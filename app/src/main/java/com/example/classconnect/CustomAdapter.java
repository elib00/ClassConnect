package com.example.classconnect;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.classconnect.Entities.Task;

import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.CustomViewHolder> {
    public Context context;
    public List<Task> taskList;

    public CustomAdapter(Context context, List<Task> tasks){
        this.context = context;
        this.taskList = tasks;
    }


    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.item_task, parent, false);
        return new CustomViewHolder(v);
    }

    //TODO
    //implement nga if i click ang item, muadto shas specific nga page para niya
    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {
        Task task = taskList.get(position);
        holder.taskActivityNumber.setText(String.format("Activity %d: %s", task.getTaskNumber(), task.getTaskName()));
    }

    @Override
    public int getItemCount() {
        return taskList.size();
    }

    public static class CustomViewHolder extends RecyclerView.ViewHolder {
        TextView taskActivityNumber;

        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);
            taskActivityNumber = itemView.findViewById(R.id.task_activity_number);
        }
    }


}
