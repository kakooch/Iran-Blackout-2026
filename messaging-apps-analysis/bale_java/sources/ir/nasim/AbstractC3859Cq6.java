package ir.nasim;

import java.util.List;
import kotlinx.serialization.KSerializer;

/* renamed from: ir.nasim.Cq6, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public abstract class AbstractC3859Cq6 {
    private AbstractC3859Cq6() {
    }

    public static /* synthetic */ KSerializer c(AbstractC3859Cq6 abstractC3859Cq6, InterfaceC11299cm3 interfaceC11299cm3, List list, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getContextual");
        }
        if ((i & 2) != 0) {
            list = AbstractC10360bX0.m();
        }
        return abstractC3859Cq6.b(interfaceC11299cm3, list);
    }

    public abstract void a(InterfaceC4561Fq6 interfaceC4561Fq6);

    public abstract KSerializer b(InterfaceC11299cm3 interfaceC11299cm3, List list);

    public abstract XI1 d(InterfaceC11299cm3 interfaceC11299cm3, String str);

    public abstract InterfaceC22798vq6 e(InterfaceC11299cm3 interfaceC11299cm3, Object obj);

    public /* synthetic */ AbstractC3859Cq6(ED1 ed1) {
        this();
    }
}
