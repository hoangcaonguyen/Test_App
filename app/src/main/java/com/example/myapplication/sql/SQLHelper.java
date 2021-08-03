package com.example.myapplication.sql;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.myapplication.Fragment.Contact;
import com.example.myapplication.network.Respones.Acc;
import com.example.myapplication.network.Respones.Math;

import java.util.ArrayList;
import java.util.List;

import static com.example.myapplication.Cons.ANS_A;
import static com.example.myapplication.Cons.ANS_B;
import static com.example.myapplication.Cons.ANS_C;
import static com.example.myapplication.Cons.ANS_D;
import static com.example.myapplication.Cons.ID_QS;
import static com.example.myapplication.Cons.LEVEL;
import static com.example.myapplication.Cons.QUESTION;
import static com.example.myapplication.Cons.RESULT;

public class SQLHelper extends SQLiteOpenHelper {
    private static final String TAG = "SqlHelper";
    static final String DB_NAME = "QUESTION.db";
    static final String DB_TABLE_MATH = "Math";
    static final String DB_TABLE_LY = "Ly";
    static final String DB_TABLE_Hoa = "Hoa";
    static final String DB_ACC = "Acc";
    static final String DB_DE_T = "DT";
    static final String DB_DE_L = "DL";
    static final String DB_DE_H = "DH";
    static final int DB_VERSION = 1;
    SQLiteDatabase sqLiteDatabase;
    ContentValues contentValues;

    public SQLHelper(@Nullable Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createQuestion = "CREATE TABLE " + DB_TABLE_MATH + "(" +
                "ID INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT," +
                "ID_QS INTEGER," +
                "QUESTION Text," +
                "ANS_A Text," +
                "ANS_B Text," +
                "ANS_C Text," +
                "ANS_D Text," +
                "RESULT Text," +
                "LEVEL Text)";
        db.execSQL(createQuestion);
        String createLy = "CREATE TABLE " + DB_TABLE_LY + "(" +
                "ID INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT," +
                "ID_QS INTEGER," +
                "QUESTION Text," +
                "ANS_A Text," +
                "ANS_B Text," +
                "ANS_C Text," +
                "ANS_D Text," +
                "RESULT Text," +
                "LEVEL Text)";
        db.execSQL(createLy);
        String createHoa = "CREATE TABLE " + DB_TABLE_Hoa + "(" +
                "ID INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT," +
                "ID_QS INTEGER," +
                "QUESTION Text," +
                "ANS_A Text," +
                "ANS_B Text," +
                "ANS_C Text," +
                "ANS_D Text," +
                "RESULT Text," +
                "LEVEL Text)";
        db.execSQL(createHoa);

        String createAcc = "CREATE TABLE " + DB_ACC + "(" +
                "ID INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT," +
                "Name Text," +
                "Old Text," +
                "Email Text," +
                "Pass Text," +
                "Addr Text)";
        db.execSQL(createAcc);
        String createDT = "CREATE TABLE " + DB_DE_T + "(" +
                "ID INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT," +
                "Name Text," +
                "Diem Text," +
                "Id_de INTEGER)";
        db.execSQL(createDT);
        String createDL = "CREATE TABLE " + DB_DE_L + "(" +
                "ID INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT," +
                "Name Text," +
                "Diem Text," +
                "Id_de INTEGER)";
        db.execSQL(createDL);
        String createDH = "CREATE TABLE " + DB_DE_H + "(" +
                "ID INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT," +
                "Name Text," +
                "Diem Text," +
                "Id_de INTEGER)";
        db.execSQL(createDH);


    }

    public void InsertDT(Contact acc) {
        sqLiteDatabase = getWritableDatabase();
        contentValues = new ContentValues();
        contentValues.put("Name", acc.getmNumberExam());
        contentValues.put("Diem", acc.getDiem());
        contentValues.put("Id_de", acc.getIdDe());
        sqLiteDatabase.insert(DB_DE_T, null, contentValues);
    }

    public ArrayList<Contact> getDT() {
        ArrayList<Contact> list = new ArrayList<>();
        sqLiteDatabase = getReadableDatabase();
        Cursor cursor = sqLiteDatabase.query(false, DB_DE_T,
                null,
                null,
                null,
                null,
                null,
                null,
                null);
        while (cursor.moveToNext()) {
            String name = cursor.getString(cursor.getColumnIndex("Name"));
            String Diem = cursor.getString(cursor.getColumnIndex("Diem"));
            int Id_de = cursor.getInt(cursor.getColumnIndex("Id_de"));
            list.add(new Contact(name, Diem, Id_de));
        }
        return list;
    }


    public void InsertDL(Contact acc) {
        sqLiteDatabase = getWritableDatabase();
        contentValues = new ContentValues();
        contentValues.put("Name", acc.getmNumberExam());
        contentValues.put("Diem", acc.getDiem());
        contentValues.put("Id_de", acc.getIdDe());
        sqLiteDatabase.insert(DB_DE_L, null, contentValues);
    }

    public ArrayList<Contact> getDL() {
        ArrayList<Contact> list = new ArrayList<>();
        sqLiteDatabase = getReadableDatabase();
        Cursor cursor = sqLiteDatabase.query(false, DB_DE_L,
                null,
                null,
                null,
                null,
                null,
                null,
                null);
        while (cursor.moveToNext()) {
            String name = cursor.getString(cursor.getColumnIndex("Name"));
            String Diem = cursor.getString(cursor.getColumnIndex("Diem"));
            int Id_de = cursor.getInt(cursor.getColumnIndex("Id_de"));
            list.add(new Contact(name, Diem, Id_de));
        }
        return list;
    }

    public void InsertDH(Contact acc) {
        sqLiteDatabase = getWritableDatabase();
        contentValues = new ContentValues();
        contentValues.put("Name", acc.getmNumberExam());
        contentValues.put("Diem", acc.getDiem());
        contentValues.put("Id_de", acc.getIdDe());
        sqLiteDatabase.insert(DB_DE_H, null, contentValues);
    }

    public ArrayList<Contact> getDH() {
        ArrayList<Contact> list = new ArrayList<>();
        sqLiteDatabase = getReadableDatabase();
        Cursor cursor = sqLiteDatabase.query(false, DB_DE_H,
                null,
                null,
                null,
                null,
                null,
                null,
                null);
        while (cursor.moveToNext()) {
            String name = cursor.getString(cursor.getColumnIndex("Name"));
            String Diem = cursor.getString(cursor.getColumnIndex("Diem"));
            int Id_de = cursor.getInt(cursor.getColumnIndex("Id_de"));
            list.add(new Contact(name, Diem, Id_de));
        }
        return list;
    }

    public void InsertAcc(Acc acc) {
        sqLiteDatabase = getWritableDatabase();
        contentValues = new ContentValues();
        contentValues.put("Name", acc.getName());
        contentValues.put("Old", acc.getOld());
        contentValues.put("Email", acc.getEmail());
        contentValues.put("Pass", acc.getPass());
        contentValues.put("Addr", acc.getAdd());
        sqLiteDatabase.insert(DB_ACC, null, contentValues);
    }

    public List<Acc> getAcc() {
        List<Acc> list = new ArrayList<>();
        sqLiteDatabase = getReadableDatabase();
        Cursor cursor = sqLiteDatabase.query(false, DB_ACC,
                null,
                null,
                null,
                null,
                null,
                null,
                null);
        while (cursor.moveToNext()) {
            int id = cursor.getInt(cursor.getColumnIndex("ID"));
            String name = cursor.getString(cursor.getColumnIndex("Name"));
            String old = cursor.getString(cursor.getColumnIndex("Old"));
            String email = cursor.getString(cursor.getColumnIndex("Email"));
            String pass = cursor.getString(cursor.getColumnIndex("Pass"));
            String add = cursor.getString(cursor.getColumnIndex("Addr"));
            list.add(new Acc(id, name, pass, add, old, email));
        }
        return list;
    }

    public void InsertMath(Math math) {
        sqLiteDatabase = getWritableDatabase();
        contentValues = new ContentValues();
        contentValues.put(ID_QS, math.getId());
        contentValues.put(QUESTION, math.getQuestion());
        contentValues.put(ANS_A, math.getAns_a());
        contentValues.put(ANS_B, math.getAns_b());
        contentValues.put(ANS_C, math.getAsn_c());
        contentValues.put(ANS_D, math.getAns_d());
        contentValues.put(RESULT, math.getResult());
        contentValues.put(LEVEL, math.getLevel());
        sqLiteDatabase.insert(DB_TABLE_MATH, null, contentValues);
    }

    public List<Math> getAllMath() {
        List<Math> list = new ArrayList<>();
        sqLiteDatabase = getReadableDatabase();
        Cursor cursor = sqLiteDatabase.query(false, DB_TABLE_MATH,
                null,
                null,
                null,
                null,
                null,
                null,
                null);
        while (cursor.moveToNext()) {
            int id = cursor.getInt(cursor.getColumnIndex("ID"));
            int idSQ = cursor.getInt(cursor.getColumnIndex(ID_QS));
            String question = cursor.getString(cursor.getColumnIndex(QUESTION));
            String a = cursor.getString(cursor.getColumnIndex(ANS_A));
            String b = cursor.getString(cursor.getColumnIndex(ANS_B));
            String c = cursor.getString(cursor.getColumnIndex(ANS_C));
            String d = cursor.getString(cursor.getColumnIndex(ANS_D));
            String result = cursor.getString(cursor.getColumnIndex(RESULT));
            String level = cursor.getString(cursor.getColumnIndex(LEVEL));
            list.add(new Math(id, idSQ, question, a, b, c, d, result, level, null));
        }
        return list;
    }

    public void DeleteAllMath() {
        sqLiteDatabase = getWritableDatabase();
        sqLiteDatabase.execSQL("delete from " + DB_TABLE_MATH);
    }

    public void InsertLy(Math math) {
        sqLiteDatabase = getWritableDatabase();
        contentValues = new ContentValues();
        contentValues.put(ID_QS, math.getId());
        contentValues.put(QUESTION, math.getQuestion());
        contentValues.put(ANS_A, math.getAns_a());
        contentValues.put(ANS_B, math.getAns_b());
        contentValues.put(ANS_C, math.getAsn_c());
        contentValues.put(ANS_D, math.getAsn_c());
        contentValues.put(RESULT, math.getResult());
        contentValues.put(LEVEL, math.getLevel());
        sqLiteDatabase.insert(DB_TABLE_LY, null, contentValues);
    }

    public List<Math> getAllLy() {
        List<Math> list = new ArrayList<>();
        sqLiteDatabase = getReadableDatabase();
        Cursor cursor = sqLiteDatabase.query(false, DB_TABLE_LY,
                null,
                null,
                null,
                null,
                null,
                null,
                null);
        while (cursor.moveToNext()) {
            int id = cursor.getInt(cursor.getColumnIndex("ID"));
            int idSQ = cursor.getInt(cursor.getColumnIndex(ID_QS));
            String question = cursor.getString(cursor.getColumnIndex(QUESTION));
            String a = cursor.getString(cursor.getColumnIndex(ANS_A));
            String b = cursor.getString(cursor.getColumnIndex(ANS_B));
            String c = cursor.getString(cursor.getColumnIndex(ANS_C));
            String d = cursor.getString(cursor.getColumnIndex(ANS_D));
            String result = cursor.getString(cursor.getColumnIndex(RESULT));
            String level = cursor.getString(cursor.getColumnIndex(LEVEL));
            list.add(new Math(id, idSQ, question, a, b, c, d, result, level, null));
        }
        return list;
    }

    public void DeleteAllLy() {
        sqLiteDatabase = getWritableDatabase();
        sqLiteDatabase.execSQL("delete from " + DB_TABLE_LY);
    }

    public void InsertHoa(Math math) {
        sqLiteDatabase = getWritableDatabase();
        contentValues = new ContentValues();
        contentValues.put(ID_QS, math.getId());
        contentValues.put(QUESTION, math.getQuestion());
        contentValues.put(ANS_A, math.getAns_a());
        contentValues.put(ANS_B, math.getAns_b());
        contentValues.put(ANS_C, math.getAsn_c());
        contentValues.put(ANS_D, math.getAsn_c());
        contentValues.put(RESULT, math.getResult());
        contentValues.put(LEVEL, math.getLevel());
        sqLiteDatabase.insert(DB_TABLE_Hoa, null, contentValues);
    }

    public List<Math> getAllHoa() {
        List<Math> list = new ArrayList<>();
        sqLiteDatabase = getReadableDatabase();
        Cursor cursor = sqLiteDatabase.query(false, DB_TABLE_Hoa,
                null,
                null,
                null,
                null,
                null,
                null,
                null);
        while (cursor.moveToNext()) {
            int id = cursor.getInt(cursor.getColumnIndex("ID"));
            int idSQ = cursor.getInt(cursor.getColumnIndex(ID_QS));
            String question = cursor.getString(cursor.getColumnIndex(QUESTION));
            String a = cursor.getString(cursor.getColumnIndex(ANS_A));
            String b = cursor.getString(cursor.getColumnIndex(ANS_B));
            String c = cursor.getString(cursor.getColumnIndex(ANS_C));
            String d = cursor.getString(cursor.getColumnIndex(ANS_D));
            String result = cursor.getString(cursor.getColumnIndex(RESULT));
            String level = cursor.getString(cursor.getColumnIndex(LEVEL));
            list.add(new Math(id, idSQ, question, a, b, c, d, result, level, null));
        }
        return list;
    }

    public void DeleteAllHoa() {
        sqLiteDatabase = getWritableDatabase();
        sqLiteDatabase.execSQL("delete from " + DB_TABLE_Hoa);
    }

    public void upDatePass(String sdt, String pass) {
        sqLiteDatabase = getWritableDatabase();
        contentValues = new ContentValues();
        contentValues.put("Pass", pass);
        sqLiteDatabase.update(DB_ACC, contentValues, "Email" + " = ?", new String[]{sdt});
        sqLiteDatabase.close();
    }

    public void updateDiem(String db, int Id_de, String Diem) {
        sqLiteDatabase = getWritableDatabase();
        contentValues = new ContentValues();
        contentValues.put("Diem", Diem);
        sqLiteDatabase.update(db, contentValues, "Id_de" + " = ?",
                new String[]{String.valueOf(Id_de)});
    }

    public void DeleteAll(String db) {
        sqLiteDatabase = getWritableDatabase();
        sqLiteDatabase.execSQL("delete from " + db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (oldVersion != newVersion) {
            db.execSQL("DROP TABLE IF EXISTS " + DB_NAME);
            onCreate(db);
        }
    }
}
