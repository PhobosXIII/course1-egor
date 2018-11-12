package com.example.egsha.newtonparkguide;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ExhibitAdapter extends RecyclerView.Adapter<ExhibitAdapter.ExhibitViewHolder>{
    private List<Exhibit> exhibits;
    private OnItemClickListener itemClickListener;

    public ExhibitAdapter(List<Exhibit> people, OnItemClickListener itemClickListener) {
        this.exhibits = people;
        this.itemClickListener = itemClickListener;
    }

    @NonNull
    @Override
    public ExhibitViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_exhibit, viewGroup, false);
        return new ExhibitViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ExhibitViewHolder exhibitViewHolder, int position) {
        exhibitViewHolder.bind(exhibits.get(position), itemClickListener);
    }

    @Override
    public int getItemCount() {
        return exhibits == null ? 0 : exhibits.size();
    }

    public void add(Exhibit exhibit){
        exhibits.add(exhibit);
        notifyDataSetChanged();
    }

    public void update(List<Exhibit> people){
        this.exhibits.clear();
        this.exhibits.addAll(people);
        notifyDataSetChanged();
    }

    public interface OnItemClickListener {
        void onItemClick(Exhibit item);
    }

    public static class ExhibitViewHolder extends RecyclerView.ViewHolder{

        TextView tvName;

        public ExhibitViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tvName);
        }

        public void bind(final Exhibit exhibit, final OnItemClickListener itemClickListener){
            itemView.setOnClickListener(v -> itemClickListener.onItemClick(exhibit));


            tvName.setText(exhibit.getName());
        }
    }


}