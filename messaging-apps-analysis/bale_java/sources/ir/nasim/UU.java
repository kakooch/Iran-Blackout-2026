package ir.nasim;

import android.gov.nist.core.Separators;

/* loaded from: classes4.dex */
public final class UU {
    private final boolean a;
    private final YI7 b;
    private final EnumC18228oI7 c;
    private final Q37 d;
    private final String e;
    private final int f;
    private final boolean g;

    public UU(boolean z, YI7 yi7, EnumC18228oI7 enumC18228oI7, Q37 q37, String str, int i, boolean z2) {
        this.a = z;
        this.b = yi7;
        this.c = enumC18228oI7;
        this.d = q37;
        this.e = str;
        this.f = i;
        this.g = z2;
    }

    public static /* synthetic */ UU b(UU uu, boolean z, YI7 yi7, EnumC18228oI7 enumC18228oI7, Q37 q37, String str, int i, boolean z2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z = uu.a;
        }
        if ((i2 & 2) != 0) {
            yi7 = uu.b;
        }
        YI7 yi72 = yi7;
        if ((i2 & 4) != 0) {
            enumC18228oI7 = uu.c;
        }
        EnumC18228oI7 enumC18228oI72 = enumC18228oI7;
        if ((i2 & 8) != 0) {
            q37 = uu.d;
        }
        Q37 q372 = q37;
        if ((i2 & 16) != 0) {
            str = uu.e;
        }
        String str2 = str;
        if ((i2 & 32) != 0) {
            i = uu.f;
        }
        int i3 = i;
        if ((i2 & 64) != 0) {
            z2 = uu.g;
        }
        return uu.a(z, yi72, enumC18228oI72, q372, str2, i3, z2);
    }

    public final UU a(boolean z, YI7 yi7, EnumC18228oI7 enumC18228oI7, Q37 q37, String str, int i, boolean z2) {
        return new UU(z, yi7, enumC18228oI7, q37, str, i, z2);
    }

    public final int c() {
        return this.f;
    }

    public final String d() {
        return this.e;
    }

    public final boolean e() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof UU)) {
            return false;
        }
        UU uu = (UU) obj;
        return this.a == uu.a && this.b == uu.b && this.c == uu.c && AbstractC13042fc3.d(this.d, uu.d) && AbstractC13042fc3.d(this.e, uu.e) && this.f == uu.f && this.g == uu.g;
    }

    public final Q37 f() {
        return this.d;
    }

    public final EnumC18228oI7 g() {
        return this.c;
    }

    public final YI7 h() {
        return this.b;
    }

    public int hashCode() {
        int iHashCode = Boolean.hashCode(this.a) * 31;
        YI7 yi7 = this.b;
        int iHashCode2 = (iHashCode + (yi7 == null ? 0 : yi7.hashCode())) * 31;
        EnumC18228oI7 enumC18228oI7 = this.c;
        int iHashCode3 = (iHashCode2 + (enumC18228oI7 == null ? 0 : enumC18228oI7.hashCode())) * 31;
        Q37 q37 = this.d;
        int iHashCode4 = (iHashCode3 + (q37 == null ? 0 : q37.hashCode())) * 31;
        String str = this.e;
        return ((((iHashCode4 + (str != null ? str.hashCode() : 0)) * 31) + Integer.hashCode(this.f)) * 31) + Boolean.hashCode(this.g);
    }

    public final boolean i() {
        return this.g;
    }

    public String toString() {
        return "AvatarImageUiState(shouldShowPresenceIndicator=" + this.a + ", userPresenceState=" + this.b + ", userActivityState=" + this.c + ", switchAccountState=" + this.d + ", avatarOwnersName=" + this.e + ", avatarOwnersId=" + this.f + ", isDeletedAccount=" + this.g + Separators.RPAREN;
    }

    public /* synthetic */ UU(boolean z, YI7 yi7, EnumC18228oI7 enumC18228oI7, Q37 q37, String str, int i, boolean z2, int i2, ED1 ed1) {
        this((i2 & 1) != 0 ? false : z, (i2 & 2) != 0 ? null : yi7, (i2 & 4) != 0 ? null : enumC18228oI7, (i2 & 8) == 0 ? q37 : null, (i2 & 16) != 0 ? "" : str, (i2 & 32) != 0 ? 0 : i, (i2 & 64) != 0 ? false : z2);
    }
}
