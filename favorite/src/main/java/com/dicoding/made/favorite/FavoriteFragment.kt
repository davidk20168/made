package com.dicoding.made.favorite

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.dicoding.made.core.ui.TeamsAdapter
import com.dicoding.made.detail.DetailTeamActivity
import com.dicoding.made.favorite.databinding.FragmentFavoriteBinding
import org.koin.android.viewmodel.ext.android.viewModel


class FavoriteFragment : Fragment() {
    private val favoriteViewModel : FavoriteViewModel by viewModel()

    private var _binding : FragmentFavoriteBinding? = null
    private val binding get() = _binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFavoriteBinding.inflate(inflater,container,false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if(activity!=null)
        {
            val teamsAdapter = TeamsAdapter()
            teamsAdapter.onItemClick = { selectedData ->
                val intent = Intent(activity, DetailTeamActivity::class.java)
                intent.putExtra(DetailTeamActivity.EXTRA_DATA, selectedData)
                startActivity(intent)
            }

            favoriteViewModel.favoriteTeams.observe(viewLifecycleOwner, { dataTeams ->
                teamsAdapter.setData(dataTeams)
                binding?.viewEmpty?.root?.visibility = if (dataTeams.isNotEmpty()) View.GONE else View.VISIBLE
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