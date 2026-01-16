package io.appmetrica.analytics.impl;

/* loaded from: classes3.dex */
public final class O2 implements on {
    @Override // io.appmetrica.analytics.impl.on
    public final mn a(Object obj) {
        C2452bn[] c2452bnArr = ((en) obj).a;
        return (c2452bnArr == null || c2452bnArr.length == 0) ? new mn(this, false, "attributes list is empty") : new mn(this, true, "");
    }
}
