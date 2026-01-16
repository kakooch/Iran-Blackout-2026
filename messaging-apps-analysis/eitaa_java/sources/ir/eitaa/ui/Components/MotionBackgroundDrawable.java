package ir.eitaa.ui.Components;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.BlendMode;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.ComposeShader;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.View;
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.messenger.NotificationCenter;
import ir.eitaa.messenger.Utilities;
import ir.eitaa.tgnet.ConnectionsManager;
import java.lang.ref.WeakReference;

/* loaded from: classes3.dex */
public class MotionBackgroundDrawable extends Drawable {
    private static final boolean useLegacyBitmap;
    private static final boolean useSoftLight;
    private int alpha;
    private BitmapShader bitmapShader;
    private int[] colors;
    private Bitmap currentBitmap;
    private boolean fastAnimation;
    private Canvas gradientCanvas;
    private Bitmap gradientFromBitmap;
    private Canvas gradientFromCanvas;
    private BitmapShader gradientShader;
    private Bitmap[] gradientToBitmap;
    private int intensity;
    private final CubicBezierInterpolator interpolator;
    private boolean invalidateLegacy;
    private boolean isPreview;
    private long lastUpdateTime;
    private Bitmap legacyBitmap;
    private Bitmap legacyBitmap2;
    private Canvas legacyCanvas;
    private Canvas legacyCanvas2;
    private Matrix matrix;
    private Paint paint;
    private Paint paint2;
    private Paint paint3;
    private WeakReference<View> parentView;
    private float patternAlpha;
    private Bitmap patternBitmap;
    private android.graphics.Rect patternBounds;
    private ColorFilter patternColorFilter;
    private int phase;
    private float posAnimationProgress;
    private boolean postInvalidateParent;
    private RectF rect;
    private boolean rotatingPreview;
    private boolean rotationBack;
    private int roundRadius;
    private int translationY;
    private Runnable updateAnimationRunnable;

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -2;
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
    }

    static {
        int i = Build.VERSION.SDK_INT;
        useLegacyBitmap = i < 28;
        useSoftLight = i >= 29;
    }

    public MotionBackgroundDrawable() {
        this.colors = new int[]{-12423849, -531317, -7888252, -133430};
        this.interpolator = new CubicBezierInterpolator(0.33d, 0.0d, 0.0d, 1.0d);
        this.posAnimationProgress = 1.0f;
        this.rect = new RectF();
        this.gradientToBitmap = new Bitmap[3];
        this.paint = new Paint(2);
        this.paint2 = new Paint(2);
        this.paint3 = new Paint();
        this.intensity = 100;
        this.updateAnimationRunnable = new Runnable() { // from class: ir.eitaa.ui.Components.-$$Lambda$MotionBackgroundDrawable$YbP_JgE23s35_G_IqeF_uKBrxiA
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.updateAnimation();
            }
        };
        this.patternBounds = new android.graphics.Rect();
        this.patternAlpha = 1.0f;
        this.alpha = 255;
        init();
    }

    public MotionBackgroundDrawable(int c1, int c2, int c3, int c4, boolean preview) {
        this.colors = new int[]{-12423849, -531317, -7888252, -133430};
        this.interpolator = new CubicBezierInterpolator(0.33d, 0.0d, 0.0d, 1.0d);
        this.posAnimationProgress = 1.0f;
        this.rect = new RectF();
        this.gradientToBitmap = new Bitmap[3];
        this.paint = new Paint(2);
        this.paint2 = new Paint(2);
        this.paint3 = new Paint();
        this.intensity = 100;
        this.updateAnimationRunnable = new Runnable() { // from class: ir.eitaa.ui.Components.-$$Lambda$MotionBackgroundDrawable$YbP_JgE23s35_G_IqeF_uKBrxiA
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.updateAnimation();
            }
        };
        this.patternBounds = new android.graphics.Rect();
        this.patternAlpha = 1.0f;
        this.alpha = 255;
        int[] iArr = this.colors;
        iArr[0] = c1;
        iArr[1] = c2;
        iArr[2] = c3;
        iArr[3] = c4;
        this.isPreview = preview;
        init();
    }

    @SuppressLint({"NewApi"})
    private void init() {
        this.currentBitmap = Bitmap.createBitmap(60, 80, Bitmap.Config.ARGB_8888);
        for (int i = 0; i < 3; i++) {
            this.gradientToBitmap[i] = Bitmap.createBitmap(60, 80, Bitmap.Config.ARGB_8888);
        }
        this.gradientCanvas = new Canvas(this.currentBitmap);
        this.gradientFromBitmap = Bitmap.createBitmap(60, 80, Bitmap.Config.ARGB_8888);
        this.gradientFromCanvas = new Canvas(this.gradientFromBitmap);
        Utilities.generateGradient(this.currentBitmap, true, this.phase, this.interpolator.getInterpolation(this.posAnimationProgress), this.currentBitmap.getWidth(), this.currentBitmap.getHeight(), this.currentBitmap.getRowBytes(), this.colors);
        if (useSoftLight) {
            this.paint2.setBlendMode(BlendMode.SOFT_LIGHT);
        }
    }

    public void setRoundRadius(int rad) {
        this.roundRadius = rad;
        this.matrix = new Matrix();
        Bitmap bitmap = this.currentBitmap;
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        BitmapShader bitmapShader = new BitmapShader(bitmap, tileMode, tileMode);
        this.bitmapShader = bitmapShader;
        this.paint.setShader(bitmapShader);
        invalidateParent();
    }

    public BitmapShader getBitmapShader() {
        return this.bitmapShader;
    }

    public Bitmap getBitmap() {
        return this.currentBitmap;
    }

    public int getIntensity() {
        return this.intensity;
    }

    public static boolean isDark(int color1, int color2, int color3, int color4) {
        int averageColor = AndroidUtilities.getAverageColor(color1, color2);
        if (color3 != 0) {
            averageColor = AndroidUtilities.getAverageColor(averageColor, color3);
        }
        if (color4 != 0) {
            averageColor = AndroidUtilities.getAverageColor(averageColor, color4);
        }
        return AndroidUtilities.RGBtoHSB(Color.red(averageColor), Color.green(averageColor), Color.blue(averageColor))[2] < 0.3f;
    }

    @Override // android.graphics.drawable.Drawable
    public void setBounds(android.graphics.Rect bounds) {
        super.setBounds(bounds);
        this.patternBounds.set(bounds);
    }

    public static int getPatternColor(int color1, int color2, int color3, int color4) {
        if (isDark(color1, color2, color3, color4)) {
            if (useSoftLight) {
                return -1;
            }
            return ConnectionsManager.DEFAULT_DATACENTER_ID;
        }
        if (useSoftLight) {
            return -16777216;
        }
        int averageColor = AndroidUtilities.getAverageColor(color3, AndroidUtilities.getAverageColor(color1, color2));
        if (color4 != 0) {
            averageColor = AndroidUtilities.getAverageColor(color4, averageColor);
        }
        return (AndroidUtilities.getPatternColor(averageColor, true) & 16777215) | 1677721600;
    }

    public int getPatternColor() {
        int[] iArr = this.colors;
        return getPatternColor(iArr[0], iArr[1], iArr[2], iArr[3]);
    }

    public int getPhase() {
        return this.phase;
    }

    public void setPostInvalidateParent(boolean value) {
        this.postInvalidateParent = value;
    }

    public void rotatePreview(boolean back) {
        if (this.posAnimationProgress < 1.0f) {
            return;
        }
        this.rotatingPreview = true;
        this.posAnimationProgress = 0.0f;
        this.rotationBack = back;
        invalidateParent();
    }

    public void setPhase(int value) {
        this.phase = value;
        if (value < 0) {
            this.phase = 0;
        } else if (value > 7) {
            this.phase = 7;
        }
        Utilities.generateGradient(this.currentBitmap, true, this.phase, this.interpolator.getInterpolation(this.posAnimationProgress), this.currentBitmap.getWidth(), this.currentBitmap.getHeight(), this.currentBitmap.getRowBytes(), this.colors);
    }

    public void switchToNextPosition() {
        switchToNextPosition(false);
    }

    public void switchToNextPosition(boolean fast) {
        if (this.posAnimationProgress < 1.0f) {
            return;
        }
        this.rotatingPreview = false;
        this.rotationBack = false;
        this.fastAnimation = fast;
        this.posAnimationProgress = 0.0f;
        int i = this.phase - 1;
        this.phase = i;
        if (i < 0) {
            this.phase = 7;
        }
        invalidateParent();
        this.gradientFromCanvas.drawBitmap(this.currentBitmap, 0.0f, 0.0f, (Paint) null);
        generateNextGradient();
    }

    private void generateNextGradient() {
        int i = 0;
        if (useLegacyBitmap && this.intensity < 0) {
            if (this.legacyBitmap != null) {
                Bitmap bitmap = this.legacyBitmap2;
                if (bitmap == null || bitmap.getHeight() != this.legacyBitmap.getHeight() || this.legacyBitmap2.getWidth() != this.legacyBitmap.getWidth()) {
                    Bitmap bitmap2 = this.legacyBitmap2;
                    if (bitmap2 != null) {
                        bitmap2.recycle();
                    }
                    this.legacyBitmap2 = Bitmap.createBitmap(this.legacyBitmap.getWidth(), this.legacyBitmap.getHeight(), Bitmap.Config.ARGB_8888);
                    this.legacyCanvas2 = new Canvas(this.legacyBitmap2);
                } else {
                    this.legacyBitmap2.eraseColor(0);
                }
                this.legacyCanvas2.drawBitmap(this.legacyBitmap, 0.0f, 0.0f, (Paint) null);
            }
            Bitmap bitmap3 = this.currentBitmap;
            Utilities.generateGradient(bitmap3, true, this.phase, 1.0f, bitmap3.getWidth(), this.currentBitmap.getHeight(), this.currentBitmap.getRowBytes(), this.colors);
            this.invalidateLegacy = true;
        }
        while (i < 3) {
            int i2 = i + 1;
            Utilities.generateGradient(this.gradientToBitmap[i], true, this.phase, i2 / 3.0f, this.currentBitmap.getWidth(), this.currentBitmap.getHeight(), this.currentBitmap.getRowBytes(), this.colors);
            i = i2;
        }
    }

    public void switchToPrevPosition(boolean fast) {
        if (this.posAnimationProgress < 1.0f) {
            return;
        }
        this.rotatingPreview = false;
        this.fastAnimation = fast;
        this.rotationBack = true;
        this.posAnimationProgress = 0.0f;
        invalidateParent();
        Utilities.generateGradient(this.gradientFromBitmap, true, this.phase, 0.0f, this.currentBitmap.getWidth(), this.currentBitmap.getHeight(), this.currentBitmap.getRowBytes(), this.colors);
        generateNextGradient();
    }

    public int[] getColors() {
        return this.colors;
    }

    public void setParentView(View view) {
        this.parentView = new WeakReference<>(view);
    }

    public void setColors(int c1, int c2, int c3, int c4) {
        setColors(c1, c2, c3, c4, true);
    }

    public void setColors(int c1, int c2, int c3, int c4, Bitmap bitmap) {
        int[] iArr = this.colors;
        iArr[0] = c1;
        iArr[1] = c2;
        iArr[2] = c3;
        iArr[3] = c4;
        Utilities.generateGradient(bitmap, true, this.phase, this.interpolator.getInterpolation(this.posAnimationProgress), this.currentBitmap.getWidth(), this.currentBitmap.getHeight(), this.currentBitmap.getRowBytes(), this.colors);
    }

    public void setColors(int c1, int c2, int c3, int c4, boolean invalidate) {
        int[] iArr = this.colors;
        iArr[0] = c1;
        iArr[1] = c2;
        iArr[2] = c3;
        iArr[3] = c4;
        Utilities.generateGradient(this.currentBitmap, true, this.phase, this.interpolator.getInterpolation(this.posAnimationProgress), this.currentBitmap.getWidth(), this.currentBitmap.getHeight(), this.currentBitmap.getRowBytes(), this.colors);
        if (invalidate) {
            invalidateParent();
        }
    }

    private void invalidateParent() {
        invalidateSelf();
        WeakReference<View> weakReference = this.parentView;
        if (weakReference != null && weakReference.get() != null) {
            this.parentView.get().invalidate();
        }
        if (this.postInvalidateParent) {
            NotificationCenter.getGlobalInstance().postNotificationName(NotificationCenter.invalidateMotionBackground, new Object[0]);
            updateAnimation();
            AndroidUtilities.cancelRunOnUIThread(this.updateAnimationRunnable);
            AndroidUtilities.runOnUIThread(this.updateAnimationRunnable, 16L);
        }
    }

    public boolean hasPattern() {
        return this.patternBitmap != null;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        Bitmap bitmap = this.patternBitmap;
        if (bitmap != null) {
            return bitmap.getWidth();
        }
        return super.getIntrinsicWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        Bitmap bitmap = this.patternBitmap;
        if (bitmap != null) {
            return bitmap.getHeight();
        }
        return super.getIntrinsicHeight();
    }

    public void setTranslationY(int y) {
        this.translationY = y;
    }

    public void setPatternBitmap(int intensity) {
        setPatternBitmap(intensity, this.patternBitmap);
    }

    @SuppressLint({"NewApi"})
    public void setPatternBitmap(int intensity, Bitmap bitmap) {
        this.intensity = intensity;
        this.patternBitmap = bitmap;
        this.invalidateLegacy = true;
        if (bitmap == null) {
            return;
        }
        if (useSoftLight) {
            if (intensity >= 0) {
                this.paint2.setBlendMode(BlendMode.SOFT_LIGHT);
            } else {
                this.paint2.setBlendMode(null);
            }
        }
        if (intensity < 0) {
            if (!useLegacyBitmap) {
                Bitmap bitmap2 = this.currentBitmap;
                Shader.TileMode tileMode = Shader.TileMode.CLAMP;
                this.bitmapShader = new BitmapShader(bitmap2, tileMode, tileMode);
                Bitmap bitmap3 = this.patternBitmap;
                Shader.TileMode tileMode2 = Shader.TileMode.CLAMP;
                this.gradientShader = new BitmapShader(bitmap3, tileMode2, tileMode2);
                this.paint2.setShader(new ComposeShader(this.bitmapShader, this.gradientShader, PorterDuff.Mode.DST_IN));
                this.matrix = new Matrix();
                return;
            }
            createLegacyBitmap();
            this.paint2.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
            return;
        }
        if (useLegacyBitmap) {
            this.paint2.setXfermode(null);
        }
    }

    public void setPatternColorFilter(int color) {
        this.patternColorFilter = new PorterDuffColorFilter(color, PorterDuff.Mode.SRC_IN);
        invalidateParent();
    }

    public void setPatternAlpha(float alpha) {
        this.patternAlpha = alpha;
        invalidateParent();
    }

    @Override // android.graphics.drawable.Drawable
    public void setBounds(int left, int top, int right, int bottom) {
        super.setBounds(left, top, right, bottom);
        this.patternBounds.set(left, top, right, bottom);
        createLegacyBitmap();
    }

    private void createLegacyBitmap() {
        if (!useLegacyBitmap || this.intensity >= 0) {
            return;
        }
        int iWidth = this.patternBounds.width();
        int iHeight = this.patternBounds.height();
        if (iWidth <= 0 || iHeight <= 0) {
            return;
        }
        Bitmap bitmap = this.legacyBitmap;
        if (bitmap != null && bitmap.getWidth() == iWidth && this.legacyBitmap.getHeight() == iHeight) {
            return;
        }
        Bitmap bitmap2 = this.legacyBitmap;
        if (bitmap2 != null) {
            bitmap2.recycle();
        }
        Bitmap bitmap3 = this.legacyBitmap2;
        if (bitmap3 != null) {
            bitmap3.recycle();
            this.legacyBitmap2 = null;
        }
        this.legacyBitmap = Bitmap.createBitmap(iWidth, iHeight, Bitmap.Config.ARGB_8888);
        this.legacyCanvas = new Canvas(this.legacyBitmap);
        this.invalidateLegacy = true;
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0144  */
    @Override // android.graphics.drawable.Drawable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void draw(android.graphics.Canvas r15) {
        /*
            Method dump skipped, instructions count: 690
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.Components.MotionBackgroundDrawable.draw(android.graphics.Canvas):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:99:0x014c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void updateAnimation() {
        /*
            Method dump skipped, instructions count: 366
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.Components.MotionBackgroundDrawable.updateAnimation():void");
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int alpha) {
        this.alpha = alpha;
        this.paint.setAlpha(alpha);
        this.paint2.setAlpha(alpha);
    }
}
