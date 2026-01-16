package io.appmetrica.analytics.impl;

import android.content.Context;
import java.util.HashMap;

/* loaded from: classes3.dex */
public final class T9 {
    public static volatile T9 c;
    public final Context a;
    public final HashMap b = new HashMap();

    public T9(Context context) {
        this.a = context;
    }

    public static T9 a(Context context) {
        if (c == null) {
            synchronized (T9.class) {
                try {
                    if (c == null) {
                        c = new T9(context);
                    }
                } finally {
                }
            }
        }
        return c;
    }

    public final C2800q9 a(String str) {
        if (!this.b.containsKey(str)) {
            synchronized (this) {
                try {
                    if (!this.b.containsKey(str)) {
                        this.b.put(str, new C2800q9(this.a, str));
                    }
                } finally {
                }
            }
        }
        return (C2800q9) this.b.get(str);
    }
}
