package com.qin.CanKu.listview;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import com.qin.CanKu.R;
import com.qin.CanKu.utils.Constant;
import com.qin.CanKu.utils.DbManger;
import com.qin.CanKu.utils.MySqliteHelper;

public class ListActivitybyqin  extends AppCompatActivity {
    private ListView lv;
    private SQLiteDatabase db;
    private MySqliteHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        String querynumber = bundle.getString("querynumber");
        lv = (ListView) findViewById(R.id.lv);
        helper = DbManger.getIntace(this);
        db = helper.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from lading where modelnumber ==?",new String[]{querynumber});
        SimpleCursorAdapter adapter=new SimpleCursorAdapter(this,R.layout.item,cursor,
                new String[]{Constant.MODELNUMBER,Constant.NAME,Constant.NUMBER,Constant.LOCATION},
                new int[]{R.id.li_modelnumber,R.id.li_name,R.id.li_number,R.id.li_location},
                SimpleCursorAdapter.FLAG_REGISTER_CONTENT_OBSERVER);
        lv.setAdapter(adapter);
    }
}
