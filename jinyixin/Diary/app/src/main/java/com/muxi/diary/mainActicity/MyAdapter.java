package com.muxi.diary.mainActicity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;

import com.muxi.diary.R;
import com.muxi.diary.database.DatabaseHelper;
import com.muxi.diary.database.ProjectNameDao;

import java.util.List;
import java.util.Map;

/**
 * Created by user on 2015/1/3.
 */
public class MyAdapter extends BaseAdapter {

    private Context context;
    private LayoutInflater layoutInflater;
    List<Map<String ,String >> list;

    public MyAdapter(Context context){
        this.context=context;
        ProjectNameDao projectNameDao = new ProjectNameDao(context);

        list = projectNameDao.loadDiary();
        layoutInflater = LayoutInflater.from(context);
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
        viewHolder.tittle.setText(getTitle(i,list));
        viewHolder.content.setText(getContent(i,list));
        return view;
    }

    class ViewHolder {
        EditText tittle;
        EditText content;
    }
    protected String getTitle(int i,List<Map<String, String>> list){
        String tittle;
        if (!list.isEmpty()){
            Map<String ,String > map = list.get(i);
            tittle = map.get(DatabaseHelper.KEY_DIARY_TITLE);
            return tittle;
        }else {
           return null;
        }
        }

    protected String getContent(int i,List<Map<String, String>> list){
        String content;
        if (!list.isEmpty()) {
            Map<String, String> map = list.get(i);
            content = map.get(DatabaseHelper.KEY_DIARY_CONTENT);
            return content;
        }else{
            return null;
        }
    }

    }


