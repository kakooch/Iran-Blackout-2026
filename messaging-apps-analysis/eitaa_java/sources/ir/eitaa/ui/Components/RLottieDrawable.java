package ir.eitaa.ui.Components;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.BitmapDrawable;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.messenger.ApplicationLoader;
import ir.eitaa.messenger.DispatchQueuePool;
import ir.eitaa.messenger.FileLog;
import ir.eitaa.messenger.R;
import ir.eitaa.messenger.Utilities;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.linphone.mediastream.Factory;

/* loaded from: classes3.dex */
public class RLottieDrawable extends BitmapDrawable implements Animatable {
    private static ThreadPoolExecutor lottieCacheGenerateQueue;
    private boolean applyTransformation;
    private boolean applyingLayerColors;
    protected int autoRepeat;
    protected int autoRepeatPlayCount;
    protected volatile Bitmap backgroundBitmap;
    protected Runnable cacheGenerateTask;
    protected int currentFrame;
    private View currentParentView;
    protected int customEndFrame;
    private boolean decodeSingleFrame;
    protected boolean destroyAfterLoading;
    protected boolean destroyWhenDone;
    protected int diceSwitchFramesCount;
    private boolean doNotRemoveInvalidOnFrameReady;
    private final android.graphics.Rect dstRect;
    private int finishFrame;
    private boolean forceFrameRedraw;
    protected CountDownLatch frameWaitSync;
    protected int height;
    private boolean invalidateOnProgressSet;
    protected int isDice;
    private boolean isInvalid;
    protected volatile boolean isRecycled;
    protected volatile boolean isRunning;
    private long lastFrameTime;
    protected Runnable loadFrameRunnable;
    protected Runnable loadFrameTask;
    protected boolean loadingInBackground;
    protected final int[] metaData;
    protected volatile long nativePtr;
    private boolean needScale;
    private HashMap<String, Integer> newColorUpdates;
    private int[] newReplaceColors;
    protected volatile boolean nextFrameIsLast;
    protected volatile Bitmap nextRenderingBitmap;
    protected WeakReference<Runnable> onFinishCallback;
    private ArrayList<WeakReference<View>> parentViews;
    private volatile HashMap<String, Integer> pendingColorUpdates;
    private int[] pendingReplaceColors;
    protected boolean playInDirectionOfCustomEndFrame;
    protected volatile Bitmap renderingBitmap;
    private float scaleX;
    private float scaleY;
    protected int secondFramesCount;
    protected boolean secondLoadingInBackground;
    protected volatile long secondNativePtr;
    protected volatile boolean setLastFrame;
    private boolean shouldLimitFps;
    private boolean singleFrameDecoded;
    protected int timeBetweenFrames;
    protected Runnable uiRunnable;
    private Runnable uiRunnableCacheFinished;
    private Runnable uiRunnableGenerateCache;
    private Runnable uiRunnableLastFrame;
    protected Runnable uiRunnableNoFrame;
    private HashMap<Integer, Integer> vibrationPattern;
    protected boolean waitingForNextTask;
    protected int width;
    protected static final Handler uiHandler = new Handler(Looper.getMainLooper());
    private static ThreadLocal<byte[]> readBufferLocal = new ThreadLocal<>();
    private static ThreadLocal<byte[]> bufferLocal = new ThreadLocal<>();
    private static DispatchQueuePool loadFrameRunnableQueue = new DispatchQueuePool(4);

    public static native long create(String src, String json, int w, int h, int[] params, boolean precache, int[] colorReplacement, boolean limitFps);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void createCache(long ptr, int w, int h);

    protected static native long createWithJson(String json, String name, int[] params, int[] colorReplacement);

    public static native void destroy(long ptr);

    public static native int getFrame(long ptr, int frame, Bitmap bitmap, int w, int h, int stride, boolean clear);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void replaceColors(long ptr, int[] colorReplacement);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void setLayerColor(long ptr, String layer, int color);

    @Override // android.graphics.drawable.BitmapDrawable, android.graphics.drawable.Drawable
    public int getOpacity() {
        return -2;
    }

    /* renamed from: ir.eitaa.ui.Components.RLottieDrawable$5, reason: invalid class name */
    class AnonymousClass5 implements Runnable {
        AnonymousClass5() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!RLottieDrawable.this.isRecycled) {
                RLottieDrawable rLottieDrawable = RLottieDrawable.this;
                if (!rLottieDrawable.destroyWhenDone && rLottieDrawable.nativePtr != 0) {
                    ThreadPoolExecutor threadPoolExecutor = RLottieDrawable.lottieCacheGenerateQueue;
                    RLottieDrawable rLottieDrawable2 = RLottieDrawable.this;
                    Runnable runnable = new Runnable() { // from class: ir.eitaa.ui.Components.-$$Lambda$RLottieDrawable$5$T0hkx19wriXNpY1pU7eK5angXQc
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.lambda$run$0$RLottieDrawable$5();
                        }
                    };
                    rLottieDrawable2.cacheGenerateTask = runnable;
                    threadPoolExecutor.execute(runnable);
                }
            }
            RLottieDrawable.this.decodeFrameFinishedInternal();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$run$0, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$run$0$RLottieDrawable$5() {
            RLottieDrawable rLottieDrawable = RLottieDrawable.this;
            if (rLottieDrawable.cacheGenerateTask == null) {
                return;
            }
            long j = rLottieDrawable.nativePtr;
            RLottieDrawable rLottieDrawable2 = RLottieDrawable.this;
            RLottieDrawable.createCache(j, rLottieDrawable2.width, rLottieDrawable2.height);
            RLottieDrawable.uiHandler.post(RLottieDrawable.this.uiRunnableCacheFinished);
        }
    }

    protected void checkRunningTasks() {
        Runnable runnable = this.cacheGenerateTask;
        if (runnable != null && lottieCacheGenerateQueue.remove(runnable)) {
            this.cacheGenerateTask = null;
        }
        if (hasParentView() || this.nextRenderingBitmap == null || this.loadFrameTask == null) {
            return;
        }
        this.loadFrameTask = null;
        this.nextRenderingBitmap = null;
    }

    protected void decodeFrameFinishedInternal() {
        if (this.destroyWhenDone) {
            checkRunningTasks();
            if (this.loadFrameTask == null && this.cacheGenerateTask == null && this.nativePtr != 0) {
                destroy(this.nativePtr);
                this.nativePtr = 0L;
                if (this.secondNativePtr != 0) {
                    destroy(this.secondNativePtr);
                    this.secondNativePtr = 0L;
                }
            }
        }
        if (this.nativePtr == 0 && this.secondNativePtr == 0) {
            recycleResources();
            return;
        }
        this.waitingForNextTask = true;
        if (!hasParentView()) {
            stop();
        }
        scheduleNextGetFrame();
    }

    protected void recycleResources() {
        if (this.renderingBitmap != null) {
            this.renderingBitmap.recycle();
            this.renderingBitmap = null;
        }
        if (this.backgroundBitmap != null) {
            this.backgroundBitmap.recycle();
            this.backgroundBitmap = null;
        }
    }

    public void setOnFinishCallback(Runnable callback, int frame) {
        if (callback != null) {
            this.onFinishCallback = new WeakReference<>(callback);
            this.finishFrame = frame;
        } else if (this.onFinishCallback != null) {
            this.onFinishCallback = null;
        }
    }

    public RLottieDrawable(File file, int w, int h, boolean precache, boolean limitFps, int[] colorReplacement) {
        int[] iArr = new int[3];
        this.metaData = iArr;
        this.customEndFrame = -1;
        this.newColorUpdates = new HashMap<>();
        this.pendingColorUpdates = new HashMap<>();
        this.diceSwitchFramesCount = -1;
        this.autoRepeat = 1;
        this.scaleX = 1.0f;
        this.scaleY = 1.0f;
        this.dstRect = new android.graphics.Rect();
        this.parentViews = new ArrayList<>();
        this.uiRunnableNoFrame = new Runnable() { // from class: ir.eitaa.ui.Components.RLottieDrawable.1
            @Override // java.lang.Runnable
            public void run() {
                RLottieDrawable rLottieDrawable = RLottieDrawable.this;
                rLottieDrawable.loadFrameTask = null;
                rLottieDrawable.decodeFrameFinishedInternal();
            }
        };
        this.uiRunnableCacheFinished = new Runnable() { // from class: ir.eitaa.ui.Components.RLottieDrawable.2
            @Override // java.lang.Runnable
            public void run() {
                RLottieDrawable rLottieDrawable = RLottieDrawable.this;
                rLottieDrawable.cacheGenerateTask = null;
                rLottieDrawable.decodeFrameFinishedInternal();
            }
        };
        this.uiRunnable = new Runnable() { // from class: ir.eitaa.ui.Components.RLottieDrawable.3
            @Override // java.lang.Runnable
            public void run() {
                RLottieDrawable.this.singleFrameDecoded = true;
                RLottieDrawable.this.invalidateInternal();
                RLottieDrawable.this.decodeFrameFinishedInternal();
            }
        };
        this.uiRunnableLastFrame = new Runnable() { // from class: ir.eitaa.ui.Components.RLottieDrawable.4
            @Override // java.lang.Runnable
            public void run() {
                RLottieDrawable.this.singleFrameDecoded = true;
                RLottieDrawable.this.isRunning = false;
                RLottieDrawable.this.invalidateInternal();
                RLottieDrawable.this.decodeFrameFinishedInternal();
            }
        };
        this.uiRunnableGenerateCache = new AnonymousClass5();
        this.loadFrameRunnable = new Runnable() { // from class: ir.eitaa.ui.Components.RLottieDrawable.6
            @Override // java.lang.Runnable
            public void run() {
                long j;
                if (RLottieDrawable.this.isRecycled) {
                    return;
                }
                if (RLottieDrawable.this.nativePtr != 0) {
                    RLottieDrawable rLottieDrawable = RLottieDrawable.this;
                    if (rLottieDrawable.isDice != 2 || rLottieDrawable.secondNativePtr != 0) {
                        if (RLottieDrawable.this.backgroundBitmap == null) {
                            try {
                                RLottieDrawable rLottieDrawable2 = RLottieDrawable.this;
                                rLottieDrawable2.backgroundBitmap = Bitmap.createBitmap(rLottieDrawable2.width, rLottieDrawable2.height, Bitmap.Config.ARGB_8888);
                            } catch (Throwable th) {
                                FileLog.e(th);
                            }
                        }
                        if (RLottieDrawable.this.backgroundBitmap != null) {
                            try {
                                if (!RLottieDrawable.this.pendingColorUpdates.isEmpty()) {
                                    for (Map.Entry entry : RLottieDrawable.this.pendingColorUpdates.entrySet()) {
                                        RLottieDrawable.setLayerColor(RLottieDrawable.this.nativePtr, (String) entry.getKey(), ((Integer) entry.getValue()).intValue());
                                    }
                                    RLottieDrawable.this.pendingColorUpdates.clear();
                                }
                            } catch (Exception unused) {
                            }
                            if (RLottieDrawable.this.pendingReplaceColors != null) {
                                RLottieDrawable.replaceColors(RLottieDrawable.this.nativePtr, RLottieDrawable.this.pendingReplaceColors);
                                RLottieDrawable.this.pendingReplaceColors = null;
                            }
                            try {
                                RLottieDrawable rLottieDrawable3 = RLottieDrawable.this;
                                int i = rLottieDrawable3.isDice;
                                if (i != 1 && i == 2) {
                                    j = rLottieDrawable3.secondNativePtr;
                                    if (RLottieDrawable.this.setLastFrame) {
                                        RLottieDrawable rLottieDrawable4 = RLottieDrawable.this;
                                        rLottieDrawable4.currentFrame = rLottieDrawable4.secondFramesCount - 1;
                                    }
                                } else {
                                    j = rLottieDrawable3.nativePtr;
                                }
                                long j2 = j;
                                RLottieDrawable rLottieDrawable5 = RLottieDrawable.this;
                                int i2 = rLottieDrawable5.currentFrame;
                                Bitmap bitmap = rLottieDrawable5.backgroundBitmap;
                                RLottieDrawable rLottieDrawable6 = RLottieDrawable.this;
                                if (RLottieDrawable.getFrame(j2, i2, bitmap, rLottieDrawable6.width, rLottieDrawable6.height, rLottieDrawable6.backgroundBitmap.getRowBytes(), true) == -1) {
                                    RLottieDrawable.uiHandler.post(RLottieDrawable.this.uiRunnableNoFrame);
                                    CountDownLatch countDownLatch = RLottieDrawable.this.frameWaitSync;
                                    if (countDownLatch != null) {
                                        countDownLatch.countDown();
                                        return;
                                    }
                                    return;
                                }
                                RLottieDrawable rLottieDrawable7 = RLottieDrawable.this;
                                if (rLottieDrawable7.metaData[2] != 0) {
                                    RLottieDrawable.uiHandler.post(rLottieDrawable7.uiRunnableGenerateCache);
                                    RLottieDrawable.this.metaData[2] = 0;
                                }
                                RLottieDrawable rLottieDrawable8 = RLottieDrawable.this;
                                rLottieDrawable8.nextRenderingBitmap = rLottieDrawable8.backgroundBitmap;
                                int i3 = RLottieDrawable.this.shouldLimitFps ? 2 : 1;
                                RLottieDrawable rLottieDrawable9 = RLottieDrawable.this;
                                int i4 = rLottieDrawable9.isDice;
                                if (i4 == 1) {
                                    int i5 = rLottieDrawable9.currentFrame;
                                    int i6 = i5 + i3;
                                    int i7 = rLottieDrawable9.diceSwitchFramesCount;
                                    if (i7 == -1) {
                                        i7 = rLottieDrawable9.metaData[0];
                                    }
                                    if (i6 < i7) {
                                        rLottieDrawable9.currentFrame = i5 + i3;
                                    } else {
                                        rLottieDrawable9.currentFrame = 0;
                                        rLottieDrawable9.nextFrameIsLast = false;
                                        if (RLottieDrawable.this.secondNativePtr != 0) {
                                            RLottieDrawable.this.isDice = 2;
                                        }
                                    }
                                } else if (i4 == 2) {
                                    int i8 = rLottieDrawable9.currentFrame;
                                    if (i8 + i3 < rLottieDrawable9.secondFramesCount) {
                                        rLottieDrawable9.currentFrame = i8 + i3;
                                    } else {
                                        rLottieDrawable9.nextFrameIsLast = true;
                                        RLottieDrawable.this.autoRepeatPlayCount++;
                                    }
                                } else {
                                    int i9 = rLottieDrawable9.customEndFrame;
                                    if (i9 >= 0 && rLottieDrawable9.playInDirectionOfCustomEndFrame) {
                                        int i10 = rLottieDrawable9.currentFrame;
                                        if (i10 > i9) {
                                            if (i10 - i3 >= i9) {
                                                rLottieDrawable9.currentFrame = i10 - i3;
                                                rLottieDrawable9.nextFrameIsLast = false;
                                            } else {
                                                rLottieDrawable9.nextFrameIsLast = true;
                                            }
                                        } else if (i10 + i3 < i9) {
                                            rLottieDrawable9.currentFrame = i10 + i3;
                                            rLottieDrawable9.nextFrameIsLast = false;
                                        } else {
                                            rLottieDrawable9.nextFrameIsLast = true;
                                        }
                                    } else {
                                        int i11 = rLottieDrawable9.currentFrame;
                                        int i12 = i11 + i3;
                                        if (i9 < 0) {
                                            i9 = rLottieDrawable9.metaData[0];
                                        }
                                        if (i12 < i9) {
                                            if (rLottieDrawable9.autoRepeat == 3) {
                                                rLottieDrawable9.nextFrameIsLast = true;
                                                RLottieDrawable.this.autoRepeatPlayCount++;
                                            } else {
                                                rLottieDrawable9.currentFrame = i11 + i3;
                                                rLottieDrawable9.nextFrameIsLast = false;
                                            }
                                        } else {
                                            int i13 = rLottieDrawable9.autoRepeat;
                                            if (i13 == 1) {
                                                rLottieDrawable9.currentFrame = 0;
                                                rLottieDrawable9.nextFrameIsLast = false;
                                            } else if (i13 == 2) {
                                                rLottieDrawable9.currentFrame = 0;
                                                rLottieDrawable9.nextFrameIsLast = true;
                                                RLottieDrawable.this.autoRepeatPlayCount++;
                                            } else {
                                                rLottieDrawable9.nextFrameIsLast = true;
                                            }
                                        }
                                    }
                                }
                            } catch (Exception e) {
                                FileLog.e(e);
                            }
                        }
                        RLottieDrawable.uiHandler.post(RLottieDrawable.this.uiRunnable);
                        CountDownLatch countDownLatch2 = RLottieDrawable.this.frameWaitSync;
                        if (countDownLatch2 != null) {
                            countDownLatch2.countDown();
                            return;
                        }
                        return;
                    }
                }
                CountDownLatch countDownLatch3 = RLottieDrawable.this.frameWaitSync;
                if (countDownLatch3 != null) {
                    countDownLatch3.countDown();
                }
                RLottieDrawable.uiHandler.post(RLottieDrawable.this.uiRunnableNoFrame);
            }
        };
        this.width = w;
        this.height = h;
        this.shouldLimitFps = limitFps;
        getPaint().setFlags(2);
        this.nativePtr = create(file.getAbsolutePath(), null, w, h, iArr, precache, colorReplacement, this.shouldLimitFps);
        if (precache && lottieCacheGenerateQueue == null) {
            lottieCacheGenerateQueue = new ThreadPoolExecutor(1, 1, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue());
        }
        if (this.nativePtr == 0) {
            file.delete();
        }
        if (this.shouldLimitFps && iArr[1] < 60) {
            this.shouldLimitFps = false;
        }
        this.timeBetweenFrames = Math.max(this.shouldLimitFps ? 33 : 16, (int) (1000.0f / iArr[1]));
    }

    public RLottieDrawable(File file, String json, int w, int h, boolean precache, boolean limitFps, int[] colorReplacement) {
        int[] iArr = new int[3];
        this.metaData = iArr;
        this.customEndFrame = -1;
        this.newColorUpdates = new HashMap<>();
        this.pendingColorUpdates = new HashMap<>();
        this.diceSwitchFramesCount = -1;
        this.autoRepeat = 1;
        this.scaleX = 1.0f;
        this.scaleY = 1.0f;
        this.dstRect = new android.graphics.Rect();
        this.parentViews = new ArrayList<>();
        this.uiRunnableNoFrame = new Runnable() { // from class: ir.eitaa.ui.Components.RLottieDrawable.1
            @Override // java.lang.Runnable
            public void run() {
                RLottieDrawable rLottieDrawable = RLottieDrawable.this;
                rLottieDrawable.loadFrameTask = null;
                rLottieDrawable.decodeFrameFinishedInternal();
            }
        };
        this.uiRunnableCacheFinished = new Runnable() { // from class: ir.eitaa.ui.Components.RLottieDrawable.2
            @Override // java.lang.Runnable
            public void run() {
                RLottieDrawable rLottieDrawable = RLottieDrawable.this;
                rLottieDrawable.cacheGenerateTask = null;
                rLottieDrawable.decodeFrameFinishedInternal();
            }
        };
        this.uiRunnable = new Runnable() { // from class: ir.eitaa.ui.Components.RLottieDrawable.3
            @Override // java.lang.Runnable
            public void run() {
                RLottieDrawable.this.singleFrameDecoded = true;
                RLottieDrawable.this.invalidateInternal();
                RLottieDrawable.this.decodeFrameFinishedInternal();
            }
        };
        this.uiRunnableLastFrame = new Runnable() { // from class: ir.eitaa.ui.Components.RLottieDrawable.4
            @Override // java.lang.Runnable
            public void run() {
                RLottieDrawable.this.singleFrameDecoded = true;
                RLottieDrawable.this.isRunning = false;
                RLottieDrawable.this.invalidateInternal();
                RLottieDrawable.this.decodeFrameFinishedInternal();
            }
        };
        this.uiRunnableGenerateCache = new AnonymousClass5();
        this.loadFrameRunnable = new Runnable() { // from class: ir.eitaa.ui.Components.RLottieDrawable.6
            @Override // java.lang.Runnable
            public void run() {
                long j;
                if (RLottieDrawable.this.isRecycled) {
                    return;
                }
                if (RLottieDrawable.this.nativePtr != 0) {
                    RLottieDrawable rLottieDrawable = RLottieDrawable.this;
                    if (rLottieDrawable.isDice != 2 || rLottieDrawable.secondNativePtr != 0) {
                        if (RLottieDrawable.this.backgroundBitmap == null) {
                            try {
                                RLottieDrawable rLottieDrawable2 = RLottieDrawable.this;
                                rLottieDrawable2.backgroundBitmap = Bitmap.createBitmap(rLottieDrawable2.width, rLottieDrawable2.height, Bitmap.Config.ARGB_8888);
                            } catch (Throwable th) {
                                FileLog.e(th);
                            }
                        }
                        if (RLottieDrawable.this.backgroundBitmap != null) {
                            try {
                                if (!RLottieDrawable.this.pendingColorUpdates.isEmpty()) {
                                    for (Map.Entry entry : RLottieDrawable.this.pendingColorUpdates.entrySet()) {
                                        RLottieDrawable.setLayerColor(RLottieDrawable.this.nativePtr, (String) entry.getKey(), ((Integer) entry.getValue()).intValue());
                                    }
                                    RLottieDrawable.this.pendingColorUpdates.clear();
                                }
                            } catch (Exception unused) {
                            }
                            if (RLottieDrawable.this.pendingReplaceColors != null) {
                                RLottieDrawable.replaceColors(RLottieDrawable.this.nativePtr, RLottieDrawable.this.pendingReplaceColors);
                                RLottieDrawable.this.pendingReplaceColors = null;
                            }
                            try {
                                RLottieDrawable rLottieDrawable3 = RLottieDrawable.this;
                                int i = rLottieDrawable3.isDice;
                                if (i != 1 && i == 2) {
                                    j = rLottieDrawable3.secondNativePtr;
                                    if (RLottieDrawable.this.setLastFrame) {
                                        RLottieDrawable rLottieDrawable4 = RLottieDrawable.this;
                                        rLottieDrawable4.currentFrame = rLottieDrawable4.secondFramesCount - 1;
                                    }
                                } else {
                                    j = rLottieDrawable3.nativePtr;
                                }
                                long j2 = j;
                                RLottieDrawable rLottieDrawable5 = RLottieDrawable.this;
                                int i2 = rLottieDrawable5.currentFrame;
                                Bitmap bitmap = rLottieDrawable5.backgroundBitmap;
                                RLottieDrawable rLottieDrawable6 = RLottieDrawable.this;
                                if (RLottieDrawable.getFrame(j2, i2, bitmap, rLottieDrawable6.width, rLottieDrawable6.height, rLottieDrawable6.backgroundBitmap.getRowBytes(), true) == -1) {
                                    RLottieDrawable.uiHandler.post(RLottieDrawable.this.uiRunnableNoFrame);
                                    CountDownLatch countDownLatch = RLottieDrawable.this.frameWaitSync;
                                    if (countDownLatch != null) {
                                        countDownLatch.countDown();
                                        return;
                                    }
                                    return;
                                }
                                RLottieDrawable rLottieDrawable7 = RLottieDrawable.this;
                                if (rLottieDrawable7.metaData[2] != 0) {
                                    RLottieDrawable.uiHandler.post(rLottieDrawable7.uiRunnableGenerateCache);
                                    RLottieDrawable.this.metaData[2] = 0;
                                }
                                RLottieDrawable rLottieDrawable8 = RLottieDrawable.this;
                                rLottieDrawable8.nextRenderingBitmap = rLottieDrawable8.backgroundBitmap;
                                int i3 = RLottieDrawable.this.shouldLimitFps ? 2 : 1;
                                RLottieDrawable rLottieDrawable9 = RLottieDrawable.this;
                                int i4 = rLottieDrawable9.isDice;
                                if (i4 == 1) {
                                    int i5 = rLottieDrawable9.currentFrame;
                                    int i6 = i5 + i3;
                                    int i7 = rLottieDrawable9.diceSwitchFramesCount;
                                    if (i7 == -1) {
                                        i7 = rLottieDrawable9.metaData[0];
                                    }
                                    if (i6 < i7) {
                                        rLottieDrawable9.currentFrame = i5 + i3;
                                    } else {
                                        rLottieDrawable9.currentFrame = 0;
                                        rLottieDrawable9.nextFrameIsLast = false;
                                        if (RLottieDrawable.this.secondNativePtr != 0) {
                                            RLottieDrawable.this.isDice = 2;
                                        }
                                    }
                                } else if (i4 == 2) {
                                    int i8 = rLottieDrawable9.currentFrame;
                                    if (i8 + i3 < rLottieDrawable9.secondFramesCount) {
                                        rLottieDrawable9.currentFrame = i8 + i3;
                                    } else {
                                        rLottieDrawable9.nextFrameIsLast = true;
                                        RLottieDrawable.this.autoRepeatPlayCount++;
                                    }
                                } else {
                                    int i9 = rLottieDrawable9.customEndFrame;
                                    if (i9 >= 0 && rLottieDrawable9.playInDirectionOfCustomEndFrame) {
                                        int i10 = rLottieDrawable9.currentFrame;
                                        if (i10 > i9) {
                                            if (i10 - i3 >= i9) {
                                                rLottieDrawable9.currentFrame = i10 - i3;
                                                rLottieDrawable9.nextFrameIsLast = false;
                                            } else {
                                                rLottieDrawable9.nextFrameIsLast = true;
                                            }
                                        } else if (i10 + i3 < i9) {
                                            rLottieDrawable9.currentFrame = i10 + i3;
                                            rLottieDrawable9.nextFrameIsLast = false;
                                        } else {
                                            rLottieDrawable9.nextFrameIsLast = true;
                                        }
                                    } else {
                                        int i11 = rLottieDrawable9.currentFrame;
                                        int i12 = i11 + i3;
                                        if (i9 < 0) {
                                            i9 = rLottieDrawable9.metaData[0];
                                        }
                                        if (i12 < i9) {
                                            if (rLottieDrawable9.autoRepeat == 3) {
                                                rLottieDrawable9.nextFrameIsLast = true;
                                                RLottieDrawable.this.autoRepeatPlayCount++;
                                            } else {
                                                rLottieDrawable9.currentFrame = i11 + i3;
                                                rLottieDrawable9.nextFrameIsLast = false;
                                            }
                                        } else {
                                            int i13 = rLottieDrawable9.autoRepeat;
                                            if (i13 == 1) {
                                                rLottieDrawable9.currentFrame = 0;
                                                rLottieDrawable9.nextFrameIsLast = false;
                                            } else if (i13 == 2) {
                                                rLottieDrawable9.currentFrame = 0;
                                                rLottieDrawable9.nextFrameIsLast = true;
                                                RLottieDrawable.this.autoRepeatPlayCount++;
                                            } else {
                                                rLottieDrawable9.nextFrameIsLast = true;
                                            }
                                        }
                                    }
                                }
                            } catch (Exception e) {
                                FileLog.e(e);
                            }
                        }
                        RLottieDrawable.uiHandler.post(RLottieDrawable.this.uiRunnable);
                        CountDownLatch countDownLatch2 = RLottieDrawable.this.frameWaitSync;
                        if (countDownLatch2 != null) {
                            countDownLatch2.countDown();
                            return;
                        }
                        return;
                    }
                }
                CountDownLatch countDownLatch3 = RLottieDrawable.this.frameWaitSync;
                if (countDownLatch3 != null) {
                    countDownLatch3.countDown();
                }
                RLottieDrawable.uiHandler.post(RLottieDrawable.this.uiRunnableNoFrame);
            }
        };
        this.width = w;
        this.height = h;
        this.shouldLimitFps = limitFps;
        getPaint().setFlags(2);
        this.nativePtr = create(file.getAbsolutePath(), json, w, h, iArr, precache, colorReplacement, this.shouldLimitFps);
        if (precache && lottieCacheGenerateQueue == null) {
            lottieCacheGenerateQueue = new ThreadPoolExecutor(1, 1, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue());
        }
        if (this.nativePtr == 0) {
            file.delete();
        }
        if (this.shouldLimitFps && iArr[1] < 60) {
            this.shouldLimitFps = false;
        }
        this.timeBetweenFrames = Math.max(this.shouldLimitFps ? 33 : 16, (int) (1000.0f / iArr[1]));
    }

    public RLottieDrawable(int rawRes, String name, int w, int h) {
        this(rawRes, name, w, h, true, (int[]) null);
    }

    public RLottieDrawable(String diceEmoji, int w, int h) {
        String res;
        int[] iArr = new int[3];
        this.metaData = iArr;
        this.customEndFrame = -1;
        this.newColorUpdates = new HashMap<>();
        this.pendingColorUpdates = new HashMap<>();
        this.diceSwitchFramesCount = -1;
        this.autoRepeat = 1;
        this.scaleX = 1.0f;
        this.scaleY = 1.0f;
        this.dstRect = new android.graphics.Rect();
        this.parentViews = new ArrayList<>();
        this.uiRunnableNoFrame = new Runnable() { // from class: ir.eitaa.ui.Components.RLottieDrawable.1
            @Override // java.lang.Runnable
            public void run() {
                RLottieDrawable rLottieDrawable = RLottieDrawable.this;
                rLottieDrawable.loadFrameTask = null;
                rLottieDrawable.decodeFrameFinishedInternal();
            }
        };
        this.uiRunnableCacheFinished = new Runnable() { // from class: ir.eitaa.ui.Components.RLottieDrawable.2
            @Override // java.lang.Runnable
            public void run() {
                RLottieDrawable rLottieDrawable = RLottieDrawable.this;
                rLottieDrawable.cacheGenerateTask = null;
                rLottieDrawable.decodeFrameFinishedInternal();
            }
        };
        this.uiRunnable = new Runnable() { // from class: ir.eitaa.ui.Components.RLottieDrawable.3
            @Override // java.lang.Runnable
            public void run() {
                RLottieDrawable.this.singleFrameDecoded = true;
                RLottieDrawable.this.invalidateInternal();
                RLottieDrawable.this.decodeFrameFinishedInternal();
            }
        };
        this.uiRunnableLastFrame = new Runnable() { // from class: ir.eitaa.ui.Components.RLottieDrawable.4
            @Override // java.lang.Runnable
            public void run() {
                RLottieDrawable.this.singleFrameDecoded = true;
                RLottieDrawable.this.isRunning = false;
                RLottieDrawable.this.invalidateInternal();
                RLottieDrawable.this.decodeFrameFinishedInternal();
            }
        };
        this.uiRunnableGenerateCache = new AnonymousClass5();
        this.loadFrameRunnable = new Runnable() { // from class: ir.eitaa.ui.Components.RLottieDrawable.6
            @Override // java.lang.Runnable
            public void run() {
                long j;
                if (RLottieDrawable.this.isRecycled) {
                    return;
                }
                if (RLottieDrawable.this.nativePtr != 0) {
                    RLottieDrawable rLottieDrawable = RLottieDrawable.this;
                    if (rLottieDrawable.isDice != 2 || rLottieDrawable.secondNativePtr != 0) {
                        if (RLottieDrawable.this.backgroundBitmap == null) {
                            try {
                                RLottieDrawable rLottieDrawable2 = RLottieDrawable.this;
                                rLottieDrawable2.backgroundBitmap = Bitmap.createBitmap(rLottieDrawable2.width, rLottieDrawable2.height, Bitmap.Config.ARGB_8888);
                            } catch (Throwable th) {
                                FileLog.e(th);
                            }
                        }
                        if (RLottieDrawable.this.backgroundBitmap != null) {
                            try {
                                if (!RLottieDrawable.this.pendingColorUpdates.isEmpty()) {
                                    for (Map.Entry entry : RLottieDrawable.this.pendingColorUpdates.entrySet()) {
                                        RLottieDrawable.setLayerColor(RLottieDrawable.this.nativePtr, (String) entry.getKey(), ((Integer) entry.getValue()).intValue());
                                    }
                                    RLottieDrawable.this.pendingColorUpdates.clear();
                                }
                            } catch (Exception unused) {
                            }
                            if (RLottieDrawable.this.pendingReplaceColors != null) {
                                RLottieDrawable.replaceColors(RLottieDrawable.this.nativePtr, RLottieDrawable.this.pendingReplaceColors);
                                RLottieDrawable.this.pendingReplaceColors = null;
                            }
                            try {
                                RLottieDrawable rLottieDrawable3 = RLottieDrawable.this;
                                int i = rLottieDrawable3.isDice;
                                if (i != 1 && i == 2) {
                                    j = rLottieDrawable3.secondNativePtr;
                                    if (RLottieDrawable.this.setLastFrame) {
                                        RLottieDrawable rLottieDrawable4 = RLottieDrawable.this;
                                        rLottieDrawable4.currentFrame = rLottieDrawable4.secondFramesCount - 1;
                                    }
                                } else {
                                    j = rLottieDrawable3.nativePtr;
                                }
                                long j2 = j;
                                RLottieDrawable rLottieDrawable5 = RLottieDrawable.this;
                                int i2 = rLottieDrawable5.currentFrame;
                                Bitmap bitmap = rLottieDrawable5.backgroundBitmap;
                                RLottieDrawable rLottieDrawable6 = RLottieDrawable.this;
                                if (RLottieDrawable.getFrame(j2, i2, bitmap, rLottieDrawable6.width, rLottieDrawable6.height, rLottieDrawable6.backgroundBitmap.getRowBytes(), true) == -1) {
                                    RLottieDrawable.uiHandler.post(RLottieDrawable.this.uiRunnableNoFrame);
                                    CountDownLatch countDownLatch = RLottieDrawable.this.frameWaitSync;
                                    if (countDownLatch != null) {
                                        countDownLatch.countDown();
                                        return;
                                    }
                                    return;
                                }
                                RLottieDrawable rLottieDrawable7 = RLottieDrawable.this;
                                if (rLottieDrawable7.metaData[2] != 0) {
                                    RLottieDrawable.uiHandler.post(rLottieDrawable7.uiRunnableGenerateCache);
                                    RLottieDrawable.this.metaData[2] = 0;
                                }
                                RLottieDrawable rLottieDrawable8 = RLottieDrawable.this;
                                rLottieDrawable8.nextRenderingBitmap = rLottieDrawable8.backgroundBitmap;
                                int i3 = RLottieDrawable.this.shouldLimitFps ? 2 : 1;
                                RLottieDrawable rLottieDrawable9 = RLottieDrawable.this;
                                int i4 = rLottieDrawable9.isDice;
                                if (i4 == 1) {
                                    int i5 = rLottieDrawable9.currentFrame;
                                    int i6 = i5 + i3;
                                    int i7 = rLottieDrawable9.diceSwitchFramesCount;
                                    if (i7 == -1) {
                                        i7 = rLottieDrawable9.metaData[0];
                                    }
                                    if (i6 < i7) {
                                        rLottieDrawable9.currentFrame = i5 + i3;
                                    } else {
                                        rLottieDrawable9.currentFrame = 0;
                                        rLottieDrawable9.nextFrameIsLast = false;
                                        if (RLottieDrawable.this.secondNativePtr != 0) {
                                            RLottieDrawable.this.isDice = 2;
                                        }
                                    }
                                } else if (i4 == 2) {
                                    int i8 = rLottieDrawable9.currentFrame;
                                    if (i8 + i3 < rLottieDrawable9.secondFramesCount) {
                                        rLottieDrawable9.currentFrame = i8 + i3;
                                    } else {
                                        rLottieDrawable9.nextFrameIsLast = true;
                                        RLottieDrawable.this.autoRepeatPlayCount++;
                                    }
                                } else {
                                    int i9 = rLottieDrawable9.customEndFrame;
                                    if (i9 >= 0 && rLottieDrawable9.playInDirectionOfCustomEndFrame) {
                                        int i10 = rLottieDrawable9.currentFrame;
                                        if (i10 > i9) {
                                            if (i10 - i3 >= i9) {
                                                rLottieDrawable9.currentFrame = i10 - i3;
                                                rLottieDrawable9.nextFrameIsLast = false;
                                            } else {
                                                rLottieDrawable9.nextFrameIsLast = true;
                                            }
                                        } else if (i10 + i3 < i9) {
                                            rLottieDrawable9.currentFrame = i10 + i3;
                                            rLottieDrawable9.nextFrameIsLast = false;
                                        } else {
                                            rLottieDrawable9.nextFrameIsLast = true;
                                        }
                                    } else {
                                        int i11 = rLottieDrawable9.currentFrame;
                                        int i12 = i11 + i3;
                                        if (i9 < 0) {
                                            i9 = rLottieDrawable9.metaData[0];
                                        }
                                        if (i12 < i9) {
                                            if (rLottieDrawable9.autoRepeat == 3) {
                                                rLottieDrawable9.nextFrameIsLast = true;
                                                RLottieDrawable.this.autoRepeatPlayCount++;
                                            } else {
                                                rLottieDrawable9.currentFrame = i11 + i3;
                                                rLottieDrawable9.nextFrameIsLast = false;
                                            }
                                        } else {
                                            int i13 = rLottieDrawable9.autoRepeat;
                                            if (i13 == 1) {
                                                rLottieDrawable9.currentFrame = 0;
                                                rLottieDrawable9.nextFrameIsLast = false;
                                            } else if (i13 == 2) {
                                                rLottieDrawable9.currentFrame = 0;
                                                rLottieDrawable9.nextFrameIsLast = true;
                                                RLottieDrawable.this.autoRepeatPlayCount++;
                                            } else {
                                                rLottieDrawable9.nextFrameIsLast = true;
                                            }
                                        }
                                    }
                                }
                            } catch (Exception e) {
                                FileLog.e(e);
                            }
                        }
                        RLottieDrawable.uiHandler.post(RLottieDrawable.this.uiRunnable);
                        CountDownLatch countDownLatch2 = RLottieDrawable.this.frameWaitSync;
                        if (countDownLatch2 != null) {
                            countDownLatch2.countDown();
                            return;
                        }
                        return;
                    }
                }
                CountDownLatch countDownLatch3 = RLottieDrawable.this.frameWaitSync;
                if (countDownLatch3 != null) {
                    countDownLatch3.countDown();
                }
                RLottieDrawable.uiHandler.post(RLottieDrawable.this.uiRunnableNoFrame);
            }
        };
        this.width = w;
        this.height = h;
        this.isDice = 1;
        if ("🎲".equals(diceEmoji)) {
            res = readRes(null, R.raw.diceloop);
            this.diceSwitchFramesCount = 60;
        } else {
            res = "🎯".equals(diceEmoji) ? readRes(null, R.raw.dartloop) : null;
        }
        getPaint().setFlags(2);
        if (TextUtils.isEmpty(res)) {
            this.timeBetweenFrames = 16;
        } else {
            this.nativePtr = createWithJson(res, "dice", iArr, null);
            this.timeBetweenFrames = Math.max(16, (int) (1000.0f / iArr[1]));
        }
    }

    public boolean setBaseDice(File path) {
        if (this.nativePtr == 0 && !this.loadingInBackground) {
            final String res = readRes(path, 0);
            if (TextUtils.isEmpty(res)) {
                return false;
            }
            this.loadingInBackground = true;
            Utilities.globalQueue.postRunnable(new Runnable() { // from class: ir.eitaa.ui.Components.-$$Lambda$RLottieDrawable$ndOpjPheIOVQhcCTUXzc2zaGz3A
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$setBaseDice$1$RLottieDrawable(res);
                }
            });
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$setBaseDice$1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$setBaseDice$1$RLottieDrawable(String str) {
        this.nativePtr = createWithJson(str, "dice", this.metaData, null);
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.Components.-$$Lambda$RLottieDrawable$yRXtE3X0h5qK6XqmZzai-qNrWPg
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$setBaseDice$0$RLottieDrawable();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$setBaseDice$0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$setBaseDice$0$RLottieDrawable() {
        this.loadingInBackground = false;
        if (!this.secondLoadingInBackground && this.destroyAfterLoading) {
            recycle();
            return;
        }
        this.timeBetweenFrames = Math.max(16, (int) (1000.0f / this.metaData[1]));
        scheduleNextGetFrame();
        invalidateInternal();
    }

    public boolean hasBaseDice() {
        return this.nativePtr != 0 || this.loadingInBackground;
    }

    public boolean setDiceNumber(File path, boolean instant) {
        if (this.secondNativePtr == 0 && !this.secondLoadingInBackground) {
            final String res = readRes(path, 0);
            if (TextUtils.isEmpty(res)) {
                return false;
            }
            if (instant && this.nextRenderingBitmap == null && this.renderingBitmap == null && this.loadFrameTask == null) {
                this.isDice = 2;
                this.setLastFrame = true;
            }
            this.secondLoadingInBackground = true;
            Utilities.globalQueue.postRunnable(new Runnable() { // from class: ir.eitaa.ui.Components.-$$Lambda$RLottieDrawable$BxNQZooHvkYSRFTIo_mTW0n4K1M
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$setDiceNumber$4$RLottieDrawable(res);
                }
            });
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$setDiceNumber$4, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$setDiceNumber$4$RLottieDrawable(String str) {
        if (this.destroyAfterLoading) {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.Components.-$$Lambda$RLottieDrawable$foSCBNpmUywHkqFoP3EUXJm1c8E
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$setDiceNumber$2$RLottieDrawable();
                }
            });
            return;
        }
        final int[] iArr = new int[3];
        this.secondNativePtr = createWithJson(str, "dice", iArr, null);
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.Components.-$$Lambda$RLottieDrawable$vdO6Tks5cF_odbWQEZ--e1SPQXg
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$setDiceNumber$3$RLottieDrawable(iArr);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$setDiceNumber$2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$setDiceNumber$2$RLottieDrawable() {
        this.secondLoadingInBackground = false;
        if (this.loadingInBackground || !this.destroyAfterLoading) {
            return;
        }
        recycle();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$setDiceNumber$3, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$setDiceNumber$3$RLottieDrawable(int[] iArr) {
        this.secondLoadingInBackground = false;
        if (this.destroyAfterLoading) {
            recycle();
            return;
        }
        this.secondFramesCount = iArr[0];
        this.timeBetweenFrames = Math.max(16, (int) (1000.0f / iArr[1]));
        scheduleNextGetFrame();
        invalidateInternal();
    }

    public RLottieDrawable(int rawRes, String name, int w, int h, boolean startDecode, int[] colorReplacement) {
        int[] iArr = new int[3];
        this.metaData = iArr;
        this.customEndFrame = -1;
        this.newColorUpdates = new HashMap<>();
        this.pendingColorUpdates = new HashMap<>();
        this.diceSwitchFramesCount = -1;
        this.autoRepeat = 1;
        this.scaleX = 1.0f;
        this.scaleY = 1.0f;
        this.dstRect = new android.graphics.Rect();
        this.parentViews = new ArrayList<>();
        this.uiRunnableNoFrame = new Runnable() { // from class: ir.eitaa.ui.Components.RLottieDrawable.1
            @Override // java.lang.Runnable
            public void run() {
                RLottieDrawable rLottieDrawable = RLottieDrawable.this;
                rLottieDrawable.loadFrameTask = null;
                rLottieDrawable.decodeFrameFinishedInternal();
            }
        };
        this.uiRunnableCacheFinished = new Runnable() { // from class: ir.eitaa.ui.Components.RLottieDrawable.2
            @Override // java.lang.Runnable
            public void run() {
                RLottieDrawable rLottieDrawable = RLottieDrawable.this;
                rLottieDrawable.cacheGenerateTask = null;
                rLottieDrawable.decodeFrameFinishedInternal();
            }
        };
        this.uiRunnable = new Runnable() { // from class: ir.eitaa.ui.Components.RLottieDrawable.3
            @Override // java.lang.Runnable
            public void run() {
                RLottieDrawable.this.singleFrameDecoded = true;
                RLottieDrawable.this.invalidateInternal();
                RLottieDrawable.this.decodeFrameFinishedInternal();
            }
        };
        this.uiRunnableLastFrame = new Runnable() { // from class: ir.eitaa.ui.Components.RLottieDrawable.4
            @Override // java.lang.Runnable
            public void run() {
                RLottieDrawable.this.singleFrameDecoded = true;
                RLottieDrawable.this.isRunning = false;
                RLottieDrawable.this.invalidateInternal();
                RLottieDrawable.this.decodeFrameFinishedInternal();
            }
        };
        this.uiRunnableGenerateCache = new AnonymousClass5();
        this.loadFrameRunnable = new Runnable() { // from class: ir.eitaa.ui.Components.RLottieDrawable.6
            @Override // java.lang.Runnable
            public void run() {
                long j;
                if (RLottieDrawable.this.isRecycled) {
                    return;
                }
                if (RLottieDrawable.this.nativePtr != 0) {
                    RLottieDrawable rLottieDrawable = RLottieDrawable.this;
                    if (rLottieDrawable.isDice != 2 || rLottieDrawable.secondNativePtr != 0) {
                        if (RLottieDrawable.this.backgroundBitmap == null) {
                            try {
                                RLottieDrawable rLottieDrawable2 = RLottieDrawable.this;
                                rLottieDrawable2.backgroundBitmap = Bitmap.createBitmap(rLottieDrawable2.width, rLottieDrawable2.height, Bitmap.Config.ARGB_8888);
                            } catch (Throwable th) {
                                FileLog.e(th);
                            }
                        }
                        if (RLottieDrawable.this.backgroundBitmap != null) {
                            try {
                                if (!RLottieDrawable.this.pendingColorUpdates.isEmpty()) {
                                    for (Map.Entry entry : RLottieDrawable.this.pendingColorUpdates.entrySet()) {
                                        RLottieDrawable.setLayerColor(RLottieDrawable.this.nativePtr, (String) entry.getKey(), ((Integer) entry.getValue()).intValue());
                                    }
                                    RLottieDrawable.this.pendingColorUpdates.clear();
                                }
                            } catch (Exception unused) {
                            }
                            if (RLottieDrawable.this.pendingReplaceColors != null) {
                                RLottieDrawable.replaceColors(RLottieDrawable.this.nativePtr, RLottieDrawable.this.pendingReplaceColors);
                                RLottieDrawable.this.pendingReplaceColors = null;
                            }
                            try {
                                RLottieDrawable rLottieDrawable3 = RLottieDrawable.this;
                                int i = rLottieDrawable3.isDice;
                                if (i != 1 && i == 2) {
                                    j = rLottieDrawable3.secondNativePtr;
                                    if (RLottieDrawable.this.setLastFrame) {
                                        RLottieDrawable rLottieDrawable4 = RLottieDrawable.this;
                                        rLottieDrawable4.currentFrame = rLottieDrawable4.secondFramesCount - 1;
                                    }
                                } else {
                                    j = rLottieDrawable3.nativePtr;
                                }
                                long j2 = j;
                                RLottieDrawable rLottieDrawable5 = RLottieDrawable.this;
                                int i2 = rLottieDrawable5.currentFrame;
                                Bitmap bitmap = rLottieDrawable5.backgroundBitmap;
                                RLottieDrawable rLottieDrawable6 = RLottieDrawable.this;
                                if (RLottieDrawable.getFrame(j2, i2, bitmap, rLottieDrawable6.width, rLottieDrawable6.height, rLottieDrawable6.backgroundBitmap.getRowBytes(), true) == -1) {
                                    RLottieDrawable.uiHandler.post(RLottieDrawable.this.uiRunnableNoFrame);
                                    CountDownLatch countDownLatch = RLottieDrawable.this.frameWaitSync;
                                    if (countDownLatch != null) {
                                        countDownLatch.countDown();
                                        return;
                                    }
                                    return;
                                }
                                RLottieDrawable rLottieDrawable7 = RLottieDrawable.this;
                                if (rLottieDrawable7.metaData[2] != 0) {
                                    RLottieDrawable.uiHandler.post(rLottieDrawable7.uiRunnableGenerateCache);
                                    RLottieDrawable.this.metaData[2] = 0;
                                }
                                RLottieDrawable rLottieDrawable8 = RLottieDrawable.this;
                                rLottieDrawable8.nextRenderingBitmap = rLottieDrawable8.backgroundBitmap;
                                int i3 = RLottieDrawable.this.shouldLimitFps ? 2 : 1;
                                RLottieDrawable rLottieDrawable9 = RLottieDrawable.this;
                                int i4 = rLottieDrawable9.isDice;
                                if (i4 == 1) {
                                    int i5 = rLottieDrawable9.currentFrame;
                                    int i6 = i5 + i3;
                                    int i7 = rLottieDrawable9.diceSwitchFramesCount;
                                    if (i7 == -1) {
                                        i7 = rLottieDrawable9.metaData[0];
                                    }
                                    if (i6 < i7) {
                                        rLottieDrawable9.currentFrame = i5 + i3;
                                    } else {
                                        rLottieDrawable9.currentFrame = 0;
                                        rLottieDrawable9.nextFrameIsLast = false;
                                        if (RLottieDrawable.this.secondNativePtr != 0) {
                                            RLottieDrawable.this.isDice = 2;
                                        }
                                    }
                                } else if (i4 == 2) {
                                    int i8 = rLottieDrawable9.currentFrame;
                                    if (i8 + i3 < rLottieDrawable9.secondFramesCount) {
                                        rLottieDrawable9.currentFrame = i8 + i3;
                                    } else {
                                        rLottieDrawable9.nextFrameIsLast = true;
                                        RLottieDrawable.this.autoRepeatPlayCount++;
                                    }
                                } else {
                                    int i9 = rLottieDrawable9.customEndFrame;
                                    if (i9 >= 0 && rLottieDrawable9.playInDirectionOfCustomEndFrame) {
                                        int i10 = rLottieDrawable9.currentFrame;
                                        if (i10 > i9) {
                                            if (i10 - i3 >= i9) {
                                                rLottieDrawable9.currentFrame = i10 - i3;
                                                rLottieDrawable9.nextFrameIsLast = false;
                                            } else {
                                                rLottieDrawable9.nextFrameIsLast = true;
                                            }
                                        } else if (i10 + i3 < i9) {
                                            rLottieDrawable9.currentFrame = i10 + i3;
                                            rLottieDrawable9.nextFrameIsLast = false;
                                        } else {
                                            rLottieDrawable9.nextFrameIsLast = true;
                                        }
                                    } else {
                                        int i11 = rLottieDrawable9.currentFrame;
                                        int i12 = i11 + i3;
                                        if (i9 < 0) {
                                            i9 = rLottieDrawable9.metaData[0];
                                        }
                                        if (i12 < i9) {
                                            if (rLottieDrawable9.autoRepeat == 3) {
                                                rLottieDrawable9.nextFrameIsLast = true;
                                                RLottieDrawable.this.autoRepeatPlayCount++;
                                            } else {
                                                rLottieDrawable9.currentFrame = i11 + i3;
                                                rLottieDrawable9.nextFrameIsLast = false;
                                            }
                                        } else {
                                            int i13 = rLottieDrawable9.autoRepeat;
                                            if (i13 == 1) {
                                                rLottieDrawable9.currentFrame = 0;
                                                rLottieDrawable9.nextFrameIsLast = false;
                                            } else if (i13 == 2) {
                                                rLottieDrawable9.currentFrame = 0;
                                                rLottieDrawable9.nextFrameIsLast = true;
                                                RLottieDrawable.this.autoRepeatPlayCount++;
                                            } else {
                                                rLottieDrawable9.nextFrameIsLast = true;
                                            }
                                        }
                                    }
                                }
                            } catch (Exception e) {
                                FileLog.e(e);
                            }
                        }
                        RLottieDrawable.uiHandler.post(RLottieDrawable.this.uiRunnable);
                        CountDownLatch countDownLatch2 = RLottieDrawable.this.frameWaitSync;
                        if (countDownLatch2 != null) {
                            countDownLatch2.countDown();
                            return;
                        }
                        return;
                    }
                }
                CountDownLatch countDownLatch3 = RLottieDrawable.this.frameWaitSync;
                if (countDownLatch3 != null) {
                    countDownLatch3.countDown();
                }
                RLottieDrawable.uiHandler.post(RLottieDrawable.this.uiRunnableNoFrame);
            }
        };
        this.width = w;
        this.height = h;
        this.autoRepeat = 0;
        String res = readRes(null, rawRes);
        if (TextUtils.isEmpty(res)) {
            return;
        }
        getPaint().setFlags(2);
        this.nativePtr = createWithJson(res, name, iArr, colorReplacement);
        this.timeBetweenFrames = Math.max(16, (int) (1000.0f / iArr[1]));
        if (startDecode) {
            setAllowDecodeSingleFrame(true);
        }
    }

    public static String readRes(File path, int rawRes) {
        InputStream inputStreamOpenRawResource;
        byte[] bArr = readBufferLocal.get();
        if (bArr == null) {
            bArr = new byte[65536];
            readBufferLocal.set(bArr);
        }
        try {
            if (path != null) {
                inputStreamOpenRawResource = new FileInputStream(path);
            } else {
                inputStreamOpenRawResource = ApplicationLoader.applicationContext.getResources().openRawResource(rawRes);
            }
        } catch (Throwable unused) {
            inputStreamOpenRawResource = null;
        }
        try {
            byte[] bArr2 = bufferLocal.get();
            if (bArr2 == null) {
                bArr2 = new byte[Factory.DEVICE_HAS_CRAPPY_AAUDIO];
                bufferLocal.set(bArr2);
            }
            int i = 0;
            while (true) {
                int i2 = inputStreamOpenRawResource.read(bArr2, 0, bArr2.length);
                if (i2 >= 0) {
                    int i3 = i + i2;
                    if (bArr.length < i3) {
                        byte[] bArr3 = new byte[bArr.length * 2];
                        System.arraycopy(bArr, 0, bArr3, 0, i);
                        readBufferLocal.set(bArr3);
                        bArr = bArr3;
                    }
                    if (i2 > 0) {
                        System.arraycopy(bArr2, 0, bArr, i, i2);
                        i = i3;
                    }
                } else {
                    try {
                        break;
                    } catch (Throwable unused2) {
                    }
                }
            }
            inputStreamOpenRawResource.close();
            return new String(bArr, 0, i);
        } catch (Throwable unused3) {
            if (inputStreamOpenRawResource != null) {
                try {
                    inputStreamOpenRawResource.close();
                } catch (Throwable unused4) {
                }
            }
            return null;
        }
    }

    public int getCurrentFrame() {
        return this.currentFrame;
    }

    public int getCustomEndFrame() {
        return this.customEndFrame;
    }

    public long getDuration() {
        int[] iArr = this.metaData;
        return (long) ((iArr[0] / iArr[1]) * 1000.0f);
    }

    public void setPlayInDirectionOfCustomEndFrame(boolean value) {
        this.playInDirectionOfCustomEndFrame = value;
    }

    public boolean setCustomEndFrame(int frame) {
        if (this.customEndFrame == frame || frame > this.metaData[0]) {
            return false;
        }
        this.customEndFrame = frame;
        return true;
    }

    public int getFramesCount() {
        return this.metaData[0];
    }

    public void addParentView(View view) {
        if (view == null) {
            return;
        }
        int size = this.parentViews.size();
        int i = 0;
        while (i < size) {
            if (this.parentViews.get(i).get() == view) {
                return;
            }
            if (this.parentViews.get(i).get() == null) {
                this.parentViews.remove(i);
                size--;
                i--;
            }
            i++;
        }
        this.parentViews.add(0, new WeakReference<>(view));
    }

    public void removeParentView(View view) {
        if (view == null) {
            return;
        }
        int i = 0;
        int size = this.parentViews.size();
        while (i < size) {
            View view2 = this.parentViews.get(i).get();
            if (view2 == view || view2 == null) {
                this.parentViews.remove(i);
                size--;
                i--;
            }
            i++;
        }
    }

    protected boolean hasParentView() {
        if (getCallback() != null) {
            return true;
        }
        for (int size = this.parentViews.size(); size > 0; size--) {
            if (this.parentViews.get(0).get() != null) {
                return true;
            }
            this.parentViews.remove(0);
        }
        return false;
    }

    protected void invalidateInternal() {
        int size = this.parentViews.size();
        int i = 0;
        while (i < size) {
            View view = this.parentViews.get(i).get();
            if (view != null) {
                view.invalidate();
            } else {
                this.parentViews.remove(i);
                size--;
                i--;
            }
            i++;
        }
        if (getCallback() != null) {
            invalidateSelf();
        }
    }

    public void setAllowDecodeSingleFrame(boolean value) {
        this.decodeSingleFrame = value;
        if (value) {
            scheduleNextGetFrame();
        }
    }

    public void recycle() {
        this.isRunning = false;
        this.isRecycled = true;
        checkRunningTasks();
        if (this.loadingInBackground || this.secondLoadingInBackground) {
            this.destroyAfterLoading = true;
            return;
        }
        if (this.loadFrameTask == null && this.cacheGenerateTask == null) {
            if (this.nativePtr != 0) {
                destroy(this.nativePtr);
                this.nativePtr = 0L;
            }
            if (this.secondNativePtr != 0) {
                destroy(this.secondNativePtr);
                this.secondNativePtr = 0L;
            }
            recycleResources();
            return;
        }
        this.destroyWhenDone = true;
    }

    public void setAutoRepeat(int value) {
        if (this.autoRepeat == 2 && value == 3 && this.currentFrame != 0) {
            return;
        }
        this.autoRepeat = value;
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
        if (this.autoRepeat < 2 || this.autoRepeatPlayCount == 0) {
            this.isRunning = true;
            if (this.invalidateOnProgressSet) {
                this.isInvalid = true;
                if (this.loadFrameTask != null) {
                    this.doNotRemoveInvalidOnFrameReady = true;
                }
            }
            scheduleNextGetFrame();
            invalidateInternal();
        }
    }

    public boolean restart() {
        if (this.autoRepeat < 2 || this.autoRepeatPlayCount == 0) {
            return false;
        }
        this.autoRepeatPlayCount = 0;
        this.autoRepeat = 2;
        start();
        return true;
    }

    public void setVibrationPattern(HashMap<Integer, Integer> pattern) {
        this.vibrationPattern = pattern;
    }

    public void beginApplyLayerColors() {
        this.applyingLayerColors = true;
    }

    public void commitApplyLayerColors() {
        if (this.applyingLayerColors) {
            this.applyingLayerColors = false;
            if (!this.isRunning && this.decodeSingleFrame) {
                if (this.currentFrame <= 2) {
                    this.currentFrame = 0;
                }
                this.nextFrameIsLast = false;
                this.singleFrameDecoded = false;
                if (!scheduleNextGetFrame()) {
                    this.forceFrameRedraw = true;
                }
            }
            invalidateInternal();
        }
    }

    public void replaceColors(int[] colors) {
        this.newReplaceColors = colors;
        requestRedrawColors();
    }

    public void setLayerColor(String layerName, int color) {
        this.newColorUpdates.put(layerName, Integer.valueOf(color));
        requestRedrawColors();
    }

    private void requestRedrawColors() {
        if (!this.applyingLayerColors && !this.isRunning && this.decodeSingleFrame) {
            if (this.currentFrame <= 2) {
                this.currentFrame = 0;
            }
            this.nextFrameIsLast = false;
            this.singleFrameDecoded = false;
            if (!scheduleNextGetFrame()) {
                this.forceFrameRedraw = true;
            }
        }
        invalidateInternal();
    }

    protected boolean scheduleNextGetFrame() {
        if (this.loadFrameTask != null || this.nextRenderingBitmap != null || this.nativePtr == 0 || this.loadingInBackground || this.destroyWhenDone) {
            return false;
        }
        if (!this.isRunning) {
            boolean z = this.decodeSingleFrame;
            if (!z) {
                return false;
            }
            if (z && this.singleFrameDecoded) {
                return false;
            }
        }
        if (!this.newColorUpdates.isEmpty()) {
            this.pendingColorUpdates.putAll(this.newColorUpdates);
            this.newColorUpdates.clear();
        }
        int[] iArr = this.newReplaceColors;
        if (iArr != null) {
            this.pendingReplaceColors = iArr;
            this.newReplaceColors = null;
        }
        DispatchQueuePool dispatchQueuePool = loadFrameRunnableQueue;
        Runnable runnable = this.loadFrameRunnable;
        this.loadFrameTask = runnable;
        dispatchQueuePool.execute(runnable);
        return true;
    }

    public boolean isHeavyDrawable() {
        return this.isDice == 0;
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        this.isRunning = false;
    }

    public void setCurrentFrame(int frame) {
        setCurrentFrame(frame, true);
    }

    public void setCurrentFrame(int frame, boolean async) throws InterruptedException {
        setCurrentFrame(frame, async, false);
    }

    public void setCurrentFrame(int frame, boolean async, boolean resetFrame) throws InterruptedException {
        if (frame < 0 || frame > this.metaData[0]) {
            return;
        }
        this.currentFrame = frame;
        this.nextFrameIsLast = false;
        this.singleFrameDecoded = false;
        if (this.invalidateOnProgressSet) {
            this.isInvalid = true;
            if (this.loadFrameTask != null) {
                this.doNotRemoveInvalidOnFrameReady = true;
            }
        }
        if ((!async || resetFrame) && this.waitingForNextTask && this.nextRenderingBitmap != null) {
            this.backgroundBitmap = this.nextRenderingBitmap;
            this.nextRenderingBitmap = null;
            this.loadFrameTask = null;
            this.waitingForNextTask = false;
        }
        if (!async && this.loadFrameTask == null) {
            this.frameWaitSync = new CountDownLatch(1);
        }
        if (!scheduleNextGetFrame()) {
            this.forceFrameRedraw = true;
        } else if (!async) {
            try {
                this.frameWaitSync.await();
            } catch (Exception e) {
                FileLog.e(e);
            }
            this.frameWaitSync = null;
        }
        invalidateSelf();
    }

    public void setProgressMs(long ms) {
        setCurrentFrame((int) ((Math.max(0L, ms) / this.timeBetweenFrames) % this.metaData[0]), true, true);
    }

    public void setProgress(float progress) {
        setProgress(progress, true);
    }

    public void setProgress(float progress, boolean async) throws InterruptedException {
        if (progress < 0.0f) {
            progress = 0.0f;
        } else if (progress > 1.0f) {
            progress = 1.0f;
        }
        setCurrentFrame((int) (this.metaData[0] * progress), async);
    }

    public void setCurrentParentView(View view) {
        this.currentParentView = view;
    }

    private boolean isCurrentParentViewMaster() {
        if (getCallback() != null || this.parentViews.size() <= 1) {
            return true;
        }
        int size = this.parentViews.size();
        int i = 0;
        while (i < size) {
            View view = this.parentViews.get(i).get();
            if (view == null) {
                this.parentViews.remove(i);
                size--;
                i--;
            } else if (view.isShown()) {
                return view == this.currentParentView;
            }
            i++;
        }
        return true;
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return this.isRunning;
    }

    @Override // android.graphics.drawable.BitmapDrawable, android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.height;
    }

    @Override // android.graphics.drawable.BitmapDrawable, android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.width;
    }

    @Override // android.graphics.drawable.BitmapDrawable, android.graphics.drawable.Drawable
    protected void onBoundsChange(android.graphics.Rect bounds) {
        super.onBoundsChange(bounds);
        this.applyTransformation = true;
    }

    private void setCurrentFrame(long now, long timeDiff, long timeCheck, boolean force) {
        WeakReference<Runnable> weakReference;
        Runnable runnable;
        WeakReference<Runnable> weakReference2;
        this.backgroundBitmap = this.renderingBitmap;
        this.renderingBitmap = this.nextRenderingBitmap;
        this.nextRenderingBitmap = null;
        if (this.isDice == 2 && (weakReference2 = this.onFinishCallback) != null && this.currentFrame - 1 >= this.finishFrame) {
            Runnable runnable2 = weakReference2.get();
            if (runnable2 != null) {
                runnable2.run();
            }
            this.onFinishCallback = null;
        }
        if (this.nextFrameIsLast) {
            stop();
        }
        this.loadFrameTask = null;
        if (this.doNotRemoveInvalidOnFrameReady) {
            this.doNotRemoveInvalidOnFrameReady = false;
        } else if (this.isInvalid) {
            this.isInvalid = false;
        }
        this.singleFrameDecoded = true;
        this.waitingForNextTask = false;
        if (AndroidUtilities.screenRefreshRate <= 60.0f) {
            this.lastFrameTime = now;
        } else {
            this.lastFrameTime = now - Math.min(16L, timeDiff - timeCheck);
        }
        if (force && this.forceFrameRedraw) {
            this.singleFrameDecoded = false;
            this.forceFrameRedraw = false;
        }
        if (this.isDice == 0 && (weakReference = this.onFinishCallback) != null && this.currentFrame >= this.finishFrame && (runnable = weakReference.get()) != null) {
            runnable.run();
        }
        scheduleNextGetFrame();
    }

    @Override // android.graphics.drawable.BitmapDrawable, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (this.nativePtr == 0 || this.destroyWhenDone) {
            return;
        }
        updateCurrentFrame();
        if (this.isInvalid || this.renderingBitmap == null) {
            return;
        }
        if (this.applyTransformation) {
            this.dstRect.set(getBounds());
            this.scaleX = this.dstRect.width() / this.width;
            this.scaleY = this.dstRect.height() / this.height;
            this.applyTransformation = false;
            this.needScale = Math.abs(this.dstRect.width() - this.width) >= AndroidUtilities.dp(1.0f) || Math.abs(this.dstRect.width() - this.width) >= AndroidUtilities.dp(1.0f);
        }
        if (!this.needScale) {
            Bitmap bitmap = this.renderingBitmap;
            android.graphics.Rect rect = this.dstRect;
            canvas.drawBitmap(bitmap, rect.left, rect.top, getPaint());
        } else {
            canvas.save();
            android.graphics.Rect rect2 = this.dstRect;
            canvas.translate(rect2.left, rect2.top);
            canvas.scale(this.scaleX, this.scaleY);
            canvas.drawBitmap(this.renderingBitmap, 0.0f, 0.0f, getPaint());
            canvas.restore();
        }
        if (this.isRunning) {
            invalidateInternal();
        }
    }

    public void updateCurrentFrame() {
        int i;
        Integer num;
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        long jAbs = Math.abs(jElapsedRealtime - this.lastFrameTime);
        if (AndroidUtilities.screenRefreshRate <= 60.0f) {
            i = this.timeBetweenFrames - 6;
        } else {
            i = this.timeBetweenFrames;
        }
        if (this.isRunning) {
            if (this.renderingBitmap == null && this.nextRenderingBitmap == null) {
                scheduleNextGetFrame();
                return;
            }
            if (this.nextRenderingBitmap != null) {
                if ((this.renderingBitmap == null || jAbs >= i) && isCurrentParentViewMaster()) {
                    HashMap<Integer, Integer> map = this.vibrationPattern;
                    if (map != null && this.currentParentView != null && (num = map.get(Integer.valueOf(this.currentFrame - 1))) != null) {
                        this.currentParentView.performHapticFeedback(num.intValue() == 1 ? 0 : 3, 2);
                    }
                    setCurrentFrame(jElapsedRealtime, jAbs, i, false);
                    return;
                }
                return;
            }
            return;
        }
        if ((this.forceFrameRedraw || (this.decodeSingleFrame && jAbs >= i)) && this.nextRenderingBitmap != null) {
            setCurrentFrame(jElapsedRealtime, jAbs, i, true);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumHeight() {
        return this.height;
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumWidth() {
        return this.width;
    }

    public Bitmap getAnimatedBitmap() {
        if (this.renderingBitmap != null) {
            return this.renderingBitmap;
        }
        if (this.nextRenderingBitmap != null) {
            return this.nextRenderingBitmap;
        }
        return null;
    }

    public boolean hasBitmap() {
        return (this.nativePtr == 0 || (this.renderingBitmap == null && this.nextRenderingBitmap == null) || this.isInvalid) ? false : true;
    }

    public void setInvalidateOnProgressSet(boolean value) {
        this.invalidateOnProgressSet = value;
    }

    public boolean isGeneratingCache() {
        return this.cacheGenerateTask != null;
    }
}
