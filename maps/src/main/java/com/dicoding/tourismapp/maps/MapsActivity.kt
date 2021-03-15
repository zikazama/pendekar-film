package com.dicoding.tourismapp.maps

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isGone
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import com.dicoding.tourismapp.core.data.Resource
import com.dicoding.tourismapp.core.ui.TourismAdapter
import com.dicoding.tourismapp.detail.DetailTourismActivity
import com.dicoding.tourismapp.di.MapsModuleDependencies
import com.dicoding.tourismapp.maps.databinding.ActivityMapsBinding
import dagger.hilt.android.EntryPointAccessors
import javax.inject.Inject

class MapsActivity : AppCompatActivity() {

    @Inject
    lateinit var factory: ViewModelFactory

    private val mapsViewModel: MapsViewModel by viewModels {
        factory
    }

    private lateinit var binding: ActivityMapsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        DaggerMapsComponent.builder()
            .context(this)
            .appDependencies(
                EntryPointAccessors.fromApplication(
                    applicationContext,
                    MapsModuleDependencies::class.java
                )
            )
            .build()
            .inject(this)
        super.onCreate(savedInstanceState)
        binding = ActivityMapsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.title = "Favorite Film"

        getTourismData()
    }

    private fun getTourismData() {

        val tourismAdapter = TourismAdapter()
        tourismAdapter.onItemClick = { selectedData ->
            val intent = Intent(this, DetailTourismActivity::class.java)
            intent.putExtra(DetailTourismActivity.EXTRA_DATA, selectedData)
            startActivity(intent)
        }

        mapsViewModel.tourism.observe(this, { tourism ->
            tourismAdapter.setData(tourism)
            binding.viewEmpty.visibility = if (tourism.isNotEmpty()) View.GONE else View.VISIBLE
        })

        with(binding.rvTourism) {
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
            adapter = tourismAdapter
        }
    }
}