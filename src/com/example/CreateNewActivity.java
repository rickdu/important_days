package com.example;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

/**
 * Created by IntelliJ IDEA.
 * User: Rick
 * Date: 3/10/12
 * Time: 11:20 AM
 * To change this template use File | Settings | File Templates.
 */
public class CreateNewActivity extends Activity {
    
    LinearLayout layout;
    LinearLayout titleLayout, bodyLayout;

    Button cancelButton, saveButton;
    
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);
        layout.setBackgroundColor(Color.BLACK);

        LinearLayout.LayoutParams param = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.FILL_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);

        // title
        titleLayout = new LinearLayout(this);
        titleLayout.setOrientation(LinearLayout.HORIZONTAL);

        // cancel button
        cancelButton = new Button(this);
        cancelButton.setText("Cancel");
        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("cancel clicked");
                Intent intent = new Intent();
                intent.setClass(CreateNewActivity.this, Main.class);
                startActivity(intent);
                CreateNewActivity.this.finish();
            }
        });
        titleLayout.addView(cancelButton);

        // label
        TextView label = new TextView(this);
        label.setText("Add");
        titleLayout.addView(label);

        // save button
        saveButton = new Button(this);
        saveButton.setText("Save");
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //TODO: save data

                System.out.println("save clicked");
                Intent intent = new Intent();
                intent.setClass(CreateNewActivity.this, Main.class);
                startActivity(intent);
                CreateNewActivity.this.finish();
            }
        });
        titleLayout.addView(saveButton);

        layout.addView(titleLayout);

        // body layout
        bodyLayout = new LinearLayout(this);
        bodyLayout.setOrientation(LinearLayout.VERTICAL);

        // birthday or anniversary
        RadioGroup radioGroup = new RadioGroup(this);
        radioGroup.setOrientation(RadioGroup.HORIZONTAL);
        RadioButton radioBirth = new RadioButton(this);
        radioBirth.setChecked(true);
        radioBirth.setText("Birthday");
        RadioButton radioAnni = new RadioButton(this);
        radioAnni.setText("Anniversary");
        radioAnni.setChecked(false);
        radioGroup.addView(radioBirth);        
        radioGroup.addView(radioAnni);
        bodyLayout.addView(radioGroup, param);

        // event name
        EditText input = new EditText(this);
        bodyLayout.addView(input, param);

        // date picker
        DatePicker date = new DatePicker(this);
        date.init(1999, 1, 1, new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker datePicker, int i, int i1, int i2) {
                System.out.println("Date changed");
            }
        });
        bodyLayout.addView(date, param);


        layout.addView(bodyLayout);

        setContentView(layout);

    }
}