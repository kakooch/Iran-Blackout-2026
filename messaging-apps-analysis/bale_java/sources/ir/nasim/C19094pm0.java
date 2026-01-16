package ir.nasim;

import ir.nasim.PJ6;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* renamed from: ir.nasim.pm0, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C19094pm0 {
    public static final C19094pm0 a = new C19094pm0();
    private static final Map b;
    private static final Map c;
    private static final Set d;
    private static final Set e;

    static {
        C10027ax2 c10027ax2 = PJ6.a.s;
        XV4 xv4A = AbstractC4616Fw7.a(AbstractC19685qm0.d(c10027ax2, "name"), C6432No4.p("name"));
        XV4 xv4A2 = AbstractC4616Fw7.a(AbstractC19685qm0.d(c10027ax2, "ordinal"), C6432No4.p("ordinal"));
        XV4 xv4A3 = AbstractC4616Fw7.a(AbstractC19685qm0.c(PJ6.a.P, "size"), C6432No4.p("size"));
        C9424Zw2 c9424Zw2 = PJ6.a.T;
        Map mapN = AbstractC20051rO3.n(xv4A, xv4A2, xv4A3, AbstractC4616Fw7.a(AbstractC19685qm0.c(c9424Zw2, "size"), C6432No4.p("size")), AbstractC4616Fw7.a(AbstractC19685qm0.d(PJ6.a.g, "length"), C6432No4.p("length")), AbstractC4616Fw7.a(AbstractC19685qm0.c(c9424Zw2, "keys"), C6432No4.p("keySet")), AbstractC4616Fw7.a(AbstractC19685qm0.c(c9424Zw2, "values"), C6432No4.p("values")), AbstractC4616Fw7.a(AbstractC19685qm0.c(c9424Zw2, "entries"), C6432No4.p("entrySet")));
        b = mapN;
        Set<Map.Entry> setEntrySet = mapN.entrySet();
        ArrayList<XV4> arrayList = new ArrayList(AbstractC10976cX0.x(setEntrySet, 10));
        for (Map.Entry entry : setEntrySet) {
            arrayList.add(new XV4(((C9424Zw2) entry.getKey()).g(), entry.getValue()));
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (XV4 xv4 : arrayList) {
            C6432No4 c6432No4 = (C6432No4) xv4.f();
            Object arrayList2 = linkedHashMap.get(c6432No4);
            if (arrayList2 == null) {
                arrayList2 = new ArrayList();
                linkedHashMap.put(c6432No4, arrayList2);
            }
            ((List) arrayList2).add((C6432No4) xv4.e());
        }
        c = linkedHashMap;
        Set setKeySet = b.keySet();
        d = setKeySet;
        Set set = setKeySet;
        ArrayList arrayList3 = new ArrayList(AbstractC10976cX0.x(set, 10));
        Iterator it = set.iterator();
        while (it.hasNext()) {
            arrayList3.add(((C9424Zw2) it.next()).g());
        }
        e = AbstractC15401jX0.r1(arrayList3);
    }

    private C19094pm0() {
    }

    public final Map a() {
        return b;
    }

    public final List b(C6432No4 c6432No4) {
        AbstractC13042fc3.i(c6432No4, "name1");
        List list = (List) c.get(c6432No4);
        return list == null ? AbstractC10360bX0.m() : list;
    }

    public final Set c() {
        return d;
    }

    public final Set d() {
        return e;
    }
}
