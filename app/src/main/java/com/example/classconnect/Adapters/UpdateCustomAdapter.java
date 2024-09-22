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

import com.example.classconnect.Entities.Student;
import com.example.classconnect.Entities.Update;
import com.example.classconnect.R;
import com.example.classconnect.StudentInformationActivity;

import java.util.List;

public class UpdateCustomAdapter  extends RecyclerView.Adapter<UpdateCustomAdapter.CustomViewHolder> {
    public Context context;
    public List<Update> updateList;

    public UpdateCustomAdapter(Context context, List<Update> updateList){
        this.context = context;
        this.updateList = updateList;
    }
    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.item_update, parent, false);
        return new CustomViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull UpdateCustomAdapter.CustomViewHolder holder, int position) {
        Update announcement = updateList.get(position);
        holder.announcementName.setText(announcement.getTitle());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AppCompatActivity activity = (AppCompatActivity) context;
                Intent intent = new Intent(context, StudentInformationActivity.class);
                activity.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return updateList.size();
    }

    public static class CustomViewHolder extends RecyclerView.ViewHolder {
        TextView announcementName;

        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);
            announcementName = itemView.findViewById(R.id.announcement_name);
        }
    }
}
