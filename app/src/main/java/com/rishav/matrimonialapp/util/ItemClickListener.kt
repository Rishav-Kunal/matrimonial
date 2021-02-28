package com.rishav.matrimonialapp.util

interface ItemClickListener<T> {
    fun onItemClicked(item : T, accepted : Boolean)
}