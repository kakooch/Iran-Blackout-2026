package ir.appp.rghapp.components;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.view.View;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.messenger.FileLog;

/* loaded from: classes3.dex */
public class SSHRadioButton extends View {
    private static Paint checkedPaint;
    private static Paint linePaint;
    private static Paint paint;
    private Bitmap bitmap;
    private Canvas bitmapCanvas;
    private int color;
    private boolean isChecked;
    private boolean isLineVisible;
    private int size;

    public SSHRadioButton(Context context) {
        super(context);
        this.size = 52;
        if (paint == null) {
            paint = new Paint(1);
            Paint paint2 = new Paint(1);
            checkedPaint = paint2;
            paint2.setStrokeWidth(14.0f);
            checkedPaint.setStyle(Paint.Style.STROKE);
            checkedPaint.setColor(0);
            checkedPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
            Paint paint3 = new Paint(1);
            linePaint = paint3;
            paint3.setStrokeWidth(AndroidUtilities.dp(1.0f));
            linePaint.setStyle(Paint.Style.STROKE);
            linePaint.setColor(0);
            linePaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        }
        try {
            this.bitmap = Bitmap.createBitmap(AndroidUtilities.dp(this.size), AndroidUtilities.dp(this.size), Bitmap.Config.ARGB_4444);
            this.bitmapCanvas = new Canvas(this.bitmap);
        } catch (Throwable th) {
            FileLog.e(th);
        }
    }

    public void setSize(int i) {
        if (this.size == i) {
            return;
        }
        this.size = i;
    }

    public void setColor(int i) {
        this.color = i;
        invalidate();
    }

    public void showLine(boolean z) {
        this.isLineVisible = z;
        invalidate();
    }

    @Override // android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    public void setChecked(boolean z) {
        if (z == this.isChecked) {
            return;
        }
        this.isChecked = z;
        invalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        Bitmap bitmap = this.bitmap;
        if (bitmap == null || bitmap.getWidth() != getMeasuredWidth()) {
            Bitmap bitmap2 = this.bitmap;
            if (bitmap2 != null) {
                bitmap2.recycle();
                this.bitmap = null;
            }
            try {
                this.bitmap = Bitmap.createBitmap(getMeasuredWidth(), getMeasuredHeight(), Bitmap.Config.ARGB_8888);
                this.bitmapCanvas = new Canvas(this.bitmap);
            } catch (Throwable th) {
                FileLog.e(th);
            }
        }
        paint.setColor(this.color);
        Bitmap bitmap3 = this.bitmap;
        if (bitmap3 != null) {
            bitmap3.eraseColor(0);
            float f = this.size / 2.0f;
            float measuredWidth = getMeasuredWidth() / 2.0f;
            float measuredHeight = getMeasuredHeight() / 2.0f;
            if (this.isChecked) {
                this.bitmapCanvas.drawCircle(measuredWidth, measuredHeight, f + 6.0f, paint);
                this.bitmapCanvas.drawCircle(measuredWidth, measuredHeight, f - 6.0f, checkedPaint);
            } else {
                this.bitmapCanvas.drawCircle(measuredWidth, measuredHeight, f, paint);
                if (this.isLineVisible) {
                    float fSqrt = ((float) Math.sqrt(Math.pow(this.size, 2.0d) / 2.0d)) / 2.0f;
                    this.bitmapCanvas.drawLine((measuredWidth - fSqrt) + 1.0f, (measuredHeight + fSqrt) - 1.0f, (measuredWidth + fSqrt) - 1.0f, (measuredHeight - fSqrt) + 1.0f, linePaint);
                }
            }
            canvas.drawBitmap(this.bitmap, 0.0f, 0.0f, (Paint) null);
        }
    }
}
