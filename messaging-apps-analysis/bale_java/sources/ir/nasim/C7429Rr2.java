package ir.nasim;

import android.gov.nist.core.Separators;
import java.util.List;

/* renamed from: ir.nasim.Rr2, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C7429Rr2 {
    private final int a;
    private final String b;
    private final List c;

    public C7429Rr2(int i, String str, List list) {
        AbstractC13042fc3.i(str, "name");
        AbstractC13042fc3.i(list, "peers");
        this.a = i;
        this.b = str;
        this.c = list;
    }

    public final int a() {
        return this.a;
    }

    public final String b() {
        return this.b;
    }

    public final List c() {
        return this.c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C7429Rr2)) {
            return false;
        }
        C7429Rr2 c7429Rr2 = (C7429Rr2) obj;
        return this.a == c7429Rr2.a && AbstractC13042fc3.d(this.b, c7429Rr2.b) && AbstractC13042fc3.d(this.c, c7429Rr2.c);
    }

    public int hashCode() {
        return (((Integer.hashCode(this.a) * 31) + this.b.hashCode()) * 31) + this.c.hashCode();
    }

    public String toString() {
        return "Folder(id=" + this.a + ", name=" + this.b + ", peers=" + this.c + Separators.RPAREN;
    }
}
