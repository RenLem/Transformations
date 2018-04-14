package omy.boston.transformations.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;

import omy.boston.transformations.interfaces.Transformation;

/**
 * Created by LosFrancisco on 11-Apr-17.
 */

public class TransformedViewWidget extends View {

    private final Transformation mTransformation;
    private final Drawable mDrawable;


    public TransformedViewWidget(Context context, Transformation xForm) {
        super(context);
        this.mTransformation = xForm;
        this.mDrawable = null;
        setMinimumWidth(280);
        setMinimumHeight(220);
    }
    /** Da bi koristio ovaj konstruktor moraš u Mainu na
     layoute dodat metodam addView metode koje tamo
     dupliciraš izTransformedViewWidget & Transformation interfacea
     RAZLIKUJU SE SAMO PO TOME ŠTO NA KRAJU IMAJU POZIV NOVE InSTANCE
     *
     "OverDrawablea"
     *
     I TO JE TO!*/

    public TransformedViewWidget(Context context, Transformation xForm, Drawable drawable) {
        super(context);
        this.mTransformation = xForm;
        this.mDrawable = drawable;
        setMinimumWidth(280);
        setMinimumHeight(220);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        setMeasuredDimension(getSuggestedMinimumWidth(), getSuggestedMinimumHeight());
    }

    @Override
    protected void onDraw(Canvas canvas){
        canvas.drawColor(Color.BLACK);
        canvas.save();
        mTransformation.transform(canvas);
        Paint paint = new Paint();

        if (mDrawable == null) {
            paint.setTextSize(50);
            paint.setColor(Color.CYAN);
            canvas.drawText("Android", 39, 55, paint);
            paint.setTextSize(38);
            paint.setColor(Color.GREEN);
            canvas.drawText("Grafics", 37, 100, paint);
            canvas.restore();
            paint.setColor(Color.WHITE);
            paint.setStyle(Paint.Style.STROKE);
            Rect rect = canvas.getClipBounds();
            canvas.drawRect(rect, paint);
            paint.setTextSize(18);
            paint.setColor(Color.WHITE);
            canvas.drawText(mTransformation.describe(), 2, 180, paint);
        }else { // Dolazi u slučaju kad se poziva DRAWABLE
            mDrawable.draw(canvas);
            canvas.restore();
            paint.setColor(Color.GRAY);
            paint.setStyle(Paint.Style.STROKE);
            Rect rect = canvas.getClipBounds();
            canvas.drawRect(rect, paint);
            paint.setTextSize(12);
            paint.setColor(Color.BLUE);
            canvas.drawText(mTransformation.describe(), 2, getMeasuredHeight()-2, paint);

        }
    }
}
