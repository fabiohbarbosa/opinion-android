package com.wordpress.fabiohbarbosa.opinionpoll.opinion.activity;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Toast;

import com.wordpress.fabiohbarbosa.opinionpoll.R;
import com.wordpress.fabiohbarbosa.opinionpoll.listener.MessageListener;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class OpinionActivity extends AppCompatActivity {
    @BindView(R.id.content_opinion_rating)
    RatingBar ratioRating;

    @BindView(R.id.opinion_name)
    EditText name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opinion);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ButterKnife.bind(this);

        name.setHint(bindHintOpinionQuestion());

        // TODO remover
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new MessageListener());
    }

    private String bindHintOpinionQuestion() {
        List<String> opinions = Arrays.asList(getResources().getStringArray(R.array.opinions));
        Random randomGenerator = new Random();
        int index = randomGenerator.nextInt(opinions.size());
        return "Ex: "+opinions.get(index);
    }

    @OnClick(R.id.opinion_radio_option)
    public void radioOption() {
        ratioRating.setVisibility(View.GONE);
    }

    @OnClick(R.id.opinion_radio_rating)
    public void ratingOption() {
        ratioRating.setVisibility(View.VISIBLE);
    }

    @OnClick(R.id.form_btn_salvar)
    public void save() {
        Toast.makeText(this, "Botão clicado", Toast.LENGTH_SHORT).show();
    }

}
