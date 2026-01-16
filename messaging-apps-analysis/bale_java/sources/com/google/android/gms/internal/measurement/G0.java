package com.google.android.gms.internal.measurement;

/* loaded from: classes3.dex */
final class G0 {
    private final Object a;
    private final int b;

    G0(Object obj, int i) {
        this.a = obj;
        this.b = i;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof G0)) {
            return false;
        }
        G0 g0 = (G0) obj;
        return this.a == g0.a && this.b == g0.b;
    }

    public final int hashCode() {
        return (System.identityHashCode(this.a) * 65535) + this.b;
    }
}
