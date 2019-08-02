package com.example.bilalapp.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bilalapp.Models.Student;
import com.example.bilalapp.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class recyclerViewAdapter extends RecyclerView.Adapter<recyclerViewAdapter.RecyclerViewItems> {

    private List<Student> list = new ArrayList<>();

    public recyclerViewAdapter() {
    }

    @NonNull
    @Override
    public RecyclerViewItems onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new RecyclerViewItems(LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerelements, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewItems holder, int position) {
        Student stu = list.get(position);
        holder.name.setText(stu.getName());
        holder.sclass.setText(String.valueOf(stu.getsClass()));
        holder.roll.setText(String.valueOf(stu.getRollNumber()));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void setListData(List<Student> listing){
        this.list = listing;
        notifyDataSetChanged();
    }


    class RecyclerViewItems extends RecyclerView.ViewHolder{
        @BindView(R.id.name)
        TextView name;
        @BindView(R.id.sclass)
        TextView sclass;
        @BindView(R.id.roll)
        TextView roll;

        RecyclerViewItems(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
