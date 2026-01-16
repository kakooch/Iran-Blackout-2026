package com.bumptech.glide.load.engine;

import ir.nasim.InterfaceC14373ho3;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
final class p {
    private final Map a = new HashMap();
    private final Map b = new HashMap();

    p() {
    }

    private Map b(boolean z) {
        return z ? this.b : this.a;
    }

    k a(InterfaceC14373ho3 interfaceC14373ho3, boolean z) {
        return (k) b(z).get(interfaceC14373ho3);
    }

    void c(InterfaceC14373ho3 interfaceC14373ho3, k kVar) {
        b(kVar.p()).put(interfaceC14373ho3, kVar);
    }

    void d(InterfaceC14373ho3 interfaceC14373ho3, k kVar) {
        Map mapB = b(kVar.p());
        if (kVar.equals(mapB.get(interfaceC14373ho3))) {
            mapB.remove(interfaceC14373ho3);
        }
    }
}
