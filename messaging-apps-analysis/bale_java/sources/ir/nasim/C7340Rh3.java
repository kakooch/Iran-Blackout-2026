package ir.nasim;

import android.gov.nist.core.Separators;
import ir.nasim.InterfaceC14592iA0;
import ir.nasim.InterfaceC15194jA0;
import java.util.List;

/* renamed from: ir.nasim.Rh3, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public class C7340Rh3 extends C18920pU0 implements InterfaceC6862Ph3 {
    private Boolean J;
    private Boolean Y;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    protected C7340Rh3(InterfaceC21331tU0 interfaceC21331tU0, C7340Rh3 c7340Rh3, InterfaceC4356Eu interfaceC4356Eu, boolean z, InterfaceC15194jA0.a aVar, JH6 jh6) {
        super(interfaceC21331tU0, c7340Rh3, interfaceC4356Eu, z, aVar, jh6);
        if (interfaceC21331tU0 == null) {
            x(0);
        }
        if (interfaceC4356Eu == null) {
            x(1);
        }
        if (aVar == null) {
            x(2);
        }
        if (jh6 == null) {
            x(3);
        }
        this.J = null;
        this.Y = null;
    }

    public static C7340Rh3 r1(InterfaceC21331tU0 interfaceC21331tU0, InterfaceC4356Eu interfaceC4356Eu, boolean z, JH6 jh6) {
        if (interfaceC21331tU0 == null) {
            x(4);
        }
        if (interfaceC4356Eu == null) {
            x(5);
        }
        if (jh6 == null) {
            x(6);
        }
        return new C7340Rh3(interfaceC21331tU0, null, interfaceC4356Eu, z, InterfaceC15194jA0.a.DECLARATION, jh6);
    }

    private static /* synthetic */ void x(int i) {
        String str = (i == 11 || i == 18) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i == 11 || i == 18) ? 2 : 3];
        switch (i) {
            case 1:
            case 5:
            case 9:
            case 15:
                objArr[0] = "annotations";
                break;
            case 2:
            case 8:
            case 13:
                objArr[0] = "kind";
                break;
            case 3:
            case 6:
            case 10:
                objArr[0] = "source";
                break;
            case 4:
            default:
                objArr[0] = "containingDeclaration";
                break;
            case 7:
            case 12:
                objArr[0] = "newOwner";
                break;
            case 11:
            case 18:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/load/java/descriptors/JavaClassConstructorDescriptor";
                break;
            case 14:
                objArr[0] = "sourceElement";
                break;
            case 16:
                objArr[0] = "enhancedValueParametersData";
                break;
            case 17:
                objArr[0] = "enhancedReturnType";
                break;
        }
        if (i == 11) {
            objArr[1] = "createSubstitutedCopy";
        } else if (i != 18) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/load/java/descriptors/JavaClassConstructorDescriptor";
        } else {
            objArr[1] = "enhance";
        }
        switch (i) {
            case 4:
            case 5:
            case 6:
                objArr[2] = "createJavaConstructor";
                break;
            case 7:
            case 8:
            case 9:
            case 10:
                objArr[2] = "createSubstitutedCopy";
                break;
            case 11:
            case 18:
                break;
            case 12:
            case 13:
            case 14:
            case 15:
                objArr[2] = "createDescriptor";
                break;
            case 16:
            case 17:
                objArr[2] = "enhance";
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String str2 = String.format(str, objArr);
        if (i != 11 && i != 18) {
            throw new IllegalArgumentException(str2);
        }
        throw new IllegalStateException(str2);
    }

    @Override // ir.nasim.BB2
    public boolean P0() {
        return this.J.booleanValue();
    }

    @Override // ir.nasim.BB2
    public void X0(boolean z) {
        this.J = Boolean.valueOf(z);
    }

    @Override // ir.nasim.BB2
    public void Y0(boolean z) {
        this.Y = Boolean.valueOf(z);
    }

    @Override // ir.nasim.BB2, ir.nasim.InterfaceC14592iA0
    public boolean h0() {
        return this.Y.booleanValue();
    }

    protected C7340Rh3 q1(InterfaceC21331tU0 interfaceC21331tU0, C7340Rh3 c7340Rh3, InterfaceC15194jA0.a aVar, JH6 jh6, InterfaceC4356Eu interfaceC4356Eu) {
        if (interfaceC21331tU0 == null) {
            x(12);
        }
        if (aVar == null) {
            x(13);
        }
        if (jh6 == null) {
            x(14);
        }
        if (interfaceC4356Eu == null) {
            x(15);
        }
        return new C7340Rh3(interfaceC21331tU0, c7340Rh3, interfaceC4356Eu, this.G, aVar, jh6);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ir.nasim.C18920pU0
    /* renamed from: s1, reason: merged with bridge method [inline-methods] */
    public C7340Rh3 K0(InterfaceC12795fB1 interfaceC12795fB1, AB2 ab2, InterfaceC15194jA0.a aVar, C6432No4 c6432No4, InterfaceC4356Eu interfaceC4356Eu, JH6 jh6) {
        if (interfaceC12795fB1 == null) {
            x(7);
        }
        if (aVar == null) {
            x(8);
        }
        if (interfaceC4356Eu == null) {
            x(9);
        }
        if (jh6 == null) {
            x(10);
        }
        if (aVar == InterfaceC15194jA0.a.DECLARATION || aVar == InterfaceC15194jA0.a.SYNTHESIZED) {
            C7340Rh3 c7340Rh3Q1 = q1((InterfaceC21331tU0) interfaceC12795fB1, (C7340Rh3) ab2, aVar, jh6, interfaceC4356Eu);
            c7340Rh3Q1.X0(P0());
            c7340Rh3Q1.Y0(h0());
            return c7340Rh3Q1;
        }
        throw new IllegalStateException("Attempt at creating a constructor that is not a declaration: \ncopy from: " + this + Separators.RETURN + "newOwner: " + interfaceC12795fB1 + Separators.RETURN + "kind: " + aVar);
    }

    @Override // ir.nasim.InterfaceC6862Ph3
    /* renamed from: t1, reason: merged with bridge method [inline-methods] */
    public C7340Rh3 X(AbstractC4099Dr3 abstractC4099Dr3, List list, AbstractC4099Dr3 abstractC4099Dr32, XV4 xv4) {
        if (list == null) {
            x(16);
        }
        if (abstractC4099Dr32 == null) {
            x(17);
        }
        C7340Rh3 c7340Rh3K0 = K0(b(), null, f(), null, getAnnotations(), i());
        c7340Rh3K0.Q0(abstractC4099Dr3 == null ? null : AbstractC23657xI1.f(c7340Rh3K0, abstractC4099Dr3, InterfaceC4356Eu.W.b()), N(), getTypeParameters(), AbstractC14118hN7.a(list, h(), c7340Rh3K0), abstractC4099Dr32, r(), getVisibility());
        if (xv4 != null) {
            c7340Rh3K0.T0((InterfaceC14592iA0.a) xv4.e(), xv4.f());
        }
        return c7340Rh3K0;
    }
}
