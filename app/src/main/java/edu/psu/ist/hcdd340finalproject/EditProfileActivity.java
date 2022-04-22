package edu.psu.ist.hcdd340finalproject;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class EditProfileActivity extends AppCompatActivity implements View.OnClickListener{

    private static final String TAG = "EDITPROFILE_ACTIVITY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.editprofile_page);

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
