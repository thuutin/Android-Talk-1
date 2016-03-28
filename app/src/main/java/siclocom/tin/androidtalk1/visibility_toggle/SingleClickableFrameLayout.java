package siclocom.tin.androidtalk1.visibility_toggle;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import siclocom.tin.androidtalk1.R;

/**
 * Created by tin on 3/28/16.
 */
public class SingleClickableFrameLayout extends FrameLayout {

  View mTargetView;

  public SingleClickableFrameLayout(Context context) {
    super(context);
  }

  public SingleClickableFrameLayout(Context context, AttributeSet attrs) {
    super(context, attrs);
  }

  public SingleClickableFrameLayout(Context context, AttributeSet attrs, int defStyleAttr) {
    super(context, attrs, defStyleAttr);
  }

  @Override public boolean dispatchTouchEvent(MotionEvent ev) {
    if (mTargetView ==null){
      mTargetView = findViewById(R.id.controller);
    }
    return mTargetView.dispatchTouchEvent(ev) || super.dispatchTouchEvent(ev);
  }
}
