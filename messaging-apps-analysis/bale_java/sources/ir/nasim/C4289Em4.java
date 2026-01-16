package ir.nasim;

import android.gov.nist.core.Separators;

/* renamed from: ir.nasim.Em4, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C4289Em4 {
    Object a;
    Object b;

    private static boolean a(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public void b(Object obj, Object obj2) {
        this.a = obj;
        this.b = obj2;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof YV4)) {
            return false;
        }
        YV4 yv4 = (YV4) obj;
        return a(yv4.a, this.a) && a(yv4.b, this.b);
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
