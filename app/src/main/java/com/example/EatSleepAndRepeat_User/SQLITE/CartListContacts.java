package com.example.EatSleepAndRepeat_User.SQLITE;

import android.provider.BaseColumns;

public class CartListContacts {
    private CartListContacts(){}
    public static class ListCart implements BaseColumns {
        public static final String TABLE_NAME ="DBcart";
        public static final String ID = "id";

        public static final String COLUMN_NAME_TITLE = "name";
        public static final String COLUMN_DESCRIPTION_TITLE = "description";
        public static final String COLUMN_PRICE = "price";
        public static final String COLUMN_QUANTITY = "quantity";

    }
}