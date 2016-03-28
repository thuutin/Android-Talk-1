package siclocom.tin.androidtalk1.intercept;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import siclocom.tin.androidtalk1.R;

/**
 * Created by tin on 3/16/16.
 */
public class MoveInterceptActivity extends AppCompatActivity {

  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_intercept);
  }
}
