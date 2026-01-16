package ir.nasim;

import java.util.List;

/* loaded from: classes3.dex */
public final class Gj8 extends Ni8 {
    protected Gj8() {
        this.a.add(EnumC9901ak8.AND);
        this.a.add(EnumC9901ak8.NOT);
        this.a.add(EnumC9901ak8.OR);
    }

    @Override // ir.nasim.Ni8
    public final InterfaceC22720vi8 a(String str, C20322ro8 c20322ro8, List list) {
        EnumC9901ak8 enumC9901ak8 = EnumC9901ak8.ADD;
        int iOrdinal = AbstractC9951ap8.e(str).ordinal();
        if (iOrdinal == 1) {
            AbstractC9951ap8.h(EnumC9901ak8.AND.name(), 2, list);
            InterfaceC22720vi8 interfaceC22720vi8B = c20322ro8.b((InterfaceC22720vi8) list.get(0));
            return !interfaceC22720vi8B.o().booleanValue() ? interfaceC22720vi8B : c20322ro8.b((InterfaceC22720vi8) list.get(1));
        }
        if (iOrdinal == 47) {
            AbstractC9951ap8.h(EnumC9901ak8.NOT.name(), 1, list);
            return new Ih8(Boolean.valueOf(!c20322ro8.b((InterfaceC22720vi8) list.get(0)).o().booleanValue()));
        }
        if (iOrdinal != 50) {
            return super.b(str);
        }
        AbstractC9951ap8.h(EnumC9901ak8.OR.name(), 2, list);
        InterfaceC22720vi8 interfaceC22720vi8B2 = c20322ro8.b((InterfaceC22720vi8) list.get(0));
        return interfaceC22720vi8B2.o().booleanValue() ? interfaceC22720vi8B2 : c20322ro8.b((InterfaceC22720vi8) list.get(1));
    }
}
