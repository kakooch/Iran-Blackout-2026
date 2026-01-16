package ir.nasim;

import android.gov.nist.core.Separators;
import ir.nasim.core.modules.profile.entity.Avatar;

/* renamed from: ir.nasim.Cc0, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public final class C3727Cc0 {
    private final int a;
    private final String b;
    private final String c;
    private final String d;
    private final Avatar e;
    private final String f;

    public C3727Cc0(int i, String str, String str2, String str3, Avatar avatar, String str4) {
        AbstractC13042fc3.i(str, "name");
        this.a = i;
        this.b = str;
        this.c = str2;
        this.d = str3;
        this.e = avatar;
        this.f = str4;
    }

    public static /* synthetic */ C3727Cc0 b(C3727Cc0 c3727Cc0, int i, String str, String str2, String str3, Avatar avatar, String str4, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = c3727Cc0.a;
        }
        if ((i2 & 2) != 0) {
            str = c3727Cc0.b;
        }
        String str5 = str;
        if ((i2 & 4) != 0) {
            str2 = c3727Cc0.c;
        }
        String str6 = str2;
        if ((i2 & 8) != 0) {
            str3 = c3727Cc0.d;
        }
        String str7 = str3;
        if ((i2 & 16) != 0) {
            avatar = c3727Cc0.e;
        }
        Avatar avatar2 = avatar;
        if ((i2 & 32) != 0) {
            str4 = c3727Cc0.f;
        }
        return c3727Cc0.a(i, str5, str6, str7, avatar2, str4);
    }

    public final C3727Cc0 a(int i, String str, String str2, String str3, Avatar avatar, String str4) {
        AbstractC13042fc3.i(str, "name");
        return new C3727Cc0(i, str, str2, str3, avatar, str4);
    }

    public final Avatar c() {
        return this.e;
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
        if (!(obj instanceof C3727Cc0)) {
            return false;
        }
        C3727Cc0 c3727Cc0 = (C3727Cc0) obj;
        return this.a == c3727Cc0.a && AbstractC13042fc3.d(this.b, c3727Cc0.b) && AbstractC13042fc3.d(this.c, c3727Cc0.c) && AbstractC13042fc3.d(this.d, c3727Cc0.d) && AbstractC13042fc3.d(this.e, c3727Cc0.e) && AbstractC13042fc3.d(this.f, c3727Cc0.f);
    }

    public final String f() {
        return this.d;
    }

    public final String g() {
        return this.f;
    }

    public final String h() {
        return this.c;
    }

    public int hashCode() {
        int iHashCode = ((Integer.hashCode(this.a) * 31) + this.b.hashCode()) * 31;
        String str = this.c;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.d;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        Avatar avatar = this.e;
        int iHashCode4 = (iHashCode3 + (avatar == null ? 0 : avatar.hashCode())) * 31;
        String str3 = this.f;
        return iHashCode4 + (str3 != null ? str3.hashCode() : 0);
    }

    public String toString() {
        return "BaseSettingsUserData(id=" + this.a + ", name=" + this.b + ", username=" + this.c + ", phone=" + this.d + ", avatar=" + this.e + ", premiumBadgeContent=" + this.f + Separators.RPAREN;
    }

    public /* synthetic */ C3727Cc0(int i, String str, String str2, String str3, Avatar avatar, String str4, int i2, ED1 ed1) {
        this((i2 & 1) != 0 ? -1 : i, (i2 & 2) != 0 ? "" : str, (i2 & 4) != 0 ? null : str2, (i2 & 8) != 0 ? null : str3, (i2 & 16) != 0 ? null : avatar, (i2 & 32) == 0 ? str4 : null);
    }
}
