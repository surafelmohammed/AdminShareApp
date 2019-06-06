package com.example.surafel.kotlineshareapp.Splash

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.surafel.kotlineshareapp.Error.Error

class Adapter(fm:FragmentManager):FragmentPagerAdapter(fm) {


    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> SplashFragment1()
            1 -> SplashFragment2()
            2 -> SplashFragment3()
            else ->Error()
        }
    }

    override fun getCount(): Int {
        return 3
    }


}