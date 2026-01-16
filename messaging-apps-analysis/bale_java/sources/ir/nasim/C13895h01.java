package ir.nasim;

import ir.nasim.PJ6;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/* renamed from: ir.nasim.h01, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C13895h01 {
    public static final C13895h01 a = new C13895h01();
    private static final Set b;

    static {
        Set set = EnumC4809Gq5.f;
        PJ6 pj6 = PJ6.a;
        ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(set, 10));
        Iterator it = set.iterator();
        while (it.hasNext()) {
            arrayList.add(PJ6.c((EnumC4809Gq5) it.next()));
        }
        C9424Zw2 c9424Zw2L = PJ6.a.h.l();
        AbstractC13042fc3.h(c9424Zw2L, "string.toSafe()");
        List listS0 = AbstractC15401jX0.S0(arrayList, c9424Zw2L);
        C9424Zw2 c9424Zw2L2 = PJ6.a.j.l();
        AbstractC13042fc3.h(c9424Zw2L2, "_boolean.toSafe()");
        List listS02 = AbstractC15401jX0.S0(listS0, c9424Zw2L2);
        C9424Zw2 c9424Zw2L3 = PJ6.a.s.l();
        AbstractC13042fc3.h(c9424Zw2L3, "_enum.toSafe()");
        List listS03 = AbstractC15401jX0.S0(listS02, c9424Zw2L3);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        Iterator it2 = listS03.iterator();
        while (it2.hasNext()) {
            linkedHashSet.add(C24948zU0.m((C9424Zw2) it2.next()));
        }
        b = linkedHashSet;
    }

    private C13895h01() {
    }

    public final Set a() {
        return b;
    }

    public final Set b() {
        return b;
    }
}
