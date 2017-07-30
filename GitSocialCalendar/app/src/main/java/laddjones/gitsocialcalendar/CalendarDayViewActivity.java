package laddjones.gitsocialcalendar;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

/**
 * Created by laddjones on 7/30/17.
 */

public class CalendarDayViewActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Toast.makeText(getApplication().getApplicationContext(), "Calendar Page", Toast.LENGTH_LONG).show();
    }
}
