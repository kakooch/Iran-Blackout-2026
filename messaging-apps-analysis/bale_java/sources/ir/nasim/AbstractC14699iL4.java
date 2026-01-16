package ir.nasim;

import java.util.List;
import kotlin.KotlinNothingValueException;

/* renamed from: ir.nasim.iL4, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC14699iL4 {
    private final int a;
    private final int b;

    /* renamed from: ir.nasim.iL4$A */
    public static final class A extends AbstractC14699iL4 {
        public static final A c = new A();

        /* JADX WARN: Illegal instructions before constructor call */
        private A() {
            int i = 0;
            super(i, i, 3, null);
        }

        @Override // ir.nasim.AbstractC14699iL4
        public void a(InterfaceC16479lL4 interfaceC16479lL4, InterfaceC15247jG interfaceC15247jG, C24216yE6 c24216yE6, XM5 xm5) {
            c24216yE6.U0();
        }
    }

    /* renamed from: ir.nasim.iL4$B */
    public static final class B extends AbstractC14699iL4 {
        public static final B c = new B();

        /* JADX WARN: Illegal instructions before constructor call */
        private B() {
            int i = 1;
            super(0, i, i, null);
        }

        @Override // ir.nasim.AbstractC14699iL4
        public void a(InterfaceC16479lL4 interfaceC16479lL4, InterfaceC15247jG interfaceC15247jG, C24216yE6 c24216yE6, XM5 xm5) {
            xm5.a((PJ5) interfaceC16479lL4.a(t.a(0)));
        }
    }

    /* renamed from: ir.nasim.iL4$C */
    public static final class C extends AbstractC14699iL4 {
        public static final C c = new C();

        private C() {
            super(1, 0, 2, null);
        }

        @Override // ir.nasim.AbstractC14699iL4
        public void a(InterfaceC16479lL4 interfaceC16479lL4, InterfaceC15247jG interfaceC15247jG, C24216yE6 c24216yE6, XM5 xm5) {
            int iE;
            int iD0;
            int i = interfaceC16479lL4.getInt(0);
            int iD02 = c24216yE6.d0();
            int iB0 = c24216yE6.b0();
            int iB1 = c24216yE6.b1(iB0);
            int iA1 = c24216yE6.a1(iB0);
            for (int iMax = Math.max(iB1, iA1 - i); iMax < iA1; iMax++) {
                Object obj = c24216yE6.c[c24216yE6.R(iMax)];
                if (obj instanceof ZM5) {
                    int i2 = iD02 - iMax;
                    ZM5 zm5 = (ZM5) obj;
                    C6669Om c6669OmA = zm5.a();
                    if (c6669OmA == null || !c6669OmA.b()) {
                        iE = -1;
                        iD0 = -1;
                    } else {
                        iE = c24216yE6.E(c6669OmA);
                        iD0 = c24216yE6.d0() - c24216yE6.Z0(iE);
                    }
                    xm5.g(zm5, i2, iE, iD0);
                } else if (obj instanceof PJ5) {
                    ((PJ5) obj).A();
                }
            }
            c24216yE6.i1(i);
        }
    }

    /* renamed from: ir.nasim.iL4$D */
    public static final class D extends AbstractC14699iL4 {
        public static final D c = new D();

        private D() {
            super(1, 2, null);
        }

        @Override // ir.nasim.AbstractC14699iL4
        public void a(InterfaceC16479lL4 interfaceC16479lL4, InterfaceC15247jG interfaceC15247jG, C24216yE6 c24216yE6, XM5 xm5) {
            int iE;
            int iD0;
            Object objA = interfaceC16479lL4.a(t.a(0));
            C6669Om c6669Om = (C6669Om) interfaceC16479lL4.a(t.a(1));
            int i = interfaceC16479lL4.getInt(0);
            if (objA instanceof ZM5) {
                xm5.d((ZM5) objA);
            }
            int iE2 = c24216yE6.E(c6669Om);
            Object objQ0 = c24216yE6.Q0(iE2, i, objA);
            if (!(objQ0 instanceof ZM5)) {
                if (objQ0 instanceof PJ5) {
                    ((PJ5) objQ0).A();
                    return;
                }
                return;
            }
            int iD02 = c24216yE6.d0() - c24216yE6.Y0(iE2, i);
            ZM5 zm5 = (ZM5) objQ0;
            C6669Om c6669OmA = zm5.a();
            if (c6669OmA == null || !c6669OmA.b()) {
                iE = -1;
                iD0 = -1;
            } else {
                iE = c24216yE6.E(c6669OmA);
                iD0 = c24216yE6.d0() - c24216yE6.Z0(iE);
            }
            xm5.g(zm5, iD02, iE, iD0);
        }
    }

    /* renamed from: ir.nasim.iL4$E */
    public static final class E extends AbstractC14699iL4 {
        public static final E c = new E();

        /* JADX WARN: Illegal instructions before constructor call */
        private E() {
            int i = 1;
            super(0, i, i, null);
        }

        @Override // ir.nasim.AbstractC14699iL4
        public void a(InterfaceC16479lL4 interfaceC16479lL4, InterfaceC15247jG interfaceC15247jG, C24216yE6 c24216yE6, XM5 xm5) {
            c24216yE6.m1(interfaceC16479lL4.a(t.a(0)));
        }
    }

    /* renamed from: ir.nasim.iL4$F */
    public static final class F extends AbstractC14699iL4 {
        public static final F c = new F();

        private F() {
            super(0, 2, 1, null);
        }

        @Override // ir.nasim.AbstractC14699iL4
        public void a(InterfaceC16479lL4 interfaceC16479lL4, InterfaceC15247jG interfaceC15247jG, C24216yE6 c24216yE6, XM5 xm5) {
            interfaceC15247jG.h((InterfaceC14603iB2) interfaceC16479lL4.a(t.a(1)), interfaceC16479lL4.a(t.a(0)));
        }
    }

    /* renamed from: ir.nasim.iL4$G */
    public static final class G extends AbstractC14699iL4 {
        public static final G c = new G();

        /* JADX WARN: Illegal instructions before constructor call */
        private G() {
            int i = 1;
            super(i, i, null);
        }

        @Override // ir.nasim.AbstractC14699iL4
        public void a(InterfaceC16479lL4 interfaceC16479lL4, InterfaceC15247jG interfaceC15247jG, C24216yE6 c24216yE6, XM5 xm5) {
            Object objA = interfaceC16479lL4.a(t.a(0));
            int i = interfaceC16479lL4.getInt(0);
            if (objA instanceof ZM5) {
                xm5.d((ZM5) objA);
            }
            Object objQ0 = c24216yE6.Q0(c24216yE6.a0(), i, objA);
            if (objQ0 instanceof ZM5) {
                xm5.g((ZM5) objQ0, c24216yE6.d0() - c24216yE6.Y0(c24216yE6.a0(), i), -1, -1);
            } else if (objQ0 instanceof PJ5) {
                ((PJ5) objQ0).A();
            }
        }
    }

    /* renamed from: ir.nasim.iL4$H */
    public static final class H extends AbstractC14699iL4 {
        public static final H c = new H();

        private H() {
            super(1, 0, 2, null);
        }

        @Override // ir.nasim.AbstractC14699iL4
        public void a(InterfaceC16479lL4 interfaceC16479lL4, InterfaceC15247jG interfaceC15247jG, C24216yE6 c24216yE6, XM5 xm5) {
            int i = interfaceC16479lL4.getInt(0);
            for (int i2 = 0; i2 < i; i2++) {
                interfaceC15247jG.k();
            }
        }
    }

    /* renamed from: ir.nasim.iL4$I */
    public static final class I extends AbstractC14699iL4 {
        public static final I c = new I();

        /* JADX WARN: Illegal instructions before constructor call */
        private I() {
            int i = 0;
            super(i, i, 3, null);
        }

        @Override // ir.nasim.AbstractC14699iL4
        public void a(InterfaceC16479lL4 interfaceC16479lL4, InterfaceC15247jG interfaceC15247jG, C24216yE6 c24216yE6, XM5 xm5) {
            interfaceC15247jG.i();
        }
    }

    /* renamed from: ir.nasim.iL4$a, reason: case insensitive filesystem */
    public static final class C14700a extends AbstractC14699iL4 {
        public static final C14700a c = new C14700a();

        private C14700a() {
            super(1, 0, 2, null);
        }

        @Override // ir.nasim.AbstractC14699iL4
        public void a(InterfaceC16479lL4 interfaceC16479lL4, InterfaceC15247jG interfaceC15247jG, C24216yE6 c24216yE6, XM5 xm5) {
            c24216yE6.C(interfaceC16479lL4.getInt(0));
        }
    }

    /* renamed from: ir.nasim.iL4$b, reason: case insensitive filesystem */
    public static final class C14701b extends AbstractC14699iL4 {
        public static final C14701b c = new C14701b();

        private C14701b() {
            super(0, 2, 1, null);
        }

        @Override // ir.nasim.AbstractC14699iL4
        public void a(InterfaceC16479lL4 interfaceC16479lL4, InterfaceC15247jG interfaceC15247jG, C24216yE6 c24216yE6, XM5 xm5) {
            C6669Om c6669Om = (C6669Om) interfaceC16479lL4.a(t.a(0));
            Object objA = interfaceC16479lL4.a(t.a(1));
            if (objA instanceof ZM5) {
                xm5.d((ZM5) objA);
            }
            c24216yE6.F(c6669Om, objA);
        }
    }

    /* renamed from: ir.nasim.iL4$c, reason: case insensitive filesystem */
    public static final class C14702c extends AbstractC14699iL4 {
        public static final C14702c c = new C14702c();

        private C14702c() {
            super(0, 2, 1, null);
        }

        @Override // ir.nasim.AbstractC14699iL4
        public void a(InterfaceC16479lL4 interfaceC16479lL4, InterfaceC15247jG interfaceC15247jG, C24216yE6 c24216yE6, XM5 xm5) {
            C3478Ba3 c3478Ba3 = (C3478Ba3) interfaceC16479lL4.a(t.a(1));
            int iA = c3478Ba3 != null ? c3478Ba3.a() : 0;
            OI0 oi0 = (OI0) interfaceC16479lL4.a(t.a(0));
            if (iA > 0) {
                interfaceC15247jG = new C9626aH4(interfaceC15247jG, iA);
            }
            oi0.b(interfaceC15247jG, c24216yE6, xm5);
        }
    }

    /* renamed from: ir.nasim.iL4$d, reason: case insensitive filesystem */
    public static final class C14703d extends AbstractC14699iL4 {
        public static final C14703d c = new C14703d();

        private C14703d() {
            super(0, 2, 1, null);
        }

        @Override // ir.nasim.AbstractC14699iL4
        public void a(InterfaceC16479lL4 interfaceC16479lL4, InterfaceC15247jG interfaceC15247jG, C24216yE6 c24216yE6, XM5 xm5) {
            int iA = ((C3478Ba3) interfaceC16479lL4.a(t.a(0))).a();
            List list = (List) interfaceC16479lL4.a(t.a(1));
            int size = list.size();
            for (int i = 0; i < size; i++) {
                Object obj = list.get(i);
                AbstractC13042fc3.g(interfaceC15247jG, "null cannot be cast to non-null type androidx.compose.runtime.Applier<kotlin.Any?>");
                int i2 = iA + i;
                interfaceC15247jG.f(i2, obj);
                interfaceC15247jG.d(i2, obj);
            }
        }
    }

    /* renamed from: ir.nasim.iL4$e, reason: case insensitive filesystem */
    public static final class C14704e extends AbstractC14699iL4 {
        public static final C14704e c = new C14704e();

        private C14704e() {
            super(0, 4, 1, null);
        }

        @Override // ir.nasim.AbstractC14699iL4
        public void a(InterfaceC16479lL4 interfaceC16479lL4, InterfaceC15247jG interfaceC15247jG, C24216yE6 c24216yE6, XM5 xm5) {
            C20869sk4 c20869sk4 = (C20869sk4) interfaceC16479lL4.a(t.a(2));
            AbstractC7050Qb1 abstractC7050Qb1 = (AbstractC7050Qb1) interfaceC16479lL4.a(t.a(1));
            abstractC7050Qb1.l(c20869sk4);
            AbstractC5138Ib1.t("Could not resolve state for movable content");
            throw new KotlinNothingValueException();
        }
    }

    /* renamed from: ir.nasim.iL4$f, reason: case insensitive filesystem */
    public static final class C14705f extends AbstractC14699iL4 {
        public static final C14705f c = new C14705f();

        /* JADX WARN: Illegal instructions before constructor call */
        private C14705f() {
            int i = 0;
            super(i, i, 3, null);
        }

        @Override // ir.nasim.AbstractC14699iL4
        public void a(InterfaceC16479lL4 interfaceC16479lL4, InterfaceC15247jG interfaceC15247jG, C24216yE6 c24216yE6, XM5 xm5) {
            AbstractC5138Ib1.u(c24216yE6, xm5);
        }
    }

    /* renamed from: ir.nasim.iL4$g, reason: case insensitive filesystem */
    public static final class C14706g extends AbstractC14699iL4 {
        public static final C14706g c = new C14706g();

        private C14706g() {
            super(0, 2, 1, null);
        }

        @Override // ir.nasim.AbstractC14699iL4
        public void a(InterfaceC16479lL4 interfaceC16479lL4, InterfaceC15247jG interfaceC15247jG, C24216yE6 c24216yE6, XM5 xm5) {
            C3478Ba3 c3478Ba3 = (C3478Ba3) interfaceC16479lL4.a(t.a(0));
            C6669Om c6669Om = (C6669Om) interfaceC16479lL4.a(t.a(1));
            AbstractC13042fc3.g(interfaceC15247jG, "null cannot be cast to non-null type androidx.compose.runtime.Applier<kotlin.Any?>");
            c3478Ba3.b(AbstractC19434qL4.d(c24216yE6, c6669Om, interfaceC15247jG));
        }
    }

    /* renamed from: ir.nasim.iL4$h, reason: case insensitive filesystem */
    public static final class C14707h extends AbstractC14699iL4 {
        public static final C14707h c = new C14707h();

        /* JADX WARN: Illegal instructions before constructor call */
        private C14707h() {
            int i = 1;
            super(0, i, i, null);
        }

        @Override // ir.nasim.AbstractC14699iL4
        public void a(InterfaceC16479lL4 interfaceC16479lL4, InterfaceC15247jG interfaceC15247jG, C24216yE6 c24216yE6, XM5 xm5) {
            AbstractC13042fc3.g(interfaceC15247jG, "null cannot be cast to non-null type androidx.compose.runtime.Applier<kotlin.Any?>");
            for (Object obj : (Object[]) interfaceC16479lL4.a(t.a(0))) {
                interfaceC15247jG.g(obj);
            }
        }
    }

    /* renamed from: ir.nasim.iL4$i, reason: case insensitive filesystem */
    public static final class C14708i extends AbstractC14699iL4 {
        public static final C14708i c = new C14708i();

        private C14708i() {
            super(0, 2, 1, null);
        }

        @Override // ir.nasim.AbstractC14699iL4
        public void a(InterfaceC16479lL4 interfaceC16479lL4, InterfaceC15247jG interfaceC15247jG, C24216yE6 c24216yE6, XM5 xm5) {
            ((UA2) interfaceC16479lL4.a(t.a(0))).invoke((InterfaceC6806Pb1) interfaceC16479lL4.a(t.a(1)));
        }
    }

    /* renamed from: ir.nasim.iL4$j */
    public static final class j extends AbstractC14699iL4 {
        public static final j c = new j();

        /* JADX WARN: Illegal instructions before constructor call */
        private j() {
            int i = 0;
            super(i, i, 3, null);
        }

        @Override // ir.nasim.AbstractC14699iL4
        public void a(InterfaceC16479lL4 interfaceC16479lL4, InterfaceC15247jG interfaceC15247jG, C24216yE6 c24216yE6, XM5 xm5) {
            c24216yE6.T();
        }
    }

    /* renamed from: ir.nasim.iL4$k */
    public static final class k extends AbstractC14699iL4 {
        public static final k c = new k();

        /* JADX WARN: Illegal instructions before constructor call */
        private k() {
            int i = 0;
            super(i, i, 3, null);
        }

        @Override // ir.nasim.AbstractC14699iL4
        public void a(InterfaceC16479lL4 interfaceC16479lL4, InterfaceC15247jG interfaceC15247jG, C24216yE6 c24216yE6, XM5 xm5) {
            AbstractC13042fc3.g(interfaceC15247jG, "null cannot be cast to non-null type androidx.compose.runtime.Applier<kotlin.Any?>");
            AbstractC19434qL4.e(c24216yE6, interfaceC15247jG, 0);
            c24216yE6.T();
        }
    }

    /* renamed from: ir.nasim.iL4$l */
    public static final class l extends AbstractC14699iL4 {
        public static final l c = new l();

        /* JADX WARN: Illegal instructions before constructor call */
        private l() {
            int i = 1;
            super(0, i, i, null);
        }

        @Override // ir.nasim.AbstractC14699iL4
        public void a(InterfaceC16479lL4 interfaceC16479lL4, InterfaceC15247jG interfaceC15247jG, C24216yE6 c24216yE6, XM5 xm5) {
            xm5.b((PJ5) interfaceC16479lL4.a(t.a(0)));
        }
    }

    /* renamed from: ir.nasim.iL4$m */
    public static final class m extends AbstractC14699iL4 {
        public static final m c = new m();

        /* JADX WARN: Illegal instructions before constructor call */
        private m() {
            int i = 1;
            super(0, i, i, null);
        }

        @Override // ir.nasim.AbstractC14699iL4
        public void a(InterfaceC16479lL4 interfaceC16479lL4, InterfaceC15247jG interfaceC15247jG, C24216yE6 c24216yE6, XM5 xm5) {
            c24216yE6.W((C6669Om) interfaceC16479lL4.a(t.a(0)));
        }
    }

    /* renamed from: ir.nasim.iL4$n */
    public static final class n extends AbstractC14699iL4 {
        public static final n c = new n();

        /* JADX WARN: Illegal instructions before constructor call */
        private n() {
            int i = 0;
            super(i, i, 3, null);
        }

        @Override // ir.nasim.AbstractC14699iL4
        public void a(InterfaceC16479lL4 interfaceC16479lL4, InterfaceC15247jG interfaceC15247jG, C24216yE6 c24216yE6, XM5 xm5) {
            c24216yE6.V(0);
        }
    }

    /* renamed from: ir.nasim.iL4$o */
    public static final class o extends AbstractC14699iL4 {
        public static final o c = new o();

        private o() {
            super(1, 2, null);
        }

        @Override // ir.nasim.AbstractC14699iL4
        public void a(InterfaceC16479lL4 interfaceC16479lL4, InterfaceC15247jG interfaceC15247jG, C24216yE6 c24216yE6, XM5 xm5) {
            Object objInvoke = ((SA2) interfaceC16479lL4.a(t.a(0))).invoke();
            C6669Om c6669Om = (C6669Om) interfaceC16479lL4.a(t.a(1));
            int i = interfaceC16479lL4.getInt(0);
            AbstractC13042fc3.g(interfaceC15247jG, "null cannot be cast to non-null type androidx.compose.runtime.Applier<kotlin.Any?>");
            c24216yE6.q1(c6669Om, objInvoke);
            interfaceC15247jG.d(i, objInvoke);
            interfaceC15247jG.g(objInvoke);
        }
    }

    /* renamed from: ir.nasim.iL4$p */
    public static final class p extends AbstractC14699iL4 {
        public static final p c = new p();

        private p() {
            super(0, 2, 1, null);
        }

        @Override // ir.nasim.AbstractC14699iL4
        public void a(InterfaceC16479lL4 interfaceC16479lL4, InterfaceC15247jG interfaceC15247jG, C24216yE6 c24216yE6, XM5 xm5) {
            C21850uE6 c21850uE6 = (C21850uE6) interfaceC16479lL4.a(t.a(1));
            C6669Om c6669Om = (C6669Om) interfaceC16479lL4.a(t.a(0));
            c24216yE6.H();
            c24216yE6.u0(c21850uE6, c6669Om.d(c21850uE6), false);
            c24216yE6.U();
        }
    }

    /* renamed from: ir.nasim.iL4$q */
    public static final class q extends AbstractC14699iL4 {
        public static final q c = new q();

        private q() {
            super(0, 3, 1, null);
        }

        @Override // ir.nasim.AbstractC14699iL4
        public void a(InterfaceC16479lL4 interfaceC16479lL4, InterfaceC15247jG interfaceC15247jG, C24216yE6 c24216yE6, XM5 xm5) {
            C21850uE6 c21850uE6 = (C21850uE6) interfaceC16479lL4.a(t.a(1));
            C6669Om c6669Om = (C6669Om) interfaceC16479lL4.a(t.a(0));
            C21604tp2 c21604tp2 = (C21604tp2) interfaceC16479lL4.a(t.a(2));
            C24216yE6 c24216yE6W = c21850uE6.W();
            try {
                c21604tp2.d(interfaceC15247jG, c24216yE6W, xm5);
                C19938rB7 c19938rB7 = C19938rB7.a;
                c24216yE6W.L(true);
                c24216yE6.H();
                c24216yE6.u0(c21850uE6, c6669Om.d(c21850uE6), false);
                c24216yE6.U();
            } catch (Throwable th) {
                c24216yE6W.L(false);
                throw th;
            }
        }
    }

    /* renamed from: ir.nasim.iL4$r */
    public static final class r extends AbstractC14699iL4 {
        public static final r c = new r();

        private r() {
            super(1, 0, 2, null);
        }

        @Override // ir.nasim.AbstractC14699iL4
        public void a(InterfaceC16479lL4 interfaceC16479lL4, InterfaceC15247jG interfaceC15247jG, C24216yE6 c24216yE6, XM5 xm5) {
            c24216yE6.v0(interfaceC16479lL4.getInt(0));
        }
    }

    /* renamed from: ir.nasim.iL4$s */
    public static final class s extends AbstractC14699iL4 {
        public static final s c = new s();

        private s() {
            super(3, 0, 2, null);
        }

        @Override // ir.nasim.AbstractC14699iL4
        public void a(InterfaceC16479lL4 interfaceC16479lL4, InterfaceC15247jG interfaceC15247jG, C24216yE6 c24216yE6, XM5 xm5) {
            interfaceC15247jG.c(interfaceC16479lL4.getInt(0), interfaceC16479lL4.getInt(1), interfaceC16479lL4.getInt(2));
        }
    }

    /* renamed from: ir.nasim.iL4$u */
    public static final class u extends AbstractC14699iL4 {
        public static final u c = new u();

        /* JADX WARN: Illegal instructions before constructor call */
        private u() {
            int i = 1;
            super(i, i, null);
        }

        @Override // ir.nasim.AbstractC14699iL4
        public void a(InterfaceC16479lL4 interfaceC16479lL4, InterfaceC15247jG interfaceC15247jG, C24216yE6 c24216yE6, XM5 xm5) {
            C6669Om c6669Om = (C6669Om) interfaceC16479lL4.a(t.a(0));
            int i = interfaceC16479lL4.getInt(0);
            interfaceC15247jG.k();
            AbstractC13042fc3.g(interfaceC15247jG, "null cannot be cast to non-null type androidx.compose.runtime.Applier<kotlin.Any?>");
            interfaceC15247jG.f(i, c24216yE6.A0(c6669Om));
        }
    }

    /* renamed from: ir.nasim.iL4$v */
    public static final class v extends AbstractC14699iL4 {
        public static final v c = new v();

        /* JADX WARN: Illegal instructions before constructor call */
        private v() {
            int i = 1;
            super(0, i, i, null);
        }

        @Override // ir.nasim.AbstractC14699iL4
        public void a(InterfaceC16479lL4 interfaceC16479lL4, InterfaceC15247jG interfaceC15247jG, C24216yE6 c24216yE6, XM5 xm5) {
            xm5.d((ZM5) interfaceC16479lL4.a(t.a(0)));
        }
    }

    /* renamed from: ir.nasim.iL4$w */
    public static final class w extends AbstractC14699iL4 {
        public static final w c = new w();

        /* JADX WARN: Illegal instructions before constructor call */
        private w() {
            int i = 0;
            super(i, i, 3, null);
        }

        @Override // ir.nasim.AbstractC14699iL4
        public void a(InterfaceC16479lL4 interfaceC16479lL4, InterfaceC15247jG interfaceC15247jG, C24216yE6 c24216yE6, XM5 xm5) {
            AbstractC5138Ib1.L(c24216yE6, xm5);
        }
    }

    /* renamed from: ir.nasim.iL4$x */
    public static final class x extends AbstractC14699iL4 {
        public static final x c = new x();

        /* JADX WARN: Illegal instructions before constructor call */
        private x() {
            int i = 2;
            super(i, 0, i, null);
        }

        @Override // ir.nasim.AbstractC14699iL4
        public void a(InterfaceC16479lL4 interfaceC16479lL4, InterfaceC15247jG interfaceC15247jG, C24216yE6 c24216yE6, XM5 xm5) {
            interfaceC15247jG.a(interfaceC16479lL4.getInt(0), interfaceC16479lL4.getInt(1));
        }
    }

    /* renamed from: ir.nasim.iL4$y */
    public static final class y extends AbstractC14699iL4 {
        public static final y c = new y();

        /* JADX WARN: Illegal instructions before constructor call */
        private y() {
            int i = 0;
            super(i, i, 3, null);
        }

        @Override // ir.nasim.AbstractC14699iL4
        public void a(InterfaceC16479lL4 interfaceC16479lL4, InterfaceC15247jG interfaceC15247jG, C24216yE6 c24216yE6, XM5 xm5) {
            c24216yE6.N0();
        }
    }

    /* renamed from: ir.nasim.iL4$z */
    public static final class z extends AbstractC14699iL4 {
        public static final z c = new z();

        /* JADX WARN: Illegal instructions before constructor call */
        private z() {
            int i = 1;
            super(0, i, i, null);
        }

        @Override // ir.nasim.AbstractC14699iL4
        public void a(InterfaceC16479lL4 interfaceC16479lL4, InterfaceC15247jG interfaceC15247jG, C24216yE6 c24216yE6, XM5 xm5) {
            xm5.c((SA2) interfaceC16479lL4.a(t.a(0)));
        }
    }

    public /* synthetic */ AbstractC14699iL4(int i, int i2, ED1 ed1) {
        this(i, i2);
    }

    public abstract void a(InterfaceC16479lL4 interfaceC16479lL4, InterfaceC15247jG interfaceC15247jG, C24216yE6 c24216yE6, XM5 xm5);

    public final int b() {
        return this.a;
    }

    public final String c() {
        String strP = AbstractC10882cM5.b(getClass()).p();
        return strP == null ? "" : strP;
    }

    public final int d() {
        return this.b;
    }

    public String toString() {
        return c();
    }

    private AbstractC14699iL4(int i, int i2) {
        this.a = i;
        this.b = i2;
    }

    public /* synthetic */ AbstractC14699iL4(int i, int i2, int i3, ED1 ed1) {
        this((i3 & 1) != 0 ? 0 : i, (i3 & 2) != 0 ? 0 : i2, null);
    }

    /* renamed from: ir.nasim.iL4$t */
    public static final class t {
        public static int a(int i) {
            return i;
        }
    }
}
