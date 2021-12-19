package com.example.EatSleepAndRepeat_User.SQLITE;

import android.provider.BaseColumns;

public class CartListContacts {
    private CartListContacts(){}
    public static class ListCart implements BaseColumns {
        public static final String TABLE_NAME ="DBcart";
        public static final String ID = "id";
        public static final String COLUMN_NAME = "name";
        public static final String COLUMN_DESCRIPTION = "description";
        public static final String COLUMN_PRICE = "price";
        public static final String COLUMN_QUANTITY = "quantity";
        public static final String COLUMN_IMAGE = "image";
        public static final String COLUMN_IDFIREBASE = "idfirebase";
        public static final String COLUM_CATEGORY = "category";

    }
}