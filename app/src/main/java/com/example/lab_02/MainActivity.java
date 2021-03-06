package com.example.lab_02;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {


    private Button button;
    private Intent i;
    private EditText text;
    public static final int REQUEST_CODE = 1;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        button = findViewById(R.id.button);
        i = new Intent(this, SecondActivity.class);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = text.getText().toString();
                i.putExtra("testString", s);
               // startActivity(i);
                startActivityForResult(i, REQUEST_CODE);



            }
        });


    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE && resultCode == Activity.RESULT_OK){
            Bundle extras = data.getExtras();

            if(extras != null){
                int imageID = extras.getInt("imageID");
                ConstraintLayout currentLayout = findViewById(R.id.MainActivity);
                currentLayout.setBackground(getDrawable(imageID));
            }
        }
    }


}