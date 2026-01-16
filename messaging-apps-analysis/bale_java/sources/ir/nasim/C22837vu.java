package ir.nasim;

import ir.nasim.C6266Mw5;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* renamed from: ir.nasim.vu, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C22837vu {
    private final InterfaceC8507Wg4 a;
    private final C21830uC4 b;

    /* renamed from: ir.nasim.vu$a */
    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[C6266Mw5.b.c.EnumC0528c.values().length];
            iArr[C6266Mw5.b.c.EnumC0528c.BYTE.ordinal()] = 1;
            iArr[C6266Mw5.b.c.EnumC0528c.CHAR.ordinal()] = 2;
            iArr[C6266Mw5.b.c.EnumC0528c.SHORT.ordinal()] = 3;
            iArr[C6266Mw5.b.c.EnumC0528c.INT.ordinal()] = 4;
            iArr[C6266Mw5.b.c.EnumC0528c.LONG.ordinal()] = 5;
            iArr[C6266Mw5.b.c.EnumC0528c.FLOAT.ordinal()] = 6;
            iArr[C6266Mw5.b.c.EnumC0528c.DOUBLE.ordinal()] = 7;
            iArr[C6266Mw5.b.c.EnumC0528c.BOOLEAN.ordinal()] = 8;
            iArr[C6266Mw5.b.c.EnumC0528c.STRING.ordinal()] = 9;
            iArr[C6266Mw5.b.c.EnumC0528c.CLASS.ordinal()] = 10;
            iArr[C6266Mw5.b.c.EnumC0528c.ENUM.ordinal()] = 11;
            iArr[C6266Mw5.b.c.EnumC0528c.ANNOTATION.ordinal()] = 12;
            iArr[C6266Mw5.b.c.EnumC0528c.ARRAY.ordinal()] = 13;
            a = iArr;
        }
    }

    public C22837vu(InterfaceC8507Wg4 interfaceC8507Wg4, C21830uC4 c21830uC4) {
        AbstractC13042fc3.i(interfaceC8507Wg4, "module");
        AbstractC13042fc3.i(c21830uC4, "notFoundClasses");
        this.a = interfaceC8507Wg4;
        this.b = c21830uC4;
    }

    private final boolean b(AbstractC7068Qd1 abstractC7068Qd1, AbstractC4099Dr3 abstractC4099Dr3, C6266Mw5.b.c cVar) {
        C6266Mw5.b.c.EnumC0528c enumC0528cW = cVar.W();
        int i = enumC0528cW == null ? -1 : a.a[enumC0528cW.ordinal()];
        if (i == 10) {
            MU0 mu0T = abstractC4099Dr3.K0().t();
            InterfaceC21331tU0 interfaceC21331tU0 = mu0T instanceof InterfaceC21331tU0 ? (InterfaceC21331tU0) mu0T : null;
            if (interfaceC21331tU0 != null && !AbstractC19738qr3.q0(interfaceC21331tU0)) {
                return false;
            }
        } else {
            if (i != 13) {
                return AbstractC13042fc3.d(abstractC7068Qd1.a(this.a), abstractC4099Dr3);
            }
            if (!((abstractC7068Qd1 instanceof WJ) && ((List) ((WJ) abstractC7068Qd1).b()).size() == cVar.N().size())) {
                throw new IllegalStateException(AbstractC13042fc3.q("Deserialized ArrayValue should have the same number of elements as the original array value: ", abstractC7068Qd1).toString());
            }
            AbstractC4099Dr3 abstractC4099Dr3K = c().k(abstractC4099Dr3);
            AbstractC13042fc3.h(abstractC4099Dr3K, "builtIns.getArrayElementType(expectedType)");
            WJ wj = (WJ) abstractC7068Qd1;
            Iterable iterableN = AbstractC10360bX0.n((Collection) wj.b());
            if (!(iterableN instanceof Collection) || !((Collection) iterableN).isEmpty()) {
                Iterator it = iterableN.iterator();
                while (it.hasNext()) {
                    int iB = ((AbstractC18386oa3) it).b();
                    AbstractC7068Qd1 abstractC7068Qd12 = (AbstractC7068Qd1) ((List) wj.b()).get(iB);
                    C6266Mw5.b.c cVarL = cVar.L(iB);
                    AbstractC13042fc3.h(cVarL, "value.getArrayElement(i)");
                    if (!b(abstractC7068Qd12, abstractC4099Dr3K, cVarL)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private final AbstractC19738qr3 c() {
        return this.a.n();
    }

    private final XV4 d(C6266Mw5.b bVar, Map map, InterfaceC6692Oo4 interfaceC6692Oo4) {
        InterfaceC24919zQ7 interfaceC24919zQ7 = (InterfaceC24919zQ7) map.get(AbstractC7170Qo4.b(interfaceC6692Oo4, bVar.w()));
        if (interfaceC24919zQ7 == null) {
            return null;
        }
        C6432No4 c6432No4B = AbstractC7170Qo4.b(interfaceC6692Oo4, bVar.w());
        AbstractC4099Dr3 type = interfaceC24919zQ7.getType();
        AbstractC13042fc3.h(type, "parameter.type");
        C6266Mw5.b.c cVarY = bVar.y();
        AbstractC13042fc3.h(cVarY, "proto.value");
        return new XV4(c6432No4B, g(type, cVarY, interfaceC6692Oo4));
    }

    private final InterfaceC21331tU0 e(C24948zU0 c24948zU0) {
        return AbstractC23370wo2.c(this.a, c24948zU0, this.b);
    }

    private final AbstractC7068Qd1 g(AbstractC4099Dr3 abstractC4099Dr3, C6266Mw5.b.c cVar, InterfaceC6692Oo4 interfaceC6692Oo4) {
        AbstractC7068Qd1 abstractC7068Qd1F = f(abstractC4099Dr3, cVar, interfaceC6692Oo4);
        if (!b(abstractC7068Qd1F, abstractC4099Dr3, cVar)) {
            abstractC7068Qd1F = null;
        }
        if (abstractC7068Qd1F != null) {
            return abstractC7068Qd1F;
        }
        return AbstractC15430ja2.b.a("Unexpected argument value: actual type " + cVar.W() + " != expected type " + abstractC4099Dr3);
    }

    public final InterfaceC21651tu a(C6266Mw5 c6266Mw5, InterfaceC6692Oo4 interfaceC6692Oo4) {
        AbstractC13042fc3.i(c6266Mw5, "proto");
        AbstractC13042fc3.i(interfaceC6692Oo4, "nameResolver");
        InterfaceC21331tU0 interfaceC21331tU0E = e(AbstractC7170Qo4.a(interfaceC6692Oo4, c6266Mw5.D()));
        Map mapK = AbstractC20051rO3.k();
        if (c6266Mw5.y() != 0 && !AbstractC14230ha2.r(interfaceC21331tU0E) && OI1.t(interfaceC21331tU0E)) {
            Collection collectionK = interfaceC21331tU0E.k();
            AbstractC13042fc3.h(collectionK, "annotationClass.constructors");
            InterfaceC18329oU0 interfaceC18329oU0 = (InterfaceC18329oU0) AbstractC15401jX0.W0(collectionK);
            if (interfaceC18329oU0 != null) {
                List listH = interfaceC18329oU0.h();
                AbstractC13042fc3.h(listH, "constructor.valueParameters");
                List list = listH;
                LinkedHashMap linkedHashMap = new LinkedHashMap(AbstractC23053wG5.e(AbstractC19460qO3.f(AbstractC10976cX0.x(list, 10)), 16));
                for (Object obj : list) {
                    linkedHashMap.put(((InterfaceC24919zQ7) obj).getName(), obj);
                }
                List<C6266Mw5.b> listZ = c6266Mw5.z();
                AbstractC13042fc3.h(listZ, "proto.argumentList");
                ArrayList arrayList = new ArrayList();
                for (C6266Mw5.b bVar : listZ) {
                    AbstractC13042fc3.h(bVar, "it");
                    XV4 xv4D = d(bVar, linkedHashMap, interfaceC6692Oo4);
                    if (xv4D != null) {
                        arrayList.add(xv4D);
                    }
                }
                mapK = AbstractC20051rO3.w(arrayList);
            }
        }
        return new C22241uu(interfaceC21331tU0E.p(), mapK, JH6.a);
    }

    public final AbstractC7068Qd1 f(AbstractC4099Dr3 abstractC4099Dr3, C6266Mw5.b.c cVar, InterfaceC6692Oo4 interfaceC6692Oo4) {
        AbstractC7068Qd1 c8341Vo0;
        AbstractC13042fc3.i(abstractC4099Dr3, "expectedType");
        AbstractC13042fc3.i(cVar, "value");
        AbstractC13042fc3.i(interfaceC6692Oo4, "nameResolver");
        Boolean boolD = AbstractC5031Hp2.N.d(cVar.S());
        AbstractC13042fc3.h(boolD, "IS_UNSIGNED.get(value.flags)");
        boolean zBooleanValue = boolD.booleanValue();
        C6266Mw5.b.c.EnumC0528c enumC0528cW = cVar.W();
        switch (enumC0528cW == null ? -1 : a.a[enumC0528cW.ordinal()]) {
            case 1:
                byte bU = (byte) cVar.U();
                if (zBooleanValue) {
                    c8341Vo0 = new C8701Wz7(bU);
                    break;
                } else {
                    c8341Vo0 = new C8341Vo0(bU);
                    break;
                }
            case 2:
                return new C14084hK0((char) cVar.U());
            case 3:
                short sU = (short) cVar.U();
                if (zBooleanValue) {
                    c8341Vo0 = new DA7(sU);
                    break;
                } else {
                    c8341Vo0 = new C5359Iz6(sU);
                    break;
                }
            case 4:
                int iU = (int) cVar.U();
                if (zBooleanValue) {
                    c8341Vo0 = new C14001hA7(iU);
                    break;
                } else {
                    c8341Vo0 = new C6066Ma3(iU);
                    break;
                }
            case 5:
                long jU = cVar.U();
                return zBooleanValue ? new C16974mA7(jU) : new C24258yJ3(jU);
            case 6:
                return new C18545oq2(cVar.T());
            case 7:
                return new C17175mX1(cVar.Q());
            case 8:
                return new C8278Vh0(cVar.U() != 0);
            case 9:
                return new C9790aZ6(interfaceC6692Oo4.getString(cVar.V()));
            case 10:
                return new C13760gm3(AbstractC7170Qo4.a(interfaceC6692Oo4, cVar.O()), cVar.K());
            case 11:
                return new N92(AbstractC7170Qo4.a(interfaceC6692Oo4, cVar.O()), AbstractC7170Qo4.b(interfaceC6692Oo4, cVar.R()));
            case 12:
                C6266Mw5 c6266Mw5J = cVar.J();
                AbstractC13042fc3.h(c6266Mw5J, "value.annotation");
                return new C4122Du(a(c6266Mw5J, interfaceC6692Oo4));
            case 13:
                C7302Rd1 c7302Rd1 = C7302Rd1.a;
                List listN = cVar.N();
                AbstractC13042fc3.h(listN, "value.arrayElementList");
                List<C6266Mw5.b.c> list = listN;
                ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(list, 10));
                for (C6266Mw5.b.c cVar2 : list) {
                    XC6 xc6I = c().i();
                    AbstractC13042fc3.h(xc6I, "builtIns.anyType");
                    AbstractC13042fc3.h(cVar2, "it");
                    arrayList.add(f(xc6I, cVar2, interfaceC6692Oo4));
                }
                return c7302Rd1.a(arrayList, abstractC4099Dr3);
            default:
                throw new IllegalStateException(("Unsupported annotation argument type: " + cVar.W() + " (expected " + abstractC4099Dr3 + ')').toString());
        }
        return c8341Vo0;
    }
}
