package ir.nasim;

import android.gov.nist.core.Separators;

/* renamed from: ir.nasim.aE7, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C9602aE7 extends AbstractC20556sC7 {
    private final int a;
    private final DA b;
    private final int c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C9602aE7(int i, DA da, int i2) {
        super(null);
        AbstractC13042fc3.i(da, "permissions");
        this.a = i;
        this.b = da;
        this.c = i2;
    }

    public final int a() {
        return this.a;
    }

    public final DA b() {
        return this.b;
    }

    public final int c() {
        return this.c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C9602aE7)) {
            return false;
        }
        C9602aE7 c9602aE7 = (C9602aE7) obj;
        return this.a == c9602aE7.a && AbstractC13042fc3.d(this.b, c9602aE7.b) && this.c == c9602aE7.c;
    }

    public int hashCode() {
        return (((Integer.hashCode(this.a) * 31) + this.b.hashCode()) * 31) + Integer.hashCode(this.c);
    }

    public String toString() {
        return "UpdateGroupMemberPermissionsChanged(groupId=" + this.a + ", permissions=" + this.b + ", uid=" + this.c + Separators.RPAREN;
    }
}
