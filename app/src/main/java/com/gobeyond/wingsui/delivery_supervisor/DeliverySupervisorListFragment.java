package com.gobeyond.wingsui.delivery_supervisor;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gobeyond.wingsui.R;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class DeliverySupervisorListFragment extends Fragment {

    private ViewPager2 viewPager;
    private TabLayout tabLayout;

    public DeliverySupervisorListFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_delivery_supervisor_list, container, false);
        init(v);
        return v;
    }

    private void init(View v) {
        viewPager = v.findViewById(R.id.viewPager);
        tabLayout = v.findViewById(R.id.tab_layout);

    }
}