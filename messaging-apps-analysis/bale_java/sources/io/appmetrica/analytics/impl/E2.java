package io.appmetrica.analytics.impl;

/* loaded from: classes3.dex */
public final class E2 {
    public final D2 a;
    public final Boolean b;

    public E2(D2 d2, Boolean bool) {
        this.a = d2;
        this.b = bool;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || E2.class != obj.getClass()) {
            return false;
        }
        E2 e2 = (E2) obj;
        if (this.a != e2.a) {
            return false;
        }
        Boolean bool = this.b;
        return bool != null ? bool.equals(e2.b) : e2.b == null;
    }

    public final int hashCode() {
        D2 d2 = this.a;
        int iHashCode = (d2 != null ? d2.hashCode() : 0) * 31;
        Boolean bool = this.b;
        return iHashCode + (bool != null ? bool.hashCode() : 0);
    }
}
