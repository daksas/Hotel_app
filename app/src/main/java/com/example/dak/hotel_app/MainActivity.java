package com.example.dak.hotel_app;

import android.support.v4.app.FragmentTransaction;
import android.content.Intent;
import android.widget.AdapterView.OnItemClickListener;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    private ListView mDrawerList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mDrawerList = (ListView) findViewById(R.id.left_drawer);
        mDrawerList.setOnItemClickListener(new SlideMenuClickListener());
       // ListView list = (ListView) findViewById(R.id.listView);

        if(findViewById(R.id.placeholder1)!=null){
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.placeholder, new fragmentList());
            ft.commit();
        }

        if(findViewById(R.id.placeholder1)!=null){
            FragmentTransaction ft1 = getSupportFragmentManager().beginTransaction();
            ft1.replace(R.id.placeholder1, new fragmentContent());
            ft1.commit();
        }

       /* list.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            public void onItemClick(AdapterView<?> parent, View clickView,
                                    int number, long id) {
                selectItem(number);
            }
        });*/

        //z nějakého důvodu nefunguje změna layoutu na tablet, edit: již nefunguje vůbec.

        }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.activity_main_actions, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
       switch(item.getItemId()) {
           case R.id.home:
               Intent intent = new Intent(this, MainActivity.class);
               startActivity(intent);
               break;
       }
        return super.onOptionsItemSelected(item);

    }


    private class SlideMenuClickListener implements
            ListView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position,
                                long id) {
            // display view for selected nav drawer item
            selectItem(position);
        }
    }


    private void selectItem(int position) {
        switch(position) {
            case 0:
                Intent a = new Intent(MainActivity.this, Contact.class);
                startActivity(a);
                break;
            case 1:
                Intent b = new Intent(MainActivity.this, Rooms.class);
                startActivity(b);
                break;
            case 2:
                Intent c = new Intent(MainActivity.this, Reservation_form.class);
                startActivity(c);
                break;
            default:
        }
    }
    public void klik(View view){
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.placeholder, new fragmentContent());
        ft.commit();
    }



}
