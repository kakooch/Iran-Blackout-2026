package ir.nasim;

import ir.nasim.C3577Bl3;
import ir.nasim.KS4;
import ir.nasim.VI1;

/* renamed from: ir.nasim.x76, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C23560x76 {
    public static final a c = new a(null);
    private final TI1 a;
    private final LS4 b;

    /* renamed from: ir.nasim.x76$a */
    public static final class a {
        private a() {
        }

        public final C23560x76 a(ClassLoader classLoader) {
            AbstractC13042fc3.i(classLoader, "classLoader");
            C14671iI3 c14671iI3 = new C14671iI3("RuntimeModuleData");
            C3577Bl3 c3577Bl3 = new C3577Bl3(c14671iI3, C3577Bl3.a.FROM_DEPENDENCIES);
            C6432No4 c6432No4S = C6432No4.s("<runtime module for " + classLoader + '>');
            AbstractC13042fc3.h(c6432No4S, "special(\"<runtime module for $classLoader>\")");
            C8773Xg4 c8773Xg4 = new C8773Xg4(c6432No4S, c14671iI3, c3577Bl3, null, null, null, 56, null);
            c3577Bl3.L0(c8773Xg4);
            c3577Bl3.Q0(c8773Xg4, true);
            XL5 xl5 = new XL5(classLoader);
            C12867fJ1 c12867fJ1 = new C12867fJ1();
            C22431vD6 c22431vD6 = new C22431vD6();
            C21830uC4 c21830uC4 = new C21830uC4(c14671iI3, c8773Xg4);
            C8641Wv3 c8641Wv3B = AbstractC24150y76.b(classLoader, c8773Xg4, c14671iI3, c21830uC4, xl5, c12867fJ1, c22431vD6, (128 & 128) != 0 ? KS4.a.a : null);
            UI1 ui1A = AbstractC24150y76.a(c8773Xg4, c14671iI3, c21830uC4, c8641Wv3B, xl5, c12867fJ1);
            c12867fJ1.o(ui1A);
            InterfaceC3550Bi3 interfaceC3550Bi3 = InterfaceC3550Bi3.a;
            AbstractC13042fc3.h(interfaceC3550Bi3, "EMPTY");
            C11881di3 c11881di3 = new C11881di3(c8641Wv3B, interfaceC3550Bi3);
            c22431vD6.c(c11881di3);
            ClassLoader classLoader2 = C19938rB7.class.getClassLoader();
            AbstractC13042fc3.h(classLoader2, "stdlibClassLoader");
            C4045Dl3 c4045Dl3 = new C4045Dl3(c14671iI3, new XL5(classLoader2), c8773Xg4, c21830uC4, c3577Bl3.P0(), c3577Bl3.P0(), VI1.a.a, InterfaceC14434hu4.b.a(), new C11009ca6(c14671iI3, AbstractC10360bX0.m()));
            c8773Xg4.W0(c8773Xg4);
            c8773Xg4.Q0(new C6312Nb1(AbstractC10360bX0.p(c11881di3.a(), c4045Dl3)));
            return new C23560x76(ui1A.a(), new LS4(c12867fJ1, xl5), null);
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public /* synthetic */ C23560x76(TI1 ti1, LS4 ls4, ED1 ed1) {
        this(ti1, ls4);
    }

    public final TI1 a() {
        return this.a;
    }

    public final InterfaceC8507Wg4 b() {
        return this.a.p();
    }

    public final LS4 c() {
        return this.b;
    }

    private C23560x76(TI1 ti1, LS4 ls4) {
        this.a = ti1;
        this.b = ls4;
    }
}
