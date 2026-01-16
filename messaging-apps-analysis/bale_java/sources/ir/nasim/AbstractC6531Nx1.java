package ir.nasim;

import com.google.firebase.components.DependencyCycleException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* renamed from: ir.nasim.Nx1, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
abstract class AbstractC6531Nx1 {

    /* renamed from: ir.nasim.Nx1$b */
    private static class b {
        private final I01 a;
        private final Set b = new HashSet();
        private final Set c = new HashSet();

        b(I01 i01) {
            this.a = i01;
        }

        void a(b bVar) {
            this.b.add(bVar);
        }

        void b(b bVar) {
            this.c.add(bVar);
        }

        I01 c() {
            return this.a;
        }

        Set d() {
            return this.b;
        }

        boolean e() {
            return this.b.isEmpty();
        }

        boolean f() {
            return this.c.isEmpty();
        }

        void g(b bVar) {
            this.c.remove(bVar);
        }
    }

    /* renamed from: ir.nasim.Nx1$c */
    private static class c {
        private final Class a;
        private final boolean b;

        public boolean equals(Object obj) {
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            return cVar.a.equals(this.a) && cVar.b == this.b;
        }

        public int hashCode() {
            return ((this.a.hashCode() ^ 1000003) * 1000003) ^ Boolean.valueOf(this.b).hashCode();
        }

        private c(Class cls, boolean z) {
            this.a = cls;
            this.b = z;
        }
    }

    static void a(List list) {
        Set<b> setC = c(list);
        Set setB = b(setC);
        int i = 0;
        while (!setB.isEmpty()) {
            b bVar = (b) setB.iterator().next();
            setB.remove(bVar);
            i++;
            for (b bVar2 : bVar.d()) {
                bVar2.g(bVar);
                if (bVar2.f()) {
                    setB.add(bVar2);
                }
            }
        }
        if (i == list.size()) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (b bVar3 : setC) {
            if (!bVar3.f() && !bVar3.e()) {
                arrayList.add(bVar3.c());
            }
        }
        throw new DependencyCycleException(arrayList);
    }

    private static Set b(Set set) {
        HashSet hashSet = new HashSet();
        Iterator it = set.iterator();
        while (it.hasNext()) {
            b bVar = (b) it.next();
            if (bVar.f()) {
                hashSet.add(bVar);
            }
        }
        return hashSet;
    }

    private static Set c(List list) {
        Set<b> set;
        HashMap map = new HashMap(list.size());
        Iterator it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                Iterator it2 = map.values().iterator();
                while (it2.hasNext()) {
                    for (b bVar : (Set) it2.next()) {
                        for (C10226bI1 c10226bI1 : bVar.c().e()) {
                            if (c10226bI1.d() && (set = (Set) map.get(new c(c10226bI1.b(), c10226bI1.f()))) != null) {
                                for (b bVar2 : set) {
                                    bVar.a(bVar2);
                                    bVar2.b(bVar);
                                }
                            }
                        }
                    }
                }
                HashSet hashSet = new HashSet();
                Iterator it3 = map.values().iterator();
                while (it3.hasNext()) {
                    hashSet.addAll((Set) it3.next());
                }
                return hashSet;
            }
            I01 i01 = (I01) it.next();
            b bVar3 = new b(i01);
            for (Class cls : i01.h()) {
                c cVar = new c(cls, !i01.n());
                if (!map.containsKey(cVar)) {
                    map.put(cVar, new HashSet());
                }
                Set set2 = (Set) map.get(cVar);
                if (!set2.isEmpty() && !cVar.b) {
                    throw new IllegalArgumentException(String.format("Multiple components provide %s.", cls));
                }
                set2.add(bVar3);
            }
        }
    }
}
