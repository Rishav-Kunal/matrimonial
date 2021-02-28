package com.rishav.matrimonialapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.rishav.matrimonialapp.adapter.UserListAdapter
import com.rishav.matrimonialapp.data.UserResult
import com.rishav.matrimonialapp.databinding.ActivityMainBinding
import com.rishav.matrimonialapp.util.ItemClickListener
import com.rishav.matrimonialapp.viewmodel.MainActivityViewModel
import dagger.hilt.InstallIn
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    @Inject
    lateinit var adapter: UserListAdapter
    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainActivityViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this
        init()
    }
    private fun init(){
        binding.rvUsers.adapter = adapter
        adapter.clickListener = object : ItemClickListener<UserResult>{
            override fun onItemClicked(item: UserResult, accepted: Boolean) {
                viewModel.applyUserAction(item,accepted)
            }


        }
        viewModel.userLiveData.observe(this, Observer { userList ->
            userList?.let {adapter.updateData(it) }
        })
    }
}