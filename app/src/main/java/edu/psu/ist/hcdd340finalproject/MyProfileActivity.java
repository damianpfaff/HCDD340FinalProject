package edu.psu.ist.hcdd340finalproject;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class MyProfileActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "MYPROFILE_ACTIVITY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.myprofile_page);

        findViewById(R.id.editProfileButton).setOnClickListener(this);
        findViewById(R.id.backButton).setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        int eventSourceId = view.getId();

        if (eventSourceId == R.id.backButton){
            Log.d(TAG, "Back button was selected");
            setResult(RESULT_CANCELED);
            finish();
        } else if (eventSourceId == R.id.editProfileButton){
            handleEditProfile();
        }
    }

    private void handleEditProfile() {
        Intent intent = new Intent(this, EditProfileActivity.class);

        Log.d(TAG, "Edit profile button was selected");

        //mGetStatus.launch(intent);
        startActivity(intent);
    }
}
