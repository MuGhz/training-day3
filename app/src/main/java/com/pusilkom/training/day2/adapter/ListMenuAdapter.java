package com.pusilkom.training.day2.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.pusilkom.training.day2.R;
import com.pusilkom.training.day2.model.ListMenuItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by purwa on 6/13/17.
 */

public class ListMenuAdapter extends ArrayAdapter<ListMenuItem> {
    private final LayoutInflater mInflater;
    private final ImageLoader imageLoader;
    private ArrayList<ListMenuItem> menuList;

    public ListMenuAdapter(Context ctx, int res, List<ListMenuItem> items) {
        super(ctx, res, items);
        mInflater = (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        menuList = (ArrayList<ListMenuItem>) items;
        imageLoader = ImageLoader.getInstance();
        if (!imageLoader.isInited()) {
            DisplayImageOptions options = new DisplayImageOptions.Builder()
                    .cacheInMemory(true)
                    .cacheOnDisk(true)
                    .build();
            ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(ctx)
                    .defaultDisplayImageOptions(options)
                    .build();
            imageLoader.init(config);
        }
    }

    @Override
    public int getCount() {
        return menuList.size();
    }

    @Override
    public ListMenuItem getItem(int i) {
        return menuList.get(i);
    }

    @Override
    public long getItemId(int i) {
        ListMenuItem item = menuList.get(i);
        return item.getId();
    }

    @Override
    public View getView(int position, View itemView, ViewGroup parent) {
        LinearLayout layout;
        if(itemView == null)
            layout = (LinearLayout) mInflater.inflate(R.layout.list_layout_menu, parent, false);
        else
            layout = (LinearLayout) itemView;

        ListMenuItem menuItem =  menuList.get(position);
        ImageView menuIcon = (ImageView) layout.findViewById(R.id.menu_icon);
        TextView menuLabel = (TextView) layout.findViewById(R.id.menu_label);
        TextView menuDesc = (TextView) layout.findViewById(R.id.menu_desc);

        imageLoader.displayImage(menuItem.getIconUrl(), menuIcon);
        menuLabel.setText(menuItem.getMenuLabel());
        menuDesc.setText(menuItem.getMenuDesc());

        return layout;
    }
}
