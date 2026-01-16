package ir.nasim;

import java.util.List;

/* loaded from: classes3.dex */
public final class Wj8 extends Ni8 {
    protected Wj8() {
        this.a.add(EnumC9901ak8.ADD);
        this.a.add(EnumC9901ak8.DIVIDE);
        this.a.add(EnumC9901ak8.MODULUS);
        this.a.add(EnumC9901ak8.MULTIPLY);
        this.a.add(EnumC9901ak8.NEGATE);
        this.a.add(EnumC9901ak8.POST_DECREMENT);
        this.a.add(EnumC9901ak8.POST_INCREMENT);
        this.a.add(EnumC9901ak8.PRE_DECREMENT);
        this.a.add(EnumC9901ak8.PRE_INCREMENT);
        this.a.add(EnumC9901ak8.SUBTRACT);
    }

    @Override // ir.nasim.Ni8
    public final InterfaceC22720vi8 a(String str, C20322ro8 c20322ro8, List list) {
        EnumC9901ak8 enumC9901ak8 = EnumC9901ak8.ADD;
        int iOrdinal = AbstractC9951ap8.e(str).ordinal();
        if (iOrdinal == 0) {
            AbstractC9951ap8.h(EnumC9901ak8.ADD.name(), 2, list);
            InterfaceC22720vi8 interfaceC22720vi8B = c20322ro8.b((InterfaceC22720vi8) list.get(0));
            InterfaceC22720vi8 interfaceC22720vi8B2 = c20322ro8.b((InterfaceC22720vi8) list.get(1));
            return ((interfaceC22720vi8B instanceof InterfaceC14926ii8) || (interfaceC22720vi8B instanceof Ei8) || (interfaceC22720vi8B2 instanceof InterfaceC14926ii8) || (interfaceC22720vi8B2 instanceof Ei8)) ? new Ei8(String.valueOf(interfaceC22720vi8B.j()).concat(String.valueOf(interfaceC22720vi8B2.j()))) : new Ph8(Double.valueOf(interfaceC22720vi8B.k().doubleValue() + interfaceC22720vi8B2.k().doubleValue()));
        }
        if (iOrdinal == 21) {
            AbstractC9951ap8.h(EnumC9901ak8.DIVIDE.name(), 2, list);
            return new Ph8(Double.valueOf(c20322ro8.b((InterfaceC22720vi8) list.get(0)).k().doubleValue() / c20322ro8.b((InterfaceC22720vi8) list.get(1)).k().doubleValue()));
        }
        if (iOrdinal == 59) {
            AbstractC9951ap8.h(EnumC9901ak8.SUBTRACT.name(), 2, list);
            return new Ph8(Double.valueOf(c20322ro8.b((InterfaceC22720vi8) list.get(0)).k().doubleValue() + new Ph8(Double.valueOf(-c20322ro8.b((InterfaceC22720vi8) list.get(1)).k().doubleValue())).k().doubleValue()));
        }
        if (iOrdinal == 52 || iOrdinal == 53) {
            AbstractC9951ap8.h(str, 2, list);
            InterfaceC22720vi8 interfaceC22720vi8B3 = c20322ro8.b((InterfaceC22720vi8) list.get(0));
            c20322ro8.b((InterfaceC22720vi8) list.get(1));
            return interfaceC22720vi8B3;
        }
        if (iOrdinal == 55 || iOrdinal == 56) {
            AbstractC9951ap8.h(str, 1, list);
            return c20322ro8.b((InterfaceC22720vi8) list.get(0));
        }
        switch (iOrdinal) {
            case 44:
                AbstractC9951ap8.h(EnumC9901ak8.MODULUS.name(), 2, list);
                return new Ph8(Double.valueOf(c20322ro8.b((InterfaceC22720vi8) list.get(0)).k().doubleValue() % c20322ro8.b((InterfaceC22720vi8) list.get(1)).k().doubleValue()));
            case 45:
                AbstractC9951ap8.h(EnumC9901ak8.MULTIPLY.name(), 2, list);
                return new Ph8(Double.valueOf(c20322ro8.b((InterfaceC22720vi8) list.get(0)).k().doubleValue() * c20322ro8.b((InterfaceC22720vi8) list.get(1)).k().doubleValue()));
            case 46:
                AbstractC9951ap8.h(EnumC9901ak8.NEGATE.name(), 1, list);
                return new Ph8(Double.valueOf(-c20322ro8.b((InterfaceC22720vi8) list.get(0)).k().doubleValue()));
            default:
                return super.b(str);
        }
    }
}
