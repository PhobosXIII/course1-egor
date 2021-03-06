package com.example.egsha.newtonparkguide;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import androidx.appcompat.app.AppCompatActivity;

public class DetailActivity extends AppCompatActivity {

    private static final String EXTRA_PERSON_ID = "com.example.egsha.newtonparkguide.extras.EXTRA_PERSON_ID";

    public static Intent getStartIntent(Context context, long personId){
        return new Intent(context, DetailActivity.class).putExtra(EXTRA_PERSON_ID, personId);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        initUi();
    }

    private void initUi() {
        TextView tvDescription = findViewById(R.id.tvDescription);
        ImageView ivImage = findViewById(R.id.ivImage);

        final long personId = getIntent().getLongExtra(EXTRA_PERSON_ID, 0);
        final Exhibit exhibit = AppDatabase.getInstance(this).exhibitDao().getById(personId);
        Picasso.get().load(exhibit.getImage())
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_background)
                .fit()
                .centerCrop()
                .into(ivImage);
        tvDescription.setText(exhibit.getDescription());

    }
}