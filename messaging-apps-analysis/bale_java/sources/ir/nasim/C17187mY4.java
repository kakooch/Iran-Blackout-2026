package ir.nasim;

import android.gov.nist.core.Separators;

/* renamed from: ir.nasim.mY4, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C17187mY4 {
    private final C19777qv2 a;
    private final EnumC10399bY4 b;
    private final IA1 c;
    private final boolean d;
    private final VX4 e;
    private final EnumC16596lY4 f;
    private final EnumC16005kY4 g;
    private final String h;

    public C17187mY4(C19777qv2 c19777qv2, EnumC10399bY4 enumC10399bY4, IA1 ia1, boolean z, VX4 vx4, EnumC16596lY4 enumC16596lY4, EnumC16005kY4 enumC16005kY4, String str) {
        AbstractC13042fc3.i(c19777qv2, "formUiState");
        this.a = c19777qv2;
        this.b = enumC10399bY4;
        this.c = ia1;
        this.d = z;
        this.e = vx4;
        this.f = enumC16596lY4;
        this.g = enumC16005kY4;
        this.h = str;
    }

    public final C17187mY4 a(C19777qv2 c19777qv2, EnumC10399bY4 enumC10399bY4, IA1 ia1, boolean z, VX4 vx4, EnumC16596lY4 enumC16596lY4, EnumC16005kY4 enumC16005kY4, String str) {
        AbstractC13042fc3.i(c19777qv2, "formUiState");
        return new C17187mY4(c19777qv2, enumC10399bY4, ia1, z, vx4, enumC16596lY4, enumC16005kY4, str);
    }

    public final boolean c() {
        return this.d;
    }

    public final IA1 d() {
        return this.c;
    }

    public final VX4 e() {
        return this.e;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C17187mY4)) {
            return false;
        }
        C17187mY4 c17187mY4 = (C17187mY4) obj;
        return AbstractC13042fc3.d(this.a, c17187mY4.a) && this.b == c17187mY4.b && AbstractC13042fc3.d(this.c, c17187mY4.c) && this.d == c17187mY4.d && this.e == c17187mY4.e && this.f == c17187mY4.f && this.g == c17187mY4.g && AbstractC13042fc3.d(this.h, c17187mY4.h);
    }

    public final C19777qv2 f() {
        return this.a;
    }

    public final EnumC10399bY4 g() {
        return this.b;
    }

    public final String h() {
        return this.h;
    }

    public int hashCode() {
        int iHashCode = this.a.hashCode() * 31;
        EnumC10399bY4 enumC10399bY4 = this.b;
        int iHashCode2 = (iHashCode + (enumC10399bY4 == null ? 0 : enumC10399bY4.hashCode())) * 31;
        IA1 ia1 = this.c;
        int iHashCode3 = (((iHashCode2 + (ia1 == null ? 0 : ia1.hashCode())) * 31) + Boolean.hashCode(this.d)) * 31;
        VX4 vx4 = this.e;
        int iHashCode4 = (iHashCode3 + (vx4 == null ? 0 : vx4.hashCode())) * 31;
        EnumC16596lY4 enumC16596lY4 = this.f;
        int iHashCode5 = (iHashCode4 + (enumC16596lY4 == null ? 0 : enumC16596lY4.hashCode())) * 31;
        EnumC16005kY4 enumC16005kY4 = this.g;
        int iHashCode6 = (iHashCode5 + (enumC16005kY4 == null ? 0 : enumC16005kY4.hashCode())) * 31;
        String str = this.h;
        return iHashCode6 + (str != null ? str.hashCode() : 0);
    }

    public final EnumC16005kY4 i() {
        return this.g;
    }

    public final EnumC16596lY4 j() {
        return this.f;
    }

    public String toString() {
        return "PassportInfoUiState(formUiState=" + this.a + ", loadingState=" + this.b + ", datePickerState=" + this.c + ", closeFragment=" + this.d + ", dialogState=" + this.e + ", toastState=" + this.f + ", snackBarState=" + this.g + ", openUpdateUrl=" + this.h + Separators.RPAREN;
    }

    public /* synthetic */ C17187mY4(C19777qv2 c19777qv2, EnumC10399bY4 enumC10399bY4, IA1 ia1, boolean z, VX4 vx4, EnumC16596lY4 enumC16596lY4, EnumC16005kY4 enumC16005kY4, String str, int i, ED1 ed1) {
        this((i & 1) != 0 ? new C19777qv2(null, null, 3, null) : c19777qv2, (i & 2) != 0 ? EnumC10399bY4.a : enumC10399bY4, (i & 4) != 0 ? null : ia1, (i & 8) != 0 ? false : z, (i & 16) != 0 ? null : vx4, (i & 32) != 0 ? null : enumC16596lY4, (i & 64) != 0 ? null : enumC16005kY4, (i & 128) == 0 ? str : null);
    }
}
