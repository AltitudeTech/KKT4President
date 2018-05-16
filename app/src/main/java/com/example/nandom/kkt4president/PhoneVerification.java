package com.example.nandom.kkt4president;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Animatable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class PhoneVerification extends AppCompatActivity {

    private TextView tvPhoneNumber, tvEditPhoneNumber;
    private EditText etVerificationCode;
    private Button bVerify;
    private Button dismiss;
    private String phone;
    private Dialog verificationDialog;
    private ImageView mImgCheck;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone_verification);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);


        tvPhoneNumber = (TextView) findViewById(R.id.tvPhoneNumber);
        tvEditPhoneNumber = (TextView) findViewById(R.id.tvEditPhoneNumber);
        etVerificationCode = (EditText) findViewById(R.id.etVerificationCode);
        bVerify = (Button) findViewById(R.id.bVerify);

        Bundle bundle = getIntent().getExtras();
        phone = bundle.getString("phone");

        tvPhoneNumber.setText(phone);

        tvEditPhoneNumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent surveryIntent = new Intent(PhoneVerification.this, OnlineSurvey.class);
                startActivity(surveryIntent);
            }
        });

        bVerify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                showLicense();

            }
        });

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

        navigateUpTo(getIntent());

    }

    private void showLicense() {
        verificationDialog = new Dialog(PhoneVerification.this);
        verificationDialog.setTitle("Phone Verification");
        verificationDialog.setContentView(R.layout.phone_verified_success_dialog);
        verificationDialog.setCanceledOnTouchOutside(false);
        verificationDialog.getWindow().setWindowAnimations(R.style.DialogWindowTitle);
        verificationDialog.show();

        mImgCheck = (ImageView) verificationDialog.findViewById(R.id.checkImageView);
        ((Animatable) mImgCheck.getDrawable()).start();

        dismiss = (Button) verificationDialog.findViewById(R.id.dismiss);
        dismiss.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                verificationDialog.dismiss();
            }
        });
    }
}
