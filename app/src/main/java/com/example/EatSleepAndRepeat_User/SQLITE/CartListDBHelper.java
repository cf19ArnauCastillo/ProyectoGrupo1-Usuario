package com.example.EatSleepAndRepeat_User.SQLITE;

import static com.example.EatSleepAndRepeat_User.SQLITE.CartListContacts.ListCart.TABLE_NAME;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;


import android.database.sqlite.SQLiteOpenHelper;
import java.util.ArrayList;

public class CartListDBHelper extends SQLiteOpenHelper{
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "DBcart.db";

    private static final String SQL_CREATE_ENTRIES = "CREATE TABLE " + TABLE_NAME + "("
            + CartListContacts.ListCart.ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + CartListContacts.ListCart.COLUMN_NAME_TITLE
            + " TEXT, "+CartListContacts.ListCart.COLUMN_PRICE
            + " TEXT, "+CartListContacts.ListCart.COLUMN_QUANTITY
            + " TEXT, "+CartListContacts.ListCart.COLUMN_DESCRIPTION_TITLE+" TEXT)";


    public CartListDBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(SQL_CREATE_ENTRIES);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
    }

    public void insertContact(SQLiteDatabase db, CartList c){
        //Check the bd is open
        if (db.isOpen()){
            //Creation of the register for insert object with the content values
            ContentValues values = new ContentValues();

            //Insert the incidence getting all values
            values.put(CartListContacts.ListCart.COLUMN_NAME_TITLE, c.getNom());
            values.put(CartListContacts.ListCart.COLUMN_PRICE, c.getPrecio());
            values.put(CartListContacts.ListCart.COLUMN_QUANTITY, c.getCantidad());
            values.put(CartListContacts.ListCart.COLUMN_DESCRIPTION_TITLE, c.getDescripcion());

            db.insert(TABLE_NAME, null, values);
        }else{
            Log.i("sql","Database is closed");
        }
    }

    public void delete() {
        SQLiteDatabase db=this.getWritableDatabase();
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);
    }

    public ArrayList<CartList> getAllData(SQLiteDatabase db){

        ArrayList<CartList> array_cart = new ArrayList<>();
        String GETNAMES = "SELECT * FROM " + TABLE_NAME;

        db = getReadableDatabase();

        if(db!=null){
            Cursor cursor = db.rawQuery(GETNAMES, null);
            cursor.moveToFirst();
            while(!cursor.isAfterLast()) {

                @SuppressLint("Range")
                String nom = cursor.getString(cursor.getColumnIndex(CartListContacts.ListCart.COLUMN_NAME_TITLE));
                @SuppressLint("Range")
                String preu = cursor.getString(cursor.getColumnIndex(CartListContacts.ListCart.COLUMN_PRICE));
                @SuppressLint("Range")
                String quantitat = cursor.getString(cursor.getColumnIndex(CartListContacts.ListCart.COLUMN_QUANTITY));
                @SuppressLint("Range")
                String descripcio = cursor.getString(cursor.getColumnIndex(CartListContacts.ListCart.COLUMN_DESCRIPTION_TITLE));

                array_cart.add(new CartList(nom,preu,quantitat,descripcio));
                cursor.moveToNext();
            }
            cursor.close();
        }
        return array_cart;
    }
}
