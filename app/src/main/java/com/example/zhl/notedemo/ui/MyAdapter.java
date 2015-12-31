package com.example.zhl.notedemo.ui;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

import com.example.zhl.notedemo.R;

/**
 * Created by zhl on 2015/12/31.
 */
public class MyAdapter extends CursorAdapter {


    public MyAdapter(Context context,Cursor cursor){
        super(context, cursor, true);
    }

    @Override
    public Object getItem(int position) {
        return super.getItem(position);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        ViewHolder viewHolder = new ViewHolder();
        View view = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false);
        viewHolder.title_item = (TextView) view.findViewById(R.id.title_item);
        viewHolder.date_item = (TextView) view.findViewById(R.id.date_item);
        view.setTag(viewHolder);
        return view;
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        ViewHolder viewHolder = (ViewHolder) view.getTag();
        String temptitle_item = cursor.getString(cursor.getColumnIndex("title"));
        String tempdate_item = cursor.getString(cursor.getColumnIndex("date"));

        viewHolder.title_item.setText(temptitle_item);
        viewHolder.date_item.setText(tempdate_item);

    }

    class ViewHolder{
        TextView title_item;
        TextView date_item;
    }

}
