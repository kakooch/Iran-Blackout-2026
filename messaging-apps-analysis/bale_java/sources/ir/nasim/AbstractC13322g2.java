package ir.nasim;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

/* renamed from: ir.nasim.g2, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public abstract class AbstractC13322g2 extends AbstractC14602iB1 implements InterfaceC22882vy7 {
    private final KQ7 e;
    private final boolean f;
    private final int g;
    private final InterfaceC23016wC4 h;
    private final InterfaceC23016wC4 i;
    private final ON6 j;

    /* renamed from: ir.nasim.g2$a */
    class a implements SA2 {
        final /* synthetic */ ON6 a;
        final /* synthetic */ M17 b;

        a(ON6 on6, M17 m17) {
            this.a = on6;
            this.b = m17;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public InterfaceC13882gy7 invoke() {
            return new c(AbstractC13322g2.this, this.a, this.b);
        }
    }

    /* renamed from: ir.nasim.g2$b */
    class b implements SA2 {
        final /* synthetic */ C6432No4 a;

        /* renamed from: ir.nasim.g2$b$a */
        class a implements SA2 {
            a() {
            }

            @Override // ir.nasim.SA2
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public W24 invoke() {
                return C18628oy7.j("Scope for type parameter " + b.this.a.h(), AbstractC13322g2.this.getUpperBounds());
            }
        }

        b(C6432No4 c6432No4) {
            this.a = c6432No4;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public XC6 invoke() {
            return C4567Fr3.j(InterfaceC4356Eu.W.b(), AbstractC13322g2.this.j(), Collections.emptyList(), false, new C23459wx3(new a()));
        }
    }

    /* renamed from: ir.nasim.g2$c */
    private class c extends AbstractC12686f2 {
        private final M17 c;
        final /* synthetic */ AbstractC13322g2 d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(AbstractC13322g2 abstractC13322g2, ON6 on6, M17 m17) {
            super(on6);
            if (on6 == null) {
                r(0);
            }
            this.d = abstractC13322g2;
            this.c = m17;
        }

        private static /* synthetic */ void r(int i) {
            String str = (i == 1 || i == 2 || i == 3 || i == 4 || i == 5 || i == 8) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
            Object[] objArr = new Object[(i == 1 || i == 2 || i == 3 || i == 4 || i == 5 || i == 8) ? 2 : 3];
            switch (i) {
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 8:
                    objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/AbstractTypeParameterDescriptor$TypeParameterTypeConstructor";
                    break;
                case 6:
                    objArr[0] = "type";
                    break;
                case 7:
                    objArr[0] = "supertypes";
                    break;
                default:
                    objArr[0] = "storageManager";
                    break;
            }
            if (i == 1) {
                objArr[1] = "computeSupertypes";
            } else if (i == 2) {
                objArr[1] = "getParameters";
            } else if (i == 3) {
                objArr[1] = "getDeclarationDescriptor";
            } else if (i == 4) {
                objArr[1] = "getBuiltIns";
            } else if (i == 5) {
                objArr[1] = "getSupertypeLoopChecker";
            } else if (i != 8) {
                objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/AbstractTypeParameterDescriptor$TypeParameterTypeConstructor";
            } else {
                objArr[1] = "processSupertypesWithoutCycles";
            }
            switch (i) {
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 8:
                    break;
                case 6:
                    objArr[2] = "reportSupertypeLoopError";
                    break;
                case 7:
                    objArr[2] = "processSupertypesWithoutCycles";
                    break;
                default:
                    objArr[2] = "<init>";
                    break;
            }
            String str2 = String.format(str, objArr);
            if (i != 1 && i != 2 && i != 3 && i != 4 && i != 5 && i != 8) {
                throw new IllegalArgumentException(str2);
            }
            throw new IllegalStateException(str2);
        }

        @Override // ir.nasim.AbstractC12686f2, ir.nasim.InterfaceC13882gy7
        public MU0 d() {
            AbstractC13322g2 abstractC13322g2 = this.d;
            if (abstractC13322g2 == null) {
                r(3);
            }
            return abstractC13322g2;
        }

        @Override // ir.nasim.InterfaceC13882gy7
        public boolean e() {
            return true;
        }

        @Override // ir.nasim.InterfaceC13882gy7
        public List getParameters() {
            List listEmptyList = Collections.emptyList();
            if (listEmptyList == null) {
                r(2);
            }
            return listEmptyList;
        }

        @Override // ir.nasim.AbstractC12686f2
        protected Collection h() {
            List listK0 = this.d.K0();
            if (listK0 == null) {
                r(1);
            }
            return listK0;
        }

        @Override // ir.nasim.AbstractC12686f2
        protected AbstractC4099Dr3 i() {
            return AbstractC14230ha2.j("Cyclic upper bounds");
        }

        @Override // ir.nasim.AbstractC12686f2
        protected M17 l() {
            M17 m17 = this.c;
            if (m17 == null) {
                r(5);
            }
            return m17;
        }

        @Override // ir.nasim.InterfaceC13882gy7
        public AbstractC19738qr3 n() {
            AbstractC19738qr3 abstractC19738qr3G = PI1.g(this.d);
            if (abstractC19738qr3G == null) {
                r(4);
            }
            return abstractC19738qr3G;
        }

        @Override // ir.nasim.AbstractC12686f2
        protected List o(List list) {
            if (list == null) {
                r(7);
            }
            List listI0 = this.d.I0(list);
            if (listI0 == null) {
                r(8);
            }
            return listI0;
        }

        @Override // ir.nasim.AbstractC12686f2
        protected void q(AbstractC4099Dr3 abstractC4099Dr3) {
            if (abstractC4099Dr3 == null) {
                r(6);
            }
            this.d.J0(abstractC4099Dr3);
        }

        public String toString() {
            return this.d.getName().toString();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    protected AbstractC13322g2(ON6 on6, InterfaceC12795fB1 interfaceC12795fB1, InterfaceC4356Eu interfaceC4356Eu, C6432No4 c6432No4, KQ7 kq7, boolean z, int i, JH6 jh6, M17 m17) {
        super(interfaceC12795fB1, interfaceC4356Eu, c6432No4, jh6);
        if (on6 == null) {
            x(0);
        }
        if (interfaceC12795fB1 == null) {
            x(1);
        }
        if (interfaceC4356Eu == null) {
            x(2);
        }
        if (c6432No4 == null) {
            x(3);
        }
        if (kq7 == null) {
            x(4);
        }
        if (jh6 == null) {
            x(5);
        }
        if (m17 == null) {
            x(6);
        }
        this.e = kq7;
        this.f = z;
        this.g = i;
        this.h = on6.c(new a(on6, m17));
        this.i = on6.c(new b(c6432No4));
        this.j = on6;
    }

    private static /* synthetic */ void x(int i) {
        String str;
        int i2;
        switch (i) {
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 13:
            case 14:
                str = "@NotNull method %s.%s must not return null";
                break;
            case 12:
            default:
                str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                break;
        }
        switch (i) {
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 13:
            case 14:
                i2 = 2;
                break;
            case 12:
            default:
                i2 = 3;
                break;
        }
        Object[] objArr = new Object[i2];
        switch (i) {
            case 1:
                objArr[0] = "containingDeclaration";
                break;
            case 2:
                objArr[0] = "annotations";
                break;
            case 3:
                objArr[0] = "name";
                break;
            case 4:
                objArr[0] = "variance";
                break;
            case 5:
                objArr[0] = "source";
                break;
            case 6:
                objArr[0] = "supertypeLoopChecker";
                break;
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 13:
            case 14:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/AbstractTypeParameterDescriptor";
                break;
            case 12:
                objArr[0] = "bounds";
                break;
            default:
                objArr[0] = "storageManager";
                break;
        }
        switch (i) {
            case 7:
                objArr[1] = "getVariance";
                break;
            case 8:
                objArr[1] = "getUpperBounds";
                break;
            case 9:
                objArr[1] = "getTypeConstructor";
                break;
            case 10:
                objArr[1] = "getDefaultType";
                break;
            case 11:
                objArr[1] = "getOriginal";
                break;
            case 12:
            default:
                objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/AbstractTypeParameterDescriptor";
                break;
            case 13:
                objArr[1] = "processBoundsWithoutCycles";
                break;
            case 14:
                objArr[1] = "getStorageManager";
                break;
        }
        switch (i) {
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 13:
            case 14:
                break;
            case 12:
                objArr[2] = "processBoundsWithoutCycles";
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String str2 = String.format(str, objArr);
        switch (i) {
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 13:
            case 14:
                throw new IllegalStateException(str2);
            case 12:
            default:
                throw new IllegalArgumentException(str2);
        }
    }

    protected List I0(List list) {
        if (list == null) {
            x(12);
        }
        if (list == null) {
            x(13);
        }
        return list;
    }

    protected abstract void J0(AbstractC4099Dr3 abstractC4099Dr3);

    protected abstract List K0();

    @Override // ir.nasim.InterfaceC22882vy7
    public ON6 O() {
        ON6 on6 = this.j;
        if (on6 == null) {
            x(14);
        }
        return on6;
    }

    @Override // ir.nasim.InterfaceC22882vy7
    public boolean S() {
        return false;
    }

    @Override // ir.nasim.InterfaceC22882vy7
    public int getIndex() {
        return this.g;
    }

    @Override // ir.nasim.InterfaceC22882vy7
    public List getUpperBounds() {
        List listB = ((c) j()).b();
        if (listB == null) {
            x(8);
        }
        return listB;
    }

    @Override // ir.nasim.InterfaceC22882vy7, ir.nasim.MU0
    public final InterfaceC13882gy7 j() {
        InterfaceC13882gy7 interfaceC13882gy7 = (InterfaceC13882gy7) this.h.invoke();
        if (interfaceC13882gy7 == null) {
            x(9);
        }
        return interfaceC13882gy7;
    }

    @Override // ir.nasim.InterfaceC22882vy7
    public KQ7 m() {
        KQ7 kq7 = this.e;
        if (kq7 == null) {
            x(7);
        }
        return kq7;
    }

    @Override // ir.nasim.MU0
    public XC6 p() {
        XC6 xc6 = (XC6) this.i.invoke();
        if (xc6 == null) {
            x(10);
        }
        return xc6;
    }

    @Override // ir.nasim.InterfaceC12795fB1
    public Object q0(InterfaceC15204jB1 interfaceC15204jB1, Object obj) {
        return interfaceC15204jB1.d(this, obj);
    }

    @Override // ir.nasim.InterfaceC22882vy7
    public boolean w() {
        return this.f;
    }

    @Override // ir.nasim.AbstractC14602iB1
    public InterfaceC22882vy7 a() {
        InterfaceC22882vy7 interfaceC22882vy7 = (InterfaceC22882vy7) super.a();
        if (interfaceC22882vy7 == null) {
            x(11);
        }
        return interfaceC22882vy7;
    }
}
