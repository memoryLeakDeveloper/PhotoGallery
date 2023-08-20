package com.example.photogallery.ui.dialog

import android.content.Context
import android.widget.ProgressBar
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class LoadingDialog(private val minShowingTime: Long = 300) {

    private var dialogHelper = BaseDialog()

    private var dialogShowAt = 0L

    fun showDialog(context: Context) {
        dialogShowAt = System.currentTimeMillis()
        dialogHelper.showDialog(ProgressBar(context), cancelable = false)
    }

    fun hideDialog() {
        if (System.currentTimeMillis() > dialogShowAt + minShowingTime) {
            dialogHelper.hideDialog()
            dialogShowAt = 0L
        } else {
            CoroutineScope(Dispatchers.Main).launch {
                delay((dialogShowAt + minShowingTime) - System.currentTimeMillis())
                hideDialog()
            }
        }
    }

    suspend fun awaitAndHideDialog() {
        if (System.currentTimeMillis() > dialogShowAt + minShowingTime) {
            dialogHelper.hideDialog()
            dialogShowAt = 0L
        } else {
            delay((dialogShowAt + minShowingTime) - System.currentTimeMillis())
            awaitAndHideDialog()
        }
    }
}