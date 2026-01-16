package ir.nasim;

import android.gov.nist.core.Separators;

/* loaded from: classes8.dex */
public final class RJ1 {
    private final EnumC23696xM4 a;

    public RJ1(EnumC23696xM4 enumC23696xM4) {
        AbstractC13042fc3.i(enumC23696xM4, "orientation");
        this.a = enumC23696xM4;
    }

    public final RJ1 a(EnumC23696xM4 enumC23696xM4) {
        AbstractC13042fc3.i(enumC23696xM4, "orientation");
        return new RJ1(enumC23696xM4);
    }

    public final EnumC23696xM4 b() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof RJ1) && this.a == ((RJ1) obj).a;
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    public String toString() {
        return "DeviceConfiguration(orientation=" + this.a + Separators.RPAREN;
    }

    public /* synthetic */ RJ1(EnumC23696xM4 enumC23696xM4, int i, ED1 ed1) {
        this((i & 1) != 0 ? EnumC23696xM4.a.a() : enumC23696xM4);
    }
}
