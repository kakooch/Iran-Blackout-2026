package com.google.android.gms.internal.measurement;

import ir.nasim.Ar8;
import ir.nasim.InterfaceC20943sr8;

/* loaded from: classes3.dex */
final class U0 extends V0 {
    /* synthetic */ U0(Ar8 ar8) {
        super(null);
    }

    @Override // com.google.android.gms.internal.measurement.V0
    final void a(Object obj, long j) {
        ((InterfaceC20943sr8) z1.k(obj, j)).c();
    }

    @Override // com.google.android.gms.internal.measurement.V0
    final void b(Object obj, Object obj2, long j) {
        InterfaceC20943sr8 interfaceC20943sr8K = (InterfaceC20943sr8) z1.k(obj, j);
        InterfaceC20943sr8 interfaceC20943sr8 = (InterfaceC20943sr8) z1.k(obj2, j);
        int size = interfaceC20943sr8K.size();
        int size2 = interfaceC20943sr8.size();
        if (size > 0 && size2 > 0) {
            if (!interfaceC20943sr8K.e()) {
                interfaceC20943sr8K = interfaceC20943sr8K.K(size2 + size);
            }
            interfaceC20943sr8K.addAll(interfaceC20943sr8);
        }
        if (size > 0) {
            interfaceC20943sr8 = interfaceC20943sr8K;
        }
        z1.x(obj, j, interfaceC20943sr8);
    }
}
