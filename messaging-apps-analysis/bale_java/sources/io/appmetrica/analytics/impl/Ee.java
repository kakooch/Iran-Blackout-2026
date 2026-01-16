package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.parsing.JsonUtils;
import ir.nasim.AbstractC13042fc3;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class Ee implements N7 {
    public final String a;
    public final JSONObject b;
    public final boolean c;
    public final boolean d;
    public final M7 e;

    public Ee(String str, JSONObject jSONObject, boolean z, boolean z2, M7 m7) {
        this.a = str;
        this.b = jSONObject;
        this.c = z;
        this.d = z2;
        this.e = m7;
    }

    @Override // io.appmetrica.analytics.impl.N7
    public final M7 a() {
        return this.e;
    }

    public final JSONObject b() {
        if (!this.c) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("trackingId", this.a);
            if (this.b.length() <= 0) {
                return jSONObject;
            }
            jSONObject.put("additionalParams", this.b);
            return jSONObject;
        } catch (Throwable unused) {
            return jSONObject;
        }
    }

    public final JSONObject c() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("trackingId", this.a);
            jSONObject.put("additionalParams", this.b);
            jSONObject.put("wasSet", this.c);
            jSONObject.put("autoTracking", this.d);
            jSONObject.put("source", this.e.a);
        } catch (Throwable unused) {
        }
        return jSONObject;
    }

    public final String toString() {
        return "PreloadInfoState{trackingId='" + this.a + "', additionalParameters=" + this.b + ", wasSet=" + this.c + ", autoTrackingEnabled=" + this.d + ", source=" + this.e + '}';
    }

    public static Ee a(JSONObject jSONObject) {
        M7 m7;
        String strOptStringOrNull = JsonUtils.optStringOrNull(jSONObject, "trackingId");
        JSONObject jSONObjectOptJsonObjectOrDefault = JsonUtils.optJsonObjectOrDefault(jSONObject, "additionalParams", new JSONObject());
        int i = 0;
        boolean zOptBooleanOrDefault = JsonUtils.optBooleanOrDefault(jSONObject, "wasSet", false);
        boolean zOptBooleanOrDefault2 = JsonUtils.optBooleanOrDefault(jSONObject, "autoTracking", false);
        String strOptStringOrNull2 = JsonUtils.optStringOrNull(jSONObject, "source");
        M7[] m7ArrValues = M7.values();
        int length = m7ArrValues.length;
        while (true) {
            if (i >= length) {
                m7 = null;
                break;
            }
            m7 = m7ArrValues[i];
            if (AbstractC13042fc3.d(m7.a, strOptStringOrNull2)) {
                break;
            }
            i++;
        }
        return new Ee(strOptStringOrNull, jSONObjectOptJsonObjectOrDefault, zOptBooleanOrDefault, zOptBooleanOrDefault2, m7 == null ? M7.b : m7);
    }
}
