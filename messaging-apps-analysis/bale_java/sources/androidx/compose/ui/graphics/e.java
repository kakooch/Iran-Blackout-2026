package androidx.compose.ui.graphics;

import androidx.compose.ui.e;
import ir.nasim.AbstractC21430te5;
import ir.nasim.AbstractC8614Ws3;
import ir.nasim.AbstractC9572aB4;
import ir.nasim.C19938rB7;
import ir.nasim.C24381yX0;
import ir.nasim.ED1;
import ir.nasim.InterfaceC10031ax6;
import ir.nasim.InterfaceC11734dW3;
import ir.nasim.InterfaceC12377eW3;
import ir.nasim.InterfaceC21655tu3;
import ir.nasim.KG1;
import ir.nasim.ON5;
import ir.nasim.UA2;
import ir.nasim.XA4;
import ir.nasim.ZV3;

/* loaded from: classes2.dex */
final class e extends e.c implements InterfaceC21655tu3 {
    private boolean A;
    private long B;
    private long D;
    private int G;
    private UA2 H;
    private float o;
    private float p;
    private float q;
    private float r;
    private float s;
    private float t;
    private float u;
    private float v;
    private float w;
    private float x;
    private long y;
    private InterfaceC10031ax6 z;

    static final class a extends AbstractC8614Ws3 implements UA2 {
        a() {
            super(1);
        }

        public final void a(c cVar) {
            cVar.g(e.this.A());
            cVar.m(e.this.K());
            cVar.c(e.this.w2());
            cVar.n(e.this.H());
            cVar.e(e.this.G());
            cVar.B(e.this.B2());
            cVar.j(e.this.I());
            cVar.k(e.this.r());
            cVar.l(e.this.s());
            cVar.i(e.this.w());
            cVar.C0(e.this.z0());
            cVar.V(e.this.C2());
            cVar.x(e.this.y2());
            e.this.A2();
            cVar.f(null);
            cVar.v(e.this.x2());
            cVar.y(e.this.D2());
            cVar.q(e.this.z2());
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((c) obj);
            return C19938rB7.a;
        }
    }

    static final class b extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ AbstractC21430te5 e;
        final /* synthetic */ e f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(AbstractC21430te5 abstractC21430te5, e eVar) {
            super(1);
            this.e = abstractC21430te5;
            this.f = eVar;
        }

        public final void a(AbstractC21430te5.a aVar) {
            AbstractC21430te5.a.v(aVar, this.e, 0, 0, 0.0f, this.f.H, 4, null);
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((AbstractC21430te5.a) obj);
            return C19938rB7.a;
        }
    }

    public /* synthetic */ e(float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, long j, InterfaceC10031ax6 interfaceC10031ax6, boolean z, ON5 on5, long j2, long j3, int i, ED1 ed1) {
        this(f, f2, f3, f4, f5, f6, f7, f8, f9, f10, j, interfaceC10031ax6, z, on5, j2, j3, i);
    }

    public final float A() {
        return this.o;
    }

    public final ON5 A2() {
        return null;
    }

    public final void B(float f) {
        this.t = f;
    }

    public final float B2() {
        return this.t;
    }

    public final void C0(long j) {
        this.y = j;
    }

    public final InterfaceC10031ax6 C2() {
        return this.z;
    }

    public final long D2() {
        return this.D;
    }

    public final void E2() {
        XA4 xa4K2 = KG1.j(this, AbstractC9572aB4.a(2)).K2();
        if (xa4K2 != null) {
            xa4K2.D3(this.H, true);
        }
    }

    public final float G() {
        return this.s;
    }

    public final float H() {
        return this.r;
    }

    public final float I() {
        return this.u;
    }

    public final float K() {
        return this.p;
    }

    public final void V(InterfaceC10031ax6 interfaceC10031ax6) {
        this.z = interfaceC10031ax6;
    }

    @Override // androidx.compose.ui.e.c
    public boolean Z1() {
        return false;
    }

    @Override // ir.nasim.InterfaceC21655tu3
    public InterfaceC11734dW3 b(InterfaceC12377eW3 interfaceC12377eW3, ZV3 zv3, long j) {
        AbstractC21430te5 abstractC21430te5L0 = zv3.l0(j);
        return InterfaceC12377eW3.Q1(interfaceC12377eW3, abstractC21430te5L0.P0(), abstractC21430te5L0.A0(), null, new b(abstractC21430te5L0, this), 4, null);
    }

    public final void c(float f) {
        this.q = f;
    }

    public final void e(float f) {
        this.s = f;
    }

    public final void g(float f) {
        this.o = f;
    }

    public final void i(float f) {
        this.x = f;
    }

    public final void j(float f) {
        this.u = f;
    }

    public final void k(float f) {
        this.v = f;
    }

    public final void l(float f) {
        this.w = f;
    }

    public final void m(float f) {
        this.p = f;
    }

    public final void n(float f) {
        this.r = f;
    }

    public final void q(int i) {
        this.G = i;
    }

    public final float r() {
        return this.v;
    }

    public final float s() {
        return this.w;
    }

    public String toString() {
        return "SimpleGraphicsLayerModifier(scaleX=" + this.o + ", scaleY=" + this.p + ", alpha = " + this.q + ", translationX=" + this.r + ", translationY=" + this.s + ", shadowElevation=" + this.t + ", rotationX=" + this.u + ", rotationY=" + this.v + ", rotationZ=" + this.w + ", cameraDistance=" + this.x + ", transformOrigin=" + ((Object) f.i(this.y)) + ", shape=" + this.z + ", clip=" + this.A + ", renderEffect=" + ((Object) null) + ", ambientShadowColor=" + ((Object) C24381yX0.x(this.B)) + ", spotShadowColor=" + ((Object) C24381yX0.x(this.D)) + ", compositingStrategy=" + ((Object) androidx.compose.ui.graphics.a.g(this.G)) + ')';
    }

    public final void v(long j) {
        this.B = j;
    }

    public final float w() {
        return this.x;
    }

    public final float w2() {
        return this.q;
    }

    public final void x(boolean z) {
        this.A = z;
    }

    public final long x2() {
        return this.B;
    }

    public final void y(long j) {
        this.D = j;
    }

    public final boolean y2() {
        return this.A;
    }

    public final long z0() {
        return this.y;
    }

    public final int z2() {
        return this.G;
    }

    private e(float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, long j, InterfaceC10031ax6 interfaceC10031ax6, boolean z, ON5 on5, long j2, long j3, int i) {
        this.o = f;
        this.p = f2;
        this.q = f3;
        this.r = f4;
        this.s = f5;
        this.t = f6;
        this.u = f7;
        this.v = f8;
        this.w = f9;
        this.x = f10;
        this.y = j;
        this.z = interfaceC10031ax6;
        this.A = z;
        this.B = j2;
        this.D = j3;
        this.G = i;
        this.H = new a();
    }

    public final void f(ON5 on5) {
    }
}
