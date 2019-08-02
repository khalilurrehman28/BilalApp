package com.example.bilalapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.Toast;

import com.example.bilalapp.Models.Student;
import com.example.bilalapp.RecyclerView.recyclerViewAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = MainActivity.class.getSimpleName();

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    @BindView(R.id.ETName)
    EditText name;

    @BindView(R.id.ETclass)
    EditText sClass;

    @BindView(R.id.ETrollno)
    EditText rollnumber;

    List<Student> list = new ArrayList<>();

    recyclerViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        adapter = new recyclerViewAdapter();
        RecyclerView.LayoutManager manager = new LinearLayoutManager(this);

        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adapter);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addItemDecoration(new DividerItemDecoration(this, 1));
    }

    private void checkState(boolean bool) {
        if(bool){
            Student student = new Student(Integer.parseInt(rollnumber.getText().toString()),Integer.parseInt(sClass.getText().toString()),name.getText().toString());
            list.add(student);
            name.getText().clear();
            rollnumber.getText().clear();
            sClass.getText().clear();
            adapter.setListData(list);
        }else{
            Toast.makeText(this, "Sorry Brother please check errors", Toast.LENGTH_SHORT).show();
        }
    }

    @OnClick(R.id.BTClick)
    public void click(){
        boolean bt = true;
        if(name.getText().toString().trim().equals("")){
            name.setError("Please Enter Name");
            bt = false;
        }
        if(rollnumber.getText().toString().trim().equals("")){
            rollnumber.setError("Please enter rollnumber");
            bt = false;
        }
        if(sClass.getText().toString().trim().equals("")){
            sClass.setError("Please Enter class");
            bt = false;
        }

        checkState(bt);
    }

}
