package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.Revenue;
import java.util.Arrays;
import java.util.List;

/* renamed from: io.appmetrica.analytics.impl.bi, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2447bi implements on {
    public final nn a = new nn();

    @Override // io.appmetrica.analytics.impl.on
    public final mn a(Revenue revenue) {
        mn mnVar;
        nn nnVar = this.a;
        C2543ff c2543ff = new C2543ff();
        Integer num = revenue.quantity;
        if (num == null || num.intValue() > 0) {
            mnVar = new mn(c2543ff, true, "");
        } else {
            mnVar = new mn(c2543ff, false, "Invalid quantity value " + num);
        }
        List<mn> listAsList = Arrays.asList(mnVar);
        nnVar.getClass();
        return nnVar.a(listAsList);
    }
}
