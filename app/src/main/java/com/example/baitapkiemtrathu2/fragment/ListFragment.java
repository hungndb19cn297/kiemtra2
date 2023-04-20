package com.example.baitapkiemtrathu2.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.baitapkiemtrathu2.AddActivity;
import com.example.baitapkiemtrathu2.MainActivity;
import com.example.baitapkiemtrathu2.R;
import com.example.baitapkiemtrathu2.adapter.BasicAdapter;
import com.example.baitapkiemtrathu2.adapter.IntentGoAdapter;
import com.example.baitapkiemtrathu2.model.Model;

import java.util.ArrayList;
import java.util.List;

public class ListFragment extends Fragment implements IntentGoAdapter {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_list, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        ListView listView = view.findViewById(R.id.lv);
        List<Model> list = MainActivity.db.search(null);
        Intent intent = new Intent(getContext(), AddActivity.class);
        BasicAdapter adapter = new BasicAdapter(list, this, intent);
        listView.setAdapter(adapter);
    }

    @Override
    public void runIntent(Intent intent) {
        startActivity(intent);
    }
}
