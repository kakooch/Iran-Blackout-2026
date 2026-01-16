package ir.nasim;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* renamed from: ir.nasim.Pb3, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C6808Pb3 extends AbstractC6360Ng4 {
    private final C15788kA3 m;

    /* renamed from: ir.nasim.Pb3$a */
    private static final class a {
        private final List a;

        public a(List list) {
            AbstractC13042fc3.i(list, "internalPhoneBookContacts");
            this.a = list;
        }

        public final List a() {
            return this.a;
        }
    }

    /* renamed from: ir.nasim.Pb3$b */
    public static final class b {
        private final List a;
        private final HashMap b;

        public b(List list, HashMap map) {
            AbstractC13042fc3.i(list, "apiUsers");
            AbstractC13042fc3.i(map, "phones");
            this.a = list;
            this.b = map;
        }

        public final List a() {
            return this.a;
        }

        public final HashMap b() {
            return this.b;
        }
    }

    /* renamed from: ir.nasim.Pb3$c */
    public static final class c {
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C6808Pb3(C9057Yh4 c9057Yh4) {
        super(c9057Yh4);
        AbstractC13042fc3.i(c9057Yh4, "context");
        this.m = C15788kA3.a;
    }

    private final void d0(List list, HashMap map) {
        List<C15811kD> list2 = list;
        ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(list2, 10));
        for (C15811kD c15811kD : list2) {
            Long l = (Long) map.get(String.valueOf(c15811kD.w()));
            int iW = c15811kD.w();
            String strValueOf = String.valueOf(l);
            String strY = c15811kD.y();
            if (strY == null) {
                strY = c15811kD.getName();
                AbstractC13042fc3.h(strY, "getName(...)");
            }
            arrayList.add(new C16388lB3(iW, strValueOf, strY));
        }
        if (!arrayList.isEmpty()) {
            r().f(new a(arrayList));
        }
    }

    private final void e0(List list) throws Throwable {
        if (list.size() == 1) {
            this.m.e(list);
        } else {
            this.m.n(list);
        }
    }

    private final void f0() {
        this.m.g();
    }

    @Override // ir.nasim.AbstractC17647nK, ir.nasim.K6
    public void m(Object obj) throws Exception {
        if (obj instanceof c) {
            f0();
            return;
        }
        if (obj instanceof b) {
            b bVar = (b) obj;
            d0(bVar.a(), bVar.b());
        } else if (obj instanceof a) {
            e0(((a) obj).a());
        } else {
            super.m(obj);
        }
    }
}
