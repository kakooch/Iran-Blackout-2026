package com.google.android.gms.internal.measurement;

import ir.nasim.AbstractC24586yr8;
import ir.nasim.C20953ss8;
import ir.nasim.InterfaceC20943sr8;
import ir.nasim.InterfaceC23996xr8;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes3.dex */
final class T0 extends V0 {
    private static final Class c = Collections.unmodifiableList(Collections.emptyList()).getClass();

    /* synthetic */ T0(AbstractC24586yr8 abstractC24586yr8) {
        super(null);
    }

    @Override // com.google.android.gms.internal.measurement.V0
    final void a(Object obj, long j) {
        Object objUnmodifiableList;
        List list = (List) z1.k(obj, j);
        if (list instanceof InterfaceC23996xr8) {
            objUnmodifiableList = ((InterfaceC23996xr8) list).g();
        } else {
            if (c.isAssignableFrom(list.getClass())) {
                return;
            }
            if ((list instanceof k1) && (list instanceof InterfaceC20943sr8)) {
                InterfaceC20943sr8 interfaceC20943sr8 = (InterfaceC20943sr8) list;
                if (interfaceC20943sr8.e()) {
                    interfaceC20943sr8.c();
                    return;
                }
                return;
            }
            objUnmodifiableList = Collections.unmodifiableList(list);
        }
        z1.x(obj, j, objUnmodifiableList);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.measurement.V0
    final void b(Object obj, Object obj2, long j) {
        S0 s0;
        List list = (List) z1.k(obj2, j);
        int size = list.size();
        List listK = (List) z1.k(obj, j);
        if (listK.isEmpty()) {
            listK = listK instanceof InterfaceC23996xr8 ? new S0(size) : ((listK instanceof k1) && (listK instanceof InterfaceC20943sr8)) ? ((InterfaceC20943sr8) listK).K(size) : new ArrayList(size);
            z1.x(obj, j, listK);
        } else {
            if (c.isAssignableFrom(listK.getClass())) {
                ArrayList arrayList = new ArrayList(listK.size() + size);
                arrayList.addAll(listK);
                z1.x(obj, j, arrayList);
                s0 = arrayList;
            } else if (listK instanceof C20953ss8) {
                S0 s02 = new S0(listK.size() + size);
                s02.addAll(s02.size(), (C20953ss8) listK);
                z1.x(obj, j, s02);
                s0 = s02;
            } else if ((listK instanceof k1) && (listK instanceof InterfaceC20943sr8)) {
                InterfaceC20943sr8 interfaceC20943sr8 = (InterfaceC20943sr8) listK;
                if (!interfaceC20943sr8.e()) {
                    listK = interfaceC20943sr8.K(listK.size() + size);
                    z1.x(obj, j, listK);
                }
            }
            listK = s0;
        }
        int size2 = listK.size();
        int size3 = list.size();
        if (size2 > 0 && size3 > 0) {
            listK.addAll(list);
        }
        if (size2 > 0) {
            list = listK;
        }
        z1.x(obj, j, list);
    }
}
