package ir.nasim;

import ir.nasim.AB2;
import ir.nasim.InterfaceC15194jA0;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes8.dex */
public class KC6 extends BB2 implements JC6 {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    protected KC6(InterfaceC12795fB1 interfaceC12795fB1, JC6 jc6, InterfaceC4356Eu interfaceC4356Eu, C6432No4 c6432No4, InterfaceC15194jA0.a aVar, JH6 jh6) {
        super(interfaceC12795fB1, jc6, interfaceC4356Eu, c6432No4, aVar, jh6);
        if (interfaceC12795fB1 == null) {
            x(0);
        }
        if (interfaceC4356Eu == null) {
            x(1);
        }
        if (c6432No4 == null) {
            x(2);
        }
        if (aVar == null) {
            x(3);
        }
        if (jh6 == null) {
            x(4);
        }
    }

    public static KC6 k1(InterfaceC12795fB1 interfaceC12795fB1, InterfaceC4356Eu interfaceC4356Eu, C6432No4 c6432No4, InterfaceC15194jA0.a aVar, JH6 jh6) {
        if (interfaceC12795fB1 == null) {
            x(5);
        }
        if (interfaceC4356Eu == null) {
            x(6);
        }
        if (c6432No4 == null) {
            x(7);
        }
        if (aVar == null) {
            x(8);
        }
        if (jh6 == null) {
            x(9);
        }
        return new KC6(interfaceC12795fB1, null, interfaceC4356Eu, c6432No4, aVar, jh6);
    }

    private static /* synthetic */ void x(int i) {
        String str = (i == 13 || i == 17 || i == 18 || i == 23 || i == 24) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i == 13 || i == 17 || i == 18 || i == 23 || i == 24) ? 2 : 3];
        switch (i) {
            case 1:
            case 6:
            case 21:
                objArr[0] = "annotations";
                break;
            case 2:
            case 7:
                objArr[0] = "name";
                break;
            case 3:
            case 8:
            case 20:
                objArr[0] = "kind";
                break;
            case 4:
            case 9:
            case 22:
                objArr[0] = "source";
                break;
            case 5:
            default:
                objArr[0] = "containingDeclaration";
                break;
            case 10:
            case 14:
                objArr[0] = "typeParameters";
                break;
            case 11:
            case 15:
                objArr[0] = "unsubstitutedValueParameters";
                break;
            case 12:
            case 16:
                objArr[0] = "visibility";
                break;
            case 13:
            case 17:
            case 18:
            case 23:
            case 24:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/SimpleFunctionDescriptorImpl";
                break;
            case 19:
                objArr[0] = "newOwner";
                break;
        }
        if (i == 13 || i == 17) {
            objArr[1] = "initialize";
        } else if (i == 18) {
            objArr[1] = "getOriginal";
        } else if (i == 23) {
            objArr[1] = "copy";
        } else if (i != 24) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/SimpleFunctionDescriptorImpl";
        } else {
            objArr[1] = "newCopyBuilder";
        }
        switch (i) {
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
                objArr[2] = "create";
                break;
            case 10:
            case 11:
            case 12:
            case 14:
            case 15:
            case 16:
                objArr[2] = "initialize";
                break;
            case 13:
            case 17:
            case 18:
            case 23:
            case 24:
                break;
            case 19:
            case 20:
            case 21:
            case 22:
                objArr[2] = "createSubstitutedCopy";
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String str2 = String.format(str, objArr);
        if (i != 13 && i != 17 && i != 18 && i != 23 && i != 24) {
            throw new IllegalArgumentException(str2);
        }
        throw new IllegalStateException(str2);
    }

    @Override // ir.nasim.BB2
    protected BB2 K0(InterfaceC12795fB1 interfaceC12795fB1, AB2 ab2, InterfaceC15194jA0.a aVar, C6432No4 c6432No4, InterfaceC4356Eu interfaceC4356Eu, JH6 jh6) {
        if (interfaceC12795fB1 == null) {
            x(19);
        }
        if (aVar == null) {
            x(20);
        }
        if (interfaceC4356Eu == null) {
            x(21);
        }
        if (jh6 == null) {
            x(22);
        }
        JC6 jc6 = (JC6) ab2;
        if (c6432No4 == null) {
            c6432No4 = getName();
        }
        return new KC6(interfaceC12795fB1, jc6, interfaceC4356Eu, c6432No4, aVar, jh6);
    }

    @Override // ir.nasim.InterfaceC15194jA0
    /* renamed from: j1, reason: merged with bridge method [inline-methods] */
    public JC6 u(InterfaceC12795fB1 interfaceC12795fB1, EnumC11067cg4 enumC11067cg4, RI1 ri1, InterfaceC15194jA0.a aVar, boolean z) {
        JC6 jc6 = (JC6) super.J0(interfaceC12795fB1, enumC11067cg4, ri1, aVar, z);
        if (jc6 == null) {
            x(23);
        }
        return jc6;
    }

    @Override // ir.nasim.AbstractC14602iB1
    /* renamed from: l1, reason: merged with bridge method [inline-methods] */
    public JC6 a() {
        JC6 jc6 = (JC6) super.a();
        if (jc6 == null) {
            x(18);
        }
        return jc6;
    }

    @Override // ir.nasim.BB2
    /* renamed from: m1, reason: merged with bridge method [inline-methods] */
    public KC6 Q0(ZI5 zi5, ZI5 zi52, List list, List list2, AbstractC4099Dr3 abstractC4099Dr3, EnumC11067cg4 enumC11067cg4, RI1 ri1) {
        if (list == null) {
            x(10);
        }
        if (list2 == null) {
            x(11);
        }
        if (ri1 == null) {
            x(12);
        }
        KC6 kc6N1 = n1(zi5, zi52, list, list2, abstractC4099Dr3, enumC11067cg4, ri1, null);
        if (kc6N1 == null) {
            x(13);
        }
        return kc6N1;
    }

    public KC6 n1(ZI5 zi5, ZI5 zi52, List list, List list2, AbstractC4099Dr3 abstractC4099Dr3, EnumC11067cg4 enumC11067cg4, RI1 ri1, Map map) {
        if (list == null) {
            x(14);
        }
        if (list2 == null) {
            x(15);
        }
        if (ri1 == null) {
            x(16);
        }
        super.Q0(zi5, zi52, list, list2, abstractC4099Dr3, enumC11067cg4, ri1);
        if (map != null && !map.isEmpty()) {
            this.D = new LinkedHashMap(map);
        }
        return this;
    }

    @Override // ir.nasim.BB2, ir.nasim.AB2
    public AB2.a t() {
        AB2.a aVarT = super.t();
        if (aVarT == null) {
            x(24);
        }
        return aVarT;
    }
}
