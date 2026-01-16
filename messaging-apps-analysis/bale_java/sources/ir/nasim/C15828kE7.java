package ir.nasim;

import android.gov.nist.core.Separators;

/* renamed from: ir.nasim.kE7, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C15828kE7 extends AbstractC20556sC7 {
    private final int a;
    private final int b;

    public C15828kE7(int i, int i2) {
        super(null);
        this.a = i;
        this.b = i2;
    }

    public final int a() {
        return this.a;
    }

    public final int b() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C15828kE7)) {
            return false;
        }
        C15828kE7 c15828kE7 = (C15828kE7) obj;
        return this.a == c15828kE7.a && this.b == c15828kE7.b;
    }

    public int hashCode() {
        return (Integer.hashCode(this.a) * 31) + Integer.hashCode(this.b);
    }

    public String toString() {
        return "UpdateGroupOwnerChanged(groupId=" + this.a + ", userId=" + this.b + Separators.RPAREN;
    }
}
