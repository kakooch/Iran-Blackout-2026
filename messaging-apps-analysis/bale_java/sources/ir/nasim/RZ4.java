package ir.nasim;

import android.gov.nist.core.Separators;
import java.util.List;

/* loaded from: classes6.dex */
public final class RZ4 {
    private final List a;
    private final EnumC24997zZ4 b;
    private final EnumC22037uZ4 c;
    private final Integer d;
    private final boolean e;
    private final QZ4 f;
    private final PZ4 g;

    public RZ4(List list, EnumC24997zZ4 enumC24997zZ4, EnumC22037uZ4 enumC22037uZ4, Integer num, boolean z, QZ4 qz4, PZ4 pz4) {
        AbstractC13042fc3.i(list, "groups");
        this.a = list;
        this.b = enumC24997zZ4;
        this.c = enumC22037uZ4;
        this.d = num;
        this.e = z;
        this.f = qz4;
        this.g = pz4;
    }

    public static /* synthetic */ RZ4 b(RZ4 rz4, List list, EnumC24997zZ4 enumC24997zZ4, EnumC22037uZ4 enumC22037uZ4, Integer num, boolean z, QZ4 qz4, PZ4 pz4, int i, Object obj) {
        if ((i & 1) != 0) {
            list = rz4.a;
        }
        if ((i & 2) != 0) {
            enumC24997zZ4 = rz4.b;
        }
        EnumC24997zZ4 enumC24997zZ42 = enumC24997zZ4;
        if ((i & 4) != 0) {
            enumC22037uZ4 = rz4.c;
        }
        EnumC22037uZ4 enumC22037uZ42 = enumC22037uZ4;
        if ((i & 8) != 0) {
            num = rz4.d;
        }
        Integer num2 = num;
        if ((i & 16) != 0) {
            z = rz4.e;
        }
        boolean z2 = z;
        if ((i & 32) != 0) {
            qz4 = rz4.f;
        }
        QZ4 qz42 = qz4;
        if ((i & 64) != 0) {
            pz4 = rz4.g;
        }
        return rz4.a(list, enumC24997zZ42, enumC22037uZ42, num2, z2, qz42, pz4);
    }

    public final RZ4 a(List list, EnumC24997zZ4 enumC24997zZ4, EnumC22037uZ4 enumC22037uZ4, Integer num, boolean z, QZ4 qz4, PZ4 pz4) {
        AbstractC13042fc3.i(list, "groups");
        return new RZ4(list, enumC24997zZ4, enumC22037uZ4, num, z, qz4, pz4);
    }

    public final boolean c() {
        return this.e;
    }

    public final EnumC22037uZ4 d() {
        return this.c;
    }

    public final List e() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RZ4)) {
            return false;
        }
        RZ4 rz4 = (RZ4) obj;
        return AbstractC13042fc3.d(this.a, rz4.a) && this.b == rz4.b && this.c == rz4.c && AbstractC13042fc3.d(this.d, rz4.d) && this.e == rz4.e && this.f == rz4.f && this.g == rz4.g;
    }

    public final EnumC24997zZ4 f() {
        return this.b;
    }

    public final Integer g() {
        return this.d;
    }

    public final PZ4 h() {
        return this.g;
    }

    public int hashCode() {
        int iHashCode = this.a.hashCode() * 31;
        EnumC24997zZ4 enumC24997zZ4 = this.b;
        int iHashCode2 = (iHashCode + (enumC24997zZ4 == null ? 0 : enumC24997zZ4.hashCode())) * 31;
        EnumC22037uZ4 enumC22037uZ4 = this.c;
        int iHashCode3 = (iHashCode2 + (enumC22037uZ4 == null ? 0 : enumC22037uZ4.hashCode())) * 31;
        Integer num = this.d;
        int iHashCode4 = (((iHashCode3 + (num == null ? 0 : num.hashCode())) * 31) + Boolean.hashCode(this.e)) * 31;
        QZ4 qz4 = this.f;
        int iHashCode5 = (iHashCode4 + (qz4 == null ? 0 : qz4.hashCode())) * 31;
        PZ4 pz4 = this.g;
        return iHashCode5 + (pz4 != null ? pz4.hashCode() : 0);
    }

    public final QZ4 i() {
        return this.f;
    }

    public String toString() {
        return "PassportSettingUiState(groups=" + this.a + ", loadingState=" + this.b + ", dialogState=" + this.c + ", openGroupId=" + this.d + ", closeFragment=" + this.e + ", toastState=" + this.f + ", snackBarState=" + this.g + Separators.RPAREN;
    }

    public /* synthetic */ RZ4(List list, EnumC24997zZ4 enumC24997zZ4, EnumC22037uZ4 enumC22037uZ4, Integer num, boolean z, QZ4 qz4, PZ4 pz4, int i, ED1 ed1) {
        this((i & 1) != 0 ? AbstractC10360bX0.m() : list, (i & 2) != 0 ? EnumC24997zZ4.a : enumC24997zZ4, (i & 4) != 0 ? null : enumC22037uZ4, (i & 8) != 0 ? null : num, (i & 16) != 0 ? false : z, (i & 32) != 0 ? null : qz4, (i & 64) == 0 ? pz4 : null);
    }
}
