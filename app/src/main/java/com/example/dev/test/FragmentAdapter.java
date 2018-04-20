package com.example.dev.test;

        import android.support.annotation.Nullable;
        import android.support.v4.app.Fragment;
        import android.support.v4.app.FragmentManager;
        import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by Amir Hossein on 4/20/2018.
 */

public class FragmentAdapter extends FragmentStatePagerAdapter {
    public FragmentAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment returnFragment;
        switch (position) {
            case 0:
                returnFragment = Fragment_main_home.newInstance();
                break;
            case 1:
                returnFragment = Fragment_main_search.newInstance();
                break;
            case 2:
                returnFragment = Fragment_main_notificatiin.newInstance();
                break;
            case 3:
                returnFragment = Fragment_main_profile.newInstance();
                break;
            default:
                returnFragment = null;
        }
        return returnFragment;
    }

    @Override
    public int getCount() {
        return 4;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        CharSequence title;
        switch (position) {
            case 0:
                title = "Home";
                break;
            case 1:
                title = "Search";
                break;
            case 2:
                title = "Notification";
                break;
            case 3:
                title = "Profile";
                break;
            default:
                return null;
        }
        return title;
    }
}
