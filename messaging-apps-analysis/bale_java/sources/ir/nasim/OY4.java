package ir.nasim;

import android.gov.nist.core.Separators;

/* loaded from: classes6.dex */
public final class OY4 {
    private final C19777qv2 a;
    private final AY4 b;
    private final IA1 c;
    private final C20751sY4 d;
    private final EnumC21371tY4 e;
    private final NY4 f;
    private final MY4 g;
    private final String h;

    public OY4(C19777qv2 c19777qv2, AY4 ay4, IA1 ia1, C20751sY4 c20751sY4, EnumC21371tY4 enumC21371tY4, NY4 ny4, MY4 my4, String str) {
        AbstractC13042fc3.i(c19777qv2, "formUiState");
        this.a = c19777qv2;
        this.b = ay4;
        this.c = ia1;
        this.d = c20751sY4;
        this.e = enumC21371tY4;
        this.f = ny4;
        this.g = my4;
        this.h = str;
    }

    public final OY4 a(C19777qv2 c19777qv2, AY4 ay4, IA1 ia1, C20751sY4 c20751sY4, EnumC21371tY4 enumC21371tY4, NY4 ny4, MY4 my4, String str) {
        AbstractC13042fc3.i(c19777qv2, "formUiState");
        return new OY4(c19777qv2, ay4, ia1, c20751sY4, enumC21371tY4, ny4, my4, str);
    }

    public final C20751sY4 c() {
        return this.d;
    }

    public final IA1 d() {
        return this.c;
    }

    public final EnumC21371tY4 e() {
        return this.e;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof OY4)) {
            return false;
        }
        OY4 oy4 = (OY4) obj;
        return AbstractC13042fc3.d(this.a, oy4.a) && this.b == oy4.b && AbstractC13042fc3.d(this.c, oy4.c) && AbstractC13042fc3.d(this.d, oy4.d) && this.e == oy4.e && this.f == oy4.f && this.g == oy4.g && AbstractC13042fc3.d(this.h, oy4.h);
    }

    public final C19777qv2 f() {
        return this.a;
    }

    public final AY4 g() {
        return this.b;
    }

    public final String h() {
        return this.h;
    }

    public int hashCode() {
        int iHashCode = this.a.hashCode() * 31;
        AY4 ay4 = this.b;
        int iHashCode2 = (iHashCode + (ay4 == null ? 0 : ay4.hashCode())) * 31;
        IA1 ia1 = this.c;
        int iHashCode3 = (iHashCode2 + (ia1 == null ? 0 : ia1.hashCode())) * 31;
        C20751sY4 c20751sY4 = this.d;
        int iHashCode4 = (iHashCode3 + (c20751sY4 == null ? 0 : c20751sY4.hashCode())) * 31;
        EnumC21371tY4 enumC21371tY4 = this.e;
        int iHashCode5 = (iHashCode4 + (enumC21371tY4 == null ? 0 : enumC21371tY4.hashCode())) * 31;
        NY4 ny4 = this.f;
        int iHashCode6 = (iHashCode5 + (ny4 == null ? 0 : ny4.hashCode())) * 31;
        MY4 my4 = this.g;
        int iHashCode7 = (iHashCode6 + (my4 == null ? 0 : my4.hashCode())) * 31;
        String str = this.h;
        return iHashCode7 + (str != null ? str.hashCode() : 0);
    }

    public final MY4 i() {
        return this.g;
    }

    public final NY4 j() {
        return this.f;
    }

    public String toString() {
        return "PassportMainUiState(formUiState=" + this.a + ", loadingState=" + this.b + ", datePickerState=" + this.c + ", closeState=" + this.d + ", dialogState=" + this.e + ", toastState=" + this.f + ", snackBarState=" + this.g + ", openUpdateUrl=" + this.h + Separators.RPAREN;
    }

    public /* synthetic */ OY4(C19777qv2 c19777qv2, AY4 ay4, IA1 ia1, C20751sY4 c20751sY4, EnumC21371tY4 enumC21371tY4, NY4 ny4, MY4 my4, String str, int i, ED1 ed1) {
        this((i & 1) != 0 ? new C19777qv2(null, null, 3, null) : c19777qv2, (i & 2) != 0 ? AY4.a : ay4, (i & 4) != 0 ? null : ia1, (i & 8) != 0 ? null : c20751sY4, (i & 16) != 0 ? null : enumC21371tY4, (i & 32) != 0 ? null : ny4, (i & 64) != 0 ? null : my4, (i & 128) == 0 ? str : null);
    }
}
