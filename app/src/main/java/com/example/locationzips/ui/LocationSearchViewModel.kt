package com.example.locationzips.ui

import android.text.Editable
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.zipcodes.data.ZipRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class LocationSearchViewModel : ViewModel() {
    private var zipRepository: ZipRepository = ZipRepository()

    val zip: MutableLiveData<List<String>> by lazy { MutableLiveData<List<String>>() }

    suspend fun updateZips(city: String, state: String) {
        val data= zipRepository.getZips(city, state)
        CoroutineScope(Dispatchers.Main).launch {
            zip.value =  data
        }
    }
}