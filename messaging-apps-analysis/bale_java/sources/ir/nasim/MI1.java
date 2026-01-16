package ir.nasim;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes8.dex */
public abstract class MI1 {
    private static /* synthetic */ void a(int i) {
        String str = i != 4 ? "Argument for @NotNull parameter '%s' of %s.%s must not be null" : "@NotNull method %s.%s must not return null";
        Object[] objArr = new Object[i != 4 ? 3 : 2];
        switch (i) {
            case 1:
            case 6:
                objArr[0] = "originalSubstitution";
                break;
            case 2:
            case 7:
                objArr[0] = "newContainingDeclaration";
                break;
            case 3:
            case 8:
                objArr[0] = "result";
                break;
            case 4:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/types/DescriptorSubstitutor";
                break;
            case 5:
            default:
                objArr[0] = "typeParameters";
                break;
        }
        if (i != 4) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/types/DescriptorSubstitutor";
        } else {
            objArr[1] = "substituteTypeParameters";
        }
        if (i != 4) {
            objArr[2] = "substituteTypeParameters";
        }
        String str2 = String.format(str, objArr);
        if (i == 4) {
            throw new IllegalStateException(str2);
        }
    }

    public static C5585Jy7 b(List list, AbstractC5117Hy7 abstractC5117Hy7, InterfaceC12795fB1 interfaceC12795fB1, List list2) {
        if (list == null) {
            a(0);
        }
        if (abstractC5117Hy7 == null) {
            a(1);
        }
        if (interfaceC12795fB1 == null) {
            a(2);
        }
        if (list2 == null) {
            a(3);
        }
        C5585Jy7 c5585Jy7C = c(list, abstractC5117Hy7, interfaceC12795fB1, list2, null);
        if (c5585Jy7C != null) {
            return c5585Jy7C;
        }
        throw new AssertionError("Substitution failed");
    }

    public static C5585Jy7 c(List list, AbstractC5117Hy7 abstractC5117Hy7, InterfaceC12795fB1 interfaceC12795fB1, List list2, boolean[] zArr) {
        if (list == null) {
            a(5);
        }
        if (abstractC5117Hy7 == null) {
            a(6);
        }
        if (interfaceC12795fB1 == null) {
            a(7);
        }
        if (list2 == null) {
            a(8);
        }
        HashMap map = new HashMap();
        HashMap map2 = new HashMap();
        Iterator it = list.iterator();
        int i = 0;
        while (it.hasNext()) {
            InterfaceC22882vy7 interfaceC22882vy7 = (InterfaceC22882vy7) it.next();
            C23472wy7 c23472wy7P0 = C23472wy7.P0(interfaceC12795fB1, interfaceC22882vy7.getAnnotations(), interfaceC22882vy7.w(), interfaceC22882vy7.m(), interfaceC22882vy7.getName(), i, JH6.a, interfaceC22882vy7.O());
            map.put(interfaceC22882vy7.j(), new C4400Ey7(c23472wy7P0.p()));
            map2.put(interfaceC22882vy7, c23472wy7P0);
            list2.add(c23472wy7P0);
            i++;
        }
        C5585Jy7 c5585Jy7H = C5585Jy7.h(abstractC5117Hy7, AbstractC15082iy7.i(map));
        Iterator it2 = list.iterator();
        while (it2.hasNext()) {
            InterfaceC22882vy7 interfaceC22882vy72 = (InterfaceC22882vy7) it2.next();
            C23472wy7 c23472wy7 = (C23472wy7) map2.get(interfaceC22882vy72);
            for (AbstractC4099Dr3 abstractC4099Dr3 : interfaceC22882vy72.getUpperBounds()) {
                AbstractC4099Dr3 abstractC4099Dr3P = c5585Jy7H.p(abstractC4099Dr3, KQ7.IN_VARIANCE);
                if (abstractC4099Dr3P == null) {
                    return null;
                }
                if (abstractC4099Dr3P != abstractC4099Dr3 && zArr != null) {
                    zArr[0] = true;
                }
                c23472wy7.L0(abstractC4099Dr3P);
            }
            c23472wy7.T0();
        }
        return c5585Jy7H;
    }
}
