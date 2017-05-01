package pl.piotrolech.a20170411_cvapp2.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import pl.piotrolech.a20170411_cvapp2.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class SkillsAndroidFragment extends Fragment {

    public static SkillsAndroidFragment newInstance() {
        
        Bundle args = new Bundle();
        
        SkillsAndroidFragment fragment = new SkillsAndroidFragment();
        fragment.setArguments(args);
        return fragment;
    }

    public SkillsAndroidFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_skills_android, container, false);
    }

}
