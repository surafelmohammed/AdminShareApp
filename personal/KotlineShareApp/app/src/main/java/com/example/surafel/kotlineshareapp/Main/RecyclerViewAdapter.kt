package com.example.surafel.kotlineshareapp.Main

import android.opengl.Visibility
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.surafel.kotlineshareapp.R
import com.example.surafel.kotlineshareapp.data.mockData
import kotlinx.android.synthetic.main.recycler_view_cell.view.*

class AdapterRV : RecyclerView.Adapter<AdapterRV.myViewHolder>() {

    private var count = 0
    val mockData= listOf(
        mockData("Android Kotlin","check"),
        mockData("Android Java","check"),
        mockData("Just Android","check"),
        mockData("Android Kotlin2","check"),
        mockData("Android Kotlin3","check"),
        mockData("Android Kotlin4","check"),
        mockData("test18","check"),
        mockData("test19","check"),
        mockData("test11","check"),
        mockData("test12","check"),
        mockData("test13","check"),
        mockData("test14","check"),
        mockData("test15","check"),
        mockData("what","no questions"))

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): myViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recycler_view_cell,parent,false) as View

        view.setOnClickListener {

        }
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
        return mockData.size
    }

    override fun onBindViewHolder(holder: myViewHolder, position: Int) {
        holder.view.title.text = mockData[position].name
        holder.view.subtitle.text = mockData[position].lastname
    }

    class myViewHolder(val view:View): RecyclerView.ViewHolder(view)

}