package io.appmetrica.analytics.impl;

/* loaded from: classes3.dex */
public final class Dl {
    public final int a;

    public Dl(int i) {
        this.a = i;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof Dl) && this.a == ((Dl) obj).a;
    }

    public final int hashCode() {
        return Integer.hashCode(this.a);
    }

    public final String toString() {
        return "StartupUpdateConfig(intervalSeconds=" + this.a + ')';
    }
}
