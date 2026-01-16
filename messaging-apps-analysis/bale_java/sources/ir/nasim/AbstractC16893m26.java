package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import ir.nasim.InterfaceC6693Oo5;

/* renamed from: ir.nasim.m26, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC16893m26 implements InterfaceC16339l63 {
    private final boolean a;
    private final float b;
    private final InterfaceC9664aL6 c;

    /* renamed from: ir.nasim.m26$a */
    static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        private /* synthetic */ Object c;
        final /* synthetic */ InterfaceC23241wb3 d;
        final /* synthetic */ androidx.compose.material.ripple.d e;

        /* renamed from: ir.nasim.m26$a$a, reason: collision with other inner class name */
        static final class C1397a implements InterfaceC4806Gq2 {
            final /* synthetic */ androidx.compose.material.ripple.d a;
            final /* synthetic */ InterfaceC20315ro1 b;

            C1397a(androidx.compose.material.ripple.d dVar, InterfaceC20315ro1 interfaceC20315ro1) {
                this.a = dVar;
                this.b = interfaceC20315ro1;
            }

            @Override // ir.nasim.InterfaceC4806Gq2
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Object a(InterfaceC22645vb3 interfaceC22645vb3, InterfaceC20295rm1 interfaceC20295rm1) {
                if (interfaceC22645vb3 instanceof InterfaceC6693Oo5.b) {
                    this.a.c((InterfaceC6693Oo5.b) interfaceC22645vb3, this.b);
                } else if (interfaceC22645vb3 instanceof InterfaceC6693Oo5.c) {
                    this.a.g(((InterfaceC6693Oo5.c) interfaceC22645vb3).a());
                } else if (interfaceC22645vb3 instanceof InterfaceC6693Oo5.a) {
                    this.a.g(((InterfaceC6693Oo5.a) interfaceC22645vb3).a());
                } else {
                    this.a.h(interfaceC22645vb3, this.b);
                }
                return C19938rB7.a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(InterfaceC23241wb3 interfaceC23241wb3, androidx.compose.material.ripple.d dVar, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = interfaceC23241wb3;
            this.e = dVar;
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
                InterfaceC20315ro1 interfaceC20315ro1 = (InterfaceC20315ro1) this.c;
                InterfaceC4557Fq2 interfaceC4557Fq2B = this.d.b();
                C1397a c1397a = new C1397a(this.e, interfaceC20315ro1);
                this.b = 1;
                if (interfaceC4557Fq2B.b(c1397a, this) == objE) {
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

    public /* synthetic */ AbstractC16893m26(boolean z, float f, InterfaceC9664aL6 interfaceC9664aL6, ED1 ed1) {
        this(z, f, interfaceC9664aL6);
    }

    @Override // ir.nasim.InterfaceC16339l63
    public final InterfaceC16930m63 a(InterfaceC23241wb3 interfaceC23241wb3, InterfaceC22053ub1 interfaceC22053ub1, int i) {
        long jA;
        interfaceC22053ub1.W(988743187);
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.Q(988743187, i, -1, "androidx.compose.material.ripple.Ripple.rememberUpdatedInstance (Ripple.kt:190)");
        }
        InterfaceC23510x26 interfaceC23510x26 = (InterfaceC23510x26) interfaceC22053ub1.H(AbstractC24100y26.d());
        if (((C24381yX0) this.c.getValue()).y() != 16) {
            interfaceC22053ub1.W(-303557454);
            interfaceC22053ub1.Q();
            jA = ((C24381yX0) this.c.getValue()).y();
        } else {
            interfaceC22053ub1.W(-303499670);
            jA = interfaceC23510x26.a(interfaceC22053ub1, 0);
            interfaceC22053ub1.Q();
        }
        InterfaceC9664aL6 interfaceC9664aL6Q = AbstractC10222bH6.q(C24381yX0.k(jA), interfaceC22053ub1, 0);
        InterfaceC9664aL6 interfaceC9664aL6Q2 = AbstractC10222bH6.q(interfaceC23510x26.b(interfaceC22053ub1, 0), interfaceC22053ub1, 0);
        int i2 = i & 14;
        androidx.compose.material.ripple.d dVarC = c(interfaceC23241wb3, this.a, this.b, interfaceC9664aL6Q, interfaceC9664aL6Q2, interfaceC22053ub1, i2 | ((i << 12) & 458752));
        boolean zD = interfaceC22053ub1.D(dVarC) | (((i2 ^ 6) > 4 && interfaceC22053ub1.V(interfaceC23241wb3)) || (i & 6) == 4);
        Object objB = interfaceC22053ub1.B();
        if (zD || objB == InterfaceC22053ub1.a.a()) {
            objB = new a(interfaceC23241wb3, dVarC, null);
            interfaceC22053ub1.s(objB);
        }
        AbstractC10721c52.f(dVarC, interfaceC23241wb3, (InterfaceC14603iB2) objB, interfaceC22053ub1, (i << 3) & SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER);
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.P();
        }
        interfaceC22053ub1.Q();
        return dVarC;
    }

    public abstract androidx.compose.material.ripple.d c(InterfaceC23241wb3 interfaceC23241wb3, boolean z, float f, InterfaceC9664aL6 interfaceC9664aL6, InterfaceC9664aL6 interfaceC9664aL62, InterfaceC22053ub1 interfaceC22053ub1, int i);

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AbstractC16893m26)) {
            return false;
        }
        AbstractC16893m26 abstractC16893m26 = (AbstractC16893m26) obj;
        return this.a == abstractC16893m26.a && C17784nZ1.s(this.b, abstractC16893m26.b) && AbstractC13042fc3.d(this.c, abstractC16893m26.c);
    }

    public int hashCode() {
        return (((Boolean.hashCode(this.a) * 31) + C17784nZ1.t(this.b)) * 31) + this.c.hashCode();
    }

    private AbstractC16893m26(boolean z, float f, InterfaceC9664aL6 interfaceC9664aL6) {
        this.a = z;
        this.b = f;
        this.c = interfaceC9664aL6;
    }
}
