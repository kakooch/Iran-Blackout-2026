package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.X;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.source.ClippingMediaSource;
import com.google.android.exoplayer2.source.MediaPeriod;
import ir.nasim.AbstractC20011rK;
import ir.nasim.AbstractC24462yf4;
import ir.nasim.AbstractC9683aN7;
import ir.nasim.C21664tv2;
import ir.nasim.C22738vk6;
import ir.nasim.InterfaceC13679ge2;

/* loaded from: classes2.dex */
public final class ClippingMediaPeriod implements MediaPeriod, MediaPeriod.Callback {
    public final MediaPeriod a;
    private MediaPeriod.Callback b;
    private ClippingSampleStream[] c = new ClippingSampleStream[0];
    private long d;
    long e;
    long f;
    private ClippingMediaSource.IllegalClippingException g;

    private final class ClippingSampleStream implements SampleStream {
        public final SampleStream a;
        private boolean b;

        public ClippingSampleStream(SampleStream sampleStream) {
            this.a = sampleStream;
        }

        public void a() {
            this.b = false;
        }

        @Override // com.google.android.exoplayer2.source.SampleStream
        public void b() {
            this.a.b();
        }

        @Override // com.google.android.exoplayer2.source.SampleStream
        public boolean h() {
            return !ClippingMediaPeriod.this.o() && this.a.h();
        }

        @Override // com.google.android.exoplayer2.source.SampleStream
        public int o(C21664tv2 c21664tv2, DecoderInputBuffer decoderInputBuffer, int i) {
            if (ClippingMediaPeriod.this.o()) {
                return -3;
            }
            if (this.b) {
                decoderInputBuffer.x(4);
                return -4;
            }
            int iO = this.a.o(c21664tv2, decoderInputBuffer, i);
            if (iO == -5) {
                X x = (X) AbstractC20011rK.e(c21664tv2.b);
                int i2 = x.B;
                if (i2 != 0 || x.D != 0) {
                    ClippingMediaPeriod clippingMediaPeriod = ClippingMediaPeriod.this;
                    if (clippingMediaPeriod.e != 0) {
                        i2 = 0;
                    }
                    c21664tv2.b = x.c().P(i2).Q(clippingMediaPeriod.f == Long.MIN_VALUE ? x.D : 0).G();
                }
                return -5;
            }
            ClippingMediaPeriod clippingMediaPeriod2 = ClippingMediaPeriod.this;
            long j = clippingMediaPeriod2.f;
            if (j == Long.MIN_VALUE || ((iO != -4 || decoderInputBuffer.e < j) && !(iO == -3 && clippingMediaPeriod2.e() == Long.MIN_VALUE && !decoderInputBuffer.d))) {
                return iO;
            }
            decoderInputBuffer.p();
            decoderInputBuffer.x(4);
            this.b = true;
            return -4;
        }

        @Override // com.google.android.exoplayer2.source.SampleStream
        public int s(long j) {
            if (ClippingMediaPeriod.this.o()) {
                return -3;
            }
            return this.a.s(j);
        }
    }

    public ClippingMediaPeriod(MediaPeriod mediaPeriod, boolean z, long j, long j2) {
        this.a = mediaPeriod;
        this.d = z ? j : -9223372036854775807L;
        this.e = j;
        this.f = j2;
    }

    private C22738vk6 n(long j, C22738vk6 c22738vk6) {
        long jQ = AbstractC9683aN7.q(c22738vk6.a, 0L, j - this.e);
        long j2 = c22738vk6.b;
        long j3 = this.f;
        long jQ2 = AbstractC9683aN7.q(j2, 0L, j3 == Long.MIN_VALUE ? Long.MAX_VALUE : j3 - j);
        return (jQ == c22738vk6.a && jQ2 == c22738vk6.b) ? c22738vk6 : new C22738vk6(jQ, jQ2);
    }

    private static boolean v(long j, InterfaceC13679ge2[] interfaceC13679ge2Arr) {
        if (j != 0) {
            for (InterfaceC13679ge2 interfaceC13679ge2 : interfaceC13679ge2Arr) {
                if (interfaceC13679ge2 != null) {
                    X xR = interfaceC13679ge2.r();
                    if (!AbstractC24462yf4.a(xR.l, xR.i)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
    public long a() {
        long jA = this.a.a();
        if (jA != Long.MIN_VALUE) {
            long j = this.f;
            if (j == Long.MIN_VALUE || jA < j) {
                return jA;
            }
        }
        return Long.MIN_VALUE;
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
    public boolean c() {
        return this.a.c();
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
    public boolean d(long j) {
        return this.a.d(j);
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
    public long e() {
        long jE = this.a.e();
        if (jE != Long.MIN_VALUE) {
            long j = this.f;
            if (j == Long.MIN_VALUE || jE < j) {
                return jE;
            }
        }
        return Long.MIN_VALUE;
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod, com.google.android.exoplayer2.source.SequenceableLoader
    public void f(long j) {
        this.a.f(j);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0063  */
    @Override // com.google.android.exoplayer2.source.MediaPeriod
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public long i(ir.nasim.InterfaceC13679ge2[] r13, boolean[] r14, com.google.android.exoplayer2.source.SampleStream[] r15, boolean[] r16, long r17) {
        /*
            r12 = this;
            r0 = r12
            r1 = r15
            int r2 = r1.length
            com.google.android.exoplayer2.source.ClippingMediaPeriod$ClippingSampleStream[] r2 = new com.google.android.exoplayer2.source.ClippingMediaPeriod.ClippingSampleStream[r2]
            r0.c = r2
            int r2 = r1.length
            com.google.android.exoplayer2.source.SampleStream[] r9 = new com.google.android.exoplayer2.source.SampleStream[r2]
            r10 = 0
            r2 = r10
        Lc:
            int r3 = r1.length
            r11 = 0
            if (r2 >= r3) goto L21
            com.google.android.exoplayer2.source.ClippingMediaPeriod$ClippingSampleStream[] r3 = r0.c
            r4 = r1[r2]
            com.google.android.exoplayer2.source.ClippingMediaPeriod$ClippingSampleStream r4 = (com.google.android.exoplayer2.source.ClippingMediaPeriod.ClippingSampleStream) r4
            r3[r2] = r4
            if (r4 == 0) goto L1c
            com.google.android.exoplayer2.source.SampleStream r11 = r4.a
        L1c:
            r9[r2] = r11
            int r2 = r2 + 1
            goto Lc
        L21:
            com.google.android.exoplayer2.source.MediaPeriod r2 = r0.a
            r3 = r13
            r4 = r14
            r5 = r9
            r6 = r16
            r7 = r17
            long r2 = r2.i(r3, r4, r5, r6, r7)
            boolean r4 = r12.o()
            if (r4 == 0) goto L43
            long r4 = r0.e
            int r6 = (r17 > r4 ? 1 : (r17 == r4 ? 0 : -1))
            if (r6 != 0) goto L43
            r6 = r13
            boolean r4 = v(r4, r13)
            if (r4 == 0) goto L43
            r4 = r2
            goto L48
        L43:
            r4 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
        L48:
            r0.d = r4
            int r4 = (r2 > r17 ? 1 : (r2 == r17 ? 0 : -1))
            if (r4 == 0) goto L63
            long r4 = r0.e
            int r4 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r4 < 0) goto L61
            long r4 = r0.f
            r6 = -9223372036854775808
            int r6 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r6 == 0) goto L63
            int r4 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r4 > 0) goto L61
            goto L63
        L61:
            r4 = r10
            goto L64
        L63:
            r4 = 1
        L64:
            ir.nasim.AbstractC20011rK.g(r4)
        L67:
            int r4 = r1.length
            if (r10 >= r4) goto L8d
            r4 = r9[r10]
            if (r4 != 0) goto L73
            com.google.android.exoplayer2.source.ClippingMediaPeriod$ClippingSampleStream[] r4 = r0.c
            r4[r10] = r11
            goto L84
        L73:
            com.google.android.exoplayer2.source.ClippingMediaPeriod$ClippingSampleStream[] r5 = r0.c
            r6 = r5[r10]
            if (r6 == 0) goto L7d
            com.google.android.exoplayer2.source.SampleStream r6 = r6.a
            if (r6 == r4) goto L84
        L7d:
            com.google.android.exoplayer2.source.ClippingMediaPeriod$ClippingSampleStream r6 = new com.google.android.exoplayer2.source.ClippingMediaPeriod$ClippingSampleStream
            r6.<init>(r4)
            r5[r10] = r6
        L84:
            com.google.android.exoplayer2.source.ClippingMediaPeriod$ClippingSampleStream[] r4 = r0.c
            r4 = r4[r10]
            r1[r10] = r4
            int r10 = r10 + 1
            goto L67
        L8d:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.source.ClippingMediaPeriod.i(ir.nasim.ge2[], boolean[], com.google.android.exoplayer2.source.SampleStream[], boolean[], long):long");
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod.Callback
    public void j(MediaPeriod mediaPeriod) {
        if (this.g != null) {
            return;
        }
        ((MediaPeriod.Callback) AbstractC20011rK.e(this.b)).j(this);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0034  */
    @Override // com.google.android.exoplayer2.source.MediaPeriod
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public long k(long r6) {
        /*
            r5 = this;
            r0 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r5.d = r0
            com.google.android.exoplayer2.source.ClippingMediaPeriod$ClippingSampleStream[] r0 = r5.c
            int r1 = r0.length
            r2 = 0
            r3 = r2
        Lc:
            if (r3 >= r1) goto L18
            r4 = r0[r3]
            if (r4 == 0) goto L15
            r4.a()
        L15:
            int r3 = r3 + 1
            goto Lc
        L18:
            com.google.android.exoplayer2.source.MediaPeriod r0 = r5.a
            long r0 = r0.k(r6)
            int r6 = (r0 > r6 ? 1 : (r0 == r6 ? 0 : -1))
            if (r6 == 0) goto L34
            long r6 = r5.e
            int r6 = (r0 > r6 ? 1 : (r0 == r6 ? 0 : -1))
            if (r6 < 0) goto L35
            long r6 = r5.f
            r3 = -9223372036854775808
            int r3 = (r6 > r3 ? 1 : (r6 == r3 ? 0 : -1))
            if (r3 == 0) goto L34
            int r6 = (r0 > r6 ? 1 : (r0 == r6 ? 0 : -1))
            if (r6 > 0) goto L35
        L34:
            r2 = 1
        L35:
            ir.nasim.AbstractC20011rK.g(r2)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.source.ClippingMediaPeriod.k(long):long");
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public long l() {
        if (o()) {
            long j = this.d;
            this.d = -9223372036854775807L;
            long jL = l();
            return jL != -9223372036854775807L ? jL : j;
        }
        long jL2 = this.a.l();
        if (jL2 == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        AbstractC20011rK.g(jL2 >= this.e);
        long j2 = this.f;
        AbstractC20011rK.g(j2 == Long.MIN_VALUE || jL2 <= j2);
        return jL2;
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public void m(MediaPeriod.Callback callback, long j) {
        this.b = callback;
        this.a.m(this, j);
    }

    boolean o() {
        return this.d != -9223372036854775807L;
    }

    @Override // com.google.android.exoplayer2.source.SequenceableLoader.Callback
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public void g(MediaPeriod mediaPeriod) {
        ((MediaPeriod.Callback) AbstractC20011rK.e(this.b)).g(this);
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public void q() throws ClippingMediaSource.IllegalClippingException {
        ClippingMediaSource.IllegalClippingException illegalClippingException = this.g;
        if (illegalClippingException != null) {
            throw illegalClippingException;
        }
        this.a.q();
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public long r(long j, C22738vk6 c22738vk6) {
        long j2 = this.e;
        if (j == j2) {
            return j2;
        }
        return this.a.r(j, n(j, c22738vk6));
    }

    public void s(ClippingMediaSource.IllegalClippingException illegalClippingException) {
        this.g = illegalClippingException;
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public TrackGroupArray t() {
        return this.a.t();
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod
    public void u(long j, boolean z) {
        this.a.u(j, z);
    }

    public void w(long j, long j2) {
        this.e = j;
        this.f = j2;
    }
}
