package ir.nasim;

import android.content.res.Resources;
import ir.nasim.AbstractC12337eS;

/* renamed from: ir.nasim.eS, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public abstract class AbstractC12337eS {

    /* renamed from: ir.nasim.eS$a */
    static final class a implements InterfaceC16978mB2 {
        final /* synthetic */ EnumC10827cG4 a;
        final /* synthetic */ SA2 b;
        final /* synthetic */ androidx.navigation.e c;
        final /* synthetic */ SA2 d;
        final /* synthetic */ SA2 e;
        final /* synthetic */ TR f;

        a(EnumC10827cG4 enumC10827cG4, SA2 sa2, androidx.navigation.e eVar, SA2 sa22, SA2 sa23, TR tr) {
            this.a = enumC10827cG4;
            this.b = sa2;
            this.c = eVar;
            this.d = sa22;
            this.e = sa23;
            this.f = tr;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 h(androidx.navigation.e eVar) throws Resources.NotFoundException {
            AbstractC13042fc3.i(eVar, "$navController");
            eVar.R(C5057Hs1.a.a(), new UA2() { // from class: ir.nasim.cS
                @Override // ir.nasim.UA2
                public final Object invoke(Object obj) {
                    return AbstractC12337eS.a.i((androidx.navigation.n) obj);
                }
            });
            return C19938rB7.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 i(androidx.navigation.n nVar) {
            AbstractC13042fc3.i(nVar, "$this$navigate");
            nVar.d(C22531vO7.a.a(), new UA2() { // from class: ir.nasim.dS
                @Override // ir.nasim.UA2
                public final Object invoke(Object obj) {
                    return AbstractC12337eS.a.k((C23903xi5) obj);
                }
            });
            return C19938rB7.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 k(C23903xi5 c23903xi5) {
            AbstractC13042fc3.i(c23903xi5, "$this$popUpTo");
            c23903xi5.c(true);
            return C19938rB7.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 n(SA2 sa2) {
            AbstractC13042fc3.i(sa2, "$onUserAuthorized");
            sa2.invoke();
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC16978mB2
        public /* bridge */ /* synthetic */ Object e(Object obj, Object obj2, Object obj3, Object obj4) {
            f((InterfaceC5757Ks) obj, (androidx.navigation.d) obj2, (InterfaceC22053ub1) obj3, ((Number) obj4).intValue());
            return C19938rB7.a;
        }

        public final void f(InterfaceC5757Ks interfaceC5757Ks, androidx.navigation.d dVar, InterfaceC22053ub1 interfaceC22053ub1, int i) {
            AbstractC13042fc3.i(interfaceC5757Ks, "$this$composable");
            AbstractC13042fc3.i(dVar, "it");
            EnumC10827cG4 enumC10827cG4 = this.a;
            SA2 sa2 = this.b;
            interfaceC22053ub1.W(-971983031);
            boolean zD = interfaceC22053ub1.D(this.c);
            final androidx.navigation.e eVar = this.c;
            Object objB = interfaceC22053ub1.B();
            if (zD || objB == InterfaceC22053ub1.a.a()) {
                objB = new SA2() { // from class: ir.nasim.aS
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return AbstractC12337eS.a.h(eVar);
                    }
                };
                interfaceC22053ub1.s(objB);
            }
            SA2 sa22 = (SA2) objB;
            interfaceC22053ub1.Q();
            SA2 sa23 = this.d;
            interfaceC22053ub1.W(-971973582);
            boolean zV = interfaceC22053ub1.V(this.e);
            final SA2 sa24 = this.e;
            Object objB2 = interfaceC22053ub1.B();
            if (zV || objB2 == InterfaceC22053ub1.a.a()) {
                objB2 = new SA2() { // from class: ir.nasim.bS
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return AbstractC12337eS.a.n(sa24);
                    }
                };
                interfaceC22053ub1.s(objB2);
            }
            interfaceC22053ub1.Q();
            XF4.v(enumC10827cG4, null, sa2, sa22, sa23, (SA2) objB2, null, this.f, interfaceC22053ub1, TR.c << 21, 66);
        }
    }

    public static final void c(C8120Up4 c8120Up4, androidx.navigation.e eVar, SA2 sa2, SA2 sa22, SA2 sa23, EnumC10827cG4 enumC10827cG4, TR tr) {
        AbstractC13042fc3.i(c8120Up4, "<this>");
        AbstractC13042fc3.i(eVar, "navController");
        AbstractC13042fc3.i(sa2, "onBackPressed");
        AbstractC13042fc3.i(sa22, "onUserAuthorized");
        AbstractC13042fc3.i(sa23, "onNavigateToValidatePassword");
        AbstractC13042fc3.i(enumC10827cG4, "otpScreenType");
        AbstractC13042fc3.i(tr, "sourceType");
        AbstractC8354Vp4.c(c8120Up4, C12946fS.a.a(), null, null, null, null, null, null, AbstractC19242q11.c(2060637825, true, new a(enumC10827cG4, sa2, eVar, sa23, sa22, tr)), 126, null);
    }

    public static /* synthetic */ void d(C8120Up4 c8120Up4, androidx.navigation.e eVar, SA2 sa2, SA2 sa22, SA2 sa23, EnumC10827cG4 enumC10827cG4, TR tr, int i, Object obj) {
        if ((i & 4) != 0) {
            sa22 = new SA2() { // from class: ir.nasim.YR
                @Override // ir.nasim.SA2
                public final Object invoke() {
                    return AbstractC12337eS.e();
                }
            };
        }
        SA2 sa24 = sa22;
        if ((i & 8) != 0) {
            sa23 = new SA2() { // from class: ir.nasim.ZR
                @Override // ir.nasim.SA2
                public final Object invoke() {
                    return AbstractC12337eS.f();
                }
            };
        }
        SA2 sa25 = sa23;
        if ((i & 16) != 0) {
            enumC10827cG4 = EnumC10827cG4.c;
        }
        c(c8120Up4, eVar, sa2, sa24, sa25, enumC10827cG4, tr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 e() {
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 f() {
        return C19938rB7.a;
    }
}
