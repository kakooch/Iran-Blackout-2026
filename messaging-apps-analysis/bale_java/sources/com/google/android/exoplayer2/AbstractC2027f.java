package com.google.android.exoplayer2;

import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.source.SampleStream;
import ir.nasim.AO5;
import ir.nasim.AbstractC20011rK;
import ir.nasim.C15493jg5;
import ir.nasim.C21664tv2;
import ir.nasim.InterfaceC22009uW3;
import ir.nasim.InterfaceC24899zO5;

/* renamed from: com.google.android.exoplayer2.f, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC2027f implements D0, InterfaceC24899zO5 {
    private final int a;
    private AO5 c;
    private int d;
    private C15493jg5 e;
    private int f;
    private SampleStream g;
    private X[] h;
    private long i;
    private long j;
    private boolean l;
    private boolean m;
    private final C21664tv2 b = new C21664tv2();
    private long k = Long.MIN_VALUE;

    public AbstractC2027f(int i) {
        this.a = i;
    }

    private void W(long j, boolean z) {
        this.l = false;
        this.j = j;
        this.k = j;
        Q(j, z);
    }

    @Override // ir.nasim.InterfaceC24899zO5
    public int A() {
        return 0;
    }

    @Override // com.google.android.exoplayer2.D0
    public final long C() {
        return this.k;
    }

    @Override // com.google.android.exoplayer2.D0
    public final void D(long j) {
        W(j, false);
    }

    @Override // com.google.android.exoplayer2.D0
    public InterfaceC22009uW3 E() {
        return null;
    }

    protected final ExoPlaybackException G(Throwable th, X x, int i) {
        return H(th, x, false, i);
    }

    protected final ExoPlaybackException H(Throwable th, X x, boolean z, int i) {
        int iF;
        if (x == null || this.m) {
            iF = 4;
        } else {
            this.m = true;
            try {
                iF = InterfaceC24899zO5.F(b(x));
            } catch (ExoPlaybackException unused) {
            } finally {
                this.m = false;
            }
        }
        return ExoPlaybackException.k(th, getName(), K(), x, iF, z, i);
    }

    protected final AO5 I() {
        return (AO5) AbstractC20011rK.e(this.c);
    }

    protected final C21664tv2 J() {
        this.b.a();
        return this.b;
    }

    protected final int K() {
        return this.d;
    }

    protected final C15493jg5 L() {
        return (C15493jg5) AbstractC20011rK.e(this.e);
    }

    protected final X[] M() {
        return (X[]) AbstractC20011rK.e(this.h);
    }

    protected final boolean N() {
        return j() ? this.l : ((SampleStream) AbstractC20011rK.e(this.g)).h();
    }

    protected abstract void O();

    protected void P(boolean z, boolean z2) {
    }

    protected abstract void Q(long j, boolean z);

    protected void R() {
    }

    protected void S() {
    }

    protected void T() {
    }

    protected abstract void U(X[] xArr, long j, long j2);

    protected final int V(C21664tv2 c21664tv2, DecoderInputBuffer decoderInputBuffer, int i) {
        int iO = ((SampleStream) AbstractC20011rK.e(this.g)).o(c21664tv2, decoderInputBuffer, i);
        if (iO == -4) {
            if (decoderInputBuffer.u()) {
                this.k = Long.MIN_VALUE;
                return this.l ? -4 : -3;
            }
            long j = decoderInputBuffer.e + this.i;
            decoderInputBuffer.e = j;
            this.k = Math.max(this.k, j);
        } else if (iO == -5) {
            X x = (X) AbstractC20011rK.e(c21664tv2.b);
            if (x.p != Long.MAX_VALUE) {
                c21664tv2.b = x.c().k0(x.p + this.i).G();
            }
        }
        return iO;
    }

    protected int X(long j) {
        return ((SampleStream) AbstractC20011rK.e(this.g)).s(j - this.i);
    }

    @Override // com.google.android.exoplayer2.D0
    public final void f() {
        AbstractC20011rK.g(this.f == 1);
        this.b.a();
        this.f = 0;
        this.g = null;
        this.h = null;
        this.l = false;
        O();
    }

    @Override // com.google.android.exoplayer2.D0, ir.nasim.InterfaceC24899zO5
    public final int g() {
        return this.a;
    }

    @Override // com.google.android.exoplayer2.D0
    public final int getState() {
        return this.f;
    }

    @Override // com.google.android.exoplayer2.D0
    public final SampleStream i() {
        return this.g;
    }

    @Override // com.google.android.exoplayer2.D0
    public final boolean j() {
        return this.k == Long.MIN_VALUE;
    }

    @Override // com.google.android.exoplayer2.D0
    public final void l() {
        this.l = true;
    }

    @Override // com.google.android.exoplayer2.D0
    public final void m(AO5 ao5, X[] xArr, SampleStream sampleStream, long j, boolean z, boolean z2, long j2, long j3) {
        AbstractC20011rK.g(this.f == 0);
        this.c = ao5;
        this.f = 1;
        P(z, z2);
        t(xArr, sampleStream, j2, j3);
        W(j, z);
    }

    @Override // com.google.android.exoplayer2.A0.b
    public void q(int i, Object obj) {
    }

    @Override // com.google.android.exoplayer2.D0
    public final void r() {
        ((SampleStream) AbstractC20011rK.e(this.g)).b();
    }

    @Override // com.google.android.exoplayer2.D0
    public final void reset() {
        AbstractC20011rK.g(this.f == 0);
        this.b.a();
        R();
    }

    @Override // com.google.android.exoplayer2.D0
    public final boolean s() {
        return this.l;
    }

    @Override // com.google.android.exoplayer2.D0
    public final void start() {
        AbstractC20011rK.g(this.f == 1);
        this.f = 2;
        S();
    }

    @Override // com.google.android.exoplayer2.D0
    public final void stop() {
        AbstractC20011rK.g(this.f == 2);
        this.f = 1;
        T();
    }

    @Override // com.google.android.exoplayer2.D0
    public final void t(X[] xArr, SampleStream sampleStream, long j, long j2) {
        AbstractC20011rK.g(!this.l);
        this.g = sampleStream;
        if (this.k == Long.MIN_VALUE) {
            this.k = j;
        }
        this.h = xArr;
        this.i = j2;
        U(xArr, j, j2);
    }

    @Override // com.google.android.exoplayer2.D0
    public final void u(int i, C15493jg5 c15493jg5) {
        this.d = i;
        this.e = c15493jg5;
    }

    @Override // com.google.android.exoplayer2.D0
    public final InterfaceC24899zO5 w() {
        return this;
    }
}
