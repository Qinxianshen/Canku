package com.qin.CanKu.listview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.qin.CanKu.R;
import com.qin.CanKu.bean.Woods;

import java.util.List;

public class ListAdapter extends ArrayAdapter {
    private final int resourceId;
    public ListAdapter(@NonNull Context context, int resource, @NonNull List objects) {
        super(context, resource, objects);
        this.resourceId  = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Woods woods = (Woods) getItem(position);
        View view = LayoutInflater.from(getContext()).inflate(resourceId,null);
        TextView name = view.findViewById(R.id.li_name);
        TextView modelnumber = view.findViewById(R.id.li_modelnumber);
        TextView number = view.findViewById(R.id.li_number);
        TextView li_location = view.findViewById(R.id.li_location);

        name.setText(woods.getName());
        modelnumber.setText(woods.getWood_id());
        number.setText(woods.getWood_num() + "");
        li_location.setText(woods.getWood_loaction());
        return view;

    }
}
