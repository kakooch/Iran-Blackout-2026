package ir.nasim;

import java.util.HashMap;
import java.util.Map;

/* renamed from: ir.nasim.oO5, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
class C18280oO5 implements InterfaceC17689nO5 {
    private final Map a = new HashMap(3);

    C18280oO5() {
    }

    @Override // ir.nasim.InterfaceC17689nO5
    public Object a(C17426mw5 c17426mw5) {
        return this.a.get(c17426mw5);
    }

    @Override // ir.nasim.InterfaceC17689nO5
    public void b(C17426mw5 c17426mw5, Object obj) {
        if (obj == null) {
            this.a.remove(c17426mw5);
        } else {
            this.a.put(c17426mw5, obj);
        }
    }
}
