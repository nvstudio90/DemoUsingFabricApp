package com.nvstudio.demoapp;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.os.Build;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.View;

import java.util.Random;

/**
 * Created by ngoc on 7/15/16.
 */
public class DrawingView extends View {

    private Path mPath = new Path();
    private Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private Random mRandom = new Random();

    public DrawingView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public DrawingView(Context context) {
        super(context);
        init();
    }

    public DrawingView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public DrawingView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    private Handler mHandler = new Handler();
    private Runnable mRunnable = new Runnable() {
        @Override
        public void run() {
            invalidate();
            mHandler.postDelayed(this, 10);
        }
    };

    private void init() {
        mHandler.postDelayed(mRunnable, 2000);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        //canvas.drawColor(Color.WHITE, PorterDuff.Mode.CLEAR);
        int x = canvas.getWidth() / 2;
        int y = canvas.getHeight() / 2;
        int color;
        mPaint.setStyle(Paint.Style.FILL);
        for (int i = -x; i < x; i += 10)
            for (int j = -y; j < y; j += 10) {
                color = (0xFF << 24) | (mRandom.nextInt(256) << 16) | (mRandom.nextInt(256) << 8) |
                        (mRandom.nextInt(256));
                mPaint.setColor(color);
                canvas.drawRect(x + i, y + j, x + i + 10, y + j + 10, mPaint);
            }
    }
}
