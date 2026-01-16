package io.appmetrica.analytics.impl;

import android.util.Base64;
import io.appmetrica.analytics.coreutils.internal.parsing.JsonUtils;
import io.appmetrica.analytics.internal.CounterConfiguration;
import io.appmetrica.analytics.internal.CounterConfigurationReporterType;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: io.appmetrica.analytics.impl.bb, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2440bb {
    public final byte[] a;
    public final String b;
    public final int c;
    public final HashMap d;
    public final String e;
    public final Integer f;
    public final String g;
    public final String h;
    public final CounterConfigurationReporterType i;
    public final String j;

    public C2440bb(String str) throws JSONException {
        JSONObject jSONObject = new JSONObject(str);
        JSONObject jSONObject2 = jSONObject.getJSONObject("event");
        this.a = Base64.decode(jSONObject2.getString("jvm_crash"), 0);
        this.b = jSONObject2.getString("name");
        this.c = jSONObject2.getInt("bytes_truncated");
        this.j = JsonUtils.optStringOrNull(jSONObject2, "environment");
        String strOptString = jSONObject2.optString("trimmed_fields");
        this.d = new HashMap();
        if (strOptString != null) {
            try {
                HashMap mapC = Ya.c(strOptString);
                if (mapC != null) {
                    for (Map.Entry entry : mapC.entrySet()) {
                        this.d.put(EnumC2408a4.valueOf((String) entry.getKey()), Integer.valueOf(Integer.parseInt((String) entry.getValue())));
                    }
                }
            } catch (Throwable unused) {
            }
        }
        JSONObject jSONObject3 = jSONObject.getJSONObject("process_configuration");
        this.e = jSONObject3.getString("package_name");
        this.f = Integer.valueOf(jSONObject3.getInt("pid"));
        this.g = jSONObject3.getString("psid");
        JSONObject jSONObject4 = jSONObject.getJSONObject("reporter_configuration");
        this.h = jSONObject4.getString("api_key");
        this.i = a(jSONObject4);
    }

    public final String a() {
        return this.h;
    }

    public final int b() {
        return this.c;
    }

    public final byte[] c() {
        return this.a;
    }

    public final String d() {
        return this.j;
    }

    public final String e() {
        return this.b;
    }

    public final String f() {
        return this.e;
    }

    public final Integer g() {
        return this.f;
    }

    public final String h() {
        return this.g;
    }

    public final CounterConfigurationReporterType i() {
        return this.i;
    }

    public final HashMap<EnumC2408a4, Integer> j() {
        return this.d;
    }

    public final String k() {
        HashMap map = new HashMap();
        for (Map.Entry entry : this.d.entrySet()) {
            map.put(((EnumC2408a4) entry.getKey()).name(), (Integer) entry.getValue());
        }
        return new JSONObject().put("process_configuration", new JSONObject().put("pid", this.f).put("psid", this.g).put("package_name", this.e)).put("reporter_configuration", new JSONObject().put("api_key", this.h).put("reporter_type", this.i.getStringValue())).put("event", new JSONObject().put("jvm_crash", Base64.encodeToString(this.a, 0)).put("name", this.b).put("bytes_truncated", this.c).put("trimmed_fields", Ya.b(map)).putOpt("environment", this.j)).toString();
    }

    public static CounterConfigurationReporterType a(JSONObject jSONObject) {
        return jSONObject.has("reporter_type") ? CounterConfigurationReporterType.fromStringValue(jSONObject.getString("reporter_type")) : CounterConfigurationReporterType.MAIN;
    }

    public C2440bb(Q5 q5, Y3 y3, HashMap<EnumC2408a4, Integer> map) {
        this.a = q5.getValueBytes();
        this.b = q5.getName();
        this.c = q5.getBytesTruncated();
        if (map != null) {
            this.d = map;
        } else {
            this.d = new HashMap();
        }
        Oe oeA = y3.a();
        this.e = oeA.f();
        this.f = oeA.g();
        this.g = oeA.h();
        CounterConfiguration counterConfigurationB = y3.b();
        this.h = counterConfigurationB.getApiKey();
        this.i = counterConfigurationB.getReporterType();
        this.j = q5.f();
    }
}
