package com.devrepublic.practical.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.ViewCompat
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.devrepublic.practical.R
import com.devrepublic.practical.databinding.FragmentDetailBinding
import com.devrepublic.practical.model.ArticlesModel
import com.google.android.material.appbar.AppBarLayout

class DetailFragment : Fragment() {

    private lateinit var binding: FragmentDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_detail, container, false)
        binding.article = arguments?.getSerializable("article") as ArticlesModel
        binding.toolbar.setNavigationOnClickListener {
            activity?.onBackPressed()
        }
        return binding.root
    }



}