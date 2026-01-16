package com.google.ads.interactivemedia.v3.internal;

import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public final class f {
    private final m a;
    private final m b;
    private final j c;
    private final l d;

    private f(j jVar, l lVar, m mVar, m mVar2) {
        this.c = jVar;
        this.d = lVar;
        this.a = mVar;
        if (mVar2 == null) {
            this.b = m.NONE;
        } else {
            this.b = mVar2;
        }
    }

    public static f b(j jVar, l lVar, m mVar, m mVar2) {
        ih.b(jVar, "CreativeType is null");
        ih.b(lVar, "ImpressionType is null");
        ih.b(mVar, "Impression owner is null");
        if (mVar == m.NONE) {
            throw new IllegalArgumentException("Impression owner is none");
        }
        if (jVar == j.DEFINED_BY_JAVASCRIPT && mVar == m.NATIVE) {
            throw new IllegalArgumentException("ImpressionType/CreativeType can only be defined as DEFINED_BY_JAVASCRIPT if Impression Owner is JavaScript");
        }
        if (lVar == l.DEFINED_BY_JAVASCRIPT && mVar == m.NATIVE) {
            throw new IllegalArgumentException("ImpressionType/CreativeType can only be defined as DEFINED_BY_JAVASCRIPT if Impression Owner is JavaScript");
        }
        return new f(jVar, lVar, mVar, mVar2);
    }

    public final JSONObject a() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        ah.d(jSONObject, "impressionOwner", this.a);
        if (this.c == null || this.d == null) {
            ah.d(jSONObject, "videoEventsOwner", this.b);
        } else {
            ah.d(jSONObject, "mediaEventsOwner", this.b);
            ah.d(jSONObject, "creativeType", this.c);
            ah.d(jSONObject, "impressionType", this.d);
        }
        ah.d(jSONObject, "isolateVerificationScripts", Boolean.TRUE);
        return jSONObject;
    }
}
