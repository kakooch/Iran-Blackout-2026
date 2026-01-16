package ir.nasim;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Set;

/* renamed from: ir.nasim.aC7, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C9584aC7 {
    public static final C9584aC7 a = new C9584aC7();
    private static final Set b;
    private static final Set c;
    private static final HashMap d;
    private static final HashMap e;
    private static final HashMap f;
    private static final Set g;

    static {
        ZB7[] zb7ArrValues = ZB7.values();
        ArrayList arrayList = new ArrayList(zb7ArrValues.length);
        int i = 0;
        for (ZB7 zb7 : zb7ArrValues) {
            arrayList.add(zb7.p());
        }
        b = AbstractC15401jX0.r1(arrayList);
        WB7[] wb7ArrValues = WB7.values();
        ArrayList arrayList2 = new ArrayList(wb7ArrValues.length);
        for (WB7 wb7 : wb7ArrValues) {
            arrayList2.add(wb7.a());
        }
        c = AbstractC15401jX0.r1(arrayList2);
        d = new HashMap();
        e = new HashMap();
        f = AbstractC20051rO3.m(AbstractC4616Fw7.a(WB7.c, C6432No4.p("ubyteArrayOf")), AbstractC4616Fw7.a(WB7.d, C6432No4.p("ushortArrayOf")), AbstractC4616Fw7.a(WB7.e, C6432No4.p("uintArrayOf")), AbstractC4616Fw7.a(WB7.f, C6432No4.p("ulongArrayOf")));
        ZB7[] zb7ArrValues2 = ZB7.values();
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (ZB7 zb72 : zb7ArrValues2) {
            linkedHashSet.add(zb72.a().j());
        }
        g = linkedHashSet;
        ZB7[] zb7ArrValues3 = ZB7.values();
        int length = zb7ArrValues3.length;
        while (i < length) {
            ZB7 zb73 = zb7ArrValues3[i];
            i++;
            d.put(zb73.a(), zb73.j());
            e.put(zb73.j(), zb73.a());
        }
    }

    private C9584aC7() {
    }

    public static final boolean d(AbstractC4099Dr3 abstractC4099Dr3) {
        MU0 mu0D;
        AbstractC13042fc3.i(abstractC4099Dr3, "type");
        if (AbstractC7497Ry7.v(abstractC4099Dr3) || (mu0D = abstractC4099Dr3.K0().t()) == null) {
            return false;
        }
        return a.c(mu0D);
    }

    public final C24948zU0 a(C24948zU0 c24948zU0) {
        AbstractC13042fc3.i(c24948zU0, "arrayClassId");
        return (C24948zU0) d.get(c24948zU0);
    }

    public final boolean b(C6432No4 c6432No4) {
        AbstractC13042fc3.i(c6432No4, "name");
        return g.contains(c6432No4);
    }

    public final boolean c(InterfaceC12795fB1 interfaceC12795fB1) {
        AbstractC13042fc3.i(interfaceC12795fB1, "descriptor");
        InterfaceC12795fB1 interfaceC12795fB1B = interfaceC12795fB1.b();
        return (interfaceC12795fB1B instanceof InterfaceC24340yS4) && AbstractC13042fc3.d(((InterfaceC24340yS4) interfaceC12795fB1B).e(), PJ6.m) && b.contains(interfaceC12795fB1.getName());
    }
}
