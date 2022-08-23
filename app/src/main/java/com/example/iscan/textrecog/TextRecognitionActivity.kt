package com.example.iscan.textrecog

import androidx.core.content.ContextCompat
import com.example.iscan.BaseLensActivity

class TextRecognitionActivity : BaseLensActivity() {

    override val imageAnalyzer = TextAnalyzer(this,this)

    override fun startScanner() {
        startTextRecognition()
    }

    private fun startTextRecognition() {
        imageAnalysis.setAnalyzer(
            ContextCompat.getMainExecutor(this),
            imageAnalyzer
        )
    }
}