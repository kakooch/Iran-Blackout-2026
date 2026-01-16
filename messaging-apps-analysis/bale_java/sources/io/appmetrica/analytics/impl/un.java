package io.appmetrica.analytics.impl;

import ir.nasim.AbstractC13042fc3;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class un {
    public final xn a;
    public final xn b;
    public final vn c;
    public JSONObject d;

    public un(xn xnVar, xn xnVar2, vn vnVar) {
        this.a = xnVar;
        this.b = xnVar2;
        this.c = vnVar;
    }

    public final synchronized JSONObject a() {
        JSONObject jSONObject;
        try {
            if (this.d == null) {
                JSONObject jSONObjectA = this.c.a(a(this.a), a(this.b));
                this.d = jSONObjectA;
                a(jSONObjectA);
            }
            jSONObject = this.d;
            if (jSONObject == null) {
                AbstractC13042fc3.y("fileContents");
                jSONObject = null;
            }
        } catch (Throwable th) {
            throw th;
        }
        return jSONObject;
    }

    public static JSONObject a(xn xnVar) {
        try {
            String strA = xnVar.a();
            return strA != null ? new JSONObject(strA) : new JSONObject();
        } catch (Throwable unused) {
            return new JSONObject();
        }
    }

    public final synchronized void a(JSONObject jSONObject) {
        String string = jSONObject.toString();
        try {
            this.a.a(string);
        } catch (Throwable unused) {
        }
        try {
            this.b.a(string);
        } catch (Throwable unused2) {
        }
    }
}
