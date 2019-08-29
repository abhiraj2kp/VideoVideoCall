package com.example.videovideocall;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;

public class NestedFragment extends AppCompatActivity implements FragmentA.FragmentInterface,FragmentB.FragmentInterface {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nested_fragment);
        FragmentTransaction transaction=getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.parent_fragment_container,new FragmentA());
        transaction.commit();
    }

    @Override
    public void FragmentACall() {
        Log.d("NestedFragment","FragmentACall");
    }

    @Override
    public void FragmentBCall() {
        Log.d("NestedFragment","FragmentBCall");
    }
}
