package com.jason.mvp.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.jason.mvp.Entity.GirlEntity;
import com.jason.mvp.R;

import java.util.List;

/**
 * Created by Administrator on 2016-05-22 0022.
 */
public class GirlAdapter1 extends BaseAdapter {

    private List<GirlEntity> list;

    public GirlAdapter1(List<GirlEntity> list) {
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        ViewHolder holder;
        if (convertView == null || convertView instanceof View) {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, null);
            holder = new ViewHolder();
            holder.tv = (TextView) view.findViewById(R.id.tv);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
        GirlEntity girl = list.get(position);
        holder.tv.setText(girl.getName());
        return view;
    }

    private static class ViewHolder {
        private TextView tv;
    }

}
