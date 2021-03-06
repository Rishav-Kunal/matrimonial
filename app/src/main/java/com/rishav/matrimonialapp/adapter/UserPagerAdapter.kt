package com.rishav.matrimonialapp.adapter

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.rishav.matrimonialapp.R
import com.rishav.matrimonialapp.ui.UserListFragment
import dagger.hilt.android.qualifiers.ActivityContext
import javax.inject.Inject

class UserPagerAdapter @Inject constructor(@ActivityContext val context : Context) : FragmentStateAdapter(context as FragmentActivity) {
    override fun getItemCount(): Int {
        //static count for now
        return context.resources.getStringArray(R.array.tabs).size
    }

    override fun createFragment(position: Int): Fragment {
        return UserListFragment.newInstance(position)
    }
}