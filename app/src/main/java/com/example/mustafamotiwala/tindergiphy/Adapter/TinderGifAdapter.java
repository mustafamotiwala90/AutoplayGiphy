package com.example.mustafamotiwala.tindergiphy.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.mustafamotiwala.tindergiphy.Model.TinderGif;
import com.example.mustafamotiwala.tindergiphy.R;
import com.example.mustafamotiwala.tindergiphy.Utils.ImageUtils;

import java.util.List;

public class TinderGifAdapter extends RecyclerView.Adapter<TinderGifViewHolder> {

    private List<TinderGif> _gifFeed;
    private Context _context;
    final float _scale;
    private int previousStart = 0;

    public TinderGifAdapter(List<TinderGif> items, Context context) {
        _gifFeed = items;
        _context = context;
        _scale = _context.getResources().getDisplayMetrics().density;
        previousStart = items.size();
    }

    @NonNull
    @Override
    public TinderGifViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_gif_view, parent, false);
        return new TinderGifViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TinderGifViewHolder holder, int position) {
        TinderGif gif = _gifFeed.get(position);
        String imageUrl = gif.getImages().getFixedHeightDownsampled().getUrl();
        setImageDimensions(holder, gif);
        holder.setImageGifUrl(_context, imageUrl);
        holder.getTextView().setText(gif.getTitle());
    }

    private void setImageDimensions(TinderGifViewHolder holder, TinderGif gif) {
        String width = gif.getImages().getFixedHeightDownsampled().getWidth();
        String height = gif.getImages().getFixedHeightDownsampled().getHeight();
        int[] values = ImageUtils.getScaledSizeValues(width, height, _scale);
        holder.getImageView().setLayoutParams(new LinearLayout.LayoutParams(values[0], values[1]));
    }

    public void appendItems(List<TinderGif> items) {
        if (items != null) {
            _gifFeed.addAll(items);
            notifyItemRangeInserted(previousStart, previousStart + items.size());
            previousStart = previousStart + items.size();
        }
    }

    @Override
    public int getItemCount() {
        return _gifFeed.size();
    }

}
