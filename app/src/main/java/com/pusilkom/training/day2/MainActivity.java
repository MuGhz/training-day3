package com.pusilkom.training.day2;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.pusilkom.training.day2.adapter.ListMenuAdapter;
import com.pusilkom.training.day2.helper.RequestHelper;
import com.pusilkom.training.day2.model.ListMenuItem;
import com.pusilkom.training.day2.task.PostActivityTask;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        RequestHelper requestHelper = new RequestHelper(getApplicationContext(), getString(R.string.api_url));
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

//        ListView menuList = (ListView) findViewById(R.id.menu_list);
//        String jsonMenu = getIntent().getStringExtra("myMenu");
//        List<ListMenuItem> myMenu = new Gson().fromJson(jsonMenu, new TypeToken<List<ListMenuItem>>(){}.getType());
//        ListAdapter adapter = new ListMenuAdapter(this, R.layout.list_layout_menu, myMenu);
//        menuList.setAdapter(adapter);
//        menuList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//
//            }
//        });

        TextView resp = (TextView) findViewById(R.id.backend_response);
        resp.setText(getIntent().getStringExtra("myRepo"));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private List<ListMenuItem> createSampleMenu() {
        ListMenuItem item1 = new ListMenuItem(1, null, "Menu 1", "Description of menu 1");
        ListMenuItem item2 = new ListMenuItem(1, null, "Menu 2", "Description of menu 2");
        ListMenuItem item3 = new ListMenuItem(1, null, "Menu 3", "Description of menu 3");
        ListMenuItem item4 = new ListMenuItem(1, null, "Menu 4", "Description of menu 4");
        List<ListMenuItem> list = new ArrayList<ListMenuItem>();
        list.add(item1);
        list.add(item2);
        list.add(item3);
        list.add(item4);

        return list;
    }
}
