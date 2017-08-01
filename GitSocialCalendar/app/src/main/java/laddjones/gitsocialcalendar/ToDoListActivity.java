package laddjones.gitsocialcalendar;

import android.content.Intent;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

/**
 * Created by laddjones on 8/1/17.
 */


public class ToDoListActivity extends AppCompatActivity {

    private GestureDetector gestureDetector;
    View.OnTouchListener gestureListener;
    private ConstraintLayout myToDoListView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todo_list);

        myToDoListView = (ConstraintLayout) findViewById(R.id.todo_a);

        Toast.makeText(getApplication().getApplicationContext(), "Arrived at To-Do list", Toast.LENGTH_LONG).show();

        //swipe to change page ------
        gestureDetector = new GestureDetector(this, new ToDoListActivity.LearnGestureCal());
        gestureListener = new View.OnTouchListener() {
            public boolean onTouch(View v, MotionEvent event) {
                return gestureDetector.onTouchEvent(event);
            }
        };
        myToDoListView.setOnTouchListener(gestureListener);
    }

    public void onRightSwipe() {
        Intent intent = new Intent(ToDoListActivity.this, CalendarDayViewActivity.class);
        startActivity(intent);
        finish();
    }
    class LearnGestureCal extends GestureDetector.SimpleOnGestureListener {
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

                // Right swipe
                if (-diff > SWIPE_MIN_DISTANCE
                        && Math.abs(velocityX) > SWIPE_THRESHOLD_VELOCITY) {
                    ToDoListActivity.this.onRightSwipe();
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
