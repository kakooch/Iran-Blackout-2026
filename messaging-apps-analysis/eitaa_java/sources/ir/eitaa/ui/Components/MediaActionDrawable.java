package ir.eitaa.ui.Components;

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
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.ui.ActionBar.Theme;

/* loaded from: classes3.dex */
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

    public static float getCircleValue(float value) {
        while (value > 360.0f) {
            value -= 360.0f;
        }
        return value;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -2;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int alpha) {
    }

    public MediaActionDrawable() {
        this.paint.setColor(-1);
        this.paint.setStrokeCap(Paint.Cap.ROUND);
        this.paint.setStrokeWidth(AndroidUtilities.dp(3.0f));
        this.paint.setStyle(Paint.Style.STROKE);
        this.paint3.setColor(-1);
        this.textPaint.setTypeface(AndroidUtilities.getFontFamily(true));
        this.textPaint.setTextSize(AndroidUtilities.dp(13.0f));
        this.textPaint.setColor(-1);
        this.paint2.setColor(-1);
    }

    public void setOverrideAlpha(float alpha) {
        this.overrideAlpha = alpha;
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.paint.setColorFilter(colorFilter);
        this.paint2.setColorFilter(colorFilter);
        this.paint3.setColorFilter(colorFilter);
        this.textPaint.setColorFilter(colorFilter);
    }

    public void setColor(int value) {
        int i = (-16777216) | value;
        this.paint.setColor(i);
        this.paint2.setColor(i);
        this.paint3.setColor(i);
        this.textPaint.setColor(i);
        this.colorFilter = new PorterDuffColorFilter(value, PorterDuff.Mode.MULTIPLY);
    }

    public void setBackColor(int value) {
        this.backPaint.setColor(value | (-16777216));
    }

    public void setMini(boolean value) {
        this.isMini = value;
        this.paint.setStrokeWidth(AndroidUtilities.dp(value ? 2.0f : 3.0f));
    }

    public void setDelegate(MediaActionDrawableDelegate mediaActionDrawableDelegate) {
        this.delegate = mediaActionDrawableDelegate;
    }

    public boolean setIcon(int icon, boolean animated) {
        int i;
        int i2;
        if (this.currentIcon == icon && (i2 = this.nextIcon) != icon) {
            this.currentIcon = i2;
            this.transitionProgress = 1.0f;
        }
        if (animated) {
            int i3 = this.currentIcon;
            if (i3 == icon || (i = this.nextIcon) == icon) {
                return false;
            }
            if ((i3 == 0 && icon == 1) || (i3 == 1 && icon == 0)) {
                this.transitionAnimationTime = 300.0f;
            } else if (i3 == 2 && (icon == 3 || icon == 14)) {
                this.transitionAnimationTime = 400.0f;
            } else if (i3 != 4 && icon == 6) {
                this.transitionAnimationTime = 360.0f;
            } else if ((i3 == 4 && icon == 14) || (i3 == 14 && icon == 4)) {
                this.transitionAnimationTime = 160.0f;
            } else {
                this.transitionAnimationTime = 220.0f;
            }
            if (this.animatingTransition) {
                this.currentIcon = i;
            }
            this.animatingTransition = true;
            this.nextIcon = icon;
            this.savedTransitionProgress = this.transitionProgress;
            this.transitionProgress = 0.0f;
        } else {
            if (this.currentIcon == icon) {
                return false;
            }
            this.animatingTransition = false;
            this.nextIcon = icon;
            this.currentIcon = icon;
            this.savedTransitionProgress = this.transitionProgress;
            this.transitionProgress = 1.0f;
        }
        if (icon == 3 || icon == 14) {
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

    public void setProgress(float value, boolean animated) {
        if (!animated) {
            this.animatedDownloadProgress = value;
            this.downloadProgressAnimationStart = value;
        } else {
            if (this.animatedDownloadProgress > value) {
                this.animatedDownloadProgress = value;
            }
            this.downloadProgressAnimationStart = this.animatedDownloadProgress;
        }
        this.downloadProgress = value;
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

    public void setBackgroundDrawable(Theme.MessageDrawable drawable) {
        this.messageDrawable = drawable;
    }

    public void setBackgroundGradientDrawable(LinearGradient drawable) {
        this.gradientDrawable = drawable;
        this.gradientMatrix = new Matrix();
    }

    public void setHasOverlayImage(boolean value) {
        this.hasOverlayImage = value;
    }

    @Override // android.graphics.drawable.Drawable
    public void setBounds(int left, int top, int right, int bottom) {
        super.setBounds(left, top, right, bottom);
        float intrinsicWidth = (right - left) / getIntrinsicWidth();
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

    private void applyShaderMatrix(boolean path) {
        Theme.MessageDrawable messageDrawable = this.messageDrawable;
        if (messageDrawable == null || !messageDrawable.hasGradient() || this.hasOverlayImage) {
            return;
        }
        android.graphics.Rect bounds = getBounds();
        Shader gradientShader = this.messageDrawable.getGradientShader();
        Matrix matrix = this.messageDrawable.getMatrix();
        matrix.reset();
        this.messageDrawable.applyMatrixScale();
        if (path) {
            matrix.postTranslate(-bounds.centerX(), (-this.messageDrawable.getTopY()) + bounds.top);
        } else {
            matrix.postTranslate(0.0f, -this.messageDrawable.getTopY());
        }
        gradientShader.setLocalMatrix(matrix);
    }

    /* JADX WARN: Removed duplicated region for block: B:121:0x0393  */
    /* JADX WARN: Removed duplicated region for block: B:188:0x0518  */
    /* JADX WARN: Removed duplicated region for block: B:191:0x0523  */
    /* JADX WARN: Removed duplicated region for block: B:193:0x052d  */
    /* JADX WARN: Removed duplicated region for block: B:200:0x05ab  */
    /* JADX WARN: Removed duplicated region for block: B:203:0x05b3  */
    /* JADX WARN: Removed duplicated region for block: B:206:0x05bb  */
    /* JADX WARN: Removed duplicated region for block: B:213:0x05c8 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:216:0x05d8  */
    /* JADX WARN: Removed duplicated region for block: B:217:0x05db  */
    /* JADX WARN: Removed duplicated region for block: B:220:0x05fc  */
    /* JADX WARN: Removed duplicated region for block: B:226:0x0606  */
    /* JADX WARN: Removed duplicated region for block: B:230:0x063b  */
    /* JADX WARN: Removed duplicated region for block: B:249:0x0683  */
    /* JADX WARN: Removed duplicated region for block: B:250:0x0686  */
    /* JADX WARN: Removed duplicated region for block: B:255:0x0692  */
    /* JADX WARN: Removed duplicated region for block: B:256:0x0698  */
    /* JADX WARN: Removed duplicated region for block: B:263:0x06a7  */
    /* JADX WARN: Removed duplicated region for block: B:264:0x06aa  */
    /* JADX WARN: Removed duplicated region for block: B:273:0x06cc  */
    /* JADX WARN: Removed duplicated region for block: B:275:0x06d7  */
    /* JADX WARN: Removed duplicated region for block: B:276:0x06da  */
    /* JADX WARN: Removed duplicated region for block: B:279:0x06f6  */
    /* JADX WARN: Removed duplicated region for block: B:280:0x0703  */
    /* JADX WARN: Removed duplicated region for block: B:283:0x0750  */
    /* JADX WARN: Removed duplicated region for block: B:288:0x075f  */
    /* JADX WARN: Removed duplicated region for block: B:290:0x0769  */
    /* JADX WARN: Removed duplicated region for block: B:291:0x076c  */
    /* JADX WARN: Removed duplicated region for block: B:297:0x077e  */
    /* JADX WARN: Removed duplicated region for block: B:298:0x0781  */
    /* JADX WARN: Removed duplicated region for block: B:301:0x0795  */
    /* JADX WARN: Removed duplicated region for block: B:304:0x07cc  */
    /* JADX WARN: Removed duplicated region for block: B:309:0x07d9  */
    /* JADX WARN: Removed duplicated region for block: B:311:0x07e3  */
    /* JADX WARN: Removed duplicated region for block: B:312:0x07e6  */
    /* JADX WARN: Removed duplicated region for block: B:317:0x080c  */
    /* JADX WARN: Removed duplicated region for block: B:322:0x0821  */
    /* JADX WARN: Removed duplicated region for block: B:325:0x0852  */
    /* JADX WARN: Removed duplicated region for block: B:334:0x0867  */
    /* JADX WARN: Removed duplicated region for block: B:349:0x088b A[PHI: r3
      0x088b: PHI (r3v128 int) = (r3v126 int), (r3v156 int) binds: [B:352:0x0891, B:348:0x0889] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:350:0x088e A[PHI: r3
      0x088e: PHI (r3v127 int) = (r3v126 int), (r3v156 int) binds: [B:352:0x0891, B:348:0x0889] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:356:0x0898 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:359:0x089d A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:373:0x08f6  */
    /* JADX WARN: Removed duplicated region for block: B:374:0x08f9  */
    /* JADX WARN: Removed duplicated region for block: B:376:0x08fc  */
    /* JADX WARN: Removed duplicated region for block: B:386:0x0938  */
    /* JADX WARN: Removed duplicated region for block: B:391:0x0942  */
    /* JADX WARN: Removed duplicated region for block: B:392:0x094f  */
    /* JADX WARN: Removed duplicated region for block: B:410:0x09a0  */
    /* JADX WARN: Removed duplicated region for block: B:412:0x09a8  */
    /* JADX WARN: Removed duplicated region for block: B:420:0x09d1  */
    /* JADX WARN: Removed duplicated region for block: B:427:0x0a01  */
    /* JADX WARN: Removed duplicated region for block: B:428:0x0a37  */
    /* JADX WARN: Removed duplicated region for block: B:431:0x0a40  */
    /* JADX WARN: Removed duplicated region for block: B:436:0x0a7a  */
    /* JADX WARN: Removed duplicated region for block: B:437:0x0a7d  */
    /* JADX WARN: Removed duplicated region for block: B:440:0x0a9a  */
    /* JADX WARN: Removed duplicated region for block: B:450:0x0afa  */
    /* JADX WARN: Removed duplicated region for block: B:451:0x0afd  */
    /* JADX WARN: Removed duplicated region for block: B:454:0x0b21  */
    /* JADX WARN: Removed duplicated region for block: B:457:0x0b2d  */
    /* JADX WARN: Removed duplicated region for block: B:460:0x0b39  */
    /* JADX WARN: Removed duplicated region for block: B:481:0x0bd6  */
    /* JADX WARN: Removed duplicated region for block: B:494:0x0bf2  */
    /* JADX WARN: Removed duplicated region for block: B:496:0x0c0b  */
    /* JADX WARN: Removed duplicated region for block: B:505:0x0c3e  */
    /* JADX WARN: Removed duplicated region for block: B:513:0x0c62  */
    /* JADX WARN: Removed duplicated region for block: B:515:? A[RETURN, SYNTHETIC] */
    @Override // android.graphics.drawable.Drawable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void draw(android.graphics.Canvas r34) {
        /*
            Method dump skipped, instructions count: 3174
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.Components.MediaActionDrawable.draw(android.graphics.Canvas):void");
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
