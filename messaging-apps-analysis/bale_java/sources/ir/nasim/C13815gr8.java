package ir.nasim;

import java.util.HashMap;
import java.util.List;

/* renamed from: ir.nasim.gr8, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C13815gr8 extends Vh8 {
    private final C18461oh8 c;

    public C13815gr8(C18461oh8 c18461oh8) {
        super("internal.eventLogger");
        this.c = c18461oh8;
    }

    @Override // ir.nasim.Vh8
    public final InterfaceC22720vi8 a(C20322ro8 c20322ro8, List list) {
        AbstractC9951ap8.h(this.a, 3, list);
        String strJ = c20322ro8.b((InterfaceC22720vi8) list.get(0)).j();
        long jA = (long) AbstractC9951ap8.a(c20322ro8.b((InterfaceC22720vi8) list.get(1)).k().doubleValue());
        InterfaceC22720vi8 interfaceC22720vi8B = c20322ro8.b((InterfaceC22720vi8) list.get(2));
        this.c.e(strJ, jA, interfaceC22720vi8B instanceof C17289mi8 ? AbstractC9951ap8.g((C17289mi8) interfaceC22720vi8B) : new HashMap());
        return InterfaceC22720vi8.r0;
    }
}
