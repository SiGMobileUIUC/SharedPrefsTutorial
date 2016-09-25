package com.rmathur.sharepreftutorial;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    final String KEY = "entered";
    final String SHARED_PREF_NAME = "general_prefs";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView message = (TextView) findViewById(R.id.message);

        // get context
        Context context = this;

        // check
        SharedPreferences preferences =
                context.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        boolean entered = preferences.getBoolean(KEY, false);
        if(entered) {
            message.setText(getString(R.string.again));
        } else {
            // add value
            SharedPreferences.Editor editor =
                    context.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE).edit();
            editor.putBoolean(KEY, true);
            editor.commit();

        }
    }
}
