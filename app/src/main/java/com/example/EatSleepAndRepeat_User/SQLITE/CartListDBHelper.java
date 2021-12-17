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
            + CartListContacts.ListCart.COLUMN_NAME + " TEXT, "
            + CartListContacts.ListCart.COLUMN_PRICE + " TEXT, "
            + CartListContacts.ListCart.COLUMN_QUANTITY + " TEXT, "
            + CartListContacts.ListCart.COLUMN_IMAGE + " INTEGER, "
            + CartListContacts.ListCart.COLUMN_DESCRIPTION+" TEXT)";


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
            values.put(CartListContacts.ListCart.COLUMN_NAME, c.getName());
            values.put(CartListContacts.ListCart.COLUMN_PRICE, c.getPrice());
            values.put(CartListContacts.ListCart.COLUMN_QUANTITY, c.getQuantity());
            values.put(CartListContacts.ListCart.COLUMN_DESCRIPTION, c.getDescription());
            values.put(CartListContacts.ListCart.COLUMN_IMAGE, c.getImage());

            db.insert(TABLE_NAME, null, values);
        }else{
            Log.i("sql","Database is closed");
        }
    }

    // Delete the order
    public void deleteOrder(SQLiteDatabase dblite) {
        dblite.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
    }

    public ArrayList<CartList> getAllData(SQLiteDatabase db){
        ArrayList<CartList> array_cart = new ArrayList<>();
        Cursor cursor = db.query(TABLE_NAME, new String[]{"name", "description", "quantity", "price","image","id"},null, null, null, null, null);
        CartList c;
        while (cursor.moveToNext()) {
            c = new CartList(cursor.getString(0), cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4), cursor.getInt(5));
            array_cart.add(c);
        }
        cursor.close();
        return array_cart;
    }
    // Deletes a item of database by id
    public void deleteItem(SQLiteDatabase db, int id){

        if (db.isOpen()){
            String ID = String.valueOf(id);
            db.execSQL("DELETE FROM " + TABLE_NAME + " WHERE ID = " + ID);
        } else {
            Log.i("sql","Database is closed");
        }
    }
}
