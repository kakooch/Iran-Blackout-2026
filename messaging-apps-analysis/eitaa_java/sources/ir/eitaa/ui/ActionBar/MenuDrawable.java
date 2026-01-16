package ir.eitaa.ui.ActionBar;

import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.view.animation.DecelerateInterpolator;
import ir.eitaa.messenger.AndroidUtilities;

/* loaded from: classes3.dex */
public class MenuDrawable extends Drawable {
    public static int TYPE_DEFAULT = 0;
    public static int TYPE_UDPATE_AVAILABLE = 1;
    public static int TYPE_UDPATE_DOWNLOADING = 2;
    private float animatedDownloadProgress;
    private int backColor;
    private Paint backPaint;
    private int currentAnimationTime;
    private float currentRotation;
    private float downloadProgress;
    private float downloadProgressAnimationStart;
    private float downloadProgressTime;
    private float downloadRadOffset;
    private float finalRotation;
    private int iconColor;
    private DecelerateInterpolator interpolator;
    private long lastFrameTime;
    private boolean miniIcon;
    private Paint paint;
    private int previousType;
    private RectF rect;
    private boolean reverseAngle;
    private boolean rotateToBack;
    private int type;
    private float typeAnimationProgress;

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -2;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int alpha) {
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter cf) {
    }

    public MenuDrawable() {
        this(TYPE_DEFAULT);
    }

    public MenuDrawable(int type) {
        this.paint = new Paint(1);
        this.backPaint = new Paint(1);
        this.rotateToBack = true;
        this.interpolator = new DecelerateInterpolator();
        this.rect = new RectF();
        this.paint.setStrokeWidth(AndroidUtilities.dp(2.0f));
        this.backPaint.setStrokeWidth(AndroidUtilities.density * 1.66f);
        this.backPaint.setStrokeCap(Paint.Cap.ROUND);
        this.backPaint.setStyle(Paint.Style.STROKE);
        this.previousType = TYPE_DEFAULT;
        this.type = type;
        this.typeAnimationProgress = 1.0f;
    }

    public void setRotateToBack(boolean value) {
        this.rotateToBack = value;
    }

    public void setRotation(float rotation, boolean animated) {
        this.lastFrameTime = 0L;
        float f = this.currentRotation;
        if (f == 1.0f) {
            this.reverseAngle = true;
        } else if (f == 0.0f) {
            this.reverseAngle = false;
        }
        this.lastFrameTime = 0L;
        if (animated) {
            if (f < rotation) {
                this.currentAnimationTime = (int) (f * 200.0f);
            } else {
                this.currentAnimationTime = (int) ((1.0f - f) * 200.0f);
            }
            this.lastFrameTime = SystemClock.elapsedRealtime();
            this.finalRotation = rotation;
        } else {
            this.currentRotation = rotation;
            this.finalRotation = rotation;
        }
        invalidateSelf();
    }

    public void setType(int value, boolean animated) {
        int i = this.type;
        if (i == value) {
            return;
        }
        this.previousType = i;
        this.type = value;
        if (animated) {
            this.typeAnimationProgress = 0.0f;
        } else {
            this.typeAnimationProgress = 1.0f;
        }
        invalidateSelf();
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x0101  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0194  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x02e5  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0304  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0326  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x032c  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0358  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0372  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0376  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0388  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0395  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x03c0  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x03d0  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x03dc  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0436  */
    @Override // android.graphics.drawable.Drawable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void draw(android.graphics.Canvas r26) {
        /*
            Method dump skipped, instructions count: 1116
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.ActionBar.MenuDrawable.draw(android.graphics.Canvas):void");
    }

    public void setUpdateDownloadProgress(float value, boolean animated) {
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

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return AndroidUtilities.dp(24.0f);
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return AndroidUtilities.dp(24.0f);
    }

    public void setIconColor(int iconColor) {
        this.iconColor = iconColor;
    }

    public void setBackColor(int backColor) {
        this.backColor = backColor;
    }

    public void setRoundCap() {
        this.paint.setStrokeCap(Paint.Cap.ROUND);
    }

    public void setMiniIcon(boolean miniIcon) {
        this.miniIcon = miniIcon;
    }
}
