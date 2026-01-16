package ir.nasim;

import android.gov.nist.core.Separators;

/* renamed from: ir.nasim.oJ3, reason: case insensitive filesystem */
/* loaded from: classes.dex */
final class C18233oJ3 {
    private final long a;
    private final long b;

    C18233oJ3(long j, long j2) {
        this.a = j;
        this.b = j2;
    }

    long a() {
        return this.b;
    }

    long b() {
        return this.a;
    }

    public String toString() {
        return this.a + Separators.SLASH + this.b;
    }

    C18233oJ3(double d) {
        this((long) (d * 10000.0d), 10000L);
    }
}
