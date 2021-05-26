package com.example.pong;

import android.app.Activity;
import android.view.Window;
import android.os.Bundle;
import android.graphics.Point;
import android.view.Display;
import android.view.WindowManager;

public class PongActivity extends Activity {
    private PongGame mPongGame;

    // called when pong activity is created
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        // Find screen size
        display.getSize(size);
        // Overloaded contructor
        mPongGame = new PongGame(this, size.x, size.y);
        setContentView(mPongGame);
    }

    // called when a pause is ended
    @Override
    protected void onResume() {
        super.onResume();
        // Call from PongGame class
        mPongGame.resume();
    }

    // called when game becomes paused
    @Override
    protected void onPause() {
        super.onPause();
        // Call from PongGame class
        mPongGame.pause();
    }
}