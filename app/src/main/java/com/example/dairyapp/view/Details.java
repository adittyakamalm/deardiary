package com.example.dairyapp.view;

import android.content.Intent;
import android.os.Bundle;

import com.example.dairyapp.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.text.method.ScrollingMovementMethod;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
//Tanggal Pengerjaan : 03 - 06 - 2021
//NIM                : 10118337
//NAMA               : ADITTYA KAMAL M
//KELAS              : IF - 8

public class Details extends AppCompatActivity {
    TextView mDetails;
    DiaryDatabase db;
    Diary diary;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mDetails = findViewById(R.id.detailsDairy);

        Intent i = getIntent();
        Long id = i.getLongExtra("ID",0);

        db = new DiaryDatabase(this);
        diary = db.getDiary(id);
        getSupportActionBar().setTitle(diary.getJudul());
        mDetails.setText(diary.getIsi());
        mDetails.setMovementMethod(new ScrollingMovementMethod());

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db.deleteDiary(diary.getID());
                Toast.makeText(getApplicationContext(), "Kegiatan Berhasil Dihapus", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getApplicationContext(),MainActivity.class));
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.edit_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.editDiary){
            Intent i = new Intent(this,Edit.class);
            i.putExtra("ID",diary.getID());
            startActivity(i);
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }



}