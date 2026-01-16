package ir.nasim;

import ir.nasim.AbstractC5284Ir3;
import ir.nasim.C11663dO4;
import ir.nasim.InterfaceC15194jA0;
import ir.nasim.InterfaceC4333Er3;
import java.util.Collection;

/* renamed from: ir.nasim.wI1, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C23067wI1 {
    public static final C23067wI1 a = new C23067wI1();

    /* renamed from: ir.nasim.wI1$a */
    static final class a extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
        public static final a e = new a();

        a() {
            super(2);
        }

        public final boolean a(InterfaceC12795fB1 interfaceC12795fB1, InterfaceC12795fB1 interfaceC12795fB12) {
            return false;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            return Boolean.valueOf(a((InterfaceC12795fB1) obj, (InterfaceC12795fB1) obj2));
        }
    }

    /* renamed from: ir.nasim.wI1$b */
    static final class b implements InterfaceC4333Er3.a {
        final /* synthetic */ boolean b;
        final /* synthetic */ InterfaceC14592iA0 c;
        final /* synthetic */ InterfaceC14592iA0 d;

        /* renamed from: ir.nasim.wI1$b$a */
        static final class a extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
            final /* synthetic */ InterfaceC14592iA0 e;
            final /* synthetic */ InterfaceC14592iA0 f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(InterfaceC14592iA0 interfaceC14592iA0, InterfaceC14592iA0 interfaceC14592iA02) {
                super(2);
                this.e = interfaceC14592iA0;
                this.f = interfaceC14592iA02;
            }

            public final boolean a(InterfaceC12795fB1 interfaceC12795fB1, InterfaceC12795fB1 interfaceC12795fB12) {
                return AbstractC13042fc3.d(interfaceC12795fB1, this.e) && AbstractC13042fc3.d(interfaceC12795fB12, this.f);
            }

            @Override // ir.nasim.InterfaceC14603iB2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                return Boolean.valueOf(a((InterfaceC12795fB1) obj, (InterfaceC12795fB1) obj2));
            }
        }

        b(boolean z, InterfaceC14592iA0 interfaceC14592iA0, InterfaceC14592iA0 interfaceC14592iA02) {
            this.b = z;
            this.c = interfaceC14592iA0;
            this.d = interfaceC14592iA02;
        }

        @Override // ir.nasim.InterfaceC4333Er3.a
        public final boolean a(InterfaceC13882gy7 interfaceC13882gy7, InterfaceC13882gy7 interfaceC13882gy72) {
            AbstractC13042fc3.i(interfaceC13882gy7, "c1");
            AbstractC13042fc3.i(interfaceC13882gy72, "c2");
            if (AbstractC13042fc3.d(interfaceC13882gy7, interfaceC13882gy72)) {
                return true;
            }
            MU0 mu0D = interfaceC13882gy7.t();
            MU0 mu0D2 = interfaceC13882gy72.t();
            if ((mu0D instanceof InterfaceC22882vy7) && (mu0D2 instanceof InterfaceC22882vy7)) {
                return C23067wI1.this.g((InterfaceC22882vy7) mu0D, (InterfaceC22882vy7) mu0D2, this.b, new a(this.c, this.d));
            }
            return false;
        }
    }

    /* renamed from: ir.nasim.wI1$c */
    static final class c extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
        public static final c e = new c();

        c() {
            super(2);
        }

        public final boolean a(InterfaceC12795fB1 interfaceC12795fB1, InterfaceC12795fB1 interfaceC12795fB12) {
            return false;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            return Boolean.valueOf(a((InterfaceC12795fB1) obj, (InterfaceC12795fB1) obj2));
        }
    }

    private C23067wI1() {
    }

    public static /* synthetic */ boolean c(C23067wI1 c23067wI1, InterfaceC14592iA0 interfaceC14592iA0, InterfaceC14592iA0 interfaceC14592iA02, boolean z, boolean z2, boolean z3, AbstractC5284Ir3 abstractC5284Ir3, int i, Object obj) {
        if ((i & 8) != 0) {
            z2 = true;
        }
        boolean z4 = z2;
        if ((i & 16) != 0) {
            z3 = false;
        }
        return c23067wI1.b(interfaceC14592iA0, interfaceC14592iA02, z, z4, z3, abstractC5284Ir3);
    }

    private final boolean d(InterfaceC21331tU0 interfaceC21331tU0, InterfaceC21331tU0 interfaceC21331tU02) {
        return AbstractC13042fc3.d(interfaceC21331tU0.j(), interfaceC21331tU02.j());
    }

    public static /* synthetic */ boolean f(C23067wI1 c23067wI1, InterfaceC12795fB1 interfaceC12795fB1, InterfaceC12795fB1 interfaceC12795fB12, boolean z, boolean z2, int i, Object obj) {
        if ((i & 8) != 0) {
            z2 = true;
        }
        return c23067wI1.e(interfaceC12795fB1, interfaceC12795fB12, z, z2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean g(InterfaceC22882vy7 interfaceC22882vy7, InterfaceC22882vy7 interfaceC22882vy72, boolean z, InterfaceC14603iB2 interfaceC14603iB2) {
        if (AbstractC13042fc3.d(interfaceC22882vy7, interfaceC22882vy72)) {
            return true;
        }
        return !AbstractC13042fc3.d(interfaceC22882vy7.b(), interfaceC22882vy72.b()) && i(interfaceC22882vy7, interfaceC22882vy72, interfaceC14603iB2, z) && interfaceC22882vy7.getIndex() == interfaceC22882vy72.getIndex();
    }

    static /* synthetic */ boolean h(C23067wI1 c23067wI1, InterfaceC22882vy7 interfaceC22882vy7, InterfaceC22882vy7 interfaceC22882vy72, boolean z, InterfaceC14603iB2 interfaceC14603iB2, int i, Object obj) {
        if ((i & 8) != 0) {
            interfaceC14603iB2 = c.e;
        }
        return c23067wI1.g(interfaceC22882vy7, interfaceC22882vy72, z, interfaceC14603iB2);
    }

    private final boolean i(InterfaceC12795fB1 interfaceC12795fB1, InterfaceC12795fB1 interfaceC12795fB12, InterfaceC14603iB2 interfaceC14603iB2, boolean z) {
        InterfaceC12795fB1 interfaceC12795fB1B = interfaceC12795fB1.b();
        InterfaceC12795fB1 interfaceC12795fB1B2 = interfaceC12795fB12.b();
        return ((interfaceC12795fB1B instanceof InterfaceC15194jA0) || (interfaceC12795fB1B2 instanceof InterfaceC15194jA0)) ? ((Boolean) interfaceC14603iB2.invoke(interfaceC12795fB1B, interfaceC12795fB1B2)).booleanValue() : f(this, interfaceC12795fB1B, interfaceC12795fB1B2, z, false, 8, null);
    }

    private final JH6 j(InterfaceC14592iA0 interfaceC14592iA0) {
        while (interfaceC14592iA0 instanceof InterfaceC15194jA0) {
            InterfaceC15194jA0 interfaceC15194jA0 = (InterfaceC15194jA0) interfaceC14592iA0;
            if (interfaceC15194jA0.f() != InterfaceC15194jA0.a.FAKE_OVERRIDE) {
                break;
            }
            Collection collectionD = interfaceC15194jA0.d();
            AbstractC13042fc3.h(collectionD, "overriddenDescriptors");
            interfaceC14592iA0 = (InterfaceC15194jA0) AbstractC15401jX0.W0(collectionD);
            if (interfaceC14592iA0 == null) {
                return null;
            }
        }
        return interfaceC14592iA0.i();
    }

    public final boolean b(InterfaceC14592iA0 interfaceC14592iA0, InterfaceC14592iA0 interfaceC14592iA02, boolean z, boolean z2, boolean z3, AbstractC5284Ir3 abstractC5284Ir3) {
        AbstractC13042fc3.i(interfaceC14592iA0, "a");
        AbstractC13042fc3.i(interfaceC14592iA02, "b");
        AbstractC13042fc3.i(abstractC5284Ir3, "kotlinTypeRefiner");
        if (AbstractC13042fc3.d(interfaceC14592iA0, interfaceC14592iA02)) {
            return true;
        }
        if (!AbstractC13042fc3.d(interfaceC14592iA0.getName(), interfaceC14592iA02.getName())) {
            return false;
        }
        if (z2 && (interfaceC14592iA0 instanceof InterfaceC21058t24) && (interfaceC14592iA02 instanceof InterfaceC21058t24) && ((InterfaceC21058t24) interfaceC14592iA0).l0() != ((InterfaceC21058t24) interfaceC14592iA02).l0()) {
            return false;
        }
        if ((AbstractC13042fc3.d(interfaceC14592iA0.b(), interfaceC14592iA02.b()) && (!z || !AbstractC13042fc3.d(j(interfaceC14592iA0), j(interfaceC14592iA02)))) || OI1.E(interfaceC14592iA0) || OI1.E(interfaceC14592iA02) || !i(interfaceC14592iA0, interfaceC14592iA02, a.e, z)) {
            return false;
        }
        C11663dO4 c11663dO4K = C11663dO4.k(abstractC5284Ir3, new b(z, interfaceC14592iA0, interfaceC14592iA02));
        AbstractC13042fc3.h(c11663dO4K, "fun areCallableDescriptorsEquivalent(\n        a: CallableDescriptor,\n        b: CallableDescriptor,\n        allowCopiesFromTheSameDeclaration: Boolean,\n        distinguishExpectsAndNonExpects: Boolean = true,\n        ignoreReturnType: Boolean = false,\n        kotlinTypeRefiner: KotlinTypeRefiner\n    ): Boolean {\n        if (a == b) return true\n        if (a.name != b.name) return false\n        if (distinguishExpectsAndNonExpects && a is MemberDescriptor && b is MemberDescriptor && a.isExpect != b.isExpect) return false\n        if (a.containingDeclaration == b.containingDeclaration) {\n            if (!allowCopiesFromTheSameDeclaration) return false\n            if (a.singleSource() != b.singleSource()) return false\n        }\n\n        // Distinct locals are not equivalent\n        if (DescriptorUtils.isLocal(a) || DescriptorUtils.isLocal(b)) return false\n\n        if (!ownersEquivalent(a, b, { _, _ -> false }, allowCopiesFromTheSameDeclaration)) return false\n\n        val overridingUtil = OverridingUtil.create(kotlinTypeRefiner) eq@{ c1, c2 ->\n            if (c1 == c2) return@eq true\n\n            val d1 = c1.declarationDescriptor\n            val d2 = c2.declarationDescriptor\n\n            if (d1 !is TypeParameterDescriptor || d2 !is TypeParameterDescriptor) return@eq false\n\n            areTypeParametersEquivalent(d1, d2, allowCopiesFromTheSameDeclaration) { x, y -> x == a && y == b }\n        }\n\n        return overridingUtil.isOverridableBy(a, b, null, !ignoreReturnType).result == OverrideCompatibilityInfo.Result.OVERRIDABLE\n                && overridingUtil.isOverridableBy(b, a, null, !ignoreReturnType).result == OverrideCompatibilityInfo.Result.OVERRIDABLE\n\n    }");
        C11663dO4.i.a aVarC = c11663dO4K.H(interfaceC14592iA0, interfaceC14592iA02, null, !z3).c();
        C11663dO4.i.a aVar = C11663dO4.i.a.OVERRIDABLE;
        return aVarC == aVar && c11663dO4K.H(interfaceC14592iA02, interfaceC14592iA0, null, z3 ^ true).c() == aVar;
    }

    public final boolean e(InterfaceC12795fB1 interfaceC12795fB1, InterfaceC12795fB1 interfaceC12795fB12, boolean z, boolean z2) {
        return ((interfaceC12795fB1 instanceof InterfaceC21331tU0) && (interfaceC12795fB12 instanceof InterfaceC21331tU0)) ? d((InterfaceC21331tU0) interfaceC12795fB1, (InterfaceC21331tU0) interfaceC12795fB12) : ((interfaceC12795fB1 instanceof InterfaceC22882vy7) && (interfaceC12795fB12 instanceof InterfaceC22882vy7)) ? h(this, (InterfaceC22882vy7) interfaceC12795fB1, (InterfaceC22882vy7) interfaceC12795fB12, z, null, 8, null) : ((interfaceC12795fB1 instanceof InterfaceC14592iA0) && (interfaceC12795fB12 instanceof InterfaceC14592iA0)) ? c(this, (InterfaceC14592iA0) interfaceC12795fB1, (InterfaceC14592iA0) interfaceC12795fB12, z, z2, false, AbstractC5284Ir3.a.a, 16, null) : ((interfaceC12795fB1 instanceof InterfaceC24340yS4) && (interfaceC12795fB12 instanceof InterfaceC24340yS4)) ? AbstractC13042fc3.d(((InterfaceC24340yS4) interfaceC12795fB1).e(), ((InterfaceC24340yS4) interfaceC12795fB12).e()) : AbstractC13042fc3.d(interfaceC12795fB1, interfaceC12795fB12);
    }
}
