package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import androidx.compose.ui.e;
import ir.nasim.AbstractC9252Zd1;
import ir.nasim.C11044ce1;
import ir.nasim.IY2;
import ir.nasim.InterfaceC12529em;
import ir.nasim.InterfaceC14163hS7;
import ir.nasim.InterfaceC16030kb1;

/* renamed from: ir.nasim.ls7, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public abstract class AbstractC16797ls7 {

    /* renamed from: ir.nasim.ls7$a */
    static final class a implements UA2 {
        final /* synthetic */ AbstractC9252Zd1.b a;

        a(AbstractC9252Zd1.b bVar) {
            this.a = bVar;
        }

        public final void a(C7536Sd1 c7536Sd1) {
            AbstractC13042fc3.i(c7536Sd1, "$this$constrainAs");
            IY2.a.a(c7536Sd1.g(), c7536Sd1.e().e(), 0.0f, 0.0f, 6, null);
            IY2.a.a(c7536Sd1.b(), this.a, 0.0f, 0.0f, 6, null);
            InterfaceC14163hS7.a.a(c7536Sd1.f(), c7536Sd1.e().d(), 0.0f, 0.0f, 6, null);
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((C7536Sd1) obj);
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.ls7$b */
    static final class b implements UA2 {
        final /* synthetic */ AbstractC9252Zd1.b a;
        final /* synthetic */ InterfaceC15796kB2 b;
        final /* synthetic */ C7773Td1 c;

        b(AbstractC9252Zd1.b bVar, InterfaceC15796kB2 interfaceC15796kB2, C7773Td1 c7773Td1) {
            this.a = bVar;
            this.b = interfaceC15796kB2;
            this.c = c7773Td1;
        }

        public final void a(C7536Sd1 c7536Sd1) {
            AbstractC13042fc3.i(c7536Sd1, "$this$constrainAs");
            IY2.a.a(c7536Sd1.g(), c7536Sd1.e().e(), 0.0f, 0.0f, 6, null);
            IY2.a.a(c7536Sd1.b(), this.a, 0.0f, 0.0f, 6, null);
            InterfaceC14163hS7.a.a(c7536Sd1.f(), this.b != null ? this.c.b() : c7536Sd1.e().d(), C17784nZ1.q(this.b != null ? 12 : 0), 0.0f, 4, null);
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((C7536Sd1) obj);
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.ls7$c */
    static final class c implements UA2 {
        final /* synthetic */ AbstractC9252Zd1.b a;

        c(AbstractC9252Zd1.b bVar) {
            this.a = bVar;
        }

        public final void a(C7536Sd1 c7536Sd1) {
            AbstractC13042fc3.i(c7536Sd1, "$this$constrainAs");
            IY2.a.a(c7536Sd1.g(), c7536Sd1.e().e(), 0.0f, 0.0f, 6, null);
            IY2.a.a(c7536Sd1.b(), this.a, 0.0f, 0.0f, 6, null);
            InterfaceC14163hS7.a.a(c7536Sd1.c(), c7536Sd1.e().b(), 0.0f, 0.0f, 6, null);
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((C7536Sd1) obj);
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.ls7$d */
    static final class d implements UA2 {
        final /* synthetic */ AbstractC9252Zd1.b a;
        final /* synthetic */ C7773Td1 b;

        d(AbstractC9252Zd1.b bVar, C7773Td1 c7773Td1) {
            this.a = bVar;
            this.b = c7773Td1;
        }

        public final void a(C7536Sd1 c7536Sd1) {
            AbstractC13042fc3.i(c7536Sd1, "$this$constrainAs");
            IY2.a.a(c7536Sd1.g(), this.a, C17784nZ1.q(4), 0.0f, 4, null);
            InterfaceC14163hS7.a.a(c7536Sd1.c(), c7536Sd1.e().b(), 0.0f, 0.0f, 6, null);
            InterfaceC14163hS7.a.a(c7536Sd1.f(), this.b.d(), 0.0f, 0.0f, 6, null);
            c7536Sd1.h(DT1.a.a());
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((C7536Sd1) obj);
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.ls7$e */
    static final class e implements InterfaceC15796kB2 {
        final /* synthetic */ C11984ds7 a;
        final /* synthetic */ String b;

        e(C11984ds7 c11984ds7, String str) {
            this.a = c11984ds7;
            this.b = str;
        }

        public final void a(androidx.compose.ui.e eVar, InterfaceC22053ub1 interfaceC22053ub1, int i) {
            int i2;
            AbstractC13042fc3.i(eVar, "descriptionModifier");
            if ((i & 6) == 0) {
                i2 = i | (interfaceC22053ub1.V(eVar) ? 4 : 2);
            } else {
                i2 = i;
            }
            if ((i2 & 19) == 18 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
            } else {
                AbstractC9339Zm7.b(this.b, eVar, this.a.d(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, G10.a.d(interfaceC22053ub1, 6).d(), interfaceC22053ub1, (i2 << 3) & SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER, 0, 65528);
            }
        }

        @Override // ir.nasim.InterfaceC15796kB2
        public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
            a((androidx.compose.ui.e) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.ls7$f */
    static final class f implements InterfaceC15796kB2 {
        final /* synthetic */ C11984ds7 a;
        final /* synthetic */ String b;

        f(C11984ds7 c11984ds7, String str) {
            this.a = c11984ds7;
            this.b = str;
        }

        public final void a(androidx.compose.ui.e eVar, InterfaceC22053ub1 interfaceC22053ub1, int i) {
            int i2;
            AbstractC13042fc3.i(eVar, "textModifier");
            if ((i & 6) == 0) {
                i2 = i | (interfaceC22053ub1.V(eVar) ? 4 : 2);
            } else {
                i2 = i;
            }
            if ((i2 & 19) == 18 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
            } else {
                AbstractC9339Zm7.b(this.b, eVar, this.a.f(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, G10.a.d(interfaceC22053ub1, 6).a(), interfaceC22053ub1, (i2 << 3) & SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER, 0, 65528);
            }
        }

        @Override // ir.nasim.InterfaceC15796kB2
        public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
            a((androidx.compose.ui.e) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.ls7$g */
    static final class g implements InterfaceC15796kB2 {
        final /* synthetic */ int a;
        final /* synthetic */ C11984ds7 b;
        final /* synthetic */ boolean c;

        g(int i, C11984ds7 c11984ds7, boolean z) {
            this.a = i;
            this.b = c11984ds7;
            this.c = z;
        }

        public final void a(androidx.compose.ui.e eVar, InterfaceC22053ub1 interfaceC22053ub1, int i) {
            int i2;
            AbstractC13042fc3.i(eVar, "leadingModifier");
            if ((i & 6) == 0) {
                i2 = i | (interfaceC22053ub1.V(eVar) ? 4 : 2);
            } else {
                i2 = i;
            }
            if ((i2 & 19) == 18 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
                return;
            }
            int i3 = this.a;
            C11984ds7 c11984ds7 = this.b;
            boolean z = this.c;
            InterfaceC12529em.a aVar = InterfaceC12529em.a;
            InterfaceC10970cW3 interfaceC10970cW3G = androidx.compose.foundation.layout.f.g(aVar.o(), false);
            int iA = AbstractC6797Pa1.a(interfaceC22053ub1, 0);
            InterfaceC11819dc1 interfaceC11819dc1Q = interfaceC22053ub1.q();
            androidx.compose.ui.e eVarE = androidx.compose.ui.c.e(interfaceC22053ub1, eVar);
            InterfaceC16030kb1.a aVar2 = InterfaceC16030kb1.d0;
            SA2 sa2A = aVar2.a();
            if (!(interfaceC22053ub1.l() instanceof InterfaceC15247jG)) {
                AbstractC6797Pa1.c();
            }
            interfaceC22053ub1.G();
            if (interfaceC22053ub1.h()) {
                interfaceC22053ub1.g(sa2A);
            } else {
                interfaceC22053ub1.r();
            }
            InterfaceC22053ub1 interfaceC22053ub1A = DG7.a(interfaceC22053ub1);
            DG7.c(interfaceC22053ub1A, interfaceC10970cW3G, aVar2.e());
            DG7.c(interfaceC22053ub1A, interfaceC11819dc1Q, aVar2.g());
            InterfaceC14603iB2 interfaceC14603iB2B = aVar2.b();
            if (interfaceC22053ub1A.h() || !AbstractC13042fc3.d(interfaceC22053ub1A.B(), Integer.valueOf(iA))) {
                interfaceC22053ub1A.s(Integer.valueOf(iA));
                interfaceC22053ub1A.v(Integer.valueOf(iA), interfaceC14603iB2B);
            }
            DG7.c(interfaceC22053ub1A, eVarE, aVar2.f());
            androidx.compose.foundation.layout.h hVar = androidx.compose.foundation.layout.h.a;
            AbstractC24077y03.b(FV4.c(i3, interfaceC22053ub1, 0), null, androidx.compose.foundation.layout.t.t(eVar, C17784nZ1.q(24)), c11984ds7.e(), interfaceC22053ub1, 48, 0);
            interfaceC22053ub1.W(1121563448);
            if (z) {
                AbstractC16797ls7.o(hVar.h(androidx.compose.ui.e.a, aVar.n()), 0L, interfaceC22053ub1, 0, 2);
            }
            interfaceC22053ub1.Q();
            interfaceC22053ub1.u();
        }

        @Override // ir.nasim.InterfaceC15796kB2
        public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
            a((androidx.compose.ui.e) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.ls7$h */
    static final class h implements InterfaceC15796kB2 {
        final /* synthetic */ C11984ds7 a;
        final /* synthetic */ String b;

        h(C11984ds7 c11984ds7, String str) {
            this.a = c11984ds7;
            this.b = str;
        }

        public final void a(androidx.compose.ui.e eVar, InterfaceC22053ub1 interfaceC22053ub1, int i) {
            int i2;
            AbstractC13042fc3.i(eVar, "descriptionModifier");
            if ((i & 6) == 0) {
                i2 = i | (interfaceC22053ub1.V(eVar) ? 4 : 2);
            } else {
                i2 = i;
            }
            if ((i2 & 19) == 18 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
            } else {
                AbstractC9339Zm7.b(this.b, eVar, this.a.d(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, G10.a.d(interfaceC22053ub1, 6).d(), interfaceC22053ub1, (i2 << 3) & SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER, 0, 65528);
            }
        }

        @Override // ir.nasim.InterfaceC15796kB2
        public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
            a((androidx.compose.ui.e) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.ls7$i */
    static final class i implements InterfaceC15796kB2 {
        final /* synthetic */ C11984ds7 a;
        final /* synthetic */ String b;

        i(C11984ds7 c11984ds7, String str) {
            this.a = c11984ds7;
            this.b = str;
        }

        public final void a(androidx.compose.ui.e eVar, InterfaceC22053ub1 interfaceC22053ub1, int i) {
            int i2;
            AbstractC13042fc3.i(eVar, "textModifier");
            if ((i & 6) == 0) {
                i2 = i | (interfaceC22053ub1.V(eVar) ? 4 : 2);
            } else {
                i2 = i;
            }
            if ((i2 & 19) == 18 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
            } else {
                AbstractC9339Zm7.b(this.b, eVar, this.a.f(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, G10.a.d(interfaceC22053ub1, 6).a(), interfaceC22053ub1, (i2 << 3) & SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER, 0, 65528);
            }
        }

        @Override // ir.nasim.InterfaceC15796kB2
        public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
            a((androidx.compose.ui.e) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.ls7$j */
    public static final class j extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ C15395jW3 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public j(C15395jW3 c15395jW3) {
            super(1);
            this.e = c15395jW3;
        }

        public final void a(InterfaceC11943do6 interfaceC11943do6) {
            AbstractC13042fc3.i(interfaceC11943do6, "$this$semantics");
            AbstractC5756Kr7.a(interfaceC11943do6, this.e);
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((InterfaceC11943do6) obj);
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.ls7$k */
    public static final class k extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
        final /* synthetic */ int e;
        final /* synthetic */ C11044ce1 f;
        final /* synthetic */ SA2 g;
        final /* synthetic */ InterfaceC15796kB2 h;
        final /* synthetic */ int i;
        final /* synthetic */ InterfaceC15796kB2 j;
        final /* synthetic */ InterfaceC22053ub1 k;
        final /* synthetic */ InterfaceC15796kB2 l;
        final /* synthetic */ InterfaceC15796kB2 m;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public k(C11044ce1 c11044ce1, int i, SA2 sa2, InterfaceC15796kB2 interfaceC15796kB2, int i2, InterfaceC15796kB2 interfaceC15796kB22, InterfaceC22053ub1 interfaceC22053ub1, InterfaceC15796kB2 interfaceC15796kB23, InterfaceC15796kB2 interfaceC15796kB24) {
            super(2);
            this.f = c11044ce1;
            this.g = sa2;
            this.h = interfaceC15796kB2;
            this.i = i2;
            this.j = interfaceC15796kB22;
            this.k = interfaceC22053ub1;
            this.l = interfaceC15796kB23;
            this.m = interfaceC15796kB24;
            this.e = i;
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if (((i & 11) ^ 2) == 0 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
                return;
            }
            int iF = this.f.f();
            this.f.g();
            C11044ce1 c11044ce1 = this.f;
            interfaceC22053ub1.W(406108496);
            C11044ce1.b bVarK = c11044ce1.k();
            C7773Td1 c7773Td1A = bVarK.a();
            C7773Td1 c7773Td1B = bVarK.b();
            C7773Td1 c7773Td1C = bVarK.c();
            C7773Td1 c7773Td1D = bVarK.d();
            AbstractC9252Zd1.b bVarC = AbstractC9252Zd1.c(c11044ce1, new C7773Td1[]{c7773Td1A, c7773Td1B, c7773Td1D}, 0.0f, 2, null);
            interfaceC22053ub1.W(1121483678);
            InterfaceC15796kB2 interfaceC15796kB2 = this.h;
            if (interfaceC15796kB2 != null) {
                e.a aVar = androidx.compose.ui.e.a;
                interfaceC22053ub1.W(1121486081);
                boolean zV = interfaceC22053ub1.V(bVarC);
                Object objB = interfaceC22053ub1.B();
                if (zV || objB == InterfaceC22053ub1.a.a()) {
                    objB = new a(bVarC);
                    interfaceC22053ub1.s(objB);
                }
                interfaceC22053ub1.Q();
                interfaceC15796kB2.q(c11044ce1.i(aVar, c7773Td1A, (UA2) objB), interfaceC22053ub1, Integer.valueOf((this.i >> 9) & SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER));
            }
            interfaceC22053ub1.Q();
            InterfaceC15796kB2 interfaceC15796kB22 = this.j;
            e.a aVar2 = androidx.compose.ui.e.a;
            interfaceC22053ub1.W(1121494608);
            boolean zV2 = this.k.V(bVarC) | ((this.i & 57344) == 16384) | this.k.V(c7773Td1A);
            Object objB2 = interfaceC22053ub1.B();
            if (zV2 || objB2 == InterfaceC22053ub1.a.a()) {
                objB2 = new b(bVarC, this.h, c7773Td1A);
                interfaceC22053ub1.s(objB2);
            }
            interfaceC22053ub1.Q();
            interfaceC15796kB22.q(c11044ce1.i(aVar2, c7773Td1B, (UA2) objB2), interfaceC22053ub1, Integer.valueOf((this.i << 3) & SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER));
            interfaceC22053ub1.W(1121506070);
            InterfaceC15796kB2 interfaceC15796kB23 = this.l;
            if (interfaceC15796kB23 != null) {
                interfaceC22053ub1.W(1121507853);
                boolean zV3 = interfaceC22053ub1.V(bVarC);
                Object objB3 = interfaceC22053ub1.B();
                if (zV3 || objB3 == InterfaceC22053ub1.a.a()) {
                    objB3 = new c(bVarC);
                    interfaceC22053ub1.s(objB3);
                }
                interfaceC22053ub1.Q();
                interfaceC15796kB23.q(c11044ce1.i(aVar2, c7773Td1D, (UA2) objB3), interfaceC22053ub1, Integer.valueOf((this.i >> 12) & SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER));
            }
            interfaceC22053ub1.Q();
            interfaceC22053ub1.W(1121514426);
            InterfaceC15796kB2 interfaceC15796kB24 = this.m;
            if (interfaceC15796kB24 != null) {
                interfaceC22053ub1.W(1121516302);
                boolean zV4 = interfaceC22053ub1.V(bVarC) | interfaceC22053ub1.V(c7773Td1B);
                Object objB4 = interfaceC22053ub1.B();
                if (zV4 || objB4 == InterfaceC22053ub1.a.a()) {
                    objB4 = new d(bVarC, c7773Td1B);
                    interfaceC22053ub1.s(objB4);
                }
                interfaceC22053ub1.Q();
                interfaceC15796kB24.q(c11044ce1.i(aVar2, c7773Td1C, (UA2) objB4), interfaceC22053ub1, Integer.valueOf((this.i >> 6) & SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER));
            }
            interfaceC22053ub1.Q();
            interfaceC22053ub1.Q();
            if (this.f.f() != iF) {
                this.g.invoke();
            }
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x011f  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0137  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0172  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x0174  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0178  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x017d  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x0193  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x0196  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x0199  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x019b  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x019f  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x01a1  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x01a7  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x01b3  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x01b6  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x01b8  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x01bc  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x01cc  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x01fb  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x01fe  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x0276  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x0282  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x0286  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x02b3  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x02ea  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x0304  */
    /* JADX WARN: Removed duplicated region for block: B:179:0x031e  */
    /* JADX WARN: Removed duplicated region for block: B:183:0x03a1  */
    /* JADX WARN: Removed duplicated region for block: B:185:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00e4  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0102  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void h(final ir.nasim.InterfaceC15796kB2 r34, androidx.compose.ui.e r35, ir.nasim.TS4 r36, ir.nasim.InterfaceC15796kB2 r37, ir.nasim.InterfaceC15796kB2 r38, ir.nasim.InterfaceC15796kB2 r39, ir.nasim.C11984ds7 r40, ir.nasim.SA2 r41, ir.nasim.SA2 r42, ir.nasim.InterfaceC22053ub1 r43, final int r44, final int r45) {
        /*
            Method dump skipped, instructions count: 945
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC16797ls7.h(ir.nasim.kB2, androidx.compose.ui.e, ir.nasim.TS4, ir.nasim.kB2, ir.nasim.kB2, ir.nasim.kB2, ir.nasim.ds7, ir.nasim.SA2, ir.nasim.SA2, ir.nasim.ub1, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x010c  */
    /* JADX WARN: Removed duplicated region for block: B:102:0x0111  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x012e  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x0148  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x0179  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x017b  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x017e  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x0185  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x019a  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x019e  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x01a1  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x01a5  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x01a8  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x01ae  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x01b9  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x01bc  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x01c0  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x01c3  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x01c7  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x01c9  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x01d8  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x01dd  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x0248  */
    /* JADX WARN: Removed duplicated region for block: B:162:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x00ee  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x00f3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void i(final java.lang.String r26, final int r27, androidx.compose.ui.e r28, ir.nasim.TS4 r29, java.lang.String r30, ir.nasim.InterfaceC15796kB2 r31, ir.nasim.C11984ds7 r32, ir.nasim.SA2 r33, ir.nasim.SA2 r34, boolean r35, ir.nasim.InterfaceC22053ub1 r36, final int r37, final int r38) {
        /*
            Method dump skipped, instructions count: 602
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC16797ls7.i(java.lang.String, int, androidx.compose.ui.e, ir.nasim.TS4, java.lang.String, ir.nasim.kB2, ir.nasim.ds7, ir.nasim.SA2, ir.nasim.SA2, boolean, ir.nasim.ub1, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x0114  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x012d  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x015e  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x0160  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0163  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0169  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x017e  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x0182  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x0185  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x0189  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x018d  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x0193  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x019e  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x01a1  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x01a4  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x01a8  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x01ae  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x01c0  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x01c3  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x0223  */
    /* JADX WARN: Removed duplicated region for block: B:151:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x00f7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void j(final java.lang.String r25, androidx.compose.ui.e r26, ir.nasim.TS4 r27, java.lang.String r28, ir.nasim.InterfaceC15796kB2 r29, ir.nasim.InterfaceC15796kB2 r30, ir.nasim.C11984ds7 r31, ir.nasim.SA2 r32, ir.nasim.SA2 r33, ir.nasim.InterfaceC22053ub1 r34, final int r35, final int r36) {
        /*
            Method dump skipped, instructions count: 563
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC16797ls7.j(java.lang.String, androidx.compose.ui.e, ir.nasim.TS4, java.lang.String, ir.nasim.kB2, ir.nasim.kB2, ir.nasim.ds7, ir.nasim.SA2, ir.nasim.SA2, ir.nasim.ub1, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 k(String str, int i2, androidx.compose.ui.e eVar, TS4 ts4, String str2, InterfaceC15796kB2 interfaceC15796kB2, C11984ds7 c11984ds7, SA2 sa2, SA2 sa22, boolean z, int i3, int i4, InterfaceC22053ub1 interfaceC22053ub1, int i5) {
        AbstractC13042fc3.i(str, "$title");
        i(str, i2, eVar, ts4, str2, interfaceC15796kB2, c11984ds7, sa2, sa22, z, interfaceC22053ub1, QJ5.a(i3 | 1), i4);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 l(String str, androidx.compose.ui.e eVar, TS4 ts4, String str2, InterfaceC15796kB2 interfaceC15796kB2, InterfaceC15796kB2 interfaceC15796kB22, C11984ds7 c11984ds7, SA2 sa2, SA2 sa22, int i2, int i3, InterfaceC22053ub1 interfaceC22053ub1, int i4) {
        AbstractC13042fc3.i(str, "$title");
        j(str, eVar, ts4, str2, interfaceC15796kB2, interfaceC15796kB22, c11984ds7, sa2, sa22, interfaceC22053ub1, QJ5.a(i2 | 1), i3);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 m() {
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 n(InterfaceC15796kB2 interfaceC15796kB2, androidx.compose.ui.e eVar, TS4 ts4, InterfaceC15796kB2 interfaceC15796kB22, InterfaceC15796kB2 interfaceC15796kB23, InterfaceC15796kB2 interfaceC15796kB24, C11984ds7 c11984ds7, SA2 sa2, SA2 sa22, int i2, int i3, InterfaceC22053ub1 interfaceC22053ub1, int i4) {
        AbstractC13042fc3.i(interfaceC15796kB2, "$title");
        h(interfaceC15796kB2, eVar, ts4, interfaceC15796kB22, interfaceC15796kB23, interfaceC15796kB24, c11984ds7, sa2, sa22, interfaceC22053ub1, QJ5.a(i2 | 1), i3);
        return C19938rB7.a;
    }

    /* JADX WARN: Removed duplicated region for block: B:54:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00af  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void o(androidx.compose.ui.e r9, long r10, ir.nasim.InterfaceC22053ub1 r12, final int r13, final int r14) {
        /*
            Method dump skipped, instructions count: 210
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC16797ls7.o(androidx.compose.ui.e, long, ir.nasim.ub1, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 p(long j2, InterfaceC17460n02 interfaceC17460n02) {
        AbstractC13042fc3.i(interfaceC17460n02, "$this$Canvas");
        InterfaceC17460n02.L(interfaceC17460n02, j2, OD6.h(interfaceC17460n02.d()) / 2, 0L, 0.0f, null, null, 0, 124, null);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 q(androidx.compose.ui.e eVar, long j2, int i2, int i3, InterfaceC22053ub1 interfaceC22053ub1, int i4) {
        o(eVar, j2, interfaceC22053ub1, QJ5.a(i2 | 1), i3);
        return C19938rB7.a;
    }

    public static final void r(InterfaceC22053ub1 interfaceC22053ub1, final int i2) {
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(-821068579);
        if (i2 == 0 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
        } else {
            M10.f(false, C18975pa1.a.b(), interfaceC22053ub1J, 48, 1);
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.es7
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return AbstractC16797ls7.s(i2, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 s(int i2, InterfaceC22053ub1 interfaceC22053ub1, int i3) {
        r(interfaceC22053ub1, QJ5.a(i2 | 1));
        return C19938rB7.a;
    }
}
