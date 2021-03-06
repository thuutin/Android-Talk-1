package siclocom.tin.androidtalk1.visibility_toggle;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import siclocom.tin.androidtalk1.R;

/**
 * Created by tin on 3/28/16.
 */
public class VisibilityToggleActivity extends AppCompatActivity {
  @Bind(R.id.checkbox1) CheckBox mCheckBox;
  @Bind(R.id.single_clickable_framelayout) SingleClickableFrameLayout mFrameLayout;

  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.visibility_toggle);
    ButterKnife.bind(this);
    mCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
      @Override public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        mFrameLayout.setWillRouteDispatch(isChecked);
      }
    });
  }
  
}
