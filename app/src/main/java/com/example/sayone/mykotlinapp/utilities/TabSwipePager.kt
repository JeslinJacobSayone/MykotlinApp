package com.example.sayone.mykotlinapp.utilities

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import java.util.ArrayList

class TabSwipePager(fragmentManager: FragmentManager,val mTabFragments:Array<Fragment>,val mPageTitle:ArrayList<String>): FragmentPagerAdapter(fragmentManager) {

    override fun getItem(position: Int): Fragment {
        return mTabFragments.get(position);
    }

    override fun getCount(): Int {
        return mTabFragments.size
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return mPageTitle.get(position)
    }
}