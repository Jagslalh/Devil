package com.example.jagjitsingh.devil;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;




public class Data extends SQLiteOpenHelper {

    private final Context mycon;

    public Data(Context context)
    {
        super(context,"ab", null, 1);

        this.mycon=context;
    }
    @Override
    public void onCreate(SQLiteDatabase db)  {
     String sql="Create table log(email varChar , passwword varChar)";
        db.execSQL(sql);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
     db.execSQL("DROP TABLE  log IF EXISTS");
        onCreate(db);
    }

    public boolean insert(String id, String name) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues c = new ContentValues();
        c.put("id", id);
        c.put("name", name);
        long b = db.insert("one", null, c);
        if (b == -1) {
            return false;
        } else {
            return true;
        }

    }
    public Cursor get(String id,String name) {
        SQLiteDatabase db = getWritableDatabase();
        Cursor d = db.rawQuery("Select * from one where id="+id+ " and name="+name, null);
        return d;
    }



 }

