package com.example.temirlan.zapis.view;


import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.temirlan.zapis.R;
import com.example.temirlan.zapis.adapters.SectionPageAdapter;
import com.example.temirlan.zapis.databinding.SalonsListFragmentBinding;

/**
 * A simple {@link Fragment} subclass.
 */
public class SalonsListFragment extends Fragment {
    public static final int POPULAR_SALONS_TAG = 0;
    public static final int SUGGESTED_SALONS_TAG = 1;
    public static final int RECENTLY_ADDED_SALONS_TAG = 2;

    SalonsListFragmentBinding binding;


    public SalonsListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.salons_list_fragment, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViewPager();
        bindViewPagerAndTabLayout();
    }

    private void initViewPager() {
        SectionPageAdapter sectionPageAdapter = new SectionPageAdapter(getChildFragmentManager());
        sectionPageAdapter.addFragment(new PopularSalonsFragment(), getString(R.string.popular_salons));
        sectionPageAdapter.addFragment(new SuggestedSalonsFragment(), getString(R.string.suggested_salons));
        sectionPageAdapter.addFragment(new RecentlyAddedSalonsFragment(), getString(R.string.recently_added_salons));
        binding.viewPager.setAdapter(sectionPageAdapter);
    }

    private void bindViewPagerAndTabLayout() {
        binding.tabLayout.setupWithViewPager(binding.viewPager);
    }
}
