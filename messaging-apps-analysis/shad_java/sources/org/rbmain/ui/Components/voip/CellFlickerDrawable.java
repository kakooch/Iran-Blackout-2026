package org.rbmain.ui.Components.voip;

import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.view.View;
import androidx.core.graphics.ColorUtils;
import org.rbmain.messenger.AndroidUtilities;

/* loaded from: classes5.dex */
public class CellFlickerDrawable {
    public float animationSpeedScale;
    public boolean drawFrame;
    public boolean frameInside;
    private Shader gradientShader;
    private Shader gradientShader2;
    long lastUpdateTime;
    Matrix matrix;
    Runnable onRestartCallback;
    private Paint paint;
    private Paint paintOutline;
    int parentWidth;
    public float progress;
    public boolean repeatEnabled;
    public float repeatProgress;
    int size;

    public CellFlickerDrawable() {
        this(64, 204);
    }

    public CellFlickerDrawable(int i, int i2) {
        this.paint = new Paint(1);
        this.paintOutline = new Paint(1);
        this.matrix = new Matrix();
        this.repeatEnabled = true;
        this.drawFrame = true;
        this.frameInside = false;
        this.repeatProgress = 1.2f;
        this.animationSpeedScale = 1.0f;
        this.size = AndroidUtilities.dp(160.0f);
        this.gradientShader = new LinearGradient(0.0f, 0.0f, this.size, 0.0f, new int[]{0, ColorUtils.setAlphaComponent(-1, i), 0}, (float[]) null, Shader.TileMode.CLAMP);
        this.gradientShader2 = new LinearGradient(0.0f, 0.0f, this.size, 0.0f, new int[]{0, ColorUtils.setAlphaComponent(-1, i2), 0}, (float[]) null, Shader.TileMode.CLAMP);
        this.paint.setShader(this.gradientShader);
        this.paintOutline.setShader(this.gradientShader2);
        this.paintOutline.setStyle(Paint.Style.STROKE);
        this.paintOutline.setStrokeWidth(AndroidUtilities.dp(2.0f));
    }

    public float getProgress() {
        return this.progress;
    }

    public void setProgress(float f) {
        this.progress = f;
    }

    public void draw(Canvas canvas, RectF rectF, float f, View view) {
        update(view);
        canvas.drawRoundRect(rectF, f, f, this.paint);
        if (this.drawFrame) {
            if (this.frameInside) {
                rectF.inset(this.paintOutline.getStrokeWidth() / 2.0f, this.paintOutline.getStrokeWidth() / 2.0f);
            }
            canvas.drawRoundRect(rectF, f, f, this.paintOutline);
        }
    }

    private void update(View view) {
        if (this.repeatEnabled || this.progress < 1.0f) {
            if (view != null) {
                view.invalidate();
            }
            long jCurrentTimeMillis = System.currentTimeMillis();
            long j = this.lastUpdateTime;
            if (j != 0) {
                long j2 = jCurrentTimeMillis - j;
                if (j2 > 10) {
                    float f = this.progress + ((j2 / 1200.0f) * this.animationSpeedScale);
                    this.progress = f;
                    if (f > this.repeatProgress) {
                        this.progress = 0.0f;
                        Runnable runnable = this.onRestartCallback;
                        if (runnable != null) {
                            runnable.run();
                        }
                    }
                    this.lastUpdateTime = jCurrentTimeMillis;
                }
            } else {
                this.lastUpdateTime = jCurrentTimeMillis;
            }
        }
        int i = this.parentWidth;
        float f2 = ((i + (r0 * 2)) * this.progress) - this.size;
        this.matrix.reset();
        this.matrix.setTranslate(f2, 0.0f);
        this.gradientShader.setLocalMatrix(this.matrix);
        this.gradientShader2.setLocalMatrix(this.matrix);
    }

    public void draw(Canvas canvas, GroupCallMiniTextureView groupCallMiniTextureView) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        long j = this.lastUpdateTime;
        if (j != 0) {
            long j2 = jCurrentTimeMillis - j;
            if (j2 > 10) {
                float f = this.progress + (j2 / 500.0f);
                this.progress = f;
                if (f > 4.0f) {
                    this.progress = 0.0f;
                    Runnable runnable = this.onRestartCallback;
                    if (runnable != null) {
                        runnable.run();
                    }
                }
                this.lastUpdateTime = jCurrentTimeMillis;
            }
        } else {
            this.lastUpdateTime = jCurrentTimeMillis;
        }
        float f2 = this.progress;
        if (f2 > 1.0f) {
            return;
        }
        int i = this.parentWidth;
        this.matrix.setTranslate((((i + (r2 * 2)) * f2) - this.size) - groupCallMiniTextureView.getX(), 0.0f);
        this.gradientShader.setLocalMatrix(this.matrix);
        this.gradientShader2.setLocalMatrix(this.matrix);
        RectF rectF = AndroidUtilities.rectTmp;
        VoIPTextureView voIPTextureView = groupCallMiniTextureView.textureView;
        rectF.set(voIPTextureView.currentClipHorizontal, voIPTextureView.currentClipVertical, voIPTextureView.getMeasuredWidth() - groupCallMiniTextureView.textureView.currentClipHorizontal, r4.getMeasuredHeight() - groupCallMiniTextureView.textureView.currentClipVertical);
        canvas.drawRect(rectF, this.paint);
        if (this.drawFrame) {
            if (this.frameInside) {
                rectF.inset(this.paintOutline.getStrokeWidth() / 2.0f, this.paintOutline.getStrokeWidth() / 2.0f);
            }
            float f3 = groupCallMiniTextureView.textureView.roundRadius;
            canvas.drawRoundRect(rectF, f3, f3, this.paintOutline);
        }
    }

    public void setParentWidth(int i) {
        this.parentWidth = i;
    }
}
