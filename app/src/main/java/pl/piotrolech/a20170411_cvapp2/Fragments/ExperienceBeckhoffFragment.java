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
public class ExperienceBeckhoffFragment extends Fragment {

    public static ExperienceBeckhoffFragment newInstance() {

        Bundle args = new Bundle();

        ExperienceBeckhoffFragment fragment = new ExperienceBeckhoffFragment();
        fragment.setArguments(args);
        return fragment;
    }

    public ExperienceBeckhoffFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_experience_beckhoff, container, false);
    }

}
