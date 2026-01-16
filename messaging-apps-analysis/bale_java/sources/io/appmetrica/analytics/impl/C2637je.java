package io.appmetrica.analytics.impl;

import android.text.TextUtils;
import io.appmetrica.analytics.AppMetricaConfig;
import io.appmetrica.analytics.coreapi.internal.identifiers.IdentifierStatus;
import io.appmetrica.analytics.coreapi.internal.model.ScreenInfo;
import io.appmetrica.analytics.coreutils.internal.parsing.JsonUtils;
import io.appmetrica.analytics.internal.IdentifiersResult;
import java.util.Collection;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: io.appmetrica.analytics.impl.je, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2637je extends AbstractC2685le {
    public static final C2709me d = new C2709me("UUID_RESULT", null);
    public static final C2709me e = new C2709me("DEVICE_ID_RESULT", null);
    public static final C2709me f = new C2709me("DEVICE_ID_HASH_RESULT", null);
    public static final C2709me g = new C2709me("AD_URL_GET_RESULT", null);
    public static final C2709me h = new C2709me("AD_URL_REPORT_RESULT", null);
    public static final C2709me i = new C2709me("CUSTOM_HOSTS", null);
    public static final C2709me j = new C2709me("SERVER_TIME_OFFSET", null);
    public static final C2709me k = new C2709me("RESPONSE_CLIDS_RESULT", null);
    public static final C2709me l = new C2709me("CUSTOM_SDK_HOSTS", null);
    public static final C2709me m = new C2709me("CLIENT_CLIDS", null);
    public static final C2709me n = new C2709me("DEFERRED_DEEP_LINK_WAS_CHECKED", null);
    public static final C2709me o = new C2709me("API_LEVEL", null);
    public static final C2709me p = new C2709me("NEXT_STARTUP_TIME", null);
    public static final C2709me q = new C2709me("GAID", null);
    public static final C2709me r = new C2709me("HOAID", null);
    public static final C2709me s = new C2709me("YANDEX_ADV_ID", null);
    public static final C2709me t = new C2709me("CLIENT_CLIDS_CHANGED_AFTER_LAST_IDENTIFIERS_UPDATE", null);
    public static final C2709me u = new C2709me("SCREEN_INFO", null);
    public static final C2709me v = new C2709me("SCREEN_SIZE_CHECKED_BY_DEPRECATED", null);
    public static final C2709me w = new C2709me("FEATURES", null);
    public static final C2709me x = new C2709me("APPMETRICA_CLIENT_CONFIG", null);

    public C2637je(Ba ba) {
        super(ba);
    }

    public final boolean a(boolean z) {
        return this.a.getBoolean(t.b, z);
    }

    public final long b(long j2) {
        return this.a.getLong(j.a, j2);
    }

    public final C2637je c(IdentifiersResult identifiersResult) {
        return a(l.b, identifiersResult);
    }

    public final IdentifiersResult d() {
        return e(g.b);
    }

    public final IdentifiersResult e() {
        return e(h.b);
    }

    public final C2637je f(IdentifiersResult identifiersResult) {
        return a(q.b, identifiersResult);
    }

    public final List<String> g() {
        String string = this.a.getString(i.b, null);
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        return Ya.b(string);
    }

    public final IdentifiersResult h() {
        return e(l.b);
    }

    public final IdentifiersResult i() {
        return e(f.b);
    }

    public final IdentifiersResult j() {
        return e(e.b);
    }

    public final P9 k() {
        String string = this.a.getString(w.b, null);
        try {
            if (!TextUtils.isEmpty(string)) {
                JSONObject jSONObject = new JSONObject(string);
                return new P9(JsonUtils.optBooleanOrNull(jSONObject, "libSslEnabled"), IdentifierStatus.from(JsonUtils.optStringOrNull(jSONObject, "STATUS")), JsonUtils.optStringOrNull(jSONObject, "ERROR_EXPLANATION"));
            }
        } catch (Throwable unused) {
        }
        return new P9(null, IdentifierStatus.UNKNOWN, null);
    }

    public final IdentifiersResult l() {
        return e(q.b);
    }

    public final IdentifiersResult m() {
        return e(r.b);
    }

    public final long n() {
        return this.a.getLong(p.b, 0L);
    }

    public final IdentifiersResult o() {
        return e(k.b);
    }

    public final ScreenInfo p() {
        return Ya.e(this.a.getString(u.b, null));
    }

    public final IdentifiersResult q() {
        return e(d.b);
    }

    public final IdentifiersResult r() {
        return e(s.b);
    }

    public final boolean s() {
        return this.a.getBoolean(n.b, false);
    }

    public final boolean t() {
        return this.a.getBoolean(v.b, false);
    }

    public final C2637je u() {
        return (C2637je) b(n.b, true);
    }

    public final void v() {
        b(v.b, true);
    }

    public final long a(long j2) {
        return this.a.getLong(o.b, j2);
    }

    public final C2637je b(IdentifiersResult identifiersResult) {
        return a(h.b, identifiersResult);
    }

    public final C2637je c(long j2) {
        return (C2637je) b(o.b, j2);
    }

    public final C2637je d(IdentifiersResult identifiersResult) {
        return a(f.b, identifiersResult);
    }

    public final IdentifiersResult e(String str) {
        IdentifiersResult identifiersResult;
        String string;
        try {
            string = this.a.getString(str, null);
        } catch (Throwable unused) {
        }
        if (string != null) {
            JSONObject jSONObject = new JSONObject(string);
            identifiersResult = new IdentifiersResult(JsonUtils.optStringOrNull(jSONObject, "ID"), IdentifierStatus.from(JsonUtils.optStringOrNull(jSONObject, "STATUS")), JsonUtils.optStringOrNull(jSONObject, "ERROR_EXPLANATION"));
        } else {
            identifiersResult = null;
        }
        return identifiersResult == null ? new IdentifiersResult(null, IdentifierStatus.UNKNOWN, "no identifier in preferences") : identifiersResult;
    }

    public final String f(String str) {
        return this.a.getString(m.b, str);
    }

    public final C2637je h(IdentifiersResult identifiersResult) {
        return a(k.b, identifiersResult);
    }

    public final C2637je i(IdentifiersResult identifiersResult) {
        return a(d.b, identifiersResult);
    }

    public final C2637je j(IdentifiersResult identifiersResult) {
        return a(s.b, identifiersResult);
    }

    public final C2637je g(IdentifiersResult identifiersResult) {
        return a(r.b, identifiersResult);
    }

    public final C2637je a(IdentifiersResult identifiersResult) {
        return a(g.b, identifiersResult);
    }

    public final C2637je b(boolean z) {
        return (C2637je) b(t.b, z);
    }

    public final C2637je d(long j2) {
        return (C2637je) b(p.b, j2);
    }

    public final AppMetricaConfig f() {
        String string = this.a.getString(x.b, null);
        if (string == null) {
            return null;
        }
        return AppMetricaConfig.fromJson(string);
    }

    public final C2637je h(String str) {
        return (C2637je) d(new C2709me(str, null).b);
    }

    public final C2637je g(String str) {
        return (C2637je) b(m.b, str);
    }

    public final C2637je a(List<String> list) {
        return (C2637je) b(i.b, hn.a((Collection) list) ? null : new JSONArray((Collection) list).toString());
    }

    public final C2637je e(IdentifiersResult identifiersResult) {
        return a(e.b, identifiersResult);
    }

    public final C2637je e(long j2) {
        return (C2637je) b(j.b, j2);
    }

    public final C2637je a(P9 p9) {
        String str = w.b;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("libSslEnabled", p9.a).put("STATUS", p9.b.getValue()).putOpt("ERROR_EXPLANATION", p9.c);
        } catch (Throwable unused) {
        }
        return (C2637je) b(str, jSONObject.toString());
    }

    public final void a(ScreenInfo screenInfo) {
        b(u.b, Ya.a(screenInfo));
    }

    public final void a(AppMetricaConfig appMetricaConfig) {
        b(x.b, appMetricaConfig.toJson());
    }

    public final C2637je a(String str, IdentifiersResult identifiersResult) {
        String string;
        if (identifiersResult != null) {
            try {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("ID", identifiersResult.id).put("STATUS", identifiersResult.status.getValue()).put("ERROR_EXPLANATION", identifiersResult.errorExplanation);
                } catch (Throwable unused) {
                }
                string = jSONObject.toString();
            } catch (Throwable unused2) {
            }
        } else {
            string = null;
        }
        if (string != null) {
            b(str, string);
        }
        return this;
    }
}
