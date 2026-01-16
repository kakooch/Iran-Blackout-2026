package com.google.android.gms.internal.measurement;

import ir.nasim.AbstractC18350oW3;
import java.util.Iterator;
import java.util.Map;

/* renamed from: com.google.android.gms.internal.measurement.b1, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
final class C2107b1 {
    C2107b1() {
    }

    public static final int a(int i, Object obj, Object obj2) {
        C2104a1 c2104a1 = (C2104a1) obj;
        AbstractC18350oW3.a(obj2);
        if (c2104a1.isEmpty()) {
            return 0;
        }
        Iterator it = c2104a1.entrySet().iterator();
        if (!it.hasNext()) {
            return 0;
        }
        Map.Entry entry = (Map.Entry) it.next();
        entry.getKey();
        entry.getValue();
        throw null;
    }

    public static final Object b(Object obj, Object obj2) {
        C2104a1 c2104a1C = (C2104a1) obj;
        C2104a1 c2104a1 = (C2104a1) obj2;
        if (!c2104a1.isEmpty()) {
            if (!c2104a1C.f()) {
                c2104a1C = c2104a1C.c();
            }
            c2104a1C.e(c2104a1);
        }
        return c2104a1C;
    }
}
