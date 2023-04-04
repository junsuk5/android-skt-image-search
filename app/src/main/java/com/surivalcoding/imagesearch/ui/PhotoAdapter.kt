package com.surivalcoding.imagesearch.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.surivalcoding.imagesearch.R
import com.surivalcoding.imagesearch.data.Photo

class PhotoAdapter(
    private val onClicked: (Photo) -> Unit = {},
) : ListAdapter<Photo, PhotoAdapter.ViewHolder>(
    object : DiffUtil.ItemCallback<Photo>() {
        override fun areItemsTheSame(oldItem: Photo, newItem: Photo): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Photo, newItem: Photo): Boolean {
            return oldItem == newItem
        }
    }
) {

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder)
     */
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imageView: ImageView

        init {
            imageView = view.findViewById(R.id.imageView)
        }
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.item_photo, viewGroup, false)

        return ViewHolder(view)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        val photo = getItem(position)

        Glide.with(viewHolder.itemView)
            .load(photo.previewURL)
            .into(viewHolder.imageView)


        // 클릭 이벤트 정의
        viewHolder.itemView.setOnClickListener {
            // 콜백으로 처리하는 부분으로 돌려줘야 함
//            println(dataSet[viewHolder.adapterPosition])
            onClicked(getItem(viewHolder.adapterPosition))
        }

    }

}
