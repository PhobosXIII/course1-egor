package com.example.egsha.newtonparkguide;

import java.util.Objects;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "exhibits")
public class Exhibit {
    @PrimaryKey(autoGenerate = true)
    private long id;
    private String name;
    private String description;
    private String image;

    public Exhibit(String name, String description, String image) {
        this(0, name, description, image);
    }

    @Ignore
    public Exhibit(long id, String name, String description, String image) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Exhibit exhibit = (Exhibit) o;
        return id == exhibit.id &&
                Objects.equals(name, exhibit.name) &&
                Objects.equals(description, exhibit.description) &&
                Objects.equals(image, exhibit.image);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name, description, image);
    }
}
