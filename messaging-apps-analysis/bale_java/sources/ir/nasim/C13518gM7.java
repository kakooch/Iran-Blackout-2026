package ir.nasim;

import ir.nasim.C9475a16;
import ir.nasim.CI7;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

/* renamed from: ir.nasim.gM7, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C13518gM7 {
    private final InterfaceC8344Vo3 a;
    private final C14733iO2 b;
    private HashMap c;

    public C13518gM7(InterfaceC8344Vo3 interfaceC8344Vo3, C14733iO2 c14733iO2) {
        AbstractC13042fc3.i(interfaceC8344Vo3, "usersEngine");
        this.a = interfaceC8344Vo3;
        this.b = c14733iO2;
        this.c = new HashMap();
    }

    private final List d(J44 j44) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(Integer.valueOf(j44.U()));
        InterfaceC25103zk1 interfaceC25103zk1F = j44.F();
        if (interfaceC25103zk1F instanceof InterfaceC4499Fj7) {
            arrayList.add(Integer.valueOf(((InterfaceC4499Fj7) interfaceC25103zk1F).c()));
        }
        C8445Vz5 c8445Vz5Q = j44.Q();
        if (c8445Vz5Q != null) {
            arrayList.add(Integer.valueOf(c8445Vz5Q.z()));
        }
        return arrayList;
    }

    public final CI7 a(int i) {
        Object objB;
        try {
            C9475a16.a aVar = C9475a16.b;
            HashMap map = this.c;
            Integer numValueOf = Integer.valueOf(i);
            Object objA = map.get(numValueOf);
            if (objA == null) {
                C17637nI7 c17637nI7 = (C17637nI7) this.a.d(i);
                CI7.a aVar2 = CI7.f;
                AbstractC13042fc3.f(c17637nI7);
                objA = aVar2.a(c17637nI7);
                map.put(numValueOf, objA);
            }
            objB = C9475a16.b((CI7) objA);
        } catch (Throwable th) {
            C9475a16.a aVar3 = C9475a16.b;
            objB = C9475a16.b(AbstractC10685c16.a(th));
        }
        if (C9475a16.g(objB)) {
            objB = null;
        }
        return (CI7) objB;
    }

    public final String b(int i) {
        C19482qQ7 c19482qQ7T;
        HashSet hashSet;
        Object next;
        C14733iO2 c14733iO2 = this.b;
        if (c14733iO2 == null || (c19482qQ7T = c14733iO2.t()) == null || (hashSet = (HashSet) c19482qQ7T.b()) == null) {
            return null;
        }
        Iterator it = hashSet.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (((C23104wM2) next).f() == i) {
                break;
            }
        }
        C23104wM2 c23104wM2 = (C23104wM2) next;
        if (c23104wM2 != null) {
            return c23104wM2.d();
        }
        return null;
    }

    public final CI7 c(Integer num) {
        return (CI7) this.c.get(num);
    }

    public final String e(Integer num) {
        CI7 ci7 = (CI7) this.c.get(num);
        if (ci7 != null) {
            return ci7.b();
        }
        return null;
    }

    public final Object f(List list) {
        AbstractC13042fc3.i(list, "messages");
        try {
            C9475a16.a aVar = C9475a16.b;
            ArrayList arrayList = new ArrayList();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                AbstractC13610gX0.D(arrayList, ((J44) it.next()).R());
            }
            ArrayList arrayList2 = new ArrayList();
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                AbstractC13610gX0.D(arrayList2, ((GG5) it2.next()).y());
            }
            ArrayList arrayList3 = new ArrayList();
            Iterator it3 = list.iterator();
            while (it3.hasNext()) {
                AbstractC13610gX0.D(arrayList3, d((J44) it3.next()));
            }
            List listJ0 = AbstractC15401jX0.j0(AbstractC15401jX0.R0(arrayList2, arrayList3));
            ArrayList arrayList4 = new ArrayList(AbstractC10976cX0.x(listJ0, 10));
            Iterator it4 = listJ0.iterator();
            while (it4.hasNext()) {
                arrayList4.add(Long.valueOf(((Number) it4.next()).intValue()));
            }
            List listF = this.a.f(arrayList4);
            AbstractC13042fc3.h(listF, "let(...)");
            List<C17637nI7> list2 = listF;
            ArrayList arrayList5 = new ArrayList(AbstractC10976cX0.x(list2, 10));
            for (C17637nI7 c17637nI7 : list2) {
                CI7.a aVar2 = CI7.f;
                AbstractC13042fc3.f(c17637nI7);
                arrayList5.add(aVar2.a(c17637nI7));
            }
            LinkedHashMap linkedHashMap = new LinkedHashMap(AbstractC23053wG5.e(AbstractC19460qO3.f(AbstractC10976cX0.x(arrayList5, 10)), 16));
            for (Object obj : arrayList5) {
                linkedHashMap.put(Integer.valueOf(((CI7) obj).c()), obj);
            }
            this.c.putAll(linkedHashMap);
            return C9475a16.b(C19938rB7.a);
        } catch (Throwable th) {
            C9475a16.a aVar3 = C9475a16.b;
            return C9475a16.b(AbstractC10685c16.a(th));
        }
    }

    public final Object g(List list) {
        AbstractC13042fc3.i(list, "uIds");
        try {
            C9475a16.a aVar = C9475a16.b;
            List list2 = list;
            ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(list2, 10));
            Iterator it = list2.iterator();
            while (it.hasNext()) {
                arrayList.add(Long.valueOf(((Number) it.next()).intValue()));
            }
            List listF = this.a.f(arrayList);
            AbstractC13042fc3.h(listF, "let(...)");
            List<C17637nI7> list3 = listF;
            ArrayList arrayList2 = new ArrayList(AbstractC10976cX0.x(list3, 10));
            for (C17637nI7 c17637nI7 : list3) {
                CI7.a aVar2 = CI7.f;
                AbstractC13042fc3.f(c17637nI7);
                arrayList2.add(aVar2.a(c17637nI7));
            }
            LinkedHashMap linkedHashMap = new LinkedHashMap(AbstractC23053wG5.e(AbstractC19460qO3.f(AbstractC10976cX0.x(arrayList2, 10)), 16));
            for (Object obj : arrayList2) {
                linkedHashMap.put(Integer.valueOf(((CI7) obj).c()), obj);
            }
            this.c.putAll(linkedHashMap);
            return C9475a16.b(C19938rB7.a);
        } catch (Throwable th) {
            C9475a16.a aVar3 = C9475a16.b;
            return C9475a16.b(AbstractC10685c16.a(th));
        }
    }
}
