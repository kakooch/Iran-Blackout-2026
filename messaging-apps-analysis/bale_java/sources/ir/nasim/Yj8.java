package ir.nasim;

import io.appmetrica.analytics.coreutils.internal.StringUtils;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
public final class Yj8 extends Ni8 {
    protected Yj8() {
        this.a.add(EnumC9901ak8.ASSIGN);
        this.a.add(EnumC9901ak8.CONST);
        this.a.add(EnumC9901ak8.CREATE_ARRAY);
        this.a.add(EnumC9901ak8.CREATE_OBJECT);
        this.a.add(EnumC9901ak8.EXPRESSION_LIST);
        this.a.add(EnumC9901ak8.GET);
        this.a.add(EnumC9901ak8.GET_INDEX);
        this.a.add(EnumC9901ak8.GET_PROPERTY);
        this.a.add(EnumC9901ak8.NULL);
        this.a.add(EnumC9901ak8.SET_PROPERTY);
        this.a.add(EnumC9901ak8.TYPEOF);
        this.a.add(EnumC9901ak8.UNDEFINED);
        this.a.add(EnumC9901ak8.VAR);
    }

    @Override // ir.nasim.Ni8
    public final InterfaceC22720vi8 a(String str, C20322ro8 c20322ro8, List list) {
        String str2;
        EnumC9901ak8 enumC9901ak8 = EnumC9901ak8.ADD;
        int iOrdinal = AbstractC9951ap8.e(str).ordinal();
        int i = 0;
        if (iOrdinal == 3) {
            AbstractC9951ap8.h(EnumC9901ak8.ASSIGN.name(), 2, list);
            InterfaceC22720vi8 interfaceC22720vi8B = c20322ro8.b((InterfaceC22720vi8) list.get(0));
            if (!(interfaceC22720vi8B instanceof Ei8)) {
                throw new IllegalArgumentException(String.format("Expected string for assign var. got %s", interfaceC22720vi8B.getClass().getCanonicalName()));
            }
            if (!c20322ro8.h(interfaceC22720vi8B.j())) {
                throw new IllegalArgumentException(String.format("Attempting to assign undefined value %s", interfaceC22720vi8B.j()));
            }
            InterfaceC22720vi8 interfaceC22720vi8B2 = c20322ro8.b((InterfaceC22720vi8) list.get(1));
            c20322ro8.g(interfaceC22720vi8B.j(), interfaceC22720vi8B2);
            return interfaceC22720vi8B2;
        }
        if (iOrdinal == 14) {
            AbstractC9951ap8.i(EnumC9901ak8.CONST.name(), 2, list);
            if (list.size() % 2 != 0) {
                throw new IllegalArgumentException(String.format("CONST requires an even number of arguments, found %s", Integer.valueOf(list.size())));
            }
            while (i < list.size() - 1) {
                InterfaceC22720vi8 interfaceC22720vi8B3 = c20322ro8.b((InterfaceC22720vi8) list.get(i));
                if (!(interfaceC22720vi8B3 instanceof Ei8)) {
                    throw new IllegalArgumentException(String.format("Expected string for const name. got %s", interfaceC22720vi8B3.getClass().getCanonicalName()));
                }
                c20322ro8.f(interfaceC22720vi8B3.j(), c20322ro8.b((InterfaceC22720vi8) list.get(i + 1)));
                i += 2;
            }
            return InterfaceC22720vi8.r0;
        }
        if (iOrdinal == 24) {
            AbstractC9951ap8.i(EnumC9901ak8.EXPRESSION_LIST.name(), 1, list);
            InterfaceC22720vi8 interfaceC22720vi8B4 = InterfaceC22720vi8.r0;
            while (i < list.size()) {
                interfaceC22720vi8B4 = c20322ro8.b((InterfaceC22720vi8) list.get(i));
                if (interfaceC22720vi8B4 instanceof Lh8) {
                    throw new IllegalStateException("ControlValue cannot be in an expression list");
                }
                i++;
            }
            return interfaceC22720vi8B4;
        }
        if (iOrdinal == 33) {
            AbstractC9951ap8.h(EnumC9901ak8.GET.name(), 1, list);
            InterfaceC22720vi8 interfaceC22720vi8B5 = c20322ro8.b((InterfaceC22720vi8) list.get(0));
            if (interfaceC22720vi8B5 instanceof Ei8) {
                return c20322ro8.d(interfaceC22720vi8B5.j());
            }
            throw new IllegalArgumentException(String.format("Expected string for get var. got %s", interfaceC22720vi8B5.getClass().getCanonicalName()));
        }
        if (iOrdinal == 49) {
            AbstractC9951ap8.h(EnumC9901ak8.NULL.name(), 0, list);
            return InterfaceC22720vi8.s0;
        }
        if (iOrdinal == 58) {
            AbstractC9951ap8.h(EnumC9901ak8.SET_PROPERTY.name(), 3, list);
            InterfaceC22720vi8 interfaceC22720vi8B6 = c20322ro8.b((InterfaceC22720vi8) list.get(0));
            InterfaceC22720vi8 interfaceC22720vi8B7 = c20322ro8.b((InterfaceC22720vi8) list.get(1));
            InterfaceC22720vi8 interfaceC22720vi8B8 = c20322ro8.b((InterfaceC22720vi8) list.get(2));
            if (interfaceC22720vi8B6 == InterfaceC22720vi8.r0 || interfaceC22720vi8B6 == InterfaceC22720vi8.s0) {
                throw new IllegalStateException(String.format("Can't set property %s of %s", interfaceC22720vi8B7.j(), interfaceC22720vi8B6.j()));
            }
            if ((interfaceC22720vi8B6 instanceof Ch8) && (interfaceC22720vi8B7 instanceof Ph8)) {
                ((Ch8) interfaceC22720vi8B6).I(interfaceC22720vi8B7.k().intValue(), interfaceC22720vi8B8);
            } else if (interfaceC22720vi8B6 instanceof InterfaceC14926ii8) {
                ((InterfaceC14926ii8) interfaceC22720vi8B6).i(interfaceC22720vi8B7.j(), interfaceC22720vi8B8);
            }
            return interfaceC22720vi8B8;
        }
        if (iOrdinal == 17) {
            if (list.isEmpty()) {
                return new Ch8();
            }
            Ch8 ch8 = new Ch8();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                InterfaceC22720vi8 interfaceC22720vi8B9 = c20322ro8.b((InterfaceC22720vi8) it.next());
                if (interfaceC22720vi8B9 instanceof Lh8) {
                    throw new IllegalStateException("Failed to evaluate array element");
                }
                ch8.I(i, interfaceC22720vi8B9);
                i++;
            }
            return ch8;
        }
        if (iOrdinal == 18) {
            if (list.isEmpty()) {
                return new C17289mi8();
            }
            if (list.size() % 2 != 0) {
                throw new IllegalArgumentException(String.format("CREATE_OBJECT requires an even number of arguments, found %s", Integer.valueOf(list.size())));
            }
            C17289mi8 c17289mi8 = new C17289mi8();
            while (i < list.size() - 1) {
                InterfaceC22720vi8 interfaceC22720vi8B10 = c20322ro8.b((InterfaceC22720vi8) list.get(i));
                InterfaceC22720vi8 interfaceC22720vi8B11 = c20322ro8.b((InterfaceC22720vi8) list.get(i + 1));
                if ((interfaceC22720vi8B10 instanceof Lh8) || (interfaceC22720vi8B11 instanceof Lh8)) {
                    throw new IllegalStateException("Failed to evaluate map entry");
                }
                c17289mi8.i(interfaceC22720vi8B10.j(), interfaceC22720vi8B11);
                i += 2;
            }
            return c17289mi8;
        }
        if (iOrdinal == 35 || iOrdinal == 36) {
            AbstractC9951ap8.h(EnumC9901ak8.GET_PROPERTY.name(), 2, list);
            InterfaceC22720vi8 interfaceC22720vi8B12 = c20322ro8.b((InterfaceC22720vi8) list.get(0));
            InterfaceC22720vi8 interfaceC22720vi8B13 = c20322ro8.b((InterfaceC22720vi8) list.get(1));
            if ((interfaceC22720vi8B12 instanceof Ch8) && AbstractC9951ap8.k(interfaceC22720vi8B13)) {
                return ((Ch8) interfaceC22720vi8B12).x(interfaceC22720vi8B13.k().intValue());
            }
            if (interfaceC22720vi8B12 instanceof InterfaceC14926ii8) {
                return ((InterfaceC14926ii8) interfaceC22720vi8B12).h(interfaceC22720vi8B13.j());
            }
            if (interfaceC22720vi8B12 instanceof Ei8) {
                if ("length".equals(interfaceC22720vi8B13.j())) {
                    return new Ph8(Double.valueOf(interfaceC22720vi8B12.j().length()));
                }
                if (AbstractC9951ap8.k(interfaceC22720vi8B13) && interfaceC22720vi8B13.k().doubleValue() < interfaceC22720vi8B12.j().length()) {
                    return new Ei8(String.valueOf(interfaceC22720vi8B12.j().charAt(interfaceC22720vi8B13.k().intValue())));
                }
            }
            return InterfaceC22720vi8.r0;
        }
        switch (iOrdinal) {
            case 62:
                AbstractC9951ap8.h(EnumC9901ak8.TYPEOF.name(), 1, list);
                InterfaceC22720vi8 interfaceC22720vi8B14 = c20322ro8.b((InterfaceC22720vi8) list.get(0));
                if (interfaceC22720vi8B14 instanceof Ii8) {
                    str2 = StringUtils.UNDEFINED;
                } else if (interfaceC22720vi8B14 instanceof Ih8) {
                    str2 = "boolean";
                } else if (interfaceC22720vi8B14 instanceof Ph8) {
                    str2 = "number";
                } else if (interfaceC22720vi8B14 instanceof Ei8) {
                    str2 = "string";
                } else if (interfaceC22720vi8B14 instanceof C20853si8) {
                    str2 = "function";
                } else {
                    if ((interfaceC22720vi8B14 instanceof C23906xi8) || (interfaceC22720vi8B14 instanceof Lh8)) {
                        throw new IllegalArgumentException(String.format("Unsupported value type %s in typeof", interfaceC22720vi8B14));
                    }
                    str2 = "object";
                }
                return new Ei8(str2);
            case 63:
                AbstractC9951ap8.h(EnumC9901ak8.UNDEFINED.name(), 0, list);
                return InterfaceC22720vi8.r0;
            case 64:
                AbstractC9951ap8.i(EnumC9901ak8.VAR.name(), 1, list);
                Iterator it2 = list.iterator();
                while (it2.hasNext()) {
                    InterfaceC22720vi8 interfaceC22720vi8B15 = c20322ro8.b((InterfaceC22720vi8) it2.next());
                    if (!(interfaceC22720vi8B15 instanceof Ei8)) {
                        throw new IllegalArgumentException(String.format("Expected string for var name. got %s", interfaceC22720vi8B15.getClass().getCanonicalName()));
                    }
                    c20322ro8.e(interfaceC22720vi8B15.j(), InterfaceC22720vi8.r0);
                }
                return InterfaceC22720vi8.r0;
            default:
                return super.b(str);
        }
    }
}
