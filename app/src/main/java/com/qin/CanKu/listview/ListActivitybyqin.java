package com.qin.CanKu.listview;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.qin.CanKu.R;
import com.qin.CanKu.bean.Woods;
import com.qin.CanKu.utils.MySqliteHelper;
import com.qin.CanKu.utils.ToastUtil;

import java.util.List;

import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;

public class ListActivitybyqin  extends AppCompatActivity {
    private ListView lv;
    private SQLiteDatabase db;
    private MySqliteHelper helper;
    private ToastUtil toastUtil;
    private List<Woods> woods;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = this;
        setContentView(R.layout.activity_list);
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        String querynumber = bundle.getString("querynumber");

        queryWoods(querynumber);



        //以下是本地的做法
/*        helper = DbManger.getIntace(this);
        db = helper.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from lading where modelnumber ==?",new String[]{querynumber});
        SimpleCursorAdapter adapter=new SimpleCursorAdapter(this,R.layout.item,cursor,
                new String[]{Constant.MODELNUMBER,Constant.NAME,Constant.NUMBER,Constant.LOCATION},
                new int[]{R.id.li_modelnumber,R.id.li_name,R.id.li_number,R.id.li_location},
                SimpleCursorAdapter.FLAG_REGISTER_CONTENT_OBSERVER);
        lv.setAdapter(adapter);*/

    }

    private void queryWoods(String querynumber) {
        BmobQuery<Woods> bmobQuery = new BmobQuery<>();
        bmobQuery.addWhereEqualTo("wood_id", querynumber);
        bmobQuery.setLimit(50);
        bmobQuery.findObjects(new FindListener<Woods>() {

            @Override public void done(List<Woods> list, BmobException e) {
                if (e != null) {
                    toastUtil.show(e.getMessage());
                    return;
                }
                if (list.size() > 0) {

                    lv = (ListView) findViewById(R.id.lv);

                    ListAdapter adapter = new ListAdapter(context,R.layout.item,list);
                    lv.setAdapter(adapter);
                }
            }
        });

    }


}
