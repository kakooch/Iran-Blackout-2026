package ir.nasim;

import java.util.Arrays;

/* renamed from: ir.nasim.cc1, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC11024cc1 {

    /* renamed from: ir.nasim.cc1$a */
    static final class a extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
        final /* synthetic */ C7252Qx5[] e;
        final /* synthetic */ InterfaceC14603iB2 f;
        final /* synthetic */ int g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(C7252Qx5[] c7252Qx5Arr, InterfaceC14603iB2 interfaceC14603iB2, int i) {
            super(2);
            this.e = c7252Qx5Arr;
            this.f = interfaceC14603iB2;
            this.g = i;
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            C7252Qx5[] c7252Qx5Arr = this.e;
            AbstractC11024cc1.b((C7252Qx5[]) Arrays.copyOf(c7252Qx5Arr, c7252Qx5Arr.length), this.f, interfaceC22053ub1, QJ5.a(this.g | 1));
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.cc1$b */
    static final class b extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
        final /* synthetic */ C7252Qx5 e;
        final /* synthetic */ InterfaceC14603iB2 f;
        final /* synthetic */ int g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(C7252Qx5 c7252Qx5, InterfaceC14603iB2 interfaceC14603iB2, int i) {
            super(2);
            this.e = c7252Qx5;
            this.f = interfaceC14603iB2;
            this.g = i;
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            AbstractC11024cc1.a(this.e, this.f, interfaceC22053ub1, QJ5.a(this.g | 1));
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    public static final void a(C7252Qx5 c7252Qx5, InterfaceC14603iB2 interfaceC14603iB2, InterfaceC22053ub1 interfaceC22053ub1, int i) {
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(-1350970552);
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.Q(-1350970552, i, -1, "androidx.compose.runtime.CompositionLocalProvider (CompositionLocal.kt:381)");
        }
        interfaceC22053ub1J.I(c7252Qx5);
        interfaceC14603iB2.invoke(interfaceC22053ub1J, Integer.valueOf((i >> 3) & 14));
        interfaceC22053ub1J.t();
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.P();
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new b(c7252Qx5, interfaceC14603iB2, i));
        }
    }

    public static final void b(C7252Qx5[] c7252Qx5Arr, InterfaceC14603iB2 interfaceC14603iB2, InterfaceC22053ub1 interfaceC22053ub1, int i) {
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(-1390796515);
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.Q(-1390796515, i, -1, "androidx.compose.runtime.CompositionLocalProvider (CompositionLocal.kt:361)");
        }
        interfaceC22053ub1J.M(c7252Qx5Arr);
        interfaceC14603iB2.invoke(interfaceC22053ub1J, Integer.valueOf((i >> 3) & 14));
        interfaceC22053ub1J.N();
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.P();
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new a(c7252Qx5Arr, interfaceC14603iB2, i));
        }
    }

    public static final AbstractC6535Nx5 c(ZG6 zg6, SA2 sa2) {
        return new C14509i22(zg6, sa2);
    }

    public static /* synthetic */ AbstractC6535Nx5 d(ZG6 zg6, SA2 sa2, int i, Object obj) {
        if ((i & 1) != 0) {
            zg6 = AbstractC10222bH6.s();
        }
        return c(zg6, sa2);
    }

    public static final AbstractC6535Nx5 e(UA2 ua2) {
        return new C21406tc1(ua2);
    }

    public static final AbstractC6535Nx5 f(SA2 sa2) {
        return new C17672nM6(sa2);
    }
}
