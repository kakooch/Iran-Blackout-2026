package ir.eitaa.ui.Components;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Shader;
import android.view.View;
import androidx.annotation.Keep;
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.messenger.FileLog;
import ir.eitaa.messenger.ImageReceiver;
import java.util.Arrays;

/* loaded from: classes3.dex */
public class ClippingImageView extends View {
    private static float[] radii = new float[8];
    private float additionalTranslationX;
    private float additionalTranslationY;
    private float animationProgress;
    private float[][] animationValues;
    private RectF bitmapRect;
    private BitmapShader bitmapShader;
    private ImageReceiver.BitmapHolder bmp;
    private int clipBottom;
    private int clipLeft;
    private int clipRight;
    private int clipTop;
    private RectF drawRect;
    private int imageX;
    private int imageY;
    private Matrix matrix;
    private boolean needRadius;
    private int orientation;
    private Paint paint;
    private int[] radius;
    private Paint roundPaint;
    private Path roundPath;
    private RectF roundRect;
    private Matrix shaderMatrix;

    public ClippingImageView(Context context) {
        super(context);
        this.radius = new int[4];
        this.roundPath = new Path();
        Paint paint = new Paint(2);
        this.paint = paint;
        paint.setFilterBitmap(true);
        this.matrix = new Matrix();
        this.drawRect = new RectF();
        this.bitmapRect = new RectF();
        this.roundPaint = new Paint(3);
        this.roundRect = new RectF();
        this.shaderMatrix = new Matrix();
    }

    public void setAnimationValues(float[][] values) {
        this.animationValues = values;
    }

    public void setAdditionalTranslationY(float value) {
        this.additionalTranslationY = value;
    }

    public void setAdditionalTranslationX(float value) {
        this.additionalTranslationX = value;
    }

    @Override // android.view.View
    public void setTranslationY(float translationY) {
        super.setTranslationY(translationY + this.additionalTranslationY);
    }

    @Override // android.view.View
    public float getTranslationY() {
        return super.getTranslationY() - this.additionalTranslationY;
    }

    @Keep
    public float getAnimationProgress() {
        return this.animationProgress;
    }

    @Keep
    public void setAnimationProgress(float progress) {
        this.animationProgress = progress;
        float[][] fArr = this.animationValues;
        setScaleX(fArr[0][0] + ((fArr[1][0] - fArr[0][0]) * progress));
        float[][] fArr2 = this.animationValues;
        setScaleY(fArr2[0][1] + ((fArr2[1][1] - fArr2[0][1]) * this.animationProgress));
        float[][] fArr3 = this.animationValues;
        float f = fArr3[0][2];
        float f2 = this.additionalTranslationX;
        setTranslationX(f + f2 + ((((fArr3[1][2] + f2) - fArr3[0][2]) - f2) * this.animationProgress));
        float[][] fArr4 = this.animationValues;
        setTranslationY(fArr4[0][3] + ((fArr4[1][3] - fArr4[0][3]) * this.animationProgress));
        float[][] fArr5 = this.animationValues;
        setClipHorizontal((int) (fArr5[0][4] + ((fArr5[1][4] - fArr5[0][4]) * this.animationProgress)));
        float[][] fArr6 = this.animationValues;
        setClipTop((int) (fArr6[0][5] + ((fArr6[1][5] - fArr6[0][5]) * this.animationProgress)));
        float[][] fArr7 = this.animationValues;
        setClipBottom((int) (fArr7[0][6] + ((fArr7[1][6] - fArr7[0][6]) * this.animationProgress)));
        int i = 0;
        while (true) {
            int[] iArr = this.radius;
            if (i >= iArr.length) {
                break;
            }
            float[][] fArr8 = this.animationValues;
            int i2 = i + 7;
            iArr[i] = (int) (fArr8[0][i2] + ((fArr8[1][i2] - fArr8[0][i2]) * this.animationProgress));
            setRadius(iArr);
            i++;
        }
        float[][] fArr9 = this.animationValues;
        if (fArr9[0].length > 11) {
            setImageY((int) (fArr9[0][11] + ((fArr9[1][11] - fArr9[0][11]) * this.animationProgress)));
            float[][] fArr10 = this.animationValues;
            setImageX((int) (fArr10[0][12] + ((fArr10[1][12] - fArr10[0][12]) * this.animationProgress)));
        }
        invalidate();
    }

    public void getClippedVisibleRect(RectF rect) {
        rect.left = getTranslationX();
        rect.top = getTranslationY();
        rect.right = rect.left + (getMeasuredWidth() * getScaleX());
        float measuredHeight = rect.top + (getMeasuredHeight() * getScaleY());
        rect.bottom = measuredHeight;
        rect.left += this.clipLeft;
        rect.top += this.clipTop;
        rect.right -= this.clipRight;
        rect.bottom = measuredHeight - this.clipBottom;
    }

    public int getClipBottom() {
        return this.clipBottom;
    }

    public int getClipHorizontal() {
        return this.clipRight;
    }

    public int getClipLeft() {
        return this.clipLeft;
    }

    public int getClipRight() {
        return this.clipRight;
    }

    public int getClipTop() {
        return this.clipTop;
    }

    public int[] getRadius() {
        return this.radius;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        ImageReceiver.BitmapHolder bitmapHolder;
        if (getVisibility() != 0 || (bitmapHolder = this.bmp) == null || bitmapHolder.isRecycled()) {
            return;
        }
        float scaleY = getScaleY();
        canvas.save();
        if (this.needRadius) {
            this.shaderMatrix.reset();
            this.roundRect.set(this.imageX / scaleY, this.imageY / scaleY, getWidth() - (this.imageX / scaleY), getHeight() - (this.imageY / scaleY));
            this.bitmapRect.set(0.0f, 0.0f, this.bmp.getWidth(), this.bmp.getHeight());
            int i = 0;
            AndroidUtilities.setRectToRect(this.shaderMatrix, this.bitmapRect, this.roundRect, this.orientation, false);
            this.bitmapShader.setLocalMatrix(this.shaderMatrix);
            canvas.clipRect(this.clipLeft / scaleY, this.clipTop / scaleY, getWidth() - (this.clipRight / scaleY), getHeight() - (this.clipBottom / scaleY));
            while (true) {
                if (i >= this.radius.length) {
                    break;
                }
                float[] fArr = radii;
                int i2 = i * 2;
                fArr[i2] = r0[i];
                fArr[i2 + 1] = r0[i];
                i++;
            }
            this.roundPath.reset();
            this.roundPath.addRoundRect(this.roundRect, radii, Path.Direction.CW);
            this.roundPath.close();
            canvas.drawPath(this.roundPath, this.roundPaint);
        } else {
            int i3 = this.orientation;
            if (i3 == 90 || i3 == 270) {
                this.drawRect.set((-getHeight()) / 2, (-getWidth()) / 2, getHeight() / 2, getWidth() / 2);
                this.matrix.setRectToRect(this.bitmapRect, this.drawRect, Matrix.ScaleToFit.FILL);
                this.matrix.postRotate(this.orientation, 0.0f, 0.0f);
                this.matrix.postTranslate(getWidth() / 2, getHeight() / 2);
            } else if (i3 == 180) {
                this.drawRect.set((-getWidth()) / 2, (-getHeight()) / 2, getWidth() / 2, getHeight() / 2);
                this.matrix.setRectToRect(this.bitmapRect, this.drawRect, Matrix.ScaleToFit.FILL);
                this.matrix.postRotate(this.orientation, 0.0f, 0.0f);
                this.matrix.postTranslate(getWidth() / 2, getHeight() / 2);
            } else {
                this.drawRect.set(0.0f, 0.0f, getWidth(), getHeight());
                this.matrix.setRectToRect(this.bitmapRect, this.drawRect, Matrix.ScaleToFit.FILL);
            }
            canvas.clipRect(this.clipLeft / scaleY, this.clipTop / scaleY, getWidth() - (this.clipRight / scaleY), getHeight() - (this.clipBottom / scaleY));
            try {
                canvas.drawBitmap(this.bmp.bitmap, this.matrix, this.paint);
            } catch (Exception e) {
                FileLog.e(e);
            }
        }
        canvas.restore();
    }

    public void setClipBottom(int value) {
        this.clipBottom = value;
        invalidate();
    }

    public void setClipHorizontal(int value) {
        this.clipRight = value;
        this.clipLeft = value;
        invalidate();
    }

    public void setClipLeft(int value) {
        this.clipLeft = value;
        invalidate();
    }

    public void setClipRight(int value) {
        this.clipRight = value;
        invalidate();
    }

    public void setClipTop(int value) {
        this.clipTop = value;
        invalidate();
    }

    public void setClipVertical(int value) {
        this.clipBottom = value;
        this.clipTop = value;
        invalidate();
    }

    public void setImageY(int value) {
        this.imageY = value;
    }

    public void setImageX(int value) {
        this.imageX = value;
    }

    public void setOrientation(int angle) {
        this.orientation = angle;
    }

    public void setImageBitmap(ImageReceiver.BitmapHolder bitmap) {
        ImageReceiver.BitmapHolder bitmapHolder = this.bmp;
        if (bitmapHolder != null) {
            bitmapHolder.release();
            this.bitmapShader = null;
        }
        this.bmp = bitmap;
        if (bitmap != null && bitmap.bitmap != null) {
            this.bitmapRect.set(0.0f, 0.0f, bitmap.getWidth(), bitmap.getHeight());
            Bitmap bitmap2 = this.bmp.bitmap;
            Shader.TileMode tileMode = Shader.TileMode.CLAMP;
            BitmapShader bitmapShader = new BitmapShader(bitmap2, tileMode, tileMode);
            this.bitmapShader = bitmapShader;
            this.roundPaint.setShader(bitmapShader);
        }
        invalidate();
    }

    public Bitmap getBitmap() {
        ImageReceiver.BitmapHolder bitmapHolder = this.bmp;
        if (bitmapHolder != null) {
            return bitmapHolder.bitmap;
        }
        return null;
    }

    public int getOrientation() {
        return this.orientation;
    }

    public void setRadius(int[] value) {
        if (value == null) {
            this.needRadius = false;
            Arrays.fill(this.radius, 0);
            return;
        }
        System.arraycopy(value, 0, this.radius, 0, value.length);
        this.needRadius = false;
        for (int i : value) {
            if (i != 0) {
                this.needRadius = true;
                return;
            }
        }
    }
}
