package com.example.roomapp.fragments.list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.roomapp.R
import com.example.roomapp.viewmodel.UserViewModel
import com.example.roomapp.databinding.FragmentListBinding


class listFragment : Fragment() {
     private var _binding: FragmentListBinding? = null
    private lateinit var mViewmodel: UserViewModel
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding=  FragmentListBinding.inflate(layoutInflater, container, false)

        _binding!!.floatingActionButton.setOnClickListener {
            findNavController().navigate(R.id.action_listFragment_to_addFragment)
        }
        val adapter = ListAdapter()
        val recycler = _binding!!.recyclerView
        recycler.adapter = adapter
        recycler.layoutManager = LinearLayoutManager(requireContext())
        mViewmodel = ViewModelProvider(this).get(UserViewModel::class.java)
        mViewmodel.readallData.observe(viewLifecycleOwner, Observer {user->
            adapter.setData(user)

        })


        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }


}