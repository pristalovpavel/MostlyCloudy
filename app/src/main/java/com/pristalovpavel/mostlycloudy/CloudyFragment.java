package com.pristalovpavel.mostlycloudy;

/**
 * Created by Pristalov Pavel on 26.12.2014 for Mostly Cloudy.
 */

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

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
        RelativeLayout layout = (RelativeLayout) view.findViewById(R.id.cloudy_layout);

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
        params.leftMargin = 200;
        params.topMargin = 200;
        layout.addView(image, params);
    }
}
