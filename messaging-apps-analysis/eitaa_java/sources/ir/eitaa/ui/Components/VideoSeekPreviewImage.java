package ir.eitaa.ui.Components;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.TextPaint;
import android.view.View;
import android.view.ViewGroup;
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.messenger.Bitmaps;
import ir.eitaa.messenger.DispatchQueue;
import ir.eitaa.messenger.FileLoader;
import ir.eitaa.messenger.R;
import ir.eitaa.messenger.Utilities;
import ir.eitaa.tgnet.TLRPC$TL_document;
import ir.eitaa.tgnet.TLRPC$TL_documentAttributeFilename;
import ir.eitaa.tgnet.TLRPC$TL_documentAttributeVideo;
import java.io.File;

/* loaded from: classes3.dex */
public class VideoSeekPreviewImage extends View {
    private Paint bitmapPaint;
    private RectF bitmapRect;
    private BitmapShader bitmapShader;
    private Bitmap bitmapToDraw;
    private Bitmap bitmapToRecycle;
    private int currentPixel;
    private VideoSeekPreviewImageDelegate delegate;
    private RectF dstR;
    private long duration;
    private AnimatedFileDrawable fileDrawable;
    private Drawable frameDrawable;
    private String frameTime;
    private Runnable loadRunnable;
    private Matrix matrix;
    private Paint paint;
    private float pendingProgress;
    private int pixelWidth;
    private Runnable progressRunnable;
    private boolean ready;
    private TextPaint textPaint;
    private int timeWidth;
    private Uri videoUri;

    public interface VideoSeekPreviewImageDelegate {
        void onReady();
    }

    public VideoSeekPreviewImage(Context context, VideoSeekPreviewImageDelegate videoSeekPreviewImageDelegate) {
        super(context);
        this.currentPixel = -1;
        this.textPaint = new TextPaint(1);
        this.dstR = new RectF();
        this.paint = new Paint(2);
        this.bitmapPaint = new Paint(2);
        this.bitmapRect = new RectF();
        this.matrix = new Matrix();
        setVisibility(4);
        this.frameDrawable = context.getResources().getDrawable(R.drawable.videopreview);
        this.textPaint.setTextSize(AndroidUtilities.dp(13.0f));
        this.textPaint.setColor(-1);
        this.delegate = videoSeekPreviewImageDelegate;
    }

    public void setProgress(final float progress, int w) {
        if (w != 0) {
            this.pixelWidth = w;
            int i = ((int) (w * progress)) / 5;
            if (this.currentPixel == i) {
                return;
            } else {
                this.currentPixel = i;
            }
        }
        final long j = (long) (this.duration * progress);
        this.frameTime = AndroidUtilities.formatShortDuration((int) (j / 1000));
        this.timeWidth = (int) Math.ceil(this.textPaint.measureText(r6));
        invalidate();
        if (this.progressRunnable != null) {
            Utilities.globalQueue.cancelRunnable(this.progressRunnable);
        }
        AnimatedFileDrawable animatedFileDrawable = this.fileDrawable;
        if (animatedFileDrawable != null) {
            animatedFileDrawable.resetStream(false);
        }
        DispatchQueue dispatchQueue = Utilities.globalQueue;
        Runnable runnable = new Runnable() { // from class: ir.eitaa.ui.Components.-$$Lambda$VideoSeekPreviewImage$9nHyopvQyV-6i9Wjj3wdNs_KGmA
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$setProgress$1$VideoSeekPreviewImage(progress, j);
            }
        };
        this.progressRunnable = runnable;
        dispatchQueue.postRunnable(runnable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$setProgress$1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$setProgress$1$VideoSeekPreviewImage(float f, long j) {
        int i;
        if (this.fileDrawable == null) {
            this.pendingProgress = f;
            return;
        }
        int iMax = Math.max(200, AndroidUtilities.dp(100.0f));
        final Bitmap frameAtTime = this.fileDrawable.getFrameAtTime(j);
        if (frameAtTime != null) {
            int width = frameAtTime.getWidth();
            int height = frameAtTime.getHeight();
            if (width > height) {
                i = (int) (height / (width / iMax));
            } else {
                int i2 = (int) (width / (height / iMax));
                i = iMax;
                iMax = i2;
            }
            try {
                Bitmap bitmapCreateBitmap = Bitmaps.createBitmap(iMax, i, Bitmap.Config.ARGB_8888);
                this.dstR.set(0.0f, 0.0f, iMax, i);
                Canvas canvas = new Canvas(bitmapCreateBitmap);
                canvas.drawBitmap(frameAtTime, (android.graphics.Rect) null, this.dstR, this.paint);
                canvas.setBitmap(null);
                frameAtTime = bitmapCreateBitmap;
            } catch (Throwable unused) {
                frameAtTime = null;
            }
        }
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.Components.-$$Lambda$VideoSeekPreviewImage$yzVcddQnjoHnqLXQvwvc_ObWU-Y
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$setProgress$0$VideoSeekPreviewImage(frameAtTime);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$setProgress$0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$setProgress$0$VideoSeekPreviewImage(Bitmap bitmap) {
        int i;
        if (bitmap != null) {
            if (this.bitmapToDraw != null) {
                Bitmap bitmap2 = this.bitmapToRecycle;
                if (bitmap2 != null) {
                    bitmap2.recycle();
                }
                this.bitmapToRecycle = this.bitmapToDraw;
            }
            this.bitmapToDraw = bitmap;
            Bitmap bitmap3 = this.bitmapToDraw;
            Shader.TileMode tileMode = Shader.TileMode.CLAMP;
            BitmapShader bitmapShader = new BitmapShader(bitmap3, tileMode, tileMode);
            this.bitmapShader = bitmapShader;
            bitmapShader.setLocalMatrix(this.matrix);
            this.bitmapPaint.setShader(this.bitmapShader);
            invalidate();
            int iDp = AndroidUtilities.dp(150.0f);
            float width = bitmap.getWidth() / bitmap.getHeight();
            if (width > 1.0f) {
                i = (int) (iDp / width);
            } else {
                iDp = (int) (iDp * width);
                i = iDp;
            }
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            if (getVisibility() != 0 || layoutParams.width != iDp || layoutParams.height != i) {
                layoutParams.width = iDp;
                layoutParams.height = i;
                setVisibility(0);
                requestLayout();
            }
        }
        this.progressRunnable = null;
    }

    public void open(final Uri uri) {
        if (uri == null || uri.equals(this.videoUri)) {
            return;
        }
        this.videoUri = uri;
        DispatchQueue dispatchQueue = Utilities.globalQueue;
        Runnable runnable = new Runnable() { // from class: ir.eitaa.ui.Components.-$$Lambda$VideoSeekPreviewImage$B-w1Yy4Aw8QDTwExQUZMz3Qk2r8
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$open$3$VideoSeekPreviewImage(uri);
            }
        };
        this.loadRunnable = runnable;
        dispatchQueue.postRunnable(runnable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$open$3, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$open$3$VideoSeekPreviewImage(Uri uri) {
        String absolutePath;
        if ("et".equals(uri.getScheme())) {
            int iIntValue = Utilities.parseInt(uri.getQueryParameter("account")).intValue();
            Object parentObject = FileLoader.getInstance(iIntValue).getParentObject(Utilities.parseInt(uri.getQueryParameter("rid")).intValue());
            TLRPC$TL_document tLRPC$TL_document = new TLRPC$TL_document();
            tLRPC$TL_document.access_hash = Utilities.parseLong(uri.getQueryParameter("hash")).longValue();
            tLRPC$TL_document.id = Utilities.parseLong(uri.getQueryParameter("id")).longValue();
            tLRPC$TL_document.size = Utilities.parseInt(uri.getQueryParameter("size")).intValue();
            tLRPC$TL_document.dc_id = Utilities.parseInt(uri.getQueryParameter("dc")).intValue();
            tLRPC$TL_document.mime_type = uri.getQueryParameter("mime");
            tLRPC$TL_document.file_reference = Utilities.hexToBytes(uri.getQueryParameter("reference"));
            TLRPC$TL_documentAttributeFilename tLRPC$TL_documentAttributeFilename = new TLRPC$TL_documentAttributeFilename();
            tLRPC$TL_documentAttributeFilename.file_name = uri.getQueryParameter("name");
            tLRPC$TL_document.attributes.add(tLRPC$TL_documentAttributeFilename);
            tLRPC$TL_document.attributes.add(new TLRPC$TL_documentAttributeVideo());
            if (FileLoader.getInstance(iIntValue).isLoadingFile(FileLoader.getAttachFileName(tLRPC$TL_document))) {
                absolutePath = new File(FileLoader.getDirectory(4), tLRPC$TL_document.dc_id + "_" + tLRPC$TL_document.id + ".temp").getAbsolutePath();
            } else {
                absolutePath = FileLoader.getPathToAttach(tLRPC$TL_document, false).getAbsolutePath();
            }
            this.fileDrawable = new AnimatedFileDrawable(new File(absolutePath), true, tLRPC$TL_document.size, tLRPC$TL_document, null, parentObject, 0L, iIntValue, true);
        } else {
            this.fileDrawable = new AnimatedFileDrawable(new File(uri.getPath()), true, 0L, null, null, null, 0L, 0, true);
        }
        this.duration = this.fileDrawable.getDurationMs();
        float f = this.pendingProgress;
        if (f != 0.0f) {
            setProgress(f, this.pixelWidth);
            this.pendingProgress = 0.0f;
        }
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.Components.-$$Lambda$VideoSeekPreviewImage$NREmvItBJ1-0yq0CTdfROWD8X_8
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$open$2$VideoSeekPreviewImage();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$open$2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$open$2$VideoSeekPreviewImage() {
        this.loadRunnable = null;
        if (this.fileDrawable != null) {
            this.ready = true;
            this.delegate.onReady();
        }
    }

    public boolean isReady() {
        return this.ready;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        Bitmap bitmap = this.bitmapToRecycle;
        if (bitmap != null) {
            bitmap.recycle();
            this.bitmapToRecycle = null;
        }
        if (this.bitmapToDraw == null || this.bitmapShader == null) {
            return;
        }
        this.matrix.reset();
        float measuredWidth = getMeasuredWidth() / this.bitmapToDraw.getWidth();
        this.matrix.preScale(measuredWidth, measuredWidth);
        this.bitmapRect.set(0.0f, 0.0f, getMeasuredWidth(), getMeasuredHeight());
        canvas.drawRoundRect(this.bitmapRect, AndroidUtilities.dp(6.0f), AndroidUtilities.dp(6.0f), this.bitmapPaint);
        this.frameDrawable.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
        this.frameDrawable.draw(canvas);
        canvas.drawText(this.frameTime, (getMeasuredWidth() - this.timeWidth) / 2, getMeasuredHeight() - AndroidUtilities.dp(9.0f), this.textPaint);
    }

    public void close() {
        if (this.loadRunnable != null) {
            Utilities.globalQueue.cancelRunnable(this.loadRunnable);
            this.loadRunnable = null;
        }
        if (this.progressRunnable != null) {
            Utilities.globalQueue.cancelRunnable(this.progressRunnable);
            this.progressRunnable = null;
        }
        AnimatedFileDrawable animatedFileDrawable = this.fileDrawable;
        if (animatedFileDrawable != null) {
            animatedFileDrawable.resetStream(true);
        }
        Utilities.globalQueue.postRunnable(new Runnable() { // from class: ir.eitaa.ui.Components.-$$Lambda$VideoSeekPreviewImage$67l4mgx8trHCbZ6ic8EueqvYzXo
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$close$4$VideoSeekPreviewImage();
            }
        });
        setVisibility(4);
        this.bitmapToDraw = null;
        this.bitmapShader = null;
        invalidate();
        this.currentPixel = -1;
        this.videoUri = null;
        this.ready = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$close$4, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$close$4$VideoSeekPreviewImage() {
        this.pendingProgress = 0.0f;
        AnimatedFileDrawable animatedFileDrawable = this.fileDrawable;
        if (animatedFileDrawable != null) {
            animatedFileDrawable.recycle();
            this.fileDrawable = null;
        }
    }
}
