package laddjones.gitsocialcalendar.list;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import laddjones.gitsocialcalendar.R;

/**
 * Created by laddjones on 8/1/17.
 */

public class ToDoListAdapter extends RecyclerView.Adapter<ToDoListAdapter.ToDoViewHolder> {
    private List<String> values;

    public ToDoListAdapter(List<String> myDataSet) {
        values = myDataSet;
    }

    public class ToDoViewHolder extends RecyclerView.ViewHolder {


        public ToDoViewHolder(View v) {
            super(v);
        }
    }
    public int i = 0;
    @Override
    public ToDoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //create a new view
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.row_todo_constrained, parent, false);
        //set the view's size, margins, padding, and layout parameters
        ToDoViewHolder vh = new ToDoViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ToDoViewHolder holder, final int position) {
        //get element from dataset at this posiiton
        //replace the contents of the view with that element

        //here you could have a setOnClickLister that calls another method if you want
    }
    @Override
    public int getItemCount() {
        return values.size();
    }
}
