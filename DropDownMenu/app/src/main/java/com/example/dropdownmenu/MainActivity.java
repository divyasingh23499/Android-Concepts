package com.example.dropdownmenu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ImageView imgShow , imgHide;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imgShow = findViewById(R.id.showNotification);
        imgHide = findViewById(R.id.hideNotification);
        registerForContextMenu(imgShow);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        imgHide.setVisibility(View.VISIBLE);
        imgShow.setVisibility(View.INVISIBLE);
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.notification_menu , menu);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        super.onContextItemSelected(item);
        switch(item.getItemId()){
            case R.id.option_1:
                Toast.makeText(this,"option 1 selected" , Toast.LENGTH_SHORT);
                imgHide.setVisibility(View.INVISIBLE);
                imgShow.setVisibility(View.VISIBLE);
                return true ;

            case R.id.option_2:
                Toast.makeText(this,"option 2 selected" , Toast.LENGTH_SHORT);
                imgHide.setVisibility(View.INVISIBLE);
                imgShow.setVisibility(View.VISIBLE);
                return true ;

            case R.id.option_3:
                Toast.makeText(this,"option 3 selected" , Toast.LENGTH_SHORT);
                imgHide.setVisibility(View.INVISIBLE);
                imgShow.setVisibility(View.VISIBLE);
                return true ;

            default:
                imgHide.setVisibility(View.INVISIBLE);
                imgShow.setVisibility(View.VISIBLE);
                return super.onContextItemSelected(item);
        }
    }
}