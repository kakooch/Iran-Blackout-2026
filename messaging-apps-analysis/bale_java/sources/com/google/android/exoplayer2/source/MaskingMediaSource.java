package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.C2018a0;
import com.google.android.exoplayer2.J0;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.ads.AdPlaybackState;
import ir.nasim.AbstractC9683aN7;
import ir.nasim.InterfaceC19684qm;

/* loaded from: classes2.dex */
public final class MaskingMediaSource extends WrappingMediaSource {
    private final boolean m;
    private final J0.d n;
    private final J0.b o;
    private MaskingTimeline p;
    private MaskingMediaPeriod q;
    private boolean r;
    private boolean s;
    private boolean t;

    private static final class MaskingTimeline extends ForwardingTimeline {
        public static final Object i = new Object();
        private final Object g;
        private final Object h;

        private MaskingTimeline(J0 j0, Object obj, Object obj2) {
            super(j0);
            this.g = obj;
            this.h = obj2;
        }

        public static MaskingTimeline A(J0 j0, Object obj, Object obj2) {
            return new MaskingTimeline(j0, obj, obj2);
        }

        public static MaskingTimeline z(C2018a0 c2018a0) {
            return new MaskingTimeline(new PlaceholderTimeline(c2018a0), J0.d.r, i);
        }

        @Override // com.google.android.exoplayer2.source.ForwardingTimeline, com.google.android.exoplayer2.J0
        public int g(Object obj) {
            Object obj2;
            J0 j0 = this.f;
            if (i.equals(obj) && (obj2 = this.h) != null) {
                obj = obj2;
            }
            return j0.g(obj);
        }

        @Override // com.google.android.exoplayer2.source.ForwardingTimeline, com.google.android.exoplayer2.J0
        public J0.b l(int i2, J0.b bVar, boolean z) {
            this.f.l(i2, bVar, z);
            if (AbstractC9683aN7.c(bVar.b, this.h) && z) {
                bVar.b = i;
            }
            return bVar;
        }

        @Override // com.google.android.exoplayer2.source.ForwardingTimeline, com.google.android.exoplayer2.J0
        public Object r(int i2) {
            Object objR = this.f.r(i2);
            return AbstractC9683aN7.c(objR, this.h) ? i : objR;
        }

        @Override // com.google.android.exoplayer2.source.ForwardingTimeline, com.google.android.exoplayer2.J0
        public J0.d t(int i2, J0.d dVar, long j) {
            this.f.t(i2, dVar, j);
            if (AbstractC9683aN7.c(dVar.a, this.g)) {
                dVar.a = J0.d.r;
            }
            return dVar;
        }

        public MaskingTimeline y(J0 j0) {
            return new MaskingTimeline(j0, this.g, this.h);
        }
    }

    public static final class PlaceholderTimeline extends J0 {
        private final C2018a0 f;

        public PlaceholderTimeline(C2018a0 c2018a0) {
            this.f = c2018a0;
        }

        @Override // com.google.android.exoplayer2.J0
        public int g(Object obj) {
            return obj == MaskingTimeline.i ? 0 : -1;
        }

        @Override // com.google.android.exoplayer2.J0
        public J0.b l(int i, J0.b bVar, boolean z) {
            bVar.w(z ? 0 : null, z ? MaskingTimeline.i : null, 0, -9223372036854775807L, 0L, AdPlaybackState.g, true);
            return bVar;
        }

        @Override // com.google.android.exoplayer2.J0
        public int n() {
            return 1;
        }

        @Override // com.google.android.exoplayer2.J0
        public Object r(int i) {
            return MaskingTimeline.i;
        }

        @Override // com.google.android.exoplayer2.J0
        public J0.d t(int i, J0.d dVar, long j) {
            dVar.j(J0.d.r, this.f, null, -9223372036854775807L, -9223372036854775807L, -9223372036854775807L, false, true, null, 0L, -9223372036854775807L, 0, 0, 0L);
            dVar.l = true;
            return dVar;
        }

        @Override // com.google.android.exoplayer2.J0
        public int u() {
            return 1;
        }
    }

    public MaskingMediaSource(MediaSource mediaSource, boolean z) {
        super(mediaSource);
        this.m = z && mediaSource.K();
        this.n = new J0.d();
        this.o = new J0.b();
        J0 j0P = mediaSource.P();
        if (j0P == null) {
            this.p = MaskingTimeline.z(mediaSource.p());
        } else {
            this.p = MaskingTimeline.A(j0P, null, null);
            this.t = true;
        }
    }

    private Object C0(Object obj) {
        return (this.p.h == null || !this.p.h.equals(obj)) ? obj : MaskingTimeline.i;
    }

    private Object D0(Object obj) {
        return (this.p.h == null || !obj.equals(MaskingTimeline.i)) ? obj : this.p.h;
    }

    private void F0(long j) {
        MaskingMediaPeriod maskingMediaPeriod = this.q;
        int iG = this.p.g(maskingMediaPeriod.a.a);
        if (iG == -1) {
            return;
        }
        long j2 = this.p.k(iG, this.o).d;
        if (j2 != -9223372036854775807L && j >= j2) {
            j = Math.max(0L, j2 - 1);
        }
        maskingMediaPeriod.w(j);
    }

    @Override // com.google.android.exoplayer2.source.WrappingMediaSource
    public void A0() {
        if (this.m) {
            return;
        }
        this.r = true;
        z0();
    }

    @Override // com.google.android.exoplayer2.source.WrappingMediaSource, com.google.android.exoplayer2.source.MediaSource
    /* renamed from: B0, reason: merged with bridge method [inline-methods] */
    public MaskingMediaPeriod b(MediaSource.MediaPeriodId mediaPeriodId, InterfaceC19684qm interfaceC19684qm, long j) {
        MaskingMediaPeriod maskingMediaPeriod = new MaskingMediaPeriod(mediaPeriodId, interfaceC19684qm, j);
        maskingMediaPeriod.y(this.k);
        if (this.s) {
            maskingMediaPeriod.n(mediaPeriodId.d(D0(mediaPeriodId.a)));
        } else {
            this.q = maskingMediaPeriod;
            if (!this.r) {
                this.r = true;
                z0();
            }
        }
        return maskingMediaPeriod;
    }

    public J0 E0() {
        return this.p;
    }

    @Override // com.google.android.exoplayer2.source.CompositeMediaSource, com.google.android.exoplayer2.source.MediaSource
    public void J() {
    }

    @Override // com.google.android.exoplayer2.source.CompositeMediaSource, com.google.android.exoplayer2.source.BaseMediaSource
    public void g0() {
        this.s = false;
        this.r = false;
        super.g0();
    }

    @Override // com.google.android.exoplayer2.source.WrappingMediaSource
    protected MediaSource.MediaPeriodId r0(MediaSource.MediaPeriodId mediaPeriodId) {
        return mediaPeriodId.d(C0(mediaPeriodId.a));
    }

    @Override // com.google.android.exoplayer2.source.WrappingMediaSource, com.google.android.exoplayer2.source.MediaSource
    public void s(MediaPeriod mediaPeriod) {
        ((MaskingMediaPeriod) mediaPeriod).x();
        if (mediaPeriod == this.q) {
            this.q = null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:32:? A[RETURN, SYNTHETIC] */
    @Override // com.google.android.exoplayer2.source.WrappingMediaSource
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void x0(com.google.android.exoplayer2.J0 r15) {
        /*
            r14 = this;
            boolean r0 = r14.s
            if (r0 == 0) goto L19
            com.google.android.exoplayer2.source.MaskingMediaSource$MaskingTimeline r0 = r14.p
            com.google.android.exoplayer2.source.MaskingMediaSource$MaskingTimeline r15 = r0.y(r15)
            r14.p = r15
            com.google.android.exoplayer2.source.MaskingMediaPeriod r15 = r14.q
            if (r15 == 0) goto Lae
            long r0 = r15.o()
            r14.F0(r0)
            goto Lae
        L19:
            boolean r0 = r15.v()
            if (r0 == 0) goto L36
            boolean r0 = r14.t
            if (r0 == 0) goto L2a
            com.google.android.exoplayer2.source.MaskingMediaSource$MaskingTimeline r0 = r14.p
            com.google.android.exoplayer2.source.MaskingMediaSource$MaskingTimeline r15 = r0.y(r15)
            goto L32
        L2a:
            java.lang.Object r0 = com.google.android.exoplayer2.J0.d.r
            java.lang.Object r1 = com.google.android.exoplayer2.source.MaskingMediaSource.MaskingTimeline.i
            com.google.android.exoplayer2.source.MaskingMediaSource$MaskingTimeline r15 = com.google.android.exoplayer2.source.MaskingMediaSource.MaskingTimeline.A(r15, r0, r1)
        L32:
            r14.p = r15
            goto Lae
        L36:
            com.google.android.exoplayer2.J0$d r0 = r14.n
            r1 = 0
            r15.s(r1, r0)
            com.google.android.exoplayer2.J0$d r0 = r14.n
            long r2 = r0.f()
            com.google.android.exoplayer2.J0$d r0 = r14.n
            java.lang.Object r0 = r0.a
            com.google.android.exoplayer2.source.MaskingMediaPeriod r4 = r14.q
            if (r4 == 0) goto L74
            long r4 = r4.p()
            com.google.android.exoplayer2.source.MaskingMediaSource$MaskingTimeline r6 = r14.p
            com.google.android.exoplayer2.source.MaskingMediaPeriod r7 = r14.q
            com.google.android.exoplayer2.source.MediaSource$MediaPeriodId r7 = r7.a
            java.lang.Object r7 = r7.a
            com.google.android.exoplayer2.J0$b r8 = r14.o
            r6.m(r7, r8)
            com.google.android.exoplayer2.J0$b r6 = r14.o
            long r6 = r6.r()
            long r6 = r6 + r4
            com.google.android.exoplayer2.source.MaskingMediaSource$MaskingTimeline r4 = r14.p
            com.google.android.exoplayer2.J0$d r5 = r14.n
            com.google.android.exoplayer2.J0$d r1 = r4.s(r1, r5)
            long r4 = r1.f()
            int r1 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r1 == 0) goto L74
            r12 = r6
            goto L75
        L74:
            r12 = r2
        L75:
            com.google.android.exoplayer2.J0$d r9 = r14.n
            com.google.android.exoplayer2.J0$b r10 = r14.o
            r11 = 0
            r8 = r15
            android.util.Pair r1 = r8.o(r9, r10, r11, r12)
            java.lang.Object r2 = r1.first
            java.lang.Object r1 = r1.second
            java.lang.Long r1 = (java.lang.Long) r1
            long r3 = r1.longValue()
            boolean r1 = r14.t
            if (r1 == 0) goto L94
            com.google.android.exoplayer2.source.MaskingMediaSource$MaskingTimeline r0 = r14.p
            com.google.android.exoplayer2.source.MaskingMediaSource$MaskingTimeline r15 = r0.y(r15)
            goto L98
        L94:
            com.google.android.exoplayer2.source.MaskingMediaSource$MaskingTimeline r15 = com.google.android.exoplayer2.source.MaskingMediaSource.MaskingTimeline.A(r15, r0, r2)
        L98:
            r14.p = r15
            com.google.android.exoplayer2.source.MaskingMediaPeriod r15 = r14.q
            if (r15 == 0) goto Lae
            r14.F0(r3)
            com.google.android.exoplayer2.source.MediaSource$MediaPeriodId r15 = r15.a
            java.lang.Object r0 = r15.a
            java.lang.Object r0 = r14.D0(r0)
            com.google.android.exoplayer2.source.MediaSource$MediaPeriodId r15 = r15.d(r0)
            goto Laf
        Lae:
            r15 = 0
        Laf:
            r0 = 1
            r14.t = r0
            r14.s = r0
            com.google.android.exoplayer2.source.MaskingMediaSource$MaskingTimeline r0 = r14.p
            r14.f0(r0)
            if (r15 == 0) goto Lc6
            com.google.android.exoplayer2.source.MaskingMediaPeriod r0 = r14.q
            java.lang.Object r0 = ir.nasim.AbstractC20011rK.e(r0)
            com.google.android.exoplayer2.source.MaskingMediaPeriod r0 = (com.google.android.exoplayer2.source.MaskingMediaPeriod) r0
            r0.n(r15)
        Lc6:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.source.MaskingMediaSource.x0(com.google.android.exoplayer2.J0):void");
    }
}
