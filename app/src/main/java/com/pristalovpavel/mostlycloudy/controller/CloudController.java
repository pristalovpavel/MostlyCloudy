package com.pristalovpavel.mostlycloudy.controller;

import android.graphics.Point;

import java.util.ArrayList;

/**
 * Created by Pristalov Pavel on 27.12.2014 for Mostly Cloudy.
 */
public class CloudController
{
    private int screenWidth;
    private int screenHeight;
    private int cloudCount;
    private int imageWidth;
    private int imageHeight;

    public CloudController()
    {
        screenWidth = -1;
        screenHeight = -1;
        cloudCount = 1;
        imageWidth = -1;
        imageHeight = -1;
    }

    public ArrayList<Point> refresh(int screenWidth, int screenHeight)
    {
        ArrayList<Point> result = new ArrayList<Point>();

        // TODO
        return result;
    }

    public CloudController screenSize(int screenWidth, int screenHeight)
    {
        this.screenWidth = screenWidth;
        this.screenHeight = screenHeight;
        return this;
    }

    public CloudController imageSize(int imageWidth, int imageHeight)
    {
        this.imageWidth = imageWidth;
        this.imageHeight = imageHeight;
        return this;
    }

    public CloudController setCloudCount(int cloudCount)
    {
        this.cloudCount = cloudCount;
        return this;
    }
}
