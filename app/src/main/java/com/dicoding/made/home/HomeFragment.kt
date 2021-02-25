package com.dicoding.made.home

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.dicoding.made.R
import com.dicoding.made.core.data.source.Resource
import com.dicoding.made.core.ui.TeamsAdapter
import com.dicoding.made.databinding.FragmentHomeBinding
import com.dicoding.made.detail.DetailTeamActivity
import org.koin.android.viewmodel.ext.android.viewModel

class HomeFragment : Fragment() {
    private val homeViewModel : HomeViewModel by viewModel()

    private var _binding : FragmentHomeBinding? = null
    private val binding get() = _binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ) : View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if(activity != null)
        {
            val teamsAdapter = TeamsAdapter()
            teamsAdapter.onItemClick = { selectedData ->
                val intent = Intent(activity, DetailTeamActivity::class.java)
                intent.putExtra(DetailTeamActivity.EXTRA_DATA, selectedData)
                startActivity(intent)
            }

            homeViewModel.teams.observe(viewLifecycleOwner, { teams ->
                if (teams != null)
                {
                    when(teams) {
                        is Resource.Loading -> binding?.progressBar?.visibility = View.VISIBLE
                        is Resource.Success -> {
                            binding?.progressBar?.visibility = View.GONE
                            teamsAdapter.setData(teams.data)
                        }
                        is Resource.Error -> {
                            binding?.progressBar?.visibility = View.GONE
                            binding?.viewError?.root?.visibility = View.VISIBLE
                            binding?.viewError?.tvError?.text = teams.message ?: getString(R.string.something_wrong)
                        }
                    }
                }

            })

            binding?.let {
                with(it.rvListTeams) {
                    layoutManager = LinearLayoutManager(context)
                    setHasFixedSize(true)
                    adapter = teamsAdapter
                }
            }

        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}