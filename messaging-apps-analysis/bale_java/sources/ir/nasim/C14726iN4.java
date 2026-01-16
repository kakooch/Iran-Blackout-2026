package ir.nasim;

import ir.nasim.AbstractC21430te5;
import java.util.List;
import java.util.NoSuchElementException;

/* renamed from: ir.nasim.iN4, reason: case insensitive filesystem */
/* loaded from: classes.dex */
final class C14726iN4 implements InterfaceC10970cW3 {
    private final UA2 a;
    private final boolean b;
    private final float c;
    private final TS4 d;

    /* renamed from: ir.nasim.iN4$a */
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

    /* renamed from: ir.nasim.iN4$b */
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

    /* renamed from: ir.nasim.iN4$c */
    static final class c extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ int e;
        final /* synthetic */ int f;
        final /* synthetic */ AbstractC21430te5 g;
        final /* synthetic */ AbstractC21430te5 h;
        final /* synthetic */ AbstractC21430te5 i;
        final /* synthetic */ AbstractC21430te5 j;
        final /* synthetic */ AbstractC21430te5 k;
        final /* synthetic */ AbstractC21430te5 l;
        final /* synthetic */ C14726iN4 m;
        final /* synthetic */ InterfaceC12377eW3 n;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(int i, int i2, AbstractC21430te5 abstractC21430te5, AbstractC21430te5 abstractC21430te52, AbstractC21430te5 abstractC21430te53, AbstractC21430te5 abstractC21430te54, AbstractC21430te5 abstractC21430te55, AbstractC21430te5 abstractC21430te56, C14726iN4 c14726iN4, InterfaceC12377eW3 interfaceC12377eW3) {
            super(1);
            this.e = i;
            this.f = i2;
            this.g = abstractC21430te5;
            this.h = abstractC21430te52;
            this.i = abstractC21430te53;
            this.j = abstractC21430te54;
            this.k = abstractC21430te55;
            this.l = abstractC21430te56;
            this.m = c14726iN4;
            this.n = interfaceC12377eW3;
        }

        public final void a(AbstractC21430te5.a aVar) {
            AbstractC14115hN4.l(aVar, this.e, this.f, this.g, this.h, this.i, this.j, this.k, this.l, this.m.c, this.m.b, this.n.getDensity(), this.n.getLayoutDirection(), this.m.d);
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((AbstractC21430te5.a) obj);
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.iN4$d */
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

    /* renamed from: ir.nasim.iN4$e */
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

    public C14726iN4(UA2 ua2, boolean z, float f, TS4 ts4) {
        this.a = ua2;
        this.b = z;
        this.c = f;
        this.d = ts4;
    }

    private final int g(InterfaceC10436bc3 interfaceC10436bc3, List list, int i, InterfaceC14603iB2 interfaceC14603iB2) {
        Object obj;
        Object obj2;
        int iM;
        int iIntValue;
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
            iM = AbstractC14115hN4.m(i, interfaceC9236Zb3.k0(Integer.MAX_VALUE));
            iIntValue = ((Number) interfaceC14603iB2.invoke(interfaceC9236Zb3, Integer.valueOf(i))).intValue();
        } else {
            iM = i;
            iIntValue = 0;
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
            iM = AbstractC14115hN4.m(iM, interfaceC9236Zb32.k0(Integer.MAX_VALUE));
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
        int iIntValue3 = obj5 != null ? ((Number) interfaceC14603iB2.invoke(obj5, Integer.valueOf(AbstractC18932pV3.c(iM, i, this.c)))).intValue() : 0;
        int size4 = list.size();
        for (int i5 = 0; i5 < size4; i5++) {
            Object obj6 = list.get(i5);
            if (AbstractC13042fc3.d(AbstractC11925dm7.e((InterfaceC9236Zb3) obj6), "TextField")) {
                int iIntValue4 = ((Number) interfaceC14603iB2.invoke(obj6, Integer.valueOf(iM))).intValue();
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
                return AbstractC14115hN4.i(iIntValue, iIntValue2, iIntValue4, iIntValue3, obj8 != null ? ((Number) interfaceC14603iB2.invoke(obj8, Integer.valueOf(iM))).intValue() : 0, this.c, AbstractC19606qe1.b(0, 0, 0, 0, 15, null), interfaceC10436bc3.getDensity(), this.d);
            }
        }
        throw new NoSuchElementException("Collection contains no element matching the predicate.");
    }

    private final int j(InterfaceC10436bc3 interfaceC10436bc3, List list, int i, InterfaceC14603iB2 interfaceC14603iB2) {
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
                return AbstractC14115hN4.j(iIntValue4, iIntValue3, iIntValue, iIntValue2, interfaceC9236Zb34 != null ? ((Number) interfaceC14603iB2.invoke(interfaceC9236Zb34, Integer.valueOf(i))).intValue() : 0, this.c, AbstractC19606qe1.b(0, 0, 0, 0, 15, null), interfaceC10436bc3.getDensity(), this.d);
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
        Object obj4;
        int iB0 = interfaceC12377eW3.B0(this.d.a());
        long jD = C17833ne1.d(j, 0, 0, 0, 0, 10, null);
        int size = list.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                obj = null;
                break;
            }
            obj = list.get(i);
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
            obj2 = list.get(i2);
            if (AbstractC13042fc3.d(androidx.compose.ui.layout.a.a((ZV3) obj2), "Trailing")) {
                break;
            }
            i2++;
        }
        ZV3 zv32 = (ZV3) obj2;
        AbstractC21430te5 abstractC21430te5L02 = zv32 != null ? zv32.l0(AbstractC19606qe1.j(jD, -iH, 0, 2, null)) : null;
        int iH2 = iH + AbstractC11925dm7.h(abstractC21430te5L02);
        int iB02 = interfaceC12377eW3.B0(this.d.d(interfaceC12377eW3.getLayoutDirection())) + interfaceC12377eW3.B0(this.d.b(interfaceC12377eW3.getLayoutDirection()));
        int i3 = -iH2;
        int i4 = -iB0;
        long jI = AbstractC19606qe1.i(jD, AbstractC18932pV3.c(i3 - iB02, -iB02, this.c), i4);
        int size3 = list.size();
        int i5 = 0;
        while (true) {
            if (i5 >= size3) {
                obj3 = null;
                break;
            }
            obj3 = list.get(i5);
            if (AbstractC13042fc3.d(androidx.compose.ui.layout.a.a((ZV3) obj3), "Label")) {
                break;
            }
            i5++;
        }
        ZV3 zv33 = (ZV3) obj3;
        AbstractC21430te5 abstractC21430te5L03 = zv33 != null ? zv33.l0(jI) : null;
        this.a.invoke(OD6.c(abstractC21430te5L03 != null ? UD6.a(abstractC21430te5L03.P0(), abstractC21430te5L03.A0()) : OD6.b.b()));
        long jD2 = C17833ne1.d(AbstractC19606qe1.i(j, i3, i4 - Math.max(AbstractC11925dm7.g(abstractC21430te5L03) / 2, interfaceC12377eW3.B0(this.d.c()))), 0, 0, 0, 0, 11, null);
        int size4 = list.size();
        for (int i6 = 0; i6 < size4; i6++) {
            ZV3 zv34 = (ZV3) list.get(i6);
            if (AbstractC13042fc3.d(androidx.compose.ui.layout.a.a(zv34), "TextField")) {
                AbstractC21430te5 abstractC21430te5L04 = zv34.l0(jD2);
                long jD3 = C17833ne1.d(jD2, 0, 0, 0, 0, 14, null);
                int size5 = list.size();
                int i7 = 0;
                while (true) {
                    if (i7 >= size5) {
                        obj4 = null;
                        break;
                    }
                    obj4 = list.get(i7);
                    int i8 = size5;
                    if (AbstractC13042fc3.d(androidx.compose.ui.layout.a.a((ZV3) obj4), "Hint")) {
                        break;
                    }
                    i7++;
                    size5 = i8;
                }
                ZV3 zv35 = (ZV3) obj4;
                AbstractC21430te5 abstractC21430te5L05 = zv35 != null ? zv35.l0(jD3) : null;
                int iJ = AbstractC14115hN4.j(AbstractC11925dm7.h(abstractC21430te5L0), AbstractC11925dm7.h(abstractC21430te5L02), abstractC21430te5L04.P0(), AbstractC11925dm7.h(abstractC21430te5L03), AbstractC11925dm7.h(abstractC21430te5L05), this.c, j, interfaceC12377eW3.getDensity(), this.d);
                int i9 = AbstractC14115hN4.i(AbstractC11925dm7.g(abstractC21430te5L0), AbstractC11925dm7.g(abstractC21430te5L02), abstractC21430te5L04.A0(), AbstractC11925dm7.g(abstractC21430te5L03), AbstractC11925dm7.g(abstractC21430te5L05), this.c, j, interfaceC12377eW3.getDensity(), this.d);
                int size6 = list.size();
                for (int i10 = 0; i10 < size6; i10++) {
                    ZV3 zv36 = (ZV3) list.get(i10);
                    if (AbstractC13042fc3.d(androidx.compose.ui.layout.a.a(zv36), "border")) {
                        return InterfaceC12377eW3.Q1(interfaceC12377eW3, iJ, i9, null, new c(i9, iJ, abstractC21430te5L0, abstractC21430te5L02, abstractC21430te5L04, abstractC21430te5L03, abstractC21430te5L05, zv36.l0(AbstractC19606qe1.a(iJ != Integer.MAX_VALUE ? iJ : 0, iJ, i9 != Integer.MAX_VALUE ? i9 : 0, i9)), this, interfaceC12377eW3), 4, null);
                    }
                }
                throw new NoSuchElementException("Collection contains no element matching the predicate.");
            }
        }
        throw new NoSuchElementException("Collection contains no element matching the predicate.");
    }

    @Override // ir.nasim.InterfaceC10970cW3
    public int d(InterfaceC10436bc3 interfaceC10436bc3, List list, int i) {
        return j(interfaceC10436bc3, list, i, b.e);
    }

    @Override // ir.nasim.InterfaceC10970cW3
    public int h(InterfaceC10436bc3 interfaceC10436bc3, List list, int i) {
        return j(interfaceC10436bc3, list, i, e.e);
    }

    @Override // ir.nasim.InterfaceC10970cW3
    public int i(InterfaceC10436bc3 interfaceC10436bc3, List list, int i) {
        return g(interfaceC10436bc3, list, i, a.e);
    }
}
