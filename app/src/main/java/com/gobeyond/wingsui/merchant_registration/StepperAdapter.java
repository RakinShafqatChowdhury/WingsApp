package com.gobeyond.wingsui.merchant_registration;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;

import com.stepstone.stepper.Step;
import com.stepstone.stepper.adapter.AbstractFragmentStepAdapter;

public class StepperAdapter extends AbstractFragmentStepAdapter {
    private static final String CURRENT_STEP_POSITION_KEY = "0";

    public StepperAdapter(@NonNull FragmentManager fm, @NonNull Context context) {
        super(fm, context);
    }

    @Override
    public Step createStep(int position) {
        Bundle b = new Bundle();
        b.putInt(CURRENT_STEP_POSITION_KEY, position);

        switch (position) {
            case 0:
                return new BasicInformationFragment();

            case 1:
                return new ContactPersonFragment();

            case 2:
                return new PaymentInformationFragment();

        }
        return null;
    }

    @Override
    public int getCount() {
        return 3;
    }
}
