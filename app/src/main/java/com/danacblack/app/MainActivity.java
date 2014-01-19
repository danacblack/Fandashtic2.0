package com.danacblack.app;

import android.app.Activity;
import android.app.Fragment;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.content.Intent;
import android.widget.Button;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.AnalogClock;
import android.widget.DigitalClock;
import android.widget.TextView;
import android.accounts.AccountManager;
import android.accounts.Account;

public class MainActivity extends Activity {


    Button button1, button2;
    ImageButton iButton1, iButton2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            getFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }
        addListenerOnButton();
        TextView text = (TextView) findViewById(R.id.text1);
        TextView text2 = (TextView) findViewById(R.id.text2);
        text.setTextColor(Color.WHITE);
        text2.setTextColor(Color.WHITE);
    }
    public void addListenerOnButton() {
        button1 = (Button) findViewById(R.id.button);
        button1.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent infoIntent;
                infoIntent = new Intent(MainActivity.this, InformationPage.class);
                startActivity(infoIntent);
            }
        });
        /*final AccountManager manager = AccountManager.get(this);
        final Account[] accounts = manager.getAccountsByType("com.google");
        final int size = accounts.length;
        final String[] names = new String[size];
        for (int i = 0; i < size; i++) {
            names[i] = accounts[i].name;
        }*/
        button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent emailIntent = new Intent(Intent.ACTION_SEND);
                emailIntent.setType("plain/text");
                emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[] { "yourdealership@dealership.com" });
                emailIntent.putExtra(Intent.EXTRA_SUBJECT, "My Car Update");
                emailIntent.putExtra(Intent.EXTRA_TEXT, "Hey, I bought my car from you and wanted you to know...");
                startActivity(Intent.createChooser(emailIntent, ""));
            }
        });
        iButton1  = (ImageButton) findViewById(R.id.imageButton);
        iButton1.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent mapIntent =
                        new Intent(Intent.ACTION_MAIN);
                PackageManager manager = getPackageManager();
                mapIntent = manager.getLaunchIntentForPackage("com.google.android.apps.maps");
                mapIntent.addCategory(Intent.CATEGORY_APP_MAPS);
                startActivity(mapIntent);
            }
        });
        iButton2  = (ImageButton) findViewById(R.id.imageButton2);
        iButton2.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent musicIntent;
                PackageManager manager = getPackageManager();
                musicIntent = manager.getLaunchIntentForPackage("com.google.android.music");
                musicIntent.addCategory(Intent.CATEGORY_APP_MUSIC);
                startActivity(musicIntent);
            }
        });
        AnalogClock ac = (AnalogClock) findViewById(R.id.analogClock1);
        DigitalClock dc = (DigitalClock) findViewById(R.id.digitalClock1);

        ac.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent clockIntent;
                PackageManager manager = getPackageManager();
                clockIntent = manager.getLaunchIntentForPackage("com.google.android.deskclock");
                clockIntent.addCategory(Intent.CATEGORY_APP_CALENDAR);
                startActivity(clockIntent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);
            return rootView;
        }
    }

}
