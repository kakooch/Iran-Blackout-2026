package ir.nasim;

/* renamed from: ir.nasim.uI6, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public abstract class AbstractC21886uI6 {

    /* renamed from: ir.nasim.uI6$a */
    static final class a extends AbstractC8614Ws3 implements UA2 {
        public static final a e = new a();

        a() {
            super(1);
        }

        public final boolean a(InterfaceC15194jA0 interfaceC15194jA0) {
            AbstractC13042fc3.i(interfaceC15194jA0, "it");
            return HU0.a.b(PI1.o(interfaceC15194jA0));
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            return Boolean.valueOf(a((InterfaceC15194jA0) obj));
        }
    }

    /* renamed from: ir.nasim.uI6$b */
    static final class b extends AbstractC8614Ws3 implements UA2 {
        public static final b e = new b();

        b() {
            super(1);
        }

        public final boolean a(InterfaceC15194jA0 interfaceC15194jA0) {
            AbstractC13042fc3.i(interfaceC15194jA0, "it");
            return C17321mm0.n.l((JC6) interfaceC15194jA0);
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            return Boolean.valueOf(a((InterfaceC15194jA0) obj));
        }
    }

    /* renamed from: ir.nasim.uI6$c */
    static final class c extends AbstractC8614Ws3 implements UA2 {
        public static final c e = new c();

        c() {
            super(1);
        }

        public final boolean a(InterfaceC15194jA0 interfaceC15194jA0) {
            AbstractC13042fc3.i(interfaceC15194jA0, "it");
            return AbstractC19738qr3.e0(interfaceC15194jA0) && C17912nm0.m(interfaceC15194jA0) != null;
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            return Boolean.valueOf(a((InterfaceC15194jA0) obj));
        }
    }

    public static final boolean a(InterfaceC15194jA0 interfaceC15194jA0) {
        AbstractC13042fc3.i(interfaceC15194jA0, "<this>");
        return d(interfaceC15194jA0) != null;
    }

    public static final String b(InterfaceC15194jA0 interfaceC15194jA0) {
        C6432No4 c6432No4J;
        AbstractC13042fc3.i(interfaceC15194jA0, "callableMemberDescriptor");
        InterfaceC15194jA0 interfaceC15194jA0C = c(interfaceC15194jA0);
        InterfaceC15194jA0 interfaceC15194jA0O = interfaceC15194jA0C == null ? null : PI1.o(interfaceC15194jA0C);
        if (interfaceC15194jA0O == null) {
            return null;
        }
        if (interfaceC15194jA0O instanceof InterfaceC20989sw5) {
            return HU0.a.a(interfaceC15194jA0O);
        }
        if (!(interfaceC15194jA0O instanceof JC6) || (c6432No4J = C17321mm0.n.j((JC6) interfaceC15194jA0O)) == null) {
            return null;
        }
        return c6432No4J.h();
    }

    private static final InterfaceC15194jA0 c(InterfaceC15194jA0 interfaceC15194jA0) {
        if (AbstractC19738qr3.e0(interfaceC15194jA0)) {
            return d(interfaceC15194jA0);
        }
        return null;
    }

    public static final InterfaceC15194jA0 d(InterfaceC15194jA0 interfaceC15194jA0) {
        AbstractC13042fc3.i(interfaceC15194jA0, "<this>");
        if (!AbstractC22476vI6.a.f().contains(interfaceC15194jA0.getName()) && !C19094pm0.a.d().contains(PI1.o(interfaceC15194jA0).getName())) {
            return null;
        }
        if (interfaceC15194jA0 instanceof InterfaceC20989sw5 ? true : interfaceC15194jA0 instanceof InterfaceC19199pw5) {
            return PI1.d(interfaceC15194jA0, false, a.e, 1, null);
        }
        if (interfaceC15194jA0 instanceof JC6) {
            return PI1.d(interfaceC15194jA0, false, b.e, 1, null);
        }
        return null;
    }

    public static final InterfaceC15194jA0 e(InterfaceC15194jA0 interfaceC15194jA0) {
        AbstractC13042fc3.i(interfaceC15194jA0, "<this>");
        InterfaceC15194jA0 interfaceC15194jA0D = d(interfaceC15194jA0);
        if (interfaceC15194jA0D != null) {
            return interfaceC15194jA0D;
        }
        C17912nm0 c17912nm0 = C17912nm0.n;
        C6432No4 name = interfaceC15194jA0.getName();
        AbstractC13042fc3.h(name, "name");
        if (c17912nm0.l(name)) {
            return PI1.d(interfaceC15194jA0, false, c.e, 1, null);
        }
        return null;
    }

    public static final boolean f(InterfaceC21331tU0 interfaceC21331tU0, InterfaceC14592iA0 interfaceC14592iA0) {
        AbstractC13042fc3.i(interfaceC21331tU0, "<this>");
        AbstractC13042fc3.i(interfaceC14592iA0, "specialCallableDescriptor");
        XC6 xc6P = ((InterfaceC21331tU0) interfaceC14592iA0.b()).p();
        AbstractC13042fc3.h(xc6P, "specialCallableDescriptor.containingDeclaration as ClassDescriptor).defaultType");
        for (InterfaceC21331tU0 interfaceC21331tU0S = OI1.s(interfaceC21331tU0); interfaceC21331tU0S != null; interfaceC21331tU0S = OI1.s(interfaceC21331tU0S)) {
            if (!(interfaceC21331tU0S instanceof InterfaceC7811Th3) && AbstractC11421cy7.b(interfaceC21331tU0S.p(), xc6P) != null) {
                return !AbstractC19738qr3.e0(interfaceC21331tU0S);
            }
        }
        return false;
    }

    public static final boolean g(InterfaceC15194jA0 interfaceC15194jA0) {
        AbstractC13042fc3.i(interfaceC15194jA0, "<this>");
        return PI1.o(interfaceC15194jA0).b() instanceof InterfaceC7811Th3;
    }

    public static final boolean h(InterfaceC15194jA0 interfaceC15194jA0) {
        AbstractC13042fc3.i(interfaceC15194jA0, "<this>");
        return g(interfaceC15194jA0) || AbstractC19738qr3.e0(interfaceC15194jA0);
    }
}
