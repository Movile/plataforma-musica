package movile.music;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import java.lang.Override;import java.lang.String;import java.util.Timer;
import java.util.TimerTask;

import bhouse.travellist.R;
import movile.music.services.GetContent;
import movile.music.services.GetContentImpl;


public class Splash extends Activity implements GetContent{

    // Set the duration of the splash screen
    private static final long SPLASH_SCREEN_DELAY = 1200;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

//Remove notification bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        // Hide title bar
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        TimerTask task = new TimerTask() {
            @Override
            public void run() {

                GetContentImpl getContent = new GetContentImpl();
                getContent.setListener(Splash.this);
                getContent.execute();

            }
        };

       // Simulate a long loading process on application startup.
        Timer timer = new Timer();
        timer.schedule(task, SPLASH_SCREEN_DELAY);
    }

    @Override
    public void callbackGetContent(String result) {
        Intent mainIntent = new Intent().setClass(
                Splash.this, MainActivity.class);
        startActivity(mainIntent);
        finish();
    }
}
