package ro.pub.cs.systems.eim.lab03.phonedialer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.provider.SyncStateContract;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

public class PhoneDialerActivity extends AppCompatActivity {

    private String tag = "phonedialer";
    private ButtonClickListener buttonClickListener = new ButtonClickListener();

    private class ButtonClickListener implements Button.OnClickListener {

        @Override
        public void onClick(View view) {
            EditText phoneNumber = findViewById(R.id.number_text);
            if (view instanceof Button) {
                String text = ((Button) view).getText().toString();
                Log.d(tag, "Button " + text + " was clicked");
                phoneNumber = findViewById(R.id.number_text);
                phoneNumber.setText(phoneNumber.getText().append(text));
                phoneNumber.setCursorVisible(false);
            }
            if (view instanceof ImageButton) {
                String desc = (String) ((ImageButton) view).getContentDescription();
                Log.d(tag, "Button " + ((ImageButton) view).getContentDescription() + " was clicked");
                if (desc.equals("Back")) {
                    phoneNumber.setText(phoneNumber.getText().subSequence(0, phoneNumber.getText().length() - 1));
                } else if (desc.equals("Call")) {
                    Intent intent = new Intent(Intent.ACTION_CALL);
                    intent.setData(Uri.parse("tel:" + phoneNumber.getText().toString()));
                    if (ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                        return;
                    }
                    startActivity(intent);
                }else if(desc.equals("Reject")){
                    finish();
                }
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone_dialer);

        findViewById(R.id.button0).setOnClickListener(buttonClickListener);
        findViewById(R.id.button1).setOnClickListener(buttonClickListener);
        findViewById(R.id.button2).setOnClickListener(buttonClickListener);
        findViewById(R.id.button3).setOnClickListener(buttonClickListener);
        findViewById(R.id.button4).setOnClickListener(buttonClickListener);
        findViewById(R.id.button5).setOnClickListener(buttonClickListener);
        findViewById(R.id.button6).setOnClickListener(buttonClickListener);
        findViewById(R.id.button7).setOnClickListener(buttonClickListener);
        findViewById(R.id.button8).setOnClickListener(buttonClickListener);
        findViewById(R.id.button9).setOnClickListener(buttonClickListener);
        findViewById(R.id.button_star).setOnClickListener(buttonClickListener);
        findViewById(R.id.button_call).setOnClickListener(buttonClickListener);
        findViewById(R.id.button_hangup).setOnClickListener(buttonClickListener);
        findViewById(R.id.button_hashtag).setOnClickListener(buttonClickListener);
        findViewById(R.id.back_button).setOnClickListener(buttonClickListener);
    }
}
