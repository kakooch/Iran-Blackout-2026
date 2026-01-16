package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import ir.nasim.InterfaceC6693Oo5;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
final class WD1 implements InterfaceC20336rq2 {
    private final float a;
    private final float b;
    private final float c;
    private final float d;

    static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ C20927sq2 c;
        final /* synthetic */ WD1 d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(C20927sq2 c20927sq2, WD1 wd1, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = c20927sq2;
            this.d = wd1;
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
                C20927sq2 c20927sq2 = this.c;
                float f = this.d.a;
                float f2 = this.d.b;
                float f3 = this.d.c;
                float f4 = this.d.d;
                this.b = 1;
                if (c20927sq2.f(f, f2, f3, f4, this) == objE) {
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
        private /* synthetic */ Object c;
        final /* synthetic */ InterfaceC23241wb3 d;
        final /* synthetic */ C20927sq2 e;

        static final class a implements InterfaceC4806Gq2 {
            final /* synthetic */ List a;
            final /* synthetic */ InterfaceC20315ro1 b;
            final /* synthetic */ C20927sq2 c;

            /* renamed from: ir.nasim.WD1$b$a$a, reason: collision with other inner class name */
            static final class C0730a extends AbstractC19859r37 implements InterfaceC14603iB2 {
                int b;
                final /* synthetic */ C20927sq2 c;
                final /* synthetic */ InterfaceC22645vb3 d;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C0730a(C20927sq2 c20927sq2, InterfaceC22645vb3 interfaceC22645vb3, InterfaceC20295rm1 interfaceC20295rm1) {
                    super(2, interfaceC20295rm1);
                    this.c = c20927sq2;
                    this.d = interfaceC22645vb3;
                }

                @Override // ir.nasim.E90
                public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                    return new C0730a(this.c, this.d, interfaceC20295rm1);
                }

                @Override // ir.nasim.E90
                public final Object invokeSuspend(Object obj) {
                    Object objE = AbstractC14862ic3.e();
                    int i = this.b;
                    if (i == 0) {
                        AbstractC10685c16.b(obj);
                        C20927sq2 c20927sq2 = this.c;
                        InterfaceC22645vb3 interfaceC22645vb3 = this.d;
                        this.b = 1;
                        if (c20927sq2.b(interfaceC22645vb3, this) == objE) {
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
                    return ((C0730a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
                }
            }

            a(List list, InterfaceC20315ro1 interfaceC20315ro1, C20927sq2 c20927sq2) {
                this.a = list;
                this.b = interfaceC20315ro1;
                this.c = c20927sq2;
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
                }
                AbstractC10533bm0.d(this.b, null, null, new C0730a(this.c, (InterfaceC22645vb3) AbstractC15401jX0.F0(this.a), null), 3, null);
                return C19938rB7.a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(InterfaceC23241wb3 interfaceC23241wb3, C20927sq2 c20927sq2, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = interfaceC23241wb3;
            this.e = c20927sq2;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            b bVar = new b(this.d, this.e, interfaceC20295rm1);
            bVar.c = obj;
            return bVar;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC20315ro1 interfaceC20315ro1 = (InterfaceC20315ro1) this.c;
                ArrayList arrayList = new ArrayList();
                InterfaceC4557Fq2 interfaceC4557Fq2B = this.d.b();
                a aVar = new a(arrayList, interfaceC20315ro1, this.e);
                this.b = 1;
                if (interfaceC4557Fq2B.b(aVar, this) == objE) {
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
            return ((b) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public /* synthetic */ WD1(float f, float f2, float f3, float f4, ED1 ed1) {
        this(f, f2, f3, f4);
    }

    @Override // ir.nasim.InterfaceC20336rq2
    public InterfaceC9664aL6 a(InterfaceC23241wb3 interfaceC23241wb3, InterfaceC22053ub1 interfaceC22053ub1, int i) {
        interfaceC22053ub1.W(-478475335);
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.Q(-478475335, i, -1, "androidx.compose.material.DefaultFloatingActionButtonElevation.elevation (FloatingActionButton.kt:259)");
        }
        int i2 = i & 14;
        int i3 = i2 ^ 6;
        boolean z = (i3 > 4 && interfaceC22053ub1.V(interfaceC23241wb3)) || (i & 6) == 4;
        Object objB = interfaceC22053ub1.B();
        if (z || objB == InterfaceC22053ub1.a.a()) {
            objB = new C20927sq2(this.a, this.b, this.c, this.d, null);
            interfaceC22053ub1.s(objB);
        }
        C20927sq2 c20927sq2 = (C20927sq2) objB;
        boolean zD = interfaceC22053ub1.D(c20927sq2) | ((((i & SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER) ^ 48) > 32 && interfaceC22053ub1.V(this)) || (i & 48) == 32);
        Object objB2 = interfaceC22053ub1.B();
        if (zD || objB2 == InterfaceC22053ub1.a.a()) {
            objB2 = new a(c20927sq2, this, null);
            interfaceC22053ub1.s(objB2);
        }
        AbstractC10721c52.e(this, (InterfaceC14603iB2) objB2, interfaceC22053ub1, (i >> 3) & 14);
        boolean zD2 = interfaceC22053ub1.D(c20927sq2) | ((i3 > 4 && interfaceC22053ub1.V(interfaceC23241wb3)) || (i & 6) == 4);
        Object objB3 = interfaceC22053ub1.B();
        if (zD2 || objB3 == InterfaceC22053ub1.a.a()) {
            objB3 = new b(interfaceC23241wb3, c20927sq2, null);
            interfaceC22053ub1.s(objB3);
        }
        AbstractC10721c52.e(interfaceC23241wb3, (InterfaceC14603iB2) objB3, interfaceC22053ub1, i2);
        InterfaceC9664aL6 interfaceC9664aL6C = c20927sq2.c();
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.P();
        }
        interfaceC22053ub1.Q();
        return interfaceC9664aL6C;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof WD1)) {
            return false;
        }
        WD1 wd1 = (WD1) obj;
        if (C17784nZ1.s(this.a, wd1.a) && C17784nZ1.s(this.b, wd1.b) && C17784nZ1.s(this.c, wd1.c)) {
            return C17784nZ1.s(this.d, wd1.d);
        }
        return false;
    }

    public int hashCode() {
        return (((((C17784nZ1.t(this.a) * 31) + C17784nZ1.t(this.b)) * 31) + C17784nZ1.t(this.c)) * 31) + C17784nZ1.t(this.d);
    }

    private WD1(float f, float f2, float f3, float f4) {
        this.a = f;
        this.b = f2;
        this.c = f3;
        this.d = f4;
    }
}
