package com.example.egsha.newtonparkguide;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import java.util.List;

public class ExhibitAdapter extends RecyclerView.Adapter<ExhibitAdapter.ExibitViewHolder>{
    private List<Exhibit> exhibites;
    private OnItemClickListener itemClickListener;

    public ExhibitAdapter(List<Exhibit> people, OnItemClickListener itemClickListener) {
        this.exhibites = people;
        this.itemClickListener = itemClickListener;
    }

    @NonNull
    @Override
    public ExibitViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_exhibit, viewGroup, false);
        return new ExibitViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ExibitViewHolder exibitViewHolder, int position) {
        exibitViewHolder.bind(exhibites.get(position), itemClickListener);
    }

    @Override
    public int getItemCount() {
        return exhibites == null ? 0 : exhibites.size();
    }

    public void add(Exhibit exhibit){
        exhibites.add(exhibit);
        notifyDataSetChanged();
    }

    public void update(List<Exhibit> people){
        this.exhibites.clear();
        this.exhibites.addAll(people);
        notifyDataSetChanged();
    }

    public interface OnItemClickListener {
        void onItemClick(Exhibit item);
    }

    public static class ExibitViewHolder extends RecyclerView.ViewHolder{

        TextView tvName;

        public ExibitViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tvName);
        }

        public void bind(final Exhibit exhibit, final OnItemClickListener itemClickListener){
            itemView.setOnClickListener(v -> itemClickListener.onItemClick(exhibit));


            tvName.setText(exhibit.getName());
        }
    }


}