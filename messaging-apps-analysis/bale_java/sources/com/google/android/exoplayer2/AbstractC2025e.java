package com.google.android.exoplayer2;

import com.google.android.exoplayer2.J0;
import ir.nasim.AbstractC12710f43;
import java.util.List;

/* renamed from: com.google.android.exoplayer2.e, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC2025e implements z0 {
    protected final J0.d a = new J0.d();

    protected AbstractC2025e() {
    }

    private int I0() {
        int iB = B();
        if (iB == 1) {
            return 0;
        }
        return iB;
    }

    private void J0(int i) {
        K0(r0(), -9223372036854775807L, i, true);
    }

    private void L0(long j, int i) {
        K0(r0(), j, i, false);
    }

    private void M0(int i, int i2) {
        K0(i, -9223372036854775807L, i2, false);
    }

    private void N0(int i) {
        int iG0 = G0();
        if (iG0 == -1) {
            return;
        }
        if (iG0 == r0()) {
            J0(i);
        } else {
            M0(iG0, i);
        }
    }

    private void O0(long j, int i) {
        long jD0 = D0() + j;
        long jF = f();
        if (jF != -9223372036854775807L) {
            jD0 = Math.min(jD0, jF);
        }
        L0(Math.max(jD0, 0L), i);
    }

    private void P0(int i) {
        int iH0 = H0();
        if (iH0 == -1) {
            return;
        }
        if (iH0 == r0()) {
            J0(i);
        } else {
            M0(iH0, i);
        }
    }

    @Override // com.google.android.exoplayer2.z0
    public final int A() {
        return r0();
    }

    @Override // com.google.android.exoplayer2.z0
    public final void B0(int i, C2018a0 c2018a0) {
        n0(i, AbstractC12710f43.W(c2018a0));
    }

    @Override // com.google.android.exoplayer2.z0
    public final void C() {
        if (N().v() || k()) {
            return;
        }
        boolean zG0 = g0();
        if (F0() && !p0()) {
            if (zG0) {
                P0(7);
            }
        } else if (!zG0 || D0() > Z()) {
            L0(0L, 7);
        } else {
            P0(7);
        }
    }

    @Override // com.google.android.exoplayer2.z0
    public final void C0(List list) {
        u(list, true);
    }

    @Override // com.google.android.exoplayer2.z0
    public final boolean F0() {
        J0 j0N = N();
        return !j0N.v() && j0N.s(r0(), this.a).i();
    }

    @Override // com.google.android.exoplayer2.z0
    public final boolean G() {
        return G0() != -1;
    }

    public final int G0() {
        J0 j0N = N();
        if (j0N.v()) {
            return -1;
        }
        return j0N.j(r0(), I0(), v0());
    }

    public final int H0() {
        J0 j0N = N();
        if (j0N.v()) {
            return -1;
        }
        return j0N.q(r0(), I0(), v0());
    }

    @Override // com.google.android.exoplayer2.z0
    public final boolean K(int i) {
        return V().d(i);
    }

    public abstract void K0(int i, long j, int i2, boolean z);

    @Override // com.google.android.exoplayer2.z0
    public final boolean L() {
        J0 j0N = N();
        return !j0N.v() && j0N.s(r0(), this.a).i;
    }

    @Override // com.google.android.exoplayer2.z0
    public final void Q() {
        if (N().v() || k()) {
            return;
        }
        if (G()) {
            N0(9);
        } else if (F0() && L()) {
            M0(r0(), 9);
        }
    }

    public final void Q0(float f) {
        e(c().e(f));
    }

    @Override // com.google.android.exoplayer2.z0
    public final void U(int i, long j) {
        K0(i, j, 10, false);
    }

    @Override // com.google.android.exoplayer2.z0
    public final void W(C2018a0 c2018a0) {
        C0(AbstractC12710f43.W(c2018a0));
    }

    @Override // com.google.android.exoplayer2.z0
    public final long a0() {
        J0 j0N = N();
        if (j0N.v()) {
            return -9223372036854775807L;
        }
        return j0N.s(r0(), this.a).g();
    }

    @Override // com.google.android.exoplayer2.z0
    public final void c0(C2018a0 c2018a0) {
        u0(AbstractC12710f43.W(c2018a0));
    }

    @Override // com.google.android.exoplayer2.z0
    public final boolean g0() {
        return H0() != -1;
    }

    @Override // com.google.android.exoplayer2.z0
    public final void h() {
        D(false);
    }

    @Override // com.google.android.exoplayer2.z0
    public final boolean i() {
        return p() == 3 && X() && M() == 0;
    }

    @Override // com.google.android.exoplayer2.z0
    public final void j0(int i) {
        M0(i, 10);
    }

    @Override // com.google.android.exoplayer2.z0
    public final void m() {
        z(0, Integer.MAX_VALUE);
    }

    @Override // com.google.android.exoplayer2.z0
    public final C2018a0 n() {
        J0 j0N = N();
        if (j0N.v()) {
            return null;
        }
        return j0N.s(r0(), this.a).c;
    }

    @Override // com.google.android.exoplayer2.z0
    public final boolean p0() {
        J0 j0N = N();
        return !j0N.v() && j0N.s(r0(), this.a).h;
    }

    @Override // com.google.android.exoplayer2.z0
    public final void q() {
        D(true);
    }

    @Override // com.google.android.exoplayer2.z0
    public final int s0() {
        return G0();
    }

    @Override // com.google.android.exoplayer2.z0
    public final void t() {
        M0(r0(), 4);
    }

    @Override // com.google.android.exoplayer2.z0
    public final void u0(List list) {
        n0(Integer.MAX_VALUE, list);
    }

    @Override // com.google.android.exoplayer2.z0
    public final void w(int i) {
        z(i, i + 1);
    }

    @Override // com.google.android.exoplayer2.z0
    public final void x(long j) {
        L0(j, 5);
    }

    @Override // com.google.android.exoplayer2.z0
    public final void x0() {
        O0(k0(), 12);
    }

    @Override // com.google.android.exoplayer2.z0
    public final int y() {
        return N().u();
    }

    @Override // com.google.android.exoplayer2.z0
    public final void y0() {
        O0(-E0(), 11);
    }
}
