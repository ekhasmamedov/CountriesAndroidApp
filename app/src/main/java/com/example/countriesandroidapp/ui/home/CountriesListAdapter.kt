package com.example.countriesandroidapp.ui.home

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.example.countriesandroidapp.R
import com.example.countriesandroidapp.models.Country

class CountriesListAdapter(private val context: Context,
                           private var dataSource: ArrayList<Country>) : BaseAdapter() {
    private val inflater: LayoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    override fun getCount(): Int {
        return dataSource.size
    }

    override fun getItem(position: Int): Any {
        return dataSource[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view: View
        val holder: ViewHolder

        if (convertView == null) {
            view = inflater.inflate(R.layout.country_list_item, parent, false)
            holder = ViewHolder()
            holder.titleTextView = view.findViewById(R.id.country_list_name) as TextView
            view.tag = holder
        } else {
            view = convertView
            holder = convertView.tag as ViewHolder
        }

        val country = getItem(position) as Country
        val titleTextView = holder.titleTextView
        titleTextView.text = country.name

        return view
    }

    private class ViewHolder {
        lateinit var titleTextView: TextView
    }

    fun setItems(items: ArrayList<Country>) {
        dataSource = items
        notifyDataSetChanged()
    }
}
