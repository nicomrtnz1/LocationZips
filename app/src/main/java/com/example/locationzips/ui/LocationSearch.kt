package com.example.locationzips.ui

import android.content.Context
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import com.example.locationzips.databinding.LocationSearchFragmentBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class LocationSearch : Fragment() {

    companion object {
        fun newInstance() = LocationSearch()
    }

    private var viewModel: LocationSearchViewModel? = null
    private var _binding: LocationSearchFragmentBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = LocationSearchFragmentBinding.inflate(inflater, container, false)
        val root: View = binding.root
        val btn = binding.button
        val cityTextView = binding.city
        val stateTextView = binding.state
        val progressBar = binding.progressBar

        btn.setOnClickListener {
            CoroutineScope(Dispatchers.IO).launch {
                viewModel?.updateZips(cityTextView.text.toString(), stateTextView.text.toString())
            }
            progressBar.visibility = View.VISIBLE
            hideKeyboard()
        }
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val progressBar = binding.progressBar
        viewModel = activity?.run {
            ViewModelProvider(this)[LocationSearchViewModel::class.java]
        }

        viewModel?.zip?.observe(viewLifecycleOwner, { zips ->
            progressBar.visibility = View.GONE
            binding.zipList.adapter = ZipCodeAdapter(zips)
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun Fragment.hideKeyboard() {
        val inputMethodManager = context?.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(view?.windowToken, 0)
    }

}