package com.google.android.gms.internal.vision;

import ir.nasim.Tq8;

/* renamed from: com.google.android.gms.internal.vision.t0, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
final class C2197t0 extends AbstractC2190p0 {
    private C2197t0() {
        super();
    }

    private static Tq8 e(Object obj, long j) {
        return (Tq8) i1.F(obj, j);
    }

    @Override // com.google.android.gms.internal.vision.AbstractC2190p0
    final void b(Object obj, Object obj2, long j) {
        Tq8 tq8E = e(obj, j);
        Tq8 tq8E2 = e(obj2, j);
        int size = tq8E.size();
        int size2 = tq8E2.size();
        if (size > 0 && size2 > 0) {
            if (!tq8E.zza()) {
                tq8E = tq8E.zza(size2 + size);
            }
            tq8E.addAll(tq8E2);
        }
        if (size > 0) {
            tq8E2 = tq8E;
        }
        i1.j(obj, j, tq8E2);
    }

    @Override // com.google.android.gms.internal.vision.AbstractC2190p0
    final void d(Object obj, long j) {
        e(obj, j).c();
    }
}
