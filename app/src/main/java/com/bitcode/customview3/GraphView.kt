package com.bitcode.customview3

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.widget.ImageView

class GraphView(
    context: Context,
    attributeSet: AttributeSet? = null
) : androidx.appcompat.widget.AppCompatImageView(context, attributeSet) {

    var values : IntArray? = null

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        var myPaint = Paint()
        myPaint.setColor(Color.RED)

        var linePaint = Paint()
        linePaint.setColor(Color.WHITE)
        linePaint.strokeWidth = 5F

        var barWidth = width / values!!.size
        var heightToPrecent = height / 100

        for(i in 0..values!!.size-1) {
            canvas!!.drawRect(
                (i * barWidth).toFloat(), height.toFloat(),
                (i* barWidth) + barWidth.toFloat(), (height - values!![i] * heightToPrecent).toFloat(),
                myPaint
            )
            canvas.drawLine(
                (i* barWidth) + barWidth.toFloat(), height.toFloat(),
                (i* barWidth) + barWidth.toFloat(), (height - values!![i] * heightToPrecent).toFloat(),
                linePaint
            )
        }

    }
}