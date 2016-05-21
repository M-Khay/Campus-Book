package scu.book.campus.com.campusbook;

import android.app.ActionBar;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;

import com.kii.cloud.storage.Kii;

/**
 * Created by kushahuja on 5/13/16.
 */
public class HomeActivity extends FragmentActivity {

    public static final String ARG_OBJECT = "object";

    DemoCollectionPagerAdapter mDemoCollectionPagerAdapter;
    ViewPager mViewPager;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_page);

        Kii.initialize("5e6cf58f", "3de2d3d6d860244b7f81698a20e38225", Kii.Site.US);
        final ActionBar actionBar = getActionBar();
        mDemoCollectionPagerAdapter =
                new DemoCollectionPagerAdapter(
                        getSupportFragmentManager());
        mViewPager = (ViewPager) findViewById(R.id.pager);
        mViewPager.setAdapter(mDemoCollectionPagerAdapter);


        mViewPager.setOnPageChangeListener(
                new ViewPager.SimpleOnPageChangeListener() {
                    @Override
                    public void onPageSelected(int position) {

                    }
                });

    }
}
// Since this is an object collection, use a FragmentStatePagerAdapter,
// and NOT a FragmentPagerAdapter.
class DemoCollectionPagerAdapter extends FragmentStatePagerAdapter {
    public DemoCollectionPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {

        Fragment fragment= null;

        switch (i)
        {
            case 0:
                fragment = new Home();
                break;
            case 1:
                fragment = new Buyer();
break;
            case 2:
                fragment = new Seller();
break;
        }
        Bundle args = new Bundle();
        // Our object is just an integer :-P
        args.putInt(HomeActivity.ARG_OBJECT, i + 1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position)
        {
            case 0:
                return "Home";
            case 1:
                return "Buyer";
            case 2:
                return "Seller";

        }


        return "OBJECT " + (position + 1);
    }
}

