package pl.piotrolech.a20170411_cvapp2.Fragments;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import pl.piotrolech.a20170411_cvapp2.Model.ViewPagerFragment;
import pl.piotrolech.a20170411_cvapp2.R;
import pl.piotrolech.a20170411_cvapp2.ViewPagerAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class SkillsContainerFragment extends Fragment {

    @BindView(R.id.viewPager)
    ViewPager viewPager;

    @BindView(R.id.tabLayout)
    TabLayout tabLayout;


    public static SkillsContainerFragment newInstance() {
        
        Bundle args = new Bundle();
        
        SkillsContainerFragment fragment = new SkillsContainerFragment();
        fragment.setArguments(args);
        return fragment;
    }
    
    public SkillsContainerFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_container, container, false);
        ButterKnife.bind(this, view);

        ArrayList<ViewPagerFragment> list = setupFragments();

        viewPager.setAdapter(new ViewPagerAdapter(getChildFragmentManager(), list));
        tabLayout.setupWithViewPager(viewPager);

        return view;
    }

    @NonNull
    private ArrayList<ViewPagerFragment> setupFragments() {
        ArrayList<ViewPagerFragment> list = new ArrayList<>();
        list.add(0,new ViewPagerFragment(SkillsAndroidFragment.newInstance(),"Android"));
        list.add(1,new ViewPagerFragment(SkillsJavaFragment.newInstance(), "Java"));
        list.add(2,new ViewPagerFragment(SkillsPLCFragment.newInstance(), "PLC"));
        return list;
    }

}
