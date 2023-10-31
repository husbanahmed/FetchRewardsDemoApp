package com.example.fetchcodingexercise.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fetchcodingexercise.network.RetrofitInstance
import com.example.fetchcodingexercise.model.Item
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.io.IOException

class MainActivityViewModel: ViewModel() {
    var itemLiveData: MutableLiveData<List<Item>> = MutableLiveData()
    private val TAG = "MainActivityViewModel"

    fun fetchData(){
        viewModelScope.launch(Dispatchers.IO) {
            try{
                val response = RetrofitInstance.api.getItems()

                if (response.isSuccessful) {
                    // Sorting by listIds in list of items
                    val sortListIDs = response.body()?.sortedBy { item -> item.listId}

                    // Filtering for null and empty strings in list of items
                    val result = sortListIDs?.filter { item -> !item.name.isNullOrEmpty() }
                    itemLiveData.postValue(result)
                }
            } catch (e:IOException) {
                Log.d(TAG,"IOException, you might not have internet connection")
            }
        }
    }
}