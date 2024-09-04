package com.example.classconnect;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;

import java.util.Calendar;

public class CreateTaskActivity extends AppCompatActivity {
    private AutoCompleteTextView autoCompleteTextView;
    ArrayAdapter<String> adapterItems;
    private String[] subjects;
    private TextInputEditText deadline;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_create_task);
        initializeView();
    }

    private void initializeView(){
        subjects = new String[]{"Science", "English", "Mathematics", "Filipino"};

        autoCompleteTextView = findViewById(R.id.autocomplete_textview);
        adapterItems = new ArrayAdapter<>(this, R.layout.subject_item, subjects);
        autoCompleteTextView.setAdapter(adapterItems);

        autoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String item = adapterView.getItemAtPosition(i).toString();

            }
        });

        //for the date picker
        deadline = findViewById(R.id.deadline);
        deadline.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDatePickerDialog();
            }
        });
    }

    private void showDatePickerDialog() {
        // Get the current date
        final Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        // Create and show DatePickerDialog
        DatePickerDialog datePickerDialog = new DatePickerDialog(
                CreateTaskActivity.this,
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        deadline.setText(String.format("%02d/%02d/%d", month + 1, dayOfMonth, year));
                    }
                },
                year, month, day
        );

        datePickerDialog.show();
    }
}