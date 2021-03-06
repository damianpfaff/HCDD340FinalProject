package edu.psu.ist.hcdd340finalproject;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Switch;
import android.widget.ToggleButton;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.Snackbar;

public class SettingsActivity extends AppCompatActivity implements View.OnClickListener{

    private static final String TAG = "SETTINGS_ACTIVITY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings_page);

        findViewById(R.id.cancelButton).setOnClickListener(this);

        findViewById(R.id.notificationsToggle).setOnClickListener(this);
        findViewById(R.id.darkmodeToggle).setOnClickListener(this);

        Intent intent = getIntent();

        int backgroundColor = intent.getIntExtra(MainActivity.EXTRA_BACKGROUND_COLOR, R.color.app_background);

        boolean changeTheme = intent.getBooleanExtra(MainActivity.EXTRA_BACKGROUND_COLOR, false);

        Switch toggleTheme = findViewById(R.id.notificationsToggle);
        toggleTheme.setChecked(changeTheme);

        setBackgroundColor(backgroundColor);
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
        } else if (eventSourceId == R.id.notificationsToggle){
            //boolean on = ((Switch) view).isChecked();
            //notificationsToggle(findViewById(R.id.notificationsToggle), Switch);
            notificationsToggle();
        } else if (eventSourceId == R.id.darkmodeToggle){
            View otherView = findViewById(R.id.darkmodeToggle);
            //add a snackbar on toggle of dark mode switch
            Snackbar.make(otherView,
                    "Dark mode not implemented yet", Snackbar.LENGTH_LONG).setBackgroundTint(getColor(
                            R.color.design_default_color_error))
                    .show();
        }
    }

    public void notificationsToggle() {
//        boolean on = ((Switch) view).isChecked();

        //if(on){
        AlertDialog.Builder notificationsDialog = new AlertDialog.Builder(this);
        notificationsDialog.setTitle("Check Device Settings");
        notificationsDialog.setMessage(R.string.notifications_dialog_message);
        notificationsDialog.setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                //nothing
            }
        });

        notificationsDialog.show();
    }

    private void setBackgroundColor(int colorId) {
        findViewById(R.id.root_layout_settings_activity).setBackgroundColor(getColor(colorId));
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
