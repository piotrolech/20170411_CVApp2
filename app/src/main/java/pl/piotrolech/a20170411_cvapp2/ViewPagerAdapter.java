package pl.piotrolech.a20170411_cvapp2;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

import pl.piotrolech.a20170411_cvapp2.Model.ViewPagerFragment;

/**
 * Created by olech on 12.04.2017.
 */

public class ViewPagerAdapter extends FragmentPagerAdapter {

    private ArrayList<ViewPagerFragment> list = new ArrayList<>();

    public ViewPagerAdapter(FragmentManager fm, ArrayList<ViewPagerFragment> list) {
        super(fm);
        this.list = list;

    }

    @Override
    public Fragment getItem(int position) {
        return list.get(position).getFragment();
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
return list.get(position).getTitle();
    }
}
