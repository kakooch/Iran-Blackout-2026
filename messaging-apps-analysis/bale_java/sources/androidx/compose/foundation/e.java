package androidx.compose.foundation;

import android.view.KeyEvent;
import ir.nasim.AbstractC13780go3;
import ir.nasim.AbstractC18350oW3;
import ir.nasim.AbstractC22775vo3;
import ir.nasim.AbstractC23371wo3;
import ir.nasim.AbstractC23831xb3;
import ir.nasim.AbstractC5138Ib1;
import ir.nasim.AbstractC8614Ws3;
import ir.nasim.AbstractC8931Xv7;
import ir.nasim.B26;
import ir.nasim.C19938rB7;
import ir.nasim.C9663aL5;
import ir.nasim.C9839ae6;
import ir.nasim.InterfaceC15796kB2;
import ir.nasim.InterfaceC16339l63;
import ir.nasim.InterfaceC17521n63;
import ir.nasim.InterfaceC18507om4;
import ir.nasim.InterfaceC22053ub1;
import ir.nasim.InterfaceC8645Wv7;
import ir.nasim.Q93;
import ir.nasim.SA2;
import ir.nasim.T93;
import ir.nasim.UA2;

/* loaded from: classes.dex */
public abstract class e {

    static final class a extends AbstractC8614Ws3 implements InterfaceC15796kB2 {
        final /* synthetic */ boolean e;
        final /* synthetic */ String f;
        final /* synthetic */ B26 g;
        final /* synthetic */ SA2 h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(boolean z, String str, B26 b26, SA2 sa2) {
            super(3);
            this.e = z;
            this.f = str;
            this.g = b26;
            this.h = sa2;
        }

        public final androidx.compose.ui.e a(androidx.compose.ui.e eVar, InterfaceC22053ub1 interfaceC22053ub1, int i) {
            InterfaceC18507om4 interfaceC18507om4;
            interfaceC22053ub1.W(-756081143);
            if (AbstractC5138Ib1.I()) {
                AbstractC5138Ib1.Q(-756081143, i, -1, "androidx.compose.foundation.clickable.<anonymous> (Clickable.kt:120)");
            }
            InterfaceC16339l63 interfaceC16339l63 = (InterfaceC16339l63) interfaceC22053ub1.H(m.a());
            if (interfaceC16339l63 instanceof InterfaceC17521n63) {
                interfaceC22053ub1.W(617653824);
                interfaceC22053ub1.Q();
                interfaceC18507om4 = null;
            } else {
                interfaceC22053ub1.W(617786442);
                Object objB = interfaceC22053ub1.B();
                if (objB == InterfaceC22053ub1.a.a()) {
                    objB = AbstractC23831xb3.a();
                    interfaceC22053ub1.s(objB);
                }
                interfaceC18507om4 = (InterfaceC18507om4) objB;
                interfaceC22053ub1.Q();
            }
            androidx.compose.ui.e eVarC = e.c(androidx.compose.ui.e.a, interfaceC18507om4, interfaceC16339l63, this.e, this.f, this.g, this.h);
            if (AbstractC5138Ib1.I()) {
                AbstractC5138Ib1.P();
            }
            interfaceC22053ub1.Q();
            return eVarC;
        }

        @Override // ir.nasim.InterfaceC15796kB2
        public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
            return a((androidx.compose.ui.e) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
        }
    }

    public static final class b extends AbstractC8614Ws3 implements InterfaceC15796kB2 {
        final /* synthetic */ InterfaceC16339l63 e;
        final /* synthetic */ boolean f;
        final /* synthetic */ String g;
        final /* synthetic */ B26 h;
        final /* synthetic */ SA2 i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(InterfaceC16339l63 interfaceC16339l63, boolean z, String str, B26 b26, SA2 sa2) {
            super(3);
            this.e = interfaceC16339l63;
            this.f = z;
            this.g = str;
            this.h = b26;
            this.i = sa2;
        }

        public final androidx.compose.ui.e a(androidx.compose.ui.e eVar, InterfaceC22053ub1 interfaceC22053ub1, int i) {
            interfaceC22053ub1.W(-1525724089);
            if (AbstractC5138Ib1.I()) {
                AbstractC5138Ib1.Q(-1525724089, i, -1, "androidx.compose.foundation.clickableWithIndicationIfNeeded.<anonymous> (Clickable.kt:473)");
            }
            Object objB = interfaceC22053ub1.B();
            if (objB == InterfaceC22053ub1.a.a()) {
                objB = AbstractC23831xb3.a();
                interfaceC22053ub1.s(objB);
            }
            InterfaceC18507om4 interfaceC18507om4 = (InterfaceC18507om4) objB;
            androidx.compose.ui.e eVarI = m.b(androidx.compose.ui.e.a, interfaceC18507om4, this.e).i(new ClickableElement(interfaceC18507om4, null, this.f, this.g, this.h, this.i, null));
            if (AbstractC5138Ib1.I()) {
                AbstractC5138Ib1.P();
            }
            interfaceC22053ub1.Q();
            return eVarI;
        }

        @Override // ir.nasim.InterfaceC15796kB2
        public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
            return a((androidx.compose.ui.e) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
        }
    }

    public static final class c extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ boolean e;
        final /* synthetic */ String f;
        final /* synthetic */ B26 g;
        final /* synthetic */ SA2 h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(boolean z, String str, B26 b26, SA2 sa2) {
            super(1);
            this.e = z;
            this.f = str;
            this.g = b26;
            this.h = sa2;
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

    static final class d extends AbstractC8614Ws3 implements InterfaceC15796kB2 {
        final /* synthetic */ boolean e;
        final /* synthetic */ String f;
        final /* synthetic */ B26 g;
        final /* synthetic */ String h;
        final /* synthetic */ SA2 i;
        final /* synthetic */ SA2 j;
        final /* synthetic */ boolean k;
        final /* synthetic */ SA2 l;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(boolean z, String str, B26 b26, String str2, SA2 sa2, SA2 sa22, boolean z2, SA2 sa23) {
            super(3);
            this.e = z;
            this.f = str;
            this.g = b26;
            this.h = str2;
            this.i = sa2;
            this.j = sa22;
            this.k = z2;
            this.l = sa23;
        }

        public final androidx.compose.ui.e a(androidx.compose.ui.e eVar, InterfaceC22053ub1 interfaceC22053ub1, int i) {
            InterfaceC18507om4 interfaceC18507om4;
            interfaceC22053ub1.W(-1534186401);
            if (AbstractC5138Ib1.I()) {
                AbstractC5138Ib1.Q(-1534186401, i, -1, "androidx.compose.foundation.combinedClickable.<anonymous> (Clickable.kt:264)");
            }
            InterfaceC16339l63 interfaceC16339l63 = (InterfaceC16339l63) interfaceC22053ub1.H(m.a());
            if (interfaceC16339l63 instanceof InterfaceC17521n63) {
                interfaceC22053ub1.W(-1726068379);
                interfaceC22053ub1.Q();
                interfaceC18507om4 = null;
            } else {
                interfaceC22053ub1.W(-1725935761);
                Object objB = interfaceC22053ub1.B();
                if (objB == InterfaceC22053ub1.a.a()) {
                    objB = AbstractC23831xb3.a();
                    interfaceC22053ub1.s(objB);
                }
                interfaceC18507om4 = (InterfaceC18507om4) objB;
                interfaceC22053ub1.Q();
            }
            androidx.compose.ui.e eVarG = e.g(androidx.compose.ui.e.a, interfaceC18507om4, interfaceC16339l63, this.e, this.f, this.g, this.h, this.i, this.j, this.k, this.l);
            if (AbstractC5138Ib1.I()) {
                AbstractC5138Ib1.P();
            }
            interfaceC22053ub1.Q();
            return eVarG;
        }

        @Override // ir.nasim.InterfaceC15796kB2
        public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
            return a((androidx.compose.ui.e) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
        }
    }

    /* renamed from: androidx.compose.foundation.e$e, reason: collision with other inner class name */
    public static final class C0032e extends AbstractC8614Ws3 implements InterfaceC15796kB2 {
        final /* synthetic */ InterfaceC16339l63 e;
        final /* synthetic */ boolean f;
        final /* synthetic */ String g;
        final /* synthetic */ B26 h;
        final /* synthetic */ SA2 i;
        final /* synthetic */ String j;
        final /* synthetic */ SA2 k;
        final /* synthetic */ SA2 l;
        final /* synthetic */ boolean m;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0032e(InterfaceC16339l63 interfaceC16339l63, boolean z, String str, B26 b26, SA2 sa2, String str2, SA2 sa22, SA2 sa23, boolean z2) {
            super(3);
            this.e = interfaceC16339l63;
            this.f = z;
            this.g = str;
            this.h = b26;
            this.i = sa2;
            this.j = str2;
            this.k = sa22;
            this.l = sa23;
            this.m = z2;
        }

        public final androidx.compose.ui.e a(androidx.compose.ui.e eVar, InterfaceC22053ub1 interfaceC22053ub1, int i) {
            interfaceC22053ub1.W(-1525724089);
            if (AbstractC5138Ib1.I()) {
                AbstractC5138Ib1.Q(-1525724089, i, -1, "androidx.compose.foundation.clickableWithIndicationIfNeeded.<anonymous> (Clickable.kt:473)");
            }
            Object objB = interfaceC22053ub1.B();
            if (objB == InterfaceC22053ub1.a.a()) {
                objB = AbstractC23831xb3.a();
                interfaceC22053ub1.s(objB);
            }
            InterfaceC18507om4 interfaceC18507om4 = (InterfaceC18507om4) objB;
            androidx.compose.ui.e eVarI = m.b(androidx.compose.ui.e.a, interfaceC18507om4, this.e).i(new CombinedClickableElement(interfaceC18507om4, null, this.f, this.g, this.h, this.i, this.j, this.k, this.l, this.m, null));
            if (AbstractC5138Ib1.I()) {
                AbstractC5138Ib1.P();
            }
            interfaceC22053ub1.Q();
            return eVarI;
        }

        @Override // ir.nasim.InterfaceC15796kB2
        public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
            return a((androidx.compose.ui.e) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
        }
    }

    public static final class f extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ boolean e;
        final /* synthetic */ String f;
        final /* synthetic */ B26 g;
        final /* synthetic */ SA2 h;
        final /* synthetic */ SA2 i;
        final /* synthetic */ SA2 j;
        final /* synthetic */ String k;
        final /* synthetic */ boolean l;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(boolean z, String str, B26 b26, SA2 sa2, SA2 sa22, SA2 sa23, String str2, boolean z2) {
            super(1);
            this.e = z;
            this.f = str;
            this.g = b26;
            this.h = sa2;
            this.i = sa22;
            this.j = sa23;
            this.k = str2;
            this.l = z2;
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

    static final class g extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ C9663aL5 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        g(C9663aL5 c9663aL5) {
            super(1);
            this.e = c9663aL5;
        }

        /* JADX WARN: Removed duplicated region for block: B:8:0x0017  */
        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Boolean invoke(ir.nasim.InterfaceC8645Wv7 r4) {
            /*
                r3 = this;
                ir.nasim.aL5 r0 = r3.e
                boolean r1 = r0.a
                r2 = 1
                if (r1 != 0) goto L17
                java.lang.String r1 = "null cannot be cast to non-null type androidx.compose.foundation.gestures.ScrollableContainerNode"
                ir.nasim.AbstractC13042fc3.g(r4, r1)
                ir.nasim.ae6 r4 = (ir.nasim.C9839ae6) r4
                boolean r4 = r4.v2()
                if (r4 == 0) goto L15
                goto L17
            L15:
                r4 = 0
                goto L18
            L17:
                r4 = r2
            L18:
                r0.a = r4
                ir.nasim.aL5 r4 = r3.e
                boolean r4 = r4.a
                r4 = r4 ^ r2
                java.lang.Boolean r4 = java.lang.Boolean.valueOf(r4)
                return r4
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.e.g.invoke(ir.nasim.Wv7):java.lang.Boolean");
        }
    }

    public static final androidx.compose.ui.e c(androidx.compose.ui.e eVar, InterfaceC18507om4 interfaceC18507om4, InterfaceC16339l63 interfaceC16339l63, boolean z, String str, B26 b26, SA2 sa2) {
        androidx.compose.ui.e eVarC;
        if (interfaceC16339l63 instanceof InterfaceC17521n63) {
            eVarC = new ClickableElement(interfaceC18507om4, (InterfaceC17521n63) interfaceC16339l63, z, str, b26, sa2, null);
        } else if (interfaceC16339l63 == null) {
            eVarC = new ClickableElement(interfaceC18507om4, null, z, str, b26, sa2, null);
        } else if (interfaceC18507om4 != null) {
            eVarC = m.b(androidx.compose.ui.e.a, interfaceC18507om4, interfaceC16339l63).i(new ClickableElement(interfaceC18507om4, null, z, str, b26, sa2, null));
        } else {
            eVarC = androidx.compose.ui.c.c(androidx.compose.ui.e.a, null, new b(interfaceC16339l63, z, str, b26, sa2), 1, null);
        }
        return eVar.i(eVarC);
    }

    public static /* synthetic */ androidx.compose.ui.e d(androidx.compose.ui.e eVar, InterfaceC18507om4 interfaceC18507om4, InterfaceC16339l63 interfaceC16339l63, boolean z, String str, B26 b26, SA2 sa2, int i, Object obj) {
        if ((i & 4) != 0) {
            z = true;
        }
        return c(eVar, interfaceC18507om4, interfaceC16339l63, z, (i & 8) != 0 ? null : str, (i & 16) != 0 ? null : b26, sa2);
    }

    public static final androidx.compose.ui.e e(androidx.compose.ui.e eVar, boolean z, String str, B26 b26, SA2 sa2) {
        return androidx.compose.ui.c.b(eVar, Q93.b() ? new c(z, str, b26, sa2) : Q93.a(), new a(z, str, b26, sa2));
    }

    public static /* synthetic */ androidx.compose.ui.e f(androidx.compose.ui.e eVar, boolean z, String str, B26 b26, SA2 sa2, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        if ((i & 2) != 0) {
            str = null;
        }
        if ((i & 4) != 0) {
            b26 = null;
        }
        return e(eVar, z, str, b26, sa2);
    }

    public static final androidx.compose.ui.e g(androidx.compose.ui.e eVar, InterfaceC18507om4 interfaceC18507om4, InterfaceC16339l63 interfaceC16339l63, boolean z, String str, B26 b26, String str2, SA2 sa2, SA2 sa22, boolean z2, SA2 sa23) {
        androidx.compose.ui.e eVarC;
        if (interfaceC16339l63 instanceof InterfaceC17521n63) {
            eVarC = new CombinedClickableElement(interfaceC18507om4, (InterfaceC17521n63) interfaceC16339l63, z, str, b26, sa23, str2, sa2, sa22, z2, null);
        } else if (interfaceC16339l63 == null) {
            eVarC = new CombinedClickableElement(interfaceC18507om4, null, z, str, b26, sa23, str2, sa2, sa22, z2, null);
        } else if (interfaceC18507om4 != null) {
            eVarC = m.b(androidx.compose.ui.e.a, interfaceC18507om4, interfaceC16339l63).i(new CombinedClickableElement(interfaceC18507om4, null, z, str, b26, sa23, str2, sa2, sa22, z2, null));
        } else {
            eVarC = androidx.compose.ui.c.c(androidx.compose.ui.e.a, null, new C0032e(interfaceC16339l63, z, str, b26, sa23, str2, sa2, sa22, z2), 1, null);
        }
        return eVar.i(eVarC);
    }

    public static final androidx.compose.ui.e i(androidx.compose.ui.e eVar, boolean z, String str, B26 b26, String str2, SA2 sa2, SA2 sa22, boolean z2, SA2 sa23) {
        return androidx.compose.ui.c.b(eVar, Q93.b() ? new f(z, str, b26, sa23, sa22, sa2, str2, z2) : Q93.a(), new d(z, str, b26, str2, sa2, sa22, z2, sa23));
    }

    public static final boolean k(InterfaceC8645Wv7 interfaceC8645Wv7) {
        C9663aL5 c9663aL5 = new C9663aL5();
        AbstractC8931Xv7.c(interfaceC8645Wv7, C9839ae6.q, new g(c9663aL5));
        return c9663aL5.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean l(KeyEvent keyEvent) {
        return AbstractC22775vo3.e(AbstractC23371wo3.b(keyEvent), AbstractC22775vo3.a.b()) && m(keyEvent);
    }

    private static final boolean m(KeyEvent keyEvent) {
        long jA = AbstractC23371wo3.a(keyEvent);
        AbstractC13780go3.a aVar = AbstractC13780go3.a;
        if (AbstractC13780go3.o(jA, aVar.b()) ? true : AbstractC13780go3.o(jA, aVar.g()) ? true : AbstractC13780go3.o(jA, aVar.i())) {
            return true;
        }
        return AbstractC13780go3.o(jA, aVar.l());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean n(KeyEvent keyEvent) {
        return AbstractC22775vo3.e(AbstractC23371wo3.b(keyEvent), AbstractC22775vo3.a.a()) && m(keyEvent);
    }
}
