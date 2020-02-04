package com.example.fragment_viewmodel_example

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView


class TicketNumberFragment : Fragment() {
    companion object {
        fun newInstance() = TicketNumberFragment()
    }

    private lateinit var viewModel: TicketNumberViewModel
    private lateinit var mainViewModel: MainViewModel



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.ticket_number_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(TicketNumberViewModel::class.java)
        activity?.let {
            mainViewModel = ViewModelProviders.of(it).get(MainViewModel::class.java)
        }
        mainViewModel.inputPerson.value?.let {
            showInfo(it)
        }
    }

    private fun showInfo(person: Person) {
        val lblName = view?.findViewById<TextView>(R.id.lblName)
        lblName?.text = person.name
    }
}
