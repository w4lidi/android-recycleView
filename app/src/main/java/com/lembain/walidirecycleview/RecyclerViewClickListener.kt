package com.lembain.walidirecycleview

import android.view.View

interface RecyclerViewClickListener {
    fun onItemClickListener(view: View, book: Book)
}