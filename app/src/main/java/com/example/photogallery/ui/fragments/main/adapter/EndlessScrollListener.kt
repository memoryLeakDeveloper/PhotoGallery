package com.example.photogallery.ui.fragments.main.adapter

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.photogallery.utils.bugger

abstract class EndlessScrollListener(
    private val logTag: String = "",
    private val layoutManager: LinearLayoutManager,
    spanCount: Int = 1
) : RecyclerView.OnScrollListener() {

    private var visibleThreshold = 2 * spanCount
    private var currentPage = 0

    private var totalCount = 0
    private var currentCount = 0

    private var isLoading = true

    // Sets the starting page index
    private val startingPageIndex = 0

    override fun onScrolled(view: RecyclerView, dx: Int, dy: Int) {
        if (isLoading) {
            bugger("$logTag. onScrolled. isLoading = true. RETURN")
            return
        }
        val lastVisibleItemPosition = layoutManager.findLastVisibleItemPosition()

        bugger("$logTag. -----onScrolled----")
        bugger(
            "$logTag. isLoading: $isLoading, " +
                    "currentPage: $currentPage, " +
                    "currentCount: $currentCount, " +
                    "totalCount: $totalCount "
        )

        val toLoadMore = !isLoading && lastVisibleItemPosition + visibleThreshold > currentCount && currentCount < totalCount
        bugger(
            "$logTag. check threshold: ${if (toLoadMore) "LOAD MORE" else "nothing"}. isLoading: $isLoading, " +
                    "lastVisible($lastVisibleItemPosition) + threshold($visibleThreshold) > currentCount($currentCount), " +
                    "currentCount($currentCount) > totalCount($totalCount)"
        )

        if (toLoadMore) {
            currentPage++
            onLoadMore(currentPage)
            isLoading = true
        }
    }

    abstract fun onLoadMore(page: Int)

    fun <T> setPagedData(pagedData: PagedData<T>) {
        bugger("${logTag}. setPagedData: $pagedData")
        totalCount = pagedData.totalCount
        currentPage = pagedData.currentPage
        currentCount = pagedData.listSize
        isLoading = false
    }

}