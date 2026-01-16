package io.appmetrica.analytics.impl;

import java.util.List;
import java.util.Set;
import org.json.JSONArray;

/* renamed from: io.appmetrica.analytics.impl.le, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public abstract class AbstractC2685le {
    public static final String c = "le";
    public final Ba a;
    public final String b;

    public AbstractC2685le(Ba ba) {
        this(ba, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <T extends AbstractC2685le> T a(String str, float f) {
        synchronized (this) {
            this.a.a(str, f);
        }
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <T extends AbstractC2685le> T b(String str, String str2) {
        synchronized (this) {
            this.a.a(str, str2);
        }
        return this;
    }

    public final C2709me c(String str) {
        return new C2709me(str, this.b);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <T extends AbstractC2685le> T d(String str) {
        synchronized (this) {
            this.a.remove(str);
        }
        return this;
    }

    public AbstractC2685le(Ba ba, String str) {
        this.a = ba;
        this.b = str;
    }

    public Set<String> c() {
        return this.a.a();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <T extends AbstractC2685le> T a(String str, String[] strArr) {
        String string;
        try {
            JSONArray jSONArray = new JSONArray();
            for (String str2 : strArr) {
                jSONArray.put(str2);
            }
            string = jSONArray.toString();
        } catch (Throwable unused) {
            string = null;
        }
        this.a.a(str, string);
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <T extends AbstractC2685le> T b(String str, long j) {
        synchronized (this) {
            this.a.a(str, j);
        }
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <T extends AbstractC2685le> T b(String str, int i) {
        synchronized (this) {
            this.a.a(i, str);
        }
        return this;
    }

    public final <T extends AbstractC2685le> T a(String str, List<String> list) {
        return (T) a(str, (String[]) list.toArray(new String[list.size()]));
    }

    public final long a(String str, long j) {
        return this.a.getLong(str, j);
    }

    public final int a(String str, int i) {
        return this.a.getInt(str, i);
    }

    public final String a(String str, String str2) {
        return this.a.getString(str, str2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <T extends AbstractC2685le> T b(String str, boolean z) {
        synchronized (this) {
            this.a.a(str, z);
        }
        return this;
    }

    public final boolean a(String str, boolean z) {
        return this.a.getBoolean(str, z);
    }

    public final void b() {
        synchronized (this) {
            this.a.b();
        }
    }

    public final boolean b(String str) {
        return this.a.a(str);
    }
}
