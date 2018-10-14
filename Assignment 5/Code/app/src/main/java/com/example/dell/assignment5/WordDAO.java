package com.example.dell.assignment5;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

   @Dao
    public interface WordDAO
   {
        @Insert
        void insert(Word word);

       @Update
       void update(Word word);

        @Delete
        void delete(Word word);

        @Query("select * from Word")
        List<Word> getAllWords();
    }

