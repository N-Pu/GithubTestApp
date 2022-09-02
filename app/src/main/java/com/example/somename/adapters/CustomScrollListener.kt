package com.example.somename.adapters

import androidx.annotation.NonNull
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView



abstract class CustomScrollListener() : RecyclerView.OnScrollListener() {
    @SuppressWarnings("FieldCanBeLocal")
    private val VISIBLE_TRESHOLD = 10
    private var currentPage = 0
    private var previousTotalItemCount = 0
    private var loading = true
    private var mLayoutManager = LinearLayoutManager(AppCompatActivity().applicationContext)

    constructor(layoutManager: LinearLayoutManager) : this() {
        this.mLayoutManager = layoutManager
    }


    override fun onScrolled(@NonNull view: RecyclerView, dx: Int, dy: Int) {
        var lastVisibleItemPosition = 0
        val totalItemCount = mLayoutManager.getItemCount()

        lastVisibleItemPosition = mLayoutManager.findLastVisibleItemPosition()


        if (loading && (totalItemCount > previousTotalItemCount)) {
            loading = false
            previousTotalItemCount = totalItemCount
        }

        if (!loading && (lastVisibleItemPosition + VISIBLE_TRESHOLD) > totalItemCount) {
            currentPage++
            onLoadMore(currentPage, totalItemCount, view)
            loading = true
        }
    }

    abstract fun onLoadMore(page: Int, totalItemCount: Any, view: RecyclerView)

}