package io.appmetrica.analytics.impl;

import android.text.TextUtils;
import java.util.LinkedList;
import java.util.List;

/* loaded from: classes3.dex */
public final class nn implements on {
    @Override // io.appmetrica.analytics.impl.on
    public final mn a(List<mn> list) {
        LinkedList linkedList = new LinkedList();
        boolean z = true;
        for (mn mnVar : list) {
            if (!mnVar.a) {
                linkedList.add(mnVar.b);
                z = false;
            }
        }
        return z ? new mn(this, true, "") : new mn(this, false, TextUtils.join(", ", linkedList));
    }
}
