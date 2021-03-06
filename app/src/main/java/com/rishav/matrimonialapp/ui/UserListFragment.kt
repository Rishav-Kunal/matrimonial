package com.rishav.matrimonialapp.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import com.rishav.matrimonialapp.R
import com.rishav.matrimonialapp.adapter.UserListAdapter
import com.rishav.matrimonialapp.data.UserResult
import com.rishav.matrimonialapp.databinding.FragmentUserListBinding
import com.rishav.matrimonialapp.util.ItemClickListener
import com.rishav.matrimonialapp.viewmodel.MainActivityViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


private const val ARG_PARAM1 = "param1"
private const val TAG = "UserListFrag"

@AndroidEntryPoint
class UserListFragment : Fragment() {
    private var position: Int? = null
    private val viewModel: MainActivityViewModel by activityViewModels()
    @Inject
    lateinit var adapter: UserListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            position = it.getInt(ARG_PARAM1)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val binding = DataBindingUtil.inflate<FragmentUserListBinding>(inflater,R.layout.fragment_user_list, container, false)
        binding.viewModel = viewModel
        init(binding)
        return binding.root
    }

    companion object {

        @JvmStatic
        fun newInstance(position: Int) =
                UserListFragment().apply {
                    arguments = Bundle().apply {
                        putInt(ARG_PARAM1, position)
                    }
                }
    }

    private fun init(binding : FragmentUserListBinding){
        binding.rvUsers.adapter = adapter
        adapter.clickListener = object : ItemClickListener<UserResult> {
            override fun onItemClicked(item: UserResult, accepted: Boolean) {
                viewModel.applyUserAction(item,accepted)
            }

        }
        val observer = Observer<List<UserResult>?> { userList ->
            userList?.let {
                if (userList.isEmpty()) {
                    binding.tvEmpty.visibility = View.VISIBLE
                } else {
                    binding.tvEmpty.visibility = View.GONE
                    adapter.updateData(it)
                }
            }
        }
        when(position) {
            0 -> viewModel.acceptedUserLiveData.observe(viewLifecycleOwner,observer)
            1 -> viewModel.userLiveData.observe(viewLifecycleOwner,observer)
            2 -> viewModel.declinedUserLiveData.observe(viewLifecycleOwner,observer)
            else -> Log.d(TAG, "null position ")
        }
    }
}