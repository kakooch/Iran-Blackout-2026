package ir.nasim;

import android.gov.nist.core.Separators;

/* renamed from: ir.nasim.cE7, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C10812cE7 extends AbstractC20556sC7 {
    private final int a;
    private final int b;

    public C10812cE7(int i, int i2) {
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
        if (!(obj instanceof C10812cE7)) {
            return false;
        }
        C10812cE7 c10812cE7 = (C10812cE7) obj;
        return this.a == c10812cE7.a && this.b == c10812cE7.b;
    }

    public int hashCode() {
        return (Integer.hashCode(this.a) * 31) + Integer.hashCode(this.b);
    }

    public String toString() {
        return "UpdateGroupMembersCountChanged(groupId=" + this.a + ", membersCount=" + this.b + Separators.RPAREN;
    }
}
