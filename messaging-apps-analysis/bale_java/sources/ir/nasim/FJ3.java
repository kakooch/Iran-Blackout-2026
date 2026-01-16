package ir.nasim;

/* loaded from: classes2.dex */
public abstract class FJ3 {
    public static final DJ3 a(DJ3 dj3) {
        C3419Au3 c3419Au3G1 = dj3.G1();
        while (true) {
            C3419Au3 c3419Au3A0 = c3419Au3G1.A0();
            if ((c3419Au3A0 != null ? c3419Au3A0.k0() : null) == null) {
                DJ3 dj3E2 = c3419Au3G1.w0().E2();
                AbstractC13042fc3.f(dj3E2);
                return dj3E2;
            }
            C3419Au3 c3419Au3A02 = c3419Au3G1.A0();
            C3419Au3 c3419Au3K0 = c3419Au3A02 != null ? c3419Au3A02.k0() : null;
            AbstractC13042fc3.f(c3419Au3K0);
            if (c3419Au3K0.V0()) {
                c3419Au3G1 = c3419Au3G1.A0();
                AbstractC13042fc3.f(c3419Au3G1);
            } else {
                C3419Au3 c3419Au3A03 = c3419Au3G1.A0();
                AbstractC13042fc3.f(c3419Au3A03);
                c3419Au3G1 = c3419Au3A03.k0();
                AbstractC13042fc3.f(c3419Au3G1);
            }
        }
    }
}
