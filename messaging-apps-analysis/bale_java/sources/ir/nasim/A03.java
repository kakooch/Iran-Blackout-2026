package ir.nasim;

import java.util.LinkedHashMap;
import java.util.Map;

/* loaded from: classes7.dex */
public final class A03 {
    private final Map a = new LinkedHashMap();
    private final Map b = new LinkedHashMap();

    public final C12700f33 a(EnumC23487x03 enumC23487x03, InterfaceC22053ub1 interfaceC22053ub1, int i) {
        AbstractC13042fc3.i(enumC23487x03, "key");
        interfaceC22053ub1.W(-305378496);
        Map map = this.a;
        Object objB = map.get(enumC23487x03);
        if (objB == null) {
            objB = XQ7.b(C12700f33.k, enumC23487x03.j(), interfaceC22053ub1, 6);
            map.put(enumC23487x03, objB);
        }
        C12700f33 c12700f33 = (C12700f33) objB;
        interfaceC22053ub1.Q();
        return c12700f33;
    }
}
