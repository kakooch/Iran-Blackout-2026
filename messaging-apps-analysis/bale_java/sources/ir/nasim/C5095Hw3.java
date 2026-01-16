package ir.nasim;

import androidx.compose.runtime.snapshots.g;

/* renamed from: ir.nasim.Hw3, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C5095Hw3 {
    private C6233Mt a;

    /* renamed from: ir.nasim.Hw3$a */
    static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        a(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C5095Hw3.this.new a(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                C6233Mt c6233Mt = C5095Hw3.this.a;
                Float fC = AbstractC6392Nk0.c(0.0f);
                C18827pJ6 c18827pJ6J = AbstractC5999Lt.j(0.0f, 400.0f, AbstractC6392Nk0.c(0.5f), 1, null);
                this.b = 1;
                if (AbstractC18086o37.j(c6233Mt, fC, c18827pJ6J, true, null, this, 8, null) == objE) {
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

    /* renamed from: ir.nasim.Hw3$b */
    static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        b(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C5095Hw3.this.new b(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                C6233Mt c6233Mt = C5095Hw3.this.a;
                Float fC = AbstractC6392Nk0.c(0.0f);
                C18827pJ6 c18827pJ6J = AbstractC5999Lt.j(0.0f, 400.0f, AbstractC6392Nk0.c(0.5f), 1, null);
                this.b = 1;
                if (AbstractC18086o37.j(c6233Mt, fC, c18827pJ6J, true, null, this, 8, null) == objE) {
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

    public C5095Hw3() {
        InterfaceC5342Ix7 interfaceC5342Ix7D = PQ7.d(C9361Zp2.a);
        Float fValueOf = Float.valueOf(0.0f);
        this.a = AbstractC6483Nt.b(interfaceC5342Ix7D, fValueOf, fValueOf, (56 & 8) != 0 ? Long.MIN_VALUE : 0L, (56 & 16) != 0 ? Long.MIN_VALUE : 0L, (56 & 32) != 0 ? false : false);
    }

    public final float b() {
        return ((Number) this.a.getValue()).floatValue();
    }

    public final void c(float f, WH1 wh1, InterfaceC20315ro1 interfaceC20315ro1) {
        if (f <= wh1.w1(AbstractC5329Iw3.a)) {
            return;
        }
        g.a aVar = androidx.compose.runtime.snapshots.g.e;
        androidx.compose.runtime.snapshots.g gVarD = aVar.d();
        UA2 ua2G = gVarD != null ? gVarD.g() : null;
        androidx.compose.runtime.snapshots.g gVarE = aVar.e(gVarD);
        try {
            float fFloatValue = ((Number) this.a.getValue()).floatValue();
            if (this.a.B()) {
                this.a = AbstractC6483Nt.g(this.a, fFloatValue - f, 0.0f, 0L, 0L, false, 30, null);
                AbstractC10533bm0.d(interfaceC20315ro1, null, null, new a(null), 3, null);
            } else {
                this.a = new C6233Mt(PQ7.d(C9361Zp2.a), Float.valueOf(-f), null, 0L, 0L, false, 60, null);
                AbstractC10533bm0.d(interfaceC20315ro1, null, null, new b(null), 3, null);
            }
            aVar.l(gVarD, gVarE, ua2G);
        } catch (Throwable th) {
            aVar.l(gVarD, gVarE, ua2G);
            throw th;
        }
    }
}
