package ir.nasim;

/* renamed from: ir.nasim.vx3, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC22869vx3 {

    /* renamed from: ir.nasim.vx3$a */
    static final class a extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
        final /* synthetic */ InterfaceC15796kB2 e;
        final /* synthetic */ C22273ux3 f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(InterfaceC15796kB2 interfaceC15796kB2, C22273ux3 c22273ux3) {
            super(2);
            this.e = interfaceC15796kB2;
            this.f = c22273ux3;
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if (!interfaceC22053ub1.o((i & 3) != 2, i & 1)) {
                interfaceC22053ub1.L();
                return;
            }
            if (AbstractC5138Ib1.I()) {
                AbstractC5138Ib1.Q(1863926504, i, -1, "androidx.compose.foundation.lazy.layout.LazySaveableStateHolderProvider.<anonymous> (LazySaveableStateHolder.kt:49)");
            }
            this.e.q(this.f, interfaceC22053ub1, 0);
            if (AbstractC5138Ib1.I()) {
                AbstractC5138Ib1.P();
            }
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.vx3$b */
    static final class b extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
        final /* synthetic */ InterfaceC15796kB2 e;
        final /* synthetic */ int f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(InterfaceC15796kB2 interfaceC15796kB2, int i) {
            super(2);
            this.e = interfaceC15796kB2;
            this.f = i;
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            AbstractC22869vx3.a(this.e, interfaceC22053ub1, QJ5.a(this.f | 1));
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.vx3$c */
    static final class c extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ InterfaceC11814db6 e;
        final /* synthetic */ InterfaceC9809ab6 f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(InterfaceC11814db6 interfaceC11814db6, InterfaceC9809ab6 interfaceC9809ab6) {
            super(0);
            this.e = interfaceC11814db6;
            this.f = interfaceC9809ab6;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final C22273ux3 invoke() {
            return new C22273ux3(this.e, AbstractC20051rO3.k(), this.f);
        }
    }

    public static final void a(InterfaceC15796kB2 interfaceC15796kB2, InterfaceC22053ub1 interfaceC22053ub1, int i) {
        int i2;
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(674185128);
        if ((i & 6) == 0) {
            i2 = (interfaceC22053ub1J.D(interfaceC15796kB2) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if (interfaceC22053ub1J.o((i2 & 3) != 2, i2 & 1)) {
            if (AbstractC5138Ib1.I()) {
                AbstractC5138Ib1.Q(674185128, i2, -1, "androidx.compose.foundation.lazy.layout.LazySaveableStateHolderProvider (LazySaveableStateHolder.kt:39)");
            }
            InterfaceC11814db6 interfaceC11814db6 = (InterfaceC11814db6) interfaceC22053ub1J.H(AbstractC13035fb6.e());
            InterfaceC9809ab6 interfaceC9809ab6A = AbstractC11019cb6.a(interfaceC22053ub1J, 0);
            Object[] objArr = {interfaceC11814db6};
            InterfaceC8230Vb6 interfaceC8230Vb6A = C22273ux3.d.a(interfaceC11814db6, interfaceC9809ab6A);
            boolean zD = interfaceC22053ub1J.D(interfaceC11814db6) | interfaceC22053ub1J.D(interfaceC9809ab6A);
            Object objB = interfaceC22053ub1J.B();
            if (zD || objB == InterfaceC22053ub1.a.a()) {
                objB = new c(interfaceC11814db6, interfaceC9809ab6A);
                interfaceC22053ub1J.s(objB);
            }
            C22273ux3 c22273ux3 = (C22273ux3) AbstractC9681aN5.e(objArr, interfaceC8230Vb6A, null, (SA2) objB, interfaceC22053ub1J, 0, 4);
            AbstractC11024cc1.a(AbstractC13035fb6.e().d(c22273ux3), AbstractC19242q11.e(1863926504, true, new a(interfaceC15796kB2, c22273ux3), interfaceC22053ub1J, 54), interfaceC22053ub1J, C7252Qx5.i | 48);
            if (AbstractC5138Ib1.I()) {
                AbstractC5138Ib1.P();
            }
        } else {
            interfaceC22053ub1J.L();
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new b(interfaceC15796kB2, i));
        }
    }
}
