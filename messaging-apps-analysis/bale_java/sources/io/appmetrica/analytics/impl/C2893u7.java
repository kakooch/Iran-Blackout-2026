package io.appmetrica.analytics.impl;

/* renamed from: io.appmetrica.analytics.impl.u7, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2893u7 {
    public final long a;
    public final int b;

    public C2893u7(int i, long j) {
        this.a = j;
        this.b = i;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C2893u7)) {
            return false;
        }
        C2893u7 c2893u7 = (C2893u7) obj;
        return this.a == c2893u7.a && this.b == c2893u7.b;
    }

    public final int hashCode() {
        return Integer.hashCode(this.b) + (Long.hashCode(this.a) * 31);
    }

    public final String toString() {
        return "DecimalProtoModel(mantissa=" + this.a + ", exponent=" + this.b + ')';
    }
}
