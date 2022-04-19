package edu.psu.ist.hcdd340finalproject;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class MyProfileActivity extends AppCompatActivity implements View.OnClickListener{

    private static final String TAG = "MYPROFILE_ACTIVITY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.myprofile_page);

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
