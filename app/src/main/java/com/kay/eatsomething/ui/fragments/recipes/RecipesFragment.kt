package com.kay.eatsomething.ui.fragments.recipes

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.kay.eatsomething.databinding.FragmentRecipesBinding

class RecipesFragment : Fragment() {

    private var _binding: FragmentRecipesBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentRecipesBinding.inflate(inflater, container, false)

        showShimmerEffect()

        return binding.root
    }

    private fun showShimmerEffect() {
        binding.shimmerFrameLayout.startShimmer()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}