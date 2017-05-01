package pl.piotrolech.a20170411_cvapp2.Fragments;


import android.graphics.Color;
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
import pl.piotrolech.a20170411_cvapp2.ViewPagerAdapter;
import pl.piotrolech.a20170411_cvapp2.Model.ViewPagerFragment;
import pl.piotrolech.a20170411_cvapp2.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class MainContainerFragment extends Fragment {

    @BindView(R.id.viewPager)
    ViewPager viewPager;

    @BindView(R.id.tabLayout)
    TabLayout tabLayout;



    public static MainContainerFragment newInstance() {

        Bundle args = new Bundle();
        MainContainerFragment fragment = new MainContainerFragment();
        fragment.setArguments(args);



        return fragment;
    }

    public MainContainerFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_container, container, false);
        ButterKnife.bind(this, view);
        view.setBackgroundColor(Color.TRANSPARENT);
        ArrayList<ViewPagerFragment> list = setupFragments();

        viewPager.setAdapter(new ViewPagerAdapter(getChildFragmentManager(),list));
        tabLayout.setupWithViewPager(viewPager);

        return view;
    }

    @NonNull
    private ArrayList<ViewPagerFragment> setupFragments() {
        ArrayList<ViewPagerFragment> list = new ArrayList<>();
        list.add(0, new ViewPagerFragment(MainFragment.newInstance(), "Personal data"));
        list.add(1, new ViewPagerFragment(MotivationFragment.newInstance(), "Motivation"));
        return list;
    }

}
