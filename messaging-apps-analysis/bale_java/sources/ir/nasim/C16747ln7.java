package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import ir.nasim.AbstractC10274bN4;
import ir.nasim.AbstractC13406gA3;
import ir.nasim.C13245fu;
import ir.nasim.InterfaceC22053ub1;
import java.util.Arrays;
import java.util.List;

/* renamed from: ir.nasim.ln7, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C16747ln7 {
    private final C13245fu a;
    private C13245fu c;
    private final InterfaceC9102Ym4 b = AbstractC13472gH6.d(null, null, 2, null);
    private final C14063hH6 d = AbstractC10222bH6.f();

    /* renamed from: ir.nasim.ln7$a */
    static final class a extends AbstractC8614Ws3 implements UA2 {
        public static final a e = new a();

        a() {
            super(1);
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final List invoke(C13245fu.d dVar) {
            C12863fI6 c12863fI6;
            if (dVar.g() instanceof AbstractC13406gA3) {
                Object objG = dVar.g();
                AbstractC13042fc3.g(objG, "null cannot be cast to non-null type androidx.compose.ui.text.LinkAnnotation");
                if (!AbstractC17338mn7.b(((AbstractC13406gA3) objG).b())) {
                    Object objG2 = dVar.g();
                    AbstractC13042fc3.g(objG2, "null cannot be cast to non-null type androidx.compose.ui.text.LinkAnnotation");
                    C17929nn7 c17929nn7B = ((AbstractC13406gA3) objG2).b();
                    if (c17929nn7B == null || (c12863fI6 = c17929nn7B.d()) == null) {
                        c12863fI6 = new C12863fI6(0L, 0L, (C4593Fu2) null, (C3418Au2) null, (C3657Bu2) null, (AbstractC9998au2) null, (String) null, 0L, (C18413od0) null, (C3590Bm7) null, (IH3) null, 0L, (C24525yl7) null, (C5566Jw6) null, (C19620qf5) null, (AbstractC18051o02) null, 65535, (ED1) null);
                    }
                    return AbstractC10360bX0.g(dVar, new C13245fu.d(c12863fI6, dVar.h(), dVar.f()));
                }
            }
            return AbstractC10360bX0.g(dVar);
        }
    }

    /* renamed from: ir.nasim.ln7$b */
    static final class b extends AbstractC8614Ws3 implements UA2 {
        public static final b e = new b();

        b() {
            super(1);
        }

        public final void a(InterfaceC11943do6 interfaceC11943do6) {
            interfaceC11943do6.f(C8838Xn6.a.w(), C19938rB7.a);
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((InterfaceC11943do6) obj);
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.ln7$c */
    static final class c extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ C13245fu.d f;
        final /* synthetic */ InterfaceC9638aI7 g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(C13245fu.d dVar, InterfaceC9638aI7 interfaceC9638aI7) {
            super(0);
            this.f = dVar;
            this.g = interfaceC9638aI7;
        }

        public final void a() {
            C16747ln7.this.o((AbstractC13406gA3) this.f.g(), this.g);
        }

        @Override // ir.nasim.SA2
        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.ln7$d */
    static final class d extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ MA3 c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(MA3 ma3, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = ma3;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new d(this.c, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                MA3 ma3 = this.c;
                this.b = 1;
                if (ma3.e(this) == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((d) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.ln7$e */
    static final class e extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ C13245fu.d f;
        final /* synthetic */ MA3 g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e(C13245fu.d dVar, MA3 ma3) {
            super(1);
            this.f = dVar;
            this.g = ma3;
        }

        public final void a(C7371Rk7 c7371Rk7) {
            C17929nn7 c17929nn7B;
            C17929nn7 c17929nn7B2;
            C17929nn7 c17929nn7B3;
            C16747ln7 c16747ln7 = C16747ln7.this;
            C17929nn7 c17929nn7B4 = ((AbstractC13406gA3) this.f.g()).b();
            C12863fI6 c12863fI6C = null;
            C12863fI6 c12863fI6P = c16747ln7.p(c16747ln7.p(c17929nn7B4 != null ? c17929nn7B4.d() : null, (!this.g.f() || (c17929nn7B3 = ((AbstractC13406gA3) this.f.g()).b()) == null) ? null : c17929nn7B3.a()), (!this.g.g() || (c17929nn7B2 = ((AbstractC13406gA3) this.f.g()).b()) == null) ? null : c17929nn7B2.b());
            if (this.g.h() && (c17929nn7B = ((AbstractC13406gA3) this.f.g()).b()) != null) {
                c12863fI6C = c17929nn7B.c();
            }
            c7371Rk7.b(this.f, c16747ln7.p(c12863fI6P, c12863fI6C));
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((C7371Rk7) obj);
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.ln7$f */
    static final class f extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
        final /* synthetic */ int f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        f(int i) {
            super(2);
            this.f = i;
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            C16747ln7.this.b(interfaceC22053ub1, QJ5.a(this.f | 1));
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.ln7$g */
    static final class g extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ UA2 f;

        /* renamed from: ir.nasim.ln7$g$a */
        public static final class a implements KV1 {
            final /* synthetic */ C16747ln7 a;
            final /* synthetic */ UA2 b;

            public a(C16747ln7 c16747ln7, UA2 ua2) {
                this.a = c16747ln7;
                this.b = ua2;
            }

            @Override // ir.nasim.KV1
            public void dispose() {
                this.a.d.remove(this.b);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        g(UA2 ua2) {
            super(1);
            this.f = ua2;
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final KV1 invoke(LV1 lv1) {
            C16747ln7.this.d.add(this.f);
            return new a(C16747ln7.this, this.f);
        }
    }

    /* renamed from: ir.nasim.ln7$h */
    static final class h extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
        final /* synthetic */ Object[] f;
        final /* synthetic */ UA2 g;
        final /* synthetic */ int h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        h(Object[] objArr, UA2 ua2, int i) {
            super(2);
            this.f = objArr;
            this.g = ua2;
            this.h = i;
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            C16747ln7 c16747ln7 = C16747ln7.this;
            Object[] objArr = this.f;
            c16747ln7.c(Arrays.copyOf(objArr, objArr.length), this.g, interfaceC22053ub1, QJ5.a(this.h | 1));
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.ln7$i */
    static final class i extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ C13245fu.d f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        i(C13245fu.d dVar) {
            super(1);
            this.f = dVar;
        }

        public final void a(androidx.compose.ui.graphics.c cVar) {
            InterfaceC10031ax6 interfaceC10031ax6S = C16747ln7.this.s(this.f);
            if (interfaceC10031ax6S != null) {
                cVar.V(interfaceC10031ax6S);
                cVar.x(true);
            }
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((androidx.compose.ui.graphics.c) obj);
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.ln7$j */
    public static final class j implements InterfaceC10031ax6 {
        final /* synthetic */ V05 a;

        j(V05 v05) {
            this.a = v05;
        }

        @Override // ir.nasim.InterfaceC10031ax6
        public AbstractC10274bN4 a(long j, EnumC12613eu3 enumC12613eu3, WH1 wh1) {
            return new AbstractC10274bN4.a(this.a);
        }
    }

    /* renamed from: ir.nasim.ln7$k */
    static final class k extends AbstractC8614Ws3 implements SA2 {
        k() {
            super(0);
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke() {
            C13183fn7 c13183fn7L;
            C13245fu c13245fuM = C16747ln7.this.m();
            C13774gn7 c13774gn7N = C16747ln7.this.n();
            return Boolean.valueOf(AbstractC13042fc3.d(c13245fuM, (c13774gn7N == null || (c13183fn7L = c13774gn7N.l()) == null) ? null : c13183fn7L.j()));
        }
    }

    /* renamed from: ir.nasim.ln7$l */
    static final class l extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ C25005za3 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        l(C25005za3 c25005za3) {
            super(0);
            this.e = c25005za3;
        }

        public final long a() {
            return this.e.k();
        }

        @Override // ir.nasim.SA2
        public /* bridge */ /* synthetic */ Object invoke() {
            return C22045ua3.c(a());
        }
    }

    /* renamed from: ir.nasim.ln7$m */
    static final class m extends AbstractC8614Ws3 implements SA2 {
        public static final m e = new m();

        m() {
            super(0);
        }

        public final long a() {
            return C22045ua3.b.b();
        }

        @Override // ir.nasim.SA2
        public /* bridge */ /* synthetic */ Object invoke() {
            return C22045ua3.c(a());
        }
    }

    /* renamed from: ir.nasim.ln7$n */
    static final class n extends AbstractC8614Ws3 implements SA2 {
        public static final n e = new n();

        n() {
            super(0);
        }

        public final long a() {
            return C22045ua3.b.b();
        }

        @Override // ir.nasim.SA2
        public /* bridge */ /* synthetic */ Object invoke() {
            return C22045ua3.c(a());
        }
    }

    public C16747ln7(C13245fu c13245fu) {
        this.a = c13245fu;
        this.c = c13245fu.a(a.e);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void c(Object[] objArr, UA2 ua2, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(-2083052099);
        int i3 = (i2 & 48) == 0 ? (interfaceC22053ub1J.D(ua2) ? 32 : 16) | i2 : i2;
        if ((i2 & 384) == 0) {
            i3 |= interfaceC22053ub1J.D(this) ? 256 : 128;
        }
        interfaceC22053ub1J.F(-416604407, Integer.valueOf(objArr.length));
        for (Object obj : objArr) {
            i3 |= interfaceC22053ub1J.D(obj) ? 4 : 0;
        }
        interfaceC22053ub1J.T();
        if ((i3 & 14) == 0) {
            i3 |= 2;
        }
        if (interfaceC22053ub1J.o((i3 & 147) != 146, i3 & 1)) {
            if (AbstractC5138Ib1.I()) {
                AbstractC5138Ib1.Q(-2083052099, i3, -1, "androidx.compose.foundation.text.TextLinkScope.StyleAnnotation (TextLinkScope.kt:315)");
            }
            C15872kJ6 c15872kJ6 = new C15872kJ6(2);
            c15872kJ6.a(ua2);
            c15872kJ6.b(objArr);
            Object[] objArrD = c15872kJ6.d(new Object[c15872kJ6.c()]);
            boolean zD = interfaceC22053ub1J.D(this) | ((i3 & SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER) == 32);
            Object objB = interfaceC22053ub1J.B();
            if (zD || objB == InterfaceC22053ub1.a.a()) {
                objB = new g(ua2);
                interfaceC22053ub1J.s(objB);
            }
            AbstractC10721c52.d(objArrD, (UA2) objB, interfaceC22053ub1J, 0);
            if (AbstractC5138Ib1.I()) {
                AbstractC5138Ib1.P();
            }
        } else {
            interfaceC22053ub1J.L();
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new h(objArr, ua2, i2));
        }
    }

    private final C13245fu.d j(C13245fu.d dVar, C13774gn7 c13774gn7) {
        int iP = C13774gn7.p(c13774gn7, c13774gn7.n() - 1, false, 2, null);
        if (dVar.h() < iP) {
            return C13245fu.d.e(dVar, null, 0, Math.min(dVar.f(), iP), null, 11, null);
        }
        return null;
    }

    private final androidx.compose.ui.e k(androidx.compose.ui.e eVar, C13245fu.d dVar) {
        return androidx.compose.ui.graphics.b.a(eVar, new i(dVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void o(AbstractC13406gA3 abstractC13406gA3, InterfaceC9638aI7 interfaceC9638aI7) {
        InterfaceC16379lA3 interfaceC16379lA3A;
        C19938rB7 c19938rB7;
        if (!(abstractC13406gA3 instanceof AbstractC13406gA3.b)) {
            if (!(abstractC13406gA3 instanceof AbstractC13406gA3.a) || (interfaceC16379lA3A = abstractC13406gA3.a()) == null) {
                return;
            }
            interfaceC16379lA3A.a(abstractC13406gA3);
            return;
        }
        InterfaceC16379lA3 interfaceC16379lA3A2 = abstractC13406gA3.a();
        if (interfaceC16379lA3A2 != null) {
            interfaceC16379lA3A2.a(abstractC13406gA3);
            c19938rB7 = C19938rB7.a;
        } else {
            c19938rB7 = null;
        }
        if (c19938rB7 == null) {
            try {
                interfaceC9638aI7.a(((AbstractC13406gA3.b) abstractC13406gA3).c());
            } catch (IllegalArgumentException unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final C12863fI6 p(C12863fI6 c12863fI6, C12863fI6 c12863fI62) {
        C12863fI6 c12863fI6Y;
        return (c12863fI6 == null || (c12863fI6Y = c12863fI6.y(c12863fI62)) == null) ? c12863fI62 : c12863fI6Y;
    }

    private final V05 q(C13245fu.d dVar) {
        C13774gn7 c13774gn7N;
        V05 v05Z = null;
        if (((Boolean) l().invoke()).booleanValue() && (c13774gn7N = n()) != null) {
            C13245fu.d dVarJ = j(dVar, c13774gn7N);
            if (dVarJ == null) {
                return null;
            }
            v05Z = c13774gn7N.z(dVarJ.h(), dVarJ.f());
            CK5 ck5D = c13774gn7N.d(dVarJ.h());
            v05Z.j(ZG4.e(ZG4.e((Float.floatToRawIntBits(c13774gn7N.q(dVarJ.h()) == c13774gn7N.q(dVarJ.f() + (-1)) ? Math.min(c13774gn7N.d(dVarJ.f() - 1).i(), ck5D.i()) : 0.0f) << 32) | (Float.floatToRawIntBits(ck5D.l()) & 4294967295L)) ^ (-9223372034707292160L)));
        }
        return v05Z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final InterfaceC10031ax6 s(C13245fu.d dVar) {
        V05 v05Q = q(dVar);
        if (v05Q != null) {
            return new j(v05Q);
        }
        return null;
    }

    private final androidx.compose.ui.e t(androidx.compose.ui.e eVar, final C13245fu.d dVar) {
        return eVar.i(new C5252In7(new InterfaceC5486Jn7() { // from class: ir.nasim.kn7
            @Override // ir.nasim.InterfaceC5486Jn7
            public final C4784Gn7 a(C5018Hn7 c5018Hn7) {
                return C16747ln7.u(this.a, dVar, c5018Hn7);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C4784Gn7 u(C16747ln7 c16747ln7, C13245fu.d dVar, C5018Hn7 c5018Hn7) {
        C13774gn7 c13774gn7N = c16747ln7.n();
        if (c13774gn7N == null) {
            return c5018Hn7.a(0, 0, m.e);
        }
        C13245fu.d dVarJ = c16747ln7.j(dVar, c13774gn7N);
        if (dVarJ == null) {
            return c5018Hn7.a(0, 0, n.e);
        }
        C25005za3 c25005za3B = AbstractC3239Aa3.b(c13774gn7N.z(dVarJ.h(), dVarJ.f()).getBounds());
        return c5018Hn7.a(c25005za3B.l(), c25005za3B.f(), new l(c25005za3B));
    }

    public final void b(InterfaceC22053ub1 interfaceC22053ub1, int i2) {
        int i3;
        char c2;
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(1154651354);
        char c3 = 2;
        if ((i2 & 6) == 0) {
            i3 = (interfaceC22053ub1J.D(this) ? 4 : 2) | i2;
        } else {
            i3 = i2;
        }
        int i4 = 1;
        if (interfaceC22053ub1J.o((i3 & 3) != 2, i3 & 1)) {
            if (AbstractC5138Ib1.I()) {
                AbstractC5138Ib1.Q(1154651354, i3, -1, "androidx.compose.foundation.text.TextLinkScope.LinksComposables (TextLinkScope.kt:214)");
            }
            InterfaceC9638aI7 interfaceC9638aI7 = (InterfaceC9638aI7) interfaceC22053ub1J.H(AbstractC13040fc1.t());
            C13245fu c13245fu = this.c;
            List listE = c13245fu.e(0, c13245fu.length());
            int size = listE.size();
            int i5 = 0;
            while (i5 < size) {
                C13245fu.d dVar = (C13245fu.d) listE.get(i5);
                if (dVar.h() != dVar.f()) {
                    interfaceC22053ub1J.W(1386075176);
                    Object objB = interfaceC22053ub1J.B();
                    InterfaceC22053ub1.a aVar = InterfaceC22053ub1.a;
                    if (objB == aVar.a()) {
                        objB = AbstractC23831xb3.a();
                        interfaceC22053ub1J.s(objB);
                    }
                    InterfaceC18507om4 interfaceC18507om4 = (InterfaceC18507om4) objB;
                    androidx.compose.ui.e eVarB = AbstractC5421Jg5.b(androidx.compose.foundation.k.b(t(AbstractC6919Pn6.d(k(androidx.compose.ui.e.a, dVar), false, b.e, i4, null), dVar), interfaceC18507om4, false, 2, null), InterfaceC4953Hg5.a.b(), false, 2, null);
                    boolean zD = interfaceC22053ub1J.D(this) | interfaceC22053ub1J.V(dVar) | interfaceC22053ub1J.D(interfaceC9638aI7);
                    Object objB2 = interfaceC22053ub1J.B();
                    if (zD || objB2 == aVar.a()) {
                        objB2 = new c(dVar, interfaceC9638aI7);
                        interfaceC22053ub1J.s(objB2);
                    }
                    c2 = 2;
                    androidx.compose.foundation.layout.f.a(androidx.compose.foundation.e.g(eVarB, interfaceC18507om4, null, (444 & 4) != 0, (444 & 8) != 0 ? null : null, (444 & 16) != 0 ? null : null, (444 & 32) != 0 ? null : null, (444 & 64) != 0 ? null : null, (444 & 128) != 0 ? null : null, (444 & 256) != 0, (SA2) objB2), interfaceC22053ub1J, 0);
                    if (AbstractC17338mn7.b(((AbstractC13406gA3) dVar.g()).b())) {
                        interfaceC22053ub1J.W(1388926990);
                        interfaceC22053ub1J.Q();
                    } else {
                        interfaceC22053ub1J.W(1386898319);
                        Object objB3 = interfaceC22053ub1J.B();
                        if (objB3 == aVar.a()) {
                            objB3 = new MA3(interfaceC18507om4);
                            interfaceC22053ub1J.s(objB3);
                        }
                        MA3 ma3 = (MA3) objB3;
                        C19938rB7 c19938rB7 = C19938rB7.a;
                        Object objB4 = interfaceC22053ub1J.B();
                        if (objB4 == aVar.a()) {
                            objB4 = new d(ma3, null);
                            interfaceC22053ub1J.s(objB4);
                        }
                        AbstractC10721c52.e(c19938rB7, (InterfaceC14603iB2) objB4, interfaceC22053ub1J, 6);
                        Boolean boolValueOf = Boolean.valueOf(ma3.g());
                        Boolean boolValueOf2 = Boolean.valueOf(ma3.f());
                        Boolean boolValueOf3 = Boolean.valueOf(ma3.h());
                        C17929nn7 c17929nn7B = ((AbstractC13406gA3) dVar.g()).b();
                        C12863fI6 c12863fI6D = c17929nn7B != null ? c17929nn7B.d() : null;
                        C17929nn7 c17929nn7B2 = ((AbstractC13406gA3) dVar.g()).b();
                        C12863fI6 c12863fI6A = c17929nn7B2 != null ? c17929nn7B2.a() : null;
                        C17929nn7 c17929nn7B3 = ((AbstractC13406gA3) dVar.g()).b();
                        C12863fI6 c12863fI6B = c17929nn7B3 != null ? c17929nn7B3.b() : null;
                        C17929nn7 c17929nn7B4 = ((AbstractC13406gA3) dVar.g()).b();
                        Object[] objArr = {boolValueOf, boolValueOf2, boolValueOf3, c12863fI6D, c12863fI6A, c12863fI6B, c17929nn7B4 != null ? c17929nn7B4.c() : null};
                        boolean zD2 = interfaceC22053ub1J.D(this) | interfaceC22053ub1J.V(dVar);
                        Object objB5 = interfaceC22053ub1J.B();
                        if (zD2 || objB5 == aVar.a()) {
                            objB5 = new e(dVar, ma3);
                            interfaceC22053ub1J.s(objB5);
                        }
                        c(objArr, (UA2) objB5, interfaceC22053ub1J, (i3 << 6) & 896);
                        interfaceC22053ub1J.Q();
                    }
                    interfaceC22053ub1J.Q();
                } else {
                    c2 = c3;
                    interfaceC22053ub1J.W(1388940878);
                    interfaceC22053ub1J.Q();
                }
                i5++;
                c3 = c2;
                i4 = 1;
            }
            if (AbstractC5138Ib1.I()) {
                AbstractC5138Ib1.P();
            }
        } else {
            interfaceC22053ub1J.L();
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new f(i2));
        }
    }

    public final C13245fu i() {
        C13245fu c13245fuA;
        if (this.d.isEmpty()) {
            c13245fuA = this.c;
        } else {
            C7371Rk7 c7371Rk7 = new C7371Rk7(this.c);
            C14063hH6 c14063hH6 = this.d;
            int size = c14063hH6.size();
            for (int i2 = 0; i2 < size; i2++) {
                ((UA2) c14063hH6.get(i2)).invoke(c7371Rk7);
            }
            c13245fuA = c7371Rk7.a();
        }
        this.c = c13245fuA;
        return c13245fuA;
    }

    public final SA2 l() {
        return new k();
    }

    public final C13245fu m() {
        return this.c;
    }

    public final C13774gn7 n() {
        return (C13774gn7) this.b.getValue();
    }

    public final void r(C13774gn7 c13774gn7) {
        this.b.setValue(c13774gn7);
    }
}
