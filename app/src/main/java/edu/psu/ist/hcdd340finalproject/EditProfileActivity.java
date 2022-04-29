package edu.psu.ist.hcdd340finalproject;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;


import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class EditProfileActivity extends AppCompatActivity implements View.OnClickListener{

    private static final String TAG = "EDITPROFILE_ACTIVITY";
    public static final String LINK = "HUDDLE_LINK";
    public static final String HIGHSCHOOL = "HIGHSCHOOL";
    public static final String SPORT = "SPORT";
    public static final String POSITION = "POSITION";
    public static final String HEIGHT = "HEIGHT";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.editprofile_page);

        findViewById(R.id.cancelButton).setOnClickListener(this);
        findViewById(R.id.savebtn).setOnClickListener(this);



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
    EditText eText, nText, sText, pText, hText, hsText;


    @Override
    public void onClick(View view) {
        int eventSourceId = view.getId();

        //if cancel button is clicked, finish current activity
        if (eventSourceId == R.id.cancelButton){
            Log.d(TAG, "Cancel button was selected");
            setResult(RESULT_CANCELED);
            finish();
        }
        if (eventSourceId == R.id.savebtn){
//            SharedPreferences prefs = view.getSharedPreferences("MyProfileActivity", 0);
//            return prefs.getString("link","");
            EditText eText = (EditText) findViewById(R.id.linktxt);
            String linkText = eText.getEditableText().toString();
            EditText hsText = (EditText) findViewById(R.id.hstxt);
            String hs = hsText.getEditableText().toString();
            EditText sText = (EditText) findViewById(R.id.sporttxt);
            String sport = sText.getEditableText().toString();
            EditText pText = (EditText) findViewById(R.id.positiontxt);
            String pos = pText.getEditableText().toString();
            EditText hText = (EditText) findViewById(R.id.heighttxt);
            String height = hText.getEditableText().toString();
            Intent intent = new Intent(this, MyProfileActivity.class);
            intent.putExtra(LINK, linkText);
            intent.putExtra(HIGHSCHOOL, hs);
            intent.putExtra(SPORT, sport);
            intent.putExtra(POSITION, pos);
            intent.putExtra(HEIGHT, height);
            startActivity(intent);

            Log.d(TAG, linkText + hs + sport + pos + height);
            Log.d(TAG, "save button was selected");

        }
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
