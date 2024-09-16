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
import com.example.classconnect.Entities.Task;
import com.example.classconnect.R;
import com.example.classconnect.StudentInformationActivity;
import com.example.classconnect.TaskDetailsActivity;

import java.util.List;

public class StudentCustomAdapter extends RecyclerView.Adapter<StudentCustomAdapter.CustomViewHolder> {
    public Context context;
    public List<Student> studentList;

    public StudentCustomAdapter(Context context, List<Student> students){
        this.context = context;
        this.studentList = students;
    }


    @NonNull
    @Override
    public StudentCustomAdapter.CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.item_student, parent, false);
        return new StudentCustomAdapter.CustomViewHolder(v);
    }

    //TODO
    //implement nga if i click ang item, muadto shas specific nga page para niya
    @Override
    public void onBindViewHolder(@NonNull StudentCustomAdapter.CustomViewHolder holder, int position) {
        Student student = studentList.get(position);
        holder.studentName.setText(student.getName());

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
        return studentList.size();
    }

    public static class CustomViewHolder extends RecyclerView.ViewHolder {
        TextView studentName;

        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);
            studentName = itemView.findViewById(R.id.student_name);
        }
    }
}

