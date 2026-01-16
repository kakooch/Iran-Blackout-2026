package ir.nasim;

import android.gov.nist.core.Separators;

/* renamed from: ir.nasim.iS0, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public final class C14767iS0 {
    private final boolean a;
    private final long b;

    public C14767iS0(boolean z, long j) {
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
        if (!(obj instanceof C14767iS0)) {
            return false;
        }
        C14767iS0 c14767iS0 = (C14767iS0) obj;
        return this.a == c14767iS0.a && this.b == c14767iS0.b;
    }

    public int hashCode() {
        return (Boolean.hashCode(this.a) * 31) + Long.hashCode(this.b);
    }

    public String toString() {
        return "ChatsStorageState(canBeCleared=" + this.a + ", allocatedSizeInByte=" + this.b + Separators.RPAREN;
    }
}
