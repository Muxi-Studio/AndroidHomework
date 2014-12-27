package com.muxi.microblog1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by user on 2014/12/27.
 */
public class MyAdapter extends BaseAdapter {

    private Context context;
    private LayoutInflater layoutInflater;

    public MyAdapter(Context context){
        this.context = context;
        layoutInflater = layoutInflater.from(context);
    }
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
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;

        if (convertView==null){
            convertView = layoutInflater.inflate(R.layout.abc_activity_chooser_view_list_item, null);
            viewHolder = new ViewHolder();
            viewHolder.headPic = (ImageView) convertView.findViewById(R.id.list_head_pic);
            viewHolder.userName = (TextView)convertView.findViewById(R.id.list_head);
            viewHolder.content = (TextView)convertView.findViewById(R.id.list_item);
            convertView.setTag(viewHolder);
             }
        else {
            viewHolder = (ViewHolder)convertView.getTag();
        }
        viewHolder.headPic.setImageDrawable(context.getResources().getDrawable(R.drawable.ic_launcher));
        viewHolder.userName.setText("user"+position);
        viewHolder.content.setText("No."+position+"使用ViewHolder来使卡片的加载速度加快，因为下面的view.findbyId的三句都是十分缓慢的语句，在多次重复加载后会严重拖慢应用的速度。\n" +
                "使用ViewHolder是通过多次使用第一次的View然后填充内容来加快速度的，在第一次加载之后，view就不是空，将直接跳到else语句，用getTag返回这个View。");
        return convertView;
    }
}
