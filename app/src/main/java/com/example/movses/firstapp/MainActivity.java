package com.example.movses.firstapp;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button plus;
    private Button minus;
    private Button div;
    private Button mult;
    private Button share;
    private EditText firstnumber;
    private EditText secondnumber;
    private TextView resultnumber;
    private MediaPlayer tada;
    private Switch mute;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firstnumber = (EditText) findViewById(R.id.firstnumber);
        secondnumber = (EditText) findViewById(R.id.secondnumber);
        resultnumber = (TextView) findViewById(R.id.resultnumber);

        plus = (Button) findViewById(R.id.plus);
        minus = (Button) findViewById(R.id.minus);
        div = (Button) findViewById(R.id.div);
        mult = (Button) findViewById(R.id.mult);

        share = (Button) findViewById(R.id.share);

        plus.setOnClickListener(this);
        minus.setOnClickListener(this);
        div.setOnClickListener(this);
        mult.setOnClickListener(this);


        tada = MediaPlayer.create(this, R.raw.tada);

        mute = (Switch) findViewById(R.id.mute);

    }

    @Override
    public void onClick(View view) {
        float number1;
        float number2;
        float result;

        String nonumber="No Number";
        int id =view.getId();
        if (TextUtils.isEmpty(firstnumber.getText().toString())
                || TextUtils.isEmpty(secondnumber.getText().toString())) {resultnumber.setText(nonumber);}
                else {





            InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);

            if (!mute.isChecked()){
            tada.start();
            tada.seekTo(100);}
        number1=Float.parseFloat(firstnumber.getText().toString());
            number2=Float.parseFloat(secondnumber.getText().toString());
            switch (id) {


                case R.id.plus:
                    result = number1 + number2;
                    resultnumber.setText(Float.toString(result));
                    break;
                case R.id.minus:
                    result = number1 - number2;
                    resultnumber.setText(Float.toString(result));
                    break;
                case R.id.mult:
                    result = number1 * number2;
                    resultnumber.setText(Float.toString(result));
                    break;
                case R.id.div:
                    result = number1 / number2;
                    resultnumber.setText(Float.toString(result));
                    break;
            }

        }

    share.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent= new Intent();
                    intent.setAction(Intent.ACTION_SEND);
                    intent.putExtra(Intent.EXTRA_TEXT,resultnumber.toString());
                    intent.setType("plain/text");
                    startActivity(intent);
        }
    });








    }
}
