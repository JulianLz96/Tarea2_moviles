package com.iteso.tarea02;

import android.content.res.Configuration;
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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        like = findViewById(R.id.like_button);
        colors = findViewById(R.id.radio_group);

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
    }
}
