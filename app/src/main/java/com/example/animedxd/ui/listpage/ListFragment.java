package com.example.animedxd.ui.listpage;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.animedxd.R;
import com.example.animedxd.model.Anime;
import com.example.animedxd.model.AnimeData;

import java.util.List;

public class ListFragment extends Fragment {

    public ListFragment() {
        // Konstruktor kosong diperlukan
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate layout
        View view = inflater.inflate(R.layout.fragment_list_anime, container, false);

        // 1. Inisialisasi data
        AnimeData.initializeData();

        // 2. Ambil list anime
        List<Anime> animeList = AnimeData.getAnimeList();

        // 3. Siapkan RecyclerView
        RecyclerView recyclerView = view.findViewById(R.id.recycler_view_anime);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(new ListAdapter(animeList, requireContext()));

        return view;
    }
}
