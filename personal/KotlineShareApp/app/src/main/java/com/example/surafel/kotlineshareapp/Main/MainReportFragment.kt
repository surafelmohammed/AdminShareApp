package com.example.surafel.kotlineshareapp.Main

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.ProgressBar
import android.widget.Toast
import androidx.core.content.ContextCompat.getSystemService
import androidx.core.net.ConnectivityManagerCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.surafel.kotlineshareapp.LocalDB.ReportedData
import com.example.surafel.kotlineshareapp.R
import com.example.surafel.kotlineshareapp.network.NetworkData
import com.example.surafel.kotlineshareapp.network.ReportApiService
import com.example.surafel.kotlineshareapp.viewmodel.ReportViewModel
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import okhttp3.Response
import retrofit2.Call
import retrofit2.Callback
import java.util.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


class MainReportFragment : Fragment() {
    private var listener: MainFragment.OnFragmentInteractionListener? = null
    lateinit var viewModel: ReportViewModel
    lateinit var recyclerView: RecyclerView
    lateinit var viewManager: RecyclerView.LayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel = ViewModelProviders.of(this).get(ReportViewModel::class.java)
        val responseData:NetworkData
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val fragmentDetail = MainReportDetailFragment()
         var viewAdapterRV: RecyclerView.Adapter<*>
         val view = inflater.inflate(R.layout.fragment_main_report, container, false)
        viewManager = LinearLayoutManager(context)
//        viewModel.allReportData.observe(this, Observer { reportData ->
//            reportData?.let { (viewAdapterRV as AdapterRV).setReportData(reportData) }
//        })
        val Nreport:Call<List<NetworkData>> = ReportApiService.getInstance().findAllResponse()
        val repotFrag=this
        Nreport.enqueue(object:Callback<List<NetworkData>>{
            override fun onFailure(call: Call<List<NetworkData>>, t: Throwable) {
                Toast.makeText(activity,"Connection Failed",Toast.LENGTH_LONG).show()
            }
            override fun onResponse(call: Call<List<NetworkData>>, response: retrofit2.Response<List<NetworkData>>) {
               val mock:List<NetworkData> =  response.body()!!

                viewAdapterRV = AdapterRV(mock,activity!!.supportFragmentManager)

                recyclerView = view.findViewById<RecyclerView>(R.id.rv_report).apply {
                    setHasFixedSize(true)
                    layoutManager = viewManager
                    adapter = viewAdapterRV
                }
            }
        })

        return view
    }

    // TODO: Rename method, update argument and hook method into UI event


    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is MainFragment.OnFragmentInteractionListener) {
            listener = context
        } else {
            throw RuntimeException(context.toString() + " must implement OnFragmentInteractionListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    private fun connected(): Boolean {

        val connectivityManager = getSystemService(activity!!, ReportApiService::class.java) as ConnectivityManager

        val networkInfo: NetworkInfo? = connectivityManager.activeNetworkInfo

        return networkInfo != null && networkInfo.isConnected
    }

    interface OnFragmentInteractionListener {

        fun onFragmentInteraction(uri: Uri)
    }
}

