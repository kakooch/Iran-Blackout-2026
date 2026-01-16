package io.livekit.android.renderer;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC5270Ip7;
import ir.nasim.AbstractC6718Or3;
import ir.nasim.C17190mY7;
import ir.nasim.UI3;
import kotlin.Metadata;
import livekit.org.webrtc.EglBase;
import livekit.org.webrtc.RendererCommon;
import livekit.org.webrtc.VideoFrame;

@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006B\u0019\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\u0005\u0010\tJ7\u0010\u0013\u001a\u00020\u00122\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0019\u001a\u00020\u00122\u0006\u0010\u0018\u001a\u00020\u0017H\u0017¢\u0006\u0004\b\u0019\u0010\u001aJ\u001f\u0010\u001f\u001a\u00020\u00122\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\u001dH\u0014¢\u0006\u0004\b\u001f\u0010 R$\u0010(\u001a\u0004\u0018\u00010!8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u0016\u0010,\u001a\u00020)8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b*\u0010+¨\u0006-"}, d2 = {"Lio/livekit/android/renderer/SurfaceViewRenderer;", "Llivekit/org/webrtc/SurfaceViewRenderer;", "Lir/nasim/mY7$a;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "Llivekit/org/webrtc/EglBase$Context;", "sharedContext", "Llivekit/org/webrtc/RendererCommon$RendererEvents;", "rendererEvents", "", "configAttributes", "Llivekit/org/webrtc/RendererCommon$GlDrawer;", "drawer", "Lir/nasim/rB7;", "init", "(Llivekit/org/webrtc/EglBase$Context;Llivekit/org/webrtc/RendererCommon$RendererEvents;[ILlivekit/org/webrtc/RendererCommon$GlDrawer;)V", "release", "()V", "Llivekit/org/webrtc/VideoFrame;", "frame", "onFrame", "(Llivekit/org/webrtc/VideoFrame;)V", "Landroid/view/View;", "changedView", "", "visibility", "onVisibilityChanged", "(Landroid/view/View;I)V", "Lir/nasim/mY7;", "a", "Lir/nasim/mY7;", "getViewVisibility", "()Lir/nasim/mY7;", "setViewVisibility", "(Lir/nasim/mY7;)V", "viewVisibility", "", "b", "Z", "initialized", "livekit-android-sdk_release"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes3.dex */
public class SurfaceViewRenderer extends livekit.org.webrtc.SurfaceViewRenderer implements C17190mY7.a {

    /* renamed from: a, reason: from kotlin metadata */
    private C17190mY7 viewVisibility;

    /* renamed from: b, reason: from kotlin metadata */
    private boolean initialized;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SurfaceViewRenderer(Context context) {
        super(context);
        AbstractC13042fc3.i(context, "context");
    }

    @Override // ir.nasim.C17190mY7.a
    public C17190mY7 getViewVisibility() {
        return this.viewVisibility;
    }

    @Override // livekit.org.webrtc.SurfaceViewRenderer
    public void init(EglBase.Context sharedContext, RendererCommon.RendererEvents rendererEvents, int[] configAttributes, RendererCommon.GlDrawer drawer) {
        if (this.initialized) {
            AbstractC6718Or3.a aVar = AbstractC6718Or3.Companion;
            if (UI3.d.compareTo(AbstractC6718Or3.Companion.a()) >= 0 && AbstractC5270Ip7.j() > 0) {
                AbstractC5270Ip7.l(null, "Reinitializing already initialized SurfaceViewRenderer.", new Object[0]);
            }
        }
        this.initialized = true;
        super.init(sharedContext, rendererEvents, configAttributes, drawer);
    }

    @Override // livekit.org.webrtc.SurfaceViewRenderer, livekit.org.webrtc.VideoSink
    public void onFrame(VideoFrame frame) {
        AbstractC13042fc3.i(frame, "frame");
        if (!this.initialized) {
            Log.e("SurfaceViewRenderer", "Received frame when not initialized! You must call Room.initVideoRenderer(view) before using this view!");
        }
        super.onFrame(frame);
    }

    @Override // android.view.View
    protected void onVisibilityChanged(View changedView, int visibility) {
        AbstractC13042fc3.i(changedView, "changedView");
        super.onVisibilityChanged(changedView, visibility);
        C17190mY7 viewVisibility = getViewVisibility();
        if (viewVisibility != null) {
            viewVisibility.j();
        }
    }

    @Override // livekit.org.webrtc.SurfaceViewRenderer
    public void release() {
        this.initialized = false;
        super.release();
    }

    @Override // ir.nasim.C17190mY7.a
    public void setViewVisibility(C17190mY7 c17190mY7) {
        this.viewVisibility = c17190mY7;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SurfaceViewRenderer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AbstractC13042fc3.i(context, "context");
        AbstractC13042fc3.i(attributeSet, "attrs");
    }
}
