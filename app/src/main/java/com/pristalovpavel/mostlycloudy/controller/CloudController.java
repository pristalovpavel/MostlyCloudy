package com.pristalovpavel.mostlycloudy.controller;

import android.graphics.Point;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Pristalov Pavel on 27.12.2014 for Mostly Cloudy.
 */
public class CloudController
{
    private static final int MAX_ROW_COUNT = 4;
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

    public ArrayList<Point> calc()
    {
        ArrayList<Point> result = new ArrayList<Point>();

        if(screenWidth > 0
                && screenHeight > 0
                && imageWidth > 0
                && imageHeight > 0
                && cloudCount > 0)
        {
            //generating rows of clouds with random shifts
            Random random = new Random(System.currentTimeMillis());

            // TODO maybe integer count, so there are no space between them
            int cloudsInRow = Math.min(screenWidth / imageWidth, cloudCount);

            int xAddition = screenWidth / cloudsInRow - imageWidth;
            int xDeviation = xAddition;

            int yAddition = -1;
            int yDeviation = -1;

            int rowCount = MAX_ROW_COUNT;
            while(yAddition < 0 && rowCount > 0)
            {
                yAddition = screenHeight / ((rowCount + 1) * 2) - imageHeight;
                yDeviation = yAddition;
                rowCount--;
            }

            for(int i = 0; i != cloudCount; ++i)
            {
                // calculates coordinates of top left corner of the cloud
                Point currentPoint = new Point();

                currentPoint.x = (i % cloudsInRow) * (xAddition + imageWidth) + xAddition / 2
                        + random.nextInt(xDeviation) * (random.nextBoolean() ? 1 : -1);

                currentPoint.y = (i / cloudsInRow) * (yAddition + imageHeight) + yAddition / 2
                        + random.nextInt(yDeviation) * (random.nextBoolean() ? 1 : -1);

                result.add(currentPoint);
            }
        }

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
