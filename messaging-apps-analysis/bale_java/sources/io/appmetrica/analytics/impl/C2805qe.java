package io.appmetrica.analytics.impl;

import org.json.JSONObject;

/* renamed from: io.appmetrica.analytics.impl.qe, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2805qe {
    public final String a;
    public final JSONObject b;
    public final M7 c;

    public C2805qe(String str, JSONObject jSONObject, M7 m7) {
        this.a = str;
        this.b = jSONObject;
        this.c = m7;
    }

    public final String toString() {
        return "Candidate{trackingId='" + this.a + "', additionalParams=" + this.b + ", source=" + this.c + '}';
    }
}
