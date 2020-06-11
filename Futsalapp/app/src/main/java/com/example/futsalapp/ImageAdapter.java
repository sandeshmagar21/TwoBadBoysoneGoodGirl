package com.example.futsalapp;

import android.content.Context;
import android.media.Image;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.ImageView;

import java.util.List;

public class ImageAdapter extends BaseAdapter {

    private  Context mContext;
    public  int[]  imageArray = {
            R.drawable.img2,R.drawable.img3, R.drawable.img4,
            R.drawable.img8,R.drawable.img7, R.drawable.img6,
            R.drawable.img9, R.drawable.img55,R.drawable.img0,



    };

    public ImageAdapter(Context mContext) {
        this.mContext = mContext;
    }

    @Override
    public int getCount() {
        return imageArray.length;
    }

    @Override
    public Object getItem(int position) {
        return imageArray[position];
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
      ImageView imageView = new ImageView(mContext);
      imageView.setImageResource(imageArray[position]);
      imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
      imageView.setLayoutParams(new GridView.LayoutParams(340,350));

     return imageView;
    }
    //private List<Integer> mThumbIds;
   // private Context  mContext;

//    public ImageAdapter(List<Integer> mThumbIds, Context mContext) {
//        this.mThumbIds = mThumbIds;
//        this.mContext = mContext;
//    }
//
  //@Override
//    public int getCount() {
//        return mThumbIds.size(); //it will show 4 image and run only  4 times
//
//    }

   // @Override
   // public Object getItem(int position) {
      //  return null;
    //}

  //  @Override
 //   public long getItemId(int position) {
      //  return mThumbIds.get(position);
  //  }

   // @Override
   // public View getView(int position, View convertView, ViewGroup parent) {
        //ImageView imageView = (ImageView) convertView;

        //if(imageView == null){
           // imageView.setLayoutParams(new GridView.LayoutParams(350,450));
           // imageView.setScaleType(ImageView.ScaleType.CENTER_CROP); //image size

      //  }

     // imageView.setImageResource(mThumbIds.get(position));
     //   return  imageView;
   // }
}
