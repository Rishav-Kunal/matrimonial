package com.rishav.matrimonialapp.util

import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.rishav.matrimonialapp.R

class BindingAdapter {
    companion object{
        @JvmStatic
        @BindingAdapter("imageUrl")
        fun loadImage(view: ImageView, url: String?) {
            Glide.with(view.context)
                    .load(url)
                    .placeholder(R.drawable.loading_animation)
                    .into(view)
        }

        @JvmStatic
        @BindingAdapter("app:isVisible")
        fun setVisibility(view: View, visibility : Boolean) {
            view.visibility = if (visibility) View.VISIBLE else View.GONE
        }
    }
}