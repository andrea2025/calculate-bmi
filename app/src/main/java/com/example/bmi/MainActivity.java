package com.example.bmi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    EditText mHeight,mWeight;
    String heightText,weightText;
    TextView mTextView;
    Editable weight1;
    Editable height1;

Button mButton;
float total;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mHeight = findViewById(R.id.height);
        mWeight = findViewById(R.id.weight);
        mButton = findViewById(R.id.btn);




   mButton.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        weight1 = mWeight.getText();
        height1 = mHeight.getText();


        total = (float) (Integer.parseInt(String.valueOf(weight1)) / (Float.parseFloat(String.valueOf(height1))
                *  Float.parseFloat(String.valueOf(height1))));

        DecimalFormat df = new DecimalFormat("#.0");
         String result = df.format(total);

        Toast.makeText(getApplicationContext(),"your value is: " + result,Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(getApplicationContext(), ResultActivity.class);
    intent.putExtra("result",result);
    startActivity(intent);
    }
});

    }

}
