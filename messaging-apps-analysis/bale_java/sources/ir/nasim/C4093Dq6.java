package ir.nasim;

import ir.nasim.AbstractC19686qm1;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlinx.serialization.KSerializer;

/* renamed from: ir.nasim.Dq6, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C4093Dq6 implements InterfaceC4561Fq6 {
    private final Map a = new HashMap();
    private final Map b = new HashMap();
    private final Map c = new HashMap();
    private final Map d = new HashMap();
    private final Map e = new HashMap();

    public static /* synthetic */ void j(C4093Dq6 c4093Dq6, InterfaceC11299cm3 interfaceC11299cm3, InterfaceC11299cm3 interfaceC11299cm32, KSerializer kSerializer, boolean z, int i, Object obj) {
        if ((i & 8) != 0) {
            z = false;
        }
        c4093Dq6.i(interfaceC11299cm3, interfaceC11299cm32, kSerializer, z);
    }

    public static /* synthetic */ void l(C4093Dq6 c4093Dq6, InterfaceC11299cm3 interfaceC11299cm3, AbstractC19686qm1 abstractC19686qm1, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            z = false;
        }
        c4093Dq6.k(interfaceC11299cm3, abstractC19686qm1, z);
    }

    @Override // ir.nasim.InterfaceC4561Fq6
    public void a(InterfaceC11299cm3 interfaceC11299cm3, UA2 ua2) {
        AbstractC13042fc3.i(interfaceC11299cm3, "baseClass");
        AbstractC13042fc3.i(ua2, "defaultDeserializerProvider");
        g(interfaceC11299cm3, ua2, false);
    }

    @Override // ir.nasim.InterfaceC4561Fq6
    public void b(InterfaceC11299cm3 interfaceC11299cm3, UA2 ua2) {
        AbstractC13042fc3.i(interfaceC11299cm3, "baseClass");
        AbstractC13042fc3.i(ua2, "defaultSerializerProvider");
        h(interfaceC11299cm3, ua2, false);
    }

    @Override // ir.nasim.InterfaceC4561Fq6
    public void c(InterfaceC11299cm3 interfaceC11299cm3, UA2 ua2) {
        AbstractC13042fc3.i(interfaceC11299cm3, "kClass");
        AbstractC13042fc3.i(ua2, "provider");
        l(this, interfaceC11299cm3, new AbstractC19686qm1.b(ua2), false, 4, null);
    }

    @Override // ir.nasim.InterfaceC4561Fq6
    public void d(InterfaceC11299cm3 interfaceC11299cm3, InterfaceC11299cm3 interfaceC11299cm32, KSerializer kSerializer) {
        AbstractC13042fc3.i(interfaceC11299cm3, "baseClass");
        AbstractC13042fc3.i(interfaceC11299cm32, "actualClass");
        AbstractC13042fc3.i(kSerializer, "actualSerializer");
        j(this, interfaceC11299cm3, interfaceC11299cm32, kSerializer, false, 8, null);
    }

    @Override // ir.nasim.InterfaceC4561Fq6
    public void e(InterfaceC11299cm3 interfaceC11299cm3, KSerializer kSerializer) {
        AbstractC13042fc3.i(interfaceC11299cm3, "kClass");
        AbstractC13042fc3.i(kSerializer, "serializer");
        l(this, interfaceC11299cm3, new AbstractC19686qm1.a(kSerializer), false, 4, null);
    }

    public final AbstractC3859Cq6 f() {
        return new C20340rq6(this.a, this.b, this.c, this.d, this.e);
    }

    public final void g(InterfaceC11299cm3 interfaceC11299cm3, UA2 ua2, boolean z) {
        AbstractC13042fc3.i(interfaceC11299cm3, "baseClass");
        AbstractC13042fc3.i(ua2, "defaultDeserializerProvider");
        UA2 ua22 = (UA2) this.e.get(interfaceC11299cm3);
        if (ua22 == null || AbstractC13042fc3.d(ua22, ua2) || z) {
            this.e.put(interfaceC11299cm3, ua2);
            return;
        }
        throw new IllegalArgumentException("Default deserializers provider for " + interfaceC11299cm3 + " is already registered: " + ua22);
    }

    public final void h(InterfaceC11299cm3 interfaceC11299cm3, UA2 ua2, boolean z) {
        AbstractC13042fc3.i(interfaceC11299cm3, "baseClass");
        AbstractC13042fc3.i(ua2, "defaultSerializerProvider");
        UA2 ua22 = (UA2) this.c.get(interfaceC11299cm3);
        if (ua22 == null || AbstractC13042fc3.d(ua22, ua2) || z) {
            this.c.put(interfaceC11299cm3, ua2);
            return;
        }
        throw new IllegalArgumentException("Default serializers provider for " + interfaceC11299cm3 + " is already registered: " + ua22);
    }

    public final void i(InterfaceC11299cm3 interfaceC11299cm3, InterfaceC11299cm3 interfaceC11299cm32, KSerializer kSerializer, boolean z) {
        Object next;
        AbstractC13042fc3.i(interfaceC11299cm3, "baseClass");
        AbstractC13042fc3.i(interfaceC11299cm32, "concreteClass");
        AbstractC13042fc3.i(kSerializer, "concreteSerializer");
        String strI = kSerializer.getDescriptor().i();
        Map map = this.b;
        Object map2 = map.get(interfaceC11299cm3);
        if (map2 == null) {
            map2 = new HashMap();
            map.put(interfaceC11299cm3, map2);
        }
        Map map3 = (Map) map2;
        KSerializer kSerializer2 = (KSerializer) map3.get(interfaceC11299cm32);
        Map map4 = this.d;
        Object map5 = map4.get(interfaceC11299cm3);
        if (map5 == null) {
            map5 = new HashMap();
            map4.put(interfaceC11299cm3, map5);
        }
        Map map6 = (Map) map5;
        if (z) {
            if (kSerializer2 != null) {
                map6.remove(kSerializer2.getDescriptor().i());
            }
            map3.put(interfaceC11299cm32, kSerializer);
            map6.put(strI, kSerializer);
            return;
        }
        if (kSerializer2 != null) {
            if (!AbstractC13042fc3.d(kSerializer2, kSerializer)) {
                throw new C3386Aq6(interfaceC11299cm3, interfaceC11299cm32);
            }
            map6.remove(kSerializer2.getDescriptor().i());
        }
        KSerializer kSerializer3 = (KSerializer) map6.get(strI);
        if (kSerializer3 == null) {
            map3.put(interfaceC11299cm32, kSerializer);
            map6.put(strI, kSerializer);
            return;
        }
        Object obj = this.b.get(interfaceC11299cm3);
        AbstractC13042fc3.f(obj);
        Iterator it = AbstractC21263tO3.B((Map) obj).iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            } else {
                next = it.next();
                if (((Map.Entry) next).getValue() == kSerializer3) {
                    break;
                }
            }
        }
        throw new IllegalArgumentException("Multiple polymorphic serializers for base class '" + interfaceC11299cm3 + "' have the same serial name '" + strI + "': '" + interfaceC11299cm32 + "' and '" + ((Map.Entry) next) + '\'');
    }

    public final void k(InterfaceC11299cm3 interfaceC11299cm3, AbstractC19686qm1 abstractC19686qm1, boolean z) {
        AbstractC19686qm1 abstractC19686qm12;
        AbstractC13042fc3.i(interfaceC11299cm3, "forClass");
        AbstractC13042fc3.i(abstractC19686qm1, "provider");
        if (z || (abstractC19686qm12 = (AbstractC19686qm1) this.a.get(interfaceC11299cm3)) == null || AbstractC13042fc3.d(abstractC19686qm12, abstractC19686qm1)) {
            this.a.put(interfaceC11299cm3, abstractC19686qm1);
            return;
        }
        throw new C3386Aq6("Contextual serializer or serializer provider for " + interfaceC11299cm3 + " already registered in this module");
    }
}
