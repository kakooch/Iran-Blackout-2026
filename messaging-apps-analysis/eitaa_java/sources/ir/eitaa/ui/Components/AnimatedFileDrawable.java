package ir.eitaa.ui.Components;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.messenger.AnimatedFileDrawableStream;
import ir.eitaa.messenger.DispatchQueue;
import ir.eitaa.messenger.FileLoader;
import ir.eitaa.messenger.FileLog;
import ir.eitaa.messenger.ImageLocation;
import ir.eitaa.tgnet.TLRPC$Document;
import java.io.File;
import java.util.ArrayList;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes3.dex */
public class AnimatedFileDrawable extends BitmapDrawable implements Animatable {
    private RectF actualDrawRect;
    private boolean applyTransformation;
    private Bitmap backgroundBitmap;
    private int backgroundBitmapTime;
    private BitmapShader backgroundShader;
    private int currentAccount;
    private DispatchQueue decodeQueue;
    private boolean decodeSingleFrame;
    private boolean decoderCreated;
    private boolean destroyWhenDone;
    private final android.graphics.Rect dstRect;
    private float endTime;
    private boolean forceDecodeAfterNextFrame;
    private int invalidateAfter;
    private boolean invalidateParentViewWithSecond;
    private boolean invalidatePath;
    private volatile boolean isRecycled;
    private volatile boolean isRunning;
    private long lastFrameDecodeTime;
    private long lastFrameTime;
    private int lastTimeStamp;
    private Runnable loadFrameRunnable;
    private Runnable loadFrameTask;
    protected final Runnable mInvalidateTask;
    private final Runnable mStartTask;
    private final int[] metaData;
    public volatile long nativePtr;
    private Bitmap nextRenderingBitmap;
    private int nextRenderingBitmapTime;
    private BitmapShader nextRenderingShader;
    private View parentView;
    private File path;
    private boolean pendingRemoveLoading;
    private int pendingRemoveLoadingFramesReset;
    private volatile long pendingSeekTo;
    private volatile long pendingSeekToUI;
    private boolean recycleWithSecond;
    private Bitmap renderingBitmap;
    private int renderingBitmapTime;
    private int renderingHeight;
    private BitmapShader renderingShader;
    private int renderingWidth;
    private Path roundPath;
    private int[] roundRadius;
    private int[] roundRadiusBackup;
    private float scaleFactor;
    private float scaleX;
    private float scaleY;
    private ArrayList<View> secondParentViews;
    private Matrix shaderMatrix;
    private boolean singleFrameDecoded;
    private float startTime;
    private AnimatedFileDrawableStream stream;
    private long streamFileSize;
    private final Object sync;
    private Runnable uiRunnable;
    private Runnable uiRunnableNoFrame;
    private boolean useSharedQueue;
    private static float[] radii = new float[8];
    private static final Handler uiHandler = new Handler(Looper.getMainLooper());
    private static ScheduledThreadPoolExecutor executor = new ScheduledThreadPoolExecutor(2, new ThreadPoolExecutor.DiscardPolicy());

    /* JADX INFO: Access modifiers changed from: private */
    public static native long createDecoder(String src, int[] params, int account, long streamFileSize, Object readCallback, boolean preview);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void destroyDecoder(long ptr);

    private static native int getFrameAtTime(long ptr, long ms, Bitmap bitmap, int[] data, int stride);

    /* JADX INFO: Access modifiers changed from: private */
    public static native int getVideoFrame(long ptr, Bitmap bitmap, int[] params, int stride, boolean preview, float startTimeSeconds, float endTimeSeconds);

    private static native void getVideoInfo(int sdkVersion, String src, int[] params);

    private static native void prepareToSeek(long ptr);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void seekToMs(long ptr, long ms, boolean precise);

    private static native void stopDecoder(long ptr);

    @Override // android.graphics.drawable.BitmapDrawable, android.graphics.drawable.Drawable
    public int getOpacity() {
        return -2;
    }

    static /* synthetic */ int access$1010(AnimatedFileDrawable animatedFileDrawable) {
        int i = animatedFileDrawable.pendingRemoveLoadingFramesReset;
        animatedFileDrawable.pendingRemoveLoadingFramesReset = i - 1;
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$new$0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$new$0$AnimatedFileDrawable() {
        View view;
        if (!this.secondParentViews.isEmpty()) {
            int size = this.secondParentViews.size();
            for (int i = 0; i < size; i++) {
                this.secondParentViews.get(i).invalidate();
            }
        }
        if ((this.secondParentViews.isEmpty() || this.invalidateParentViewWithSecond) && (view = this.parentView) != null) {
            view.invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$new$1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$new$1$AnimatedFileDrawable() {
        View view;
        if (!this.secondParentViews.isEmpty()) {
            int size = this.secondParentViews.size();
            for (int i = 0; i < size; i++) {
                this.secondParentViews.get(i).invalidate();
            }
        }
        if ((this.secondParentViews.isEmpty() || this.invalidateParentViewWithSecond) && (view = this.parentView) != null) {
            view.invalidate();
        }
    }

    public AnimatedFileDrawable(File file, boolean createDecoder, long streamSize, TLRPC$Document document, ImageLocation location, Object parentObject, long seekTo, int account, boolean preview) {
        this(file, createDecoder, streamSize, document, location, parentObject, seekTo, account, preview, 0, 0);
    }

    public AnimatedFileDrawable(File file, boolean createDecoder, long streamSize, TLRPC$Document document, ImageLocation location, Object parentObject, long seekTo, int account, boolean preview, int w, int h) {
        long j;
        int i;
        this.invalidateAfter = 50;
        int[] iArr = new int[5];
        this.metaData = iArr;
        this.pendingSeekTo = -1L;
        this.pendingSeekToUI = -1L;
        this.sync = new Object();
        this.actualDrawRect = new RectF();
        this.roundRadius = new int[4];
        this.shaderMatrix = new Matrix();
        this.roundPath = new Path();
        this.scaleX = 1.0f;
        this.scaleY = 1.0f;
        this.dstRect = new android.graphics.Rect();
        this.scaleFactor = 1.0f;
        this.secondParentViews = new ArrayList<>();
        this.invalidatePath = true;
        this.mInvalidateTask = new Runnable() { // from class: ir.eitaa.ui.Components.-$$Lambda$AnimatedFileDrawable$dcb0vzPZcF22uaO1dUfLP7uYSdc
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$new$0$AnimatedFileDrawable();
            }
        };
        this.uiRunnableNoFrame = new Runnable() { // from class: ir.eitaa.ui.Components.AnimatedFileDrawable.1
            @Override // java.lang.Runnable
            public void run() throws InterruptedException {
                if (AnimatedFileDrawable.this.destroyWhenDone && AnimatedFileDrawable.this.nativePtr != 0) {
                    AnimatedFileDrawable.destroyDecoder(AnimatedFileDrawable.this.nativePtr);
                    AnimatedFileDrawable.this.nativePtr = 0L;
                }
                if (AnimatedFileDrawable.this.nativePtr == 0) {
                    if (AnimatedFileDrawable.this.renderingBitmap != null) {
                        AnimatedFileDrawable.this.renderingBitmap.recycle();
                        AnimatedFileDrawable.this.renderingBitmap = null;
                    }
                    if (AnimatedFileDrawable.this.backgroundBitmap != null) {
                        AnimatedFileDrawable.this.backgroundBitmap.recycle();
                        AnimatedFileDrawable.this.backgroundBitmap = null;
                    }
                    if (AnimatedFileDrawable.this.decodeQueue != null) {
                        AnimatedFileDrawable.this.decodeQueue.recycle();
                        AnimatedFileDrawable.this.decodeQueue = null;
                        return;
                    }
                    return;
                }
                AnimatedFileDrawable.this.loadFrameTask = null;
                AnimatedFileDrawable.this.scheduleNextGetFrame();
            }
        };
        this.uiRunnable = new Runnable() { // from class: ir.eitaa.ui.Components.AnimatedFileDrawable.2
            @Override // java.lang.Runnable
            public void run() throws InterruptedException {
                if (AnimatedFileDrawable.this.destroyWhenDone && AnimatedFileDrawable.this.nativePtr != 0) {
                    AnimatedFileDrawable.destroyDecoder(AnimatedFileDrawable.this.nativePtr);
                    AnimatedFileDrawable.this.nativePtr = 0L;
                }
                if (AnimatedFileDrawable.this.nativePtr == 0) {
                    if (AnimatedFileDrawable.this.renderingBitmap != null) {
                        AnimatedFileDrawable.this.renderingBitmap.recycle();
                        AnimatedFileDrawable.this.renderingBitmap = null;
                    }
                    if (AnimatedFileDrawable.this.backgroundBitmap != null) {
                        AnimatedFileDrawable.this.backgroundBitmap.recycle();
                        AnimatedFileDrawable.this.backgroundBitmap = null;
                    }
                    if (AnimatedFileDrawable.this.decodeQueue != null) {
                        AnimatedFileDrawable.this.decodeQueue.recycle();
                        AnimatedFileDrawable.this.decodeQueue = null;
                        return;
                    }
                    return;
                }
                if (AnimatedFileDrawable.this.stream != null && AnimatedFileDrawable.this.pendingRemoveLoading) {
                    FileLoader.getInstance(AnimatedFileDrawable.this.currentAccount).removeLoadingVideo(AnimatedFileDrawable.this.stream.getDocument(), false, false);
                }
                if (AnimatedFileDrawable.this.pendingRemoveLoadingFramesReset <= 0) {
                    AnimatedFileDrawable.this.pendingRemoveLoading = true;
                } else {
                    AnimatedFileDrawable.access$1010(AnimatedFileDrawable.this);
                }
                if (!AnimatedFileDrawable.this.forceDecodeAfterNextFrame) {
                    AnimatedFileDrawable.this.singleFrameDecoded = true;
                } else {
                    AnimatedFileDrawable.this.forceDecodeAfterNextFrame = false;
                }
                AnimatedFileDrawable.this.loadFrameTask = null;
                AnimatedFileDrawable animatedFileDrawable = AnimatedFileDrawable.this;
                animatedFileDrawable.nextRenderingBitmap = animatedFileDrawable.backgroundBitmap;
                AnimatedFileDrawable animatedFileDrawable2 = AnimatedFileDrawable.this;
                animatedFileDrawable2.nextRenderingBitmapTime = animatedFileDrawable2.backgroundBitmapTime;
                AnimatedFileDrawable animatedFileDrawable3 = AnimatedFileDrawable.this;
                animatedFileDrawable3.nextRenderingShader = animatedFileDrawable3.backgroundShader;
                if (AnimatedFileDrawable.this.metaData[3] < AnimatedFileDrawable.this.lastTimeStamp) {
                    AnimatedFileDrawable animatedFileDrawable4 = AnimatedFileDrawable.this;
                    animatedFileDrawable4.lastTimeStamp = animatedFileDrawable4.startTime > 0.0f ? (int) (AnimatedFileDrawable.this.startTime * 1000.0f) : 0;
                }
                if (AnimatedFileDrawable.this.metaData[3] - AnimatedFileDrawable.this.lastTimeStamp != 0) {
                    AnimatedFileDrawable animatedFileDrawable5 = AnimatedFileDrawable.this;
                    animatedFileDrawable5.invalidateAfter = animatedFileDrawable5.metaData[3] - AnimatedFileDrawable.this.lastTimeStamp;
                }
                if (AnimatedFileDrawable.this.pendingSeekToUI >= 0 && AnimatedFileDrawable.this.pendingSeekTo == -1) {
                    AnimatedFileDrawable.this.pendingSeekToUI = -1L;
                    AnimatedFileDrawable.this.invalidateAfter = 0;
                }
                AnimatedFileDrawable animatedFileDrawable6 = AnimatedFileDrawable.this;
                animatedFileDrawable6.lastTimeStamp = animatedFileDrawable6.metaData[3];
                if (!AnimatedFileDrawable.this.secondParentViews.isEmpty()) {
                    int size = AnimatedFileDrawable.this.secondParentViews.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        ((View) AnimatedFileDrawable.this.secondParentViews.get(i2)).invalidate();
                    }
                }
                if ((AnimatedFileDrawable.this.secondParentViews.isEmpty() || AnimatedFileDrawable.this.invalidateParentViewWithSecond) && AnimatedFileDrawable.this.parentView != null) {
                    AnimatedFileDrawable.this.parentView.invalidate();
                }
                AnimatedFileDrawable.this.scheduleNextGetFrame();
            }
        };
        this.loadFrameRunnable = new Runnable() { // from class: ir.eitaa.ui.Components.AnimatedFileDrawable.3
            @Override // java.lang.Runnable
            public void run() {
                if (!AnimatedFileDrawable.this.isRecycled) {
                    boolean z = false;
                    if (!AnimatedFileDrawable.this.decoderCreated && AnimatedFileDrawable.this.nativePtr == 0) {
                        AnimatedFileDrawable animatedFileDrawable = AnimatedFileDrawable.this;
                        animatedFileDrawable.nativePtr = AnimatedFileDrawable.createDecoder(animatedFileDrawable.path.getAbsolutePath(), AnimatedFileDrawable.this.metaData, AnimatedFileDrawable.this.currentAccount, AnimatedFileDrawable.this.streamFileSize, AnimatedFileDrawable.this.stream, false);
                        if (AnimatedFileDrawable.this.nativePtr != 0 && (AnimatedFileDrawable.this.metaData[0] > 3840 || AnimatedFileDrawable.this.metaData[1] > 3840)) {
                            AnimatedFileDrawable.destroyDecoder(AnimatedFileDrawable.this.nativePtr);
                            AnimatedFileDrawable.this.nativePtr = 0L;
                        }
                        if (AnimatedFileDrawable.this.renderingHeight <= 0 || AnimatedFileDrawable.this.renderingWidth <= 0 || AnimatedFileDrawable.this.metaData[0] <= 0 || AnimatedFileDrawable.this.metaData[1] <= 0) {
                            AnimatedFileDrawable.this.scaleFactor = 1.0f;
                        } else {
                            AnimatedFileDrawable.this.scaleFactor = Math.max(r0.renderingWidth / AnimatedFileDrawable.this.metaData[0], AnimatedFileDrawable.this.renderingHeight / AnimatedFileDrawable.this.metaData[1]);
                            if (AnimatedFileDrawable.this.scaleFactor <= 0.0f || AnimatedFileDrawable.this.scaleFactor > 0.7d) {
                                AnimatedFileDrawable.this.scaleFactor = 1.0f;
                            }
                        }
                        AnimatedFileDrawable.this.decoderCreated = true;
                    }
                    try {
                        if (AnimatedFileDrawable.this.nativePtr == 0 && AnimatedFileDrawable.this.metaData[0] != 0 && AnimatedFileDrawable.this.metaData[1] != 0) {
                            AndroidUtilities.runOnUIThread(AnimatedFileDrawable.this.uiRunnableNoFrame);
                            return;
                        }
                        if (AnimatedFileDrawable.this.backgroundBitmap == null && AnimatedFileDrawable.this.metaData[0] > 0 && AnimatedFileDrawable.this.metaData[1] > 0) {
                            try {
                                AnimatedFileDrawable.this.backgroundBitmap = Bitmap.createBitmap((int) (r0.metaData[0] * AnimatedFileDrawable.this.scaleFactor), (int) (AnimatedFileDrawable.this.metaData[1] * AnimatedFileDrawable.this.scaleFactor), Bitmap.Config.ARGB_8888);
                            } catch (Throwable th) {
                                FileLog.e(th);
                            }
                            if (AnimatedFileDrawable.this.backgroundShader == null && AnimatedFileDrawable.this.backgroundBitmap != null && AnimatedFileDrawable.this.hasRoundRadius()) {
                                AnimatedFileDrawable animatedFileDrawable2 = AnimatedFileDrawable.this;
                                Bitmap bitmap = AnimatedFileDrawable.this.backgroundBitmap;
                                Shader.TileMode tileMode = Shader.TileMode.CLAMP;
                                animatedFileDrawable2.backgroundShader = new BitmapShader(bitmap, tileMode, tileMode);
                            }
                        }
                        if (AnimatedFileDrawable.this.pendingSeekTo >= 0) {
                            AnimatedFileDrawable.this.metaData[3] = (int) AnimatedFileDrawable.this.pendingSeekTo;
                            long j2 = AnimatedFileDrawable.this.pendingSeekTo;
                            synchronized (AnimatedFileDrawable.this.sync) {
                                AnimatedFileDrawable.this.pendingSeekTo = -1L;
                            }
                            if (AnimatedFileDrawable.this.stream != null) {
                                AnimatedFileDrawable.this.stream.reset();
                            }
                            AnimatedFileDrawable.seekToMs(AnimatedFileDrawable.this.nativePtr, j2, true);
                            z = true;
                        }
                        if (AnimatedFileDrawable.this.backgroundBitmap != null) {
                            AnimatedFileDrawable.this.lastFrameDecodeTime = System.currentTimeMillis();
                            if (AnimatedFileDrawable.getVideoFrame(AnimatedFileDrawable.this.nativePtr, AnimatedFileDrawable.this.backgroundBitmap, AnimatedFileDrawable.this.metaData, AnimatedFileDrawable.this.backgroundBitmap.getRowBytes(), false, AnimatedFileDrawable.this.startTime, AnimatedFileDrawable.this.endTime) == 0) {
                                AndroidUtilities.runOnUIThread(AnimatedFileDrawable.this.uiRunnableNoFrame);
                                return;
                            }
                            if (z) {
                                AnimatedFileDrawable animatedFileDrawable3 = AnimatedFileDrawable.this;
                                animatedFileDrawable3.lastTimeStamp = animatedFileDrawable3.metaData[3];
                            }
                            AnimatedFileDrawable animatedFileDrawable4 = AnimatedFileDrawable.this;
                            animatedFileDrawable4.backgroundBitmapTime = animatedFileDrawable4.metaData[3];
                        }
                    } catch (Throwable th2) {
                        FileLog.e(th2);
                    }
                }
                AndroidUtilities.runOnUIThread(AnimatedFileDrawable.this.uiRunnable);
            }
        };
        this.mStartTask = new Runnable() { // from class: ir.eitaa.ui.Components.-$$Lambda$AnimatedFileDrawable$L2ZTOGjWo7ljfErMVD6FBEQHzZg
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$new$1$AnimatedFileDrawable();
            }
        };
        this.path = file;
        this.streamFileSize = streamSize;
        this.currentAccount = account;
        this.renderingHeight = h;
        this.renderingWidth = w;
        getPaint().setFlags(3);
        if (streamSize == 0 || (document == null && location == null)) {
            j = 0;
        } else {
            j = 0;
            this.stream = new AnimatedFileDrawableStream(document, location, parentObject, account, preview);
        }
        if (createDecoder) {
            this.nativePtr = createDecoder(file.getAbsolutePath(), iArr, this.currentAccount, this.streamFileSize, this.stream, preview);
            if (this.nativePtr != j && (iArr[0] > 3840 || iArr[1] > 3840)) {
                destroyDecoder(this.nativePtr);
                this.nativePtr = j;
            }
            int i2 = this.renderingHeight;
            if (i2 > 0 && (i = this.renderingWidth) > 0 && iArr[0] > 0 && iArr[1] > 0) {
                float fMax = Math.max(i / iArr[0], i2 / iArr[1]);
                this.scaleFactor = fMax;
                if (fMax <= 0.0f || fMax > 0.7d) {
                    this.scaleFactor = 1.0f;
                }
            } else {
                this.scaleFactor = 1.0f;
            }
            this.decoderCreated = true;
        }
        if (seekTo != j) {
            seekTo(seekTo, false);
        }
    }

    public Bitmap getFrameAtTime(long ms) {
        return getFrameAtTime(ms, false);
    }

    public Bitmap getFrameAtTime(long ms, boolean precise) {
        int videoFrame;
        if (!this.decoderCreated || this.nativePtr == 0) {
            return null;
        }
        AnimatedFileDrawableStream animatedFileDrawableStream = this.stream;
        if (animatedFileDrawableStream != null) {
            animatedFileDrawableStream.cancel(false);
            this.stream.reset();
        }
        if (!precise) {
            seekToMs(this.nativePtr, ms, precise);
        }
        if (this.backgroundBitmap == null) {
            float f = this.metaData[0];
            float f2 = this.scaleFactor;
            this.backgroundBitmap = Bitmap.createBitmap((int) (f * f2), (int) (r0[1] * f2), Bitmap.Config.ARGB_8888);
        }
        if (precise) {
            long j = this.nativePtr;
            Bitmap bitmap = this.backgroundBitmap;
            videoFrame = getFrameAtTime(j, ms, bitmap, this.metaData, bitmap.getRowBytes());
        } else {
            long j2 = this.nativePtr;
            Bitmap bitmap2 = this.backgroundBitmap;
            videoFrame = getVideoFrame(j2, bitmap2, this.metaData, bitmap2.getRowBytes(), true, 0.0f, 0.0f);
        }
        if (videoFrame != 0) {
            return this.backgroundBitmap;
        }
        return null;
    }

    public void setParentView(View view) {
        if (this.parentView != null) {
            return;
        }
        this.parentView = view;
    }

    public void setInvalidateParentViewWithSecond(boolean value) {
        this.invalidateParentViewWithSecond = value;
    }

    public void addSecondParentView(View view) {
        if (view == null || this.secondParentViews.contains(view)) {
            return;
        }
        this.secondParentViews.add(view);
    }

    public void removeSecondParentView(View view) {
        this.secondParentViews.remove(view);
        if (this.secondParentViews.isEmpty()) {
            if (this.recycleWithSecond) {
                recycle();
                return;
            }
            int[] iArr = this.roundRadiusBackup;
            if (iArr != null) {
                setRoundRadius(iArr);
            }
        }
    }

    public void setAllowDecodeSingleFrame(boolean value) throws InterruptedException {
        this.decodeSingleFrame = value;
        if (value) {
            scheduleNextGetFrame();
        }
    }

    public void seekTo(long ms, boolean removeLoading) {
        seekTo(ms, removeLoading, false);
    }

    public void seekTo(long ms, boolean removeLoading, boolean force) {
        AnimatedFileDrawableStream animatedFileDrawableStream;
        synchronized (this.sync) {
            this.pendingSeekTo = ms;
            this.pendingSeekToUI = ms;
            if (this.nativePtr != 0) {
                prepareToSeek(this.nativePtr);
            }
            if (this.decoderCreated && (animatedFileDrawableStream = this.stream) != null) {
                animatedFileDrawableStream.cancel(removeLoading);
                this.pendingRemoveLoading = removeLoading;
                this.pendingRemoveLoadingFramesReset = removeLoading ? 0 : 10;
            }
            if (force && this.decodeSingleFrame) {
                this.singleFrameDecoded = false;
                if (this.loadFrameTask == null) {
                    scheduleNextGetFrame();
                } else {
                    this.forceDecodeAfterNextFrame = true;
                }
            }
        }
    }

    public void recycle() {
        if (!this.secondParentViews.isEmpty()) {
            this.recycleWithSecond = true;
            return;
        }
        this.isRunning = false;
        this.isRecycled = true;
        if (this.loadFrameTask == null) {
            if (this.nativePtr != 0) {
                destroyDecoder(this.nativePtr);
                this.nativePtr = 0L;
            }
            Bitmap bitmap = this.renderingBitmap;
            if (bitmap != null) {
                bitmap.recycle();
                this.renderingBitmap = null;
            }
            Bitmap bitmap2 = this.nextRenderingBitmap;
            if (bitmap2 != null) {
                bitmap2.recycle();
                this.nextRenderingBitmap = null;
            }
            DispatchQueue dispatchQueue = this.decodeQueue;
            if (dispatchQueue != null) {
                dispatchQueue.recycle();
                this.decodeQueue = null;
            }
        } else {
            this.destroyWhenDone = true;
        }
        AnimatedFileDrawableStream animatedFileDrawableStream = this.stream;
        if (animatedFileDrawableStream != null) {
            animatedFileDrawableStream.cancel(true);
        }
    }

    public void resetStream(boolean stop) {
        AnimatedFileDrawableStream animatedFileDrawableStream = this.stream;
        if (animatedFileDrawableStream != null) {
            animatedFileDrawableStream.cancel(true);
        }
        if (this.nativePtr != 0) {
            if (stop) {
                stopDecoder(this.nativePtr);
            } else {
                prepareToSeek(this.nativePtr);
            }
        }
    }

    protected static void runOnUiThread(Runnable task) {
        Looper looperMyLooper = Looper.myLooper();
        Handler handler = uiHandler;
        if (looperMyLooper == handler.getLooper()) {
            task.run();
        } else {
            handler.post(task);
        }
    }

    public void setUseSharedQueue(boolean value) {
        this.useSharedQueue = value;
    }

    protected void finalize() throws Throwable {
        try {
            recycle();
        } finally {
            super.finalize();
        }
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        if (this.isRunning) {
            return;
        }
        this.isRunning = true;
        scheduleNextGetFrame();
        runOnUiThread(this.mStartTask);
    }

    public float getCurrentProgress() {
        if (this.metaData[4] == 0) {
            return 0.0f;
        }
        if (this.pendingSeekToUI >= 0) {
            return this.pendingSeekToUI / this.metaData[4];
        }
        int[] iArr = this.metaData;
        return iArr[3] / iArr[4];
    }

    public int getCurrentProgressMs() {
        if (this.pendingSeekToUI >= 0) {
            return (int) this.pendingSeekToUI;
        }
        int i = this.nextRenderingBitmapTime;
        return i != 0 ? i : this.renderingBitmapTime;
    }

    public int getDurationMs() {
        return this.metaData[4];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void scheduleNextGetFrame() throws InterruptedException {
        if (this.loadFrameTask == null) {
            long jMin = 0;
            if ((this.nativePtr == 0 && this.decoderCreated) || this.destroyWhenDone) {
                return;
            }
            if (!this.isRunning) {
                boolean z = this.decodeSingleFrame;
                if (!z) {
                    return;
                }
                if (z && this.singleFrameDecoded) {
                    return;
                }
            }
            if (this.lastFrameDecodeTime != 0) {
                int i = this.invalidateAfter;
                jMin = Math.min(i, Math.max(0L, i - (System.currentTimeMillis() - this.lastFrameDecodeTime)));
            }
            if (this.useSharedQueue) {
                ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = executor;
                Runnable runnable = this.loadFrameRunnable;
                this.loadFrameTask = runnable;
                scheduledThreadPoolExecutor.schedule(runnable, jMin, TimeUnit.MILLISECONDS);
                return;
            }
            if (this.decodeQueue == null) {
                this.decodeQueue = new DispatchQueue("decodeQueue" + this);
            }
            DispatchQueue dispatchQueue = this.decodeQueue;
            Runnable runnable2 = this.loadFrameRunnable;
            this.loadFrameTask = runnable2;
            dispatchQueue.postRunnable(runnable2, jMin);
        }
    }

    public boolean isLoadingStream() {
        AnimatedFileDrawableStream animatedFileDrawableStream = this.stream;
        return animatedFileDrawableStream != null && animatedFileDrawableStream.isWaitingForLoad();
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        this.isRunning = false;
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return this.isRunning;
    }

    @Override // android.graphics.drawable.BitmapDrawable, android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        int i = 0;
        if (this.decoderCreated) {
            int[] iArr = this.metaData;
            i = (iArr[2] == 90 || iArr[2] == 270) ? iArr[0] : iArr[1];
        }
        if (i == 0) {
            return AndroidUtilities.dp(100.0f);
        }
        return (int) (i * this.scaleFactor);
    }

    @Override // android.graphics.drawable.BitmapDrawable, android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        int i = 0;
        if (this.decoderCreated) {
            int[] iArr = this.metaData;
            i = (iArr[2] == 90 || iArr[2] == 270) ? iArr[1] : iArr[0];
        }
        if (i == 0) {
            return AndroidUtilities.dp(100.0f);
        }
        return (int) (i * this.scaleFactor);
    }

    @Override // android.graphics.drawable.BitmapDrawable, android.graphics.drawable.Drawable
    protected void onBoundsChange(android.graphics.Rect bounds) {
        super.onBoundsChange(bounds);
        this.applyTransformation = true;
    }

    @Override // android.graphics.drawable.BitmapDrawable, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) throws InterruptedException {
        Bitmap bitmap;
        if ((this.nativePtr == 0 && this.decoderCreated) || this.destroyWhenDone) {
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (this.isRunning) {
            Bitmap bitmap2 = this.renderingBitmap;
            if (bitmap2 == null && this.nextRenderingBitmap == null) {
                scheduleNextGetFrame();
            } else if (this.nextRenderingBitmap != null && (bitmap2 == null || Math.abs(jCurrentTimeMillis - this.lastFrameTime) >= this.invalidateAfter)) {
                this.renderingBitmap = this.nextRenderingBitmap;
                this.renderingBitmapTime = this.nextRenderingBitmapTime;
                this.renderingShader = this.nextRenderingShader;
                this.nextRenderingBitmap = null;
                this.nextRenderingBitmapTime = 0;
                this.nextRenderingShader = null;
                this.lastFrameTime = jCurrentTimeMillis;
            }
        } else if (!this.isRunning && this.decodeSingleFrame && Math.abs(jCurrentTimeMillis - this.lastFrameTime) >= this.invalidateAfter && (bitmap = this.nextRenderingBitmap) != null) {
            this.renderingBitmap = bitmap;
            this.renderingBitmapTime = this.nextRenderingBitmapTime;
            this.renderingShader = this.nextRenderingShader;
            this.nextRenderingBitmap = null;
            this.nextRenderingBitmapTime = 0;
            this.nextRenderingShader = null;
            this.lastFrameTime = jCurrentTimeMillis;
        }
        Bitmap bitmap3 = this.renderingBitmap;
        if (bitmap3 != null) {
            if (this.applyTransformation) {
                int width = bitmap3.getWidth();
                int height = this.renderingBitmap.getHeight();
                int[] iArr = this.metaData;
                if (iArr[2] == 90 || iArr[2] == 270) {
                    height = width;
                    width = height;
                }
                this.dstRect.set(getBounds());
                this.scaleX = this.dstRect.width() / width;
                this.scaleY = this.dstRect.height() / height;
                this.applyTransformation = false;
            }
            if (hasRoundRadius()) {
                Math.max(this.scaleX, this.scaleY);
                if (this.renderingShader == null) {
                    Bitmap bitmap4 = this.backgroundBitmap;
                    Shader.TileMode tileMode = Shader.TileMode.CLAMP;
                    this.renderingShader = new BitmapShader(bitmap4, tileMode, tileMode);
                }
                Paint paint = getPaint();
                paint.setShader(this.renderingShader);
                this.shaderMatrix.reset();
                Matrix matrix = this.shaderMatrix;
                android.graphics.Rect rect = this.dstRect;
                matrix.setTranslate(rect.left, rect.top);
                int[] iArr2 = this.metaData;
                if (iArr2[2] == 90) {
                    this.shaderMatrix.preRotate(90.0f);
                    this.shaderMatrix.preTranslate(0.0f, -this.dstRect.width());
                } else if (iArr2[2] == 180) {
                    this.shaderMatrix.preRotate(180.0f);
                    this.shaderMatrix.preTranslate(-this.dstRect.width(), -this.dstRect.height());
                } else if (iArr2[2] == 270) {
                    this.shaderMatrix.preRotate(270.0f);
                    this.shaderMatrix.preTranslate(-this.dstRect.height(), 0.0f);
                }
                this.shaderMatrix.preScale(this.scaleX, this.scaleY);
                this.renderingShader.setLocalMatrix(this.shaderMatrix);
                if (this.invalidatePath) {
                    this.invalidatePath = false;
                    int i = 0;
                    while (true) {
                        if (i >= this.roundRadius.length) {
                            break;
                        }
                        float[] fArr = radii;
                        int i2 = i * 2;
                        fArr[i2] = r5[i];
                        fArr[i2 + 1] = r5[i];
                        i++;
                    }
                    this.roundPath.reset();
                    this.roundPath.addRoundRect(this.actualDrawRect, radii, Path.Direction.CW);
                    this.roundPath.close();
                }
                canvas.drawPath(this.roundPath, paint);
            } else {
                android.graphics.Rect rect2 = this.dstRect;
                canvas.translate(rect2.left, rect2.top);
                int[] iArr3 = this.metaData;
                if (iArr3[2] == 90) {
                    canvas.rotate(90.0f);
                    canvas.translate(0.0f, -this.dstRect.width());
                } else if (iArr3[2] == 180) {
                    canvas.rotate(180.0f);
                    canvas.translate(-this.dstRect.width(), -this.dstRect.height());
                } else if (iArr3[2] == 270) {
                    canvas.rotate(270.0f);
                    canvas.translate(-this.dstRect.height(), 0.0f);
                }
                canvas.scale(this.scaleX, this.scaleY);
                canvas.drawBitmap(this.renderingBitmap, 0.0f, 0.0f, getPaint());
            }
            if (this.isRunning) {
                long jMax = Math.max(1L, (this.invalidateAfter - (jCurrentTimeMillis - this.lastFrameTime)) - 17);
                Handler handler = uiHandler;
                handler.removeCallbacks(this.mInvalidateTask);
                handler.postDelayed(this.mInvalidateTask, Math.min(jMax, this.invalidateAfter));
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumHeight() {
        int i = 0;
        if (this.decoderCreated) {
            int[] iArr = this.metaData;
            i = (iArr[2] == 90 || iArr[2] == 270) ? iArr[0] : iArr[1];
        }
        return i == 0 ? AndroidUtilities.dp(100.0f) : i;
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumWidth() {
        int i = 0;
        if (this.decoderCreated) {
            int[] iArr = this.metaData;
            i = (iArr[2] == 90 || iArr[2] == 270) ? iArr[1] : iArr[0];
        }
        return i == 0 ? AndroidUtilities.dp(100.0f) : i;
    }

    public Bitmap getAnimatedBitmap() {
        Bitmap bitmap = this.renderingBitmap;
        if (bitmap != null) {
            return bitmap;
        }
        Bitmap bitmap2 = this.nextRenderingBitmap;
        if (bitmap2 != null) {
            return bitmap2;
        }
        return null;
    }

    public void setActualDrawRect(float x, float y, float width, float height) {
        float f = height + y;
        float f2 = width + x;
        RectF rectF = this.actualDrawRect;
        if (rectF.left == x && rectF.top == y && rectF.right == f2 && rectF.bottom == f) {
            return;
        }
        rectF.set(x, y, f2, f);
        this.invalidatePath = true;
    }

    public void setRoundRadius(int[] value) {
        if (!this.secondParentViews.isEmpty()) {
            if (this.roundRadiusBackup == null) {
                this.roundRadiusBackup = new int[4];
            }
            int[] iArr = this.roundRadius;
            int[] iArr2 = this.roundRadiusBackup;
            System.arraycopy(iArr, 0, iArr2, 0, iArr2.length);
        }
        for (int i = 0; i < 4; i++) {
            if (!this.invalidatePath && value[i] != this.roundRadius[i]) {
                this.invalidatePath = true;
            }
            this.roundRadius[i] = value[i];
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean hasRoundRadius() {
        int i = 0;
        while (true) {
            int[] iArr = this.roundRadius;
            if (i >= iArr.length) {
                return false;
            }
            if (iArr[i] != 0) {
                return true;
            }
            i++;
        }
    }

    public boolean hasBitmap() {
        return (this.nativePtr == 0 || (this.renderingBitmap == null && this.nextRenderingBitmap == null)) ? false : true;
    }

    public int getOrientation() {
        return this.metaData[2];
    }

    public AnimatedFileDrawable makeCopy() {
        AnimatedFileDrawable animatedFileDrawable;
        AnimatedFileDrawableStream animatedFileDrawableStream = this.stream;
        if (animatedFileDrawableStream != null) {
            File file = this.path;
            long j = this.streamFileSize;
            TLRPC$Document document = animatedFileDrawableStream.getDocument();
            ImageLocation location = this.stream.getLocation();
            Object parentObject = this.stream.getParentObject();
            long j2 = this.pendingSeekToUI;
            int i = this.currentAccount;
            AnimatedFileDrawableStream animatedFileDrawableStream2 = this.stream;
            animatedFileDrawable = new AnimatedFileDrawable(file, false, j, document, location, parentObject, j2, i, animatedFileDrawableStream2 != null && animatedFileDrawableStream2.isPreview());
        } else {
            File file2 = this.path;
            long j3 = this.streamFileSize;
            long j4 = this.pendingSeekToUI;
            int i2 = this.currentAccount;
            AnimatedFileDrawableStream animatedFileDrawableStream3 = this.stream;
            animatedFileDrawable = new AnimatedFileDrawable(file2, false, j3, null, null, null, j4, i2, animatedFileDrawableStream3 != null && animatedFileDrawableStream3.isPreview());
        }
        AnimatedFileDrawable animatedFileDrawable2 = animatedFileDrawable;
        int[] iArr = animatedFileDrawable2.metaData;
        int[] iArr2 = this.metaData;
        iArr[0] = iArr2[0];
        iArr[1] = iArr2[1];
        return animatedFileDrawable2;
    }

    public static void getVideoInfo(String src, int[] params) {
        getVideoInfo(Build.VERSION.SDK_INT, src, params);
    }

    public void setStartEndTime(long startTime, long endTime) {
        this.startTime = startTime / 1000.0f;
        this.endTime = endTime / 1000.0f;
        if (getCurrentProgressMs() < startTime) {
            seekTo(startTime, true);
        }
    }

    public long getStartTime() {
        return (long) (this.startTime * 1000.0f);
    }
}
