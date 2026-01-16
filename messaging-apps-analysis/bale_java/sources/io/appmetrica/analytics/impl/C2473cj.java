package io.appmetrica.analytics.impl;

import java.util.Map;

/* renamed from: io.appmetrica.analytics.impl.cj, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2473cj implements Ka {
    public final /* synthetic */ String a;
    public final /* synthetic */ Map b;

    public C2473cj(String str, Map map) {
        this.a = str;
        this.b = map;
    }

    @Override // io.appmetrica.analytics.impl.Ka
    public final void a(La la) {
        la.reportEvent(this.a, this.b);
    }
}
