package androidx.compose.foundation.gestures;

import androidx.compose.foundation.gestures.a;
import ir.nasim.AbstractC10533bm0;
import ir.nasim.AbstractC10685c16;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC14862ic3;
import ir.nasim.AbstractC19859r37;
import ir.nasim.AbstractC6392Nk0;
import ir.nasim.AbstractC8614Ws3;
import ir.nasim.C17718nR7;
import ir.nasim.C19938rB7;
import ir.nasim.EnumC15562jn4;
import ir.nasim.EnumC23959xo1;
import ir.nasim.EnumC24286yM4;
import ir.nasim.IZ1;
import ir.nasim.InterfaceC14603iB2;
import ir.nasim.InterfaceC15796kB2;
import ir.nasim.InterfaceC18507om4;
import ir.nasim.InterfaceC20295rm1;
import ir.nasim.InterfaceC20315ro1;
import ir.nasim.NZ1;
import ir.nasim.OZ1;
import ir.nasim.UA2;
import ir.nasim.ZG4;

/* loaded from: classes.dex */
public final class c extends androidx.compose.foundation.gestures.b {
    private EnumC24286yM4 A;
    private boolean B;
    private InterfaceC15796kB2 D;
    private InterfaceC15796kB2 G;
    private boolean H;
    private OZ1 z;

    static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        private /* synthetic */ Object c;
        final /* synthetic */ InterfaceC14603iB2 d;
        final /* synthetic */ c e;

        /* renamed from: androidx.compose.foundation.gestures.c$a$a, reason: collision with other inner class name */
        static final class C0037a extends AbstractC8614Ws3 implements UA2 {
            final /* synthetic */ IZ1 e;
            final /* synthetic */ c f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C0037a(IZ1 iz1, c cVar) {
                super(1);
                this.e = iz1;
                this.f = cVar;
            }

            public final void a(a.b bVar) {
                this.e.a(NZ1.j(this.f.c3(bVar.a()), this.f.A));
            }

            @Override // ir.nasim.UA2
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                a((a.b) obj);
                return C19938rB7.a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(InterfaceC14603iB2 interfaceC14603iB2, c cVar, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = interfaceC14603iB2;
            this.e = cVar;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            a aVar = new a(this.d, this.e, interfaceC20295rm1);
            aVar.c = obj;
            return aVar;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                IZ1 iz1 = (IZ1) this.c;
                InterfaceC14603iB2 interfaceC14603iB2 = this.d;
                C0037a c0037a = new C0037a(iz1, this.e);
                this.b = 1;
                if (interfaceC14603iB2.invoke(c0037a, this) == objE) {
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
        public final Object invoke(IZ1 iz1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((a) create(iz1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        private /* synthetic */ Object c;
        final /* synthetic */ long e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(long j, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.e = j;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            b bVar = c.this.new b(this.e, interfaceC20295rm1);
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
                InterfaceC15796kB2 interfaceC15796kB2 = c.this.D;
                ZG4 zg4D = ZG4.d(this.e);
                this.b = 1;
                if (interfaceC15796kB2.q(interfaceC20315ro1, zg4D, this) == objE) {
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

    /* renamed from: androidx.compose.foundation.gestures.c$c, reason: collision with other inner class name */
    static final class C0038c extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        private /* synthetic */ Object c;
        final /* synthetic */ long e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C0038c(long j, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.e = j;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            C0038c c0038c = c.this.new C0038c(this.e, interfaceC20295rm1);
            c0038c.c = obj;
            return c0038c;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC20315ro1 interfaceC20315ro1 = (InterfaceC20315ro1) this.c;
                InterfaceC15796kB2 interfaceC15796kB2 = c.this.G;
                Float fC = AbstractC6392Nk0.c(NZ1.k(c.this.b3(this.e), c.this.A));
                this.b = 1;
                if (interfaceC15796kB2.q(interfaceC20315ro1, fC, this) == objE) {
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
            return ((C0038c) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public c(OZ1 oz1, UA2 ua2, EnumC24286yM4 enumC24286yM4, boolean z, InterfaceC18507om4 interfaceC18507om4, boolean z2, InterfaceC15796kB2 interfaceC15796kB2, InterfaceC15796kB2 interfaceC15796kB22, boolean z3) {
        super(ua2, z, interfaceC18507om4, enumC24286yM4);
        this.z = oz1;
        this.A = enumC24286yM4;
        this.B = z2;
        this.D = interfaceC15796kB2;
        this.G = interfaceC15796kB22;
        this.H = z3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long b3(long j) {
        return C17718nR7.m(j, this.H ? -1.0f : 1.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long c3(long j) {
        return ZG4.r(j, this.H ? -1.0f : 1.0f);
    }

    @Override // androidx.compose.foundation.gestures.b
    public Object K2(InterfaceC14603iB2 interfaceC14603iB2, InterfaceC20295rm1 interfaceC20295rm1) {
        Object objA = this.z.a(EnumC15562jn4.b, new a(interfaceC14603iB2, this, null), interfaceC20295rm1);
        return objA == AbstractC14862ic3.e() ? objA : C19938rB7.a;
    }

    @Override // androidx.compose.foundation.gestures.b
    public void O2(long j) {
        if (!b2() || AbstractC13042fc3.d(this.D, NZ1.a)) {
            return;
        }
        AbstractC10533bm0.d(U1(), null, EnumC23959xo1.UNDISPATCHED, new b(j, null), 1, null);
    }

    @Override // androidx.compose.foundation.gestures.b
    public void P2(long j) {
        if (!b2() || AbstractC13042fc3.d(this.G, NZ1.b)) {
            return;
        }
        AbstractC10533bm0.d(U1(), null, EnumC23959xo1.UNDISPATCHED, new C0038c(j, null), 1, null);
    }

    @Override // androidx.compose.foundation.gestures.b
    public boolean T2() {
        return this.B;
    }

    public final void d3(OZ1 oz1, UA2 ua2, EnumC24286yM4 enumC24286yM4, boolean z, InterfaceC18507om4 interfaceC18507om4, boolean z2, InterfaceC15796kB2 interfaceC15796kB2, InterfaceC15796kB2 interfaceC15796kB22, boolean z3) {
        boolean z4;
        boolean z5;
        InterfaceC15796kB2 interfaceC15796kB23;
        if (AbstractC13042fc3.d(this.z, oz1)) {
            z4 = false;
        } else {
            this.z = oz1;
            z4 = true;
        }
        if (this.A != enumC24286yM4) {
            this.A = enumC24286yM4;
            z4 = true;
        }
        if (this.H != z3) {
            this.H = z3;
            interfaceC15796kB23 = interfaceC15796kB2;
            z5 = true;
        } else {
            z5 = z4;
            interfaceC15796kB23 = interfaceC15796kB2;
        }
        this.D = interfaceC15796kB23;
        this.G = interfaceC15796kB22;
        this.B = z2;
        V2(ua2, z, interfaceC18507om4, enumC24286yM4, z5);
    }
}
