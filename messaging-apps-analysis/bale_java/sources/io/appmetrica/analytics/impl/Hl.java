package io.appmetrica.analytics.impl;

/* loaded from: classes3.dex */
public final class Hl {
    public final long a;

    public Hl(long j) {
        this.a = j;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && Hl.class == obj.getClass() && this.a == ((Hl) obj).a;
    }

    public final int hashCode() {
        long j = this.a;
        return (int) (j ^ (j >>> 32));
    }

    public final String toString() {
        return "StatSending{disabledReportingInterval=" + this.a + '}';
    }
}
