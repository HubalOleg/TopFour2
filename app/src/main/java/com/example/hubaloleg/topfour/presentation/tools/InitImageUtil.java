package com.example.hubaloleg.topfour.presentation.tools;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

/**
 * Created by kostya on 11.07.17.
 */

public class InitImageUtil {

     private InitImageUtil() {

     }

     public static void initImage(Context context, String url, ImageView imageView) {
          Glide.with(context)
                  .load(url)
                  .into(imageView);
     }
}
