package com.example.get_proj_images_java;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.get_proj_images_java.R;
import java.util.List;

public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.ImageViewHolder> {

    private List<Images> imagesList;
    private Context context;

    public ImageAdapter(List<Images> imagesList,Context context) {
        this.imagesList = imagesList;
        this.context = context;
    }

    @NonNull
    @Override
    public ImageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.image_item, parent, false);
        return new ImageViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ImageViewHolder holder, int position) {
        Images image = imagesList.get(position);
        holder.title.setText(image.getTitle());
        holder.url.setText(image.getUrl());
        Glide.with(context).load(image.getThumbnailUrl()).into(holder.thumbnailUrl);
    }


    @Override
    public int getItemCount() {
        return imagesList.size();
    }

    class ImageViewHolder extends RecyclerView.ViewHolder {
        TextView title, url;
        ImageView thumbnailUrl;

        public ImageViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.imageTitle);
            url = itemView.findViewById(R.id.imageUrl);
            thumbnailUrl = itemView.findViewById(R.id.imageThumbnailUrl);
        }
    }
}
