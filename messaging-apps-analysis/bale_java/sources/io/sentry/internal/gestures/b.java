package io.sentry.internal.gestures;

import io.sentry.util.u;
import java.lang.ref.WeakReference;

/* loaded from: classes3.dex */
public final class b {
    final WeakReference a;
    final String b;
    final String c;
    final String d;
    final String e;

    public enum a {
        CLICKABLE,
        SCROLLABLE
    }

    public b(Object obj, String str, String str2, String str3, String str4) {
        this.a = new WeakReference(obj);
        this.b = str;
        this.c = str2;
        this.d = str3;
        this.e = str4;
    }

    public String a() {
        return this.b;
    }

    public String b() {
        String str = this.c;
        return str != null ? str : (String) u.c(this.d, "UiElement.tag can't be null");
    }

    public String c() {
        return this.e;
    }

    public String d() {
        return this.c;
    }

    public String e() {
        return this.d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || b.class != obj.getClass()) {
            return false;
        }
        b bVar = (b) obj;
        return u.a(this.b, bVar.b) && u.a(this.c, bVar.c) && u.a(this.d, bVar.d);
    }

    public Object f() {
        return this.a.get();
    }

    public int hashCode() {
        return u.b(this.a, this.c, this.d);
    }
}
