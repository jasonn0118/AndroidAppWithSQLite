package com.example.sqlliteconnectiontutorial;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UpdateActivity extends AppCompatActivity {

    EditText edTitleUpdate, edAuthorUpdate, edPagesUpdate;
    Button btnUpdate;

    String id, title, author, pages;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        edTitleUpdate = findViewById(R.id.edTitleInputUpdate);
        edAuthorUpdate = findViewById(R.id.edAuthorInputUpdate);
        edPagesUpdate = findViewById(R.id.edNumOfPaperInputUpdate);
        btnUpdate = findViewById(R.id.btnUpdate);

        //First we Call this method.
        getAndSetIntentData();

        //Set actionbar tite after getAndSetIntentData method
        ActionBar ab = getSupportActionBar();
        if(ab != null)
            ab.setTitle(title);

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDatabaseHelper myDB = new myDatabaseHelper(UpdateActivity.this);
                title = edTitleUpdate.getText().toString().trim();
                author = edAuthorUpdate.getText().toString().trim();
                pages = edPagesUpdate.getText().toString().trim();
                myDB.updateData(id, title, author, pages);
                Log.d("CHECK DATA", "title: "+title);
                Log.d("CHECK DATA", "author: "+author);
            }
        });

    }

    void getAndSetIntentData() {
        try{
            if(getIntent().hasExtra("id") && getIntent().hasExtra("title") && getIntent().hasExtra("author")
                    && getIntent().hasExtra("pages")){
                //Getting Data from intent
                id = getIntent().getStringExtra("id");
                title = getIntent().getStringExtra("title");
                author = getIntent().getStringExtra("author");
                pages = getIntent().getStringExtra("pages");

                //Setting Intent Data
                edTitleUpdate.setText(title);
                edAuthorUpdate.setText(author);
                edPagesUpdate.setText(pages);
            } else {
                Toast.makeText(this, "No data to pass.", Toast.LENGTH_SHORT).show();
            }
        }catch (Exception ex){
            Toast.makeText(this, "Something wrong on getIntent data", Toast.LENGTH_SHORT).show();
        }
        
    }
}
