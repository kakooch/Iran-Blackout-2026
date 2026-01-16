package io.appmetrica.analytics.impl;

import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class N8 {
    public final tn a;

    public N8(tn tnVar) {
        this.a = tnVar;
    }

    public final void a(int i, long j) throws JSONException {
        JSONObject jSONObjectOptJSONObject;
        tn tnVar = this.a;
        synchronized (tnVar) {
            jSONObjectOptJSONObject = tnVar.a.a().optJSONObject("numbers_of_type");
        }
        if (jSONObjectOptJSONObject == null) {
            jSONObjectOptJSONObject = new JSONObject();
        }
        jSONObjectOptJSONObject.put(String.valueOf(i), j);
        this.a.a(jSONObjectOptJSONObject);
    }
}
