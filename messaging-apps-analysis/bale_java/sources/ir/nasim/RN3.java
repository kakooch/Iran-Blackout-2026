package ir.nasim;

import android.gov.nist.core.Separators;
import java.io.Serializable;

/* loaded from: classes8.dex */
final class RN3 implements Serializable {
    public final Object a;
    public final Object b;

    public RN3(Object obj, Object obj2) {
        this.a = obj;
        this.b = obj2;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof RN3)) {
            return false;
        }
        RN3 rn3 = (RN3) obj;
        Object obj2 = this.a;
        if (obj2 == null) {
            if (rn3.a != null) {
                return false;
            }
        } else if (!obj2.equals(rn3.a)) {
            return false;
        }
        Object obj3 = this.b;
        Object obj4 = rn3.b;
        if (obj3 == null) {
            if (obj4 != null) {
                return false;
            }
        } else if (!obj3.equals(obj4)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        Object obj = this.a;
        int iHashCode = obj == null ? 0 : obj.hashCode();
        Object obj2 = this.b;
        return iHashCode ^ (obj2 != null ? obj2.hashCode() : 0);
    }

    public String toString() {
        return this.a + Separators.EQUALS + this.b;
    }
}
