package com.example.dell.assignment6;

import android.Manifest;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MainActivity extends AppCompatActivity
{
    private static final int MY_PERMISSIONS_REQUEST_READ_CONTACTS = 0;
    int permissionGranted = 0;
    private RecycleAdapter mAdapter;
    private List<Contacts> contactsList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setRecyclerView();
    }

    public void getContacts(View view)
    {
        requestPermission();

        if(permissionGranted == 1)
        {
            //ContactsContract.Contacts.DISPLAY_NAME_PRIMARY,
            //        ContactsContract.Contacts.CONTACT_STATUS,
            String[] mColumnProjection = new String[]{
                    ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME_PRIMARY,
                    ContactsContract.CommonDataKinds.Phone.NUMBER};
            try
            {
                Cursor cursor = getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, mColumnProjection, null, null, null);
                if (cursor != null)
                {
                    TextView count = findViewById(R.id.textView);
                    String text = getResources().getString(R.string.total) + cursor.getCount();
                    count.setText(text);

                    loadContacts(cursor);
                }
                else
                {
                    TextView count = findViewById(R.id.textView);
                    String text = getResources().getString(R.string.no);
                    count.setText(text);
                }

                Objects.requireNonNull(cursor).close();
            }catch(Exception e)
            {
                Toast.makeText(this, "Error: "+e, Toast.LENGTH_SHORT).show();
            }

        }
        else
        {
            Toast.makeText(this, getResources().getString(R.string.notPerm), Toast.LENGTH_SHORT).show();
        }
    }

    public void setRecyclerView()
    {
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        mAdapter = new RecycleAdapter(contactsList);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        recyclerView.setAdapter(mAdapter);
    }

    public void loadContacts(Cursor cursor)
    {
        Contacts contact;
        while(cursor.moveToNext())
        {
            String name = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME_PRIMARY)) ;
            String number = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER)) ;
            contact = new Contacts(name, number);
            contactsList.add(contact);
        }
        mAdapter.notifyDataSetChanged();
    }

    public void requestPermission()
    {
        // Here, thisActivity is the current activity
        if (ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.READ_CONTACTS) != PackageManager.PERMISSION_GRANTED)
        {
            // Permission is not granted
            // Should we show an explanation?
            if (ActivityCompat.shouldShowRequestPermissionRationale(MainActivity.this, Manifest.permission.READ_CONTACTS))
            {
                // Show an explanation to the user *asynchronously* -- don't block
                // this thread waiting for the user's response! After the user
                // sees the explanation, try again to request the permission.
            }
            else
                {
                    // No explanation needed; request the permission
                    ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.READ_CONTACTS}, MY_PERMISSIONS_REQUEST_READ_CONTACTS);

                    // MY_PERMISSIONS_REQUEST_READ_CONTACTS is an
                    // app-defined int constant. The callback method gets the
                    // result of the request.
                }
        }
        else
        {
            // Permission has already been granted
            permissionGranted = 1;
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        switch (requestCode)
        {
            case MY_PERMISSIONS_REQUEST_READ_CONTACTS:
                {
                    // If request is cancelled, the result arrays are empty.
                    if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED)
                    {
                        // permission was granted, yay! Do the
                        // contacts-related task you need to do.
                        permissionGranted = 1;
                    }
                    else
                    {
                        // permission denied, boo! Disable the
                        // functionality that depends on this permission.
                        permissionGranted = 0;
                    }
            }

            // other 'case' lines to check for other
            // permissions this app might request.
        }
    }
}
