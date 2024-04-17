package com.example.etonsillitis.modelWork

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import org.tensorflow.lite.DataType
import org.tensorflow.lite.Interpreter
import org.tensorflow.lite.support.tensorbuffer.TensorBuffer
import java.io.FileInputStream
import java.nio.ByteBuffer
import java.nio.ByteOrder
import java.nio.channels.FileChannel


class CNNviewModel(private val context: Context) : ViewModel() {
    val predictionResult = MutableLiveData<Predictions>()

    private lateinit var tflite: Interpreter
    private lateinit var tfliteModel: ByteBuffer

    init {
        loadModel()
    }

    private fun loadModel() {
        val assetManager = context.assets
        val fileDescriptor = assetManager.openFd("model_unquant.tflite")
        val inputStream = FileInputStream(fileDescriptor.fileDescriptor)
        val fileChannel = inputStream.channel
        val startOffset = fileDescriptor.startOffset
        val declaredLength = fileDescriptor.declaredLength
        tfliteModel = fileChannel.map(FileChannel.MapMode.READ_ONLY, startOffset, declaredLength)
        tflite = Interpreter(tfliteModel)
    }

    fun classifyImage(imagePath: String) {
        val bitmap = BitmapFactory.decodeFile(imagePath)
        val byteBuffer = convertBitmapToByteBuffer(bitmap)

        val inputFeature0 =
            TensorBuffer.createFixedSize(intArrayOf(1, 224, 224, 3), DataType.FLOAT32)
        inputFeature0.loadBuffer(byteBuffer)

        // Get output tensor shape from the model
        val outputShape = tflite.getOutputTensor(0).shape()
        val outputSize = outputShape.fold(1, { a, b -> a * b })

        // Create output tensor with the correct size
        val outputFeature0 = TensorBuffer.createFixedSize(intArrayOf(outputSize), DataType.FLOAT32)

        tflite.run(inputFeature0.buffer, outputFeature0.buffer.rewind())

        val predictedClass = outputFeature0.floatArray

        predictionResult.value = Predictions(
            bacterial = predictedClass[0],
            viral = predictedClass[1],
            normal = predictedClass[2],
            unknown = predictedClass[3]
        )
    }

    private fun convertBitmapToByteBuffer(bitmap: Bitmap): ByteBuffer {
        // Resize the bitmap to 224x224 pixels
        val resizedBitmap = Bitmap.createScaledBitmap(bitmap, 224, 224, true)

        val byteBuffer = ByteBuffer.allocateDirect(4 * 1 * 224 * 224 * 3) // float has 4 bytes
        byteBuffer.order(ByteOrder.nativeOrder())
        val intValues = IntArray(224 * 224)
        resizedBitmap.getPixels(intValues, 0, resizedBitmap.width, 0, 0, resizedBitmap.width, resizedBitmap.height)
        var pixel = 0
        for (i in 0 until 224) {
            for (j in 0 until 224) {
                val value = intValues[pixel++]
                byteBuffer.putFloat(((value shr 16 and 0xFF) - 127.5f) / 127.5f)
                byteBuffer.putFloat(((value shr 8 and 0xFF) - 127.5f) / 127.5f)
                byteBuffer.putFloat(((value and 0xFF) - 127.5f) / 127.5f)
            }
        }
        return byteBuffer
    }


}

data class Predictions(
    val viral: Float = .0f,
    val bacterial: Float = .0f,
    val normal: Float = .0f,
    val unknown: Float = .0f

)