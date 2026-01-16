package ir.nasim;

import ir.nasim.InterfaceC21991uU3;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* loaded from: classes3.dex */
class CM5 implements InterfaceC21991uU3.b {
    private final List a;
    private final List b;
    private final Set c = new HashSet(3);

    CM5(List list) {
        this.a = list;
        this.b = new ArrayList(list.size());
    }

    private void b(InterfaceC21991uU3 interfaceC21991uU3) {
        if (this.b.contains(interfaceC21991uU3)) {
            return;
        }
        if (this.c.contains(interfaceC21991uU3)) {
            throw new IllegalStateException("Cyclic dependency chain found: " + this.c);
        }
        this.c.add(interfaceC21991uU3);
        interfaceC21991uU3.c(this);
        this.c.remove(interfaceC21991uU3);
        if (this.b.contains(interfaceC21991uU3)) {
            return;
        }
        if (C7158Qn1.class.isAssignableFrom(interfaceC21991uU3.getClass())) {
            this.b.add(0, interfaceC21991uU3);
        } else {
            this.b.add(interfaceC21991uU3);
        }
    }

    private static InterfaceC21991uU3 c(List list, Class cls) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            InterfaceC21991uU3 interfaceC21991uU3 = (InterfaceC21991uU3) it.next();
            if (cls.isAssignableFrom(interfaceC21991uU3.getClass())) {
                return interfaceC21991uU3;
            }
        }
        return null;
    }

    private InterfaceC21991uU3 d(Class cls) {
        InterfaceC21991uU3 interfaceC21991uU3C = c(this.b, cls);
        if (interfaceC21991uU3C == null) {
            interfaceC21991uU3C = c(this.a, cls);
            if (interfaceC21991uU3C == null) {
                throw new IllegalStateException("Requested plugin is not added: " + cls.getName() + ", plugins: " + this.a);
            }
            b(interfaceC21991uU3C);
        }
        return interfaceC21991uU3C;
    }

    @Override // ir.nasim.InterfaceC21991uU3.b
    public void a(Class cls, InterfaceC21991uU3.a aVar) {
        aVar.a(d(cls));
    }

    List e() {
        Iterator it = this.a.iterator();
        while (it.hasNext()) {
            b((InterfaceC21991uU3) it.next());
        }
        return this.b;
    }
}
