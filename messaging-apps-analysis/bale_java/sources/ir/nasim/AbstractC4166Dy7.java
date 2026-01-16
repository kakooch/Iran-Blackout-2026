package ir.nasim;

import android.gov.nist.core.Separators;

/* renamed from: ir.nasim.Dy7, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public abstract class AbstractC4166Dy7 implements InterfaceC3932Cy7 {
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof InterfaceC3932Cy7)) {
            return false;
        }
        InterfaceC3932Cy7 interfaceC3932Cy7 = (InterfaceC3932Cy7) obj;
        return b() == interfaceC3932Cy7.b() && c() == interfaceC3932Cy7.c() && getType().equals(interfaceC3932Cy7.getType());
    }

    public int hashCode() {
        int iHashCode = c().hashCode();
        if (AbstractC7497Ry7.v(getType())) {
            return (iHashCode * 31) + 19;
        }
        return (iHashCode * 31) + (b() ? 17 : getType().hashCode());
    }

    public String toString() {
        if (b()) {
            return Separators.STAR;
        }
        if (c() == KQ7.INVARIANT) {
            return getType().toString();
        }
        return c() + Separators.SP + getType();
    }
}
