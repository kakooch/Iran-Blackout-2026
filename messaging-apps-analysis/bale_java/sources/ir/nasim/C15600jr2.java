package ir.nasim;

import ir.nasim.AbstractC13218fr2;
import ir.nasim.AbstractC21430te5;
import ir.nasim.C11348cr2;
import ir.nasim.C24254yJ;
import java.util.List;
import java.util.NoSuchElementException;

/* renamed from: ir.nasim.jr2, reason: case insensitive filesystem */
/* loaded from: classes.dex */
final class C15600jr2 implements InterfaceC16724ll4, InterfaceC15010ir2 {
    private final boolean a;
    private final C24254yJ.e b;
    private final C24254yJ.m c;
    private final float d;
    private final AbstractC5075Hu1 e;
    private final float f;
    private final int g;
    private final int h;
    private final C13809gr2 i;

    public /* synthetic */ C15600jr2(boolean z, C24254yJ.e eVar, C24254yJ.m mVar, float f, AbstractC5075Hu1 abstractC5075Hu1, float f2, int i, int i2, C13809gr2 c13809gr2, ED1 ed1) {
        this(z, eVar, mVar, f, abstractC5075Hu1, f2, i, i2, c13809gr2);
    }

    @Override // ir.nasim.InterfaceC16724ll4
    public int a(InterfaceC10436bc3 interfaceC10436bc3, List list, int i) {
        C13809gr2 c13809gr2 = this.i;
        List list2 = (List) AbstractC15401jX0.t0(list, 1);
        InterfaceC9236Zb3 interfaceC9236Zb3 = list2 != null ? (InterfaceC9236Zb3) AbstractC15401jX0.s0(list2) : null;
        List list3 = (List) AbstractC15401jX0.t0(list, 2);
        c13809gr2.m(interfaceC9236Zb3, list3 != null ? (InterfaceC9236Zb3) AbstractC15401jX0.s0(list3) : null, m(), AbstractC19606qe1.b(0, i, 0, 0, 13, null));
        if (m()) {
            List listM = (List) AbstractC15401jX0.s0(list);
            if (listM == null) {
                listM = AbstractC10360bX0.m();
            }
            return l(listM, i, interfaceC10436bc3.B0(this.d), interfaceC10436bc3.B0(this.f), this.g, this.h, this.i);
        }
        List listM2 = (List) AbstractC15401jX0.s0(list);
        if (listM2 == null) {
            listM2 = AbstractC10360bX0.m();
        }
        return u(listM2, i, interfaceC10436bc3.B0(this.d), interfaceC10436bc3.B0(this.f), this.g, this.h, this.i);
    }

    @Override // ir.nasim.InterfaceC16724ll4
    public InterfaceC11734dW3 b(InterfaceC12377eW3 interfaceC12377eW3, List list, long j) {
        if (this.h == 0 || this.g == 0 || list.isEmpty() || (C17833ne1.k(j) == 0 && this.i.i() != AbstractC13218fr2.a.a)) {
            return InterfaceC12377eW3.Q1(interfaceC12377eW3, 0, 0, null, a.e, 4, null);
        }
        List list2 = (List) AbstractC15401jX0.q0(list);
        if (list2.isEmpty()) {
            return InterfaceC12377eW3.Q1(interfaceC12377eW3, 0, 0, null, b.e, 4, null);
        }
        List list3 = (List) AbstractC15401jX0.t0(list, 1);
        ZV3 zv3 = list3 != null ? (ZV3) AbstractC15401jX0.s0(list3) : null;
        List list4 = (List) AbstractC15401jX0.t0(list, 2);
        ZV3 zv32 = list4 != null ? (ZV3) AbstractC15401jX0.s0(list4) : null;
        this.i.j(list2.size());
        this.i.l(this, zv3, zv32, j);
        return AbstractC12582er2.d(interfaceC12377eW3, this, list2.iterator(), this.d, this.f, AbstractC24880zM4.c(j, m() ? EnumC5311Iu3.a : EnumC5311Iu3.b), this.g, this.h, this.i);
    }

    @Override // ir.nasim.InterfaceC16724ll4
    public int d(InterfaceC10436bc3 interfaceC10436bc3, List list, int i) {
        C13809gr2 c13809gr2 = this.i;
        List list2 = (List) AbstractC15401jX0.t0(list, 1);
        InterfaceC9236Zb3 interfaceC9236Zb3 = list2 != null ? (InterfaceC9236Zb3) AbstractC15401jX0.s0(list2) : null;
        List list3 = (List) AbstractC15401jX0.t0(list, 2);
        c13809gr2.m(interfaceC9236Zb3, list3 != null ? (InterfaceC9236Zb3) AbstractC15401jX0.s0(list3) : null, m(), AbstractC19606qe1.b(0, 0, 0, i, 7, null));
        if (m()) {
            List listM = (List) AbstractC15401jX0.s0(list);
            if (listM == null) {
                listM = AbstractC10360bX0.m();
            }
            return o(listM, i, interfaceC10436bc3.B0(this.d));
        }
        List listM2 = (List) AbstractC15401jX0.s0(list);
        if (listM2 == null) {
            listM2 = AbstractC10360bX0.m();
        }
        return l(listM2, i, interfaceC10436bc3.B0(this.d), interfaceC10436bc3.B0(this.f), this.g, this.h, this.i);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C15600jr2)) {
            return false;
        }
        C15600jr2 c15600jr2 = (C15600jr2) obj;
        return this.a == c15600jr2.a && AbstractC13042fc3.d(this.b, c15600jr2.b) && AbstractC13042fc3.d(this.c, c15600jr2.c) && C17784nZ1.s(this.d, c15600jr2.d) && AbstractC13042fc3.d(this.e, c15600jr2.e) && C17784nZ1.s(this.f, c15600jr2.f) && this.g == c15600jr2.g && this.h == c15600jr2.h && AbstractC13042fc3.d(this.i, c15600jr2.i);
    }

    @Override // ir.nasim.InterfaceC16724ll4
    public int h(InterfaceC10436bc3 interfaceC10436bc3, List list, int i) {
        C13809gr2 c13809gr2 = this.i;
        List list2 = (List) AbstractC15401jX0.t0(list, 1);
        InterfaceC9236Zb3 interfaceC9236Zb3 = list2 != null ? (InterfaceC9236Zb3) AbstractC15401jX0.s0(list2) : null;
        List list3 = (List) AbstractC15401jX0.t0(list, 2);
        c13809gr2.m(interfaceC9236Zb3, list3 != null ? (InterfaceC9236Zb3) AbstractC15401jX0.s0(list3) : null, m(), AbstractC19606qe1.b(0, 0, 0, i, 7, null));
        if (m()) {
            List listM = (List) AbstractC15401jX0.s0(list);
            if (listM == null) {
                listM = AbstractC10360bX0.m();
            }
            return u(listM, i, interfaceC10436bc3.B0(this.d), interfaceC10436bc3.B0(this.f), this.g, this.h, this.i);
        }
        List listM2 = (List) AbstractC15401jX0.s0(list);
        if (listM2 == null) {
            listM2 = AbstractC10360bX0.m();
        }
        return l(listM2, i, interfaceC10436bc3.B0(this.d), interfaceC10436bc3.B0(this.f), this.g, this.h, this.i);
    }

    public int hashCode() {
        return (((((((((((((((Boolean.hashCode(this.a) * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + C17784nZ1.t(this.d)) * 31) + this.e.hashCode()) * 31) + C17784nZ1.t(this.f)) * 31) + Integer.hashCode(this.g)) * 31) + Integer.hashCode(this.h)) * 31) + this.i.hashCode();
    }

    @Override // ir.nasim.InterfaceC16724ll4
    public int i(InterfaceC10436bc3 interfaceC10436bc3, List list, int i) {
        C13809gr2 c13809gr2 = this.i;
        List list2 = (List) AbstractC15401jX0.t0(list, 1);
        InterfaceC9236Zb3 interfaceC9236Zb3 = list2 != null ? (InterfaceC9236Zb3) AbstractC15401jX0.s0(list2) : null;
        List list3 = (List) AbstractC15401jX0.t0(list, 2);
        c13809gr2.m(interfaceC9236Zb3, list3 != null ? (InterfaceC9236Zb3) AbstractC15401jX0.s0(list3) : null, m(), AbstractC19606qe1.b(0, i, 0, 0, 13, null));
        if (m()) {
            List listM = (List) AbstractC15401jX0.s0(list);
            if (listM == null) {
                listM = AbstractC10360bX0.m();
            }
            return l(listM, i, interfaceC10436bc3.B0(this.d), interfaceC10436bc3.B0(this.f), this.g, this.h, this.i);
        }
        List listM2 = (List) AbstractC15401jX0.s0(list);
        if (listM2 == null) {
            listM2 = AbstractC10360bX0.m();
        }
        return o(listM2, i, interfaceC10436bc3.B0(this.d));
    }

    @Override // ir.nasim.InterfaceC15010ir2
    public AbstractC5075Hu1 k() {
        return this.e;
    }

    public final int l(List list, int i, int i2, int i3, int i4, int i5, C13809gr2 c13809gr2) {
        long jB;
        if (list.isEmpty()) {
            jB = C17795na3.b(0, 0);
        } else {
            C11348cr2 c11348cr2 = new C11348cr2(i4, c13809gr2, AbstractC24880zM4.a(0, i, 0, Integer.MAX_VALUE), i5, i2, i3, null);
            InterfaceC9236Zb3 interfaceC9236Zb3 = (InterfaceC9236Zb3) AbstractC15401jX0.t0(list, 0);
            int iQ = interfaceC9236Zb3 != null ? q(interfaceC9236Zb3, i) : 0;
            int iV = interfaceC9236Zb3 != null ? v(interfaceC9236Zb3, iQ) : 0;
            int i6 = 0;
            int iF = 0;
            int i7 = 0;
            if (c11348cr2.b(list.size() > 1, 0, C17795na3.b(i, Integer.MAX_VALUE), interfaceC9236Zb3 == null ? null : C17795na3.a(C17795na3.b(iV, iQ)), 0, 0, 0, false, false).a()) {
                C17795na3 c17795na3F = c13809gr2.f(interfaceC9236Zb3 != null, 0, 0);
                jB = C17795na3.b(c17795na3F != null ? C17795na3.f(c17795na3F.i()) : 0, 0);
            } else {
                int size = list.size();
                int i8 = i;
                int i9 = 0;
                int i10 = 0;
                int i11 = 0;
                while (true) {
                    if (i9 >= size) {
                        break;
                    }
                    int i12 = i8 - iV;
                    int i13 = i9 + 1;
                    int iMax = Math.max(i7, iQ);
                    InterfaceC9236Zb3 interfaceC9236Zb32 = (InterfaceC9236Zb3) AbstractC15401jX0.t0(list, i13);
                    int iQ2 = interfaceC9236Zb32 != null ? q(interfaceC9236Zb32, i) : 0;
                    int iV2 = interfaceC9236Zb32 != null ? v(interfaceC9236Zb32, iQ2) + i2 : 0;
                    boolean z = i9 + 2 < list.size();
                    int i14 = i13 - i11;
                    int i15 = iQ2;
                    C11348cr2.b bVarB = c11348cr2.b(z, i14, C17795na3.b(i12, Integer.MAX_VALUE), interfaceC9236Zb32 == null ? null : C17795na3.a(C17795na3.b(iV2, iQ2)), i6, iF, iMax, false, false);
                    if (bVarB.b()) {
                        iF += iMax + i3;
                        C11348cr2.a aVarA = c11348cr2.a(bVarB, interfaceC9236Zb32 != null, i6, iF, i12, i14);
                        int i16 = iV2 - i2;
                        i6++;
                        if (bVarB.a()) {
                            if (aVarA != null) {
                                long jB2 = aVarA.b();
                                if (!aVarA.c()) {
                                    iF += C17795na3.f(jB2) + i3;
                                }
                            }
                            i10 = i13;
                        } else {
                            i8 = i;
                            iV = i16;
                            i7 = 0;
                            i11 = i13;
                        }
                    } else {
                        i7 = iMax;
                        i8 = i12;
                        iV = iV2;
                    }
                    iQ = i15;
                    i9 = i13;
                    i10 = i9;
                }
                jB = C17795na3.b(iF - i3, i10);
            }
        }
        return C17795na3.e(jB);
    }

    @Override // ir.nasim.InterfaceC15010ir2
    public boolean m() {
        return this.a;
    }

    public final int o(List list, int i, int i2) {
        int i3 = this.g;
        int size = list.size();
        int i4 = 0;
        int iMax = 0;
        int i5 = 0;
        int i6 = 0;
        while (i4 < size) {
            int iP = p((InterfaceC9236Zb3) list.get(i4), i) + i2;
            int i7 = i4 + 1;
            if (i7 - i5 == i3 || i7 == list.size()) {
                iMax = Math.max(iMax, (i6 + iP) - i2);
                i6 = 0;
                i5 = i4;
            } else {
                i6 += iP;
            }
            i4 = i7;
        }
        return iMax;
    }

    public final int p(InterfaceC9236Zb3 interfaceC9236Zb3, int i) {
        return m() ? interfaceC9236Zb3.k0(i) : interfaceC9236Zb3.z(i);
    }

    public final int q(InterfaceC9236Zb3 interfaceC9236Zb3, int i) {
        return m() ? interfaceC9236Zb3.Z(i) : interfaceC9236Zb3.i0(i);
    }

    @Override // ir.nasim.InterfaceC15010ir2
    public C24254yJ.e s() {
        return this.b;
    }

    @Override // ir.nasim.InterfaceC15010ir2
    public C24254yJ.m t() {
        return this.c;
    }

    public String toString() {
        return "FlowMeasurePolicy(isHorizontal=" + this.a + ", horizontalArrangement=" + this.b + ", verticalArrangement=" + this.c + ", mainAxisSpacing=" + ((Object) C17784nZ1.u(this.d)) + ", crossAxisAlignment=" + this.e + ", crossAxisArrangementSpacing=" + ((Object) C17784nZ1.u(this.f)) + ", maxItemsInMainAxis=" + this.g + ", maxLines=" + this.h + ", overflow=" + this.i + ')';
    }

    public final int u(List list, int i, int i2, int i3, int i4, int i5, C13809gr2 c13809gr2) {
        if (list.isEmpty()) {
            return 0;
        }
        int size = list.size();
        int[] iArr = new int[size];
        int size2 = list.size();
        int[] iArr2 = new int[size2];
        int size3 = list.size();
        for (int i6 = 0; i6 < size3; i6++) {
            InterfaceC9236Zb3 interfaceC9236Zb3 = (InterfaceC9236Zb3) list.get(i6);
            int iV = v(interfaceC9236Zb3, i);
            iArr[i6] = iV;
            iArr2[i6] = q(interfaceC9236Zb3, iV);
        }
        int i7 = Integer.MAX_VALUE;
        if (i5 != Integer.MAX_VALUE && i4 != Integer.MAX_VALUE) {
            i7 = i4 * i5;
        }
        int iMin = Math.min(i7 - (((i7 >= list.size() || !(c13809gr2.i() == AbstractC13218fr2.a.c || c13809gr2.i() == AbstractC13218fr2.a.d)) && (i7 < list.size() || i5 < c13809gr2.g() || c13809gr2.i() != AbstractC13218fr2.a.d)) ? 0 : 1), list.size());
        int iT0 = AbstractC10242bK.T0(iArr) + ((list.size() - 1) * i2);
        if (size2 == 0) {
            throw new NoSuchElementException();
        }
        int iE = iArr2[0];
        AbstractC18386oa3 it = new C24411ya3(1, AbstractC10242bK.j0(iArr2)).iterator();
        while (it.hasNext()) {
            int i8 = iArr2[it.b()];
            if (iE < i8) {
                iE = i8;
            }
        }
        if (size == 0) {
            throw new NoSuchElementException();
        }
        int i9 = iArr[0];
        AbstractC18386oa3 it2 = new C24411ya3(1, AbstractC10242bK.j0(iArr)).iterator();
        while (it2.hasNext()) {
            int i10 = iArr[it2.b()];
            if (i9 < i10) {
                i9 = i10;
            }
        }
        int i11 = i9;
        int i12 = iT0;
        int i13 = i12;
        while (i11 <= i13 && iE != i) {
            int i14 = (i11 + i13) / 2;
            int i15 = i13;
            int i16 = i11;
            int i17 = iMin;
            long jF = AbstractC12582er2.f(list, iArr, iArr2, i14, i2, i3, i4, i5, c13809gr2);
            iE = C17795na3.e(jF);
            int iF = C17795na3.f(jF);
            if (iE > i || iF < i17) {
                i11 = i14 + 1;
                if (i11 > i15) {
                    return i11;
                }
                i13 = i15;
                iMin = i17;
                i12 = i14;
            } else {
                if (iE >= i) {
                    return i14;
                }
                i13 = i14 - 1;
                iMin = i17;
                i12 = i14;
                i11 = i16;
            }
        }
        return i12;
    }

    public final int v(InterfaceC9236Zb3 interfaceC9236Zb3, int i) {
        return m() ? interfaceC9236Zb3.i0(i) : interfaceC9236Zb3.Z(i);
    }

    private C15600jr2(boolean z, C24254yJ.e eVar, C24254yJ.m mVar, float f, AbstractC5075Hu1 abstractC5075Hu1, float f2, int i, int i2, C13809gr2 c13809gr2) {
        this.a = z;
        this.b = eVar;
        this.c = mVar;
        this.d = f;
        this.e = abstractC5075Hu1;
        this.f = f2;
        this.g = i;
        this.h = i2;
        this.i = c13809gr2;
    }

    /* renamed from: ir.nasim.jr2$a */
    static final class a extends AbstractC8614Ws3 implements UA2 {
        public static final a e = new a();

        a() {
            super(1);
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((AbstractC21430te5.a) obj);
            return C19938rB7.a;
        }

        public final void a(AbstractC21430te5.a aVar) {
        }
    }

    /* renamed from: ir.nasim.jr2$b */
    static final class b extends AbstractC8614Ws3 implements UA2 {
        public static final b e = new b();

        b() {
            super(1);
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((AbstractC21430te5.a) obj);
            return C19938rB7.a;
        }

        public final void a(AbstractC21430te5.a aVar) {
        }
    }
}
