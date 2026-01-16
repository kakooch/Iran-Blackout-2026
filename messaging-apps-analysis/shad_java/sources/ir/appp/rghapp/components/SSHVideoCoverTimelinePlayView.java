package ir.appp.rghapp.components;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.media.MediaMetadataRetriever;
import android.os.AsyncTask;
import android.view.MotionEvent;
import android.view.TextureView;
import android.view.View;
import java.util.ArrayList;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.messenger.FileLog;
import org.rbmain.ui.ActionBar.Theme;

/* loaded from: classes3.dex */
public class SSHVideoCoverTimelinePlayView extends View {
    private static final Object sync = new Object();
    private int additionWidth;
    private int borderWidth;
    private int bottom;
    private AsyncTask<Integer, Integer, Bitmap> currentTask;
    private VideoCoverTimelineViewDelegate delegate;
    private long endTrim;
    private int endX;
    private int frameHeight;
    private long frameTimeOffset;
    private int frameWidth;
    private final ArrayList<Bitmap> frames;
    private int framesToLoad;
    private int lastWidth;
    private float leftProgress;
    private MediaMetadataRetriever mediaMetadataRetriever;
    private float middleWidth;
    private float offsetTranslateX;
    private float offsetTranslateY;
    private final Paint paint;
    private final Paint paint2;
    private final Paint paint3;
    private final Paint paint4;
    private boolean pressed;
    private float progress;
    private float rightProgress;
    private float scale;
    private final Matrix scaleMatrix;
    private long startTrim;
    private int startX;
    private int swipeX;
    private TextureView textureViewToCopy;
    private int top;
    private long videoLength;
    private float x1;

    public interface VideoCoverTimelineViewDelegate {
        void didStartDragging();

        void didStopDragging();

        void onProgressChanged(float f);
    }

    public SSHVideoCoverTimelinePlayView(Context context) {
        super(context);
        this.progress = 0.0f;
        this.frames = new ArrayList<>();
        Paint paint = new Paint();
        this.paint = paint;
        paint.setColor(-1);
        Paint paint2 = new Paint(2);
        this.paint2 = paint2;
        paint2.setAlpha(110);
        Paint paint3 = new Paint(1);
        this.paint3 = paint3;
        paint3.setColor(Theme.getColor(Theme.key_windowBackgroundWhite));
        paint3.setShadowLayer(AndroidUtilities.dp(20.0f), 0.0f, AndroidUtilities.dp(10.0f), 620756992);
        Paint paint4 = new Paint();
        this.paint4 = paint4;
        paint4.setColor(Theme.getColor(Theme.key_rubino_add_post_TabActiveText));
        this.scaleMatrix = new Matrix();
    }

    public float getProgress() {
        return this.progress;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent == null) {
            return false;
        }
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        if (motionEvent.getAction() == 0) {
            this.x1 = motionEvent.getX();
            getParent().requestDisallowInterceptTouchEvent(true);
            if (this.mediaMetadataRetriever == null) {
                return false;
            }
            if (this.startX <= x && x <= this.endX) {
                int i = this.top;
                if (y <= this.frameHeight + i && y >= i) {
                    VideoCoverTimelineViewDelegate videoCoverTimelineViewDelegate = this.delegate;
                    if (videoCoverTimelineViewDelegate != null) {
                        videoCoverTimelineViewDelegate.didStartDragging();
                    }
                    float f = this.x1 - this.additionWidth;
                    int i2 = this.frameHeight;
                    int i3 = (int) (f - (i2 / 2));
                    this.swipeX = i3;
                    if (i3 < 0) {
                        this.swipeX = 0;
                    }
                    float f2 = this.swipeX + i2;
                    float f3 = this.middleWidth;
                    if (f2 > f3) {
                        this.swipeX = ((int) f3) - i2;
                    }
                    this.pressed = true;
                    calculateProgress();
                    invalidate();
                    return true;
                }
            }
        } else if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
            if (this.pressed) {
                VideoCoverTimelineViewDelegate videoCoverTimelineViewDelegate2 = this.delegate;
                if (videoCoverTimelineViewDelegate2 != null) {
                    videoCoverTimelineViewDelegate2.didStopDragging();
                }
                this.pressed = false;
            }
        } else if (motionEvent.getAction() == 2 && this.pressed) {
            int x2 = (int) (motionEvent.getX() - this.x1);
            int i4 = this.swipeX;
            if (i4 <= 0 && x2 <= 0) {
                return true;
            }
            if (this.frameHeight + i4 >= this.middleWidth && x2 >= 0) {
                return true;
            }
            this.swipeX = i4 + x2;
            this.x1 = motionEvent.getX();
            if (this.swipeX < 0) {
                this.swipeX = 0;
            }
            int i5 = this.swipeX;
            int i6 = this.frameHeight;
            float f4 = i5 + i6;
            float f5 = this.middleWidth;
            if (f4 > f5) {
                this.swipeX = ((int) f5) - i6;
            }
            calculateProgress();
            invalidate();
            return true;
        }
        return true;
    }

    private void calculateProgress() {
        float f = this.middleWidth;
        float f2 = f / 2.0f;
        double d = f2;
        double dPow = Math.pow(d, 2.0d);
        double d2 = f - this.frameHeight;
        double dPow2 = Math.pow(d2, 2.0d);
        Double.isNaN(d2);
        Double.isNaN(d);
        double d3 = (dPow * d2) - (d * dPow2);
        Double.isNaN(d2);
        Double.isNaN(d);
        double dPow3 = Math.pow(this.swipeX, 2.0d);
        double d4 = this.swipeX;
        Double.isNaN(d4);
        float f3 = (float) ((dPow3 * (((d2 * 0.5d) - d) / d3)) + (d4 * ((dPow - (dPow2 * 0.5d)) / d3)));
        this.progress = f3;
        VideoCoverTimelineViewDelegate videoCoverTimelineViewDelegate = this.delegate;
        if (videoCoverTimelineViewDelegate != null) {
            videoCoverTimelineViewDelegate.onProgressChanged(f3);
        }
    }

    public void calculateSwipeX(float f) {
        this.progress = f;
        float f2 = this.middleWidth;
        float f3 = f2 / 2.0f;
        double d = f3;
        double dPow = Math.pow(d, 2.0d);
        double d2 = f2 - this.frameHeight;
        double dPow2 = Math.pow(d2, 2.0d);
        Double.isNaN(d2);
        Double.isNaN(d);
        double d3 = (dPow * d2) - (d * dPow2);
        Double.isNaN(d2);
        Double.isNaN(d);
        double d4 = ((d2 * 0.5d) - d) / d3;
        double d5 = (dPow - (dPow2 * 0.5d)) / d3;
        double d6 = f;
        Double.isNaN(d6);
        double dSqrt = Math.sqrt((4.0d * d4 * d6) + Math.pow(d5, 2.0d));
        double d7 = -d5;
        double d8 = d4 * 2.0d;
        this.swipeX = Math.max((int) ((d7 + dSqrt) / d8), (int) ((d7 - dSqrt) / d8));
    }

    public void setVideoPath(TextureView textureView, String str, float f, float f2, float f3, float f4, float f5) throws IllegalArgumentException {
        this.progress = f3;
        this.textureViewToCopy = textureView;
        if (this.leftProgress != f4 || this.rightProgress != f5) {
            destroy();
            this.mediaMetadataRetriever = new MediaMetadataRetriever();
            this.swipeX = 0;
        }
        this.offsetTranslateX = f;
        this.offsetTranslateY = f2;
        this.leftProgress = f4;
        this.rightProgress = f5;
        try {
            this.mediaMetadataRetriever.setDataSource(str);
            long j = (long) (this.leftProgress * f);
            this.startTrim = j;
            long j2 = (long) (this.rightProgress * f);
            this.endTrim = j2;
            this.videoLength = j2 - j;
        } catch (Exception e) {
            FileLog.e(e);
        }
        invalidate();
    }

    public void setDelegate(VideoCoverTimelineViewDelegate videoCoverTimelineViewDelegate) {
        this.delegate = videoCoverTimelineViewDelegate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reloadFrames(int i) {
        if (this.mediaMetadataRetriever == null) {
            return;
        }
        if (i == 0) {
            this.additionWidth = AndroidUtilities.dp(16.0f);
            this.middleWidth = getMeasuredWidth() - (this.additionWidth * 2);
            this.frameHeight = AndroidUtilities.dp(60.0f);
            this.frameWidth = AndroidUtilities.dp(42.0f);
            int iMax = Math.max(1, (int) Math.ceil(this.middleWidth / r2));
            this.framesToLoad = iMax;
            this.frameTimeOffset = this.videoLength / iMax;
            int i2 = this.additionWidth;
            this.startX = i2;
            this.endX = ((int) this.middleWidth) + i2;
            int i3 = this.frameHeight;
            int measuredHeight = (int) ((getMeasuredHeight() / 2.0f) - (i3 / 2.0f));
            this.top = measuredHeight;
            this.bottom = measuredHeight + i3;
            this.borderWidth = AndroidUtilities.dp(2.0f);
            float f = this.progress;
            if (f != 0.0f) {
                calculateSwipeX(f);
            }
        }
        AsyncTask<Integer, Integer, Bitmap> asyncTask = new AsyncTask<Integer, Integer, Bitmap>() { // from class: ir.appp.rghapp.components.SSHVideoCoverTimelinePlayView.1
            private int frameNum = 0;

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // android.os.AsyncTask
            public Bitmap doInBackground(Integer... numArr) {
                this.frameNum = numArr[0].intValue();
                Bitmap bitmap = null;
                if (isCancelled()) {
                    return null;
                }
                try {
                    Bitmap frameAtTime = SSHVideoCoverTimelinePlayView.this.mediaMetadataRetriever.getFrameAtTime((SSHVideoCoverTimelinePlayView.this.startTrim * 1000) + (SSHVideoCoverTimelinePlayView.this.frameTimeOffset * this.frameNum * 1000), 2);
                    try {
                        if (isCancelled()) {
                            return null;
                        }
                        if (frameAtTime == null) {
                            return frameAtTime;
                        }
                        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(SSHVideoCoverTimelinePlayView.this.frameWidth, SSHVideoCoverTimelinePlayView.this.frameHeight, frameAtTime.getConfig());
                        Canvas canvas = new Canvas(bitmapCreateBitmap);
                        float fMax = Math.max(SSHVideoCoverTimelinePlayView.this.frameWidth / frameAtTime.getWidth(), SSHVideoCoverTimelinePlayView.this.frameHeight / frameAtTime.getHeight());
                        int width = (int) (frameAtTime.getWidth() * fMax);
                        int height = (int) (frameAtTime.getHeight() * fMax);
                        Rect rect = new Rect(0, 0, frameAtTime.getWidth(), frameAtTime.getHeight());
                        int i4 = (SSHVideoCoverTimelinePlayView.this.frameWidth - width) / 2;
                        int i5 = (SSHVideoCoverTimelinePlayView.this.frameHeight - height) / 2;
                        canvas.drawBitmap(frameAtTime, rect, new Rect(i4, i5, width + i4, height + i5), (Paint) null);
                        frameAtTime.recycle();
                        return bitmapCreateBitmap;
                    } catch (Exception e) {
                        e = e;
                        bitmap = frameAtTime;
                        FileLog.e(e);
                        return bitmap;
                    }
                } catch (Exception e2) {
                    e = e2;
                }
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // android.os.AsyncTask
            public void onPostExecute(Bitmap bitmap) {
                if (isCancelled()) {
                    return;
                }
                SSHVideoCoverTimelinePlayView.this.frames.add(bitmap);
                SSHVideoCoverTimelinePlayView.this.invalidate();
                if (this.frameNum < SSHVideoCoverTimelinePlayView.this.framesToLoad) {
                    SSHVideoCoverTimelinePlayView.this.reloadFrames(this.frameNum + 1);
                }
            }
        };
        this.currentTask = asyncTask;
        asyncTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, Integer.valueOf(i), null, null);
    }

    public void loadCurrentFrameBitmap() {
        invalidate();
    }

    public void destroy() {
        MediaMetadataRetriever mediaMetadataRetriever;
        synchronized (sync) {
            try {
                mediaMetadataRetriever = this.mediaMetadataRetriever;
            } catch (Exception e) {
                FileLog.e(e);
            }
            if (mediaMetadataRetriever != null) {
                mediaMetadataRetriever.release();
                this.mediaMetadataRetriever = null;
            }
        }
        for (int i = 0; i < this.frames.size(); i++) {
            Bitmap bitmap = this.frames.get(i);
            if (bitmap != null) {
                bitmap.recycle();
            }
        }
        this.frames.clear();
        AsyncTask<Integer, Integer, Bitmap> asyncTask = this.currentTask;
        if (asyncTask != null) {
            asyncTask.cancel(true);
            this.currentTask = null;
        }
    }

    public void clearFrames() {
        for (int i = 0; i < this.frames.size(); i++) {
            Bitmap bitmap = this.frames.get(i);
            if (bitmap != null) {
                bitmap.recycle();
            }
        }
        this.frames.clear();
        AsyncTask<Integer, Integer, Bitmap> asyncTask = this.currentTask;
        if (asyncTask != null) {
            asyncTask.cancel(true);
            this.currentTask = null;
        }
        invalidate();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int size = View.MeasureSpec.getSize(i2);
        int size2 = View.MeasureSpec.getSize(i);
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(size2, 1073741824), View.MeasureSpec.makeMeasureSpec(size - size2, 1073741824));
        if (this.lastWidth != size2) {
            clearFrames();
            this.lastWidth = size2;
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        canvas.save();
        canvas.drawRect(this.startX, this.top, this.endX, this.bottom, this.paint3);
        canvas.clipRect(this.startX, this.top, this.endX, this.bottom);
        for (float f = 1.0f; f <= this.framesToLoad; f += 1.0f) {
            float fDp = AndroidUtilities.dp(16.0f) + (this.frameWidth * f);
            canvas.drawLine(fDp, this.top, fDp, this.frameHeight + r2, this.paint4);
        }
        if (this.frames.isEmpty() && this.currentTask == null) {
            reloadFrames(0);
        } else {
            for (int i = 0; i < this.frames.size(); i++) {
                Bitmap bitmap = this.frames.get(i);
                if (bitmap != null) {
                    canvas.drawBitmap(bitmap, this.startX + (this.frameWidth * i), this.top, this.paint2);
                }
            }
        }
        canvas.restore();
        if (this.textureViewToCopy != null) {
            canvas.save();
            int width = this.textureViewToCopy.getWidth();
            int height = this.textureViewToCopy.getHeight();
            this.scale = (this.frameHeight - (this.borderWidth * 2)) / Math.min(width, height);
            float f2 = this.startX + this.swipeX;
            int iRound = (int) (((this.frameHeight - (this.borderWidth * 2)) - Math.round(width * r2)) * this.offsetTranslateX);
            int iRound2 = (int) (((this.frameHeight - (this.borderWidth * 2)) - Math.round(height * this.scale)) * this.offsetTranslateY);
            Matrix matrix = this.scaleMatrix;
            float f3 = this.scale;
            float f4 = iRound + f2;
            int i2 = this.borderWidth;
            matrix.setScale(f3, f3, (int) (i2 + f4), this.top + iRound2 + i2);
            canvas.clipRect(f2, this.top, this.frameHeight + f2, this.bottom);
            canvas.setMatrix(this.scaleMatrix);
            int i3 = this.borderWidth;
            canvas.translate((int) (f4 + i3), this.top + iRound2 + i3);
            this.textureViewToCopy.draw(canvas);
            canvas.restore();
            canvas.save();
            canvas.drawRect(f2, this.top, (this.frameHeight + f2) - this.borderWidth, r0 + r2, this.paint);
            canvas.drawRect(f2, this.top, f2 + this.borderWidth, this.bottom, this.paint);
            int i4 = this.frameHeight;
            canvas.drawRect((i4 + f2) - this.borderWidth, this.top, f2 + i4, this.bottom, this.paint);
            canvas.drawRect(f2, r0 - r1, (this.frameHeight + f2) - this.borderWidth, this.bottom, this.paint);
            canvas.restore();
        }
    }
}
