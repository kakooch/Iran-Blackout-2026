package ir.nasim;

import java.util.List;

/* loaded from: classes8.dex */
public final class WJ extends AbstractC7068Qd1 {
    private final UA2 b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WJ(List list, UA2 ua2) {
        super(list);
        AbstractC13042fc3.i(list, "value");
        AbstractC13042fc3.i(ua2, "computeType");
        this.b = ua2;
    }

    @Override // ir.nasim.AbstractC7068Qd1
    public AbstractC4099Dr3 a(InterfaceC8507Wg4 interfaceC8507Wg4) {
        AbstractC13042fc3.i(interfaceC8507Wg4, "module");
        AbstractC4099Dr3 abstractC4099Dr3 = (AbstractC4099Dr3) this.b.invoke(interfaceC8507Wg4);
        if (!AbstractC19738qr3.b0(abstractC4099Dr3) && !AbstractC19738qr3.w0(abstractC4099Dr3)) {
            AbstractC19738qr3.K0(abstractC4099Dr3);
        }
        return abstractC4099Dr3;
    }
}
