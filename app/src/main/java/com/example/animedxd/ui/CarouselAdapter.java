package com.example.animedxd.ui;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;
import com.example.animedxd.R;

public class CarouselAdapter extends PagerAdapter {

    private final Context context;
    private final int[] images = { R.drawable.carousel1, R.drawable.carousel2, R.drawable.carousel3 };

    public CarouselAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return images.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        ImageView img = new ImageView(context);
        img.setImageResource(images[position]);
        img.setScaleType(ImageView.ScaleType.CENTER_CROP);
        container.addView(img);
        return img;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}
