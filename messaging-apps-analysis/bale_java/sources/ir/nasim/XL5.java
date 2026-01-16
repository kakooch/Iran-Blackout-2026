package ir.nasim;

import ir.nasim.InterfaceC20347rr3;
import java.io.InputStream;

/* loaded from: classes8.dex */
public final class XL5 implements InterfaceC20347rr3 {
    private final ClassLoader a;
    private final C16730lm0 b;

    public XL5(ClassLoader classLoader) {
        AbstractC13042fc3.i(classLoader, "classLoader");
        this.a = classLoader;
        this.b = new C16730lm0();
    }

    private final InterfaceC20347rr3.a d(String str) {
        WL5 wl5A;
        Class clsA = EL5.a(this.a, str);
        if (clsA == null || (wl5A = WL5.c.a(clsA)) == null) {
            return null;
        }
        return new InterfaceC20347rr3.a.C1530a(wl5A, null, 2, null);
    }

    @Override // ir.nasim.InterfaceC20347rr3
    public InterfaceC20347rr3.a a(InterfaceC7106Qh3 interfaceC7106Qh3) {
        AbstractC13042fc3.i(interfaceC7106Qh3, "javaClass");
        C9424Zw2 c9424Zw2E = interfaceC7106Qh3.e();
        String strB = c9424Zw2E == null ? null : c9424Zw2E.b();
        if (strB == null) {
            return null;
        }
        return d(strB);
    }

    @Override // ir.nasim.InterfaceC20347rr3
    public InterfaceC20347rr3.a b(C24948zU0 c24948zU0) {
        AbstractC13042fc3.i(c24948zU0, "classId");
        return d(YL5.b(c24948zU0));
    }

    @Override // ir.nasim.InterfaceC24581yr3
    public InputStream c(C9424Zw2 c9424Zw2) {
        AbstractC13042fc3.i(c9424Zw2, "packageFqName");
        if (c9424Zw2.i(PJ6.l)) {
            return this.b.a(C12530em0.n.n(c9424Zw2));
        }
        return null;
    }
}
