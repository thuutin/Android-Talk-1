package siclocom.tin.androidtalk1.log;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import android.widget.ImageView;

/**
 * Created by tin on 5/7/16.
 */
public class LoggingFrameLayout extends FrameLayout {

    public LoggingFrameLayout(Context context) {
        super(context);
    }

    public LoggingFrameLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public LoggingFrameLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Log.d(FrameLayout.class.getSimpleName(), "dispatchTouchEvent!!!");
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.d(FrameLayout.class.getSimpleName(), "onTouchEvent!!!");
        return super.onTouchEvent(event);
    }
}
