package ir.nasim;

import ir.nasim.AbstractC21430te5;
import ir.nasim.C24254yJ;
import java.util.ArrayList;
import java.util.List;
import kotlin.KotlinNothingValueException;

/* renamed from: ir.nasim.vv3, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC22851vv3 {

    /* renamed from: ir.nasim.vv3$b */
    static final class b extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ InterfaceC9102Ym4 e;
        final /* synthetic */ List f;
        final /* synthetic */ List g;
        final /* synthetic */ boolean h;

        /* renamed from: ir.nasim.vv3$b$a */
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
                    ((C24031xv3) list.get(i)).t(aVar, z);
                }
                List list2 = this.f;
                boolean z2 = this.g;
                int size2 = list2.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    ((C24031xv3) list2.get(i2)).t(aVar, z2);
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

    /* renamed from: ir.nasim.vv3$c */
    static final class c extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ AbstractC3428Av3 e;
        final /* synthetic */ AbstractC24621yv3 f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(AbstractC3428Av3 abstractC3428Av3, AbstractC24621yv3 abstractC24621yv3) {
            super(1);
            this.e = abstractC3428Av3;
            this.f = abstractC24621yv3;
        }

        public final C24031xv3 a(int i) {
            int iD = this.e.d(i);
            return this.f.a(i, 0, iD, this.e.a(0, iD));
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            return a(((Number) obj).intValue());
        }
    }

    private static final void a(List list, Object[] objArr) {
        for (Object obj : objArr) {
            list.add(obj);
        }
    }

    private static final List b(List list, List list2, List list3, int i, int i2, int i3, int i4, int i5, boolean z, C24254yJ.m mVar, C24254yJ.e eVar, boolean z2, WH1 wh1) {
        int i6 = z ? i2 : i;
        boolean z3 = i3 < Math.min(i6, i4);
        if (z3) {
            if (!(i5 == 0)) {
                P73.c("non-zero firstLineScrollOffset");
            }
        }
        List list4 = list;
        int size = list4.size();
        int length = 0;
        for (int i7 = 0; i7 < size; i7++) {
            length += ((C25215zv3) list.get(i7)).b().length;
        }
        ArrayList arrayList = new ArrayList(length);
        if (z3) {
            if (!(list2.isEmpty() && list3.isEmpty())) {
                P73.a("no items");
            }
            int size2 = list.size();
            int[] iArr = new int[size2];
            for (int i8 = 0; i8 < size2; i8++) {
                iArr[i8] = ((C25215zv3) list.get(c(i8, z2, size2))).c();
            }
            int[] iArr2 = new int[size2];
            if (z) {
                if (mVar == null) {
                    P73.b("null verticalArrangement");
                    throw new KotlinNothingValueException();
                }
                mVar.c(wh1, i6, iArr, iArr2);
            } else {
                if (eVar == null) {
                    P73.b("null horizontalArrangement");
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
                    int iC = iArr2[iO];
                    C25215zv3 c25215zv3 = (C25215zv3) list.get(c(iO, z2, size2));
                    if (z2) {
                        iC = (i6 - iC) - c25215zv3.c();
                    }
                    a(arrayList, c25215zv3.f(iC, i, i2));
                    if (iO == iT) {
                        break;
                    }
                    iO += iV;
                }
            }
        } else {
            int size3 = list2.size() - 1;
            if (size3 >= 0) {
                int iK = i5;
                while (true) {
                    int i9 = size3 - 1;
                    C24031xv3 c24031xv3 = (C24031xv3) list2.get(size3);
                    iK -= c24031xv3.k();
                    c24031xv3.j(iK, 0, i, i2);
                    arrayList.add(c24031xv3);
                    if (i9 < 0) {
                        break;
                    }
                    size3 = i9;
                }
            }
            int size4 = list4.size();
            int iK2 = i5;
            for (int i10 = 0; i10 < size4; i10++) {
                C25215zv3 c25215zv32 = (C25215zv3) list.get(i10);
                a(arrayList, c25215zv32.f(iK2, i, i2));
                iK2 += c25215zv32.d();
            }
            int size5 = list3.size();
            for (int i11 = 0; i11 < size5; i11++) {
                C24031xv3 c24031xv32 = (C24031xv3) list3.get(i11);
                c24031xv32.j(iK2, 0, i, i2);
                arrayList.add(c24031xv32);
                iK2 += c24031xv32.k();
            }
        }
        return arrayList;
    }

    private static final int c(int i, boolean z, int i2) {
        return !z ? i : (i2 - i) - 1;
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00af A[LOOP:1: B:25:0x0074->B:39:0x00af, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00b2 A[EDGE_INSN: B:48:0x00b2->B:40:0x00b2 BREAK  A[LOOP:1: B:25:0x0074->B:39:0x00af], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static final java.util.List d(int r6, int r7, ir.nasim.AbstractC3428Av3 r8, boolean r9, java.util.List r10, ir.nasim.InterfaceC21665tv3 r11) {
        /*
            r0 = 0
            if (r9 == 0) goto Lb2
            if (r11 == 0) goto Lb2
            java.util.List r9 = r11.i()
            java.util.Collection r9 = (java.util.Collection) r9
            boolean r9 = r9.isEmpty()
            r9 = r9 ^ 1
            if (r9 == 0) goto Lb2
            java.util.List r9 = r11.i()
            int r1 = r9.size()
            int r1 = r1 + (-1)
        L1d:
            r2 = -1
            if (r2 >= r1) goto L46
            java.lang.Object r2 = r9.get(r1)
            ir.nasim.lv3 r2 = (ir.nasim.InterfaceC16823lv3) r2
            int r2 = r2.getIndex()
            if (r2 <= r6) goto L43
            if (r1 == 0) goto L3c
            int r2 = r1 + (-1)
            java.lang.Object r2 = r9.get(r2)
            ir.nasim.lv3 r2 = (ir.nasim.InterfaceC16823lv3) r2
            int r2 = r2.getIndex()
            if (r2 > r6) goto L43
        L3c:
            java.lang.Object r6 = r9.get(r1)
            ir.nasim.lv3 r6 = (ir.nasim.InterfaceC16823lv3) r6
            goto L47
        L43:
            int r1 = r1 + (-1)
            goto L1d
        L46:
            r6 = r0
        L47:
            java.util.List r9 = r11.i()
            java.lang.Object r9 = ir.nasim.ZW0.C0(r9)
            ir.nasim.lv3 r9 = (ir.nasim.InterfaceC16823lv3) r9
            java.lang.Object r10 = ir.nasim.ZW0.F0(r10)
            ir.nasim.zv3 r10 = (ir.nasim.C25215zv3) r10
            r11 = 0
            if (r10 == 0) goto L61
            int r10 = r10.a()
            int r10 = r10 + 1
            goto L62
        L61:
            r10 = r11
        L62:
            if (r6 == 0) goto Lb2
            int r6 = r6.getIndex()
            int r9 = r9.getIndex()
            int r7 = r7 + (-1)
            int r7 = java.lang.Math.min(r9, r7)
            if (r6 > r7) goto Lb2
        L74:
            if (r0 == 0) goto L9d
            r9 = r0
            java.util.Collection r9 = (java.util.Collection) r9
            int r9 = r9.size()
            r1 = r11
        L7e:
            if (r1 >= r9) goto L9d
            java.lang.Object r2 = r0.get(r1)
            ir.nasim.zv3 r2 = (ir.nasim.C25215zv3) r2
            ir.nasim.xv3[] r2 = r2.b()
            int r3 = r2.length
            r4 = r11
        L8c:
            if (r4 >= r3) goto L9a
            r5 = r2[r4]
            int r5 = r5.getIndex()
            if (r5 != r6) goto L97
            goto Lad
        L97:
            int r4 = r4 + 1
            goto L8c
        L9a:
            int r1 = r1 + 1
            goto L7e
        L9d:
            if (r0 != 0) goto La4
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
        La4:
            ir.nasim.zv3 r9 = r8.c(r10)
            int r10 = r10 + 1
            r0.add(r9)
        Lad:
            if (r6 == r7) goto Lb2
            int r6 = r6 + 1
            goto L74
        Lb2:
            if (r0 != 0) goto Lb8
            java.util.List r0 = ir.nasim.ZW0.m()
        Lb8:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC22851vv3.d(int, int, ir.nasim.Av3, boolean, java.util.List, ir.nasim.tv3):java.util.List");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:105:0x0228  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x023b  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0286  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x02b5  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x033e  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x0345  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x0351  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x035a  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x037c  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x0381  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x0387  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x038c  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x0396  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x0399  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x03df  */
    /* JADX WARN: Removed duplicated region for block: B:188:0x0431 A[PHI: r5
      0x0431: PHI (r5v8 int) = (r5v7 int), (r5v13 int) binds: [B:172:0x03dd, B:187:0x042f] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:191:0x0456  */
    /* JADX WARN: Removed duplicated region for block: B:195:0x0460  */
    /* JADX WARN: Removed duplicated region for block: B:199:0x0484  */
    /* JADX WARN: Removed duplicated region for block: B:201:0x0489  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x01cd  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x01e1  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x01e5  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x01e7  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x01ea  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0204  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x020a  */
    /* JADX WARN: Type inference failed for: r0v20, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r0v26, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r1v18, types: [java.util.List] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final ir.nasim.C23441wv3 e(int r41, ir.nasim.AbstractC3428Av3 r42, ir.nasim.AbstractC24621yv3 r43, int r44, int r45, int r46, int r47, int r48, int r49, float r50, long r51, boolean r53, ir.nasim.C24254yJ.m r54, ir.nasim.C24254yJ.e r55, boolean r56, ir.nasim.WH1 r57, androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimator r58, int r59, java.util.List r60, boolean r61, boolean r62, ir.nasim.InterfaceC21665tv3 r63, ir.nasim.InterfaceC20315ro1 r64, ir.nasim.InterfaceC9102Ym4 r65, ir.nasim.InterfaceC20014rK2 r66, ir.nasim.UA2 r67, ir.nasim.EN6 r68, ir.nasim.InterfaceC15796kB2 r69) {
        /*
            Method dump skipped, instructions count: 1200
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC22851vv3.e(int, ir.nasim.Av3, ir.nasim.yv3, int, int, int, int, int, int, float, long, boolean, ir.nasim.yJ$m, ir.nasim.yJ$e, boolean, ir.nasim.WH1, androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimator, int, java.util.List, boolean, boolean, ir.nasim.tv3, ir.nasim.ro1, ir.nasim.Ym4, ir.nasim.rK2, ir.nasim.UA2, ir.nasim.EN6, ir.nasim.kB2):ir.nasim.wv3");
    }

    /* renamed from: ir.nasim.vv3$a */
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
