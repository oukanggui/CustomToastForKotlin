package com.baymax.customtoast.kotlin

import android.app.Activity
import android.content.Context
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

/**
 * @author oukanggui
 * @date 2019-06-23
 * Custom toast helper
 * Use:
 * var toastHelper = ToastHelper(this)
 * toastHelper.setView(R.layout.toast_custom)
 * toastHelper.setText("I am baymax from Custom Toast")
 * toastHelper.show()
 */
class ToastHelper(private val context: Context) {
    private var mToast: Toast

    init {
        mToast = Toast(context)
    }

    /**
     * Set the view for the Toast
     * Note:the custom layout must contain the id @+id/toast_icon for ImageView and the id @+id/toast_message for TextView
     * @param layoutId
     */
    fun setView(layoutId: Int) {
        mToast.view = LayoutInflater.from(context).inflate(layoutId, null, false)
    }

    /**
     * Set the text showed for Toast
     * @param message
     */
    fun setText(message: String) {
        ensureToastRootView()
        var tvMessage: TextView = mToast.view.findViewById(R.id.toast_message)
        tvMessage.text = message
    }

    /**
     * Set the image for the Toast
     * @param resId
     */
    fun setImage(resId: Int) {
        ensureToastRootView()
        var ivIcon: ImageView = mToast.view.findViewById(R.id.toast_icon)
        ivIcon.visibility = View.VISIBLE
        ivIcon.setImageResource(resId)
    }

    private fun ensureToastRootView() {
        // 使用前，保证Toast的View不能为空
        if (mToast.view == null) {
            // 使用默认布局
            val rootView = LayoutInflater.from(context).inflate(R.layout.toast_custom, null, false)
            mToast.view = rootView
        }
    }

    /**
     * Show the Toast,default duration is Toast.LENGTH_SHORT
     */
    fun show(duration: Int = Toast.LENGTH_SHORT) {
        // 函数表达式
        val uiRunnable: () -> Unit = {
            mToast.duration = duration
            mToast.show()
        }

        if (context is Activity && !context.isFinishing) {
            context.runOnUiThread(uiRunnable)
        } else {
            var uiHandler = Handler(Looper.getMainLooper())
            uiHandler.post(uiRunnable)
        }
    }
}