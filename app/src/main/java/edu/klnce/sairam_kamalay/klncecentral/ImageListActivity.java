package edu.klnce.sairam_kamalay.klncecentral;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class ImageListActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
    private DatabaseReference mDatabaseRef;
    private List<imageUpload> imgList;
    private ListView lv;
    private ImageListAdapter adapter;
    private ProgressDialog progressDialog;

    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToggle;
    private NavigationView mDrawer;


    FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_list);
        imgList = new ArrayList<>();
        lv= (ListView) findViewById(R.id.listViewImage);
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("please wait loading News...");
        progressDialog.show();

        mDrawer = (NavigationView) findViewById(R.id.sidenavview);
        mDrawer.setNavigationItemSelectedListener(this);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.imagelistDrawer);
        mToggle = new ActionBarDrawerToggle(this,mDrawerLayout,R.string.sidenavopen,R.string.sidenavclose);

        mDrawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mDatabaseRef = FirebaseDatabase.getInstance().getReference(Mainpage.FB_DATABASE_PATH);
        mDatabaseRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                progressDialog.dismiss();


                for (DataSnapshot snapshot:dataSnapshot.getChildren())
                {
                    imageUpload img= snapshot.getValue(imageUpload.class);
                    imgList.add(img);
                }
                adapter = new ImageListAdapter(ImageListActivity.this, R.layout.image_item,imgList);
                lv.setAdapter((ListAdapter) adapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                progressDialog.dismiss();

            }
        });
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (mToggle.onOptionsItemSelected(item)){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Intent tolog = null;
        if (item.getItemId() == R.id.sidenav_logout){
            firebaseAuth.signOut();
            mDrawerLayout.closeDrawer(GravityCompat.START);
            tolog = new Intent(ImageListActivity.this,MainActivity.class);
            tolog.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(tolog);
            return true;
        }
        else if(item.getItemId() == R.id.about_us){
            Intent toaboutus = new Intent(this,About_us.class);
            startActivity(toaboutus);
            return true;
        }
        else if(item.getItemId() == R.id.busschedule){
            Intent tobusschedule = new Intent(this,BusSchedule.class);
            startActivity(tobusschedule);
            return true;
        }
        else if(item.getItemId() == R.id.canteendetails){
            Intent tocanteen = new Intent(this,Canteen.class);
            startActivity(tocanteen);
            return true;
        }

        return false;
    }
}
