package com.example.endrit.finalproject.adapters;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.endrit.finalproject.R;
import com.squareup.picasso.Picasso;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by endrit on 1/7/2018.
 */

public class MainPagerAdapter extends PagerAdapter {

//    private int[] image_resources = {
//            R.drawable.android,
//            R.drawable.pink
//    };

    Context context;
    LayoutInflater inflater;

    public MainPagerAdapter(Context context) {
        this.context = context;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View swipe_page = inflater.inflate(R.layout.swipe_page, container, false);
        ImageView pagerImage = swipe_page.findViewById(R.id.pager_image);
//        TextView imageNumber = swipe_page.findViewById(R.id.image_number);
//        imageNumber.setText(position);
//        pagerImage.setImageResource(image_resources[position]);

        loadImageFromTheInternet(pagerImage, context);

        container.addView(swipe_page);

        return swipe_page;
    }

    private void loadImageFromTheInternet(ImageView pagerImage, Context context) {
        String image_url = "https://picsum.photos/200/300/?random";
        Picasso.with(context).load(image_url).placeholder(R.drawable.android)
                .error(R.drawable.pink)
                .into(pagerImage, new com.squareup.picasso.Callback(){

                    @Override
                    public void onSuccess() {

                    }

                    @Override
                    public void onError() {

                    }
                });
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    @Override
    public int getCount() {
        return 10;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view.equals(object);
    }

}
