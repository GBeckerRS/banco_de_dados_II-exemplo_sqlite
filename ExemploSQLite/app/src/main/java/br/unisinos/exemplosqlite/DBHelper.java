package br.unisinos.exemplosqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Cassio on 19/11/2016.
 */
public class DBHelper extends SQLiteOpenHelper {

    private static String BD_Nome = "exemplo_SQLite";
    private static int BD_Versao = 1;

    private static String TABELA_Personagem =
            "CREATE TABLE  Personagem(" +
                "Id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "Nome VARCHAR(100)" +
            ");";

    public DBHelper(Context contexto) {
        super(contexto, BD_Nome, null, BD_Versao);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABELA_Personagem);

        String[] nomes = {"Mario", "Pac-man", "Crash Bandicoot", "Solid Snake", "Donkey Kong", "Nathan Drake", "Joel", "Ellie", "Capitão John Price"};
        for (String nome: nomes) {
            String sqlPopulacao = "INSERT INTO Personagem (Nome) VALUES ('" + nome + "')";
            db.execSQL(sqlPopulacao);
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
