package ir.nasim;

import java.util.List;

/* renamed from: ir.nasim.yb8, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public abstract class AbstractC24426yb8 extends AbstractC4099Dr3 {
    public AbstractC24426yb8() {
        super(null);
    }

    @Override // ir.nasim.AbstractC4099Dr3
    public List J0() {
        return O0().J0();
    }

    @Override // ir.nasim.AbstractC4099Dr3
    public InterfaceC13882gy7 K0() {
        return O0().K0();
    }

    @Override // ir.nasim.AbstractC4099Dr3
    public boolean L0() {
        return O0().L0();
    }

    @Override // ir.nasim.AbstractC4099Dr3
    public final AbstractC18174oC7 N0() {
        AbstractC4099Dr3 abstractC4099Dr3O0 = O0();
        while (abstractC4099Dr3O0 instanceof AbstractC24426yb8) {
            abstractC4099Dr3O0 = ((AbstractC24426yb8) abstractC4099Dr3O0).O0();
        }
        return (AbstractC18174oC7) abstractC4099Dr3O0;
    }

    protected abstract AbstractC4099Dr3 O0();

    public abstract boolean P0();

    @Override // ir.nasim.InterfaceC10612bu
    public InterfaceC4356Eu getAnnotations() {
        return O0().getAnnotations();
    }

    @Override // ir.nasim.AbstractC4099Dr3
    public W24 o() {
        return O0().o();
    }

    public String toString() {
        return P0() ? O0().toString() : "<Not computed yet>";
    }
}
