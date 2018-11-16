package com.example.egsha.newtonparkguide;


import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.Menu;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class ListActivity extends AppCompatActivity {

    private ExhibitAdapter adapter;
    RecyclerView rvExhibits;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        ExhibitDao exhibitDao = AppDatabase.getInstance(this).exhibitDao();
        if (exhibitDao.getAll().size() == 0) {
            exhibitDao.insertExhibits(ExhibitGenerator.getExhibits());
        }

        initList();

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(view -> {
            new IntentIntegrator(this).initiateScan();
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if(result != null) {
            String contents = result.getContents();
            if(contents != null) {
                searchExhibit(contents);
            }
        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }

    private void initList() {
        rvExhibits = findViewById(R.id.rvExhibits);
        rvExhibits.setHasFixedSize(true);
        rvExhibits.setLayoutManager(new LinearLayoutManager(this));
        rvExhibits.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        List<Exhibit> exhibits = AppDatabase.getInstance(this).exhibitDao().getAll();
        adapter = new ExhibitAdapter(exhibits, exhibit -> {
            final Intent intent = DetailActivity.getStartIntent(this, exhibit.getId());
            startActivity(intent);
        });
        rvExhibits.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_list, menu);
        SearchView searchView = (SearchView) menu.findItem(R.id.actionSearch).getActionView();
        searchView.setInputType(InputType.TYPE_CLASS_NUMBER);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                searchExhibit(query);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
        return true;
    }

    private void searchExhibit(String exhibitId) {
        long searchId = Long.valueOf(exhibitId);
        Exhibit exhibit = AppDatabase.getInstance(ListActivity.this).exhibitDao().getById(searchId);
        if (exhibit != null) {
            Intent intent = DetailActivity.getStartIntent(ListActivity.this, searchId);
            startActivity(intent);
        } else {
            Snackbar.make(rvExhibits, "Exhibit not found", Snackbar.LENGTH_LONG).show();
        }
    }
}