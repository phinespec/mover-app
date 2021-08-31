package com.example.mover.views.home

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mover.Network.Mover
import com.example.mover.model.database.MoverDao
import java.util.*

class HomeViewModel(
    val database: MoverDao,
    application: Application) : ViewModel() {

    private val _movers = MutableLiveData<List<Mover>>()
    val movers: LiveData<List<Mover>>
    get() = _movers

    private val _selectedMover = MutableLiveData<Mover?>()
    val selectedMover: LiveData<Mover?>
    get() = _selectedMover

    fun navigationComplete() {
        _selectedMover.value = null
    }

    fun setMover(mover: Mover) {
        _selectedMover.value = mover
    }

}

//object Movers {
//
//    val listOfMovers = mutableListOf<Mover>(
//        Mover(0, firstName = "Bob", lastName = "Wiley", moneyOwed = 40_000.00, address = "1987 Lake Winnapasaukee, NH, 46330"),
//        Mover(1, firstName = "James", lastName = "Bond", moneyOwed = 5_000_000.00, address = "007, Octopussy, Maryland"),
//        Mover(2, firstName = "Dr", lastName = "Evil", moneyOwed = 1_000_000_000.00, address = "345 Submarine Dr, Antarctica")
//
//    )
//}