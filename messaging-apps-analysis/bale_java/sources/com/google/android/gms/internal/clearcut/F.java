package com.google.android.gms.internal.clearcut;

import ir.nasim.Gn8;
import ir.nasim.Hl8;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes3.dex */
final class F extends D {
    private static final Class c = Collections.unmodifiableList(Collections.emptyList()).getClass();

    private F() {
        super();
    }

    private static List e(Object obj, long j) {
        return (List) o0.M(obj, j);
    }

    @Override // com.google.android.gms.internal.clearcut.D
    final void a(Object obj, long j) {
        Object objUnmodifiableList;
        List list = (List) o0.M(obj, j);
        if (list instanceof Hl8) {
            objUnmodifiableList = ((Hl8) list).O1();
        } else if (c.isAssignableFrom(list.getClass())) {
            return;
        } else {
            objUnmodifiableList = Collections.unmodifiableList(list);
        }
        o0.i(obj, j, objUnmodifiableList);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.clearcut.D
    final void b(Object obj, Object obj2, long j) {
        C c2;
        List listE = e(obj2, j);
        int size = listE.size();
        List listE2 = e(obj, j);
        if (listE2.isEmpty()) {
            listE2 = listE2 instanceof Hl8 ? new C(size) : new ArrayList(size);
            o0.i(obj, j, listE2);
        } else {
            if (c.isAssignableFrom(listE2.getClass())) {
                ArrayList arrayList = new ArrayList(listE2.size() + size);
                arrayList.addAll(listE2);
                c2 = arrayList;
            } else if (listE2 instanceof Gn8) {
                C c3 = new C(listE2.size() + size);
                c3.addAll((Gn8) listE2);
                c2 = c3;
            }
            o0.i(obj, j, c2);
            listE2 = c2;
        }
        int size2 = listE2.size();
        int size3 = listE.size();
        if (size2 > 0 && size3 > 0) {
            listE2.addAll(listE);
        }
        if (size2 > 0) {
            listE = listE2;
        }
        o0.i(obj, j, listE);
    }
}
