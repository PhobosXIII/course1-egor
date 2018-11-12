package com.example.egsha.newtonparkguide;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

@Dao
public interface ExhibitDao {
    @Query("SELECT * FROM exhibits")
    List<Exhibit> getAll();

    @Query("SELECT * FROM exhibits WHERE id = :id")
    Exhibit getById(long id);

    @Insert
    long insertExhibit(Exhibit exhibit);
}
