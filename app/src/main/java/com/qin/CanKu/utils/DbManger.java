package com.qin.CanKu.utils;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class DbManger {
    private static MySqliteHelper helper;
    public static MySqliteHelper getIntace(Context context){
        if(helper==null){
            helper=new MySqliteHelper(context);
        }
        return helper;
    }
    public static void execSQL(SQLiteDatabase db, String sql){
        if(db!=null){
            if(sql!=null&&"".equals(sql)) {
                db.execSQL(sql);
            }
        }
    }
}
