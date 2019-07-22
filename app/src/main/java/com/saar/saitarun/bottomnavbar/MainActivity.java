package com.saar.saitarun.bottomnavbar;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {


    private BottomNavigationView bottomNavigationView;
    private HomeFragment homeFragment;
    private MusicFragment musicFragment;
    private CartFragment cartFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView=findViewById(R.id.bottombar);


        homeFragment=new HomeFragment();
        musicFragment=new MusicFragment();
        cartFragment=new CartFragment();

        setOurFragment(homeFragment);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                switch (menuItem.getItemId()){

                    case R.id.home:
                        bottomNavigationView.setItemBackgroundResource(R.color.home);
                        setOurFragment(homeFragment);
                        return true;

                    case R.id.music:
                        bottomNavigationView.setItemBackgroundResource(R.color.music);
                        setOurFragment(musicFragment);
                        return true;

                    case R.id.cart:
                        bottomNavigationView.setItemBackgroundResource(R.color.cart);
                        setOurFragment(cartFragment);
                        return true;

                        default:
                            return false;
                }

            }
        });
    }

    public void setOurFragment(Fragment fragment){

        FragmentTransaction fragmentTransaction=getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.mainframe,fragment);
        fragmentTransaction.commit();

    }
}
