package ir.nasim;

import android.gov.nist.core.Separators;

/* renamed from: ir.nasim.eD7, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C12210eD7 extends AbstractC20556sC7 {
    private final int a;
    private final boolean b;
    private final long c;
    private final long d;

    public C12210eD7(int i, boolean z, long j, long j2) {
        super(null);
        this.a = i;
        this.b = z;
        this.c = j;
        this.d = j2;
    }

    public final long a() {
        return this.c;
    }

    public final long b() {
        return this.d;
    }

    public final int c() {
        return this.a;
    }

    public final boolean d() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C12210eD7)) {
            return false;
        }
        C12210eD7 c12210eD7 = (C12210eD7) obj;
        return this.a == c12210eD7.a && this.b == c12210eD7.b && this.c == c12210eD7.c && this.d == c12210eD7.d;
    }

    public int hashCode() {
        return (((((Integer.hashCode(this.a) * 31) + Boolean.hashCode(this.b)) * 31) + Long.hashCode(this.c)) * 31) + Long.hashCode(this.d);
    }

    public String toString() {
        return "UpdateContactRegistered(uid=" + this.a + ", isSilent=" + this.b + ", date=" + this.c + ", rid=" + this.d + Separators.RPAREN;
    }
}
