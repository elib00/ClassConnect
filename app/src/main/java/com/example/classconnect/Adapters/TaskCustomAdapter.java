package com.example.classconnect.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.classconnect.Entities.Task;
import com.example.classconnect.R;
import com.example.classconnect.TaskDetailsActivity;

import java.util.List;

public class TaskCustomAdapter extends RecyclerView.Adapter<TaskCustomAdapter.CustomViewHolder> {
    public Context context;
    public List<Task> taskList;

    public TaskCustomAdapter(Context context, List<Task> tasks){
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

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AppCompatActivity activity = (AppCompatActivity) context;
                Intent intent = new Intent(context, TaskDetailsActivity.class);
                activity.startActivity(intent);
            }
        });
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
