package pl.piotrolech.a20170411_cvapp2;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.MenuItem;

import butterknife.BindView;
import butterknife.ButterKnife;
import pl.piotrolech.a20170411_cvapp2.Fragments.EducationContainerFragment;
import pl.piotrolech.a20170411_cvapp2.Fragments.ExperienceContainerFragment;
import pl.piotrolech.a20170411_cvapp2.Fragments.HobbyContainerFragment;
import pl.piotrolech.a20170411_cvapp2.Fragments.MainContainerFragment;
import pl.piotrolech.a20170411_cvapp2.Fragments.SkillsContainerFragment;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.drawerLayout)
    DrawerLayout drawerLayout;

    @BindView(R.id.navigationView)
    NavigationView navigationView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        setSupportActionBar(toolbar);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar,
                R.string.open_drawer, R.string.close_drawer);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                for (int i = 0; i < navigationView.getMenu().size(); i++) {
                    navigationView.getMenu().getItem(i).setChecked(false);
                }
                item.setChecked(true);
                toolbar.setTitle(item.getTitle());
                drawerLayout.closeDrawer(Gravity.START);
                switch (item.getItemId()) {
                    case R.id.home: {
                        setupFragment(MainContainerFragment.newInstance());
                        break;
                    }
                    case R.id.skills: {
                        setupFragment(SkillsContainerFragment.newInstance());
                        break;
                    }
                    case R.id.experience: {
                        setupFragment(ExperienceContainerFragment.newInstance());
                        break;
                    }
                    case R.id.education: {
                        setupFragment(EducationContainerFragment.newInstance());
                        break;
                    }
                    case R.id.hobby: {
                        setupFragment(HobbyContainerFragment.newInstance());
                        break;
                    }

                }
                return true;
            }
        });
        setupFragment(MainContainerFragment.newInstance());
    }

    private void setupFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment).commit();
    }
}
