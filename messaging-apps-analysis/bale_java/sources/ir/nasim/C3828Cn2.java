package ir.nasim;

import android.gov.nist.core.Separators;

/* renamed from: ir.nasim.Cn2, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public final class C3828Cn2 {
    private final boolean a;
    private final long b;

    public C3828Cn2(boolean z, long j) {
        this.a = z;
        this.b = j;
    }

    public final long a() {
        return this.b;
    }

    public final boolean b() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C3828Cn2)) {
            return false;
        }
        C3828Cn2 c3828Cn2 = (C3828Cn2) obj;
        return this.a == c3828Cn2.a && this.b == c3828Cn2.b;
    }

    public int hashCode() {
        return (Boolean.hashCode(this.a) * 31) + Long.hashCode(this.b);
    }

    public String toString() {
        return "FilesStorageState(canBeCleared=" + this.a + ", allocatedSizeInByte=" + this.b + Separators.RPAREN;
    }
}
