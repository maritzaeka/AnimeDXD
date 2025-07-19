package com.example.animedxd.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.animedxd.R;
import java.util.Arrays;
import java.util.List;

public class MangaFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.manga_fragment, container, false);

        List<Manga> dummyList = Arrays.asList(
                new Manga("Death Note", R.drawable.manga1),
                new Manga("Jujutsu Kaisen", R.drawable.manga2),
                new Manga("Naruto", R.drawable.manga3)
        );

        MangaAdapter adapter = new MangaAdapter(dummyList);

        RecyclerView rvPopular = view.findViewById(R.id.rv_popular_manga);
        RecyclerView rvLatest = view.findViewById(R.id.rv_latest_manga);

        rvPopular.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        rvPopular.setAdapter(adapter);

        rvLatest.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        rvLatest.setAdapter(adapter);

        return view;
    }
}
