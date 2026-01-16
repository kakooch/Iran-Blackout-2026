package ir.nasim;

import android.gov.nist.core.Separators;

/* renamed from: ir.nasim.tC7, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C21159tC7 extends AbstractC20556sC7 {
    private final int a;
    private final Integer b;
    private final String c;

    public C21159tC7(int i, Integer num, String str) {
        super(null);
        this.a = i;
        this.b = num;
        this.c = str;
    }

    public final int a() {
        return this.a;
    }

    public final String b() {
        return this.c;
    }

    public final Integer c() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C21159tC7)) {
            return false;
        }
        C21159tC7 c21159tC7 = (C21159tC7) obj;
        return this.a == c21159tC7.a && AbstractC13042fc3.d(this.b, c21159tC7.b) && AbstractC13042fc3.d(this.c, c21159tC7.c);
    }

    public int hashCode() {
        int iHashCode = Integer.hashCode(this.a) * 31;
        Integer num = this.b;
        int iHashCode2 = (iHashCode + (num == null ? 0 : num.hashCode())) * 31;
        String str = this.c;
        return iHashCode2 + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        return "UpdateAskBotReview(botId=" + this.a + ", previousRating=" + this.b + ", previousComment=" + this.c + Separators.RPAREN;
    }
}
