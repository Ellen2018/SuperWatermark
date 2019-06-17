package com.ellen.watermark;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;


public class WatemarkUtils {

    /**
     * Bitmap对象是否为空。
     */
    private static boolean isEmptyBitmap(Bitmap src) {
        return src == null || src.getWidth() == 0 || src.getHeight() == 0;
    }

    /**
     *
     * @param bitmap 原图
     * @param content 文本内容
     * @param textSize 文字大小
     * @param textColor 文字颜色
     * @param x 水印坐标x
     * @param y 水印坐标y
     * @return 加上水印后的Bitmap
     */
    public static Bitmap createWatermark(Bitmap bitmap, String content,int textSize,int textColor,float x,float y) {
        if (isEmptyBitmap(bitmap) || content == null)
            return null;
        int w = bitmap.getWidth();
        int h = bitmap.getHeight();
        Bitmap bmp = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bmp);
        Paint p = new Paint();
        // 水印颜色
        p.setColor(textColor);
        // 水印字体大小
        p.setTextSize(textSize);
        //抗锯齿
        p.setAntiAlias(true);
        Paint.FontMetrics fontMetrics =  p.getFontMetrics();
        //绘制图像
        canvas.drawBitmap(bitmap, 0, 0, p);
        //绘制文字
        float height = fontMetrics.descent-fontMetrics.ascent;
        height = height - height/4;
        canvas.drawText(content, x, y+height, p);
        canvas.save();
        canvas.restore();
        return bmp;
    }
}
