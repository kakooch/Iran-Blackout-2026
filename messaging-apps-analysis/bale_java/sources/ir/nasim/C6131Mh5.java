package ir.nasim;

import android.gov.nist.core.Separators;
import java.util.List;

/* renamed from: ir.nasim.Mh5, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C6131Mh5 {
    private final List a;
    private final List b;
    private final String c;
    private final List d;
    private final boolean e;
    private final int f;

    public C6131Mh5(List list, List list2, String str, List list3, boolean z, int i) {
        AbstractC13042fc3.i(list, "answers");
        AbstractC13042fc3.i(list2, "fullResult");
        AbstractC13042fc3.i(str, "question");
        AbstractC13042fc3.i(list3, "voters");
        this.a = list;
        this.b = list2;
        this.c = str;
        this.d = list3;
        this.e = z;
        this.f = i;
    }

    public final List a() {
        return this.a;
    }

    public final List b() {
        return this.b;
    }

    public final List c() {
        return this.d;
    }

    public final int d() {
        return this.f;
    }

    public final boolean e() {
        return this.e;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C6131Mh5)) {
            return false;
        }
        C6131Mh5 c6131Mh5 = (C6131Mh5) obj;
        return AbstractC13042fc3.d(this.a, c6131Mh5.a) && AbstractC13042fc3.d(this.b, c6131Mh5.b) && AbstractC13042fc3.d(this.c, c6131Mh5.c) && AbstractC13042fc3.d(this.d, c6131Mh5.d) && this.e == c6131Mh5.e && this.f == c6131Mh5.f;
    }

    public int hashCode() {
        return (((((((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + Boolean.hashCode(this.e)) * 31) + Integer.hashCode(this.f);
    }

    public String toString() {
        return "PollResultUI(answers=" + this.a + ", fullResult=" + this.b + ", question=" + this.c + ", voters=" + this.d + ", isLoading=" + this.e + ", votersCount=" + this.f + Separators.RPAREN;
    }
}
