package com.google.android.exoplayer2.source;

import android.os.Handler;
import com.google.android.exoplayer2.J0;
import com.google.android.exoplayer2.drm.h;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.MediaSourceEventListener;
import ir.nasim.AbstractC20011rK;
import ir.nasim.AbstractC9683aN7;
import ir.nasim.InterfaceC25209zu7;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;

/* loaded from: classes2.dex */
public abstract class CompositeMediaSource<T> extends BaseMediaSource {
    private final HashMap h = new HashMap();
    private Handler i;
    private InterfaceC25209zu7 j;

    private final class ForwardingEventListener implements MediaSourceEventListener, com.google.android.exoplayer2.drm.h {
        private final Object a;
        private MediaSourceEventListener.EventDispatcher b;
        private h.a c;

        public ForwardingEventListener(Object obj) {
            this.b = CompositeMediaSource.this.Z(null);
            this.c = CompositeMediaSource.this.S(null);
            this.a = obj;
        }

        private boolean b(int i, MediaSource.MediaPeriodId mediaPeriodId) {
            MediaSource.MediaPeriodId mediaPeriodIdK0;
            if (mediaPeriodId != null) {
                mediaPeriodIdK0 = CompositeMediaSource.this.k0(this.a, mediaPeriodId);
                if (mediaPeriodIdK0 == null) {
                    return false;
                }
            } else {
                mediaPeriodIdK0 = null;
            }
            int iM0 = CompositeMediaSource.this.m0(this.a, i);
            MediaSourceEventListener.EventDispatcher eventDispatcher = this.b;
            if (eventDispatcher.a != iM0 || !AbstractC9683aN7.c(eventDispatcher.b, mediaPeriodIdK0)) {
                this.b = CompositeMediaSource.this.X(iM0, mediaPeriodIdK0, 0L);
            }
            h.a aVar = this.c;
            if (aVar.a == iM0 && AbstractC9683aN7.c(aVar.b, mediaPeriodIdK0)) {
                return true;
            }
            this.c = CompositeMediaSource.this.R(iM0, mediaPeriodIdK0);
            return true;
        }

        private MediaLoadData i(MediaLoadData mediaLoadData) {
            long jL0 = CompositeMediaSource.this.l0(this.a, mediaLoadData.f);
            long jL02 = CompositeMediaSource.this.l0(this.a, mediaLoadData.g);
            return (jL0 == mediaLoadData.f && jL02 == mediaLoadData.g) ? mediaLoadData : new MediaLoadData(mediaLoadData.a, mediaLoadData.b, mediaLoadData.c, mediaLoadData.d, mediaLoadData.e, jL0, jL02);
        }

        @Override // com.google.android.exoplayer2.drm.h
        public void Q(int i, MediaSource.MediaPeriodId mediaPeriodId) {
            if (b(i, mediaPeriodId)) {
                this.c.h();
            }
        }

        @Override // com.google.android.exoplayer2.source.MediaSourceEventListener
        public void T(int i, MediaSource.MediaPeriodId mediaPeriodId, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
            if (b(i, mediaPeriodId)) {
                this.b.v(loadEventInfo, i(mediaLoadData));
            }
        }

        @Override // com.google.android.exoplayer2.drm.h
        public void U(int i, MediaSource.MediaPeriodId mediaPeriodId, int i2) {
            if (b(i, mediaPeriodId)) {
                this.c.k(i2);
            }
        }

        @Override // com.google.android.exoplayer2.drm.h
        public void V(int i, MediaSource.MediaPeriodId mediaPeriodId) {
            if (b(i, mediaPeriodId)) {
                this.c.m();
            }
        }

        @Override // com.google.android.exoplayer2.source.MediaSourceEventListener
        public void W(int i, MediaSource.MediaPeriodId mediaPeriodId, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData, IOException iOException, boolean z) {
            if (b(i, mediaPeriodId)) {
                this.b.y(loadEventInfo, i(mediaLoadData), iOException, z);
            }
        }

        @Override // com.google.android.exoplayer2.drm.h
        public void Y(int i, MediaSource.MediaPeriodId mediaPeriodId) {
            if (b(i, mediaPeriodId)) {
                this.c.j();
            }
        }

        @Override // com.google.android.exoplayer2.source.MediaSourceEventListener
        public void a(int i, MediaSource.MediaPeriodId mediaPeriodId, MediaLoadData mediaLoadData) {
            if (b(i, mediaPeriodId)) {
                this.b.j(i(mediaLoadData));
            }
        }

        @Override // com.google.android.exoplayer2.source.MediaSourceEventListener
        public void e(int i, MediaSource.MediaPeriodId mediaPeriodId, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
            if (b(i, mediaPeriodId)) {
                this.b.s(loadEventInfo, i(mediaLoadData));
            }
        }

        @Override // com.google.android.exoplayer2.source.MediaSourceEventListener
        public void h(int i, MediaSource.MediaPeriodId mediaPeriodId, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
            if (b(i, mediaPeriodId)) {
                this.b.B(loadEventInfo, i(mediaLoadData));
            }
        }

        @Override // com.google.android.exoplayer2.drm.h
        public void q(int i, MediaSource.MediaPeriodId mediaPeriodId) {
            if (b(i, mediaPeriodId)) {
                this.c.i();
            }
        }

        @Override // com.google.android.exoplayer2.source.MediaSourceEventListener
        public void v(int i, MediaSource.MediaPeriodId mediaPeriodId, MediaLoadData mediaLoadData) {
            if (b(i, mediaPeriodId)) {
                this.b.E(i(mediaLoadData));
            }
        }

        @Override // com.google.android.exoplayer2.drm.h
        public void z(int i, MediaSource.MediaPeriodId mediaPeriodId, Exception exc) {
            if (b(i, mediaPeriodId)) {
                this.c.l(exc);
            }
        }
    }

    private static final class MediaSourceAndListener<T> {
        public final MediaSource a;
        public final MediaSource.MediaSourceCaller b;
        public final ForwardingEventListener c;

        public MediaSourceAndListener(MediaSource mediaSource, MediaSource.MediaSourceCaller mediaSourceCaller, ForwardingEventListener forwardingEventListener) {
            this.a = mediaSource;
            this.b = mediaSourceCaller;
            this.c = forwardingEventListener;
        }
    }

    protected CompositeMediaSource() {
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public void J() {
        Iterator it = this.h.values().iterator();
        while (it.hasNext()) {
            ((MediaSourceAndListener) it.next()).a.J();
        }
    }

    @Override // com.google.android.exoplayer2.source.BaseMediaSource
    protected void a0() {
        for (MediaSourceAndListener mediaSourceAndListener : this.h.values()) {
            mediaSourceAndListener.a.B(mediaSourceAndListener.b);
        }
    }

    @Override // com.google.android.exoplayer2.source.BaseMediaSource
    protected void b0() {
        for (MediaSourceAndListener mediaSourceAndListener : this.h.values()) {
            mediaSourceAndListener.a.t(mediaSourceAndListener.b);
        }
    }

    @Override // com.google.android.exoplayer2.source.BaseMediaSource
    protected void e0(InterfaceC25209zu7 interfaceC25209zu7) {
        this.j = interfaceC25209zu7;
        this.i = AbstractC9683aN7.v();
    }

    @Override // com.google.android.exoplayer2.source.BaseMediaSource
    protected void g0() {
        for (MediaSourceAndListener mediaSourceAndListener : this.h.values()) {
            mediaSourceAndListener.a.i(mediaSourceAndListener.b);
            mediaSourceAndListener.a.o(mediaSourceAndListener.c);
            mediaSourceAndListener.a.H(mediaSourceAndListener.c);
        }
        this.h.clear();
    }

    protected final void i0(Object obj) {
        MediaSourceAndListener mediaSourceAndListener = (MediaSourceAndListener) AbstractC20011rK.e((MediaSourceAndListener) this.h.get(obj));
        mediaSourceAndListener.a.B(mediaSourceAndListener.b);
    }

    protected final void j0(Object obj) {
        MediaSourceAndListener mediaSourceAndListener = (MediaSourceAndListener) AbstractC20011rK.e((MediaSourceAndListener) this.h.get(obj));
        mediaSourceAndListener.a.t(mediaSourceAndListener.b);
    }

    protected MediaSource.MediaPeriodId k0(Object obj, MediaSource.MediaPeriodId mediaPeriodId) {
        return mediaPeriodId;
    }

    protected long l0(Object obj, long j) {
        return j;
    }

    protected int m0(Object obj, int i) {
        return i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: o0, reason: merged with bridge method [inline-methods] */
    public abstract void n0(Object obj, MediaSource mediaSource, J0 j0);

    /* JADX INFO: Access modifiers changed from: protected */
    public final void p0(final Object obj, MediaSource mediaSource) {
        AbstractC20011rK.a(!this.h.containsKey(obj));
        MediaSource.MediaSourceCaller mediaSourceCaller = new MediaSource.MediaSourceCaller() { // from class: ir.nasim.Mb1
            @Override // com.google.android.exoplayer2.source.MediaSource.MediaSourceCaller
            public final void x(MediaSource mediaSource2, com.google.android.exoplayer2.J0 j0) {
                this.a.n0(obj, mediaSource2, j0);
            }
        };
        ForwardingEventListener forwardingEventListener = new ForwardingEventListener(obj);
        this.h.put(obj, new MediaSourceAndListener(mediaSource, mediaSourceCaller, forwardingEventListener));
        mediaSource.l((Handler) AbstractC20011rK.e(this.i), forwardingEventListener);
        mediaSource.F((Handler) AbstractC20011rK.e(this.i), forwardingEventListener);
        mediaSource.u(mediaSourceCaller, this.j, c0());
        if (d0()) {
            return;
        }
        mediaSource.B(mediaSourceCaller);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void q0(Object obj) {
        MediaSourceAndListener mediaSourceAndListener = (MediaSourceAndListener) AbstractC20011rK.e((MediaSourceAndListener) this.h.remove(obj));
        mediaSourceAndListener.a.i(mediaSourceAndListener.b);
        mediaSourceAndListener.a.o(mediaSourceAndListener.c);
        mediaSourceAndListener.a.H(mediaSourceAndListener.c);
    }
}
