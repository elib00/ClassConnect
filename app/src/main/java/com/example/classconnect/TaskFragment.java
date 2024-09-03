package com.example.classconnect;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.SearchView;

import com.example.classconnect.Entities.Task;
import com.google.android.material.search.SearchBar;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link TaskFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TaskFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private List<Task> taskList;
    private List<Task> taskQueryList;
    private CustomAdapter adapter;
    private RecyclerView tasksContainer;
    private SearchView taskSearchView;
    private AppCompatButton ongoingButton;
    private AppCompatButton doneButton;

    public TaskFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment TaskFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static TaskFragment newInstance(String param1, String param2) {
        TaskFragment fragment = new TaskFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_task, container, false);
        initializeFragment(view);
        return view;
    }


    //TODO
    // implement ang feature na if imoha i click ang ongoing or done, machange ang query state
    @SuppressLint("NotifyDataSetChanged")
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        tasksContainer = (RecyclerView) view.findViewById(R.id.tasks_list_container);
        tasksContainer.setLayoutManager(new LinearLayoutManager(getContext()));
        tasksContainer.hasFixedSize();

        adapter = new CustomAdapter(getContext(), taskList);
        tasksContainer.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    private void initializeFragment(View view){
        taskList = new ArrayList<>();
        for(int i = 0; i < 100; i++){
            taskList.add(new Task(i + 1, "SAMPLE", "SAMPLE"));
        }

        ongoingButton = view.findViewById(R.id.ongoing_button);
        doneButton = view.findViewById(R.id.done_button);
        taskSearchView = view.findViewById(R.id.task_searchbar);

        taskSearchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                return false;
            }
        });
    }
}