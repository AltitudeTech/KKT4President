package com.example.nandom.kkt4president.fragments;


import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.nandom.kkt4president.R;

import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class AboutFragment extends Fragment implements View.OnClickListener {

    private ImageView aboutFacebook, aboutTweeter, aboutInstagram;
    private Intent fbIntent;

    public static AboutFragment newInstance() {
        // Required empty public constructor
        AboutFragment fragment = new AboutFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_about, container, false);

        aboutFacebook = (ImageView) view.findViewById(R.id.iv_about_fb);
        aboutTweeter = (ImageView) view.findViewById(R.id.iv_about_tweeter);
        aboutInstagram = (ImageView) view.findViewById(R.id.iv_about_ig);

        aboutFacebook.setOnClickListener(this);
        aboutTweeter.setOnClickListener(this);
        aboutInstagram.setOnClickListener(this);
        ButterKnife.bind(getActivity());



        return view;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_about_fb:
                fbIntent = getOpenFacebookIntent(getContext());
                startActivity(fbIntent);
                break;
            case R.id.iv_about_tweeter:
                Intent twiterIntent = null;
                try {
                    // get the Twitter app if possible
                    getContext().getPackageManager().getPackageInfo("com.twitter.android", 0);
                    twiterIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("twitter://user?user_id=961242674224394241"));
                    twiterIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                } catch (Exception e) {
                    // no Twitter app, revert to browser
                    twiterIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://twitter.com/ktt4president"));
                }
                this.startActivity(twiterIntent);

                break;
            case R.id.iv_about_ig:

                Uri uri = Uri.parse("http://instagram.com/_u/KTTPRESIDENTIAL");
                Intent likeIng = new Intent(Intent.ACTION_VIEW, uri);

                likeIng.setPackage("com.instagram.android");

                try {
                    startActivity(likeIng);
                } catch (ActivityNotFoundException e) {
                    startActivity(new Intent(Intent.ACTION_VIEW,
                            Uri.parse("http://instagram.com/KTTPRESIDENTIAL")));
                }


                break;
        }
    }

    public static Intent getOpenFacebookIntent(Context context) {

        try {
            context.getPackageManager()
                    .getPackageInfo("com.facebook.katana", 0); //Checks if FB is even installed.
            return new Intent(Intent.ACTION_VIEW,
                    Uri.parse("fb://profile/100024389583308")); //Trys to make intent with FB's URI
        } catch (Exception e) {
            return new Intent(Intent.ACTION_VIEW,
                    Uri.parse("https://www.facebook.com/KTTPRESIDENTAL")); //catches and opens a url to the desired page
        }
    }
}
