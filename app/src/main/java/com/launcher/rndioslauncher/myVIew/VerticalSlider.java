package com.launcher.rndioslauncher.myVIew;

/*import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

public class VerticalSlider extends View {

    private static final int DEFAULT_COLOR = Color.BLUE;
    private static final int BACKGROUND_COLOR = Color.LTGRAY;

    private float value = 0.5f;
    private Paint paint;
    private RectF progressRect;
    private OnValueChangedListener onValueChangedListener;

    public interface OnValueChangedListener {
        void onValueChanged(float value);
    }

    public VerticalSlider(Context context) {
        super(context);
        init();
    }

    public VerticalSlider(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public VerticalSlider(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        paint = new Paint();
        paint.setColor(DEFAULT_COLOR);

        progressRect = new RectF();
    }

    public void setOnValueChangedListener(OnValueChangedListener listener) {
        this.onValueChangedListener = listener;
    }

    public void setValue(float value) {
        this.value = Math.max(0, Math.min(1, value));
        invalidate();

        if (onValueChangedListener != null) {
            onValueChangedListener.onValueChanged(this.value);
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        // Draw background
        paint.setColor(BACKGROUND_COLOR);
        canvas.drawRect(0, 0, getWidth(), getHeight(), paint);

        // Draw progress
        paint.setColor(DEFAULT_COLOR);
        progressRect.set(0, getHeight() * (1 - value), getWidth(), getHeight());
        canvas.drawRect(progressRect, paint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_MOVE:
                float newValue = 1 - (event.getY() / getHeight());
                setValue(newValue);
                return true;
        }
        return super.onTouchEvent(event);
    }*/

/*
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

public class VerticalSlider extends View {

    private static final int DEFAULT_COLOR = Color.BLUE;
    private static final int BACKGROUND_COLOR = Color.LTGRAY;
    private static final int MAX_VALUE = 100;

    private float value = 50;
    private Paint paint;
    private RectF progressRect;
    private OnValueChangedListener onValueChangedListener;

    public interface OnValueChangedListener {
        void onValueChanged(int value);
    }

    public VerticalSlider(Context context) {
        super(context);
        init();
    }

    public VerticalSlider(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public VerticalSlider(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        paint = new Paint();
        paint.setColor(DEFAULT_COLOR);

        progressRect = new RectF();
    }

    public void setOnValueChangedListener(OnValueChangedListener listener) {
        this.onValueChangedListener = listener;
    }

    public void setValue(int value) {
        this.value = Math.max(0, Math.min(MAX_VALUE, value));
        invalidate();

        if (onValueChangedListener != null) {
            onValueChangedListener.onValueChanged((int) this.value);
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        // Draw background
        paint.setColor(BACKGROUND_COLOR);
        canvas.drawRect(0, 0, getWidth(), getHeight(), paint);

        // Draw progress
        paint.setColor(DEFAULT_COLOR);
        float percentage = value / MAX_VALUE;
        progressRect.set(0, getHeight() * (1 - percentage), getWidth(), getHeight());
        canvas.drawRect(progressRect, paint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
            case MotionEvent.ACTION_MOVE:
                float newValue = MAX_VALUE * (1 - (event.getY() / getHeight()));
                setValue((int) newValue);
                return true;
        }
        return super.onTouchEvent(event);
    }
}
*/

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

public class VerticalSlider extends View {

    private static final int DEFAULT_COLOR = Color.BLUE;
    private static final int BACKGROUND_COLOR = Color.LTGRAY;
    private static final int MAX_VALUE = 100;

    private float value = 50;
    private float cornerRadius = 0; // Default corner radius
    private Paint paint;
    private RectF progressRect;
    private OnValueChangedListener onValueChangedListener;

    public interface OnValueChangedListener {
        void onValueChanged(int value);
    }

    public VerticalSlider(Context context) {
        super(context);
        init();
    }

    public VerticalSlider(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public VerticalSlider(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        paint = new Paint();
        paint.setColor(DEFAULT_COLOR);

        progressRect = new RectF();
    }

    public void setOnValueChangedListener(OnValueChangedListener listener) {
        this.onValueChangedListener = listener;
    }

    public void setValue(int value) {
        this.value = Math.max(0, Math.min(MAX_VALUE, value));
        invalidate();

        if (onValueChangedListener != null) {
            onValueChangedListener.onValueChanged((int) this.value);
        }
    }

    public void setCornerRadius(float cornerRadius) {
        this.cornerRadius = cornerRadius;
        invalidate();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        // Draw background
        paint.setColor(BACKGROUND_COLOR);
        canvas.drawRoundRect(0, 0, getWidth(), getHeight(), cornerRadius, cornerRadius, paint);

        // Draw progress
        paint.setColor(DEFAULT_COLOR);
        float percentage = value / MAX_VALUE;
        progressRect.set(0, getHeight() * (1 - percentage), getWidth(), getHeight());
        canvas.drawRoundRect(progressRect, cornerRadius, cornerRadius, paint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
            case MotionEvent.ACTION_MOVE:
                float newValue = MAX_VALUE * (1 - (event.getY() / getHeight()));
                setValue((int) newValue);
                return true;
        }
        return super.onTouchEvent(event);
    }
}