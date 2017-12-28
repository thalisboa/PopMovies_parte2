package br.com.thaislisboa.popularmovies.domain.Dao;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;



import br.com.thaislisboa.popularmovies.domain.data.FavoriteListDbHelper;

public class Dao {

    private Context context;
    protected SQLiteDatabase db;

    public Dao(Context context) {

        this.context = context;
    }

    //
    public void abrirBanco() {
        FavoriteListDbHelper baseHelper = new FavoriteListDbHelper( context);

        this.db = baseHelper.getWritableDatabase();

    }

    // Ensinei ele a fechar o banco de dados
    public void fecharBanco() {
        if (db != null) {
            db.close();
        }
    }
}
