package ir.nasim;

import android.gov.nist.core.Separators;
import ir.nasim.database.dailogLists.DialogEntity;
import ir.nasim.features.pfm.entity.PFMTransaction;
import java.util.List;

/* renamed from: ir.nasim.Wa6, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C8455Wa6 {
    public static final a h = new a(null);
    public static final int i = 8;
    private final String a;
    private final long b;
    private final String c;
    private final String d;
    private final long e;
    private final long f;
    private final PFMTransaction g;

    /* renamed from: ir.nasim.Wa6$a */
    public static final class a {
        private a() {
        }

        public final C8455Wa6 a(J44 j44) {
            String strV;
            AbstractC13042fc3.i(j44, DialogEntity.COLUMN_MESSAGE);
            C23345wl7 c23345wl7L = j44.F().l();
            if (c23345wl7L == null || (strV = c23345wl7L.v()) == null) {
                strV = "";
            }
            if (!AbstractC20762sZ6.n0(strV)) {
                try {
                    List listU0 = AbstractC20762sZ6.u0(strV);
                    String strSubstring = ((String) listU0.get(1)).substring(AbstractC20762sZ6.l0((CharSequence) listU0.get(1), Separators.STAR, 0, false, 6, null) + 2, AbstractC20762sZ6.r0((CharSequence) listU0.get(1), Separators.STAR, 0, false, 6, null));
                    AbstractC13042fc3.h(strSubstring, "substring(...)");
                    String strM = AbstractC20153rZ6.M(strSubstring, "_", Separators.SP, false, 4, null);
                    String strSubstring2 = ((String) listU0.get(2)).substring(AbstractC20762sZ6.l0((CharSequence) listU0.get(2), Separators.STAR, 0, false, 6, null) + 1, AbstractC20762sZ6.r0((CharSequence) listU0.get(2), Separators.STAR, 0, false, 6, null));
                    AbstractC13042fc3.h(strSubstring2, "substring(...)");
                    String strSubstring3 = ((String) listU0.get(3)).substring(AbstractC20762sZ6.l0((CharSequence) listU0.get(3), Separators.STAR, 0, false, 6, null) + 1, AbstractC20762sZ6.r0((CharSequence) listU0.get(3), Separators.STAR, 0, false, 6, null));
                    AbstractC13042fc3.h(strSubstring3, "substring(...)");
                    String strSubstring4 = ((String) listU0.get(4)).substring(AbstractC20762sZ6.l0((CharSequence) listU0.get(4), Separators.STAR, 0, false, 6, null) + 2, AbstractC20762sZ6.r0((CharSequence) listU0.get(4), Separators.STAR, 0, false, 6, null));
                    AbstractC13042fc3.h(strSubstring4, "substring(...)");
                    long j = Long.parseLong(strSubstring4);
                    return new C8455Wa6(strSubstring2, j, strSubstring3, strM, j44.i(), j44.h(), new PFMTransaction(j44.i(), j44.h(), XY6.h(AbstractC20153rZ6.M(AbstractC20153rZ6.M(AbstractC20153rZ6.M(strSubstring2, ",", "", false, 4, null), "-", "", false, 4, null), "+", "", false, 4, null)), AbstractC20762sZ6.X(strSubstring2, "+", false, 2, null) ? EnumC18897pR4.c : AbstractC20762sZ6.X(strSubstring2, "-", false, 2, null) ? EnumC18897pR4.d : EnumC18897pR4.b, j, strM, AbstractC10360bX0.m(), null, null, 384, null));
                } catch (Exception e) {
                    C19406qI3.b("SaptaPushModel", "showSaptaNotification: " + e.getMessage());
                }
            }
            return null;
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public C8455Wa6(String str, long j, String str2, String str3, long j2, long j3, PFMTransaction pFMTransaction) {
        AbstractC13042fc3.i(str, "amount");
        AbstractC13042fc3.i(str2, "remain");
        AbstractC13042fc3.i(str3, "about");
        AbstractC13042fc3.i(pFMTransaction, "transaction");
        this.a = str;
        this.b = j;
        this.c = str2;
        this.d = str3;
        this.e = j2;
        this.f = j3;
        this.g = pFMTransaction;
    }

    public final long a() {
        return this.b;
    }

    public final long b() {
        return this.e;
    }

    public final long c() {
        return this.f;
    }

    public final PFMTransaction d() {
        return this.g;
    }

    public final String e() {
        return this.d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C8455Wa6)) {
            return false;
        }
        C8455Wa6 c8455Wa6 = (C8455Wa6) obj;
        return AbstractC13042fc3.d(this.a, c8455Wa6.a) && this.b == c8455Wa6.b && AbstractC13042fc3.d(this.c, c8455Wa6.c) && AbstractC13042fc3.d(this.d, c8455Wa6.d) && this.e == c8455Wa6.e && this.f == c8455Wa6.f && AbstractC13042fc3.d(this.g, c8455Wa6.g);
    }

    public final long f() {
        return this.b;
    }

    public final String g() {
        return this.a;
    }

    public final String h() {
        return this.c;
    }

    public int hashCode() {
        return (((((((((((this.a.hashCode() * 31) + Long.hashCode(this.b)) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + Long.hashCode(this.e)) * 31) + Long.hashCode(this.f)) * 31) + this.g.hashCode();
    }

    public final PFMTransaction i() {
        return this.g;
    }

    public String toString() {
        return "SaptaPushModel(amount=" + this.a + ", accountNumber=" + this.b + ", remain=" + this.c + ", about=" + this.d + ", rid=" + this.e + ", date=" + this.f + ", transaction=" + this.g + Separators.RPAREN;
    }
}
