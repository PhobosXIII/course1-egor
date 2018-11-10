package com.example.egsha.newtonparkguide;


import android.content.Intent;
import android.os.Bundle;
import android.widget.Toolbar;

import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class ListActivity extends AppCompatActivity {

    private ExhibitAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        initList();

        /*FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(view -> {
            final PersonDao personDao = AppDatabase.getInstance(this).personDao();
            personDao.insertPerson(generator.getPerson());
            List<Exhibit> people = personDao.getAll();
            adapter.update(people);
        });*/
    }

    private void initList() {
        RecyclerView rvPersons = findViewById(R.id.rvExhibits);
        rvPersons.setHasFixedSize(true);
        rvPersons.setLayoutManager(new LinearLayoutManager(this));
        rvPersons.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        List<Exhibit> exhibits = new ArrayList<>();// = AppDatabase.getInstance(this).personDao().getAll();
        adapter = new ExhibitAdapter(exhibits, exhibit -> {
            final Intent intent = DetailActivity.getStartIntent(this, exhibit.getId());
            startActivity(intent);
        });
        rvPersons.setAdapter(adapter);
    }
}