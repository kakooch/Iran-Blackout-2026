package io.appmetrica.analytics.impl;

/* renamed from: io.appmetrica.analytics.impl.a0, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2404a0 {
    public final String a;
    public final long b;

    public C2404a0(String str, long j) {
        this.a = str;
        this.b = j;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || C2404a0.class != obj.getClass()) {
            return false;
        }
        C2404a0 c2404a0 = (C2404a0) obj;
        if (this.b != c2404a0.b) {
            return false;
        }
        String str = this.a;
        String str2 = c2404a0.a;
        if (str != null) {
            if (str.equals(str2)) {
                return true;
            }
        } else if (str2 == null) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        String str = this.a;
        int iHashCode = str != null ? str.hashCode() : 0;
        long j = this.b;
        return (iHashCode * 31) + ((int) (j ^ (j >>> 32)));
    }
}
