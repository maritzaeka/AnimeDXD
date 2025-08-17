package com.example.animedxd.ui.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.animedxd.R;
import com.example.animedxd.model.Anime;
import com.example.animedxd.ui.listpage.ListViewHolder;
import java.util.List;

public class MangaAdapter extends RecyclerView.Adapter<ListViewHolder> {

    private final List<Anime> mangaList;
    private OnItemClickCallback onItemClickCallback;

    public void setOnItemClickCallback(OnItemClickCallback onItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback;
    }

    public MangaAdapter(List<Anime> mangaList) {
        this.mangaList = mangaList;
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_manga_card, parent, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListViewHolder holder, int position) {
        Anime mangaItem = mangaList.get(position);

        ImageView imageView = holder.itemView.findViewById(R.id.mangaImage);
        if (imageView != null) {
            imageView.setImageResource(mangaItem.getImageResId());
        }

        TextView titleView = holder.itemView.findViewById(R.id.mangaTitle);
        if (titleView != null) {
            titleView.setText(mangaItem.getTitle());
        }

        TextView mangaGenreView = holder.itemView.findViewById(R.id.mangaGenre);
        if (mangaGenreView != null) {
            mangaGenreView.setText("Genre: "+ mangaItem.getGenre());
        }

        String shortDescription = getFirstTwoSentences(mangaItem.getDescription());
        TextView mangaDescView = holder.itemView.findViewById(R.id.mangaDesc);
        if (mangaDescView != null) {
            mangaDescView.setText("Description:\n" + shortDescription);
        }

        holder.itemView.setOnClickListener(v -> {
            if (onItemClickCallback != null) {
                onItemClickCallback.onItemClicked(mangaList.get(holder.getAdapterPosition()));
            }
        });
    }

    private String getFirstTwoSentences(String text) {
        if (text == null || text.isEmpty()) {
            return "";
        }
        int firstPeriodIndex = text.indexOf(".");
        if (firstPeriodIndex == -1) {
            return text;
        }
        int secondPeriodIndex = text.indexOf(".", firstPeriodIndex + 1);
        if (secondPeriodIndex == -1) {
            return text.substring(0, firstPeriodIndex + 1);
        }
        return text.substring(0, secondPeriodIndex + 1);
    }

    @Override
    public int getItemCount() {
        return mangaList.size();
    }

    public interface OnItemClickCallback {
        void onItemClicked(Anime data);
    }
}