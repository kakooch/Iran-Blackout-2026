package ir.nasim;

import android.gov.nist.core.Separators;
import ir.nasim.core.modules.profile.entity.Avatar;

/* loaded from: classes7.dex */
public final class BM2 {
    private final int a;
    private final String b;
    private final int c;
    private final Avatar d;
    private final ZN2 e;
    private final boolean f;

    public BM2(int i, String str, int i2, Avatar avatar, ZN2 zn2, boolean z) {
        AbstractC13042fc3.i(str, "name");
        AbstractC13042fc3.i(zn2, "groupType");
        this.a = i;
        this.b = str;
        this.c = i2;
        this.d = avatar;
        this.e = zn2;
        this.f = z;
    }

    public final Avatar a() {
        return this.d;
    }

    public final ZN2 b() {
        return this.e;
    }

    public final int c() {
        return this.a;
    }

    public final int d() {
        return this.c;
    }

    public final String e() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BM2)) {
            return false;
        }
        BM2 bm2 = (BM2) obj;
        return this.a == bm2.a && AbstractC13042fc3.d(this.b, bm2.b) && this.c == bm2.c && AbstractC13042fc3.d(this.d, bm2.d) && this.e == bm2.e && this.f == bm2.f;
    }

    public int hashCode() {
        int iHashCode = ((((Integer.hashCode(this.a) * 31) + this.b.hashCode()) * 31) + Integer.hashCode(this.c)) * 31;
        Avatar avatar = this.d;
        return ((((iHashCode + (avatar == null ? 0 : avatar.hashCode())) * 31) + this.e.hashCode()) * 31) + Boolean.hashCode(this.f);
    }

    public String toString() {
        return "GroupModel(id=" + this.a + ", name=" + this.b + ", membersCount=" + this.c + ", avatar=" + this.d + ", groupType=" + this.e + ", amIOwner=" + this.f + Separators.RPAREN;
    }
}
