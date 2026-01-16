package ir.nasim;

import android.gov.nist.core.Separators;
import ir.nasim.core.modules.profile.entity.Avatar;

/* loaded from: classes4.dex */
public final class DH5 {
    private final int a;
    private final String b;
    private final long c;
    private final String d;
    private final Avatar e;
    private final boolean f;

    public DH5(int i, String str, long j, String str2, Avatar avatar, boolean z) {
        AbstractC13042fc3.i(str, "name");
        AbstractC13042fc3.i(str2, "reactionCode");
        this.a = i;
        this.b = str;
        this.c = j;
        this.d = str2;
        this.e = avatar;
        this.f = z;
    }

    public final Avatar a() {
        return this.e;
    }

    public final String b() {
        return this.b;
    }

    public final String c() {
        return this.d;
    }

    public final long d() {
        return this.c;
    }

    public final int e() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DH5)) {
            return false;
        }
        DH5 dh5 = (DH5) obj;
        return this.a == dh5.a && AbstractC13042fc3.d(this.b, dh5.b) && this.c == dh5.c && AbstractC13042fc3.d(this.d, dh5.d) && AbstractC13042fc3.d(this.e, dh5.e) && this.f == dh5.f;
    }

    public final boolean f() {
        return this.f;
    }

    public int hashCode() {
        int iHashCode = ((((((Integer.hashCode(this.a) * 31) + this.b.hashCode()) * 31) + Long.hashCode(this.c)) * 31) + this.d.hashCode()) * 31;
        Avatar avatar = this.e;
        return ((iHashCode + (avatar == null ? 0 : avatar.hashCode())) * 31) + Boolean.hashCode(this.f);
    }

    public String toString() {
        return "ReactionListModel(uId=" + this.a + ", name=" + this.b + ", time=" + this.c + ", reactionCode=" + this.d + ", avatar=" + this.e + ", isDeleteAccount=" + this.f + Separators.RPAREN;
    }
}
