package com.example.dell.assignment5;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "Word")
public class Word
{

    @PrimaryKey(autoGenerate = true)
    private int id;

    private String word;

    //constructor
    public Word(String word) {this.word = word;}

    public void setId(int ida)
    {
        this.id = ida;
    }
    public String getWord(){return this.word;}
    public int getId(){return this.id;}

}
