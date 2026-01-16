package io.appmetrica.analytics.impl;

import java.util.HashMap;

/* renamed from: io.appmetrica.analytics.impl.yd, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2995yd {
    public final HashMap a;

    public C2995yd() {
        HashMap map = new HashMap();
        this.a = map;
        map.put("google_aid", "g");
        map.put("huawei_oaid", "h");
        map.put("sim_info", "si");
        map.put("features_collecting", "fc");
        map.put("permissions_collecting", "pc");
        map.put("retry_policy", "rp");
        map.put("cache_control", "cc");
        map.put("auto_inapp_collecting", "aic");
        map.put("attribution", "at");
        map.put("startup_update", "su");
        map.put("ssl_pinning", "sp");
        map.put("external_attribution", "exta");
    }

    public final String a(String str) {
        return this.a.containsKey(str) ? (String) this.a.get(str) : str;
    }
}
