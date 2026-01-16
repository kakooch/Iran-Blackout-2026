package ir.nasim;

import android.gov.nist.core.Separators;
import ir.nasim.core.modules.profile.entity.Avatar;

/* renamed from: ir.nasim.Ok6, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C6658Ok6 {
    private final int a;
    private final String b;
    private final Avatar c;
    private final boolean d;

    public C6658Ok6(int i, String str, Avatar avatar, boolean z) {
        AbstractC13042fc3.i(str, "name");
        this.a = i;
        this.b = str;
        this.c = avatar;
        this.d = z;
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

    public final boolean d() {
        return this.d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C6658Ok6)) {
            return false;
        }
        C6658Ok6 c6658Ok6 = (C6658Ok6) obj;
        return this.a == c6658Ok6.a && AbstractC13042fc3.d(this.b, c6658Ok6.b) && AbstractC13042fc3.d(this.c, c6658Ok6.c) && this.d == c6658Ok6.d;
    }

    public int hashCode() {
        int iHashCode = ((Integer.hashCode(this.a) * 31) + this.b.hashCode()) * 31;
        Avatar avatar = this.c;
        return ((iHashCode + (avatar == null ? 0 : avatar.hashCode())) * 31) + Boolean.hashCode(this.d);
    }

    public String toString() {
        return "SeenListModel(uId=" + this.a + ", name=" + this.b + ", avatar=" + this.c + ", isDeleteAccount=" + this.d + Separators.RPAREN;
    }
}
