package ir.nasim;

/* renamed from: ir.nasim.Ww3, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC8650Ww3 {

    /* renamed from: ir.nasim.Ww3$b */
    static final class b extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ InterfaceC9664aL6 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(InterfaceC9664aL6 interfaceC9664aL6) {
            super(0);
            this.e = interfaceC9664aL6;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final C7709Sw3 invoke() {
            return new C7709Sw3((UA2) this.e.getValue());
        }
    }

    /* renamed from: ir.nasim.Ww3$c */
    static final class c extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ InterfaceC9664aL6 e;
        final /* synthetic */ C19206px3 f;
        final /* synthetic */ androidx.compose.foundation.lazy.a g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(InterfaceC9664aL6 interfaceC9664aL6, C19206px3 c19206px3, androidx.compose.foundation.lazy.a aVar) {
            super(0);
            this.e = interfaceC9664aL6;
            this.f = c19206px3;
            this.g = aVar;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final C8416Vw3 invoke() {
            C7709Sw3 c7709Sw3 = (C7709Sw3) this.e.getValue();
            return new C8416Vw3(this.f, c7709Sw3, this.g, new C19729qq4(this.f.z(), c7709Sw3));
        }
    }

    public static final SA2 a(C19206px3 c19206px3, UA2 ua2, InterfaceC22053ub1 interfaceC22053ub1, int i) {
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.Q(-343736148, i, -1, "androidx.compose.foundation.lazy.rememberLazyListItemProviderLambda (LazyListItemProvider.kt:44)");
        }
        InterfaceC9664aL6 interfaceC9664aL6Q = AbstractC10222bH6.q(ua2, interfaceC22053ub1, (i >> 3) & 14);
        boolean z = (((i & 14) ^ 6) > 4 && interfaceC22053ub1.V(c19206px3)) || (i & 6) == 4;
        Object objB = interfaceC22053ub1.B();
        if (z || objB == InterfaceC22053ub1.a.a()) {
            objB = new AbstractC24042xw5(AbstractC10222bH6.e(AbstractC10222bH6.p(), new c(AbstractC10222bH6.e(AbstractC10222bH6.p(), new b(interfaceC9664aL6Q)), c19206px3, new androidx.compose.foundation.lazy.a()))) { // from class: ir.nasim.Ww3.a
                @Override // ir.nasim.InterfaceC3820Cm3
                public Object get() {
                    return ((InterfaceC9664aL6) this.receiver).getValue();
                }
            };
            interfaceC22053ub1.s(objB);
        }
        InterfaceC3820Cm3 interfaceC3820Cm3 = (InterfaceC3820Cm3) objB;
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.P();
        }
        return interfaceC3820Cm3;
    }
}
