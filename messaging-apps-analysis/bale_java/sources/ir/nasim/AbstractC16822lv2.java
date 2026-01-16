package ir.nasim;

import android.content.res.Resources;
import ir.nasim.AbstractC16822lv2;

/* renamed from: ir.nasim.lv2, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public abstract class AbstractC16822lv2 {

    /* renamed from: ir.nasim.lv2$a */
    static final class a implements InterfaceC16978mB2 {
        final /* synthetic */ SA2 a;
        final /* synthetic */ SA2 b;
        final /* synthetic */ androidx.navigation.e c;
        final /* synthetic */ TR d;

        a(SA2 sa2, SA2 sa22, androidx.navigation.e eVar, TR tr) {
            this.a = sa2;
            this.b = sa22;
            this.c = eVar;
            this.d = tr;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 f(SA2 sa2, androidx.navigation.e eVar) throws Resources.NotFoundException {
            AbstractC13042fc3.i(sa2, "$onDeletePassword");
            AbstractC13042fc3.i(eVar, "$navController");
            sa2.invoke();
            eVar.R(C5057Hs1.a.a(), new UA2() { // from class: ir.nasim.jv2
                @Override // ir.nasim.UA2
                public final Object invoke(Object obj) {
                    return AbstractC16822lv2.a.h((androidx.navigation.n) obj);
                }
            });
            return C19938rB7.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 h(androidx.navigation.n nVar) {
            AbstractC13042fc3.i(nVar, "$this$navigate");
            nVar.d(C18004nv2.a.a(), new UA2() { // from class: ir.nasim.kv2
                @Override // ir.nasim.UA2
                public final Object invoke(Object obj) {
                    return AbstractC16822lv2.a.i((C23903xi5) obj);
                }
            });
            return C19938rB7.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 i(C23903xi5 c23903xi5) {
            AbstractC13042fc3.i(c23903xi5, "$this$popUpTo");
            c23903xi5.c(true);
            return C19938rB7.a;
        }

        public final void d(InterfaceC5757Ks interfaceC5757Ks, androidx.navigation.d dVar, InterfaceC22053ub1 interfaceC22053ub1, int i) {
            AbstractC13042fc3.i(interfaceC5757Ks, "$this$composable");
            AbstractC13042fc3.i(dVar, "it");
            EnumC10827cG4 enumC10827cG4 = EnumC10827cG4.b;
            SA2 sa2 = this.a;
            interfaceC22053ub1.W(-1761311821);
            boolean zV = interfaceC22053ub1.V(this.b) | interfaceC22053ub1.D(this.c);
            final SA2 sa22 = this.b;
            final androidx.navigation.e eVar = this.c;
            Object objB = interfaceC22053ub1.B();
            if (zV || objB == InterfaceC22053ub1.a.a()) {
                objB = new SA2() { // from class: ir.nasim.iv2
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return AbstractC16822lv2.a.f(sa22, eVar);
                    }
                };
                interfaceC22053ub1.s(objB);
            }
            interfaceC22053ub1.Q();
            XF4.v(enumC10827cG4, null, sa2, (SA2) objB, null, null, null, this.d, interfaceC22053ub1, (TR.c << 21) | 6, 114);
        }

        @Override // ir.nasim.InterfaceC16978mB2
        public /* bridge */ /* synthetic */ Object e(Object obj, Object obj2, Object obj3, Object obj4) {
            d((InterfaceC5757Ks) obj, (androidx.navigation.d) obj2, (InterfaceC22053ub1) obj3, ((Number) obj4).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.lv2$b */
    static final class b implements InterfaceC16978mB2 {
        final /* synthetic */ SA2 a;
        final /* synthetic */ SA2 b;
        final /* synthetic */ TR c;

        b(SA2 sa2, SA2 sa22, TR tr) {
            this.a = sa2;
            this.b = sa22;
            this.c = tr;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 c(SA2 sa2) {
            AbstractC13042fc3.i(sa2, "$onPasswordChanged");
            sa2.invoke();
            return C19938rB7.a;
        }

        public final void b(InterfaceC5757Ks interfaceC5757Ks, androidx.navigation.d dVar, InterfaceC22053ub1 interfaceC22053ub1, int i) {
            AbstractC13042fc3.i(interfaceC5757Ks, "$this$composable");
            AbstractC13042fc3.i(dVar, "it");
            SA2 sa2 = this.a;
            interfaceC22053ub1.W(-1761297316);
            boolean zV = interfaceC22053ub1.V(this.b);
            final SA2 sa22 = this.b;
            Object objB = interfaceC22053ub1.B();
            if (zV || objB == InterfaceC22053ub1.a.a()) {
                objB = new SA2() { // from class: ir.nasim.mv2
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return AbstractC16822lv2.b.c(sa22);
                    }
                };
                interfaceC22053ub1.s(objB);
            }
            interfaceC22053ub1.Q();
            AbstractC8612Ws1.k(null, sa2, (SA2) objB, null, null, this.c, interfaceC22053ub1, TR.c << 15, 25);
        }

        @Override // ir.nasim.InterfaceC16978mB2
        public /* bridge */ /* synthetic */ Object e(Object obj, Object obj2, Object obj3, Object obj4) {
            b((InterfaceC5757Ks) obj, (androidx.navigation.d) obj2, (InterfaceC22053ub1) obj3, ((Number) obj4).intValue());
            return C19938rB7.a;
        }
    }

    public static final void a(C8120Up4 c8120Up4, androidx.navigation.e eVar, SA2 sa2, SA2 sa22, TR tr, SA2 sa23) {
        AbstractC13042fc3.i(c8120Up4, "<this>");
        AbstractC13042fc3.i(eVar, "navController");
        AbstractC13042fc3.i(sa2, "onBackPressed");
        AbstractC13042fc3.i(sa22, "onPasswordChanged");
        AbstractC13042fc3.i(tr, "sourceType");
        AbstractC13042fc3.i(sa23, "onDeletePassword");
        AbstractC8354Vp4.c(c8120Up4, C18004nv2.a.a(), null, null, null, null, null, null, AbstractC19242q11.c(-1653182419, true, new a(sa2, sa23, eVar, tr)), 126, null);
        AbstractC8354Vp4.c(c8120Up4, C5057Hs1.a.a(), null, null, null, null, null, null, AbstractC19242q11.c(-427244060, true, new b(sa2, sa22, tr)), 126, null);
    }
}
