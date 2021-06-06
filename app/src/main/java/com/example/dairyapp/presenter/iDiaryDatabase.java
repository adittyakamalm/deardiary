package com.example.dairyapp.presenter;

import com.example.dairyapp.view.Diary;

import java.util.List;

public interface iDiaryDatabase {
    public long tambahDiary(Diary diary);
    public Diary getDiary(long id);
    public List<Diary> getDiary();
    public int editDiary(Diary diary);
    void deleteDiary (long id);
}
