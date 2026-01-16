package ir.nasim;

import ir.nasim.InterfaceC15194jA0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* renamed from: ir.nasim.tw5, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public class C21676tw5 extends IQ7 implements InterfaceC20989sw5 {
    private final EnumC11067cg4 h;
    private RI1 i;
    private Collection j;
    private final InterfaceC20989sw5 k;
    private final InterfaceC15194jA0.a l;
    private final boolean m;
    private final boolean n;
    private final boolean o;
    private final boolean p;
    private final boolean q;
    private final boolean r;
    private ZI5 s;
    private ZI5 t;
    private List u;
    private C22862vw5 v;
    private InterfaceC4146Dw5 w;
    private boolean x;
    private InterfaceC25104zk2 y;
    private InterfaceC25104zk2 z;

    /* renamed from: ir.nasim.tw5$a */
    public class a {
        private InterfaceC12795fB1 a;
        private EnumC11067cg4 b;
        private RI1 c;
        private InterfaceC15194jA0.a f;
        private ZI5 i;
        private C6432No4 k;
        private AbstractC4099Dr3 l;
        private InterfaceC20989sw5 d = null;
        private boolean e = false;
        private AbstractC5117Hy7 g = AbstractC5117Hy7.b;
        private boolean h = true;
        private List j = null;

        public a() {
            this.a = C21676tw5.this.b();
            this.b = C21676tw5.this.r();
            this.c = C21676tw5.this.getVisibility();
            this.f = C21676tw5.this.f();
            this.i = C21676tw5.this.s;
            this.k = C21676tw5.this.getName();
            this.l = C21676tw5.this.getType();
        }

        private static /* synthetic */ void a(int i) {
            String str = (i == 1 || i == 2 || i == 3 || i == 5 || i == 7 || i == 9 || i == 11 || i == 19 || i == 13 || i == 14 || i == 16 || i == 17) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
            Object[] objArr = new Object[(i == 1 || i == 2 || i == 3 || i == 5 || i == 7 || i == 9 || i == 11 || i == 19 || i == 13 || i == 14 || i == 16 || i == 17) ? 2 : 3];
            switch (i) {
                case 1:
                case 2:
                case 3:
                case 5:
                case 7:
                case 9:
                case 11:
                case 13:
                case 14:
                case 16:
                case 17:
                case 19:
                    objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertyDescriptorImpl$CopyConfiguration";
                    break;
                case 4:
                    objArr[0] = "type";
                    break;
                case 6:
                    objArr[0] = "modality";
                    break;
                case 8:
                    objArr[0] = "visibility";
                    break;
                case 10:
                    objArr[0] = "kind";
                    break;
                case 12:
                    objArr[0] = "typeParameters";
                    break;
                case 15:
                    objArr[0] = "substitution";
                    break;
                case 18:
                    objArr[0] = "name";
                    break;
                default:
                    objArr[0] = "owner";
                    break;
            }
            if (i == 1) {
                objArr[1] = "setOwner";
            } else if (i == 2) {
                objArr[1] = "setOriginal";
            } else if (i == 3) {
                objArr[1] = "setPreserveSourceElement";
            } else if (i == 5) {
                objArr[1] = "setReturnType";
            } else if (i == 7) {
                objArr[1] = "setModality";
            } else if (i == 9) {
                objArr[1] = "setVisibility";
            } else if (i == 11) {
                objArr[1] = "setKind";
            } else if (i == 19) {
                objArr[1] = "setName";
            } else if (i == 13) {
                objArr[1] = "setTypeParameters";
            } else if (i == 14) {
                objArr[1] = "setDispatchReceiverParameter";
            } else if (i == 16) {
                objArr[1] = "setSubstitution";
            } else if (i != 17) {
                objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertyDescriptorImpl$CopyConfiguration";
            } else {
                objArr[1] = "setCopyOverrides";
            }
            switch (i) {
                case 1:
                case 2:
                case 3:
                case 5:
                case 7:
                case 9:
                case 11:
                case 13:
                case 14:
                case 16:
                case 17:
                case 19:
                    break;
                case 4:
                    objArr[2] = "setReturnType";
                    break;
                case 6:
                    objArr[2] = "setModality";
                    break;
                case 8:
                    objArr[2] = "setVisibility";
                    break;
                case 10:
                    objArr[2] = "setKind";
                    break;
                case 12:
                    objArr[2] = "setTypeParameters";
                    break;
                case 15:
                    objArr[2] = "setSubstitution";
                    break;
                case 18:
                    objArr[2] = "setName";
                    break;
                default:
                    objArr[2] = "setOwner";
                    break;
            }
            String str2 = String.format(str, objArr);
            if (i != 1 && i != 2 && i != 3 && i != 5 && i != 7 && i != 9 && i != 11 && i != 19 && i != 13 && i != 14 && i != 16 && i != 17) {
                throw new IllegalArgumentException(str2);
            }
            throw new IllegalStateException(str2);
        }

        public InterfaceC20989sw5 n() {
            return C21676tw5.this.O0(this);
        }

        InterfaceC22266uw5 o() {
            InterfaceC20989sw5 interfaceC20989sw5 = this.d;
            if (interfaceC20989sw5 == null) {
                return null;
            }
            return interfaceC20989sw5.g();
        }

        InterfaceC4146Dw5 p() {
            InterfaceC20989sw5 interfaceC20989sw5 = this.d;
            if (interfaceC20989sw5 == null) {
                return null;
            }
            return interfaceC20989sw5.J();
        }

        public a q(boolean z) {
            this.h = z;
            return this;
        }

        public a r(InterfaceC15194jA0.a aVar) {
            if (aVar == null) {
                a(10);
            }
            this.f = aVar;
            return this;
        }

        public a s(EnumC11067cg4 enumC11067cg4) {
            if (enumC11067cg4 == null) {
                a(6);
            }
            this.b = enumC11067cg4;
            return this;
        }

        public a t(InterfaceC15194jA0 interfaceC15194jA0) {
            this.d = (InterfaceC20989sw5) interfaceC15194jA0;
            return this;
        }

        public a u(InterfaceC12795fB1 interfaceC12795fB1) {
            if (interfaceC12795fB1 == null) {
                a(0);
            }
            this.a = interfaceC12795fB1;
            return this;
        }

        public a v(AbstractC5117Hy7 abstractC5117Hy7) {
            if (abstractC5117Hy7 == null) {
                a(15);
            }
            this.g = abstractC5117Hy7;
            return this;
        }

        public a w(RI1 ri1) {
            if (ri1 == null) {
                a(8);
            }
            this.c = ri1;
            return this;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    protected C21676tw5(InterfaceC12795fB1 interfaceC12795fB1, InterfaceC20989sw5 interfaceC20989sw5, InterfaceC4356Eu interfaceC4356Eu, EnumC11067cg4 enumC11067cg4, RI1 ri1, boolean z, C6432No4 c6432No4, InterfaceC15194jA0.a aVar, JH6 jh6, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7) {
        super(interfaceC12795fB1, interfaceC4356Eu, c6432No4, null, z, jh6);
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
        if (aVar == null) {
            x(5);
        }
        if (jh6 == null) {
            x(6);
        }
        this.j = null;
        this.h = enumC11067cg4;
        this.i = ri1;
        this.k = interfaceC20989sw5 == null ? this : interfaceC20989sw5;
        this.l = aVar;
        this.m = z2;
        this.n = z3;
        this.o = z4;
        this.p = z5;
        this.q = z6;
        this.r = z7;
    }

    public static C21676tw5 M0(InterfaceC12795fB1 interfaceC12795fB1, InterfaceC4356Eu interfaceC4356Eu, EnumC11067cg4 enumC11067cg4, RI1 ri1, boolean z, C6432No4 c6432No4, InterfaceC15194jA0.a aVar, JH6 jh6, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7) {
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
        if (aVar == null) {
            x(12);
        }
        if (jh6 == null) {
            x(13);
        }
        return new C21676tw5(interfaceC12795fB1, null, interfaceC4356Eu, enumC11067cg4, ri1, z, c6432No4, aVar, jh6, z2, z3, z4, z5, z6, z7);
    }

    private JH6 Q0(boolean z, InterfaceC20989sw5 interfaceC20989sw5) {
        JH6 jh6I;
        if (z) {
            if (interfaceC20989sw5 == null) {
                interfaceC20989sw5 = a();
            }
            jh6I = interfaceC20989sw5.i();
        } else {
            jh6I = JH6.a;
        }
        if (jh6I == null) {
            x(23);
        }
        return jh6I;
    }

    private static AB2 R0(C5585Jy7 c5585Jy7, InterfaceC19199pw5 interfaceC19199pw5) {
        if (c5585Jy7 == null) {
            x(25);
        }
        if (interfaceC19199pw5 == null) {
            x(26);
        }
        if (interfaceC19199pw5.s0() != null) {
            return interfaceC19199pw5.s0().c(c5585Jy7);
        }
        return null;
    }

    private static RI1 W0(RI1 ri1, InterfaceC15194jA0.a aVar) {
        return (aVar == InterfaceC15194jA0.a.FAKE_OVERRIDE && QI1.g(ri1.f())) ? QI1.h : ri1;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x001a  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x002c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static /* synthetic */ void x(int r11) {
        /*
            Method dump skipped, instructions count: 488
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C21676tw5.x(int):void");
    }

    @Override // ir.nasim.HQ7
    public boolean B() {
        return this.r;
    }

    @Override // ir.nasim.InterfaceC15194jA0
    public void D0(Collection collection) {
        if (collection == null) {
            x(35);
        }
        this.j = collection;
    }

    @Override // ir.nasim.InterfaceC20989sw5
    public InterfaceC4146Dw5 J() {
        return this.w;
    }

    @Override // ir.nasim.InterfaceC15194jA0
    /* renamed from: L0, reason: merged with bridge method [inline-methods] */
    public InterfaceC20989sw5 u(InterfaceC12795fB1 interfaceC12795fB1, EnumC11067cg4 enumC11067cg4, RI1 ri1, InterfaceC15194jA0.a aVar, boolean z) {
        InterfaceC20989sw5 interfaceC20989sw5N = V0().u(interfaceC12795fB1).t(null).s(enumC11067cg4).w(ri1).r(aVar).q(z).n();
        if (interfaceC20989sw5N == null) {
            x(37);
        }
        return interfaceC20989sw5N;
    }

    @Override // ir.nasim.GQ7, ir.nasim.InterfaceC14592iA0
    public ZI5 N() {
        return this.s;
    }

    protected C21676tw5 N0(InterfaceC12795fB1 interfaceC12795fB1, EnumC11067cg4 enumC11067cg4, RI1 ri1, InterfaceC20989sw5 interfaceC20989sw5, InterfaceC15194jA0.a aVar, C6432No4 c6432No4, JH6 jh6) {
        if (interfaceC12795fB1 == null) {
            x(27);
        }
        if (enumC11067cg4 == null) {
            x(28);
        }
        if (ri1 == null) {
            x(29);
        }
        if (aVar == null) {
            x(30);
        }
        if (c6432No4 == null) {
            x(31);
        }
        if (jh6 == null) {
            x(32);
        }
        return new C21676tw5(interfaceC12795fB1, interfaceC20989sw5, getAnnotations(), enumC11067cg4, ri1, P(), c6432No4, aVar, jh6, w0(), c0(), l0(), Y(), isExternal(), B());
    }

    protected InterfaceC20989sw5 O0(a aVar) {
        ZI5 zi5C;
        C9645aJ5 c9645aJ5;
        InterfaceC20580sF4 interfaceC20580sF4;
        if (aVar == null) {
            x(24);
        }
        C21676tw5 c21676tw5N0 = N0(aVar.a, aVar.b, aVar.c, aVar.d, aVar.f, aVar.k, Q0(aVar.e, aVar.d));
        List typeParameters = aVar.j == null ? getTypeParameters() : aVar.j;
        ArrayList arrayList = new ArrayList(typeParameters.size());
        C5585Jy7 c5585Jy7B = MI1.b(typeParameters, aVar.g, c21676tw5N0, arrayList);
        AbstractC4099Dr3 abstractC4099Dr3 = aVar.l;
        KQ7 kq7 = KQ7.OUT_VARIANCE;
        AbstractC4099Dr3 abstractC4099Dr3P = c5585Jy7B.p(abstractC4099Dr3, kq7);
        if (abstractC4099Dr3P == null) {
            return null;
        }
        ZI5 zi5 = aVar.i;
        if (zi5 != null) {
            zi5C = zi5.c(c5585Jy7B);
            if (zi5C == null) {
                return null;
            }
        } else {
            zi5C = null;
        }
        ZI5 zi52 = this.t;
        if (zi52 != null) {
            AbstractC4099Dr3 abstractC4099Dr3P2 = c5585Jy7B.p(zi52.getType(), KQ7.IN_VARIANCE);
            if (abstractC4099Dr3P2 == null) {
                return null;
            }
            c9645aJ5 = new C9645aJ5(c21676tw5N0, new C6340Ne2(c21676tw5N0, abstractC4099Dr3P2, this.t.getValue()), this.t.getAnnotations());
        } else {
            c9645aJ5 = null;
        }
        c21676tw5N0.Y0(abstractC4099Dr3P, arrayList, zi5C, c9645aJ5);
        C22862vw5 c22862vw5 = this.v == null ? null : new C22862vw5(c21676tw5N0, this.v.getAnnotations(), aVar.b, W0(this.v.getVisibility(), aVar.f), this.v.F(), this.v.isExternal(), this.v.isInline(), aVar.f, aVar.o(), JH6.a);
        if (c22862vw5 != null) {
            AbstractC4099Dr3 returnType = this.v.getReturnType();
            c22862vw5.L0(R0(c5585Jy7B, this.v));
            c22862vw5.O0(returnType != null ? c5585Jy7B.p(returnType, kq7) : null);
        }
        C4380Ew5 c4380Ew5 = this.w == null ? null : new C4380Ew5(c21676tw5N0, this.w.getAnnotations(), aVar.b, W0(this.w.getVisibility(), aVar.f), this.w.F(), this.w.isExternal(), this.w.isInline(), aVar.f, aVar.p(), JH6.a);
        if (c4380Ew5 != null) {
            List listO0 = BB2.O0(c4380Ew5, this.w.h(), c5585Jy7B, false, false, null);
            if (listO0 == null) {
                c21676tw5N0.X0(true);
                listO0 = Collections.singletonList(C4380Ew5.N0(c4380Ew5, PI1.g(aVar.a).H(), ((InterfaceC24919zQ7) this.w.h().get(0)).getAnnotations()));
            }
            if (listO0.size() != 1) {
                throw new IllegalStateException();
            }
            c4380Ew5.L0(R0(c5585Jy7B, this.w));
            c4380Ew5.P0((InterfaceC24919zQ7) listO0.get(0));
        }
        InterfaceC25104zk2 interfaceC25104zk2 = this.y;
        C3328Ak2 c3328Ak2 = interfaceC25104zk2 == null ? null : new C3328Ak2(interfaceC25104zk2.getAnnotations(), c21676tw5N0);
        InterfaceC25104zk2 interfaceC25104zk22 = this.z;
        c21676tw5N0.T0(c22862vw5, c4380Ew5, c3328Ak2, interfaceC25104zk22 != null ? new C3328Ak2(interfaceC25104zk22.getAnnotations(), c21676tw5N0) : null);
        if (aVar.h) {
            DE6 de6F = DE6.f();
            Iterator it = d().iterator();
            while (it.hasNext()) {
                de6F.add(((InterfaceC20989sw5) it.next()).c(c5585Jy7B));
            }
            c21676tw5N0.D0(de6F);
        }
        if (c0() && (interfaceC20580sF4 = this.g) != null) {
            c21676tw5N0.J0(interfaceC20580sF4);
        }
        return c21676tw5N0;
    }

    @Override // ir.nasim.InterfaceC20989sw5
    /* renamed from: P0, reason: merged with bridge method [inline-methods] */
    public C22862vw5 g() {
        return this.v;
    }

    @Override // ir.nasim.GQ7, ir.nasim.InterfaceC14592iA0
    public ZI5 Q() {
        return this.t;
    }

    @Override // ir.nasim.InterfaceC20989sw5
    public InterfaceC25104zk2 R() {
        return this.z;
    }

    public void S0(C22862vw5 c22862vw5, InterfaceC4146Dw5 interfaceC4146Dw5) {
        T0(c22862vw5, interfaceC4146Dw5, null, null);
    }

    public void T0(C22862vw5 c22862vw5, InterfaceC4146Dw5 interfaceC4146Dw5, InterfaceC25104zk2 interfaceC25104zk2, InterfaceC25104zk2 interfaceC25104zk22) {
        this.v = c22862vw5;
        this.w = interfaceC4146Dw5;
        this.y = interfaceC25104zk2;
        this.z = interfaceC25104zk22;
    }

    public boolean U0() {
        return this.x;
    }

    public a V0() {
        return new a();
    }

    public void X0(boolean z) {
        this.x = z;
    }

    @Override // ir.nasim.InterfaceC21058t24
    public boolean Y() {
        return this.p;
    }

    public void Y0(AbstractC4099Dr3 abstractC4099Dr3, List list, ZI5 zi5, ZI5 zi52) {
        if (abstractC4099Dr3 == null) {
            x(14);
        }
        if (list == null) {
            x(15);
        }
        I0(abstractC4099Dr3);
        this.u = new ArrayList(list);
        this.t = zi52;
        this.s = zi5;
    }

    public void Z0(RI1 ri1) {
        if (ri1 == null) {
            x(16);
        }
        this.i = ri1;
    }

    @Override // ir.nasim.FQ7
    public boolean c0() {
        return this.n;
    }

    @Override // ir.nasim.InterfaceC14592iA0
    public Collection d() {
        Collection collectionEmptyList = this.j;
        if (collectionEmptyList == null) {
            collectionEmptyList = Collections.emptyList();
        }
        if (collectionEmptyList == null) {
            x(36);
        }
        return collectionEmptyList;
    }

    @Override // ir.nasim.InterfaceC15194jA0
    public InterfaceC15194jA0.a f() {
        InterfaceC15194jA0.a aVar = this.l;
        if (aVar == null) {
            x(34);
        }
        return aVar;
    }

    @Override // ir.nasim.GQ7, ir.nasim.InterfaceC14592iA0
    public AbstractC4099Dr3 getReturnType() {
        AbstractC4099Dr3 type = getType();
        if (type == null) {
            x(18);
        }
        return type;
    }

    @Override // ir.nasim.GQ7, ir.nasim.InterfaceC14592iA0
    public List getTypeParameters() {
        List list = this.u;
        if (list != null) {
            return list;
        }
        throw new IllegalStateException("typeParameters == null for " + toString());
    }

    @Override // ir.nasim.InterfaceC16977mB1
    public RI1 getVisibility() {
        RI1 ri1 = this.i;
        if (ri1 == null) {
            x(20);
        }
        return ri1;
    }

    public boolean isExternal() {
        return this.q;
    }

    @Override // ir.nasim.InterfaceC21058t24
    public boolean l0() {
        return this.o;
    }

    @Override // ir.nasim.InterfaceC12795fB1
    public Object q0(InterfaceC15204jB1 interfaceC15204jB1, Object obj) {
        return interfaceC15204jB1.f(this, obj);
    }

    @Override // ir.nasim.InterfaceC21058t24
    public EnumC11067cg4 r() {
        EnumC11067cg4 enumC11067cg4 = this.h;
        if (enumC11067cg4 == null) {
            x(19);
        }
        return enumC11067cg4;
    }

    @Override // ir.nasim.InterfaceC20989sw5
    public List v() {
        ArrayList arrayList = new ArrayList(2);
        C22862vw5 c22862vw5 = this.v;
        if (c22862vw5 != null) {
            arrayList.add(c22862vw5);
        }
        InterfaceC4146Dw5 interfaceC4146Dw5 = this.w;
        if (interfaceC4146Dw5 != null) {
            arrayList.add(interfaceC4146Dw5);
        }
        return arrayList;
    }

    @Override // ir.nasim.InterfaceC20989sw5
    public InterfaceC25104zk2 v0() {
        return this.y;
    }

    @Override // ir.nasim.FQ7
    public boolean w0() {
        return this.m;
    }

    @Override // ir.nasim.InterfaceC19829r07
    public InterfaceC20989sw5 c(C5585Jy7 c5585Jy7) {
        if (c5585Jy7 == null) {
            x(22);
        }
        return c5585Jy7.k() ? this : V0().v(c5585Jy7.j()).t(a()).n();
    }

    @Override // ir.nasim.AbstractC14602iB1
    public InterfaceC20989sw5 a() {
        InterfaceC20989sw5 interfaceC20989sw5 = this.k;
        InterfaceC20989sw5 interfaceC20989sw5A = interfaceC20989sw5 == this ? this : interfaceC20989sw5.a();
        if (interfaceC20989sw5A == null) {
            x(33);
        }
        return interfaceC20989sw5A;
    }
}
