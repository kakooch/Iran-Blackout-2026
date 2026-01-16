package io.sentry.clientreport;

import io.sentry.util.u;

/* loaded from: classes3.dex */
final class d {
    private final String a;
    private final String b;

    d(String str, String str2) {
        this.a = str;
        this.b = str2;
    }

    public String a() {
        return this.b;
    }

    public String b() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        return u.a(b(), dVar.b()) && u.a(a(), dVar.a());
    }

    public int hashCode() {
        return u.b(b(), a());
    }
}
