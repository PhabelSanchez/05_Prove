package com.example.a05prove;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    String book, scripture, capbook;
    int chapter, verse;

    EditText bookField;
    EditText chapterField;
    EditText verseField;
    TextView scriptureField;

    Button enterButton;

    private static final String TAG = "IntentStatus";




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bookField = (EditText) findViewById(R.id.bookField);
        chapterField = (EditText) findViewById(R.id.chapterField);
        verseField = (EditText) findViewById(R.id.verseField);
        scriptureField = (TextView) findViewById(R.id.scriptureField);

        enterButton = (Button) findViewById(R.id.enterButton);
        enterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                book = bookField.getText().toString();
                chapter = Integer.parseInt(chapterField.getText().toString());
                verse = Integer.parseInt(verseField.getText().toString());
                capbook = book.substring(0, 1).toUpperCase() + book.substring(1);

                ShowToast(capbook);
                ShowToast(String.valueOf(chapter));
                ShowToast(String.valueOf(verse));

                scripture = capbook + " " + chapter + ":" + verse;

                Log.i(TAG, "About to create intent with " + scripture);

                scriptureField.setText(scripture);

                Log.i(TAG, "Received intent with " + scripture);

                bookField.getText().clear();
                chapterField.getText().clear();
                verseField.getText().clear();


            }
        });
    }

    private void ShowToast(String text) {
        Toast.makeText(MainActivity.this, text, Toast.LENGTH_SHORT).show();
    }
}