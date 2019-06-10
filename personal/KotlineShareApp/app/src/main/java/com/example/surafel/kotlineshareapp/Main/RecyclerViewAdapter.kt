package com.example.surafel.kotlineshareapp.Main

import android.app.ProgressDialog
import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.Toast
import androidx.fragment.app.FragmentManager
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.surafel.kotlineshareapp.R
import kotlinx.android.synthetic.main.recycler_view_cell.view.*
import com.example.surafel.kotlineshareapp.LocalDB.ReportedData
import com.example.surafel.kotlineshareapp.MainActivity
import com.example.surafel.kotlineshareapp.network.NetworkData
import com.example.surafel.kotlineshareapp.network.ReportApiService
import retrofit2.Call
import kotlin.coroutines.coroutineContext

class AdapterRV(test:List<NetworkData>,val parentFragment:MainReportFragment) : RecyclerView.Adapter<AdapterRV.myViewHolder>() {

    private var reportedData: List<NetworkData> = test
    private var count = 0

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): myViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recycler_view_cell,parent,false) as View

        view.iv_more.setOnClickListener {
            count = count +1
            if(count%2!=0){
                view.hidden_item.visibility = LinearLayout.VISIBLE
                view.iv_more.setImageResource(R.drawable.less)
            }else {
                view.hidden_item.visibility = LinearLayout.GONE
                view.iv_more.setImageResource(R.drawable.more)
            }
        }

        return myViewHolder(view)
    }

    override fun getItemCount(): Int {
        return reportedData.size //modkData.size for mock data object
    }

    override fun onBindViewHolder(holder: myViewHolder, position: Int) {

        val data = reportedData[position]

        holder.view.title.text = data.title//mockData[position]. for  mock data object
        holder.view.subtitle.text = data.body

        val bundle = Bundle()
        bundle.putString("title",reportedData.get(position).title)
        bundle.putString("body",reportedData.get(position).body)
        bundle.putInt("id",reportedData.get(position).id)

        holder.view.setOnClickListener {
            holder.view.findNavController().navigate(R.id.mainReportDetailFragment4,bundle)
        }
        holder.view.btn_more.setOnClickListener {
            holder.view.findNavController().navigate(R.id.mainReportDetailFragment4,bundle)
        }
        holder.view.btn_delete.setOnClickListener {
            progressDialog("Deleting the file").show()
            ReportApiService.getInstance().deleteReport(reportedData.get(position).id)
        }
        holder.view.btn_remove.setOnClickListener {
            progressDialog("Removing The report").show()
            ReportApiService.getInstance().updataReport(data)
        }
        holder.view.btn_seen.setOnClickListener {

        }

//        holder.view.setOnClickListener {
//            parentFragment.beginTransaction()
//                .replace(R.id.fl_main_fragment,fragmentDetail)
//                .commit()
//
//        }
    }

    fun setReportData(reportedData: List<ReportedData>){
        notifyDataSetChanged()
    }

    class myViewHolder(val view:View): RecyclerView.ViewHolder(view)


    fun progressDialog(message:String):ProgressDialog
    {
        val pDialog = ProgressDialog(parentFragment.context)
        pDialog.setTitle(message)
        pDialog.setMessage("please wait...")
        return pDialog
    }
}