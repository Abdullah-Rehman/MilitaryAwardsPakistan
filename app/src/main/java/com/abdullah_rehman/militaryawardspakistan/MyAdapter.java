package com.abdullah_rehman.militaryawardspakistan;

import android.content.Context;
import android.media.Image;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Abdullah_Rehman on 03-Oct-17.
 */

public class MyAdapter extends ArrayAdapter<String>{

    String[] names;
    int[]images;
    Context mContext;
    public MyAdapter(Context context,String[] awardNames, int[] awardImages) {
        super(context, R.layout.listview_item);
        this.names=awardNames;
        this.images=awardImages;
        this.mContext=context;
    }

    @Override
    public int getCount() {
        return names.length;
    }

    @NonNull
    @Override
    public View getView(int position,  View convertView, ViewGroup parent) {
        ViewHolder mViewHolder = new ViewHolder();
        if(convertView==null) {
            LayoutInflater mInflater = (LayoutInflater) mContext.
                    getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = mInflater.inflate(R.layout.listview_item, parent, false);
            mViewHolder.myImages = (ImageView) convertView.findViewById(R.id.imageView);
            mViewHolder.myNames = (TextView) convertView.findViewById(R.id.textView);
            convertView.setTag(mViewHolder);
        }else {

            mViewHolder = (ViewHolder)convertView.getTag();
            }
            mViewHolder.myImages.setImageResource(images[position]);
            mViewHolder.myNames.setText(names[position]);
        return convertView;
    }
    static class ViewHolder{
        ImageView myImages;
        TextView myNames;
    }
}
