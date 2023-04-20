package com.example.baitapkiemtrathu2.db;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.baitapkiemtrathu2.model.Model;

import java.util.ArrayList;
import java.util.List;

public class Database extends SQLiteOpenHelper {
    private final static String name = "model2";
    private final static int version = 1;

    public Database(@Nullable Context context) {
        super(context, name, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sql = "create table model2 (" +
                " id integer primary key autoincrement, " +
                " name text, content text, " +
                " description text, spn1 text, " +
                " spn2 text, date text, " +
                " isOK integer)";
        sqLiteDatabase.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public boolean save(Model c) {
        if (c.getId() == null) {
            String sql = "insert into model2 (name,content, description, spn1, spn2, date, isOK ) values(?,?,?,?,?,?,?) ";
            String[] args = new String[]{
                    c.getName(),
                    c.getContent(),
                    c.getDescription(),
                    c.getSpn1(),
                    c.getSpn2(),
                    c.getDate() + "",
                    c.getIsOK() + ""
            };
            SQLiteDatabase st = getWritableDatabase();
            st.execSQL(sql, args);
            return true;
        }
        String sql1 = "select * from model2 where id = ?";
        SQLiteDatabase st1 = getReadableDatabase();
        Cursor rs = st1.rawQuery(sql1, new String[]{c.getId() + ""});
        if ((rs != null) && (rs.moveToNext())) {
            String sql = "update model2 set " +
                    "name = ? ," +
                    "content = ?," +
                    "description = ?," +
                    "spn1 = ?," +
                    "spn2 = ?," +
                    "date = ?," +
                    "isOk = ? " +
                    " where id = ? ";
            String[] args = new String[]{
                    c.getName(),
                    c.getContent(),
                    c.getDescription(),
                    c.getSpn1(),
                    c.getSpn2(),
                    c.getDate() + "",
                    c.getIsOK() + "",
                    c.getId() + ""};
            SQLiteDatabase st = getWritableDatabase();
            st.execSQL(sql, args);
            return true;
        }
        return false;
    }

    public void delete(Integer id){
        String sql = "delete from model2 where id = ?";
        SQLiteDatabase st = getWritableDatabase();
        st.execSQL(sql, new String[]{id+""});
    }

    public List<Model> search(String keyword) {
        String sql = "select m.id," +
                "m.name," +
                "m.content, " +
                "m.description, " +
                "m.spn1, " +
                "m.spn2, " +
                "m.date, " +
                "m.isOK  " +
                "from model2 m " +
                "where (1 = 1)";
        List<Model> list = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        if (keyword != null){
            sql += " and name like '%"+ keyword + "%' ";
        }
        if (1 == 1){
            sql += " order by id desc";
        }

        Cursor rs = db.rawQuery(sql, null);

        while ((rs != null) && (rs.moveToNext())) {
            int i = 0;
            Model model = new Model();
            model.setId(rs.getInt(i++));
            model.setName(rs.getString(i++));
            model.setContent(rs.getString(i++));
            model.setDescription(rs.getString(i++));
            model.setSpn1(rs.getString(i++));
            model.setSpn2(rs.getString(i++));
            model.setDate(rs.getString(i++));
            model.setIsOK(rs.getInt(i++));
            list.add(model);
        }
        return list;
    }

    public Model findOne(Integer id) {
        String sql = "select m.id," +
                "m.name," +
                "m.content, " +
                "m.description, " +
                "m.spn1, " +
                "m.spn2, " +
                "m.date, " +
                "m.isOK  " +
                "from model2 m " +
                "where id = ?";

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor rs = db.rawQuery(sql, new String[]{id + ""});

        while ((rs != null) && (rs.moveToNext())) {
            int i = 0;
            Model model = new Model();
            model.setId(rs.getInt(i++));
            model.setName(rs.getString(i++));
            model.setContent(rs.getString(i++));
            model.setDescription(rs.getString(i++));
            model.setSpn1(rs.getString(i++));
            model.setSpn2(rs.getString(i++));
            model.setDate(rs.getString(i++));
            model.setIsOK(rs.getInt(i++));
            return model;
        }
        return new Model();
    }

}
