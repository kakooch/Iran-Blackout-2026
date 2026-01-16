package ir.nasim;

import android.gov.nist.core.Separators;
import ir.nasim.core.modules.profile.entity.Avatar;

/* loaded from: classes6.dex */
public final class R14 {
    private final Avatar a;
    private final String b;
    private final int c;

    public R14(Avatar avatar, String str, int i) {
        AbstractC13042fc3.i(str, "name");
        this.a = avatar;
        this.b = str;
        this.c = i;
    }

    public final Avatar a() {
        return this.a;
    }

    public final int b() {
        return this.c;
    }

    public final String c() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof R14)) {
            return false;
        }
        R14 r14 = (R14) obj;
        return AbstractC13042fc3.d(this.a, r14.a) && AbstractC13042fc3.d(this.b, r14.b) && this.c == r14.c;
    }

    public int hashCode() {
        Avatar avatar = this.a;
        return ((((avatar == null ? 0 : avatar.hashCode()) * 31) + this.b.hashCode()) * 31) + Integer.hashCode(this.c);
    }

    public String toString() {
        return "Member(avatar=" + this.a + ", name=" + this.b + ", id=" + this.c + Separators.RPAREN;
    }
}
