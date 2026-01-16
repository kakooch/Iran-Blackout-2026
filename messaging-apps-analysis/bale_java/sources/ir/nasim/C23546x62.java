package ir.nasim;

import android.gov.nist.core.Separators;
import java.util.Map;

/* renamed from: ir.nasim.x62, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C23546x62 {
    private final C13245fu a;
    private final Map b;

    public C23546x62(C13245fu c13245fu, Map map) {
        AbstractC13042fc3.i(c13245fu, "annotatedString");
        AbstractC13042fc3.i(map, "composeEmoji");
        this.a = c13245fu;
        this.b = map;
    }

    public final C13245fu a() {
        return this.a;
    }

    public final Map b() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C23546x62)) {
            return false;
        }
        C23546x62 c23546x62 = (C23546x62) obj;
        return AbstractC13042fc3.d(this.a, c23546x62.a) && AbstractC13042fc3.d(this.b, c23546x62.b);
    }

    public int hashCode() {
        return (this.a.hashCode() * 31) + this.b.hashCode();
    }

    public String toString() {
        C13245fu c13245fu = this.a;
        return "EmojiString(annotatedString=" + ((Object) c13245fu) + ", composeEmoji=" + this.b + Separators.RPAREN;
    }

    public /* synthetic */ C23546x62(C13245fu c13245fu, Map map, int i, ED1 ed1) {
        this(c13245fu, (i & 2) != 0 ? AbstractC20051rO3.k() : map);
    }
}
