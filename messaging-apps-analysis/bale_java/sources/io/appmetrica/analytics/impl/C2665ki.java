package io.appmetrica.analytics.impl;

import org.json.JSONObject;

/* renamed from: io.appmetrica.analytics.impl.ki, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2665ki extends AbstractC2568gg {
    public final He b;

    public C2665ki(C2484d5 c2484d5) {
        this(c2484d5, C2586ha.h().q());
    }

    @Override // io.appmetrica.analytics.impl.AbstractC2568gg
    public final boolean a(Q5 q5) {
        JSONObject jSONObjectOptJSONObject;
        try {
            jSONObjectOptJSONObject = new JSONObject(q5.getValue()).optJSONObject("preloadInfo");
        } catch (Throwable unused) {
            jSONObjectOptJSONObject = null;
        }
        this.b.b(Ee.a(jSONObjectOptJSONObject));
        return false;
    }

    public C2665ki(C2484d5 c2484d5, He he) {
        super(c2484d5);
        this.b = he;
    }
}
