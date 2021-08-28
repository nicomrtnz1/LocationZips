package com.example.locationzips.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.locationzips.R
import com.example.locationzips.databinding.FragmentTitleBinding
import android.animation.ObjectAnimator
import android.animation.PropertyValuesHolder


class TitleFragment : Fragment() {

    private var _binding: FragmentTitleBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTitleBinding.inflate(inflater, container, false)
        val startButton = binding.startButton
        startButton.setOnClickListener(
            Navigation.createNavigateOnClickListener(R.id.searchFragment)
        )
        val largeCircle = binding.lgCircle
        val smallCircle = binding.smCircle

        startAnimation(largeCircle,1.8f)
        startAnimation(smallCircle,8f)
        return binding.root
    }

    private fun startAnimation(target: View, scale:Float){
        val scaleDown: ObjectAnimator = ObjectAnimator.ofPropertyValuesHolder(
            target,
            PropertyValuesHolder.ofFloat("scaleX", scale),
            PropertyValuesHolder.ofFloat("scaleY", scale)
        )
        scaleDown.duration = 1500

        scaleDown.repeatCount = ObjectAnimator.INFINITE
        scaleDown.repeatMode = ObjectAnimator.REVERSE

        scaleDown.start()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}