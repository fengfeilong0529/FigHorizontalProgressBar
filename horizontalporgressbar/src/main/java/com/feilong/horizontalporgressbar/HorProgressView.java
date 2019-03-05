package com.feilong.horizontalporgressbar;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import java.text.DecimalFormat;


/**
 * 带百分比显示的水平进度条
 *
 * @author Administrator
 */
public class HorProgressView extends View {

    private int mBaseColor = Color.GRAY;
    private int mProcessColor = Color.GREEN;
    private int mProcessTextColor = Color.BLUE;
    private int mProcessTextSize;
    private int mBarWidth;
    private Paint mTextPaint;
    private Paint mProcessPaint;
    private Paint mBasePaint;
    private int mMax, mCurrentValue;

    public HorProgressView(Context context) {
        super(context);
    }

    public HorProgressView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.HorProgressView);
        mBaseColor = ta.getColor(R.styleable.HorProgressView_baseColor, mBaseColor);
        mProcessColor = ta.getColor(R.styleable.HorProgressView_processColor, mProcessColor);
        mProcessTextColor = ta.getColor(R.styleable.HorProgressView_processTextColor, mProcessTextColor);
        mProcessTextSize = ta.getDimensionPixelOffset(R.styleable.HorProgressView_processTextSize, mProcessTextSize);
        mBarWidth = (int) ta.getDimension(R.styleable.HorProgressView_barWidth, mBarWidth);
        ta.recycle();

        //背景线条画笔
        mBasePaint = new Paint();
        mBasePaint.setAntiAlias(true);
        mBasePaint.setColor(mBaseColor);
        mBasePaint.setStyle(Paint.Style.STROKE);
        mBasePaint.setStrokeCap(Paint.Cap.ROUND);
        mBasePaint.setStrokeWidth(mBarWidth);

        //进度条画笔
        mProcessPaint = new Paint();
        mProcessPaint.setAntiAlias(true);
        mProcessPaint.setColor(mProcessColor);
        mProcessPaint.setStyle(Paint.Style.STROKE);
        mProcessPaint.setStrokeCap(Paint.Cap.ROUND);
        mProcessPaint.setStrokeWidth(mBarWidth);

        mTextPaint = new Paint();
        mTextPaint.setAntiAlias(true);
        mTextPaint.setColor(mProcessTextColor);
        mTextPaint.setTextSize(mProcessTextSize);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int width = MeasureSpec.getSize(widthMeasureSpec);
        int height = MeasureSpec.getSize(heightMeasureSpec);
        setMeasuredDimension(width, height);
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //绘制底部线条
        canvas.drawLine(mBarWidth / 2, getHeight() / 2, getWidth() - mBarWidth / 2, getHeight() / 2, mBasePaint);

        //绘制进度条
        float i = (float) mCurrentValue / mMax;
        canvas.drawLine(mBarWidth / 2, getHeight() / 2, i * getWidth() - mBarWidth / 2, getHeight() / 2, mProcessPaint);

        //绘制进度文本
        DecimalFormat df = new DecimalFormat("0");
        String txt = df.format(i * 100) + "%";
        Rect rect = new Rect();
        mTextPaint.getTextBounds(txt, 0, txt.length(), rect);
        canvas.drawText(txt, i * getWidth() - rect.width(), getHeight() / 2 + rect.height() / 2, mTextPaint);
    }

    /**
     * 设置最大值
     *
     * @param max
     */
    public void setMaxValue(int max) {
        this.mMax = max;
    }

    /**
     * 设置当前值
     *
     * @param value
     */
    public void setCurrentValue(int value) {
        this.mCurrentValue = value;
        invalidate();
    }
}
