package com.example.mover.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.mover.R
import com.example.mover.databinding.DetailFragmentBinding
import com.example.mover.model.database.MoverDatabase

class DetailFragment : Fragment() {

    private lateinit var binding: DetailFragmentBinding
    private lateinit var viewModel: DetailViewModel


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        binding = DataBindingUtil.inflate(
            inflater, R.layout.detail_fragment, container, false)

        val application = requireNotNull(this.activity).application
        val dataSource = MoverDatabase.getInstance(application).moverDao

        val viewModelFactory = DetailViewModelFactory(dataSource, application)
        viewModel = ViewModelProvider(this, viewModelFactory).get(DetailViewModel::class.java)

        binding.lifecycleOwner = this


        return binding.root
    }

}