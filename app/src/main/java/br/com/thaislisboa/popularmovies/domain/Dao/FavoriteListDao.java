package br.com.thaislisboa.popularmovies.domain.Dao;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import java.util.ArrayList;

import br.com.thaislisboa.popularmovies.domain.data.FavoriteContract;
import br.com.thaislisboa.popularmovies.domain.model.Movie;


public class FavoriteListDao extends Dao {


    public FavoriteListDao(Context context) {
        super(context);
    }

    public void InsertFavorite(Movie movie) {

        abrirBanco();
        //
        ContentValues cv = new ContentValues();
        cv.put(FavoriteContract.FavoriteContractEntry.COLUMN_ID_MOVIE, movie.getId());
        cv.put(FavoriteContract.FavoriteContractEntry.COLUMN_TITLE, movie.getTitle());
        cv.put(FavoriteContract.FavoriteContractEntry.COLUMN_POSER, movie.getPoster());
        cv.put(FavoriteContract.FavoriteContractEntry.COLUMN_YEAR, movie.getYear());
        cv.put(FavoriteContract.FavoriteContractEntry.COLUMN_GRADE, movie.getGrade());
        cv.put(FavoriteContract.FavoriteContractEntry.COLUMN_OVERVIEW, movie.getOverview());
        // cv.put(VersaoServidor.ID, versaoServidor.getId());
        //
        db.insert(FavoriteContract.FavoriteContractEntry.TABLE_NAME, null, cv);
        //
        fecharBanco();

    }

    public ArrayList<Movie> favoriteList() {
        ArrayList<Movie> d = new ArrayList<Movie>();
        //
        abrirBanco();
        //
        Cursor cursor = null;
        //
        try {
            StringBuilder sb = new StringBuilder();
            sb.append(" select * from " + FavoriteContract.FavoriteContractEntry.TABLE_NAME);

            cursor = db.rawQuery(sb.toString().toLowerCase(), null);
            int i = 0;
            while (cursor.moveToNext()) {
                Movie movie = new Movie();
                        /*cursor.getString(cursor.getColumnIndex(FavoriteContract.FavoriteContractEntry.COLUMN_ID_MOVIE)),
                cursor.getString(cursor.getColumnIndex(FavoriteContract.FavoriteContractEntry.COLUMN_TITLE)),
                cursor.getString(cursor.getColumnIndex(FavoriteContract.FavoriteContractEntry.COLUMN_POSER)),
                cursor.getString(cursor.getColumnIndex(FavoriteContract.FavoriteContractEntry.COLUMN_YEAR)),
                cursor.getString(cursor.getColumnIndex(FavoriteContract.FavoriteContractEntry.COLUMN_GRADE)),
                cursor.getString(cursor.getColumnIndex(FavoriteContract.FavoriteContractEntry.COLUMN_OVERVIEW)));*/

                i++;

                d.add(movie);

            }

        } catch (Exception e) {
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
        //
        fecharBanco();
        //
        return d;
    }

    public void apagarFavoritos() {
        abrirBanco();
        //

        String where = " 1= 1";
        // String[] argumentos = {chave};
        //
        db.delete(FavoriteContract.FavoriteContractEntry.TABLE_NAME, where, null);
        fecharBanco();

    }

}


//insert, update, delete