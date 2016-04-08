package com.ricardo.victor.d2d;

import java.util.ArrayList;
import java.util.Objects;

import android.content.Context;
import android.view.View;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.app.Activity;
import android.widget.ImageView;
import android.graphics.drawable.Drawable;

public class ListAdapter extends BaseAdapter{
    private Activity activity;
    private ArrayList<Visitor> data;
    private static LayoutInflater inflater;
    public  ListAdapter(Activity activity,ArrayList<Visitor>data){
        this.activity=activity;
        this.data=data;
        inflater=(LayoutInflater)this.activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    @Override
    public int getCount(){return this.data.size();}
    @Override
    public Object getItem(int item){return item;}
    @Override
    public long getItemId(int itemid){return itemid;}
    @Override
    public View getView(int position, View view, ViewGroup parentView){
        View v=view;
        //layout of list adapter
        if(v==null) v=this.inflater.inflate(R.layout.visitor_layout, null);
        //layout controls
        TextView tvName=(TextView)v.findViewById(R.id.visitorName);
        TextView tvDesc=(TextView)v.findViewById(R.id.visitorDesc);
        //read data item
        Visitor item=this.data.get(position);
        //display in controls
        tvName.setText(item.getName());
        tvDesc.setText(item.getDescription());
        //return view
        return v;
    }
}
