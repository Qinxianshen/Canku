package com.qin.CanKu;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.qin.CanKu.enter.EnterActivity;
import com.qin.CanKu.query.QueryActivity;

import cn.bmob.v3.Bmob;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bmob.initialize(this, "9daa5b3df6f68486da0bff68461f64ac");
        setContentView(R.layout.activity_main);


        Button btn_enter = (Button) findViewById(R.id.btn_enter);
        Button btn_query = (Button) findViewById(R.id.btn_query);

        btn_query.setOnClickListener(new ButtonListener());
        btn_enter.setOnClickListener(new ButtonListener());

    }
    private class ButtonListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {

                case R.id.btn_enter:
                    Intent intent = new Intent(MainActivity.this, EnterActivity.class);
                    startActivity(intent);
                    break;
                case R.id.btn_query:
                    Intent intent1= new Intent(MainActivity.this, QueryActivity.class);
                    startActivity(intent1);
                    break;
                default:
                    break;
            }
        }
    }
}
