package com.wordpress.fabiohbarbosa.agenda.activity;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.wordpress.fabiohbarbosa.agenda.R;
import com.wordpress.fabiohbarbosa.agenda.listener.MessageListener;

import java.util.ArrayList;

public class ListaAlunosActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_alunos);

        ArrayList<String> alunos = new ArrayList<>();
        alunos.add("Fabio");
        alunos.add("Bia");
        alunos.add("Pedro");
        alunos.add("Josy");
        ListView listaAlunos = (ListView) findViewById(R.id.lista_alunos);

        listaAlunos.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, alunos));

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new MessageListener());
    }

}
