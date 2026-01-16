package com.google.android.exoplayer2.source;

import android.net.Uri;
import com.google.android.exoplayer2.C2018a0;
import com.google.android.exoplayer2.J0;
import com.google.android.exoplayer2.X;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.upstream.a;
import com.google.android.exoplayer2.upstream.b;
import ir.nasim.AbstractC12710f43;
import ir.nasim.AbstractC20011rK;
import ir.nasim.AbstractC8300Vj4;
import ir.nasim.InterfaceC19684qm;
import ir.nasim.InterfaceC25209zu7;

/* loaded from: classes2.dex */
public final class SingleSampleMediaSource extends BaseMediaSource {
    private final com.google.android.exoplayer2.upstream.b h;
    private final a.InterfaceC0163a i;
    private final X j;
    private final long k;
    private final com.google.android.exoplayer2.upstream.j l;
    private final boolean m;
    private final J0 n;
    private final C2018a0 o;
    private InterfaceC25209zu7 p;

    public static final class Factory {
        private final a.InterfaceC0163a a;
        private com.google.android.exoplayer2.upstream.j b = new com.google.android.exoplayer2.upstream.i();
        private boolean c = true;
        private Object d;
        private String e;

        public Factory(a.InterfaceC0163a interfaceC0163a) {
            this.a = (a.InterfaceC0163a) AbstractC20011rK.e(interfaceC0163a);
        }

        public SingleSampleMediaSource a(C2018a0.l lVar, long j) {
            return new SingleSampleMediaSource(this.e, lVar, this.a, j, this.b, this.c, this.d);
        }

        public Factory b(com.google.android.exoplayer2.upstream.j jVar) {
            if (jVar == null) {
                jVar = new com.google.android.exoplayer2.upstream.i();
            }
            this.b = jVar;
            return this;
        }
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public void J() {
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public MediaPeriod b(MediaSource.MediaPeriodId mediaPeriodId, InterfaceC19684qm interfaceC19684qm, long j) {
        return new SingleSampleMediaPeriod(this.h, this.i, this.p, this.j, this.k, this.l, Z(mediaPeriodId), this.m);
    }

    @Override // com.google.android.exoplayer2.source.BaseMediaSource
    protected void e0(InterfaceC25209zu7 interfaceC25209zu7) {
        this.p = interfaceC25209zu7;
        f0(this.n);
    }

    @Override // com.google.android.exoplayer2.source.BaseMediaSource
    protected void g0() {
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public C2018a0 p() {
        return this.o;
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public void s(MediaPeriod mediaPeriod) {
        ((SingleSampleMediaPeriod) mediaPeriod).s();
    }

    private SingleSampleMediaSource(String str, C2018a0.l lVar, a.InterfaceC0163a interfaceC0163a, long j, com.google.android.exoplayer2.upstream.j jVar, boolean z, Object obj) {
        this.i = interfaceC0163a;
        this.k = j;
        this.l = jVar;
        this.m = z;
        C2018a0 c2018a0A = new C2018a0.c().j(Uri.EMPTY).e(lVar.a.toString()).h(AbstractC12710f43.W(lVar)).i(obj).a();
        this.o = c2018a0A;
        X.b bVarW = new X.b().g0((String) AbstractC8300Vj4.a(lVar.b, "text/x-unknown")).X(lVar.c).i0(lVar.d).e0(lVar.e).W(lVar.f);
        String str2 = lVar.g;
        this.j = bVarW.U(str2 == null ? str : str2).G();
        this.h = new b.C0164b().i(lVar.a).b(1).a();
        this.n = new SinglePeriodTimeline(j, true, false, false, null, c2018a0A);
    }
}
