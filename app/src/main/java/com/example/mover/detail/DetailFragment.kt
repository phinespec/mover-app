package com.example.mover.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.mover.R
import com.example.mover.databinding.HomeFragmentBinding
import com.example.mover.model.database.MoverDatabase
import com.example.mover.view.home.HomeViewModel
import com.example.mover.view.home.HomeViewModelFactory

class DetailFragment : Fragment()

    private lateinit var binding: HomeFragmentBinding
    private lateinit var viewModel: HomeViewModel


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        binding = DataBindingUtil.inflate(
            inflater, R.layout.home_fragment, container, false)

        val application = requireNotNull(this.activity).application
        val dataSource = MoverDatabase.getInstance(application).moverDao

        val viewModelFactory = HomeViewModelFactory(dataSource, application)


        viewModel.selectedMover.observe(viewLifecycleOwner, Observer {
            it?.let { mover ->
                this.findNavController().navigate()
            }

        })

        return binding.root
    }

}