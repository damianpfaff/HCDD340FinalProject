package edu.psu.ist.hcdd340finalproject;

import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.ToggleButton;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;

import com.google.android.material.switchmaterial.SwitchMaterial;

public class SettingsActivity extends AppCompatActivity implements View.OnClickListener{

    private static final String TAG = "SETTINGS_ACTIVITY";
    ToggleButton notificationsSwitch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings_page);

        findViewById(R.id.backButton).setOnClickListener(this);

        findViewById(R.id.notificationsToggle).setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        int eventSourceId = view.getId();

        if (eventSourceId == R.id.backButton){
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
