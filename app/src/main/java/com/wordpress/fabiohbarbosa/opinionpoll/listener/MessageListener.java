package com.wordpress.fabiohbarbosa.opinionpoll.listener;

import android.support.design.widget.Snackbar;
import android.view.View;
import android.view.View.OnClickListener;

public class MessageListener implements OnClickListener {

    @Override
    public void onClick(View view) {
        Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show();
    }
}
