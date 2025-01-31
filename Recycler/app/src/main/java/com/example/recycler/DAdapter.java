package com.example.recycler;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class DAdapter extends RecyclerView.Adapter<DepartmentViewHolder> {

    Context ct;
    List<Department> depts;

    public DAdapter(Context ct,List<Department>depts) {
        this.ct = ct;
        this.depts=depts;
    }


    @NonNull
    @Override
    public DepartmentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new DepartmentViewHolder(LayoutInflater.from(ct).inflate(R.layout.itemlayout_recyclerview,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull DepartmentViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
