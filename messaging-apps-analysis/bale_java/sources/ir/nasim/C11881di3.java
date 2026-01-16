package ir.nasim;

/* renamed from: ir.nasim.di3, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C11881di3 {
    private final C8641Wv3 a;
    private final InterfaceC3550Bi3 b;

    public C11881di3(C8641Wv3 c8641Wv3, InterfaceC3550Bi3 interfaceC3550Bi3) {
        AbstractC13042fc3.i(c8641Wv3, "packageFragmentProvider");
        AbstractC13042fc3.i(interfaceC3550Bi3, "javaResolverCache");
        this.a = c8641Wv3;
        this.b = interfaceC3550Bi3;
    }

    public final C8641Wv3 a() {
        return this.a;
    }

    public final InterfaceC21331tU0 b(InterfaceC7106Qh3 interfaceC7106Qh3) {
        AbstractC13042fc3.i(interfaceC7106Qh3, "javaClass");
        C9424Zw2 c9424Zw2E = interfaceC7106Qh3.e();
        if (c9424Zw2E != null && interfaceC7106Qh3.M() == EnumC23477wz3.SOURCE) {
            return this.b.c(c9424Zw2E);
        }
        InterfaceC7106Qh3 interfaceC7106Qh3J = interfaceC7106Qh3.j();
        if (interfaceC7106Qh3J != null) {
            InterfaceC21331tU0 interfaceC21331tU0B = b(interfaceC7106Qh3J);
            W24 w24U = interfaceC21331tU0B == null ? null : interfaceC21331tU0B.U();
            MU0 mu0E = w24U == null ? null : w24U.e(interfaceC7106Qh3.getName(), FA4.FROM_JAVA_LOADER);
            if (mu0E instanceof InterfaceC21331tU0) {
                return (InterfaceC21331tU0) mu0E;
            }
            return null;
        }
        if (c9424Zw2E == null) {
            return null;
        }
        C8641Wv3 c8641Wv3 = this.a;
        C9424Zw2 c9424Zw2E2 = c9424Zw2E.e();
        AbstractC13042fc3.h(c9424Zw2E2, "fqName.parent()");
        C8407Vv3 c8407Vv3 = (C8407Vv3) AbstractC15401jX0.s0(c8641Wv3.b(c9424Zw2E2));
        if (c8407Vv3 == null) {
            return null;
        }
        return c8407Vv3.K0(interfaceC7106Qh3);
    }
}
