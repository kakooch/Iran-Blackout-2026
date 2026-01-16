package org.rbmain.ui.Components;

import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.view.animation.DecelerateInterpolator;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.ui.ActionBar.Theme;

/* loaded from: classes5.dex */
public class MediaActionDrawable extends Drawable {
    private float animatedDownloadProgress;
    private boolean animatingTransition;
    private ColorFilter colorFilter;
    private int currentIcon;
    private MediaActionDrawableDelegate delegate;
    private float downloadProgress;
    private float downloadProgressAnimationStart;
    private float downloadProgressTime;
    private float downloadRadOffset;
    private LinearGradient gradientDrawable;
    private Matrix gradientMatrix;
    private boolean hasOverlayImage;
    private boolean isMini;
    private long lastAnimationTime;
    private Theme.MessageDrawable messageDrawable;
    private int nextIcon;
    private String percentString;
    private int percentStringWidth;
    private float savedTransitionProgress;
    private TextPaint textPaint = new TextPaint(1);
    private Paint paint = new Paint(1);
    private Paint backPaint = new Paint(1);
    private Paint paint2 = new Paint(1);
    private Paint paint3 = new Paint(1);
    private RectF rect = new RectF();
    private float scale = 1.0f;
    private DecelerateInterpolator interpolator = new DecelerateInterpolator();
    private float transitionAnimationTime = 400.0f;
    private int lastPercent = -1;
    private float overrideAlpha = 1.0f;
    private float transitionProgress = 1.0f;

    public interface MediaActionDrawableDelegate {
        void invalidate();
    }

    public static float getCircleValue(float f) {
        while (f > 360.0f) {
            f -= 360.0f;
        }
        return f;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -2;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
    }

    public MediaActionDrawable() {
        this.paint.setColor(-1);
        this.paint.setStrokeCap(Paint.Cap.ROUND);
        this.paint.setStrokeWidth(AndroidUtilities.dp(3.0f));
        this.paint.setStyle(Paint.Style.STROKE);
        this.paint3.setColor(-1);
        this.textPaint.setTypeface(AndroidUtilities.getTypeface(AndroidUtilities.TYPEFACE_ROBOTO_MEDIUM));
        this.textPaint.setTextSize(AndroidUtilities.dp(13.0f));
        this.textPaint.setColor(-1);
        this.paint2.setColor(-1);
    }

    public void setOverrideAlpha(float f) {
        this.overrideAlpha = f;
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.paint.setColorFilter(colorFilter);
        this.paint2.setColorFilter(colorFilter);
        this.paint3.setColorFilter(colorFilter);
        this.textPaint.setColorFilter(colorFilter);
    }

    public void setColor(int i) {
        int i2 = (-16777216) | i;
        this.paint.setColor(i2);
        this.paint2.setColor(i2);
        this.paint3.setColor(i2);
        this.textPaint.setColor(i2);
        this.colorFilter = new PorterDuffColorFilter(i, PorterDuff.Mode.MULTIPLY);
    }

    public void setBackColor(int i) {
        this.backPaint.setColor(i | (-16777216));
    }

    public void setMini(boolean z) {
        this.isMini = z;
        this.paint.setStrokeWidth(AndroidUtilities.dp(z ? 2.0f : 3.0f));
    }

    public void setDelegate(MediaActionDrawableDelegate mediaActionDrawableDelegate) {
        this.delegate = mediaActionDrawableDelegate;
    }

    public boolean setIcon(int i, boolean z) {
        int i2;
        int i3;
        if (this.currentIcon == i && (i3 = this.nextIcon) != i) {
            this.currentIcon = i3;
            this.transitionProgress = 1.0f;
        }
        if (z) {
            int i4 = this.currentIcon;
            if (i4 == i || (i2 = this.nextIcon) == i) {
                return false;
            }
            if ((i4 == 0 && i == 1) || (i4 == 1 && i == 0)) {
                this.transitionAnimationTime = 300.0f;
            } else if (i4 == 2 && (i == 3 || i == 14)) {
                this.transitionAnimationTime = 400.0f;
            } else if (i4 != 4 && i == 6) {
                this.transitionAnimationTime = 360.0f;
            } else if ((i4 == 4 && i == 14) || (i4 == 14 && i == 4)) {
                this.transitionAnimationTime = 160.0f;
            } else {
                this.transitionAnimationTime = 220.0f;
            }
            if (this.animatingTransition) {
                this.currentIcon = i2;
            }
            this.animatingTransition = true;
            this.nextIcon = i;
            this.savedTransitionProgress = this.transitionProgress;
            this.transitionProgress = 0.0f;
        } else {
            if (this.currentIcon == i) {
                return false;
            }
            this.animatingTransition = false;
            this.nextIcon = i;
            this.currentIcon = i;
            this.savedTransitionProgress = this.transitionProgress;
            this.transitionProgress = 1.0f;
        }
        if (i == 3 || i == 14) {
            this.downloadRadOffset = 112.0f;
            this.animatedDownloadProgress = 0.0f;
            this.downloadProgressAnimationStart = 0.0f;
            this.downloadProgressTime = 0.0f;
        }
        invalidateSelf();
        return true;
    }

    public int getCurrentIcon() {
        return this.nextIcon;
    }

    public int getPreviousIcon() {
        return this.currentIcon;
    }

    public void setProgress(float f, boolean z) {
        if (this.downloadProgress == f) {
            return;
        }
        if (!z) {
            this.animatedDownloadProgress = f;
            this.downloadProgressAnimationStart = f;
        } else {
            if (this.animatedDownloadProgress > f) {
                this.animatedDownloadProgress = f;
            }
            this.downloadProgressAnimationStart = this.animatedDownloadProgress;
        }
        this.downloadProgress = f;
        this.downloadProgressTime = 0.0f;
        invalidateSelf();
    }

    public float getProgress() {
        return this.downloadProgress;
    }

    public float getTransitionProgress() {
        if (this.animatingTransition) {
            return this.transitionProgress;
        }
        return 1.0f;
    }

    public void setBackgroundDrawable(Theme.MessageDrawable messageDrawable) {
        this.messageDrawable = messageDrawable;
    }

    public void setHasOverlayImage(boolean z) {
        this.hasOverlayImage = z;
    }

    @Override // android.graphics.drawable.Drawable
    public void setBounds(int i, int i2, int i3, int i4) {
        super.setBounds(i, i2, i3, i4);
        float intrinsicWidth = (i3 - i) / getIntrinsicWidth();
        this.scale = intrinsicWidth;
        if (intrinsicWidth < 0.7f) {
            this.paint.setStrokeWidth(AndroidUtilities.dp(2.0f));
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        super.invalidateSelf();
        MediaActionDrawableDelegate mediaActionDrawableDelegate = this.delegate;
        if (mediaActionDrawableDelegate != null) {
            mediaActionDrawableDelegate.invalidate();
        }
    }

    private void applyShaderMatrix(boolean z) {
        Theme.MessageDrawable messageDrawable = this.messageDrawable;
        if (messageDrawable == null || !messageDrawable.hasGradient() || this.hasOverlayImage) {
            return;
        }
        android.graphics.Rect bounds = getBounds();
        Shader gradientShader = this.messageDrawable.getGradientShader();
        Matrix matrix = this.messageDrawable.getMatrix();
        matrix.reset();
        this.messageDrawable.applyMatrixScale();
        if (z) {
            matrix.postTranslate(-bounds.centerX(), (-this.messageDrawable.getTopY()) + bounds.top);
        } else {
            matrix.postTranslate(0.0f, -this.messageDrawable.getTopY());
        }
        gradientShader.setLocalMatrix(matrix);
    }

    /* JADX WARN: Removed duplicated region for block: B:121:0x0393  */
    /* JADX WARN: Removed duplicated region for block: B:188:0x050f  */
    /* JADX WARN: Removed duplicated region for block: B:191:0x051a  */
    /* JADX WARN: Removed duplicated region for block: B:193:0x0524  */
    /* JADX WARN: Removed duplicated region for block: B:200:0x05a2  */
    /* JADX WARN: Removed duplicated region for block: B:203:0x05aa  */
    /* JADX WARN: Removed duplicated region for block: B:206:0x05b3  */
    /* JADX WARN: Removed duplicated region for block: B:209:0x05bb  */
    /* JADX WARN: Removed duplicated region for block: B:216:0x05c8 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:219:0x05d8  */
    /* JADX WARN: Removed duplicated region for block: B:220:0x05db  */
    /* JADX WARN: Removed duplicated region for block: B:223:0x05fc  */
    /* JADX WARN: Removed duplicated region for block: B:227:0x0603  */
    /* JADX WARN: Removed duplicated region for block: B:252:0x067f  */
    /* JADX WARN: Removed duplicated region for block: B:253:0x0682  */
    /* JADX WARN: Removed duplicated region for block: B:258:0x068e  */
    /* JADX WARN: Removed duplicated region for block: B:259:0x0694  */
    /* JADX WARN: Removed duplicated region for block: B:266:0x06a3  */
    /* JADX WARN: Removed duplicated region for block: B:267:0x06a6  */
    /* JADX WARN: Removed duplicated region for block: B:272:0x06b2  */
    /* JADX WARN: Removed duplicated region for block: B:273:0x06b5  */
    /* JADX WARN: Removed duplicated region for block: B:282:0x06d7  */
    /* JADX WARN: Removed duplicated region for block: B:284:0x06e2  */
    /* JADX WARN: Removed duplicated region for block: B:285:0x06e5  */
    /* JADX WARN: Removed duplicated region for block: B:288:0x0701  */
    /* JADX WARN: Removed duplicated region for block: B:289:0x070e  */
    /* JADX WARN: Removed duplicated region for block: B:292:0x075b  */
    /* JADX WARN: Removed duplicated region for block: B:297:0x076a  */
    /* JADX WARN: Removed duplicated region for block: B:299:0x0774  */
    /* JADX WARN: Removed duplicated region for block: B:300:0x0777  */
    /* JADX WARN: Removed duplicated region for block: B:306:0x0789  */
    /* JADX WARN: Removed duplicated region for block: B:307:0x078c  */
    /* JADX WARN: Removed duplicated region for block: B:310:0x07a0  */
    /* JADX WARN: Removed duplicated region for block: B:313:0x07d7  */
    /* JADX WARN: Removed duplicated region for block: B:318:0x07e4  */
    /* JADX WARN: Removed duplicated region for block: B:320:0x07ee  */
    /* JADX WARN: Removed duplicated region for block: B:321:0x07f1  */
    /* JADX WARN: Removed duplicated region for block: B:326:0x0817  */
    /* JADX WARN: Removed duplicated region for block: B:331:0x082c  */
    /* JADX WARN: Removed duplicated region for block: B:334:0x085d  */
    /* JADX WARN: Removed duplicated region for block: B:343:0x0872  */
    /* JADX WARN: Removed duplicated region for block: B:358:0x0896 A[PHI: r3
      0x0896: PHI (r3v132 int) = (r3v130 int), (r3v160 int) binds: [B:361:0x089c, B:357:0x0894] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:359:0x0899 A[PHI: r3
      0x0899: PHI (r3v131 int) = (r3v130 int), (r3v160 int) binds: [B:361:0x089c, B:357:0x0894] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:365:0x08a3 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:368:0x08a8 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:382:0x0901  */
    /* JADX WARN: Removed duplicated region for block: B:383:0x0904  */
    /* JADX WARN: Removed duplicated region for block: B:385:0x0907  */
    /* JADX WARN: Removed duplicated region for block: B:395:0x0943  */
    /* JADX WARN: Removed duplicated region for block: B:400:0x094d  */
    /* JADX WARN: Removed duplicated region for block: B:401:0x095a  */
    /* JADX WARN: Removed duplicated region for block: B:419:0x09ab  */
    /* JADX WARN: Removed duplicated region for block: B:421:0x09b3  */
    /* JADX WARN: Removed duplicated region for block: B:429:0x09dc  */
    /* JADX WARN: Removed duplicated region for block: B:436:0x0a0c  */
    /* JADX WARN: Removed duplicated region for block: B:437:0x0a42  */
    /* JADX WARN: Removed duplicated region for block: B:440:0x0a4b  */
    /* JADX WARN: Removed duplicated region for block: B:445:0x0a85  */
    /* JADX WARN: Removed duplicated region for block: B:446:0x0a88  */
    /* JADX WARN: Removed duplicated region for block: B:449:0x0aa5  */
    /* JADX WARN: Removed duplicated region for block: B:459:0x0af7  */
    /* JADX WARN: Removed duplicated region for block: B:460:0x0afa  */
    /* JADX WARN: Removed duplicated region for block: B:463:0x0b21  */
    /* JADX WARN: Removed duplicated region for block: B:466:0x0b2d  */
    /* JADX WARN: Removed duplicated region for block: B:469:0x0b39  */
    /* JADX WARN: Removed duplicated region for block: B:490:0x0bcf  */
    /* JADX WARN: Removed duplicated region for block: B:503:0x0beb  */
    /* JADX WARN: Removed duplicated region for block: B:505:0x0c04  */
    /* JADX WARN: Removed duplicated region for block: B:514:0x0c37  */
    /* JADX WARN: Removed duplicated region for block: B:522:0x0c5b  */
    /* JADX WARN: Removed duplicated region for block: B:524:? A[RETURN, SYNTHETIC] */
    @Override // android.graphics.drawable.Drawable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void draw(android.graphics.Canvas r34) {
        /*
            Method dump skipped, instructions count: 3167
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.rbmain.ui.Components.MediaActionDrawable.draw(android.graphics.Canvas):void");
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return AndroidUtilities.dp(48.0f);
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return AndroidUtilities.dp(48.0f);
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumWidth() {
        return AndroidUtilities.dp(48.0f);
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumHeight() {
        return AndroidUtilities.dp(48.0f);
    }
}
