package ir.nasim;

import android.gov.nist.core.Separators;
import java.util.List;

/* renamed from: ir.nasim.ai5, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C9878ai5 {
    private final String a;
    private final List b;
    private final boolean c;
    private final boolean d;
    private final Integer e;
    private final boolean f;

    public C9878ai5(String str, List list, boolean z, boolean z2, Integer num, boolean z3) {
        AbstractC13042fc3.i(str, "question");
        AbstractC13042fc3.i(list, "answers");
        this.a = str;
        this.b = list;
        this.c = z;
        this.d = z2;
        this.e = num;
        this.f = z3;
    }

    public static /* synthetic */ C9878ai5 b(C9878ai5 c9878ai5, String str, List list, boolean z, boolean z2, Integer num, boolean z3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = c9878ai5.a;
        }
        if ((i & 2) != 0) {
            list = c9878ai5.b;
        }
        List list2 = list;
        if ((i & 4) != 0) {
            z = c9878ai5.c;
        }
        boolean z4 = z;
        if ((i & 8) != 0) {
            z2 = c9878ai5.d;
        }
        boolean z5 = z2;
        if ((i & 16) != 0) {
            num = c9878ai5.e;
        }
        Integer num2 = num;
        if ((i & 32) != 0) {
            z3 = c9878ai5.f;
        }
        return c9878ai5.a(str, list2, z4, z5, num2, z3);
    }

    public final C9878ai5 a(String str, List list, boolean z, boolean z2, Integer num, boolean z3) {
        AbstractC13042fc3.i(str, "question");
        AbstractC13042fc3.i(list, "answers");
        return new C9878ai5(str, list, z, z2, num, z3);
    }

    public final List c() {
        return this.b;
    }

    public final String d() {
        return this.a;
    }

    public final Integer e() {
        return this.e;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C9878ai5)) {
            return false;
        }
        C9878ai5 c9878ai5 = (C9878ai5) obj;
        return AbstractC13042fc3.d(this.a, c9878ai5.a) && AbstractC13042fc3.d(this.b, c9878ai5.b) && this.c == c9878ai5.c && this.d == c9878ai5.d && AbstractC13042fc3.d(this.e, c9878ai5.e) && this.f == c9878ai5.f;
    }

    public final boolean f() {
        return this.f;
    }

    public final boolean g() {
        return this.c;
    }

    public final boolean h() {
        return this.d;
    }

    public int hashCode() {
        int iHashCode = ((((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + Boolean.hashCode(this.c)) * 31) + Boolean.hashCode(this.d)) * 31;
        Integer num = this.e;
        return ((iHashCode + (num == null ? 0 : num.hashCode())) * 31) + Boolean.hashCode(this.f);
    }

    public String toString() {
        return "PollUiState(question=" + this.a + ", answers=" + this.b + ", isMultipleChoice=" + this.c + ", isUnknown=" + this.d + ", snackBarMessage=" + this.e + ", isCreatePollSuccessful=" + this.f + Separators.RPAREN;
    }

    public /* synthetic */ C9878ai5(String str, List list, boolean z, boolean z2, Integer num, boolean z3, int i, ED1 ed1) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? AbstractC9766aX0.e("") : list, (i & 4) != 0 ? false : z, (i & 8) != 0 ? true : z2, (i & 16) != 0 ? null : num, (i & 32) != 0 ? false : z3);
    }
}
