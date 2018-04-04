package com.example.nandom.kkt4president.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.nandom.kkt4president.R;


public class QuestionFragment extends Fragment {

    public QuestionFragment() {
        // Required empty public constructor
    }

    private RadioGroup rgOption;
    private RadioButton selectedOption;
    private Button bSubmit;
    private EditText etSurvey;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_question, container, false);

        rgOption = (RadioGroup) view.findViewById(R.id.rgOption);
        bSubmit = (Button) view.findViewById(R.id.bSubmit);
        etSurvey = (EditText) view.findViewById(R.id.etSurveyPhone);

        bSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedId = rgOption.getCheckedRadioButtonId();

                String phone = etSurvey.getText().toString();

                selectedOption = (RadioButton) view.findViewById(selectedId);

                if (rgOption.getCheckedRadioButtonId() == -1)
                    Toast.makeText(getContext(), "Please select an answer from the Option", Toast.LENGTH_LONG).show();
                else {
                    Toast.makeText(getContext(), selectedOption.getText().toString(), Toast.LENGTH_LONG).show();
                }

                if (phone.isEmpty()) {
                    Toast.makeText(getContext(), "Please Enter phone number to Submit Polls", Toast.LENGTH_LONG).show();
                }

                if (rgOption.getCheckedRadioButtonId() != -1 && !phone.isEmpty()) {
                    Toast.makeText(getContext(), "Succesfully submitted Polls", Toast.LENGTH_SHORT).show();
                }
            }
        });
        // Inflate the layout for this fragment
        return view;
    }

}