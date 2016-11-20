package br.unisinos.exemplosqlite;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class ListagemPersonagensActivity extends AppCompatActivity {

    private PersonagemRepositorio personagemRepositorio = new PersonagemRepositorio(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listagem_personagens);

        List<Personagem> personagens = personagemRepositorio.listar();
        List<String> personagensString = this.converteEmListaString(personagens);

        ArrayAdapter<String> adapter;
        ListView listView = (ListView) findViewById(R.id.listViewPersonagens);


        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, personagensString);
        listView.setAdapter(adapter);
    }

    public void novoPersonagem(View view) {
        Button button = (Button) view;

        Intent intent = new Intent(this, NovoPersonagemActivity.class);

        startActivity(intent);
    }

    public void listarPersonagem(View view) {
        Button button = (Button) view;

        List<Personagem> personagens = personagemRepositorio.listar();
        List<String> personagensString = this.converteEmListaString(personagens);

        ArrayAdapter<String> adapter;
        ListView listView = (ListView) findViewById(R.id.listViewPersonagens);


        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, personagensString);
        listView.setAdapter(adapter);

    }

    private List<String> converteEmListaString(List<Personagem> personagens) {
        List<String> personagensString = new ArrayList<>();

        for (Personagem personagem : personagens) {
            personagensString.add(personagem.getId() + " - " + personagem.getNome());
        }

        return personagensString;
    }
}
