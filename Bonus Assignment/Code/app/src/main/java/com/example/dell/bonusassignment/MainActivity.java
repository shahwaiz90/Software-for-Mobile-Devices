package com.example.dell.bonusassignment;

import android.content.Context;
import android.net.Uri;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity
{
    File directory;
    File file;
    String filename;
    String fileContents;
    FileOutputStream outputStream;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        createInInternal(this);

        try
        {
            createInExternal();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public void createInInternal(Context context)
    {
        //creating directory in internal storage
        directory = context.getDir("Internal Folder", context.MODE_PRIVATE);

        //create directory in downloads folder of internal storage
        directory = context.getDir("Downloads", context.MODE_PRIVATE);          //creating downloads folder
        //directory = new File(Environment.getDataDirectory()+"/Downloads");
        file = new File(directory, "Internal Download Folder");
        file.mkdir();

        //creating cache file
        try
        {
            filename = "Internal Cache File";
            file = File.createTempFile(filename, null, context.getCacheDir());
        }
        catch (IOException e)
        {
            Toast.makeText(context, "Error: "+e, Toast.LENGTH_SHORT).show();
        }


    }

    public void createInExternal() throws IOException {
        if(Environment.getExternalStorageState() != null)
        {
            //creating directory in external folder
            directory = new File(Environment.getExternalStorageDirectory()+"/SDcard Folder/");
            directory.mkdir();

            //creating directory in external download folder
            directory = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS), "SDcard Download Folder");
            directory.mkdir();

            //creating file in external cache
            File directory1 = this.getExternalCacheDir();
            filename = "SDcard Cache File";
            file = File.createTempFile(filename, null, directory1);


        }
        else
        {
            Toast.makeText(this, "No SD card mounted", Toast.LENGTH_SHORT).show();
        }
    }
}

