package com.example.uneed.network;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ImageView;

import com.example.uneed.MarketActivity;
import com.example.uneed.R;

import java.io.InputStream;

/**
 * This class takes pics from internet
 * and implement it to the android
 * @author  fistikci_sahap
 * @version 1.0
 * */
public class DownloadImageTask extends AsyncTask<String, Void, Bitmap> {
    ImageView bmImage;

    public DownloadImageTask(ImageView bmImage) {
        this.bmImage = bmImage;
    }

    /**
     * This method sets images after execution
     * @param result Bitmap
     * */
    protected void onPostExecute(Bitmap result) {
        bmImage.setImageBitmap(result);
    }
}
