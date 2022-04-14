package edu.psu.ist.hcdd340finalproject;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SettingsActivity extends AppCompatActivity implements View.OnClickListener{

    private static final String TAG = "SETTINGS_ACTIVITY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings_page);

        findViewById(R.id.backButton).setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        int eventSourceId = view.getId();

        if (eventSourceId == R.id.backButton){
            Log.d(TAG, "Back button was selected");
            setResult(RESULT_CANCELED);
            finish();
        }
    }
}
