package com.example.g0294.tutorial.datastorage;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import com.example.g0294.tutorial.R;

import java.util.List;

public class SQLiteDemo extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sqlite_layout);
        ContactDao contactDao = new ContactDao(this);

        // Inserting Contacts
        Log.d("Insert: ", "Inserting ..");
        contactDao.addContact(new Contact("Ravi", "0911111111"));
        contactDao.addContact(new Contact("Srinivas", "0912222222"));
        contactDao.addContact(new Contact("Tommy", "0933333333"));
        contactDao.addContact(new Contact("Karthik", "0934444444"));

        // Reading all contacts
        Log.d("Reading: ", "Reading all contacts..");
        List<Contact> contacts = contactDao.getAllContacts();

        for (Contact cn : contacts) {
            String log =
                    "Id: " + cn.get_id() + " ,Name: " + cn.get_name() + " ,Phone: " + cn.get_phone_number();
            // Writing Contacts to log
            Log.d("Name: ", log);
        }
    }

}
