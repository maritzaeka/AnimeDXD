// CarouselAdapter.java in adapter package
package com.example.animedxd.ui.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.animedxd.R;
import com.example.animedxd.ui.model.CarouselItem;
import java.util.List;

public class CarouselAdapter extends RecyclerView.Adapter<CarouselAdapter.CarouselViewHolder> {

    private final List<CarouselItem> items;

    public CarouselAdapter(List<CarouselItem> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public CarouselViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_carousel, parent, false);
        return new CarouselViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CarouselViewHolder holder, int position) {
        CarouselItem item = items.get(position);
        holder.title.setText(item.getTitle());
        holder.subtitle.setText(item.getSubtitle());
        holder.imageView.setImageResource(item.getImageResId()); // Now works
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    static class CarouselViewHolder extends RecyclerView.ViewHolder {
        TextView title, subtitle;
        ImageView imageView; // Declared

        public CarouselViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.carouselTitle);
            subtitle = itemView.findViewById(R.id.carouselSubtitle);
            imageView = itemView.findViewById(R.id.carouselImage); // Initialized
        }
    }
}