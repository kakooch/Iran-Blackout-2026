package ir.nasim;

/* loaded from: classes8.dex */
public abstract class NI1 {
    public static final InterfaceC21331tU0 a(InterfaceC8507Wg4 interfaceC8507Wg4, C9424Zw2 c9424Zw2, IJ3 ij3) {
        W24 w24U;
        MU0 mu0E;
        AbstractC13042fc3.i(interfaceC8507Wg4, "<this>");
        AbstractC13042fc3.i(c9424Zw2, "fqName");
        AbstractC13042fc3.i(ij3, "lookupLocation");
        if (c9424Zw2.d()) {
            return null;
        }
        C9424Zw2 c9424Zw2E = c9424Zw2.e();
        AbstractC13042fc3.h(c9424Zw2E, "fqName.parent()");
        W24 w24O = interfaceC8507Wg4.z0(c9424Zw2E).o();
        C6432No4 c6432No4G = c9424Zw2.g();
        AbstractC13042fc3.h(c6432No4G, "fqName.shortName()");
        MU0 mu0E2 = w24O.e(c6432No4G, ij3);
        InterfaceC21331tU0 interfaceC21331tU0 = mu0E2 instanceof InterfaceC21331tU0 ? (InterfaceC21331tU0) mu0E2 : null;
        if (interfaceC21331tU0 != null) {
            return interfaceC21331tU0;
        }
        C9424Zw2 c9424Zw2E2 = c9424Zw2.e();
        AbstractC13042fc3.h(c9424Zw2E2, "fqName.parent()");
        InterfaceC21331tU0 interfaceC21331tU0A = a(interfaceC8507Wg4, c9424Zw2E2, ij3);
        if (interfaceC21331tU0A == null || (w24U = interfaceC21331tU0A.U()) == null) {
            mu0E = null;
        } else {
            C6432No4 c6432No4G2 = c9424Zw2.g();
            AbstractC13042fc3.h(c6432No4G2, "fqName.shortName()");
            mu0E = w24U.e(c6432No4G2, ij3);
        }
        if (mu0E instanceof InterfaceC21331tU0) {
            return (InterfaceC21331tU0) mu0E;
        }
        return null;
    }
}
