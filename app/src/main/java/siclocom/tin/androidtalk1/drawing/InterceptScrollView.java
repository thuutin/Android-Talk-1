package siclocom.tin.androidtalk1.drawing;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ScrollView;
import siclocom.tin.androidtalk1.R;

/**
 * Created by tin on 3/28/16.
 */
public class InterceptScrollView extends ScrollView {

  private boolean willIntercept;
  View mTargetView;
  private float density;

  public InterceptScrollView(Context context) {
    super(context);
  }

  public InterceptScrollView(Context context, AttributeSet attrs) {
    super(context, attrs);
  }

  public InterceptScrollView(Context context, AttributeSet attrs, int defStyleAttr) {
    super(context, attrs, defStyleAttr);
  }

  @Override protected void onAttachedToWindow() {
    super.onAttachedToWindow();
    density = getResources().getDisplayMetrics().density;

  }

  public void setWillIntercept(boolean willIntercept){
    this.willIntercept = willIntercept;
  }

  @Override public boolean onInterceptTouchEvent(MotionEvent ev) {
    if (willIntercept){

      if (mTargetView == null){
        mTargetView = findViewById(R.id.drawing);
      }
      final float y = ev.getY();
      final float top = mTargetView.getTop() - density * 800;
      final float bottom = mTargetView.getHeight() + top;
      Log.d("Hello", "RawY: " + y + "   Top: " + top + "   Bottom: " + bottom);
      if (top < y && y < bottom){
        return false;
      }
    }
    return super.onInterceptTouchEvent(ev);
  }
}
