package io.appmetrica.analytics.impl;

import android.gov.nist.javax.sip.header.ParameterNames;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class L9 {
    public final String a;
    public final int b;
    public final boolean c;

    public L9(JSONObject jSONObject) {
        this.a = jSONObject.getString("name");
        this.c = jSONObject.getBoolean(ParameterNames.REQUIRED);
        this.b = jSONObject.optInt(ParameterNames.VERSION, -1);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || L9.class != obj.getClass()) {
            return false;
        }
        L9 l9 = (L9) obj;
        if (this.b != l9.b || this.c != l9.c) {
            return false;
        }
        String str = this.a;
        String str2 = l9.a;
        return str != null ? str.equals(str2) : str2 == null;
    }

    public final int hashCode() {
        String str = this.a;
        return ((((str != null ? str.hashCode() : 0) * 31) + this.b) * 31) + (this.c ? 1 : 0);
    }

    public L9(String str, int i, boolean z) {
        this.a = str;
        this.b = i;
        this.c = z;
    }
}
