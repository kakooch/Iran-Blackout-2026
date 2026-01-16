package ir.nasim;

import ir.nasim.AbstractC10289bP1;
import ir.nasim.AbstractC13050fd1;
import ir.nasim.InterfaceC19114po0;

/* renamed from: ir.nasim.fd1, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public abstract class AbstractC13050fd1 {

    /* renamed from: ir.nasim.fd1$a */
    static final class a implements InterfaceC14603iB2 {
        final /* synthetic */ SA2 a;
        final /* synthetic */ SA2 b;

        a(SA2 sa2, SA2 sa22) {
            this.a = sa2;
            this.b = sa22;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 d(SA2 sa2) {
            AbstractC13042fc3.i(sa2, "$onClose");
            sa2.invoke();
            return C19938rB7.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 f(SA2 sa2) {
            AbstractC13042fc3.i(sa2, "$onCancel");
            sa2.invoke();
            return C19938rB7.a;
        }

        public final void c(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
                return;
            }
            C21065t31 c21065t31 = C21065t31.a;
            InterfaceC14603iB2 interfaceC14603iB2A = c21065t31.a();
            AbstractC10289bP1.b.c cVar = AbstractC10289bP1.b.c.b;
            InterfaceC14603iB2 interfaceC14603iB2B = c21065t31.b();
            AbstractC10289bP1.a.c cVar2 = AbstractC10289bP1.a.c.a;
            InterfaceC19114po0.b.a aVar = InterfaceC19114po0.b.a.a;
            interfaceC22053ub1.W(-731594869);
            boolean zV = interfaceC22053ub1.V(this.a);
            final SA2 sa2 = this.a;
            Object objB = interfaceC22053ub1.B();
            if (zV || objB == InterfaceC22053ub1.a.a()) {
                objB = new SA2() { // from class: ir.nasim.dd1
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return AbstractC13050fd1.a.d(sa2);
                    }
                };
                interfaceC22053ub1.s(objB);
            }
            SA2 sa22 = (SA2) objB;
            interfaceC22053ub1.Q();
            int i2 = WD5.close_anyway;
            InterfaceC19114po0.b.C1454b c1454b = InterfaceC19114po0.b.C1454b.a;
            interfaceC22053ub1.W(-731588788);
            boolean zV2 = interfaceC22053ub1.V(this.b);
            final SA2 sa23 = this.b;
            Object objB2 = interfaceC22053ub1.B();
            if (zV2 || objB2 == InterfaceC22053ub1.a.a()) {
                objB2 = new SA2() { // from class: ir.nasim.ed1
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return AbstractC13050fd1.a.f(sa23);
                    }
                };
                interfaceC22053ub1.s(objB2);
            }
            interfaceC22053ub1.Q();
            AbstractC19555qZ.E(interfaceC14603iB2A, cVar, interfaceC14603iB2B, cVar2, aVar, sa22, i2, c1454b, (SA2) objB2, WD5.cancel, null, interfaceC22053ub1, (InterfaceC19114po0.b.C1454b.b << 21) | (AbstractC10289bP1.b.c.c << 3) | 390 | (AbstractC10289bP1.a.c.b << 9) | (InterfaceC19114po0.b.a.b << 12), 0, 1024);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            c((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    public static final void b(final SA2 sa2, final SA2 sa22, InterfaceC22053ub1 interfaceC22053ub1, final int i) {
        int i2;
        AbstractC13042fc3.i(sa2, "onClose");
        AbstractC13042fc3.i(sa22, "onCancel");
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(-208281646);
        if ((i & 6) == 0) {
            i2 = (interfaceC22053ub1J.D(sa2) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= interfaceC22053ub1J.D(sa22) ? 32 : 16;
        }
        if ((i2 & 19) == 18 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
        } else {
            AbstractC6687Oo.a(sa22, new C18876pP1(true, true, false, 4, (ED1) null), AbstractC19242q11.e(1158270043, true, new a(sa2, sa22), interfaceC22053ub1J, 54), interfaceC22053ub1J, ((i2 >> 3) & 14) | 432, 0);
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.cd1
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return AbstractC13050fd1.c(sa2, sa22, i, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 c(SA2 sa2, SA2 sa22, int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
        AbstractC13042fc3.i(sa2, "$onClose");
        AbstractC13042fc3.i(sa22, "$onCancel");
        b(sa2, sa22, interfaceC22053ub1, QJ5.a(i | 1));
        return C19938rB7.a;
    }
}
