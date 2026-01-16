package ir.nasim;

import androidx.compose.ui.e;
import kotlin.KotlinNothingValueException;

/* renamed from: ir.nasim.Cu3, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C3892Cu3 implements InterfaceC17460n02, InterfaceC23919xk1 {
    private final C20576sF0 a;
    private InterfaceC15687k02 b;

    /* renamed from: ir.nasim.Cu3$a */
    static final class a extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ InterfaceC15687k02 f;
        final /* synthetic */ UA2 g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(InterfaceC15687k02 interfaceC15687k02, UA2 ua2) {
            super(1);
            this.f = interfaceC15687k02;
            this.g = ua2;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r2v0, types: [ir.nasim.k02] */
        /* JADX WARN: Type inference failed for: r2v1 */
        /* JADX WARN: Type inference failed for: r2v2, types: [ir.nasim.k02] */
        /* JADX WARN: Type inference failed for: r2v3 */
        /* JADX WARN: Type inference failed for: r2v4, types: [ir.nasim.YZ1] */
        /* JADX WARN: Type inference failed for: r2v5 */
        public final void a(InterfaceC17460n02 interfaceC17460n02) throws Throwable {
            C3892Cu3 c3892Cu3;
            WH1 density;
            EnumC12613eu3 layoutDirection;
            UE0 ue0E;
            long jD;
            C21226tK2 c21226tK2I;
            UA2 ua2;
            WH1 density2;
            EnumC12613eu3 layoutDirection2;
            UE0 ue0E2;
            long jD2;
            C21226tK2 c21226tK2I2;
            ?? Z1 = C3892Cu3.this.b;
            C3892Cu3.this.b = this.f;
            try {
                c3892Cu3 = C3892Cu3.this;
                density = interfaceC17460n02.z1().getDensity();
                layoutDirection = interfaceC17460n02.z1().getLayoutDirection();
                ue0E = interfaceC17460n02.z1().e();
                jD = interfaceC17460n02.z1().d();
                c21226tK2I = interfaceC17460n02.z1().i();
                ua2 = this.g;
                density2 = c3892Cu3.z1().getDensity();
                layoutDirection2 = c3892Cu3.z1().getLayoutDirection();
                ue0E2 = c3892Cu3.z1().e();
                jD2 = c3892Cu3.z1().d();
                c21226tK2I2 = c3892Cu3.z1().i();
            } catch (Throwable th) {
                th = th;
                C3892Cu3.this.b = Z1;
                throw th;
            }
            try {
                Z1 = c3892Cu3.z1();
                Z1.f(density);
                Z1.c(layoutDirection);
                Z1.a(ue0E);
                Z1.g(jD);
                Z1.h(c21226tK2I);
                ue0E.n();
                try {
                    ua2.invoke(c3892Cu3);
                    ue0E.i();
                    YZ1 yz1Z1 = c3892Cu3.z1();
                    yz1Z1.f(density2);
                    yz1Z1.c(layoutDirection2);
                    yz1Z1.a(ue0E2);
                    yz1Z1.g(jD2);
                    yz1Z1.h(c21226tK2I2);
                    C3892Cu3.this.b = Z1;
                } finally {
                }
            } catch (Throwable th2) {
                th = th2;
                Z1 = Z1;
                C3892Cu3.this.b = Z1;
                throw th;
            }
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) throws Throwable {
            a((InterfaceC17460n02) obj);
            return C19938rB7.a;
        }
    }

    public C3892Cu3(C20576sF0 c20576sF0) {
        this.a = c20576sF0;
    }

    @Override // ir.nasim.WH1
    public int A1(long j) {
        return this.a.A1(j);
    }

    @Override // ir.nasim.WH1
    public int B0(float f) {
        return this.a.B0(f);
    }

    @Override // ir.nasim.WH1
    public float D(int i) {
        return this.a.D(i);
    }

    @Override // ir.nasim.InterfaceC17460n02
    public long E1() {
        return this.a.E1();
    }

    @Override // ir.nasim.WH1
    public float I0(long j) {
        return this.a.I0(j);
    }

    @Override // ir.nasim.WH1
    public long I1(long j) {
        return this.a.I1(j);
    }

    @Override // ir.nasim.InterfaceC17460n02
    public void K0(AbstractC12520el0 abstractC12520el0, long j, long j2, float f, int i, InterfaceC13909h15 interfaceC13909h15, float f2, AbstractC24975zX0 abstractC24975zX0, int i2) {
        this.a.K0(abstractC12520el0, j, j2, f, i, interfaceC13909h15, f2, abstractC24975zX0, i2);
    }

    @Override // ir.nasim.InterfaceC17460n02
    public void M0(Y03 y03, long j, float f, AbstractC18051o02 abstractC18051o02, AbstractC24975zX0 abstractC24975zX0, int i) {
        this.a.M0(y03, j, f, abstractC18051o02, abstractC24975zX0, i);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [androidx.compose.ui.e$c] */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v12 */
    /* JADX WARN: Type inference failed for: r2v13 */
    /* JADX WARN: Type inference failed for: r2v14 */
    /* JADX WARN: Type inference failed for: r2v15 */
    /* JADX WARN: Type inference failed for: r2v5, types: [androidx.compose.ui.e$c] */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Type inference failed for: r2v8, types: [androidx.compose.ui.e$c] */
    /* JADX WARN: Type inference failed for: r2v9, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v10 */
    /* JADX WARN: Type inference failed for: r4v11 */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Type inference failed for: r4v3, types: [ir.nasim.en4] */
    /* JADX WARN: Type inference failed for: r4v4 */
    /* JADX WARN: Type inference failed for: r4v5 */
    /* JADX WARN: Type inference failed for: r4v6, types: [ir.nasim.en4] */
    /* JADX WARN: Type inference failed for: r4v8 */
    /* JADX WARN: Type inference failed for: r4v9 */
    @Override // ir.nasim.InterfaceC23919xk1
    public void N1() {
        UE0 ue0E = z1().e();
        InterfaceC15687k02 interfaceC15687k02 = this.b;
        if (interfaceC15687k02 == null) {
            M73.c("Attempting to drawContent for a `null` node. This usually means that a call to ContentDrawScope#drawContent() has been captured inside a lambda, and is being invoked outside of the draw pass. Capturing the scope this way is unsupported - if you are trying to record drawContent with graphicsLayer.record(), make sure you are using the GraphicsLayer#record function within DrawScope, instead of the member function on GraphicsLayer.");
            throw new KotlinNothingValueException();
        }
        RG1 rg1B = AbstractC4126Du3.b(interfaceC15687k02);
        if (rg1B == 0) {
            XA4 xa4J = KG1.j(interfaceC15687k02, AbstractC9572aB4.a(4));
            if (xa4J.J2() == interfaceC15687k02.h()) {
                xa4J = xa4J.K2();
                AbstractC13042fc3.f(xa4J);
            }
            xa4J.k3(ue0E, z1().i());
            return;
        }
        int iA = AbstractC9572aB4.a(4);
        ?? c12544en4 = 0;
        while (rg1B != 0) {
            if (rg1B instanceof InterfaceC15687k02) {
                t((InterfaceC15687k02) rg1B, ue0E, z1().i());
            } else if ((rg1B.W1() & iA) != 0 && (rg1B instanceof RG1)) {
                e.c cVarW2 = rg1B.w2();
                int i = 0;
                rg1B = rg1B;
                c12544en4 = c12544en4;
                while (cVarW2 != null) {
                    if ((cVarW2.W1() & iA) != 0) {
                        i++;
                        c12544en4 = c12544en4;
                        if (i == 1) {
                            rg1B = cVarW2;
                        } else {
                            if (c12544en4 == 0) {
                                c12544en4 = new C12544en4(new e.c[16], 0);
                            }
                            if (rg1B != 0) {
                                c12544en4.d(rg1B);
                                rg1B = 0;
                            }
                            c12544en4.d(cVarW2);
                        }
                    }
                    cVarW2 = cVarW2.S1();
                    rg1B = rg1B;
                    c12544en4 = c12544en4;
                }
                if (i == 1) {
                }
            }
            rg1B = KG1.h(c12544en4);
        }
    }

    @Override // ir.nasim.InterfaceC17460n02
    public void O1(C21226tK2 c21226tK2, long j, UA2 ua2) {
        c21226tK2.F(this, getLayoutDirection(), j, new a(this.b, ua2));
    }

    @Override // ir.nasim.InterfaceC17460n02
    public void Q0(V05 v05, long j, float f, AbstractC18051o02 abstractC18051o02, AbstractC24975zX0 abstractC24975zX0, int i) {
        this.a.Q0(v05, j, f, abstractC18051o02, abstractC24975zX0, i);
    }

    @Override // ir.nasim.InterfaceC17460n02
    public void R(AbstractC12520el0 abstractC12520el0, long j, long j2, float f, AbstractC18051o02 abstractC18051o02, AbstractC24975zX0 abstractC24975zX0, int i) {
        this.a.R(abstractC12520el0, j, j2, f, abstractC18051o02, abstractC24975zX0, i);
    }

    @Override // ir.nasim.InterfaceC23430wu2
    public long T(float f) {
        return this.a.T(f);
    }

    @Override // ir.nasim.WH1
    public long U(long j) {
        return this.a.U(j);
    }

    @Override // ir.nasim.InterfaceC17460n02
    public void X(V05 v05, AbstractC12520el0 abstractC12520el0, float f, AbstractC18051o02 abstractC18051o02, AbstractC24975zX0 abstractC24975zX0, int i) {
        this.a.X(v05, abstractC12520el0, f, abstractC18051o02, abstractC24975zX0, i);
    }

    @Override // ir.nasim.InterfaceC23430wu2
    public float Y(long j) {
        return this.a.Y(j);
    }

    @Override // ir.nasim.InterfaceC17460n02
    public void a1(AbstractC12520el0 abstractC12520el0, float f, long j, float f2, AbstractC18051o02 abstractC18051o02, AbstractC24975zX0 abstractC24975zX0, int i) {
        this.a.a1(abstractC12520el0, f, j, f2, abstractC18051o02, abstractC24975zX0, i);
    }

    @Override // ir.nasim.InterfaceC17460n02
    public void c0(long j, long j2, long j3, float f, int i, InterfaceC13909h15 interfaceC13909h15, float f2, AbstractC24975zX0 abstractC24975zX0, int i2) {
        this.a.c0(j, j2, j3, f, i, interfaceC13909h15, f2, abstractC24975zX0, i2);
    }

    @Override // ir.nasim.InterfaceC17460n02
    public long d() {
        return this.a.d();
    }

    @Override // ir.nasim.WH1
    public float getDensity() {
        return this.a.getDensity();
    }

    @Override // ir.nasim.InterfaceC17460n02
    public EnumC12613eu3 getLayoutDirection() {
        return this.a.getLayoutDirection();
    }

    @Override // ir.nasim.WH1
    public long j0(float f) {
        return this.a.j0(f);
    }

    @Override // ir.nasim.InterfaceC17460n02
    public void m1(long j, long j2, long j3, float f, AbstractC18051o02 abstractC18051o02, AbstractC24975zX0 abstractC24975zX0, int i) {
        this.a.m1(j, j2, j3, f, abstractC18051o02, abstractC24975zX0, i);
    }

    @Override // ir.nasim.InterfaceC17460n02
    public void n1(long j, float f, long j2, float f2, AbstractC18051o02 abstractC18051o02, AbstractC24975zX0 abstractC24975zX0, int i) {
        this.a.n1(j, f, j2, f2, abstractC18051o02, abstractC24975zX0, i);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [androidx.compose.ui.e$c] */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v3, types: [androidx.compose.ui.e$c] */
    /* JADX WARN: Type inference failed for: r2v4, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Type inference failed for: r2v8 */
    /* JADX WARN: Type inference failed for: r2v9 */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v10 */
    /* JADX WARN: Type inference failed for: r3v11 */
    /* JADX WARN: Type inference failed for: r3v2 */
    /* JADX WARN: Type inference failed for: r3v3, types: [ir.nasim.en4] */
    /* JADX WARN: Type inference failed for: r3v4 */
    /* JADX WARN: Type inference failed for: r3v5 */
    /* JADX WARN: Type inference failed for: r3v6, types: [ir.nasim.en4] */
    /* JADX WARN: Type inference failed for: r3v8 */
    /* JADX WARN: Type inference failed for: r3v9 */
    public final void o(UE0 ue0, long j, XA4 xa4, e.c cVar, C21226tK2 c21226tK2) {
        int iA = AbstractC9572aB4.a(4);
        RG1 rg1H = cVar;
        ?? c12544en4 = 0;
        while (rg1H != 0) {
            if (rg1H instanceof InterfaceC15687k02) {
                p(ue0, j, xa4, rg1H, c21226tK2);
            } else if ((rg1H.W1() & iA) != 0 && (rg1H instanceof RG1)) {
                e.c cVarW2 = rg1H.w2();
                int i = 0;
                rg1H = rg1H;
                c12544en4 = c12544en4;
                while (cVarW2 != null) {
                    if ((cVarW2.W1() & iA) != 0) {
                        i++;
                        c12544en4 = c12544en4;
                        if (i == 1) {
                            rg1H = cVarW2;
                        } else {
                            if (c12544en4 == 0) {
                                c12544en4 = new C12544en4(new e.c[16], 0);
                            }
                            if (rg1H != 0) {
                                c12544en4.d(rg1H);
                                rg1H = 0;
                            }
                            c12544en4.d(cVarW2);
                        }
                    }
                    cVarW2 = cVarW2.S1();
                    rg1H = rg1H;
                    c12544en4 = c12544en4;
                }
                if (i == 1) {
                }
            }
            rg1H = KG1.h(c12544en4);
        }
    }

    @Override // ir.nasim.WH1
    public float o1(float f) {
        return this.a.o1(f);
    }

    public final void p(UE0 ue0, long j, XA4 xa4, InterfaceC15687k02 interfaceC15687k02, C21226tK2 c21226tK2) {
        InterfaceC15687k02 interfaceC15687k022 = this.b;
        this.b = interfaceC15687k02;
        C20576sF0 c20576sF0 = this.a;
        EnumC12613eu3 layoutDirection = xa4.getLayoutDirection();
        WH1 density = c20576sF0.z1().getDensity();
        EnumC12613eu3 layoutDirection2 = c20576sF0.z1().getLayoutDirection();
        UE0 ue0E = c20576sF0.z1().e();
        long jD = c20576sF0.z1().d();
        C21226tK2 c21226tK2I = c20576sF0.z1().i();
        YZ1 yz1Z1 = c20576sF0.z1();
        yz1Z1.f(xa4);
        yz1Z1.c(layoutDirection);
        yz1Z1.a(ue0);
        yz1Z1.g(j);
        yz1Z1.h(c21226tK2);
        ue0.n();
        try {
            interfaceC15687k02.o(this);
            ue0.i();
            YZ1 yz1Z12 = c20576sF0.z1();
            yz1Z12.f(density);
            yz1Z12.c(layoutDirection2);
            yz1Z12.a(ue0E);
            yz1Z12.g(jD);
            yz1Z12.h(c21226tK2I);
            this.b = interfaceC15687k022;
        } catch (Throwable th) {
            ue0.i();
            YZ1 yz1Z13 = c20576sF0.z1();
            yz1Z13.f(density);
            yz1Z13.c(layoutDirection2);
            yz1Z13.a(ue0E);
            yz1Z13.g(jD);
            yz1Z13.h(c21226tK2I);
            throw th;
        }
    }

    @Override // ir.nasim.InterfaceC17460n02
    public void r0(AbstractC12520el0 abstractC12520el0, long j, long j2, long j3, float f, AbstractC18051o02 abstractC18051o02, AbstractC24975zX0 abstractC24975zX0, int i) {
        this.a.r0(abstractC12520el0, j, j2, j3, f, abstractC18051o02, abstractC24975zX0, i);
    }

    public final void t(InterfaceC15687k02 interfaceC15687k02, UE0 ue0, C21226tK2 c21226tK2) {
        XA4 xa4J = KG1.j(interfaceC15687k02, AbstractC9572aB4.a(4));
        xa4J.G1().l0().p(ue0, AbstractC4663Ga3.d(xa4J.a()), xa4J, interfaceC15687k02, c21226tK2);
    }

    @Override // ir.nasim.InterfaceC23430wu2
    public float t1() {
        return this.a.t1();
    }

    @Override // ir.nasim.InterfaceC17460n02
    public void v1(long j, long j2, long j3, long j4, AbstractC18051o02 abstractC18051o02, float f, AbstractC24975zX0 abstractC24975zX0, int i) {
        this.a.v1(j, j2, j3, j4, abstractC18051o02, f, abstractC24975zX0, i);
    }

    @Override // ir.nasim.WH1
    public float w1(float f) {
        return this.a.w1(f);
    }

    @Override // ir.nasim.InterfaceC17460n02
    public void x1(long j, float f, float f2, boolean z, long j2, long j3, float f3, AbstractC18051o02 abstractC18051o02, AbstractC24975zX0 abstractC24975zX0, int i) {
        this.a.x1(j, f, f2, z, j2, j3, f3, abstractC18051o02, abstractC24975zX0, i);
    }

    @Override // ir.nasim.InterfaceC17460n02
    public void y1(Y03 y03, long j, long j2, long j3, long j4, float f, AbstractC18051o02 abstractC18051o02, AbstractC24975zX0 abstractC24975zX0, int i, int i2) {
        this.a.y1(y03, j, j2, j3, j4, f, abstractC18051o02, abstractC24975zX0, i, i2);
    }

    @Override // ir.nasim.InterfaceC17460n02
    public YZ1 z1() {
        return this.a.z1();
    }

    public /* synthetic */ C3892Cu3(C20576sF0 c20576sF0, int i, ED1 ed1) {
        this((i & 1) != 0 ? new C20576sF0() : c20576sF0);
    }
}
