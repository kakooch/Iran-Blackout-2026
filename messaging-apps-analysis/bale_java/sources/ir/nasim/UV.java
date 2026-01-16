package ir.nasim;

import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import ir.nasim.InterfaceC22053ub1;

/* loaded from: classes.dex */
public abstract class UV {

    static final class a extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ d e;
        final /* synthetic */ boolean f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(d dVar, boolean z) {
            super(0);
            this.e = dVar;
            this.f = z;
        }

        public final void a() {
            this.e.j(this.f);
        }

        @Override // ir.nasim.SA2
        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return C19938rB7.a;
        }
    }

    static final class b extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ C23660xI4 e;
        final /* synthetic */ InterfaceC18633oz3 f;
        final /* synthetic */ d g;

        public static final class a implements KV1 {
            final /* synthetic */ d a;

            public a(d dVar) {
                this.a = dVar;
            }

            @Override // ir.nasim.KV1
            public void dispose() {
                this.a.h();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(C23660xI4 c23660xI4, InterfaceC18633oz3 interfaceC18633oz3, d dVar) {
            super(1);
            this.e = c23660xI4;
            this.f = interfaceC18633oz3;
            this.g = dVar;
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final KV1 invoke(LV1 lv1) {
            this.e.h(this.f, this.g);
            return new a(this.g);
        }
    }

    static final class c extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
        final /* synthetic */ boolean e;
        final /* synthetic */ SA2 f;
        final /* synthetic */ int g;
        final /* synthetic */ int h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(boolean z, SA2 sa2, int i, int i2) {
            super(2);
            this.e = z;
            this.f = sa2;
            this.g = i;
            this.h = i2;
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            UV.a(this.e, this.f, interfaceC22053ub1, this.g | 1, this.h);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    public static final class d extends AbstractC23070wI4 {
        final /* synthetic */ InterfaceC9664aL6 d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(boolean z, InterfaceC9664aL6 interfaceC9664aL6) {
            super(z);
            this.d = interfaceC9664aL6;
        }

        @Override // ir.nasim.AbstractC23070wI4
        public void d() {
            UV.b(this.d).invoke();
        }
    }

    public static final void a(boolean z, SA2 sa2, InterfaceC22053ub1 interfaceC22053ub1, int i, int i2) {
        int i3;
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(-361453782);
        int i4 = i2 & 1;
        if (i4 != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (interfaceC22053ub1J.a(z) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i2 & 2) != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            i3 |= interfaceC22053ub1J.V(sa2) ? 32 : 16;
        }
        if ((i3 & 19) == 18 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
        } else {
            if (i4 != 0) {
                z = true;
            }
            InterfaceC9664aL6 interfaceC9664aL6Q = AbstractC10222bH6.q(sa2, interfaceC22053ub1J, (i3 >> 3) & 14);
            interfaceC22053ub1J.A(-971159753);
            Object objB = interfaceC22053ub1J.B();
            InterfaceC22053ub1.a aVar = InterfaceC22053ub1.a;
            if (objB == aVar.a()) {
                objB = new d(z, interfaceC9664aL6Q);
                interfaceC22053ub1J.s(objB);
            }
            d dVar = (d) objB;
            interfaceC22053ub1J.U();
            interfaceC22053ub1J.A(-971159481);
            boolean zV = interfaceC22053ub1J.V(dVar) | interfaceC22053ub1J.a(z);
            Object objB2 = interfaceC22053ub1J.B();
            if (zV || objB2 == aVar.a()) {
                objB2 = new a(dVar, z);
                interfaceC22053ub1J.s(objB2);
            }
            interfaceC22053ub1J.U();
            AbstractC10721c52.i((SA2) objB2, interfaceC22053ub1J, 0);
            AI4 ai4A = XG3.a.a(interfaceC22053ub1J, 6);
            if (ai4A == null) {
                throw new IllegalStateException("No OnBackPressedDispatcherOwner was provided via LocalOnBackPressedDispatcherOwner".toString());
            }
            C23660xI4 c23660xI4Z2 = ai4A.z2();
            InterfaceC18633oz3 interfaceC18633oz3 = (InterfaceC18633oz3) interfaceC22053ub1J.H(AndroidCompositionLocals_androidKt.getLocalLifecycleOwner());
            interfaceC22053ub1J.A(-971159120);
            boolean zV2 = interfaceC22053ub1J.V(c23660xI4Z2) | interfaceC22053ub1J.V(interfaceC18633oz3) | interfaceC22053ub1J.V(dVar);
            Object objB3 = interfaceC22053ub1J.B();
            if (zV2 || objB3 == aVar.a()) {
                objB3 = new b(c23660xI4Z2, interfaceC18633oz3, dVar);
                interfaceC22053ub1J.s(objB3);
            }
            interfaceC22053ub1J.U();
            AbstractC10721c52.b(interfaceC18633oz3, c23660xI4Z2, (UA2) objB3, interfaceC22053ub1J, 0);
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new c(z, sa2, i, i2));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SA2 b(InterfaceC9664aL6 interfaceC9664aL6) {
        return (SA2) interfaceC9664aL6.getValue();
    }
}
