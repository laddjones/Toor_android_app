package laddjones.gitsocialcalendar.list;

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
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import laddjones.gitsocialcalendar.R;
import laddjones.gitsocialcalendar.calendar.CalendarDayViewActivity;
import laddjones.gitsocialcalendar.calendar.CalendarDayViewAdapter;

/**
 * Created by laddjones on 8/1/17.
 */


public class ToDoListActivity extends AppCompatActivity {

    private Toolbar toDoToolBar;
    private RecyclerView toDoRecyclerView;
    private RecyclerView.Adapter toDoAdapter;
    private RecyclerView.LayoutManager toDoLayoutManager;
    private GestureDetector gestureDetector;
    View.OnTouchListener gestureListener;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todo_list);

        //create toolbar
        toDoToolBar = (Toolbar) findViewById(R.id.to_do_tool_bar);
        //setSupportActionBar(toolbar);

        //set up the RecyclerView, first tell it where to find the xml to set it up
        toDoRecyclerView = (RecyclerView) findViewById(R.id.my_to_do_recycler_view);
        //now set up the layout manager as a LinearLayoutManager
        //'this' is referring to our current object that we want to set the layout mananger up for
        toDoLayoutManager = new LinearLayoutManager(this);
        //now set the RecyclerView's layout
        toDoRecyclerView.setLayoutManager(toDoLayoutManager);
        //now create the data that will be going in
        List<String> input = new ArrayList<>();
        for(int i = 0; i < 20; i++) {
            input.add("Ladd Jones" + i);
        }
        //now set define an adapter and pass in the input
        toDoAdapter = new ToDoListAdapter(input);
        //now set the RecyclerView's adapter
        toDoRecyclerView.setAdapter(toDoAdapter);

        //swipe to change page ------
        gestureDetector = new GestureDetector(this, new ToDoListActivity.LearnGestureToDo());
        gestureListener = new View.OnTouchListener() {
            public boolean onTouch(View v, MotionEvent event) {
                return gestureDetector.onTouchEvent(event);
            }
        };
        toDoRecyclerView.setOnTouchListener(gestureListener);
    }

    public void onRightSwipe() {
        Intent intent = new Intent(ToDoListActivity.this, CalendarDayViewActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.left_slide1, R.anim.left_slide2);
        finish();
    }
    class LearnGestureToDo extends GestureDetector.SimpleOnGestureListener {
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
