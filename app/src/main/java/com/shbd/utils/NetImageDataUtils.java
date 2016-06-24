package com.shbd.utils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by yh on 2016/6/24.
 * 网络缓存
 */
public class NetImageDataUtils {


    private static final String TAG = "TAG";

    /**
     * 从网络获取图片数据,并设置给图片
     *
     * @param imageView
     * @param url
     */
    public static void setImageCacheFromNet(ImageView imageView, String url) {
        imageView.setTag(url);

        ImageDataAsyncTask imageDataAsyncTask = new ImageDataAsyncTask();
        imageDataAsyncTask.execute(imageView, url);
    }

    /**
     * 异步下载和更新图片
     * 参数1:Params:传入的参数
     * 参数2:Progress:更新的进度
     * 参数3:Result:返回的参数
     */
    static class ImageDataAsyncTask extends AsyncTask<Object, Integer, Bitmap> {

        private ImageView imageView;
        private String url;

        /**
         * 主线程运行,预加载
         */
        @Override
        protected void onPreExecute() {
        }

        /**
         * 子线程运行，下载图片
         *
         * @param params
         * @return
         */
        @Override
        protected Bitmap doInBackground(Object... params) {
            imageView = (ImageView) params[0];
            url = (String) params[1];

            Bitmap bitmap = download(url);

            if (bitmap != null) {
                Log.e(TAG, " 网络下载图片成功");
                LocalImageDataUtils.saveImageToLocal(bitmap, url);

                MemoryImageDataUtils.saveImageToMemory(bitmap, url);
            }
            return download(url);
        }

        /**
         * 主线程运行,更新ui
         *
         * @param bitmap
         */
        @Override
        protected void onPostExecute(Bitmap bitmap) {
            //防止图片错乱
            if (url.equals(imageView.getTag())) {
                imageView.setImageBitmap(bitmap);
            }
        }

        /**
         * 主线程运行,更新进度
         *
         * @param values
         */
        @Override
        protected void onProgressUpdate(Integer... values) {
        }
    }

    /**
     * 下载图片
     *
     * @param url
     * @return
     */
    private static Bitmap download(String url) {
        HttpURLConnection con = null;
        InputStream inputStream = null;
        Bitmap bitmap = null;

        try {

            URL imageUrl = new URL(url);
            con = (HttpURLConnection) imageUrl.openConnection();
            con.setReadTimeout(5000);
            con.setConnectTimeout(5000);
            con.setRequestMethod("GET");
            con.connect();
            int responseCode = con.getResponseCode();

            if (responseCode == 200) {
                inputStream = con.getInputStream();
                bitmap = BitmapFactory.decodeStream(inputStream);
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (con != null) {
                con.disconnect();
            }

            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return bitmap;
    }

}
