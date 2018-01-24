package com.example.temirlan.zapis.view;

import android.Manifest;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.databinding.DataBindingUtil;
import android.databinding.Observable;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.MenuItem;
import android.view.View;

import com.example.temirlan.zapis.R;
import com.example.temirlan.zapis.adapters.ImageItemAdapter;
import com.example.temirlan.zapis.adapters.ServiceItemAdapter;
import com.example.temirlan.zapis.databinding.ActivitySalonDetailBinding;
import com.example.temirlan.zapis.viewmodel.SalonDetailViewModel;

import static com.example.temirlan.zapis.utils.CommonUtils.showLoadingDialog;

public class SalonDetailActivity extends AppCompatActivity {
    ActivitySalonDetailBinding binding;
    SalonDetailViewModel viewModel;
    int salonId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_salon_detail);
        getSalonId();

        initActionBar();

        initViewModel();

        initRecViews();
    }

    private void getSalonId() {
        salonId = getIntent().getIntExtra("salonId", 0);
    }

    private void initActionBar() {
        setSupportActionBar(binding.toolbar);
        getSupportActionBar().setTitle("");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Drawable newArrow = getResources().getDrawable(R.drawable.abc_ic_ab_back_material);
        newArrow.setColorFilter(getResources().getColor(R.color.white), PorterDuff.Mode.SRC_ATOP);
        getSupportActionBar().setHomeAsUpIndicator(newArrow);
    }

    private void initViewModel() {
        viewModel = new SalonDetailViewModel(getApplicationContext());
        viewModel.start(salonId);
        ProgressDialog progressDialog = showLoadingDialog(this);
        viewModel.observableFullSalonInfo.addOnPropertyChangedCallback(new Observable.OnPropertyChangedCallback() {
            @Override
            public void onPropertyChanged(Observable observable, int i) {
                if (viewModel.observableFullSalonInfo.get() != null) {
                    observable.removeOnPropertyChangedCallback(this);
                    binding.setFull(viewModel.observableFullSalonInfo.get());
                    progressDialog.dismiss();
                }
            }
        });
    }

    private void initRecViews() {
        binding.servicesRecView.setHasFixedSize(true);
        binding.servicesRecView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        binding.servicesRecView.setAdapter(new ServiceItemAdapter(viewModel.observableListOfServices));
        binding.imagesRecView.setHasFixedSize(true);
        binding.imagesRecView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL, false));
        binding.imagesRecView.setAdapter(new ImageItemAdapter(viewModel.observableListOfImagesUrl));
    }

    public void makeCall(View view){
        String phoneNumber = viewModel.getPhoneNumber();
        Intent intent = new Intent(Intent.ACTION_CALL);
        intent.setData(Uri.parse("tel:"+phoneNumber));
        if (ActivityCompat.checkSelfPermission(SalonDetailActivity.this,
                Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        startActivity(intent);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }
}
