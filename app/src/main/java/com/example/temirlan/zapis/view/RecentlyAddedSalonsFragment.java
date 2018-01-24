
package com.example.temirlan.zapis.view;


import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.temirlan.zapis.R;
import com.example.temirlan.zapis.adapters.SalonItemAdapter;
import com.example.temirlan.zapis.adapters.navigation.SalonItemOnClickListeners;
import com.example.temirlan.zapis.databinding.FragmentPopularSalonsBinding;
import com.example.temirlan.zapis.viewmodel.SalonsViewModel;

import static com.example.temirlan.zapis.view.SalonsListFragment.RECENTLY_ADDED_SALONS_TAG;

/**
     * A simple {@link Fragment} subclass.
     */
    public class RecentlyAddedSalonsFragment extends Fragment {
        FragmentPopularSalonsBinding binding;
        SalonsViewModel viewModel;
        SalonItemOnClickListeners listeners;

        public RecentlyAddedSalonsFragment() {
            // Required empty public constructor
        }


        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            binding = DataBindingUtil.inflate(inflater,R.layout.fragment_popular_salons,container,false);
            return binding.getRoot();
        }

        @Override
        public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
            super.onViewCreated(view, savedInstanceState);
            initViewModel();
            setListeners();
            initRecView();
        }

        private void initViewModel() {
            viewModel = new SalonsViewModel(getActivity().getApplicationContext());
            viewModel.start(RECENTLY_ADDED_SALONS_TAG);
        }

    private void setListeners() {
        listeners = i -> {
            Intent intent = new Intent(getActivity(), SalonDetailActivity.class);
            intent.putExtra("salonId", i);
            getActivity().startActivity(intent);
        };
    }

        private void initRecView() {
            binding.recView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL,false));
            binding.recView.setHasFixedSize(false);
            binding.recView.setAdapter(new SalonItemAdapter(viewModel.getObservableListOfSalons(), listeners));
        }
    }
