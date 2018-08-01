package com.example.sayone.mykotlinapp.app.login.registration

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import com.example.sayone.mykotlinapp.R
import com.example.sayone.mykotlinapp.utilities.TabSwipePager
import kotlinx.android.synthetic.main.activity_first_page.*
import java.util.ArrayList

class FirstPageActivity : AppCompatActivity() {


    val mLoginFragment: LoginFragment = LoginFragment()
    val mRegisterFragment: RegisterFragment = RegisterFragment()
    val mFragment: Array<Fragment> = arrayOf(mLoginFragment, mRegisterFragment)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val mPageTitle: ArrayList<String> = arrayListOf("Login","Sign Up")
        setContentView(R.layout.activity_first_page)
        container.adapter = TabSwipePager(supportFragmentManager, mFragment, mPageTitle)
        first_page_tab.setupWithViewPager(container)

    }
}
