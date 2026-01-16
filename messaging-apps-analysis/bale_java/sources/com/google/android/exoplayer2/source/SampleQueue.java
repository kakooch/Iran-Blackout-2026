package com.google.android.exoplayer2.source;

import androidx.recyclerview.widget.RecyclerView;
import com.google.android.exoplayer2.X;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.drm.DrmSession;
import com.google.android.exoplayer2.drm.h;
import com.google.android.exoplayer2.drm.i;
import com.google.android.exoplayer2.source.SampleQueue;
import io.appmetrica.analytics.AppMetricaDefaultValues;
import ir.nasim.AbstractC20011rK;
import ir.nasim.AbstractC24462yf4;
import ir.nasim.AbstractC9683aN7;
import ir.nasim.C21664tv2;
import ir.nasim.EW4;
import ir.nasim.InterfaceC18631oz1;
import ir.nasim.InterfaceC19684qm;
import ir.nasim.InterfaceC23269we1;
import ir.nasim.InterfaceC4589Ft7;

/* loaded from: classes2.dex */
public class SampleQueue implements InterfaceC4589Ft7 {
    private X A;
    private X B;
    private int C;
    private boolean D;
    private boolean E;
    private long F;
    private boolean G;
    private final SampleDataQueue a;
    private final com.google.android.exoplayer2.drm.i d;
    private final h.a e;
    private UpstreamFormatChangedListener f;
    private X g;
    private DrmSession h;
    private int p;
    private int q;
    private int r;
    private int s;
    private boolean w;
    private boolean z;
    private final SampleExtrasHolder b = new SampleExtrasHolder();
    private int i = AppMetricaDefaultValues.DEFAULT_MAX_REPORTS_IN_DATABASE_COUNT;
    private int[] j = new int[AppMetricaDefaultValues.DEFAULT_MAX_REPORTS_IN_DATABASE_COUNT];
    private long[] k = new long[AppMetricaDefaultValues.DEFAULT_MAX_REPORTS_IN_DATABASE_COUNT];
    private long[] n = new long[AppMetricaDefaultValues.DEFAULT_MAX_REPORTS_IN_DATABASE_COUNT];
    private int[] m = new int[AppMetricaDefaultValues.DEFAULT_MAX_REPORTS_IN_DATABASE_COUNT];
    private int[] l = new int[AppMetricaDefaultValues.DEFAULT_MAX_REPORTS_IN_DATABASE_COUNT];
    private InterfaceC4589Ft7.a[] o = new InterfaceC4589Ft7.a[AppMetricaDefaultValues.DEFAULT_MAX_REPORTS_IN_DATABASE_COUNT];
    private final SpannedData c = new SpannedData(new InterfaceC23269we1() { // from class: com.google.android.exoplayer2.source.j
        @Override // ir.nasim.InterfaceC23269we1
        public final void accept(Object obj) {
            SampleQueue.G((SampleQueue.SharedSampleMetadata) obj);
        }
    });
    private long t = Long.MIN_VALUE;
    private long u = Long.MIN_VALUE;
    private long v = Long.MIN_VALUE;
    private boolean y = true;
    private boolean x = true;

    static final class SampleExtrasHolder {
        public int a;
        public long b;
        public InterfaceC4589Ft7.a c;

        SampleExtrasHolder() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    static final class SharedSampleMetadata {
        public final X a;
        public final i.b b;

        private SharedSampleMetadata(X x, i.b bVar) {
            this.a = x;
            this.b = bVar;
        }
    }

    public interface UpstreamFormatChangedListener {
        void h(X x);
    }

    protected SampleQueue(InterfaceC19684qm interfaceC19684qm, com.google.android.exoplayer2.drm.i iVar, h.a aVar) {
        this.d = iVar;
        this.e = aVar;
        this.a = new SampleDataQueue(interfaceC19684qm);
    }

    private boolean C() {
        return this.s != this.p;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void G(SharedSampleMetadata sharedSampleMetadata) {
        sharedSampleMetadata.b.release();
    }

    private boolean H(int i) {
        DrmSession drmSession = this.h;
        return drmSession == null || drmSession.getState() == 4 || ((this.m[i] & 1073741824) == 0 && this.h.d());
    }

    private void J(X x, C21664tv2 c21664tv2) {
        X x2 = this.g;
        boolean z = x2 == null;
        DrmInitData drmInitData = z ? null : x2.o;
        this.g = x;
        DrmInitData drmInitData2 = x.o;
        com.google.android.exoplayer2.drm.i iVar = this.d;
        c21664tv2.b = iVar != null ? x.d(iVar.a(x)) : x;
        c21664tv2.a = this.h;
        if (this.d == null) {
            return;
        }
        if (z || !AbstractC9683aN7.c(drmInitData, drmInitData2)) {
            DrmSession drmSession = this.h;
            DrmSession drmSessionC = this.d.c(this.e, x);
            this.h = drmSessionC;
            c21664tv2.a = drmSessionC;
            if (drmSession != null) {
                drmSession.b(this.e);
            }
        }
    }

    private synchronized int K(C21664tv2 c21664tv2, DecoderInputBuffer decoderInputBuffer, boolean z, boolean z2, SampleExtrasHolder sampleExtrasHolder) {
        try {
            decoderInputBuffer.d = false;
            if (!C()) {
                if (!z2 && !this.w) {
                    X x = this.B;
                    if (x == null || (!z && x == this.g)) {
                        return -3;
                    }
                    J((X) AbstractC20011rK.e(x), c21664tv2);
                    return -5;
                }
                decoderInputBuffer.x(4);
                return -4;
            }
            X x2 = ((SharedSampleMetadata) this.c.f(x())).a;
            if (!z && x2 == this.g) {
                int iY = y(this.s);
                if (!H(iY)) {
                    decoderInputBuffer.d = true;
                    return -3;
                }
                decoderInputBuffer.x(this.m[iY]);
                long j = this.n[iY];
                decoderInputBuffer.e = j;
                if (j < this.t) {
                    decoderInputBuffer.o(RecyclerView.UNDEFINED_DURATION);
                }
                sampleExtrasHolder.a = this.l[iY];
                sampleExtrasHolder.b = this.k[iY];
                sampleExtrasHolder.c = this.o[iY];
                return -4;
            }
            J(x2, c21664tv2);
            return -5;
        } catch (Throwable th) {
            throw th;
        }
    }

    private void P() {
        DrmSession drmSession = this.h;
        if (drmSession != null) {
            drmSession.b(this.e);
            this.h = null;
            this.g = null;
        }
    }

    private synchronized void S() {
        this.s = 0;
        this.a.o();
    }

    private synchronized boolean W(X x) {
        try {
            this.y = false;
            if (AbstractC9683aN7.c(x, this.B)) {
                return false;
            }
            if (this.c.h() || !((SharedSampleMetadata) this.c.g()).a.equals(x)) {
                this.B = x;
            } else {
                this.B = ((SharedSampleMetadata) this.c.g()).a;
            }
            X x2 = this.B;
            this.D = AbstractC24462yf4.a(x2.l, x2.i);
            this.E = false;
            return true;
        } catch (Throwable th) {
            throw th;
        }
    }

    private synchronized boolean h(long j) {
        if (this.p == 0) {
            return j > this.u;
        }
        if (v() >= j) {
            return false;
        }
        q(this.q + j(j));
        return true;
    }

    private synchronized void i(long j, int i, long j2, int i2, InterfaceC4589Ft7.a aVar) {
        try {
            int i3 = this.p;
            if (i3 > 0) {
                int iY = y(i3 - 1);
                AbstractC20011rK.a(this.k[iY] + ((long) this.l[iY]) <= j2);
            }
            this.w = (536870912 & i) != 0;
            this.v = Math.max(this.v, j);
            int iY2 = y(this.p);
            this.n[iY2] = j;
            this.k[iY2] = j2;
            this.l[iY2] = i2;
            this.m[iY2] = i;
            this.o[iY2] = aVar;
            this.j[iY2] = this.C;
            if (this.c.h() || !((SharedSampleMetadata) this.c.g()).a.equals(this.B)) {
                com.google.android.exoplayer2.drm.i iVar = this.d;
                this.c.b(B(), new SharedSampleMetadata((X) AbstractC20011rK.e(this.B), iVar != null ? iVar.d(this.e, this.B) : i.b.a));
            }
            int i4 = this.p + 1;
            this.p = i4;
            int i5 = this.i;
            if (i4 == i5) {
                int i6 = i5 + AppMetricaDefaultValues.DEFAULT_MAX_REPORTS_IN_DATABASE_COUNT;
                int[] iArr = new int[i6];
                long[] jArr = new long[i6];
                long[] jArr2 = new long[i6];
                int[] iArr2 = new int[i6];
                int[] iArr3 = new int[i6];
                InterfaceC4589Ft7.a[] aVarArr = new InterfaceC4589Ft7.a[i6];
                int i7 = this.r;
                int i8 = i5 - i7;
                System.arraycopy(this.k, i7, jArr, 0, i8);
                System.arraycopy(this.n, this.r, jArr2, 0, i8);
                System.arraycopy(this.m, this.r, iArr2, 0, i8);
                System.arraycopy(this.l, this.r, iArr3, 0, i8);
                System.arraycopy(this.o, this.r, aVarArr, 0, i8);
                System.arraycopy(this.j, this.r, iArr, 0, i8);
                int i9 = this.r;
                System.arraycopy(this.k, 0, jArr, i8, i9);
                System.arraycopy(this.n, 0, jArr2, i8, i9);
                System.arraycopy(this.m, 0, iArr2, i8, i9);
                System.arraycopy(this.l, 0, iArr3, i8, i9);
                System.arraycopy(this.o, 0, aVarArr, i8, i9);
                System.arraycopy(this.j, 0, iArr, i8, i9);
                this.k = jArr;
                this.n = jArr2;
                this.m = iArr2;
                this.l = iArr3;
                this.o = aVarArr;
                this.j = iArr;
                this.r = 0;
                this.i = i6;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    private int j(long j) {
        int i = this.p;
        int iY = y(i - 1);
        while (i > this.s && this.n[iY] >= j) {
            i--;
            iY--;
            if (iY == -1) {
                iY = this.i - 1;
            }
        }
        return i;
    }

    public static SampleQueue k(InterfaceC19684qm interfaceC19684qm, com.google.android.exoplayer2.drm.i iVar, h.a aVar) {
        return new SampleQueue(interfaceC19684qm, (com.google.android.exoplayer2.drm.i) AbstractC20011rK.e(iVar), (h.a) AbstractC20011rK.e(aVar));
    }

    private synchronized long l(long j, boolean z, boolean z2) {
        int i;
        try {
            int i2 = this.p;
            if (i2 != 0) {
                long[] jArr = this.n;
                int i3 = this.r;
                if (j >= jArr[i3]) {
                    if (z2 && (i = this.s) != i2) {
                        i2 = i + 1;
                    }
                    int iS = s(i3, i2, j, z);
                    if (iS == -1) {
                        return -1L;
                    }
                    return n(iS);
                }
            }
            return -1L;
        } finally {
        }
    }

    private synchronized long m() {
        int i = this.p;
        if (i == 0) {
            return -1L;
        }
        return n(i);
    }

    private long n(int i) {
        this.u = Math.max(this.u, w(i));
        this.p -= i;
        int i2 = this.q + i;
        this.q = i2;
        int i3 = this.r + i;
        this.r = i3;
        int i4 = this.i;
        if (i3 >= i4) {
            this.r = i3 - i4;
        }
        int i5 = this.s - i;
        this.s = i5;
        if (i5 < 0) {
            this.s = 0;
        }
        this.c.e(i2);
        if (this.p != 0) {
            return this.k[this.r];
        }
        int i6 = this.r;
        if (i6 == 0) {
            i6 = this.i;
        }
        return this.k[i6 - 1] + this.l[r6];
    }

    private long q(int i) {
        int iB = B() - i;
        boolean z = false;
        AbstractC20011rK.a(iB >= 0 && iB <= this.p - this.s);
        int i2 = this.p - iB;
        this.p = i2;
        this.v = Math.max(this.u, w(i2));
        if (iB == 0 && this.w) {
            z = true;
        }
        this.w = z;
        this.c.d(i);
        int i3 = this.p;
        if (i3 == 0) {
            return 0L;
        }
        return this.k[y(i3 - 1)] + this.l[r9];
    }

    private int s(int i, int i2, long j, boolean z) {
        int i3 = -1;
        for (int i4 = 0; i4 < i2; i4++) {
            long j2 = this.n[i];
            if (j2 > j) {
                return i3;
            }
            if (!z || (this.m[i] & 1) != 0) {
                if (j2 == j) {
                    return i4;
                }
                i3 = i4;
            }
            i++;
            if (i == this.i) {
                i = 0;
            }
        }
        return i3;
    }

    private long w(int i) {
        long jMax = Long.MIN_VALUE;
        if (i == 0) {
            return Long.MIN_VALUE;
        }
        int iY = y(i - 1);
        for (int i2 = 0; i2 < i; i2++) {
            jMax = Math.max(jMax, this.n[iY]);
            if ((this.m[iY] & 1) != 0) {
                break;
            }
            iY--;
            if (iY == -1) {
                iY = this.i - 1;
            }
        }
        return jMax;
    }

    private int y(int i) {
        int i2 = this.r + i;
        int i3 = this.i;
        return i2 < i3 ? i2 : i2 - i3;
    }

    public final synchronized X A() {
        return this.y ? null : this.B;
    }

    public final int B() {
        return this.q + this.p;
    }

    protected final void D() {
        this.z = true;
    }

    public final synchronized boolean E() {
        return this.w;
    }

    public synchronized boolean F(boolean z) {
        X x;
        boolean z2 = true;
        if (C()) {
            if (((SharedSampleMetadata) this.c.f(x())).a != this.g) {
                return true;
            }
            return H(y(this.s));
        }
        if (!z && !this.w && ((x = this.B) == null || x == this.g)) {
            z2 = false;
        }
        return z2;
    }

    public void I() throws DrmSession.DrmSessionException {
        DrmSession drmSession = this.h;
        if (drmSession != null && drmSession.getState() == 1) {
            throw ((DrmSession.DrmSessionException) AbstractC20011rK.e(this.h.e()));
        }
    }

    public final synchronized int L() {
        try {
        } catch (Throwable th) {
            throw th;
        }
        return C() ? this.j[y(this.s)] : this.C;
    }

    public void M() {
        p();
        P();
    }

    public int N(C21664tv2 c21664tv2, DecoderInputBuffer decoderInputBuffer, int i, boolean z) {
        int iK = K(c21664tv2, decoderInputBuffer, (i & 2) != 0, z, this.b);
        if (iK == -4 && !decoderInputBuffer.u()) {
            boolean z2 = (i & 1) != 0;
            if ((i & 4) == 0) {
                if (z2) {
                    this.a.f(decoderInputBuffer, this.b);
                } else {
                    this.a.m(decoderInputBuffer, this.b);
                }
            }
            if (!z2) {
                this.s++;
            }
        }
        return iK;
    }

    public void O() {
        R(true);
        P();
    }

    public final void Q() {
        R(false);
    }

    public void R(boolean z) {
        this.a.n();
        this.p = 0;
        this.q = 0;
        this.r = 0;
        this.s = 0;
        this.x = true;
        this.t = Long.MIN_VALUE;
        this.u = Long.MIN_VALUE;
        this.v = Long.MIN_VALUE;
        this.w = false;
        this.c.c();
        if (z) {
            this.A = null;
            this.B = null;
            this.y = true;
        }
    }

    public final synchronized boolean T(long j, boolean z) {
        S();
        int iY = y(this.s);
        if (C() && j >= this.n[iY] && (j <= this.v || z)) {
            int iS = s(iY, this.p - this.s, j, true);
            if (iS == -1) {
                return false;
            }
            this.t = j;
            this.s += iS;
            return true;
        }
        return false;
    }

    public final void U(long j) {
        if (this.F != j) {
            this.F = j;
            D();
        }
    }

    public final void V(long j) {
        this.t = j;
    }

    public final void X(UpstreamFormatChangedListener upstreamFormatChangedListener) {
        this.f = upstreamFormatChangedListener;
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x000e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final synchronized void Y(int r3) {
        /*
            r2 = this;
            monitor-enter(r2)
            if (r3 < 0) goto Le
            int r0 = r2.s     // Catch: java.lang.Throwable -> Lc
            int r0 = r0 + r3
            int r1 = r2.p     // Catch: java.lang.Throwable -> Lc
            if (r0 > r1) goto Le
            r0 = 1
            goto Lf
        Lc:
            r3 = move-exception
            goto L19
        Le:
            r0 = 0
        Lf:
            ir.nasim.AbstractC20011rK.a(r0)     // Catch: java.lang.Throwable -> Lc
            int r0 = r2.s     // Catch: java.lang.Throwable -> Lc
            int r0 = r0 + r3
            r2.s = r0     // Catch: java.lang.Throwable -> Lc
            monitor-exit(r2)
            return
        L19:
            monitor-exit(r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.source.SampleQueue.Y(int):void");
    }

    public final void Z(int i) {
        this.C = i;
    }

    @Override // ir.nasim.InterfaceC4589Ft7
    public final void a(EW4 ew4, int i, int i2) {
        this.a.q(ew4, i);
    }

    public final void a0() {
        this.G = true;
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0054  */
    @Override // ir.nasim.InterfaceC4589Ft7
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void b(long r12, int r14, int r15, int r16, ir.nasim.InterfaceC4589Ft7.a r17) {
        /*
            r11 = this;
            r8 = r11
            boolean r0 = r8.z
            if (r0 == 0) goto L10
            com.google.android.exoplayer2.X r0 = r8.A
            java.lang.Object r0 = ir.nasim.AbstractC20011rK.i(r0)
            com.google.android.exoplayer2.X r0 = (com.google.android.exoplayer2.X) r0
            r11.c(r0)
        L10:
            r0 = r14 & 1
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L18
            r3 = r2
            goto L19
        L18:
            r3 = r1
        L19:
            boolean r4 = r8.x
            if (r4 == 0) goto L22
            if (r3 != 0) goto L20
            return
        L20:
            r8.x = r1
        L22:
            long r4 = r8.F
            long r4 = r4 + r12
            boolean r6 = r8.D
            if (r6 == 0) goto L54
            long r6 = r8.t
            int r6 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r6 >= 0) goto L30
            return
        L30:
            if (r0 != 0) goto L54
            boolean r0 = r8.E
            if (r0 != 0) goto L50
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r6 = "Overriding unexpected non-sync sample for format: "
            r0.append(r6)
            com.google.android.exoplayer2.X r6 = r8.B
            r0.append(r6)
            java.lang.String r0 = r0.toString()
            java.lang.String r6 = "SampleQueue"
            ir.nasim.AbstractC18815pI3.k(r6, r0)
            r8.E = r2
        L50:
            r0 = r14 | 1
            r6 = r0
            goto L55
        L54:
            r6 = r14
        L55:
            boolean r0 = r8.G
            if (r0 == 0) goto L66
            if (r3 == 0) goto L65
            boolean r0 = r11.h(r4)
            if (r0 != 0) goto L62
            goto L65
        L62:
            r8.G = r1
            goto L66
        L65:
            return
        L66:
            com.google.android.exoplayer2.source.SampleDataQueue r0 = r8.a
            long r0 = r0.e()
            r7 = r15
            long r2 = (long) r7
            long r0 = r0 - r2
            r2 = r16
            long r2 = (long) r2
            long r9 = r0 - r2
            r0 = r11
            r1 = r4
            r3 = r6
            r4 = r9
            r6 = r15
            r7 = r17
            r0.i(r1, r3, r4, r6, r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.source.SampleQueue.b(long, int, int, int, ir.nasim.Ft7$a):void");
    }

    @Override // ir.nasim.InterfaceC4589Ft7
    public final void c(X x) {
        X xT = t(x);
        this.z = false;
        this.A = x;
        boolean zW = W(xT);
        UpstreamFormatChangedListener upstreamFormatChangedListener = this.f;
        if (upstreamFormatChangedListener == null || !zW) {
            return;
        }
        upstreamFormatChangedListener.h(xT);
    }

    @Override // ir.nasim.InterfaceC4589Ft7
    public final int e(InterfaceC18631oz1 interfaceC18631oz1, int i, boolean z, int i2) {
        return this.a.p(interfaceC18631oz1, i, z);
    }

    public final void o(long j, boolean z, boolean z2) {
        this.a.b(l(j, z, z2));
    }

    public final void p() {
        this.a.b(m());
    }

    public final void r(int i) {
        this.a.c(q(i));
    }

    protected X t(X x) {
        return (this.F == 0 || x.p == Long.MAX_VALUE) ? x : x.c().k0(x.p + this.F).G();
    }

    public final synchronized long u() {
        return this.v;
    }

    public final synchronized long v() {
        return Math.max(this.u, w(this.s));
    }

    public final int x() {
        return this.q + this.s;
    }

    public final synchronized int z(long j, boolean z) {
        int iY = y(this.s);
        if (C() && j >= this.n[iY]) {
            if (j > this.v && z) {
                return this.p - this.s;
            }
            int iS = s(iY, this.p - this.s, j, true);
            if (iS == -1) {
                return 0;
            }
            return iS;
        }
        return 0;
    }
}
