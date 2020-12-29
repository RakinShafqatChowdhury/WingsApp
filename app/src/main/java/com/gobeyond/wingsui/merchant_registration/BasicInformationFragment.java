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
import android.widget.RadioGroup;
import android.widget.Toast;

import com.gobeyond.wingsui.R;
import com.google.android.material.textfield.TextInputEditText;
import com.stepstone.stepper.BlockingStep;
import com.stepstone.stepper.StepperLayout;
import com.stepstone.stepper.VerificationError;

public class BasicInformationFragment extends Fragment implements BlockingStep {

    private TextInputEditText etMerchantName, etAddress, etProductNature, etWebsite, etFacebookPage, etCompanyPhone;
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
        etMerchantName = v.findViewById(R.id.etNameMerRegistration);
        etAddress = v.findViewById(R.id.etAddressMerRegistration);
        etProductNature = v.findViewById(R.id.etProductNatureMerRegistration);
        etWebsite = v.findViewById(R.id.etWebsiteMerRegistration);
        etFacebookPage = v.findViewById(R.id.etFacebookPageMerRegistration);
        etCompanyPhone = v.findViewById(R.id.etCompanyPhoneMerRegistration);
        radioGroupBusinessType = v.findViewById(R.id.rg_business_type);
    }

    private Boolean verifyFields(){
        if(TextUtils.isEmpty(etMerchantName.getText().toString().trim())){
            etMerchantName.setError("Enter merchant name");
            etMerchantName.requestFocus();
            return false;
        }else if(TextUtils.isEmpty(etAddress.getText().toString().trim())){
            etAddress.setError("Enter merchant address");
            etAddress.requestFocus();
            return false;
        }else if(TextUtils.isEmpty(etProductNature.getText().toString().trim())){
            etProductNature.setError("Enter product nature");
            etProductNature.requestFocus();
            return false;
        }else if(TextUtils.isEmpty(etWebsite.getText().toString().trim())){
            etWebsite.setError("Enter website address");
            etWebsite.requestFocus();
            return false;
        }else if(TextUtils.isEmpty(etFacebookPage.getText().toString().trim())){
            etFacebookPage.setError("Enter facebook page");
            etFacebookPage.requestFocus();
            return false;
        }else if(TextUtils.isEmpty(etCompanyPhone.getText().toString().trim())){
            etCompanyPhone.setError("Enter phone number");
            etCompanyPhone.requestFocus();
            return false;
        }else if(radioGroupBusinessType.getCheckedRadioButtonId()==-1){
            Toast.makeText(requireActivity(), "Select business type", Toast.LENGTH_SHORT).show();
            return false;
        }else if(!Patterns.WEB_URL.matcher(etWebsite.getText().toString().trim()).matches()){
            etWebsite.setError("Enter valid web address");
            etWebsite.requestFocus();
            return false;
        }
        return true;
    }

    @Override
    public void onNextClicked(StepperLayout.OnNextClickedCallback callback) {
        if(verifyFields()) {
            callback.goToNextStep();
        }
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