package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.J0;
import com.google.android.exoplayer2.source.MediaSource;
import io.appmetrica.analytics.coreutils.internal.services.telephony.CellularNetworkTypeExtractor;
import ir.nasim.AbstractC20011rK;
import ir.nasim.AbstractC9683aN7;
import ir.nasim.InterfaceC19684qm;
import java.io.IOException;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayList;

/* loaded from: classes2.dex */
public final class ClippingMediaSource extends WrappingMediaSource {
    private final long m;
    private final long n;
    private final boolean o;
    private final boolean p;
    private final boolean q;
    private final ArrayList r;
    private final J0.d s;
    private ClippingTimeline t;
    private IllegalClippingException u;
    private long v;
    private long w;

    private static final class ClippingTimeline extends ForwardingTimeline {
        private final long g;
        private final long h;
        private final long i;
        private final boolean j;

        public ClippingTimeline(J0 j0, long j, long j2) throws IllegalClippingException {
            super(j0);
            boolean z = false;
            if (j0.n() != 1) {
                throw new IllegalClippingException(0);
            }
            J0.d dVarS = j0.s(0, new J0.d());
            long jMax = Math.max(0L, j);
            if (!dVarS.l && jMax != 0 && !dVarS.h) {
                throw new IllegalClippingException(1);
            }
            long jMax2 = j2 == Long.MIN_VALUE ? dVarS.n : Math.max(0L, j2);
            long j3 = dVarS.n;
            if (j3 != -9223372036854775807L) {
                jMax2 = jMax2 > j3 ? j3 : jMax2;
                if (jMax > jMax2) {
                    throw new IllegalClippingException(2);
                }
            }
            this.g = jMax;
            this.h = jMax2;
            this.i = jMax2 == -9223372036854775807L ? -9223372036854775807L : jMax2 - jMax;
            if (dVarS.i && (jMax2 == -9223372036854775807L || (j3 != -9223372036854775807L && jMax2 == j3))) {
                z = true;
            }
            this.j = z;
        }

        @Override // com.google.android.exoplayer2.source.ForwardingTimeline, com.google.android.exoplayer2.J0
        public J0.b l(int i, J0.b bVar, boolean z) {
            this.f.l(0, bVar, z);
            long jR = bVar.r() - this.g;
            long j = this.i;
            return bVar.v(bVar.a, bVar.b, 0, j == -9223372036854775807L ? -9223372036854775807L : j - jR, jR);
        }

        @Override // com.google.android.exoplayer2.source.ForwardingTimeline, com.google.android.exoplayer2.J0
        public J0.d t(int i, J0.d dVar, long j) {
            this.f.t(0, dVar, 0L);
            long j2 = dVar.q;
            long j3 = this.g;
            dVar.q = j2 + j3;
            dVar.n = this.i;
            dVar.i = this.j;
            long j4 = dVar.m;
            if (j4 != -9223372036854775807L) {
                long jMax = Math.max(j4, j3);
                dVar.m = jMax;
                long j5 = this.h;
                if (j5 != -9223372036854775807L) {
                    jMax = Math.min(jMax, j5);
                }
                dVar.m = jMax - this.g;
            }
            long jC1 = AbstractC9683aN7.c1(this.g);
            long j6 = dVar.e;
            if (j6 != -9223372036854775807L) {
                dVar.e = j6 + jC1;
            }
            long j7 = dVar.f;
            if (j7 != -9223372036854775807L) {
                dVar.f = j7 + jC1;
            }
            return dVar;
        }
    }

    public static final class IllegalClippingException extends IOException {
        public final int a;

        @Target({ElementType.TYPE_USE})
        @Documented
        @Retention(RetentionPolicy.SOURCE)
        public @interface Reason {
        }

        public IllegalClippingException(int i) {
            super("Illegal clipping: " + a(i));
            this.a = i;
        }

        private static String a(int i) {
            return i != 0 ? i != 1 ? i != 2 ? CellularNetworkTypeExtractor.UNKNOWN_NETWORK_TYPE_VALUE : "start exceeds end" : "not seekable to start" : "invalid period count";
        }
    }

    public ClippingMediaSource(MediaSource mediaSource, long j, long j2, boolean z, boolean z2, boolean z3) {
        super((MediaSource) AbstractC20011rK.e(mediaSource));
        AbstractC20011rK.a(j >= 0);
        this.m = j;
        this.n = j2;
        this.o = z;
        this.p = z2;
        this.q = z3;
        this.r = new ArrayList();
        this.s = new J0.d();
    }

    private void B0(J0 j0) {
        long j;
        long j2;
        j0.s(0, this.s);
        long jH = this.s.h();
        if (this.t == null || this.r.isEmpty() || this.p) {
            long j3 = this.m;
            long j4 = this.n;
            if (this.q) {
                long jF = this.s.f();
                j3 += jF;
                j4 += jF;
            }
            this.v = jH + j3;
            this.w = this.n != Long.MIN_VALUE ? jH + j4 : Long.MIN_VALUE;
            int size = this.r.size();
            for (int i = 0; i < size; i++) {
                ((ClippingMediaPeriod) this.r.get(i)).w(this.v, this.w);
            }
            j = j3;
            j2 = j4;
        } else {
            long j5 = this.v - jH;
            j2 = this.n != Long.MIN_VALUE ? this.w - jH : Long.MIN_VALUE;
            j = j5;
        }
        try {
            ClippingTimeline clippingTimeline = new ClippingTimeline(j0, j, j2);
            this.t = clippingTimeline;
            f0(clippingTimeline);
        } catch (IllegalClippingException e) {
            this.u = e;
            for (int i2 = 0; i2 < this.r.size(); i2++) {
                ((ClippingMediaPeriod) this.r.get(i2)).s(this.u);
            }
        }
    }

    @Override // com.google.android.exoplayer2.source.CompositeMediaSource, com.google.android.exoplayer2.source.MediaSource
    public void J() throws IllegalClippingException {
        IllegalClippingException illegalClippingException = this.u;
        if (illegalClippingException != null) {
            throw illegalClippingException;
        }
        super.J();
    }

    @Override // com.google.android.exoplayer2.source.WrappingMediaSource, com.google.android.exoplayer2.source.MediaSource
    public MediaPeriod b(MediaSource.MediaPeriodId mediaPeriodId, InterfaceC19684qm interfaceC19684qm, long j) {
        ClippingMediaPeriod clippingMediaPeriod = new ClippingMediaPeriod(this.k.b(mediaPeriodId, interfaceC19684qm, j), this.o, this.v, this.w);
        this.r.add(clippingMediaPeriod);
        return clippingMediaPeriod;
    }

    @Override // com.google.android.exoplayer2.source.CompositeMediaSource, com.google.android.exoplayer2.source.BaseMediaSource
    protected void g0() {
        super.g0();
        this.u = null;
        this.t = null;
    }

    @Override // com.google.android.exoplayer2.source.WrappingMediaSource, com.google.android.exoplayer2.source.MediaSource
    public void s(MediaPeriod mediaPeriod) {
        AbstractC20011rK.g(this.r.remove(mediaPeriod));
        this.k.s(((ClippingMediaPeriod) mediaPeriod).a);
        if (!this.r.isEmpty() || this.p) {
            return;
        }
        B0(((ClippingTimeline) AbstractC20011rK.e(this.t)).f);
    }

    @Override // com.google.android.exoplayer2.source.WrappingMediaSource
    protected void x0(J0 j0) {
        if (this.u != null) {
            return;
        }
        B0(j0);
    }
}
