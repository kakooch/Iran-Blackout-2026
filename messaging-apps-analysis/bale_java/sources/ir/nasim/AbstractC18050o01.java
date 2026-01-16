package ir.nasim;

import java.util.Comparator;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: ir.nasim.o01, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public abstract class AbstractC18050o01 {
    public static Comparator b(final UA2... ua2Arr) {
        AbstractC13042fc3.i(ua2Arr, "selectors");
        if (ua2Arr.length > 0) {
            return new Comparator() { // from class: ir.nasim.n01
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    return AbstractC18050o01.c(ua2Arr, obj, obj2);
                }
            };
        }
        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int c(UA2[] ua2Arr, Object obj, Object obj2) {
        return e(obj, obj2, ua2Arr);
    }

    public static int d(Comparable comparable, Comparable comparable2) {
        if (comparable == comparable2) {
            return 0;
        }
        if (comparable == null) {
            return -1;
        }
        if (comparable2 == null) {
            return 1;
        }
        return comparable.compareTo(comparable2);
    }

    private static final int e(Object obj, Object obj2, UA2[] ua2Arr) {
        for (UA2 ua2 : ua2Arr) {
            int iD = d((Comparable) ua2.invoke(obj), (Comparable) ua2.invoke(obj2));
            if (iD != 0) {
                return iD;
            }
        }
        return 0;
    }

    public static Comparator f() {
        C6452Np4 c6452Np4 = C6452Np4.a;
        AbstractC13042fc3.g(c6452Np4, "null cannot be cast to non-null type java.util.Comparator<T of kotlin.comparisons.ComparisonsKt__ComparisonsKt.naturalOrder>{ kotlin.TypeAliasesKt.Comparator<T of kotlin.comparisons.ComparisonsKt__ComparisonsKt.naturalOrder> }");
        return c6452Np4;
    }
}
