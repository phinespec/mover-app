package com.example.mover.view.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.mover.R
import com.example.mover.databinding.HomeFragmentBinding
import com.example.mover.model.database.MoverDatabase
import timber.log.Timber

class HomeFragment : Fragment() {

    private lateinit var binding: HomeFragmentBinding
    private lateinit var viewModel: HomeViewModel

    val moverList = Movers.listOfMovers


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        binding = DataBindingUtil.inflate(
            inflater, R.layout.home_fragment, container, false)

        val application = requireNotNull(this.activity).application
        val dataSource = MoverDatabase.getInstance(application).moverDao

        val viewModelFactory = HomeViewModelFactory(dataSource, application)
        viewModel = ViewModelProvider(this, viewModelFactory).get(HomeViewModel::class.java)

        viewModel.selectedMover.observe(viewLifecycleOwner, Observer {
            it?.let { mover ->
                // Print the mover
                Timber.i("Mover name => ${mover.firstName}")

            }

        })

        val adapter = MoverAdapter(viewModel)

        binding.moverList.adapter = adapter

        adapter.submitList(moverList)

        return binding.root
    }

}