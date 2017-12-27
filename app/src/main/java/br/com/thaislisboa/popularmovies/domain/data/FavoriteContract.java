package br.com.thaislisboa.popularmovies.domain.data;

import android.net.Uri;
import android.provider.BaseColumns;

public class FavoriteContract {

    public static final String AUTHORITY = "br.com.thaislisboa.popularmovies";

    public static final Uri BASE_CONTENT_URI = Uri.parse("content://" + AUTHORITY);

    public static final String PATH_FAVORITE= "favorite";

    public static final class FavoriteContractEntry implements BaseColumns {


        public static final String TABLE_NAME = "favorite_movie";
        public static final String COLUMN_ID_MOVIE = "id_movie";
        public static final String COLUMN_TITLE = "title";
        public static final String COLUMN_POSER = "poser";
        public static final String COLUMN_YEAR = "year";
        public static final String COLUMN_DETAILS = "details";
        public static final String COLUMN_GRADE = "grade";
        public static final String COLUMN_OVERVIEW = "overview";

    }

}
