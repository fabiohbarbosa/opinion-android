package com.wordpress.fabiohbarbosa.opinionpoll.opinion.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.wordpress.fabiohbarbosa.opinionpoll.R;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class OpinionActivity extends AppCompatActivity {
    private final static String CONTENT_OPINION_YES_OR_NO = "content_opinion_yesorno";
    private final static String CONTENT_OPINION_OPTION = "content_opinion_option";
    private final static String CONTENT_OPINION_RATING = "content_opinion_rating";

    @BindView(R.id.opinion_name)
    EditText name;

    @BindView(R.id.content_opinion_yesorno)
    TextView radioYesOrNo;

    @BindView(R.id.content_opinion_option)
    TextView radioOption;

    @BindView(R.id.content_opinion_rating)
    RatingBar radioRating;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opinion);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ButterKnife.bind(this);

        setNameHint();
    }

    private void setNameHint() {
        List<String> opinions = Arrays.asList(getResources().getStringArray(R.array.opinions));
        Random randomGenerator = new Random();
        int index = randomGenerator.nextInt(opinions.size());
        name.setHint("Ex: " + opinions.get(index));
    }

    @OnClick(R.id.opinion_radio_yesorno)
    public void radioYesOrNo() {
        radioYesOrNo.setVisibility(View.VISIBLE);
        radioOption.setVisibility(View.GONE);
        radioRating.setVisibility(View.GONE);
    }


    @OnClick(R.id.opinion_radio_option)
    public void radioOption() {
        radioYesOrNo.setVisibility(View.GONE);
        radioOption.setVisibility(View.VISIBLE);
        radioRating.setVisibility(View.GONE);
    }

    @OnClick(R.id.opinion_radio_rating)
    public void radioRating() {
        radioYesOrNo.setVisibility(View.GONE);
        radioOption.setVisibility(View.GONE);
        radioRating.setVisibility(View.VISIBLE);
    }

    @OnClick(R.id.form_btn_salvar)
    public void save() {
        Toast.makeText(this, "Botão clicado "+radioRating.getRating(), Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onSaveInstanceState (Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(CONTENT_OPINION_YES_OR_NO, radioYesOrNo.getVisibility());
        outState.putInt(CONTENT_OPINION_OPTION, radioOption.getVisibility());
        outState.putInt(CONTENT_OPINION_RATING, radioRating.getVisibility());
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        setVisibility(savedInstanceState, radioYesOrNo, CONTENT_OPINION_YES_OR_NO);
        setVisibility(savedInstanceState, radioOption, CONTENT_OPINION_OPTION);
        setVisibility(savedInstanceState, radioRating, CONTENT_OPINION_RATING);
    }

    private void setVisibility(Bundle savedInstanceState, View view, String viewId) {
        int optionVisibility = savedInstanceState.getInt(viewId, view.getVisibility());
        if (optionVisibility == View.VISIBLE) {
            view.setVisibility(View.VISIBLE);
        }
    }
}