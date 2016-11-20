package br.unisinos.exemplosqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Cassio on 19/11/2016.
 */
public class PersonagemRepositorio {
    private static String TABELA_PERSONAGEM = "Personagem";
    private DBHelper dbHelper;



    public PersonagemRepositorio(Context contexto) {
        dbHelper = new DBHelper(contexto);
    }

    public void inserir(Personagem personagem) {
        SQLiteDatabase database = dbHelper.getWritableDatabase();

        /*String sql = "INSERT INTO "+TABELA_PERSONAGEM+" (Nome) " +
                            "VALUES ('" + personagem.getNome() + "')";
        database.execSQL(sql);*/

        ContentValues values = new ContentValues();
        values.put("nome", personagem.getNome());
        database.insert(TABELA_PERSONAGEM, null, values);
    }

    public void atualizar(Personagem personagem){
        SQLiteDatabase database = dbHelper.getWritableDatabase();

        /*String sql = "UPDATE Personagem " +
                     "SET Nome = '" + personagem.getNome() + "' " +
                     "WHERE Id = +" + personagem.getId();
        database.execSQL(sql);*/

        ContentValues values = new ContentValues();
        database.update(TABELA_PERSONAGEM, values,"id = ?", new String[]{"" + personagem.getId() });
    }

    public void remover(Personagem personagem) {
        SQLiteDatabase database = dbHelper.getWritableDatabase();

        /*String sql = "DELETE Personagem " +
                       "WHERE Id = +" + personagem.getId();
        database.execSQL(sql);*/

        database.delete(TABELA_PERSONAGEM, "id = " + personagem.getId(), null);
    }

    public List<Personagem> listar(){
        SQLiteDatabase database = dbHelper.getReadableDatabase();

        String sql = "SELECT Id, Nome FROM Personagem";
        Cursor cursor = database.rawQuery(sql, null);

        List<Personagem> personagens = new ArrayList<>();
        if (cursor.getCount() > 0){
            cursor.moveToFirst();
            personagens = new ArrayList();

            do{
                Personagem personagem = new Personagem(cursor.getInt(0), cursor.getString(1));
                personagens.add(personagem);
            }while(cursor.moveToNext());

        }

        return personagens;

        /*List<Personagem> personagens = new ArrayList<>();
        String[] colunas = {"Id", "Nome"};
        // database.query(nome_tabela, colunas, where, array argumentos(substitui interrogações do where), groupBy, having, orderBy)
        Cursor cursor = database.query(TABELA_PERSONAGEM, colunas, null, null, null, null, "Nome ASC");

        if (cursor.getCount() > 0) {
            cursor.moveToFirst();

            do{
                Personagem personagem = new Personagem(cursor.getInt(0), cursor.getString(1));
                personagens.add(personagem);

            }while(cursor.moveToNext());
        }
        return personagens;*/
    }
}
