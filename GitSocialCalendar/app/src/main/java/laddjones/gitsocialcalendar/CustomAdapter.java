package laddjones.gitsocialcalendar;

/**
 * Created by laddjones on 7/12/17.
 */
import java.util.List;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;


public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.CustomViewHolder> {
    //up to snuff
    private List<String> values;

    public CustomAdapter(List<String> myDataSet) {
        values = myDataSet;
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder {
        public TextView txtPersonName;
        public TextView txtNumPeople;
        public TextView txtetDescription;
        public TextView txtDate;
        public TextView txtTime;
        public ImageView picOfP;
        public View vrtLine;
        public View hrLine;
        public View layout;

        public CustomViewHolder(View v) {
            super(v);
            layout = v;
            picOfP = (ImageView) v.findViewById(R.id.picture);
            txtPersonName = (TextView) v.findViewById(R.id.name);
            txtNumPeople = (TextView) v.findViewById(R.id.numPeople);
            txtetDescription = (TextView) v.findViewById(R.id.etDescription);
            txtDate = (TextView) v.findViewById(R.id.dateTop);
            txtTime = (TextView) v.findViewById(R.id.timeBelow);
            vrtLine = v.findViewById(R.id.verticalLine);
            hrLine = v.findViewById(R.id.horizontalLine);
        }
    }
    public int i = 0;
    @Override
    public CustomAdapter.CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //create a new view
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.row_layout_constrained, parent, false);
        //set the view's size, margins, padding, and layout parameters
        CustomViewHolder vh = new CustomViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(CustomViewHolder holder, final int position) {
        //get element from dataset at this posiiton
        //replace the contents of the view with that element
        final  String name = values.get(position);
        holder.txtPersonName.setText(name);
        //here you could have a setOnClickLister that calls another method if you want
        if(position%8==0) {
            holder.txtPersonName.setText("Bill Gates");
            holder.txtNumPeople.setText("57");
            holder.picOfP.setImageResource(R.mipmap.bill_gates);
            holder.txtetDescription.setText("dinner # " + name +" with Elon to talk about telsa");
            holder.vrtLine.setBackgroundColor(Color.CYAN);
            holder.txtDate.setText(R.string.friday_resource);
            holder.txtTime.setText(R.string.time_resource);
            //holder.itemView.setElevation(20);
            holder.hrLine.setBackgroundColor(Color.WHITE);

        } else if(position%7==0) {
            holder.txtPersonName.setText("Code Group");
            holder.txtNumPeople.setText("100+");
            holder.picOfP.setImageResource(R.mipmap.code_group);
            holder.txtetDescription.setText("group discuption # " + name +" with Elon");
            holder.vrtLine.setBackgroundColor(Color.YELLOW);
            holder.txtDate.setText(R.string.friday_resource);
            holder.txtTime.setText(R.string.time_resource);

        } else if(position%6==0) {
            holder.txtPersonName.setText("Luke Jones");
            holder.txtNumPeople.setText("1");
            holder.picOfP.setImageResource(R.mipmap.luke_face);
            holder.txtetDescription.setText("walk the # " + name +" with bla bla bla ");
            holder.vrtLine.setBackgroundColor(Color.RED);
            holder.txtDate.setText(R.string.friday_resource);
            holder.txtTime.setText(R.string.time_resource);

        } else if(position%5==0) {
            holder.txtPersonName.setText("Dad");
            holder.txtNumPeople.setText("3");
            holder.picOfP.setImageResource(R.mipmap.dad_face);
            holder.txtetDescription.setText("Talking # " + name +" with dad over the new car aka lambo");
            holder.vrtLine.setBackgroundColor(Color.DKGRAY);
            holder.txtDate.setText(R.string.friday_resource);
            holder.txtTime.setText(R.string.time_resource);

        } else if(position%4==0) {
            holder.txtPersonName.setText("Computer Group");
            holder.txtNumPeople.setText("5");
            holder.picOfP.setImageResource(R.mipmap.computer_group);
            holder.txtetDescription.setText("Meeting # " + name +" with Elon");
            holder.vrtLine.setBackgroundColor(Color.RED);
            holder.txtDate.setText(R.string.friday_resource);
            holder.txtTime.setText(R.string.time_resource);

        } else if(position%3==0) {
            holder.txtPersonName.setText("Elon Musk");
            holder.txtNumPeople.setText("77");
            holder.picOfP.setImageResource(R.mipmap.elon_musk);
            holder.txtetDescription.setText("going to mars # " + name +" with Elon");
            holder.vrtLine.setBackgroundColor(Color.GREEN);
            holder.txtDate.setText(R.string.friday_resource);
            holder.txtTime.setText(R.string.time_resource);

        } else if(position%2==0) {
            holder.txtPersonName.setText("Richard Branson");
            holder.txtNumPeople.setText("11");
            holder.picOfP.setImageResource(R.mipmap.richard_branson);
            holder.txtetDescription.setText("fun stuff # " + name +" with Elon");
            holder.vrtLine.setBackgroundColor(Color.MAGENTA);
            holder.txtDate.setText(R.string.friday_resource);
            holder.txtTime.setText(R.string.time_resource);

        } else {
            holder.txtPersonName.setText("Ladd Jones");
            holder.txtNumPeople.setText("17");
            holder.picOfP.setImageResource(R.mipmap.ladd_face);
            holder.txtetDescription.setText("here we go # " + name +" with Elon");
            holder.vrtLine.setBackgroundColor(Color.RED);
            holder.txtDate.setText(R.string.friday_resource);
            holder.txtTime.setText(R.string.time_resource);

        }
        holder.txtDate.setText(R.string.friday_resource);

        holder.hrLine.setBackgroundColor(Color.WHITE);
        holder.vrtLine.setBackgroundColor(Color.WHITE);
        holder.vrtLine.setBackgroundColor(Color.LTGRAY);
    }

    @Override
    public int getItemCount() {
        return values.size();
    }
}
