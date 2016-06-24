package com.shbd.utils;

import android.graphics.Bitmap;
import android.support.v4.util.LruCache;
import android.util.Log;

/**
 * Created by yh on 2016/6/24.
 * 内存缓存
 */
public class MemoryImageDataUtils {
    //谷歌推荐使用LruCache来保存内存数据
    private static LruCache<String, Bitmap> imageCache;

    static {
        long maxMemory = Runtime.getRuntime().maxMemory();
        imageCache = new LruCache<String, Bitmap>((int) (maxMemory / 8)) {

            /**
             * 必须重写该方法来获取每一个bitmap的大小
             *
             * @param key
             * @param value
             * @return
             */
            @Override
            protected int sizeOf(String key, Bitmap value) {
                int byteCount = value.getByteCount();
                return byteCount;
            }
        };
    }

    /**
     * 保存数据到内存
     *
     * @param bitmap
     * @param url
     */
    public static void saveImageToMemory(Bitmap bitmap, String url) {
        Log.e(ImageUtils.TAG, "保存数据到内存");
        if (bitmap != null) {
            imageCache.put(MD5Encoder.encode(url), bitmap);
        }
    }

    /**
     * 从内存中取出保存的数据
     *
     * @param url
     * @return
     */
    public static Bitmap getImageFromMemory(String url) {
        return imageCache.get(MD5Encoder.encode(url));
    }
}
