package com.example.nandom.kkt4president.fragments;

import android.annotation.SuppressLint;
import android.app.DialogFragment;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.nandom.kkt4president.MainActivity;
import com.example.nandom.kkt4president.R;

import org.w3c.dom.Text;

/**
 * Created by Nandom on 3/9/2018.
 */
@SuppressLint("ValidFragment")
public class LicenseDialog extends DialogFragment {

    private TextView tvTitle;
    private Button bDismiss;

    public LicenseDialog(MainActivity mainActivity, int pauseDialog) {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.license_information_dialog, container, false);
        getDialog().setCanceledOnTouchOutside(false);
        getDialog().setCancelable(true);
        getDialog().setTitle("License Information");

        tvTitle = (TextView) rootView.findViewById(R.id.title);

        String altitude = " Altitude Technology";

        String title = getText(R.string.powered_by_altitude_technology) +""+ altitude;

        Spannable spannable = new SpannableString(title);

        spannable.setSpan(new ForegroundColorSpan(Color.parseColor("#dc3545")), getText(R.string.powered_by_altitude_technology).length(), (title).length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

        tvTitle.setText(spannable, TextView.BufferType.SPANNABLE);

        bDismiss.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getDialog().dismiss();
            }
        });

        return rootView;
    }
}