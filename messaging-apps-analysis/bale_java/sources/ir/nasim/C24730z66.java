package ir.nasim;

import android.gov.nist.core.Separators;
import java.util.List;

/* renamed from: ir.nasim.z66, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C24730z66 {
    private final C11458d25 a;
    private final List b;

    public C24730z66(C11458d25 c11458d25, List list) {
        AbstractC13042fc3.i(c11458d25, "peer");
        AbstractC13042fc3.i(list, "reactions");
        this.a = c11458d25;
        this.b = list;
    }

    public final C11458d25 a() {
        return this.a;
    }

    public final List b() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C24730z66)) {
            return false;
        }
        C24730z66 c24730z66 = (C24730z66) obj;
        return AbstractC13042fc3.d(this.a, c24730z66.a) && AbstractC13042fc3.d(this.b, c24730z66.b);
    }

    public int hashCode() {
        return (this.a.hashCode() * 31) + this.b.hashCode();
    }

    public String toString() {
        return "RouterSetGroupAvailableReactions(peer=" + this.a + ", reactions=" + this.b + Separators.RPAREN;
    }
}
