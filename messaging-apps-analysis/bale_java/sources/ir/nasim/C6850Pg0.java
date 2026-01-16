package ir.nasim;

import android.gov.nist.core.Separators;
import ir.nasim.core.modules.profile.entity.Avatar;

/* renamed from: ir.nasim.Pg0, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public final class C6850Pg0 {
    private final int a;
    private final String b;
    private final Avatar c;
    private final boolean d;
    private final int e;
    private final String f;

    public C6850Pg0(int i, String str, Avatar avatar, boolean z, int i2, String str2) {
        AbstractC13042fc3.i(str, "name");
        AbstractC13042fc3.i(str2, "bannerUserName");
        this.a = i;
        this.b = str;
        this.c = avatar;
        this.d = z;
        this.e = i2;
        this.f = str2;
    }

    public final Avatar a() {
        return this.c;
    }

    public final int b() {
        return this.e;
    }

    public final String c() {
        return this.f;
    }

    public final int d() {
        return this.a;
    }

    public final String e() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C6850Pg0)) {
            return false;
        }
        C6850Pg0 c6850Pg0 = (C6850Pg0) obj;
        return this.a == c6850Pg0.a && AbstractC13042fc3.d(this.b, c6850Pg0.b) && AbstractC13042fc3.d(this.c, c6850Pg0.c) && this.d == c6850Pg0.d && this.e == c6850Pg0.e && AbstractC13042fc3.d(this.f, c6850Pg0.f);
    }

    public int hashCode() {
        int iHashCode = ((Integer.hashCode(this.a) * 31) + this.b.hashCode()) * 31;
        Avatar avatar = this.c;
        return ((((((iHashCode + (avatar == null ? 0 : avatar.hashCode())) * 31) + Boolean.hashCode(this.d)) * 31) + Integer.hashCode(this.e)) * 31) + this.f.hashCode();
    }

    public String toString() {
        return "BlackUserModel(id=" + this.a + ", name=" + this.b + ", avatar=" + this.c + ", isBot=" + this.d + ", bannerUserId=" + this.e + ", bannerUserName=" + this.f + Separators.RPAREN;
    }
}
