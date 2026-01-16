package ir.nasim;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* renamed from: ir.nasim.hN7, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public abstract class AbstractC14118hN7 {
    public static final List a(Collection collection, Collection collection2, InterfaceC14592iA0 interfaceC14592iA0) {
        AbstractC13042fc3.i(collection, "newValueParametersTypes");
        AbstractC13042fc3.i(collection2, "oldValueParameters");
        AbstractC13042fc3.i(interfaceC14592iA0, "newOwner");
        collection.size();
        collection2.size();
        List listV1 = AbstractC15401jX0.v1(collection, collection2);
        ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(listV1, 10));
        for (Iterator it = listV1.iterator(); it.hasNext(); it = it) {
            XV4 xv4 = (XV4) it.next();
            C24325yQ7 c24325yQ7 = (C24325yQ7) xv4.a();
            InterfaceC24919zQ7 interfaceC24919zQ7 = (InterfaceC24919zQ7) xv4.b();
            int index = interfaceC24919zQ7.getIndex();
            InterfaceC4356Eu annotations = interfaceC24919zQ7.getAnnotations();
            C6432No4 name = interfaceC24919zQ7.getName();
            AbstractC13042fc3.h(name, "oldParameter.name");
            AbstractC4099Dr3 abstractC4099Dr3B = c24325yQ7.b();
            boolean zA = c24325yQ7.a();
            boolean zR0 = interfaceC24919zQ7.r0();
            boolean zP0 = interfaceC24919zQ7.p0();
            AbstractC4099Dr3 abstractC4099Dr3K = interfaceC24919zQ7.u0() != null ? PI1.l(interfaceC14592iA0).n().k(c24325yQ7.b()) : null;
            JH6 jh6I = interfaceC24919zQ7.i();
            AbstractC13042fc3.h(jh6I, "oldParameter.source");
            arrayList.add(new AQ7(interfaceC14592iA0, null, index, annotations, name, abstractC4099Dr3B, zA, zR0, zP0, abstractC4099Dr3K, jh6I));
        }
        return arrayList;
    }

    public static final AbstractC20964su b(InterfaceC24919zQ7 interfaceC24919zQ7) {
        AbstractC7068Qd1 abstractC7068Qd1B;
        C9790aZ6 c9790aZ6;
        String str;
        AbstractC13042fc3.i(interfaceC24919zQ7, "<this>");
        InterfaceC4356Eu annotations = interfaceC24919zQ7.getAnnotations();
        C9424Zw2 c9424Zw2 = AbstractC24521yl3.t;
        AbstractC13042fc3.h(c9424Zw2, "DEFAULT_VALUE_FQ_NAME");
        InterfaceC21651tu interfaceC21651tuZ = annotations.z(c9424Zw2);
        if (interfaceC21651tuZ == null || (abstractC7068Qd1B = PI1.b(interfaceC21651tuZ)) == null) {
            c9790aZ6 = null;
        } else {
            if (!(abstractC7068Qd1B instanceof C9790aZ6)) {
                abstractC7068Qd1B = null;
            }
            c9790aZ6 = (C9790aZ6) abstractC7068Qd1B;
        }
        if (c9790aZ6 != null && (str = (String) c9790aZ6.b()) != null) {
            return new FY6(str);
        }
        InterfaceC4356Eu annotations2 = interfaceC24919zQ7.getAnnotations();
        C9424Zw2 c9424Zw22 = AbstractC24521yl3.u;
        AbstractC13042fc3.h(c9424Zw22, "DEFAULT_NULL_FQ_NAME");
        if (annotations2.M1(c9424Zw22)) {
            return C10202bF4.a;
        }
        return null;
    }

    public static final C10019aw3 c(InterfaceC21331tU0 interfaceC21331tU0) {
        AbstractC13042fc3.i(interfaceC21331tU0, "<this>");
        InterfaceC21331tU0 interfaceC21331tU0P = PI1.p(interfaceC21331tU0);
        if (interfaceC21331tU0P == null) {
            return null;
        }
        W24 w24M0 = interfaceC21331tU0P.m0();
        C10019aw3 c10019aw3 = w24M0 instanceof C10019aw3 ? (C10019aw3) w24M0 : null;
        return c10019aw3 == null ? c(interfaceC21331tU0P) : c10019aw3;
    }
}
