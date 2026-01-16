package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import ir.nasim.C21669tv7;
import ir.nasim.C21669tv7.a;
import ir.nasim.C21669tv7.d;
import ir.nasim.InterfaceC22053ub1;

/* renamed from: ir.nasim.Dv7, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC4139Dv7 {
    private static final UA2 a = b.e;
    private static final InterfaceC9173Yu3 b = AbstractC13269fw3.b(EnumC4870Gx3.c, a.e);

    /* renamed from: ir.nasim.Dv7$a */
    static final class a extends AbstractC8614Ws3 implements SA2 {
        public static final a e = new a();

        /* renamed from: ir.nasim.Dv7$a$a, reason: collision with other inner class name */
        static final class C0329a extends AbstractC8614Ws3 implements UA2 {
            public static final C0329a e = new C0329a();

            C0329a() {
                super(1);
            }

            public final void a(SA2 sa2) {
                sa2.invoke();
            }

            @Override // ir.nasim.UA2
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                a((SA2) obj);
                return C19938rB7.a;
            }
        }

        a() {
            super(0);
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final androidx.compose.runtime.snapshots.k invoke() {
            androidx.compose.runtime.snapshots.k kVar = new androidx.compose.runtime.snapshots.k(C0329a.e);
            kVar.t();
            return kVar;
        }
    }

    /* renamed from: ir.nasim.Dv7$b */
    static final class b extends AbstractC8614Ws3 implements UA2 {
        public static final b e = new b();

        b() {
            super(1);
        }

        public final void a(AbstractC23924xk6 abstractC23924xk6) {
            throw null;
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            AbstractC18350oW3.a(obj);
            a(null);
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.Dv7$c */
    static final class c extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
        final /* synthetic */ C21669tv7 e;
        final /* synthetic */ C21669tv7.d f;
        final /* synthetic */ Object g;
        final /* synthetic */ Object h;
        final /* synthetic */ InterfaceC4788Go2 i;
        final /* synthetic */ int j;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(C21669tv7 c21669tv7, C21669tv7.d dVar, Object obj, Object obj2, InterfaceC4788Go2 interfaceC4788Go2, int i) {
            super(2);
            this.e = c21669tv7;
            this.f = dVar;
            this.g = obj;
            this.h = obj2;
            this.i = interfaceC4788Go2;
            this.j = i;
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            AbstractC4139Dv7.a(this.e, this.f, this.g, this.h, this.i, interfaceC22053ub1, QJ5.a(this.j | 1));
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.Dv7$d */
    static final class d extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ C21669tv7 e;
        final /* synthetic */ C21669tv7 f;

        /* renamed from: ir.nasim.Dv7$d$a */
        public static final class a implements KV1 {
            final /* synthetic */ C21669tv7 a;
            final /* synthetic */ C21669tv7 b;

            public a(C21669tv7 c21669tv7, C21669tv7 c21669tv72) {
                this.a = c21669tv7;
                this.b = c21669tv72;
            }

            @Override // ir.nasim.KV1
            public void dispose() {
                this.a.D(this.b);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(C21669tv7 c21669tv7, C21669tv7 c21669tv72) {
            super(1);
            this.e = c21669tv7;
            this.f = c21669tv72;
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final KV1 invoke(LV1 lv1) {
            this.e.d(this.f);
            return new a(this.e, this.f);
        }
    }

    /* renamed from: ir.nasim.Dv7$e */
    static final class e extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ C21669tv7 e;
        final /* synthetic */ C21669tv7.a f;

        /* renamed from: ir.nasim.Dv7$e$a */
        public static final class a implements KV1 {
            final /* synthetic */ C21669tv7 a;
            final /* synthetic */ C21669tv7.a b;

            public a(C21669tv7 c21669tv7, C21669tv7.a aVar) {
                this.a = c21669tv7;
                this.b = aVar;
            }

            @Override // ir.nasim.KV1
            public void dispose() {
                this.a.B(this.b);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e(C21669tv7 c21669tv7, C21669tv7.a aVar) {
            super(1);
            this.e = c21669tv7;
            this.f = aVar;
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final KV1 invoke(LV1 lv1) {
            return new a(this.e, this.f);
        }
    }

    /* renamed from: ir.nasim.Dv7$f */
    static final class f extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ C21669tv7 e;
        final /* synthetic */ C21669tv7.d f;

        /* renamed from: ir.nasim.Dv7$f$a */
        public static final class a implements KV1 {
            final /* synthetic */ C21669tv7 a;
            final /* synthetic */ C21669tv7.d b;

            public a(C21669tv7 c21669tv7, C21669tv7.d dVar) {
                this.a = c21669tv7;
                this.b = dVar;
            }

            @Override // ir.nasim.KV1
            public void dispose() {
                this.a.C(this.b);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        f(C21669tv7 c21669tv7, C21669tv7.d dVar) {
            super(1);
            this.e = c21669tv7;
            this.f = dVar;
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final KV1 invoke(LV1 lv1) {
            this.e.c(this.f);
            return new a(this.e, this.f);
        }
    }

    /* renamed from: ir.nasim.Dv7$g */
    static final class g extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ C21669tv7 e;

        /* renamed from: ir.nasim.Dv7$g$a */
        public static final class a implements KV1 {
            final /* synthetic */ C21669tv7 a;

            public a(C21669tv7 c21669tv7) {
                this.a = c21669tv7;
            }

            @Override // ir.nasim.KV1
            public void dispose() {
                this.a.w();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        g(C21669tv7 c21669tv7) {
            super(1);
            this.e = c21669tv7;
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final KV1 invoke(LV1 lv1) {
            return new a(this.e);
        }
    }

    /* renamed from: ir.nasim.Dv7$h */
    static final class h extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ C21669tv7 e;

        /* renamed from: ir.nasim.Dv7$h$a */
        public static final class a implements KV1 {
            final /* synthetic */ C21669tv7 a;

            public a(C21669tv7 c21669tv7) {
                this.a = c21669tv7;
            }

            @Override // ir.nasim.KV1
            public void dispose() {
                this.a.w();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        h(C21669tv7 c21669tv7) {
            super(1);
            this.e = c21669tv7;
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final KV1 invoke(LV1 lv1) {
            return new a(this.e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(C21669tv7 c21669tv7, C21669tv7.d dVar, Object obj, Object obj2, InterfaceC4788Go2 interfaceC4788Go2, InterfaceC22053ub1 interfaceC22053ub1, int i) {
        int i2;
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(867041821);
        if ((i & 6) == 0) {
            i2 = (interfaceC22053ub1J.V(c21669tv7) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= interfaceC22053ub1J.V(dVar) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= (i & 512) == 0 ? interfaceC22053ub1J.V(obj) : interfaceC22053ub1J.D(obj) ? 256 : 128;
        }
        if ((i & SetRpcStruct$ComposedRpc.GET_NASIM_FILE_PUBLIC_URL_FIELD_NUMBER) == 0) {
            i2 |= (i & 4096) == 0 ? interfaceC22053ub1J.V(obj2) : interfaceC22053ub1J.D(obj2) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i2 |= (32768 & i) == 0 ? interfaceC22053ub1J.V(interfaceC4788Go2) : interfaceC22053ub1J.D(interfaceC4788Go2) ? 16384 : 8192;
        }
        if (interfaceC22053ub1J.o((i2 & 9363) != 9362, i2 & 1)) {
            if (AbstractC5138Ib1.I()) {
                AbstractC5138Ib1.Q(867041821, i2, -1, "androidx.compose.animation.core.UpdateInitialAndTargetValues (Transition.kt:1880)");
            }
            if (c21669tv7.u()) {
                dVar.P(obj, obj2, interfaceC4788Go2);
            } else {
                dVar.Q(obj2, interfaceC4788Go2);
            }
            if (AbstractC5138Ib1.I()) {
                AbstractC5138Ib1.P();
            }
        } else {
            interfaceC22053ub1J.L();
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new c(c21669tv7, dVar, obj, obj2, interfaceC4788Go2, i));
        }
    }

    public static final C21669tv7 c(C21669tv7 c21669tv7, Object obj, Object obj2, String str, InterfaceC22053ub1 interfaceC22053ub1, int i) {
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.Q(-198307638, i, -1, "androidx.compose.animation.core.createChildTransitionInternal (Transition.kt:1773)");
        }
        int i2 = (i & 14) ^ 6;
        boolean z = true;
        boolean z2 = (i2 > 4 && interfaceC22053ub1.V(c21669tv7)) || (i & 6) == 4;
        Object objB = interfaceC22053ub1.B();
        if (z2 || objB == InterfaceC22053ub1.a.a()) {
            objB = new C21669tv7(new C11932dn4(obj), c21669tv7, c21669tv7.j() + " > " + str);
            interfaceC22053ub1.s(objB);
        }
        C21669tv7 c21669tv72 = (C21669tv7) objB;
        if ((i2 <= 4 || !interfaceC22053ub1.V(c21669tv7)) && (i & 6) != 4) {
            z = false;
        }
        boolean zV = interfaceC22053ub1.V(c21669tv72) | z;
        Object objB2 = interfaceC22053ub1.B();
        if (zV || objB2 == InterfaceC22053ub1.a.a()) {
            objB2 = new d(c21669tv7, c21669tv72);
            interfaceC22053ub1.s(objB2);
        }
        AbstractC10721c52.a(c21669tv72, (UA2) objB2, interfaceC22053ub1, 0);
        if (c21669tv7.u()) {
            c21669tv72.E(obj, obj2, c21669tv7.k());
        } else {
            c21669tv72.M(obj2);
            c21669tv72.G(false);
        }
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.P();
        }
        return c21669tv72;
    }

    public static final C21669tv7.a d(C21669tv7 c21669tv7, InterfaceC5342Ix7 interfaceC5342Ix7, String str, InterfaceC22053ub1 interfaceC22053ub1, int i, int i2) {
        if ((i2 & 2) != 0) {
            str = "DeferredAnimation";
        }
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.Q(-1714122528, i, -1, "androidx.compose.animation.core.createDeferredAnimation (Transition.kt:1731)");
        }
        int i3 = (i & 14) ^ 6;
        boolean z = true;
        boolean z2 = (i3 > 4 && interfaceC22053ub1.V(c21669tv7)) || (i & 6) == 4;
        Object objB = interfaceC22053ub1.B();
        if (z2 || objB == InterfaceC22053ub1.a.a()) {
            objB = c21669tv7.new a(interfaceC5342Ix7, str);
            interfaceC22053ub1.s(objB);
        }
        C21669tv7.a aVar = (C21669tv7.a) objB;
        if ((i3 <= 4 || !interfaceC22053ub1.V(c21669tv7)) && (i & 6) != 4) {
            z = false;
        }
        boolean zD = interfaceC22053ub1.D(aVar) | z;
        Object objB2 = interfaceC22053ub1.B();
        if (zD || objB2 == InterfaceC22053ub1.a.a()) {
            objB2 = new e(c21669tv7, aVar);
            interfaceC22053ub1.s(objB2);
        }
        AbstractC10721c52.a(aVar, (UA2) objB2, interfaceC22053ub1, 0);
        if (c21669tv7.u()) {
            aVar.d();
        }
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.P();
        }
        return aVar;
    }

    public static final InterfaceC9664aL6 e(C21669tv7 c21669tv7, Object obj, Object obj2, InterfaceC4788Go2 interfaceC4788Go2, InterfaceC5342Ix7 interfaceC5342Ix7, String str, InterfaceC22053ub1 interfaceC22053ub1, int i) {
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.Q(-304821198, i, -1, "androidx.compose.animation.core.createTransitionAnimation (Transition.kt:1848)");
        }
        int i2 = i & 14;
        int i3 = i2 ^ 6;
        boolean z = true;
        boolean z2 = (i3 > 4 && interfaceC22053ub1.V(c21669tv7)) || (i & 6) == 4;
        Object objB = interfaceC22053ub1.B();
        if (z2 || objB == InterfaceC22053ub1.a.a()) {
            Object dVar = c21669tv7.new d(obj, AbstractC6483Nt.i(interfaceC5342Ix7, obj2), interfaceC5342Ix7, str);
            interfaceC22053ub1.s(dVar);
            objB = dVar;
        }
        C21669tv7.d dVar2 = (C21669tv7.d) objB;
        int i4 = (i >> 3) & 8;
        int i5 = i << 3;
        a(c21669tv7, dVar2, obj, obj2, interfaceC4788Go2, interfaceC22053ub1, (i4 << 9) | (i4 << 6) | i2 | (i5 & 896) | (i5 & 7168) | (57344 & i5));
        if ((i3 <= 4 || !interfaceC22053ub1.V(c21669tv7)) && (i & 6) != 4) {
            z = false;
        }
        boolean zV = interfaceC22053ub1.V(dVar2) | z;
        Object objB2 = interfaceC22053ub1.B();
        if (zV || objB2 == InterfaceC22053ub1.a.a()) {
            objB2 = new f(c21669tv7, dVar2);
            interfaceC22053ub1.s(objB2);
        }
        AbstractC10721c52.a(dVar2, (UA2) objB2, interfaceC22053ub1, 0);
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.P();
        }
        return dVar2;
    }

    public static final C21669tv7 f(AbstractC4607Fv7 abstractC4607Fv7, String str, InterfaceC22053ub1 interfaceC22053ub1, int i, int i2) {
        if ((i2 & 2) != 0) {
            str = null;
        }
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.Q(1643203617, i, -1, "androidx.compose.animation.core.rememberTransition (Transition.kt:803)");
        }
        boolean z = (((i & 14) ^ 6) > 4 && interfaceC22053ub1.V(abstractC4607Fv7)) || (i & 6) == 4;
        Object objB = interfaceC22053ub1.B();
        if (z || objB == InterfaceC22053ub1.a.a()) {
            objB = new C21669tv7(abstractC4607Fv7, str);
            interfaceC22053ub1.s(objB);
        }
        C21669tv7 c21669tv7 = (C21669tv7) objB;
        interfaceC22053ub1.W(1031290843);
        c21669tv7.e(abstractC4607Fv7.b(), interfaceC22053ub1, 0);
        interfaceC22053ub1.Q();
        boolean zV = interfaceC22053ub1.V(c21669tv7);
        Object objB2 = interfaceC22053ub1.B();
        if (zV || objB2 == InterfaceC22053ub1.a.a()) {
            objB2 = new g(c21669tv7);
            interfaceC22053ub1.s(objB2);
        }
        AbstractC10721c52.a(c21669tv7, (UA2) objB2, interfaceC22053ub1, 0);
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.P();
        }
        return c21669tv7;
    }

    public static final C21669tv7 g(C11932dn4 c11932dn4, String str, InterfaceC22053ub1 interfaceC22053ub1, int i, int i2) {
        if ((i2 & 2) != 0) {
            str = null;
        }
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.Q(882913843, i, -1, "androidx.compose.animation.core.updateTransition (Transition.kt:856)");
        }
        C21669tv7 c21669tv7F = f(c11932dn4, str, interfaceC22053ub1, (i & SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER) | (i & 14), 0);
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.P();
        }
        return c21669tv7F;
    }

    public static final C21669tv7 h(Object obj, String str, InterfaceC22053ub1 interfaceC22053ub1, int i, int i2) {
        if ((i2 & 2) != 0) {
            str = null;
        }
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.Q(2029166765, i, -1, "androidx.compose.animation.core.updateTransition (Transition.kt:86)");
        }
        Object objB = interfaceC22053ub1.B();
        InterfaceC22053ub1.a aVar = InterfaceC22053ub1.a;
        if (objB == aVar.a()) {
            objB = new C21669tv7(obj, str);
            interfaceC22053ub1.s(objB);
        }
        C21669tv7 c21669tv7 = (C21669tv7) objB;
        c21669tv7.e(obj, interfaceC22053ub1, (i & 8) | 48 | (i & 14));
        Object objB2 = interfaceC22053ub1.B();
        if (objB2 == aVar.a()) {
            objB2 = new h(c21669tv7);
            interfaceC22053ub1.s(objB2);
        }
        AbstractC10721c52.a(c21669tv7, (UA2) objB2, interfaceC22053ub1, 54);
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.P();
        }
        return c21669tv7;
    }
}
