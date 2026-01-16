package ir.nasim;

import ir.nasim.M17;
import java.util.ArrayList;
import java.util.List;

/* renamed from: ir.nasim.wy7, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public class C23472wy7 extends AbstractC13322g2 {
    private final UA2 k;
    private final List l;
    private boolean m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    private C23472wy7(InterfaceC12795fB1 interfaceC12795fB1, InterfaceC4356Eu interfaceC4356Eu, boolean z, KQ7 kq7, C6432No4 c6432No4, int i, JH6 jh6, UA2 ua2, M17 m17, ON6 on6) {
        super(on6, interfaceC12795fB1, interfaceC4356Eu, c6432No4, kq7, z, i, jh6, m17);
        if (interfaceC12795fB1 == null) {
            x(19);
        }
        if (interfaceC4356Eu == null) {
            x(20);
        }
        if (kq7 == null) {
            x(21);
        }
        if (c6432No4 == null) {
            x(22);
        }
        if (jh6 == null) {
            x(23);
        }
        if (m17 == null) {
            x(24);
        }
        if (on6 == null) {
            x(25);
        }
        this.l = new ArrayList(1);
        this.m = false;
        this.k = ua2;
    }

    private void M0() {
        if (this.m) {
            return;
        }
        throw new IllegalStateException("Type parameter descriptor is not initialized: " + S0());
    }

    private void N0() {
        if (this.m) {
            throw new IllegalStateException("Type parameter descriptor is already initialized: " + S0());
        }
    }

    public static C23472wy7 O0(InterfaceC12795fB1 interfaceC12795fB1, InterfaceC4356Eu interfaceC4356Eu, boolean z, KQ7 kq7, C6432No4 c6432No4, int i, JH6 jh6, UA2 ua2, M17 m17, ON6 on6) {
        if (interfaceC12795fB1 == null) {
            x(12);
        }
        if (interfaceC4356Eu == null) {
            x(13);
        }
        if (kq7 == null) {
            x(14);
        }
        if (c6432No4 == null) {
            x(15);
        }
        if (jh6 == null) {
            x(16);
        }
        if (m17 == null) {
            x(17);
        }
        if (on6 == null) {
            x(18);
        }
        return new C23472wy7(interfaceC12795fB1, interfaceC4356Eu, z, kq7, c6432No4, i, jh6, ua2, m17, on6);
    }

    public static C23472wy7 P0(InterfaceC12795fB1 interfaceC12795fB1, InterfaceC4356Eu interfaceC4356Eu, boolean z, KQ7 kq7, C6432No4 c6432No4, int i, JH6 jh6, ON6 on6) {
        if (interfaceC12795fB1 == null) {
            x(6);
        }
        if (interfaceC4356Eu == null) {
            x(7);
        }
        if (kq7 == null) {
            x(8);
        }
        if (c6432No4 == null) {
            x(9);
        }
        if (jh6 == null) {
            x(10);
        }
        if (on6 == null) {
            x(11);
        }
        return O0(interfaceC12795fB1, interfaceC4356Eu, z, kq7, c6432No4, i, jh6, null, M17.a.a, on6);
    }

    public static InterfaceC22882vy7 Q0(InterfaceC12795fB1 interfaceC12795fB1, InterfaceC4356Eu interfaceC4356Eu, boolean z, KQ7 kq7, C6432No4 c6432No4, int i, ON6 on6) {
        if (interfaceC12795fB1 == null) {
            x(0);
        }
        if (interfaceC4356Eu == null) {
            x(1);
        }
        if (kq7 == null) {
            x(2);
        }
        if (c6432No4 == null) {
            x(3);
        }
        if (on6 == null) {
            x(4);
        }
        C23472wy7 c23472wy7P0 = P0(interfaceC12795fB1, interfaceC4356Eu, z, kq7, c6432No4, i, JH6.a, on6);
        c23472wy7P0.L0(PI1.g(interfaceC12795fB1).y());
        c23472wy7P0.T0();
        return c23472wy7P0;
    }

    private void R0(AbstractC4099Dr3 abstractC4099Dr3) {
        if (AbstractC4816Gr3.a(abstractC4099Dr3)) {
            return;
        }
        this.l.add(abstractC4099Dr3);
    }

    private String S0() {
        return getName() + " declared in " + OI1.m(b());
    }

    private static /* synthetic */ void x(int i) {
        String str = (i == 5 || i == 28) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i == 5 || i == 28) ? 2 : 3];
        switch (i) {
            case 1:
            case 7:
            case 13:
            case 20:
                objArr[0] = "annotations";
                break;
            case 2:
            case 8:
            case 14:
            case 21:
                objArr[0] = "variance";
                break;
            case 3:
            case 9:
            case 15:
            case 22:
                objArr[0] = "name";
                break;
            case 4:
            case 11:
            case 18:
            case 25:
                objArr[0] = "storageManager";
                break;
            case 5:
            case 28:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/TypeParameterDescriptorImpl";
                break;
            case 6:
            case 12:
            case 19:
            default:
                objArr[0] = "containingDeclaration";
                break;
            case 10:
            case 16:
            case 23:
                objArr[0] = "source";
                break;
            case 17:
                objArr[0] = "supertypeLoopsResolver";
                break;
            case 24:
                objArr[0] = "supertypeLoopsChecker";
                break;
            case 26:
                objArr[0] = "bound";
                break;
            case 27:
                objArr[0] = "type";
                break;
        }
        if (i == 5) {
            objArr[1] = "createWithDefaultBound";
        } else if (i != 28) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/TypeParameterDescriptorImpl";
        } else {
            objArr[1] = "resolveUpperBounds";
        }
        switch (i) {
            case 5:
            case 28:
                break;
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
                objArr[2] = "createForFurtherModification";
                break;
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
                objArr[2] = "<init>";
                break;
            case 26:
                objArr[2] = "addUpperBound";
                break;
            case 27:
                objArr[2] = "reportSupertypeLoopError";
                break;
            default:
                objArr[2] = "createWithDefaultBound";
                break;
        }
        String str2 = String.format(str, objArr);
        if (i != 5 && i != 28) {
            throw new IllegalArgumentException(str2);
        }
        throw new IllegalStateException(str2);
    }

    @Override // ir.nasim.AbstractC13322g2
    protected void J0(AbstractC4099Dr3 abstractC4099Dr3) {
        if (abstractC4099Dr3 == null) {
            x(27);
        }
        UA2 ua2 = this.k;
        if (ua2 == null) {
            return;
        }
        ua2.invoke(abstractC4099Dr3);
    }

    @Override // ir.nasim.AbstractC13322g2
    protected List K0() {
        M0();
        List list = this.l;
        if (list == null) {
            x(28);
        }
        return list;
    }

    public void L0(AbstractC4099Dr3 abstractC4099Dr3) {
        if (abstractC4099Dr3 == null) {
            x(26);
        }
        N0();
        R0(abstractC4099Dr3);
    }

    public void T0() {
        N0();
        this.m = true;
    }
}
