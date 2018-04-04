package com.example.nandom.kkt4president;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.nandom.kkt4president.fragments.AboutFragment;
import com.example.nandom.kkt4president.fragments.EventsFragment;
import com.example.nandom.kkt4president.fragments.GalleryFragment;
import com.example.nandom.kkt4president.fragments.GalleryMainFragment;
import com.example.nandom.kkt4president.fragments.HomeFragment;
import com.example.nandom.kkt4president.fragments.NewsMainFragment;

import java.io.File;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private TextView mTextMessage;
    private Button button;

    private String fragmentStatus;
    private FragmentTransaction transaction;
    private Fragment selectedFragment = null;

    private BottomNavigationView bottomNavigationView;
    boolean doubleBackToExitPressedOnce = false;
    private Button dismiss;
    private Dialog pauseDialog;
    static final int CUSTOM_DIALOG_ID = 0;


    @RequiresApi(api = Build.VERSION_CODES.M)
    @SuppressLint("ResourceAsColor")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        fragmentStatus = "home";

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        bottomNavigationView = (BottomNavigationView) findViewById(R.id.navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                selectedFragment = null;
                switch (item.getItemId()) {
                    case R.id.navigation_home:
                        selectedFragment = HomeFragment.newInstance();
                        fragmentStatus = "home";
                        break;
                    case R.id.navigation_news:
                        selectedFragment = NewsMainFragment.newInstance();
                        fragmentStatus = "news";
                        break;
                    case R.id.navigation_gallery:
                        selectedFragment = GalleryMainFragment.newInstance();
                        fragmentStatus = "gallery";
                        break;
                    case R.id.navigation_about:
                        selectedFragment = AboutFragment.newInstance();
                        fragmentStatus = "about";
                        break;
                }
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.frame_layout, selectedFragment);
                transaction.commit();
                return true;
            }
        });
        //Manually displaying the first fragment - one time only
        transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_layout, HomeFragment.newInstance());
        transaction.commit();

        dismiss = (Button) findViewById(R.id.dismiss);

    }

    public static void setBadgeCount(Context context, LayerDrawable icon, String count) {

        BadgeDrawable badge;

        // Reuse drawable if possible
        Drawable reuse = icon.findDrawableByLayerId(R.id.ic_badge);
        if (reuse != null && reuse instanceof BadgeDrawable) {
            badge = (BadgeDrawable) reuse;
        } else {
            badge = new BadgeDrawable(context);
        }

        badge.setCount(count);
        icon.mutate();
        icon.setDrawableByLayerId(R.id.ic_badge, badge);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);

        MenuItem itemCart = menu.findItem(R.id.action_notifications);
        LayerDrawable icon = (LayerDrawable) itemCart.getIcon();
        setBadgeCount(this, icon, "1");

        return true;
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {

            if (doubleBackToExitPressedOnce) {
                super.onBackPressed();
                return;
            } else {
                if (!fragmentStatus.contentEquals("home")) {
                    bottomNavigationView.setSelectedItemId(R.id.navigation_home);
                    selectedFragment = HomeFragment.newInstance();
                    FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                    transaction.replace(R.id.frame_layout, selectedFragment);
                    transaction.commit();
                    this.doubleBackToExitPressedOnce = false;
                } else {

                    this.doubleBackToExitPressedOnce = true;
                    Toast.makeText(this, "Please click BACK again to exit", Toast.LENGTH_SHORT).show();

                    new Handler().postDelayed(new Runnable() {

                        @Override
                        public void run() {
                            doubleBackToExitPressedOnce = false;
                        }
                    }, 2000);
                }
            }
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
//            FragmentManager fm = getFragmentManager();
//            LicenseDialog dialogFragment = new LicenseDialog(this, R.style.PauseDialog);
//            dialogFragment.show(fm, "License Information");

            showLicense();


//            dismiss.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    pauseDialog.dismiss();
//                }
//            });

            return true;
        }
        if (id == R.id.action_notifications) {
            Intent notificationIntent = new Intent(MainActivity.this, OnlineSurvey.class);
            startActivity(notificationIntent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void showLicense() {
        pauseDialog = new Dialog(MainActivity.this, R.style.PauseDialog);
        pauseDialog.setTitle("License Iinformation");
        pauseDialog.setContentView(R.layout.license_information_dialog);
        pauseDialog.setCanceledOnTouchOutside(false);
        pauseDialog.show();

        TextView tvTitle = (TextView) pauseDialog.findViewById(R.id.title);

        String altitude = " Altitude Technology";

        String title = getText(R.string.powered_by_altitude_technology) + "" + altitude;

        Spannable spannable = new SpannableString(title);

        spannable.setSpan(new ForegroundColorSpan(Color.parseColor("#dc3545")), getText(R.string.powered_by_altitude_technology).length(), (title).length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

        tvTitle.setText(spannable, TextView.BufferType.SPANNABLE);

        dismiss = (Button) pauseDialog.findViewById(R.id.dismiss);
        dismiss.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pauseDialog.dismiss();
            }
        });
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        Fragment selectedFragment = null;
        FragmentTransaction transaction = null;
        if (id == R.id.nav_ktt_television) {
            Intent ktttvIntent = new Intent(MainActivity.this, KTTTelevision.class);
            startActivity(ktttvIntent);

        } else if (id == R.id.nav_home) {
            bottomNavigationView.setSelectedItemId(R.id.navigation_home);
            selectedFragment = HomeFragment.newInstance();
            transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.frame_layout, selectedFragment);
            transaction.commit();

        } else if (id == R.id.nav_news) {
            bottomNavigationView.setSelectedItemId(R.id.navigation_news);
            selectedFragment = NewsMainFragment.newInstance();
            transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.frame_layout, selectedFragment);
            transaction.commit();

        } else if (id == R.id.nav_you_first) {

            Intent youFirstIntent = new Intent(MainActivity.this, YOUFIRST.class);
            startActivity(youFirstIntent);

        } else if (id == R.id.nav_upcoming_events) {
            Intent eventsIntent = new Intent(MainActivity.this, Events.class);
            startActivity(eventsIntent);

        } else if (id == R.id.your_opinion) {
            Intent opinionIntent = new Intent(MainActivity.this, OnlineSurvey.class);
            startActivity(opinionIntent);

        } else if (id == R.id.nav_about_ktt) {
//            bottomNavigationView.setSelectedItemId(R.id.navigation_about);
            selectedFragment = AboutFragment.newInstance();
            transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.frame_layout, selectedFragment);
            transaction.commit();

        }
//        else if (id == R.id.nav_endorsement) {
//
//            Intent endorsements = new Intent(MainActivity.this, Endorse.class);
//            startActivity(endorsements);
//
//        }
        else if (id == R.id.nav_gallery) {
            bottomNavigationView.setSelectedItemId(R.id.navigation_gallery);
            selectedFragment = GalleryMainFragment.newInstance();
            transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.frame_layout, selectedFragment);
            transaction.commit();

        } else if (id == R.id.nav_contact) {
            Intent contactIntent = new Intent(MainActivity.this, ContactActivity.class);
            startActivity(contactIntent);

        } else if (id == R.id.nav_share) {
            ApplicationInfo api = getApplicationContext().getApplicationInfo();
            String apkFile = api.sourceDir;

            Intent intent = new Intent(android.content.Intent.ACTION_SEND);
            intent.setType("application/vnd.android.package-archive");
            intent.putExtra(intent.EXTRA_STREAM, Uri.fromFile(new File(apkFile)));

            startActivity(Intent.createChooser(intent, "Share App Using..."));

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
