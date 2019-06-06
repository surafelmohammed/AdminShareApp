package com.example.surafel.kotlineshareapp.Splash


import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.example.surafel.kotlineshareapp.Login.LoginFragment
import com.example.surafel.kotlineshareapp.R
import kotlinx.android.synthetic.main.fragment_view_pager.view.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class ViewPagerFragment : Fragment() {


    lateinit var adapter: Adapter
    lateinit var viewPager: ViewPager
    private var counter = 0
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_view_pager, container, false)

        view.vp_splash.adapter = Adapter(childFragmentManager)
        val fragmentLogin = LoginFragment()


        view.btn_next.setOnClickListener {
           when (view.vp_splash.currentItem){
               0,1->view.vp_splash.setCurrentItem(view.vp_splash.currentItem+1)
               2->activity?.supportFragmentManager!!.beginTransaction()
                   .replace(R.id.fl_container,fragmentLogin)
                   .commit()
           }
        }
        view.btn_previous.setOnClickListener {
            view.vp_splash.currentItem = view.vp_splash.currentItem - 1
        }
        return view
    }

}
