package siclocom.tin.androidtalk1;

import android.support.v4.view.MotionEventCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        View view = findViewById(R.id.root);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        final int masked = MotionEventCompat.getActionMasked(ev);
        Log.d("Tin", "Activity - dispatchTouchEvent: " + masked);
        return super.dispatchTouchEvent(ev);
    }
}
