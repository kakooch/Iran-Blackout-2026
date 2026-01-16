package com.google.android.exoplayer2.source;

import android.os.Looper;
import com.google.android.exoplayer2.C2018a0;
import com.google.android.exoplayer2.J0;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.ProgressiveMediaExtractor;
import com.google.android.exoplayer2.source.ProgressiveMediaPeriod;
import com.google.android.exoplayer2.source.ProgressiveMediaSource;
import com.google.android.exoplayer2.upstream.a;
import ir.nasim.AbstractC20011rK;
import ir.nasim.C15493jg5;
import ir.nasim.InterfaceC12088e12;
import ir.nasim.InterfaceC12462ef2;
import ir.nasim.InterfaceC19684qm;
import ir.nasim.InterfaceC25209zu7;
import ir.nasim.UD1;

/* loaded from: classes2.dex */
public final class ProgressiveMediaSource extends BaseMediaSource implements ProgressiveMediaPeriod.Listener {
    private final C2018a0 h;
    private final C2018a0.h i;
    private final a.InterfaceC0163a j;
    private final ProgressiveMediaExtractor.Factory k;
    private final com.google.android.exoplayer2.drm.i l;
    private final com.google.android.exoplayer2.upstream.j m;
    private final int n;
    private boolean o;
    private long p;
    private boolean q;
    private boolean r;
    private InterfaceC25209zu7 s;

    public static final class Factory implements MediaSourceFactory {
        private final a.InterfaceC0163a a;
        private ProgressiveMediaExtractor.Factory b;
        private InterfaceC12088e12 c;
        private com.google.android.exoplayer2.upstream.j d;
        private int e;
        private String f;
        private Object g;

        public Factory(a.InterfaceC0163a interfaceC0163a) {
            this(interfaceC0163a, new UD1());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ ProgressiveMediaExtractor f(InterfaceC12462ef2 interfaceC12462ef2, C15493jg5 c15493jg5) {
            return new BundledExtractorsAdapter(interfaceC12462ef2);
        }

        @Override // com.google.android.exoplayer2.source.MediaSource.Factory
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public ProgressiveMediaSource a(C2018a0 c2018a0) {
            AbstractC20011rK.e(c2018a0.b);
            C2018a0.h hVar = c2018a0.b;
            boolean z = false;
            boolean z2 = hVar.h == null && this.g != null;
            if (hVar.e == null && this.f != null) {
                z = true;
            }
            if (z2 && z) {
                c2018a0 = c2018a0.c().i(this.g).b(this.f).a();
            } else if (z2) {
                c2018a0 = c2018a0.c().i(this.g).a();
            } else if (z) {
                c2018a0 = c2018a0.c().b(this.f).a();
            }
            C2018a0 c2018a02 = c2018a0;
            return new ProgressiveMediaSource(c2018a02, this.a, this.b, this.c.a(c2018a02), this.d, this.e);
        }

        @Override // com.google.android.exoplayer2.source.MediaSource.Factory
        /* renamed from: g, reason: merged with bridge method [inline-methods] */
        public Factory b(InterfaceC12088e12 interfaceC12088e12) {
            this.c = (InterfaceC12088e12) AbstractC20011rK.f(interfaceC12088e12, "MediaSource.Factory#setDrmSessionManagerProvider no longer handles null by instantiating a new DefaultDrmSessionManagerProvider. Explicitly construct and pass an instance in order to retain the old behavior.");
            return this;
        }

        @Override // com.google.android.exoplayer2.source.MediaSource.Factory
        /* renamed from: h, reason: merged with bridge method [inline-methods] */
        public Factory c(com.google.android.exoplayer2.upstream.j jVar) {
            this.d = (com.google.android.exoplayer2.upstream.j) AbstractC20011rK.f(jVar, "MediaSource.Factory#setLoadErrorHandlingPolicy no longer handles null by instantiating a new DefaultLoadErrorHandlingPolicy. Explicitly construct and pass an instance in order to retain the old behavior.");
            return this;
        }

        public Factory(a.InterfaceC0163a interfaceC0163a, final InterfaceC12462ef2 interfaceC12462ef2) {
            this(interfaceC0163a, new ProgressiveMediaExtractor.Factory() { // from class: ir.nasim.nv5
                @Override // com.google.android.exoplayer2.source.ProgressiveMediaExtractor.Factory
                public final ProgressiveMediaExtractor a(C15493jg5 c15493jg5) {
                    return ProgressiveMediaSource.Factory.f(interfaceC12462ef2, c15493jg5);
                }
            });
        }

        public Factory(a.InterfaceC0163a interfaceC0163a, ProgressiveMediaExtractor.Factory factory) {
            this(interfaceC0163a, factory, new com.google.android.exoplayer2.drm.g(), new com.google.android.exoplayer2.upstream.i(), 1048576);
        }

        public Factory(a.InterfaceC0163a interfaceC0163a, ProgressiveMediaExtractor.Factory factory, InterfaceC12088e12 interfaceC12088e12, com.google.android.exoplayer2.upstream.j jVar, int i) {
            this.a = interfaceC0163a;
            this.b = factory;
            this.c = interfaceC12088e12;
            this.d = jVar;
            this.e = i;
        }
    }

    private void h0() {
        J0 singlePeriodTimeline = new SinglePeriodTimeline(this.p, this.q, false, this.r, null, this.h);
        if (this.o) {
            singlePeriodTimeline = new ForwardingTimeline(this, singlePeriodTimeline) { // from class: com.google.android.exoplayer2.source.ProgressiveMediaSource.1
                @Override // com.google.android.exoplayer2.source.ForwardingTimeline, com.google.android.exoplayer2.J0
                public J0.b l(int i, J0.b bVar, boolean z) {
                    super.l(i, bVar, z);
                    bVar.f = true;
                    return bVar;
                }

                @Override // com.google.android.exoplayer2.source.ForwardingTimeline, com.google.android.exoplayer2.J0
                public J0.d t(int i, J0.d dVar, long j) {
                    super.t(i, dVar, j);
                    dVar.l = true;
                    return dVar;
                }
            };
        }
        f0(singlePeriodTimeline);
    }

    @Override // com.google.android.exoplayer2.source.ProgressiveMediaPeriod.Listener
    public void C(long j, boolean z, boolean z2) {
        if (j == -9223372036854775807L) {
            j = this.p;
        }
        if (!this.o && this.p == j && this.q == z && this.r == z2) {
            return;
        }
        this.p = j;
        this.q = z;
        this.r = z2;
        this.o = false;
        h0();
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public void J() {
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public MediaPeriod b(MediaSource.MediaPeriodId mediaPeriodId, InterfaceC19684qm interfaceC19684qm, long j) {
        com.google.android.exoplayer2.upstream.a aVarA = this.j.a();
        InterfaceC25209zu7 interfaceC25209zu7 = this.s;
        if (interfaceC25209zu7 != null) {
            aVarA.i(interfaceC25209zu7);
        }
        return new ProgressiveMediaPeriod(this.i.a, aVarA, this.k.a(c0()), this.l, S(mediaPeriodId), this.m, Z(mediaPeriodId), this, interfaceC19684qm, this.i.e, this.n);
    }

    @Override // com.google.android.exoplayer2.source.BaseMediaSource
    protected void e0(InterfaceC25209zu7 interfaceC25209zu7) {
        this.s = interfaceC25209zu7;
        this.l.r();
        this.l.b((Looper) AbstractC20011rK.e(Looper.myLooper()), c0());
        h0();
    }

    @Override // com.google.android.exoplayer2.source.BaseMediaSource
    protected void g0() {
        this.l.release();
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public C2018a0 p() {
        return this.h;
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public void s(MediaPeriod mediaPeriod) {
        ((ProgressiveMediaPeriod) mediaPeriod).f0();
    }

    private ProgressiveMediaSource(C2018a0 c2018a0, a.InterfaceC0163a interfaceC0163a, ProgressiveMediaExtractor.Factory factory, com.google.android.exoplayer2.drm.i iVar, com.google.android.exoplayer2.upstream.j jVar, int i) {
        this.i = (C2018a0.h) AbstractC20011rK.e(c2018a0.b);
        this.h = c2018a0;
        this.j = interfaceC0163a;
        this.k = factory;
        this.l = iVar;
        this.m = jVar;
        this.n = i;
        this.o = true;
        this.p = -9223372036854775807L;
    }
}
