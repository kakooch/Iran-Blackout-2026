package com.google.android.exoplayer2.source;

import android.os.Handler;
import android.os.Message;
import android.util.Pair;
import com.google.android.exoplayer2.C2018a0;
import com.google.android.exoplayer2.J0;
import com.google.android.exoplayer2.source.MediaSource;
import ir.nasim.AbstractC12710f43;
import ir.nasim.AbstractC20011rK;
import ir.nasim.AbstractC9683aN7;
import ir.nasim.InterfaceC19684qm;
import ir.nasim.InterfaceC25209zu7;
import java.util.IdentityHashMap;

/* loaded from: classes2.dex */
public final class ConcatenatingMediaSource2 extends CompositeMediaSource<Integer> {
    private final C2018a0 k;
    private final AbstractC12710f43 l;
    private final IdentityHashMap m;
    private Handler n;
    private boolean o;

    public static final class Builder {
        private final AbstractC12710f43.a a = AbstractC12710f43.L();
    }

    private static final class ConcatenatedTimeline extends J0 {
        private final C2018a0 f;
        private final AbstractC12710f43 g;
        private final AbstractC12710f43 h;
        private final AbstractC12710f43 i;
        private final boolean j;
        private final boolean k;
        private final long l;
        private final long m;
        private final Object n;

        public ConcatenatedTimeline(C2018a0 c2018a0, AbstractC12710f43 abstractC12710f43, AbstractC12710f43 abstractC12710f432, AbstractC12710f43 abstractC12710f433, boolean z, boolean z2, long j, long j2, Object obj) {
            this.f = c2018a0;
            this.g = abstractC12710f43;
            this.h = abstractC12710f432;
            this.i = abstractC12710f433;
            this.j = z;
            this.k = z2;
            this.l = j;
            this.m = j2;
            this.n = obj;
        }

        private int x(int i) {
            return AbstractC9683aN7.g(this.h, Integer.valueOf(i + 1), false, false);
        }

        @Override // com.google.android.exoplayer2.J0
        public final int g(Object obj) {
            if (!(obj instanceof Pair) || !(((Pair) obj).first instanceof Integer)) {
                return -1;
            }
            int iW0 = ConcatenatingMediaSource2.w0(obj);
            int iG = ((J0) this.g.get(iW0)).g(ConcatenatingMediaSource2.y0(obj));
            if (iG == -1) {
                return -1;
            }
            return ((Integer) this.h.get(iW0)).intValue() + iG;
        }

        @Override // com.google.android.exoplayer2.J0
        public final J0.b l(int i, J0.b bVar, boolean z) {
            int iX = x(i);
            ((J0) this.g.get(iX)).l(i - ((Integer) this.h.get(iX)).intValue(), bVar, z);
            bVar.c = 0;
            bVar.e = ((Long) this.i.get(i)).longValue();
            if (z) {
                bVar.b = ConcatenatingMediaSource2.B0(iX, AbstractC20011rK.e(bVar.b));
            }
            return bVar;
        }

        @Override // com.google.android.exoplayer2.J0
        public final J0.b m(Object obj, J0.b bVar) {
            int iW0 = ConcatenatingMediaSource2.w0(obj);
            Object objY0 = ConcatenatingMediaSource2.y0(obj);
            J0 j0 = (J0) this.g.get(iW0);
            int iIntValue = ((Integer) this.h.get(iW0)).intValue() + j0.g(objY0);
            j0.m(objY0, bVar);
            bVar.c = 0;
            bVar.e = ((Long) this.i.get(iIntValue)).longValue();
            bVar.b = obj;
            return bVar;
        }

        @Override // com.google.android.exoplayer2.J0
        public int n() {
            return this.i.size();
        }

        @Override // com.google.android.exoplayer2.J0
        public final Object r(int i) {
            int iX = x(i);
            return ConcatenatingMediaSource2.B0(iX, ((J0) this.g.get(iX)).r(i - ((Integer) this.h.get(iX)).intValue()));
        }

        @Override // com.google.android.exoplayer2.J0
        public final J0.d t(int i, J0.d dVar, long j) {
            return dVar.j(J0.d.r, this.f, this.n, -9223372036854775807L, -9223372036854775807L, -9223372036854775807L, this.j, this.k, null, this.m, this.l, 0, n() - 1, -((Long) this.i.get(0)).longValue());
        }

        @Override // com.google.android.exoplayer2.J0
        public int u() {
            return 1;
        }
    }

    static final class MediaSourceHolder {
        public final MaskingMediaSource a;
        public final int b;
        public final long c;
        public int d;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Object B0(int i, Object obj) {
        return Pair.create(Integer.valueOf(i), obj);
    }

    private static long D0(long j, int i) {
        return j / i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean E0(Message message) {
        if (message.what != 0) {
            return true;
        }
        I0();
        return true;
    }

    private ConcatenatedTimeline F0() {
        J0.b bVar;
        AbstractC12710f43.a aVar;
        int i;
        J0.d dVar = new J0.d();
        J0.b bVar2 = new J0.b();
        AbstractC12710f43.a aVarL = AbstractC12710f43.L();
        AbstractC12710f43.a aVarL2 = AbstractC12710f43.L();
        AbstractC12710f43.a aVarL3 = AbstractC12710f43.L();
        boolean z = true;
        boolean z2 = true;
        boolean z3 = true;
        int i2 = 0;
        Object obj = null;
        int iN = 0;
        long j = 0;
        boolean z4 = false;
        long j2 = 0;
        long j3 = 0;
        boolean z5 = false;
        while (i2 < this.l.size()) {
            MediaSourceHolder mediaSourceHolder = (MediaSourceHolder) this.l.get(i2);
            J0 j0E0 = mediaSourceHolder.a.E0();
            AbstractC20011rK.b(j0E0.v() ^ z, "Can't concatenate empty child Timeline.");
            aVarL.a(j0E0);
            aVarL2.a(Integer.valueOf(iN));
            iN += j0E0.n();
            int i3 = 0;
            while (i3 < j0E0.u()) {
                j0E0.s(i3, dVar);
                if (!z5) {
                    obj = dVar.d;
                    z5 = true;
                }
                if (z2 && AbstractC9683aN7.c(obj, dVar.d)) {
                    i = i2;
                    z2 = true;
                } else {
                    i = i2;
                    z2 = false;
                }
                long j4 = dVar.n;
                if (j4 == -9223372036854775807L) {
                    j4 = mediaSourceHolder.c;
                    if (j4 == -9223372036854775807L) {
                        return null;
                    }
                }
                j2 += j4;
                if (mediaSourceHolder.b == 0 && i3 == 0) {
                    j3 = dVar.m;
                    j = -dVar.q;
                } else {
                    AbstractC20011rK.b(dVar.q == 0, "Can't concatenate windows. A window has a non-zero offset in a period.");
                }
                z3 &= dVar.h || dVar.l;
                z4 |= dVar.i;
                i3++;
                i2 = i;
            }
            int i4 = i2;
            int iN2 = j0E0.n();
            int i5 = 0;
            while (i5 < iN2) {
                aVarL3.a(Long.valueOf(j));
                j0E0.k(i5, bVar2);
                long j5 = bVar2.d;
                if (j5 == -9223372036854775807L) {
                    bVar = bVar2;
                    AbstractC20011rK.b(iN2 == 1, "Can't concatenate multiple periods with unknown duration in one window.");
                    long j6 = dVar.n;
                    if (j6 == -9223372036854775807L) {
                        j6 = mediaSourceHolder.c;
                    }
                    aVar = aVarL;
                    j5 = j6 + dVar.q;
                } else {
                    bVar = bVar2;
                    aVar = aVarL;
                }
                j += j5;
                i5++;
                aVarL = aVar;
                bVar2 = bVar;
            }
            i2 = i4 + 1;
            z = true;
        }
        return new ConcatenatedTimeline(this.k, aVarL.h(), aVarL2.h(), aVarL3.h(), z3, z4, j2, j3, z2 ? obj : null);
    }

    private void H0() {
        if (this.o) {
            return;
        }
        ((Handler) AbstractC20011rK.e(this.n)).obtainMessage(0).sendToTarget();
        this.o = true;
    }

    private void I0() {
        this.o = false;
        ConcatenatedTimeline concatenatedTimelineF0 = F0();
        if (concatenatedTimelineF0 != null) {
            f0(concatenatedTimelineF0);
        }
    }

    private void v0() {
        for (int i = 0; i < this.l.size(); i++) {
            MediaSourceHolder mediaSourceHolder = (MediaSourceHolder) this.l.get(i);
            if (mediaSourceHolder.d == 0) {
                i0(Integer.valueOf(mediaSourceHolder.b));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int w0(Object obj) {
        return ((Integer) ((Pair) obj).first).intValue();
    }

    private static int x0(long j, int i) {
        return (int) (j % i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Object y0(Object obj) {
        return ((Pair) obj).second;
    }

    private static long z0(long j, int i, int i2) {
        return (j * i) + i2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.source.CompositeMediaSource
    /* renamed from: A0, reason: merged with bridge method [inline-methods] */
    public MediaSource.MediaPeriodId k0(Integer num, MediaSource.MediaPeriodId mediaPeriodId) {
        if (num.intValue() != x0(mediaPeriodId.d, this.l.size())) {
            return null;
        }
        return mediaPeriodId.d(B0(num.intValue(), mediaPeriodId.a)).e(D0(mediaPeriodId.d, this.l.size()));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.source.CompositeMediaSource
    /* renamed from: C0, reason: merged with bridge method [inline-methods] */
    public int m0(Integer num, int i) {
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.source.CompositeMediaSource
    /* renamed from: G0, reason: merged with bridge method [inline-methods] */
    public void n0(Integer num, MediaSource mediaSource, J0 j0) {
        H0();
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public J0 P() {
        return F0();
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public MediaPeriod b(MediaSource.MediaPeriodId mediaPeriodId, InterfaceC19684qm interfaceC19684qm, long j) {
        MediaSourceHolder mediaSourceHolder = (MediaSourceHolder) this.l.get(w0(mediaPeriodId.a));
        MediaSource.MediaPeriodId mediaPeriodIdE = mediaPeriodId.d(y0(mediaPeriodId.a)).e(z0(mediaPeriodId.d, this.l.size(), mediaSourceHolder.b));
        j0(Integer.valueOf(mediaSourceHolder.b));
        mediaSourceHolder.d++;
        MaskingMediaPeriod maskingMediaPeriodB = mediaSourceHolder.a.b(mediaPeriodIdE, interfaceC19684qm, j);
        this.m.put(maskingMediaPeriodB, mediaSourceHolder);
        v0();
        return maskingMediaPeriodB;
    }

    @Override // com.google.android.exoplayer2.source.CompositeMediaSource, com.google.android.exoplayer2.source.BaseMediaSource
    protected void b0() {
    }

    @Override // com.google.android.exoplayer2.source.CompositeMediaSource, com.google.android.exoplayer2.source.BaseMediaSource
    protected void e0(InterfaceC25209zu7 interfaceC25209zu7) {
        super.e0(interfaceC25209zu7);
        this.n = new Handler(new Handler.Callback() { // from class: ir.nasim.yc1
            @Override // android.os.Handler.Callback
            public final boolean handleMessage(Message message) {
                return this.a.E0(message);
            }
        });
        for (int i = 0; i < this.l.size(); i++) {
            p0(Integer.valueOf(i), ((MediaSourceHolder) this.l.get(i)).a);
        }
        H0();
    }

    @Override // com.google.android.exoplayer2.source.CompositeMediaSource, com.google.android.exoplayer2.source.BaseMediaSource
    protected void g0() {
        super.g0();
        Handler handler = this.n;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.n = null;
        }
        this.o = false;
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public C2018a0 p() {
        return this.k;
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public void s(MediaPeriod mediaPeriod) {
        ((MediaSourceHolder) AbstractC20011rK.e((MediaSourceHolder) this.m.remove(mediaPeriod))).a.s(mediaPeriod);
        r0.d--;
        if (this.m.isEmpty()) {
            return;
        }
        v0();
    }
}
