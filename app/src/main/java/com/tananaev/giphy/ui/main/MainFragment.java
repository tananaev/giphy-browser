package com.tananaev.giphy.ui.main;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.tananaev.giphy.R;
import com.tananaev.giphy.model.Gif;
import com.tananaev.giphy.ui.detail.DetailFragment;

import javax.inject.Inject;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class MainFragment extends Fragment implements MainAdapter.ItemClickListener {

    private static final int COLUMNS = 2;

    private MainViewModel viewModel;
    private MainAdapter adapter = new MainAdapter(COLUMNS, this);

    @Inject
    MainViewModelFactory viewModelFactory;

    public static MainFragment newInstance() {
        return new MainFragment();
    }

    @Nullable
    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater,
            @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.main_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        RecyclerView gridView = view.findViewById(R.id.grid);
        gridView.setLayoutManager(new GridLayoutManager(getContext(), COLUMNS));
        gridView.setAdapter(adapter);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        viewModel = new ViewModelProvider(this, viewModelFactory).get(MainViewModel.class);
        viewModel.fetchData(null).observe(this.getActivity(), adapter::submitList);
    }

    @Override
    public void onClick(Gif gif) {
        getParentFragmentManager()
                .beginTransaction()
                .replace(R.id.container, DetailFragment.newInstance(gif))
                .addToBackStack("detail")
                .commit();
    }
}
