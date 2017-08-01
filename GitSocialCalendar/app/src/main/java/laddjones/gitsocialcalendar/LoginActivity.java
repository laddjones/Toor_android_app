package laddjones.gitsocialcalendar;

import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.Button;
import android.support.design.widget.TextInputEditText;
import android.view.View;
import android.widget.Button;
import android.content.Intent;
import android.widget.Toast;
import android.support.v4.view.GestureDetectorCompat;
import android.view.MotionEvent;


/**
 * Created by laddjones on 7/29/17.
 */

public class LoginActivity extends AppCompatActivity {

    private Button connectButton;
    private TextInputEditText userIDEdit, userPasswordEdit;
    private GestureDetector gestureDetector;
    View.OnTouchListener gestureListener;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        userIDEdit = (TextInputEditText) findViewById(R.id.edit_text_login_user_id);
        userPasswordEdit = (TextInputEditText) findViewById(R.id.edit_text_login_user_password);
        connectButton = (Button) findViewById(R.id.button_login);

        connectButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userID = userIDEdit.getText().toString();
                userID = userID.replaceAll("\\s", "");
                String userPassword = userPasswordEdit.getText().toString();

                //connect to server
                connectToorServer(userID, userPassword);
            }
        });
    }

    /**
     * Attempt to connect to server
     * @param userID    The unique ID of the user
     * @param userPassword  The unique password of the user
     */
    private void connectToorServer(final String userID, final String userPassword) {
        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}
