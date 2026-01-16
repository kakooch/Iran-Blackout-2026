package io.appmetrica.analytics.impl;

import java.util.HashMap;

/* renamed from: io.appmetrica.analytics.impl.yb, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2993yb implements InterfaceC2649k2 {
    public final C2962x4 a;

    public C2993yb(C2962x4 c2962x4) {
        this.a = c2962x4;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC2649k2
    public final C2452bn a(Zm zm, C2452bn c2452bn) {
        int i = zm.b;
        int i2 = this.a.a;
        if (i == i2) {
            if (((C2452bn) ((HashMap) zm.a.get(c2452bn.b)).get(new String(c2452bn.a))) != null) {
                ((HashMap) zm.a.get(c2452bn.b)).put(new String(c2452bn.a), c2452bn);
            }
        } else if (i < i2) {
            ((HashMap) zm.a.get(c2452bn.b)).put(new String(c2452bn.a), c2452bn);
            zm.b++;
        }
        return c2452bn;
    }
}
