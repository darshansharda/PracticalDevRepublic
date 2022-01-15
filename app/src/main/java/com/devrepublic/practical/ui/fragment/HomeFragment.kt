package com.devrepublic.practical.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.devrepublic.practical.R
import com.devrepublic.practical.api.Status
import com.devrepublic.practical.databinding.FragmentHomeBinding
import com.devrepublic.practical.model.ArticlesModel
import com.devrepublic.practical.ui.adapter.NewsAdapter
import com.devrepublic.practical.utils.RecyclerViewClickListener
import com.devrepublic.practical.viewmodel.HomeViewModel

class HomeFragment : Fragment(), RecyclerViewClickListener {

    private val homeViewModel: HomeViewModel by viewModels()
    private lateinit var binding: FragmentHomeBinding
    private val articles = arrayListOf<ArticlesModel>()
    private lateinit var navController: NavController

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)
        val navHostFragment =
            activity?.supportFragmentManager?.findFragmentById(R.id.my_nav_host_fragment) as NavHostFragment
        navController = navHostFragment.navController
        setupRecyclerView()
        setObserver()
        return binding.root
    }

    private fun setupRecyclerView() {
        binding.rvNews.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = NewsAdapter(context, articles, this@HomeFragment)
        }
    }

    override fun onItemClick(pos: Int, data: Any) {
        redirectToDetail(data as ArticlesModel)
    }

    private fun redirectToDetail(article: ArticlesModel) {
        navController.navigate(
            R.id.action_homeFragment_to_detailFragment,
            bundleOf("article" to article)
        )
    }

    private fun setObserver() {

        homeViewModel.getNewsFeeds().observe(this) {
            when (it.status) {
                Status.LOADING -> {
                    binding.progress.visibility = View.VISIBLE
                }
                Status.SUCCESS -> {
                    binding.progress.visibility = View.GONE
                    articles.clear()
                    articles.addAll(it.data!!)
                    binding.rvNews.adapter?.notifyDataSetChanged()
                }
                Status.ERROR -> {
                    binding.progress.visibility = View.GONE
                }

            }
        }

    }

}