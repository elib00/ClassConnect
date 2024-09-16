package com.example.classconnect;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.SearchView;
import android.widget.Toast;

import com.example.classconnect.Entities.Task;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;
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
    private FloatingActionButton addTaskButton;
    private ImageButton burgerButton;
    private NavigationView sidebar;
    private DrawerLayout drawerLayout;

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

    //TODO diri ta mag fetch og data from the database
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

        adapter = new CustomAdapter(getContext(), taskQueryList);
        tasksContainer.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    private void initializeFragment(View view){
        taskList = new ArrayList<>();
        for(int i = 0; i < 10; i++){
            taskList.add(new Task(i + 1, "SAMPLE", "SAMPLE"));
        }

        taskSearchView = view.findViewById(R.id.task_searchbar);
        taskQueryList = new ArrayList<>(taskList);
        taskSearchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                filterList(s);
                return true;
            }
        });


        //for the toggling of activities logic
        ongoingButton = view.findViewById(R.id.ongoing_button);
        doneButton = view.findViewById(R.id.done_button);


        //set as the default one
        ongoingButton.setSelected(true);

        ongoingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectButton(ongoingButton);
            }
        });

        doneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectButton(doneButton);
            }
        });

        //for the floating button / adding task

        addTaskButton = view.findViewById(R.id.add_task_button);
        addTaskButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), CreateTaskActivity.class);
                startActivity(intent);
            }
        });

        //for the burger button para mo-open ang sidebar
        burgerButton = view.findViewById(R.id.burger_button);
        sidebar = view.findViewById(R.id.side_nav_container);
        drawerLayout = view.findViewById(R.id.drawer_layout);
        burgerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });

        sidebar.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                // Close the drawer after item is clicked
                drawerLayout.closeDrawer(GravityCompat.START);

                Intent intent;
                if (menuItem.getItemId() == R.id.nav_teacher_profile) {
                    System.out.println("teacher profile");
                    intent = new Intent(requireContext(), TeacherProfileActivity.class);
                    startActivity(intent);
                }else if (menuItem.getItemId() == R.id.nav_class_list) {
                    System.out.println("class list");
                    intent = new Intent(requireContext(), ClassListActivity.class);
                    startActivity(intent);
                }

                drawerLayout.closeDrawer(GravityCompat.START);
                return true;
            }
        });


    }

    private void selectButton(AppCompatButton selectedButton){
        ongoingButton.setSelected(false);
        doneButton.setSelected(false);
        selectedButton.setSelected(true);
    }

    private void filterList(String s){
        List<Task> filteredList = new ArrayList<>();
        System.out.println(s);
        for(Task task : taskList){
            String activityName = String.format("Activity %d: %s", task.getTaskNumber(), task.getTaskName());
            System.out.println(activityName);
            if(activityName.toLowerCase().contains(s.toLowerCase())){
                filteredList.add(task);
                System.out.println("na add si " + task.getTaskNumber());
            }
        }

        if(!filteredList.isEmpty()){
            setFilteredList(filteredList);
        }else{
            System.out.println("EMPTY ANG LIST!!!!");
        }
    }

    private void setFilteredList(List<Task> filteredList){
        taskQueryList.clear();
        taskQueryList.addAll(filteredList);
        adapter.notifyDataSetChanged();
    }
}