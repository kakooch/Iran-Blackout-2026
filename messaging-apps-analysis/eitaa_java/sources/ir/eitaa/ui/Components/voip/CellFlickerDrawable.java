package ir.eitaa.ui.Components.voip;

import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import androidx.core.graphics.ColorUtils;
import ir.eitaa.messenger.AndroidUtilities;

/* loaded from: classes3.dex */
public class CellFlickerDrawable {
    public boolean drawFrame;
    private final Shader gradientShader;
    private final Shader gradientShader2;
    long lastUpdateTime;
    Matrix matrix;
    private final Paint paint;
    private final Paint paintOutline;
    int parentWidth;
    float progress;
    public float repeatProgress;
    int size;

    public CellFlickerDrawable() {
        this(64, 204);
    }

    public CellFlickerDrawable(int a1, int a2) {
        Paint paint = new Paint(1);
        this.paint = paint;
        Paint paint2 = new Paint(1);
        this.paintOutline = paint2;
        this.matrix = new Matrix();
        this.drawFrame = true;
        this.repeatProgress = 1.2f;
        this.size = AndroidUtilities.dp(160.0f);
        LinearGradient linearGradient = new LinearGradient(0.0f, 0.0f, this.size, 0.0f, new int[]{0, ColorUtils.setAlphaComponent(-1, a1), 0}, (float[]) null, Shader.TileMode.CLAMP);
        this.gradientShader = linearGradient;
        LinearGradient linearGradient2 = new LinearGradient(0.0f, 0.0f, this.size, 0.0f, new int[]{0, ColorUtils.setAlphaComponent(-1, a2), 0}, (float[]) null, Shader.TileMode.CLAMP);
        this.gradientShader2 = linearGradient2;
        paint.setShader(linearGradient);
        paint2.setShader(linearGradient2);
        paint2.setStyle(Paint.Style.STROKE);
        paint2.setStrokeWidth(AndroidUtilities.dp(2.0f));
    }

    public void draw(Canvas canvas, RectF rectF, float rad) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        long j = this.lastUpdateTime;
        if (j != 0) {
            long j2 = jCurrentTimeMillis - j;
            if (j2 > 10) {
                float f = this.progress + (j2 / 1200.0f);
                this.progress = f;
                if (f > this.repeatProgress) {
                    this.progress = 0.0f;
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
        this.matrix.setTranslate(((i + (r2 * 2)) * f2) - this.size, 0.0f);
        this.gradientShader.setLocalMatrix(this.matrix);
        this.gradientShader2.setLocalMatrix(this.matrix);
        canvas.drawRoundRect(rectF, rad, rad, this.paint);
        if (this.drawFrame) {
            canvas.drawRoundRect(rectF, rad, rad, this.paintOutline);
        }
    }

    public void draw(Canvas canvas, GroupCallMiniTextureView view) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        long j = this.lastUpdateTime;
        if (j != 0) {
            long j2 = jCurrentTimeMillis - j;
            if (j2 > 10) {
                float f = this.progress + (j2 / 500.0f);
                this.progress = f;
                if (f > 4.0f) {
                    this.progress = 0.0f;
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
        this.matrix.setTranslate((((i + (r2 * 2)) * f2) - this.size) - view.getX(), 0.0f);
        this.gradientShader.setLocalMatrix(this.matrix);
        this.gradientShader2.setLocalMatrix(this.matrix);
        RectF rectF = AndroidUtilities.rectTmp;
        VoIPTextureView voIPTextureView = view.textureView;
        rectF.set(voIPTextureView.currentClipHorizontal, voIPTextureView.currentClipVertical, voIPTextureView.getMeasuredWidth() - view.textureView.currentClipHorizontal, r4.getMeasuredHeight() - view.textureView.currentClipVertical);
        canvas.drawRect(rectF, this.paint);
        if (this.drawFrame) {
            float f3 = view.textureView.roundRadius;
            canvas.drawRoundRect(rectF, f3, f3, this.paintOutline);
        }
    }

    public void setParentWidth(int parentWidth) {
        this.parentWidth = parentWidth;
    }
}
