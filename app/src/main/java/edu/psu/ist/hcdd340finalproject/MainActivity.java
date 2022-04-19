package edu.psu.ist.hcdd340finalproject;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "ATHLEAD_ACTIVITY";
    //hi
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.settingsImage).setOnClickListener(this);
        findViewById(R.id.profileIcon).setOnClickListener(this);

//        ImageView settingsIcon = (ImageView) findViewById(R.id.settingsImage);
//        settingsIcon.bringToFront();
//        settingsIcon.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent myIntent = new Intent(MainActivity.this, SettingsActivity.class);
//                startActivity(myIntent);
//            }
//        });
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.profileIcon:
                handleMyProfile();
                break;
            case R.id.settingsImage:
                handleSettings();
                break;
        }
    }

    private void handleSettings() {
        Intent intent = new Intent(this, SettingsActivity.class);

        Log.d(TAG, "Settings button clicked");

        //mGetStatus.launch(intent);
        startActivity(intent);
    }

    private void handleMyProfile(){
        Intent intent = new Intent(this, MyProfileActivity.class);

        Log.d(TAG, "Profile button clicked");

        //mGetStatus.launch(intent);
        startActivity(intent);
    }
}



