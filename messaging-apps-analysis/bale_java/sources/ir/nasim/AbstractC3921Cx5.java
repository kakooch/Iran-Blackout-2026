package ir.nasim;

import ir.nasim.C10647bx5;
import java.util.ArrayList;
import java.util.List;

/* renamed from: ir.nasim.Cx5, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public abstract class AbstractC3921Cx5 {
    public static final C10647bx5 a(C10647bx5 c10647bx5, C7029Py7 c7029Py7) {
        AbstractC13042fc3.i(c10647bx5, "<this>");
        AbstractC13042fc3.i(c7029Py7, "typeTable");
        if (c10647bx5.o0()) {
            return c10647bx5.V();
        }
        if (c10647bx5.p0()) {
            return c7029Py7.a(c10647bx5.W());
        }
        return null;
    }

    public static final C10647bx5 b(C11410cx5 c11410cx5, C7029Py7 c7029Py7) {
        AbstractC13042fc3.i(c11410cx5, "<this>");
        AbstractC13042fc3.i(c7029Py7, "typeTable");
        if (c11410cx5.i0()) {
            C10647bx5 c10647bx5X = c11410cx5.X();
            AbstractC13042fc3.h(c10647bx5X, "expandedType");
            return c10647bx5X;
        }
        if (c11410cx5.j0()) {
            return c7029Py7.a(c11410cx5.Y());
        }
        throw new IllegalStateException("No expandedType in ProtoBuf.TypeAlias".toString());
    }

    public static final C10647bx5 c(C10647bx5 c10647bx5, C7029Py7 c7029Py7) {
        AbstractC13042fc3.i(c10647bx5, "<this>");
        AbstractC13042fc3.i(c7029Py7, "typeTable");
        if (c10647bx5.t0()) {
            return c10647bx5.g0();
        }
        if (c10647bx5.u0()) {
            return c7029Py7.a(c10647bx5.h0());
        }
        return null;
    }

    public static final boolean d(C7950Tw5 c7950Tw5) {
        AbstractC13042fc3.i(c7950Tw5, "<this>");
        return c7950Tw5.s0() || c7950Tw5.t0();
    }

    public static final boolean e(C9193Yw5 c9193Yw5) {
        AbstractC13042fc3.i(c9193Yw5, "<this>");
        return c9193Yw5.p0() || c9193Yw5.q0();
    }

    public static final C10647bx5 f(C10647bx5 c10647bx5, C7029Py7 c7029Py7) {
        AbstractC13042fc3.i(c10647bx5, "<this>");
        AbstractC13042fc3.i(c7029Py7, "typeTable");
        if (c10647bx5.w0()) {
            return c10647bx5.j0();
        }
        if (c10647bx5.x0()) {
            return c7029Py7.a(c10647bx5.k0());
        }
        return null;
    }

    public static final C10647bx5 g(C7950Tw5 c7950Tw5, C7029Py7 c7029Py7) {
        AbstractC13042fc3.i(c7950Tw5, "<this>");
        AbstractC13042fc3.i(c7029Py7, "typeTable");
        if (c7950Tw5.s0()) {
            return c7950Tw5.b0();
        }
        if (c7950Tw5.t0()) {
            return c7029Py7.a(c7950Tw5.c0());
        }
        return null;
    }

    public static final C10647bx5 h(C9193Yw5 c9193Yw5, C7029Py7 c7029Py7) {
        AbstractC13042fc3.i(c9193Yw5, "<this>");
        AbstractC13042fc3.i(c7029Py7, "typeTable");
        if (c9193Yw5.p0()) {
            return c9193Yw5.a0();
        }
        if (c9193Yw5.q0()) {
            return c7029Py7.a(c9193Yw5.b0());
        }
        return null;
    }

    public static final C10647bx5 i(C7950Tw5 c7950Tw5, C7029Py7 c7029Py7) {
        AbstractC13042fc3.i(c7950Tw5, "<this>");
        AbstractC13042fc3.i(c7029Py7, "typeTable");
        if (c7950Tw5.u0()) {
            C10647bx5 c10647bx5E0 = c7950Tw5.e0();
            AbstractC13042fc3.h(c10647bx5E0, "returnType");
            return c10647bx5E0;
        }
        if (c7950Tw5.v0()) {
            return c7029Py7.a(c7950Tw5.f0());
        }
        throw new IllegalStateException("No returnType in ProtoBuf.Function".toString());
    }

    public static final C10647bx5 j(C9193Yw5 c9193Yw5, C7029Py7 c7029Py7) {
        AbstractC13042fc3.i(c9193Yw5, "<this>");
        AbstractC13042fc3.i(c7029Py7, "typeTable");
        if (c9193Yw5.r0()) {
            C10647bx5 c10647bx5C0 = c9193Yw5.c0();
            AbstractC13042fc3.h(c10647bx5C0, "returnType");
            return c10647bx5C0;
        }
        if (c9193Yw5.s0()) {
            return c7029Py7.a(c9193Yw5.e0());
        }
        throw new IllegalStateException("No returnType in ProtoBuf.Property".toString());
    }

    public static final List k(C6526Nw5 c6526Nw5, C7029Py7 c7029Py7) {
        AbstractC13042fc3.i(c6526Nw5, "<this>");
        AbstractC13042fc3.i(c7029Py7, "typeTable");
        List listE0 = c6526Nw5.E0();
        if (!(!listE0.isEmpty())) {
            listE0 = null;
        }
        if (listE0 == null) {
            List listD0 = c6526Nw5.D0();
            AbstractC13042fc3.h(listD0, "supertypeIdList");
            List<Integer> list = listD0;
            listE0 = new ArrayList(AbstractC10976cX0.x(list, 10));
            for (Integer num : list) {
                AbstractC13042fc3.h(num, "it");
                listE0.add(c7029Py7.a(num.intValue()));
            }
        }
        return listE0;
    }

    public static final C10647bx5 l(C10647bx5.b bVar, C7029Py7 c7029Py7) {
        AbstractC13042fc3.i(bVar, "<this>");
        AbstractC13042fc3.i(c7029Py7, "typeTable");
        if (bVar.E()) {
            return bVar.z();
        }
        if (bVar.F()) {
            return c7029Py7.a(bVar.C());
        }
        return null;
    }

    public static final C10647bx5 m(C13280fx5 c13280fx5, C7029Py7 c7029Py7) {
        AbstractC13042fc3.i(c13280fx5, "<this>");
        AbstractC13042fc3.i(c7029Py7, "typeTable");
        if (c13280fx5.W()) {
            C10647bx5 c10647bx5Q = c13280fx5.Q();
            AbstractC13042fc3.h(c10647bx5Q, "type");
            return c10647bx5Q;
        }
        if (c13280fx5.X()) {
            return c7029Py7.a(c13280fx5.R());
        }
        throw new IllegalStateException("No type in ProtoBuf.ValueParameter".toString());
    }

    public static final C10647bx5 n(C11410cx5 c11410cx5, C7029Py7 c7029Py7) {
        AbstractC13042fc3.i(c11410cx5, "<this>");
        AbstractC13042fc3.i(c7029Py7, "typeTable");
        if (c11410cx5.m0()) {
            C10647bx5 c10647bx5F0 = c11410cx5.f0();
            AbstractC13042fc3.h(c10647bx5F0, "underlyingType");
            return c10647bx5F0;
        }
        if (c11410cx5.n0()) {
            return c7029Py7.a(c11410cx5.g0());
        }
        throw new IllegalStateException("No underlyingType in ProtoBuf.TypeAlias".toString());
    }

    public static final List o(C12053dx5 c12053dx5, C7029Py7 c7029Py7) {
        AbstractC13042fc3.i(c12053dx5, "<this>");
        AbstractC13042fc3.i(c7029Py7, "typeTable");
        List listW = c12053dx5.W();
        if (!(!listW.isEmpty())) {
            listW = null;
        }
        if (listW == null) {
            List listV = c12053dx5.V();
            AbstractC13042fc3.h(listV, "upperBoundIdList");
            List<Integer> list = listV;
            listW = new ArrayList(AbstractC10976cX0.x(list, 10));
            for (Integer num : list) {
                AbstractC13042fc3.h(num, "it");
                listW.add(c7029Py7.a(num.intValue()));
            }
        }
        return listW;
    }

    public static final C10647bx5 p(C13280fx5 c13280fx5, C7029Py7 c7029Py7) {
        AbstractC13042fc3.i(c13280fx5, "<this>");
        AbstractC13042fc3.i(c7029Py7, "typeTable");
        if (c13280fx5.Y()) {
            return c13280fx5.S();
        }
        if (c13280fx5.Z()) {
            return c7029Py7.a(c13280fx5.T());
        }
        return null;
    }
}
