package vn.edu.ictu.android.simplecalander;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ViewPager viewPager = findViewById(R.id.pager);
        TabLayout tab = findViewById(R.id.tab);

        PageAdapter pageAdapter = new PageAdapter(getSupportFragmentManager());
        for (int i = 2; i <= 500; i++) {
            int dayOfWeek = i%7;
            if(dayOfWeek == 0) dayOfWeek = 7;
            if(dayOfWeek == 1) dayOfWeek = 8;
            pageAdapter.addFragment(DayFragment.newInstance(i - 2),
                    dayOfWeek % 8 == 0 ? "CN" : "Thứ " + dayOfWeek);
        }

        viewPager.setAdapter(pageAdapter);
        tab.setupWithViewPager(viewPager);
    }
}
