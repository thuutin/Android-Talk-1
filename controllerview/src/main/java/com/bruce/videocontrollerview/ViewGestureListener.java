package com.bruce.videocontrollerview;

import android.content.Context;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.WindowManager;

/**
 * Created by Brucetoo
 * On 2015/10/21
 * At 9:58
 */
public class ViewGestureListener extends GestureDetector.SimpleOnGestureListener {

    private static final String TAG = "ViewGestureListener";


    public ViewGestureListener() {
    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        return true;
    }

}
