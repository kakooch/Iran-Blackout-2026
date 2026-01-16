package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import android.content.Context;
import android.content.ContextWrapper;
import androidx.activity.ComponentActivity;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;

/* loaded from: classes2.dex */
public abstract class RV {
    private static final AbstractC6535Nx5 a = AbstractC11024cc1.f(h.e);

    static final class a extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
        final /* synthetic */ SA2 e;

        /* renamed from: ir.nasim.RV$a$a, reason: collision with other inner class name */
        static final class C0597a extends AbstractC8614Ws3 implements SA2 {
            final /* synthetic */ SA2 e;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C0597a(SA2 sa2) {
                super(0);
                this.e = sa2;
            }

            public final void a() {
                this.e.invoke();
            }

            @Override // ir.nasim.SA2
            public /* bridge */ /* synthetic */ Object invoke() {
                a();
                return C19938rB7.a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(SA2 sa2) {
            super(2);
            this.e = sa2;
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 11) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
                return;
            }
            if (AbstractC5138Ib1.I()) {
                AbstractC5138Ib1.Q(-955225945, i, -1, "com.airbnb.android.showkase.ui.BackButtonHandler.<anonymous> (BackButtonHandler.kt:67)");
            }
            interfaceC22053ub1.A(1122796498);
            boolean zV = interfaceC22053ub1.V(this.e);
            SA2 sa2 = this.e;
            Object objB = interfaceC22053ub1.B();
            if (zV || objB == InterfaceC22053ub1.a.a()) {
                objB = new C0597a(sa2);
                interfaceC22053ub1.s(objB);
            }
            interfaceC22053ub1.U();
            RV.b(false, (SA2) objB, interfaceC22053ub1, 0, 1);
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

    static final class b extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
        final /* synthetic */ SA2 e;
        final /* synthetic */ int f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(SA2 sa2, int i) {
            super(2);
            this.e = sa2;
            this.f = i;
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            RV.a(this.e, interfaceC22053ub1, QJ5.a(this.f | 1));
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    static final class c extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ C23660xI4 e;
        final /* synthetic */ C16878m11 f;

        public static final class a implements KV1 {
            final /* synthetic */ C16878m11 a;

            public a(C16878m11 c16878m11) {
                this.a = c16878m11;
            }

            @Override // ir.nasim.KV1
            public void dispose() {
                this.a.h();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(C23660xI4 c23660xI4, C16878m11 c16878m11) {
            super(1);
            this.e = c23660xI4;
            this.f = c16878m11;
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final KV1 invoke(LV1 lv1) {
            AbstractC13042fc3.i(lv1, "$this$DisposableEffect");
            this.e.i(this.f);
            return new a(this.f);
        }
    }

    static final class d extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ C16878m11 c;
        final /* synthetic */ boolean d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(C16878m11 c16878m11, boolean z, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = c16878m11;
            this.d = z;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new d(this.c, this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            this.c.j(this.d);
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((d) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class e extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ C16878m11 c;
        final /* synthetic */ SA2 d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e(C16878m11 c16878m11, SA2 sa2, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = c16878m11;
            this.d = sa2;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new e(this.c, this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            this.c.m(this.d);
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((e) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class f extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
        final /* synthetic */ boolean e;
        final /* synthetic */ SA2 f;
        final /* synthetic */ int g;
        final /* synthetic */ int h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        f(boolean z, SA2 sa2, int i, int i2) {
            super(2);
            this.e = z;
            this.f = sa2;
            this.g = i;
            this.h = i2;
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            RV.b(this.e, this.f, interfaceC22053ub1, QJ5.a(this.g | 1), this.h);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    static final class g extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
        final /* synthetic */ boolean e;
        final /* synthetic */ SA2 f;
        final /* synthetic */ int g;
        final /* synthetic */ int h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        g(boolean z, SA2 sa2, int i, int i2) {
            super(2);
            this.e = z;
            this.f = sa2;
            this.g = i;
            this.h = i2;
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            RV.b(this.e, this.f, interfaceC22053ub1, QJ5.a(this.g | 1), this.h);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    static final class h extends AbstractC8614Ws3 implements SA2 {
        public static final h e = new h();

        h() {
            super(0);
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final AI4 invoke() {
            return null;
        }
    }

    public static final void a(SA2 sa2, InterfaceC22053ub1 interfaceC22053ub1, int i) {
        int i2;
        AbstractC13042fc3.i(sa2, "onBackPressed");
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(-1799539737);
        if ((i & 14) == 0) {
            i2 = (interfaceC22053ub1J.D(sa2) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i2 & 11) == 2 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
        } else {
            if (AbstractC5138Ib1.I()) {
                AbstractC5138Ib1.Q(-1799539737, i2, -1, "com.airbnb.android.showkase.ui.BackButtonHandler (BackButtonHandler.kt:51)");
            }
            Context baseContext = (Context) interfaceC22053ub1J.H(AndroidCompositionLocals_androidKt.g());
            while ((baseContext instanceof ContextWrapper) && !(baseContext instanceof AI4)) {
                baseContext = ((ContextWrapper) baseContext).getBaseContext();
                AbstractC13042fc3.h(baseContext, "getBaseContext(...)");
            }
            AbstractC6535Nx5 abstractC6535Nx5 = a;
            AbstractC13042fc3.g(baseContext, "null cannot be cast to non-null type androidx.activity.ComponentActivity");
            AbstractC11024cc1.a(abstractC6535Nx5.d((ComponentActivity) baseContext), AbstractC19242q11.b(interfaceC22053ub1J, -955225945, true, new a(sa2)), interfaceC22053ub1J, 56);
            if (AbstractC5138Ib1.I()) {
                AbstractC5138Ib1.P();
            }
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new b(sa2, i));
        }
    }

    public static final void b(boolean z, SA2 sa2, InterfaceC22053ub1 interfaceC22053ub1, int i, int i2) {
        int i3;
        AbstractC13042fc3.i(sa2, "onBackPressed");
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(108285564);
        int i4 = i2 & 1;
        if (i4 != 0) {
            i3 = i | 6;
        } else if ((i & 14) == 0) {
            i3 = (interfaceC22053ub1J.a(z) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i2 & 2) != 0) {
            i3 |= 48;
        } else if ((i & SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER) == 0) {
            i3 |= interfaceC22053ub1J.D(sa2) ? 32 : 16;
        }
        if ((i3 & 91) == 18 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
        } else {
            if (i4 != 0) {
                z = true;
            }
            if (AbstractC5138Ib1.I()) {
                AbstractC5138Ib1.Q(108285564, i3, -1, "com.airbnb.android.showkase.ui.Handler (BackButtonHandler.kt:32)");
            }
            AI4 ai4 = (AI4) interfaceC22053ub1J.H(a);
            if (ai4 == null) {
                if (AbstractC5138Ib1.I()) {
                    AbstractC5138Ib1.P();
                }
                InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
                if (interfaceC20208rd6M != null) {
                    interfaceC20208rd6M.a(new g(z, sa2, i, i2));
                    return;
                }
                return;
            }
            C23660xI4 c23660xI4Z2 = ai4.z2();
            interfaceC22053ub1J.A(197839920);
            Object objB = interfaceC22053ub1J.B();
            if (objB == InterfaceC22053ub1.a.a()) {
                objB = new C16878m11(z);
                interfaceC22053ub1J.s(objB);
            }
            C16878m11 c16878m11 = (C16878m11) objB;
            interfaceC22053ub1J.U();
            AbstractC10721c52.a(c23660xI4Z2, new c(c23660xI4Z2, c16878m11), interfaceC22053ub1J, 8);
            AbstractC10721c52.e(Boolean.valueOf(z), new d(c16878m11, z, null), interfaceC22053ub1J, (i3 & 14) | 64);
            AbstractC10721c52.e(sa2, new e(c16878m11, sa2, null), interfaceC22053ub1J, ((i3 >> 3) & 14) | 64);
            if (AbstractC5138Ib1.I()) {
                AbstractC5138Ib1.P();
            }
        }
        InterfaceC20208rd6 interfaceC20208rd6M2 = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M2 != null) {
            interfaceC20208rd6M2.a(new f(z, sa2, i, i2));
        }
    }
}
