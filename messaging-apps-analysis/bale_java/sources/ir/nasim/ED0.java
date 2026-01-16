package ir.nasim;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;

/* loaded from: classes.dex */
public final class ED0 {
    public static final ED0 c = new a().b(0).a();
    public static final ED0 d = new a().b(1).a();
    private final LinkedHashSet a;
    private final String b;

    public static final class a {
        private final LinkedHashSet a = new LinkedHashSet();
        private String b;

        public ED0 a() {
            return new ED0(this.a, this.b);
        }

        public a b(int i) {
            AbstractC4980Hj5.j(i != -1, "The specified lens facing is invalid.");
            this.a.add(new C7259Qy3(i));
            return this;
        }
    }

    ED0(LinkedHashSet linkedHashSet, String str) {
        this.a = linkedHashSet;
        this.b = str;
    }

    public LinkedHashSet a(LinkedHashSet linkedHashSet) {
        ArrayList arrayList = new ArrayList();
        Iterator it = linkedHashSet.iterator();
        while (it.hasNext()) {
            arrayList.add(((InterfaceC15221jD0) it.next()).a());
        }
        List listB = b(arrayList);
        LinkedHashSet linkedHashSet2 = new LinkedHashSet();
        Iterator it2 = linkedHashSet.iterator();
        while (it2.hasNext()) {
            InterfaceC15221jD0 interfaceC15221jD0 = (InterfaceC15221jD0) it2.next();
            if (listB.contains(interfaceC15221jD0.a())) {
                linkedHashSet2.add(interfaceC15221jD0);
            }
        }
        return linkedHashSet2;
    }

    public List b(List list) {
        List arrayList = new ArrayList(list);
        Iterator it = this.a.iterator();
        while (it.hasNext()) {
            arrayList = ((InterfaceC12203eD0) it.next()).a(Collections.unmodifiableList(arrayList));
        }
        arrayList.retainAll(list);
        return arrayList;
    }

    public LinkedHashSet c() {
        return this.a;
    }

    public Integer d() {
        Iterator it = this.a.iterator();
        Integer num = null;
        while (it.hasNext()) {
            InterfaceC12203eD0 interfaceC12203eD0 = (InterfaceC12203eD0) it.next();
            if (interfaceC12203eD0 instanceof C7259Qy3) {
                Integer numValueOf = Integer.valueOf(((C7259Qy3) interfaceC12203eD0).b());
                if (num == null) {
                    num = numValueOf;
                } else if (!num.equals(numValueOf)) {
                    throw new IllegalStateException("Multiple conflicting lens facing requirements exist.");
                }
            }
        }
        return num;
    }

    public InterfaceC15221jD0 e(LinkedHashSet linkedHashSet) {
        Iterator it = a(linkedHashSet).iterator();
        if (it.hasNext()) {
            return (InterfaceC15221jD0) it.next();
        }
        throw new IllegalArgumentException("No available camera can be found");
    }
}
