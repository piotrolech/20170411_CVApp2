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
public class ExperienceAstorFragment extends Fragment {


    public static ExperienceAstorFragment newInstance() {
        
        Bundle args = new Bundle();
        
        ExperienceAstorFragment fragment = new ExperienceAstorFragment();
        fragment.setArguments(args);
        return fragment;
    }
    public ExperienceAstorFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_experience_astor, container, false);
    }

}
