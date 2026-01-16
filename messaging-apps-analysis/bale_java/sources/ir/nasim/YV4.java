package ir.nasim;

import android.gov.nist.core.Separators;

/* loaded from: classes2.dex */
public class YV4 {
    public final Object a;
    public final Object b;

    public YV4(Object obj, Object obj2) {
        this.a = obj;
        this.b = obj2;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof YV4)) {
            return false;
        }
        YV4 yv4 = (YV4) obj;
        return FG4.a(yv4.a, this.a) && FG4.a(yv4.b, this.b);
    }

    public int hashCode() {
        Object obj = this.a;
        int iHashCode = obj == null ? 0 : obj.hashCode();
        Object obj2 = this.b;
        return iHashCode ^ (obj2 != null ? obj2.hashCode() : 0);
    }

    public String toString() {
        return "Pair{" + this.a + Separators.SP + this.b + "}";
    }
}
