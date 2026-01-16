package ir.nasim;

import ir.nasim.InterfaceC22011uW5;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes8.dex */
public abstract class MI2 extends X24 {
    static final /* synthetic */ InterfaceC5239Im3[] d = {AbstractC10882cM5.i(new C25226zw5(AbstractC10882cM5.b(MI2.class), "allDescriptors", "getAllDescriptors()Ljava/util/List;"))};
    private final InterfaceC21331tU0 b;
    private final InterfaceC23016wC4 c;

    static final class a extends AbstractC8614Ws3 implements SA2 {
        a() {
            super(0);
        }

        @Override // ir.nasim.SA2
        public final List invoke() {
            List listI = MI2.this.i();
            return AbstractC15401jX0.R0(listI, MI2.this.j(listI));
        }
    }

    public static final class b extends AbstractC16980mB4 {
        final /* synthetic */ ArrayList a;
        final /* synthetic */ MI2 b;

        b(ArrayList arrayList, MI2 mi2) {
            this.a = arrayList;
            this.b = mi2;
        }

        @Override // ir.nasim.AbstractC10899cO4
        public void a(InterfaceC15194jA0 interfaceC15194jA0) {
            AbstractC13042fc3.i(interfaceC15194jA0, "fakeOverride");
            C11663dO4.N(interfaceC15194jA0, null);
            this.a.add(interfaceC15194jA0);
        }

        @Override // ir.nasim.AbstractC16980mB4
        protected void e(InterfaceC15194jA0 interfaceC15194jA0, InterfaceC15194jA0 interfaceC15194jA02) {
            AbstractC13042fc3.i(interfaceC15194jA0, "fromSuper");
            AbstractC13042fc3.i(interfaceC15194jA02, "fromCurrent");
            throw new IllegalStateException(("Conflict in scope of " + this.b.l() + ": " + interfaceC15194jA0 + " vs " + interfaceC15194jA02).toString());
        }
    }

    public MI2(ON6 on6, InterfaceC21331tU0 interfaceC21331tU0) {
        AbstractC13042fc3.i(on6, "storageManager");
        AbstractC13042fc3.i(interfaceC21331tU0, "containingClass");
        this.b = interfaceC21331tU0;
        this.c = on6.c(new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List j(List list) {
        Collection collectionM;
        ArrayList arrayList = new ArrayList(3);
        Collection collectionB = this.b.j().b();
        AbstractC13042fc3.h(collectionB, "containingClass.typeConstructor.supertypes");
        ArrayList arrayList2 = new ArrayList();
        Iterator it = collectionB.iterator();
        while (it.hasNext()) {
            AbstractC13610gX0.D(arrayList2, InterfaceC22011uW5.a.a(((AbstractC4099Dr3) it.next()).o(), null, null, 3, null));
        }
        ArrayList arrayList3 = new ArrayList();
        for (Object obj : arrayList2) {
            if (obj instanceof InterfaceC15194jA0) {
                arrayList3.add(obj);
            }
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Object obj2 : arrayList3) {
            C6432No4 name = ((InterfaceC15194jA0) obj2).getName();
            Object arrayList4 = linkedHashMap.get(name);
            if (arrayList4 == null) {
                arrayList4 = new ArrayList();
                linkedHashMap.put(name, arrayList4);
            }
            ((List) arrayList4).add(obj2);
        }
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            C6432No4 c6432No4 = (C6432No4) entry.getKey();
            List list2 = (List) entry.getValue();
            LinkedHashMap linkedHashMap2 = new LinkedHashMap();
            for (Object obj3 : list2) {
                Boolean boolValueOf = Boolean.valueOf(((InterfaceC15194jA0) obj3) instanceof AB2);
                Object arrayList5 = linkedHashMap2.get(boolValueOf);
                if (arrayList5 == null) {
                    arrayList5 = new ArrayList();
                    linkedHashMap2.put(boolValueOf, arrayList5);
                }
                ((List) arrayList5).add(obj3);
            }
            for (Map.Entry entry2 : linkedHashMap2.entrySet()) {
                boolean zBooleanValue = ((Boolean) entry2.getKey()).booleanValue();
                List list3 = (List) entry2.getValue();
                C11663dO4 c11663dO4 = C11663dO4.d;
                List list4 = list3;
                if (zBooleanValue) {
                    collectionM = new ArrayList();
                    for (Object obj4 : list) {
                        if (AbstractC13042fc3.d(((AB2) obj4).getName(), c6432No4)) {
                            collectionM.add(obj4);
                        }
                    }
                } else {
                    collectionM = AbstractC10360bX0.m();
                }
                c11663dO4.y(c6432No4, list4, collectionM, this.b, new b(arrayList, this));
            }
        }
        return YW0.c(arrayList);
    }

    private final List k() {
        return (List) MN6.a(this.c, this, d[0]);
    }

    @Override // ir.nasim.X24, ir.nasim.W24
    public Collection b(C6432No4 c6432No4, IJ3 ij3) {
        AbstractC13042fc3.i(c6432No4, "name");
        AbstractC13042fc3.i(ij3, "location");
        List listK = k();
        CE6 ce6 = new CE6();
        for (Object obj : listK) {
            if ((obj instanceof InterfaceC20989sw5) && AbstractC13042fc3.d(((InterfaceC20989sw5) obj).getName(), c6432No4)) {
                ce6.add(obj);
            }
        }
        return ce6;
    }

    @Override // ir.nasim.X24, ir.nasim.W24
    public Collection d(C6432No4 c6432No4, IJ3 ij3) {
        AbstractC13042fc3.i(c6432No4, "name");
        AbstractC13042fc3.i(ij3, "location");
        List listK = k();
        CE6 ce6 = new CE6();
        for (Object obj : listK) {
            if ((obj instanceof JC6) && AbstractC13042fc3.d(((JC6) obj).getName(), c6432No4)) {
                ce6.add(obj);
            }
        }
        return ce6;
    }

    @Override // ir.nasim.X24, ir.nasim.InterfaceC22011uW5
    public Collection f(C24841zI1 c24841zI1, UA2 ua2) {
        AbstractC13042fc3.i(c24841zI1, "kindFilter");
        AbstractC13042fc3.i(ua2, "nameFilter");
        return !c24841zI1.a(C24841zI1.p.o()) ? AbstractC10360bX0.m() : k();
    }

    protected abstract List i();

    protected final InterfaceC21331tU0 l() {
        return this.b;
    }
}
