package com.tolerans.vitrinova.ui.main

import android.app.Activity
import android.app.SearchManager
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.speech.RecognizerIntent
import android.util.Log
import android.view.*
import android.widget.SearchView
import android.widget.Toast
import androidx.core.content.ContextCompat.getSystemService
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.tolerans.vitrinova.R
import com.tolerans.vitrinova.databinding.FragmentMainBinding
import com.tolerans.vitrinova.ui.adapter.DiscoverParentRvAdapter
import com.tolerans.vitrinova.util.Constant
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.collect


@AndroidEntryPoint
@ExperimentalCoroutinesApi
class MainFragment : Fragment() {
    val mainViewModel: MainViewModel by viewModels()
    lateinit var  binding : FragmentMainBinding
    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_main, container, false)
        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        lifecycleScope.launchWhenCreated {
            mainViewModel.discoverElement.collect{ discoverEvent->

                when(discoverEvent){
                    is MainViewModel.DiscoverEvent.Loading -> {

                    }
                    is MainViewModel.DiscoverEvent.Error -> {
                        Toast.makeText(requireContext(), discoverEvent.errText, Toast.LENGTH_SHORT).show()
                    }
                    is MainViewModel.DiscoverEvent.Success -> {
                        val layoutManager = LinearLayoutManager(requireContext())
                        layoutManager.orientation = LinearLayoutManager.VERTICAL
                        binding.rvMain.layoutManager = layoutManager

                        binding.rvMain.adapter = DiscoverParentRvAdapter(discoverEvent.item)
                    }
                }

            }

        }


        binding.swRefreshMain.setOnRefreshListener {
            binding.swRefreshMain.isRefreshing = true
            mainViewModel.initData()
            binding.swRefreshMain.isRefreshing = false
            binding.srcMainToolbar.setQuery("",false)
        }

        binding.btnMainToolbarVoice.setOnClickListener {
            val intent = Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH)

            intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, "tr-TR")
            startActivityForResult(intent, Constant.VOICE_REQUEST_CODE)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if(requestCode == Constant.VOICE_REQUEST_CODE){
            if(data!=null && resultCode == Activity.RESULT_OK) {
                data!!.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS)?.let {

                    binding.srcMainToolbar.setQuery(  it.get(0),false)
                }


            }
        }
    }

}