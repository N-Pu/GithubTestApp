package com.example.somename.adapters

import androidx.annotation.NonNull
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


abstract class CustomScrollListener() :
    RecyclerView.OnScrollListener() {


    @SuppressWarnings("FieldCanBeLocal")
    private val VISIBLE_TRESHOLD = 10
    private var currentPage = 0
    private var previousTotalItemCount = 0
    private var loading = true

    private lateinit var mLayoutManager: LinearLayoutManager

    constructor(layoutManager: LinearLayoutManager) : this() {
        this.mLayoutManager = layoutManager
    }

    @OptIn(DelicateCoroutinesApi::class)
    override fun onScrolled(@NonNull view: RecyclerView, dx: Int, dy: Int) {
        var lastVisibleItemPosition = 0
        val totalItemCount = mLayoutManager.itemCount

        lastVisibleItemPosition = mLayoutManager.findLastVisibleItemPosition()


        if (loading && (totalItemCount > previousTotalItemCount)) {
            loading = false
            previousTotalItemCount = totalItemCount
        }

        if (!loading && (lastVisibleItemPosition + VISIBLE_TRESHOLD) > totalItemCount) {
            currentPage++
            GlobalScope.launch { onLoadMore(currentPage, totalItemCount, view) }
            loading = true
        }
    }

    abstract  fun onLoadMore(page: Int, totalItemCount: Int, view: RecyclerView)

}