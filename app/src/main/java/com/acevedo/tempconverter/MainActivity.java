package com.acevedo.tempconverter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity implements TextView.OnEditorActionListener {

    //define variables for widgets
    private EditText FText;
    private TextView CTextView;


    private String fString;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //get references to the widgets
        CTextView = (TextView) findViewById(R.id.C);
        FText = (EditText) findViewById(R.id.F);

        FText.setOnEditorActionListener(this);

}

    @Override
    public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        calculateAndDisplay();
        return false;
    }

    private void calculateAndDisplay(){
        //create string
        fString = FText.getText().toString();

        float c;
        float F;
        

        try {
            F = Float.parseFloat(fString);
        }catch (NumberFormatException e){
            F = 0;
        }


        c = (F-32) * 5/9;

        //display celsius

        CTextView.setText(String.valueOf(c));

    }

}
