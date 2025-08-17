package com.example.animedxd.ui.home;

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
import com.example.animedxd.ui.adapter.MangaAdapter;
import com.example.animedxd.ui.detail.DetailFragment;
import com.example.animedxd.ui.model.MangaItem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MangaFragment extends Fragment {

    private RecyclerView recyclerViewPopularManga;
    private RecyclerView recyclerViewLatestManga;
    private RecyclerView recyclerRecommendationForYou;

    public MangaFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_manga, container, false);

        if(AnimeData.getAnimeList().isEmpty()){
            AnimeData.initializeData();
        }

        recyclerViewPopularManga = view.findViewById(R.id.recyclerViewPopularManga);
        recyclerViewLatestManga = view.findViewById(R.id.recyclerViewLatestManga);
        recyclerRecommendationForYou = view.findViewById(R.id.recyclerRecommendationForYou);

        setupRecyclerView(recyclerViewPopularManga, getPopularMangaData());
        setupRecyclerView(recyclerViewLatestManga, getLatestMangaData());
        setupRecyclerView(recyclerRecommendationForYou, getRecommendationData());
//        recyclerViewPopularManga.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
//        MangaAdapter popularMangaAdapter = new MangaAdapter(getPopularMangaData());
//        recyclerViewPopularManga.setAdapter(popularMangaAdapter);
//
//        recyclerViewLatestManga.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
//        MangaAdapter latestMangaAdapter = new MangaAdapter(getLatestMangaData());
//        recyclerViewLatestManga.setAdapter(latestMangaAdapter);
//
//        recyclerRecommendationForYou.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
//        MangaAdapter recommendationForYouAdapter = new MangaAdapter(getRecommendationData());
//        recyclerRecommendationForYou.setAdapter(recommendationForYouAdapter);

        return view;
    }

    private void setupRecyclerView(RecyclerView recyclerView, List<Anime> animeList){
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        MangaAdapter adapter = new MangaAdapter(animeList);
        recyclerView.setAdapter(adapter);

    }

    private List<Anime> getPopularMangaData() {
        List<Anime> allAnime = AnimeData.getAnimeList();
        return new ArrayList<>(allAnime.subList(0, Math.min(5, allAnime.size())));
    }

    private List<Anime> getLatestMangaData() {
        List <Anime> allAnime = new ArrayList<>(AnimeData.getAnimeList());
        Collections.shuffle(allAnime);
        return new ArrayList<>(allAnime.subList(0, Math.min(6, allAnime.size())));
    }

    private List<Anime> getRecommendationData() {
        List<Anime> allAnime = new ArrayList<>(AnimeData.getAnimeList());
        Collections.reverse(allAnime);
        return new ArrayList<>(allAnime.subList(0, Math.min(5, allAnime.size())));
    }
}
