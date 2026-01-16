package com.google.ads.interactivemedia.v3.internal;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
final class ads<T> {
    public final T a;
    private boolean b;

    public ads(T t) {
        this.a = t;
    }

    public final void a() {
        this.b = true;
    }

    public final void b(adr<T> adrVar) {
        if (this.b) {
            return;
        }
        adrVar.a(this.a);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || ads.class != obj.getClass()) {
            return false;
        }
        return this.a.equals(((ads) obj).a);
    }

    public final int hashCode() {
        return this.a.hashCode();
    }
}
