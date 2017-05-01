package pl.piotrolech.a20170411_cvapp2.Model;

import android.support.v4.app.Fragment;

/**
 * Created by olech on 14.04.2017.
 */

public class ViewPagerFragment {
    private Fragment fragment;
    private String title;

    public ViewPagerFragment(Fragment fragment, String title) {
        this.fragment = fragment;
        this.title = title;
    }

    public Fragment getFragment() {
        return fragment;
    }

    public String getTitle() {
        return title;
    }

    public void setFragment(Fragment fragment) {
        this.fragment = fragment;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
