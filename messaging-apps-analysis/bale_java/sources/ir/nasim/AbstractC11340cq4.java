package ir.nasim;

import android.os.Bundle;
import java.util.List;

/* renamed from: ir.nasim.cq4, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public abstract class AbstractC11340cq4 {

    /* renamed from: ir.nasim.cq4$a */
    static final class a implements InterfaceC16978mB2 {
        final /* synthetic */ C8588Wp4 a;

        /* renamed from: ir.nasim.cq4$a$a, reason: collision with other inner class name */
        static final class C0999a implements InterfaceC14603iB2 {
            final /* synthetic */ C8588Wp4 a;
            final /* synthetic */ String b;

            C0999a(C8588Wp4 c8588Wp4, String str) {
                this.a = c8588Wp4;
                this.b = str;
            }

            public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
                if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                    interfaceC22053ub1.L();
                } else {
                    Y8.h(this.a, this.b, interfaceC22053ub1, 0);
                }
            }

            @Override // ir.nasim.InterfaceC14603iB2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
                return C19938rB7.a;
            }
        }

        a(C8588Wp4 c8588Wp4) {
            this.a = c8588Wp4;
        }

        public final void a(InterfaceC5757Ks interfaceC5757Ks, androidx.navigation.d dVar, InterfaceC22053ub1 interfaceC22053ub1, int i) {
            AbstractC13042fc3.i(interfaceC5757Ks, "$this$composable");
            AbstractC13042fc3.i(dVar, "backStackEntry");
            Bundle bundleC = dVar.c();
            String string = bundleC != null ? bundleC.getString("folderName") : null;
            interfaceC22053ub1.W(-593586189);
            Object objB = interfaceC22053ub1.B();
            if (objB == InterfaceC22053ub1.a.a()) {
                objB = new A03();
                interfaceC22053ub1.s(objB);
            }
            interfaceC22053ub1.Q();
            AbstractC11024cc1.a(FN1.c().d((A03) objB), AbstractC19242q11.e(1206379798, true, new C0999a(this.a, string), interfaceC22053ub1, 54), interfaceC22053ub1, C7252Qx5.i | 48);
        }

        @Override // ir.nasim.InterfaceC16978mB2
        public /* bridge */ /* synthetic */ Object e(Object obj, Object obj2, Object obj3, Object obj4) {
            a((InterfaceC5757Ks) obj, (androidx.navigation.d) obj2, (InterfaceC22053ub1) obj3, ((Number) obj4).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.cq4$b */
    static final class b implements InterfaceC16978mB2 {
        final /* synthetic */ C8588Wp4 a;
        final /* synthetic */ Integer b;
        final /* synthetic */ List c;
        final /* synthetic */ UA2 d;

        /* renamed from: ir.nasim.cq4$b$a */
        static final class a implements InterfaceC14603iB2 {
            final /* synthetic */ C8588Wp4 a;
            final /* synthetic */ Integer b;
            final /* synthetic */ List c;
            final /* synthetic */ UA2 d;

            a(C8588Wp4 c8588Wp4, Integer num, List list, UA2 ua2) {
                this.a = c8588Wp4;
                this.b = num;
                this.c = list;
                this.d = ua2;
            }

            public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
                if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                    interfaceC22053ub1.L();
                } else {
                    AbstractC16365l9.v(this.a, this.b, this.c, this.d, interfaceC22053ub1, 0);
                }
            }

            @Override // ir.nasim.InterfaceC14603iB2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
                return C19938rB7.a;
            }
        }

        b(C8588Wp4 c8588Wp4, Integer num, List list, UA2 ua2) {
            this.a = c8588Wp4;
            this.b = num;
            this.c = list;
            this.d = ua2;
        }

        public final void a(InterfaceC5757Ks interfaceC5757Ks, androidx.navigation.d dVar, InterfaceC22053ub1 interfaceC22053ub1, int i) {
            AbstractC13042fc3.i(interfaceC5757Ks, "$this$composable");
            AbstractC13042fc3.i(dVar, "it");
            interfaceC22053ub1.W(1056347565);
            Object objB = interfaceC22053ub1.B();
            if (objB == InterfaceC22053ub1.a.a()) {
                objB = new A03();
                interfaceC22053ub1.s(objB);
            }
            interfaceC22053ub1.Q();
            AbstractC11024cc1.a(FN1.c().d((A03) objB), AbstractC19242q11.e(-1892567864, true, new a(this.a, this.b, this.c, this.d), interfaceC22053ub1, 54), interfaceC22053ub1, C7252Qx5.i | 48);
        }

        @Override // ir.nasim.InterfaceC16978mB2
        public /* bridge */ /* synthetic */ Object e(Object obj, Object obj2, Object obj3, Object obj4) {
            a((InterfaceC5757Ks) obj, (androidx.navigation.d) obj2, (InterfaceC22053ub1) obj3, ((Number) obj4).intValue());
            return C19938rB7.a;
        }
    }

    public static final void b(C8120Up4 c8120Up4, C8588Wp4 c8588Wp4) {
        AbstractC13042fc3.i(c8120Up4, "<this>");
        AbstractC13042fc3.i(c8588Wp4, "navController");
        AbstractC8354Vp4.c(c8120Up4, "addDialog?folderName={folderName}", AbstractC9766aX0.e(AbstractC8345Vo4.a("folderName", new UA2() { // from class: ir.nasim.bq4
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return AbstractC11340cq4.c((androidx.navigation.c) obj);
            }
        })), null, null, null, null, null, AbstractC19242q11.c(-1058881066, true, new a(c8588Wp4)), 124, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 c(androidx.navigation.c cVar) {
        AbstractC13042fc3.i(cVar, "$this$navArgument");
        cVar.d(androidx.navigation.o.m);
        cVar.c(true);
        cVar.b(null);
        return C19938rB7.a;
    }

    public static final void d(C8120Up4 c8120Up4, C8588Wp4 c8588Wp4, Integer num, List list, UA2 ua2) {
        AbstractC13042fc3.i(c8120Up4, "<this>");
        AbstractC13042fc3.i(c8588Wp4, "navController");
        AbstractC13042fc3.i(ua2, "onBackPressedCallback");
        AbstractC8354Vp4.c(c8120Up4, "addFolder", null, null, null, null, null, null, AbstractC19242q11.c(1032986632, true, new b(c8588Wp4, num, list, ua2)), 126, null);
    }
}
