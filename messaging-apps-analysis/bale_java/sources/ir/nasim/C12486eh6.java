package ir.nasim;

import android.gov.nist.core.Separators;
import java.util.List;

/* renamed from: ir.nasim.eh6, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C12486eh6 {
    private final int a;
    private final List b;

    public C12486eh6(int i, List list) {
        AbstractC13042fc3.i(list, "searchMessages");
        this.a = i;
        this.b = list;
    }

    public final List a() {
        return this.b;
    }

    public final int b() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C12486eh6)) {
            return false;
        }
        C12486eh6 c12486eh6 = (C12486eh6) obj;
        return this.a == c12486eh6.a && AbstractC13042fc3.d(this.b, c12486eh6.b);
    }

    public int hashCode() {
        return (Integer.hashCode(this.a) * 31) + this.b.hashCode();
    }

    public String toString() {
        return "SearchResult(totalCounts=" + this.a + ", searchMessages=" + this.b + Separators.RPAREN;
    }
}
