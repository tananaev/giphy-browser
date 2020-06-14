package com.tananaev.giphy.ui.detail;

import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.tananaev.giphy.R;
import com.tananaev.giphy.model.Gif;

public class DetailFragment extends Fragment {

    private static final String KEY_GIF = "gif";

    public static DetailFragment newInstance(Gif gif) {
        Bundle bundle = new Bundle();
        bundle.putSerializable(KEY_GIF, gif);
        DetailFragment fragment = new DetailFragment();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater,
            @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.detail_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        SimpleDraweeView imageView = view.findViewById(R.id.image);
        Gif gif = (Gif) getArguments().getSerializable(KEY_GIF);
        DraweeController controller = Fresco.newDraweeControllerBuilder()
                .setUri(Uri.parse(gif.images.original.url))
                .setAutoPlayAnimations(true)
                .build();
        imageView.setController(controller);
    }
}
