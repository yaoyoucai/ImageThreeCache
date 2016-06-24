package com.shbd.utils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.util.Log;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/**
 * Created by yh on 2016/6/24.
 * 本地缓存
 */
public class LocalImageDataUtils {
    /**
     * 图片保存到本地的路径
     */
    private static final String dirPath = Environment.getExternalStorageDirectory().getAbsolutePath() + "/imageCache111";

    /**
     * 保存图片到本地
     *
     * @param bitmap
     * @param url
     */
    public static void saveImageToLocal(Bitmap bitmap, String url) {
        File dirFile = new File(dirPath);

        if (!dirFile.exists() || !dirFile.isDirectory()) {
            dirFile.mkdirs();
        }

        File file = new File(dirPath, MD5Encoder.encode(url));

        try {
            /**
             * 将图片压缩保存在本地
             */
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, new FileOutputStream(file));

            Log.e(ImageUtils.TAG, "将图片压缩保存在本地");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * 从本地读取图片
     *
     * @param url
     * @return
     */
    public static Bitmap getImageFromLocal(String url) {
        Bitmap bitmap = null;

        File file = new File(dirPath, MD5Encoder.encode(url));
        try {

            if (file.exists()) {
                bitmap = BitmapFactory.decodeStream(new FileInputStream(file));
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return bitmap;
    }
}
