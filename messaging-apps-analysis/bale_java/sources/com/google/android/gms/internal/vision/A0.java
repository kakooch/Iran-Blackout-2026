package com.google.android.gms.internal.vision;

import ir.nasim.AbstractC18350oW3;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes3.dex */
final class A0 implements B0 {
    A0() {
    }

    @Override // com.google.android.gms.internal.vision.B0
    public final Map a(Object obj) {
        return (C2207y0) obj;
    }

    @Override // com.google.android.gms.internal.vision.B0
    public final boolean b(Object obj) {
        return !((C2207y0) obj).k();
    }

    @Override // com.google.android.gms.internal.vision.B0
    public final Object c(Object obj, Object obj2) {
        C2207y0 c2207y0E = (C2207y0) obj;
        C2207y0 c2207y0 = (C2207y0) obj2;
        if (!c2207y0.isEmpty()) {
            if (!c2207y0E.k()) {
                c2207y0E = c2207y0E.e();
            }
            c2207y0E.d(c2207y0);
        }
        return c2207y0E;
    }

    @Override // com.google.android.gms.internal.vision.B0
    public final Object d(Object obj) {
        ((C2207y0) obj).f();
        return obj;
    }

    @Override // com.google.android.gms.internal.vision.B0
    public final int e(int i, Object obj, Object obj2) {
        C2207y0 c2207y0 = (C2207y0) obj;
        AbstractC18350oW3.a(obj2);
        if (c2207y0.isEmpty()) {
            return 0;
        }
        Iterator it = c2207y0.entrySet().iterator();
        if (!it.hasNext()) {
            return 0;
        }
        Map.Entry entry = (Map.Entry) it.next();
        entry.getKey();
        entry.getValue();
        throw new NoSuchMethodError();
    }

    @Override // com.google.android.gms.internal.vision.B0
    public final Map h(Object obj) {
        return (C2207y0) obj;
    }

    @Override // com.google.android.gms.internal.vision.B0
    public final AbstractC2209z0 i(Object obj) {
        AbstractC18350oW3.a(obj);
        throw new NoSuchMethodError();
    }

    @Override // com.google.android.gms.internal.vision.B0
    public final Object j(Object obj) {
        return C2207y0.c().e();
    }
}
