package com.example.sayone.mykotlinapp.app.homepage

import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.sayone.mykotlinapp.R
import com.example.sayone.mykotlinapp.utilities.TabSwipePager
import kotlinx.android.synthetic.main.activity_home_page.*

class HomePage : AppCompatActivity() {

    val mGridFragment = GridFragment()
    val mListFragment = ListFragment()
    val mFragments: Array<Fragment> = arrayOf<Fragment>(mGridFragment,mListFragment)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_page)
        val tabTitles:ArrayList<String> = arrayListOf("Grid","List")
        home_viewpager.adapter=TabSwipePager(supportFragmentManager,mFragments,tabTitles)
        home_tab.setupWithViewPager(home_viewpager)

    }
}
