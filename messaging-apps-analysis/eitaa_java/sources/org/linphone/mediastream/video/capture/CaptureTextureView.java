package org.linphone.mediastream.video.capture;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Size;
import android.view.TextureView;
import org.linphone.mediastream.Log;

/* loaded from: classes3.dex */
public class CaptureTextureView extends TextureView {
    private DisplayMode mActualMode;
    protected boolean mAlignTopRight;
    private int mCapturedVideoHeight;
    private int mCapturedVideoWidth;
    protected DisplayMode mDisplayMode;
    private RectF mPreviewRect;
    private int mRotation;

    public enum DisplayMode {
        BLACK_BARS,
        OCCUPY_ALL_SPACE,
        HYBRID
    }

    public CaptureTextureView(Context context) {
        this(context, null);
    }

    public CaptureTextureView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CaptureTextureView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mCapturedVideoWidth = 0;
        this.mCapturedVideoHeight = 0;
        this.mRotation = 0;
        DisplayMode displayMode = DisplayMode.BLACK_BARS;
        this.mActualMode = displayMode;
        this.mPreviewRect = null;
        this.mAlignTopRight = true;
        this.mDisplayMode = displayMode;
    }

    public DisplayMode getActualDisplayMode() {
        return this.mActualMode;
    }

    public Size getPreviewVideoSize() {
        return new Size(this.mCapturedVideoWidth, this.mCapturedVideoHeight);
    }

    public RectF getPreviewRectF() {
        return this.mPreviewRect;
    }

    public void rotateToMatchDisplayOrientation(int i) {
        float f;
        this.mRotation = i;
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        Matrix matrix = new Matrix();
        float f2 = measuredWidth;
        float f3 = measuredHeight;
        RectF rectF = new RectF(0.0f, 0.0f, f2, f3);
        matrix.mapRect(rectF);
        Log.d("[Capture TextureView] Rotating preview texture by " + i);
        if (i % 180 == 90) {
            matrix.setPolyToPoly(new float[]{0.0f, 0.0f, f2, 0.0f, 0.0f, f3, f2, f3}, 0, i == 270 ? new float[]{f2, 0.0f, f2, f3, 0.0f, 0.0f, 0.0f, f3} : new float[]{0.0f, f3, 0.0f, 0.0f, f2, f3, f2, 0.0f}, 0, 4);
        } else if (i == 180) {
            matrix.postRotate(180.0f, measuredWidth / 2, measuredHeight / 2);
        }
        if (this.mCapturedVideoWidth != 0 && this.mCapturedVideoHeight != 0) {
            Log.i("[Capture TextureView] TextureView size is " + measuredWidth + "x" + measuredHeight + ", captured video size is " + this.mCapturedVideoWidth + "x" + this.mCapturedVideoHeight);
            DisplayMode displayMode = this.mDisplayMode;
            if (displayMode == DisplayMode.HYBRID) {
                if ((measuredWidth >= measuredHeight && this.mCapturedVideoWidth >= this.mCapturedVideoHeight) || (measuredHeight >= measuredWidth && this.mCapturedVideoHeight >= this.mCapturedVideoWidth)) {
                    Log.i("[Capture TextureView] Hybrid mode enabled, display mode will be 'occupy all space'");
                    this.mActualMode = DisplayMode.OCCUPY_ALL_SPACE;
                } else {
                    Log.i("[Capture TextureView] Hybrid mode enabled, display mode will be 'black bars'");
                    this.mActualMode = DisplayMode.BLACK_BARS;
                }
            } else {
                if (displayMode == DisplayMode.BLACK_BARS) {
                    Log.i("[Capture TextureView] Hybrid mode disabled, display mode will be 'black bars'");
                } else {
                    Log.i("[Capture TextureView] Hybrid mode disabled, display mode will be 'occupy all space'");
                }
                this.mActualMode = this.mDisplayMode;
            }
            Matrix matrix2 = new Matrix();
            if (this.mActualMode == DisplayMode.BLACK_BARS) {
                int i2 = this.mCapturedVideoWidth;
                int i3 = this.mCapturedVideoHeight;
                if (measuredWidth < (measuredHeight * i2) / i3) {
                    f3 = (measuredWidth * i3) / i2;
                    f = f2;
                } else {
                    f = (measuredHeight * i2) / i3;
                }
                RectF rectF2 = new RectF(0.0f, 0.0f, f, f3);
                if (this.mAlignTopRight) {
                    Log.i("[Capture TextureView] Aligning the video in the rop-right corner");
                    rectF2.offset(f2 - f, 0.0f);
                } else {
                    rectF2.offset(rectF.centerX() - rectF2.centerX(), rectF.centerY() - rectF2.centerY());
                }
                matrix2.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.FILL);
                this.mPreviewRect = rectF2;
            } else {
                RectF rectF3 = new RectF(0.0f, 0.0f, this.mCapturedVideoWidth, this.mCapturedVideoHeight);
                rectF3.offset(rectF.centerX() - rectF3.centerX(), rectF.centerY() - rectF3.centerY());
                matrix2.setRectToRect(rectF, rectF3, Matrix.ScaleToFit.FILL);
                float fMax = Math.max(f3 / this.mCapturedVideoHeight, f2 / this.mCapturedVideoWidth);
                matrix2.postScale(fMax, fMax, rectF.centerX(), rectF.centerY());
                this.mPreviewRect = rectF;
            }
            matrix.postConcat(matrix2);
        }
        setTransform(matrix);
    }

    public void setAspectRatio(int i, int i2) {
        if (i < 0 || i2 < 0) {
            throw new IllegalArgumentException("Size cannot be negative.");
        }
        Log.i("[Capture TextureView] Changing preview texture ratio to match " + i + "x" + i2 + " captured video size");
        this.mCapturedVideoWidth = i;
        this.mCapturedVideoHeight = i2;
        rotateToMatchDisplayOrientation(this.mRotation);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        rotateToMatchDisplayOrientation(this.mRotation);
    }
}
