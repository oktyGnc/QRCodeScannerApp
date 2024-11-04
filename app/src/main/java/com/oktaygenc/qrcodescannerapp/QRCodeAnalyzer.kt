package com.oktaygenc.qrcodescannerapp

import androidx.camera.core.ImageAnalysis
import androidx.camera.core.ImageProxy
import com.google.mlkit.vision.barcode.BarcodeScanning
import com.google.mlkit.vision.common.InputImage
import java.util.concurrent.atomic.AtomicBoolean

class QRCodeAnalyzer(private val onQRCodeFound: (String) -> Unit) : ImageAnalysis.Analyzer {
    private val scanner = BarcodeScanning.getClient()
    private val isScanning = AtomicBoolean(false)
    private var lastScannedUrl: String? = null
    private var lastScanTime: Long = 0
    private val SCAN_DELAY_MS = 3000

    @androidx.camera.core.ExperimentalGetImage
    override fun analyze(imageProxy: ImageProxy) {
        if (isScanning.get() || System.currentTimeMillis() - lastScanTime < SCAN_DELAY_MS) {
            imageProxy.close()
            return
        }

        val mediaImage = imageProxy.image
        if (mediaImage != null) {
            isScanning.set(true)
            val image = InputImage.fromMediaImage(mediaImage, imageProxy.imageInfo.rotationDegrees)

            scanner.process(image)
                .addOnSuccessListener { barcodes ->
                    for (barcode in barcodes) {
                        if (barcode.valueType == com.google.mlkit.vision.barcode.common.Barcode.TYPE_URL) {
                            barcode.url?.url?.let { url ->
                                if (url != lastScannedUrl) {
                                    lastScannedUrl = url
                                    lastScanTime = System.currentTimeMillis()
                                    onQRCodeFound(url)
                                }
                            }
                        }
                    }
                }
                .addOnCompleteListener {
                    isScanning.set(false)
                    imageProxy.close()
                }
        } else {
            imageProxy.close()
        }
    }
}