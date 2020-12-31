package com.gobeyond.wingsui.delivery_supervisor;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import com.gobeyond.wingsui.R;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class ViewPagerActivity extends AppCompatActivity {
    private static final int NUM_PAGES = 4;
    private ViewPager2 viewPager;
    private FragmentStateAdapter pagerAdapter;
    private final String[] titles = new String[]{"List", "Bank", "Courier", "Expense"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager);
        TabLayout tabLayout = findViewById(R.id.tab_layout);
        tabLayout.setTabTextColors(getResources().getColor(R.color.grey_400),getResources().getColor(R.color.white));
        tabLayout.setBackgroundColor(getResources().getColor(R.color.blue_600));
        tabLayout.setSelectedTabIndicatorGravity(TabLayout.INDICATOR_GRAVITY_TOP);
        // Instantiate a ViewPager2 and a PagerAdapter.
        viewPager = findViewById(R.id.viewPager);
        viewPager.setPageTransformer(new ZoomOutPageTransformer());
        pagerAdapter = new ScreenSlidePagerAdapter(this);
        viewPager.setAdapter(pagerAdapter);

//        new TabLayoutMediator(tabLayout, viewPager,
//                (tab, position) -> tab.setText(titles[position])).attach();
        new TabLayoutMediator(tabLayout, viewPager, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                if(position==0){
                    tab.setText("Home");
                    tabLayout.setSelectedTabIndicatorColor(getResources().getColor(R.color.white));
                }else if(position==1){
                    tab.setText("Bank");
                    tabLayout.setSelectedTabIndicatorColor(getResources().getColor(R.color.white));
                }else if(position==2){
                    tab.setText("Courier");
                    tabLayout.setSelectedTabIndicatorColor(getResources().getColor(R.color.white));
                }else{
                    tab.setText("Expense");
                    tabLayout.setSelectedTabIndicatorColor(getResources().getColor(R.color.white));
                }
            }
        }).attach();
    }

    private static class ScreenSlidePagerAdapter extends FragmentStateAdapter {
        public ScreenSlidePagerAdapter(FragmentActivity fa) {
            super(fa);
        }

        @Override
        public Fragment createFragment(int position) {
            switch (position) {
                case 0:
                    return new DeliverySupervisorListFragment();

                case 1:
                    return new DeliverySupervisorBankFragment();

                case 2:
                    return new DeliverySupervisorCourierFragment();


                case 3:
                    return new DeliverySupervisorExpenseFragment();

            }
            return null;
        }

        @Override
        public int getItemCount() {
            return NUM_PAGES;
        }
    }

    @Override
    public void onBackPressed() {
        if (viewPager.getCurrentItem() == 0) {
            // If the user is currently looking at the first step, allow the system to handle the
            // Back button. This calls finish() on this activity and pops the back stack.
            super.onBackPressed();
        } else {
            // Otherwise, select the previous step.
            viewPager.setCurrentItem(viewPager.getCurrentItem() - 1);
        }
    }
}