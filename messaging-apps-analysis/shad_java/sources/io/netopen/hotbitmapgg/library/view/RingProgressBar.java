package io.netopen.hotbitmapgg.library.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View;
import io.netopen.hotbitmapgg.library.R$styleable;

/* loaded from: classes3.dex */
public class RingProgressBar extends View {
    private int centre;
    private int height;
    private OnProgressListener mOnProgressListener;
    private int max;
    private int padding;
    private Paint paint;
    private int progress;
    private int radius;
    private int result;
    private int ringColor;
    private int ringProgressColor;
    private float ringWidth;
    private int style;
    private int textColor;
    private boolean textIsShow;
    private float textSize;
    private int width;

    public interface OnProgressListener {
        void progressToComplete();
    }

    public RingProgressBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RingProgressBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.result = 0;
        this.padding = 0;
        this.paint = new Paint();
        this.result = dp2px(100);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.RingProgressBar);
        this.ringColor = typedArrayObtainStyledAttributes.getColor(R$styleable.RingProgressBar_ringColor, -16777216);
        this.ringProgressColor = typedArrayObtainStyledAttributes.getColor(R$styleable.RingProgressBar_ringProgressColor, -1);
        this.textColor = typedArrayObtainStyledAttributes.getColor(R$styleable.RingProgressBar_textColor, -16777216);
        this.textSize = typedArrayObtainStyledAttributes.getDimension(R$styleable.RingProgressBar_textSize, 16.0f);
        this.ringWidth = typedArrayObtainStyledAttributes.getDimension(R$styleable.RingProgressBar_ringWidth, 5.0f);
        this.max = typedArrayObtainStyledAttributes.getInteger(R$styleable.RingProgressBar_max, 100);
        this.textIsShow = typedArrayObtainStyledAttributes.getBoolean(R$styleable.RingProgressBar_textIsShow, true);
        this.style = typedArrayObtainStyledAttributes.getInt(R$styleable.RingProgressBar_style, 0);
        typedArrayObtainStyledAttributes.recycle();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int width = getWidth() / 2;
        this.centre = width;
        this.radius = (int) (width - (this.ringWidth / 2.0f));
        drawCircle(canvas);
        drawTextContent(canvas);
        drawProgress(canvas);
    }

    private void drawCircle(Canvas canvas) {
        this.paint.setColor(this.ringColor);
        this.paint.setStyle(Paint.Style.STROKE);
        this.paint.setStrokeWidth(this.ringWidth);
        this.paint.setAntiAlias(true);
        int i = this.centre;
        canvas.drawCircle(i, i, this.radius, this.paint);
    }

    private void drawTextContent(Canvas canvas) {
        this.paint.setStrokeWidth(0.0f);
        this.paint.setColor(this.textColor);
        this.paint.setTextSize(this.textSize);
        this.paint.setTypeface(Typeface.DEFAULT);
        int i = (int) ((this.progress / this.max) * 100.0f);
        float fMeasureText = this.paint.measureText(i + "%");
        if (this.textIsShow && i != 0 && this.style == 0) {
            int i2 = this.centre;
            canvas.drawText(i + "%", i2 - (fMeasureText / 2.0f), i2 + (this.textSize / 2.0f), this.paint);
        }
    }

    private void drawProgress(Canvas canvas) {
        this.paint.setStrokeWidth(this.ringWidth);
        this.paint.setColor(this.ringProgressColor);
        int i = this.centre;
        int i2 = this.radius;
        RectF rectF = new RectF(i - i2, i - i2, i + i2, i + i2);
        int i3 = this.centre;
        int i4 = this.radius;
        float f = this.ringWidth;
        int i5 = this.padding;
        RectF rectF2 = new RectF((i3 - i4) + f + i5, (i3 - i4) + f + i5, ((i3 + i4) - f) - i5, ((i3 + i4) - f) - i5);
        int i6 = this.style;
        if (i6 == 0) {
            this.paint.setStyle(Paint.Style.STROKE);
            this.paint.setStrokeCap(Paint.Cap.ROUND);
            canvas.drawArc(rectF, -90.0f, (this.progress * 360) / this.max, false, this.paint);
        } else {
            if (i6 != 1) {
                return;
            }
            this.paint.setStyle(Paint.Style.FILL_AND_STROKE);
            this.paint.setStrokeCap(Paint.Cap.ROUND);
            if (this.progress != 0) {
                canvas.drawArc(rectF2, -90.0f, (r0 * 360) / this.max, true, this.paint);
            }
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int size2 = View.MeasureSpec.getSize(i2);
        if (mode == Integer.MIN_VALUE) {
            this.width = this.result;
        } else {
            this.width = size;
        }
        if (mode2 == Integer.MIN_VALUE) {
            this.height = this.result;
        } else {
            this.height = size2;
        }
        setMeasuredDimension(this.width, this.height);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.width = i;
        this.height = i2;
        this.padding = dp2px(5);
    }

    public synchronized int getMax() {
        return this.max;
    }

    public synchronized void setMax(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("The max progress of 0");
        }
        this.max = i;
    }

    public synchronized int getProgress() {
        return this.progress;
    }

    public synchronized void setProgress(int i) {
        OnProgressListener onProgressListener;
        if (i < 0) {
            throw new IllegalArgumentException("The progress of 0");
        }
        int i2 = this.max;
        if (i > i2) {
            i = i2;
        }
        if (i <= i2) {
            this.progress = i;
            postInvalidate();
        }
        if (i == this.max && (onProgressListener = this.mOnProgressListener) != null) {
            onProgressListener.progressToComplete();
        }
    }

    public int getRingColor() {
        return this.ringColor;
    }

    public void setRingColor(int i) {
        this.ringColor = i;
    }

    public int getRingProgressColor() {
        return this.ringProgressColor;
    }

    public void setRingProgressColor(int i) {
        this.ringProgressColor = i;
    }

    public int getTextColor() {
        return this.textColor;
    }

    public void setTextColor(int i) {
        this.textColor = i;
    }

    public float getTextSize() {
        return this.textSize;
    }

    public void setTextSize(float f) {
        this.textSize = f;
    }

    public float getRingWidth() {
        return this.ringWidth;
    }

    public void setRingWidth(float f) {
        this.ringWidth = f;
    }

    public int dp2px(int i) {
        return (int) ((i * getContext().getResources().getDisplayMetrics().density) + 0.5f);
    }

    public void setOnProgressListener(OnProgressListener onProgressListener) {
        this.mOnProgressListener = onProgressListener;
    }
}
