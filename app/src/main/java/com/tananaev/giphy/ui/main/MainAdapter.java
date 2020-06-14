package com.tananaev.giphy.ui.main;

import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.paging.PagedListAdapter;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.tananaev.giphy.R;
import com.tananaev.giphy.model.Gif;

public class MainAdapter extends PagedListAdapter<Gif, MainAdapter.MainViewHolder> {

    public static class MainViewHolder extends RecyclerView.ViewHolder {

        public SimpleDraweeView imageView;

        public MainViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = (SimpleDraweeView) itemView;
        }
    }

    public interface ItemClickListener {
        void onClick(Gif gif);
    }

    private final int columns;
    private final ItemClickListener itemClickListener;

    protected MainAdapter(int columns, ItemClickListener itemClickListener) {
        super(new DiffUtil.ItemCallback<Gif>() {

            @Override
            public boolean areItemsTheSame(@NonNull Gif oldItem, @NonNull Gif newItem) {
                return oldItem.id.equals(newItem.id);
            }

            @Override
            public boolean areContentsTheSame(@NonNull Gif oldItem, @NonNull Gif newItem) {
                return oldItem.id.equals(newItem.id); // assuming data doesn't change
            }
        });
        this.columns = columns;
        this.itemClickListener = itemClickListener;
    }

    @NonNull
    @Override
    public MainViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        int size = parent.getWidth() / columns;
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.height = size;
        layoutParams.width = size;
        view.setLayoutParams(layoutParams);
        return new MainViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MainViewHolder holder, int position) {
        Gif gif = getItem(position);
        DraweeController controller = Fresco.newDraweeControllerBuilder()
                .setUri(Uri.parse(gif.images.fixed_height.url))
                .setAutoPlayAnimations(true)
                .build();
        holder.imageView.setController(controller);
        holder.itemView.setOnClickListener(v -> itemClickListener.onClick(gif));
    }
}
