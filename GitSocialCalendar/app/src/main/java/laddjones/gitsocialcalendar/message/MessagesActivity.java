package laddjones.gitsocialcalendar.message;

import android.content.Intent;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import laddjones.gitsocialcalendar.R;
import laddjones.gitsocialcalendar.main.MainActivity;

/**
 * Created by laddjones on 7/30/17.
 */

public class MessagesActivity extends AppCompatActivity {

    private GestureDetector gestureDetector;
    View.OnTouchListener gestureListener;
    private ConstraintLayout myMessagesView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_messages);

        myMessagesView = (ConstraintLayout) findViewById(R.id.messages_a);

        Toast.makeText(getApplication().getApplicationContext(), "Messages Page", Toast.LENGTH_LONG).show();


        //swipe to change page ------
        gestureDetector = new GestureDetector(this, new MessagesActivity.LearnGestureMessage());
        gestureListener = new View.OnTouchListener() {
            public boolean onTouch(View v, MotionEvent event) {
                return gestureDetector.onTouchEvent(event);
            }
        };
        myMessagesView.setOnTouchListener(gestureListener);
    }



    public void onLeftSwipe() {
        Intent intent = new Intent(MessagesActivity.this, MainActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.right_slide1, R.anim.right_slide2);
        finish();
    }

    class LearnGestureMessage extends GestureDetector.SimpleOnGestureListener {
        private static final int SWIPE_MIN_DISTANCE = 50;
        private static final int SWIPE_MAX_OFF_PATH = 200;
        private static final int SWIPE_THRESHOLD_VELOCITY = 200;

        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX,
                               float velocityY) {
            try {
                float diffAbs = Math.abs(e1.getY() - e2.getY());
                float diff = e1.getX() - e2.getX();

                if (diffAbs > SWIPE_MAX_OFF_PATH)
                    return false;

                // Left swipe
                if (diff > SWIPE_MIN_DISTANCE
                        && Math.abs(velocityX) > SWIPE_THRESHOLD_VELOCITY) {
                    MessagesActivity.this.onLeftSwipe();
                }
            } catch (Exception e) {
                Log.e("Home", "Error on gestures");
            }
            return false;
        }
        @Override
        public boolean onDown(MotionEvent e) {
            return true;
        }

    }


}
