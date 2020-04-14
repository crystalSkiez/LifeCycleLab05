package com.evaniskosophia.lifecyclelab05;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    SharedPreferences pref;
    SharedPreferences.Editor edit;
    int resumect,pausect,stopct,startct,restartct,destroyct,createct = 0;
    TextView all, current;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pref = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        edit = pref.edit();
        edit.putInt("onCreate", pref.getInt("onCreate", 0) + 1);
        edit.apply();

        all = findViewById(R.id.alldata);
        current = findViewById(R.id.currentdata);

        createct += 1;
        updateViews();
    }

    @Override
    protected void onStart() {
        super.onStart();
        startct += 1;
        edit.putInt("onStart", pref.getInt("onStart", 0) + 1);
        edit.apply();
        updateViews();
    }

    @Override
    protected void onResume() {
        super.onResume();
        resumect += 1;
        edit.putInt("onResume", pref.getInt("onResume", 0) + 1);
        edit.apply();
        updateViews();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        restartct += 1;
        edit.putInt("onRestart", pref.getInt("onRestart", 0) + 1);
        edit.apply();
        updateViews();
    }


    @Override
    protected void onPause() {
        super.onPause();
        pausect += 1;
        edit.putInt("onPause", pref.getInt("onPause", 0) + 1);
        edit.apply();
        updateViews();
    }

    @Override
    protected void onStop() {
        super.onStop();
        stopct += 1;
        edit.putInt("onStop", pref.getInt("onStop", 0) + 1);
        edit.apply();
        updateViews();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        destroyct += 1;
        edit.putInt("onDestroy", pref.getInt("onDestroy", 0) + 1);
        edit.apply();
        updateViews();
    }

    public String onCurrentRunString(){
        String out = "";
        out  += "create " + createct + "    start " + startct + "    stop " + stopct + "\n   pause " + pausect;
        out += "    resume " + resumect + "    destroy " + destroyct + "    restart " + restartct;
        return out;

    }

    public String onAllRunString(){
        String out = "";
        out += "onCreate" + (" " + pref.getInt("onCreate", 0) + "\n");
        out += "onStart" + (" " + pref.getInt("onStart", 0)  + "\n");
        out += "onStop" + (" " + pref.getInt("onStop", 0)  + "\n");
        out += "onPause" + (" " + pref.getInt("onPause", 0)  + "\n");
        out += "onResume" + (" " + pref.getInt("onResume", 0)  + "\n");
        out += "onDestroy" + (" " + pref.getInt("onDestroy", 0)  + "\n");
        out += "onRestart" + (" " + pref.getInt("onRestart", 0)  + "\n");
        return out;
    }

    public void updateViews(){
        current.setText(onCurrentRunString());
        all.setText(onAllRunString());
    }

}
