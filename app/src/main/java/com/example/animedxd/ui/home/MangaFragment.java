package com.example.animedxd.ui.home;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.animedxd.R;
import com.example.animedxd.ui.adapter.MangaAdapter;
import com.example.animedxd.ui.model.MangaItem;

import java.util.ArrayList;
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

        recyclerViewPopularManga = view.findViewById(R.id.recyclerViewPopularManga);
        recyclerViewLatestManga = view.findViewById(R.id.recyclerViewLatestManga);
        recyclerRecommendationForYou = view.findViewById(R.id.recyclerRecommendationForYou);

        recyclerViewPopularManga.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        MangaAdapter popularMangaAdapter = new MangaAdapter(getPopularMangaData());
        recyclerViewPopularManga.setAdapter(popularMangaAdapter);

        recyclerViewLatestManga.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        MangaAdapter latestMangaAdapter = new MangaAdapter(getLatestMangaData());
        recyclerViewLatestManga.setAdapter(latestMangaAdapter);

        recyclerRecommendationForYou.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        MangaAdapter recommendationForYouAdapter = new MangaAdapter(getRecommendationData());
        recyclerRecommendationForYou.setAdapter(recommendationForYouAdapter);

        return view;
    }

    private List<MangaItem> getPopularMangaData() {
        List<MangaItem> mangaList = new ArrayList<>();
        mangaList.add(new MangaItem("Death Note", "Supernatural, Suspense", R.drawable.man_detnot));
        mangaList.add(new MangaItem("Naruto: Shippuuden", "Action, Adventure, Fantasy", R.drawable.man_nar));
        mangaList.add(new MangaItem("Jujutsu Kaisen", "Action, Supernatural", R.drawable.man_jjk));
        mangaList.add(new MangaItem("Spy X Family", "Action, Comedy", R.drawable.man_spy));
        mangaList.add(new MangaItem("My Hero Academia", "Action", R.drawable.man_myha));
        mangaList.add(new MangaItem("One Piece", "Action, Adventure, Fantasy", R.drawable.man_opis));
        mangaList.add(new MangaItem("Chainsaw Man", "Action, Fantasy", R.drawable.man_cenmen));
        return mangaList;
    }

    private List<MangaItem> getLatestMangaData() {
        List<MangaItem> mangaList = new ArrayList<>();
        mangaList.add(new MangaItem("Attack on Titan", "Action, Drama, Suspense", R.drawable.man_aot));
        mangaList.add(new MangaItem("Demon Slayer", "Action, Supernatural", R.drawable.man_demyer));
        mangaList.add(new MangaItem("Death Note", "Supernatural, Suspense", R.drawable.man_detnot));
        mangaList.add(new MangaItem("Naruto: Shippuuden", "Action, Adventure, Fantasy", R.drawable.man_nar));
        mangaList.add(new MangaItem("Jujutsu Kaisen", "Action, Supernatural", R.drawable.man_jjk));
        mangaList.add(new MangaItem("One Piece", "Action, Adventure, Fantasy", R.drawable.man_opis));
        mangaList.add(new MangaItem("Chainsaw Man", "Action, Fantasy", R.drawable.man_cenmen));
        return mangaList;
    }

    private List<MangaItem> getRecommendationData() {
        List<MangaItem> mangaList = new ArrayList<>();
        mangaList.add(new MangaItem("Tokyo Ghoul", "Action, Fantasy, Horror, Suspense", R.drawable.man_tokgho));
        mangaList.add(new MangaItem("One Punch Man", "Action, Comedy", R.drawable.man_opm));
        mangaList.add(new MangaItem("One Piece", "Action, Adventure, Fantasy", R.drawable.man_opis));
        mangaList.add(new MangaItem("Chainsaw Man", "Action, Fantasy", R.drawable.man_cenmen));
        mangaList.add(new MangaItem("Death Note", "Supernatural, Suspense", R.drawable.man_detnot));
        mangaList.add(new MangaItem("Naruto: Shippuuden", "Action, Adventure, Fantasy", R.drawable.man_nar));
        mangaList.add(new MangaItem("Jujutsu Kaisen", "Action, Supernatural", R.drawable.man_jjk));
        return mangaList;
    }
}
