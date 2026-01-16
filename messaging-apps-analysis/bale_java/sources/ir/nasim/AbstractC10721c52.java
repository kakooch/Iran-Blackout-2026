package ir.nasim;

import java.util.Arrays;

/* renamed from: ir.nasim.c52, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC10721c52 {
    private static final LV1 a = new LV1();

    public static final void a(Object obj, UA2 ua2, InterfaceC22053ub1 interfaceC22053ub1, int i) {
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.Q(-1371986847, i, -1, "androidx.compose.runtime.DisposableEffect (Effects.kt:148)");
        }
        boolean zV = interfaceC22053ub1.V(obj);
        Object objB = interfaceC22053ub1.B();
        if (zV || objB == InterfaceC22053ub1.a.a()) {
            objB = new JV1(ua2);
            interfaceC22053ub1.s(objB);
        }
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.P();
        }
    }

    public static final void b(Object obj, Object obj2, UA2 ua2, InterfaceC22053ub1 interfaceC22053ub1, int i) {
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.Q(1429097729, i, -1, "androidx.compose.runtime.DisposableEffect (Effects.kt:185)");
        }
        boolean zV = interfaceC22053ub1.V(obj) | interfaceC22053ub1.V(obj2);
        Object objB = interfaceC22053ub1.B();
        if (zV || objB == InterfaceC22053ub1.a.a()) {
            objB = new JV1(ua2);
            interfaceC22053ub1.s(objB);
        }
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.P();
        }
    }

    public static final void c(Object obj, Object obj2, Object obj3, UA2 ua2, InterfaceC22053ub1 interfaceC22053ub1, int i) {
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.Q(-1239538271, i, -1, "androidx.compose.runtime.DisposableEffect (Effects.kt:223)");
        }
        boolean zV = interfaceC22053ub1.V(obj) | interfaceC22053ub1.V(obj2) | interfaceC22053ub1.V(obj3);
        Object objB = interfaceC22053ub1.B();
        if (zV || objB == InterfaceC22053ub1.a.a()) {
            objB = new JV1(ua2);
            interfaceC22053ub1.s(objB);
        }
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.P();
        }
    }

    public static final void d(Object[] objArr, UA2 ua2, InterfaceC22053ub1 interfaceC22053ub1, int i) {
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.Q(-1307627122, i, -1, "androidx.compose.runtime.DisposableEffect (Effects.kt:259)");
        }
        boolean zV = false;
        for (Object obj : Arrays.copyOf(objArr, objArr.length)) {
            zV |= interfaceC22053ub1.V(obj);
        }
        Object objB = interfaceC22053ub1.B();
        if (zV || objB == InterfaceC22053ub1.a.a()) {
            interfaceC22053ub1.s(new JV1(ua2));
        }
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.P();
        }
    }

    public static final void e(Object obj, InterfaceC14603iB2 interfaceC14603iB2, InterfaceC22053ub1 interfaceC22053ub1, int i) {
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.Q(1179185413, i, -1, "androidx.compose.runtime.LaunchedEffect (Effects.kt:316)");
        }
        InterfaceC11938do1 interfaceC11938do1P = interfaceC22053ub1.p();
        boolean zV = interfaceC22053ub1.V(obj);
        Object objB = interfaceC22053ub1.B();
        if (zV || objB == InterfaceC22053ub1.a.a()) {
            objB = new C6736Ot3(interfaceC11938do1P, interfaceC14603iB2);
            interfaceC22053ub1.s(objB);
        }
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.P();
        }
    }

    public static final void f(Object obj, Object obj2, InterfaceC14603iB2 interfaceC14603iB2, InterfaceC22053ub1 interfaceC22053ub1, int i) {
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.Q(590241125, i, -1, "androidx.compose.runtime.LaunchedEffect (Effects.kt:335)");
        }
        InterfaceC11938do1 interfaceC11938do1P = interfaceC22053ub1.p();
        boolean zV = interfaceC22053ub1.V(obj) | interfaceC22053ub1.V(obj2);
        Object objB = interfaceC22053ub1.B();
        if (zV || objB == InterfaceC22053ub1.a.a()) {
            objB = new C6736Ot3(interfaceC11938do1P, interfaceC14603iB2);
            interfaceC22053ub1.s(objB);
        }
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.P();
        }
    }

    public static final void g(Object obj, Object obj2, Object obj3, InterfaceC14603iB2 interfaceC14603iB2, InterfaceC22053ub1 interfaceC22053ub1, int i) {
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.Q(-54093371, i, -1, "androidx.compose.runtime.LaunchedEffect (Effects.kt:354)");
        }
        InterfaceC11938do1 interfaceC11938do1P = interfaceC22053ub1.p();
        boolean zV = interfaceC22053ub1.V(obj) | interfaceC22053ub1.V(obj2) | interfaceC22053ub1.V(obj3);
        Object objB = interfaceC22053ub1.B();
        if (zV || objB == InterfaceC22053ub1.a.a()) {
            objB = new C6736Ot3(interfaceC11938do1P, interfaceC14603iB2);
            interfaceC22053ub1.s(objB);
        }
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.P();
        }
    }

    public static final void h(Object[] objArr, InterfaceC14603iB2 interfaceC14603iB2, InterfaceC22053ub1 interfaceC22053ub1, int i) {
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.Q(-139560008, i, -1, "androidx.compose.runtime.LaunchedEffect (Effects.kt:377)");
        }
        InterfaceC11938do1 interfaceC11938do1P = interfaceC22053ub1.p();
        boolean zV = false;
        for (Object obj : Arrays.copyOf(objArr, objArr.length)) {
            zV |= interfaceC22053ub1.V(obj);
        }
        Object objB = interfaceC22053ub1.B();
        if (zV || objB == InterfaceC22053ub1.a.a()) {
            interfaceC22053ub1.s(new C6736Ot3(interfaceC11938do1P, interfaceC14603iB2));
        }
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.P();
        }
    }

    public static final void i(SA2 sa2, InterfaceC22053ub1 interfaceC22053ub1, int i) {
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.Q(-1288466761, i, -1, "androidx.compose.runtime.SideEffect (Effects.kt:49)");
        }
        interfaceC22053ub1.P(sa2);
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.P();
        }
    }

    public static final InterfaceC20315ro1 k(InterfaceC11938do1 interfaceC11938do1, InterfaceC22053ub1 interfaceC22053ub1) {
        if (interfaceC11938do1.a(InterfaceC13730gj3.n0) == null) {
            return new C10275bN5(interfaceC22053ub1.p(), interfaceC11938do1);
        }
        InterfaceC24075y01 interfaceC24075y01B = AbstractC20267rj3.b(null, 1, null);
        interfaceC24075y01B.e(new IllegalArgumentException("CoroutineContext supplied to rememberCoroutineScope may not include a parent job"));
        return AbstractC20906so1.a(interfaceC24075y01B);
    }
}
