package com.example.surafel.kotlineshareapp.Splash


import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import androidx.fragment.app.FragmentManager
import androidx.viewpager.widget.ViewPager
import com.bumptech.glide.Glide
import com.example.surafel.kotlineshareapp.MainActivity

import com.example.surafel.kotlineshareapp.R
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*
import kotlinx.android.synthetic.main.fragment_splash_fragment1.*
import kotlinx.android.synthetic.main.fragment_splash_fragment1.view.*
import kotlinx.android.synthetic.main.fragment_splash_fragment2.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class SplashFragment1 : Fragment() {


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val view =inflater.inflate(R.layout.fragment_splash_fragment1, container, false)
        val imageView = view.iv_fragment1_header
        Glide.with(view.context).load(R.drawable.track).into(imageView)

        return view
    }

}
