package omy.boston.transformations.interfaces;

import android.graphics.Canvas;

/**
 * Created by LosFrancisco on 11-Apr-17.
 */

public interface Transformation {
    void transform(Canvas canvas);

    String describe();
}
