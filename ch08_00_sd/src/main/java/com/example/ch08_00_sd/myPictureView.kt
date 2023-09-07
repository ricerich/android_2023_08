package com.example.ch08_00_sd

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.util.AttributeSet
import android.view.View
import java.lang.Exception

class myPictureView(context: Context, attrs: AttributeSet?) : View(context, attrs) {
    public var imagePath : String? = null
    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        try {
            if (imagePath != null) {
                var bitmap = BitmapFactory.decodeFile(imagePath)
                canvas.scale(4f, 4f, 0f, 0f)
                canvas.drawBitmap(bitmap!!, 0f, 0f, null)
                bitmap!!.recycle()
            }
        }catch (e : Exception) {
        }
    }
}
