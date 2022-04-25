package edu.psu.ist.hcdd340finalproject;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class SettingsActivity extends AppCompatActivity implements View.OnClickListener{

    private static final String TAG = "SETTINGS_ACTIVITY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings_page);

        findViewById(R.id.cancelButton).setOnClickListener(this);

        findViewById(R.id.notificationsToggle).setOnClickListener(this);

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

}
