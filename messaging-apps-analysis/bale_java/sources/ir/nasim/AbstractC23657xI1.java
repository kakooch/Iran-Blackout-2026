package ir.nasim;

import ir.nasim.InterfaceC15194jA0;
import ir.nasim.InterfaceC4356Eu;
import java.util.Collections;

/* renamed from: ir.nasim.xI1, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public abstract class AbstractC23657xI1 {

    /* renamed from: ir.nasim.xI1$a */
    private static class a extends C18920pU0 {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(InterfaceC21331tU0 interfaceC21331tU0, JH6 jh6, boolean z) {
            super(interfaceC21331tU0, null, InterfaceC4356Eu.W.b(), true, InterfaceC15194jA0.a.DECLARATION, jh6);
            if (interfaceC21331tU0 == null) {
                x(0);
            }
            if (jh6 == null) {
                x(1);
            }
            o1(Collections.emptyList(), OI1.k(interfaceC21331tU0, z));
        }

        private static /* synthetic */ void x(int i) {
            Object[] objArr = new Object[3];
            if (i != 1) {
                objArr[0] = "containingClass";
            } else {
                objArr[0] = "source";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/resolve/DescriptorFactory$DefaultClassConstructorDescriptor";
            objArr[2] = "<init>";
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }
    }

    private static /* synthetic */ void a(int i) {
        String str = (i == 12 || i == 23 || i == 25) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i == 12 || i == 23 || i == 25) ? 2 : 3];
        switch (i) {
            case 1:
            case 4:
            case 8:
            case 14:
            case 16:
            case 18:
            case 30:
                objArr[0] = "annotations";
                break;
            case 2:
            case 5:
            case 9:
                objArr[0] = "parameterAnnotations";
                break;
            case 3:
            case 7:
            case 13:
            case 15:
            case 17:
            default:
                objArr[0] = "propertyDescriptor";
                break;
            case 6:
            case 11:
            case 19:
                objArr[0] = "sourceElement";
                break;
            case 10:
                objArr[0] = "visibility";
                break;
            case 12:
            case 23:
            case 25:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/resolve/DescriptorFactory";
                break;
            case 20:
                objArr[0] = "containingClass";
                break;
            case 21:
                objArr[0] = "source";
                break;
            case 22:
            case 24:
                objArr[0] = "enumClass";
                break;
            case 26:
            case 27:
            case 28:
                objArr[0] = "descriptor";
                break;
            case 29:
                objArr[0] = "owner";
                break;
        }
        if (i == 12) {
            objArr[1] = "createSetter";
        } else if (i == 23) {
            objArr[1] = "createEnumValuesMethod";
        } else if (i != 25) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/resolve/DescriptorFactory";
        } else {
            objArr[1] = "createEnumValueOfMethod";
        }
        switch (i) {
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
                objArr[2] = "createSetter";
                break;
            case 12:
            case 23:
            case 25:
                break;
            case 13:
            case 14:
                objArr[2] = "createDefaultGetter";
                break;
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
                objArr[2] = "createGetter";
                break;
            case 20:
            case 21:
                objArr[2] = "createPrimaryConstructorForObject";
                break;
            case 22:
                objArr[2] = "createEnumValuesMethod";
                break;
            case 24:
                objArr[2] = "createEnumValueOfMethod";
                break;
            case 26:
                objArr[2] = "isEnumValuesMethod";
                break;
            case 27:
                objArr[2] = "isEnumValueOfMethod";
                break;
            case 28:
                objArr[2] = "isEnumSpecialMethod";
                break;
            case 29:
            case 30:
                objArr[2] = "createExtensionReceiverParameterForCallable";
                break;
            default:
                objArr[2] = "createDefaultSetter";
                break;
        }
        String str2 = String.format(str, objArr);
        if (i != 12 && i != 23 && i != 25) {
            throw new IllegalArgumentException(str2);
        }
        throw new IllegalStateException(str2);
    }

    public static C22862vw5 b(InterfaceC20989sw5 interfaceC20989sw5, InterfaceC4356Eu interfaceC4356Eu) {
        if (interfaceC20989sw5 == null) {
            a(13);
        }
        if (interfaceC4356Eu == null) {
            a(14);
        }
        return g(interfaceC20989sw5, interfaceC4356Eu, true, false, false);
    }

    public static C4380Ew5 c(InterfaceC20989sw5 interfaceC20989sw5, InterfaceC4356Eu interfaceC4356Eu, InterfaceC4356Eu interfaceC4356Eu2) {
        if (interfaceC20989sw5 == null) {
            a(0);
        }
        if (interfaceC4356Eu == null) {
            a(1);
        }
        if (interfaceC4356Eu2 == null) {
            a(2);
        }
        return k(interfaceC20989sw5, interfaceC4356Eu, interfaceC4356Eu2, true, false, false, interfaceC20989sw5.i());
    }

    public static JC6 d(InterfaceC21331tU0 interfaceC21331tU0) {
        if (interfaceC21331tU0 == null) {
            a(24);
        }
        InterfaceC4356Eu.a aVar = InterfaceC4356Eu.W;
        KC6 kc6K1 = KC6.k1(interfaceC21331tU0, aVar.b(), PJ6.c, InterfaceC15194jA0.a.SYNTHESIZED, interfaceC21331tU0.i());
        KC6 kc6Q0 = kc6K1.Q0(null, null, Collections.emptyList(), Collections.singletonList(new AQ7(kc6K1, null, 0, aVar.b(), C6432No4.p("value"), PI1.g(interfaceC21331tU0).V(), false, false, false, null, interfaceC21331tU0.i())), interfaceC21331tU0.p(), EnumC11067cg4.FINAL, QI1.e);
        if (kc6Q0 == null) {
            a(25);
        }
        return kc6Q0;
    }

    public static JC6 e(InterfaceC21331tU0 interfaceC21331tU0) {
        if (interfaceC21331tU0 == null) {
            a(22);
        }
        KC6 kc6Q0 = KC6.k1(interfaceC21331tU0, InterfaceC4356Eu.W.b(), PJ6.b, InterfaceC15194jA0.a.SYNTHESIZED, interfaceC21331tU0.i()).Q0(null, null, Collections.emptyList(), Collections.emptyList(), PI1.g(interfaceC21331tU0).l(KQ7.INVARIANT, interfaceC21331tU0.p()), EnumC11067cg4.FINAL, QI1.e);
        if (kc6Q0 == null) {
            a(23);
        }
        return kc6Q0;
    }

    public static ZI5 f(InterfaceC14592iA0 interfaceC14592iA0, AbstractC4099Dr3 abstractC4099Dr3, InterfaceC4356Eu interfaceC4356Eu) {
        if (interfaceC14592iA0 == null) {
            a(29);
        }
        if (interfaceC4356Eu == null) {
            a(30);
        }
        if (abstractC4099Dr3 == null) {
            return null;
        }
        return new C9645aJ5(interfaceC14592iA0, new C6340Ne2(interfaceC14592iA0, abstractC4099Dr3, null), interfaceC4356Eu);
    }

    public static C22862vw5 g(InterfaceC20989sw5 interfaceC20989sw5, InterfaceC4356Eu interfaceC4356Eu, boolean z, boolean z2, boolean z3) {
        if (interfaceC20989sw5 == null) {
            a(15);
        }
        if (interfaceC4356Eu == null) {
            a(16);
        }
        return h(interfaceC20989sw5, interfaceC4356Eu, z, z2, z3, interfaceC20989sw5.i());
    }

    public static C22862vw5 h(InterfaceC20989sw5 interfaceC20989sw5, InterfaceC4356Eu interfaceC4356Eu, boolean z, boolean z2, boolean z3, JH6 jh6) {
        if (interfaceC20989sw5 == null) {
            a(17);
        }
        if (interfaceC4356Eu == null) {
            a(18);
        }
        if (jh6 == null) {
            a(19);
        }
        return new C22862vw5(interfaceC20989sw5, interfaceC4356Eu, interfaceC20989sw5.r(), interfaceC20989sw5.getVisibility(), z, z2, z3, InterfaceC15194jA0.a.DECLARATION, null, jh6);
    }

    public static C18920pU0 i(InterfaceC21331tU0 interfaceC21331tU0, JH6 jh6) {
        if (interfaceC21331tU0 == null) {
            a(20);
        }
        if (jh6 == null) {
            a(21);
        }
        return new a(interfaceC21331tU0, jh6, false);
    }

    public static C4380Ew5 j(InterfaceC20989sw5 interfaceC20989sw5, InterfaceC4356Eu interfaceC4356Eu, InterfaceC4356Eu interfaceC4356Eu2, boolean z, boolean z2, boolean z3, RI1 ri1, JH6 jh6) {
        if (interfaceC20989sw5 == null) {
            a(7);
        }
        if (interfaceC4356Eu == null) {
            a(8);
        }
        if (interfaceC4356Eu2 == null) {
            a(9);
        }
        if (ri1 == null) {
            a(10);
        }
        if (jh6 == null) {
            a(11);
        }
        C4380Ew5 c4380Ew5 = new C4380Ew5(interfaceC20989sw5, interfaceC4356Eu, interfaceC20989sw5.r(), ri1, z, z2, z3, InterfaceC15194jA0.a.DECLARATION, null, jh6);
        c4380Ew5.P0(C4380Ew5.N0(c4380Ew5, interfaceC20989sw5.getType(), interfaceC4356Eu2));
        return c4380Ew5;
    }

    public static C4380Ew5 k(InterfaceC20989sw5 interfaceC20989sw5, InterfaceC4356Eu interfaceC4356Eu, InterfaceC4356Eu interfaceC4356Eu2, boolean z, boolean z2, boolean z3, JH6 jh6) {
        if (interfaceC20989sw5 == null) {
            a(3);
        }
        if (interfaceC4356Eu == null) {
            a(4);
        }
        if (interfaceC4356Eu2 == null) {
            a(5);
        }
        if (jh6 == null) {
            a(6);
        }
        return j(interfaceC20989sw5, interfaceC4356Eu, interfaceC4356Eu2, z, z2, z3, interfaceC20989sw5.getVisibility(), jh6);
    }

    private static boolean l(AB2 ab2) {
        if (ab2 == null) {
            a(28);
        }
        return ab2.f() == InterfaceC15194jA0.a.SYNTHESIZED && OI1.A(ab2.b());
    }

    public static boolean m(AB2 ab2) {
        if (ab2 == null) {
            a(27);
        }
        return ab2.getName().equals(PJ6.c) && l(ab2);
    }

    public static boolean n(AB2 ab2) {
        if (ab2 == null) {
            a(26);
        }
        return ab2.getName().equals(PJ6.b) && l(ab2);
    }
}
