package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.C2018a0;
import com.google.android.exoplayer2.J0;
import com.google.android.exoplayer2.source.MediaSource;
import ir.nasim.AbstractC20011rK;
import ir.nasim.AbstractC7377Rl4;
import ir.nasim.InterfaceC19684qm;
import ir.nasim.InterfaceC25209zu7;
import ir.nasim.InterfaceC7143Ql4;
import java.io.IOException;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes2.dex */
public final class MergingMediaSource extends CompositeMediaSource<Integer> {
    private static final C2018a0 v = new C2018a0.c().e("MergingMediaSource").a();
    private final boolean k;
    private final boolean l;
    private final MediaSource[] m;
    private final J0[] n;
    private final ArrayList o;
    private final CompositeSequenceableLoaderFactory p;
    private final Map q;
    private final InterfaceC7143Ql4 r;
    private int s;
    private long[][] t;
    private IllegalMergeException u;

    private static final class ClippedTimeline extends ForwardingTimeline {
        private final long[] g;
        private final long[] h;

        public ClippedTimeline(J0 j0, Map map) {
            super(j0);
            int iU = j0.u();
            this.h = new long[j0.u()];
            J0.d dVar = new J0.d();
            for (int i = 0; i < iU; i++) {
                this.h[i] = j0.s(i, dVar).n;
            }
            int iN = j0.n();
            this.g = new long[iN];
            J0.b bVar = new J0.b();
            for (int i2 = 0; i2 < iN; i2++) {
                j0.l(i2, bVar, true);
                long jLongValue = ((Long) AbstractC20011rK.e((Long) map.get(bVar.b))).longValue();
                long[] jArr = this.g;
                jLongValue = jLongValue == Long.MIN_VALUE ? bVar.d : jLongValue;
                jArr[i2] = jLongValue;
                long j = bVar.d;
                if (j != -9223372036854775807L) {
                    long[] jArr2 = this.h;
                    int i3 = bVar.c;
                    jArr2[i3] = jArr2[i3] - (j - jLongValue);
                }
            }
        }

        @Override // com.google.android.exoplayer2.source.ForwardingTimeline, com.google.android.exoplayer2.J0
        public J0.b l(int i, J0.b bVar, boolean z) {
            super.l(i, bVar, z);
            bVar.d = this.g[i];
            return bVar;
        }

        /* JADX WARN: Removed duplicated region for block: B:8:0x001e  */
        @Override // com.google.android.exoplayer2.source.ForwardingTimeline, com.google.android.exoplayer2.J0
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public com.google.android.exoplayer2.J0.d t(int r5, com.google.android.exoplayer2.J0.d r6, long r7) {
            /*
                r4 = this;
                super.t(r5, r6, r7)
                long[] r7 = r4.h
                r0 = r7[r5]
                r6.n = r0
                r7 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
                int r5 = (r0 > r7 ? 1 : (r0 == r7 ? 0 : -1))
                if (r5 == 0) goto L1e
                long r2 = r6.m
                int r5 = (r2 > r7 ? 1 : (r2 == r7 ? 0 : -1))
                if (r5 != 0) goto L19
                goto L1e
            L19:
                long r7 = java.lang.Math.min(r2, r0)
                goto L20
            L1e:
                long r7 = r6.m
            L20:
                r6.m = r7
                return r6
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.source.MergingMediaSource.ClippedTimeline.t(int, com.google.android.exoplayer2.J0$d, long):com.google.android.exoplayer2.J0$d");
        }
    }

    public static final class IllegalMergeException extends IOException {
        public final int a;

        @Target({ElementType.TYPE_USE})
        @Documented
        @Retention(RetentionPolicy.SOURCE)
        public @interface Reason {
        }

        public IllegalMergeException(int i) {
            this.a = i;
        }
    }

    public MergingMediaSource(MediaSource... mediaSourceArr) {
        this(false, mediaSourceArr);
    }

    private void r0() {
        J0.b bVar = new J0.b();
        for (int i = 0; i < this.s; i++) {
            long j = -this.n[0].k(i, bVar).r();
            int i2 = 1;
            while (true) {
                J0[] j0Arr = this.n;
                if (i2 < j0Arr.length) {
                    this.t[i][i2] = j - (-j0Arr[i2].k(i, bVar).r());
                    i2++;
                }
            }
        }
    }

    private void u0() {
        J0[] j0Arr;
        J0.b bVar = new J0.b();
        for (int i = 0; i < this.s; i++) {
            int i2 = 0;
            long j = Long.MIN_VALUE;
            while (true) {
                j0Arr = this.n;
                if (i2 >= j0Arr.length) {
                    break;
                }
                long jN = j0Arr[i2].k(i, bVar).n();
                if (jN != -9223372036854775807L) {
                    long j2 = jN + this.t[i][i2];
                    if (j == Long.MIN_VALUE || j2 < j) {
                        j = j2;
                    }
                }
                i2++;
            }
            Object objR = j0Arr[0].r(i);
            this.q.put(objR, Long.valueOf(j));
            Iterator it = this.r.get(objR).iterator();
            while (it.hasNext()) {
                ((ClippingMediaPeriod) it.next()).w(0L, j);
            }
        }
    }

    @Override // com.google.android.exoplayer2.source.CompositeMediaSource, com.google.android.exoplayer2.source.MediaSource
    public void J() throws IllegalMergeException {
        IllegalMergeException illegalMergeException = this.u;
        if (illegalMergeException != null) {
            throw illegalMergeException;
        }
        super.J();
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public MediaPeriod b(MediaSource.MediaPeriodId mediaPeriodId, InterfaceC19684qm interfaceC19684qm, long j) {
        int length = this.m.length;
        MediaPeriod[] mediaPeriodArr = new MediaPeriod[length];
        int iG = this.n[0].g(mediaPeriodId.a);
        for (int i = 0; i < length; i++) {
            mediaPeriodArr[i] = this.m[i].b(mediaPeriodId.d(this.n[i].r(iG)), interfaceC19684qm, j - this.t[iG][i]);
        }
        MergingMediaPeriod mergingMediaPeriod = new MergingMediaPeriod(this.p, this.t[iG], mediaPeriodArr);
        if (!this.l) {
            return mergingMediaPeriod;
        }
        ClippingMediaPeriod clippingMediaPeriod = new ClippingMediaPeriod(mergingMediaPeriod, true, 0L, ((Long) AbstractC20011rK.e((Long) this.q.get(mediaPeriodId.a))).longValue());
        this.r.put(mediaPeriodId.a, clippingMediaPeriod);
        return clippingMediaPeriod;
    }

    @Override // com.google.android.exoplayer2.source.CompositeMediaSource, com.google.android.exoplayer2.source.BaseMediaSource
    protected void e0(InterfaceC25209zu7 interfaceC25209zu7) {
        super.e0(interfaceC25209zu7);
        for (int i = 0; i < this.m.length; i++) {
            p0(Integer.valueOf(i), this.m[i]);
        }
    }

    @Override // com.google.android.exoplayer2.source.CompositeMediaSource, com.google.android.exoplayer2.source.BaseMediaSource
    protected void g0() {
        super.g0();
        Arrays.fill(this.n, (Object) null);
        this.s = -1;
        this.u = null;
        this.o.clear();
        Collections.addAll(this.o, this.m);
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public C2018a0 p() {
        MediaSource[] mediaSourceArr = this.m;
        return mediaSourceArr.length > 0 ? mediaSourceArr[0].p() : v;
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public void s(MediaPeriod mediaPeriod) {
        if (this.l) {
            ClippingMediaPeriod clippingMediaPeriod = (ClippingMediaPeriod) mediaPeriod;
            Iterator it = this.r.a().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Map.Entry entry = (Map.Entry) it.next();
                if (((ClippingMediaPeriod) entry.getValue()).equals(clippingMediaPeriod)) {
                    this.r.remove(entry.getKey(), entry.getValue());
                    break;
                }
            }
            mediaPeriod = clippingMediaPeriod.a;
        }
        MergingMediaPeriod mergingMediaPeriod = (MergingMediaPeriod) mediaPeriod;
        int i = 0;
        while (true) {
            MediaSource[] mediaSourceArr = this.m;
            if (i >= mediaSourceArr.length) {
                return;
            }
            mediaSourceArr[i].s(mergingMediaPeriod.n(i));
            i++;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.source.CompositeMediaSource
    /* renamed from: s0, reason: merged with bridge method [inline-methods] */
    public MediaSource.MediaPeriodId k0(Integer num, MediaSource.MediaPeriodId mediaPeriodId) {
        if (num.intValue() == 0) {
            return mediaPeriodId;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.source.CompositeMediaSource
    /* renamed from: t0, reason: merged with bridge method [inline-methods] */
    public void n0(Integer num, MediaSource mediaSource, J0 j0) {
        if (this.u != null) {
            return;
        }
        if (this.s == -1) {
            this.s = j0.n();
        } else if (j0.n() != this.s) {
            this.u = new IllegalMergeException(0);
            return;
        }
        if (this.t.length == 0) {
            this.t = (long[][]) Array.newInstance((Class<?>) Long.TYPE, this.s, this.n.length);
        }
        this.o.remove(mediaSource);
        this.n[num.intValue()] = j0;
        if (this.o.isEmpty()) {
            if (this.k) {
                r0();
            }
            J0 clippedTimeline = this.n[0];
            if (this.l) {
                u0();
                clippedTimeline = new ClippedTimeline(clippedTimeline, this.q);
            }
            f0(clippedTimeline);
        }
    }

    public MergingMediaSource(boolean z, MediaSource... mediaSourceArr) {
        this(z, false, mediaSourceArr);
    }

    public MergingMediaSource(boolean z, boolean z2, MediaSource... mediaSourceArr) {
        this(z, z2, new DefaultCompositeSequenceableLoaderFactory(), mediaSourceArr);
    }

    public MergingMediaSource(boolean z, boolean z2, CompositeSequenceableLoaderFactory compositeSequenceableLoaderFactory, MediaSource... mediaSourceArr) {
        this.k = z;
        this.l = z2;
        this.m = mediaSourceArr;
        this.p = compositeSequenceableLoaderFactory;
        this.o = new ArrayList(Arrays.asList(mediaSourceArr));
        this.s = -1;
        this.n = new J0[mediaSourceArr.length];
        this.t = new long[0][];
        this.q = new HashMap();
        this.r = AbstractC7377Rl4.a().a().e();
    }
}
