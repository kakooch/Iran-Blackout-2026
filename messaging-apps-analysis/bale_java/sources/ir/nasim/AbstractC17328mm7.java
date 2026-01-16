package ir.nasim;

import kotlin.NoWhenBranchMatchedException;

/* renamed from: ir.nasim.mm7, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC17328mm7 {

    /* renamed from: ir.nasim.mm7$a */
    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[EnumC24286yM4.values().length];
            try {
                iArr[EnumC24286yM4.a.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[EnumC24286yM4.b.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            a = iArr;
        }
    }

    /* renamed from: ir.nasim.mm7$b */
    public static final class b extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ C18510om7 e;
        final /* synthetic */ InterfaceC18507om4 f;
        final /* synthetic */ boolean g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(C18510om7 c18510om7, InterfaceC18507om4 interfaceC18507om4, boolean z) {
            super(1);
            this.e = c18510om7;
            this.f = interfaceC18507om4;
            this.g = z;
        }

        public final void a(T93 t93) {
            throw null;
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            AbstractC18350oW3.a(obj);
            a(null);
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.mm7$c */
    static final class c extends AbstractC8614Ws3 implements InterfaceC15796kB2 {
        final /* synthetic */ C18510om7 e;
        final /* synthetic */ boolean f;
        final /* synthetic */ InterfaceC18507om4 g;

        /* renamed from: ir.nasim.mm7$c$a */
        static final class a extends AbstractC8614Ws3 implements UA2 {
            final /* synthetic */ C18510om7 e;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(C18510om7 c18510om7) {
                super(1);
                this.e = c18510om7;
            }

            public final Float a(float f) {
                float fD = this.e.d() + f;
                if (fD > this.e.c()) {
                    f = this.e.c() - this.e.d();
                } else if (fD < 0.0f) {
                    f = -this.e.d();
                }
                C18510om7 c18510om7 = this.e;
                c18510om7.h(c18510om7.d() + f);
                return Float.valueOf(f);
            }

            @Override // ir.nasim.UA2
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                return a(((Number) obj).floatValue());
            }
        }

        /* renamed from: ir.nasim.mm7$c$b */
        public static final class b implements InterfaceC11049ce6 {
            private final /* synthetic */ InterfaceC11049ce6 a;
            private final InterfaceC9664aL6 b;
            private final InterfaceC9664aL6 c;

            /* renamed from: ir.nasim.mm7$c$b$a */
            static final class a extends AbstractC8614Ws3 implements SA2 {
                final /* synthetic */ C18510om7 e;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                a(C18510om7 c18510om7) {
                    super(0);
                    this.e = c18510om7;
                }

                @Override // ir.nasim.SA2
                /* renamed from: a, reason: merged with bridge method [inline-methods] */
                public final Boolean invoke() {
                    return Boolean.valueOf(this.e.d() > 0.0f);
                }
            }

            /* renamed from: ir.nasim.mm7$c$b$b, reason: collision with other inner class name */
            static final class C1401b extends AbstractC8614Ws3 implements SA2 {
                final /* synthetic */ C18510om7 e;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C1401b(C18510om7 c18510om7) {
                    super(0);
                    this.e = c18510om7;
                }

                @Override // ir.nasim.SA2
                /* renamed from: a, reason: merged with bridge method [inline-methods] */
                public final Boolean invoke() {
                    return Boolean.valueOf(this.e.d() < this.e.c());
                }
            }

            b(InterfaceC11049ce6 interfaceC11049ce6, C18510om7 c18510om7) {
                this.a = interfaceC11049ce6;
                this.b = AbstractC10222bH6.d(new C1401b(c18510om7));
                this.c = AbstractC10222bH6.d(new a(c18510om7));
            }

            @Override // ir.nasim.InterfaceC11049ce6
            public Object b(EnumC15562jn4 enumC15562jn4, InterfaceC14603iB2 interfaceC14603iB2, InterfaceC20295rm1 interfaceC20295rm1) {
                return this.a.b(enumC15562jn4, interfaceC14603iB2, interfaceC20295rm1);
            }

            @Override // ir.nasim.InterfaceC11049ce6
            public boolean c() {
                return this.a.c();
            }

            @Override // ir.nasim.InterfaceC11049ce6
            public boolean d() {
                return ((Boolean) this.c.getValue()).booleanValue();
            }

            @Override // ir.nasim.InterfaceC11049ce6
            public boolean e() {
                return ((Boolean) this.b.getValue()).booleanValue();
            }

            @Override // ir.nasim.InterfaceC11049ce6
            public float f(float f) {
                return this.a.f(f);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(C18510om7 c18510om7, boolean z, InterfaceC18507om4 interfaceC18507om4) {
            super(3);
            this.e = c18510om7;
            this.f = z;
            this.g = interfaceC18507om4;
        }

        public final androidx.compose.ui.e a(androidx.compose.ui.e eVar, InterfaceC22053ub1 interfaceC22053ub1, int i) {
            interfaceC22053ub1.W(805428266);
            if (AbstractC5138Ib1.I()) {
                AbstractC5138Ib1.Q(805428266, i, -1, "androidx.compose.foundation.text.textFieldScrollable.<anonymous> (TextFieldScroll.kt:71)");
            }
            boolean z = this.e.f() == EnumC24286yM4.a || !(interfaceC22053ub1.H(AbstractC13040fc1.n()) == EnumC12613eu3.b);
            boolean zV = interfaceC22053ub1.V(this.e);
            C18510om7 c18510om7 = this.e;
            Object objB = interfaceC22053ub1.B();
            if (zV || objB == InterfaceC22053ub1.a.a()) {
                objB = new a(c18510om7);
                interfaceC22053ub1.s(objB);
            }
            InterfaceC11049ce6 interfaceC11049ce6B = AbstractC11844de6.b((UA2) objB, interfaceC22053ub1, 0);
            boolean zV2 = interfaceC22053ub1.V(interfaceC11049ce6B) | interfaceC22053ub1.V(this.e);
            C18510om7 c18510om72 = this.e;
            Object objB2 = interfaceC22053ub1.B();
            if (zV2 || objB2 == InterfaceC22053ub1.a.a()) {
                objB2 = new b(interfaceC11049ce6B, c18510om72);
                interfaceC22053ub1.s(objB2);
            }
            androidx.compose.ui.e eVarK = androidx.compose.foundation.gestures.d.k(androidx.compose.ui.e.a, (b) objB2, this.e.f(), this.f && this.e.c() != 0.0f, z, null, this.g, 16, null);
            if (AbstractC5138Ib1.I()) {
                AbstractC5138Ib1.P();
            }
            interfaceC22053ub1.Q();
            return eVarK;
        }

        @Override // ir.nasim.InterfaceC15796kB2
        public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
            return a((androidx.compose.ui.e) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
        }
    }

    public static final androidx.compose.ui.e b(androidx.compose.ui.e eVar, C18510om7 c18510om7, C23945xm7 c23945xm7, QY7 qy7, SA2 sa2) {
        androidx.compose.ui.e c16545lS7;
        EnumC24286yM4 enumC24286yM4F = c18510om7.f();
        int iE = c18510om7.e(c23945xm7.g());
        c18510om7.i(c23945xm7.g());
        C18600ov7 c18600ov7C = VO7.c(qy7, c23945xm7.e());
        int i = a.a[enumC24286yM4F.ordinal()];
        if (i == 1) {
            c16545lS7 = new C16545lS7(c18510om7, iE, c18600ov7C, sa2);
        } else {
            if (i != 2) {
                throw new NoWhenBranchMatchedException();
            }
            c16545lS7 = new OY2(c18510om7, iE, c18600ov7C, sa2);
        }
        return FV0.b(eVar).i(c16545lS7);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CK5 c(WH1 wh1, int i, C18600ov7 c18600ov7, C13774gn7 c13774gn7, boolean z, int i2) {
        CK5 ck5A;
        if (c13774gn7 == null || (ck5A = c13774gn7.e(c18600ov7.a().b(i))) == null) {
            ck5A = CK5.e.a();
        }
        CK5 ck5 = ck5A;
        int iB0 = wh1.B0(AbstractC8087Ul7.a());
        return CK5.d(ck5, z ? (i2 - ck5.i()) - iB0 : ck5.i(), 0.0f, z ? i2 - ck5.i() : ck5.i() + iB0, 0.0f, 10, null);
    }

    public static final androidx.compose.ui.e d(androidx.compose.ui.e eVar, C18510om7 c18510om7, InterfaceC18507om4 interfaceC18507om4, boolean z) {
        return androidx.compose.ui.c.b(eVar, Q93.b() ? new b(c18510om7, interfaceC18507om4, z) : Q93.a(), new c(c18510om7, z, interfaceC18507om4));
    }
}
