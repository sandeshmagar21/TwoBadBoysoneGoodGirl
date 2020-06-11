package com.example.futsalapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;

public class gallery extends AppCompatActivity {
GridView gridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);

      gridView = (GridView) findViewById(R.id.myGrid);
        gridView.setAdapter(new  ImageAdapter( this));




     gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
         Intent intent = new Intent(getApplicationContext(), fullView.class);
         intent.putExtra("id ",position);
         startActivity(intent);
            }
       });
   }

//    public  void ShowDialogBox (final int item_pos){
//        final Dialog dialog = new Dialog(this);
//        dialog.setContentView(R.layout.custom_dialog);
//
//        //Getting custom dialog view
//        TextView Image_name = dialog.findViewById(R.id.image_name);
//        ImageView Image = dialog.findViewById(R.id.img);
//        Button btn_Full = dialog.findViewById(R.id.btn_full);
//        Button btn_Close = dialog.findViewById(R.id.btn_close);
//
//        String title = getResources().getResourceName(item_pos);

        //extracting name
//        int index = title.indexOf("/");//image name
//        String name = title.substring(index+1,title.length());
//        Image_name.setText(name);
//
//        Image.setImageResource(item_pos);
//
//        btn_Close.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                dialog.dismiss();
//            }
//        });
//        btn_Full.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent i = new Intent (gallery.this, fullView.class);
//                i.putExtra("img_id", item_pos);
//                startActivity(i);
//
//            }
//        });
//        dialog.show();

    }

