package ir.nasim;

import android.gov.nist.core.Separators;
import java.util.List;

/* renamed from: ir.nasim.qh5, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C19640qh5 {
    private final int a;
    private final int b;
    private final List c;

    public C19640qh5(int i, int i2, List list) {
        AbstractC13042fc3.i(list, "votersList");
        this.a = i;
        this.b = i2;
        this.c = list;
    }

    public final int a() {
        return this.a;
    }

    public final List b() {
        return this.c;
    }

    public final int c() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C19640qh5)) {
            return false;
        }
        C19640qh5 c19640qh5 = (C19640qh5) obj;
        return this.a == c19640qh5.a && this.b == c19640qh5.b && AbstractC13042fc3.d(this.c, c19640qh5.c);
    }

    public int hashCode() {
        return (((Integer.hashCode(this.a) * 31) + Integer.hashCode(this.b)) * 31) + this.c.hashCode();
    }

    public String toString() {
        return "PollFullResult(optionId=" + this.a + ", votesCount=" + this.b + ", votersList=" + this.c + Separators.RPAREN;
    }
}
