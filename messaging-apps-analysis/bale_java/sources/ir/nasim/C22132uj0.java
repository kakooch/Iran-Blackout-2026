package ir.nasim;

import android.gov.nist.core.Separators;

/* renamed from: ir.nasim.uj0, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C22132uj0 {
    public static final int c = 0;
    private final Integer a;
    private final String b;

    public C22132uj0(Integer num, String str) {
        this.a = num;
        this.b = str;
    }

    public final String a() {
        return this.b;
    }

    public final Integer b() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C22132uj0)) {
            return false;
        }
        C22132uj0 c22132uj0 = (C22132uj0) obj;
        return AbstractC13042fc3.d(this.a, c22132uj0.a) && AbstractC13042fc3.d(this.b, c22132uj0.b);
    }

    public int hashCode() {
        Integer num = this.a;
        int iHashCode = (num == null ? 0 : num.hashCode()) * 31;
        String str = this.b;
        return iHashCode + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        return "BotReviewData(rating=" + this.a + ", comment=" + this.b + Separators.RPAREN;
    }
}
