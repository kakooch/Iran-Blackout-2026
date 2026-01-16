package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import androidx.compose.ui.e;
import ir.nasim.InterfaceC12529em;
import ir.nasim.InterfaceC16030kb1;
import ir.nasim.InterfaceC22627vZ4;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;

/* loaded from: classes6.dex */
public abstract class OZ4 {

    static final class a implements InterfaceC15796kB2 {
        final /* synthetic */ UA2 a;

        a(UA2 ua2) {
            this.a = ua2;
        }

        public final void a(InterfaceC6988Pv3 interfaceC6988Pv3, InterfaceC22053ub1 interfaceC22053ub1, int i) {
            AbstractC13042fc3.i(interfaceC6988Pv3, "$this$item");
            if ((i & 17) == 16 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
            } else {
                OZ4.o(this.a, interfaceC22053ub1, 0);
                MY2.b(null, null, 0L, interfaceC22053ub1, 0, 7);
            }
        }

        @Override // ir.nasim.InterfaceC15796kB2
        public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
            a((InterfaceC6988Pv3) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
            return C19938rB7.a;
        }
    }

    public static final class b extends AbstractC8614Ws3 implements UA2 {
        public static final b e = new b();

        public b() {
            super(1);
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Void invoke(Object obj) {
            return null;
        }
    }

    public static final class c extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ UA2 e;
        final /* synthetic */ List f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(UA2 ua2, List list) {
            super(1);
            this.e = ua2;
            this.f = list;
        }

        public final Object a(int i) {
            return this.e.invoke(this.f.get(i));
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            return a(((Number) obj).intValue());
        }
    }

    public static final class d extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ UA2 e;
        final /* synthetic */ List f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(UA2 ua2, List list) {
            super(1);
            this.e = ua2;
            this.f = list;
        }

        public final Object a(int i) {
            return this.e.invoke(this.f.get(i));
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            return a(((Number) obj).intValue());
        }
    }

    public static final class e extends AbstractC8614Ws3 implements InterfaceC16978mB2 {
        final /* synthetic */ List e;
        final /* synthetic */ UA2 f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(List list, UA2 ua2) {
            super(4);
            this.e = list;
            this.f = ua2;
        }

        public final void a(InterfaceC6988Pv3 interfaceC6988Pv3, int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
            int i3;
            if ((i2 & 6) == 0) {
                i3 = (interfaceC22053ub1.V(interfaceC6988Pv3) ? 4 : 2) | i2;
            } else {
                i3 = i2;
            }
            if ((i2 & 48) == 0) {
                i3 |= interfaceC22053ub1.e(i) ? 32 : 16;
            }
            if (!interfaceC22053ub1.o((i3 & 147) != 146, i3 & 1)) {
                interfaceC22053ub1.L();
                return;
            }
            if (AbstractC5138Ib1.I()) {
                AbstractC5138Ib1.Q(-632812321, i3, -1, "androidx.compose.foundation.lazy.items.<anonymous> (LazyDsl.kt:178)");
            }
            UX4 ux4 = (UX4) this.e.get(i);
            interfaceC22053ub1.W(-1554500554);
            OZ4.v(ux4, this.f, interfaceC22053ub1, 0);
            MY2.b(null, null, 0L, interfaceC22053ub1, 0, 7);
            interfaceC22053ub1.Q();
            if (AbstractC5138Ib1.I()) {
                AbstractC5138Ib1.P();
            }
        }

        @Override // ir.nasim.InterfaceC16978mB2
        public /* bridge */ /* synthetic */ Object e(Object obj, Object obj2, Object obj3, Object obj4) {
            a((InterfaceC6988Pv3) obj, ((Number) obj2).intValue(), (InterfaceC22053ub1) obj3, ((Number) obj4).intValue());
            return C19938rB7.a;
        }
    }

    public /* synthetic */ class f {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[EnumC24997zZ4.values().length];
            try {
                iArr[EnumC24997zZ4.a.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[EnumC24997zZ4.b.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            a = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object A(UX4 ux4) {
        AbstractC13042fc3.i(ux4, "it");
        return Integer.valueOf(ux4.a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 B(RZ4 rz4, UA2 ua2, int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
        AbstractC13042fc3.i(rz4, "$state");
        AbstractC13042fc3.i(ua2, "$onViewModelEvent");
        y(rz4, ua2, interfaceC22053ub1, QJ5.a(i | 1));
        return C19938rB7.a;
    }

    private static final void C(final EnumC24997zZ4 enumC24997zZ4, InterfaceC22053ub1 interfaceC22053ub1, final int i) {
        int i2;
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(147745674);
        if ((i & 6) == 0) {
            i2 = (interfaceC22053ub1J.V(enumC24997zZ4) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i2 & 3) == 2 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
        } else {
            int i3 = f.a[enumC24997zZ4.ordinal()];
            if (i3 == 1) {
                interfaceC22053ub1J.W(1085233171);
                CG3.j(androidx.compose.foundation.layout.t.f(androidx.compose.ui.e.a, 0.0f, 1, null), G10.a.a(interfaceC22053ub1J, G10.b).r(), interfaceC22053ub1J, 6, 0);
                interfaceC22053ub1J.Q();
            } else {
                if (i3 != 2) {
                    interfaceC22053ub1J.W(1085230869);
                    interfaceC22053ub1J.Q();
                    throw new NoWhenBranchMatchedException();
                }
                interfaceC22053ub1J.W(1085239419);
                CG3.g(null, null, null, interfaceC22053ub1J, 0, 7);
                interfaceC22053ub1J.Q();
            }
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.BZ4
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return OZ4.D(enumC24997zZ4, i, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 D(EnumC24997zZ4 enumC24997zZ4, int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
        AbstractC13042fc3.i(enumC24997zZ4, "$loadingState");
        C(enumC24997zZ4, interfaceC22053ub1, QJ5.a(i | 1));
        return C19938rB7.a;
    }

    public static final void E(final RZ4 rz4, final C19391qG6 c19391qG6, final UA2 ua2, InterfaceC22053ub1 interfaceC22053ub1, final int i) {
        int i2;
        AbstractC13042fc3.i(rz4, "state");
        AbstractC13042fc3.i(c19391qG6, "snackBarState");
        AbstractC13042fc3.i(ua2, "onViewModelEvent");
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(-1768598416);
        if ((i & 6) == 0) {
            i2 = (interfaceC22053ub1J.D(rz4) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= interfaceC22053ub1J.V(c19391qG6) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= interfaceC22053ub1J.D(ua2) ? 256 : 128;
        }
        if ((i2 & 147) == 146 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
        } else {
            int i3 = i2 & 14;
            int i4 = i2 >> 3;
            int i5 = i4 & SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER;
            y(rz4, ua2, interfaceC22053ub1J, i3 | i5);
            I(c19391qG6, interfaceC22053ub1J, i4 & 14);
            EnumC24997zZ4 enumC24997zZ4F = rz4.f();
            interfaceC22053ub1J.W(-1620068717);
            if (enumC24997zZ4F != null) {
                C(enumC24997zZ4F, interfaceC22053ub1J, 0);
                C19938rB7 c19938rB7 = C19938rB7.a;
            }
            interfaceC22053ub1J.Q();
            EnumC22037uZ4 enumC22037uZ4D = rz4.d();
            if (enumC22037uZ4D != null) {
                r(enumC22037uZ4D, ua2, interfaceC22053ub1J, i5);
            }
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.KZ4
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return OZ4.F(rz4, c19391qG6, ua2, i, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 F(RZ4 rz4, C19391qG6 c19391qG6, UA2 ua2, int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
        AbstractC13042fc3.i(rz4, "$state");
        AbstractC13042fc3.i(c19391qG6, "$snackBarState");
        AbstractC13042fc3.i(ua2, "$onViewModelEvent");
        E(rz4, c19391qG6, ua2, interfaceC22053ub1, QJ5.a(i | 1));
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void G(InterfaceC22053ub1 interfaceC22053ub1, final int i) {
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(-281898818);
        if (i == 0 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
        } else {
            e.a aVar = androidx.compose.ui.e.a;
            InterfaceC10970cW3 interfaceC10970cW3A = XY0.a(C24254yJ.a.h(), InterfaceC12529em.a.k(), interfaceC22053ub1J, 0);
            int iA = AbstractC6797Pa1.a(interfaceC22053ub1J, 0);
            InterfaceC11819dc1 interfaceC11819dc1Q = interfaceC22053ub1J.q();
            androidx.compose.ui.e eVarE = androidx.compose.ui.c.e(interfaceC22053ub1J, aVar);
            InterfaceC16030kb1.a aVar2 = InterfaceC16030kb1.d0;
            SA2 sa2A = aVar2.a();
            if (!(interfaceC22053ub1J.l() instanceof InterfaceC15247jG)) {
                AbstractC6797Pa1.c();
            }
            interfaceC22053ub1J.G();
            if (interfaceC22053ub1J.h()) {
                interfaceC22053ub1J.g(sa2A);
            } else {
                interfaceC22053ub1J.r();
            }
            InterfaceC22053ub1 interfaceC22053ub1A = DG7.a(interfaceC22053ub1J);
            DG7.c(interfaceC22053ub1A, interfaceC10970cW3A, aVar2.e());
            DG7.c(interfaceC22053ub1A, interfaceC11819dc1Q, aVar2.g());
            InterfaceC14603iB2 interfaceC14603iB2B = aVar2.b();
            if (interfaceC22053ub1A.h() || !AbstractC13042fc3.d(interfaceC22053ub1A.B(), Integer.valueOf(iA))) {
                interfaceC22053ub1A.s(Integer.valueOf(iA));
                interfaceC22053ub1A.v(Integer.valueOf(iA), interfaceC14603iB2B);
            }
            DG7.c(interfaceC22053ub1A, eVarE, aVar2.f());
            C9784aZ0 c9784aZ0 = C9784aZ0.a;
            androidx.compose.ui.e eVarJ = androidx.compose.foundation.layout.q.j(aVar, C17784nZ1.q(16), C17784nZ1.q(8));
            int iF = C6399Nk7.b.f();
            String strC = UY6.c(LD5.personal_info_privacy_message, interfaceC22053ub1J, 0);
            G10 g10 = G10.a;
            int i2 = G10.b;
            AbstractC9339Zm7.b(strC, eVarJ, g10.a(interfaceC22053ub1J, i2).B(), 0L, null, null, null, 0L, null, C6399Nk7.h(iF), 0L, 0, false, 0, 0, null, g10.d(interfaceC22053ub1J, i2).b(), interfaceC22053ub1J, 0, 0, 65016);
            MY2.b(androidx.compose.foundation.layout.q.k(aVar, 0.0f, C17784nZ1.q(12), 1, null), EnumC10352bW1.a, 0L, interfaceC22053ub1J, 54, 4);
            interfaceC22053ub1J.u();
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.FZ4
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return OZ4.H(i, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 H(int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
        G(interfaceC22053ub1, QJ5.a(i | 1));
        return C19938rB7.a;
    }

    private static final void I(final C19391qG6 c19391qG6, InterfaceC22053ub1 interfaceC22053ub1, final int i) {
        int i2;
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(-639244206);
        if ((i & 6) == 0) {
            i2 = (interfaceC22053ub1J.V(c19391qG6) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i2 & 3) == 2 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
        } else {
            e.a aVar = androidx.compose.ui.e.a;
            androidx.compose.ui.e eVarF = androidx.compose.foundation.layout.t.f(aVar, 0.0f, 1, null);
            InterfaceC12529em.a aVar2 = InterfaceC12529em.a;
            InterfaceC10970cW3 interfaceC10970cW3G = androidx.compose.foundation.layout.f.g(aVar2.o(), false);
            int iA = AbstractC6797Pa1.a(interfaceC22053ub1J, 0);
            InterfaceC11819dc1 interfaceC11819dc1Q = interfaceC22053ub1J.q();
            androidx.compose.ui.e eVarE = androidx.compose.ui.c.e(interfaceC22053ub1J, eVarF);
            InterfaceC16030kb1.a aVar3 = InterfaceC16030kb1.d0;
            SA2 sa2A = aVar3.a();
            if (!(interfaceC22053ub1J.l() instanceof InterfaceC15247jG)) {
                AbstractC6797Pa1.c();
            }
            interfaceC22053ub1J.G();
            if (interfaceC22053ub1J.h()) {
                interfaceC22053ub1J.g(sa2A);
            } else {
                interfaceC22053ub1J.r();
            }
            InterfaceC22053ub1 interfaceC22053ub1A = DG7.a(interfaceC22053ub1J);
            DG7.c(interfaceC22053ub1A, interfaceC10970cW3G, aVar3.e());
            DG7.c(interfaceC22053ub1A, interfaceC11819dc1Q, aVar3.g());
            InterfaceC14603iB2 interfaceC14603iB2B = aVar3.b();
            if (interfaceC22053ub1A.h() || !AbstractC13042fc3.d(interfaceC22053ub1A.B(), Integer.valueOf(iA))) {
                interfaceC22053ub1A.s(Integer.valueOf(iA));
                interfaceC22053ub1A.v(Integer.valueOf(iA), interfaceC14603iB2B);
            }
            DG7.c(interfaceC22053ub1A, eVarE, aVar3.f());
            AbstractC18209oG6.b(c19391qG6, androidx.compose.foundation.layout.h.a.h(aVar, aVar2.b()), C18120o71.a.b(), interfaceC22053ub1J, (i2 & 14) | 384, 0);
            interfaceC22053ub1J.u();
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.LZ4
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return OZ4.J(c19391qG6, i, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 J(C19391qG6 c19391qG6, int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
        AbstractC13042fc3.i(c19391qG6, "$snackBarState");
        I(c19391qG6, interfaceC22053ub1, QJ5.a(i | 1));
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o(final UA2 ua2, InterfaceC22053ub1 interfaceC22053ub1, final int i) {
        int i2;
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(-263915488);
        if ((i & 6) == 0) {
            i2 = (interfaceC22053ub1J.D(ua2) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i2 & 3) == 2 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
        } else {
            String strC = UY6.c(LD5.remove_groups_info, interfaceC22053ub1J, 0);
            int i3 = AbstractC19936rB5.delete;
            G10 g10 = G10.a;
            int i4 = G10.b;
            C11984ds7 c11984ds7 = new C11984ds7(g10.a(interfaceC22053ub1J, i4).r(), g10.a(interfaceC22053ub1J, i4).t(), g10.a(interfaceC22053ub1J, i4).t(), g10.a(interfaceC22053ub1J, i4).t(), null);
            interfaceC22053ub1J.W(963831945);
            boolean z = (i2 & 14) == 4;
            Object objB = interfaceC22053ub1J.B();
            if (z || objB == InterfaceC22053ub1.a.a()) {
                objB = new SA2() { // from class: ir.nasim.GZ4
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return OZ4.p(ua2);
                    }
                };
                interfaceC22053ub1J.s(objB);
            }
            interfaceC22053ub1J.Q();
            AbstractC16797ls7.i(strC, i3, null, null, null, null, c11984ds7, (SA2) objB, null, false, interfaceC22053ub1J, C11984ds7.f << 18, 828);
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.HZ4
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return OZ4.q(ua2, i, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 p(UA2 ua2) {
        AbstractC13042fc3.i(ua2, "$onViewModelEvent");
        ua2.invoke(InterfaceC22627vZ4.b.a);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 q(UA2 ua2, int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
        AbstractC13042fc3.i(ua2, "$onViewModelEvent");
        o(ua2, interfaceC22053ub1, QJ5.a(i | 1));
        return C19938rB7.a;
    }

    private static final void r(final EnumC22037uZ4 enumC22037uZ4, final UA2 ua2, InterfaceC22053ub1 interfaceC22053ub1, final int i) {
        int i2;
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(-1591667313);
        if ((i & 6) == 0) {
            i2 = (interfaceC22053ub1J.V(enumC22037uZ4) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= interfaceC22053ub1J.D(ua2) ? 32 : 16;
        }
        if ((i2 & 19) == 18 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
        } else {
            if (enumC22037uZ4 != EnumC22037uZ4.a) {
                throw new NoWhenBranchMatchedException();
            }
            interfaceC22053ub1J.W(1776054280);
            int i3 = i2 & SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER;
            boolean z = i3 == 32;
            Object objB = interfaceC22053ub1J.B();
            if (z || objB == InterfaceC22053ub1.a.a()) {
                objB = new SA2() { // from class: ir.nasim.CZ4
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return OZ4.s(ua2);
                    }
                };
                interfaceC22053ub1J.s(objB);
            }
            SA2 sa2 = (SA2) objB;
            interfaceC22053ub1J.Q();
            interfaceC22053ub1J.W(1776058633);
            boolean z2 = i3 == 32;
            Object objB2 = interfaceC22053ub1J.B();
            if (z2 || objB2 == InterfaceC22053ub1.a.a()) {
                objB2 = new SA2() { // from class: ir.nasim.DZ4
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return OZ4.t(ua2);
                    }
                };
                interfaceC22053ub1J.s(objB2);
            }
            interfaceC22053ub1J.Q();
            GH1.c(sa2, (SA2) objB2, interfaceC22053ub1J, 0);
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.EZ4
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return OZ4.u(enumC22037uZ4, ua2, i, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 s(UA2 ua2) {
        AbstractC13042fc3.i(ua2, "$onViewModelEvent");
        ua2.invoke(new InterfaceC22627vZ4.c(true));
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 t(UA2 ua2) {
        AbstractC13042fc3.i(ua2, "$onViewModelEvent");
        ua2.invoke(new InterfaceC22627vZ4.c(false));
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 u(EnumC22037uZ4 enumC22037uZ4, UA2 ua2, int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
        AbstractC13042fc3.i(enumC22037uZ4, "$state1");
        AbstractC13042fc3.i(ua2, "$onViewModelEvent");
        r(enumC22037uZ4, ua2, interfaceC22053ub1, QJ5.a(i | 1));
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v(final UX4 ux4, final UA2 ua2, InterfaceC22053ub1 interfaceC22053ub1, final int i) {
        int i2;
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(-587615911);
        if ((i & 6) == 0) {
            i2 = (interfaceC22053ub1J.D(ux4) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= interfaceC22053ub1J.D(ua2) ? 32 : 16;
        }
        if ((i2 & 19) == 18 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
        } else {
            String strB = ux4.b();
            interfaceC22053ub1J.W(260522671);
            boolean zD = ((i2 & SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER) == 32) | interfaceC22053ub1J.D(ux4);
            Object objB = interfaceC22053ub1J.B();
            if (zD || objB == InterfaceC22053ub1.a.a()) {
                objB = new SA2() { // from class: ir.nasim.IZ4
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return OZ4.w(ua2, ux4);
                    }
                };
                interfaceC22053ub1J.s(objB);
            }
            interfaceC22053ub1J.Q();
            AbstractC16797ls7.j(strB, null, null, null, null, null, null, (SA2) objB, null, interfaceC22053ub1J, 0, 382);
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.JZ4
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return OZ4.x(ux4, ua2, i, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 w(UA2 ua2, UX4 ux4) {
        AbstractC13042fc3.i(ua2, "$onViewModelEvent");
        AbstractC13042fc3.i(ux4, "$group");
        ua2.invoke(new InterfaceC22627vZ4.a(ux4.a()));
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 x(UX4 ux4, UA2 ua2, int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
        AbstractC13042fc3.i(ux4, "$group");
        AbstractC13042fc3.i(ua2, "$onViewModelEvent");
        v(ux4, ua2, interfaceC22053ub1, QJ5.a(i | 1));
        return C19938rB7.a;
    }

    private static final void y(final RZ4 rz4, final UA2 ua2, InterfaceC22053ub1 interfaceC22053ub1, final int i) {
        int i2;
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(-64311179);
        if ((i & 6) == 0) {
            i2 = (interfaceC22053ub1J.D(rz4) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= interfaceC22053ub1J.D(ua2) ? 32 : 16;
        }
        if ((i2 & 19) == 18 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
        } else {
            androidx.compose.ui.e eVarK = androidx.compose.foundation.layout.q.k(androidx.compose.foundation.layout.t.f(androidx.compose.ui.e.a, 0.0f, 1, null), 0.0f, C17784nZ1.q(16), 1, null);
            interfaceC22053ub1J.W(-1463208376);
            boolean zD = interfaceC22053ub1J.D(rz4) | ((i2 & SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER) == 32);
            Object objB = interfaceC22053ub1J.B();
            if (zD || objB == InterfaceC22053ub1.a.a()) {
                objB = new UA2() { // from class: ir.nasim.MZ4
                    @Override // ir.nasim.UA2
                    public final Object invoke(Object obj) {
                        return OZ4.z(rz4, ua2, (InterfaceC15069ix3) obj);
                    }
                };
                interfaceC22053ub1J.s(objB);
            }
            interfaceC22053ub1J.Q();
            AbstractC12623ev3.b(eVarK, null, null, false, null, null, null, false, null, (UA2) objB, interfaceC22053ub1J, 6, 510);
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.NZ4
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return OZ4.B(rz4, ua2, i, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 z(RZ4 rz4, UA2 ua2, InterfaceC15069ix3 interfaceC15069ix3) {
        AbstractC13042fc3.i(rz4, "$state");
        AbstractC13042fc3.i(ua2, "$onViewModelEvent");
        AbstractC13042fc3.i(interfaceC15069ix3, "$this$LazyColumn");
        InterfaceC15069ix3.d(interfaceC15069ix3, null, null, C18120o71.a.a(), 3, null);
        List listE = rz4.e();
        interfaceC15069ix3.a(listE.size(), new c(new UA2() { // from class: ir.nasim.AZ4
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return OZ4.A((UX4) obj);
            }
        }, listE), new d(b.e, listE), AbstractC19242q11.c(-632812321, true, new e(listE, ua2)));
        InterfaceC15069ix3.d(interfaceC15069ix3, null, null, AbstractC19242q11.c(1384518273, true, new a(ua2)), 3, null);
        return C19938rB7.a;
    }
}
