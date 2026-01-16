package ir.nasim;

import ir.nasim.AbstractC21430te5;
import ir.nasim.C24254yJ;
import ir.nasim.InterfaceC12529em;
import java.util.ArrayList;
import java.util.List;

/* renamed from: ir.nasim.rT4, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC20097rT4 {

    /* renamed from: ir.nasim.rT4$a */
    static final class a extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ InterfaceC9102Ym4 e;
        final /* synthetic */ List f;

        /* renamed from: ir.nasim.rT4$a$a, reason: collision with other inner class name */
        static final class C1500a extends AbstractC8614Ws3 implements UA2 {
            final /* synthetic */ List e;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C1500a(List list) {
                super(1);
                this.e = list;
            }

            public final void a(AbstractC21430te5.a aVar) {
                List list = this.e;
                int size = list.size();
                for (int i = 0; i < size; i++) {
                    ((C14806iW3) list.get(i)).g(aVar);
                }
            }

            @Override // ir.nasim.UA2
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                a((AbstractC21430te5.a) obj);
                return C19938rB7.a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(InterfaceC9102Ym4 interfaceC9102Ym4, List list) {
            super(1);
            this.e = interfaceC9102Ym4;
            this.f = list;
        }

        public final void a(AbstractC21430te5.a aVar) {
            aVar.A(new C1500a(this.f));
            LG4.a(this.e);
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((AbstractC21430te5.a) obj);
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.rT4$c */
    static final class c extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ InterfaceC23450ww3 e;
        final /* synthetic */ long f;
        final /* synthetic */ C19506qT4 g;
        final /* synthetic */ long h;
        final /* synthetic */ EnumC24286yM4 i;
        final /* synthetic */ InterfaceC12529em.b j;
        final /* synthetic */ InterfaceC12529em.c k;
        final /* synthetic */ boolean l;
        final /* synthetic */ int m;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(InterfaceC23450ww3 interfaceC23450ww3, long j, C19506qT4 c19506qT4, long j2, EnumC24286yM4 enumC24286yM4, InterfaceC12529em.b bVar, InterfaceC12529em.c cVar, boolean z, int i) {
            super(1);
            this.e = interfaceC23450ww3;
            this.f = j;
            this.g = c19506qT4;
            this.h = j2;
            this.i = enumC24286yM4;
            this.j = bVar;
            this.k = cVar;
            this.l = z;
            this.m = i;
        }

        public final C14806iW3 a(int i) {
            InterfaceC23450ww3 interfaceC23450ww3 = this.e;
            return AbstractC20097rT4.g(interfaceC23450ww3, i, this.f, this.g, this.h, this.i, this.j, this.k, interfaceC23450ww3.getLayoutDirection(), this.l, this.m);
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            return a(((Number) obj).intValue());
        }
    }

    /* renamed from: ir.nasim.rT4$d */
    static final class d extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ InterfaceC23450ww3 e;
        final /* synthetic */ long f;
        final /* synthetic */ C19506qT4 g;
        final /* synthetic */ long h;
        final /* synthetic */ EnumC24286yM4 i;
        final /* synthetic */ InterfaceC12529em.b j;
        final /* synthetic */ InterfaceC12529em.c k;
        final /* synthetic */ boolean l;
        final /* synthetic */ int m;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(InterfaceC23450ww3 interfaceC23450ww3, long j, C19506qT4 c19506qT4, long j2, EnumC24286yM4 enumC24286yM4, InterfaceC12529em.b bVar, InterfaceC12529em.c cVar, boolean z, int i) {
            super(1);
            this.e = interfaceC23450ww3;
            this.f = j;
            this.g = c19506qT4;
            this.h = j2;
            this.i = enumC24286yM4;
            this.j = bVar;
            this.k = cVar;
            this.l = z;
            this.m = i;
        }

        public final C14806iW3 a(int i) {
            InterfaceC23450ww3 interfaceC23450ww3 = this.e;
            return AbstractC20097rT4.g(interfaceC23450ww3, i, this.f, this.g, this.h, this.i, this.j, this.k, interfaceC23450ww3.getLayoutDirection(), this.l, this.m);
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            return a(((Number) obj).intValue());
        }
    }

    private static final C14806iW3 b(int i, List list, int i2, int i3, int i4, FG6 fg6, int i5) {
        Object obj;
        if (list.isEmpty()) {
            obj = null;
        } else {
            Object obj2 = list.get(0);
            C14806iW3 c14806iW3 = (C14806iW3) obj2;
            float f = -Math.abs(GG6.a(i, i2, i3, i4, c14806iW3.getOffset(), c14806iW3.getIndex(), fg6, i5));
            int iO = AbstractC10360bX0.o(list);
            int i6 = 1;
            if (1 <= iO) {
                while (true) {
                    Object obj3 = list.get(i6);
                    C14806iW3 c14806iW32 = (C14806iW3) obj3;
                    float f2 = -Math.abs(GG6.a(i, i2, i3, i4, c14806iW32.getOffset(), c14806iW32.getIndex(), fg6, i5));
                    if (Float.compare(f, f2) < 0) {
                        obj2 = obj3;
                        f = f2;
                    }
                    if (i6 == iO) {
                        break;
                    }
                    i6++;
                }
            }
            obj = obj2;
        }
        return (C14806iW3) obj;
    }

    private static final List c(InterfaceC23450ww3 interfaceC23450ww3, List list, List list2, List list3, int i, int i2, int i3, int i4, int i5, EnumC24286yM4 enumC24286yM4, boolean z, WH1 wh1, int i6, int i7) {
        int i8;
        int i9;
        ArrayList arrayList;
        int i10;
        int i11 = i5;
        int i12 = i7 + i6;
        if (enumC24286yM4 == EnumC24286yM4.a) {
            i8 = i4;
            i9 = i2;
        } else {
            i8 = i4;
            i9 = i;
        }
        int i13 = 0;
        boolean z2 = i3 < Math.min(i9, i8);
        if (z2) {
            if (!(i11 == 0)) {
                P73.c("non-zero pagesScrollOffset=" + i11);
            }
        }
        ArrayList arrayList2 = new ArrayList(list.size() + list2.size() + list3.size());
        if (z2) {
            if (!(list2.isEmpty() && list3.isEmpty())) {
                P73.a("No extra pages");
            }
            int size = list.size();
            int[] iArr = new int[size];
            while (i13 < size) {
                iArr[i13] = i7;
                i13++;
            }
            int[] iArr2 = new int[size];
            C24254yJ.f fVarC = C24254yJ.a.a.c(interfaceC23450ww3.D(i6));
            if (enumC24286yM4 == EnumC24286yM4.a) {
                fVarC.c(wh1, i9, iArr, iArr2);
                arrayList = arrayList2;
                i10 = i9;
            } else {
                arrayList = arrayList2;
                i10 = i9;
                fVarC.b(wh1, i9, iArr, EnumC12613eu3.a, iArr2);
            }
            C23231wa3 c23231wa3F0 = AbstractC10242bK.f0(iArr2);
            if (z) {
                c23231wa3F0 = AbstractC23053wG5.u(c23231wa3F0);
            }
            int iO = c23231wa3F0.o();
            int iT = c23231wa3F0.t();
            int iV = c23231wa3F0.v();
            if ((iV > 0 && iO <= iT) || (iV < 0 && iT <= iO)) {
                while (true) {
                    int iF = iArr2[iO];
                    C14806iW3 c14806iW3 = (C14806iW3) list.get(d(iO, z, size));
                    if (z) {
                        iF = (i10 - iF) - c14806iW3.f();
                    }
                    c14806iW3.h(iF, i, i2);
                    arrayList.add(c14806iW3);
                    if (iO == iT) {
                        break;
                    }
                    iO += iV;
                }
            }
        } else {
            arrayList = arrayList2;
            int size2 = list2.size();
            int i14 = i11;
            for (int i15 = 0; i15 < size2; i15++) {
                C14806iW3 c14806iW32 = (C14806iW3) list2.get(i15);
                i14 -= i12;
                c14806iW32.h(i14, i, i2);
                arrayList.add(c14806iW32);
            }
            int size3 = list.size();
            for (int i16 = 0; i16 < size3; i16++) {
                C14806iW3 c14806iW33 = (C14806iW3) list.get(i16);
                c14806iW33.h(i11, i, i2);
                arrayList.add(c14806iW33);
                i11 += i12;
            }
            int size4 = list3.size();
            while (i13 < size4) {
                C14806iW3 c14806iW34 = (C14806iW3) list3.get(i13);
                c14806iW34.h(i11, i, i2);
                arrayList.add(c14806iW34);
                i11 += i12;
                i13++;
            }
        }
        return arrayList;
    }

    private static final int d(int i, boolean z, int i2) {
        return !z ? i : (i2 - i) - 1;
    }

    private static final List e(int i, int i2, int i3, List list, UA2 ua2) {
        int iMin = Math.min(i3 + i, i2 - 1);
        int i4 = i + 1;
        ArrayList arrayList = null;
        if (i4 <= iMin) {
            while (true) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(ua2.invoke(Integer.valueOf(i4)));
                if (i4 == iMin) {
                    break;
                }
                i4++;
            }
        }
        int size = list.size();
        for (int i5 = 0; i5 < size; i5++) {
            int iIntValue = ((Number) list.get(i5)).intValue();
            if (iMin + 1 <= iIntValue && iIntValue < i2) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(ua2.invoke(Integer.valueOf(iIntValue)));
            }
        }
        return arrayList == null ? AbstractC10360bX0.m() : arrayList;
    }

    private static final List f(int i, int i2, List list, UA2 ua2) {
        int iMax = Math.max(0, i - i2);
        int i3 = i - 1;
        ArrayList arrayList = null;
        if (iMax <= i3) {
            while (true) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(ua2.invoke(Integer.valueOf(i3)));
                if (i3 == iMax) {
                    break;
                }
                i3--;
            }
        }
        int size = list.size();
        for (int i4 = 0; i4 < size; i4++) {
            int iIntValue = ((Number) list.get(i4)).intValue();
            if (iIntValue < iMax) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(ua2.invoke(Integer.valueOf(iIntValue)));
            }
        }
        return arrayList == null ? AbstractC10360bX0.m() : arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C14806iW3 g(InterfaceC23450ww3 interfaceC23450ww3, int i, long j, C19506qT4 c19506qT4, long j2, EnumC24286yM4 enumC24286yM4, InterfaceC12529em.b bVar, InterfaceC12529em.c cVar, EnumC12613eu3 enumC12613eu3, boolean z, int i2) {
        return new C14806iW3(i, i2, interfaceC23450ww3.n0(i, j), j2, c19506qT4.d(i), enumC24286yM4, bVar, cVar, enumC12613eu3, z, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final C21326tT4 h(InterfaceC23450ww3 interfaceC23450ww3, int i, C19506qT4 c19506qT4, int i2, int i3, int i4, int i5, int i6, int i7, long j, EnumC24286yM4 enumC24286yM4, InterfaceC12529em.c cVar, InterfaceC12529em.b bVar, boolean z, long j2, int i8, int i9, List list, FG6 fg6, InterfaceC9102Ym4 interfaceC9102Ym4, InterfaceC20315ro1 interfaceC20315ro1, InterfaceC15796kB2 interfaceC15796kB2) {
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        C14806iW3 c14806iW3;
        int i16;
        List list2;
        List arrayList;
        List arrayList2;
        int i17 = 0;
        if (!(i3 >= 0)) {
            P73.a("negative beforeContentPadding");
        }
        if (!(i4 >= 0)) {
            P73.a("negative afterContentPadding");
        }
        int iE = AbstractC23053wG5.e(i8 + i5, 0);
        if (i <= 0) {
            return new C21326tT4(AbstractC10360bX0.m(), i8, i5, i4, enumC24286yM4, -i3, i2 + i4, false, i9, null, null, 0.0f, 0, false, fg6, (InterfaceC11734dW3) interfaceC15796kB2.q(Integer.valueOf(C17833ne1.n(j)), Integer.valueOf(C17833ne1.m(j)), b.e), false, null, null, interfaceC20315ro1, 393216, null);
        }
        EnumC24286yM4 enumC24286yM42 = EnumC24286yM4.a;
        long jB = AbstractC19606qe1.b(0, enumC24286yM4 == enumC24286yM42 ? C17833ne1.l(j) : i8, 0, enumC24286yM4 != enumC24286yM42 ? C17833ne1.k(j) : i8, 5, null);
        int i18 = i6;
        int i19 = i7;
        while (i18 > 0 && i19 > 0) {
            i18--;
            i19 -= iE;
        }
        int i20 = i19 * (-1);
        if (i18 >= i) {
            i18 = i - 1;
            i20 = 0;
        }
        BJ bj = new BJ();
        int i21 = -i3;
        int i22 = (i5 < 0 ? i5 : 0) + i21;
        int i23 = i20 + i22;
        int iMax = 0;
        while (i23 < 0 && i18 > 0) {
            int i24 = i18 - 1;
            BJ bj2 = bj;
            int i25 = i17;
            int i26 = iE;
            C14806iW3 c14806iW3G = g(interfaceC23450ww3, i24, jB, c19506qT4, j2, enumC24286yM4, bVar, cVar, interfaceC23450ww3.getLayoutDirection(), z, i8);
            bj2.add(i25, c14806iW3G);
            iMax = Math.max(iMax, c14806iW3G.b());
            i23 += i26;
            i18 = i24;
            i22 = i22;
            bj = bj2;
            i17 = i25;
            iE = i26;
            i21 = i21;
        }
        int i27 = i23;
        int i28 = i21;
        int i29 = i22;
        BJ bj3 = bj;
        int i30 = i17;
        int i31 = iE;
        int i32 = (i27 < i29 ? i29 : i27) - i29;
        int i33 = i2 + i4;
        int iE2 = AbstractC23053wG5.e(i33, i30);
        int i34 = -i32;
        int i35 = i30;
        int i36 = i35;
        int i37 = i18;
        while (i35 < bj3.size()) {
            if (i34 >= iE2) {
                bj3.remove(i35);
                i36 = 1;
            } else {
                i37++;
                i34 += i31;
                i35++;
            }
        }
        int i38 = i18;
        int i39 = i32;
        int i40 = i36;
        int i41 = i37;
        int i42 = i34;
        while (i41 < i && (i42 < iE2 || i42 <= 0 || bj3.isEmpty())) {
            int i43 = i33;
            int i44 = i41;
            int i45 = i38;
            int i46 = iE2;
            int i47 = i42;
            int i48 = i31;
            C14806iW3 c14806iW3G2 = g(interfaceC23450ww3, i41, jB, c19506qT4, j2, enumC24286yM4, bVar, cVar, interfaceC23450ww3.getLayoutDirection(), z, i8);
            int i49 = i - 1;
            i42 = (i44 == i49 ? i8 : i48) + i47;
            if (i42 > i29 || i44 == i49) {
                iMax = Math.max(iMax, c14806iW3G2.b());
                bj3.add(c14806iW3G2);
                i38 = i45;
            } else {
                i39 -= i48;
                i38 = i44 + 1;
                i40 = 1;
            }
            i41 = i44 + 1;
            i33 = i43;
            i31 = i48;
            iE2 = i46;
        }
        int i50 = i38;
        int i51 = i33;
        int i52 = i41;
        int i53 = i42;
        int i54 = i31;
        if (i53 < i2) {
            int i55 = i2 - i53;
            int i56 = i39 - i55;
            int i57 = i55 + i53;
            int i58 = i3;
            i15 = i50;
            int i59 = i54;
            int i60 = i56;
            while (i60 < i58 && i15 > 0) {
                i15--;
                int i61 = i52;
                int i62 = i59;
                C14806iW3 c14806iW3G3 = g(interfaceC23450ww3, i15, jB, c19506qT4, j2, enumC24286yM4, bVar, cVar, interfaceC23450ww3.getLayoutDirection(), z, i8);
                bj3.add(0, c14806iW3G3);
                iMax = Math.max(iMax, c14806iW3G3.b());
                i60 += i62;
                i58 = i3;
                i59 = i62;
                i52 = i61;
            }
            i10 = i52;
            i11 = i59;
            i12 = 0;
            if (i60 < 0) {
                i13 = i57 + i60;
                i14 = 0;
            } else {
                i14 = i60;
                i13 = i57;
            }
        } else {
            i10 = i52;
            i11 = i54;
            i12 = 0;
            i13 = i53;
            i14 = i39;
            i15 = i50;
        }
        if ((i14 >= 0 ? 1 : i12) == 0) {
            P73.a("invalid currentFirstPageScrollOffset");
        }
        int i63 = -i14;
        C14806iW3 c14806iW32 = (C14806iW3) bj3.first();
        if (i3 > 0 || i5 < 0) {
            int size = bj3.size();
            int i64 = i14;
            int i65 = i12;
            while (i65 < size && i64 != 0 && i11 <= i64 && i65 != AbstractC10360bX0.o(bj3)) {
                i64 -= i11;
                i65++;
                c14806iW32 = (C14806iW3) bj3.get(i65);
            }
            c14806iW3 = c14806iW32;
            i16 = i64;
        } else {
            i16 = i14;
            c14806iW3 = c14806iW32;
        }
        int i66 = iMax;
        int i67 = i11;
        C14806iW3 c14806iW33 = c14806iW3;
        int i68 = i12;
        List listF = f(i15, i9, list, new d(interfaceC23450ww3, jB, c19506qT4, j2, enumC24286yM4, bVar, cVar, z, i8));
        int size2 = listF.size();
        int iMax2 = i66;
        for (int i69 = i68; i69 < size2; i69++) {
            iMax2 = Math.max(iMax2, ((C14806iW3) listF.get(i69)).b());
        }
        List listE = e(((C14806iW3) bj3.last()).getIndex(), i, i9, list, new c(interfaceC23450ww3, jB, c19506qT4, j2, enumC24286yM4, bVar, cVar, z, i8));
        int size3 = listE.size();
        int iMax3 = iMax2;
        for (int i70 = i68; i70 < size3; i70++) {
            iMax3 = Math.max(iMax3, ((C14806iW3) listE.get(i70)).b());
        }
        int i71 = (AbstractC13042fc3.d(c14806iW33, bj3.first()) && listF.isEmpty() && listE.isEmpty()) ? 1 : i68;
        EnumC24286yM4 enumC24286yM43 = EnumC24286yM4.a;
        int iG = AbstractC19606qe1.g(j, enumC24286yM4 == enumC24286yM43 ? iMax3 : i13);
        if (enumC24286yM4 == enumC24286yM43) {
            iMax3 = i13;
        }
        int iF = AbstractC19606qe1.f(j, iMax3);
        List listC = c(interfaceC23450ww3, bj3, listF, listE, iG, iF, i13, i2, i63, enumC24286yM4, z, interfaceC23450ww3, i5, i8);
        if (i71 != 0) {
            list2 = listC;
        } else {
            ArrayList arrayList3 = new ArrayList(listC.size());
            int size4 = listC.size();
            for (int i72 = i68; i72 < size4; i72++) {
                Object obj = listC.get(i72);
                C14806iW3 c14806iW34 = (C14806iW3) obj;
                if (c14806iW34.getIndex() >= ((C14806iW3) bj3.first()).getIndex() && c14806iW34.getIndex() <= ((C14806iW3) bj3.last()).getIndex()) {
                    arrayList3.add(obj);
                }
            }
            list2 = arrayList3;
        }
        if (listF.isEmpty()) {
            arrayList = AbstractC10360bX0.m();
        } else {
            arrayList = new ArrayList(listC.size());
            int size5 = listC.size();
            for (int i73 = i68; i73 < size5; i73++) {
                Object obj2 = listC.get(i73);
                if (((C14806iW3) obj2).getIndex() < ((C14806iW3) bj3.first()).getIndex()) {
                    arrayList.add(obj2);
                }
            }
        }
        List list3 = arrayList;
        if (listE.isEmpty()) {
            arrayList2 = AbstractC10360bX0.m();
        } else {
            arrayList2 = new ArrayList(listC.size());
            int size6 = listC.size();
            for (int i74 = i68; i74 < size6; i74++) {
                Object obj3 = listC.get(i74);
                if (((C14806iW3) obj3).getIndex() > ((C14806iW3) bj3.last()).getIndex()) {
                    arrayList2.add(obj3);
                }
            }
        }
        List list4 = arrayList2;
        int i75 = i10;
        int i76 = i13;
        C14806iW3 c14806iW3B = b(i2 + i3 + i4, list2, i3, i4, i67, fg6, i);
        return new C21326tT4(list2, i8, i5, i4, enumC24286yM4, i28, i51, z, i9, c14806iW33, c14806iW3B, i67 == 0 ? 0.0f : AbstractC23053wG5.l((fg6.a(r10, i8, i3, i4, c14806iW3B != null ? c14806iW3B.getIndex() : i68, i) - (c14806iW3B != null ? c14806iW3B.getOffset() : i68)) / i67, -0.5f, 0.5f), i16, (i75 < i || i76 > i2) ? 1 : i68, fg6, (InterfaceC11734dW3) interfaceC15796kB2.q(Integer.valueOf(iG), Integer.valueOf(iF), new a(interfaceC9102Ym4, listC)), i40, list3, list4, interfaceC20315ro1);
    }

    /* renamed from: ir.nasim.rT4$b */
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
