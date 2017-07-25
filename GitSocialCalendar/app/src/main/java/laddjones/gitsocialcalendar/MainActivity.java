package laddjones.gitsocialcalendar;

/**
 * Created by laddjones on 7/12/17.
 */
import android.support.v7.app.AppCompatActivity;
import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private RecyclerView myRecyclerView;
    private RecyclerView.Adapter myAdapter;
    private RecyclerView.LayoutManager myLayoutManager;
    //works here too
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
    }
}
