package com.example.iscan

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

import android.content.Intent
import com.example.iscan.barcode.BarcodeActivity
import com.example.iscan.facedetect.FaceDetectActivity
import com.example.iscan.imagelabeler.ImageLabelingActivity
import com.example.iscan.textrecog.TextRecognitionActivity
import com.example.iscan.R


class RecyclerAdapter : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

    private var title = arrayOf(
        "QR/Barcode scanning",
        "Face detection",
        "Image labeling",
        "Text recognition"
    )
    private var desc =
        arrayOf(
            "Scan and process barcodes. Supports most standard 1D and 2D formats.",
            "Detect faces and facial landmarks.",
            "Identify objects, locations, activities, animal species, products, and more. Use a general-purpose base model to your use case with a custom TensorFlow Lite model.",
            "Recognize and extract text from images."
        )

    private var image = intArrayOf(
        R.drawable.bar_code,
        R.drawable.face_detection,
        R.drawable.image,
        R.drawable.text
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.card_layout, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemTitle.text = title[position]
        holder.itemDetail.text = desc[position]
        holder.itemImage.setImageResource(image[position])
    }

    override fun getItemCount(): Int {
        return title.size
    }


    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var itemImage: ImageView
        var itemTitle: TextView
        var itemDetail: TextView
        val context = itemView.context
        init {
            itemImage = itemView.findViewById(R.id.imgView)
            itemTitle = itemView.findViewById(R.id.tvTitle)
            itemDetail = itemView.findViewById(R.id.tvDesc)

            itemView.setOnClickListener {
                val pos: Int = adapterPosition
                passData(pos)
            }

        }
        private fun passData(pos: Int) {
            when (pos) {
                0 -> {
                    context.startActivity(Intent(context, BarcodeActivity::class.java).putExtra("tb",title[pos]))
                }
                1 -> {
                    context.startActivity(Intent(context, FaceDetectActivity::class.java).putExtra("tb",title[pos]))
                }
                2 -> {
                    context.startActivity(Intent(context, ImageLabelingActivity::class.java).putExtra("tb",title[pos]))
                }
                3 -> {
                    context.startActivity(Intent(context, TextRecognitionActivity::class.java).putExtra("tb",title[pos]))
                }
            }
        }
    }



}