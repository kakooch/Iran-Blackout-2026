package ir.nasim;

/* loaded from: classes8.dex */
public abstract class E0 extends AbstractC6615Og4 {
    private final C6432No4 b;
    protected final InterfaceC23016wC4 c;
    private final InterfaceC23016wC4 d;
    private final InterfaceC23016wC4 e;

    class a implements SA2 {

        /* renamed from: ir.nasim.E0$a$a, reason: collision with other inner class name */
        class C0334a implements UA2 {
            C0334a() {
            }

            @Override // ir.nasim.UA2
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public XC6 invoke(AbstractC5284Ir3 abstractC5284Ir3) {
                MU0 mu0E = abstractC5284Ir3.e(E0.this);
                return mu0E == null ? (XC6) E0.this.c.invoke() : mu0E instanceof InterfaceC7722Sx7 ? C4567Fr3.b((InterfaceC7722Sx7) mu0E, AbstractC7497Ry7.g(mu0E.j().getParameters())) : mu0E instanceof AbstractC6615Og4 ? AbstractC7497Ry7.u(mu0E.j().a(abstractC5284Ir3), ((AbstractC6615Og4) mu0E).M(abstractC5284Ir3), this) : mu0E.p();
            }
        }

        a() {
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public XC6 invoke() {
            E0 e0 = E0.this;
            return AbstractC7497Ry7.t(e0, e0.W(), new C0334a());
        }
    }

    class b implements SA2 {
        b() {
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public W24 invoke() {
            return new C14575i83(E0.this.W());
        }
    }

    class c implements SA2 {
        c() {
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public ZI5 invoke() {
            return new C11389cv3(E0.this);
        }
    }

    public E0(ON6 on6, C6432No4 c6432No4) {
        if (on6 == null) {
            i0(0);
        }
        if (c6432No4 == null) {
            i0(1);
        }
        this.b = c6432No4;
        this.c = on6.c(new a());
        this.d = on6.c(new b());
        this.e = on6.c(new c());
    }

    private static /* synthetic */ void i0(int i) {
        String str = (i == 2 || i == 3 || i == 4 || i == 5 || i == 8 || i == 11 || i == 13 || i == 15 || i == 16 || i == 18 || i == 19) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i == 2 || i == 3 || i == 4 || i == 5 || i == 8 || i == 11 || i == 13 || i == 15 || i == 16 || i == 18 || i == 19) ? 2 : 3];
        switch (i) {
            case 1:
                objArr[0] = "name";
                break;
            case 2:
            case 3:
            case 4:
            case 5:
            case 8:
            case 11:
            case 13:
            case 15:
            case 16:
            case 18:
            case 19:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/AbstractClassDescriptor";
                break;
            case 6:
            case 12:
                objArr[0] = "typeArguments";
                break;
            case 7:
            case 10:
                objArr[0] = "kotlinTypeRefiner";
                break;
            case 9:
            case 14:
                objArr[0] = "typeSubstitution";
                break;
            case 17:
                objArr[0] = "substitutor";
                break;
            default:
                objArr[0] = "storageManager";
                break;
        }
        if (i == 2) {
            objArr[1] = "getName";
        } else if (i == 3) {
            objArr[1] = "getOriginal";
        } else if (i == 4) {
            objArr[1] = "getUnsubstitutedInnerClassesScope";
        } else if (i == 5) {
            objArr[1] = "getThisAsReceiverParameter";
        } else if (i == 8 || i == 11 || i == 13 || i == 15) {
            objArr[1] = "getMemberScope";
        } else if (i == 16) {
            objArr[1] = "getUnsubstitutedMemberScope";
        } else if (i == 18) {
            objArr[1] = "substitute";
        } else if (i != 19) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/AbstractClassDescriptor";
        } else {
            objArr[1] = "getDefaultType";
        }
        switch (i) {
            case 2:
            case 3:
            case 4:
            case 5:
            case 8:
            case 11:
            case 13:
            case 15:
            case 16:
            case 18:
            case 19:
                break;
            case 6:
            case 7:
            case 9:
            case 10:
            case 12:
            case 14:
                objArr[2] = "getMemberScope";
                break;
            case 17:
                objArr[2] = "substitute";
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String str2 = String.format(str, objArr);
        if (i != 2 && i != 3 && i != 4 && i != 5 && i != 8 && i != 11 && i != 13 && i != 15 && i != 16 && i != 18 && i != 19) {
            throw new IllegalArgumentException(str2);
        }
        throw new IllegalStateException(str2);
    }

    @Override // ir.nasim.InterfaceC21331tU0
    public W24 H(AbstractC5117Hy7 abstractC5117Hy7) {
        if (abstractC5117Hy7 == null) {
            i0(14);
        }
        W24 w24X = x(abstractC5117Hy7, PI1.k(OI1.g(this)));
        if (w24X == null) {
            i0(15);
        }
        return w24X;
    }

    @Override // ir.nasim.InterfaceC21331tU0
    public ZI5 H0() {
        ZI5 zi5 = (ZI5) this.e.invoke();
        if (zi5 == null) {
            i0(5);
        }
        return zi5;
    }

    @Override // ir.nasim.InterfaceC19829r07
    /* renamed from: I0 */
    public InterfaceC21331tU0 c(C5585Jy7 c5585Jy7) {
        if (c5585Jy7 == null) {
            i0(17);
        }
        return c5585Jy7.k() ? this : new C4621Fx3(this, c5585Jy7);
    }

    @Override // ir.nasim.InterfaceC21331tU0
    public W24 U() {
        W24 w24 = (W24) this.d.invoke();
        if (w24 == null) {
            i0(4);
        }
        return w24;
    }

    @Override // ir.nasim.InterfaceC21331tU0
    public W24 W() {
        W24 w24M = M(PI1.k(OI1.g(this)));
        if (w24M == null) {
            i0(16);
        }
        return w24M;
    }

    @Override // ir.nasim.InterfaceC7638So4
    public C6432No4 getName() {
        C6432No4 c6432No4 = this.b;
        if (c6432No4 == null) {
            i0(2);
        }
        return c6432No4;
    }

    @Override // ir.nasim.InterfaceC21331tU0, ir.nasim.MU0
    public XC6 p() {
        XC6 xc6 = (XC6) this.c.invoke();
        if (xc6 == null) {
            i0(19);
        }
        return xc6;
    }

    @Override // ir.nasim.InterfaceC12795fB1
    public Object q0(InterfaceC15204jB1 interfaceC15204jB1, Object obj) {
        return interfaceC15204jB1.a(this, obj);
    }

    @Override // ir.nasim.AbstractC6615Og4
    public W24 x(AbstractC5117Hy7 abstractC5117Hy7, AbstractC5284Ir3 abstractC5284Ir3) {
        if (abstractC5117Hy7 == null) {
            i0(9);
        }
        if (abstractC5284Ir3 == null) {
            i0(10);
        }
        if (!abstractC5117Hy7.f()) {
            return new C22305v07(M(abstractC5284Ir3), C5585Jy7.g(abstractC5117Hy7));
        }
        W24 w24M = M(abstractC5284Ir3);
        if (w24M == null) {
            i0(11);
        }
        return w24M;
    }

    @Override // ir.nasim.InterfaceC12795fB1
    public InterfaceC21331tU0 a() {
        return this;
    }
}
