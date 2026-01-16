package ir.nasim;

import ir.nasim.AbstractC21430te5;
import ir.nasim.C24254yJ;
import java.util.ArrayList;
import java.util.List;
import kotlin.KotlinNothingValueException;

/* renamed from: ir.nasim.bx3, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC10645bx3 {

    /* renamed from: ir.nasim.bx3$b */
    static final class b extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ InterfaceC9102Ym4 e;
        final /* synthetic */ List f;
        final /* synthetic */ List g;
        final /* synthetic */ boolean h;

        /* renamed from: ir.nasim.bx3$b$a */
        static final class a extends AbstractC8614Ws3 implements UA2 {
            final /* synthetic */ List e;
            final /* synthetic */ List f;
            final /* synthetic */ boolean g;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(List list, List list2, boolean z) {
                super(1);
                this.e = list;
                this.f = list2;
                this.g = z;
            }

            public final void a(AbstractC21430te5.a aVar) {
                List list = this.e;
                boolean z = this.g;
                int size = list.size();
                for (int i = 0; i < size; i++) {
                    ((C12051dx3) list.get(i)).q(aVar, z);
                }
                List list2 = this.f;
                boolean z2 = this.g;
                int size2 = list2.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    ((C12051dx3) list2.get(i2)).q(aVar, z2);
                }
            }

            @Override // ir.nasim.UA2
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                a((AbstractC21430te5.a) obj);
                return C19938rB7.a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(InterfaceC9102Ym4 interfaceC9102Ym4, List list, List list2, boolean z) {
            super(1);
            this.e = interfaceC9102Ym4;
            this.f = list;
            this.g = list2;
            this.h = z;
        }

        public final void a(AbstractC21430te5.a aVar) {
            aVar.A(new a(this.f, this.g, this.h));
            LG4.a(this.e);
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((AbstractC21430te5.a) obj);
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.bx3$c */
    static final class c extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ AbstractC12642ex3 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(AbstractC12642ex3 abstractC12642ex3) {
            super(1);
            this.e = abstractC12642ex3;
        }

        public final C12051dx3 a(int i) {
            return AbstractC12642ex3.e(this.e, i, 0L, 2, null);
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            return a(((Number) obj).intValue());
        }
    }

    private static final List a(List list, List list2, List list3, int i, int i2, int i3, int i4, int i5, boolean z, C24254yJ.m mVar, C24254yJ.e eVar, boolean z2, WH1 wh1) {
        int i6 = z ? i2 : i;
        int i7 = 0;
        boolean z3 = i3 < Math.min(i6, i4);
        if (z3) {
            if (!(i5 == 0)) {
                P73.c("non-zero itemsScrollOffset");
            }
        }
        ArrayList arrayList = new ArrayList(list.size() + list2.size() + list3.size());
        if (z3) {
            if (!(list2.isEmpty() && list3.isEmpty())) {
                P73.a("no extra items");
            }
            int size = list.size();
            int[] iArr = new int[size];
            while (i7 < size) {
                iArr[i7] = ((C12051dx3) list.get(b(i7, z2, size))).f();
                i7++;
            }
            int[] iArr2 = new int[size];
            if (z) {
                if (mVar == null) {
                    P73.b("null verticalArrangement when isVertical == true");
                    throw new KotlinNothingValueException();
                }
                mVar.c(wh1, i6, iArr, iArr2);
            } else {
                if (eVar == null) {
                    P73.b("null horizontalArrangement when isVertical == false");
                    throw new KotlinNothingValueException();
                }
                eVar.b(wh1, i6, iArr, EnumC12613eu3.a, iArr2);
            }
            C23231wa3 c23231wa3F0 = AbstractC10242bK.f0(iArr2);
            if (z2) {
                c23231wa3F0 = AbstractC23053wG5.u(c23231wa3F0);
            }
            int iO = c23231wa3F0.o();
            int iT = c23231wa3F0.t();
            int iV = c23231wa3F0.v();
            if ((iV > 0 && iO <= iT) || (iV < 0 && iT <= iO)) {
                while (true) {
                    int iF = iArr2[iO];
                    C12051dx3 c12051dx3 = (C12051dx3) list.get(b(iO, z2, size));
                    if (z2) {
                        iF = (i6 - iF) - c12051dx3.f();
                    }
                    c12051dx3.r(iF, i, i2);
                    arrayList.add(c12051dx3);
                    if (iO == iT) {
                        break;
                    }
                    iO += iV;
                }
            }
        } else {
            int size2 = list2.size();
            int iK = i5;
            for (int i8 = 0; i8 < size2; i8++) {
                C12051dx3 c12051dx32 = (C12051dx3) list2.get(i8);
                iK -= c12051dx32.k();
                c12051dx32.r(iK, i, i2);
                arrayList.add(c12051dx32);
            }
            int size3 = list.size();
            int iK2 = i5;
            for (int i9 = 0; i9 < size3; i9++) {
                C12051dx3 c12051dx33 = (C12051dx3) list.get(i9);
                c12051dx33.r(iK2, i, i2);
                arrayList.add(c12051dx33);
                iK2 += c12051dx33.k();
            }
            int size4 = list3.size();
            while (i7 < size4) {
                C12051dx3 c12051dx34 = (C12051dx3) list3.get(i7);
                c12051dx34.r(iK2, i, i2);
                arrayList.add(c12051dx34);
                iK2 += c12051dx34.k();
                i7++;
            }
        }
        return arrayList;
    }

    private static final int b(int i, boolean z, int i2) {
        return !z ? i : (i2 - i) - 1;
    }

    private static final List c(List list, AbstractC12642ex3 abstractC12642ex3, int i, int i2, List list2, float f, boolean z, InterfaceC9425Zw3 interfaceC9425Zw3) {
        ArrayList arrayList;
        InterfaceC7948Tw3 interfaceC7948Tw3;
        C12051dx3 c12051dx3;
        Object obj;
        int iK;
        Object obj2;
        int index;
        int iMin;
        C12051dx3 c12051dx32;
        Object obj3;
        int i3 = i - 1;
        int iMin2 = Math.min(((C12051dx3) AbstractC15401jX0.C0(list)).getIndex() + i2, i3);
        int index2 = ((C12051dx3) AbstractC15401jX0.C0(list)).getIndex() + 1;
        if (index2 <= iMin2) {
            ArrayList arrayList2 = null;
            while (true) {
                if (arrayList2 == null) {
                    arrayList2 = new ArrayList();
                }
                arrayList = arrayList2;
                arrayList.add(AbstractC12642ex3.e(abstractC12642ex3, index2, 0L, 2, null));
                if (index2 == iMin2) {
                    break;
                }
                index2++;
                arrayList2 = arrayList;
            }
        } else {
            arrayList = null;
        }
        if (z && interfaceC9425Zw3 != null && (!interfaceC9425Zw3.i().isEmpty())) {
            List listI = interfaceC9425Zw3.i();
            int size = listI.size();
            while (true) {
                size--;
                if (-1 >= size) {
                    interfaceC7948Tw3 = null;
                    break;
                }
                if (((InterfaceC7948Tw3) listI.get(size)).getIndex() > iMin2 && (size == 0 || ((InterfaceC7948Tw3) listI.get(size - 1)).getIndex() <= iMin2)) {
                    break;
                }
            }
            interfaceC7948Tw3 = (InterfaceC7948Tw3) listI.get(size);
            InterfaceC7948Tw3 interfaceC7948Tw32 = (InterfaceC7948Tw3) AbstractC15401jX0.C0(interfaceC9425Zw3.i());
            if (interfaceC7948Tw3 != null && (index = interfaceC7948Tw3.getIndex()) <= (iMin = Math.min(interfaceC7948Tw32.getIndex(), i3))) {
                while (true) {
                    if (arrayList != null) {
                        int size2 = arrayList.size();
                        int i4 = 0;
                        while (true) {
                            if (i4 >= size2) {
                                obj3 = null;
                                break;
                            }
                            obj3 = arrayList.get(i4);
                            if (((C12051dx3) obj3).getIndex() == index) {
                                break;
                            }
                            i4++;
                        }
                        c12051dx32 = (C12051dx3) obj3;
                    } else {
                        c12051dx32 = null;
                    }
                    if (c12051dx32 == null) {
                        if (arrayList == null) {
                            arrayList = new ArrayList();
                        }
                        arrayList.add(AbstractC12642ex3.e(abstractC12642ex3, index, 0L, 2, null));
                    }
                    if (index == iMin) {
                        break;
                    }
                    index++;
                }
            }
            float fD = ((interfaceC9425Zw3.d() - interfaceC7948Tw32.getOffset()) - interfaceC7948Tw32.f()) - f;
            if (fD > 0.0f) {
                int index3 = interfaceC7948Tw32.getIndex() + 1;
                int i5 = 0;
                while (index3 < i && i5 < fD) {
                    if (index3 <= iMin2) {
                        int size3 = list.size();
                        int i6 = 0;
                        while (true) {
                            if (i6 >= size3) {
                                obj2 = null;
                                break;
                            }
                            obj2 = list.get(i6);
                            if (((C12051dx3) obj2).getIndex() == index3) {
                                break;
                            }
                            i6++;
                        }
                        c12051dx3 = (C12051dx3) obj2;
                    } else if (arrayList != null) {
                        int size4 = arrayList.size();
                        int i7 = 0;
                        while (true) {
                            if (i7 >= size4) {
                                obj = null;
                                break;
                            }
                            obj = arrayList.get(i7);
                            if (((C12051dx3) obj).getIndex() == index3) {
                                break;
                            }
                            i7++;
                        }
                        c12051dx3 = (C12051dx3) obj;
                    } else {
                        c12051dx3 = null;
                    }
                    if (c12051dx3 != null) {
                        index3++;
                        iK = c12051dx3.k();
                    } else {
                        if (arrayList == null) {
                            arrayList = new ArrayList();
                        }
                        arrayList.add(AbstractC12642ex3.e(abstractC12642ex3, index3, 0L, 2, null));
                        index3++;
                        iK = ((C12051dx3) AbstractC15401jX0.C0(arrayList)).k();
                    }
                    i5 += iK;
                }
            }
        }
        if (arrayList != null && ((C12051dx3) AbstractC15401jX0.C0(arrayList)).getIndex() > iMin2) {
            iMin2 = ((C12051dx3) AbstractC15401jX0.C0(arrayList)).getIndex();
        }
        int size5 = list2.size();
        for (int i8 = 0; i8 < size5; i8++) {
            int iIntValue = ((Number) list2.get(i8)).intValue();
            if (iIntValue > iMin2) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(AbstractC12642ex3.e(abstractC12642ex3, iIntValue, 0L, 2, null));
            }
        }
        return arrayList == null ? AbstractC10360bX0.m() : arrayList;
    }

    private static final List d(int i, AbstractC12642ex3 abstractC12642ex3, int i2, List list) {
        int iMax = Math.max(0, i - i2);
        int i3 = i - 1;
        ArrayList arrayList = null;
        if (iMax <= i3) {
            while (true) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(AbstractC12642ex3.e(abstractC12642ex3, i3, 0L, 2, null));
                if (i3 == iMax) {
                    break;
                }
                i3--;
            }
        }
        int size = list.size() - 1;
        if (size >= 0) {
            while (true) {
                int i4 = size - 1;
                int iIntValue = ((Number) list.get(size)).intValue();
                if (iIntValue < iMax) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(AbstractC12642ex3.e(abstractC12642ex3, iIntValue, 0L, 2, null));
                }
                if (i4 < 0) {
                    break;
                }
                size = i4;
            }
        }
        return arrayList == null ? AbstractC10360bX0.m() : arrayList;
    }

    /* JADX WARN: Removed duplicated region for block: B:149:0x041e  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x0454  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x04b8  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x04bd  */
    /* JADX WARN: Removed duplicated region for block: B:179:0x04c1  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x04c6  */
    /* JADX WARN: Removed duplicated region for block: B:183:0x04ce  */
    /* JADX WARN: Removed duplicated region for block: B:185:0x04d3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final ir.nasim.C11408cx3 e(int r37, ir.nasim.AbstractC12642ex3 r38, int r39, int r40, int r41, int r42, int r43, int r44, float r45, long r46, boolean r48, ir.nasim.C24254yJ.m r49, ir.nasim.C24254yJ.e r50, boolean r51, ir.nasim.WH1 r52, androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimator r53, int r54, java.util.List r55, boolean r56, boolean r57, ir.nasim.InterfaceC9425Zw3 r58, ir.nasim.InterfaceC20315ro1 r59, ir.nasim.InterfaceC9102Ym4 r60, ir.nasim.InterfaceC20014rK2 r61, ir.nasim.EN6 r62, ir.nasim.InterfaceC15796kB2 r63) {
        /*
            Method dump skipped, instructions count: 1278
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC10645bx3.e(int, ir.nasim.ex3, int, int, int, int, int, int, float, long, boolean, ir.nasim.yJ$m, ir.nasim.yJ$e, boolean, ir.nasim.WH1, androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimator, int, java.util.List, boolean, boolean, ir.nasim.Zw3, ir.nasim.ro1, ir.nasim.Ym4, ir.nasim.rK2, ir.nasim.EN6, ir.nasim.kB2):ir.nasim.cx3");
    }

    /* renamed from: ir.nasim.bx3$a */
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
}
