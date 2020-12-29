package com.gobeyond.wingsui.merchant_registration;

import android.graphics.Paint;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.gobeyond.wingsui.R;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.stepstone.stepper.BlockingStep;
import com.stepstone.stepper.StepperLayout;
import com.stepstone.stepper.VerificationError;

public class PaymentInformationFragment extends Fragment implements BlockingStep {

    private RadioGroup radioGroupPaymentMethod;
    private String selectedPaymentMethod = "";
    private TextInputEditText etAccName, etAccNumber, etBank, etBranch, etRoutingNumber;
    private TextInputLayout bankTIL, branchTIL, routingNumTIL;

    public PaymentInformationFragment() {
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
        View v = inflater.inflate(R.layout.fragment_payment_information, container, false);
        init(v);
        return v;
    }

    private void init(View v) {
        radioGroupPaymentMethod = v.findViewById(R.id.rg_payment_method);
        etAccName = v.findViewById(R.id.etAccNameMerRegistration);
        etAccNumber = v.findViewById(R.id.etAccNumMerRegistration);
        etBank = v.findViewById(R.id.etBankNameMerRegistration);
        etBranch = v.findViewById(R.id.etBranchMerRegistration);
        etRoutingNumber = v.findViewById(R.id.etRoutingNumRegistration);

        bankTIL = v.findViewById(R.id.tilBankNameMerRegistration);
        branchTIL = v.findViewById(R.id.tilBranchMerRegistration);
        routingNumTIL = v.findViewById(R.id.tilRoutingNumRegistration);


    }

    private void activeEditTexts(String selectedPaymentMethod) {
        switch (selectedPaymentMethod){
            case "Bkash":
            case "Rocket":
            case "Nagad":
            case "Cheque":
                etAccName.setEnabled(true);
                etAccNumber.setEnabled(true);
                etBank.setEnabled(false);
                etBranch.setEnabled(false);
                etRoutingNumber.setEnabled(false);
                bankTIL.setBackgroundColor(getResources().getColor(R.color.grey_200));
                branchTIL.setBackgroundColor(getResources().getColor(R.color.grey_200));
                routingNumTIL.setBackgroundColor(getResources().getColor(R.color.grey_200));
                etBank.setPaintFlags(etBank.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
                etBranch.setPaintFlags(etBank.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
                etRoutingNumber.setPaintFlags(etBank.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
                break;
            case "Bank":
                etAccName.setEnabled(true);
                etAccNumber.setEnabled(true);
                etBank.setEnabled(true);
                etBranch.setEnabled(true);
                etRoutingNumber.setEnabled(true);

                bankTIL.setBackgroundColor(getResources().getColor(R.color.white));
                branchTIL.setBackgroundColor(getResources().getColor(R.color.white));
                routingNumTIL.setBackgroundColor(getResources().getColor(R.color.white));

                etBank.setPaintFlags(etBank.getPaintFlags() & (~Paint.STRIKE_THRU_TEXT_FLAG));
                etBranch.setPaintFlags(etBank.getPaintFlags() & (~Paint.STRIKE_THRU_TEXT_FLAG));
                etRoutingNumber.setPaintFlags(etBank.getPaintFlags() & (~Paint.STRIKE_THRU_TEXT_FLAG));
                break;

        }
    }

    private Boolean verifyFields(String paymentMethod){
        if(paymentMethod.matches("Bkash") || paymentMethod.matches("Rocket") || paymentMethod.matches("Nagad") || paymentMethod.matches("Cheque")){
            if(etAccName.getText().toString().trim().isEmpty()){
                etAccName.setError("Enter account name");
                etAccName.requestFocus();
                return false;
            }else if(etAccNumber.getText().toString().trim().isEmpty()){
                etAccNumber.setError("Enter account number");
                etAccNumber.requestFocus();
                return false;
            }
        }else if(paymentMethod.matches("Bank")){
            if(etAccName.getText().toString().trim().isEmpty()){
                etAccName.setError("Enter account name");
                etAccName.requestFocus();
                return false;
            }else if(etAccNumber.getText().toString().trim().isEmpty()){
                etAccNumber.setError("Enter account number");
                etAccNumber.requestFocus();
                return false;
            }else if(etBank.getText().toString().trim().isEmpty()){
                etBank.setError("Enter bank name");
                etBank.requestFocus();
                return false;
            }else if(etBranch.getText().toString().trim().isEmpty()){
                etBranch.setError("Enter bank name");
                etBranch.requestFocus();
                return false;
            }else if(etRoutingNumber.getText().toString().trim().isEmpty()){
                etRoutingNumber.setError("Enter bank name");
                etRoutingNumber.requestFocus();
                return false;
            }
        }
        else {
            Toast.makeText(requireActivity(), "Select payment method", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    @Override
    public void onNextClicked(StepperLayout.OnNextClickedCallback callback) {

    }

    @Override
    public void onCompleteClicked(StepperLayout.OnCompleteClickedCallback callback) {

        if(verifyFields(selectedPaymentMethod)){
            Toast.makeText(requireActivity(), "Done", Toast.LENGTH_SHORT).show();
        }
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
        getActivity().setTitle("Payment Information");

        radioGroupPaymentMethod.setOnCheckedChangeListener((group, checkedId) -> {
            RadioButton radioButton = radioGroupPaymentMethod.findViewById(checkedId);
            selectedPaymentMethod = radioButton.getText().toString();
            activeEditTexts(selectedPaymentMethod);
        });


    }

    @Override
    public void onError(@NonNull VerificationError error) {

    }
}