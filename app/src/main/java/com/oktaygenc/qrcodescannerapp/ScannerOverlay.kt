package com.oktaygenc.qrcodescannerapp

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.RectF
import android.util.AttributeSet
import android.view.View

class ScannerOverlay @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0,
) : View(context, attrs, defStyleAttr) {

    private val squarePaint = Paint().apply {
        color = Color.WHITE
        style = Paint.Style.STROKE
        strokeWidth = 8f
    }

    private val overlayPaint = Paint().apply {
        color = Color.parseColor("#80000000") // Yarı saydam siyah
    }

    private val cornerPaint = Paint().apply {
        color = Color.GREEN
        style = Paint.Style.STROKE
        strokeWidth = 12f
    }

    private val scannerRect = RectF()
    private val cornerLength = 100f

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        // Ekran boyutları
        val width = width.toFloat()
        val height = height.toFloat()

        // Tarayıcı kare boyutu (ekranın %70'i)
        val squareSize = (width.coerceAtMost(height) * 0.7f).toInt()

        // Tarayıcı karesinin pozisyonu
        val left = (width - squareSize) / 2
        val top = (height - squareSize) / 2
        scannerRect.set(left, top, left + squareSize, top + squareSize)

        // Yarı saydam overlay çizimi
        canvas.drawRect(0f, 0f, width, scannerRect.top, overlayPaint) // Üst
        canvas.drawRect(
            0f,
            scannerRect.top,
            scannerRect.left,
            scannerRect.bottom,
            overlayPaint
        ) // Sol
        canvas.drawRect(
            scannerRect.right,
            scannerRect.top,
            width,
            scannerRect.bottom,
            overlayPaint
        ) // Sağ
        canvas.drawRect(0f, scannerRect.bottom, width, height, overlayPaint) // Alt

        // Ana kare çizimi
        canvas.drawRect(scannerRect, squarePaint)

        // Köşe çizgileri
        // Sol üst köşe
        canvas.drawLine(
            scannerRect.left,
            scannerRect.top,
            scannerRect.left + cornerLength,
            scannerRect.top,
            cornerPaint
        )
        canvas.drawLine(
            scannerRect.left,
            scannerRect.top,
            scannerRect.left,
            scannerRect.top + cornerLength,
            cornerPaint
        )

        // Sağ üst köşe
        canvas.drawLine(
            scannerRect.right - cornerLength,
            scannerRect.top,
            scannerRect.right,
            scannerRect.top,
            cornerPaint
        )
        canvas.drawLine(
            scannerRect.right,
            scannerRect.top,
            scannerRect.right,
            scannerRect.top + cornerLength,
            cornerPaint
        )

        // Sol alt köşe
        canvas.drawLine(
            scannerRect.left,
            scannerRect.bottom - cornerLength,
            scannerRect.left,
            scannerRect.bottom,
            cornerPaint
        )
        canvas.drawLine(
            scannerRect.left,
            scannerRect.bottom,
            scannerRect.left + cornerLength,
            scannerRect.bottom,
            cornerPaint
        )

        // Sağ alt köşe
        canvas.drawLine(
            scannerRect.right - cornerLength,
            scannerRect.bottom,
            scannerRect.right,
            scannerRect.bottom,
            cornerPaint
        )
        canvas.drawLine(
            scannerRect.right,
            scannerRect.bottom - cornerLength,
            scannerRect.right,
            scannerRect.bottom,
            cornerPaint
        )
    }
}