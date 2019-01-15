package bwei.com.day7_rikao.Fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import bwei.com.day7_rikao.R;
import bwei.com.day7_rikao.View_Action.TopBars;

public class FxFragments extends Fragment {

    private TopBars top_bar_wang;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fx_fragments, container, false);
        top_bar_wang = view.findViewById(R.id.top_bar_wang);
        return  view;
    }
}
