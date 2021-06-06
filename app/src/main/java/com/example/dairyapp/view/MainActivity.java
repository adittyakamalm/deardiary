package com.example.dairyapp.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.dairyapp.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.List;
//Tanggal Pengerjaan : 02 - 06 - 2021
//NIM                : 10118337
//NAMA               : ADITTYA KAMAL M
//KELAS              : IF - 8

public class MainActivity extends AppCompatActivity {
    Toolbar toolbar;
    RecyclerView recyclerView;
    Adapter adapter;
    List<Diary> diaries;
    private Object BottomNavigationView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitleTextColor(getResources().getColor(R.color.white));

        DiaryDatabase db = new DiaryDatabase(this);
        diaries = db.getDiary();
        recyclerView = findViewById(R.id.diary);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new Adapter(this,diaries);
        recyclerView.setAdapter(adapter);

        BottomNavigationView bottomNavigationView =  findViewById(R.id.bottomNavigationView);

        bottomNavigationView.setSelectedItemId(R.id.home);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.home:
                        return true;
                    case R.id.profile:
                        startActivity(new Intent(getApplicationContext(),ProfileActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.about:
                        startActivity(new Intent(getApplicationContext(),About.class));
                        overridePendingTransition(0,0);
                        return true;
                }
                return false;
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.add_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.tambah){
            Intent i = new Intent(this, TambahDiary.class);
            startActivity(i);
            Toast.makeText(this, "Tombol Tambah Ditekan", Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }



}