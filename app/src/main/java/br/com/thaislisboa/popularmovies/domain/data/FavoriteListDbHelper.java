package br.com.thaislisboa.popularmovies.domain.data;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class FavoriteListDbHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "movies.db";
    private static final int DATABASE_VERSION = 1;

    public FavoriteListDbHelper(Context context){
    super(context,DATABASE_NAME,null,DATABASE_VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {


        final String SQL_CREATE_WAITLIST_TABLE = "CREATE TABLE " + FavoriteContract.FavoriteContractEntry.TABLE_NAME + " (" +
                FavoriteContract.FavoriteContractEntry._ID + " INTEGER PRIMARY KEY," +
                FavoriteContract.FavoriteContractEntry.COLUMN_ID_MOVIE + " INTEGER NOT NULL," +
                FavoriteContract.FavoriteContractEntry.COLUMN_TITLE + " TEXT NOT NULL, " +
                FavoriteContract.FavoriteContractEntry.COLUMN_POSER + " STRING NOT NULL, " +
                FavoriteContract.FavoriteContractEntry.COLUMN_YEAR + " INTEGER NOT NULL, " +
                FavoriteContract.FavoriteContractEntry.COLUMN_GRADE + " STRING , " +
                FavoriteContract.FavoriteContractEntry.COLUMN_OVERVIEW + " STRING " +
                "); ";

        db.execSQL(SQL_CREATE_WAITLIST_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
       // For now simply drop the table and create a new one. This means if you change the
        // DATABASE_VERSION the table will be dropped.
        // In a production app, this method might be modified to ALTER the table
        // instead of dropping it, so that existing data is not deleted.
        // COMPLETED (9) Inside, execute a drop table query, and then call onCreate to re-create it
        db.execSQL("DROP TABLE IF EXISTS " + FavoriteContract.FavoriteContractEntry.TABLE_NAME);
        onCreate(db);

    }
}

