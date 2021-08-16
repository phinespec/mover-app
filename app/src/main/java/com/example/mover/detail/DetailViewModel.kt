package com.example.mover.detail

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mover.model.database.Mover
import com.example.mover.model.database.MoverDao

class DetailViewModel(
    val database: MoverDao,
    application: Application
) : ViewModel() {

    private val _selectedMover = MutableLiveData<Mover?>()
    val selectedMover: LiveData<Mover?>
        get() = _selectedMover

    fun navigationComplete() {
        _selectedMover.value = null
    }


}