package siclocom.tin.androidtalk1.drawing;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ScrollView;
import butterknife.Bind;
import butterknife.ButterKnife;
import siclocom.tin.androidtalk1.R;

/**
 * Created by tin on 3/28/16.
 */
public class DrawingActivity extends AppCompatActivity {

  @Bind(R.id.interceptTouchEvent) CheckBox mCheckBox;
  @Bind(R.id.scrollView) InterceptScrollView mScrollView;

  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.drawing);
    ButterKnife.bind(this);

    mCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
      @Override public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        mScrollView.setWillIntercept(isChecked);
      }
    });
  }
}
