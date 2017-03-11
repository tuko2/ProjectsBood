package com.example.android.projectsbood.Data;

import android.provider.BaseColumns;

/**
 * Creates a handling for working with DB.
 */

public final class ProjectContract {

    public  ProjectContract() {}

    //Constants for SQL Queries
    public  static abstract class ProjectEntry implements BaseColumns {
        public final static String _ID = BaseColumns._ID;
        public  static final String TABLE_NAME = "Project";
        public  static final String NAME = "Name";
        public  static final String TIME_READY = "TimeReady";
        public  static final String GEO = "Geo";
        public  static final String _ID_BOODCOMPANY = "_ID_BoodCompany";
        public  static final String _ID_DISTRICT = "_ID_District";
    }


}
