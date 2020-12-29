package com.gobeyond.wingsui.merchant_registration;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.gobeyond.wingsui.R;
import com.google.android.material.textfield.TextInputEditText;
import com.stepstone.stepper.BlockingStep;
import com.stepstone.stepper.StepperLayout;
import com.stepstone.stepper.VerificationError;

public class BasicInformationFragment extends Fragment implements BlockingStep {

    private TextInputEditText merchantName, address, productNature, website, facebookPage, companyPhone;
    private RadioGroup radioGroupBusinessType;

    public BasicInformationFragment() {
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

        View v = inflater.inflate(R.layout.fragment_basic_information, container, false);
        init(v);
        return v;
    }

    private void init(View v) {
        merchantName = v.findViewById(R.id.etNameMerRegistration);
        address = v.findViewById(R.id.etAddressMerRegistration);
        productNature = v.findViewById(R.id.etProductNatureMerRegistration);
        website = v.findViewById(R.id.etWebsiteMerRegistration);
        facebookPage = v.findViewById(R.id.etFacebookPageMerRegistration);
        companyPhone = v.findViewById(R.id.etCompanyPhoneMerRegistration);
        radioGroupBusinessType = v.findViewById(R.id.rg_business_type);
    }

    private Boolean verifyFields(){
        if(TextUtils.isEmpty(merchantName.getText().toString().trim())){
            merchantName.setError("Enter merchant name");
            merchantName.requestFocus();
            return false;
        }else if(TextUtils.isEmpty(address.getText().toString().trim())){
            address.setError("Enter merchant address");
            address.requestFocus();
            return false;
        }else if(TextUtils.isEmpty(productNature.getText().toString().trim())){
            productNature.setError("Enter product nature");
            productNature.requestFocus();
            return false;
        }else if(TextUtils.isEmpty(website.getText().toString().trim())){
            website.setError("Enter website address");
            website.requestFocus();
            return false;
        }else if(TextUtils.isEmpty(facebookPage.getText().toString().trim())){
            facebookPage.setError("Enter facebook page");
            facebookPage.requestFocus();
            return false;
        }else if(TextUtils.isEmpty(companyPhone.getText().toString().trim())){
            companyPhone.setError("Enter phone number");
            companyPhone.requestFocus();
            return false;
        }else if(radioGroupBusinessType.getCheckedRadioButtonId()==-1){
            Toast.makeText(requireActivity(), "Select business type", Toast.LENGTH_SHORT).show();
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

    }

    @Nullable
    @Override
    public VerificationError verifyStep() {
        return null;
    }

    @Override
    public void onSelected() {
        getActivity().setTitle("Basic Information");
    }

    @Override
    public void onError(@NonNull VerificationError error) {

    }
}