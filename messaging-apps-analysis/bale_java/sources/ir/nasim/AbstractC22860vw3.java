package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import ir.nasim.InterfaceC22053ub1;

/* renamed from: ir.nasim.vw3, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC22860vw3 {

    /* renamed from: ir.nasim.vw3$a */
    static final class a extends AbstractC8614Ws3 implements InterfaceC15796kB2 {
        final /* synthetic */ androidx.compose.foundation.lazy.layout.d e;
        final /* synthetic */ androidx.compose.ui.e f;
        final /* synthetic */ InterfaceC14603iB2 g;
        final /* synthetic */ InterfaceC9664aL6 h;

        /* renamed from: ir.nasim.vw3$a$a, reason: collision with other inner class name */
        static final class C1731a extends AbstractC8614Ws3 implements UA2 {
            final /* synthetic */ androidx.compose.foundation.lazy.layout.d e;
            final /* synthetic */ C19197pw3 f;
            final /* synthetic */ TZ6 g;
            final /* synthetic */ InterfaceC4989Hk5 h;

            /* renamed from: ir.nasim.vw3$a$a$a, reason: collision with other inner class name */
            public static final class C1732a implements KV1 {
                final /* synthetic */ androidx.compose.foundation.lazy.layout.d a;

                public C1732a(androidx.compose.foundation.lazy.layout.d dVar) {
                    this.a = dVar;
                }

                @Override // ir.nasim.KV1
                public void dispose() {
                    this.a.f(null);
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C1731a(androidx.compose.foundation.lazy.layout.d dVar, C19197pw3 c19197pw3, TZ6 tz6, InterfaceC4989Hk5 interfaceC4989Hk5) {
                super(1);
                this.e = dVar;
                this.f = c19197pw3;
                this.g = tz6;
                this.h = interfaceC4989Hk5;
            }

            @Override // ir.nasim.UA2
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final KV1 invoke(LV1 lv1) {
                this.e.f(new androidx.compose.foundation.lazy.layout.i(this.f, this.g, this.h));
                return new C1732a(this.e);
            }
        }

        /* renamed from: ir.nasim.vw3$a$b */
        static final class b extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
            final /* synthetic */ C19197pw3 e;
            final /* synthetic */ InterfaceC14603iB2 f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            b(C19197pw3 c19197pw3, InterfaceC14603iB2 interfaceC14603iB2) {
                super(2);
                this.e = c19197pw3;
                this.f = interfaceC14603iB2;
            }

            public final InterfaceC11734dW3 a(UZ6 uz6, long j) {
                return (InterfaceC11734dW3) this.f.invoke(new C24040xw3(this.e, uz6), C17833ne1.a(j));
            }

            @Override // ir.nasim.InterfaceC14603iB2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                return a((UZ6) obj, ((C17833ne1) obj2).r());
            }
        }

        /* renamed from: ir.nasim.vw3$a$c */
        static final class c extends AbstractC8614Ws3 implements SA2 {
            final /* synthetic */ InterfaceC9664aL6 e;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            c(InterfaceC9664aL6 interfaceC9664aL6) {
                super(0);
                this.e = interfaceC9664aL6;
            }

            @Override // ir.nasim.SA2
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final InterfaceC20397rw3 invoke() {
                return (InterfaceC20397rw3) ((SA2) this.e.getValue()).invoke();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(androidx.compose.foundation.lazy.layout.d dVar, androidx.compose.ui.e eVar, InterfaceC14603iB2 interfaceC14603iB2, InterfaceC9664aL6 interfaceC9664aL6) {
            super(3);
            this.e = dVar;
            this.f = eVar;
            this.g = interfaceC14603iB2;
            this.h = interfaceC9664aL6;
        }

        public final void a(InterfaceC9809ab6 interfaceC9809ab6, InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if (AbstractC5138Ib1.I()) {
                AbstractC5138Ib1.Q(-1488997347, i, -1, "androidx.compose.foundation.lazy.layout.LazyLayout.<anonymous> (LazyLayout.kt:56)");
            }
            InterfaceC9664aL6 interfaceC9664aL6 = this.h;
            Object objB = interfaceC22053ub1.B();
            InterfaceC22053ub1.a aVar = InterfaceC22053ub1.a;
            if (objB == aVar.a()) {
                objB = new C19197pw3(interfaceC9809ab6, new c(interfaceC9664aL6));
                interfaceC22053ub1.s(objB);
            }
            C19197pw3 c19197pw3 = (C19197pw3) objB;
            Object objB2 = interfaceC22053ub1.B();
            if (objB2 == aVar.a()) {
                objB2 = new TZ6(new C21674tw3(c19197pw3));
                interfaceC22053ub1.s(objB2);
            }
            TZ6 tz6 = (TZ6) objB2;
            if (this.e != null) {
                interfaceC22053ub1.W(204281539);
                InterfaceC4989Hk5 interfaceC4989Hk5D = this.e.d();
                if (interfaceC4989Hk5D == null) {
                    interfaceC22053ub1.W(6591363);
                    interfaceC4989Hk5D = AbstractC5223Ik5.a(interfaceC22053ub1, 0);
                } else {
                    interfaceC22053ub1.W(6590278);
                }
                interfaceC22053ub1.Q();
                Object[] objArr = {this.e, c19197pw3, tz6, interfaceC4989Hk5D};
                boolean zV = interfaceC22053ub1.V(this.e) | interfaceC22053ub1.D(c19197pw3) | interfaceC22053ub1.D(tz6) | interfaceC22053ub1.D(interfaceC4989Hk5D);
                androidx.compose.foundation.lazy.layout.d dVar = this.e;
                Object objB3 = interfaceC22053ub1.B();
                if (zV || objB3 == aVar.a()) {
                    objB3 = new C1731a(dVar, c19197pw3, tz6, interfaceC4989Hk5D);
                    interfaceC22053ub1.s(objB3);
                }
                AbstractC10721c52.d(objArr, (UA2) objB3, interfaceC22053ub1, 0);
                interfaceC22053ub1.Q();
            } else {
                interfaceC22053ub1.W(204710145);
                interfaceC22053ub1.Q();
            }
            androidx.compose.ui.e eVarB = androidx.compose.foundation.lazy.layout.e.b(this.f, this.e);
            boolean zV2 = interfaceC22053ub1.V(c19197pw3) | interfaceC22053ub1.V(this.g);
            InterfaceC14603iB2 interfaceC14603iB2 = this.g;
            Object objB4 = interfaceC22053ub1.B();
            if (zV2 || objB4 == aVar.a()) {
                objB4 = new b(c19197pw3, interfaceC14603iB2);
                interfaceC22053ub1.s(objB4);
            }
            SZ6.b(tz6, eVarB, (InterfaceC14603iB2) objB4, interfaceC22053ub1, TZ6.f, 0);
            if (AbstractC5138Ib1.I()) {
                AbstractC5138Ib1.P();
            }
        }

        @Override // ir.nasim.InterfaceC15796kB2
        public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
            a((InterfaceC9809ab6) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.vw3$b */
    static final class b extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
        final /* synthetic */ SA2 e;
        final /* synthetic */ androidx.compose.ui.e f;
        final /* synthetic */ androidx.compose.foundation.lazy.layout.d g;
        final /* synthetic */ InterfaceC14603iB2 h;
        final /* synthetic */ int i;
        final /* synthetic */ int j;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(SA2 sa2, androidx.compose.ui.e eVar, androidx.compose.foundation.lazy.layout.d dVar, InterfaceC14603iB2 interfaceC14603iB2, int i, int i2) {
            super(2);
            this.e = sa2;
            this.f = eVar;
            this.g = dVar;
            this.h = interfaceC14603iB2;
            this.i = i;
            this.j = i2;
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            AbstractC22860vw3.a(this.e, this.f, this.g, this.h, interfaceC22053ub1, QJ5.a(this.i | 1), this.j);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    public static final void a(SA2 sa2, androidx.compose.ui.e eVar, androidx.compose.foundation.lazy.layout.d dVar, InterfaceC14603iB2 interfaceC14603iB2, InterfaceC22053ub1 interfaceC22053ub1, int i, int i2) {
        int i3;
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(2002163445);
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (interfaceC22053ub1J.D(sa2) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i4 = i2 & 2;
        if (i4 != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            i3 |= interfaceC22053ub1J.V(eVar) ? 32 : 16;
        }
        int i5 = i2 & 4;
        if (i5 != 0) {
            i3 |= 384;
        } else if ((i & 384) == 0) {
            i3 |= interfaceC22053ub1J.V(dVar) ? 256 : 128;
        }
        if ((i2 & 8) != 0) {
            i3 |= SetRpcStruct$ComposedRpc.GET_NASIM_FILE_PUBLIC_URL_FIELD_NUMBER;
        } else if ((i & SetRpcStruct$ComposedRpc.GET_NASIM_FILE_PUBLIC_URL_FIELD_NUMBER) == 0) {
            i3 |= interfaceC22053ub1J.D(interfaceC14603iB2) ? 2048 : 1024;
        }
        if (interfaceC22053ub1J.o((i3 & 1171) != 1170, i3 & 1)) {
            if (i4 != 0) {
                eVar = androidx.compose.ui.e.a;
            }
            if (i5 != 0) {
                dVar = null;
            }
            if (AbstractC5138Ib1.I()) {
                AbstractC5138Ib1.Q(2002163445, i3, -1, "androidx.compose.foundation.lazy.layout.LazyLayout (LazyLayout.kt:52)");
            }
            AbstractC22869vx3.a(AbstractC19242q11.e(-1488997347, true, new a(dVar, eVar, interfaceC14603iB2, AbstractC10222bH6.q(sa2, interfaceC22053ub1J, i3 & 14)), interfaceC22053ub1J, 54), interfaceC22053ub1J, 6);
            if (AbstractC5138Ib1.I()) {
                AbstractC5138Ib1.P();
            }
        } else {
            interfaceC22053ub1J.L();
        }
        androidx.compose.ui.e eVar2 = eVar;
        androidx.compose.foundation.lazy.layout.d dVar2 = dVar;
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new b(sa2, eVar2, dVar2, interfaceC14603iB2, i, i2));
        }
    }
}
