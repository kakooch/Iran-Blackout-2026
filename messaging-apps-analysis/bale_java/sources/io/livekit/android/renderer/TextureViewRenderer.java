package io.livekit.android.renderer;

import android.content.Context;
import android.content.res.Resources;
import android.gov.nist.javax.sip.parser.TokenNames;
import android.graphics.Matrix;
import android.graphics.Point;
import android.graphics.SurfaceTexture;
import android.os.Looper;
import android.util.AttributeSet;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.TextureView;
import android.view.View;
import io.livekit.android.renderer.TextureViewRenderer;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC5270Ip7;
import ir.nasim.AbstractC6718Or3;
import ir.nasim.C17190mY7;
import ir.nasim.UI3;
import java.util.concurrent.CountDownLatch;
import kotlin.Metadata;
import livekit.org.webrtc.EglBase;
import livekit.org.webrtc.GlRectDrawer;
import livekit.org.webrtc.Logging;
import livekit.org.webrtc.RendererCommon;
import livekit.org.webrtc.SurfaceEglRenderer;
import livekit.org.webrtc.ThreadUtils;
import livekit.org.webrtc.VideoFrame;
import livekit.org.webrtc.VideoSink;

@Metadata(d1 = {"\u0000²\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\b\b\u0016\u0018\u0000 \u0083\u00012\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u0006:\u0001fB\u0011\b\u0016\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nB\u0019\b\u0016\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\t\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u001f\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0017\u001a\u00020\u0016H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u001b\u001a\u00020\u000e2\u0006\u0010\u001a\u001a\u00020\u0019H\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010\u001e\u001a\u00020\u000e2\u0006\u0010\u001d\u001a\u00020\u0016H\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ;\u0010'\u001a\u00020\u000e2\b\u0010!\u001a\u0004\u0018\u00010 2\b\u0010\"\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010$\u001a\u0004\u0018\u00010#2\n\b\u0002\u0010&\u001a\u0004\u0018\u00010%H\u0007¢\u0006\u0004\b'\u0010(J\r\u0010)\u001a\u00020\u000e¢\u0006\u0004\b)\u0010\u0010J\u0015\u0010,\u001a\u00020\u000e2\u0006\u0010+\u001a\u00020*¢\u0006\u0004\b,\u0010-J\u0015\u0010/\u001a\u00020\u000e2\u0006\u0010.\u001a\u00020*¢\u0006\u0004\b/\u0010-J\u0017\u00102\u001a\u00020\u000e2\b\u00101\u001a\u0004\u0018\u000100¢\u0006\u0004\b2\u00103J!\u00102\u001a\u00020\u000e2\b\u00104\u001a\u0004\u0018\u0001002\b\u00105\u001a\u0004\u0018\u000100¢\u0006\u0004\b2\u00106J\u0015\u00109\u001a\u00020\u000e2\u0006\u00108\u001a\u000207¢\u0006\u0004\b9\u0010:J\u0017\u0010=\u001a\u00020\u000e2\u0006\u0010<\u001a\u00020;H\u0017¢\u0006\u0004\b=\u0010>J\u001f\u0010A\u001a\u00020\u000e2\u0006\u0010?\u001a\u00020\u00112\u0006\u0010@\u001a\u00020\u0011H\u0014¢\u0006\u0004\bA\u0010\u0015J7\u0010G\u001a\u00020\u000e2\u0006\u0010B\u001a\u00020*2\u0006\u0010C\u001a\u00020\u00112\u0006\u0010D\u001a\u00020\u00112\u0006\u0010E\u001a\u00020\u00112\u0006\u0010F\u001a\u00020\u0011H\u0014¢\u0006\u0004\bG\u0010HJ\u0017\u0010K\u001a\u00020\u000e2\u0006\u0010J\u001a\u00020IH\u0016¢\u0006\u0004\bK\u0010LJ\u0017\u0010M\u001a\u00020\u000e2\u0006\u0010J\u001a\u00020IH\u0016¢\u0006\u0004\bM\u0010LJ/\u0010Q\u001a\u00020\u000e2\u0006\u0010J\u001a\u00020I2\u0006\u0010N\u001a\u00020\u00112\u0006\u0010O\u001a\u00020\u00112\u0006\u0010P\u001a\u00020\u0011H\u0016¢\u0006\u0004\bQ\u0010RJ'\u0010V\u001a\u00020\u000e2\u0006\u0010T\u001a\u00020S2\u0006\u0010\u001b\u001a\u00020\u00112\u0006\u0010U\u001a\u00020\u0011H\u0016¢\u0006\u0004\bV\u0010WJ'\u0010X\u001a\u00020\u000e2\u0006\u0010T\u001a\u00020S2\u0006\u0010O\u001a\u00020\u00112\u0006\u0010P\u001a\u00020\u0011H\u0016¢\u0006\u0004\bX\u0010WJ\u0017\u0010Y\u001a\u00020*2\u0006\u0010T\u001a\u00020SH\u0016¢\u0006\u0004\bY\u0010ZJ\u0017\u0010[\u001a\u00020\u000e2\u0006\u0010T\u001a\u00020SH\u0016¢\u0006\u0004\b[\u0010\\J\u000f\u0010]\u001a\u00020\u000eH\u0016¢\u0006\u0004\b]\u0010\u0010J'\u0010_\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u00112\u0006\u0010^\u001a\u00020\u0011H\u0016¢\u0006\u0004\b_\u0010`J\u001f\u0010d\u001a\u00020\u000e2\u0006\u0010b\u001a\u00020a2\u0006\u0010c\u001a\u00020\u0011H\u0014¢\u0006\u0004\bd\u0010eR\u0014\u0010h\u001a\u00020\u00168\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bf\u0010gR\u0014\u0010l\u001a\u00020i8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bj\u0010kR\u0014\u0010o\u001a\u00020m8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010nR\u0018\u0010\"\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b'\u0010pR\u0016\u0010s\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bq\u0010rR\u0016\u0010t\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010rR\u0016\u0010w\u001a\u00020*8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bu\u0010vR\u0016\u0010y\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bx\u0010rR\u0016\u0010z\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010rR\u0016\u0010{\u001a\u00020*8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b)\u0010vR'\u0010\u0082\u0001\u001a\u0004\u0018\u00010|8\u0016@\u0016X\u0096\u000e¢\u0006\u0014\n\u0004\b\u000f\u0010}\u001a\u0004\b~\u0010\u007f\"\u0006\b\u0080\u0001\u0010\u0081\u0001¨\u0006\u0084\u0001"}, d2 = {"Lio/livekit/android/renderer/TextureViewRenderer;", "Landroid/view/TextureView;", "Landroid/view/SurfaceHolder$Callback;", "Landroid/view/TextureView$SurfaceTextureListener;", "Llivekit/org/webrtc/VideoSink;", "Llivekit/org/webrtc/RendererCommon$RendererEvents;", "Lir/nasim/mY7$a;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "Lir/nasim/rB7;", "k", "()V", "", "videoWidth", "videoHeight", "c", "(II)V", "", "getResourceName", "()Ljava/lang/String;", "Ljava/lang/Runnable;", "r", "i", "(Ljava/lang/Runnable;)V", "string", "f", "(Ljava/lang/String;)V", "Llivekit/org/webrtc/EglBase$Context;", "sharedContext", "rendererEvents", "", "configAttributes", "Llivekit/org/webrtc/RendererCommon$GlDrawer;", "drawer", "d", "(Llivekit/org/webrtc/EglBase$Context;Llivekit/org/webrtc/RendererCommon$RendererEvents;[ILlivekit/org/webrtc/RendererCommon$GlDrawer;)V", "j", "", "enabled", "setEnableHardwareScaler", "(Z)V", "mirror", "setMirror", "Llivekit/org/webrtc/RendererCommon$ScalingType;", "scalingType", "setScalingType", "(Llivekit/org/webrtc/RendererCommon$ScalingType;)V", "scalingTypeMatchOrientation", "scalingTypeMismatchOrientation", "(Llivekit/org/webrtc/RendererCommon$ScalingType;Llivekit/org/webrtc/RendererCommon$ScalingType;)V", "", "fps", "setFpsReduction", "(F)V", "Llivekit/org/webrtc/VideoFrame;", "frame", "onFrame", "(Llivekit/org/webrtc/VideoFrame;)V", "widthSpec", "heightSpec", "onMeasure", "changed", "left", "top", "right", "bottom", "onLayout", "(ZIIII)V", "Landroid/view/SurfaceHolder;", "holder", "surfaceCreated", "(Landroid/view/SurfaceHolder;)V", "surfaceDestroyed", "format", "width", "height", "surfaceChanged", "(Landroid/view/SurfaceHolder;III)V", "Landroid/graphics/SurfaceTexture;", "surface", "i1", "onSurfaceTextureAvailable", "(Landroid/graphics/SurfaceTexture;II)V", "onSurfaceTextureSizeChanged", "onSurfaceTextureDestroyed", "(Landroid/graphics/SurfaceTexture;)Z", "onSurfaceTextureUpdated", "(Landroid/graphics/SurfaceTexture;)V", "onFirstFrameRendered", "rotation", "onFrameResolutionChanged", "(III)V", "Landroid/view/View;", "changedView", "visibility", "onVisibilityChanged", "(Landroid/view/View;I)V", "a", "Ljava/lang/String;", "resourceName", "Llivekit/org/webrtc/RendererCommon$VideoLayoutMeasure;", "b", "Llivekit/org/webrtc/RendererCommon$VideoLayoutMeasure;", "videoLayoutMeasure", "Llivekit/org/webrtc/SurfaceEglRenderer;", "Llivekit/org/webrtc/SurfaceEglRenderer;", "eglRenderer", "Llivekit/org/webrtc/RendererCommon$RendererEvents;", "e", TokenNames.I, "rotatedFrameWidth", "rotatedFrameHeight", "g", "Z", "enableFixedSize", "h", "surfaceWidth", "surfaceHeight", "initialized", "Lir/nasim/mY7;", "Lir/nasim/mY7;", "getViewVisibility", "()Lir/nasim/mY7;", "setViewVisibility", "(Lir/nasim/mY7;)V", "viewVisibility", "Companion", "livekit-android-sdk_release"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes3.dex */
public class TextureViewRenderer extends TextureView implements SurfaceHolder.Callback, TextureView.SurfaceTextureListener, VideoSink, RendererCommon.RendererEvents, C17190mY7.a {

    /* renamed from: a, reason: from kotlin metadata */
    private final String resourceName;

    /* renamed from: b, reason: from kotlin metadata */
    private final RendererCommon.VideoLayoutMeasure videoLayoutMeasure;

    /* renamed from: c, reason: from kotlin metadata */
    private final SurfaceEglRenderer eglRenderer;

    /* renamed from: d, reason: from kotlin metadata */
    private RendererCommon.RendererEvents rendererEvents;

    /* renamed from: e, reason: from kotlin metadata */
    private int rotatedFrameWidth;

    /* renamed from: f, reason: from kotlin metadata */
    private int rotatedFrameHeight;

    /* renamed from: g, reason: from kotlin metadata */
    private boolean enableFixedSize;

    /* renamed from: h, reason: from kotlin metadata */
    private int surfaceWidth;

    /* renamed from: i, reason: from kotlin metadata */
    private int surfaceHeight;

    /* renamed from: j, reason: from kotlin metadata */
    private boolean initialized;

    /* renamed from: k, reason: from kotlin metadata */
    private C17190mY7 viewVisibility;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TextureViewRenderer(Context context) throws Resources.NotFoundException {
        super(context);
        AbstractC13042fc3.i(context, "context");
        this.videoLayoutMeasure = new RendererCommon.VideoLayoutMeasure();
        String resourceName = getResourceName();
        this.resourceName = resourceName;
        this.eglRenderer = new SurfaceEglRenderer(resourceName);
        setSurfaceTextureListener(this);
    }

    private final void c(int videoWidth, int videoHeight) {
        int i;
        int width = getWidth();
        int height = getHeight();
        double d = videoHeight / videoWidth;
        int i2 = (int) (width * d);
        if (height > i2) {
            i = width;
        } else {
            i = (int) (height / d);
            i2 = height;
        }
        int i3 = (width - i) / 2;
        int i4 = (height - i2) / 2;
        f("video=" + videoWidth + 'x' + videoHeight + " view=" + width + 'x' + height + " newView=" + i + 'x' + i2 + " off=" + i3 + ',' + i4);
        Matrix matrix = new Matrix();
        getTransform(matrix);
        matrix.setScale(((float) i) / ((float) width), ((float) i2) / ((float) height));
        matrix.postTranslate((float) i3, (float) i4);
        setTransform(matrix);
    }

    public static /* synthetic */ void e(TextureViewRenderer textureViewRenderer, EglBase.Context context, RendererCommon.RendererEvents rendererEvents, int[] iArr, RendererCommon.GlDrawer glDrawer, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: init");
        }
        if ((i & 4) != 0) {
            iArr = EglBase.CONFIG_PLAIN;
        }
        if ((i & 8) != 0) {
            glDrawer = new GlRectDrawer();
        }
        textureViewRenderer.d(context, rendererEvents, iArr, glDrawer);
    }

    private final void f(String string) {
        Logging.d("TextureViewRenderer", this.resourceName + ": " + string);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(TextureViewRenderer textureViewRenderer, int i, int i2) {
        AbstractC13042fc3.i(textureViewRenderer, "this$0");
        textureViewRenderer.rotatedFrameWidth = i;
        textureViewRenderer.rotatedFrameHeight = i2;
        textureViewRenderer.k();
        textureViewRenderer.requestLayout();
    }

    private final String getResourceName() throws Resources.NotFoundException {
        try {
            String resourceEntryName = getResources().getResourceEntryName(getId());
            AbstractC13042fc3.f(resourceEntryName);
            return resourceEntryName;
        } catch (Resources.NotFoundException unused) {
            return "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(CountDownLatch countDownLatch) {
        AbstractC13042fc3.i(countDownLatch, "$completionLatch");
        countDownLatch.countDown();
    }

    private final void i(Runnable r) {
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            r.run();
        } else {
            post(r);
        }
    }

    private final void k() {
        ThreadUtils.checkIsOnMainThread();
        if (!this.enableFixedSize || this.rotatedFrameWidth == 0 || this.rotatedFrameHeight == 0 || getWidth() == 0 || getHeight() == 0) {
            this.surfaceHeight = 0;
            this.surfaceWidth = 0;
            return;
        }
        float width = getWidth() / getHeight();
        int i = this.rotatedFrameWidth;
        int i2 = this.rotatedFrameHeight;
        if (i / i2 > width) {
            i = (int) (i2 * width);
        } else {
            i2 = (int) (i / width);
        }
        int iMin = Math.min(getWidth(), i);
        int iMin2 = Math.min(getHeight(), i2);
        f("updateSurfaceSize. Layout size: " + getWidth() + 'x' + getHeight() + ", frame size: " + this.rotatedFrameWidth + 'x' + this.rotatedFrameHeight + ", requested surface size: " + iMin + 'x' + iMin2 + ", old surface size: " + this.surfaceWidth + 'x' + this.surfaceHeight);
        if (iMin == this.surfaceWidth && iMin2 == this.surfaceHeight) {
            return;
        }
        this.surfaceWidth = iMin;
        this.surfaceHeight = iMin2;
        c(iMin, iMin2);
    }

    public final void d(EglBase.Context sharedContext, RendererCommon.RendererEvents rendererEvents, int[] configAttributes, RendererCommon.GlDrawer drawer) {
        ThreadUtils.checkIsOnMainThread();
        if (this.initialized) {
            AbstractC6718Or3.a aVar = AbstractC6718Or3.Companion;
            if (UI3.d.compareTo(AbstractC6718Or3.Companion.a()) >= 0 && AbstractC5270Ip7.j() > 0) {
                AbstractC5270Ip7.l(null, "Reinitializing already initialized TextureViewRenderer.", new Object[0]);
            }
        }
        this.initialized = true;
        this.rendererEvents = rendererEvents;
        this.rotatedFrameWidth = 0;
        this.rotatedFrameHeight = 0;
        this.eglRenderer.init(sharedContext, this, configAttributes, drawer);
    }

    @Override // ir.nasim.C17190mY7.a
    public C17190mY7 getViewVisibility() {
        return this.viewVisibility;
    }

    public final void j() {
        this.initialized = false;
        this.eglRenderer.release();
    }

    @Override // livekit.org.webrtc.RendererCommon.RendererEvents
    public void onFirstFrameRendered() {
        RendererCommon.RendererEvents rendererEvents = this.rendererEvents;
        if (rendererEvents != null) {
            AbstractC13042fc3.f(rendererEvents);
            rendererEvents.onFirstFrameRendered();
        }
    }

    @Override // livekit.org.webrtc.VideoSink
    public void onFrame(VideoFrame frame) {
        AbstractC13042fc3.i(frame, "frame");
        if (!this.initialized) {
            Log.e("TextureViewRenderer", "Received frame when not initialized! You must call Room.initVideoRenderer(view) before using this view!");
        }
        this.eglRenderer.onFrame(frame);
    }

    @Override // livekit.org.webrtc.RendererCommon.RendererEvents
    public void onFrameResolutionChanged(final int videoWidth, int videoHeight, int rotation) {
        RendererCommon.RendererEvents rendererEvents = this.rendererEvents;
        if (rendererEvents != null) {
            AbstractC13042fc3.f(rendererEvents);
            rendererEvents.onFrameResolutionChanged(videoWidth, videoHeight, rotation);
        }
        final int i = (rotation == 0 || rotation == 180) ? videoWidth : videoHeight;
        if (rotation == 0 || rotation == 180) {
            videoWidth = videoHeight;
        }
        i(new Runnable() { // from class: ir.nasim.to7
            @Override // java.lang.Runnable
            public final void run() {
                TextureViewRenderer.g(this.a, i, videoWidth);
            }
        });
    }

    @Override // android.view.View
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        ThreadUtils.checkIsOnMainThread();
        this.eglRenderer.setLayoutAspectRatio((right - left) / (bottom - top));
        k();
    }

    @Override // android.view.View
    protected void onMeasure(int widthSpec, int heightSpec) {
        ThreadUtils.checkIsOnMainThread();
        Point pointMeasure = this.videoLayoutMeasure.measure(widthSpec, heightSpec, this.rotatedFrameWidth, this.rotatedFrameHeight);
        setMeasuredDimension(pointMeasure.x, pointMeasure.y);
        f("onMeasure(). New size: " + pointMeasure.x + 'x' + pointMeasure.y);
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surface, int i, int i1) {
        AbstractC13042fc3.i(surface, "surface");
        ThreadUtils.checkIsOnMainThread();
        this.eglRenderer.createEglSurface(getSurfaceTexture());
        this.surfaceHeight = 0;
        this.surfaceWidth = 0;
        k();
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surface) {
        AbstractC13042fc3.i(surface, "surface");
        ThreadUtils.checkIsOnMainThread();
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        this.eglRenderer.releaseEglSurface(new Runnable() { // from class: ir.nasim.uo7
            @Override // java.lang.Runnable
            public final void run() {
                TextureViewRenderer.h(countDownLatch);
            }
        });
        ThreadUtils.awaitUninterruptibly(countDownLatch);
        return true;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture surface, int width, int height) {
        AbstractC13042fc3.i(surface, "surface");
        ThreadUtils.checkIsOnMainThread();
        f("surfaceChanged: size: " + width + 'x' + height);
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture surface) {
        AbstractC13042fc3.i(surface, "surface");
    }

    @Override // android.view.TextureView, android.view.View
    protected void onVisibilityChanged(View changedView, int visibility) {
        AbstractC13042fc3.i(changedView, "changedView");
        super.onVisibilityChanged(changedView, visibility);
        C17190mY7 viewVisibility = getViewVisibility();
        if (viewVisibility != null) {
            viewVisibility.j();
        }
    }

    public final void setEnableHardwareScaler(boolean enabled) {
        ThreadUtils.checkIsOnMainThread();
        this.enableFixedSize = enabled;
        k();
    }

    public final void setFpsReduction(float fps) {
        this.eglRenderer.setFpsReduction(fps);
    }

    public final void setMirror(boolean mirror) {
        this.eglRenderer.setMirror(mirror);
    }

    public final void setScalingType(RendererCommon.ScalingType scalingType) {
        ThreadUtils.checkIsOnMainThread();
        this.videoLayoutMeasure.setScalingType(scalingType);
        requestLayout();
    }

    @Override // ir.nasim.C17190mY7.a
    public void setViewVisibility(C17190mY7 c17190mY7) {
        this.viewVisibility = c17190mY7;
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
        AbstractC13042fc3.i(holder, "holder");
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder holder) {
        AbstractC13042fc3.i(holder, "holder");
        ThreadUtils.checkIsOnMainThread();
        this.surfaceHeight = 0;
        this.surfaceWidth = 0;
        k();
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder holder) {
        AbstractC13042fc3.i(holder, "holder");
    }

    public final void setScalingType(RendererCommon.ScalingType scalingTypeMatchOrientation, RendererCommon.ScalingType scalingTypeMismatchOrientation) {
        ThreadUtils.checkIsOnMainThread();
        this.videoLayoutMeasure.setScalingType(scalingTypeMatchOrientation, scalingTypeMismatchOrientation);
        requestLayout();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TextureViewRenderer(Context context, AttributeSet attributeSet) throws Resources.NotFoundException {
        super(context, attributeSet);
        AbstractC13042fc3.i(context, "context");
        AbstractC13042fc3.i(attributeSet, "attrs");
        this.videoLayoutMeasure = new RendererCommon.VideoLayoutMeasure();
        String resourceName = getResourceName();
        this.resourceName = resourceName;
        this.eglRenderer = new SurfaceEglRenderer(resourceName);
        setSurfaceTextureListener(this);
    }
}
