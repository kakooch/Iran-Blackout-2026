package ir.nasim;

import android.gov.nist.core.Separators;

/* loaded from: classes5.dex */
public final class YD7 extends AbstractC20556sC7 {
    private final int a;
    private final int b;
    private final boolean c;

    public YD7(int i, int i2, boolean z) {
        super(null);
        this.a = i;
        this.b = i2;
        this.c = z;
    }

    public final int a() {
        return this.a;
    }

    public final int b() {
        return this.b;
    }

    public final boolean c() {
        return this.c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof YD7)) {
            return false;
        }
        YD7 yd7 = (YD7) obj;
        return this.a == yd7.a && this.b == yd7.b && this.c == yd7.c;
    }

    public int hashCode() {
        return (((Integer.hashCode(this.a) * 31) + Integer.hashCode(this.b)) * 31) + Boolean.hashCode(this.c);
    }

    public String toString() {
        return "UpdateGroupMemberAdminChanged(groupId=" + this.a + ", userId=" + this.b + ", isAdmin=" + this.c + Separators.RPAREN;
    }
}
