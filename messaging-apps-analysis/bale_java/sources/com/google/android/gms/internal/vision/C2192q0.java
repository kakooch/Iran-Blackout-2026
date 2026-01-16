package com.google.android.gms.internal.vision;

import ir.nasim.Tq8;
import ir.nasim.Tr8;
import ir.nasim.Yq8;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* renamed from: com.google.android.gms.internal.vision.q0, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
final class C2192q0 extends AbstractC2190p0 {
    private static final Class c = Collections.unmodifiableList(Collections.emptyList()).getClass();

    private C2192q0() {
        super();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static List e(Object obj, long j, int i) {
        C2188o0 c2188o0;
        List listF = f(obj, j);
        if (listF.isEmpty()) {
            List c2188o02 = listF instanceof Yq8 ? new C2188o0(i) : ((listF instanceof L0) && (listF instanceof Tq8)) ? ((Tq8) listF).zza(i) : new ArrayList(i);
            i1.j(obj, j, c2188o02);
            return c2188o02;
        }
        if (c.isAssignableFrom(listF.getClass())) {
            ArrayList arrayList = new ArrayList(listF.size() + i);
            arrayList.addAll(listF);
            i1.j(obj, j, arrayList);
            c2188o0 = arrayList;
        } else {
            if (!(listF instanceof Tr8)) {
                if (!(listF instanceof L0) || !(listF instanceof Tq8)) {
                    return listF;
                }
                Tq8 tq8 = (Tq8) listF;
                if (tq8.zza()) {
                    return listF;
                }
                Tq8 tq8Zza = tq8.zza(listF.size() + i);
                i1.j(obj, j, tq8Zza);
                return tq8Zza;
            }
            C2188o0 c2188o03 = new C2188o0(listF.size() + i);
            c2188o03.addAll((Tr8) listF);
            i1.j(obj, j, c2188o03);
            c2188o0 = c2188o03;
        }
        return c2188o0;
    }

    private static List f(Object obj, long j) {
        return (List) i1.F(obj, j);
    }

    @Override // com.google.android.gms.internal.vision.AbstractC2190p0
    final void b(Object obj, Object obj2, long j) {
        List listF = f(obj2, j);
        List listE = e(obj, j, listF.size());
        int size = listE.size();
        int size2 = listF.size();
        if (size > 0 && size2 > 0) {
            listE.addAll(listF);
        }
        if (size > 0) {
            listF = listE;
        }
        i1.j(obj, j, listF);
    }

    @Override // com.google.android.gms.internal.vision.AbstractC2190p0
    final void d(Object obj, long j) {
        Object objUnmodifiableList;
        List list = (List) i1.F(obj, j);
        if (list instanceof Yq8) {
            objUnmodifiableList = ((Yq8) list).g();
        } else {
            if (c.isAssignableFrom(list.getClass())) {
                return;
            }
            if ((list instanceof L0) && (list instanceof Tq8)) {
                Tq8 tq8 = (Tq8) list;
                if (tq8.zza()) {
                    tq8.c();
                    return;
                }
                return;
            }
            objUnmodifiableList = Collections.unmodifiableList(list);
        }
        i1.j(obj, j, objUnmodifiableList);
    }
}
