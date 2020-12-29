package com.gobeyond.wingsui.merchant_registration;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gobeyond.wingsui.R;
import com.google.android.material.textfield.TextInputEditText;
import com.stepstone.stepper.BlockingStep;
import com.stepstone.stepper.StepperLayout;
import com.stepstone.stepper.VerificationError;

public class ContactPersonFragment extends Fragment implements BlockingStep {

    private TextInputEditText contactPersonName, designation, contactNumber, email;

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
        contactPersonName = v.findViewById(R.id.etContactPersonNameRegistration);
        designation = v.findViewById(R.id.etDesignationMerRegistration);
        contactNumber = v.findViewById(R.id.etContactNumberMerRegistration);
        email = v.findViewById(R.id.etEmailMerRegistration);
    }

    private Boolean verifyFields(){
        if(TextUtils.isEmpty(contactPersonName.getText().toString().trim())){
            contactPersonName.setError("Enter name");
            contactPersonName.requestFocus();
            return false;
        }else if(TextUtils.isEmpty(designation.getText().toString().trim())){
            designation.setError("Enter designation");
            designation.requestFocus();
            return false;
        }else if(TextUtils.isEmpty(contactNumber.getText().toString().trim())){
            contactNumber.setError("Enter contact number");
            contactNumber.requestFocus();
            return false;
        }else if(TextUtils.isEmpty(email.getText().toString().trim())){
            email.setError("Enter email address");
            email.requestFocus();
            return false;
        }
        return true;
    }

    @Override
    public void onNextClicked(StepperLayout.OnNextClickedCallback callback) {
        if(verifyFields()){
            callback.goToNextStep();
        }
        callback.goToNextStep();

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