package br.com.thaislisboa.popularmovies.domain.data;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import br.com.thaislisboa.popularmovies.domain.model.Movie;

public class FavoriteContentProvider extends ContentProvider {

    //public static final int FAVORITES = 100;
    //public static final int TASK_WITH_ID = 101;

    private FavoriteDbHelper mFavoriteDbHelper;

    private static final UriMatcher sUriMatcher = buildUriMatcher();

    public static UriMatcher buildUriMatcher() {
        UriMatcher uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);

        uriMatcher.addURI(FavoriteContract.AUTHORITY, FavoriteContract.PATH_FAVORITE, FAVORITES);
        uriMatcher.addURI(FavoriteContract.AUTHORITY, FavoriteContract.PATH_FAVORITE + "/#", TASK_WITH_ID);

        return uriMatcher;

    }


    @Override
    public boolean onCreate() {
        return false;
    }

    @Nullable
        // Implement query to handle requests for data by URI
        @Override
        public Cursor query(@NonNull Uri uri, String[] projection, String selection,
                String[] selectionArgs, String sortOrder) {

            // COMPLETED (1) Get access to underlying database (read-only for query)
            final SQLiteDatabase db = mFavoriteDbHelper.getReadableDatabase();

            // COMPLETED (2) Write URI match code and set a variable to return a Cursor
            int match = sUriMatcher.match(uri);
            Cursor retCursor;

            // COMPLETED (3) Query for the tasks directory and write a default case
            switch (match) {
                // Query for the tasks directory
                case TASKS:
                    retCursor =  db.query(TABLE_NAME,
                            projection,
                            selection,
                            selectionArgs,
                            null,
                            null,
                            sortOrder);
                    break;
                // Default exception
                default:
                    throw new UnsupportedOperationException("Unknown uri: " + uri);
            }

            // COMPLETED (4) Set a notification URI on the Cursor and return that Cursor
            retCursor.setNotificationUri(getContext().getContentResolver(), uri);

            // Return the desired Cursor
            return retCursor;
        }


    }

    @Nullable
    @Override
    public String getType(@NonNull Uri uri) {
        return null;
    }

    @Nullable
    @Override
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues values) {

        final SQLiteDatabase db = mFavoriteDbHelper.getReadableDatabase();

        int match = sUriMatcher.match(uri);

        Uri returnUri;

        switch (match) {
            case favorite:

                long id = db.insert(Movie.TABLE_NAME, null, values);

                if (id > 0) {

                    returnUri = ContentUris.withAppendedId(FavoriteContract.FavoriteContractEntry.CONTENT_URI, id);

                } else {

                    throw new android.database.SQLException("Failed to insert row into" + uri);
                }
                break;

            default:
                throw new UnsupportedOperationException("Unknown uri: " + uri);
        }

        return returnUri;
    }

    @Override
    public int delete(@NonNull Uri uri, @Nullable String selection, @Nullable String[] selectionArgs) {
        return 0;
    }

    @Override
    public int update(@NonNull Uri uri, @Nullable ContentValues values, @Nullable String selection, @Nullable String[] selectionArgs) {
        return 0;
    }
}
