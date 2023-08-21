package com.example.photogallery.ui.fragments.main.adapter

data class PagedData<T>(
    val totalCount: Int,
    val perPage: Int,
    val currentPage: Int,
    val list: List<T>,
    val listSize: Int = list.size
) {
    override fun toString() = "[totalCount: $totalCount, perPage: $perPage, currentPage: $currentPage, listSize: $listSize]"
}