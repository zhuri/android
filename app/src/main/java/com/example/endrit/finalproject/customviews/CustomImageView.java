package com.example.endrit.finalproject.customviews;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.ImageView;

/**
 * Created by endrit on 1/7/2018.
 */

@SuppressLint("AppCompatCustomView")
public class CustomImageView extends ImageView {

    private Paint blue, red;
    public CustomImageView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        setUpPaint();
    }

    private void setUpPaint() {
        blue = new Paint(Paint.ANTI_ALIAS_FLAG);
        red = new Paint(Paint.ANTI_ALIAS_FLAG);

        blue.setColor(Color.BLUE);
        red.setColor(Color.RED);

        blue.setStrokeWidth(20);
        red.setStrokeWidth(20);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        //parent triangle
        canvas.drawLine(getMeasuredWidth()/2,0, 0, getMeasuredHeight()/2, blue); // top-left
        canvas.drawLine(getMeasuredWidth()/2, 0, getMeasuredWidth(), getMeasuredHeight()/2, blue); //top-right
        canvas.drawLine(0, getMeasuredHeight()/2, getMeasuredWidth(), getMeasuredHeight()/2, blue); //middle-middle
        //end of parent triangle

        //child triangle
        //end of child triangle


        canvas.save();
        canvas.restore();
    }
}
