package com.marcosmendes.instagram.common.view

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import com.marcosmendes.instagram.R

class CustomDialog(context: Context) : Dialog(context) {

    private lateinit var dialogLinearLayout: LinearLayout
    private lateinit var txtButtons: Array<TextView>
    private lateinit var txtTitle: TextView

    private var titleId: Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dialog_custom)

        dialogLinearLayout = findViewById(R.id.dialog_container)

        txtTitle = findViewById(R.id.dialog_title)
        titleId?.let {
            txtTitle.setText(it)
        }

    }

    fun addButton(vararg texts: Int, listener: View.OnClickListener) {
        txtButtons = Array(texts.size) {
            TextView(context)
        }

        texts.forEachIndexed { index, txtId ->
            txtButtons[index].id = txtId
            txtButtons[index].setText(txtId)

            txtButtons[index].setOnClickListener {
                listener.onClick(it)
                dismiss()
                Log.i("teste", (it as TextView ).text.toString())

            }
        }

    }

    override fun setTitle(titleId: Int) {
        this.titleId = titleId
        titleId?.let {
        }
    }

    override fun show() {
        super.show()
        val layoutParams = LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT)
        layoutParams.setMargins(30, 50, 30, 50)

        for (textView in txtButtons) {
            dialogLinearLayout.addView(textView, layoutParams)
        }
    }



}