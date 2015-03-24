package com.muxistudio.jinyixin.query.mainActivity;

import android.app.Application;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.TextView;

import com.muxistudio.jinyixin.query.R;
import com.muxistudio.jinyixin.query.util.QueryApplication;

import java.util.List;
import java.util.Map;

/**
 * Created by jinyixin on 15/3/14.
 */
public class MyAdapter extends BaseAdapter {

    private static Context context = QueryApplication.getContext();
    private LayoutInflater layoutInflater;
    List<Map<String, String>> list;

    public MyAdapter(Context context) {
        this.context = context;
        layoutInflater = layoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if (view == null) {
            view = layoutInflater.inflate(R.layout.main_list, null);
            viewHolder = new ViewHolder();
            viewHolder.textViewone = (EditText) view.findViewById(R.id.list_title);
            viewHolder.textViewtwo = (EditText) view.findViewById(R.id.list_item);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        viewHolder.textViewone.setText(getTitle(i, list));
        viewHolder.textViewtwo.setText(getContent(i, list));
        return view;
    }

    class ViewHolder {
        TextView textViewone;
        TextView textViewtwo;
    }

    protected String getTitle(int i, List<Map<String, String>> list) {
//        String tittle;
//        if (!list.isEmpty()){
//            Map<String ,String > map = list.get(i);
//            tittle = map.get();
//            return tittle;
//        }else {
//            return null;
//        }
        return "one";
    }

    protected String getContent(int i, List<Map<String, String>> list) {
//        String content;
//        if (!list.isEmpty()) {
//            Map<String, String> map = list.get(i);
//            content = map.get(DatabaseHelper.KEY_DIARY_CONTENT);
//            return content;
//        }else{
//            return null;
//        }
        return "two";
    }
}