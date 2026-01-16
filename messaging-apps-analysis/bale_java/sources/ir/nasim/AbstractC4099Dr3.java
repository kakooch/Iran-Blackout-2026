package ir.nasim;

import java.util.List;

/* renamed from: ir.nasim.Dr3, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public abstract class AbstractC4099Dr3 implements InterfaceC10612bu, InterfaceC5050Hr3 {
    private int a;

    private AbstractC4099Dr3() {
    }

    private final int I0() {
        return AbstractC4816Gr3.a(this) ? super.hashCode() : (((K0().hashCode() * 31) + J0().hashCode()) * 31) + (L0() ? 1 : 0);
    }

    public abstract List J0();

    public abstract InterfaceC13882gy7 K0();

    public abstract boolean L0();

    public abstract AbstractC4099Dr3 M0(AbstractC5284Ir3 abstractC5284Ir3);

    public abstract AbstractC18174oC7 N0();

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AbstractC4099Dr3)) {
            return false;
        }
        AbstractC4099Dr3 abstractC4099Dr3 = (AbstractC4099Dr3) obj;
        return L0() == abstractC4099Dr3.L0() && C24396yY6.a.a(N0(), abstractC4099Dr3.N0());
    }

    public final int hashCode() {
        int i = this.a;
        if (i != 0) {
            return i;
        }
        int iI0 = I0();
        this.a = iI0;
        return iI0;
    }

    public abstract W24 o();

    public /* synthetic */ AbstractC4099Dr3(ED1 ed1) {
        this();
    }
}
