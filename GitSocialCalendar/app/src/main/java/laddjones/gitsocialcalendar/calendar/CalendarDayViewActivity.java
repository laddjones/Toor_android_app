package laddjones.gitsocialcalendar.calendar;

import android.content.Intent;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import laddjones.gitsocialcalendar.main.MainActivity;
import laddjones.gitsocialcalendar.R;
import laddjones.gitsocialcalendar.list.ToDoListActivity;

/**
 * Created by laddjones on 7/30/17.
 */

public class CalendarDayViewActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private RecyclerView calRecyclerView;
    private RecyclerView.Adapter calAdapter;
    private RecyclerView.LayoutManager calLayoutManager;
    private GestureDetector gestureDetector;
    View.OnTouchListener gestureListener;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cal_daily_view);

        //create toolbar
        toolbar = (Toolbar) findViewById(R.id.tool_bar_daily_cal);
        //setSupportActionBar(toolbar);

        //set up the RecyclerView, first tell it where to find the xml to set it up
        calRecyclerView = (RecyclerView) findViewById(R.id.my_daily_cal_recycler_view);
        //now set up the layout manager as a LinearLayoutManager
        //'this' is referring to our current object that we want to set the layout mananger up for
        calLayoutManager = new LinearLayoutManager(this);
        //now set the RecyclerView's layout
        calRecyclerView.setLayoutManager(calLayoutManager);
        //now create the data that will be going in
        List<String> input = new ArrayList<>();
        for(int i = 0; i < 20; i++) {
            input.add("Ladd Jones" + i);
        }
        //now set define an adapter and pass in the input
        calAdapter = new CalendarDayViewAdapter(input);
        //now set the RecyclerView's adapter
        calRecyclerView.setAdapter(calAdapter);

        //swipe to change page ------
        gestureDetector = new GestureDetector(this, new CalendarDayViewActivity.LearnGestureCal());
        gestureListener = new View.OnTouchListener() {
            public boolean onTouch(View v, MotionEvent event) {
                return gestureDetector.onTouchEvent(event);
            }
        };
        calRecyclerView.setOnTouchListener(gestureListener);
    }

    public void onLeftSwipe() {
        Intent intent = new Intent(CalendarDayViewActivity.this, ToDoListActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.right_slide1, R.anim.right_slide2);
        finish();
    }
    public void onRightSwipe() {
        Intent intent = new Intent(CalendarDayViewActivity.this, MainActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.left_slide1, R.anim.left_slide2);
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

                // Left swipe
                if (diff > SWIPE_MIN_DISTANCE
                        && Math.abs(velocityX) > SWIPE_THRESHOLD_VELOCITY) {
                    CalendarDayViewActivity.this.onLeftSwipe();
                }
                // Right swipe
                else if (-diff > SWIPE_MIN_DISTANCE
                        && Math.abs(velocityX) > SWIPE_THRESHOLD_VELOCITY) {
                    CalendarDayViewActivity.this.onRightSwipe();
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
