package ir.nasim;

import java.util.Collection;

/* loaded from: classes8.dex */
public final class HU0 {
    public static final HU0 a = new HU0();

    static final class a extends AbstractC8614Ws3 implements UA2 {
        a() {
            super(1);
        }

        public final boolean a(InterfaceC15194jA0 interfaceC15194jA0) {
            AbstractC13042fc3.i(interfaceC15194jA0, "it");
            return HU0.this.b(interfaceC15194jA0);
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            return Boolean.valueOf(a((InterfaceC15194jA0) obj));
        }
    }

    private HU0() {
    }

    private final boolean c(InterfaceC15194jA0 interfaceC15194jA0) {
        if (AbstractC15401jX0.i0(C19094pm0.a.c(), PI1.e(interfaceC15194jA0)) && interfaceC15194jA0.h().isEmpty()) {
            return true;
        }
        if (!AbstractC19738qr3.e0(interfaceC15194jA0)) {
            return false;
        }
        Collection collectionD = interfaceC15194jA0.d();
        AbstractC13042fc3.h(collectionD, "overriddenDescriptors");
        Collection<InterfaceC15194jA0> collection = collectionD;
        if (!collection.isEmpty()) {
            for (InterfaceC15194jA0 interfaceC15194jA02 : collection) {
                AbstractC13042fc3.h(interfaceC15194jA02, "it");
                if (b(interfaceC15194jA02)) {
                    return true;
                }
            }
        }
        return false;
    }

    public final String a(InterfaceC15194jA0 interfaceC15194jA0) {
        C6432No4 c6432No4;
        AbstractC13042fc3.i(interfaceC15194jA0, "<this>");
        AbstractC19738qr3.e0(interfaceC15194jA0);
        InterfaceC15194jA0 interfaceC15194jA0D = PI1.d(PI1.o(interfaceC15194jA0), false, new a(), 1, null);
        if (interfaceC15194jA0D == null || (c6432No4 = (C6432No4) C19094pm0.a.a().get(PI1.i(interfaceC15194jA0D))) == null) {
            return null;
        }
        return c6432No4.h();
    }

    public final boolean b(InterfaceC15194jA0 interfaceC15194jA0) {
        AbstractC13042fc3.i(interfaceC15194jA0, "callableMemberDescriptor");
        if (C19094pm0.a.d().contains(interfaceC15194jA0.getName())) {
            return c(interfaceC15194jA0);
        }
        return false;
    }
}
