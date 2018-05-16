package com.example.nandom.kkt4president.fragments;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.apollographql.apollo.ApolloCall;
import com.apollographql.apollo.CustomTypeAdapter;
import com.apollographql.apollo.api.Response;
import com.apollographql.apollo.exception.ApolloException;
import com.example.nandom.kkt4president.CreateVoteMutation;
import com.example.nandom.kkt4president.KttvVideosQuery;
import com.example.nandom.kkt4president.LastPollsQuery;
import com.example.nandom.kkt4president.MainActivity;
import com.example.nandom.kkt4president.PhoneVerification;
import com.example.nandom.kkt4president.R;
import com.example.nandom.kkt4president.apollographql.MyApolloClient;
import com.example.nandom.kkt4president.classes.SlideAnimationUtil;

import java.util.regex.Pattern;

import javax.annotation.Nonnull;

import pl.droidsonroids.gif.GifImageView;
import type.EnumPollVoteVote;
import type.CustomType;

public class QuestionFragment extends Fragment {

    public QuestionFragment() {
        // Required empty public constructor
    }

    private RadioGroup rgOption;
    private RadioButton selectedOption, rbOption1, rbOption2, rbOption3, rbOption4;
    private Button bSubmit;
    private EditText etSurvey;
    private TextView tvQuestion;
    private double AtotalVotes, AVotesa, AVotesb, AVotesc, AVotesd;
    private double BtotalVotes, BVotesa, BVotesb, BVotesc, BVotesd;
    GifImageView loadingGif;
    private ScrollView svLayout;
    private TextInputLayout phoneLayout;

    private String recordId, anotherThing;

    private EnumPollVoteVote voteOption;

    private CustomTypeAdapter mongoId;

    private String selectionLetter;
    private String phone;

    private String Aquestion1, AoptionA, AoptionB, AoptionC, AoptionD, AquestionId;
    private String Bquestion1, BoptionA, BoptionB, BoptionC, BoptionD, BquestionId;
    private String AtagLine1, AtagLine2, AtagLine3, AtagLine4;
    private String BtagLine1, BtagLine2, BtagLine3, BtagLine4;

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
        tvQuestion = (TextView) view.findViewById(R.id.tvQuestion);
        rbOption1 = (RadioButton) view.findViewById(R.id.option1);
        rbOption2 = (RadioButton) view.findViewById(R.id.option2);
        rbOption3 = (RadioButton) view.findViewById(R.id.option3);
        rbOption4 = (RadioButton) view.findViewById(R.id.option4);

        phoneLayout = (TextInputLayout) view.findViewById(R.id.textInputLayout);

        svLayout = (ScrollView) view.findViewById(R.id.svLayout);

        loadingGif = (GifImageView) view.findViewById(R.id.loadingGif);

        bSubmit.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceType")
            @Override
            public void onClick(View v) {
                int selectedId = rgOption.getCheckedRadioButtonId();

                phone = etSurvey.getText().toString();

                selectedOption = (RadioButton) view.findViewById(selectedId);

                if (rgOption.getCheckedRadioButtonId() == -1) {
                    phoneLayout.setError("You must select an option");
                    phoneLayout.setErrorTextAppearance(R.color.darker_red);

                }

                if (rgOption.getCheckedRadioButtonId() != -1 && isValidPhone(phone)) {
//

                    if (rgOption.getCheckedRadioButtonId() == 2131361998) {
                        voteOption = EnumPollVoteVote.a;
                    } else if (rgOption.getCheckedRadioButtonId() == 2131361999) {
                        voteOption = EnumPollVoteVote.b;
                    } else if (rgOption.getCheckedRadioButtonId() == 2131362000) {
                        voteOption = EnumPollVoteVote.c;
                    } else if (rgOption.getCheckedRadioButtonId() == 2131362001) {
                        voteOption = EnumPollVoteVote.d;
                    }

                    System.out.println("Option Id:" + rgOption.getCheckedRadioButtonId() + "");

                    createVote();

                } else if (rgOption.getCheckedRadioButtonId() != -1 && !isValidPhone(phone)) {
                    phoneLayout.setError("You must enter a valid phone number");
                }
            }
        });


        etSurvey.addTextChangedListener(textActivityWatcher);

        // Inflate the layout for this fragment
        getLastPoll();
        return view;
    }

    private final TextWatcher textActivityWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int begin, int last, int count) {

            if (begin == 11) {
                phoneLayout.setError("");
            }
        }

        @Override
        public void afterTextChanged(Editable editable) {

            if (etSurvey.length() == 0) {
                phoneLayout.setError("You must enter phone number");
            } else if (etSurvey.length() > 0) {
                phoneLayout.setError("");
            }

        }
    };

    public void getLastPoll() {

        MyApolloClient.getMyApolloClient().query(LastPollsQuery.builder().build()).enqueue(new ApolloCall.Callback<LastPollsQuery.Data>() {
            @Override
            public void onResponse(@Nonnull Response<LastPollsQuery.Data> response) {

                Aquestion1 = response.data().lastPolls().get(0).title().toString();
                AtotalVotes = response.data().lastPolls().get(0).totalVotes();

                AtagLine1 = response.data().lastPolls().get(0).option1().tagLine();
                AtagLine2 = response.data().lastPolls().get(0).option2().tagLine();
                AtagLine3 = response.data().lastPolls().get(0).option3().tagLine();
                AtagLine4 = response.data().lastPolls().get(0).option4().tagLine();

                AVotesa = response.data().lastPolls().get(0).aVotes();
                AVotesb = response.data().lastPolls().get(0).bVotes();
                AVotesc = response.data().lastPolls().get(0).cVotes();
                AVotesd = response.data().lastPolls().get(0).dVotes();

                AoptionA = response.data().lastPolls().get(0).option1().text();
                AoptionB = response.data().lastPolls().get(0).option2().text();
                AoptionC = response.data().lastPolls().get(0).option3().text();
                AoptionD = response.data().lastPolls().get(0).option4().text();
                AoptionD = response.data().lastPolls().get(0).option4().text();

                AquestionId = response.data().lastPolls().get(0).id();

                Bquestion1 = response.data().lastPolls().get(1).title().toString();
                BtotalVotes = response.data().lastPolls().get(1).totalVotes();

                BtagLine1 = response.data().lastPolls().get(1).option1().tagLine();
                BtagLine2 = response.data().lastPolls().get(1).option2().tagLine();
                BtagLine3 = response.data().lastPolls().get(1).option3().tagLine();
                BtagLine4 = response.data().lastPolls().get(1).option4().tagLine();

                BVotesa = response.data().lastPolls().get(1).aVotes();
                BVotesb = response.data().lastPolls().get(1).bVotes();
                BVotesc = response.data().lastPolls().get(1).cVotes();
                BVotesd = response.data().lastPolls().get(1).dVotes();

                BoptionA = response.data().lastPolls().get(1).option1().text();
                BoptionB = response.data().lastPolls().get(1).option2().text();
                BoptionC = response.data().lastPolls().get(1).option3().text();
                BoptionD = response.data().lastPolls().get(1).option4().text();

                BquestionId = response.data().lastPolls().get(1).id();


                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        loadingGif.setVisibility(View.GONE);
                        svLayout.setVisibility(View.VISIBLE);

                        System.out.println("question Id:" + AquestionId);
                        tvQuestion.setText(Aquestion1);
                        rbOption1.setText(AoptionA);
                        rbOption2.setText(AoptionB);
                        rbOption3.setText(AoptionC);
                        rbOption4.setText(AoptionD);
                    }
                });
            }

            @Override
            public void onFailure(@Nonnull final ApolloException e) {

                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(getContext(), "Nothing is working" + e, Toast.LENGTH_LONG).show();
                        System.out.println("something " + e);
                    }
                });
            }
        });
    }

    private boolean isValidPhone(String phone) {

        boolean check;

        if (phone.isEmpty()) {
            check = false;
        } else {

            if (!Pattern.matches("[a-zA-Z]+", phone)) {
                if (phone.length() == 11) {
                    check = true;

                } else {
                    check = false;

                }
            } else {
                check = false;
            }
        }
        return check;
    }

    public void createVote() {

        String phoneNumber = etSurvey.getText().toString();
        String questionId = AquestionId;

        MyApolloClient.getMyApolloClient().mutate(
                CreateVoteMutation.builder()
                        .phoneNumber(phoneNumber)
                        .poll(questionId)
                        .vote(voteOption).build())
                .enqueue(new ApolloCall.Callback<CreateVoteMutation.Data>() {
                    @Override
                    public void onResponse(@Nonnull Response<CreateVoteMutation.Data> response) {

                        recordId = null;
                        try {
                            recordId = response.data().pollVoteCreate().recordId().toString();
                        } catch (Exception e) {
                            Log.d("QuestionFragment", e + " ");
                        }

                        getActivity().runOnUiThread(new Runnable() {
                            @Override
                            public void run() {

//                                Toast.makeText(getContext(), recordId, Toast.LENGTH_SHORT).show();
//                                System.out.println("Record Id"+ recordId);

                                if (recordId == null) {
                                    phoneLayout.setError("This number has already been used");
                                } else {
                                    Intent verifyPhoneIntent = new Intent(getActivity(), PhoneVerification.class);
                                    verifyPhoneIntent.putExtra("phone", phone);
                                    startActivity(verifyPhoneIntent);
                                    getActivity().overridePendingTransition(R.anim.slide_from_right, R.anim.slide_to_left);
                                }
                            }
                        });
                    }

                    @Override
                    public void onFailure(@Nonnull ApolloException e) {
                        System.out.println("This thing has failed ooo");


                    }
                });

    }

}