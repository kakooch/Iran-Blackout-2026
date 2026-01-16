package io.appmetrica.analytics.impl;

import android.text.TextUtils;
import io.appmetrica.analytics.billinginterface.internal.config.BillingConfig;
import io.appmetrica.analytics.coreutils.internal.parsing.RemoteConfigJsonUtils;
import io.appmetrica.analytics.networktasks.internal.CommonUrlParts;
import io.appmetrica.analytics.networktasks.internal.RetryPolicyConfig;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class Xk {
    public final C2824ra a;
    public final Q9 b;
    public final Th c;
    public final Od d;
    public final Il e;
    public final C2793q2 f;
    public final C2961x3 g;
    public final C2745o2 h;
    public final Za i;
    public final Fl j;
    public final Sc k;
    public final C2967x9 l;

    public Xk() {
        this(new Za(), new C2824ra(), new Q9(), new Th(), new Od(), new Il(), new C2961x3(), new C2793q2(), new C2745o2(), new Fl(), new Sc(), new C2967x9());
    }

    public final void a(C2475cl c2475cl, Xa xa) {
        long jOptLong;
        long jOptLong2;
        String string;
        ArrayList arrayListA;
        JSONObject jSONObjectOptJSONObject;
        JSONObject jSONObjectOptJSONObject2;
        JSONObject jSONObjectOptJSONObject3;
        JSONObject jSONObjectOptJSONObject4 = xa.optJSONObject("queries");
        if (jSONObjectOptJSONObject4 != null && (jSONObjectOptJSONObject2 = jSONObjectOptJSONObject4.optJSONObject("list")) != null && (jSONObjectOptJSONObject3 = jSONObjectOptJSONObject2.optJSONObject("host")) != null) {
            c2475cl.g = jSONObjectOptJSONObject3.optString("url", null);
        }
        Object jSONObject = new JSONObject();
        try {
            jSONObject = xa.get("distribution_customization");
        } catch (Throwable unused) {
        }
        JSONObject jSONObjectOptJSONObject5 = ((JSONObject) jSONObject).optJSONObject("clids");
        if (jSONObjectOptJSONObject5 != null) {
            HashMap map = new HashMap();
            Iterator<String> itKeys = jSONObjectOptJSONObject5.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                JSONObject jSONObjectOptJSONObject6 = jSONObjectOptJSONObject5.optJSONObject(next);
                if (jSONObjectOptJSONObject6 != null && jSONObjectOptJSONObject6.has("value")) {
                    map.put(next, jSONObjectOptJSONObject6.getString("value"));
                }
            }
            c2475cl.j = Gl.a((Map) map);
        }
        JSONObject jSONObjectOptJSONObject7 = xa.optJSONObject(CommonUrlParts.LOCALE);
        String string2 = "";
        c2475cl.m = (jSONObjectOptJSONObject7 == null || (jSONObjectOptJSONObject = jSONObjectOptJSONObject7.optJSONObject("country")) == null || !jSONObjectOptJSONObject.optBoolean("reliable", false)) ? "" : jSONObjectOptJSONObject.optString("value", "");
        JSONObject jSONObjectOptJSONObject8 = xa.optJSONObject("time");
        if (jSONObjectOptJSONObject8 != null) {
            try {
                c2475cl.l = Long.valueOf(jSONObjectOptJSONObject8.getLong("max_valid_difference_seconds"));
            } catch (Throwable unused2) {
            }
        }
        C2955wl c2955wl = new C2955wl();
        JSONObject jSONObjectOptJSONObject9 = xa.optJSONObject("stat_sending");
        if (jSONObjectOptJSONObject9 != null) {
            c2955wl.a = RemoteConfigJsonUtils.extractMillisFromSecondsOrDefault(jSONObjectOptJSONObject9, "disabled_reporting_interval_seconds", c2955wl.a);
        }
        this.e.getClass();
        c2475cl.p = new Hl(c2955wl.a);
        this.b.getClass();
        C2859sl c2859sl = new C2859sl();
        try {
            Object jSONObject2 = new JSONObject();
            try {
                jSONObject2 = xa.get("features");
            } catch (Throwable unused3) {
            }
            JSONObject jSONObjectOptJSONObject10 = ((JSONObject) jSONObject2).optJSONObject("list");
            if (jSONObjectOptJSONObject10 != null) {
                C2890u4 c2890u4 = new C2890u4();
                c2890u4.a = Q9.a(jSONObjectOptJSONObject10, "permissions_collecting", c2859sl.a);
                c2890u4.b = Q9.a(jSONObjectOptJSONObject10, "features_collecting", c2859sl.b);
                c2890u4.c = Q9.a(jSONObjectOptJSONObject10, "google_aid", c2859sl.c);
                c2890u4.d = Q9.a(jSONObjectOptJSONObject10, "sim_info", c2859sl.d);
                c2890u4.e = Q9.a(jSONObjectOptJSONObject10, "huawei_oaid", c2859sl.e);
                c2890u4.f = jSONObjectOptJSONObject10.has("ssl_pinning") ? Boolean.valueOf(jSONObjectOptJSONObject10.getJSONObject("ssl_pinning").getBoolean("enabled")) : null;
                c2475cl.b = new C2938w4(c2890u4);
            }
        } catch (Throwable unused4) {
        }
        this.a.getClass();
        try {
            Object jSONObject3 = new JSONObject();
            try {
                jSONObject3 = xa.get("query_hosts");
            } catch (Throwable unused5) {
            }
            JSONObject jSONObjectOptJSONObject11 = ((JSONObject) jSONObject3).optJSONObject("list");
            if (jSONObjectOptJSONObject11 != null) {
                try {
                    string = jSONObjectOptJSONObject11.getJSONObject("get_ad").getJSONArray("urls").getString(0);
                } catch (Throwable unused6) {
                    string = "";
                }
                if (!TextUtils.isEmpty(string)) {
                    c2475cl.d = string;
                }
                ArrayList arrayListA2 = C2824ra.a(jSONObjectOptJSONObject11, "report");
                if (!hn.a((Collection) arrayListA2)) {
                    c2475cl.e = arrayListA2;
                }
                try {
                    string2 = jSONObjectOptJSONObject11.getJSONObject("report_ad").getJSONArray("urls").getString(0);
                } catch (Throwable unused7) {
                }
                if (!TextUtils.isEmpty(string2)) {
                    c2475cl.f = string2;
                }
                ArrayList arrayListA3 = C2824ra.a(jSONObjectOptJSONObject11, "startup");
                if (!hn.a((Collection) arrayListA3)) {
                    c2475cl.c = arrayListA3;
                }
                ArrayList arrayListA4 = C2824ra.a(jSONObjectOptJSONObject11, "diagnostic");
                if (!hn.a((Collection) arrayListA4)) {
                    c2475cl.n = arrayListA4;
                }
                HashMap map2 = new HashMap();
                Iterator<String> itKeys2 = jSONObjectOptJSONObject11.keys();
                while (itKeys2.hasNext()) {
                    String next2 = itKeys2.next();
                    if (!C2824ra.a.contains(next2) && (arrayListA = C2824ra.a(jSONObjectOptJSONObject11, next2)) != null) {
                        map2.put(next2, arrayListA);
                    }
                }
                c2475cl.o = map2;
            }
        } catch (Throwable unused8) {
        }
        this.c.getClass();
        C2979xl c2979xl = new C2979xl();
        JSONObject jSONObjectOptJSONObject12 = xa.optJSONObject("retry_policy");
        int iOptInt = c2979xl.w;
        int iOptInt2 = c2979xl.x;
        if (jSONObjectOptJSONObject12 != null) {
            iOptInt = jSONObjectOptJSONObject12.optInt("max_interval_seconds", iOptInt);
            iOptInt2 = jSONObjectOptJSONObject12.optInt("exponential_multiplier", c2979xl.x);
        }
        c2475cl.q = new RetryPolicyConfig(iOptInt, iOptInt2);
        this.d.getClass();
        if (c2475cl.b.a) {
            JSONObject jSONObjectOptJSONObject13 = xa.optJSONObject("permissions_collecting");
            C2907ul c2907ul = new C2907ul();
            if (jSONObjectOptJSONObject13 != null) {
                jOptLong = jSONObjectOptJSONObject13.optLong("check_interval_seconds", c2907ul.a);
                jOptLong2 = jSONObjectOptJSONObject13.optLong("force_send_interval_seconds", c2907ul.b);
            } else {
                jOptLong = c2907ul.a;
                jOptLong2 = c2907ul.b;
            }
            c2475cl.k = new Md(jOptLong, jOptLong2);
        }
        C2769p2 c2769p2 = this.f.a;
        C2764ol c2764ol = new C2764ol();
        JSONObject jSONObjectOptJSONObject14 = xa.optJSONObject("auto_inapp_collecting");
        if (jSONObjectOptJSONObject14 != null) {
            c2764ol.a = jSONObjectOptJSONObject14.optInt("send_frequency_seconds", c2764ol.a);
            c2764ol.b = jSONObjectOptJSONObject14.optInt("first_collecting_inapp_max_age_seconds", c2764ol.b);
        }
        c2769p2.getClass();
        c2475cl.r = new BillingConfig(c2764ol.a, c2764ol.b);
        C2961x3 c2961x3 = this.g;
        c2961x3.getClass();
        C2788pl c2788pl = new C2788pl();
        JSONObject jSONObjectOptJSONObject15 = xa.optJSONObject("cache_control");
        if (jSONObjectOptJSONObject15 != null) {
            c2788pl.a = RemoteConfigJsonUtils.extractMillisFromSecondsOrDefault(jSONObjectOptJSONObject15, "last_known_location_ttl", c2788pl.a);
        }
        c2961x3.a.getClass();
        c2475cl.s = new C2889u3(c2788pl.a);
        this.h.getClass();
        C2745o2.a(c2475cl, xa);
        Fl fl = this.j;
        fl.getClass();
        JSONObject jSONObjectOptJSONObject16 = xa.optJSONObject("startup_update");
        C2931vl c2931vl = new C2931vl();
        Integer numA = Ya.a(jSONObjectOptJSONObject16, "interval_seconds", null);
        if (numA != null) {
            c2931vl.a = numA.intValue();
        }
        fl.a.getClass();
        c2475cl.u = new Dl(c2931vl.a);
        Map<String, Fc> mapB = this.k.a.b();
        Rc rc = new Rc(xa);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<String, Fc> entry : mapB.entrySet()) {
            Object objInvoke = rc.invoke(entry);
            if (objInvoke != null) {
                linkedHashMap.put(entry.getKey(), objInvoke);
            }
        }
        c2475cl.v = linkedHashMap;
        C2943w9 c2943w9 = this.l.a;
        C2835rl c2835rl = new C2835rl();
        JSONObject jSONObjectOptJSONObject17 = xa.optJSONObject("external_attribution");
        if (jSONObjectOptJSONObject17 != null) {
            c2835rl.a = RemoteConfigJsonUtils.extractMillisFromSecondsOrDefault(jSONObjectOptJSONObject17, "collecting_interval_seconds", c2835rl.a);
        }
        c2943w9.getClass();
        c2475cl.w = new C2919v9(c2835rl.a);
    }

    public Xk(Za za, C2824ra c2824ra, Q9 q9, Th th, Od od, Il il, C2961x3 c2961x3, C2793q2 c2793q2, C2745o2 c2745o2, Fl fl, Sc sc, C2967x9 c2967x9) {
        this.a = c2824ra;
        this.b = q9;
        this.c = th;
        this.d = od;
        this.e = il;
        this.g = c2961x3;
        this.f = c2793q2;
        this.h = c2745o2;
        this.i = za;
        this.j = fl;
        this.k = sc;
        this.l = c2967x9;
    }
}
