package com.example.yaxon.myapplication;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AdminActivity extends AppCompatActivity implements View.OnClickListener {
    //final String LOG_TAG = "myLogs";

    EditText etquestion;
    Button bQuestion,bClear,bRead;
    DBHelper dbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);
        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);
        etquestion = (EditText) findViewById(R.id.question);
        bRead = (Button) findViewById(R.id.btnRead);
        bRead.setOnClickListener(this);

        bQuestion = (Button) findViewById(R.id.btnQuestion);
        bQuestion.setOnClickListener(this);

        bClear = (Button) findViewById(R.id.btnClear);
        bClear.setOnClickListener(this);
        dbHelper = new DBHelper(this);


    }

    @Override
    public void onClick(View view) {
        String question = etquestion.getText().toString() ;

        SQLiteDatabase database = dbHelper.getWritableDatabase();

        ContentValues contentValues = new ContentValues();

            switch (view.getId()){
                case R.id.btnQuestion:
                    contentValues.put(DBHelper.KEY_QCOLUMN , question);

                    database.insert(DBHelper.TABLE_TQESTIONS,null,contentValues);
                        break;
                case R.id.btnRead:
                    Cursor cursor = database.query(DBHelper.TABLE_TQESTIONS,null,null,null,null,null,null);

                    if (cursor.moveToFirst()){
                        int IndexId = cursor.getColumnIndex(DBHelper.KEY_ID);
                        int QuestionsTableIndex = cursor.getColumnIndex(DBHelper.KEY_QCOLUMN );
                        //int AnswerIndex = cursor.getColumnIndex(DBHelper.KEY_ANSWER);
                        do{
                            Log.d("mLog", "ID = " + cursor.getInt(IndexId) +"question =" + cursor.getString(QuestionsTableIndex));
                            // +    ",answer ="+ cursor.getString(AnswerIndex )
                        }while (cursor.moveToFirst());
                    }else
                        Log.d("mLog","0 rows");
                    cursor.close();
                    break;
                case R.id.btnClear:
                    database.delete(DBHelper.TABLE_TQESTIONS,null,null);
                    break;
            }

        dbHelper.close();
    }

}
