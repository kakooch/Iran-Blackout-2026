package ir.nasim;

import ir.nasim.InterfaceC22581vU3;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* renamed from: ir.nasim.wU3, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
class C23177wU3 implements InterfaceC22581vU3 {
    private final Map a;

    /* renamed from: ir.nasim.wU3$a */
    static class a implements InterfaceC22581vU3.a {
        private final Map a = new HashMap(3);

        a() {
        }

        @Override // ir.nasim.InterfaceC22581vU3.a
        public InterfaceC22581vU3 a() {
            return new C23177wU3(Collections.unmodifiableMap(this.a));
        }

        @Override // ir.nasim.InterfaceC22581vU3.a
        public InterfaceC22581vU3.a b(Class cls, InterfaceC12254eI6 interfaceC12254eI6) {
            if (interfaceC12254eI6 == null) {
                this.a.remove(cls);
            } else {
                this.a.put(cls, interfaceC12254eI6);
            }
            return this;
        }
    }

    C23177wU3(Map map) {
        this.a = map;
    }

    @Override // ir.nasim.InterfaceC22581vU3
    public InterfaceC12254eI6 a(Class cls) {
        return (InterfaceC12254eI6) this.a.get(cls);
    }
}
