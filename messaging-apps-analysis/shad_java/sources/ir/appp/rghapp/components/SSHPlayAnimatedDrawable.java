package ir.appp.rghapp.components;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import ir.medu.shad.R;
import org.rbmain.messenger.AndroidUtilities;

/* loaded from: classes3.dex */
public class SSHPlayAnimatedDrawable extends Drawable {
    private boolean animate;
    private Bitmap bitmap;
    private boolean isVisible;
    private Matrix scaleMatrix;
    private int currentAlpha = 0;
    private Paint paint = new Paint(2);

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -2;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
    }

    public SSHPlayAnimatedDrawable(Context context) {
        this.bitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.ic_play_button);
        float fDp = AndroidUtilities.dp(48.0f) / this.bitmap.getWidth();
        Matrix matrix = new Matrix();
        this.scaleMatrix = matrix;
        matrix.setScale(fDp, fDp, 0.0f, 0.0f);
    }

    public void setIsVisible(boolean z) {
        setIsVisible(z, true);
    }

    public void setIsVisible(boolean z, boolean z2) {
        this.isVisible = z;
        this.animate = z2;
        if (z) {
            this.currentAlpha = z2 ? 0 : 255;
        } else {
            this.currentAlpha = z2 ? 255 : 0;
        }
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        canvas.setMatrix(this.scaleMatrix);
        if (!this.isVisible) {
            if (this.animate) {
                int i = this.currentAlpha;
                if (i >= 0 && i < 255) {
                    this.paint.setAlpha(i);
                    canvas.drawBitmap(this.bitmap, 0.0f, 0.0f, this.paint);
                    this.currentAlpha += 42;
                    AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.appp.rghapp.components.SSHPlayAnimatedDrawable$$ExternalSyntheticLambda0
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.invalidateSelf();
                        }
                    }, 15L);
                    return;
                }
                if (i < 510) {
                    this.paint.setAlpha(510 - i);
                    canvas.drawBitmap(this.bitmap, 0.0f, 0.0f, this.paint);
                    this.currentAlpha += 42;
                    AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.appp.rghapp.components.SSHPlayAnimatedDrawable$$ExternalSyntheticLambda0
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.invalidateSelf();
                        }
                    }, 15L);
                    return;
                }
                return;
            }
            this.paint.setAlpha(this.currentAlpha);
            canvas.drawBitmap(this.bitmap, 0.0f, 0.0f, this.paint);
            return;
        }
        if (this.animate) {
            int i2 = this.currentAlpha;
            if (i2 < 255) {
                this.paint.setAlpha(i2);
                canvas.drawBitmap(this.bitmap, 0.0f, 0.0f, this.paint);
                this.currentAlpha += 42;
                AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.appp.rghapp.components.SSHPlayAnimatedDrawable$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.invalidateSelf();
                    }
                }, 15L);
                return;
            }
            this.currentAlpha = 255;
            this.paint.setAlpha(255);
            canvas.drawBitmap(this.bitmap, 0.0f, 0.0f, this.paint);
            return;
        }
        this.paint.setAlpha(this.currentAlpha);
        canvas.drawBitmap(this.bitmap, 0.0f, 0.0f, this.paint);
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return AndroidUtilities.dp(48.0f);
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return AndroidUtilities.dp(48.0f);
    }
}
