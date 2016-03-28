package siclocom.tin.androidtalk1.drawing;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by tin on 3/28/16.
 */
public class DrawingView extends View {

  Path mPoints;
  Paint paint;

  public DrawingView(Context context) {
    super(context);
  }

  public DrawingView(Context context, AttributeSet attrs) {
    super(context, attrs);
  }

  public DrawingView(Context context, AttributeSet attrs, int defStyleAttr) {
    super(context, attrs, defStyleAttr);
  }

  @Override protected void onAttachedToWindow() {
    super.onAttachedToWindow();
    paint = new Paint();
    paint.setAntiAlias(true);
    paint.setColor(Color.BLACK);
    paint.setStyle(Paint.Style.STROKE);
    paint.setStrokeJoin(Paint.Join.ROUND);
    paint.setStrokeWidth(5f);
    mPoints = new Path();
  }

  @Override protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
    super.onLayout(changed, left, top, right, bottom);
  }

  @Override public boolean onTouchEvent(MotionEvent event) {
    final int masked = event.getActionMasked();
    switch (masked){

      case MotionEvent.ACTION_DOWN:
        final int x = (int) event.getX();
        final int y = (int) event.getY();
        mPoints.moveTo(x, y);
        return true;

      case MotionEvent.ACTION_MOVE:
      case MotionEvent.ACTION_UP:

        final int historySize = event.getHistorySize();
        for (int i = 0; i < historySize; i++) {
          float historicalX = event.getHistoricalX(i);
          float historicalY = event.getHistoricalY(i);
          mPoints.lineTo(historicalX, historicalY);
        }
        invalidate();
        break;
      case MotionEvent.ACTION_CANCEL:
        mPoints.reset();
        break;
    }

    return true;
  }

  @Override protected void onDraw(Canvas canvas) {
    super.onDraw(canvas);
    canvas.drawPath(mPoints, paint);
  }
}
