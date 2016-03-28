package siclocom.tin.androidtalk1;

import android.content.Intent;
import android.support.v4.view.MotionEventCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ScrollView;
import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import siclocom.tin.androidtalk1.drawing.DrawingActivity;
import siclocom.tin.androidtalk1.intercept.MoveInterceptActivity;
import siclocom.tin.androidtalk1.visibility_toggle.VisibilityToggleActivity;

public class MainActivity extends AppCompatActivity {

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    ButterKnife.bind(this);
  }

  @OnClick({ R.id.move_intercept, R.id.visibility_toggle, R.id.drawing })
  public void onClick(View v) {
    switch (v.getId()) {
      case R.id.move_intercept:
        startActivity(new Intent(this, MoveInterceptActivity.class));
        break;

      case R.id.visibility_toggle:
        startActivity(new Intent(this, VisibilityToggleActivity.class));
        break;

      case R.id.drawing:
        startActivity(new Intent(this, DrawingActivity.class));
    }
  }
}
