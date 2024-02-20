/*

package com.launcher.rndioslauncher.views;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class VerticalSlider extends View {
    public static final */
/* synthetic *//*
 int B = 0;
    public final Path A;
    @Nullable
    public Bitmap n;
    @Nullable
    public Bitmap o;
    @Nullable
    public Bitmap p;
    public float q = ((float) a(10));
    public int r = 10;
    public int s = 5;
    @Nullable
    public b t;
    public final int u = a(36);
    public final RectF v = new RectF();
    public final RectF w = new RectF(0.0f, 0.0f, (float) getMeasuredWidth(), (float) getMeasuredHeight());
    public final Paint x;
    public final RectF y;
    public final Paint z;

    public static final class a extends f implements f.n.a.a<i> {
        public final */
/* synthetic *//*
 VerticalSlider o;
        public final */
/* synthetic *//*
 int p;
        public final */
/* synthetic *//*
 Context q;
        public final */
/* synthetic *//*
 int r;
        public final */
/* synthetic *//*
 int s;

        */
/* JADX INFO: super call moved to the top of the method (can break code semantics) *//*

        public a(VerticalSlider verticalSlider, int i2, Context context, int i3, int i4) {
            super(0);
            this.o = verticalSlider;
            this.p = i2;
            this.q = context;
            this.r = i3;
            this.s = i4;
        }

        */
/* Return type fixed from 'java.lang.Object' to match base method *//*

        @Override // f.n.a.a
        public i a() {
            int i2 = this.p;
            if (i2 != -1) {
                VerticalSlider verticalSlider = this.o;
                Context context = this.q;
                int i3 = VerticalSlider.B;
                verticalSlider.setIconHigh(verticalSlider.b(context, i2));
            }
            int i4 = this.r;
            if (i4 != -1) {
                VerticalSlider verticalSlider2 = this.o;
                Context context2 = this.q;
                int i5 = VerticalSlider.B;
                verticalSlider2.setIconMedium(verticalSlider2.b(context2, i4));
            }
            int i6 = this.s;
            if (i6 != -1) {
                VerticalSlider verticalSlider3 = this.o;
                Context context3 = this.q;
                int i7 = VerticalSlider.B;
                verticalSlider3.setIconLow(verticalSlider3.b(context3, i6));
            }
            return i.a;
        }
    }

    public interface b {
        void a(int i2, int i3);
    }

    */
/* JADX INFO: super call moved to the top of the method (can break code semantics) *//*

    public VerticalSlider(@NotNull Context context, @NotNull AttributeSet attributeSet) {
        super(context, attributeSet);
        e.f(context, "context");
        e.f(attributeSet, "attributeSet");
        Paint paint = new Paint();
        paint.setColor(Color.parseColor("#aa787878"));
        paint.setAntiAlias(true);
        this.x = paint;
        this.y = new RectF(0.0f, 0.0f, (float) getMeasuredWidth(), (float) getMeasuredHeight());
        Paint paint2 = new Paint();
        paint2.setColor(-1);
        paint2.setAntiAlias(true);
        this.z = paint2;
        this.A = new Path();
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, d.e.a.a.a, 0, 0);
        try {
            int resourceId = obtainStyledAttributes.getResourceId(2, -1);
            int resourceId2 = obtainStyledAttributes.getResourceId(3, -1);
            int resourceId3 = obtainStyledAttributes.getResourceId(1, -1);
            this.r = obtainStyledAttributes.getInteger(4, this.r);
            setProgress(obtainStyledAttributes.getInteger(5, this.s));
            setCornerRadius(obtainStyledAttributes.getDimension(0, this.q));
            a aVar = new a(this, resourceId3, context, resourceId2, resourceId);
            e.e(aVar, "block");
            new f.k.a(aVar).start();
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    public final int a(int i2) {
        Resources resources = getResources();
        e.b(resources, "resources");
        return (int) (((float) i2) * resources.getDisplayMetrics().density);
    }

    public final Bitmap b(Context context, int i2) {
        Object obj = c.i.c.a.a;
        Drawable b2 = a.b.b(context, i2);
        if (b2 != null) {
            Bitmap createBitmap = Bitmap.createBitmap(b2.getIntrinsicWidth(), b2.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(createBitmap);
            b2.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
            b2.draw(canvas);
            e.b(createBitmap, "bitmap");
            return createBitmap;
        }
        e.j();
        throw null;
    }

    public final float getCornerRadius() {
        return this.q;
    }

    @Nullable
    public final Bitmap getIconHigh() {
        return this.n;
    }

    @Nullable
    public final Bitmap getIconLow() {
        return this.p;
    }

    @Nullable
    public final Bitmap getIconMedium() {
        return this.o;
    }

    public final int getMax() {
        return this.r;
    }

    @Nullable
    public final b getOnProgressChangeListener() {
        return this.t;
    }

    public final int getProgress() {
        return this.s;
    }

    public void onDraw(@NotNull Canvas canvas) {
        Bitmap bitmap;
        Bitmap bitmap2;
        e.f(canvas, "canvas");
        canvas.clipPath(this.A);
        canvas.drawRect(this.w, this.x);
        canvas.drawRect(this.y, this.z);
        Bitmap bitmap3 = this.p;
        if (bitmap3 != null && (bitmap = this.o) != null && (bitmap2 = this.n) != null) {
            int i2 = this.s;
            int i3 = this.r;
            if (i2 < i3 / 3) {
                canvas.drawBitmap(bitmap3, (Rect) null, this.v, (Paint) null);
                return;
            }
            int i4 = (i3 * 2) / 3;
            RectF rectF = this.v;
            if (i2 < i4) {
                canvas.drawBitmap(bitmap, (Rect) null, rectF, (Paint) null);
            } else {
                canvas.drawBitmap(bitmap2, (Rect) null, rectF, (Paint) null);
            }
        }
    }

    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        if (getMeasuredHeight() > 0 && getMeasuredWidth() > 0) {
            this.w.set(0.0f, 0.0f, (float) getMeasuredWidth(), (float) getMeasuredHeight());
            this.y.set(0.0f, (((float) 1) - (((float) this.s) / ((float) this.r))) * ((float) getMeasuredHeight()), (float) getMeasuredWidth(), (float) getMeasuredHeight());
            this.v.set((((float) getMeasuredWidth()) / 2.0f) - ((float) (this.u / 2)), (((float) getMeasuredHeight()) / 2.0f) - ((float) (this.u / 2)), (((float) getMeasuredWidth()) / 2.0f) + ((float) (this.u / 2)), (((float) getMeasuredHeight()) / 2.0f) + ((float) (this.u / 2)));
            Path path = this.A;
            RectF rectF = this.w;
            float f2 = this.q;
            path.addRoundRect(rectF, f2, f2, Path.Direction.CW);
        }
    }

    public boolean onTouchEvent(@NotNull MotionEvent motionEvent) {
        e.f(motionEvent, "event");
        int action = motionEvent.getAction();
        if (action != 0) {
            int i2 = 0;
            if (action != 1 && action != 2) {
                return false;
            }
            float measuredHeight = (((float) getMeasuredHeight()) - motionEvent.getY()) / ((float) getMeasuredHeight());
            if (measuredHeight >= ((float) 1)) {
                i2 = this.r;
            } else if (measuredHeight > ((float) 0)) {
                i2 = (int) (((float) this.r) * measuredHeight);
            }
            setProgress(i2);
        }
        return true;
    }

    public final void setCornerRadius(float f2) {
        this.q = f2;
        invalidate();
    }

    public final void setIconHigh(@Nullable Bitmap bitmap) {
        this.n = bitmap;
    }

    public final void setIconHighResource(int i2) {
        Context context = getContext();
        e.b(context, "context");
        this.n = b(context, i2);
    }

    public final void setIconLow(@Nullable Bitmap bitmap) {
        this.p = bitmap;
    }

    public final void setIconLowResource(int i2) {
        Context context = getContext();
        e.b(context, "context");
        this.p = b(context, i2);
    }

    public final void setIconMedium(@Nullable Bitmap bitmap) {
        this.o = bitmap;
    }

    public final void setIconMediumResource(int i2) {
        Context context = getContext();
        e.b(context, "context");
        this.o = b(context, i2);
    }

    public final void setMax(int i2) {
        this.r = i2;
    }

    public final void setOnProgressChangeListener(@Nullable b bVar) {
        this.t = bVar;
    }

    public final void setProgress(int i2) {
        int i3 = this.r;
        if (i2 <= i3) {
            this.s = i2;
            b bVar = this.t;
            if (bVar != null) {
                bVar.a(i2, i3);
            }
            this.y.set(0.0f, (((float) 1) - (((float) this.s) / ((float) this.r))) * ((float) getMeasuredHeight()), (float) getMeasuredWidth(), (float) getMeasuredHeight());
            invalidate();
            return;
        }
        throw new RuntimeException("progress must not be larger than max");
    }
}*/
