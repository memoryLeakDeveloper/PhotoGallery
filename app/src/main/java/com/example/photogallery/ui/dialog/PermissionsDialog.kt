package com.example.photogallery.ui.dialog

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.provider.Settings
import android.view.LayoutInflater
import com.example.photogallery.databinding.DialogPermissionsBinding

class PermissionsDialog {

    private val dialogHelper = BaseDialog()

    fun showDialog(context: Context) {
        val dialogBinding = DialogPermissionsBinding.inflate(LayoutInflater.from(context))
        dialogBinding.apply {
            btSettings.setOnClickListener {
                val intent = Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS)
                val uri: Uri = Uri.fromParts("package", context.packageName, null)
                intent.data = uri
                context.startActivity(intent)
                dialogHelper.hideDialog()
            }
        }
        dialogHelper.showDialog(dialogBinding.root)
    }
}