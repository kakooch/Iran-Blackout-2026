package com.google.android.gms.gcm;

import android.content.Context;
import ir.nasim.KJ;
import java.util.Map;

/* loaded from: classes3.dex */
public class a {
    private static a c;
    private final Context a;
    private final Map b = new KJ();

    private a(Context context) {
        this.a = context;
    }

    public static a a(Context context) {
        a aVar;
        synchronized (a.class) {
            try {
                if (c == null) {
                    c = new a(context.getApplicationContext());
                }
                aVar = c;
            } catch (Throwable th) {
                throw th;
            }
        }
        return aVar;
    }

    final synchronized boolean b(String str, String str2) {
        Map kj;
        try {
            kj = (Map) this.b.get(str2);
            if (kj == null) {
                kj = new KJ();
                this.b.put(str2, kj);
            }
        } catch (Throwable th) {
            throw th;
        }
        return kj.put(str, Boolean.FALSE) == null;
    }

    final synchronized void c(String str, String str2) {
        Map map = (Map) this.b.get(str2);
        if (map != null && map.remove(str) != null && map.isEmpty()) {
            this.b.remove(str2);
        }
    }

    final synchronized boolean d(String str) {
        return this.b.containsKey(str);
    }

    final synchronized boolean e(String str, String str2) {
        Map map = (Map) this.b.get(str2);
        if (map == null) {
            return false;
        }
        Boolean bool = (Boolean) map.get(str);
        if (bool == null) {
            return false;
        }
        return bool.booleanValue();
    }
}
