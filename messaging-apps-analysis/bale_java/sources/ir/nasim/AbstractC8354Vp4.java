package ir.nasim;

import ir.nasim.C10424bb1;
import ir.nasim.C9804ab1;
import java.util.Iterator;
import java.util.List;

/* renamed from: ir.nasim.Vp4, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC8354Vp4 {

    /* renamed from: ir.nasim.Vp4$a */
    static final class a extends AbstractC8614Ws3 implements InterfaceC16978mB2 {
        final /* synthetic */ InterfaceC15796kB2 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(InterfaceC15796kB2 interfaceC15796kB2) {
            super(4);
            this.e = interfaceC15796kB2;
        }

        public final void a(InterfaceC5757Ks interfaceC5757Ks, androidx.navigation.d dVar, InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if (AbstractC5138Ib1.I()) {
                AbstractC5138Ib1.Q(484185514, i, -1, "androidx.navigation.compose.composable.<anonymous> (NavGraphBuilder.kt:52)");
            }
            this.e.q(dVar, interfaceC22053ub1, 8);
            if (AbstractC5138Ib1.I()) {
                AbstractC5138Ib1.P();
            }
        }

        @Override // ir.nasim.InterfaceC16978mB2
        public /* bridge */ /* synthetic */ Object e(Object obj, Object obj2, Object obj3, Object obj4) {
            a((InterfaceC5757Ks) obj, (androidx.navigation.d) obj2, (InterfaceC22053ub1) obj3, ((Number) obj4).intValue());
            return C19938rB7.a;
        }
    }

    public static final void a(C8120Up4 c8120Up4, String str, List list, List list2, UA2 ua2, UA2 ua22, UA2 ua23, UA2 ua24, InterfaceC16978mB2 interfaceC16978mB2) {
        C10424bb1.b bVar = new C10424bb1.b((C10424bb1) c8120Up4.e().d(C10424bb1.class), interfaceC16978mB2);
        bVar.S(str);
        Iterator it = list.iterator();
        while (it.hasNext()) {
            C8111Uo4 c8111Uo4 = (C8111Uo4) it.next();
            bVar.h(c8111Uo4.a(), c8111Uo4.b());
        }
        Iterator it2 = list2.iterator();
        while (it2.hasNext()) {
            bVar.i((androidx.navigation.g) it2.next());
        }
        bVar.c0(ua2);
        bVar.d0(ua22);
        bVar.f0(ua23);
        bVar.g0(ua24);
        c8120Up4.c(bVar);
    }

    public static final /* synthetic */ void b(C8120Up4 c8120Up4, String str, List list, List list2, InterfaceC15796kB2 interfaceC15796kB2) {
        C10424bb1.b bVar = new C10424bb1.b((C10424bb1) c8120Up4.e().d(C10424bb1.class), AbstractC19242q11.c(484185514, true, new a(interfaceC15796kB2)));
        bVar.S(str);
        Iterator it = list.iterator();
        while (it.hasNext()) {
            C8111Uo4 c8111Uo4 = (C8111Uo4) it.next();
            bVar.h(c8111Uo4.a(), c8111Uo4.b());
        }
        Iterator it2 = list2.iterator();
        while (it2.hasNext()) {
            bVar.i((androidx.navigation.g) it2.next());
        }
        c8120Up4.c(bVar);
    }

    public static /* synthetic */ void c(C8120Up4 c8120Up4, String str, List list, List list2, UA2 ua2, UA2 ua22, UA2 ua23, UA2 ua24, InterfaceC16978mB2 interfaceC16978mB2, int i, Object obj) {
        List listM = (i & 2) != 0 ? AbstractC10360bX0.m() : list;
        List listM2 = (i & 4) != 0 ? AbstractC10360bX0.m() : list2;
        UA2 ua25 = (i & 8) != 0 ? null : ua2;
        UA2 ua26 = (i & 16) != 0 ? null : ua22;
        a(c8120Up4, str, listM, listM2, ua25, ua26, (i & 32) != 0 ? ua25 : ua23, (i & 64) != 0 ? ua26 : ua24, interfaceC16978mB2);
    }

    public static /* synthetic */ void d(C8120Up4 c8120Up4, String str, List list, List list2, InterfaceC15796kB2 interfaceC15796kB2, int i, Object obj) {
        if ((i & 2) != 0) {
            list = AbstractC10360bX0.m();
        }
        if ((i & 4) != 0) {
            list2 = AbstractC10360bX0.m();
        }
        b(c8120Up4, str, list, list2, interfaceC15796kB2);
    }

    public static final void e(C8120Up4 c8120Up4, String str, String str2, List list, List list2, UA2 ua2, UA2 ua22, UA2 ua23, UA2 ua24, UA2 ua25) {
        C8120Up4 c8120Up42 = new C8120Up4(c8120Up4.e(), str, str2);
        ua25.invoke(c8120Up42);
        androidx.navigation.j jVarD = c8120Up42.d();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            C8111Uo4 c8111Uo4 = (C8111Uo4) it.next();
            jVarD.h(c8111Uo4.a(), c8111Uo4.b());
        }
        Iterator it2 = list2.iterator();
        while (it2.hasNext()) {
            jVarD.i((androidx.navigation.g) it2.next());
        }
        if (jVarD instanceof C9804ab1.a) {
            C9804ab1.a aVar = (C9804ab1.a) jVarD;
            aVar.s0(ua2);
            aVar.t0(ua22);
            aVar.u0(ua23);
            aVar.v0(ua24);
        }
        c8120Up4.c(jVarD);
    }

    public static /* synthetic */ void f(C8120Up4 c8120Up4, String str, String str2, List list, List list2, UA2 ua2, UA2 ua22, UA2 ua23, UA2 ua24, UA2 ua25, int i, Object obj) {
        List listM = (i & 4) != 0 ? AbstractC10360bX0.m() : list;
        List listM2 = (i & 8) != 0 ? AbstractC10360bX0.m() : list2;
        UA2 ua26 = (i & 16) != 0 ? null : ua2;
        UA2 ua27 = (i & 32) != 0 ? null : ua22;
        e(c8120Up4, str, str2, listM, listM2, ua26, ua27, (i & 64) != 0 ? ua26 : ua23, (i & 128) != 0 ? ua27 : ua24, ua25);
    }
}
