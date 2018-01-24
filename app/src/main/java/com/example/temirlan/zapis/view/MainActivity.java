package com.example.temirlan.zapis.view;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.example.temirlan.zapis.R;
import com.example.temirlan.zapis.databinding.ActivityMainBinding;


public class MainActivity extends AppCompatActivity {
    ActivityMainBinding dataBinding;

    private SalonsListFragment salonsListFragment;
    private EmptyFragment emptyFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dataBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        dataBinding.setOnSelectListener(this::switchTabNames);

        navigateToSalonsPage();


        initActionBar();

    }


    private void initActionBar() {
        setSupportActionBar(dataBinding.toolbar);
        getSupportActionBar().setTitle("");
    }

    private void navigateToSalonsPage() {
        dataBinding.tabTitle.setText(R.string.main_screen);
        replaceWithFragment(getSalonsListFragment());
    }


    private SalonsListFragment getSalonsListFragment() {
        if (salonsListFragment == null) {
            salonsListFragment = new SalonsListFragment();
        }
        return salonsListFragment;
    }

    private void navigateToSearchPage() {
        dataBinding.tabTitle.setText(R.string.search);
        replaceWithFragment(getEmptyFragment());
    }


    private EmptyFragment getEmptyFragment() {
        if (emptyFragment == null) {
            emptyFragment = new EmptyFragment();
        }
        return emptyFragment;
    }

    private void navigateToProfilePage() {
        dataBinding.tabTitle.setText(R.string.profile);
        replaceWithFragment(getEmptyFragment());
    }


    private void replaceWithFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_container, fragment);
        transaction.commitAllowingStateLoss();
    }

    public boolean switchTabNames(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.main:
                navigateToSalonsPage();
                break;
            case R.id.search:
                navigateToSearchPage();
                break;
            case R.id.profile:
                navigateToProfilePage();
                break;
        }
        return true;
    }
}
