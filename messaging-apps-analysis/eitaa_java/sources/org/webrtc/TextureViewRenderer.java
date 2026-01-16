package org.webrtc;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.SurfaceTexture;
import android.os.Looper;
import android.view.TextureView;
import android.view.View;
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.messenger.voip.VoIPService;
import java.util.concurrent.CountDownLatch;
import org.webrtc.EglBase;
import org.webrtc.EglRenderer;
import org.webrtc.GlGenericDrawer;
import org.webrtc.RendererCommon;

/* loaded from: classes3.dex */
public class TextureViewRenderer extends TextureView implements TextureView.SurfaceTextureListener, VideoSink, RendererCommon.RendererEvents {
    private static final String TAG = "TextureViewRenderer";
    private TextureView backgroundRenderer;
    private int cameraRotation;
    private final TextureEglRenderer eglRenderer;
    private boolean enableFixedSize;
    private boolean isCamera;
    private int maxTextureSize;
    private boolean mirror;
    private OrientationHelper orientationHelper;
    private VideoSink parentSink;
    private RendererCommon.RendererEvents rendererEvents;
    private final String resourceName;
    private boolean rotateTextureWitchScreen;
    public int rotatedFrameHeight;
    public int rotatedFrameWidth;
    private int screenRotation;
    private int surfaceHeight;
    private int surfaceWidth;
    int textureRotation;
    Runnable updateScreenRunnable;
    boolean useCameraRotation;
    private int videoHeight;
    private final RendererCommon.VideoLayoutMeasure videoLayoutMeasure;
    private int videoWidth;

    public void setBackgroundRenderer(TextureView backgroundRenderer) {
        this.backgroundRenderer = backgroundRenderer;
        backgroundRenderer.setSurfaceTextureListener(new TextureView.SurfaceTextureListener() { // from class: org.webrtc.TextureViewRenderer.1
            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i1) {
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i1) {
                TextureViewRenderer.this.createBackgroundSurface(surfaceTexture);
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                ThreadUtils.checkIsOnMainThread();
                TextureViewRenderer.this.eglRenderer.releaseEglSurface(null, true);
                return false;
            }
        });
    }

    public void clearFirstFrame() {
        TextureEglRenderer textureEglRenderer = this.eglRenderer;
        textureEglRenderer.firstFrameRendered = false;
        textureEglRenderer.isFirstFrameRendered = false;
    }

    public static class TextureEglRenderer extends EglRenderer implements TextureView.SurfaceTextureListener {
        private static final String TAG = "TextureEglRenderer";
        private int frameRotation;
        private boolean isFirstFrameRendered;
        private boolean isRenderingPaused;
        private final Object layoutLock;
        private RendererCommon.RendererEvents rendererEvents;
        private int rotatedFrameHeight;
        private int rotatedFrameWidth;

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        }

        public TextureEglRenderer(String name) {
            super(name);
            this.layoutLock = new Object();
        }

        public void init(final EglBase.Context sharedContext, RendererCommon.RendererEvents rendererEvents, final int[] configAttributes, RendererCommon.GlDrawer drawer) {
            ThreadUtils.checkIsOnMainThread();
            this.rendererEvents = rendererEvents;
            synchronized (this.layoutLock) {
                this.isFirstFrameRendered = false;
                this.rotatedFrameWidth = 0;
                this.rotatedFrameHeight = 0;
                this.frameRotation = 0;
            }
            super.init(sharedContext, configAttributes, drawer);
        }

        @Override // org.webrtc.EglRenderer
        public void init(final EglBase.Context sharedContext, final int[] configAttributes, RendererCommon.GlDrawer drawer) {
            init(sharedContext, (RendererCommon.RendererEvents) null, configAttributes, drawer);
        }

        @Override // org.webrtc.EglRenderer
        public void setFpsReduction(float fps) {
            synchronized (this.layoutLock) {
                this.isRenderingPaused = fps == 0.0f;
            }
            super.setFpsReduction(fps);
        }

        @Override // org.webrtc.EglRenderer
        public void disableFpsReduction() {
            synchronized (this.layoutLock) {
                this.isRenderingPaused = false;
            }
            super.disableFpsReduction();
        }

        @Override // org.webrtc.EglRenderer
        public void pauseVideo() {
            synchronized (this.layoutLock) {
                this.isRenderingPaused = true;
            }
            super.pauseVideo();
        }

        @Override // org.webrtc.EglRenderer, org.webrtc.VideoSink
        public void onFrame(VideoFrame frame) {
            updateFrameDimensionsAndReportEvents(frame);
            super.onFrame(frame);
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int width, int height) {
            ThreadUtils.checkIsOnMainThread();
            createEglSurface(surfaceTexture);
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int width, int height) {
            ThreadUtils.checkIsOnMainThread();
            logD("surfaceChanged: size: " + width + "x" + height);
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            ThreadUtils.checkIsOnMainThread();
            CountDownLatch countDownLatch = new CountDownLatch(1);
            releaseEglSurface(new $$Lambda$xXXywdCqM5leaxXkxy473i7s2A(countDownLatch), false);
            ThreadUtils.awaitUninterruptibly(countDownLatch);
            return true;
        }

        private void updateFrameDimensionsAndReportEvents(VideoFrame frame) {
            synchronized (this.layoutLock) {
                if (this.isRenderingPaused) {
                    return;
                }
                if (this.rotatedFrameWidth != frame.getRotatedWidth() || this.rotatedFrameHeight != frame.getRotatedHeight() || this.frameRotation != frame.getRotation()) {
                    logD("Reporting frame resolution changed to " + frame.getBuffer().getWidth() + "x" + frame.getBuffer().getHeight() + " with rotation " + frame.getRotation());
                    RendererCommon.RendererEvents rendererEvents = this.rendererEvents;
                    if (rendererEvents != null) {
                        rendererEvents.onFrameResolutionChanged(frame.getBuffer().getWidth(), frame.getBuffer().getHeight(), frame.getRotation());
                    }
                    this.rotatedFrameWidth = frame.getRotatedWidth();
                    this.rotatedFrameHeight = frame.getRotatedHeight();
                    this.frameRotation = frame.getRotation();
                }
            }
        }

        private void logD(String string) {
            Logging.d(TAG, this.name + ": " + string);
        }

        @Override // org.webrtc.EglRenderer
        protected void onFirstFrameRendered() {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.webrtc.-$$Lambda$TextureViewRenderer$TextureEglRenderer$1xg_P1AFlTrZF78tjcROeHyk9Pg
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onFirstFrameRendered$0$TextureViewRenderer$TextureEglRenderer();
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$onFirstFrameRendered$0, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$onFirstFrameRendered$0$TextureViewRenderer$TextureEglRenderer() {
            this.isFirstFrameRendered = true;
            this.rendererEvents.onFirstFrameRendered();
        }
    }

    public TextureViewRenderer(Context context) {
        super(context);
        this.videoLayoutMeasure = new RendererCommon.VideoLayoutMeasure();
        String resourceName = getResourceName();
        this.resourceName = resourceName;
        this.eglRenderer = new TextureEglRenderer(resourceName);
        setSurfaceTextureListener(this);
    }

    public void init(EglBase.Context sharedContext, RendererCommon.RendererEvents rendererEvents) {
        init(sharedContext, rendererEvents, EglBase.CONFIG_PLAIN, new GlRectDrawer());
    }

    public void init(final EglBase.Context sharedContext, RendererCommon.RendererEvents rendererEvents, final int[] configAttributes, RendererCommon.GlDrawer drawer) {
        ThreadUtils.checkIsOnMainThread();
        this.rendererEvents = rendererEvents;
        this.rotatedFrameWidth = 0;
        this.rotatedFrameHeight = 0;
        this.eglRenderer.init(sharedContext, this, configAttributes, drawer);
    }

    public void release() {
        this.eglRenderer.release();
        OrientationHelper orientationHelper = this.orientationHelper;
        if (orientationHelper != null) {
            orientationHelper.stop();
        }
    }

    public void addFrameListener(EglRenderer.FrameListener listener, float scale, RendererCommon.GlDrawer drawerParam) {
        this.eglRenderer.addFrameListener(listener, scale, drawerParam);
    }

    public void getRenderBufferBitmap(GlGenericDrawer.TextureCallback callback) {
        this.eglRenderer.getTexture(callback);
    }

    public void addFrameListener(EglRenderer.FrameListener listener, float scale) {
        this.eglRenderer.addFrameListener(listener, scale);
    }

    public void removeFrameListener(EglRenderer.FrameListener listener) {
        this.eglRenderer.removeFrameListener(listener);
    }

    public void setIsCamera(boolean value) {
        this.isCamera = value;
        if (value) {
            return;
        }
        OrientationHelper orientationHelper = new OrientationHelper() { // from class: org.webrtc.TextureViewRenderer.2
            @Override // org.webrtc.OrientationHelper
            protected void onOrientationUpdate(int orientation) {
                if (TextureViewRenderer.this.isCamera) {
                    return;
                }
                TextureViewRenderer.this.updateRotation();
            }
        };
        this.orientationHelper = orientationHelper;
        orientationHelper.start();
    }

    public void setEnableHardwareScaler(boolean enabled) {
        ThreadUtils.checkIsOnMainThread();
        this.enableFixedSize = enabled;
        updateSurfaceSize();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateRotation() {
        View view;
        float f;
        float f2;
        float fMin;
        if (this.orientationHelper == null || this.rotatedFrameWidth == 0 || this.rotatedFrameHeight == 0 || (view = (View) getParent()) == null) {
            return;
        }
        int orientation = this.orientationHelper.getOrientation();
        float measuredWidth = getMeasuredWidth();
        float measuredHeight = getMeasuredHeight();
        float measuredWidth2 = view.getMeasuredWidth();
        float measuredHeight2 = view.getMeasuredHeight();
        if (orientation == 90 || orientation == 270) {
            f = measuredWidth;
            f2 = measuredHeight;
        } else {
            f2 = measuredWidth;
            f = measuredHeight;
        }
        if (f2 < f) {
            fMin = Math.max(f2 / measuredWidth, f / measuredHeight);
        } else {
            fMin = Math.min(f2 / measuredWidth, f / measuredHeight);
        }
        float f3 = f2 * fMin;
        float f4 = f * fMin;
        if (Math.abs((f3 / f4) - (measuredWidth2 / measuredHeight2)) < 0.1f) {
            fMin *= Math.max(measuredWidth2 / f3, measuredHeight2 / f4);
        }
        if (orientation == 270) {
            orientation = -90;
        }
        animate().scaleX(fMin).scaleY(fMin).rotation(-orientation).setDuration(180L).start();
    }

    public void setMirror(final boolean mirror) {
        if (this.mirror != mirror) {
            this.mirror = mirror;
            if (this.rotateTextureWitchScreen) {
                onRotationChanged();
            } else {
                this.eglRenderer.setMirror(mirror);
            }
            updateSurfaceSize();
            requestLayout();
        }
    }

    public void setScalingType(RendererCommon.ScalingType scalingType) {
        ThreadUtils.checkIsOnMainThread();
        this.videoLayoutMeasure.setScalingType(scalingType);
        requestLayout();
    }

    public void setScalingType(RendererCommon.ScalingType scalingTypeMatchOrientation, RendererCommon.ScalingType scalingTypeMismatchOrientation) {
        ThreadUtils.checkIsOnMainThread();
        this.videoLayoutMeasure.setScalingType(scalingTypeMatchOrientation, scalingTypeMismatchOrientation);
        requestLayout();
    }

    public void setFpsReduction(float fps) {
        this.eglRenderer.setFpsReduction(fps);
    }

    public void disableFpsReduction() {
        this.eglRenderer.disableFpsReduction();
    }

    public void pauseVideo() {
        this.eglRenderer.pauseVideo();
    }

    @Override // org.webrtc.VideoSink
    public void onFrame(VideoFrame frame) {
        this.eglRenderer.onFrame(frame);
    }

    @Override // android.view.View
    protected void onMeasure(int widthSpec, int heightSpec) {
        Point pointMeasure;
        ThreadUtils.checkIsOnMainThread();
        if (!this.isCamera && this.rotateTextureWitchScreen) {
            updateVideoSizes();
        }
        int i = this.maxTextureSize;
        if (i > 0) {
            pointMeasure = this.videoLayoutMeasure.measure(this.isCamera, View.MeasureSpec.makeMeasureSpec(Math.min(i, View.MeasureSpec.getSize(widthSpec)), View.MeasureSpec.getMode(widthSpec)), View.MeasureSpec.makeMeasureSpec(Math.min(this.maxTextureSize, View.MeasureSpec.getSize(heightSpec)), View.MeasureSpec.getMode(heightSpec)), this.rotatedFrameWidth, this.rotatedFrameHeight);
        } else {
            pointMeasure = this.videoLayoutMeasure.measure(this.isCamera, widthSpec, heightSpec, this.rotatedFrameWidth, this.rotatedFrameHeight);
        }
        setMeasuredDimension(pointMeasure.x, pointMeasure.y);
        if (this.rotatedFrameWidth != 0 && this.rotatedFrameHeight != 0) {
            this.eglRenderer.setLayoutAspectRatio(getMeasuredWidth() / getMeasuredHeight());
        }
        updateSurfaceSize();
    }

    private void updateSurfaceSize() {
        ThreadUtils.checkIsOnMainThread();
        if (this.enableFixedSize && this.rotatedFrameWidth != 0 && this.rotatedFrameHeight != 0 && getWidth() != 0 && getHeight() != 0) {
            float width = getWidth() / getHeight();
            int i = this.rotatedFrameWidth;
            int i2 = this.rotatedFrameHeight;
            if (i / i2 > width) {
                i = (int) (i2 * width);
            } else {
                i2 = (int) (i2 / width);
            }
            int iMin = Math.min(getWidth(), i);
            int iMin2 = Math.min(getHeight(), i2);
            logD("updateSurfaceSize. Layout size: " + getWidth() + "x" + getHeight() + ", frame size: " + this.rotatedFrameWidth + "x" + this.rotatedFrameHeight + ", requested surface size: " + iMin + "x" + iMin2 + ", old surface size: " + this.surfaceWidth + "x" + this.surfaceHeight);
            if (iMin == this.surfaceWidth && iMin2 == this.surfaceHeight) {
                return;
            }
            this.surfaceWidth = iMin;
            this.surfaceHeight = iMin2;
            return;
        }
        this.surfaceHeight = 0;
        this.surfaceWidth = 0;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surface, int width, int height) {
        ThreadUtils.checkIsOnMainThread();
        this.surfaceHeight = 0;
        this.surfaceWidth = 0;
        updateSurfaceSize();
        this.eglRenderer.onSurfaceTextureAvailable(surface, width, height);
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture surface, final int width, final int height) {
        this.surfaceWidth = width;
        this.surfaceHeight = height;
        this.eglRenderer.onSurfaceTextureSizeChanged(surface, width, height);
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        VideoSink videoSink = this.parentSink;
        if (videoSink instanceof VoIPService.ProxyVideoSink) {
            VoIPService.ProxyVideoSink proxyVideoSink = (VoIPService.ProxyVideoSink) videoSink;
            proxyVideoSink.removeTarget(this);
            proxyVideoSink.removeBackground(this);
        }
        this.eglRenderer.onSurfaceTextureDestroyed(surfaceTexture);
        return true;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        this.eglRenderer.onSurfaceTextureUpdated(surfaceTexture);
    }

    private String getResourceName() {
        try {
            return getResources().getResourceEntryName(getId());
        } catch (Resources.NotFoundException unused) {
            return "";
        }
    }

    public void clearImage() {
        this.eglRenderer.clearImage();
        this.eglRenderer.isFirstFrameRendered = false;
    }

    @Override // org.webrtc.VideoSink
    public void setParentSink(VideoSink parent) {
        this.parentSink = parent;
    }

    public void onFirstFrameRendered() {
        RendererCommon.RendererEvents rendererEvents = this.rendererEvents;
        if (rendererEvents != null) {
            rendererEvents.onFirstFrameRendered();
        }
    }

    public boolean isFirstFrameRendered() {
        return this.eglRenderer.isFirstFrameRendered;
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x0059 A[PHI: r0
      0x0059: PHI (r0v8 int) = (r0v5 int), (r0v14 int), (r0v17 int) binds: [B:41:0x0056, B:27:0x0036, B:16:0x0023] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x005b A[PHI: r0
      0x005b: PHI (r0v12 int) = (r0v5 int), (r0v5 int), (r0v5 int), (r0v14 int), (r0v14 int), (r0v14 int), (r0v17 int) binds: [B:39:0x0052, B:40:0x0054, B:41:0x0056, B:25:0x0032, B:26:0x0034, B:27:0x0036, B:16:0x0023] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // org.webrtc.RendererCommon.RendererEvents
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onFrameResolutionChanged(final int r8, final int r9, int r10) {
        /*
            r7 = this;
            org.webrtc.RendererCommon$RendererEvents r0 = r7.rendererEvents
            if (r0 == 0) goto L7
            r0.onFrameResolutionChanged(r8, r9, r10)
        L7:
            r7.textureRotation = r10
            boolean r0 = r7.rotateTextureWitchScreen
            r1 = -180(0xffffffffffffff4c, float:NaN)
            r2 = 180(0xb4, float:2.52E-43)
            if (r0 == 0) goto L39
            boolean r10 = r7.isCamera
            if (r10 == 0) goto L18
            r7.onRotationChanged()
        L18:
            boolean r10 = r7.useCameraRotation
            if (r10 == 0) goto L26
            int r10 = r7.screenRotation
            if (r10 != 0) goto L22
            r0 = r9
            goto L23
        L22:
            r0 = r8
        L23:
            if (r10 != 0) goto L5b
            goto L59
        L26:
            int r10 = r7.textureRotation
            if (r10 == 0) goto L31
            if (r10 == r2) goto L31
            if (r10 != r1) goto L2f
            goto L31
        L2f:
            r0 = r9
            goto L32
        L31:
            r0 = r8
        L32:
            if (r10 == 0) goto L5b
            if (r10 == r2) goto L5b
            if (r10 != r1) goto L59
            goto L5b
        L39:
            boolean r0 = r7.isCamera
            if (r0 == 0) goto L45
            org.webrtc.TextureViewRenderer$TextureEglRenderer r0 = r7.eglRenderer
            int r3 = org.webrtc.OrientationHelper.cameraRotation
            int r3 = -r3
            r0.setRotation(r3)
        L45:
            int r0 = org.webrtc.OrientationHelper.cameraOrientation
            int r10 = r10 - r0
            if (r10 == 0) goto L51
            if (r10 == r2) goto L51
            if (r10 != r1) goto L4f
            goto L51
        L4f:
            r0 = r9
            goto L52
        L51:
            r0 = r8
        L52:
            if (r10 == 0) goto L5b
            if (r10 == r2) goto L5b
            if (r10 != r1) goto L59
            goto L5b
        L59:
            r10 = r8
            goto L5c
        L5b:
            r10 = r9
        L5c:
            r6 = r10
            r5 = r0
            org.webrtc.TextureViewRenderer$TextureEglRenderer r10 = r7.eglRenderer
            java.lang.Object r10 = org.webrtc.TextureViewRenderer.TextureEglRenderer.access$400(r10)
            monitor-enter(r10)
            java.lang.Runnable r0 = r7.updateScreenRunnable     // Catch: java.lang.Throwable -> L7c
            if (r0 == 0) goto L6c
            ir.eitaa.messenger.AndroidUtilities.cancelRunOnUIThread(r0)     // Catch: java.lang.Throwable -> L7c
        L6c:
            org.webrtc.-$$Lambda$TextureViewRenderer$y2sa0zyVrVEL4-KQaGswieONtN8 r0 = new org.webrtc.-$$Lambda$TextureViewRenderer$y2sa0zyVrVEL4-KQaGswieONtN8     // Catch: java.lang.Throwable -> L7c
            r1 = r0
            r2 = r7
            r3 = r8
            r4 = r9
            r1.<init>()     // Catch: java.lang.Throwable -> L7c
            r7.updateScreenRunnable = r0     // Catch: java.lang.Throwable -> L7c
            r7.postOrRun(r0)     // Catch: java.lang.Throwable -> L7c
            monitor-exit(r10)     // Catch: java.lang.Throwable -> L7c
            return
        L7c:
            r8 = move-exception
            monitor-exit(r10)     // Catch: java.lang.Throwable -> L7c
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: org.webrtc.TextureViewRenderer.onFrameResolutionChanged(int, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$onFrameResolutionChanged$0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$onFrameResolutionChanged$0$TextureViewRenderer(int i, int i2, int i3, int i4) {
        this.updateScreenRunnable = null;
        this.videoWidth = i;
        this.videoHeight = i2;
        this.rotatedFrameWidth = i3;
        this.rotatedFrameHeight = i4;
        updateSurfaceSize();
        requestLayout();
    }

    public void setScreenRotation(int screenRotation) {
        this.screenRotation = screenRotation;
        onRotationChanged();
        updateVideoSizes();
    }

    private void updateVideoSizes() {
        int i;
        final int i2;
        final int i3 = this.videoHeight;
        if (i3 == 0 || (i = this.videoWidth) == 0) {
            return;
        }
        if (this.rotateTextureWitchScreen) {
            if (this.useCameraRotation) {
                int i4 = this.screenRotation;
                i2 = i4 == 0 ? i3 : i;
                if (i4 == 0) {
                    i3 = i;
                }
            } else {
                int i5 = this.textureRotation;
                int i6 = (i5 == 0 || i5 == 180 || i5 == -180) ? i : i3;
                if (i5 != 0 && i5 != 180 && i5 != -180) {
                    i3 = i;
                }
                i2 = i6;
            }
        } else {
            int i7 = this.textureRotation - OrientationHelper.cameraOrientation;
            int i8 = (i7 == 0 || i7 == 180 || i7 == -180) ? this.videoWidth : this.videoHeight;
            i3 = (i7 == 0 || i7 == 180 || i7 == -180) ? this.videoHeight : this.videoWidth;
            i2 = i8;
        }
        if (this.rotatedFrameWidth == i2 && this.rotatedFrameHeight == i3) {
            return;
        }
        synchronized (this.eglRenderer.layoutLock) {
            Runnable runnable = this.updateScreenRunnable;
            if (runnable != null) {
                AndroidUtilities.cancelRunOnUIThread(runnable);
            }
            Runnable runnable2 = new Runnable() { // from class: org.webrtc.-$$Lambda$TextureViewRenderer$8T6Cmx0ACLgGQMeB5W_IQ0ppg04
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$updateVideoSizes$1$TextureViewRenderer(i2, i3);
                }
            };
            this.updateScreenRunnable = runnable2;
            postOrRun(runnable2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$updateVideoSizes$1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$updateVideoSizes$1$TextureViewRenderer(int i, int i2) {
        this.updateScreenRunnable = null;
        this.rotatedFrameWidth = i;
        this.rotatedFrameHeight = i2;
        updateSurfaceSize();
        requestLayout();
    }

    public void setRotateTextureWitchScreen(boolean rotateTextureWitchScreen) {
        if (this.rotateTextureWitchScreen != rotateTextureWitchScreen) {
            this.rotateTextureWitchScreen = rotateTextureWitchScreen;
            requestLayout();
        }
    }

    public void setUseCameraRotation(boolean useCameraRotation) {
        if (this.useCameraRotation != useCameraRotation) {
            this.useCameraRotation = useCameraRotation;
            onRotationChanged();
            updateVideoSizes();
        }
    }

    private void onRotationChanged() {
        int i;
        int i2 = this.useCameraRotation ? OrientationHelper.cameraOrientation : 0;
        boolean z = this.mirror;
        if (z) {
            i2 = 360 - i2;
        }
        int i3 = -i2;
        if (this.useCameraRotation) {
            int i4 = this.screenRotation;
            if (i4 == 1) {
                i = z ? 90 : -90;
            } else if (i4 == 3) {
                i = z ? 270 : -270;
            }
            i3 += i;
        }
        this.eglRenderer.setRotation(i3);
        this.eglRenderer.setMirror(this.mirror);
    }

    private void postOrRun(Runnable r) {
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            r.run();
        } else {
            AndroidUtilities.runOnUIThread(r);
        }
    }

    private void logD(String string) {
        Logging.d(TAG, this.resourceName + ": " + string);
    }

    public void createBackgroundSurface(SurfaceTexture bluSurfaceTexturerRenderer) {
        this.eglRenderer.createBackgroundSurface(bluSurfaceTexturerRenderer);
    }

    public void setMaxTextureSize(int maxTextureSize) {
        this.maxTextureSize = maxTextureSize;
    }
}
