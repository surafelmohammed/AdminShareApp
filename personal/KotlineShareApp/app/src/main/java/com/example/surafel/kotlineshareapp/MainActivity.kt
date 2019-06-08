package com.example.surafel.kotlineshareapp

import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import com.example.surafel.kotlineshareapp.Login.LoginFragment
import com.example.surafel.kotlineshareapp.Main.MainFragment
import com.example.surafel.kotlineshareapp.Main.MainReportFragment
import com.example.surafel.kotlineshareapp.Splash.ViewPagerFragment

private var logIn = false
private var signIn = false
private var veryFirstTime = true

class MainActivity : AppCompatActivity(), LoginFragment.onLoginClick, MainFragment.OnFragmentInteractionListener,
    MainReportFragment.OnFragmentInteractionListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragmentSplash = ViewPagerFragment()

        supportFragmentManager.beginTransaction()
            .add(R.id.fl_container,fragmentSplash)
            .addToBackStack(null)
            .commit()

    }

    override fun loginCallback() {
        val fragmentMain = MainFragment()
        supportFragmentManager.beginTransaction()
            .add(R.id.fl_container,fragmentMain)
            .addToBackStack(null)
            .commit()
    }

    override fun onFragmentInteraction(uri: Uri) {
    }


}
