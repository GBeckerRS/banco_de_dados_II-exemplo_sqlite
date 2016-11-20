package br.unisinos.exemplosqlite;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class NovoPersonagemActivity extends AppCompatActivity {

    private EditText nomeEt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_novo_personagem);

        nomeEt = (EditText) findViewById(R.id.nome);
    }

    public void salvarPersonagem(View view){
        String nome = nomeEt.getText().toString();
        Personagem personagem = new Personagem(nome);

        PersonagemRepositorio personagemRepositorio = new PersonagemRepositorio(this);
        personagemRepositorio.inserir(personagem);

        Toast.makeText(this, "Personagem inserido com sucesso!", Toast.LENGTH_SHORT).show();
    }
}
