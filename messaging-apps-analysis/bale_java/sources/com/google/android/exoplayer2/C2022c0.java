package com.google.android.exoplayer2;

import com.google.android.exoplayer2.source.ClippingMediaPeriod;
import com.google.android.exoplayer2.source.EmptySampleStream;
import com.google.android.exoplayer2.source.MediaPeriod;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.SampleStream;
import com.google.android.exoplayer2.source.TrackGroupArray;
import ir.nasim.AbstractC18815pI3;
import ir.nasim.AbstractC20011rK;
import ir.nasim.AbstractC7218Qt7;
import ir.nasim.C7452Rt7;
import ir.nasim.InterfaceC13679ge2;
import ir.nasim.InterfaceC19684qm;
import ir.nasim.InterfaceC24899zO5;

/* renamed from: com.google.android.exoplayer2.c0, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
final class C2022c0 {
    public final MediaPeriod a;
    public final Object b;
    public final SampleStream[] c;
    public boolean d;
    public boolean e;
    public C2024d0 f;
    public boolean g;
    private final boolean[] h;
    private final InterfaceC24899zO5[] i;
    private final AbstractC7218Qt7 j;
    private final u0 k;
    private C2022c0 l;
    private TrackGroupArray m;
    private C7452Rt7 n;
    private long o;

    public C2022c0(InterfaceC24899zO5[] interfaceC24899zO5Arr, long j, AbstractC7218Qt7 abstractC7218Qt7, InterfaceC19684qm interfaceC19684qm, u0 u0Var, C2024d0 c2024d0, C7452Rt7 c7452Rt7) {
        this.i = interfaceC24899zO5Arr;
        this.o = j;
        this.j = abstractC7218Qt7;
        this.k = u0Var;
        MediaSource.MediaPeriodId mediaPeriodId = c2024d0.a;
        this.b = mediaPeriodId.a;
        this.f = c2024d0;
        this.m = TrackGroupArray.d;
        this.n = c7452Rt7;
        this.c = new SampleStream[interfaceC24899zO5Arr.length];
        this.h = new boolean[interfaceC24899zO5Arr.length];
        this.a = e(mediaPeriodId, u0Var, interfaceC19684qm, c2024d0.b, c2024d0.d);
    }

    private void c(SampleStream[] sampleStreamArr) {
        int i = 0;
        while (true) {
            InterfaceC24899zO5[] interfaceC24899zO5Arr = this.i;
            if (i >= interfaceC24899zO5Arr.length) {
                return;
            }
            if (interfaceC24899zO5Arr[i].g() == -2 && this.n.c(i)) {
                sampleStreamArr[i] = new EmptySampleStream();
            }
            i++;
        }
    }

    private static MediaPeriod e(MediaSource.MediaPeriodId mediaPeriodId, u0 u0Var, InterfaceC19684qm interfaceC19684qm, long j, long j2) {
        MediaPeriod mediaPeriodH = u0Var.h(mediaPeriodId, interfaceC19684qm, j);
        return j2 != -9223372036854775807L ? new ClippingMediaPeriod(mediaPeriodH, true, 0L, j2) : mediaPeriodH;
    }

    private void f() {
        if (!r()) {
            return;
        }
        int i = 0;
        while (true) {
            C7452Rt7 c7452Rt7 = this.n;
            if (i >= c7452Rt7.a) {
                return;
            }
            boolean zC = c7452Rt7.c(i);
            InterfaceC13679ge2 interfaceC13679ge2 = this.n.c[i];
            if (zC && interfaceC13679ge2 != null) {
                interfaceC13679ge2.f();
            }
            i++;
        }
    }

    private void g(SampleStream[] sampleStreamArr) {
        int i = 0;
        while (true) {
            InterfaceC24899zO5[] interfaceC24899zO5Arr = this.i;
            if (i >= interfaceC24899zO5Arr.length) {
                return;
            }
            if (interfaceC24899zO5Arr[i].g() == -2) {
                sampleStreamArr[i] = null;
            }
            i++;
        }
    }

    private void h() {
        if (!r()) {
            return;
        }
        int i = 0;
        while (true) {
            C7452Rt7 c7452Rt7 = this.n;
            if (i >= c7452Rt7.a) {
                return;
            }
            boolean zC = c7452Rt7.c(i);
            InterfaceC13679ge2 interfaceC13679ge2 = this.n.c[i];
            if (zC && interfaceC13679ge2 != null) {
                interfaceC13679ge2.n();
            }
            i++;
        }
    }

    private boolean r() {
        return this.l == null;
    }

    private static void u(u0 u0Var, MediaPeriod mediaPeriod) {
        try {
            if (mediaPeriod instanceof ClippingMediaPeriod) {
                u0Var.y(((ClippingMediaPeriod) mediaPeriod).a);
            } else {
                u0Var.y(mediaPeriod);
            }
        } catch (RuntimeException e) {
            AbstractC18815pI3.d("MediaPeriodHolder", "Period release failed.", e);
        }
    }

    public void A() {
        MediaPeriod mediaPeriod = this.a;
        if (mediaPeriod instanceof ClippingMediaPeriod) {
            long j = this.f.d;
            if (j == -9223372036854775807L) {
                j = Long.MIN_VALUE;
            }
            ((ClippingMediaPeriod) mediaPeriod).w(0L, j);
        }
    }

    public long a(C7452Rt7 c7452Rt7, long j, boolean z) {
        return b(c7452Rt7, j, z, new boolean[this.i.length]);
    }

    public long b(C7452Rt7 c7452Rt7, long j, boolean z, boolean[] zArr) {
        int i = 0;
        while (true) {
            boolean z2 = true;
            if (i >= c7452Rt7.a) {
                break;
            }
            boolean[] zArr2 = this.h;
            if (z || !c7452Rt7.b(this.n, i)) {
                z2 = false;
            }
            zArr2[i] = z2;
            i++;
        }
        g(this.c);
        f();
        this.n = c7452Rt7;
        h();
        long jI = this.a.i(c7452Rt7.c, this.h, this.c, zArr, j);
        c(this.c);
        this.e = false;
        int i2 = 0;
        while (true) {
            SampleStream[] sampleStreamArr = this.c;
            if (i2 >= sampleStreamArr.length) {
                return jI;
            }
            if (sampleStreamArr[i2] != null) {
                AbstractC20011rK.g(c7452Rt7.c(i2));
                if (this.i[i2].g() != -2) {
                    this.e = true;
                }
            } else {
                AbstractC20011rK.g(c7452Rt7.c[i2] == null);
            }
            i2++;
        }
    }

    public void d(long j) {
        AbstractC20011rK.g(r());
        this.a.d(y(j));
    }

    public long i() {
        if (!this.d) {
            return this.f.b;
        }
        long jE = this.e ? this.a.e() : Long.MIN_VALUE;
        return jE == Long.MIN_VALUE ? this.f.e : jE;
    }

    public C2022c0 j() {
        return this.l;
    }

    public long k() {
        if (this.d) {
            return this.a.a();
        }
        return 0L;
    }

    public long l() {
        return this.o;
    }

    public long m() {
        return this.f.b + this.o;
    }

    public TrackGroupArray n() {
        return this.m;
    }

    public C7452Rt7 o() {
        return this.n;
    }

    public void p(float f, J0 j0) {
        this.d = true;
        this.m = this.a.t();
        C7452Rt7 c7452Rt7V = v(f, j0);
        C2024d0 c2024d0 = this.f;
        long jMax = c2024d0.b;
        long j = c2024d0.e;
        if (j != -9223372036854775807L && jMax >= j) {
            jMax = Math.max(0L, j - 1);
        }
        long jA = a(c7452Rt7V, jMax, false);
        long j2 = this.o;
        C2024d0 c2024d02 = this.f;
        this.o = j2 + (c2024d02.b - jA);
        this.f = c2024d02.b(jA);
    }

    public boolean q() {
        return this.d && (!this.e || this.a.e() == Long.MIN_VALUE);
    }

    public void s(long j) {
        AbstractC20011rK.g(r());
        if (this.d) {
            this.a.f(y(j));
        }
    }

    public void t() {
        f();
        u(this.k, this.a);
    }

    public C7452Rt7 v(float f, J0 j0) {
        C7452Rt7 c7452Rt7H = this.j.h(this.i, n(), this.f.a, j0);
        for (InterfaceC13679ge2 interfaceC13679ge2 : c7452Rt7H.c) {
            if (interfaceC13679ge2 != null) {
                interfaceC13679ge2.h(f);
            }
        }
        return c7452Rt7H;
    }

    public void w(C2022c0 c2022c0) {
        if (c2022c0 == this.l) {
            return;
        }
        f();
        this.l = c2022c0;
        h();
    }

    public void x(long j) {
        this.o = j;
    }

    public long y(long j) {
        return j - l();
    }

    public long z(long j) {
        return j + l();
    }
}
