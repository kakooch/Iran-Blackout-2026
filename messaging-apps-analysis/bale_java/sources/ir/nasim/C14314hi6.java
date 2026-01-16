package ir.nasim;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/* renamed from: ir.nasim.hi6, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C14314hi6 {
    public static final C14314hi6 a = new C14314hi6();

    /* renamed from: ir.nasim.hi6$a */
    public static final class a implements Comparator {
        final /* synthetic */ Map a;

        public a(Map map) {
            this.a = map;
        }

        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            Long l = (Long) this.a.get(Long.valueOf(((AbstractC3769Cg6) obj2).d().u()));
            Long lValueOf = Long.valueOf(l != null ? l.longValue() : 0L);
            Long l2 = (Long) this.a.get(Long.valueOf(((AbstractC3769Cg6) obj).d().u()));
            return AbstractC18050o01.d(lValueOf, Long.valueOf(l2 != null ? l2.longValue() : 0L));
        }
    }

    /* renamed from: ir.nasim.hi6$b */
    public static final class b implements Comparator {
        final /* synthetic */ String a;

        public b(String str) {
            this.a = str;
        }

        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            C14314hi6 c14314hi6 = C14314hi6.a;
            return AbstractC18050o01.d(Integer.valueOf(c14314hi6.b((AbstractC3769Cg6) obj, this.a)), Integer.valueOf(c14314hi6.b((AbstractC3769Cg6) obj2, this.a)));
        }
    }

    private C14314hi6() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int b(AbstractC3769Cg6 abstractC3769Cg6, String str) {
        String lowerCase = AbstractC20762sZ6.n1(abstractC3769Cg6.e()).toString().toLowerCase(Locale.ROOT);
        AbstractC13042fc3.h(lowerCase, "toLowerCase(...)");
        List listM = new C20644sM5("\\s+").m(new C20644sM5("^[^\\p{L}]+").k(lowerCase, ""), 0);
        if (AbstractC13042fc3.d(lowerCase, str)) {
            return 0;
        }
        List list = listM;
        if (!(list instanceof Collection) || !list.isEmpty()) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                if (AbstractC20153rZ6.S((String) it.next(), str, false, 2, null)) {
                    return 0;
                }
            }
        }
        return AbstractC20762sZ6.X(lowerCase, str, false, 2, null) ? 1 : 2;
    }

    public final List c(List list, String str, Map map) {
        AbstractC13042fc3.i(list, "<this>");
        AbstractC13042fc3.i(str, "query");
        AbstractC13042fc3.i(map, "clickMap");
        String lowerCase = AbstractC20762sZ6.n1(str).toString().toLowerCase(Locale.ROOT);
        AbstractC13042fc3.h(lowerCase, "toLowerCase(...)");
        List listE = e(list, str);
        ArrayList arrayList = new ArrayList();
        for (Object obj : listE) {
            if (a.b((AbstractC3769Cg6) obj, lowerCase) == 0) {
                arrayList.add(obj);
            }
        }
        List listD = d(arrayList, map);
        ArrayList arrayList2 = new ArrayList();
        for (Object obj2 : listE) {
            if (a.b((AbstractC3769Cg6) obj2, lowerCase) == 1) {
                arrayList2.add(obj2);
            }
        }
        List listD2 = d(arrayList2, map);
        ArrayList arrayList3 = new ArrayList();
        for (Object obj3 : listE) {
            if (a.b((AbstractC3769Cg6) obj3, lowerCase) == 2) {
                arrayList3.add(obj3);
            }
        }
        return AbstractC15401jX0.R0(AbstractC15401jX0.R0(listD, listD2), d(arrayList3, map));
    }

    public final List d(List list, Map map) {
        AbstractC13042fc3.i(list, "<this>");
        AbstractC13042fc3.i(map, "clickMap");
        return AbstractC15401jX0.a1(list, new a(map));
    }

    public final List e(List list, String str) {
        AbstractC13042fc3.i(list, "<this>");
        AbstractC13042fc3.i(str, "query");
        String lowerCase = AbstractC20762sZ6.n1(str).toString().toLowerCase(Locale.ROOT);
        AbstractC13042fc3.h(lowerCase, "toLowerCase(...)");
        return AbstractC15401jX0.a1(list, new b(lowerCase));
    }
}
