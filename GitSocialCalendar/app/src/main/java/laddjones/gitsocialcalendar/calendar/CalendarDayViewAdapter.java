package laddjones.gitsocialcalendar.calendar;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import laddjones.gitsocialcalendar.R;

/**
 * Created by laddjones on 8/1/17.
 */


public class CalendarDayViewAdapter extends RecyclerView.Adapter<CalendarDayViewAdapter.CalendarDayViewHolder> {
    private List<String> values;

    public CalendarDayViewAdapter(List<String> myDataSet) {
        values = myDataSet;
    }

    public class CalendarDayViewHolder extends RecyclerView.ViewHolder {


        public CalendarDayViewHolder(View v) {
            super(v);
        }
    }
    public int i = 0;
    @Override
    public CalendarDayViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //create a new view
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.row_dailycal_constrained, parent, false);
        //set the view's size, margins, padding, and layout parameters
        CalendarDayViewHolder vh = new CalendarDayViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(CalendarDayViewHolder holder, final int position) {
        //get element from dataset at this posiiton
        //replace the contents of the view with that element

        //here you could have a setOnClickLister that calls another method if you want
    }
    @Override
    public int getItemCount() {
        return values.size();
    }
}
