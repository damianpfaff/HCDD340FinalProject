package edu.psu.ist.hcdd340finalproject;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.android.material.snackbar.Snackbar;

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
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_info:
                showInfo();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void showInfo() {
        AlertDialog.Builder infoDialog = new AlertDialog.Builder(this);
        infoDialog.setTitle("App Information");
        infoDialog.setMessage(R.string.dialog_message);

        infoDialog.setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                // nothing
            }
        });

        infoDialog.show();
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



