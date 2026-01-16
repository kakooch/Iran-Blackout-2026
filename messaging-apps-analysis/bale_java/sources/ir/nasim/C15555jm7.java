package ir.nasim;

import ir.nasim.AbstractC21430te5;
import java.util.List;
import java.util.NoSuchElementException;

/* renamed from: ir.nasim.jm7, reason: case insensitive filesystem */
/* loaded from: classes.dex */
final class C15555jm7 implements InterfaceC10970cW3 {
    private final boolean a;
    private final float b;
    private final TS4 c;

    /* renamed from: ir.nasim.jm7$a */
    static final class a extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
        public static final a e = new a();

        a() {
            super(2);
        }

        public final Integer a(InterfaceC9236Zb3 interfaceC9236Zb3, int i) {
            return Integer.valueOf(interfaceC9236Zb3.z(i));
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            return a((InterfaceC9236Zb3) obj, ((Number) obj2).intValue());
        }
    }

    /* renamed from: ir.nasim.jm7$b */
    static final class b extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
        public static final b e = new b();

        b() {
            super(2);
        }

        public final Integer a(InterfaceC9236Zb3 interfaceC9236Zb3, int i) {
            return Integer.valueOf(interfaceC9236Zb3.k0(i));
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            return a((InterfaceC9236Zb3) obj, ((Number) obj2).intValue());
        }
    }

    /* renamed from: ir.nasim.jm7$c */
    static final class c extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ AbstractC21430te5 e;
        final /* synthetic */ int f;
        final /* synthetic */ int g;
        final /* synthetic */ int h;
        final /* synthetic */ int i;
        final /* synthetic */ AbstractC21430te5 j;
        final /* synthetic */ AbstractC21430te5 k;
        final /* synthetic */ AbstractC21430te5 l;
        final /* synthetic */ AbstractC21430te5 m;
        final /* synthetic */ C15555jm7 n;
        final /* synthetic */ int o;
        final /* synthetic */ int p;
        final /* synthetic */ InterfaceC12377eW3 q;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(AbstractC21430te5 abstractC21430te5, int i, int i2, int i3, int i4, AbstractC21430te5 abstractC21430te52, AbstractC21430te5 abstractC21430te53, AbstractC21430te5 abstractC21430te54, AbstractC21430te5 abstractC21430te55, C15555jm7 c15555jm7, int i5, int i6, InterfaceC12377eW3 interfaceC12377eW3) {
            super(1);
            this.e = abstractC21430te5;
            this.f = i;
            this.g = i2;
            this.h = i3;
            this.i = i4;
            this.j = abstractC21430te52;
            this.k = abstractC21430te53;
            this.l = abstractC21430te54;
            this.m = abstractC21430te55;
            this.n = c15555jm7;
            this.o = i5;
            this.p = i6;
            this.q = interfaceC12377eW3;
        }

        public final void a(AbstractC21430te5.a aVar) {
            if (this.e == null) {
                AbstractC14965im7.o(aVar, this.h, this.i, this.j, this.k, this.l, this.m, this.n.a, this.q.getDensity(), this.n.c);
            } else {
                AbstractC14965im7.n(aVar, this.h, this.i, this.j, this.e, this.k, this.l, this.m, this.n.a, AbstractC23053wG5.e(this.f - this.g, 0), this.o + this.p, this.n.b, this.q.getDensity());
            }
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((AbstractC21430te5.a) obj);
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.jm7$d */
    static final class d extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
        public static final d e = new d();

        d() {
            super(2);
        }

        public final Integer a(InterfaceC9236Zb3 interfaceC9236Zb3, int i) {
            return Integer.valueOf(interfaceC9236Zb3.Z(i));
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            return a((InterfaceC9236Zb3) obj, ((Number) obj2).intValue());
        }
    }

    /* renamed from: ir.nasim.jm7$e */
    static final class e extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
        public static final e e = new e();

        e() {
            super(2);
        }

        public final Integer a(InterfaceC9236Zb3 interfaceC9236Zb3, int i) {
            return Integer.valueOf(interfaceC9236Zb3.i0(i));
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            return a((InterfaceC9236Zb3) obj, ((Number) obj2).intValue());
        }
    }

    public C15555jm7(boolean z, float f, TS4 ts4) {
        this.a = z;
        this.b = f;
        this.c = ts4;
    }

    private final int g(InterfaceC10436bc3 interfaceC10436bc3, List list, int i, InterfaceC14603iB2 interfaceC14603iB2) {
        Object obj;
        Object obj2;
        int iIntValue;
        int iP;
        Object obj3;
        int iIntValue2;
        Object obj4;
        int size = list.size();
        int i2 = 0;
        while (true) {
            obj = null;
            if (i2 >= size) {
                obj2 = null;
                break;
            }
            obj2 = list.get(i2);
            if (AbstractC13042fc3.d(AbstractC11925dm7.e((InterfaceC9236Zb3) obj2), "Leading")) {
                break;
            }
            i2++;
        }
        InterfaceC9236Zb3 interfaceC9236Zb3 = (InterfaceC9236Zb3) obj2;
        if (interfaceC9236Zb3 != null) {
            iP = AbstractC14965im7.p(i, interfaceC9236Zb3.k0(Integer.MAX_VALUE));
            iIntValue = ((Number) interfaceC14603iB2.invoke(interfaceC9236Zb3, Integer.valueOf(i))).intValue();
        } else {
            iIntValue = 0;
            iP = i;
        }
        int size2 = list.size();
        int i3 = 0;
        while (true) {
            if (i3 >= size2) {
                obj3 = null;
                break;
            }
            obj3 = list.get(i3);
            if (AbstractC13042fc3.d(AbstractC11925dm7.e((InterfaceC9236Zb3) obj3), "Trailing")) {
                break;
            }
            i3++;
        }
        InterfaceC9236Zb3 interfaceC9236Zb32 = (InterfaceC9236Zb3) obj3;
        if (interfaceC9236Zb32 != null) {
            iP = AbstractC14965im7.p(iP, interfaceC9236Zb32.k0(Integer.MAX_VALUE));
            iIntValue2 = ((Number) interfaceC14603iB2.invoke(interfaceC9236Zb32, Integer.valueOf(i))).intValue();
        } else {
            iIntValue2 = 0;
        }
        int size3 = list.size();
        int i4 = 0;
        while (true) {
            if (i4 >= size3) {
                obj4 = null;
                break;
            }
            obj4 = list.get(i4);
            if (AbstractC13042fc3.d(AbstractC11925dm7.e((InterfaceC9236Zb3) obj4), "Label")) {
                break;
            }
            i4++;
        }
        Object obj5 = (InterfaceC9236Zb3) obj4;
        int iIntValue3 = obj5 != null ? ((Number) interfaceC14603iB2.invoke(obj5, Integer.valueOf(iP))).intValue() : 0;
        int size4 = list.size();
        for (int i5 = 0; i5 < size4; i5++) {
            Object obj6 = list.get(i5);
            if (AbstractC13042fc3.d(AbstractC11925dm7.e((InterfaceC9236Zb3) obj6), "TextField")) {
                int iIntValue4 = ((Number) interfaceC14603iB2.invoke(obj6, Integer.valueOf(iP))).intValue();
                int size5 = list.size();
                int i6 = 0;
                while (true) {
                    if (i6 >= size5) {
                        break;
                    }
                    Object obj7 = list.get(i6);
                    if (AbstractC13042fc3.d(AbstractC11925dm7.e((InterfaceC9236Zb3) obj7), "Hint")) {
                        obj = obj7;
                        break;
                    }
                    i6++;
                }
                Object obj8 = (InterfaceC9236Zb3) obj;
                return AbstractC14965im7.h(iIntValue4, iIntValue3 > 0, iIntValue3, iIntValue, iIntValue2, obj8 != null ? ((Number) interfaceC14603iB2.invoke(obj8, Integer.valueOf(iP))).intValue() : 0, AbstractC19606qe1.b(0, 0, 0, 0, 15, null), interfaceC10436bc3.getDensity(), this.c);
            }
        }
        throw new NoSuchElementException("Collection contains no element matching the predicate.");
    }

    private final int j(List list, int i, InterfaceC14603iB2 interfaceC14603iB2) {
        Object obj;
        Object obj2;
        Object obj3;
        Object obj4;
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            Object obj5 = list.get(i2);
            if (AbstractC13042fc3.d(AbstractC11925dm7.e((InterfaceC9236Zb3) obj5), "TextField")) {
                int iIntValue = ((Number) interfaceC14603iB2.invoke(obj5, Integer.valueOf(i))).intValue();
                int size2 = list.size();
                int i3 = 0;
                while (true) {
                    obj = null;
                    if (i3 >= size2) {
                        obj2 = null;
                        break;
                    }
                    obj2 = list.get(i3);
                    if (AbstractC13042fc3.d(AbstractC11925dm7.e((InterfaceC9236Zb3) obj2), "Label")) {
                        break;
                    }
                    i3++;
                }
                InterfaceC9236Zb3 interfaceC9236Zb3 = (InterfaceC9236Zb3) obj2;
                int iIntValue2 = interfaceC9236Zb3 != null ? ((Number) interfaceC14603iB2.invoke(interfaceC9236Zb3, Integer.valueOf(i))).intValue() : 0;
                int size3 = list.size();
                int i4 = 0;
                while (true) {
                    if (i4 >= size3) {
                        obj3 = null;
                        break;
                    }
                    obj3 = list.get(i4);
                    if (AbstractC13042fc3.d(AbstractC11925dm7.e((InterfaceC9236Zb3) obj3), "Trailing")) {
                        break;
                    }
                    i4++;
                }
                InterfaceC9236Zb3 interfaceC9236Zb32 = (InterfaceC9236Zb3) obj3;
                int iIntValue3 = interfaceC9236Zb32 != null ? ((Number) interfaceC14603iB2.invoke(interfaceC9236Zb32, Integer.valueOf(i))).intValue() : 0;
                int size4 = list.size();
                int i5 = 0;
                while (true) {
                    if (i5 >= size4) {
                        obj4 = null;
                        break;
                    }
                    obj4 = list.get(i5);
                    if (AbstractC13042fc3.d(AbstractC11925dm7.e((InterfaceC9236Zb3) obj4), "Leading")) {
                        break;
                    }
                    i5++;
                }
                InterfaceC9236Zb3 interfaceC9236Zb33 = (InterfaceC9236Zb3) obj4;
                int iIntValue4 = interfaceC9236Zb33 != null ? ((Number) interfaceC14603iB2.invoke(interfaceC9236Zb33, Integer.valueOf(i))).intValue() : 0;
                int size5 = list.size();
                int i6 = 0;
                while (true) {
                    if (i6 >= size5) {
                        break;
                    }
                    Object obj6 = list.get(i6);
                    if (AbstractC13042fc3.d(AbstractC11925dm7.e((InterfaceC9236Zb3) obj6), "Hint")) {
                        obj = obj6;
                        break;
                    }
                    i6++;
                }
                InterfaceC9236Zb3 interfaceC9236Zb34 = (InterfaceC9236Zb3) obj;
                return AbstractC14965im7.i(iIntValue4, iIntValue3, iIntValue, iIntValue2, interfaceC9236Zb34 != null ? ((Number) interfaceC14603iB2.invoke(interfaceC9236Zb34, Integer.valueOf(i))).intValue() : 0, AbstractC19606qe1.b(0, 0, 0, 0, 15, null));
            }
        }
        throw new NoSuchElementException("Collection contains no element matching the predicate.");
    }

    @Override // ir.nasim.InterfaceC10970cW3
    public int a(InterfaceC10436bc3 interfaceC10436bc3, List list, int i) {
        return g(interfaceC10436bc3, list, i, d.e);
    }

    @Override // ir.nasim.InterfaceC10970cW3
    public InterfaceC11734dW3 b(InterfaceC12377eW3 interfaceC12377eW3, List list, long j) {
        Object obj;
        Object obj2;
        Object obj3;
        int iJ;
        Object obj4;
        List list2 = list;
        int iB0 = interfaceC12377eW3.B0(this.c.c());
        int iB02 = interfaceC12377eW3.B0(this.c.a());
        int iB03 = interfaceC12377eW3.B0(AbstractC14965im7.m());
        long jD = C17833ne1.d(j, 0, 0, 0, 0, 10, null);
        int size = list.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                obj = null;
                break;
            }
            obj = list2.get(i);
            if (AbstractC13042fc3.d(androidx.compose.ui.layout.a.a((ZV3) obj), "Leading")) {
                break;
            }
            i++;
        }
        ZV3 zv3 = (ZV3) obj;
        AbstractC21430te5 abstractC21430te5L0 = zv3 != null ? zv3.l0(jD) : null;
        int iH = AbstractC11925dm7.h(abstractC21430te5L0);
        int size2 = list.size();
        int i2 = 0;
        while (true) {
            if (i2 >= size2) {
                obj2 = null;
                break;
            }
            obj2 = list2.get(i2);
            if (AbstractC13042fc3.d(androidx.compose.ui.layout.a.a((ZV3) obj2), "Trailing")) {
                break;
            }
            i2++;
        }
        ZV3 zv32 = (ZV3) obj2;
        AbstractC21430te5 abstractC21430te5L02 = zv32 != null ? zv32.l0(AbstractC19606qe1.j(jD, -iH, 0, 2, null)) : null;
        int i3 = -iB02;
        int i4 = -(iH + AbstractC11925dm7.h(abstractC21430te5L02));
        long jI = AbstractC19606qe1.i(jD, i4, i3);
        int size3 = list.size();
        int i5 = 0;
        while (true) {
            if (i5 >= size3) {
                obj3 = null;
                break;
            }
            obj3 = list2.get(i5);
            int i6 = size3;
            if (AbstractC13042fc3.d(androidx.compose.ui.layout.a.a((ZV3) obj3), "Label")) {
                break;
            }
            i5++;
            size3 = i6;
        }
        ZV3 zv33 = (ZV3) obj3;
        AbstractC21430te5 abstractC21430te5L03 = zv33 != null ? zv33.l0(jI) : null;
        if (abstractC21430te5L03 != null) {
            iJ = abstractC21430te5L03.J(AbstractC13756gm.b());
            if (iJ == Integer.MIN_VALUE) {
                iJ = abstractC21430te5L03.A0();
            }
        } else {
            iJ = 0;
        }
        int iMax = Math.max(iJ, iB0);
        long jI2 = AbstractC19606qe1.i(C17833ne1.d(j, 0, 0, 0, 0, 11, null), i4, abstractC21430te5L03 != null ? (i3 - iB03) - iMax : (-iB0) - iB02);
        int size4 = list.size();
        int i7 = 0;
        while (i7 < size4) {
            ZV3 zv34 = (ZV3) list2.get(i7);
            int i8 = size4;
            if (AbstractC13042fc3.d(androidx.compose.ui.layout.a.a(zv34), "TextField")) {
                AbstractC21430te5 abstractC21430te5L04 = zv34.l0(jI2);
                long jD2 = C17833ne1.d(jI2, 0, 0, 0, 0, 14, null);
                int size5 = list.size();
                int i9 = 0;
                while (true) {
                    if (i9 >= size5) {
                        obj4 = null;
                        break;
                    }
                    obj4 = list2.get(i9);
                    int i10 = size5;
                    if (AbstractC13042fc3.d(androidx.compose.ui.layout.a.a((ZV3) obj4), "Hint")) {
                        break;
                    }
                    i9++;
                    list2 = list;
                    size5 = i10;
                }
                ZV3 zv35 = (ZV3) obj4;
                AbstractC21430te5 abstractC21430te5L05 = zv35 != null ? zv35.l0(jD2) : null;
                int i11 = AbstractC14965im7.i(AbstractC11925dm7.h(abstractC21430te5L0), AbstractC11925dm7.h(abstractC21430te5L02), abstractC21430te5L04.P0(), AbstractC11925dm7.h(abstractC21430te5L03), AbstractC11925dm7.h(abstractC21430te5L05), j);
                int iH2 = AbstractC14965im7.h(abstractC21430te5L04.A0(), abstractC21430te5L03 != null, iMax, AbstractC11925dm7.g(abstractC21430te5L0), AbstractC11925dm7.g(abstractC21430te5L02), AbstractC11925dm7.g(abstractC21430te5L05), j, interfaceC12377eW3.getDensity(), this.c);
                return InterfaceC12377eW3.Q1(interfaceC12377eW3, i11, iH2, null, new c(abstractC21430te5L03, iB0, iJ, i11, iH2, abstractC21430te5L04, abstractC21430te5L05, abstractC21430te5L0, abstractC21430te5L02, this, iMax, iB03, interfaceC12377eW3), 4, null);
            }
            i7++;
            list2 = list;
            size4 = i8;
        }
        throw new NoSuchElementException("Collection contains no element matching the predicate.");
    }

    @Override // ir.nasim.InterfaceC10970cW3
    public int d(InterfaceC10436bc3 interfaceC10436bc3, List list, int i) {
        return j(list, i, b.e);
    }

    @Override // ir.nasim.InterfaceC10970cW3
    public int h(InterfaceC10436bc3 interfaceC10436bc3, List list, int i) {
        return j(list, i, e.e);
    }

    @Override // ir.nasim.InterfaceC10970cW3
    public int i(InterfaceC10436bc3 interfaceC10436bc3, List list, int i) {
        return g(interfaceC10436bc3, list, i, a.e);
    }
}
