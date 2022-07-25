package com.example.navigationtesting

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.navigationtesting.ViewModels.RegisterViewModel
import com.example.navigationtesting.databinding.FragmentRegisterBinding

class RegisterFragment : Fragment() {

    private var _binding: FragmentRegisterBinding? = null
    private val binding get() = _binding!!
    lateinit var registerViewModel: RegisterViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        registerViewModel = ViewModelProvider(this)[RegisterViewModel::class.java]
        _binding = FragmentRegisterBinding.inflate(inflater, container, false)

        registerViewModel.count.observe(viewLifecycleOwner) {
            binding.counterTv.text = it.toString()
        }
        binding.gotologin.setOnClickListener {
            findNavController().navigate(R.id.action_registerFragment_to_loginFragment)
        }
        binding.increase.setOnClickListener {

            increment()
        }
        binding.decrese.setOnClickListener {
            decrement()
        }
        binding.Reset.setOnClickListener {
            reset()
        }

        return binding.root
    }

    private fun reset() {
        registerViewModel.resetCounter()
    }

    private fun decrement() {
        if (registerViewModel.count.value == 0) {
            val toast = Toast.makeText(context, "Counter Value is equal to zero", Toast.LENGTH_SHORT)
            toast.show()
        } else {
            registerViewModel.decreamentCounter()
        }

    }

    private fun increment() {
        registerViewModel.increamentCounter()
    }


    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }


}