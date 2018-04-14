package omy.boston.transformations.views;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PixelFormat;
import android.graphics.drawable.Drawable;

/**
 * Created by LosFrancisco on 11-Apr-17.
 */

public class OverDrawable extends Drawable {

    private ColorFilter filter;
    private int mOpacity;

    @Override
    public void draw(Canvas canvas) {
        Paint paint = new Paint();
        paint.setColorFilter(filter);
        paint.setAlpha(mOpacity);
        paint.setTextSize(30);
        paint.setColor(Color.GRAY);
        canvas.drawText("Hello", 40, 55, paint);
        paint.setTextSize(50);
        paint.setColor(Color.MAGENTA);
        canvas.drawText("Android", 35, 100, paint);
    }

    @Override
    public void setAlpha(int alpha) {

    }

    @Override
    public void setColorFilter(ColorFilter colorFilter) {

    }

    @Override
    public int getOpacity() {
        return PixelFormat.TRANSLUCENT;
    }
}
