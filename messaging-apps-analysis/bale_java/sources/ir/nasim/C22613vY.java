package ir.nasim;

import android.gov.nist.core.Separators;
import ir.nasim.core.modules.profile.entity.Avatar;

/* renamed from: ir.nasim.vY, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C22613vY {
    private final int a;
    private final String b;
    private final Avatar c;
    private final boolean d;
    private final String e;
    private final boolean f;

    public C22613vY(int i, String str, Avatar avatar, boolean z, String str2, boolean z2) {
        AbstractC13042fc3.i(str, "name");
        AbstractC13042fc3.i(str2, "lastSeen");
        this.a = i;
        this.b = str;
        this.c = avatar;
        this.d = z;
        this.e = str2;
        this.f = z2;
    }

    public static /* synthetic */ C22613vY b(C22613vY c22613vY, int i, String str, Avatar avatar, boolean z, String str2, boolean z2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = c22613vY.a;
        }
        if ((i2 & 2) != 0) {
            str = c22613vY.b;
        }
        String str3 = str;
        if ((i2 & 4) != 0) {
            avatar = c22613vY.c;
        }
        Avatar avatar2 = avatar;
        if ((i2 & 8) != 0) {
            z = c22613vY.d;
        }
        boolean z3 = z;
        if ((i2 & 16) != 0) {
            str2 = c22613vY.e;
        }
        String str4 = str2;
        if ((i2 & 32) != 0) {
            z2 = c22613vY.f;
        }
        return c22613vY.a(i, str3, avatar2, z3, str4, z2);
    }

    public final C22613vY a(int i, String str, Avatar avatar, boolean z, String str2, boolean z2) {
        AbstractC13042fc3.i(str, "name");
        AbstractC13042fc3.i(str2, "lastSeen");
        return new C22613vY(i, str, avatar, z, str2, z2);
    }

    public final Avatar c() {
        return this.c;
    }

    public final int d() {
        return this.a;
    }

    public final String e() {
        return this.e;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C22613vY)) {
            return false;
        }
        C22613vY c22613vY = (C22613vY) obj;
        return this.a == c22613vY.a && AbstractC13042fc3.d(this.b, c22613vY.b) && AbstractC13042fc3.d(this.c, c22613vY.c) && this.d == c22613vY.d && AbstractC13042fc3.d(this.e, c22613vY.e) && this.f == c22613vY.f;
    }

    public final String f() {
        return this.b;
    }

    public final boolean g() {
        return this.f;
    }

    public final boolean h() {
        return this.d;
    }

    public int hashCode() {
        int iHashCode = ((Integer.hashCode(this.a) * 31) + this.b.hashCode()) * 31;
        Avatar avatar = this.c;
        return ((((((iHashCode + (avatar == null ? 0 : avatar.hashCode())) * 31) + Boolean.hashCode(this.d)) * 31) + this.e.hashCode()) * 31) + Boolean.hashCode(this.f);
    }

    public String toString() {
        return "BaleContactItem(id=" + this.a + ", name=" + this.b + ", avatar=" + this.c + ", isSelected=" + this.d + ", lastSeen=" + this.e + ", isBot=" + this.f + Separators.RPAREN;
    }
}
