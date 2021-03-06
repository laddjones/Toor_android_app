package laddjones.gitsocialcalendar.main;

/**
 * Created by laddjones on 7/12/17.
 */
import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.GestureDetector;
import android.view.Gravity;
import android.view.View;
import android.view.LayoutInflater;
import android.widget.RelativeLayout;
import android.widget.PopupWindow;
import android.view.MotionEvent;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import laddjones.gitsocialcalendar.message.MessagesActivity;
import laddjones.gitsocialcalendar.R;
import laddjones.gitsocialcalendar.calendar.CalendarDayViewActivity;

public class MainActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private RecyclerView myRecyclerView;
    private RecyclerView.Adapter myAdapter;
    private RecyclerView.LayoutManager myLayoutManager;
    private FloatingActionButton addET;
    private GestureDetector gestureDetector;
    View.OnTouchListener gestureListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState); // here super is being used to called the parent method
        setContentView(R.layout.activity_main);

        //create toolbar
        toolbar = (Toolbar) findViewById(R.id.tool_bar);
        //setSupportActionBar(toolbar);

        //set up the RecyclerView, first tell it where to find the xml to set it up
        myRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        //now set up the layout manager as a LinearLayoutManager
        //'this' is referring to our current object that we want to set the layout mananger up for
        myLayoutManager = new LinearLayoutManager(this);
        //now set the RecyclerView's layout
        myRecyclerView.setLayoutManager(myLayoutManager);
        //now create the data that will be going in
        List<String> input = new ArrayList<>();
        for(int i = 0; i < 20; i++) {
            input.add("Ladd Jones" + i);
        }
        //now set define an adapter and pass in the input
        myAdapter = new CustomAdapter(input);
        //now set the RecyclerView's adapter
        myRecyclerView.setAdapter(myAdapter);

        addET = (FloatingActionButton) findViewById(R.id.add_ET);
        addET.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onButtonShowPopupWindowClick(v);
            }
        });

        //swipe to change page ------
        gestureDetector = new GestureDetector(this, new LearnGesture());
        gestureListener = new View.OnTouchListener() {
            public boolean onTouch(View v, MotionEvent event) {
                return gestureDetector.onTouchEvent(event);
            }
        };
        myRecyclerView.setOnTouchListener(gestureListener);
    }


    public void onLeftSwipe() {
        Intent intent = new Intent(MainActivity.this, CalendarDayViewActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.right_slide1, R.anim.right_slide2);
        finish();
    }
    public void onRightSwipe() {
        Intent intent = new Intent(MainActivity.this, MessagesActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.left_slide1, R.anim.left_slide2);
        finish();
    }
    class LearnGesture extends GestureDetector.SimpleOnGestureListener {
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
                    MainActivity.this.onLeftSwipe();
                }
                // Right swipe
                else if (-diff > SWIPE_MIN_DISTANCE
                        && Math.abs(velocityX) > SWIPE_THRESHOLD_VELOCITY) {
                    MainActivity.this.onRightSwipe();
                }
            } catch (Exception e) {
                Log.e("Home", "Error on gestures");
            }
            return false;
        }

    }

    public void onButtonShowPopupWindowClick(View view) {

        // get a reference to the already created main layout
        RelativeLayout mainLayout = (RelativeLayout) findViewById(R.id.activity_main_layout);

        // inflate the layout of the popup window
        LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
        View popupView = inflater.inflate(R.layout.popup_window_add_et, null);

        // create the popup window
        int width = ConstraintLayout.LayoutParams.FILL_PARENT;
        int height = ConstraintLayout.LayoutParams.FILL_PARENT;
        boolean focusable = true; // lets taps outside the popup also dismiss it
        final PopupWindow popupWindow = new PopupWindow(popupView, width, height, focusable);

        // show the popup window
        popupWindow.showAtLocation(mainLayout, Gravity.BOTTOM, Gravity.END, 0);

        // dismiss the popup window when touched
        popupView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                popupWindow.dismiss();
                return true;
            }
        });

        FloatingActionButton calButton = (FloatingActionButton) popupView.findViewById(R.id.add_to_calendar);
        FloatingActionButton todoButton = (FloatingActionButton) popupView.findViewById(R.id.add_to_list);

        calButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, CreateCalActivity.class);
                startActivity(intent);
                finish();            }
        });

        todoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, CreateToDoActivity.class);
                startActivity(intent);
                finish();            }
        });

    }
}
