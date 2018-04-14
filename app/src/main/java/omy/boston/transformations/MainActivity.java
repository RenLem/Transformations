package omy.boston.transformations;

import android.graphics.Canvas;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import omy.boston.transformations.interfaces.Transformation;
import omy.boston.transformations.views.TransformedViewWidget;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.transformation_layout);

        LinearLayout linearLeft = (LinearLayout) findViewById(R.id.ll_left);

        linearLeft.addView(new TransformedViewWidget(this, new Transformation() {
            @Override
            public void transform(Canvas canvas) {

            }

            @Override
            public String describe() {
                return "Identity";
            }
        }));
        linearLeft.addView(new TransformedViewWidget(this, new Transformation() {
            @Override
            public void transform(Canvas canvas) {
                canvas.rotate(-30.0F);
            }

            @Override
            public String describe() {
                return "rotate(-30)";
            }
        }));
        linearLeft.addView(new TransformedViewWidget(this, new Transformation() {
            @Override
            public void transform(Canvas canvas) {
                canvas.scale(0.5F, 0.8F);
            }

            @Override
            public String describe() {
                return "scale(.5, .8)";
            }
        }));
        linearLeft.addView(new TransformedViewWidget(this, new Transformation() {
            @Override
            public void transform(Canvas canvas) {
                canvas.skew(0.1F, 0.3F);
            }

            @Override
            public String describe() {
                return "skew(.1, .3)";
            }
        }));

        LinearLayout linearRight = (LinearLayout) findViewById(R.id.ll_right);

        linearRight.addView(new TransformedViewWidget(this, new Transformation() {
            @Override
            public void transform(Canvas canvas) {
                canvas.translate(30F, 10F);
            }

            @Override
            public String describe() {
                return "translate(30F, 10F)";
            }
        }));
        linearRight.addView(new TransformedViewWidget(this, new Transformation() {
            @Override
            public void transform(Canvas canvas) {
                canvas.translate(109F, -23F);
                canvas.rotate(82.0F);
            }

            @Override
            public String describe() {
                return "canvas.translate(109F, -23F), canvas.rotate(82.0F)";
            }
        }));
        linearRight.addView(new TransformedViewWidget(this, new Transformation() {
            @Override
            public void transform(Canvas canvas) {
                canvas.translate(-50F, -20F);
                canvas.scale(2F, 1.2F);
            }

            @Override
            public String describe() {
                return "canvas.translate(-50F, -20F),canvas.scale(2F, 1.2F);";
            }
        }));
        linearRight.addView(new TransformedViewWidget(this, new Transformation() {
            @Override
            public void transform(Canvas canvas) {
                canvas.skew(0.1F, 0.2F);
                canvas.translate(-10F, -100F);
                canvas.scale(2.5F, 2F);
            }

            @Override
            public String describe() {
                return "compleks";
            }
        }));
    }
}
