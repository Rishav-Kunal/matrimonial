package com.rishav.matrimonialapp.adapter

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.DiffUtil
import android.view.LayoutInflater
import androidx.databinding.DataBindingUtil
import com.rishav.matrimonialapp.R
import com.rishav.matrimonialapp.data.UserResult
import com.rishav.matrimonialapp.databinding.UserListItemLargeBinding
import com.rishav.matrimonialapp.util.ApplicationConstants
import com.rishav.matrimonialapp.util.ItemClickListener
import javax.inject.Inject

class UserListAdapter @Inject constructor() : RecyclerView.Adapter<UserListAdapter.ResultViewHolder>() {

    private var data: List<UserResult> = ArrayList()
    var clickListener : ItemClickListener<UserResult>? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ResultViewHolder {
        val userListItemBinding: UserListItemLargeBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.user_list_item_large, parent, false
        )
        return ResultViewHolder(userListItemBinding)
    }

    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: ResultViewHolder, position: Int) =
        holder.bind(data[position])

    fun updateData(newList: List<UserResult>) {
        val diffResult: DiffUtil.DiffResult =
            DiffUtil.calculateDiff(ResultDiffUtil(data, newList))
        diffResult.dispatchUpdatesTo(this)
        data = newList
    }

    inner class ResultViewHolder(private val binding: UserListItemLargeBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: UserResult) = with(itemView) {
            binding.user = item
            if (item.userAction == ApplicationConstants.USER_ACTION_ACCEPTED){
                binding.tvActionMessage.text = "Member Accepted"
            } else if (item.userAction == ApplicationConstants.USER_ACTION_DECLINED){
                binding.tvActionMessage.text = "Member Declined"
            }
            binding.ivAccept.setOnClickListener { clickListener?.onItemClicked(item, true) }
            binding.tvAccept.setOnClickListener { clickListener?.onItemClicked(item, true) }

            binding.ivReject.setOnClickListener { clickListener?.onItemClicked(item, false) }
            binding.tvReject.setOnClickListener { clickListener?.onItemClicked(item, false) }
        }
    }

    inner class ResultDiffUtil(var oldList: List<UserResult>, var newList: List<UserResult>) :
        DiffUtil.Callback() {
        override fun getOldListSize(): Int {
            return oldList.size
        }

        override fun getNewListSize(): Int {
            return newList.size
        }

        override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            return oldList[oldItemPosition].email == newList[newItemPosition].email
        }

        override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            return oldList[oldItemPosition] == newList[newItemPosition]
        }

    }
}