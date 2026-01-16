package ir.nasim;

import ir.nasim.InterfaceC15194jA0;
import java.util.List;

/* loaded from: classes8.dex */
public final class RV0 extends MI2 {
    public static final a e = new a(null);
    private static final C6432No4 f;

    public static final class a {
        private a() {
        }

        public final C6432No4 a() {
            return RV0.f;
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    static {
        C6432No4 c6432No4P = C6432No4.p("clone");
        AbstractC13042fc3.h(c6432No4P, "identifier(\"clone\")");
        f = c6432No4P;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RV0(ON6 on6, InterfaceC21331tU0 interfaceC21331tU0) {
        super(on6, interfaceC21331tU0);
        AbstractC13042fc3.i(on6, "storageManager");
        AbstractC13042fc3.i(interfaceC21331tU0, "containingClass");
    }

    @Override // ir.nasim.MI2
    protected List i() {
        KC6 kc6K1 = KC6.k1(l(), InterfaceC4356Eu.W.b(), e.a(), InterfaceC15194jA0.a.DECLARATION, JH6.a);
        kc6K1.Q0(null, l().H0(), AbstractC10360bX0.m(), AbstractC10360bX0.m(), PI1.g(l()).i(), EnumC11067cg4.OPEN, QI1.c);
        return AbstractC9766aX0.e(kc6K1);
    }
}
