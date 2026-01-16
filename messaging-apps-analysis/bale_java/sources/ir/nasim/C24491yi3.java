package ir.nasim;

import ir.nasim.InterfaceC15194jA0;
import java.util.List;

/* renamed from: ir.nasim.yi3, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public class C24491yi3 extends C21676tw5 implements InterfaceC6862Ph3 {
    private final boolean A;
    private final XV4 B;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    protected C24491yi3(InterfaceC12795fB1 interfaceC12795fB1, InterfaceC4356Eu interfaceC4356Eu, EnumC11067cg4 enumC11067cg4, RI1 ri1, boolean z, C6432No4 c6432No4, JH6 jh6, InterfaceC20989sw5 interfaceC20989sw5, InterfaceC15194jA0.a aVar, boolean z2, XV4 xv4) {
        super(interfaceC12795fB1, interfaceC20989sw5, interfaceC4356Eu, enumC11067cg4, ri1, z, c6432No4, aVar, jh6, false, false, false, false, false, false);
        if (interfaceC12795fB1 == null) {
            x(0);
        }
        if (interfaceC4356Eu == null) {
            x(1);
        }
        if (enumC11067cg4 == null) {
            x(2);
        }
        if (ri1 == null) {
            x(3);
        }
        if (c6432No4 == null) {
            x(4);
        }
        if (jh6 == null) {
            x(5);
        }
        if (aVar == null) {
            x(6);
        }
        this.A = z2;
        this.B = xv4;
    }

    public static C24491yi3 a1(InterfaceC12795fB1 interfaceC12795fB1, InterfaceC4356Eu interfaceC4356Eu, EnumC11067cg4 enumC11067cg4, RI1 ri1, boolean z, C6432No4 c6432No4, JH6 jh6, boolean z2) {
        if (interfaceC12795fB1 == null) {
            x(7);
        }
        if (interfaceC4356Eu == null) {
            x(8);
        }
        if (enumC11067cg4 == null) {
            x(9);
        }
        if (ri1 == null) {
            x(10);
        }
        if (c6432No4 == null) {
            x(11);
        }
        if (jh6 == null) {
            x(12);
        }
        return new C24491yi3(interfaceC12795fB1, interfaceC4356Eu, enumC11067cg4, ri1, z, c6432No4, jh6, null, InterfaceC15194jA0.a.DECLARATION, z2, null);
    }

    private static /* synthetic */ void x(int i) {
        String str = i != 21 ? "Argument for @NotNull parameter '%s' of %s.%s must not be null" : "@NotNull method %s.%s must not return null";
        Object[] objArr = new Object[i != 21 ? 3 : 2];
        switch (i) {
            case 1:
            case 8:
                objArr[0] = "annotations";
                break;
            case 2:
            case 9:
                objArr[0] = "modality";
                break;
            case 3:
            case 10:
                objArr[0] = "visibility";
                break;
            case 4:
            case 11:
                objArr[0] = "name";
                break;
            case 5:
            case 12:
            case 18:
                objArr[0] = "source";
                break;
            case 6:
            case 16:
                objArr[0] = "kind";
                break;
            case 7:
            default:
                objArr[0] = "containingDeclaration";
                break;
            case 13:
                objArr[0] = "newOwner";
                break;
            case 14:
                objArr[0] = "newModality";
                break;
            case 15:
                objArr[0] = "newVisibility";
                break;
            case 17:
                objArr[0] = "newName";
                break;
            case 19:
                objArr[0] = "enhancedValueParametersData";
                break;
            case 20:
                objArr[0] = "enhancedReturnType";
                break;
            case 21:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/load/java/descriptors/JavaPropertyDescriptor";
                break;
        }
        if (i != 21) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/load/java/descriptors/JavaPropertyDescriptor";
        } else {
            objArr[1] = "enhance";
        }
        switch (i) {
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
                objArr[2] = "create";
                break;
            case 13:
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
                objArr[2] = "createSubstitutedCopy";
                break;
            case 19:
            case 20:
                objArr[2] = "enhance";
                break;
            case 21:
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String str2 = String.format(str, objArr);
        if (i == 21) {
            throw new IllegalStateException(str2);
        }
    }

    @Override // ir.nasim.C21676tw5
    protected C21676tw5 N0(InterfaceC12795fB1 interfaceC12795fB1, EnumC11067cg4 enumC11067cg4, RI1 ri1, InterfaceC20989sw5 interfaceC20989sw5, InterfaceC15194jA0.a aVar, C6432No4 c6432No4, JH6 jh6) {
        if (interfaceC12795fB1 == null) {
            x(13);
        }
        if (enumC11067cg4 == null) {
            x(14);
        }
        if (ri1 == null) {
            x(15);
        }
        if (aVar == null) {
            x(16);
        }
        if (c6432No4 == null) {
            x(17);
        }
        if (jh6 == null) {
            x(18);
        }
        return new C24491yi3(interfaceC12795fB1, getAnnotations(), enumC11067cg4, ri1, P(), c6432No4, jh6, interfaceC20989sw5, aVar, this.A, this.B);
    }

    @Override // ir.nasim.InterfaceC6862Ph3
    public InterfaceC6862Ph3 X(AbstractC4099Dr3 abstractC4099Dr3, List list, AbstractC4099Dr3 abstractC4099Dr32, XV4 xv4) {
        C22862vw5 c22862vw5;
        C4380Ew5 c4380Ew5;
        if (list == null) {
            x(19);
        }
        if (abstractC4099Dr32 == null) {
            x(20);
        }
        InterfaceC20989sw5 interfaceC20989sw5A = a() == this ? null : a();
        C24491yi3 c24491yi3 = new C24491yi3(b(), getAnnotations(), r(), getVisibility(), P(), getName(), i(), interfaceC20989sw5A, f(), this.A, xv4);
        C22862vw5 c22862vw5G = g();
        if (c22862vw5G != null) {
            c22862vw5 = c22862vw5;
            C22862vw5 c22862vw52 = new C22862vw5(c24491yi3, c22862vw5G.getAnnotations(), c22862vw5G.r(), c22862vw5G.getVisibility(), c22862vw5G.F(), c22862vw5G.isExternal(), c22862vw5G.isInline(), f(), interfaceC20989sw5A == null ? null : interfaceC20989sw5A.g(), c22862vw5G.i());
            c22862vw5.L0(c22862vw5G.s0());
            c22862vw5.O0(abstractC4099Dr32);
        } else {
            c22862vw5 = null;
        }
        InterfaceC4146Dw5 interfaceC4146Dw5J = J();
        if (interfaceC4146Dw5J != null) {
            C4380Ew5 c4380Ew52 = new C4380Ew5(c24491yi3, interfaceC4146Dw5J.getAnnotations(), interfaceC4146Dw5J.r(), interfaceC4146Dw5J.getVisibility(), interfaceC4146Dw5J.F(), interfaceC4146Dw5J.isExternal(), interfaceC4146Dw5J.isInline(), f(), interfaceC20989sw5A == null ? null : interfaceC20989sw5A.J(), interfaceC4146Dw5J.i());
            c4380Ew52.L0(c4380Ew52.s0());
            c4380Ew52.P0((InterfaceC24919zQ7) interfaceC4146Dw5J.h().get(0));
            c4380Ew5 = c4380Ew52;
        } else {
            c4380Ew5 = null;
        }
        c24491yi3.T0(c22862vw5, c4380Ew5, v0(), R());
        c24491yi3.X0(U0());
        InterfaceC20580sF4 interfaceC20580sF4 = this.g;
        if (interfaceC20580sF4 != null) {
            c24491yi3.J0(interfaceC20580sF4);
        }
        c24491yi3.D0(d());
        c24491yi3.Y0(abstractC4099Dr32, getTypeParameters(), N(), abstractC4099Dr3 == null ? null : AbstractC23657xI1.f(this, abstractC4099Dr3, InterfaceC4356Eu.W.b()));
        return c24491yi3;
    }

    @Override // ir.nasim.C21676tw5, ir.nasim.FQ7
    public boolean c0() {
        AbstractC4099Dr3 type = getType();
        return this.A && C5858Ld1.a(type) && (!AbstractC18037ny7.i(type) || AbstractC19738qr3.C0(type));
    }

    @Override // ir.nasim.GQ7, ir.nasim.InterfaceC14592iA0
    public boolean h0() {
        return false;
    }
}
