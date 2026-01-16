package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import ir.nasim.InterfaceC22053ub1;
import ir.nasim.InterfaceC6693Oo5;

/* loaded from: classes.dex */
public final class NG0 {
    private final float a;
    private final float b;
    private final float c;
    private final float d;
    private final float e;
    private final float f;

    static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ InterfaceC23241wb3 c;
        final /* synthetic */ C14063hH6 d;

        /* renamed from: ir.nasim.NG0$a$a, reason: collision with other inner class name */
        static final class C0530a implements InterfaceC4806Gq2 {
            final /* synthetic */ C14063hH6 a;

            C0530a(C14063hH6 c14063hH6) {
                this.a = c14063hH6;
            }

            @Override // ir.nasim.InterfaceC4806Gq2
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Object a(InterfaceC22645vb3 interfaceC22645vb3, InterfaceC20295rm1 interfaceC20295rm1) {
                if (interfaceC22645vb3 instanceof C12403eZ2) {
                    this.a.add(interfaceC22645vb3);
                } else if (interfaceC22645vb3 instanceof C13012fZ2) {
                    this.a.remove(((C13012fZ2) interfaceC22645vb3).a());
                } else if (interfaceC22645vb3 instanceof C23400wr2) {
                    this.a.add(interfaceC22645vb3);
                } else if (interfaceC22645vb3 instanceof C23990xr2) {
                    this.a.remove(((C23990xr2) interfaceC22645vb3).a());
                } else if (interfaceC22645vb3 instanceof InterfaceC6693Oo5.b) {
                    this.a.add(interfaceC22645vb3);
                } else if (interfaceC22645vb3 instanceof InterfaceC6693Oo5.c) {
                    this.a.remove(((InterfaceC6693Oo5.c) interfaceC22645vb3).a());
                } else if (interfaceC22645vb3 instanceof InterfaceC6693Oo5.a) {
                    this.a.remove(((InterfaceC6693Oo5.a) interfaceC22645vb3).a());
                } else if (interfaceC22645vb3 instanceof GZ1) {
                    this.a.add(interfaceC22645vb3);
                } else if (interfaceC22645vb3 instanceof HZ1) {
                    this.a.remove(((HZ1) interfaceC22645vb3).a());
                } else if (interfaceC22645vb3 instanceof FZ1) {
                    this.a.remove(((FZ1) interfaceC22645vb3).a());
                }
                return C19938rB7.a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(InterfaceC23241wb3 interfaceC23241wb3, C14063hH6 c14063hH6, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = interfaceC23241wb3;
            this.d = c14063hH6;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new a(this.c, this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC4557Fq2 interfaceC4557Fq2B = this.c.b();
                C0530a c0530a = new C0530a(this.d);
                this.b = 1;
                if (interfaceC4557Fq2B.b(c0530a, this) == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ C15607js c;
        final /* synthetic */ float d;
        final /* synthetic */ boolean e;
        final /* synthetic */ NG0 f;
        final /* synthetic */ InterfaceC22645vb3 g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(C15607js c15607js, float f, boolean z, NG0 ng0, InterfaceC22645vb3 interfaceC22645vb3, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = c15607js;
            this.d = f;
            this.e = z;
            this.f = ng0;
            this.g = interfaceC22645vb3;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new b(this.c, this.d, this.e, this.f, this.g, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                if (!C17784nZ1.s(((C17784nZ1) this.c.n()).v(), this.d)) {
                    if (this.e) {
                        float fV = ((C17784nZ1) this.c.n()).v();
                        InterfaceC22645vb3 gz1 = null;
                        if (C17784nZ1.s(fV, this.f.b)) {
                            gz1 = new InterfaceC6693Oo5.b(ZG4.b.c(), null);
                        } else if (C17784nZ1.s(fV, this.f.d)) {
                            gz1 = new C12403eZ2();
                        } else if (C17784nZ1.s(fV, this.f.c)) {
                            gz1 = new C23400wr2();
                        } else if (C17784nZ1.s(fV, this.f.e)) {
                            gz1 = new GZ1();
                        }
                        C15607js c15607js = this.c;
                        float f = this.d;
                        InterfaceC22645vb3 interfaceC22645vb3 = this.g;
                        this.b = 2;
                        if (E52.d(c15607js, f, gz1, interfaceC22645vb3, this) == objE) {
                            return objE;
                        }
                    } else {
                        C15607js c15607js2 = this.c;
                        C17784nZ1 c17784nZ1J = C17784nZ1.j(this.d);
                        this.b = 1;
                        if (c15607js2.x(c17784nZ1J, this) == objE) {
                            return objE;
                        }
                    }
                }
            } else {
                if (i != 1 && i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((b) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public /* synthetic */ NG0(float f, float f2, float f3, float f4, float f5, float f6, ED1 ed1) {
        this(f, f2, f3, f4, f5, f6);
    }

    private final InterfaceC9664aL6 e(boolean z, InterfaceC23241wb3 interfaceC23241wb3, InterfaceC22053ub1 interfaceC22053ub1, int i) {
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.Q(-1421890746, i, -1, "androidx.compose.material3.CardElevation.animateElevation (Card.kt:670)");
        }
        Object objB = interfaceC22053ub1.B();
        InterfaceC22053ub1.a aVar = InterfaceC22053ub1.a;
        if (objB == aVar.a()) {
            objB = AbstractC10222bH6.f();
            interfaceC22053ub1.s(objB);
        }
        C14063hH6 c14063hH6 = (C14063hH6) objB;
        boolean z2 = true;
        boolean z3 = (((i & SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER) ^ 48) > 32 && interfaceC22053ub1.V(interfaceC23241wb3)) || (i & 48) == 32;
        Object objB2 = interfaceC22053ub1.B();
        if (z3 || objB2 == aVar.a()) {
            objB2 = new a(interfaceC23241wb3, c14063hH6, null);
            interfaceC22053ub1.s(objB2);
        }
        AbstractC10721c52.e(interfaceC23241wb3, (InterfaceC14603iB2) objB2, interfaceC22053ub1, (i >> 3) & 14);
        InterfaceC22645vb3 interfaceC22645vb3 = (InterfaceC22645vb3) AbstractC15401jX0.F0(c14063hH6);
        float f = !z ? this.f : interfaceC22645vb3 instanceof InterfaceC6693Oo5.b ? this.b : interfaceC22645vb3 instanceof C12403eZ2 ? this.d : interfaceC22645vb3 instanceof C23400wr2 ? this.c : interfaceC22645vb3 instanceof GZ1 ? this.e : this.a;
        Object objB3 = interfaceC22053ub1.B();
        if (objB3 == aVar.a()) {
            objB3 = new C15607js(C17784nZ1.j(f), PQ7.b(C17784nZ1.b), null, null, 12, null);
            interfaceC22053ub1.s(objB3);
        }
        C15607js c15607js = (C15607js) objB3;
        C17784nZ1 c17784nZ1J = C17784nZ1.j(f);
        boolean zD = interfaceC22053ub1.D(c15607js) | interfaceC22053ub1.c(f) | ((((i & 14) ^ 6) > 4 && interfaceC22053ub1.a(z)) || (i & 6) == 4);
        if ((((i & 896) ^ 384) <= 256 || !interfaceC22053ub1.V(this)) && (i & 384) != 256) {
            z2 = false;
        }
        boolean zD2 = zD | z2 | interfaceC22053ub1.D(interfaceC22645vb3);
        Object objB4 = interfaceC22053ub1.B();
        if (zD2 || objB4 == aVar.a()) {
            Object bVar = new b(c15607js, f, z, this, interfaceC22645vb3, null);
            interfaceC22053ub1.s(bVar);
            objB4 = bVar;
        }
        AbstractC10721c52.e(c17784nZ1J, (InterfaceC14603iB2) objB4, interfaceC22053ub1, 0);
        InterfaceC9664aL6 interfaceC9664aL6I = c15607js.i();
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.P();
        }
        return interfaceC9664aL6I;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof NG0)) {
            return false;
        }
        NG0 ng0 = (NG0) obj;
        return C17784nZ1.s(this.a, ng0.a) && C17784nZ1.s(this.b, ng0.b) && C17784nZ1.s(this.c, ng0.c) && C17784nZ1.s(this.d, ng0.d) && C17784nZ1.s(this.f, ng0.f);
    }

    public final InterfaceC9664aL6 f(boolean z, InterfaceC23241wb3 interfaceC23241wb3, InterfaceC22053ub1 interfaceC22053ub1, int i) {
        interfaceC22053ub1.W(-1763481333);
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.Q(-1763481333, i, -1, "androidx.compose.material3.CardElevation.shadowElevation (Card.kt:659)");
        }
        interfaceC22053ub1.W(-734838460);
        if (interfaceC23241wb3 != null) {
            interfaceC22053ub1.Q();
            InterfaceC9664aL6 interfaceC9664aL6E = e(z, interfaceC23241wb3, interfaceC22053ub1, (i & 896) | (i & 14) | (i & SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER));
            if (AbstractC5138Ib1.I()) {
                AbstractC5138Ib1.P();
            }
            interfaceC22053ub1.Q();
            return interfaceC9664aL6E;
        }
        Object objB = interfaceC22053ub1.B();
        if (objB == InterfaceC22053ub1.a.a()) {
            objB = AbstractC13472gH6.d(C17784nZ1.j(this.a), null, 2, null);
            interfaceC22053ub1.s(objB);
        }
        InterfaceC9102Ym4 interfaceC9102Ym4 = (InterfaceC9102Ym4) objB;
        interfaceC22053ub1.Q();
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.P();
        }
        interfaceC22053ub1.Q();
        return interfaceC9102Ym4;
    }

    public int hashCode() {
        return (((((((C17784nZ1.t(this.a) * 31) + C17784nZ1.t(this.b)) * 31) + C17784nZ1.t(this.c)) * 31) + C17784nZ1.t(this.d)) * 31) + C17784nZ1.t(this.f);
    }

    private NG0(float f, float f2, float f3, float f4, float f5, float f6) {
        this.a = f;
        this.b = f2;
        this.c = f3;
        this.d = f4;
        this.e = f5;
        this.f = f6;
    }
}
