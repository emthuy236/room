package com.example.roomapp.fragments.add

import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.roomapp.R
import com.example.roomapp.models.User
import com.example.roomapp.viewmodel.UserViewModel
import com.example.roomapp.databinding.FragmentAddBinding

class addFragment : Fragment() {
    private lateinit var mUserviewmodel: UserViewModel
    private var _binding1:FragmentAddBinding? = null
    private val binding1 get() = _binding1!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment

        _binding1 = FragmentAddBinding.inflate(layoutInflater, container, false)

        mUserviewmodel = ViewModelProvider(this).get(UserViewModel::class.java)
        _binding1!!.buttonadd.setOnClickListener {
            insertToDatabase()
        }
        return binding1.root
    }

    private  fun insertToDatabase() {
        val firstname = _binding1!!.editfirst.text.toString()
        val lastname = _binding1!!.editsecond.text.toString()
        val age = _binding1!!.editthird.text

        if (inputCheck(firstname,lastname,age)){
            val user = User(0,firstname,lastname,Integer.parseInt(age.toString()))
            mUserviewmodel.adduser(user)
            Toast.makeText(requireContext(),"Successfully",Toast.LENGTH_SHORT).show()
                findNavController().navigate(R.id.action_addFragment_to_listFragment)
        }else{
            Toast.makeText(requireContext(),"Error",Toast.LENGTH_SHORT).show()
        }


    }
    private fun inputCheck(firstName:String,lastName:String,Age:Editable):Boolean{
        return !(TextUtils.isEmpty(firstName) && TextUtils.isEmpty(lastName) && Age.isEmpty())
    }
}