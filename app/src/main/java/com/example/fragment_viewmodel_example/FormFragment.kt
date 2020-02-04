package com.example.fragment_viewmodel_example

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.navigation.fragment.findNavController


class FormFragment : Fragment() {
    companion object {
        fun newInstance() = FormFragment()
    }

    private lateinit var viewModel: FormViewModel
    private lateinit var mainViewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.form_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(FormViewModel::class.java)
        activity?.let {
            mainViewModel = ViewModelProviders.of(it).get(MainViewModel::class.java)
        }

        val etName = view?.findViewById<EditText>(R.id.etName)
        val etAge = view?.findViewById<EditText>(R.id.etAge)
        val btnGenerate = view?.findViewById<Button>(R.id.btnGenerate)

        btnGenerate?.setOnClickListener {
            val name = etName?.text.toString()
            val age = etAge?.text.toString().toInt()
            if (!name.isNullOrBlank()) {
                mainViewModel.inputPerson.postValue(Person(name, age))
                findNavController().navigate(R.id.action_formFragment_to_ticketNumberFragment)
            }
        }
    }
}
