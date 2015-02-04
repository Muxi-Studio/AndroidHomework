package com.muxi.diary.mainActicity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;

import com.muxi.diary.R;

/**
 * Created by user on 2015/1/3.
 */
public class MyAdapter extends BaseAdapter {

    private Context context;
    private LayoutInflater layoutInflater;

    public MyAdapter(Context context){
        this.context=context;
        layoutInflater = layoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return 100;
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
        if (view == null){
            view = layoutInflater.inflate(R.layout.mail_list , null);
            viewHolder = new ViewHolder();
            viewHolder.tittle = (EditText) view.findViewById(R.id.list_title);
            viewHolder.content = (EditText) view.findViewById(R.id.list_item);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        viewHolder.tittle.setText("tittle" + i);
        viewHolder.content.setText("add content");
        return view;
    }
}
class ViewHolder {
    EditText tittle;
    EditText content;
}

