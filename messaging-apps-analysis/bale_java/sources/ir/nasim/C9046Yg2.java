package ir.nasim;

import android.gov.nist.core.Separators;

/* renamed from: ir.nasim.Yg2, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C9046Yg2 {
    private final int a;
    private final String b;
    private final String c;

    public C9046Yg2(int i, String str, String str2) {
        AbstractC13042fc3.i(str, "persianName");
        AbstractC13042fc3.i(str2, "englishName");
        this.a = i;
        this.b = str;
        this.c = str2;
    }

    public final int a() {
        return this.a;
    }

    public final String b() {
        return this.c;
    }

    public final String c() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C9046Yg2)) {
            return false;
        }
        C9046Yg2 c9046Yg2 = (C9046Yg2) obj;
        return this.a == c9046Yg2.a && AbstractC13042fc3.d(this.b, c9046Yg2.b) && AbstractC13042fc3.d(this.c, c9046Yg2.c);
    }

    public int hashCode() {
        return (((Integer.hashCode(this.a) * 31) + this.b.hashCode()) * 31) + this.c.hashCode();
    }

    public String toString() {
        return "FeedCategory(categoryId=" + this.a + ", persianName=" + this.b + ", englishName=" + this.c + Separators.RPAREN;
    }
}
