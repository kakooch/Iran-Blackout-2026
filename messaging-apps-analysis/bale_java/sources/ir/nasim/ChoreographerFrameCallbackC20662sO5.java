package ir.nasim;

import android.view.Choreographer;
import livekit.org.webrtc.RenderSynchronizer;

/* renamed from: ir.nasim.sO5, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final /* synthetic */ class ChoreographerFrameCallbackC20662sO5 implements Choreographer.FrameCallback {
    public final /* synthetic */ RenderSynchronizer a;

    public /* synthetic */ ChoreographerFrameCallbackC20662sO5(RenderSynchronizer renderSynchronizer) {
        this.a = renderSynchronizer;
    }

    @Override // android.view.Choreographer.FrameCallback
    public final void doFrame(long j) {
        this.a.onDisplayRefreshCycleBegin(j);
    }
}
