package com.iteso.tarea02;

import android.content.res.Configuration;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class Activity_main extends AppCompatActivity {

    ImageButton like;
    RadioGroup colors;
    Button save;
    Button sm;
    private static final String KEY_STATE_BUTTON = "state_button";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        like = findViewById(R.id.like_button);
        colors = findViewById(R.id.radio_group);
        save = findViewById(R.id.button_save);
        sm = findViewById(R.id.radio_button_m);

        if(savedInstanceState != null){
            CharSequence textSaved = savedInstanceState.getCharSequence(KEY_STATE_BUTTON);
            save.setText(textSaved);
        }

        like.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast plusone = Toast.makeText(Activity_main.this, "+1 to Vintage Bicycle",
                        Toast.LENGTH_SHORT);
                if(getResources().getConfiguration().orientation
                        == Configuration.ORIENTATION_LANDSCAPE)
                    plusone.setGravity(Gravity.BOTTOM, 0, 0);
                plusone.show();
            }
        });

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(save.getText().toString() == getResources().getString(R.string.add_to_cart)) {
                    Snackbar.make(view, getResources().getString(R.string.added_to_cart), Snackbar.LENGTH_LONG)
                            .setAction("Undo", new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    save.setText(R.string.add_to_cart);
                                }
                            })
                            .show();

                    save.setText(R.string.added_to_cart);
                } else {
                    Snackbar.make(view, R.string.already_in_cart, Snackbar.LENGTH_LONG).show();
                }
            }
        });
    }

    @Override
    protected void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);
        outState.putCharSequence(KEY_STATE_BUTTON, save.getText());
    }
}
