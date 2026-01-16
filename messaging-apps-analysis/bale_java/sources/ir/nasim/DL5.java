package ir.nasim;

import ir.nasim.InterfaceC8047Uh3;
import java.util.Set;

/* loaded from: classes8.dex */
public final class DL5 implements InterfaceC8047Uh3 {
    private final ClassLoader a;

    public DL5(ClassLoader classLoader) {
        AbstractC13042fc3.i(classLoader, "classLoader");
        this.a = classLoader;
    }

    @Override // ir.nasim.InterfaceC8047Uh3
    public InterfaceC22715vi3 a(C9424Zw2 c9424Zw2) {
        AbstractC13042fc3.i(c9424Zw2, "fqName");
        return new PL5(c9424Zw2);
    }

    @Override // ir.nasim.InterfaceC8047Uh3
    public InterfaceC7106Qh3 b(InterfaceC8047Uh3.a aVar) {
        AbstractC13042fc3.i(aVar, "request");
        C24948zU0 c24948zU0A = aVar.a();
        C9424Zw2 c9424Zw2H = c24948zU0A.h();
        AbstractC13042fc3.h(c9424Zw2H, "classId.packageFqName");
        String strB = c24948zU0A.i().b();
        AbstractC13042fc3.h(strB, "classId.relativeClassName.asString()");
        String strL = AbstractC20153rZ6.L(strB, '.', '$', false, 4, null);
        if (!c9424Zw2H.d()) {
            strL = c9424Zw2H.b() + '.' + strL;
        }
        Class clsA = EL5.a(this.a, strL);
        if (clsA != null) {
            return new CL5(clsA);
        }
        return null;
    }

    @Override // ir.nasim.InterfaceC8047Uh3
    public Set c(C9424Zw2 c9424Zw2) {
        AbstractC13042fc3.i(c9424Zw2, "packageFqName");
        return null;
    }
}
