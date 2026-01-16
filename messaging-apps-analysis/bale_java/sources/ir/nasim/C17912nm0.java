package ir.nasim;

import ir.nasim.AbstractC22476vI6;

/* renamed from: ir.nasim.nm0, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C17912nm0 extends AbstractC22476vI6 {
    public static final C17912nm0 n = new C17912nm0();

    /* renamed from: ir.nasim.nm0$a */
    static final class a extends AbstractC8614Ws3 implements UA2 {
        a() {
            super(1);
        }

        public final boolean a(InterfaceC15194jA0 interfaceC15194jA0) {
            AbstractC13042fc3.i(interfaceC15194jA0, "it");
            return C17912nm0.this.j(interfaceC15194jA0);
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            return Boolean.valueOf(a((InterfaceC15194jA0) obj));
        }
    }

    /* renamed from: ir.nasim.nm0$b */
    static final class b extends AbstractC8614Ws3 implements UA2 {
        b() {
            super(1);
        }

        public final boolean a(InterfaceC15194jA0 interfaceC15194jA0) {
            AbstractC13042fc3.i(interfaceC15194jA0, "it");
            return (interfaceC15194jA0 instanceof AB2) && C17912nm0.this.j(interfaceC15194jA0);
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            return Boolean.valueOf(a((InterfaceC15194jA0) obj));
        }
    }

    private C17912nm0() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean j(InterfaceC15194jA0 interfaceC15194jA0) {
        return AbstractC15401jX0.i0(AbstractC22476vI6.a.d(), AbstractC6597Oe4.d(interfaceC15194jA0));
    }

    public static final AB2 k(AB2 ab2) {
        AbstractC13042fc3.i(ab2, "functionDescriptor");
        C17912nm0 c17912nm0 = n;
        C6432No4 name = ab2.getName();
        AbstractC13042fc3.h(name, "functionDescriptor.name");
        if (c17912nm0.l(name)) {
            return (AB2) PI1.d(ab2, false, c17912nm0.new a(), 1, null);
        }
        return null;
    }

    public static final AbstractC22476vI6.b m(InterfaceC15194jA0 interfaceC15194jA0) {
        AbstractC13042fc3.i(interfaceC15194jA0, "<this>");
        AbstractC22476vI6.a aVar = AbstractC22476vI6.a;
        if (!aVar.c().contains(interfaceC15194jA0.getName())) {
            return null;
        }
        InterfaceC15194jA0 interfaceC15194jA0D = PI1.d(interfaceC15194jA0, false, n.new b(), 1, null);
        String strD = interfaceC15194jA0D == null ? null : AbstractC6597Oe4.d(interfaceC15194jA0D);
        if (strD == null) {
            return null;
        }
        return aVar.j(strD);
    }

    public final boolean l(C6432No4 c6432No4) {
        AbstractC13042fc3.i(c6432No4, "<this>");
        return AbstractC22476vI6.a.c().contains(c6432No4);
    }
}
