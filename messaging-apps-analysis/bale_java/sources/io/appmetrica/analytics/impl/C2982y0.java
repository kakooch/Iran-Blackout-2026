package io.appmetrica.analytics.impl;

import android.util.Base64;
import io.appmetrica.analytics.coreutils.internal.parsing.JsonUtils;
import io.appmetrica.analytics.internal.CounterConfigurationReporterType;
import ir.nasim.C12275eL0;
import org.json.JSONObject;

/* renamed from: io.appmetrica.analytics.impl.y0, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2982y0 {
    public static String a(C2958x0 c2958x0) {
        try {
            return Base64.encodeToString(new JSONObject().put("apiKey", c2958x0.a).put("packageName", c2958x0.b).put("reporterType", c2958x0.c.getStringValue()).put("processID", c2958x0.d).put("processSessionID", c2958x0.e).put("errorEnvironment", c2958x0.f).toString().getBytes(C12275eL0.b), 0);
        } catch (Throwable unused) {
            return "";
        }
    }

    public static C2958x0 a(String str) {
        try {
            JSONObject jSONObject = new JSONObject(new String(Base64.decode(str, 0), C12275eL0.b));
            return new C2958x0(jSONObject.getString("apiKey"), jSONObject.getString("packageName"), CounterConfigurationReporterType.INSTANCE.fromStringValue(jSONObject.getString("reporterType")), jSONObject.getInt("processID"), jSONObject.getString("processSessionID"), JsonUtils.optStringOrNull(jSONObject, "errorEnvironment"));
        } catch (Throwable unused) {
            return null;
        }
    }
}
