package ir.nasim;

/* loaded from: classes.dex */
public abstract class DG7 {

    static final class a extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
        final /* synthetic */ UA2 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(UA2 ua2) {
            super(2);
            this.e = ua2;
        }

        public final void a(Object obj, C19938rB7 c19938rB7) {
            this.e.invoke(obj);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a(obj, (C19938rB7) obj2);
            return C19938rB7.a;
        }
    }

    public static final void b(InterfaceC22053ub1 interfaceC22053ub1, UA2 ua2) {
        if (interfaceC22053ub1.h()) {
            interfaceC22053ub1.v(C19938rB7.a, new a(ua2));
        }
    }

    public static final void c(InterfaceC22053ub1 interfaceC22053ub1, Object obj, InterfaceC14603iB2 interfaceC14603iB2) {
        if (interfaceC22053ub1.h() || !AbstractC13042fc3.d(interfaceC22053ub1.B(), obj)) {
            interfaceC22053ub1.s(obj);
            interfaceC22053ub1.v(obj, interfaceC14603iB2);
        }
    }

    public static InterfaceC22053ub1 a(InterfaceC22053ub1 interfaceC22053ub1) {
        return interfaceC22053ub1;
    }
}
