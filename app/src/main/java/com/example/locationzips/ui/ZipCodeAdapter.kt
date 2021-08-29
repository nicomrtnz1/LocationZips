package com.example.locationzips.ui

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.core.view.size
import androidx.recyclerview.widget.RecyclerView
import com.example.locationzips.R
import com.example.locationzips.databinding.LocationSearchFragmentBinding
import com.example.locationzips.databinding.ZipCodeViewBinding

class ZipCodeAdapter(private val zips: List<String>): RecyclerView.Adapter<ZipCodeAdapter.ViewHolder>() {


    inner class  ViewHolder(val binding: ZipCodeViewBinding): RecyclerView.ViewHolder(binding.root)

    override fun getItemCount() = zips.size
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val zip = zips[position]
        with(holder.binding){
            if (position%2 === 0){
                zipText.setBackgroundColor(ContextCompat.getColor(zipText.context, R.color.im_accent))
            }
            zipText.text = zip
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ZipCodeViewBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }
}