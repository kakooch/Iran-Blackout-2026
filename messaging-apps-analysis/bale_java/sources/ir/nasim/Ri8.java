package ir.nasim;

import java.util.List;

/* loaded from: classes3.dex */
public final class Ri8 extends Ni8 {
    public Ri8() {
        this.a.add(EnumC9901ak8.EQUALS);
        this.a.add(EnumC9901ak8.GREATER_THAN);
        this.a.add(EnumC9901ak8.GREATER_THAN_EQUALS);
        this.a.add(EnumC9901ak8.IDENTITY_EQUALS);
        this.a.add(EnumC9901ak8.IDENTITY_NOT_EQUALS);
        this.a.add(EnumC9901ak8.LESS_THAN);
        this.a.add(EnumC9901ak8.LESS_THAN_EQUALS);
        this.a.add(EnumC9901ak8.NOT_EQUALS);
    }

    private static boolean c(InterfaceC22720vi8 interfaceC22720vi8, InterfaceC22720vi8 interfaceC22720vi82) {
        if (interfaceC22720vi8.getClass().equals(interfaceC22720vi82.getClass())) {
            if ((interfaceC22720vi8 instanceof Ii8) || (interfaceC22720vi8 instanceof C19062pi8)) {
                return true;
            }
            return interfaceC22720vi8 instanceof Ph8 ? (Double.isNaN(interfaceC22720vi8.k().doubleValue()) || Double.isNaN(interfaceC22720vi82.k().doubleValue()) || interfaceC22720vi8.k().doubleValue() != interfaceC22720vi82.k().doubleValue()) ? false : true : interfaceC22720vi8 instanceof Ei8 ? interfaceC22720vi8.j().equals(interfaceC22720vi82.j()) : interfaceC22720vi8 instanceof Ih8 ? interfaceC22720vi8.o().equals(interfaceC22720vi82.o()) : interfaceC22720vi8 == interfaceC22720vi82;
        }
        if (((interfaceC22720vi8 instanceof Ii8) || (interfaceC22720vi8 instanceof C19062pi8)) && ((interfaceC22720vi82 instanceof Ii8) || (interfaceC22720vi82 instanceof C19062pi8))) {
            return true;
        }
        boolean z = interfaceC22720vi8 instanceof Ph8;
        if (z && (interfaceC22720vi82 instanceof Ei8)) {
            return c(interfaceC22720vi8, new Ph8(interfaceC22720vi82.k()));
        }
        boolean z2 = interfaceC22720vi8 instanceof Ei8;
        if (z2 && (interfaceC22720vi82 instanceof Ph8)) {
            return c(new Ph8(interfaceC22720vi8.k()), interfaceC22720vi82);
        }
        if (interfaceC22720vi8 instanceof Ih8) {
            return c(new Ph8(interfaceC22720vi8.k()), interfaceC22720vi82);
        }
        if (interfaceC22720vi82 instanceof Ih8) {
            return c(interfaceC22720vi8, new Ph8(interfaceC22720vi82.k()));
        }
        if ((z2 || z) && (interfaceC22720vi82 instanceof InterfaceC14926ii8)) {
            return c(interfaceC22720vi8, new Ei8(interfaceC22720vi82.j()));
        }
        if ((interfaceC22720vi8 instanceof InterfaceC14926ii8) && ((interfaceC22720vi82 instanceof Ei8) || (interfaceC22720vi82 instanceof Ph8))) {
            return c(new Ei8(interfaceC22720vi8.j()), interfaceC22720vi82);
        }
        return false;
    }

    private static boolean d(InterfaceC22720vi8 interfaceC22720vi8, InterfaceC22720vi8 interfaceC22720vi82) {
        if (interfaceC22720vi8 instanceof InterfaceC14926ii8) {
            interfaceC22720vi8 = new Ei8(interfaceC22720vi8.j());
        }
        if (interfaceC22720vi82 instanceof InterfaceC14926ii8) {
            interfaceC22720vi82 = new Ei8(interfaceC22720vi82.j());
        }
        if ((interfaceC22720vi8 instanceof Ei8) && (interfaceC22720vi82 instanceof Ei8)) {
            return interfaceC22720vi8.j().compareTo(interfaceC22720vi82.j()) < 0;
        }
        double dDoubleValue = interfaceC22720vi8.k().doubleValue();
        double dDoubleValue2 = interfaceC22720vi82.k().doubleValue();
        return (Double.isNaN(dDoubleValue) || Double.isNaN(dDoubleValue2) || (dDoubleValue == 0.0d && dDoubleValue2 == 0.0d) || ((dDoubleValue == 0.0d && dDoubleValue2 == 0.0d) || Double.compare(dDoubleValue, dDoubleValue2) >= 0)) ? false : true;
    }

    private static boolean e(InterfaceC22720vi8 interfaceC22720vi8, InterfaceC22720vi8 interfaceC22720vi82) {
        if (interfaceC22720vi8 instanceof InterfaceC14926ii8) {
            interfaceC22720vi8 = new Ei8(interfaceC22720vi8.j());
        }
        if (interfaceC22720vi82 instanceof InterfaceC14926ii8) {
            interfaceC22720vi82 = new Ei8(interfaceC22720vi82.j());
        }
        return (((interfaceC22720vi8 instanceof Ei8) && (interfaceC22720vi82 instanceof Ei8)) || !(Double.isNaN(interfaceC22720vi8.k().doubleValue()) || Double.isNaN(interfaceC22720vi82.k().doubleValue()))) && !d(interfaceC22720vi82, interfaceC22720vi8);
    }

    @Override // ir.nasim.Ni8
    public final InterfaceC22720vi8 a(String str, C20322ro8 c20322ro8, List list) {
        boolean zC;
        boolean zC2;
        AbstractC9951ap8.h(AbstractC9951ap8.e(str).name(), 2, list);
        InterfaceC22720vi8 interfaceC22720vi8B = c20322ro8.b((InterfaceC22720vi8) list.get(0));
        InterfaceC22720vi8 interfaceC22720vi8B2 = c20322ro8.b((InterfaceC22720vi8) list.get(1));
        int iOrdinal = AbstractC9951ap8.e(str).ordinal();
        if (iOrdinal != 23) {
            if (iOrdinal == 48) {
                zC2 = c(interfaceC22720vi8B, interfaceC22720vi8B2);
            } else if (iOrdinal == 42) {
                zC = d(interfaceC22720vi8B, interfaceC22720vi8B2);
            } else if (iOrdinal != 43) {
                switch (iOrdinal) {
                    case 37:
                        zC = d(interfaceC22720vi8B2, interfaceC22720vi8B);
                        break;
                    case 38:
                        zC = e(interfaceC22720vi8B2, interfaceC22720vi8B);
                        break;
                    case 39:
                        zC = AbstractC9951ap8.l(interfaceC22720vi8B, interfaceC22720vi8B2);
                        break;
                    case 40:
                        zC2 = AbstractC9951ap8.l(interfaceC22720vi8B, interfaceC22720vi8B2);
                        break;
                    default:
                        return super.b(str);
                }
            } else {
                zC = e(interfaceC22720vi8B, interfaceC22720vi8B2);
            }
            zC = !zC2;
        } else {
            zC = c(interfaceC22720vi8B, interfaceC22720vi8B2);
        }
        return zC ? InterfaceC22720vi8.w0 : InterfaceC22720vi8.x0;
    }
}
