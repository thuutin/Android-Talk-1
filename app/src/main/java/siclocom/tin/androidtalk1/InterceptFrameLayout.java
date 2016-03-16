package siclocom.tin.androidtalk1;

import android.content.Context;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.ViewConfigurationCompat;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.widget.FrameLayout;

/**
 * Created by tin on 3/16/16.
 */
public class InterceptFrameLayout extends FrameLayout {
  float x,y;
  public InterceptFrameLayout(Context context) {
    super(context);
  }

  public InterceptFrameLayout(Context context, AttributeSet attrs) {
    super(context, attrs);
  }

  public InterceptFrameLayout(Context context, AttributeSet attrs, int defStyleAttr) {
    super(context, attrs, defStyleAttr);
  }

  @Override public boolean onInterceptTouchEvent(MotionEvent ev) {
    final int mask = MotionEventCompat.getActionMasked(ev);
    switch (mask){

      case MotionEvent.ACTION_DOWN:
        x = ev.getRawX();
        y = ev.getRawY();
        return false;

      case MotionEvent.ACTION_MOVE:
        final float currentX = ev.getRawX();
        final float currentY = ev.getRawY();
        final double distance = Math.sqrt(
            Math.pow((currentX - x), 2) +
            Math.pow((currentY - y), 2)
        );

        return distance > ViewConfiguration.get(getContext()).getScaledTouchSlop();

      default:
        return false;
    }
  }
}
