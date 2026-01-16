package ir.eitaa.ui.Components;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.media.MediaMetadataRetriever;
import android.os.AsyncTask;
import android.os.Build;
import android.view.MotionEvent;
import android.view.View;
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.messenger.FileLog;
import ir.eitaa.messenger.R;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public class VideoTimelinePlayView extends View {
    public static int TYPE_LEFT = 0;
    public static int TYPE_PROGRESS = 2;
    public static int TYPE_RIGHT = 1;
    private static final Object sync = new Object();
    Paint bitmapPaint;
    private int currentMode;
    private AsyncTask<Integer, Integer, Bitmap> currentTask;
    private VideoTimelineViewDelegate delegate;
    private Drawable drawableLeft;
    private Drawable drawableRight;
    private ArrayList<android.graphics.Rect> exclusionRects;
    private android.graphics.Rect exclustionRect;
    private int frameHeight;
    private long frameTimeOffset;
    private int frameWidth;
    private ArrayList<BitmapFrame> frames;
    private int framesToLoad;
    private int lastWidth;
    private float maxProgressDiff;
    private MediaMetadataRetriever mediaMetadataRetriever;
    private float minProgressDiff;
    private Paint paint;
    private Paint paint2;
    private float playProgress;
    private float pressDx;
    private boolean pressedLeft;
    private boolean pressedPlay;
    private boolean pressedRight;
    private float progressLeft;
    private float progressRight;
    private RectF rect3;
    private long videoLength;

    public interface VideoTimelineViewDelegate {
        void didStartDragging(int type);

        void didStopDragging(int type);

        void onLeftProgressChanged(float progress);

        void onPlayProgressChanged(float progress);

        void onRightProgressChanged(float progress);
    }

    public VideoTimelinePlayView(Context context) throws Resources.NotFoundException {
        super(context);
        this.progressRight = 1.0f;
        this.playProgress = 0.5f;
        this.frames = new ArrayList<>();
        this.maxProgressDiff = 1.0f;
        this.minProgressDiff = 0.0f;
        this.rect3 = new RectF();
        this.currentMode = 0;
        this.bitmapPaint = new Paint();
        this.exclusionRects = new ArrayList<>();
        this.exclustionRect = new android.graphics.Rect();
        Paint paint = new Paint(1);
        this.paint = paint;
        paint.setColor(-1);
        Paint paint2 = new Paint();
        this.paint2 = paint2;
        paint2.setColor(2130706432);
        Drawable drawable = context.getResources().getDrawable(R.drawable.video_cropleft);
        this.drawableLeft = drawable;
        drawable.setColorFilter(new PorterDuffColorFilter(-16777216, PorterDuff.Mode.MULTIPLY));
        Drawable drawable2 = context.getResources().getDrawable(R.drawable.video_cropright);
        this.drawableRight = drawable2;
        drawable2.setColorFilter(new PorterDuffColorFilter(-16777216, PorterDuff.Mode.MULTIPLY));
        this.exclusionRects.add(this.exclustionRect);
    }

    public float getProgress() {
        return this.playProgress;
    }

    public float getLeftProgress() {
        return this.progressLeft;
    }

    public float getRightProgress() {
        return this.progressRight;
    }

    public void setMinProgressDiff(float value) {
        this.minProgressDiff = value;
    }

    public void setMode(int mode) {
        if (this.currentMode == mode) {
            return;
        }
        this.currentMode = mode;
        invalidate();
    }

    public void setMaxProgressDiff(float value) {
        this.maxProgressDiff = value;
        float f = this.progressRight;
        float f2 = this.progressLeft;
        if (f - f2 > value) {
            this.progressRight = f2 + value;
            invalidate();
        }
    }

    @Override // android.view.View
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        if (Build.VERSION.SDK_INT >= 29) {
            this.exclustionRect.set(left, 0, right, getMeasuredHeight());
            setSystemGestureExclusionRects(this.exclusionRects);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent event) {
        if (event == null) {
            return false;
        }
        float x = event.getX();
        float y = event.getY();
        int measuredWidth = getMeasuredWidth() - AndroidUtilities.dp(32.0f);
        float f = measuredWidth;
        int iDp = ((int) (this.progressLeft * f)) + AndroidUtilities.dp(16.0f);
        int iDp2 = ((int) (this.playProgress * f)) + AndroidUtilities.dp(16.0f);
        int iDp3 = ((int) (this.progressRight * f)) + AndroidUtilities.dp(16.0f);
        if (event.getAction() == 0) {
            getParent().requestDisallowInterceptTouchEvent(true);
            if (this.mediaMetadataRetriever == null) {
                return false;
            }
            int iDp4 = AndroidUtilities.dp(16.0f);
            int iDp5 = AndroidUtilities.dp(8.0f);
            if (iDp3 != iDp && iDp2 - iDp5 <= x && x <= iDp5 + iDp2 && y >= 0.0f && y <= getMeasuredHeight()) {
                VideoTimelineViewDelegate videoTimelineViewDelegate = this.delegate;
                if (videoTimelineViewDelegate != null) {
                    videoTimelineViewDelegate.didStartDragging(TYPE_PROGRESS);
                }
                this.pressedPlay = true;
                this.pressDx = (int) (x - iDp2);
                invalidate();
                return true;
            }
            if (iDp - iDp4 <= x && x <= Math.min(iDp + iDp4, iDp3) && y >= 0.0f && y <= getMeasuredHeight()) {
                VideoTimelineViewDelegate videoTimelineViewDelegate2 = this.delegate;
                if (videoTimelineViewDelegate2 != null) {
                    videoTimelineViewDelegate2.didStartDragging(TYPE_LEFT);
                }
                this.pressedLeft = true;
                this.pressDx = (int) (x - iDp);
                invalidate();
                return true;
            }
            if (iDp3 - iDp4 <= x && x <= iDp4 + iDp3 && y >= 0.0f && y <= getMeasuredHeight()) {
                VideoTimelineViewDelegate videoTimelineViewDelegate3 = this.delegate;
                if (videoTimelineViewDelegate3 != null) {
                    videoTimelineViewDelegate3.didStartDragging(TYPE_RIGHT);
                }
                this.pressedRight = true;
                this.pressDx = (int) (x - iDp3);
                invalidate();
                return true;
            }
            if (iDp <= x && x <= iDp3 && y >= 0.0f && y <= getMeasuredHeight()) {
                VideoTimelineViewDelegate videoTimelineViewDelegate4 = this.delegate;
                if (videoTimelineViewDelegate4 != null) {
                    videoTimelineViewDelegate4.didStartDragging(TYPE_PROGRESS);
                }
                this.pressedPlay = true;
                float fDp = (x - AndroidUtilities.dp(16.0f)) / f;
                this.playProgress = fDp;
                VideoTimelineViewDelegate videoTimelineViewDelegate5 = this.delegate;
                if (videoTimelineViewDelegate5 != null) {
                    videoTimelineViewDelegate5.onPlayProgressChanged(fDp);
                }
                this.pressDx = 0.0f;
                invalidate();
                return true;
            }
        } else if (event.getAction() == 1 || event.getAction() == 3) {
            if (this.pressedLeft) {
                VideoTimelineViewDelegate videoTimelineViewDelegate6 = this.delegate;
                if (videoTimelineViewDelegate6 != null) {
                    videoTimelineViewDelegate6.didStopDragging(TYPE_LEFT);
                }
                this.pressedLeft = false;
                return true;
            }
            if (this.pressedRight) {
                VideoTimelineViewDelegate videoTimelineViewDelegate7 = this.delegate;
                if (videoTimelineViewDelegate7 != null) {
                    videoTimelineViewDelegate7.didStopDragging(TYPE_RIGHT);
                }
                this.pressedRight = false;
                return true;
            }
            if (this.pressedPlay) {
                VideoTimelineViewDelegate videoTimelineViewDelegate8 = this.delegate;
                if (videoTimelineViewDelegate8 != null) {
                    videoTimelineViewDelegate8.didStopDragging(TYPE_PROGRESS);
                }
                this.pressedPlay = false;
            }
        } else if (event.getAction() == 2) {
            if (this.pressedPlay) {
                float fDp2 = (((int) (x - this.pressDx)) - AndroidUtilities.dp(16.0f)) / f;
                this.playProgress = fDp2;
                float f2 = this.progressLeft;
                if (fDp2 < f2) {
                    this.playProgress = f2;
                } else {
                    float f3 = this.progressRight;
                    if (fDp2 > f3) {
                        this.playProgress = f3;
                    }
                }
                VideoTimelineViewDelegate videoTimelineViewDelegate9 = this.delegate;
                if (videoTimelineViewDelegate9 != null) {
                    videoTimelineViewDelegate9.onPlayProgressChanged(this.playProgress);
                }
                invalidate();
                return true;
            }
            if (this.pressedLeft) {
                int i = (int) (x - this.pressDx);
                if (i < AndroidUtilities.dp(16.0f)) {
                    iDp3 = AndroidUtilities.dp(16.0f);
                } else if (i <= iDp3) {
                    iDp3 = i;
                }
                float fDp3 = (iDp3 - AndroidUtilities.dp(16.0f)) / f;
                this.progressLeft = fDp3;
                float f4 = this.progressRight;
                float f5 = f4 - fDp3;
                float f6 = this.maxProgressDiff;
                if (f5 > f6) {
                    this.progressRight = fDp3 + f6;
                } else {
                    float f7 = this.minProgressDiff;
                    if (f7 != 0.0f && f4 - fDp3 < f7) {
                        float f8 = f4 - f7;
                        this.progressLeft = f8;
                        if (f8 < 0.0f) {
                            this.progressLeft = 0.0f;
                        }
                    }
                }
                float f9 = this.progressLeft;
                float f10 = this.playProgress;
                if (f9 > f10) {
                    this.playProgress = f9;
                } else {
                    float f11 = this.progressRight;
                    if (f11 < f10) {
                        this.playProgress = f11;
                    }
                }
                VideoTimelineViewDelegate videoTimelineViewDelegate10 = this.delegate;
                if (videoTimelineViewDelegate10 != null) {
                    videoTimelineViewDelegate10.onLeftProgressChanged(f9);
                }
                invalidate();
                return true;
            }
            if (this.pressedRight) {
                int i2 = (int) (x - this.pressDx);
                if (i2 >= iDp) {
                    iDp = i2 > AndroidUtilities.dp(16.0f) + measuredWidth ? measuredWidth + AndroidUtilities.dp(16.0f) : i2;
                }
                float fDp4 = (iDp - AndroidUtilities.dp(16.0f)) / f;
                this.progressRight = fDp4;
                float f12 = this.progressLeft;
                float f13 = fDp4 - f12;
                float f14 = this.maxProgressDiff;
                if (f13 > f14) {
                    this.progressLeft = fDp4 - f14;
                } else {
                    float f15 = this.minProgressDiff;
                    if (f15 != 0.0f && fDp4 - f12 < f15) {
                        float f16 = f12 + f15;
                        this.progressRight = f16;
                        if (f16 > 1.0f) {
                            this.progressRight = 1.0f;
                        }
                    }
                }
                float f17 = this.progressLeft;
                float f18 = this.playProgress;
                if (f17 > f18) {
                    this.playProgress = f17;
                } else {
                    float f19 = this.progressRight;
                    if (f19 < f18) {
                        this.playProgress = f19;
                    }
                }
                VideoTimelineViewDelegate videoTimelineViewDelegate11 = this.delegate;
                if (videoTimelineViewDelegate11 != null) {
                    videoTimelineViewDelegate11.onRightProgressChanged(this.progressRight);
                }
                invalidate();
                return true;
            }
        }
        return true;
    }

    public void setVideoPath(String path, float left, float right) {
        destroy();
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        this.mediaMetadataRetriever = mediaMetadataRetriever;
        this.progressLeft = left;
        this.progressRight = right;
        try {
            mediaMetadataRetriever.setDataSource(path);
            this.videoLength = Long.parseLong(this.mediaMetadataRetriever.extractMetadata(9));
        } catch (Exception e) {
            FileLog.e(e);
        }
        invalidate();
    }

    public void setRightProgress(float value) {
        this.progressRight = value;
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

    public void setDelegate(VideoTimelineViewDelegate delegate) {
        this.delegate = delegate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reloadFrames(int frameNum) {
        if (this.mediaMetadataRetriever == null) {
            return;
        }
        if (frameNum == 0) {
            this.frameHeight = AndroidUtilities.dp(40.0f);
            this.framesToLoad = Math.max(1, (getMeasuredWidth() - AndroidUtilities.dp(16.0f)) / this.frameHeight);
            this.frameWidth = (int) Math.ceil((getMeasuredWidth() - AndroidUtilities.dp(16.0f)) / this.framesToLoad);
            this.frameTimeOffset = this.videoLength / this.framesToLoad;
        }
        AsyncTask<Integer, Integer, Bitmap> asyncTask = new AsyncTask<Integer, Integer, Bitmap>() { // from class: ir.eitaa.ui.Components.VideoTimelinePlayView.1
            private int frameNum = 0;

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // android.os.AsyncTask
            public Bitmap doInBackground(Integer... objects) {
                Bitmap frameAtTime;
                this.frameNum = objects[0].intValue();
                Bitmap bitmap = null;
                if (isCancelled()) {
                    return null;
                }
                try {
                    frameAtTime = VideoTimelinePlayView.this.mediaMetadataRetriever.getFrameAtTime(VideoTimelinePlayView.this.frameTimeOffset * this.frameNum * 1000, 2);
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
                    Bitmap bitmapCreateBitmap = Bitmap.createBitmap(VideoTimelinePlayView.this.frameWidth, VideoTimelinePlayView.this.frameHeight, frameAtTime.getConfig());
                    Canvas canvas = new Canvas(bitmapCreateBitmap);
                    float fMax = Math.max(VideoTimelinePlayView.this.frameWidth / frameAtTime.getWidth(), VideoTimelinePlayView.this.frameHeight / frameAtTime.getHeight());
                    int width = (int) (frameAtTime.getWidth() * fMax);
                    int height = (int) (frameAtTime.getHeight() * fMax);
                    canvas.drawBitmap(frameAtTime, new android.graphics.Rect(0, 0, frameAtTime.getWidth(), frameAtTime.getHeight()), new android.graphics.Rect((VideoTimelinePlayView.this.frameWidth - width) / 2, (VideoTimelinePlayView.this.frameHeight - height) / 2, width, height), (Paint) null);
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
                VideoTimelinePlayView.this.frames.add(new BitmapFrame(bitmap));
                VideoTimelinePlayView.this.invalidate();
                if (this.frameNum < VideoTimelinePlayView.this.framesToLoad) {
                    VideoTimelinePlayView.this.reloadFrames(this.frameNum + 1);
                }
            }
        };
        this.currentTask = asyncTask;
        asyncTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, Integer.valueOf(frameNum), null, null);
    }

    public void destroy() {
        Bitmap bitmap;
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
            BitmapFrame bitmapFrame = this.frames.get(i);
            if (bitmapFrame != null && (bitmap = bitmapFrame.bitmap) != null) {
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

    public void setProgress(float value) {
        this.playProgress = value;
        invalidate();
    }

    public void clearFrames() {
        for (int i = 0; i < this.frames.size(); i++) {
            BitmapFrame bitmapFrame = this.frames.get(i);
            if (bitmapFrame != null) {
                bitmapFrame.bitmap.recycle();
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
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int size = View.MeasureSpec.getSize(widthMeasureSpec);
        if (this.lastWidth != size) {
            clearFrames();
            this.lastWidth = size;
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        int measuredWidth = getMeasuredWidth() - AndroidUtilities.dp(32.0f);
        float f = measuredWidth;
        int iDp = ((int) (this.progressLeft * f)) + AndroidUtilities.dp(16.0f);
        int iDp2 = ((int) (this.progressRight * f)) + AndroidUtilities.dp(16.0f);
        canvas.save();
        canvas.clipRect(AndroidUtilities.dp(16.0f), AndroidUtilities.dp(4.0f), AndroidUtilities.dp(20.0f) + measuredWidth, AndroidUtilities.dp(48.0f));
        int i = 0;
        float f2 = 1.0f;
        if (this.frames.isEmpty() && this.currentTask == null) {
            reloadFrames(0);
        } else {
            int i2 = 0;
            while (i < this.frames.size()) {
                BitmapFrame bitmapFrame = this.frames.get(i);
                if (bitmapFrame.bitmap != null) {
                    int iDp3 = AndroidUtilities.dp(16.0f) + (this.frameWidth * i2);
                    int iDp4 = AndroidUtilities.dp(6.0f);
                    float f3 = bitmapFrame.alpha;
                    if (f3 != f2) {
                        float f4 = f3 + 0.16f;
                        bitmapFrame.alpha = f4;
                        if (f4 > f2) {
                            bitmapFrame.alpha = f2;
                        } else {
                            invalidate();
                        }
                        this.bitmapPaint.setAlpha((int) (bitmapFrame.alpha * 255.0f));
                        canvas.drawBitmap(bitmapFrame.bitmap, iDp3, iDp4, this.bitmapPaint);
                    } else {
                        canvas.drawBitmap(bitmapFrame.bitmap, iDp3, iDp4, (Paint) null);
                    }
                }
                i2++;
                i++;
                f2 = 1.0f;
            }
        }
        int iDp5 = AndroidUtilities.dp(6.0f);
        int iDp6 = AndroidUtilities.dp(48.0f);
        float f5 = iDp5;
        float f6 = iDp;
        canvas.drawRect(AndroidUtilities.dp(16.0f), f5, f6, AndroidUtilities.dp(46.0f), this.paint2);
        canvas.drawRect(AndroidUtilities.dp(4.0f) + iDp2, f5, AndroidUtilities.dp(16.0f) + measuredWidth + AndroidUtilities.dp(4.0f), AndroidUtilities.dp(46.0f), this.paint2);
        float f7 = iDp6;
        canvas.drawRect(f6, AndroidUtilities.dp(4.0f), AndroidUtilities.dp(2.0f) + iDp, f7, this.paint);
        canvas.drawRect(AndroidUtilities.dp(2.0f) + iDp2, AndroidUtilities.dp(4.0f), AndroidUtilities.dp(4.0f) + iDp2, f7, this.paint);
        canvas.drawRect(AndroidUtilities.dp(2.0f) + iDp, AndroidUtilities.dp(4.0f), AndroidUtilities.dp(4.0f) + iDp2, f5, this.paint);
        canvas.drawRect(AndroidUtilities.dp(2.0f) + iDp, iDp6 - AndroidUtilities.dp(2.0f), AndroidUtilities.dp(4.0f) + iDp2, f7, this.paint);
        canvas.restore();
        this.rect3.set(iDp - AndroidUtilities.dp(8.0f), AndroidUtilities.dp(4.0f), AndroidUtilities.dp(2.0f) + iDp, f7);
        canvas.drawRoundRect(this.rect3, AndroidUtilities.dp(2.0f), AndroidUtilities.dp(2.0f), this.paint);
        this.drawableLeft.setBounds(iDp - AndroidUtilities.dp(8.0f), AndroidUtilities.dp(4.0f) + ((AndroidUtilities.dp(44.0f) - AndroidUtilities.dp(18.0f)) / 2), iDp + AndroidUtilities.dp(2.0f), ((AndroidUtilities.dp(44.0f) - AndroidUtilities.dp(18.0f)) / 2) + AndroidUtilities.dp(22.0f));
        this.drawableLeft.draw(canvas);
        this.rect3.set(AndroidUtilities.dp(2.0f) + iDp2, AndroidUtilities.dp(4.0f), AndroidUtilities.dp(12.0f) + iDp2, f7);
        canvas.drawRoundRect(this.rect3, AndroidUtilities.dp(2.0f), AndroidUtilities.dp(2.0f), this.paint);
        this.drawableRight.setBounds(AndroidUtilities.dp(2.0f) + iDp2, AndroidUtilities.dp(4.0f) + ((AndroidUtilities.dp(44.0f) - AndroidUtilities.dp(18.0f)) / 2), iDp2 + AndroidUtilities.dp(12.0f), ((AndroidUtilities.dp(44.0f) - AndroidUtilities.dp(18.0f)) / 2) + AndroidUtilities.dp(22.0f));
        this.drawableRight.draw(canvas);
        float fDp = AndroidUtilities.dp(18.0f) + (f * this.playProgress);
        this.rect3.set(fDp - AndroidUtilities.dp(1.5f), AndroidUtilities.dp(2.0f), AndroidUtilities.dp(1.5f) + fDp, AndroidUtilities.dp(50.0f));
        canvas.drawRoundRect(this.rect3, AndroidUtilities.dp(1.0f), AndroidUtilities.dp(1.0f), this.paint2);
        canvas.drawCircle(fDp, AndroidUtilities.dp(52.0f), AndroidUtilities.dp(3.5f), this.paint2);
        this.rect3.set(fDp - AndroidUtilities.dp(1.0f), AndroidUtilities.dp(2.0f), AndroidUtilities.dp(1.0f) + fDp, AndroidUtilities.dp(50.0f));
        canvas.drawRoundRect(this.rect3, AndroidUtilities.dp(1.0f), AndroidUtilities.dp(1.0f), this.paint);
        canvas.drawCircle(fDp, AndroidUtilities.dp(52.0f), AndroidUtilities.dp(3.0f), this.paint);
    }

    private static class BitmapFrame {
        float alpha;
        Bitmap bitmap;

        public BitmapFrame(Bitmap bitmap) {
            this.bitmap = bitmap;
        }
    }
}
