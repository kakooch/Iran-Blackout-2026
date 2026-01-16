package ir.nasim;

import android.gov.nist.core.Separators;
import ir.nasim.core.modules.profile.entity.Avatar;

/* loaded from: classes7.dex */
public final class Q14 {
    private final String a;
    private final int b;
    private final int c;
    private final Avatar d;
    private final boolean e;
    private final boolean f;
    private final int g;
    private final long h;
    private final int i;
    private final boolean j;
    private final Boolean k;
    private final String l;

    public Q14(String str, int i, int i2, Avatar avatar, boolean z, boolean z2, int i3, long j, int i4, boolean z3, Boolean bool, String str2) {
        AbstractC13042fc3.i(str, "name");
        this.a = str;
        this.b = i;
        this.c = i2;
        this.d = avatar;
        this.e = z;
        this.f = z2;
        this.g = i3;
        this.h = j;
        this.i = i4;
        this.j = z3;
        this.k = bool;
        this.l = str2;
    }

    public final Avatar a() {
        return this.d;
    }

    public final Boolean b() {
        return this.k;
    }

    public final long c() {
        return this.h;
    }

    public final int d() {
        return this.g;
    }

    public final String e() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Q14)) {
            return false;
        }
        Q14 q14 = (Q14) obj;
        return AbstractC13042fc3.d(this.a, q14.a) && this.b == q14.b && this.c == q14.c && AbstractC13042fc3.d(this.d, q14.d) && this.e == q14.e && this.f == q14.f && this.g == q14.g && this.h == q14.h && this.i == q14.i && this.j == q14.j && AbstractC13042fc3.d(this.k, q14.k) && AbstractC13042fc3.d(this.l, q14.l);
    }

    public final int f() {
        return this.c;
    }

    public final String g() {
        return this.l;
    }

    public final int h() {
        return this.i;
    }

    public int hashCode() {
        int iHashCode = ((((this.a.hashCode() * 31) + Integer.hashCode(this.b)) * 31) + Integer.hashCode(this.c)) * 31;
        Avatar avatar = this.d;
        int iHashCode2 = (((((((((((((iHashCode + (avatar == null ? 0 : avatar.hashCode())) * 31) + Boolean.hashCode(this.e)) * 31) + Boolean.hashCode(this.f)) * 31) + Integer.hashCode(this.g)) * 31) + Long.hashCode(this.h)) * 31) + Integer.hashCode(this.i)) * 31) + Boolean.hashCode(this.j)) * 31;
        Boolean bool = this.k;
        int iHashCode3 = (iHashCode2 + (bool == null ? 0 : bool.hashCode())) * 31;
        String str = this.l;
        return iHashCode3 + (str != null ? str.hashCode() : 0);
    }

    public final int i() {
        return this.b;
    }

    public final boolean j() {
        return this.e;
    }

    public final boolean k() {
        return this.j;
    }

    public final boolean l() {
        return this.f;
    }

    public String toString() {
        return "Member(name=" + this.a + ", uid=" + this.b + ", peerId=" + this.c + ", avatar=" + this.d + ", isAdmin=" + this.e + ", isOwner=" + this.f + ", inviterUid=" + this.g + ", inviteDate=" + this.h + ", promoterUserId=" + this.i + ", isBot=" + this.j + ", canSeeMessages=" + this.k + ", personalName=" + this.l + Separators.RPAREN;
    }
}
