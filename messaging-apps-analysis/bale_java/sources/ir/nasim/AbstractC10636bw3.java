package ir.nasim;

import ir.nasim.AbstractC9416Zv3;
import java.util.Collection;
import java.util.List;

/* renamed from: ir.nasim.bw3, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public abstract class AbstractC10636bw3 extends AbstractC9416Zv3 {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AbstractC10636bw3(C9182Yv3 c9182Yv3) {
        super(c9182Yv3, null, 2, null);
        AbstractC13042fc3.i(c9182Yv3, "c");
    }

    @Override // ir.nasim.AbstractC9416Zv3
    protected AbstractC9416Zv3.a H(InterfaceC20257ri3 interfaceC20257ri3, List list, AbstractC4099Dr3 abstractC4099Dr3, List list2) {
        AbstractC13042fc3.i(interfaceC20257ri3, "method");
        AbstractC13042fc3.i(list, "methodTypeParameters");
        AbstractC13042fc3.i(abstractC4099Dr3, "returnType");
        AbstractC13042fc3.i(list2, "valueParameters");
        return new AbstractC9416Zv3.a(abstractC4099Dr3, null, list2, list, false, AbstractC10360bX0.m());
    }

    @Override // ir.nasim.AbstractC9416Zv3
    protected void s(C6432No4 c6432No4, Collection collection) {
        AbstractC13042fc3.i(c6432No4, "name");
        AbstractC13042fc3.i(collection, "result");
    }

    @Override // ir.nasim.AbstractC9416Zv3
    protected ZI5 z() {
        return null;
    }
}
