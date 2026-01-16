package io.appmetrica.analytics.impl;

import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class Xa extends JSONObject {
    public Xa() {
    }

    public final Long a(String str) {
        try {
            return Long.valueOf(getLong(str));
        } catch (Throwable unused) {
            return null;
        }
    }

    public final String b(String str) {
        if (has(str)) {
            try {
                return getString(str);
            } catch (Throwable unused) {
            }
        }
        return "";
    }

    public Xa(String str) {
        super(str);
    }
}
