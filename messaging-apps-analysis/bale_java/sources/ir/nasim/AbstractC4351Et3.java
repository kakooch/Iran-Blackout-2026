package ir.nasim;

import java.util.Iterator;
import java.util.List;

/* renamed from: ir.nasim.Et3, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public abstract class AbstractC4351Et3 {

    /* renamed from: ir.nasim.Et3$a */
    static final class a implements InterfaceC15796kB2 {
        final /* synthetic */ List a;

        a(List list) {
            this.a = list;
        }

        public final void a(InterfaceC16782lr2 interfaceC16782lr2, InterfaceC22053ub1 interfaceC22053ub1, int i) {
            AbstractC13042fc3.i(interfaceC16782lr2, "$this$FlowRow");
            if ((i & 17) == 16 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
                return;
            }
            Iterator it = this.a.iterator();
            while (it.hasNext()) {
                AbstractC4351Et3.d((String) it.next(), interfaceC22053ub1, 0);
            }
        }

        @Override // ir.nasim.InterfaceC15796kB2
        public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
            a((InterfaceC16782lr2) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
            return C19938rB7.a;
        }
    }

    public static final void d(final String str, InterfaceC22053ub1 interfaceC22053ub1, final int i) {
        int i2;
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(1366644174);
        if ((i & 6) == 0) {
            i2 = (interfaceC22053ub1J.V(str) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i2 & 3) == 2 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
        } else {
            if (str == null || AbstractC20762sZ6.n0(str)) {
                InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
                if (interfaceC20208rd6M != null) {
                    interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.Ct3
                        @Override // ir.nasim.InterfaceC14603iB2
                        public final Object invoke(Object obj, Object obj2) {
                            return AbstractC4351Et3.e(str, i, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                        }
                    });
                    return;
                }
                return;
            }
            M10.f(false, C18701p61.a.a(), interfaceC22053ub1J, 48, 1);
        }
        InterfaceC20208rd6 interfaceC20208rd6M2 = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M2 != null) {
            interfaceC20208rd6M2.a(new InterfaceC14603iB2() { // from class: ir.nasim.Dt3
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return AbstractC4351Et3.f(str, i, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 e(String str, int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
        d(str, interfaceC22053ub1, QJ5.a(i | 1));
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 f(String str, int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
        d(str, interfaceC22053ub1, QJ5.a(i | 1));
        return C19938rB7.a;
    }

    public static final void g(InterfaceC22053ub1 interfaceC22053ub1, final int i) {
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(2143620507);
        if (i == 0 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
        } else {
            AbstractC12582er2.b(null, C24254yJ.a.o(C17784nZ1.q(8)), null, null, 0, 0, AbstractC19242q11.e(-1184981546, true, new a(AbstractC10360bX0.p("📱", "😂", "🤪", "🎈", "🏆", "⌚", "🍩", "👎", "👍", "😎")), interfaceC22053ub1J, 54), interfaceC22053ub1J, 1572912, 61);
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.Bt3
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return AbstractC4351Et3.h(i, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 h(int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
        g(interfaceC22053ub1, QJ5.a(i | 1));
        return C19938rB7.a;
    }
}
