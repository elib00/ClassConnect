package com.example.classconnect;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.classconnect.Adapters.StudentCustomAdapter;
import com.example.classconnect.Entities.Student;
import java.util.ArrayList;
import java.util.List;

public class ClassListActivity extends AppCompatActivity {
    private RecyclerView studentsListContainer;
    private StudentCustomAdapter adapter;
    private List<Student> studentList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_class_list);
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
//            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
//            return insets;
//        });
        initializeActivity();
    }

    private void initializeActivity(){
        studentList = new ArrayList<>();
        for(int i = 0; i < 10; i++){
            studentList.add(new Student.StudentBuilder().setStudentName("Joshua Napinas").build());
        }

        studentsListContainer = findViewById(R.id.classlist_students_list_container);
        studentsListContainer.setLayoutManager(new LinearLayoutManager(this));
        studentsListContainer.hasFixedSize();

        adapter = new StudentCustomAdapter(this, studentList);
        studentsListContainer.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }
}