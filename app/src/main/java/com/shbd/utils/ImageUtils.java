package com.shbd.utils;

import android.graphics.Bitmap;
import android.util.Log;
import android.widget.ImageView;

/**
 * Created by yh on 2016/6/24.
 * 图片三级缓存
 */
public class ImageUtils {
    public static final String TAG = "TAG";

    public static void displayImage(ImageView imageView, String url) {
        //1.内存缓存
        Bitmap memoryBitmap = MemoryImageDataUtils.getImageFromMemory(url);
        if (memoryBitmap != null) {
            imageView.setImageBitmap(memoryBitmap);
            Log.e(TAG, "从内存读取缓存 ");
            return;
        }

        //2.本地缓存
        Bitmap localBitmap = LocalImageDataUtils.getImageFromLocal(url);
        if (localBitmap != null) {
            imageView.setImageBitmap(localBitmap);
            Log.e(TAG, "从本地读取缓存 ");

            //将缓存数据保存到内存
            MemoryImageDataUtils.saveImageToMemory(localBitmap,url);
            return;
        }

        //3.网络缓存
        NetImageDataUtils.setImageCacheFromNet(imageView, url);
    }
}
