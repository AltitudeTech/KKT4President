package com.example.nandom.kkt4president;

import android.Manifest;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class ContactActivity extends AppCompatActivity implements View.OnClickListener, OnMapReadyCallback {

    private CardView mapCardView;
    private LinearLayout telephone1, telephone2, telephone3, email1, email2;
    private ImageView twitter, facebook, instagram, youtube;
    private GoogleMap mMap;
    private Intent fbIntent = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        //Setting up map Activity
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

//        mapCardView = (CardView) findViewById(R.id.card_map_view);
        telephone1 = (LinearLayout) findViewById(R.id.llTelephone1);
        telephone2 = (LinearLayout) findViewById(R.id.llTelephone2);
        telephone3 = (LinearLayout) findViewById(R.id.llTelephone3);
        email1 = (LinearLayout) findViewById(R.id.llEmail1);
        email2 = (LinearLayout) findViewById(R.id.llEmail2);
        twitter = (ImageView) findViewById(R.id.twitterFollow);
        facebook = (ImageView) findViewById(R.id.facebookFollow);
        instagram = (ImageView) findViewById(R.id.igFollow);
        youtube = (ImageView) findViewById(R.id.youtube);


//        mapCardView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent mapIntent = new Intent(ContactActivity.this, MapsActivity.class);
//                startActivity(mapIntent);
//            }
//        });
        telephone1.setOnClickListener(this);
        telephone2.setOnClickListener(this);
        telephone3.setOnClickListener(this);
        email1.setOnClickListener(this);
        email2.setOnClickListener(this);
        twitter.setOnClickListener(this);
        facebook.setOnClickListener(this);
        instagram.setOnClickListener(this);
        youtube.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.llTelephone1:
                Intent intent = new Intent(Intent.ACTION_CALL);

                intent.setData(Uri.parse("tel: 08056544344"));
                if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    // TODO: Consider calling
                    //    ActivityCompat#requestPermissions
                    // here to request the missing permissions, and then overriding
                    //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                    //                                          int[] grantResults)
                    // to handle the case where the user grants the permission. See the documentation
                    // for ActivityCompat#requestPermissions for more details.
                    return;
                }
                this.startActivity(intent);
                break;
            case R.id.llTelephone2:
                Intent telephone2Intent = new Intent(Intent.ACTION_CALL);

                telephone2Intent.setData(Uri.parse("tel: 07045546719"));
                if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    // TODO: Consider calling
                    //    ActivityCompat#requestPermissions
                    // here to request the missing permissions, and then overriding
                    //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                    //                                          int[] grantResults)
                    // to handle the case where the user grants the permission. See the documentation
                    // for ActivityCompat#requestPermissions for more details.
                    return;
                }
                this.startActivity(telephone2Intent);
                break;
            case R.id.llTelephone3:
                Intent telephone3Intent = new Intent(Intent.ACTION_CALL);

                telephone3Intent.setData(Uri.parse("tel: 09035897693"));
                if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    // TODO: Consider calling
                    //    ActivityCompat#requestPermissions
                    // here to request the missing permissions, and then overriding
                    //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                    //                                          int[] grantResults)
                    // to handle the case where the user grants the permission. See the documentation
                    // for ActivityCompat#requestPermissions for more details.
                    return;
                }
                this.startActivity(telephone3Intent);
                break;
            case R.id.llEmail1:
                Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts(
                        "mailto", "info@ktt4president.org", null));
                emailIntent.putExtra(Intent.EXTRA_SUBJECT, "This is my subject text");
                this.startActivity(Intent.createChooser(emailIntent, null));
                break;
            case R.id.llEmail2:
                Intent email2Intent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts(
                        "mailto", "info@ktt4president.org", null));
                email2Intent.putExtra(Intent.EXTRA_SUBJECT, "This is my subject text");
                this.startActivity(Intent.createChooser(email2Intent, null));
                break;
            case R.id.twitterFollow:
//                PackageInfo info = null;
//                try {
//                    info = getPackageManager().getPackageInfo("com.twitter.android", 0);
//                } catch (PackageManager.NameNotFoundException e) {
//                    e.printStackTrace();
//                }
//                if (info.applicationInfo.enabled)
//                    intent = new Intent(Intent.ACTION_VIEW, Uri.parse("twitter://user?user_id=961242674224394241"));
//                else
//                    intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://twitter.com/ktt4president"));
//


//                startActivity(intent);

                Intent twiterIntent = null;
                try {
                    // get the Twitter app if possible
                    this.getPackageManager().getPackageInfo("com.twitter.android", 0);
                    twiterIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("twitter://user?user_id=961242674224394241"));
                    twiterIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                } catch (Exception e) {
                    // no Twitter app, revert to browser
                    twiterIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://twitter.com/ktt4president"));
                }
                this.startActivity(twiterIntent);

                break;
            case R.id.facebookFollow:

//                try {
//                    this.getPackageManager().getPackageInfo("com.facebook.katana", 0);
//                    fbIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("fb://page/1355081672"));
//                } catch (Exception e) {
//                    fbIntent = new Intent(Intent.ACTION_VIEW,Uri.parse("https://web.facebook.com/KTTPRESIDENTAL"));
//                }
                fbIntent = getOpenFacebookIntent(this);
                startActivity(fbIntent);
                break;
            case R.id.igFollow:
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

            case R.id.youtube:
                Intent youtubeIntent=null;
                String url = "https://www.youtube.com/channel/UCj1TZCQkO5RCIoJISzmDiKQ";
                try {
                    youtubeIntent =new Intent(Intent.ACTION_VIEW);
                    youtubeIntent.setPackage("com.google.android.youtube");
                    youtubeIntent.setData(Uri.parse(url));
                    startActivity(youtubeIntent);
                } catch (ActivityNotFoundException e) {
                    youtubeIntent = new Intent(Intent.ACTION_VIEW);
                    youtubeIntent.setData(Uri.parse(url));
                    startActivity(youtubeIntent);
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

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(9.1425078, 7.3168307);
        float zoom = 16;
        mMap.addMarker(new MarkerOptions().position(sydney).title("Altitude Technology Nigeria"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
        mMap.animateCamera(CameraUpdateFactory.zoomTo(15.0f));
    }
}
