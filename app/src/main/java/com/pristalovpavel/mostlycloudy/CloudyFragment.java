package com.pristalovpavel.mostlycloudy;

/**
 * Created by Pristalov Pavel on 26.12.2014 for Mostly Cloudy.
 */

import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.pristalovpavel.mostlycloudy.controller.CloudController;

import java.util.ArrayList;

/**
 *  Fragment containing clouds and house.
 */
public class CloudyFragment extends Fragment
{
    public CloudyFragment()
    {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View rootView = inflater.inflate(R.layout.fragment_cloudy, container, false);
        return rootView;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState)
    {
        initView(view);
    }

    private void initView(View view)
    {
        Point size = getDisplaySize();
        Bitmap cloudBitmap = getCloudBitmap();
        if(cloudBitmap == null) return;

        ArrayList<Point> points = new CloudController()
                                        .screenSize(size.x, size.y)
                                        .setCloudCount(4)
                                        .imageSize(cloudBitmap.getWidth(), cloudBitmap.getHeight())
                                        .calc();

        RelativeLayout layout = (RelativeLayout) view.findViewById(R.id.cloudy_layout);

        for(Point point : points)
        {
            ImageView image = (ImageView) getActivity().getLayoutInflater().inflate(R.layout.image_view_cloud,
                    layout, false);

            image.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View v)
                {
                    Toast.makeText(getActivity(), "I'm a little cloud!", Toast.LENGTH_SHORT).show();
                }
            });

            RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams
                    (RelativeLayout.LayoutParams.WRAP_CONTENT,
                            RelativeLayout.LayoutParams.WRAP_CONTENT);
            params.leftMargin = point.x;
            params.topMargin = point.y;

            layout.addView(image, params);
        }

    }

    private Point getDisplaySize()
    {
        DisplayMetrics metrics = new DisplayMetrics();

        Display display = getActivity().getWindowManager().getDefaultDisplay();
        Point size = new Point();

        display.getMetrics(metrics);
        size.x = metrics.widthPixels;
        size.y = metrics.heightPixels;

        return size;
    }

    private Bitmap getCloudBitmap()
    {
        Drawable drw = getActivity().getResources().getDrawable(R.drawable.cloud);
        if(drw != null && (drw instanceof BitmapDrawable))
        {
            return ((BitmapDrawable) drw).getBitmap();
        }
        else return null;
    }
}
