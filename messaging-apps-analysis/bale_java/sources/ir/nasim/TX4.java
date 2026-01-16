package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import androidx.compose.ui.e;
import ir.nasim.AbstractC11684dQ7;
import ir.nasim.AbstractC14472hy4;
import ir.nasim.C24254yJ;
import ir.nasim.DX4;
import ir.nasim.EX4;
import ir.nasim.G45;
import ir.nasim.InterfaceC16030kb1;
import ir.nasim.InterfaceC22053ub1;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;

/* loaded from: classes6.dex */
public abstract class TX4 {

    static final class a implements InterfaceC15796kB2 {
        final /* synthetic */ C13245fu a;

        a(C13245fu c13245fu) {
            this.a = c13245fu;
        }

        public final void a(InterfaceC6988Pv3 interfaceC6988Pv3, InterfaceC22053ub1 interfaceC22053ub1, int i) {
            AbstractC13042fc3.i(interfaceC6988Pv3, "$this$item");
            if ((i & 17) == 16 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
                return;
            }
            androidx.compose.ui.e eVarJ = androidx.compose.foundation.layout.q.j(androidx.compose.ui.e.a, C17784nZ1.q(16), C17784nZ1.q(8));
            int iF = C6399Nk7.b.f();
            C23546x62 c23546x62 = new C23546x62(this.a, null, 2, null);
            G10 g10 = G10.a;
            int i2 = G10.b;
            C62.d(c23546x62, eVarJ, g10.a(interfaceC22053ub1, i2).B(), 0L, null, null, null, 0L, null, C6399Nk7.h(iF), 0L, 0, false, 0, 0, null, g10.d(interfaceC22053ub1, i2).b(), 0, null, interfaceC22053ub1, 0, 0, 458232);
        }

        @Override // ir.nasim.InterfaceC15796kB2
        public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
            a((InterfaceC6988Pv3) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
            return C19938rB7.a;
        }
    }

    static final class b implements InterfaceC15796kB2 {
        final /* synthetic */ String a;

        b(String str) {
            this.a = str;
        }

        public final void a(InterfaceC6988Pv3 interfaceC6988Pv3, InterfaceC22053ub1 interfaceC22053ub1, int i) {
            AbstractC13042fc3.i(interfaceC6988Pv3, "$this$item");
            if ((i & 17) == 16 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
            } else {
                AbstractC9459a00.c(null, this.a, null, interfaceC22053ub1, 0, 5);
            }
        }

        @Override // ir.nasim.InterfaceC15796kB2
        public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
            a((InterfaceC6988Pv3) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
            return C19938rB7.a;
        }
    }

    public /* synthetic */ class c {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[EnumC14492i05.values().length];
            try {
                iArr[EnumC14492i05.b.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[EnumC14492i05.c.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            a = iArr;
        }
    }

    public static final class d extends AbstractC8614Ws3 implements UA2 {
        public static final d e = new d();

        public d() {
            super(1);
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Void invoke(Object obj) {
            return null;
        }
    }

    public static final class e extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ UA2 e;
        final /* synthetic */ List f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(UA2 ua2, List list) {
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

    public static final class f extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ UA2 e;
        final /* synthetic */ List f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(UA2 ua2, List list) {
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

    public static final class g extends AbstractC8614Ws3 implements InterfaceC16978mB2 {
        final /* synthetic */ List e;
        final /* synthetic */ C19186pv2 f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(List list, C19186pv2 c19186pv2) {
            super(4);
            this.e = list;
            this.f = c19186pv2;
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
            BX4 bx4 = (BX4) this.e.get(i);
            interfaceC22053ub1.W(1632708910);
            EX4 ex4I = bx4.i();
            if (ex4I instanceof EX4.a) {
                interfaceC22053ub1.W(-224424630);
                TX4.n(bx4, (EX4.a) ex4I, this.f.a(), interfaceC22053ub1, 0);
                interfaceC22053ub1.Q();
            } else if (ex4I instanceof EX4.b) {
                interfaceC22053ub1.W(-224419353);
                TX4.r(bx4, (EX4.b) ex4I, this.f.b(), interfaceC22053ub1, 0);
                interfaceC22053ub1.Q();
            } else if (ex4I instanceof EX4.c) {
                interfaceC22053ub1.W(-224414235);
                TX4.C(bx4, (EX4.c) ex4I, this.f.b(), interfaceC22053ub1, 0);
                interfaceC22053ub1.Q();
            } else {
                if (!(ex4I instanceof EX4.d)) {
                    interfaceC22053ub1.W(-224426635);
                    interfaceC22053ub1.Q();
                    throw new NoWhenBranchMatchedException();
                }
                interfaceC22053ub1.W(1633253486);
                interfaceC22053ub1.Q();
            }
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

    /* JADX WARN: Removed duplicated region for block: B:36:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00e5  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00f1  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00f5  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0122  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0152  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0155  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x01aa  */
    /* JADX WARN: Removed duplicated region for block: B:84:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static final void A(final ir.nasim.BX4 r34, final java.lang.String r35, final ir.nasim.UA2 r36, final ir.nasim.C21605tp3 r37, int r38, ir.nasim.InterfaceC22053ub1 r39, final int r40, final int r41) {
        /*
            Method dump skipped, instructions count: 448
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.TX4.A(ir.nasim.BX4, java.lang.String, ir.nasim.UA2, ir.nasim.tp3, int, ir.nasim.ub1, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 B(BX4 bx4, String str, UA2 ua2, C21605tp3 c21605tp3, int i, int i2, int i3, InterfaceC22053ub1 interfaceC22053ub1, int i4) {
        AbstractC13042fc3.i(bx4, "$field");
        AbstractC13042fc3.i(str, "$value");
        AbstractC13042fc3.i(ua2, "$onValueChanged");
        AbstractC13042fc3.i(c21605tp3, "$keyboardOptions");
        A(bx4, str, ua2, c21605tp3, i, interfaceC22053ub1, QJ5.a(i2 | 1), i3);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void C(final BX4 bx4, final EX4.c cVar, final InterfaceC14603iB2 interfaceC14603iB2, InterfaceC22053ub1 interfaceC22053ub1, final int i) {
        int i2;
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(1827952100);
        if ((i & 6) == 0) {
            i2 = (interfaceC22053ub1J.D(bx4) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= interfaceC22053ub1J.D(cVar) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= interfaceC22053ub1J.D(interfaceC14603iB2) ? 256 : 128;
        }
        if ((i2 & 147) == 146 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
        } else {
            Object[] objArr = new Object[0];
            interfaceC22053ub1J.W(1815378124);
            boolean zD = interfaceC22053ub1J.D(cVar);
            Object objB = interfaceC22053ub1J.B();
            if (zD || objB == InterfaceC22053ub1.a.a()) {
                objB = new SA2() { // from class: ir.nasim.NX4
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return TX4.D(cVar);
                    }
                };
                interfaceC22053ub1J.s(objB);
            }
            interfaceC22053ub1J.Q();
            final InterfaceC9102Ym4 interfaceC9102Ym4 = (InterfaceC9102Ym4) AbstractC9681aN5.e(objArr, null, null, (SA2) objB, interfaceC22053ub1J, 0, 6);
            String strE = E(interfaceC9102Ym4);
            int i3 = cVar.e() == EnumC14492i05.c ? 3 : 1;
            EnumC14492i05 enumC14492i05E = cVar.e();
            int i4 = enumC14492i05E == null ? -1 : c.a[enumC14492i05E.ordinal()];
            C21605tp3 c21605tp3 = i4 != 1 ? i4 != 2 ? new C21605tp3(0, null, C22785vp3.b.h(), S33.b.d(), null, null, null, 115, null) : new C21605tp3(0, null, C22785vp3.b.h(), S33.b.a(), null, null, null, 115, null) : new C21605tp3(0, null, C22785vp3.b.d(), S33.b.d(), null, null, null, 115, null);
            interfaceC22053ub1J.W(1815383509);
            boolean zV = interfaceC22053ub1J.V(interfaceC9102Ym4) | ((i2 & 896) == 256) | interfaceC22053ub1J.D(bx4) | interfaceC22053ub1J.D(cVar);
            Object objB2 = interfaceC22053ub1J.B();
            if (zV || objB2 == InterfaceC22053ub1.a.a()) {
                objB2 = new UA2() { // from class: ir.nasim.OX4
                    @Override // ir.nasim.UA2
                    public final Object invoke(Object obj) {
                        return TX4.G(interfaceC14603iB2, bx4, cVar, interfaceC9102Ym4, (String) obj);
                    }
                };
                interfaceC22053ub1J.s(objB2);
            }
            interfaceC22053ub1J.Q();
            A(bx4, strE, (UA2) objB2, c21605tp3, i3, interfaceC22053ub1J, i2 & 14, 0);
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.PX4
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return TX4.H(bx4, cVar, interfaceC14603iB2, i, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final InterfaceC9102Ym4 D(EX4.c cVar) {
        AbstractC13042fc3.i(cVar, "$fieldType");
        String strH = cVar.h();
        if (strH == null) {
            strH = "";
        }
        return AbstractC13472gH6.d(strH, null, 2, null);
    }

    private static final String E(InterfaceC9102Ym4 interfaceC9102Ym4) {
        return (String) interfaceC9102Ym4.getValue();
    }

    private static final void F(InterfaceC9102Ym4 interfaceC9102Ym4, String str) {
        interfaceC9102Ym4.setValue(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 G(InterfaceC14603iB2 interfaceC14603iB2, BX4 bx4, EX4.c cVar, InterfaceC9102Ym4 interfaceC9102Ym4, String str) {
        AbstractC13042fc3.i(interfaceC14603iB2, "$onFieldChanged");
        AbstractC13042fc3.i(bx4, "$field");
        AbstractC13042fc3.i(cVar, "$fieldType");
        AbstractC13042fc3.i(interfaceC9102Ym4, "$value$delegate");
        AbstractC13042fc3.i(str, "newValue");
        F(interfaceC9102Ym4, str);
        interfaceC14603iB2.invoke(bx4, EX4.c.b(cVar, E(interfaceC9102Ym4), null, null, null, null, null, 62, null));
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 H(BX4 bx4, EX4.c cVar, InterfaceC14603iB2 interfaceC14603iB2, int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
        AbstractC13042fc3.i(bx4, "$field");
        AbstractC13042fc3.i(cVar, "$fieldType");
        AbstractC13042fc3.i(interfaceC14603iB2, "$onFieldChanged");
        C(bx4, cVar, interfaceC14603iB2, interfaceC22053ub1, QJ5.a(i | 1));
        return C19938rB7.a;
    }

    private static final void L(InterfaceC15069ix3 interfaceC15069ix3, List list, C19186pv2 c19186pv2) {
        interfaceC15069ix3.a(list.size(), new e(new UA2() { // from class: ir.nasim.GX4
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return TX4.M((BX4) obj);
            }
        }, list), new f(d.e, list), AbstractC19242q11.c(-632812321, true, new g(list, c19186pv2)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object M(BX4 bx4) {
        AbstractC13042fc3.i(bx4, "it");
        return Integer.valueOf(bx4.d());
    }

    private static final String N(AbstractC11684dQ7 abstractC11684dQ7, InterfaceC22053ub1 interfaceC22053ub1, int i) {
        String strA;
        interfaceC22053ub1.W(169125995);
        if (abstractC11684dQ7 instanceof AbstractC11684dQ7.b.f) {
            interfaceC22053ub1.W(1195824005);
            strA = UY6.d(LD5.field_error_min_length, new Object[]{Integer.valueOf(((AbstractC11684dQ7.b.f) abstractC11684dQ7).a())}, interfaceC22053ub1, 0);
            interfaceC22053ub1.Q();
        } else if (abstractC11684dQ7 instanceof AbstractC11684dQ7.b.c) {
            interfaceC22053ub1.W(1195828677);
            strA = UY6.d(LD5.field_error_max_length, new Object[]{Integer.valueOf(((AbstractC11684dQ7.b.c) abstractC11684dQ7).a())}, interfaceC22053ub1, 0);
            interfaceC22053ub1.Q();
        } else if (abstractC11684dQ7 instanceof AbstractC11684dQ7.b.g) {
            interfaceC22053ub1.W(1195833316);
            strA = UY6.d(LD5.field_error_min_value, new Object[]{Integer.valueOf(((AbstractC11684dQ7.b.g) abstractC11684dQ7).a())}, interfaceC22053ub1, 0);
            interfaceC22053ub1.Q();
        } else if (abstractC11684dQ7 instanceof AbstractC11684dQ7.b.d) {
            interfaceC22053ub1.W(1195837924);
            strA = UY6.d(LD5.field_error_max_value, new Object[]{Integer.valueOf(((AbstractC11684dQ7.b.d) abstractC11684dQ7).a())}, interfaceC22053ub1, 0);
            interfaceC22053ub1.Q();
        } else if (abstractC11684dQ7 instanceof AbstractC11684dQ7.b.e) {
            interfaceC22053ub1.W(1195842518);
            strA = UY6.d(LD5.field_error_min_date, new Object[]{O(Long.valueOf(((AbstractC11684dQ7.b.e) abstractC11684dQ7).a()), interfaceC22053ub1, 0)}, interfaceC22053ub1, 0);
            interfaceC22053ub1.Q();
        } else if (abstractC11684dQ7 instanceof AbstractC11684dQ7.b.C1008b) {
            interfaceC22053ub1.W(1195847670);
            strA = UY6.d(LD5.field_error_max_date, new Object[]{O(Long.valueOf(((AbstractC11684dQ7.b.C1008b) abstractC11684dQ7).a()), interfaceC22053ub1, 0)}, interfaceC22053ub1, 0);
            interfaceC22053ub1.Q();
        } else if (abstractC11684dQ7 instanceof AbstractC11684dQ7.b.a) {
            interfaceC22053ub1.W(1195852955);
            strA = UY6.c(LD5.field_error_invalid_format, interfaceC22053ub1, 0);
            interfaceC22053ub1.Q();
        } else if (abstractC11684dQ7 instanceof AbstractC11684dQ7.a) {
            interfaceC22053ub1.W(1195856180);
            interfaceC22053ub1.Q();
            strA = ((AbstractC11684dQ7.a) abstractC11684dQ7).a();
        } else {
            if (abstractC11684dQ7 != null) {
                interfaceC22053ub1.W(1195822914);
                interfaceC22053ub1.Q();
                throw new NoWhenBranchMatchedException();
            }
            interfaceC22053ub1.W(-1583134571);
            interfaceC22053ub1.Q();
            strA = null;
        }
        interfaceC22053ub1.Q();
        return strA;
    }

    private static final String O(Long l, InterfaceC22053ub1 interfaceC22053ub1, int i) {
        interfaceC22053ub1.W(1872393495);
        if (l == null) {
            interfaceC22053ub1.Q();
            return "";
        }
        String strB = new G45("Y/m/d", AbstractC19332qA1.A(interfaceC22053ub1, 0) ? G45.a.FARSI : G45.a.ENGLISH).b(new E45(l));
        AbstractC13042fc3.h(strB, "format(...)");
        interfaceC22053ub1.Q();
        return strB;
    }

    private static final AbstractC14472hy4 P(DX4 dx4, InterfaceC22053ub1 interfaceC22053ub1, int i) {
        AbstractC14472hy4 bVar;
        AbstractC14472hy4 dVar;
        interfaceC22053ub1.W(1642375692);
        if (AbstractC13042fc3.d(dx4, DX4.a.a)) {
            interfaceC22053ub1.W(1626857953);
            interfaceC22053ub1.Q();
            dVar = new AbstractC14472hy4.d(null, null, null, 7, null);
        } else {
            if (dx4 instanceof DX4.b) {
                interfaceC22053ub1.W(1626860267);
                bVar = new AbstractC14472hy4.a(null, N(((DX4.b) dx4).a(), interfaceC22053ub1, 0), null, 5, null);
                interfaceC22053ub1.Q();
            } else {
                if (!(dx4 instanceof DX4.c)) {
                    interfaceC22053ub1.W(1626856066);
                    interfaceC22053ub1.Q();
                    throw new NoWhenBranchMatchedException();
                }
                interfaceC22053ub1.W(1626865949);
                bVar = new AbstractC14472hy4.b(null, UY6.c(((DX4.c) dx4).a(), interfaceC22053ub1, 0), null, 5, null);
                interfaceC22053ub1.Q();
            }
            dVar = bVar;
        }
        interfaceC22053ub1.Q();
        return dVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n(final BX4 bx4, final EX4.a aVar, final InterfaceC14603iB2 interfaceC14603iB2, InterfaceC22053ub1 interfaceC22053ub1, final int i) {
        int i2;
        String str;
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(-2026011614);
        if ((i & 6) == 0) {
            i2 = (interfaceC22053ub1J.D(bx4) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= interfaceC22053ub1J.D(aVar) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= interfaceC22053ub1J.D(interfaceC14603iB2) ? 256 : 128;
        }
        int i3 = i2;
        if ((i3 & 147) == 146 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
        } else {
            String strO = O(aVar.e(), interfaceC22053ub1J, 0);
            interfaceC22053ub1J.W(-444664292);
            Object objB = interfaceC22053ub1J.B();
            InterfaceC22053ub1.a aVar2 = InterfaceC22053ub1.a;
            if (objB == aVar2.a()) {
                objB = new androidx.compose.ui.focus.m();
                interfaceC22053ub1J.s(objB);
            }
            final androidx.compose.ui.focus.m mVar = (androidx.compose.ui.focus.m) objB;
            interfaceC22053ub1J.Q();
            e.a aVar3 = androidx.compose.ui.e.a;
            androidx.compose.ui.e eVarK = androidx.compose.foundation.layout.q.k(androidx.compose.foundation.layout.t.h(aVar3, 0.0f, 1, null), C17784nZ1.q(16), 0.0f, 2, null);
            InterfaceC10970cW3 interfaceC10970cW3G = androidx.compose.foundation.layout.f.g(InterfaceC12529em.a.o(), false);
            int iA = AbstractC6797Pa1.a(interfaceC22053ub1J, 0);
            InterfaceC11819dc1 interfaceC11819dc1Q = interfaceC22053ub1J.q();
            androidx.compose.ui.e eVarE = androidx.compose.ui.c.e(interfaceC22053ub1J, eVarK);
            InterfaceC16030kb1.a aVar4 = InterfaceC16030kb1.d0;
            SA2 sa2A = aVar4.a();
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
            DG7.c(interfaceC22053ub1A, interfaceC10970cW3G, aVar4.e());
            DG7.c(interfaceC22053ub1A, interfaceC11819dc1Q, aVar4.g());
            InterfaceC14603iB2 interfaceC14603iB2B = aVar4.b();
            if (interfaceC22053ub1A.h() || !AbstractC13042fc3.d(interfaceC22053ub1A.B(), Integer.valueOf(iA))) {
                interfaceC22053ub1A.s(Integer.valueOf(iA));
                interfaceC22053ub1A.v(Integer.valueOf(iA), interfaceC14603iB2B);
            }
            DG7.c(interfaceC22053ub1A, eVarE, aVar4.f());
            androidx.compose.foundation.layout.h hVar = androidx.compose.foundation.layout.h.a;
            androidx.compose.ui.e eVarA = androidx.compose.ui.focus.n.a(androidx.compose.foundation.layout.t.h(aVar3, 0.0f, 1, null), mVar);
            if (!AbstractC20762sZ6.n0(strO)) {
                str = "\u2066" + strO + "\u2068";
            } else {
                str = "";
            }
            String strH = bx4.h();
            String strF = bx4.f();
            AbstractC14472hy4 abstractC14472hy4P = P(bx4.g(), interfaceC22053ub1J, 0);
            boolean zC = bx4.c();
            interfaceC22053ub1J.W(-609995744);
            Object objB2 = interfaceC22053ub1J.B();
            if (objB2 == aVar2.a()) {
                objB2 = new UA2() { // from class: ir.nasim.QX4
                    @Override // ir.nasim.UA2
                    public final Object invoke(Object obj) {
                        return TX4.o((String) obj);
                    }
                };
                interfaceC22053ub1J.s(objB2);
            }
            interfaceC22053ub1J.Q();
            AbstractC8426Vx4.e0(str, (UA2) objB2, strH, strF, eVarA, null, zC, true, null, C15165j71.a.a(), abstractC14472hy4P, null, null, false, 0, 0, null, null, false, false, null, false, interfaceC22053ub1J, 817889328, AbstractC14472hy4.a, 0, 4192544);
            androidx.compose.ui.e eVarE2 = hVar.e(aVar3);
            interfaceC22053ub1J.W(-609970939);
            Object objB3 = interfaceC22053ub1J.B();
            if (objB3 == aVar2.a()) {
                objB3 = AbstractC23831xb3.a();
                interfaceC22053ub1J.s(objB3);
            }
            InterfaceC18507om4 interfaceC18507om4 = (InterfaceC18507om4) objB3;
            interfaceC22053ub1J.Q();
            interfaceC22053ub1J.W(-609967317);
            boolean zD = interfaceC22053ub1J.D(bx4) | ((i3 & 896) == 256) | interfaceC22053ub1J.D(aVar);
            Object objB4 = interfaceC22053ub1J.B();
            if (zD || objB4 == aVar2.a()) {
                objB4 = new SA2() { // from class: ir.nasim.RX4
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return TX4.p(mVar, interfaceC14603iB2, bx4, aVar);
                    }
                };
                interfaceC22053ub1J.s(objB4);
            }
            interfaceC22053ub1J.Q();
            androidx.compose.foundation.layout.f.a(androidx.compose.foundation.e.d(eVarE2, interfaceC18507om4, null, false, null, null, (SA2) objB4, 28, null), interfaceC22053ub1J, 0);
            interfaceC22053ub1J.u();
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.SX4
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return TX4.q(bx4, aVar, interfaceC14603iB2, i, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 o(String str) {
        AbstractC13042fc3.i(str, "it");
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 p(androidx.compose.ui.focus.m mVar, InterfaceC14603iB2 interfaceC14603iB2, BX4 bx4, EX4.a aVar) {
        AbstractC13042fc3.i(mVar, "$focusRequester");
        AbstractC13042fc3.i(interfaceC14603iB2, "$onDatePickerRequested");
        AbstractC13042fc3.i(bx4, "$field");
        AbstractC13042fc3.i(aVar, "$fieldType");
        androidx.compose.ui.focus.m.g(mVar, 0, 1, null);
        interfaceC14603iB2.invoke(bx4, aVar);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 q(BX4 bx4, EX4.a aVar, InterfaceC14603iB2 interfaceC14603iB2, int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
        AbstractC13042fc3.i(bx4, "$field");
        AbstractC13042fc3.i(aVar, "$fieldType");
        AbstractC13042fc3.i(interfaceC14603iB2, "$onDatePickerRequested");
        n(bx4, aVar, interfaceC14603iB2, interfaceC22053ub1, QJ5.a(i | 1));
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r(final BX4 bx4, final EX4.b bVar, final InterfaceC14603iB2 interfaceC14603iB2, InterfaceC22053ub1 interfaceC22053ub1, final int i) {
        int i2;
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(890410604);
        if ((i & 6) == 0) {
            i2 = (interfaceC22053ub1J.D(bx4) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= interfaceC22053ub1J.D(bVar) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= interfaceC22053ub1J.D(interfaceC14603iB2) ? 256 : 128;
        }
        if ((i2 & 147) == 146 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
        } else {
            Object[] objArr = new Object[0];
            interfaceC22053ub1J.W(-1554241188);
            boolean zD = interfaceC22053ub1J.D(bVar);
            Object objB = interfaceC22053ub1J.B();
            if (zD || objB == InterfaceC22053ub1.a.a()) {
                objB = new SA2() { // from class: ir.nasim.KX4
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return TX4.s(bVar);
                    }
                };
                interfaceC22053ub1J.s(objB);
            }
            interfaceC22053ub1J.Q();
            final InterfaceC9102Ym4 interfaceC9102Ym4 = (InterfaceC9102Ym4) AbstractC9681aN5.e(objArr, null, null, (SA2) objB, interfaceC22053ub1J, 0, 6);
            String strT = t(interfaceC9102Ym4);
            interfaceC22053ub1J.W(-1554235323);
            boolean zV = interfaceC22053ub1J.V(interfaceC9102Ym4) | ((i2 & 896) == 256) | interfaceC22053ub1J.D(bx4) | interfaceC22053ub1J.D(bVar);
            Object objB2 = interfaceC22053ub1J.B();
            if (zV || objB2 == InterfaceC22053ub1.a.a()) {
                objB2 = new UA2() { // from class: ir.nasim.LX4
                    @Override // ir.nasim.UA2
                    public final Object invoke(Object obj) {
                        return TX4.v(interfaceC14603iB2, bx4, bVar, interfaceC9102Ym4, (String) obj);
                    }
                };
                interfaceC22053ub1J.s(objB2);
            }
            interfaceC22053ub1J.Q();
            A(bx4, strT, (UA2) objB2, new C21605tp3(0, null, C22785vp3.b.d(), S33.b.d(), null, null, null, 115, null), 0, interfaceC22053ub1J, (i2 & 14) | SetRpcStruct$ComposedRpc.GET_NASIM_FILE_PUBLIC_URL_FIELD_NUMBER, 16);
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.MX4
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return TX4.w(bx4, bVar, interfaceC14603iB2, i, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final InterfaceC9102Ym4 s(EX4.b bVar) {
        String string;
        AbstractC13042fc3.i(bVar, "$fieldType");
        Integer numE = bVar.e();
        if (numE == null || (string = numE.toString()) == null) {
            string = "";
        }
        return AbstractC13472gH6.d(string, null, 2, null);
    }

    private static final String t(InterfaceC9102Ym4 interfaceC9102Ym4) {
        return (String) interfaceC9102Ym4.getValue();
    }

    private static final void u(InterfaceC9102Ym4 interfaceC9102Ym4, String str) {
        interfaceC9102Ym4.setValue(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 v(InterfaceC14603iB2 interfaceC14603iB2, BX4 bx4, EX4.b bVar, InterfaceC9102Ym4 interfaceC9102Ym4, String str) {
        AbstractC13042fc3.i(interfaceC14603iB2, "$onFieldChanged");
        AbstractC13042fc3.i(bx4, "$field");
        AbstractC13042fc3.i(bVar, "$fieldType");
        AbstractC13042fc3.i(interfaceC9102Ym4, "$value$delegate");
        AbstractC13042fc3.i(str, "newValue");
        u(interfaceC9102Ym4, ZY6.a(str));
        interfaceC14603iB2.invoke(bx4, EX4.b.b(bVar, AbstractC20762sZ6.n0(t(interfaceC9102Ym4)) ? null : AbstractC19562qZ6.o(t(interfaceC9102Ym4)), null, null, 6, null));
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 w(BX4 bx4, EX4.b bVar, InterfaceC14603iB2 interfaceC14603iB2, int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
        AbstractC13042fc3.i(bx4, "$field");
        AbstractC13042fc3.i(bVar, "$fieldType");
        AbstractC13042fc3.i(interfaceC14603iB2, "$onFieldChanged");
        r(bx4, bVar, interfaceC14603iB2, interfaceC22053ub1, QJ5.a(i | 1));
        return C19938rB7.a;
    }

    public static final void x(final C19777qv2 c19777qv2, final C19186pv2 c19186pv2, InterfaceC22053ub1 interfaceC22053ub1, final int i) {
        int i2;
        AbstractC13042fc3.i(c19777qv2, "state");
        AbstractC13042fc3.i(c19186pv2, "callBack");
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(2126894779);
        if ((i & 6) == 0) {
            i2 = (interfaceC22053ub1J.D(c19777qv2) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= interfaceC22053ub1J.V(c19186pv2) ? 32 : 16;
        }
        if ((i2 & 19) == 18 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
        } else {
            androidx.compose.ui.e eVarF = androidx.compose.foundation.layout.t.f(androidx.compose.ui.e.a, 0.0f, 1, null);
            float f2 = 16;
            TS4 ts4C = androidx.compose.foundation.layout.q.c(0.0f, C17784nZ1.q(f2), 1, null);
            C24254yJ.f fVarO = C24254yJ.a.o(C17784nZ1.q(f2));
            interfaceC22053ub1J.W(79516253);
            boolean zD = interfaceC22053ub1J.D(c19777qv2) | ((i2 & SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER) == 32);
            Object objB = interfaceC22053ub1J.B();
            if (zD || objB == InterfaceC22053ub1.a.a()) {
                objB = new UA2() { // from class: ir.nasim.IX4
                    @Override // ir.nasim.UA2
                    public final Object invoke(Object obj) {
                        return TX4.y(c19777qv2, c19186pv2, (InterfaceC15069ix3) obj);
                    }
                };
                interfaceC22053ub1J.s(objB);
            }
            interfaceC22053ub1J.Q();
            AbstractC12623ev3.b(eVarF, null, ts4C, false, fVarO, null, null, false, null, (UA2) objB, interfaceC22053ub1J, 24966, 490);
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.JX4
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return TX4.z(c19777qv2, c19186pv2, i, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 y(C19777qv2 c19777qv2, C19186pv2 c19186pv2, InterfaceC15069ix3 interfaceC15069ix3) {
        AbstractC13042fc3.i(c19777qv2, "$state");
        AbstractC13042fc3.i(c19186pv2, "$callBack");
        AbstractC13042fc3.i(interfaceC15069ix3, "$this$LazyColumn");
        C13245fu c13245fuC = c19777qv2.c();
        if (c13245fuC != null) {
            InterfaceC15069ix3.d(interfaceC15069ix3, null, null, AbstractC19242q11.c(-2037760670, true, new a(c13245fuC)), 3, null);
        }
        if (c19777qv2.d().size() > 1) {
            for (CX4 cx4 : c19777qv2.d()) {
                String strD = cx4.d();
                if (strD != null) {
                    InterfaceC15069ix3.d(interfaceC15069ix3, null, null, AbstractC19242q11.c(-526969417, true, new b(strD)), 3, null);
                }
                L(interfaceC15069ix3, cx4.c(), c19186pv2);
            }
        } else if (!c19777qv2.d().isEmpty()) {
            L(interfaceC15069ix3, ((CX4) AbstractC15401jX0.q0(c19777qv2.d())).c(), c19186pv2);
        }
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 z(C19777qv2 c19777qv2, C19186pv2 c19186pv2, int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
        AbstractC13042fc3.i(c19777qv2, "$state");
        AbstractC13042fc3.i(c19186pv2, "$callBack");
        x(c19777qv2, c19186pv2, interfaceC22053ub1, QJ5.a(i | 1));
        return C19938rB7.a;
    }
}
