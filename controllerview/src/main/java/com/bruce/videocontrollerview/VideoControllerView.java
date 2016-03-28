package com.bruce.videocontrollerview;

/**
 * Created by Brucetoo
 * On 2015/10/19
 * At 16:33
 */

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import java.lang.ref.WeakReference;

public class VideoControllerView extends FrameLayout {

    private static final String TAG = "VideoControllerView";

    private static final int HANDLER_ANIMATE_OUT = 1;// out animate
    private static final int HANDLER_UPDATE_PROGRESS = 2;//cycle update progress
    private boolean mShowing;//controller view showing?

    private GestureDetector mGestureDetector;
    private Handler mHandler = new ControllerViewHandler(this);

    public VideoControllerView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public VideoControllerView(Context context) {
        this(context, null);
    }

    @Override protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        makeControllerView();
        mGestureDetector = new GestureDetector(getContext(),
            new ViewGestureListener());
    }

    /**
     * Handler prevent leak memory.
     */
    private static class ControllerViewHandler extends Handler {
        private final WeakReference<VideoControllerView> mView;

        ControllerViewHandler(VideoControllerView view) {
            mView = new WeakReference<VideoControllerView>(view);
        }

        @Override
        public void handleMessage(Message msg) {
            VideoControllerView view = mView.get();
            if (view == null) {
                return;
            }

            int pos;
            switch (msg.what) {
                case HANDLER_ANIMATE_OUT:
                    view.hide();
                    break;

            }
        }
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
        mHandler.sendEmptyMessage(HANDLER_UPDATE_PROGRESS);
    }

    /**
     * Control if show controllerview
     */
    public void toggleControllerView(){
        if(!isShowing()){
            show();
        }else {
            //animate out controller view
            Message msg = mHandler.obtainMessage(HANDLER_ANIMATE_OUT);
            mHandler.removeMessages(HANDLER_ANIMATE_OUT);
            mHandler.sendMessageDelayed(msg, 100);
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
        if (!isShowing()) {
            return;
        }
        setVisibility(INVISIBLE);
        mShowing = false;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        if (mGestureDetector.onTouchEvent(event)){
           toggleControllerView();
           return true;
        }

        return super.onTouchEvent(event);
    }

}