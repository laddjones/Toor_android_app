package laddjones.gitsocialcalendar.main;

import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import laddjones.gitsocialcalendar.R;

/**
 * Created by laddjones on 7/30/17.
 */

public class CreateCalActivity extends AppCompatActivity {

    private TextInputEditText etDescriptionCal;
    private Button addToCal;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_cal);

        etDescriptionCal = (TextInputEditText) findViewById(R.id.edit_text_et_description_cal);
        addToCal = (Button) findViewById(R.id.add_et_button_cal);

        addToCal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userDescrEntry = etDescriptionCal.getText().toString();

                //add the users entry to their calendar via the online database
                addET(userDescrEntry);
            }
        });
    }

    public void addET(String etDescriptionCal) {

    }

}
