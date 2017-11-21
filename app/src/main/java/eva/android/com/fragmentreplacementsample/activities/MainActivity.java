package eva.android.com.fragmentreplacementsample.activities;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import eva.android.com.fragmentreplacementsample.R;
import eva.android.com.fragmentreplacementsample.fragments.CameraFragment;
import eva.android.com.fragmentreplacementsample.fragments.GalleryFragment;
import eva.android.com.fragmentreplacementsample.fragments.ManageFragment;
import eva.android.com.fragmentreplacementsample.fragments.SendFragment;
import eva.android.com.fragmentreplacementsample.fragments.ShareFragment;
import eva.android.com.fragmentreplacementsample.fragments.SlideShowFragment;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    Toolbar toolbar;
    DrawerLayout drawer;
    Fragment cameraFragment;
    Fragment sendFragment;
    Fragment shareFragment;
    Fragment managerFragment;
    Fragment slideshowFragment;
    Fragment galleryFragment;
    FragmentTransaction fTrans;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        cameraFragment = new CameraFragment();
        sendFragment = new SendFragment();
        shareFragment = new ShareFragment();
        managerFragment = new ManageFragment();
        slideshowFragment = new SlideShowFragment();
        galleryFragment = new GalleryFragment();

        fTrans = getFragmentManager().beginTransaction();
        fTrans.replace(R.id.frame_layout, cameraFragment).commit();
        toolbar.setTitle("Import");
    }

    @Override
    public void onBackPressed() {

        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        fTrans = getFragmentManager().beginTransaction();
        switch (item.getItemId()) {
            case R.id.nav_camera:
                toolbar.setTitle("Import");
                fTrans.replace(R.id.frame_layout, cameraFragment);
                break;
            case R.id.nav_gallery:
                toolbar.setTitle("Gallery");
                fTrans.replace(R.id.frame_layout, galleryFragment);
                break;
            case R.id.nav_slideshow:
                toolbar.setTitle("Slideshow");
                fTrans.replace(R.id.frame_layout, slideshowFragment);
                break;
            case R.id.nav_manage:
                toolbar.setTitle("Tools");
                fTrans.replace(R.id.frame_layout, managerFragment);
                break;
            case R.id.nav_share:
                toolbar.setTitle("Share");
                fTrans.replace(R.id.frame_layout, shareFragment);
                break;
            case R.id.nav_send:
                toolbar.setTitle("Send");
                fTrans.replace(R.id.frame_layout, sendFragment);
                break;
        }
        fTrans.commit();
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
