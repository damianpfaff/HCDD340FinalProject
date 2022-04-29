package edu.psu.ist.hcdd340finalproject;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class MyProfileActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "MYPROFILE_ACTIVITY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.myprofile_page);

        findViewById(R.id.editProfileButton).setOnClickListener(this);
        findViewById(R.id.cancelButton).setOnClickListener(this);


        Intent intent = getIntent();
        TextView textView = findViewById(R.id.hudlLinkCompleted);
        textView.setText(intent.getStringExtra(EditProfileActivity.LINK));
        textView = findViewById(R.id.highSchoolCompleted);
        textView.setText(intent.getStringExtra(EditProfileActivity.HIGHSCHOOL));
        textView = findViewById(R.id.sportCompleted);
        textView.setText(intent.getStringExtra(EditProfileActivity.SPORT));
        textView = findViewById(R.id.positionCompleted);
        textView.setText(intent.getStringExtra(EditProfileActivity.POSITION));
        textView = findViewById(R.id.heightWeightCompleted);
        textView.setText(intent.getStringExtra(EditProfileActivity.HEIGHT));
    }
    public static void setFields(View view, String link){
        SharedPreferences prefs = view.getContext().getSharedPreferences("MyProfileActivity", 0);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString("link", link);
        editor.commit();
    }

    //creating the menu in this class
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
            case R.id.menu_home:
                returnHome();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    //makes the home button open the main activity page
    private void returnHome() {
        Intent intent = new Intent(this, MainActivity.class);

        Log.d(TAG, "Edit profile button was selected");

        //mGetStatus.launch(intent);
        startActivity(intent);
    }

    //opens a dialog with the app info
    private void showInfo() {
        AlertDialog.Builder infoDialog = new AlertDialog.Builder(this);
        infoDialog.setTitle("App Information");
        infoDialog.setMessage(R.string.dialog_message);

        infoDialog.setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
            }
        });

        //shows the dialog box
        infoDialog.show();
    }

    @Override
    public void onClick(View view) {
        int eventSourceId = view.getId();

        if (eventSourceId == R.id.cancelButton){
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
    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "On Start");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "On Resume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "On Pause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "On Stop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "On Destroy");
    }
}
