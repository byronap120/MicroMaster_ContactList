package com.beginner.micromaster.contactlist;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    private EditText nameEditText;
    private EditText lastNameEditText;
    private EditText emailEditText;
    private EditText phoneNumberEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameEditText = (EditText) findViewById(R.id.input_name);
        lastNameEditText = (EditText) findViewById(R.id.input_lastName);
        emailEditText = (EditText) findViewById(R.id.input_email);
        phoneNumberEditText = (EditText) findViewById(R.id.input_phoneNumber);

        Button button = (Button) findViewById(R.id.button_create_contact);
        button.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                String name = nameEditText.getText().toString();
                String lastName = lastNameEditText.getText().toString();
                String email = emailEditText.getText().toString();
                String phoneNumber = phoneNumberEditText.getText().toString();

                Integer phoneNumberInt = parsePhoneNumber(phoneNumber);
                if (phoneNumberInt != null) {
                    createNewContact(name, lastName, email, phoneNumberInt);
                }
            }
        });
    }

    private void createNewContact(String name, String lastName, String email, int phoneNumber) {
        Contact contact = new Contact(name, lastName, email, phoneNumber);
        Log.d(TAG, "New contact created: " + contact.toString());
        clearEditText();
    }

    private void clearEditText() {
        nameEditText.setText("");
        lastNameEditText.setText("");
        emailEditText.setText("");
        phoneNumberEditText.setText("");
    }

    public static Integer parsePhoneNumber(String text) {
        try {
            return Integer.parseInt(text);
        } catch (NumberFormatException e) {
            return null;
        }
    }
}
