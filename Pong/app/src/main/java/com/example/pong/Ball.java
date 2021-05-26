package com.example.pong;

import android.graphics.RectF;

public class Ball {

    // member variables
    private RectF mRect;
    private float mXVelocity;
    private float mYVelocity;
    private float mBallWidth;
    private float mBallHeight;

    // Constructor
    public Ball(int screenX){
        // make ball 1% of screen
        mBallWidth = screenX / 100;
        mBallHeight = screenX / 100;

        mRect = new RectF();
    }

    // getter for mRect
    RectF getRect(){
        return mRect;
    }

    // update position of the ball
    void update(long fps){
        mRect.left = mRect.left + (mXVelocity / fps);
        mRect.top = mRect.top + (mYVelocity / fps);
        mRect.right = mRect.left + mBallWidth;
        mRect.bottom = mRect.top + mBallHeight;
    }

    // Reverses Y velocity
    void reverseYVelocity(){
        mYVelocity = -mYVelocity;
    }

    // Reverses X velocity
    void reverseXVelocity(){
        mXVelocity = -mXVelocity;
    }

    // Resets ball position
    void reset(int x, int y){
        // set pos and size
        mRect.left = x / 2;
        mRect.top = 0;
        mRect.right = x / 2 + mBallWidth;
        mRect.bottom = mBallHeight;

        // set initial velocities
        mYVelocity = (y / 3); // remove -
        mXVelocity = (x / 2);

    }

    // Increase ball speed by 10%
    void increaseVelocity(){
        mXVelocity = mXVelocity * 1.1f;
        mYVelocity = mYVelocity * 1.1f;

    }

    void batBounce(RectF batPosition){

        // detect centre of bat
        float batCenter = batPosition.left + (batPosition.width() / 2);

        // detect the centre of the ball
        float ballCenter = mRect.left + (mBallWidth / 2);

        // Where did ball hit
        float relativeIntersect = (batCenter - ballCenter);

        if(relativeIntersect < 0){ //right
            mXVelocity = Math.abs(mXVelocity);
        }else{ // left
            mXVelocity = -Math.abs(mXVelocity);
        }

        reverseYVelocity();
    }
}
