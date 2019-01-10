package com.example.xzr.listviewproject;

import android.content.Context;
import android.icu.util.ValueIterator;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

/**
 * Created by xzr on 2018/12/26.
 */

public class FruitAdapter extends ArrayAdapter<Fruit> {
    private int resourceId;
    public FruitAdapter(Context context, int textViewResourceId, List<Fruit>objects) {
        super(context,textViewResourceId,objects);
        resourceId = textViewResourceId;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Fruit fruit = getItem(position);
        View view;

        ViewHolder viewHolder ;

        if (convertView == null) {
            view = LayoutInflater.from(getContext()).inflate(resourceId,parent,false);
            viewHolder = new ViewHolder();
            viewHolder.fruitImage = view.findViewById(R.id.fruit_image);
            viewHolder.fruitName = view.findViewById(R.id.fruit_text);
            view.setTag(viewHolder);
        }else  {
            view = convertView;
            viewHolder = (ViewHolder) view.getTag();

        }

        // 为何调用 view.findViewById
//        ImageView fruitImage = view.findViewById(R.id.fruit_image);
//        TextView fruitText = view.findViewById(R.id.fruit_text);

//        fruitImage.setImageResource(fruit.getImageID());
//        fruitText.setText(fruit.getName());
        viewHolder.fruitImage.setImageResource(fruit.getImageID());
        viewHolder.fruitName.setText(fruit.getName());

        return view;
    }

    class ViewHolder {
        ImageView fruitImage;
        TextView fruitName;
    }
}
