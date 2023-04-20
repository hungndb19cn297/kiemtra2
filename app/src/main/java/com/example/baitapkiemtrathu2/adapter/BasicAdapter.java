package com.example.baitapkiemtrathu2.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.baitapkiemtrathu2.AddActivity;
import com.example.baitapkiemtrathu2.MainActivity;
import com.example.baitapkiemtrathu2.R;
import com.example.baitapkiemtrathu2.model.Model;

import java.util.List;

public class BasicAdapter extends BaseAdapter {
    List<Model> list;
    IntentGoAdapter intentGoAdapter;
    Intent intent;

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Model getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return list.get(i).getId();
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
        view = layoutInflater.inflate(R.layout.textview, viewGroup, false);
        TextView t = view.findViewById(R.id.tv);
        t.setText(list.get(i).toString());

        view.setOnClickListener(v -> {
            intent.putExtra("id", list.get(i).getId());
            intentGoAdapter.runIntent(intent);
        });

        return view;
    }

    public BasicAdapter(List<Model> list, IntentGoAdapter intentGoAdapter, Intent intent) {
        this.list = list;
        this.intentGoAdapter = intentGoAdapter;
        this.intent = intent;
    }
}
