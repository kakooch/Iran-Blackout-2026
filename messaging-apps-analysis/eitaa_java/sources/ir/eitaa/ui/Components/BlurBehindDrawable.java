package ir.eitaa.ui.Components;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.view.View;
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.messenger.DispatchQueue;
import ir.eitaa.messenger.FileLog;
import ir.eitaa.messenger.Utilities;
import ir.eitaa.ui.ActionBar.Theme;
import ir.eitaa.ui.ChatActivity;

/* loaded from: classes3.dex */
public class BlurBehindDrawable {
    private Bitmap[] backgroundBitmap;
    private Canvas[] backgroundBitmapCanvas;
    private View behindView;
    private float blurAlpha;
    private Canvas[] blurCanvas;
    private Bitmap[] blurredBitmapTmp;
    private boolean error;
    Paint errorBlackoutPaint;
    private int lastH;
    private int lastW;
    private float panTranslationY;
    private View parentView;
    private boolean processingNextFrame;
    DispatchQueue queue;
    private Bitmap[] renderingBitmap;
    private Canvas[] renderingBitmapCanvas;
    private final Theme.ResourcesProvider resourcesProvider;
    private boolean show;
    private boolean skipDraw;
    private int toolbarH;
    private final int type;
    private boolean wasDraw;
    private boolean invalidate = true;
    private boolean animateAlpha = true;
    private final float DOWN_SCALE = 6.0f;
    BlurBackgroundTask blurBackgroundTask = new BlurBackgroundTask();
    Paint emptyPaint = new Paint(2);

    public BlurBehindDrawable(View behindView, View parentView, int type, Theme.ResourcesProvider resourcesProvider) {
        Paint paint = new Paint();
        this.errorBlackoutPaint = paint;
        this.type = type;
        this.behindView = behindView;
        this.parentView = parentView;
        this.resourcesProvider = resourcesProvider;
        paint.setColor(-16777216);
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x003e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void draw(android.graphics.Canvas r15) throws java.lang.InterruptedException {
        /*
            Method dump skipped, instructions count: 639
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.Components.BlurBehindDrawable.draw(android.graphics.Canvas):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$draw$0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$draw$0$BlurBehindDrawable() {
        this.error = true;
        this.parentView.invalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getBlurRadius() {
        return Math.max(7, Math.max(this.lastH, this.lastW) / 180);
    }

    public void clear() throws InterruptedException {
        this.invalidate = true;
        this.wasDraw = false;
        this.error = false;
        this.blurAlpha = 0.0f;
        this.lastW = 0;
        this.lastH = 0;
        DispatchQueue dispatchQueue = this.queue;
        if (dispatchQueue != null) {
            dispatchQueue.cleanupQueue();
            this.queue.postRunnable(new Runnable() { // from class: ir.eitaa.ui.Components.-$$Lambda$BlurBehindDrawable$2O5zOCduwm2APM886f6jT-EA5Sw
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$clear$2$BlurBehindDrawable();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$clear$2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$clear$2$BlurBehindDrawable() {
        Bitmap[] bitmapArr = this.renderingBitmap;
        if (bitmapArr != null) {
            if (bitmapArr[0] != null) {
                bitmapArr[0].recycle();
            }
            Bitmap[] bitmapArr2 = this.renderingBitmap;
            if (bitmapArr2[1] != null) {
                bitmapArr2[1].recycle();
            }
            this.renderingBitmap = null;
        }
        Bitmap[] bitmapArr3 = this.backgroundBitmap;
        if (bitmapArr3 != null) {
            if (bitmapArr3[0] != null) {
                bitmapArr3[0].recycle();
            }
            Bitmap[] bitmapArr4 = this.backgroundBitmap;
            if (bitmapArr4[1] != null) {
                bitmapArr4[1].recycle();
            }
            this.backgroundBitmap = null;
        }
        this.renderingBitmapCanvas = null;
        this.skipDraw = false;
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.Components.-$$Lambda$BlurBehindDrawable$BU-6uViSxhVUEPreLGSV6tsG80Y
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$clear$1$BlurBehindDrawable();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$clear$1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$clear$1$BlurBehindDrawable() {
        DispatchQueue dispatchQueue = this.queue;
        if (dispatchQueue != null) {
            dispatchQueue.recycle();
            this.queue = null;
        }
    }

    public void invalidate() {
        this.invalidate = true;
        View view = this.parentView;
        if (view != null) {
            view.invalidate();
        }
    }

    public boolean isFullyDrawing() {
        return !this.skipDraw && this.wasDraw && (this.blurAlpha == 1.0f || !this.animateAlpha) && this.show && this.parentView.getAlpha() == 1.0f;
    }

    public void checkSizes() throws InterruptedException {
        if (this.renderingBitmap == null || this.parentView.getMeasuredHeight() == 0 || this.parentView.getMeasuredWidth() == 0) {
            return;
        }
        generateBlurredBitmaps();
        this.lastH = this.parentView.getMeasuredHeight();
        this.lastW = this.parentView.getMeasuredWidth();
    }

    private void generateBlurredBitmaps() throws InterruptedException {
        Bitmap[] bitmapArr = this.renderingBitmap;
        if (bitmapArr == null) {
            bitmapArr = new Bitmap[2];
            this.renderingBitmap = bitmapArr;
            this.renderingBitmapCanvas = new Canvas[2];
        }
        if (this.blurredBitmapTmp == null) {
            this.blurredBitmapTmp = new Bitmap[2];
            this.blurCanvas = new Canvas[2];
        }
        this.blurBackgroundTask.canceled = true;
        this.blurBackgroundTask = new BlurBackgroundTask();
        for (int i = 0; i < 2; i++) {
            int measuredHeight = this.parentView.getMeasuredHeight();
            int measuredWidth = this.parentView.getMeasuredWidth();
            int iDp = AndroidUtilities.statusBarHeight + AndroidUtilities.dp(200.0f);
            this.toolbarH = iDp;
            if (i != 0) {
                iDp = measuredHeight;
            }
            if (bitmapArr[i] == null || bitmapArr[i].getHeight() != iDp || bitmapArr[i].getWidth() != this.parentView.getMeasuredWidth()) {
                DispatchQueue dispatchQueue = this.queue;
                if (dispatchQueue != null) {
                    dispatchQueue.cleanupQueue();
                }
                int i2 = (int) (measuredWidth / 6.0f);
                this.blurredBitmapTmp[i] = Bitmap.createBitmap(i2, (int) (iDp / 6.0f), Bitmap.Config.ARGB_8888);
                if (i == 1) {
                    this.blurredBitmapTmp[i].eraseColor(getThemedColor("windowBackgroundWhite"));
                }
                this.blurCanvas[i] = new Canvas(this.blurredBitmapTmp[i]);
                if (i == 0) {
                    measuredHeight = this.toolbarH;
                }
                this.renderingBitmap[i] = Bitmap.createBitmap(i2, (int) (measuredHeight / 6.0f), Bitmap.Config.ARGB_8888);
                this.renderingBitmapCanvas[i] = new Canvas(this.renderingBitmap[i]);
                this.renderingBitmapCanvas[i].scale(this.renderingBitmap[i].getWidth() / this.blurredBitmapTmp[i].getWidth(), this.renderingBitmap[i].getHeight() / this.blurredBitmapTmp[i].getHeight());
                this.blurCanvas[i].save();
                this.blurCanvas[i].scale(0.16666667f, 0.16666667f, 0.0f, 0.0f);
                Drawable background = this.behindView.getBackground();
                if (background == null) {
                    background = getBackgroundDrawable();
                }
                this.behindView.setTag(67108867, Integer.valueOf(i));
                if (i == 0) {
                    this.blurCanvas[i].translate(0.0f, -this.panTranslationY);
                    this.behindView.draw(this.blurCanvas[i]);
                }
                if (i == 1) {
                    android.graphics.Rect bounds = background.getBounds();
                    background.setBounds(0, 0, this.behindView.getMeasuredWidth(), this.behindView.getMeasuredHeight());
                    background.draw(this.blurCanvas[i]);
                    background.setBounds(bounds);
                    this.behindView.draw(this.blurCanvas[i]);
                }
                this.behindView.setTag(67108867, null);
                this.blurCanvas[i].restore();
                Utilities.stackBlurBitmap(this.blurredBitmapTmp[i], getBlurRadius());
                this.emptyPaint.setAlpha(255);
                if (i == 1) {
                    this.renderingBitmap[i].eraseColor(getThemedColor("windowBackgroundWhite"));
                }
                this.renderingBitmapCanvas[i].drawBitmap(this.blurredBitmapTmp[i], 0.0f, 0.0f, this.emptyPaint);
            }
        }
    }

    public void show(boolean show) {
        this.show = show;
    }

    public void setAnimateAlpha(boolean animateAlpha) {
        this.animateAlpha = animateAlpha;
    }

    public void onPanTranslationUpdate(float y) {
        this.panTranslationY = y;
        this.parentView.invalidate();
    }

    public class BlurBackgroundTask implements Runnable {
        boolean canceled;
        int height;
        int width;

        public BlurBackgroundTask() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (BlurBehindDrawable.this.backgroundBitmap == null) {
                BlurBehindDrawable.this.backgroundBitmap = new Bitmap[2];
                BlurBehindDrawable.this.backgroundBitmapCanvas = new Canvas[2];
            }
            int i = (int) (this.width / 6.0f);
            int i2 = 0;
            while (i2 < 2) {
                int i3 = (int) ((i2 == 0 ? BlurBehindDrawable.this.toolbarH : this.height) / 6.0f);
                if (BlurBehindDrawable.this.backgroundBitmap[i2] != null && ((BlurBehindDrawable.this.backgroundBitmap[i2].getHeight() != i3 || BlurBehindDrawable.this.backgroundBitmap[i2].getWidth() != i) && BlurBehindDrawable.this.backgroundBitmap[i2] != null)) {
                    BlurBehindDrawable.this.backgroundBitmap[i2].recycle();
                    BlurBehindDrawable.this.backgroundBitmap[i2] = null;
                }
                System.currentTimeMillis();
                if (BlurBehindDrawable.this.backgroundBitmap[i2] == null) {
                    try {
                        BlurBehindDrawable.this.backgroundBitmap[i2] = Bitmap.createBitmap(i, i3, Bitmap.Config.ARGB_8888);
                        BlurBehindDrawable.this.backgroundBitmapCanvas[i2] = new Canvas(BlurBehindDrawable.this.backgroundBitmap[i2]);
                        BlurBehindDrawable.this.backgroundBitmapCanvas[i2].scale(i / BlurBehindDrawable.this.blurredBitmapTmp[i2].getWidth(), i3 / BlurBehindDrawable.this.blurredBitmapTmp[i2].getHeight());
                    } catch (Throwable th) {
                        FileLog.e(th);
                    }
                }
                if (i2 == 1) {
                    BlurBehindDrawable.this.backgroundBitmap[i2].eraseColor(BlurBehindDrawable.this.getThemedColor("windowBackgroundWhite"));
                } else {
                    BlurBehindDrawable.this.backgroundBitmap[i2].eraseColor(0);
                }
                BlurBehindDrawable.this.emptyPaint.setAlpha(255);
                Utilities.stackBlurBitmap(BlurBehindDrawable.this.blurredBitmapTmp[i2], BlurBehindDrawable.this.getBlurRadius());
                if (BlurBehindDrawable.this.backgroundBitmapCanvas[i2] != null) {
                    BlurBehindDrawable.this.backgroundBitmapCanvas[i2].drawBitmap(BlurBehindDrawable.this.blurredBitmapTmp[i2], 0.0f, 0.0f, BlurBehindDrawable.this.emptyPaint);
                }
                if (this.canceled) {
                    return;
                } else {
                    i2++;
                }
            }
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.Components.-$$Lambda$BlurBehindDrawable$BlurBackgroundTask$OOwIc3fS0JKetHsY__sCueD2tPA
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$run$0$BlurBehindDrawable$BlurBackgroundTask();
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$run$0, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$run$0$BlurBehindDrawable$BlurBackgroundTask() {
            if (this.canceled) {
                return;
            }
            Bitmap[] bitmapArr = BlurBehindDrawable.this.renderingBitmap;
            Canvas[] canvasArr = BlurBehindDrawable.this.renderingBitmapCanvas;
            BlurBehindDrawable blurBehindDrawable = BlurBehindDrawable.this;
            blurBehindDrawable.renderingBitmap = blurBehindDrawable.backgroundBitmap;
            BlurBehindDrawable blurBehindDrawable2 = BlurBehindDrawable.this;
            blurBehindDrawable2.renderingBitmapCanvas = blurBehindDrawable2.backgroundBitmapCanvas;
            BlurBehindDrawable.this.backgroundBitmap = bitmapArr;
            BlurBehindDrawable.this.backgroundBitmapCanvas = canvasArr;
            BlurBehindDrawable.this.processingNextFrame = false;
            if (BlurBehindDrawable.this.parentView != null) {
                BlurBehindDrawable.this.parentView.invalidate();
            }
        }
    }

    private Drawable getBackgroundDrawable() {
        Theme.ResourcesProvider resourcesProvider = this.resourcesProvider;
        if (resourcesProvider instanceof ChatActivity.ThemeDelegate) {
            return ((ChatActivity.ThemeDelegate) resourcesProvider).getWallpaperDrawable();
        }
        return Theme.getCachedWallpaperNonBlocking();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getThemedColor(String key) {
        Theme.ResourcesProvider resourcesProvider = this.resourcesProvider;
        Integer color = resourcesProvider != null ? resourcesProvider.getColor(key) : null;
        return color != null ? color.intValue() : Theme.getColor(key);
    }
}
