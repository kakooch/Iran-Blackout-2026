package com.google.android.gms.internal.clearcut;

import ir.nasim.InterfaceC25120zl8;

/* loaded from: classes3.dex */
final class G extends D {
    private G() {
        super();
    }

    private static InterfaceC25120zl8 e(Object obj, long j) {
        return (InterfaceC25120zl8) o0.M(obj, j);
    }

    @Override // com.google.android.gms.internal.clearcut.D
    final void a(Object obj, long j) {
        e(obj, j).H();
    }

    @Override // com.google.android.gms.internal.clearcut.D
    final void b(Object obj, Object obj2, long j) {
        InterfaceC25120zl8 interfaceC25120zl8E = e(obj, j);
        InterfaceC25120zl8 interfaceC25120zl8E2 = e(obj2, j);
        int size = interfaceC25120zl8E.size();
        int size2 = interfaceC25120zl8E2.size();
        if (size > 0 && size2 > 0) {
            if (!interfaceC25120zl8E.G()) {
                interfaceC25120zl8E = interfaceC25120zl8E.z0(size2 + size);
            }
            interfaceC25120zl8E.addAll(interfaceC25120zl8E2);
        }
        if (size > 0) {
            interfaceC25120zl8E2 = interfaceC25120zl8E;
        }
        o0.i(obj, j, interfaceC25120zl8E2);
    }
}
