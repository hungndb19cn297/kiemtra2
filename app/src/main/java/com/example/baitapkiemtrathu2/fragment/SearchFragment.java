package com.example.baitapkiemtrathu2.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
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

import java.util.List;

public class SearchFragment extends Fragment implements IntentGoAdapter {
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_search, container, false);
    }

    ListView listView;
    BasicAdapter adapter;

    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        EditText edt1 = view.findViewById(R.id.editTextTextPersonName);
        EditText edt2 = view.findViewById(R.id.editTextTextPersonName2);
        EditText edt3 = view.findViewById(R.id.editTextTextPersonName3);
        Button button = view.findViewById(R.id.button);
        listView = view.findViewById(R.id.l_search);
        Intent intent = new Intent(getContext(), AddActivity.class);
        List<Model> list = MainActivity.db.search(null);
        adapter = new BasicAdapter(list, this, intent);
        listView.setAdapter(adapter);

        button.setOnClickListener(v -> {
            List<Model> temp = MainActivity.db.search(edt1.getText().toString());
            list.clear();
            list.addAll(temp);
            adapter.notifyDataSetChanged();
        });
    }

    @Override
    public void runIntent(Intent intent) {
        startActivity(intent);
    }

}
