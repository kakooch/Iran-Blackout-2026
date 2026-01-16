package io.appmetrica.analytics.impl;

/* renamed from: io.appmetrica.analytics.impl.u3, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2889u3 {
    public final long a;

    public C2889u3(long j) {
        this.a = j;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && C2889u3.class == obj.getClass() && this.a == ((C2889u3) obj).a;
    }

    public final int hashCode() {
        long j = this.a;
        return (int) (j ^ (j >>> 32));
    }

    public final String toString() {
        return "CacheControl{lastKnownLocationTtl=" + this.a + '}';
    }
}
