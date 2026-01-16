package ir.nasim;

import android.gov.nist.core.Separators;
import com.google.protobuf.BytesValue;
import java.util.List;

/* renamed from: ir.nasim.zg6, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C25068zg6 {
    private final long a;
    private final EnumC21528th6 b;
    private final EnumC16752lo2 c;
    private final EnumC16752lo2 d;
    private final String e;
    private final Long f;
    private final Integer g;
    private final int h;
    private final List i;
    private final int j;
    private final int k;
    private final BytesValue l;
    private final boolean m;

    public C25068zg6(long j, EnumC21528th6 enumC21528th6, EnumC16752lo2 enumC16752lo2, EnumC16752lo2 enumC16752lo22, String str, Long l, Integer num, int i, List list, int i2, int i3, BytesValue bytesValue, boolean z) {
        AbstractC13042fc3.i(enumC21528th6, "searchState");
        AbstractC13042fc3.i(enumC16752lo2, "dateFilterItemState");
        AbstractC13042fc3.i(enumC16752lo22, "personFilterItemState");
        AbstractC13042fc3.i(list, "result");
        this.a = j;
        this.b = enumC21528th6;
        this.c = enumC16752lo2;
        this.d = enumC16752lo22;
        this.e = str;
        this.f = l;
        this.g = num;
        this.h = i;
        this.i = list;
        this.j = i2;
        this.k = i3;
        this.l = bytesValue;
        this.m = z;
    }

    public final C25068zg6 a(long j, EnumC21528th6 enumC21528th6, EnumC16752lo2 enumC16752lo2, EnumC16752lo2 enumC16752lo22, String str, Long l, Integer num, int i, List list, int i2, int i3, BytesValue bytesValue, boolean z) {
        AbstractC13042fc3.i(enumC21528th6, "searchState");
        AbstractC13042fc3.i(enumC16752lo2, "dateFilterItemState");
        AbstractC13042fc3.i(enumC16752lo22, "personFilterItemState");
        AbstractC13042fc3.i(list, "result");
        return new C25068zg6(j, enumC21528th6, enumC16752lo2, enumC16752lo22, str, l, num, i, list, i2, i3, bytesValue, z);
    }

    public final long c() {
        return this.a;
    }

    public final int d() {
        return this.j;
    }

    public final EnumC16752lo2 e() {
        return this.c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C25068zg6)) {
            return false;
        }
        C25068zg6 c25068zg6 = (C25068zg6) obj;
        return this.a == c25068zg6.a && this.b == c25068zg6.b && this.c == c25068zg6.c && this.d == c25068zg6.d && AbstractC13042fc3.d(this.e, c25068zg6.e) && AbstractC13042fc3.d(this.f, c25068zg6.f) && AbstractC13042fc3.d(this.g, c25068zg6.g) && this.h == c25068zg6.h && AbstractC13042fc3.d(this.i, c25068zg6.i) && this.j == c25068zg6.j && this.k == c25068zg6.k && AbstractC13042fc3.d(this.l, c25068zg6.l) && this.m == c25068zg6.m;
    }

    public final String f() {
        return this.e;
    }

    public final EnumC16752lo2 g() {
        return this.d;
    }

    public final int h() {
        return this.k;
    }

    public int hashCode() {
        int iHashCode = ((((((Long.hashCode(this.a) * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31;
        String str = this.e;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        Long l = this.f;
        int iHashCode3 = (iHashCode2 + (l == null ? 0 : l.hashCode())) * 31;
        Integer num = this.g;
        int iHashCode4 = (((((((((iHashCode3 + (num == null ? 0 : num.hashCode())) * 31) + Integer.hashCode(this.h)) * 31) + this.i.hashCode()) * 31) + Integer.hashCode(this.j)) * 31) + Integer.hashCode(this.k)) * 31;
        BytesValue bytesValue = this.l;
        return ((iHashCode4 + (bytesValue != null ? bytesValue.hashCode() : 0)) * 31) + Boolean.hashCode(this.m);
    }

    public final List i() {
        return this.i;
    }

    public final int j() {
        return this.h;
    }

    public final BytesValue k() {
        return this.l;
    }

    public final EnumC21528th6 l() {
        return this.b;
    }

    public final Long m() {
        return this.f;
    }

    public final Integer n() {
        return this.g;
    }

    public final boolean o() {
        return this.m;
    }

    public String toString() {
        return "SearchMessageUiState(createtimestamp=" + this.a + ", searchState=" + this.b + ", dateFilterItemState=" + this.c + ", personFilterItemState=" + this.d + ", keyword=" + this.e + ", selectedDate=" + this.f + ", senderId=" + this.g + ", resultCount=" + this.h + ", result=" + this.i + ", currentScrollItemPosition=" + this.j + ", previousScrollItemPosition=" + this.k + ", searchResultNextPage=" + this.l + ", shouldShowSenderSelection=" + this.m + Separators.RPAREN;
    }

    public /* synthetic */ C25068zg6(long j, EnumC21528th6 enumC21528th6, EnumC16752lo2 enumC16752lo2, EnumC16752lo2 enumC16752lo22, String str, Long l, Integer num, int i, List list, int i2, int i3, BytesValue bytesValue, boolean z, int i4, ED1 ed1) {
        this((i4 & 1) != 0 ? System.currentTimeMillis() : j, (i4 & 2) != 0 ? EnumC21528th6.a : enumC21528th6, (i4 & 4) != 0 ? EnumC16752lo2.b : enumC16752lo2, (i4 & 8) != 0 ? EnumC16752lo2.b : enumC16752lo22, (i4 & 16) != 0 ? null : str, (i4 & 32) != 0 ? null : l, (i4 & 64) != 0 ? null : num, (i4 & 128) != 0 ? 0 : i, (i4 & 256) != 0 ? AbstractC10360bX0.m() : list, (i4 & 512) != 0 ? -1 : i2, (i4 & 1024) == 0 ? i3 : -1, (i4 & 2048) == 0 ? bytesValue : null, (i4 & 4096) == 0 ? z : false);
    }
}
