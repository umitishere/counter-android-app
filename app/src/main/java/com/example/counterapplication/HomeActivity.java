package com.example.counterapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.security.Key;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener {

    TextView counterView;
    Integer counter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        counterView = (TextView) findViewById(R.id.counterView);

        Button plusButton = findViewById(R.id.plusButton);
        Button minusButton = findViewById(R.id.minusButton);
        Button settingsButton = findViewById(R.id.settingsButton);

        plusButton.setOnClickListener(this);
        minusButton.setOnClickListener(this);
        settingsButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.plusButton:
                counter++;
                counterView.setText(counter.toString());
                break;
            case R.id.minusButton:
                counter--;
                counterView.setText(counter.toString());
                break;
            case R.id.settingsButton:
                startActivity(new Intent(HomeActivity.this, SettingsActivity.class));
                finish();
        }
    }

    public boolean dispatchKeyEvent(KeyEvent event) {
        int action = event.getAction();
        int keyCode = event.getKeyCode();

        switch (keyCode) {
            case KeyEvent.KEYCODE_VOLUME_UP:
                if (action == KeyEvent.ACTION_DOWN) {
                    counter += 5;
                    counterView.setText(counter.toString());
                }
                return true;
            case KeyEvent.KEYCODE_VOLUME_DOWN:
                if (action == KeyEvent.ACTION_DOWN) {
                    counter -= 5;
                    counterView.setText(counter.toString());
                }
                return true;
            default:
                return super.dispatchKeyEvent(event);
        }
    }
}