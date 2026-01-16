package ir.nasim;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* renamed from: ir.nasim.zs4, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public abstract class AbstractC25186zs4 {
    private static final List a(AbstractC18174oC7 abstractC18174oC7, EnumC15839kG0 enumC15839kG0) {
        if (abstractC18174oC7.J0().size() != abstractC18174oC7.K0().getParameters().size()) {
            return null;
        }
        List listJ0 = abstractC18174oC7.J0();
        List list = listJ0;
        if (!(list instanceof Collection) || !list.isEmpty()) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                if (((InterfaceC3932Cy7) it.next()).c() != KQ7.INVARIANT) {
                    List parameters = abstractC18174oC7.K0().getParameters();
                    AbstractC13042fc3.h(parameters, "type.constructor.parameters");
                    List<XV4> listV1 = AbstractC15401jX0.v1(list, parameters);
                    ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(listV1, 10));
                    for (XV4 xv4 : listV1) {
                        InterfaceC3932Cy7 interfaceC3932Cy7A = (InterfaceC3932Cy7) xv4.a();
                        InterfaceC22882vy7 interfaceC22882vy7 = (InterfaceC22882vy7) xv4.b();
                        if (interfaceC3932Cy7A.c() != KQ7.INVARIANT) {
                            AbstractC18174oC7 abstractC18174oC7N0 = (interfaceC3932Cy7A.b() || interfaceC3932Cy7A.c() != KQ7.IN_VARIANCE) ? null : interfaceC3932Cy7A.getType().N0();
                            AbstractC13042fc3.h(interfaceC22882vy7, "parameter");
                            interfaceC3932Cy7A = AbstractC7731Sy7.a(new C24002xs4(enumC15839kG0, abstractC18174oC7N0, interfaceC3932Cy7A, interfaceC22882vy7));
                        }
                        arrayList.add(interfaceC3932Cy7A);
                    }
                    C5585Jy7 c5585Jy7C = AbstractC15082iy7.c.b(abstractC18174oC7.K0(), arrayList).c();
                    int size = listJ0.size() - 1;
                    if (size >= 0) {
                        int i = 0;
                        while (true) {
                            int i2 = i + 1;
                            InterfaceC3932Cy7 interfaceC3932Cy7 = (InterfaceC3932Cy7) listJ0.get(i);
                            InterfaceC3932Cy7 interfaceC3932Cy72 = (InterfaceC3932Cy7) arrayList.get(i);
                            if (interfaceC3932Cy7.c() != KQ7.INVARIANT) {
                                List upperBounds = ((InterfaceC22882vy7) abstractC18174oC7.K0().getParameters().get(i)).getUpperBounds();
                                AbstractC13042fc3.h(upperBounds, "type.constructor.parameters[index].upperBounds");
                                ArrayList arrayList2 = new ArrayList();
                                Iterator it2 = upperBounds.iterator();
                                while (it2.hasNext()) {
                                    arrayList2.add(InterfaceC14434hu4.b.a().h(c5585Jy7C.n((AbstractC4099Dr3) it2.next(), KQ7.INVARIANT).N0()));
                                }
                                if (!interfaceC3932Cy7.b() && interfaceC3932Cy7.c() == KQ7.OUT_VARIANCE) {
                                    arrayList2.add(InterfaceC14434hu4.b.a().h(interfaceC3932Cy7.getType().N0()));
                                }
                                ((C24002xs4) interfaceC3932Cy72.getType()).K0().i(arrayList2);
                            }
                            if (i2 > size) {
                                break;
                            }
                            i = i2;
                        }
                    }
                    return arrayList;
                }
            }
        }
        return null;
    }

    public static final XC6 b(XC6 xc6, EnumC15839kG0 enumC15839kG0) {
        AbstractC13042fc3.i(xc6, "type");
        AbstractC13042fc3.i(enumC15839kG0, "status");
        List listA = a(xc6, enumC15839kG0);
        if (listA == null) {
            return null;
        }
        return c(xc6, listA);
    }

    private static final XC6 c(AbstractC18174oC7 abstractC18174oC7, List list) {
        C4567Fr3 c4567Fr3 = C4567Fr3.a;
        return C4567Fr3.i(abstractC18174oC7.getAnnotations(), abstractC18174oC7.K0(), list, abstractC18174oC7.L0(), null, 16, null);
    }
}
