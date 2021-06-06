package com.example.dairyapp.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import com.example.dairyapp.R;

import java.util.Calendar;
//Tanggal Pengerjaan : 04 - 06 - 2021
//NIM                : 10118337
//NAMA               : ADITTYA KAMAL M
//KELAS              : IF - 8

public class Edit extends AppCompatActivity {
    Toolbar toolbar;
    EditText juduldiary, isidiary;
    Calendar c;
    String todaysDate;
    String currentTime;
    DiaryDatabase db;
    Diary diary;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        Intent i = getIntent();
        Long id = i.getLongExtra("ID", 0);
         db = new DiaryDatabase(this);
         diary = db.getDiary(id);

        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitleTextColor(getResources().getColor(R.color.white));
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(diary.getJudul());

        juduldiary = findViewById(R.id.juduldiary);
        isidiary = findViewById(R.id.isidiary);

        juduldiary.setText(diary.getJudul());
        isidiary.setText(diary.getIsi());

        juduldiary.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() != 0) {
                    getSupportActionBar().setTitle(s);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        // get tanggal hari ini
        c = Calendar.getInstance();
        todaysDate = c.get(Calendar.DATE) + "/" + (c.get(Calendar.MONTH) + 1) + "/" + c.get(Calendar.YEAR);
        currentTime = pad(c.get(Calendar.HOUR)) + ":" + pad(c.get(Calendar.MINUTE));

        Log.d("calendar", "Date and Time : " + todaysDate + " and " + currentTime);
    }

    private String pad(int i) {
        if (i < 10)
            return "0" + i;
        return String.valueOf(i);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.save_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.delete){
            Toast.makeText(this, "Berhasil Dihapus", Toast.LENGTH_SHORT).show();
            onBackPressed();
        }
        if(item.getItemId() == R.id.save){
            diary.setJudul(juduldiary.getText().toString());
            diary.setIsi(isidiary.getText().toString());
            int id = db.editDiary(diary);
            if(id ==diary.getID()){
                Toast.makeText(this, "Aktivitas berhasil diubah", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Terjadi Kesalahan", Toast.LENGTH_SHORT).show();
            }

            Toast.makeText(this, "Berhasil Disimpan", Toast.LENGTH_SHORT).show();
            Intent i = new Intent(getApplicationContext(),Details.class);
            i.putExtra("ID",diary.getID());
            startActivity(i);
        }
        return super.onOptionsItemSelected(item);
    }

    private void goToMain() {
        Intent i = new Intent(this,MainActivity.class );
        startActivity(i);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

}
