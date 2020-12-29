package com.gobeyond.wingsui.merchant_registration;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.text.TextUtils;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gobeyond.wingsui.R;
import com.google.android.material.textfield.TextInputEditText;
import com.stepstone.stepper.BlockingStep;
import com.stepstone.stepper.StepperLayout;
import com.stepstone.stepper.VerificationError;

import java.util.regex.Pattern;

public class ContactPersonFragment extends Fragment implements BlockingStep {

    private TextInputEditText etContactPersonName, etDesignation, etContactNumber, etEmail;

    public ContactPersonFragment() {
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

        View v = inflater.inflate(R.layout.fragment_contact_person, container, false);
        init(v);
        return v;
    }

    private void init(View v) {
        etContactPersonName = v.findViewById(R.id.etContactPersonNameRegistration);
        etDesignation = v.findViewById(R.id.etDesignationMerRegistration);
        etContactNumber = v.findViewById(R.id.etContactNumberMerRegistration);
        etEmail = v.findViewById(R.id.etEmailMerRegistration);
    }

    private Boolean verifyFields(){
        if(TextUtils.isEmpty(etContactPersonName.getText().toString().trim())){
            etContactPersonName.setError("Enter name");
            etContactPersonName.requestFocus();
            return false;
        }else if(TextUtils.isEmpty(etDesignation.getText().toString().trim())){
            etDesignation.setError("Enter designation");
            etDesignation.requestFocus();
            return false;
        }else if(TextUtils.isEmpty(etContactNumber.getText().toString().trim())){
            etContactNumber.setError("Enter contact number");
            etContactNumber.requestFocus();
            return false;
        }else if(TextUtils.isEmpty(etEmail.getText().toString().trim())){
            etEmail.setError("Enter email address");
            etEmail.requestFocus();
            return false;
        }else if(!Patterns.EMAIL_ADDRESS.matcher(etEmail.getText().toString().trim()).matches()){
            etEmail.setError("Enter valid email address");
            etEmail.requestFocus();
            return false;
        }
        return true;
    }

    @Override
    public void onNextClicked(StepperLayout.OnNextClickedCallback callback) {
        if(verifyFields()){
            callback.goToNextStep();
        }
    }

    @Override
    public void onCompleteClicked(StepperLayout.OnCompleteClickedCallback callback) {

    }

    @Override
    public void onBackClicked(StepperLayout.OnBackClickedCallback callback) {
        callback.goToPrevStep();
    }

    @Nullable
    @Override
    public VerificationError verifyStep() {
        return null;
    }

    @Override
    public void onSelected() {
        getActivity().setTitle("Contact Person Details");
    }

    @Override
    public void onError(@NonNull VerificationError error) {

    }
}