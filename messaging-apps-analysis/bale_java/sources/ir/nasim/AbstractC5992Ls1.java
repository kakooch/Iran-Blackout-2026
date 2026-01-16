package ir.nasim;

import android.content.res.Resources;
import ir.nasim.AbstractC5992Ls1;
import ir.nasim.C5057Hs1;

/* renamed from: ir.nasim.Ls1, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public abstract class AbstractC5992Ls1 {

    /* renamed from: ir.nasim.Ls1$a */
    static final class a implements InterfaceC16978mB2 {
        final /* synthetic */ SA2 a;
        final /* synthetic */ androidx.navigation.e b;
        final /* synthetic */ boolean c;

        a(SA2 sa2, androidx.navigation.e eVar, boolean z) {
            this.a = sa2;
            this.b = eVar;
            this.c = z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 c(androidx.navigation.e eVar) throws Resources.NotFoundException {
            AbstractC13042fc3.i(eVar, "$navController");
            androidx.navigation.e.S(eVar, C5057Hs1.a.a.a(), null, null, 6, null);
            return C19938rB7.a;
        }

        public final void b(InterfaceC5757Ks interfaceC5757Ks, androidx.navigation.d dVar, InterfaceC22053ub1 interfaceC22053ub1, int i) {
            AbstractC13042fc3.i(interfaceC5757Ks, "$this$composable");
            AbstractC13042fc3.i(dVar, "it");
            SA2 sa2 = this.a;
            interfaceC22053ub1.W(461214104);
            boolean zD = interfaceC22053ub1.D(this.b);
            final androidx.navigation.e eVar = this.b;
            Object objB = interfaceC22053ub1.B();
            if (zD || objB == InterfaceC22053ub1.a.a()) {
                objB = new SA2() { // from class: ir.nasim.Ks1
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return AbstractC5992Ls1.a.c(eVar);
                    }
                };
                interfaceC22053ub1.s(objB);
            }
            interfaceC22053ub1.Q();
            AbstractC4340Es1.e(null, null, sa2, (SA2) objB, this.c, interfaceC22053ub1, 0, 3);
        }

        @Override // ir.nasim.InterfaceC16978mB2
        public /* bridge */ /* synthetic */ Object e(Object obj, Object obj2, Object obj3, Object obj4) {
            b((InterfaceC5757Ks) obj, (androidx.navigation.d) obj2, (InterfaceC22053ub1) obj3, ((Number) obj4).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.Ls1$b */
    static final class b implements InterfaceC16978mB2 {
        final /* synthetic */ boolean a;
        final /* synthetic */ SA2 b;
        final /* synthetic */ androidx.navigation.e c;
        final /* synthetic */ SA2 d;
        final /* synthetic */ TR e;

        b(boolean z, SA2 sa2, androidx.navigation.e eVar, SA2 sa22, TR tr) {
            this.a = z;
            this.b = sa2;
            this.c = eVar;
            this.d = sa22;
            this.e = tr;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 f(boolean z, SA2 sa2, androidx.navigation.e eVar) {
            AbstractC13042fc3.i(sa2, "$onBackPressed");
            AbstractC13042fc3.i(eVar, "$navController");
            if (z) {
                sa2.invoke();
            } else {
                eVar.V();
            }
            return C19938rB7.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 h(SA2 sa2, androidx.navigation.e eVar) {
            AbstractC13042fc3.i(sa2, "$onCompleted");
            AbstractC13042fc3.i(eVar, "$navController");
            sa2.invoke();
            while (eVar.V()) {
            }
            return C19938rB7.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 i(androidx.navigation.e eVar) throws Resources.NotFoundException {
            AbstractC13042fc3.i(eVar, "$navController");
            eVar.V();
            androidx.navigation.e.S(eVar, C12946fS.a.a(), null, null, 6, null);
            return C19938rB7.a;
        }

        public final void d(InterfaceC5757Ks interfaceC5757Ks, androidx.navigation.d dVar, InterfaceC22053ub1 interfaceC22053ub1, int i) {
            AbstractC13042fc3.i(interfaceC5757Ks, "$this$composable");
            AbstractC13042fc3.i(dVar, "it");
            interfaceC22053ub1.W(461228388);
            boolean zA = interfaceC22053ub1.a(this.a) | interfaceC22053ub1.V(this.b) | interfaceC22053ub1.D(this.c);
            final boolean z = this.a;
            final SA2 sa2 = this.b;
            final androidx.navigation.e eVar = this.c;
            Object objB = interfaceC22053ub1.B();
            if (zA || objB == InterfaceC22053ub1.a.a()) {
                objB = new SA2() { // from class: ir.nasim.Ms1
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return AbstractC5992Ls1.b.f(z, sa2, eVar);
                    }
                };
                interfaceC22053ub1.s(objB);
            }
            SA2 sa22 = (SA2) objB;
            interfaceC22053ub1.Q();
            interfaceC22053ub1.W(461223591);
            boolean zV = interfaceC22053ub1.V(this.d) | interfaceC22053ub1.D(this.c);
            final SA2 sa23 = this.d;
            final androidx.navigation.e eVar2 = this.c;
            Object objB2 = interfaceC22053ub1.B();
            if (zV || objB2 == InterfaceC22053ub1.a.a()) {
                objB2 = new SA2() { // from class: ir.nasim.Ns1
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return AbstractC5992Ls1.b.h(sa23, eVar2);
                    }
                };
                interfaceC22053ub1.s(objB2);
            }
            SA2 sa24 = (SA2) objB2;
            interfaceC22053ub1.Q();
            interfaceC22053ub1.W(461237696);
            boolean zD = interfaceC22053ub1.D(this.c);
            final androidx.navigation.e eVar3 = this.c;
            Object objB3 = interfaceC22053ub1.B();
            if (zD || objB3 == InterfaceC22053ub1.a.a()) {
                objB3 = new SA2() { // from class: ir.nasim.Os1
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return AbstractC5992Ls1.b.i(eVar3);
                    }
                };
                interfaceC22053ub1.s(objB3);
            }
            interfaceC22053ub1.Q();
            AbstractC8612Ws1.k(null, sa22, sa24, (SA2) objB3, null, this.e, interfaceC22053ub1, TR.c << 15, 17);
        }

        @Override // ir.nasim.InterfaceC16978mB2
        public /* bridge */ /* synthetic */ Object e(Object obj, Object obj2, Object obj3, Object obj4) {
            d((InterfaceC5757Ks) obj, (androidx.navigation.d) obj2, (InterfaceC22053ub1) obj3, ((Number) obj4).intValue());
            return C19938rB7.a;
        }
    }

    public static final void c(C8120Up4 c8120Up4, final androidx.navigation.e eVar, final boolean z, final SA2 sa2, final SA2 sa22, final TR tr, final boolean z2) {
        AbstractC13042fc3.i(c8120Up4, "<this>");
        AbstractC13042fc3.i(eVar, "navController");
        AbstractC13042fc3.i(sa2, "onBackPressed");
        AbstractC13042fc3.i(sa22, "onCompleted");
        AbstractC13042fc3.i(tr, "sourceType");
        AbstractC8354Vp4.f(c8120Up4, (z ? C5057Hs1.a.a : C5057Hs1.b.a).a(), C5057Hs1.a.a(), null, null, null, null, null, null, new UA2() { // from class: ir.nasim.Is1
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return AbstractC5992Ls1.e(eVar, sa2, tr, z2, z, sa22, (C8120Up4) obj);
            }
        }, 252, null);
    }

    public static /* synthetic */ void d(C8120Up4 c8120Up4, androidx.navigation.e eVar, boolean z, SA2 sa2, SA2 sa22, TR tr, boolean z2, int i, Object obj) {
        if ((i & 32) != 0) {
            z2 = true;
        }
        c(c8120Up4, eVar, z, sa2, sa22, tr, z2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 e(final androidx.navigation.e eVar, SA2 sa2, TR tr, boolean z, boolean z2, final SA2 sa22, C8120Up4 c8120Up4) {
        AbstractC13042fc3.i(eVar, "$navController");
        AbstractC13042fc3.i(sa2, "$onBackPressed");
        AbstractC13042fc3.i(tr, "$sourceType");
        AbstractC13042fc3.i(sa22, "$onCompleted");
        AbstractC13042fc3.i(c8120Up4, "$this$navigation");
        AbstractC8354Vp4.c(c8120Up4, C5057Hs1.b.a.a(), null, null, null, null, null, null, AbstractC19242q11.c(518871467, true, new a(sa2, eVar, z)), 126, null);
        AbstractC8354Vp4.c(c8120Up4, C5057Hs1.a.a.a(), null, null, null, null, null, null, AbstractC19242q11.c(820372898, true, new b(z2, sa2, eVar, sa22, tr)), 126, null);
        AbstractC12337eS.d(c8120Up4, eVar, sa2, new SA2() { // from class: ir.nasim.Js1
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return AbstractC5992Ls1.f(sa22, eVar);
            }
        }, null, EnumC10827cG4.c, tr, 8, null);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 f(SA2 sa2, androidx.navigation.e eVar) {
        AbstractC13042fc3.i(sa2, "$onCompleted");
        AbstractC13042fc3.i(eVar, "$navController");
        sa2.invoke();
        while (eVar.V()) {
        }
        return C19938rB7.a;
    }
}
