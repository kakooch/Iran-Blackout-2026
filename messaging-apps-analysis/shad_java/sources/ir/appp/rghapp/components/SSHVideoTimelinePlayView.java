package ir.appp.rghapp.components;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.media.MediaMetadataRetriever;
import android.os.AsyncTask;
import android.text.TextPaint;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.DecelerateInterpolator;
import android.widget.Scroller;
import com.facebook.stetho.websocket.CloseCodes;
import java.util.ArrayList;
import java.util.Locale;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.messenger.FileLog;

/* loaded from: classes3.dex */
public class SSHVideoTimelinePlayView extends View {
    public static int TYPE_LEFT = 0;
    public static int TYPE_PROGRESS = 2;
    public static int TYPE_RIGHT = 1;
    private static final Object sync = new Object();
    private int allFramesToLoad;
    private int currentAlpha;
    private AsyncTask<Integer, Integer, Bitmap> currentTask;
    private VideoTimelineViewDelegate delegate;
    private float floatingX;
    private int frameHeight;
    private long frameTimeOffset;
    private int frameWidth;
    private ArrayList<Bitmap> frames;
    private int framesToLoad;
    private float gapLength;
    private int gapOffset;
    private boolean isFlinging;
    boolean isPlaying;
    private int lastWidth;
    private Scroller mFlingScroller;
    private int mMinimumFlingVelocity;
    private int mPreviousScrollerX;
    private VelocityTracker mVelocityTracker;
    private float maxProgressDiff;
    private float maxVideoShowInScreen;
    private MediaMetadataRetriever mediaMetadataRetriever;
    int midWidth;
    private float minProgressDiff;
    private Paint paint;
    private Paint paint2;
    private Paint paint3;
    private Paint paint4;
    private Paint paint5;
    private Paint paint6;
    private float playProgress;
    private float playProgressActual;
    private float pressDx;
    private boolean pressedLeft;
    private boolean pressedPlay;
    private boolean pressedRight;
    private float progressLeft;
    private float progressLeftActual;
    private float progressRight;
    private float progressRightActual;
    private int swipeX;
    private TextPaint textPaint;
    private int textWidth;
    float totalVideoLength;
    private float totalWidth;
    private long videoLength;
    private float x1;

    public interface VideoTimelineViewDelegate {
        void didStartDragging(int i);

        void didStartFling();

        void didStopDragging(int i);

        void didStopFling(float f, float f2, float f3, int i);

        void onLeftProgressChanged(float f);

        void onPlayProgressChanged(float f, float f2, float f3, int i);

        void onRightProgressChanged(float f);
    }

    public SSHVideoTimelinePlayView(Context context) {
        super(context);
        this.progressRight = 1.0f;
        this.progressRightActual = 1.0f;
        this.playProgress = 0.0f;
        this.playProgressActual = 0.0f;
        this.frames = new ArrayList<>();
        this.maxProgressDiff = 1.0f;
        this.maxVideoShowInScreen = 60000.0f;
        this.totalWidth = 0.0f;
        this.minProgressDiff = 0.0f;
        this.isFlinging = false;
        this.currentAlpha = 0;
        Paint paint = new Paint(1);
        this.paint = paint;
        paint.setColor(-1);
        Paint paint2 = new Paint();
        this.paint2 = paint2;
        paint2.setColor(-654311424);
        Paint paint3 = new Paint(1);
        this.paint3 = paint3;
        paint3.setColor(-16738826);
        Paint paint4 = new Paint();
        this.paint4 = paint4;
        paint4.setColor(-6710887);
        Paint paint5 = new Paint(1);
        this.paint5 = paint5;
        paint5.setColor(-1);
        this.paint5.setShadowLayer(AndroidUtilities.dp(2.0f), 0.0f, 0.0f, -12303292);
        Paint paint6 = new Paint();
        this.paint6 = paint6;
        paint6.setColor(-16777216);
        TextPaint textPaint = new TextPaint(1);
        this.textPaint = textPaint;
        textPaint.setColor(-6710887);
        this.textPaint.setTextSize(AndroidUtilities.dp(12.0f));
        this.mFlingScroller = new Scroller(getContext(), new DecelerateInterpolator(5.0f), true);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        this.mMinimumFlingVelocity = viewConfiguration.getScaledMinimumFlingVelocity();
        int scaledMaximumFlingVelocity = viewConfiguration.getScaledMaximumFlingVelocity() / 8;
    }

    public static String formatDurationNoHours(int i) {
        int i2 = i / 60;
        int i3 = i % 60;
        return i2 == 0 ? String.format(Locale.US, ":%02d", Integer.valueOf(i3)) : String.format(Locale.US, "%d:%02d", Integer.valueOf(i2), Integer.valueOf(i3));
    }

    public float getProgress() {
        return this.playProgress;
    }

    public void setProgress(float f) {
        float f2 = -this.swipeX;
        float f3 = this.totalVideoLength;
        this.playProgress = ((f - (f2 / f3)) * f3) / this.midWidth;
        invalidate();
    }

    public float getLeftProgress() {
        return this.progressLeftActual;
    }

    public float getRightProgress() {
        return this.progressRightActual;
    }

    public int getSwipeX() {
        return this.swipeX;
    }

    public void setRightProgress(float f) {
        this.progressRight = f;
        VideoTimelineViewDelegate videoTimelineViewDelegate = this.delegate;
        if (videoTimelineViewDelegate != null) {
            videoTimelineViewDelegate.didStartDragging(TYPE_RIGHT);
        }
        VideoTimelineViewDelegate videoTimelineViewDelegate2 = this.delegate;
        if (videoTimelineViewDelegate2 != null) {
            videoTimelineViewDelegate2.onRightProgressChanged(this.progressRight);
        }
        VideoTimelineViewDelegate videoTimelineViewDelegate3 = this.delegate;
        if (videoTimelineViewDelegate3 != null) {
            videoTimelineViewDelegate3.didStopDragging(TYPE_RIGHT);
        }
        invalidate();
    }

    public void setMinProgressDiff(float f) {
        this.minProgressDiff = f;
    }

    public void setMaxProgressDiff(float f) {
        this.maxProgressDiff = f;
        float f2 = this.progressRight;
        float f3 = this.progressLeft;
        if (f2 - f3 > f) {
            this.progressRight = f3 + f;
            invalidate();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:121:0x0238  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x023c  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x0266  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onTouchEvent(android.view.MotionEvent r22) {
        /*
            Method dump skipped, instructions count: 872
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.appp.rghapp.components.SSHVideoTimelinePlayView.onTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.videoLength <= 60000) {
            return;
        }
        this.mFlingScroller.computeScrollOffset();
        int currX = this.mFlingScroller.getCurrX();
        if (this.mPreviousScrollerX == 0) {
            this.mPreviousScrollerX = this.mFlingScroller.getStartX();
        }
        scrollBy(currX - this.mPreviousScrollerX, 0);
        this.mPreviousScrollerX = currX;
        if (!this.mFlingScroller.isFinished()) {
            this.isFlinging = true;
            this.delegate.didStartFling();
            invalidate();
            return;
        }
        if (this.isFlinging) {
            this.isFlinging = false;
            int i = this.midWidth;
            float f = this.progressLeft;
            int i2 = this.swipeX;
            float f2 = this.totalVideoLength;
            float f3 = (((i * f) + (-i2)) / f2) + this.playProgress;
            this.playProgressActual = f3;
            float f4 = ((i * f) + (-i2)) / f2;
            this.progressLeftActual = f4;
            float f5 = ((i * this.progressRight) + (-i2)) / f2;
            this.progressRightActual = f5;
            VideoTimelineViewDelegate videoTimelineViewDelegate = this.delegate;
            if (videoTimelineViewDelegate != null) {
                videoTimelineViewDelegate.didStopFling(f4, f5, f3, i2);
            }
        }
    }

    @Override // android.view.View
    public void scrollBy(int i, int i2) {
        if (this.videoLength <= 60000) {
            return;
        }
        int i3 = this.swipeX + i;
        this.swipeX = i3;
        if (i3 > 0) {
            this.swipeX = 0;
            this.mFlingScroller.forceFinished(true);
        }
        int iDp = (int) (((this.videoLength / 1000.0f) * this.gapLength) + AndroidUtilities.dp(32.0f));
        if (Math.abs(this.swipeX) + getMeasuredWidth() > iDp) {
            this.swipeX = -(iDp - getMeasuredWidth());
            this.mFlingScroller.forceFinished(true);
        }
    }

    public void setVideoPath(String str, float f, float f2, int i) throws IllegalArgumentException {
        destroy();
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        this.mediaMetadataRetriever = mediaMetadataRetriever;
        this.currentAlpha = 0;
        this.swipeX = i;
        try {
            mediaMetadataRetriever.setDataSource(str);
            long j = ((int) (Long.parseLong(this.mediaMetadataRetriever.extractMetadata(9)) / 1000.0f)) * CloseCodes.NORMAL_CLOSURE;
            this.videoLength = j;
            this.gapOffset = ((float) j) <= 30000.0f ? 5 : 10;
            this.maxVideoShowInScreen = 60000.0f;
            if (j < 60000.0f) {
                float f3 = 15000.0f;
                while (true) {
                    if (f3 >= 60000.0f) {
                        break;
                    }
                    if (this.videoLength <= f3) {
                        this.maxVideoShowInScreen = f3;
                        break;
                    }
                    f3 += 2000.0f;
                }
            }
            float fDp = AndroidUtilities.displayMetrics.widthPixels - AndroidUtilities.dp(32.0f);
            float f4 = this.maxVideoShowInScreen;
            float f5 = fDp / (f4 / 1000.0f);
            this.gapLength = f5;
            long j2 = this.videoLength;
            float f6 = (j2 / 1000.0f) * f5;
            this.totalVideoLength = f6;
            if (j2 >= 60000) {
                f6 = f5 * 60.0f;
            }
            this.midWidth = (int) f6;
            this.totalWidth = (j2 * fDp) / f4;
            this.frameHeight = AndroidUtilities.dp(88.0f);
            int iDp = AndroidUtilities.dp(40.0f);
            this.frameWidth = iDp;
            this.allFramesToLoad = Math.max(1, ((int) this.totalWidth) / iDp);
            int iMax = Math.max(1, (int) Math.ceil(fDp / this.frameWidth));
            this.framesToLoad = iMax;
            int i2 = this.allFramesToLoad;
            if (iMax > i2) {
                this.framesToLoad = i2;
            }
            long j3 = this.videoLength;
            this.frameTimeOffset = j3 / i2;
            if (f == 0.0f) {
                this.progressLeftActual = f;
                this.progressLeft = f;
            } else {
                this.progressLeftActual = f;
                this.progressLeft = ((f * this.totalVideoLength) - (-i)) / this.midWidth;
            }
            if (f2 != 0.0f) {
                this.progressRightActual = f2;
                this.progressRight = ((f2 * this.totalVideoLength) - (-i)) / this.midWidth;
            } else if (j3 <= 60000) {
                this.progressRightActual = 1.0f;
                this.progressRight = 1.0f;
            } else {
                this.progressRight = 1.0f;
                this.progressRightActual = 60000.0f / j3;
            }
        } catch (Exception e) {
            FileLog.e(e);
        }
        invalidate();
    }

    public void setDelegate(VideoTimelineViewDelegate videoTimelineViewDelegate) {
        this.delegate = videoTimelineViewDelegate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reloadFrames(int i) {
        if (this.mediaMetadataRetriever == null) {
            return;
        }
        AsyncTask<Integer, Integer, Bitmap> asyncTask = new AsyncTask<Integer, Integer, Bitmap>() { // from class: ir.appp.rghapp.components.SSHVideoTimelinePlayView.1
            private int frameNum = 0;

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // android.os.AsyncTask
            public Bitmap doInBackground(Integer... numArr) {
                Bitmap frameAtTime;
                this.frameNum = numArr[0].intValue();
                Bitmap bitmap = null;
                if (isCancelled()) {
                    return null;
                }
                try {
                    frameAtTime = SSHVideoTimelinePlayView.this.mediaMetadataRetriever.getFrameAtTime(SSHVideoTimelinePlayView.this.frameTimeOffset * this.frameNum * 1000, 2);
                } catch (Exception e) {
                    e = e;
                }
                try {
                    if (isCancelled()) {
                        return null;
                    }
                    if (frameAtTime == null) {
                        return frameAtTime;
                    }
                    Bitmap bitmapCreateBitmap = Bitmap.createBitmap(SSHVideoTimelinePlayView.this.frameWidth, SSHVideoTimelinePlayView.this.frameHeight, frameAtTime.getConfig());
                    Canvas canvas = new Canvas(bitmapCreateBitmap);
                    float fMax = Math.max(SSHVideoTimelinePlayView.this.frameWidth / frameAtTime.getWidth(), SSHVideoTimelinePlayView.this.frameHeight / frameAtTime.getHeight());
                    int width = (int) (frameAtTime.getWidth() * fMax);
                    int height = (int) (frameAtTime.getHeight() * fMax);
                    Rect rect = new Rect(0, 0, frameAtTime.getWidth(), frameAtTime.getHeight());
                    int i2 = (SSHVideoTimelinePlayView.this.frameWidth - width) / 2;
                    int i3 = (SSHVideoTimelinePlayView.this.frameHeight - height) / 2;
                    canvas.drawBitmap(frameAtTime, rect, new Rect(i2, i3, width + i2, height + i3), (Paint) null);
                    frameAtTime.recycle();
                    return bitmapCreateBitmap;
                } catch (Exception e2) {
                    e = e2;
                    bitmap = frameAtTime;
                    FileLog.e(e);
                    return bitmap;
                }
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // android.os.AsyncTask
            public void onPostExecute(Bitmap bitmap) {
                if (isCancelled()) {
                    return;
                }
                SSHVideoTimelinePlayView.this.frames.add(bitmap);
                SSHVideoTimelinePlayView.this.invalidate();
                if (this.frameNum < SSHVideoTimelinePlayView.this.allFramesToLoad) {
                    SSHVideoTimelinePlayView.this.reloadFrames(this.frameNum + 1);
                }
            }
        };
        this.currentTask = asyncTask;
        asyncTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, Integer.valueOf(i), null, null);
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

    public boolean isDragging() {
        return this.pressedPlay;
    }

    public void isPlaying(boolean z) {
        this.isPlaying = z;
        if (z) {
            this.currentAlpha = 0;
        } else {
            this.currentAlpha = 255;
            invalidate();
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
        int i;
        int i2;
        float fDp = this.totalVideoLength + AndroidUtilities.dp(16.0f);
        int iDp = ((int) (this.midWidth * this.progressLeft)) + AndroidUtilities.dp(16.0f);
        int iDp2 = ((int) (this.midWidth * this.progressRight)) + AndroidUtilities.dp(16.0f);
        int iDp3 = AndroidUtilities.dp(2.0f);
        int measuredHeight = getMeasuredHeight();
        int iDp4 = AndroidUtilities.dp(90.0f);
        canvas.save();
        float f = iDp3;
        canvas.clipRect(0.0f, f, fDp, this.frameHeight + iDp3);
        canvas.drawColor(-7829368);
        float f2 = 0.0f;
        while (f2 <= this.allFramesToLoad) {
            float fDp2 = AndroidUtilities.dp(16.0f) + (this.frameWidth * f2);
            canvas.drawLine(fDp2, f, fDp2, this.frameHeight + iDp3, this.paint6);
            f2 += 1.0f;
            f = f;
        }
        float f3 = f;
        canvas.restore();
        canvas.save();
        canvas.clipRect(0.0f, 0.0f, this.totalVideoLength + AndroidUtilities.dp(16.0f), getMeasuredHeight());
        if (this.frames.isEmpty() && this.currentTask == null) {
            reloadFrames(0);
        } else {
            int i3 = 0;
            for (int i4 = 0; i4 < this.frames.size(); i4++) {
                Bitmap bitmap = this.frames.get(i4);
                if (bitmap != null) {
                    canvas.drawBitmap(bitmap, AndroidUtilities.dp(16.0f) + (this.frameWidth * i3) + this.swipeX, f3, (Paint) null);
                }
                i3++;
            }
        }
        float fDp3 = AndroidUtilities.dp(16.0f) + (this.midWidth * this.playProgress);
        if (this.pressedRight || this.pressedLeft) {
            i = measuredHeight;
        } else if (!this.isPlaying) {
            int i5 = this.currentAlpha;
            if (i5 < 0 || i5 >= 255) {
                i = measuredHeight;
                if (i5 < 510) {
                    this.paint5.setAlpha(510 - i5);
                    canvas.drawRect(fDp3 - AndroidUtilities.dp(1.0f), f3, fDp3 + AndroidUtilities.dp(1.0f), iDp4, this.paint5);
                    this.currentAlpha += 25;
                    postInvalidateDelayed(15L);
                }
            } else {
                this.paint5.setAlpha(i5);
                i = measuredHeight;
                canvas.drawRect(fDp3 - AndroidUtilities.dp(1.0f), f3, fDp3 + AndroidUtilities.dp(1.0f), iDp4, this.paint5);
                this.currentAlpha += 25;
                postInvalidateDelayed(15L);
            }
        } else {
            i = measuredHeight;
            int i6 = this.currentAlpha;
            if (i6 < 255) {
                this.paint5.setAlpha(i6);
                canvas.drawRect(fDp3 - AndroidUtilities.dp(1.0f), f3, fDp3 + AndroidUtilities.dp(1.0f), iDp4, this.paint5);
                this.currentAlpha += 25;
                postInvalidateDelayed(15L);
            } else {
                this.currentAlpha = 255;
                this.paint5.setAlpha(255);
                canvas.drawRect(fDp3 - AndroidUtilities.dp(1.0f), f3, fDp3 + AndroidUtilities.dp(1.0f), iDp4, this.paint5);
            }
        }
        float f4 = iDp;
        float f5 = iDp2;
        canvas.drawRect(f4, 0.0f, f5, f3, this.paint3);
        canvas.restore();
        float f6 = iDp4;
        canvas.drawRect(0.0f, 0.0f, f4, f6, this.paint2);
        canvas.drawRect(iDp2 - AndroidUtilities.dp(2.0f), 0.0f, getMeasuredWidth(), f6, this.paint2);
        canvas.drawRect(iDp2 - AndroidUtilities.dp(2.0f), 0.0f, f5, f6, this.paint);
        canvas.drawRect(iDp - AndroidUtilities.dp(1.0f), 0.0f, iDp + AndroidUtilities.dp(1.0f), f6, this.paint);
        float f7 = f6 / 2.0f;
        canvas.drawCircle(f4, f7, AndroidUtilities.dp(10.0f), this.paint);
        canvas.drawCircle(f5, f7, AndroidUtilities.dp(10.0f), this.paint);
        int i7 = 0;
        while (true) {
            int i8 = i7 + 1;
            String durationNoHours = formatDurationNoHours(i7);
            this.textWidth = (int) Math.ceil(this.textPaint.measureText(durationNoHours));
            float fDp4 = this.swipeX + AndroidUtilities.dp(16.0f) + (i7 * this.gapLength);
            if (fDp4 > getMeasuredWidth()) {
                return;
            }
            if ((this.textWidth / 2.0f) + fDp4 <= 0.0f) {
                i2 = i;
            } else if (i7 % this.gapOffset == 0) {
                i2 = i;
                float f8 = i2;
                canvas.drawRect(fDp4 - 2.0f, f8 - ((i2 - AndroidUtilities.dp(90.0f)) / 2.0f), fDp4, f8, this.paint4);
                canvas.drawText(durationNoHours, fDp4 - (this.textWidth / 2.0f), (i2 - AndroidUtilities.dp(4.0f)) - ((i2 - AndroidUtilities.dp(90.0f)) / 2.0f), this.textPaint);
            } else {
                i2 = i;
                float f9 = i2;
                canvas.drawRect(fDp4 - 1.0f, f9 - ((i2 - AndroidUtilities.dp(90.0f)) / 4.0f), fDp4, f9, this.paint4);
            }
            i = i2;
            i7 = i8;
        }
    }
}
