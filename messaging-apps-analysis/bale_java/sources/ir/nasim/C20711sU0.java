package ir.nasim;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* renamed from: ir.nasim.sU0, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public class C20711sU0 implements InterfaceC17568nB1 {
    private final InterfaceC7106Qh3 a;
    private final UA2 b;
    private final UA2 c;
    private final Map d;
    private final Map e;
    private final Map f;

    /* renamed from: ir.nasim.sU0$a */
    static final class a extends AbstractC8614Ws3 implements UA2 {
        a() {
            super(1);
        }

        public final boolean a(InterfaceC20257ri3 interfaceC20257ri3) {
            AbstractC13042fc3.i(interfaceC20257ri3, "m");
            return ((Boolean) C20711sU0.this.b.invoke(interfaceC20257ri3)).booleanValue() && !AbstractC19057pi3.c(interfaceC20257ri3);
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            return Boolean.valueOf(a((InterfaceC20257ri3) obj));
        }
    }

    public C20711sU0(InterfaceC7106Qh3 interfaceC7106Qh3, UA2 ua2) {
        AbstractC13042fc3.i(interfaceC7106Qh3, "jClass");
        AbstractC13042fc3.i(ua2, "memberFilter");
        this.a = interfaceC7106Qh3;
        this.b = ua2;
        a aVar = new a();
        this.c = aVar;
        InterfaceC23384wp6 interfaceC23384wp6R = AbstractC11342cq6.r(AbstractC15401jX0.g0(interfaceC7106Qh3.C()), aVar);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Object obj : interfaceC23384wp6R) {
            C6432No4 name = ((InterfaceC20257ri3) obj).getName();
            Object arrayList = linkedHashMap.get(name);
            if (arrayList == null) {
                arrayList = new ArrayList();
                linkedHashMap.put(name, arrayList);
            }
            ((List) arrayList).add(obj);
        }
        this.d = linkedHashMap;
        InterfaceC23384wp6 interfaceC23384wp6R2 = AbstractC11342cq6.r(AbstractC15401jX0.g0(this.a.x()), this.b);
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        for (Object obj2 : interfaceC23384wp6R2) {
            linkedHashMap2.put(((InterfaceC14921ii3) obj2).getName(), obj2);
        }
        this.e = linkedHashMap2;
        Collection collectionL = this.a.l();
        UA2 ua22 = this.b;
        ArrayList arrayList2 = new ArrayList();
        for (Object obj3 : collectionL) {
            if (((Boolean) ua22.invoke(obj3)).booleanValue()) {
                arrayList2.add(obj3);
            }
        }
        LinkedHashMap linkedHashMap3 = new LinkedHashMap(AbstractC23053wG5.e(AbstractC19460qO3.f(AbstractC10976cX0.x(arrayList2, 10)), 16));
        Iterator it = arrayList2.iterator();
        if (it.hasNext()) {
            AbstractC18350oW3.a(it.next());
            throw null;
        }
        this.f = linkedHashMap3;
    }

    @Override // ir.nasim.InterfaceC17568nB1
    public Set a() {
        InterfaceC23384wp6 interfaceC23384wp6R = AbstractC11342cq6.r(AbstractC15401jX0.g0(this.a.C()), this.c);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        Iterator it = interfaceC23384wp6R.iterator();
        while (it.hasNext()) {
            linkedHashSet.add(((InterfaceC22125ui3) it.next()).getName());
        }
        return linkedHashSet;
    }

    @Override // ir.nasim.InterfaceC17568nB1
    public InterfaceC3311Ai3 b(C6432No4 c6432No4) {
        AbstractC13042fc3.i(c6432No4, "name");
        AbstractC18350oW3.a(this.f.get(c6432No4));
        return null;
    }

    @Override // ir.nasim.InterfaceC17568nB1
    public Set c() {
        return this.f.keySet();
    }

    @Override // ir.nasim.InterfaceC17568nB1
    public InterfaceC14921ii3 d(C6432No4 c6432No4) {
        AbstractC13042fc3.i(c6432No4, "name");
        return (InterfaceC14921ii3) this.e.get(c6432No4);
    }

    @Override // ir.nasim.InterfaceC17568nB1
    public Set e() {
        InterfaceC23384wp6 interfaceC23384wp6R = AbstractC11342cq6.r(AbstractC15401jX0.g0(this.a.x()), this.b);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        Iterator it = interfaceC23384wp6R.iterator();
        while (it.hasNext()) {
            linkedHashSet.add(((InterfaceC22125ui3) it.next()).getName());
        }
        return linkedHashSet;
    }

    @Override // ir.nasim.InterfaceC17568nB1
    public Collection f(C6432No4 c6432No4) {
        AbstractC13042fc3.i(c6432No4, "name");
        List listM = (List) this.d.get(c6432No4);
        if (listM == null) {
            listM = AbstractC10360bX0.m();
        }
        return listM;
    }
}
