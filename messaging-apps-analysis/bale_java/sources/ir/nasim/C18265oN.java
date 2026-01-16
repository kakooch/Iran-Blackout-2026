package ir.nasim;

import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/* renamed from: ir.nasim.oN, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C18265oN implements Comparator {
    private final List a;

    public C18265oN(List list) {
        AbstractC13042fc3.i(list, "order");
        this.a = list;
    }

    @Override // java.util.Comparator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compare(AbstractC14721iN abstractC14721iN, AbstractC14721iN abstractC14721iN2) {
        Object next;
        if (abstractC14721iN == null && abstractC14721iN2 == null) {
            return 0;
        }
        if (abstractC14721iN == null) {
            return -1;
        }
        if (abstractC14721iN2 == null) {
            return 1;
        }
        Class<?> cls = abstractC14721iN.getClass();
        Class<?> cls2 = abstractC14721iN2.getClass();
        if (AbstractC13042fc3.d(cls, cls2)) {
            return 0;
        }
        Iterator it = this.a.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            Class cls3 = (Class) next;
            if (AbstractC13042fc3.d(cls3, cls) || AbstractC13042fc3.d(cls3, cls2)) {
                break;
            }
        }
        return AbstractC13042fc3.d((Class) next, cls) ? -1 : 1;
    }
}
