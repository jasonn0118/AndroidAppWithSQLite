package com.example.sqlliteconnectiontutorial;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddActivity extends AppCompatActivity {

    EditText edTitle, edAuthor, edPages;
    Button btnAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        edTitle = findViewById(R.id.edTitleInputUpdate);
        edAuthor = findViewById(R.id.edAuthorInputUpdate);
        edPages = findViewById(R.id.edNumOfPaperInputUpdate);
        btnAdd = findViewById(R.id.btnUpdate);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDatabaseHelper myDB = new myDatabaseHelper(AddActivity.this);
                myDB.addBook(edTitle.getText().toString().trim(),
                        edAuthor.getText().toString().trim(),
                        Integer.valueOf(edPages.getText().toString().trim()));

            }
        });


    }
}
