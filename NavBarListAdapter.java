package com.example.dell.spotsoontest;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.AppCompatTextView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by DELL on 19-05-2017.
 */

public class NavBarListAdapter extends BaseAdapter {

    private static final String LCAT = "NavBarListAdapter";

    private AppCompatActivity activity;
    private ArrayList<String> navBarListItems;
    private static LayoutInflater inflater = null;

    public NavBarListAdapter(AppCompatActivity activity) {
        super();
        this.activity = activity;
        navBarListItems = new ArrayList<String>(Arrays.asList(activity.getResources().getStringArray(R.array.nav_bar_items)));
        inflater = (LayoutInflater) this.activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return navBarListItems.size();
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        if(convertView == null){
            convertView = inflater.inflate(R.layout.nav_bar_list_item,  null);
        }

        AppCompatImageView navBarListItemIcon = (AppCompatImageView) convertView.findViewById(R.id.nav_bar_list_item_icon);
        AppCompatTextView navBarListItemTitle = (AppCompatTextView) convertView.findViewById(R.id.nav_bar_list_item_title);

        navBarListItemIcon.setImageDrawable(ContextCompat.getDrawable(activity, R.drawable.ic_nav_bar_item_home));
        navBarListItemTitle.setText(navBarListItems.get(position));

        return convertView;
    }
}
