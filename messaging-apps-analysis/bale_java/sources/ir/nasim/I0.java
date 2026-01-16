package ir.nasim;

import java.util.Set;

/* loaded from: classes3.dex */
abstract class I0 implements S01 {
    I0() {
    }

    @Override // ir.nasim.S01
    public Object a(Class cls) {
        InterfaceC7959Tx5 interfaceC7959Tx5D = d(cls);
        if (interfaceC7959Tx5D == null) {
            return null;
        }
        return interfaceC7959Tx5D.get();
    }

    @Override // ir.nasim.S01
    public Set c(Class cls) {
        return (Set) b(cls).get();
    }
}
