package ir.eitaa.ui.Components;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.messenger.DownloadController;
import ir.eitaa.messenger.FileLoader;
import ir.eitaa.messenger.LocaleController;
import ir.eitaa.messenger.MessageObject;
import ir.eitaa.messenger.R;

/* loaded from: classes3.dex */
public class OtherDocumentPlaceholderDrawable extends RecyclableDrawable implements DownloadController.FileDownloadProgressListener {
    private int TAG;
    private String ext;
    private String fileName;
    private String fileSize;
    private boolean loaded;
    private boolean loading;
    private MessageObject parentMessageObject;
    private View parentView;
    private String progress;
    private boolean progressVisible;
    private Drawable thumbDrawable;
    private static Paint paint = new Paint();
    private static Paint progressPaint = new Paint(1);
    private static TextPaint docPaint = new TextPaint(1);
    private static TextPaint namePaint = new TextPaint(1);
    private static TextPaint sizePaint = new TextPaint(1);
    private static TextPaint buttonPaint = new TextPaint(1);
    private static TextPaint percentPaint = new TextPaint(1);
    private static TextPaint openPaint = new TextPaint(1);
    private static DecelerateInterpolator decelerateInterpolator = new DecelerateInterpolator();
    private long lastUpdateTime = 0;
    private float currentProgress = 0.0f;
    private float animationProgressStart = 0.0f;
    private long currentProgressTime = 0;
    private float animatedProgressValue = 0.0f;
    private float animatedAlphaValue = 1.0f;

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -1;
    }

    @Override // ir.eitaa.messenger.DownloadController.FileDownloadProgressListener
    public void onProgressUpload(String fileName, long uploadedSize, long totalSize, boolean isEncrypted) {
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
    }

    static {
        progressPaint.setStrokeCap(Paint.Cap.ROUND);
        paint.setColor(-14209998);
        docPaint.setColor(-1);
        namePaint.setColor(-1);
        sizePaint.setColor(-10327179);
        buttonPaint.setColor(-10327179);
        percentPaint.setColor(-1);
        openPaint.setColor(-1);
        docPaint.setTypeface(AndroidUtilities.getFontFamily(true));
        namePaint.setTypeface(AndroidUtilities.getFontFamily(true));
        buttonPaint.setTypeface(AndroidUtilities.getFontFamily(true));
        percentPaint.setTypeface(AndroidUtilities.getFontFamily(true));
        openPaint.setTypeface(AndroidUtilities.getFontFamily(true));
    }

    public OtherDocumentPlaceholderDrawable(Context context, View view, MessageObject messageObject) {
        docPaint.setTextSize(AndroidUtilities.dp(14.0f));
        namePaint.setTextSize(AndroidUtilities.dp(19.0f));
        sizePaint.setTextSize(AndroidUtilities.dp(15.0f));
        buttonPaint.setTextSize(AndroidUtilities.dp(15.0f));
        percentPaint.setTextSize(AndroidUtilities.dp(15.0f));
        openPaint.setTextSize(AndroidUtilities.dp(15.0f));
        progressPaint.setStrokeWidth(AndroidUtilities.dp(2.0f));
        this.parentView = view;
        this.parentMessageObject = messageObject;
        this.TAG = DownloadController.getInstance(messageObject.currentAccount).generateObserverTag();
        if (messageObject.getDocument() != null) {
            String documentFileName = FileLoader.getDocumentFileName(messageObject.getDocument());
            this.fileName = documentFileName;
            if (TextUtils.isEmpty(documentFileName)) {
                this.fileName = "name";
            }
            int iLastIndexOf = this.fileName.lastIndexOf(46);
            this.ext = iLastIndexOf == -1 ? "" : this.fileName.substring(iLastIndexOf + 1).toUpperCase();
            if (((int) Math.ceil(docPaint.measureText(r0))) > AndroidUtilities.dp(40.0f)) {
                this.ext = TextUtils.ellipsize(this.ext, docPaint, AndroidUtilities.dp(40.0f), TextUtils.TruncateAt.END).toString();
            }
            this.thumbDrawable = context.getResources().getDrawable(AndroidUtilities.getThumbForNameOrMime(this.fileName, messageObject.getDocument().mime_type, true)).mutate();
            this.fileSize = AndroidUtilities.formatFileSize(r7.size);
            if (((int) Math.ceil(namePaint.measureText(this.fileName))) > AndroidUtilities.dp(320.0f)) {
                this.fileName = TextUtils.ellipsize(this.fileName, namePaint, AndroidUtilities.dp(320.0f), TextUtils.TruncateAt.END).toString();
            }
        }
        checkFileExist();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int alpha) {
        Drawable drawable = this.thumbDrawable;
        if (drawable != null) {
            drawable.setAlpha(alpha);
        }
        paint.setAlpha(alpha);
        docPaint.setAlpha(alpha);
        namePaint.setAlpha(alpha);
        sizePaint.setAlpha(alpha);
        buttonPaint.setAlpha(alpha);
        percentPaint.setAlpha(alpha);
        openPaint.setAlpha(alpha);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        String string;
        int iDp;
        TextPaint textPaint;
        android.graphics.Rect bounds = getBounds();
        int iWidth = bounds.width();
        int iHeight = bounds.height();
        canvas.save();
        canvas.translate(bounds.left, bounds.top);
        canvas.drawRect(0.0f, 0.0f, iWidth, iHeight, paint);
        int iDp2 = (iHeight - AndroidUtilities.dp(240.0f)) / 2;
        int iDp3 = (iWidth - AndroidUtilities.dp(48.0f)) / 2;
        this.thumbDrawable.setBounds(iDp3, iDp2, AndroidUtilities.dp(48.0f) + iDp3, AndroidUtilities.dp(48.0f) + iDp2);
        this.thumbDrawable.draw(canvas);
        canvas.drawText(this.ext, (iWidth - ((int) Math.ceil(docPaint.measureText(this.ext)))) / 2, AndroidUtilities.dp(31.0f) + iDp2, docPaint);
        canvas.drawText(this.fileName, (iWidth - ((int) Math.ceil(namePaint.measureText(this.fileName)))) / 2, AndroidUtilities.dp(96.0f) + iDp2, namePaint);
        canvas.drawText(this.fileSize, (iWidth - ((int) Math.ceil(sizePaint.measureText(this.fileSize)))) / 2, AndroidUtilities.dp(125.0f) + iDp2, sizePaint);
        if (this.loaded) {
            string = LocaleController.getString("OpenFile", R.string.OpenFile);
            textPaint = openPaint;
            iDp = 0;
        } else {
            if (this.loading) {
                string = LocaleController.getString("Cancel", R.string.Cancel).toUpperCase();
            } else {
                string = LocaleController.getString("TapToDownload", R.string.TapToDownload);
            }
            iDp = AndroidUtilities.dp(28.0f);
            textPaint = buttonPaint;
        }
        canvas.drawText(string, (iWidth - ((int) Math.ceil(textPaint.measureText(string)))) / 2, AndroidUtilities.dp(235.0f) + iDp2 + iDp, textPaint);
        if (this.progressVisible) {
            if (this.progress != null) {
                canvas.drawText(this.progress, (iWidth - ((int) Math.ceil(percentPaint.measureText(r3)))) / 2, AndroidUtilities.dp(210.0f) + iDp2, percentPaint);
            }
            int iDp4 = (iWidth - AndroidUtilities.dp(240.0f)) / 2;
            int iDp5 = iDp2 + AndroidUtilities.dp(232.0f);
            progressPaint.setColor(-10327179);
            progressPaint.setAlpha((int) (this.animatedAlphaValue * 255.0f));
            float f = iDp5;
            canvas.drawRect(((int) (AndroidUtilities.dp(240.0f) * this.animatedProgressValue)) + iDp4, f, AndroidUtilities.dp(240.0f) + iDp4, AndroidUtilities.dp(2.0f) + iDp5, progressPaint);
            progressPaint.setColor(-1);
            progressPaint.setAlpha((int) (this.animatedAlphaValue * 255.0f));
            float f2 = iDp4;
            canvas.drawRect(f2, f, f2 + (AndroidUtilities.dp(240.0f) * this.animatedProgressValue), iDp5 + AndroidUtilities.dp(2.0f), progressPaint);
            updateAnimation();
        }
        canvas.restore();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.parentView.getMeasuredWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.parentView.getMeasuredHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumWidth() {
        return this.parentView.getMeasuredWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumHeight() {
        return this.parentView.getMeasuredHeight();
    }

    @Override // ir.eitaa.messenger.DownloadController.FileDownloadProgressListener
    public void onFailedDownload(String name, boolean canceled) {
        checkFileExist();
    }

    @Override // ir.eitaa.messenger.DownloadController.FileDownloadProgressListener
    public void onSuccessDownload(String name) {
        setProgress(1.0f, true);
        checkFileExist();
    }

    @Override // ir.eitaa.messenger.DownloadController.FileDownloadProgressListener
    public void onProgressDownload(String fileName, long downloadedSize, long totalSize) {
        if (!this.progressVisible) {
            checkFileExist();
        }
        setProgress(Math.min(1.0f, downloadedSize / totalSize), true);
    }

    @Override // ir.eitaa.messenger.DownloadController.FileDownloadProgressListener
    public int getObserverTag() {
        return this.TAG;
    }

    @Override // ir.eitaa.ui.Components.RecyclableDrawable
    public void recycle() {
        DownloadController.getInstance(this.parentMessageObject.currentAccount).removeLoadingFileObserver(this);
        this.parentView = null;
        this.parentMessageObject = null;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x008b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void checkFileExist() {
        /*
            r6 = this;
            ir.eitaa.messenger.MessageObject r0 = r6.parentMessageObject
            r1 = 0
            r2 = 1
            r3 = 0
            if (r0 == 0) goto L8b
            ir.eitaa.tgnet.TLRPC$Message r0 = r0.messageOwner
            ir.eitaa.tgnet.TLRPC$MessageMedia r4 = r0.media
            if (r4 == 0) goto L8b
            r4 = 0
            java.lang.String r0 = r0.attachPath
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L27
            java.io.File r0 = new java.io.File
            ir.eitaa.messenger.MessageObject r5 = r6.parentMessageObject
            ir.eitaa.tgnet.TLRPC$Message r5 = r5.messageOwner
            java.lang.String r5 = r5.attachPath
            r0.<init>(r5)
            boolean r0 = r0.exists()
            if (r0 != 0) goto L3f
        L27:
            ir.eitaa.messenger.MessageObject r0 = r6.parentMessageObject
            ir.eitaa.tgnet.TLRPC$Message r0 = r0.messageOwner
            java.io.File r0 = ir.eitaa.messenger.FileLoader.getPathToMessage(r0)
            boolean r0 = r0.exists()
            if (r0 != 0) goto L3f
            ir.eitaa.messenger.MessageObject r0 = r6.parentMessageObject
            ir.eitaa.tgnet.TLRPC$Document r0 = r0.getDocument()
            java.lang.String r4 = ir.eitaa.messenger.FileLoader.getAttachFileName(r0)
        L3f:
            r6.loaded = r3
            if (r4 != 0) goto L55
            r6.progressVisible = r3
            r6.loading = r3
            r6.loaded = r2
            ir.eitaa.messenger.MessageObject r0 = r6.parentMessageObject
            int r0 = r0.currentAccount
            ir.eitaa.messenger.DownloadController r0 = ir.eitaa.messenger.DownloadController.getInstance(r0)
            r0.removeLoadingFileObserver(r6)
            goto L9f
        L55:
            ir.eitaa.messenger.MessageObject r0 = r6.parentMessageObject
            int r0 = r0.currentAccount
            ir.eitaa.messenger.DownloadController r0 = ir.eitaa.messenger.DownloadController.getInstance(r0)
            r0.addLoadingFileObserver(r4, r6)
            ir.eitaa.messenger.MessageObject r0 = r6.parentMessageObject
            int r0 = r0.currentAccount
            ir.eitaa.messenger.FileLoader r0 = ir.eitaa.messenger.FileLoader.getInstance(r0)
            boolean r0 = r0.isLoadingFile(r4)
            r6.loading = r0
            if (r0 == 0) goto L88
            r6.progressVisible = r2
            ir.eitaa.messenger.ImageLoader r0 = ir.eitaa.messenger.ImageLoader.getInstance()
            java.lang.Float r0 = r0.getFileProgress(r4)
            if (r0 != 0) goto L80
            java.lang.Float r0 = java.lang.Float.valueOf(r1)
        L80:
            float r0 = r0.floatValue()
            r6.setProgress(r0, r3)
            goto L9f
        L88:
            r6.progressVisible = r3
            goto L9f
        L8b:
            r6.loading = r3
            r6.loaded = r2
            r6.progressVisible = r3
            r6.setProgress(r1, r3)
            ir.eitaa.messenger.MessageObject r0 = r6.parentMessageObject
            int r0 = r0.currentAccount
            ir.eitaa.messenger.DownloadController r0 = ir.eitaa.messenger.DownloadController.getInstance(r0)
            r0.removeLoadingFileObserver(r6)
        L9f:
            android.view.View r0 = r6.parentView
            r0.invalidate()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.Components.OtherDocumentPlaceholderDrawable.checkFileExist():void");
    }

    private void updateAnimation() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        long j = jCurrentTimeMillis - this.lastUpdateTime;
        this.lastUpdateTime = jCurrentTimeMillis;
        float f = this.animatedProgressValue;
        if (f != 1.0f) {
            float f2 = this.currentProgress;
            if (f != f2) {
                float f3 = this.animationProgressStart;
                float f4 = f2 - f3;
                if (f4 > 0.0f) {
                    long j2 = this.currentProgressTime + j;
                    this.currentProgressTime = j2;
                    if (j2 >= 300) {
                        this.animatedProgressValue = f2;
                        this.animationProgressStart = f2;
                        this.currentProgressTime = 0L;
                    } else {
                        this.animatedProgressValue = f3 + (f4 * decelerateInterpolator.getInterpolation(j2 / 300.0f));
                    }
                }
                this.parentView.invalidate();
            }
        }
        float f5 = this.animatedProgressValue;
        if (f5 < 1.0f || f5 != 1.0f) {
            return;
        }
        float f6 = this.animatedAlphaValue;
        if (f6 != 0.0f) {
            float f7 = f6 - (j / 200.0f);
            this.animatedAlphaValue = f7;
            if (f7 <= 0.0f) {
                this.animatedAlphaValue = 0.0f;
            }
            this.parentView.invalidate();
        }
    }

    public void setProgress(float value, boolean animated) {
        if (!animated) {
            this.animatedProgressValue = value;
            this.animationProgressStart = value;
        } else {
            this.animationProgressStart = this.animatedProgressValue;
        }
        this.progress = String.format("%d%%", Integer.valueOf((int) (100.0f * value)));
        if (value != 1.0f) {
            this.animatedAlphaValue = 1.0f;
        }
        this.currentProgress = value;
        this.currentProgressTime = 0L;
        this.lastUpdateTime = System.currentTimeMillis();
        this.parentView.invalidate();
    }
}
