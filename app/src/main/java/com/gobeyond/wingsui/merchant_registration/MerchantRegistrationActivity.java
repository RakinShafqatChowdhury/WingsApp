package com.gobeyond.wingsui.merchant_registration;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.gobeyond.wingsui.R;
import com.stepstone.stepper.StepperLayout;
import com.stepstone.stepper.VerificationError;

import java.util.Objects;

public class MerchantRegistrationActivity extends AppCompatActivity implements StepperLayout.StepperListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_merchant_registration);
        setTitle("Merchant Registration");
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        StepperLayout mStepperLayout = findViewById(R.id.stepperLayout);
        mStepperLayout.setAdapter(new StepperAdapter(getSupportFragmentManager(), this));
    }

    @Override
    public void onCompleted(View completeButton) {

    }

    @Override
    public void onError(VerificationError verificationError) {

    }

    @Override
    public void onStepSelected(int newStepPosition) {

    }

    @Override
    public void onReturn() {

    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return super.onSupportNavigateUp();
    }
}