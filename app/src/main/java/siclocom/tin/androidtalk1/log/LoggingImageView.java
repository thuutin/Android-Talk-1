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
public class LoggingImageView extends ImageView {
    public LoggingImageView(Context context) {
        super(context);
    }

    public LoggingImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public LoggingImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        Log.d(ImageView.class.getSimpleName(), "dispatchTouchEvent!!!");
        return super.dispatchTouchEvent(event);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.d(ImageView.class.getSimpleName(), "onTouchEvent!!!");
        return super.onTouchEvent(event);
    }
}
