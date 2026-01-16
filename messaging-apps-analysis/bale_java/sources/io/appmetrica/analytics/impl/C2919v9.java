package io.appmetrica.analytics.impl;

/* renamed from: io.appmetrica.analytics.impl.v9, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2919v9 {
    public final long a;

    public C2919v9(long j) {
        this.a = j;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof C2919v9) && this.a == ((C2919v9) obj).a;
    }

    public final int hashCode() {
        return Long.hashCode(this.a);
    }

    public final String toString() {
        return "ExternalAttributionConfig(collectingInterval=" + this.a + ')';
    }
}
