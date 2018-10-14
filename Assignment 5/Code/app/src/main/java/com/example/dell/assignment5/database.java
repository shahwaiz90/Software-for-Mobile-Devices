package com.example.dell.assignment5;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

@Database(entities = {Word.class}, version = 2)
public abstract class database extends RoomDatabase
{
    public abstract WordDAO wordDao();
}
