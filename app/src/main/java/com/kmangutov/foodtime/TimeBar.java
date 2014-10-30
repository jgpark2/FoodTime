package com.kmangutov.foodtime;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by kmangutov on 10/29/14.
 */
public class TimeBar extends View {

    public TimeBar(Context context) {
        super(context);
    }

    public TimeBar(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    double selection = 0.0;

    @Override
    protected void onDraw(Canvas canvas) {
        //super.onDraw(canvas);

        Paint paint = new Paint();
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(0xFF33B5E5);
        paint.setStrokeWidth(4);

        int barHeight = (int)(selection * getHeight());
        canvas.drawRect(0, barHeight, getWidth(), getHeight(), paint);

        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(0x000);
        canvas.drawLine(0, 0, getWidth(), getHeight(), paint);
        this.invalidate();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        switch(event.getAction())
        {
            case MotionEvent.ACTION_DOWN:
                Log.d("MOTIONEVENT", event.getX() + "," + event.getY());
                selection = event.getY()/getHeight();
                System.out.println("selection: " + selection);
        }

        return true;
    }
}