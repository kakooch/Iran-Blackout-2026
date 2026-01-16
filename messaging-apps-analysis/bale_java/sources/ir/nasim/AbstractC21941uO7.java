package ir.nasim;

import android.content.res.Resources;
import ir.nasim.AbstractC21941uO7;

/* renamed from: ir.nasim.uO7, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public abstract class AbstractC21941uO7 {

    /* renamed from: ir.nasim.uO7$a */
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
        public static final C19938rB7 f(androidx.navigation.e eVar) throws Resources.NotFoundException {
            AbstractC13042fc3.i(eVar, "$navController");
            eVar.R(C18004nv2.a.a(), new UA2() { // from class: ir.nasim.sO7
                @Override // ir.nasim.UA2
                public final Object invoke(Object obj) {
                    return AbstractC21941uO7.a.h((androidx.navigation.n) obj);
                }
            });
            return C19938rB7.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 h(androidx.navigation.n nVar) {
            AbstractC13042fc3.i(nVar, "$this$navigate");
            nVar.d(C22531vO7.a.a(), new UA2() { // from class: ir.nasim.tO7
                @Override // ir.nasim.UA2
                public final Object invoke(Object obj) {
                    return AbstractC21941uO7.a.i((C23903xi5) obj);
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
            SA2 sa2 = this.a;
            SA2 sa22 = this.b;
            interfaceC22053ub1.W(646974660);
            boolean zD = interfaceC22053ub1.D(this.c);
            final androidx.navigation.e eVar = this.c;
            Object objB = interfaceC22053ub1.B();
            if (zD || objB == InterfaceC22053ub1.a.a()) {
                objB = new SA2() { // from class: ir.nasim.rO7
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return AbstractC21941uO7.a.f(eVar);
                    }
                };
                interfaceC22053ub1.s(objB);
            }
            interfaceC22053ub1.Q();
            JO7.x(null, sa2, sa22, (SA2) objB, null, this.d, interfaceC22053ub1, TR.c << 15, 17);
        }

        @Override // ir.nasim.InterfaceC16978mB2
        public /* bridge */ /* synthetic */ Object e(Object obj, Object obj2, Object obj3, Object obj4) {
            d((InterfaceC5757Ks) obj, (androidx.navigation.d) obj2, (InterfaceC22053ub1) obj3, ((Number) obj4).intValue());
            return C19938rB7.a;
        }
    }

    public static final void e(C8120Up4 c8120Up4, final androidx.navigation.e eVar, SA2 sa2, SA2 sa22, TR tr, SA2 sa23) {
        AbstractC13042fc3.i(c8120Up4, "<this>");
        AbstractC13042fc3.i(eVar, "navController");
        AbstractC13042fc3.i(sa2, "onBackPressed");
        AbstractC13042fc3.i(sa22, "onValidationCompleted");
        AbstractC13042fc3.i(tr, "sourceType");
        AbstractC13042fc3.i(sa23, "onDeletePassword");
        AbstractC5992Ls1.d(c8120Up4, eVar, true, sa2, sa22, tr, false, 32, null);
        AbstractC16822lv2.a(c8120Up4, eVar, sa2, sa22, tr, sa23);
        AbstractC12337eS.d(c8120Up4, eVar, sa2, null, new SA2() { // from class: ir.nasim.oO7
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return AbstractC21941uO7.h(eVar);
            }
        }, EnumC10827cG4.d, tr, 4, null);
        AbstractC8354Vp4.c(c8120Up4, C22531vO7.a.a(), null, null, null, null, null, null, AbstractC19242q11.c(415231266, true, new a(sa2, sa22, eVar, tr)), 126, null);
    }

    public static /* synthetic */ void f(C8120Up4 c8120Up4, androidx.navigation.e eVar, SA2 sa2, SA2 sa22, TR tr, SA2 sa23, int i, Object obj) {
        if ((i & 16) != 0) {
            sa23 = new SA2() { // from class: ir.nasim.nO7
                @Override // ir.nasim.SA2
                public final Object invoke() {
                    return AbstractC21941uO7.g();
                }
            };
        }
        e(c8120Up4, eVar, sa2, sa22, tr, sa23);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 g() {
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 h(androidx.navigation.e eVar) throws Resources.NotFoundException {
        AbstractC13042fc3.i(eVar, "$navController");
        eVar.R(C22531vO7.a.a(), new UA2() { // from class: ir.nasim.pO7
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return AbstractC21941uO7.i((androidx.navigation.n) obj);
            }
        });
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 i(androidx.navigation.n nVar) {
        AbstractC13042fc3.i(nVar, "$this$navigate");
        nVar.d(C12946fS.a.a(), new UA2() { // from class: ir.nasim.qO7
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return AbstractC21941uO7.j((C23903xi5) obj);
            }
        });
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 j(C23903xi5 c23903xi5) {
        AbstractC13042fc3.i(c23903xi5, "$this$popUpTo");
        c23903xi5.c(true);
        return C19938rB7.a;
    }
}
