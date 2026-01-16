package io.appmetrica.analytics;

import io.appmetrica.analytics.impl.Ad;
import io.appmetrica.analytics.impl.C2635jc;
import io.appmetrica.analytics.impl.C2947wd;
import io.appmetrica.analytics.impl.D9;
import io.appmetrica.analytics.impl.Wa;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class ExternalAttributions {
    public static ExternalAttribution adjust(Object obj) {
        return obj == null ? new C2947wd(D9.ADJUST) : new Ad(D9.ADJUST, obj);
    }

    public static ExternalAttribution airbridge(Map<String, String> map) {
        return map == null ? new C2947wd(D9.AIRBRIDGE) : new C2635jc(D9.AIRBRIDGE, map);
    }

    public static ExternalAttribution appsflyer(Map<String, Object> map) {
        return map == null ? new C2947wd(D9.APPSFLYER) : new C2635jc(D9.APPSFLYER, map);
    }

    public static ExternalAttribution kochava(JSONObject jSONObject) {
        return jSONObject == null ? new C2947wd(D9.KOCHAVA) : new Wa(D9.KOCHAVA, jSONObject);
    }

    public static ExternalAttribution singular(Map<String, Object> map) {
        return map == null ? new C2947wd(D9.SINGULAR) : new C2635jc(D9.SINGULAR, map);
    }

    public static ExternalAttribution tenjin(Map<String, String> map) {
        return map == null ? new C2947wd(D9.TENJIN) : new C2635jc(D9.TENJIN, map);
    }
}
