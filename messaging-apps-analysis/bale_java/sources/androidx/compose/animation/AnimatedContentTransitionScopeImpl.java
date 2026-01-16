package androidx.compose.animation;

import android.gov.nist.javax.sip.parser.TokenNames;
import ir.nasim.AbstractC10222bH6;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC13472gH6;
import ir.nasim.AbstractC21430te5;
import ir.nasim.AbstractC22068uc6;
import ir.nasim.AbstractC24021xu3;
import ir.nasim.AbstractC25066zg4;
import ir.nasim.AbstractC4139Dv7;
import ir.nasim.AbstractC5138Ib1;
import ir.nasim.AbstractC5999Lt;
import ir.nasim.AbstractC8614Ws3;
import ir.nasim.C17312ml1;
import ir.nasim.C19938rB7;
import ir.nasim.C21669tv7;
import ir.nasim.C4414Fa3;
import ir.nasim.C7386Rm4;
import ir.nasim.EnumC12613eu3;
import ir.nasim.FV0;
import ir.nasim.InterfaceC10195bE6;
import ir.nasim.InterfaceC11734dW3;
import ir.nasim.InterfaceC12377eW3;
import ir.nasim.InterfaceC12529em;
import ir.nasim.InterfaceC22053ub1;
import ir.nasim.InterfaceC24376yW4;
import ir.nasim.InterfaceC4788Go2;
import ir.nasim.InterfaceC9102Ym4;
import ir.nasim.InterfaceC9664aL6;
import ir.nasim.PQ7;
import ir.nasim.UA2;
import ir.nasim.WH1;
import ir.nasim.ZV3;
import kotlin.Metadata;

/* loaded from: classes.dex */
public final class AnimatedContentTransitionScopeImpl implements d {
    private final C21669tv7 a;
    private InterfaceC12529em b;
    private EnumC12613eu3 c;
    private final InterfaceC9102Ym4 d = AbstractC13472gH6.d(C4414Fa3.b(C4414Fa3.b.a()), null, 2, null);
    private final C7386Rm4 e = AbstractC22068uc6.b();
    private InterfaceC9664aL6 f;

    @Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0002\u0018\u0000*\u0004\b\u0001\u0010\u00012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u00030\u0002BE\u0012\u001e\u0010\b\u001a\u001a\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004R\b\u0012\u0004\u0012\u00028\u00010\u0007\u0012\u000e\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\t\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00010\f¢\u0006\u0004\b\u000e\u0010\u000fJ\u0015\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00010\u0003H\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u001a\u0010\u0018\u001a\u00020\u00172\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0096\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u001d\u0010\u001c\u001a\u00020\u001b2\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00028\u00010\u0003H\u0016¢\u0006\u0004\b\u001c\u0010\u001dR/\u0010\b\u001a\u001a\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004R\b\u0012\u0004\u0012\u00028\u00010\u00078\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R\u001f\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\t8\u0006¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%R\u001d\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00010\f8\u0006¢\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)¨\u0006*"}, d2 = {"Landroidx/compose/animation/AnimatedContentTransitionScopeImpl$SizeModifierElement;", TokenNames.S, "Lir/nasim/zg4;", "Landroidx/compose/animation/AnimatedContentTransitionScopeImpl$b;", "Lir/nasim/tv7$a;", "Lir/nasim/Fa3;", "Lir/nasim/Rt;", "Lir/nasim/tv7;", "sizeAnimation", "Lir/nasim/aL6;", "Lir/nasim/bE6;", "sizeTransform", "Landroidx/compose/animation/AnimatedContentTransitionScopeImpl;", "scope", "<init>", "(Lir/nasim/tv7$a;Lir/nasim/aL6;Landroidx/compose/animation/AnimatedContentTransitionScopeImpl;)V", "l", "()Landroidx/compose/animation/AnimatedContentTransitionScopeImpl$b;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "node", "Lir/nasim/rB7;", "m", "(Landroidx/compose/animation/AnimatedContentTransitionScopeImpl$b;)V", "b", "Lir/nasim/tv7$a;", "getSizeAnimation", "()Lir/nasim/tv7$a;", "c", "Lir/nasim/aL6;", "getSizeTransform", "()Lir/nasim/aL6;", "d", "Landroidx/compose/animation/AnimatedContentTransitionScopeImpl;", "getScope", "()Landroidx/compose/animation/AnimatedContentTransitionScopeImpl;", "animation_release"}, k = 1, mv = {1, 9, 0})
    private static final class SizeModifierElement<S> extends AbstractC25066zg4 {

        /* renamed from: b, reason: from kotlin metadata */
        private final C21669tv7.a sizeAnimation;

        /* renamed from: c, reason: from kotlin metadata */
        private final InterfaceC9664aL6 sizeTransform;

        /* renamed from: d, reason: from kotlin metadata */
        private final AnimatedContentTransitionScopeImpl scope;

        public SizeModifierElement(C21669tv7.a aVar, InterfaceC9664aL6 interfaceC9664aL6, AnimatedContentTransitionScopeImpl animatedContentTransitionScopeImpl) {
            this.sizeAnimation = aVar;
            this.sizeTransform = interfaceC9664aL6;
            this.scope = animatedContentTransitionScopeImpl;
        }

        public boolean equals(Object other) {
            if (other instanceof SizeModifierElement) {
                SizeModifierElement sizeModifierElement = (SizeModifierElement) other;
                if (AbstractC13042fc3.d(sizeModifierElement.sizeAnimation, this.sizeAnimation) && AbstractC13042fc3.d(sizeModifierElement.sizeTransform, this.sizeTransform)) {
                    return true;
                }
            }
            return false;
        }

        public int hashCode() {
            int iHashCode = this.scope.hashCode() * 31;
            C21669tv7.a aVar = this.sizeAnimation;
            return ((iHashCode + (aVar != null ? aVar.hashCode() : 0)) * 31) + this.sizeTransform.hashCode();
        }

        @Override // ir.nasim.AbstractC25066zg4
        /* renamed from: l, reason: merged with bridge method [inline-methods] */
        public b f() {
            return new b(this.sizeAnimation, this.sizeTransform, this.scope);
        }

        @Override // ir.nasim.AbstractC25066zg4
        /* renamed from: m, reason: merged with bridge method [inline-methods] */
        public void k(b node) {
            node.A2(this.sizeAnimation);
            node.B2(this.sizeTransform);
            node.z2(this.scope);
        }
    }

    private static final class b extends AbstractC24021xu3 {
        private C21669tv7.a o;
        private InterfaceC9664aL6 p;
        private AnimatedContentTransitionScopeImpl q;
        private long r = androidx.compose.animation.a.a;

        static final class a extends AbstractC8614Ws3 implements UA2 {
            final /* synthetic */ AbstractC21430te5 f;
            final /* synthetic */ long g;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(AbstractC21430te5 abstractC21430te5, long j) {
                super(1);
                this.f = abstractC21430te5;
                this.g = j;
            }

            public final void a(AbstractC21430te5.a aVar) {
                AbstractC21430te5.a.j(aVar, this.f, b.this.w2().g().a(C4414Fa3.c((this.f.P0() << 32) | (this.f.A0() & 4294967295L)), this.g, EnumC12613eu3.a), 0.0f, 2, null);
            }

            @Override // ir.nasim.UA2
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                a((AbstractC21430te5.a) obj);
                return C19938rB7.a;
            }
        }

        /* renamed from: androidx.compose.animation.AnimatedContentTransitionScopeImpl$b$b, reason: collision with other inner class name */
        static final class C0020b extends AbstractC8614Ws3 implements UA2 {
            final /* synthetic */ long f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C0020b(long j) {
                super(1);
                this.f = j;
            }

            @Override // ir.nasim.UA2
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final InterfaceC4788Go2 invoke(C21669tv7.b bVar) {
                long j;
                InterfaceC4788Go2 interfaceC4788Go2B;
                if (AbstractC13042fc3.d(bVar.b(), b.this.w2().b())) {
                    j = b.this.y2(this.f);
                } else {
                    InterfaceC9664aL6 interfaceC9664aL6 = (InterfaceC9664aL6) b.this.w2().h().e(bVar.b());
                    j = interfaceC9664aL6 != null ? ((C4414Fa3) interfaceC9664aL6.getValue()).j() : C4414Fa3.b.a();
                }
                InterfaceC9664aL6 interfaceC9664aL62 = (InterfaceC9664aL6) b.this.w2().h().e(bVar.a());
                long j2 = interfaceC9664aL62 != null ? ((C4414Fa3) interfaceC9664aL62.getValue()).j() : C4414Fa3.b.a();
                InterfaceC10195bE6 interfaceC10195bE6 = (InterfaceC10195bE6) b.this.x2().getValue();
                return (interfaceC10195bE6 == null || (interfaceC4788Go2B = interfaceC10195bE6.b(j, j2)) == null) ? AbstractC5999Lt.j(0.0f, 400.0f, null, 5, null) : interfaceC4788Go2B;
            }
        }

        static final class c extends AbstractC8614Ws3 implements UA2 {
            final /* synthetic */ long f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            c(long j) {
                super(1);
                this.f = j;
            }

            public final long a(Object obj) {
                if (AbstractC13042fc3.d(obj, b.this.w2().b())) {
                    return b.this.y2(this.f);
                }
                InterfaceC9664aL6 interfaceC9664aL6 = (InterfaceC9664aL6) b.this.w2().h().e(obj);
                return interfaceC9664aL6 != null ? ((C4414Fa3) interfaceC9664aL6.getValue()).j() : C4414Fa3.b.a();
            }

            @Override // ir.nasim.UA2
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                return C4414Fa3.b(a(obj));
            }
        }

        public b(C21669tv7.a aVar, InterfaceC9664aL6 interfaceC9664aL6, AnimatedContentTransitionScopeImpl animatedContentTransitionScopeImpl) {
            this.o = aVar;
            this.p = interfaceC9664aL6;
            this.q = animatedContentTransitionScopeImpl;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final long y2(long j) {
            return C4414Fa3.e(this.r, androidx.compose.animation.a.a) ? j : this.r;
        }

        public final void A2(C21669tv7.a aVar) {
            this.o = aVar;
        }

        public final void B2(InterfaceC9664aL6 interfaceC9664aL6) {
            this.p = interfaceC9664aL6;
        }

        @Override // ir.nasim.InterfaceC21655tu3
        public InterfaceC11734dW3 b(InterfaceC12377eW3 interfaceC12377eW3, ZV3 zv3, long j) {
            long j2;
            AbstractC21430te5 abstractC21430te5L0 = zv3.l0(j);
            if (interfaceC12377eW3.s0()) {
                j2 = C4414Fa3.c((abstractC21430te5L0.P0() << 32) | (abstractC21430te5L0.A0() & 4294967295L));
            } else if (this.o == null) {
                j2 = C4414Fa3.c((abstractC21430te5L0.P0() << 32) | (abstractC21430te5L0.A0() & 4294967295L));
                this.r = C4414Fa3.c((abstractC21430te5L0.P0() << 32) | (abstractC21430te5L0.A0() & 4294967295L));
            } else {
                long jC = C4414Fa3.c((abstractC21430te5L0.P0() << 32) | (abstractC21430te5L0.A0() & 4294967295L));
                C21669tv7.a aVar = this.o;
                AbstractC13042fc3.f(aVar);
                InterfaceC9664aL6 interfaceC9664aL6A = aVar.a(new C0020b(jC), new c(jC));
                this.q.i(interfaceC9664aL6A);
                j2 = ((C4414Fa3) interfaceC9664aL6A.getValue()).j();
                this.r = ((C4414Fa3) interfaceC9664aL6A.getValue()).j();
            }
            return InterfaceC12377eW3.Q1(interfaceC12377eW3, (int) (j2 >> 32), (int) (j2 & 4294967295L), null, new a(abstractC21430te5L0, j2), 4, null);
        }

        @Override // androidx.compose.ui.e.c
        public void g2() {
            super.g2();
            this.r = androidx.compose.animation.a.a;
        }

        public final AnimatedContentTransitionScopeImpl w2() {
            return this.q;
        }

        public final InterfaceC9664aL6 x2() {
            return this.p;
        }

        public final void z2(AnimatedContentTransitionScopeImpl animatedContentTransitionScopeImpl) {
            this.q = animatedContentTransitionScopeImpl;
        }
    }

    public AnimatedContentTransitionScopeImpl(C21669tv7 c21669tv7, InterfaceC12529em interfaceC12529em, EnumC12613eu3 enumC12613eu3) {
        this.a = c21669tv7;
        this.b = interfaceC12529em;
        this.c = enumC12613eu3;
    }

    private static final boolean e(InterfaceC9102Ym4 interfaceC9102Ym4) {
        return ((Boolean) interfaceC9102Ym4.getValue()).booleanValue();
    }

    private static final void f(InterfaceC9102Ym4 interfaceC9102Ym4, boolean z) {
        interfaceC9102Ym4.setValue(Boolean.valueOf(z));
    }

    @Override // ir.nasim.C21669tv7.b
    public Object a() {
        return this.a.m().a();
    }

    @Override // ir.nasim.C21669tv7.b
    public Object b() {
        return this.a.m().b();
    }

    public final androidx.compose.ui.e d(C17312ml1 c17312ml1, InterfaceC22053ub1 interfaceC22053ub1, int i) {
        androidx.compose.ui.e eVar;
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.Q(93755870, i, -1, "androidx.compose.animation.AnimatedContentTransitionScopeImpl.createSizeAnimationModifier (AnimatedContent.kt:556)");
        }
        boolean zV = interfaceC22053ub1.V(this);
        Object objB = interfaceC22053ub1.B();
        C21669tv7.a aVarD = null;
        if (zV || objB == InterfaceC22053ub1.a.a()) {
            objB = AbstractC13472gH6.d(Boolean.FALSE, null, 2, null);
            interfaceC22053ub1.s(objB);
        }
        InterfaceC9102Ym4 interfaceC9102Ym4 = (InterfaceC9102Ym4) objB;
        InterfaceC9664aL6 interfaceC9664aL6Q = AbstractC10222bH6.q(c17312ml1.b(), interfaceC22053ub1, 0);
        if (AbstractC13042fc3.d(this.a.h(), this.a.o())) {
            f(interfaceC9102Ym4, false);
        } else if (interfaceC9664aL6Q.getValue() != null) {
            f(interfaceC9102Ym4, true);
        }
        if (e(interfaceC9102Ym4)) {
            interfaceC22053ub1.W(249676467);
            aVarD = AbstractC4139Dv7.d(this.a, PQ7.g(C4414Fa3.b), null, interfaceC22053ub1, 0, 2);
            boolean zV2 = interfaceC22053ub1.V(aVarD);
            Object objB2 = interfaceC22053ub1.B();
            if (zV2 || objB2 == InterfaceC22053ub1.a.a()) {
                InterfaceC10195bE6 interfaceC10195bE6 = (InterfaceC10195bE6) interfaceC9664aL6Q.getValue();
                objB2 = (interfaceC10195bE6 == null || interfaceC10195bE6.a()) ? FV0.b(androidx.compose.ui.e.a) : androidx.compose.ui.e.a;
                interfaceC22053ub1.s(objB2);
            }
            eVar = (androidx.compose.ui.e) objB2;
            interfaceC22053ub1.Q();
        } else {
            interfaceC22053ub1.W(249942509);
            interfaceC22053ub1.Q();
            this.f = null;
            eVar = androidx.compose.ui.e.a;
        }
        androidx.compose.ui.e eVarI = eVar.i(new SizeModifierElement(aVarD, interfaceC9664aL6Q, this));
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.P();
        }
        return eVarI;
    }

    public InterfaceC12529em g() {
        return this.b;
    }

    public final C7386Rm4 h() {
        return this.e;
    }

    public final void i(InterfaceC9664aL6 interfaceC9664aL6) {
        this.f = interfaceC9664aL6;
    }

    public void j(InterfaceC12529em interfaceC12529em) {
        this.b = interfaceC12529em;
    }

    public final void k(EnumC12613eu3 enumC12613eu3) {
        this.c = enumC12613eu3;
    }

    public final void l(long j) {
        this.d.setValue(C4414Fa3.b(j));
    }

    public static final class a implements InterfaceC24376yW4 {
        private final InterfaceC9102Ym4 b;

        public a(boolean z) {
            this.b = AbstractC13472gH6.d(Boolean.valueOf(z), null, 2, null);
        }

        public final boolean f() {
            return ((Boolean) this.b.getValue()).booleanValue();
        }

        public final void k(boolean z) {
            this.b.setValue(Boolean.valueOf(z));
        }

        @Override // ir.nasim.InterfaceC24376yW4
        public Object C(WH1 wh1, Object obj) {
            return this;
        }
    }
}
