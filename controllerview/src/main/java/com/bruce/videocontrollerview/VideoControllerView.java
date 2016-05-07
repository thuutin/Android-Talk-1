package com.bruce.videocontrollerview;

/**
 * Created by Brucetoo
 * On 2015/10/19
 * At 16:33
 */

import android.animation.Animator;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.MotionEventCompat;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import java.lang.ref.WeakReference;

public class VideoControllerView extends FrameLayout {

    private static final String TAG = "VideoControllerView";

    private boolean mShowing;//controller view showing?

    public VideoControllerView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public VideoControllerView(Context context) {
        this(context, null);
    }

    @Override protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        makeControllerView();
    }
    /**
     * init controller view
     * @return
     */
    protected void makeControllerView() {
        LayoutInflater inflate = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflate.inflate(R.layout.media_controller, this, true);
    }

    /**
     * show controller view
     */
    private void show() {
        if (!mShowing) {
            setVisibility(VISIBLE);
            mShowing = true;//set view state
        }
        //update progress
    }

    /**
     * Control if show controllerview
     */
    public void toggleControllerView(){
        if(!isShowing()){
            show();
        }else {
            hide();
        }
    }

    public boolean isShowing() {
        return mShowing;
    }

    /**
     * hide controller view with animation
     * Just use LayoutTransition
       mAnchorView.setLayoutTransition(new LayoutTransition());
       equals android:animateLayoutChanges="true"
     */
    private void hide() {
        animate().alpha(0).setDuration(300).setListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                setVisibility(INVISIBLE);
                setAlpha(1);
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
        mShowing = false;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        final int masked = MotionEventCompat.getActionMasked(event);
        if (masked == MotionEvent.ACTION_DOWN){
            toggleControllerView();
            return true;
        }
        return false;

    }

}