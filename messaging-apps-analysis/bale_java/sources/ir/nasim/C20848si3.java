package ir.nasim;

import ir.nasim.InterfaceC14592iA0;
import ir.nasim.InterfaceC15194jA0;
import java.util.List;
import java.util.Map;

/* renamed from: ir.nasim.si3, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public class C20848si3 extends KC6 implements InterfaceC6862Ph3 {
    public static final InterfaceC14592iA0.a J = new a();
    private b G;
    private final boolean H;

    /* renamed from: ir.nasim.si3$a */
    static class a implements InterfaceC14592iA0.a {
        a() {
        }
    }

    /* renamed from: ir.nasim.si3$b */
    private enum b {
        NON_STABLE_DECLARED(false, false),
        STABLE_DECLARED(true, false),
        NON_STABLE_SYNTHESIZED(false, true),
        STABLE_SYNTHESIZED(true, true);

        public final boolean a;
        public final boolean b;

        b(boolean z, boolean z2) {
            this.a = z;
            this.b = z2;
        }

        private static /* synthetic */ void a(int i) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/load/java/descriptors/JavaMethodDescriptor$ParameterNamesStatus", "get"));
        }

        public static b j(boolean z, boolean z2) {
            b bVar = z ? z2 ? STABLE_SYNTHESIZED : STABLE_DECLARED : z2 ? NON_STABLE_SYNTHESIZED : NON_STABLE_DECLARED;
            if (bVar == null) {
                a(0);
            }
            return bVar;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    protected C20848si3(InterfaceC12795fB1 interfaceC12795fB1, JC6 jc6, InterfaceC4356Eu interfaceC4356Eu, C6432No4 c6432No4, InterfaceC15194jA0.a aVar, JH6 jh6, boolean z) {
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
        this.G = null;
        this.H = z;
    }

    public static C20848si3 o1(InterfaceC12795fB1 interfaceC12795fB1, InterfaceC4356Eu interfaceC4356Eu, C6432No4 c6432No4, JH6 jh6, boolean z) {
        if (interfaceC12795fB1 == null) {
            x(5);
        }
        if (interfaceC4356Eu == null) {
            x(6);
        }
        if (c6432No4 == null) {
            x(7);
        }
        if (jh6 == null) {
            x(8);
        }
        return new C20848si3(interfaceC12795fB1, null, interfaceC4356Eu, c6432No4, InterfaceC15194jA0.a.DECLARATION, jh6, z);
    }

    private static /* synthetic */ void x(int i) {
        String str = (i == 12 || i == 17 || i == 20) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i == 12 || i == 17 || i == 20) ? 2 : 3];
        switch (i) {
            case 1:
            case 6:
            case 15:
                objArr[0] = "annotations";
                break;
            case 2:
            case 7:
                objArr[0] = "name";
                break;
            case 3:
            case 14:
                objArr[0] = "kind";
                break;
            case 4:
            case 8:
            case 16:
                objArr[0] = "source";
                break;
            case 5:
            default:
                objArr[0] = "containingDeclaration";
                break;
            case 9:
                objArr[0] = "typeParameters";
                break;
            case 10:
                objArr[0] = "unsubstitutedValueParameters";
                break;
            case 11:
                objArr[0] = "visibility";
                break;
            case 12:
            case 17:
            case 20:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/load/java/descriptors/JavaMethodDescriptor";
                break;
            case 13:
                objArr[0] = "newOwner";
                break;
            case 18:
                objArr[0] = "enhancedValueParametersData";
                break;
            case 19:
                objArr[0] = "enhancedReturnType";
                break;
        }
        if (i == 12) {
            objArr[1] = "initialize";
        } else if (i == 17) {
            objArr[1] = "createSubstitutedCopy";
        } else if (i != 20) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/load/java/descriptors/JavaMethodDescriptor";
        } else {
            objArr[1] = "enhance";
        }
        switch (i) {
            case 5:
            case 6:
            case 7:
            case 8:
                objArr[2] = "createJavaMethod";
                break;
            case 9:
            case 10:
            case 11:
                objArr[2] = "initialize";
                break;
            case 12:
            case 17:
            case 20:
                break;
            case 13:
            case 14:
            case 15:
            case 16:
                objArr[2] = "createSubstitutedCopy";
                break;
            case 18:
            case 19:
                objArr[2] = "enhance";
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String str2 = String.format(str, objArr);
        if (i != 12 && i != 17 && i != 20) {
            throw new IllegalArgumentException(str2);
        }
        throw new IllegalStateException(str2);
    }

    @Override // ir.nasim.BB2
    public boolean P0() {
        return this.G.a;
    }

    @Override // ir.nasim.BB2, ir.nasim.InterfaceC14592iA0
    public boolean h0() {
        return this.G.b;
    }

    @Override // ir.nasim.KC6
    public KC6 n1(ZI5 zi5, ZI5 zi52, List list, List list2, AbstractC4099Dr3 abstractC4099Dr3, EnumC11067cg4 enumC11067cg4, RI1 ri1, Map map) {
        if (list == null) {
            x(9);
        }
        if (list2 == null) {
            x(10);
        }
        if (ri1 == null) {
            x(11);
        }
        KC6 kc6N1 = super.n1(zi5, zi52, list, list2, abstractC4099Dr3, enumC11067cg4, ri1, map);
        e1(C21237tL4.a.a(kc6N1).a());
        if (kc6N1 == null) {
            x(12);
        }
        return kc6N1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ir.nasim.KC6, ir.nasim.BB2
    /* renamed from: p1, reason: merged with bridge method [inline-methods] */
    public C20848si3 K0(InterfaceC12795fB1 interfaceC12795fB1, AB2 ab2, InterfaceC15194jA0.a aVar, C6432No4 c6432No4, InterfaceC4356Eu interfaceC4356Eu, JH6 jh6) {
        if (interfaceC12795fB1 == null) {
            x(13);
        }
        if (aVar == null) {
            x(14);
        }
        if (interfaceC4356Eu == null) {
            x(15);
        }
        if (jh6 == null) {
            x(16);
        }
        JC6 jc6 = (JC6) ab2;
        if (c6432No4 == null) {
            c6432No4 = getName();
        }
        C20848si3 c20848si3 = new C20848si3(interfaceC12795fB1, jc6, interfaceC4356Eu, c6432No4, aVar, jh6, this.H);
        c20848si3.r1(P0(), h0());
        return c20848si3;
    }

    @Override // ir.nasim.InterfaceC6862Ph3
    /* renamed from: q1, reason: merged with bridge method [inline-methods] */
    public C20848si3 X(AbstractC4099Dr3 abstractC4099Dr3, List list, AbstractC4099Dr3 abstractC4099Dr32, XV4 xv4) {
        if (list == null) {
            x(18);
        }
        if (abstractC4099Dr32 == null) {
            x(19);
        }
        C20848si3 c20848si3 = (C20848si3) t().c(AbstractC14118hN7.a(list, h(), this)).f(abstractC4099Dr32).d(abstractC4099Dr3 == null ? null : AbstractC23657xI1.f(this, abstractC4099Dr3, InterfaceC4356Eu.W.b())).b().m().a();
        if (xv4 != null) {
            c20848si3.T0((InterfaceC14592iA0.a) xv4.e(), xv4.f());
        }
        if (c20848si3 == null) {
            x(20);
        }
        return c20848si3;
    }

    public void r1(boolean z, boolean z2) {
        this.G = b.j(z, z2);
    }
}
