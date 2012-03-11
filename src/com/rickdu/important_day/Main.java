package com.rickdu.important_day;

import android.R;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import com.rickdu.important_day.data.DatabaseHandler;
import com.rickdu.important_day.data.EventView;
import com.rickdu.important_day.data.UtilEventView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main extends Activity {
    LinearLayout layout;
    ListView listView;
    Button createButton;

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // create titleLayout
        layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);
        layout.setBackgroundColor(Color.BLACK);

        // create list view
        listView = new ListView(this);
        LinearLayout.LayoutParams param = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.FILL_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        listView.setBackgroundColor(Color.BLACK);
        layout.addView(listView, param);

        // create button
        createButton = new Button(this);
        createButton.setText("Create");
        createButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // switch the activity to 'create new record' activity
                System.out.println("button clicked");

                Intent intent = new Intent();
                intent.setClass(Main.this, CreateNewActivity.class);
                startActivity(intent);
                Main.this.finish();
            }
        });
        layout.addView(createButton);

        // set content titleLayout
        setContentView(layout);

        // get phones cursor
//        Cursor cur = getContentResolver().query(ContactsContract.Contacts.CONTENT_URI, null, null, null, null);
        DatabaseHandler db = new DatabaseHandler(this);
        db.open();
        Cursor cur = db.findAll();
        startManagingCursor(cur);

        // load data to EventViews
        List data = new ArrayList<Map<String, String>>();
        while (cur.moveToNext()) {
            EventView ev = new EventView();
            ev.setId(cur.getInt(cur.getColumnIndex(DatabaseHandler.KEY_ID)));
            ev.setName(cur.getString(cur.getColumnIndex(DatabaseHandler.KEY_NAME)));
            ev.setType(cur.getString(cur.getColumnIndex(DatabaseHandler.KEY_TYPE)));
            ev.setYear(cur.getInt(cur.getColumnIndex(DatabaseHandler.KEY_YEAR)));
            ev.setMonth(cur.getInt(cur.getColumnIndex(DatabaseHandler.KEY_MONTH)));
            ev.setDay(cur.getInt(cur.getColumnIndex(DatabaseHandler.KEY_DAY)));
            data.add(UtilEventView.toMap(ev));
        }

        // create adaptor to bridge data and list view
        ListAdapter adapter = new SimpleAdapter(this,
                data,
                R.layout.simple_list_item_2, // 2 items each line
                new String[]{db.KEY_NAME, db.KEY_ID},
                new int[]{R.id.text1, R.id.text2});
        listView.setAdapter(adapter);

        listView.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                displayToast("rolling to item " + Long.toString(adapterView.getSelectedItemId()));
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                // nothing to do
            }
        });
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                displayToast("rolling to item " + Long.toString(adapterView.getSelectedItemId()));
            }
        });
    }

    // display toast
    public void displayToast(String str) {
        System.out.println("item selected");
        Toast.makeText(this, str, Toast.LENGTH_SHORT).show();
    }
}
