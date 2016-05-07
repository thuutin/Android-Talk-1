package siclocom.tin.androidtalk1.log;

import android.graphics.Color;
import android.media.Image;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;

/**
 * Created by tin on 5/7/16.
 */
public class LoggingActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ViewGroup vg = new LoggingFrameLayout(this);
        ImageView iv = new LoggingImageView(this);
        iv.setBackgroundColor(Color.BLUE);
        vg.addView(iv, new FrameLayout.LayoutParams(400, 400, Gravity.CENTER));
        setContentView(vg);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Log.d(AppCompatActivity.class.getSimpleName(), "dispatchTouchEvent!!!");
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.d(AppCompatActivity.class.getSimpleName(), "onTouchEvent!!!");
        return super.onTouchEvent(event);
    }
}
