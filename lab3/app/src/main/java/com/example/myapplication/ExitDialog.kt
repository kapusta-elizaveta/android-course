package com.example.myapplication

import android.app.Activity
import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import android.os.Build
import android.os.Bundle
import androidx.fragment.app.DialogFragment

class ExitDialog : DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialogBuilder = AlertDialog.Builder(activity)
        dialogBuilder.setMessage("Вы точно хотите выйти?")
            .setPositiveButton("Да", DialogInterface.OnClickListener {
                    dialog, id -> if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                (activity as Activity).finishAndRemoveTask()
            }
            })
            .setNegativeButton("Нет", DialogInterface.OnClickListener {
                    dialog, id -> dialog.cancel()
            })
        return dialogBuilder.create();
    }
}