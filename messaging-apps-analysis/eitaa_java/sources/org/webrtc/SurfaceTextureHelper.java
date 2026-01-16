package org.webrtc;

import android.annotation.TargetApi;
import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import java.util.concurrent.Callable;
import org.webrtc.EglBase;
import org.webrtc.TextureBufferImpl;
import org.webrtc.VideoFrame;

/* loaded from: classes3.dex */
public class SurfaceTextureHelper {
    private static final String TAG = "SurfaceTextureHelper";
    private final EglBase eglBase;
    private final FrameRefMonitor frameRefMonitor;
    private int frameRotation;
    private final Handler handler;
    private boolean hasPendingTexture;
    private boolean isQuitting;
    private volatile boolean isTextureInUse;
    private VideoSink listener;
    private final int oesTextureId;
    private VideoSink pendingListener;
    final Runnable setListenerRunnable;
    private final SurfaceTexture surfaceTexture;
    private int textureHeight;
    private final TextureBufferImpl.RefCountMonitor textureRefCountMonitor;
    private int textureWidth;
    private final TimestampAligner timestampAligner;
    private final YuvConverter yuvConverter;

    public interface FrameRefMonitor {
        void onDestroyBuffer(VideoFrame.TextureBuffer textureBuffer);

        void onNewBuffer(VideoFrame.TextureBuffer textureBuffer);

        void onReleaseBuffer(VideoFrame.TextureBuffer textureBuffer);

        void onRetainBuffer(VideoFrame.TextureBuffer textureBuffer);
    }

    public static SurfaceTextureHelper create(final String threadName, final EglBase.Context sharedContext, final boolean alignTimestamps, final YuvConverter yuvConverter, final FrameRefMonitor frameRefMonitor) {
        HandlerThread handlerThread = new HandlerThread(threadName);
        handlerThread.start();
        final Handler handler = new Handler(handlerThread.getLooper());
        return (SurfaceTextureHelper) ThreadUtils.invokeAtFrontUninterruptibly(handler, new Callable<SurfaceTextureHelper>() { // from class: org.webrtc.SurfaceTextureHelper.1
            @Override // java.util.concurrent.Callable
            public SurfaceTextureHelper call() {
                try {
                    return new SurfaceTextureHelper(sharedContext, handler, alignTimestamps, yuvConverter, frameRefMonitor);
                } catch (RuntimeException e) {
                    Logging.e(SurfaceTextureHelper.TAG, threadName + " create failure", e);
                    return null;
                }
            }
        });
    }

    public static SurfaceTextureHelper create(final String threadName, final EglBase.Context sharedContext) {
        return create(threadName, sharedContext, false, new YuvConverter(), null);
    }

    public static SurfaceTextureHelper create(final String threadName, final EglBase.Context sharedContext, boolean alignTimestamps) {
        return create(threadName, sharedContext, alignTimestamps, new YuvConverter(), null);
    }

    public static SurfaceTextureHelper create(final String threadName, final EglBase.Context sharedContext, boolean alignTimestamps, YuvConverter yuvConverter) {
        return create(threadName, sharedContext, alignTimestamps, yuvConverter, null);
    }

    private SurfaceTextureHelper(EglBase.Context sharedContext, Handler handler, boolean alignTimestamps, YuvConverter yuvConverter, FrameRefMonitor frameRefMonitor) {
        this.textureRefCountMonitor = new TextureBufferImpl.RefCountMonitor() { // from class: org.webrtc.SurfaceTextureHelper.2
            @Override // org.webrtc.TextureBufferImpl.RefCountMonitor
            public void onRetain(TextureBufferImpl textureBuffer) {
                if (SurfaceTextureHelper.this.frameRefMonitor != null) {
                    SurfaceTextureHelper.this.frameRefMonitor.onRetainBuffer(textureBuffer);
                }
            }

            @Override // org.webrtc.TextureBufferImpl.RefCountMonitor
            public void onRelease(TextureBufferImpl textureBuffer) {
                if (SurfaceTextureHelper.this.frameRefMonitor != null) {
                    SurfaceTextureHelper.this.frameRefMonitor.onReleaseBuffer(textureBuffer);
                }
            }

            @Override // org.webrtc.TextureBufferImpl.RefCountMonitor
            public void onDestroy(TextureBufferImpl textureBuffer) {
                SurfaceTextureHelper.this.returnTextureFrame();
                if (SurfaceTextureHelper.this.frameRefMonitor != null) {
                    SurfaceTextureHelper.this.frameRefMonitor.onDestroyBuffer(textureBuffer);
                }
            }
        };
        this.setListenerRunnable = new Runnable() { // from class: org.webrtc.SurfaceTextureHelper.3
            @Override // java.lang.Runnable
            public void run() {
                Logging.d(SurfaceTextureHelper.TAG, "Setting listener to " + SurfaceTextureHelper.this.pendingListener);
                SurfaceTextureHelper surfaceTextureHelper = SurfaceTextureHelper.this;
                surfaceTextureHelper.listener = surfaceTextureHelper.pendingListener;
                SurfaceTextureHelper.this.pendingListener = null;
                if (SurfaceTextureHelper.this.hasPendingTexture) {
                    SurfaceTextureHelper.this.updateTexImage();
                    SurfaceTextureHelper.this.hasPendingTexture = false;
                }
            }
        };
        if (handler.getLooper().getThread() != Thread.currentThread()) {
            throw new IllegalStateException("SurfaceTextureHelper must be created on the handler thread");
        }
        this.handler = handler;
        this.timestampAligner = alignTimestamps ? new TimestampAligner() : null;
        this.yuvConverter = yuvConverter;
        this.frameRefMonitor = frameRefMonitor;
        EglBase eglBaseCreate = EglBase.CC.create(sharedContext, EglBase.CONFIG_PIXEL_BUFFER);
        this.eglBase = eglBaseCreate;
        try {
            eglBaseCreate.createDummyPbufferSurface();
            eglBaseCreate.makeCurrent();
            int iGenerateTexture = GlUtil.generateTexture(36197);
            this.oesTextureId = iGenerateTexture;
            SurfaceTexture surfaceTexture = new SurfaceTexture(iGenerateTexture);
            this.surfaceTexture = surfaceTexture;
            setOnFrameAvailableListener(surfaceTexture, new SurfaceTexture.OnFrameAvailableListener() { // from class: org.webrtc.-$$Lambda$SurfaceTextureHelper$073Iq_oVBecUTQR2U0VmYQ8_7lM
                @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
                public final void onFrameAvailable(SurfaceTexture surfaceTexture2) {
                    this.f$0.lambda$new$0$SurfaceTextureHelper(surfaceTexture2);
                }
            }, handler);
        } catch (RuntimeException e) {
            this.eglBase.release();
            handler.getLooper().quit();
            throw e;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$new$0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$new$0$SurfaceTextureHelper(SurfaceTexture surfaceTexture) {
        if (this.hasPendingTexture) {
            Logging.d(TAG, "A frame is already pending, dropping frame.");
        }
        this.hasPendingTexture = true;
        tryDeliverTextureFrame();
    }

    @TargetApi(21)
    private static void setOnFrameAvailableListener(SurfaceTexture surfaceTexture, SurfaceTexture.OnFrameAvailableListener listener, Handler handler) {
        if (Build.VERSION.SDK_INT >= 21) {
            surfaceTexture.setOnFrameAvailableListener(listener, handler);
        } else {
            surfaceTexture.setOnFrameAvailableListener(listener);
        }
    }

    public void startListening(final VideoSink listener) {
        if (this.listener != null || this.pendingListener != null) {
            throw new IllegalStateException("SurfaceTextureHelper listener has already been set.");
        }
        this.pendingListener = listener;
        this.handler.post(this.setListenerRunnable);
    }

    public void stopListening() {
        Logging.d(TAG, "stopListening()");
        this.handler.removeCallbacks(this.setListenerRunnable);
        ThreadUtils.invokeAtFrontUninterruptibly(this.handler, new Runnable() { // from class: org.webrtc.-$$Lambda$SurfaceTextureHelper$Sh0ywtqKkQ0umpu9CzT8Hl__d1U
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$stopListening$1$SurfaceTextureHelper();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$stopListening$1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$stopListening$1$SurfaceTextureHelper() {
        this.listener = null;
        this.pendingListener = null;
    }

    public void setTextureSize(final int textureWidth, final int textureHeight) {
        if (textureWidth <= 0) {
            throw new IllegalArgumentException("Texture width must be positive, but was " + textureWidth);
        }
        if (textureHeight <= 0) {
            throw new IllegalArgumentException("Texture height must be positive, but was " + textureHeight);
        }
        this.surfaceTexture.setDefaultBufferSize(textureWidth, textureHeight);
        this.handler.post(new Runnable() { // from class: org.webrtc.-$$Lambda$SurfaceTextureHelper$BOw0CKPXmtvJTWQbaqJg5vLMZws
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$setTextureSize$2$SurfaceTextureHelper(textureWidth, textureHeight);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$setTextureSize$2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$setTextureSize$2$SurfaceTextureHelper(int i, int i2) {
        this.textureWidth = i;
        this.textureHeight = i2;
        tryDeliverTextureFrame();
    }

    public void forceFrame() {
        this.handler.post(new Runnable() { // from class: org.webrtc.-$$Lambda$SurfaceTextureHelper$KyGzQj-AX1JDTnHcwljaBNN8SFw
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$forceFrame$3$SurfaceTextureHelper();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$forceFrame$3, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$forceFrame$3$SurfaceTextureHelper() {
        this.hasPendingTexture = true;
        tryDeliverTextureFrame();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$setFrameRotation$4, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$setFrameRotation$4$SurfaceTextureHelper(int i) {
        this.frameRotation = i;
    }

    public void setFrameRotation(final int rotation) {
        this.handler.post(new Runnable() { // from class: org.webrtc.-$$Lambda$SurfaceTextureHelper$OfMUO2pSB7RpEy7JJ6CVxdtvCsc
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$setFrameRotation$4$SurfaceTextureHelper(rotation);
            }
        });
    }

    public SurfaceTexture getSurfaceTexture() {
        return this.surfaceTexture;
    }

    public Handler getHandler() {
        return this.handler;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void returnTextureFrame() {
        this.handler.post(new Runnable() { // from class: org.webrtc.-$$Lambda$SurfaceTextureHelper$SmAcBpiTK4gw5pUB-r5bk85WY8Q
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$returnTextureFrame$5$SurfaceTextureHelper();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$returnTextureFrame$5, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$returnTextureFrame$5$SurfaceTextureHelper() {
        this.isTextureInUse = false;
        if (this.isQuitting) {
            release();
        } else {
            tryDeliverTextureFrame();
        }
    }

    public boolean isTextureInUse() {
        return this.isTextureInUse;
    }

    public void dispose() {
        Logging.d(TAG, "dispose()");
        ThreadUtils.invokeAtFrontUninterruptibly(this.handler, new Runnable() { // from class: org.webrtc.-$$Lambda$SurfaceTextureHelper$72pjJaZeXOpnOvwdgP2Ugyu21Hk
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$dispose$6$SurfaceTextureHelper();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$dispose$6, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$dispose$6$SurfaceTextureHelper() {
        this.isQuitting = true;
        if (this.isTextureInUse) {
            return;
        }
        release();
    }

    @Deprecated
    public VideoFrame.I420Buffer textureToYuv(final VideoFrame.TextureBuffer textureBuffer) {
        return textureBuffer.toI420();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTexImage() {
        synchronized (EglBase.lock) {
            try {
                this.surfaceTexture.updateTexImage();
            } catch (Throwable unused) {
            }
        }
    }

    private void tryDeliverTextureFrame() {
        if (this.handler.getLooper().getThread() != Thread.currentThread()) {
            throw new IllegalStateException("Wrong thread.");
        }
        if (this.isQuitting || !this.hasPendingTexture || this.isTextureInUse || this.listener == null) {
            return;
        }
        if (this.textureWidth == 0 || this.textureHeight == 0) {
            Logging.w(TAG, "Texture size has not been set.");
            return;
        }
        this.isTextureInUse = true;
        this.hasPendingTexture = false;
        updateTexImage();
        float[] fArr = new float[16];
        this.surfaceTexture.getTransformMatrix(fArr);
        long timestamp = this.surfaceTexture.getTimestamp();
        TimestampAligner timestampAligner = this.timestampAligner;
        if (timestampAligner != null) {
            timestamp = timestampAligner.translateTimestamp(timestamp);
        }
        TextureBufferImpl textureBufferImpl = new TextureBufferImpl(this.textureWidth, this.textureHeight, VideoFrame.TextureBuffer.Type.OES, this.oesTextureId, RendererCommon.convertMatrixToAndroidGraphicsMatrix(fArr), this.handler, this.yuvConverter, this.textureRefCountMonitor);
        FrameRefMonitor frameRefMonitor = this.frameRefMonitor;
        if (frameRefMonitor != null) {
            frameRefMonitor.onNewBuffer(textureBufferImpl);
        }
        VideoFrame videoFrame = new VideoFrame(textureBufferImpl, this.frameRotation, timestamp);
        this.listener.onFrame(videoFrame);
        videoFrame.release();
    }

    private void release() {
        if (this.handler.getLooper().getThread() != Thread.currentThread()) {
            throw new IllegalStateException("Wrong thread.");
        }
        if (this.isTextureInUse || !this.isQuitting) {
            throw new IllegalStateException("Unexpected release.");
        }
        this.yuvConverter.release();
        GLES20.glDeleteTextures(1, new int[]{this.oesTextureId}, 0);
        this.surfaceTexture.release();
        this.eglBase.release();
        this.handler.getLooper().quit();
        TimestampAligner timestampAligner = this.timestampAligner;
        if (timestampAligner != null) {
            timestampAligner.dispose();
        }
    }
}
