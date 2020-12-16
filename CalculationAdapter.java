package com.dev.calsci;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

class CalculationAdapter extends ArrayAdapter<Calculation> {
    private Context context;
    private int resource;
    public CalculationAdapter(Context context, int resource, List<Calculation> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView,  ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);
        convertView = inflater.inflate(resource,parent,false);
        String title = getItem(position).getTitle();
        String calculationString = getItem(position).getCalculationString();
        TextView tvTitle = convertView.findViewById(R.id.calculationTitle);
        TextView tvCalculationString = convertView.findViewById(R.id.calculationString);
        tvTitle.setText(title);
        tvCalculationString.setText(calculationString);
        return convertView;
    }
}
