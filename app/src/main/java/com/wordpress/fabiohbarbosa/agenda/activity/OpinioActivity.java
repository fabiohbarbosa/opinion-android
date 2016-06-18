package com.wordpress.fabiohbarbosa.agenda.activity;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;
import android.widget.Toast;

import com.wordpress.fabiohbarbosa.agenda.R;
import com.wordpress.fabiohbarbosa.agenda.listener.MessageListener;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class OpinioActivity extends AppCompatActivity {
    @BindView(R.id.form_name)
    public TextView name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.opinion);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ButterKnife.bind(this);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new MessageListener());
    }

    @OnClick(R.id.form_btn_salvar)
    protected void save() {
        Toast.makeText(this, "Botão clicado", Toast.LENGTH_SHORT).show();
        System.out.println("################33"+ name.getText());
    }

}
