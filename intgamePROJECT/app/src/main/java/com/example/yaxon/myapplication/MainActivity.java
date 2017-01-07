package com.example.yaxon.myapplication;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;



public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    DBHelper bdHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        final Button bGame = (Button) findViewById(R.id.bGame);
        bGame.setOnClickListener(this);
        final Button bAdmin = (Button) findViewById(R.id.bAdmin);
        bAdmin.setOnClickListener(this);

        bdHelper = new DBHelper(this);
    }
    @Override
    public void onClick (View view) {

                switch (view.getId()) {
                    case R.id.bGame:
                        Intent intent1 = new Intent(MainActivity.this, GameActivity.class);
                    MainActivity.this.startActivity(intent1);
                        break;
                    default:
                        break;
                }
                switch (view.getId()){
                    case R.id.bAdmin:
                        Intent intent = new Intent(MainActivity.this, AdminActivity.class);
                        MainActivity.this.startActivity(intent);
                        break;
                    default:
                        break;
                }
        }

    }

