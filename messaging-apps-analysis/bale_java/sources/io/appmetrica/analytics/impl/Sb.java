package io.appmetrica.analytics.impl;

import android.text.TextUtils;

/* loaded from: classes3.dex */
public final class Sb {
    public volatile String a;

    public static String a() {
        try {
            Class<?> cls = Class.forName("android.app.ActivityThread");
            return (String) cls.getMethod("getProcessName", null).invoke(cls.getMethod("currentActivityThread", null).invoke(null, null), null);
        } catch (Throwable th) {
            throw new RuntimeException(th);
        }
    }

    public final String b() {
        if (this.a != null) {
            return this.a;
        }
        synchronized (this) {
            try {
                if (this.a == null) {
                    this.a = a();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return this.a;
    }

    public final boolean c() {
        try {
            if (TextUtils.isEmpty(b())) {
                return false;
            }
            return !b().contains(":");
        } catch (Throwable unused) {
            return false;
        }
    }

    public final boolean a(String str) {
        try {
            if (TextUtils.isEmpty(b())) {
                return false;
            }
            String strB = b();
            StringBuilder sb = new StringBuilder(":");
            sb.append(str);
            return strB.endsWith(sb.toString());
        } catch (Throwable unused) {
            return false;
        }
    }
}
