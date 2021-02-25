package com.dicoding.made.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.dicoding.made.R
import com.dicoding.made.core.domain.model.Teams
import com.dicoding.made.databinding.ActivityDetailTeamBinding
import org.koin.android.viewmodel.ext.android.viewModel

class DetailTeamActivity : AppCompatActivity() {
    companion object {
        const val EXTRA_DATA = "extra_data"
    }

    private val detailTeamsViewModel : DetailTeamsViewModel by viewModel()
    private lateinit var binding : ActivityDetailTeamBinding
    private var menuItem: Menu? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDetailTeamBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val detailTeams = intent.getParcelableExtra<Teams>(EXTRA_DATA)
        showDetailTeams(detailTeams)

    }

    private fun showDetailTeams(detailTeams : Teams?) {
        detailTeams?.let {
            supportActionBar?.title = detailTeams.strTeam
            binding.tvTeamName.text = getString(R.string.label_team_name,detailTeams.strTeam)
            binding.tvTeamStadium.text = getString(R.string.label_stadium_name, detailTeams.strStadium)
            binding.tvTeamDescription.text = detailTeams.strDescriptionEn
            Glide.with(this@DetailTeamActivity)
                .load(detailTeams.strTeamBadge)
                .into(binding.ivItemBadge)

            var statusFavorite = detailTeams.isFavorite
            setStatusFavorite(statusFavorite)
            binding.fab.setOnClickListener {
                statusFavorite = !statusFavorite
                detailTeamsViewModel.setFavoriteTeams(detailTeams,statusFavorite)
                setStatusFavorite(statusFavorite)
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_detail, menu)
        menuItem = menu

        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId)
        {
            android.R.id.home ->
            {
                finish()
                return super.onOptionsItemSelected(item)
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun setStatusFavorite(statusFavorite: Boolean) {
        if (statusFavorite) {
            binding.fab.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_favorite_white))
        } else {
            binding.fab.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_not_favorite_white))
        }
    }

}