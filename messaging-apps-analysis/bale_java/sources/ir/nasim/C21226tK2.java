package ir.nasim;

import android.graphics.Canvas;
import android.graphics.Outline;
import android.graphics.RectF;
import android.os.Build;
import ir.nasim.AbstractC10274bN4;
import ir.nasim.ZG4;

/* renamed from: ir.nasim.tK2, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C21226tK2 {
    public static final a y = new a(null);
    private static final InterfaceC8155Ut3 z;
    private final androidx.compose.ui.graphics.layer.a a;
    private Outline f;
    private long h;
    private long i;
    private float j;
    private AbstractC10274bN4 k;
    private V05 l;
    private V05 m;
    private boolean n;
    private C20576sF0 o;
    private InterfaceC12969fU4 p;
    private int q;
    private final FS0 r;
    private boolean s;
    private long t;
    private long u;
    private long v;
    private boolean w;
    private RectF x;
    private WH1 b = ZZ1.a();
    private EnumC12613eu3 c = EnumC12613eu3.a;
    private UA2 d = c.e;
    private final UA2 e = new b();
    private boolean g = true;

    /* renamed from: ir.nasim.tK2$a */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.tK2$b */
    static final class b extends AbstractC8614Ws3 implements UA2 {
        b() {
            super(1);
        }

        public final void a(InterfaceC17460n02 interfaceC17460n02) {
            V05 v05 = C21226tK2.this.l;
            if (!C21226tK2.this.n || !C21226tK2.this.l() || v05 == null) {
                C21226tK2.this.i(interfaceC17460n02);
                return;
            }
            C21226tK2 c21226tK2 = C21226tK2.this;
            int iB = GV0.a.b();
            YZ1 yz1Z1 = interfaceC17460n02.z1();
            long jD = yz1Z1.d();
            yz1Z1.e().n();
            try {
                yz1Z1.b().d(v05, iB);
                c21226tK2.i(interfaceC17460n02);
            } finally {
                yz1Z1.e().i();
                yz1Z1.g(jD);
            }
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((InterfaceC17460n02) obj);
            return C19938rB7.a;
        }
    }

    static {
        z = AbstractC7214Qt3.a.a() ? C8389Vt3.a : Build.VERSION.SDK_INT >= 28 ? C8889Xt3.a : C16904m37.a.a() ? C8623Wt3.a : C8389Vt3.a;
    }

    public C21226tK2(androidx.compose.ui.graphics.layer.a aVar, AbstractC7214Qt3 abstractC7214Qt3) {
        this.a = aVar;
        ZG4.a aVar2 = ZG4.b;
        this.h = aVar2.c();
        this.i = OD6.b.a();
        this.r = new FS0();
        aVar.x(false);
        this.t = C22045ua3.b.b();
        this.u = C4414Fa3.b.a();
        this.v = aVar2.b();
    }

    private final Outline B() {
        Outline outline = this.f;
        if (outline != null) {
            return outline;
        }
        Outline outline2 = new Outline();
        this.f = outline2;
        return outline2;
    }

    private final RectF C() {
        RectF rectF = this.x;
        if (rectF != null) {
            return rectF;
        }
        RectF rectF2 = new RectF();
        this.x = rectF2;
        return rectF2;
    }

    private final void D() {
        this.q++;
    }

    private final void E() {
        this.q--;
        f();
    }

    private final void G() {
        this.a.J(this.b, this.c, this, this.e);
    }

    private final void H() {
        if (this.a.h()) {
            return;
        }
        try {
            G();
        } catch (Throwable unused) {
        }
    }

    private final void J() {
        this.k = null;
        this.l = null;
        this.i = OD6.b.a();
        this.h = ZG4.b.c();
        this.j = 0.0f;
        this.g = true;
        this.n = false;
    }

    private final void R(long j, long j2) {
        this.a.t(C22045ua3.k(j), C22045ua3.l(j), j2);
    }

    private final void b0(long j) {
        if (C4414Fa3.e(this.u, j)) {
            return;
        }
        this.u = j;
        R(this.t, j);
        if (this.i == 9205357640488583168L) {
            this.g = true;
            e();
        }
    }

    private final void d(C21226tK2 c21226tK2) {
        if (this.r.i(c21226tK2)) {
            c21226tK2.D();
        }
    }

    private final void e() {
        if (this.g) {
            Outline outline = null;
            if (this.w || v() > 0.0f) {
                V05 v05 = this.l;
                if (v05 != null) {
                    RectF rectFC = C();
                    if (!(v05 instanceof C19724qq)) {
                        throw new UnsupportedOperationException("Unable to obtain android.graphics.Path");
                    }
                    ((C19724qq) v05).u().computeBounds(rectFC, false);
                    Outline outlineH0 = h0(v05);
                    if (outlineH0 != null) {
                        outlineH0.setAlpha(j());
                        outline = outlineH0;
                    }
                    this.a.F(outline, C4414Fa3.c((4294967295L & Math.round(rectFC.height())) | (Math.round(rectFC.width()) << 32)));
                    if (this.n && this.w) {
                        this.a.x(false);
                        this.a.d();
                    } else {
                        this.a.x(this.w);
                    }
                } else {
                    this.a.x(this.w);
                    OD6.b.b();
                    Outline outlineB = B();
                    long jD = AbstractC4663Ga3.d(this.u);
                    long j = this.h;
                    long j2 = this.i;
                    long j3 = j2 == 9205357640488583168L ? jD : j2;
                    int i = (int) (j >> 32);
                    int i2 = (int) (j & 4294967295L);
                    outlineB.setRoundRect(Math.round(Float.intBitsToFloat(i)), Math.round(Float.intBitsToFloat(i2)), Math.round(Float.intBitsToFloat(i) + Float.intBitsToFloat((int) (j3 >> 32))), Math.round(Float.intBitsToFloat(i2) + Float.intBitsToFloat((int) (4294967295L & j3))), this.j);
                    outlineB.setAlpha(j());
                    this.a.F(outlineB, AbstractC4663Ga3.c(j3));
                }
            } else {
                this.a.x(false);
                this.a.F(null, C4414Fa3.b.a());
            }
        }
        this.g = false;
    }

    private final void f() {
        if (this.s && this.q == 0) {
            g();
        }
    }

    private final void g0(Canvas canvas) {
        float fK = C22045ua3.k(this.t);
        float fL = C22045ua3.l(this.t);
        float fK2 = C22045ua3.k(this.t) + ((int) (this.u >> 32));
        float fL2 = C22045ua3.l(this.t) + ((int) (this.u & 4294967295L));
        float fJ = j();
        AbstractC24975zX0 abstractC24975zX0M = m();
        int iK = k();
        if (fJ < 1.0f || !AbstractC7094Qg0.E(iK, AbstractC7094Qg0.a.B()) || abstractC24975zX0M != null || AbstractC6567Ob1.e(n(), AbstractC6567Ob1.a.c())) {
            InterfaceC12969fU4 interfaceC12969fU4A = this.p;
            if (interfaceC12969fU4A == null) {
                interfaceC12969fU4A = AbstractC15587jq.a();
                this.p = interfaceC12969fU4A;
            }
            interfaceC12969fU4A.c(fJ);
            interfaceC12969fU4A.g(iK);
            interfaceC12969fU4A.e(abstractC24975zX0M);
            canvas.saveLayer(fK, fL, fK2, fL2, interfaceC12969fU4A.p());
        } else {
            canvas.save();
        }
        canvas.translate(fK, fL);
        canvas.concat(this.a.C());
    }

    private final Outline h0(V05 v05) {
        Outline outline;
        int i = Build.VERSION.SDK_INT;
        if (i > 28 || v05.d()) {
            Outline outlineB = B();
            if (i >= 30) {
                C13524gN4.a.a(outlineB, v05);
            } else {
                if (!(v05 instanceof C19724qq)) {
                    throw new UnsupportedOperationException("Unable to obtain android.graphics.Path");
                }
                outlineB.setConvexPath(((C19724qq) v05).u());
            }
            this.n = !outlineB.canClip();
            outline = outlineB;
        } else {
            Outline outline2 = this.f;
            if (outline2 != null) {
                outline2.setEmpty();
            }
            this.n = true;
            this.a.E(true);
            outline = null;
        }
        this.l = v05;
        return outline;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0089  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void i(ir.nasim.InterfaceC17460n02 r15) {
        /*
            r14 = this;
            ir.nasim.FS0 r0 = r14.r
            ir.nasim.tK2 r1 = ir.nasim.FS0.b(r0)
            ir.nasim.FS0.g(r0, r1)
            ir.nasim.Sm4 r1 = ir.nasim.FS0.a(r0)
            if (r1 == 0) goto L28
            boolean r2 = r1.e()
            if (r2 == 0) goto L28
            ir.nasim.Sm4 r2 = ir.nasim.FS0.c(r0)
            if (r2 != 0) goto L22
            ir.nasim.Sm4 r2 = ir.nasim.AbstractC23254wc6.a()
            ir.nasim.FS0.f(r0, r2)
        L22:
            r2.i(r1)
            r1.m()
        L28:
            r1 = 1
            ir.nasim.FS0.h(r0, r1)
            ir.nasim.UA2 r1 = r14.d
            r1.invoke(r15)
            r15 = 0
            ir.nasim.FS0.h(r0, r15)
            ir.nasim.tK2 r1 = ir.nasim.FS0.d(r0)
            if (r1 == 0) goto L3e
            r1.E()
        L3e:
            ir.nasim.Sm4 r0 = ir.nasim.FS0.c(r0)
            if (r0 == 0) goto L91
            boolean r1 = r0.e()
            if (r1 == 0) goto L91
            java.lang.Object[] r1 = r0.b
            long[] r2 = r0.a
            int r3 = r2.length
            int r3 = r3 + (-2)
            if (r3 < 0) goto L8e
            r4 = r15
        L54:
            r5 = r2[r4]
            long r7 = ~r5
            r9 = 7
            long r7 = r7 << r9
            long r7 = r7 & r5
            r9 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r7 = r7 & r9
            int r7 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r7 == 0) goto L89
            int r7 = r4 - r3
            int r7 = ~r7
            int r7 = r7 >>> 31
            r8 = 8
            int r7 = 8 - r7
            r9 = r15
        L6e:
            if (r9 >= r7) goto L87
            r10 = 255(0xff, double:1.26E-321)
            long r10 = r10 & r5
            r12 = 128(0x80, double:6.3E-322)
            int r10 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r10 >= 0) goto L83
            int r10 = r4 << 3
            int r10 = r10 + r9
            r10 = r1[r10]
            ir.nasim.tK2 r10 = (ir.nasim.C21226tK2) r10
            r10.E()
        L83:
            long r5 = r5 >> r8
            int r9 = r9 + 1
            goto L6e
        L87:
            if (r7 != r8) goto L8e
        L89:
            if (r4 == r3) goto L8e
            int r4 = r4 + 1
            goto L54
        L8e:
            r0.m()
        L91:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C21226tK2.i(ir.nasim.n02):void");
    }

    public final boolean A() {
        return this.s;
    }

    public final void F(WH1 wh1, EnumC12613eu3 enumC12613eu3, long j, UA2 ua2) {
        b0(j);
        this.b = wh1;
        this.c = enumC12613eu3;
        this.d = ua2;
        this.a.E(true);
        G();
    }

    public final void I() {
        if (this.s) {
            return;
        }
        this.s = true;
        f();
    }

    public final void K(float f) {
        if (this.a.a() == f) {
            return;
        }
        this.a.c(f);
    }

    public final void L(long j) {
        if (C24381yX0.q(j, this.a.u())) {
            return;
        }
        this.a.v(j);
    }

    public final void M(float f) {
        if (this.a.w() == f) {
            return;
        }
        this.a.i(f);
    }

    public final void N(boolean z2) {
        if (this.w != z2) {
            this.w = z2;
            this.g = true;
            e();
        }
    }

    public final void O(int i) {
        if (AbstractC6567Ob1.e(this.a.q(), i)) {
            return;
        }
        this.a.N(i);
    }

    public final void P(V05 v05) {
        J();
        this.l = v05;
        e();
    }

    public final void Q(long j) {
        if (ZG4.j(this.v, j)) {
            return;
        }
        this.v = j;
        this.a.L(j);
    }

    public final void S(long j, long j2) {
        X(j, j2, 0.0f);
    }

    public final void T(ON5 on5) {
        this.a.p();
        if (AbstractC13042fc3.d(null, on5)) {
            return;
        }
        this.a.f(on5);
    }

    public final void U(float f) {
        if (this.a.I() == f) {
            return;
        }
        this.a.j(f);
    }

    public final void V(float f) {
        if (this.a.r() == f) {
            return;
        }
        this.a.k(f);
    }

    public final void W(float f) {
        if (this.a.s() == f) {
            return;
        }
        this.a.l(f);
    }

    public final void X(long j, long j2, float f) {
        if (ZG4.j(this.h, j) && OD6.f(this.i, j2) && this.j == f && this.l == null) {
            return;
        }
        J();
        this.h = j;
        this.i = j2;
        this.j = f;
        e();
    }

    public final void Y(float f) {
        if (this.a.A() == f) {
            return;
        }
        this.a.g(f);
    }

    public final void Z(float f) {
        if (this.a.K() == f) {
            return;
        }
        this.a.m(f);
    }

    public final void a0(float f) {
        if (this.a.O() == f) {
            return;
        }
        this.a.B(f);
        this.g = true;
        e();
    }

    public final void c0(long j) {
        if (C24381yX0.q(j, this.a.z())) {
            return;
        }
        this.a.y(j);
    }

    public final void d0(long j) {
        if (C22045ua3.j(this.t, j)) {
            return;
        }
        this.t = j;
        R(j, this.u);
    }

    public final void e0(float f) {
        if (this.a.H() == f) {
            return;
        }
        this.a.n(f);
    }

    public final void f0(float f) {
        if (this.a.G() == f) {
            return;
        }
        this.a.e(f);
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0055  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void g() {
        /*
            r15 = this;
            ir.nasim.FS0 r0 = r15.r
            ir.nasim.tK2 r1 = ir.nasim.FS0.b(r0)
            if (r1 == 0) goto Lf
            r1.E()
            r1 = 0
            ir.nasim.FS0.e(r0, r1)
        Lf:
            ir.nasim.Sm4 r0 = ir.nasim.FS0.a(r0)
            if (r0 == 0) goto L5d
            java.lang.Object[] r1 = r0.b
            long[] r2 = r0.a
            int r3 = r2.length
            int r3 = r3 + (-2)
            if (r3 < 0) goto L5a
            r4 = 0
            r5 = r4
        L20:
            r6 = r2[r5]
            long r8 = ~r6
            r10 = 7
            long r8 = r8 << r10
            long r8 = r8 & r6
            r10 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r8 = r8 & r10
            int r8 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r8 == 0) goto L55
            int r8 = r5 - r3
            int r8 = ~r8
            int r8 = r8 >>> 31
            r9 = 8
            int r8 = 8 - r8
            r10 = r4
        L3a:
            if (r10 >= r8) goto L53
            r11 = 255(0xff, double:1.26E-321)
            long r11 = r11 & r6
            r13 = 128(0x80, double:6.3E-322)
            int r11 = (r11 > r13 ? 1 : (r11 == r13 ? 0 : -1))
            if (r11 >= 0) goto L4f
            int r11 = r5 << 3
            int r11 = r11 + r10
            r11 = r1[r11]
            ir.nasim.tK2 r11 = (ir.nasim.C21226tK2) r11
            r11.E()
        L4f:
            long r6 = r6 >> r9
            int r10 = r10 + 1
            goto L3a
        L53:
            if (r8 != r9) goto L5a
        L55:
            if (r5 == r3) goto L5a
            int r5 = r5 + 1
            goto L20
        L5a:
            r0.m()
        L5d:
            androidx.compose.ui.graphics.layer.a r0 = r15.a
            r0.d()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C21226tK2.g():void");
    }

    public final void h(UE0 ue0, C21226tK2 c21226tK2) {
        Canvas canvas;
        boolean z2;
        if (this.s) {
            return;
        }
        e();
        H();
        boolean z3 = v() > 0.0f;
        if (z3) {
            ue0.k();
        }
        Canvas canvasD = AbstractC7624Sn.d(ue0);
        boolean z4 = !canvasD.isHardwareAccelerated();
        if (z4) {
            g0(canvasD);
        }
        boolean z5 = z4 && this.w;
        if (z5) {
            ue0.n();
            AbstractC10274bN4 abstractC10274bN4O = o();
            if (abstractC10274bN4O instanceof AbstractC10274bN4.b) {
                UE0.s(ue0, abstractC10274bN4O.a(), 0, 2, null);
            } else if (abstractC10274bN4O instanceof AbstractC10274bN4.c) {
                V05 v05A = this.m;
                if (v05A != null) {
                    v05A.t();
                } else {
                    v05A = AbstractC21611tq.a();
                    this.m = v05A;
                }
                V05.p(v05A, ((AbstractC10274bN4.c) abstractC10274bN4O).b(), null, 2, null);
                UE0.m(ue0, v05A, 0, 2, null);
            } else if (abstractC10274bN4O instanceof AbstractC10274bN4.a) {
                UE0.m(ue0, ((AbstractC10274bN4.a) abstractC10274bN4O).b(), 0, 2, null);
            }
        }
        if (c21226tK2 != null) {
            c21226tK2.d(this);
        }
        if (AbstractC7624Sn.d(ue0).isHardwareAccelerated() || this.a.D()) {
            canvas = canvasD;
            z2 = z4;
            this.a.M(ue0);
        } else {
            C20576sF0 c20576sF0 = this.o;
            if (c20576sF0 == null) {
                c20576sF0 = new C20576sF0();
                this.o = c20576sF0;
            }
            C20576sF0 c20576sF02 = c20576sF0;
            WH1 wh1 = this.b;
            EnumC12613eu3 enumC12613eu3 = this.c;
            long jD = AbstractC4663Ga3.d(this.u);
            WH1 density = c20576sF02.z1().getDensity();
            EnumC12613eu3 layoutDirection = c20576sF02.z1().getLayoutDirection();
            UE0 ue0E = c20576sF02.z1().e();
            long jD2 = c20576sF02.z1().d();
            canvas = canvasD;
            C21226tK2 c21226tK2I = c20576sF02.z1().i();
            z2 = z4;
            YZ1 yz1Z1 = c20576sF02.z1();
            yz1Z1.f(wh1);
            yz1Z1.c(enumC12613eu3);
            yz1Z1.a(ue0);
            yz1Z1.g(jD);
            yz1Z1.h(this);
            ue0.n();
            try {
                i(c20576sF02);
            } finally {
                ue0.i();
                YZ1 yz1Z12 = c20576sF02.z1();
                yz1Z12.f(density);
                yz1Z12.c(layoutDirection);
                yz1Z12.a(ue0E);
                yz1Z12.g(jD2);
                yz1Z12.h(c21226tK2I);
            }
        }
        if (z5) {
            ue0.i();
        }
        if (z3) {
            ue0.p();
        }
        if (z2) {
            canvas.restore();
        }
    }

    public final float j() {
        return this.a.a();
    }

    public final int k() {
        return this.a.o();
    }

    public final boolean l() {
        return this.w;
    }

    public final AbstractC24975zX0 m() {
        return this.a.b();
    }

    public final int n() {
        return this.a.q();
    }

    public final AbstractC10274bN4 o() {
        AbstractC10274bN4 bVar;
        AbstractC10274bN4 abstractC10274bN4 = this.k;
        V05 v05 = this.l;
        if (abstractC10274bN4 != null) {
            return abstractC10274bN4;
        }
        if (v05 != null) {
            AbstractC10274bN4.a aVar = new AbstractC10274bN4.a(v05);
            this.k = aVar;
            return aVar;
        }
        long jD = AbstractC4663Ga3.d(this.u);
        long j = this.h;
        long j2 = this.i;
        if (j2 != 9205357640488583168L) {
            jD = j2;
        }
        float fIntBitsToFloat = Float.intBitsToFloat((int) (j >> 32));
        float fIntBitsToFloat2 = Float.intBitsToFloat((int) (j & 4294967295L));
        float fIntBitsToFloat3 = Float.intBitsToFloat((int) (jD >> 32)) + fIntBitsToFloat;
        float fIntBitsToFloat4 = fIntBitsToFloat2 + Float.intBitsToFloat((int) (jD & 4294967295L));
        if (this.j > 0.0f) {
            bVar = new AbstractC10274bN4.c(J46.c(fIntBitsToFloat, fIntBitsToFloat2, fIntBitsToFloat3, fIntBitsToFloat4, AbstractC8567Wn1.b((Float.floatToRawIntBits(r0) << 32) | (4294967295L & Float.floatToRawIntBits(r0)))));
        } else {
            bVar = new AbstractC10274bN4.b(new CK5(fIntBitsToFloat, fIntBitsToFloat2, fIntBitsToFloat3, fIntBitsToFloat4));
        }
        this.k = bVar;
        return bVar;
    }

    public final long p() {
        return this.v;
    }

    public final float q() {
        return this.a.I();
    }

    public final float r() {
        return this.a.r();
    }

    public final float s() {
        return this.a.s();
    }

    public final float t() {
        return this.a.A();
    }

    public final float u() {
        return this.a.K();
    }

    public final float v() {
        return this.a.O();
    }

    public final long w() {
        return this.u;
    }

    public final long x() {
        return this.t;
    }

    public final float y() {
        return this.a.H();
    }

    public final float z() {
        return this.a.G();
    }

    /* renamed from: ir.nasim.tK2$c */
    static final class c extends AbstractC8614Ws3 implements UA2 {
        public static final c e = new c();

        c() {
            super(1);
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((InterfaceC17460n02) obj);
            return C19938rB7.a;
        }

        public final void a(InterfaceC17460n02 interfaceC17460n02) {
        }
    }
}
