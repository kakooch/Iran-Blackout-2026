package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.IReporter;
import java.util.HashMap;

/* renamed from: io.appmetrica.analytics.impl.mg, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2711mg extends AbstractC2568gg {
    public final IReporter b;

    public C2711mg(C2484d5 c2484d5, IReporter iReporter) {
        super(c2484d5);
        this.b = iReporter;
    }

    @Override // io.appmetrica.analytics.impl.AbstractC2568gg
    public final boolean a(Q5 q5) {
        C2779pc c2779pc = (C2779pc) C2779pc.c.get(q5.d);
        HashMap map = new HashMap();
        map.put("type", c2779pc.a);
        map.put("delivery_method", c2779pc.b);
        this.b.reportEvent("crash_saved", map);
        return false;
    }
}
