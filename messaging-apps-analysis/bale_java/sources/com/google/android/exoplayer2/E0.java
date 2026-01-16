package com.google.android.exoplayer2;

import android.content.Context;
import android.os.Looper;
import android.view.Surface;
import android.view.SurfaceView;
import android.view.TextureView;
import com.google.android.exoplayer2.InterfaceC2037k;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.ShuffleOrder;
import com.google.android.exoplayer2.z0;
import ir.nasim.C12372eV7;
import ir.nasim.C16831lw1;
import ir.nasim.C3962Dc1;
import ir.nasim.C6740Ot7;
import ir.nasim.InterfaceC6170Mm;
import ir.nasim.RF3;
import java.util.List;

/* loaded from: classes2.dex */
public class E0 extends AbstractC2025e implements InterfaceC2037k {
    private final K b;
    private final C3962Dc1 c;

    public static final class a {
        private final InterfaceC2037k.b a;

        public a(Context context) {
            this.a = new InterfaceC2037k.b(context);
        }

        public E0 a() {
            return this.a.j();
        }

        public a b(RF3 rf3) {
            this.a.s(rf3);
            return this;
        }

        public a c(MediaSource.Factory factory) {
            this.a.t(factory);
            return this;
        }
    }

    E0(InterfaceC2037k.b bVar) {
        C3962Dc1 c3962Dc1 = new C3962Dc1();
        this.c = c3962Dc1;
        try {
            this.b = new K(bVar, this);
            c3962Dc1.f();
        } catch (Throwable th) {
            this.c.f();
            throw th;
        }
    }

    private void R0() {
        this.c.c();
    }

    @Override // com.google.android.exoplayer2.z0
    public C2020b0 A0() {
        R0();
        return this.b.A0();
    }

    @Override // com.google.android.exoplayer2.z0
    public int B() {
        R0();
        return this.b.B();
    }

    @Override // com.google.android.exoplayer2.z0
    public void D(boolean z) {
        R0();
        this.b.D(z);
    }

    @Override // com.google.android.exoplayer2.z0
    public long D0() {
        R0();
        return this.b.D0();
    }

    @Override // com.google.android.exoplayer2.InterfaceC2037k
    public void E(InterfaceC6170Mm interfaceC6170Mm) {
        R0();
        this.b.E(interfaceC6170Mm);
    }

    @Override // com.google.android.exoplayer2.z0
    public long E0() {
        R0();
        return this.b.E0();
    }

    @Override // com.google.android.exoplayer2.z0
    public K0 F() {
        R0();
        return this.b.F();
    }

    @Override // com.google.android.exoplayer2.z0
    public C16831lw1 H() {
        R0();
        return this.b.H();
    }

    @Override // com.google.android.exoplayer2.z0
    public int I() {
        R0();
        return this.b.I();
    }

    @Override // com.google.android.exoplayer2.InterfaceC2037k
    public void J(boolean z) {
        R0();
        this.b.J(z);
    }

    @Override // com.google.android.exoplayer2.AbstractC2025e
    public void K0(int i, long j, int i2, boolean z) {
        R0();
        this.b.K0(i, j, i2, z);
    }

    @Override // com.google.android.exoplayer2.z0
    public int M() {
        R0();
        return this.b.M();
    }

    @Override // com.google.android.exoplayer2.z0
    public J0 N() {
        R0();
        return this.b.N();
    }

    @Override // com.google.android.exoplayer2.z0
    public Looper O() {
        R0();
        return this.b.O();
    }

    @Override // com.google.android.exoplayer2.z0
    public C6740Ot7 P() {
        R0();
        return this.b.P();
    }

    @Override // com.google.android.exoplayer2.z0
    public void R(TextureView textureView) {
        R0();
        this.b.R(textureView);
    }

    @Override // com.google.android.exoplayer2.InterfaceC2037k
    public void S(com.google.android.exoplayer2.audio.a aVar, boolean z) {
        R0();
        this.b.S(aVar, z);
    }

    public C2035j S0() {
        R0();
        return this.b.f2();
    }

    @Override // com.google.android.exoplayer2.z0
    public void T(C6740Ot7 c6740Ot7) {
        R0();
        this.b.T(c6740Ot7);
    }

    public int T0() {
        R0();
        return this.b.g2();
    }

    public boolean U0() {
        R0();
        return this.b.o2();
    }

    @Override // com.google.android.exoplayer2.z0
    public z0.b V() {
        R0();
        return this.b.V();
    }

    public void V0(InterfaceC6170Mm interfaceC6170Mm) {
        R0();
        this.b.T2(interfaceC6170Mm);
    }

    @Override // com.google.android.exoplayer2.z0
    public boolean X() {
        R0();
        return this.b.X();
    }

    @Override // com.google.android.exoplayer2.z0
    public void Y(boolean z) {
        R0();
        this.b.Y(z);
    }

    @Override // com.google.android.exoplayer2.z0
    public long Z() {
        R0();
        return this.b.Z();
    }

    @Override // com.google.android.exoplayer2.z0
    public com.google.android.exoplayer2.audio.a b() {
        R0();
        return this.b.b();
    }

    @Override // com.google.android.exoplayer2.z0
    public int b0() {
        R0();
        return this.b.b0();
    }

    @Override // com.google.android.exoplayer2.z0
    public y0 c() {
        R0();
        return this.b.c();
    }

    @Override // com.google.android.exoplayer2.InterfaceC2037k
    public void d(MediaSource mediaSource) {
        R0();
        this.b.d(mediaSource);
    }

    @Override // com.google.android.exoplayer2.z0
    public void d0(TextureView textureView) {
        R0();
        this.b.d0(textureView);
    }

    @Override // com.google.android.exoplayer2.z0
    public void e(y0 y0Var) {
        R0();
        this.b.e(y0Var);
    }

    @Override // com.google.android.exoplayer2.z0
    public C12372eV7 e0() {
        R0();
        return this.b.e0();
    }

    @Override // com.google.android.exoplayer2.z0
    public long f() {
        R0();
        return this.b.f();
    }

    @Override // com.google.android.exoplayer2.z0
    public float f0() {
        R0();
        return this.b.f0();
    }

    @Override // com.google.android.exoplayer2.z0
    public void g(float f) {
        R0();
        this.b.g(f);
    }

    @Override // com.google.android.exoplayer2.z0
    public int h0() {
        R0();
        return this.b.h0();
    }

    @Override // com.google.android.exoplayer2.z0
    public void i0() {
        R0();
        this.b.i0();
    }

    @Override // com.google.android.exoplayer2.z0
    public void j(Surface surface) {
        R0();
        this.b.j(surface);
    }

    @Override // com.google.android.exoplayer2.z0
    public boolean k() {
        R0();
        return this.b.k();
    }

    @Override // com.google.android.exoplayer2.z0
    public long k0() {
        R0();
        return this.b.k0();
    }

    @Override // com.google.android.exoplayer2.z0
    public long l() {
        R0();
        return this.b.l();
    }

    @Override // com.google.android.exoplayer2.z0
    public long l0() {
        R0();
        return this.b.l0();
    }

    @Override // com.google.android.exoplayer2.z0
    public void m0(z0.d dVar) {
        R0();
        this.b.m0(dVar);
    }

    @Override // com.google.android.exoplayer2.z0
    public void n0(int i, List list) {
        R0();
        this.b.n0(i, list);
    }

    @Override // com.google.android.exoplayer2.z0
    public void o(z0.d dVar) {
        R0();
        this.b.o(dVar);
    }

    @Override // com.google.android.exoplayer2.z0
    public long o0() {
        R0();
        return this.b.o0();
    }

    @Override // com.google.android.exoplayer2.z0
    public int p() {
        R0();
        return this.b.p();
    }

    @Override // com.google.android.exoplayer2.InterfaceC2037k
    public void q0(ShuffleOrder shuffleOrder) {
        R0();
        this.b.q0(shuffleOrder);
    }

    @Override // com.google.android.exoplayer2.z0
    public void r() {
        R0();
        this.b.r();
    }

    @Override // com.google.android.exoplayer2.z0
    public int r0() {
        R0();
        return this.b.r0();
    }

    @Override // com.google.android.exoplayer2.z0
    public void release() {
        R0();
        this.b.release();
    }

    @Override // com.google.android.exoplayer2.z0
    public void s(int i) {
        R0();
        this.b.s(i);
    }

    @Override // com.google.android.exoplayer2.z0
    public void stop() {
        R0();
        this.b.stop();
    }

    @Override // com.google.android.exoplayer2.z0
    public void t0(SurfaceView surfaceView) {
        R0();
        this.b.t0(surfaceView);
    }

    @Override // com.google.android.exoplayer2.z0
    public void u(List list, boolean z) {
        R0();
        this.b.u(list, z);
    }

    @Override // com.google.android.exoplayer2.z0
    public void v(SurfaceView surfaceView) {
        R0();
        this.b.v(surfaceView);
    }

    @Override // com.google.android.exoplayer2.z0
    public boolean v0() {
        R0();
        return this.b.v0();
    }

    @Override // com.google.android.exoplayer2.z0
    public long w0() {
        R0();
        return this.b.w0();
    }

    @Override // com.google.android.exoplayer2.z0
    public void z(int i, int i2) {
        R0();
        this.b.z(i, i2);
    }

    @Override // com.google.android.exoplayer2.InterfaceC2037k
    public void z0(MediaSource mediaSource, boolean z) {
        R0();
        this.b.z0(mediaSource, z);
    }

    @Override // com.google.android.exoplayer2.z0, com.google.android.exoplayer2.InterfaceC2037k
    public ExoPlaybackException a() {
        R0();
        return this.b.a();
    }
}
