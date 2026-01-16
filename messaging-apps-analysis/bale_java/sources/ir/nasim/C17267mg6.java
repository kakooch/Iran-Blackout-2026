package ir.nasim;

import android.gov.nist.core.Separators;
import ir.nasim.core.modules.profile.entity.Avatar;

/* renamed from: ir.nasim.mg6, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C17267mg6 {
    private final int a;
    private final String b;
    private final Avatar c;

    public C17267mg6(int i, String str, Avatar avatar) {
        AbstractC13042fc3.i(str, "fullName");
        this.a = i;
        this.b = str;
        this.c = avatar;
    }

    public final Avatar a() {
        return this.c;
    }

    public final String b() {
        return this.b;
    }

    public final int c() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C17267mg6)) {
            return false;
        }
        C17267mg6 c17267mg6 = (C17267mg6) obj;
        return this.a == c17267mg6.a && AbstractC13042fc3.d(this.b, c17267mg6.b) && AbstractC13042fc3.d(this.c, c17267mg6.c);
    }

    public int hashCode() {
        int iHashCode = ((Integer.hashCode(this.a) * 31) + this.b.hashCode()) * 31;
        Avatar avatar = this.c;
        return iHashCode + (avatar == null ? 0 : avatar.hashCode());
    }

    public String toString() {
        return "SearchFilterUserItem(userId=" + this.a + ", fullName=" + this.b + ", avatar=" + this.c + Separators.RPAREN;
    }
}
