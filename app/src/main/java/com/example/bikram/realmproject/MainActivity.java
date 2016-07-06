package com.example.bikram.realmproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

import io.realm.Realm;
import io.realm.RealmConfiguration;

public class MainActivity extends AppCompatActivity {
    Realm realm;
    ArrayList<String> modelClasses;
    ArrayAdapter arrayAdapter;
    Spinner spinner;
    EditText editText;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner = (Spinner) findViewById(R.id.spinner);
        editText = (EditText) findViewById(R.id.editText);
        button = (Button) findViewById(R.id.button);

        RealmConfiguration realmConfiguration = new RealmConfiguration.Builder(this).build();

        realm = Realm.getInstance(realmConfiguration);

        final RealHelper realHelper = new RealHelper(realm);

        modelClasses = realHelper.getData();

        arrayAdapter = new ArrayAdapter(this, R.layout.support_simple_spinner_dropdown_item, modelClasses);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this, "clicked", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        spinner.setAdapter(arrayAdapter);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ModelClass modelClass = new ModelClass();

                modelClass.setName(editText.getText().toString().trim());
                RealHelper realHelper1 = new RealHelper(realm);


                realHelper1.save(modelClass);

                modelClasses = realHelper.getData();

                arrayAdapter = new ArrayAdapter(MainActivity.this, R.layout.support_simple_spinner_dropdown_item, modelClasses);

                spinner.setAdapter(arrayAdapter);
            }
        });


    }
}
