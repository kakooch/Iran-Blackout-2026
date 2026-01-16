package ir.nasim;

import java.util.List;

/* loaded from: classes3.dex */
public final class Li8 extends Ni8 {
    public Li8() {
        this.a.add(EnumC9901ak8.BITWISE_AND);
        this.a.add(EnumC9901ak8.BITWISE_LEFT_SHIFT);
        this.a.add(EnumC9901ak8.BITWISE_NOT);
        this.a.add(EnumC9901ak8.BITWISE_OR);
        this.a.add(EnumC9901ak8.BITWISE_RIGHT_SHIFT);
        this.a.add(EnumC9901ak8.BITWISE_UNSIGNED_RIGHT_SHIFT);
        this.a.add(EnumC9901ak8.BITWISE_XOR);
    }

    @Override // ir.nasim.Ni8
    public final InterfaceC22720vi8 a(String str, C20322ro8 c20322ro8, List list) {
        EnumC9901ak8 enumC9901ak8 = EnumC9901ak8.ADD;
        switch (AbstractC9951ap8.e(str).ordinal()) {
            case 4:
                AbstractC9951ap8.h(EnumC9901ak8.BITWISE_AND.name(), 2, list);
                return new Ph8(Double.valueOf(AbstractC9951ap8.b(c20322ro8.b((InterfaceC22720vi8) list.get(0)).k().doubleValue()) & AbstractC9951ap8.b(c20322ro8.b((InterfaceC22720vi8) list.get(1)).k().doubleValue())));
            case 5:
                AbstractC9951ap8.h(EnumC9901ak8.BITWISE_LEFT_SHIFT.name(), 2, list);
                return new Ph8(Double.valueOf(AbstractC9951ap8.b(c20322ro8.b((InterfaceC22720vi8) list.get(0)).k().doubleValue()) << ((int) (AbstractC9951ap8.d(c20322ro8.b((InterfaceC22720vi8) list.get(1)).k().doubleValue()) & 31))));
            case 6:
                AbstractC9951ap8.h(EnumC9901ak8.BITWISE_NOT.name(), 1, list);
                return new Ph8(Double.valueOf(~AbstractC9951ap8.b(c20322ro8.b((InterfaceC22720vi8) list.get(0)).k().doubleValue())));
            case 7:
                AbstractC9951ap8.h(EnumC9901ak8.BITWISE_OR.name(), 2, list);
                return new Ph8(Double.valueOf(AbstractC9951ap8.b(c20322ro8.b((InterfaceC22720vi8) list.get(0)).k().doubleValue()) | AbstractC9951ap8.b(c20322ro8.b((InterfaceC22720vi8) list.get(1)).k().doubleValue())));
            case 8:
                AbstractC9951ap8.h(EnumC9901ak8.BITWISE_RIGHT_SHIFT.name(), 2, list);
                return new Ph8(Double.valueOf(AbstractC9951ap8.b(c20322ro8.b((InterfaceC22720vi8) list.get(0)).k().doubleValue()) >> ((int) (AbstractC9951ap8.d(c20322ro8.b((InterfaceC22720vi8) list.get(1)).k().doubleValue()) & 31))));
            case 9:
                AbstractC9951ap8.h(EnumC9901ak8.BITWISE_UNSIGNED_RIGHT_SHIFT.name(), 2, list);
                return new Ph8(Double.valueOf(AbstractC9951ap8.d(c20322ro8.b((InterfaceC22720vi8) list.get(0)).k().doubleValue()) >>> ((int) (AbstractC9951ap8.d(c20322ro8.b((InterfaceC22720vi8) list.get(1)).k().doubleValue()) & 31))));
            case 10:
                AbstractC9951ap8.h(EnumC9901ak8.BITWISE_XOR.name(), 2, list);
                return new Ph8(Double.valueOf(AbstractC9951ap8.b(c20322ro8.b((InterfaceC22720vi8) list.get(0)).k().doubleValue()) ^ AbstractC9951ap8.b(c20322ro8.b((InterfaceC22720vi8) list.get(1)).k().doubleValue())));
            default:
                return super.b(str);
        }
    }
}
