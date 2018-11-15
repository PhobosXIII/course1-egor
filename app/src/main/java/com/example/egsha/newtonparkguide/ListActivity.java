package com.example.egsha.newtonparkguide;


import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;

import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class ListActivity extends AppCompatActivity {

    private ExhibitAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        ExhibitDao exhibitDao = AppDatabase.getInstance(this).exhibitDao();
        if (exhibitDao.getAll().size() == 0){
            exhibitDao.insertExhibits(ExibitGenerator.getExhibits());
        }

        initList();
    }

    private void initList() {
        RecyclerView rvPersons = findViewById(R.id.rvExhibits);
        rvPersons.setHasFixedSize(true);
        rvPersons.setLayoutManager(new LinearLayoutManager(this));
        rvPersons.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        List<Exhibit> exhibits = AppDatabase.getInstance(this).exhibitDao().getAll();
        adapter = new ExhibitAdapter(exhibits, exhibit -> {
            final Intent intent = DetailActivity.getStartIntent(this, exhibit.getId());
            startActivity(intent);
        });
        rvPersons.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_list, menu);
        SearchView searchView = (SearchView) menu.findItem(R.id.actionSearch).getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {

                if(Long.valueOf(query) > 0 && Long.valueOf(query) < ExibitGenerator.numberOfExhibits){Intent intent = DetailActivity.getStartIntent(ListActivity.this, Long.valueOf(query));
                startActivity(intent);}

//                try{
//                    (int)query;
//                }catch(){
//
//                }
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
        return true;
    }
}