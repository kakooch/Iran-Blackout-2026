package ir.nasim;

import androidx.compose.runtime.snapshots.g;
import ir.nasim.C24254yJ;
import ir.nasim.C5788Kv3;
import java.util.ArrayList;
import java.util.List;
import kotlin.KotlinNothingValueException;

/* renamed from: ir.nasim.sv3, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC20978sv3 {

    /* renamed from: ir.nasim.sv3$a */
    static final class a extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
        final /* synthetic */ androidx.compose.ui.e e;
        final /* synthetic */ C6021Lv3 f;
        final /* synthetic */ InterfaceC5086Hv3 g;
        final /* synthetic */ TS4 h;
        final /* synthetic */ boolean i;
        final /* synthetic */ boolean j;
        final /* synthetic */ InterfaceC7645Sp2 k;
        final /* synthetic */ boolean l;
        final /* synthetic */ InterfaceC14124hO4 m;
        final /* synthetic */ C24254yJ.m n;
        final /* synthetic */ C24254yJ.e o;
        final /* synthetic */ UA2 p;
        final /* synthetic */ int q;
        final /* synthetic */ int r;
        final /* synthetic */ int s;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(androidx.compose.ui.e eVar, C6021Lv3 c6021Lv3, InterfaceC5086Hv3 interfaceC5086Hv3, TS4 ts4, boolean z, boolean z2, InterfaceC7645Sp2 interfaceC7645Sp2, boolean z3, InterfaceC14124hO4 interfaceC14124hO4, C24254yJ.m mVar, C24254yJ.e eVar2, UA2 ua2, int i, int i2, int i3) {
            super(2);
            this.e = eVar;
            this.f = c6021Lv3;
            this.g = interfaceC5086Hv3;
            this.h = ts4;
            this.i = z;
            this.j = z2;
            this.k = interfaceC7645Sp2;
            this.l = z3;
            this.m = interfaceC14124hO4;
            this.n = mVar;
            this.o = eVar2;
            this.p = ua2;
            this.q = i;
            this.r = i2;
            this.s = i3;
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            AbstractC20978sv3.a(this.e, this.f, this.g, this.h, this.i, this.j, this.k, this.l, this.m, this.n, this.o, this.p, interfaceC22053ub1, QJ5.a(this.q | 1), QJ5.a(this.r), this.s);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.sv3$b */
    static final class b extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
        final /* synthetic */ C6021Lv3 e;
        final /* synthetic */ boolean f;
        final /* synthetic */ TS4 g;
        final /* synthetic */ boolean h;
        final /* synthetic */ SA2 i;
        final /* synthetic */ InterfaceC5086Hv3 j;
        final /* synthetic */ C24254yJ.m k;
        final /* synthetic */ C24254yJ.e l;
        final /* synthetic */ InterfaceC20315ro1 m;
        final /* synthetic */ InterfaceC20014rK2 n;
        final /* synthetic */ EN6 o;

        /* renamed from: ir.nasim.sv3$b$a */
        static final class a extends AbstractC8614Ws3 implements InterfaceC15796kB2 {
            final /* synthetic */ InterfaceC23450ww3 e;
            final /* synthetic */ long f;
            final /* synthetic */ int g;
            final /* synthetic */ int h;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(InterfaceC23450ww3 interfaceC23450ww3, long j, int i, int i2) {
                super(3);
                this.e = interfaceC23450ww3;
                this.f = j;
                this.g = i;
                this.h = i2;
            }

            public final InterfaceC11734dW3 a(int i, int i2, UA2 ua2) {
                return this.e.P1(AbstractC19606qe1.g(this.f, i + this.g), AbstractC19606qe1.f(this.f, i2 + this.h), AbstractC20051rO3.k(), ua2);
            }

            @Override // ir.nasim.InterfaceC15796kB2
            public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
                return a(((Number) obj).intValue(), ((Number) obj2).intValue(), (UA2) obj3);
            }
        }

        /* renamed from: ir.nasim.sv3$b$b, reason: collision with other inner class name */
        public static final class C1552b extends AbstractC24621yv3 {
            final /* synthetic */ InterfaceC23450ww3 d;
            final /* synthetic */ C6021Lv3 e;
            final /* synthetic */ boolean f;
            final /* synthetic */ boolean g;
            final /* synthetic */ int h;
            final /* synthetic */ int i;
            final /* synthetic */ long j;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C1552b(InterfaceC17414mv3 interfaceC17414mv3, InterfaceC23450ww3 interfaceC23450ww3, int i, C6021Lv3 c6021Lv3, boolean z, boolean z2, int i2, int i3, long j) {
                super(interfaceC17414mv3, interfaceC23450ww3, i);
                this.d = interfaceC23450ww3;
                this.e = c6021Lv3;
                this.f = z;
                this.g = z2;
                this.h = i2;
                this.i = i3;
                this.j = j;
            }

            @Override // ir.nasim.AbstractC24621yv3
            public C24031xv3 b(int i, Object obj, Object obj2, int i2, int i3, List list, long j, int i4, int i5) {
                return new C24031xv3(i, obj, this.f, i2, i3, this.g, this.d.getLayoutDirection(), this.h, this.i, list, this.j, obj2, this.e.t(), j, i4, i5, null);
            }
        }

        /* renamed from: ir.nasim.sv3$b$c */
        public static final class c extends AbstractC3428Av3 {
            final /* synthetic */ boolean g;
            final /* synthetic */ C4852Gv3 h;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            c(boolean z, C4852Gv3 c4852Gv3, int i, int i2, C1552b c1552b, C5788Kv3 c5788Kv3) {
                super(z, c4852Gv3, i, i2, c1552b, c5788Kv3);
                this.g = z;
                this.h = c4852Gv3;
            }

            @Override // ir.nasim.AbstractC3428Av3
            public C25215zv3 b(int i, C24031xv3[] c24031xv3Arr, List list, int i2) {
                return new C25215zv3(i, c24031xv3Arr, this.h, list, this.g, i2);
            }
        }

        /* renamed from: ir.nasim.sv3$b$d */
        static final class d extends AbstractC8614Ws3 implements UA2 {
            final /* synthetic */ C5788Kv3 e;
            final /* synthetic */ c f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            d(C5788Kv3 c5788Kv3, c cVar) {
                super(1);
                this.e = c5788Kv3;
                this.f = cVar;
            }

            public final ArrayList a(int i) {
                C5788Kv3.c cVarC = this.e.c(i);
                int iA = cVarC.a();
                ArrayList arrayList = new ArrayList(cVarC.b().size());
                List listB = cVarC.b();
                c cVar = this.f;
                int size = listB.size();
                int i2 = 0;
                for (int i3 = 0; i3 < size; i3++) {
                    int iD = C10870cL2.d(((C10870cL2) listB.get(i3)).g());
                    arrayList.add(AbstractC4616Fw7.a(Integer.valueOf(iA), C17833ne1.a(cVar.a(i2, iD))));
                    iA++;
                    i2 += iD;
                }
                return arrayList;
            }

            @Override // ir.nasim.UA2
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                return a(((Number) obj).intValue());
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(C6021Lv3 c6021Lv3, boolean z, TS4 ts4, boolean z2, SA2 sa2, InterfaceC5086Hv3 interfaceC5086Hv3, C24254yJ.m mVar, C24254yJ.e eVar, InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20014rK2 interfaceC20014rK2, EN6 en6) {
            super(2);
            this.e = c6021Lv3;
            this.f = z;
            this.g = ts4;
            this.h = z2;
            this.i = sa2;
            this.j = interfaceC5086Hv3;
            this.k = mVar;
            this.l = eVar;
            this.m = interfaceC20315ro1;
            this.n = interfaceC20014rK2;
            this.o = en6;
        }

        public final C23441wv3 a(InterfaceC23450ww3 interfaceC23450ww3, long j) {
            float fA;
            int i;
            long jF;
            int iD;
            int iQ;
            LG4.a(this.e.v());
            boolean z = this.e.r() || interfaceC23450ww3.s0();
            AbstractC21313tS0.a(j, this.f ? EnumC24286yM4.a : EnumC24286yM4.b);
            int iB0 = this.f ? interfaceC23450ww3.B0(this.g.d(interfaceC23450ww3.getLayoutDirection())) : interfaceC23450ww3.B0(androidx.compose.foundation.layout.q.g(this.g, interfaceC23450ww3.getLayoutDirection()));
            int iB02 = this.f ? interfaceC23450ww3.B0(this.g.b(interfaceC23450ww3.getLayoutDirection())) : interfaceC23450ww3.B0(androidx.compose.foundation.layout.q.f(this.g, interfaceC23450ww3.getLayoutDirection()));
            int iB03 = interfaceC23450ww3.B0(this.g.c());
            int iB04 = interfaceC23450ww3.B0(this.g.a());
            int i2 = iB03 + iB04;
            int i3 = iB0 + iB02;
            boolean z2 = this.f;
            int i4 = z2 ? i2 : i3;
            int i5 = (!z2 || this.h) ? (z2 && this.h) ? iB04 : (z2 || this.h) ? iB02 : iB0 : iB03;
            int i6 = i4 - i5;
            long jI = AbstractC19606qe1.i(j, -i3, -i2);
            InterfaceC17414mv3 interfaceC17414mv3 = (InterfaceC17414mv3) this.i.invoke();
            C5788Kv3 c5788Kv3H = interfaceC17414mv3.h();
            C4852Gv3 c4852Gv3A = this.j.a(interfaceC23450ww3, jI);
            int length = c4852Gv3A.b().length;
            c5788Kv3H.h(length);
            if (this.f) {
                C24254yJ.m mVar = this.k;
                if (mVar == null) {
                    P73.b("null verticalArrangement when isVertical == true");
                    throw new KotlinNothingValueException();
                }
                fA = mVar.a();
            } else {
                C24254yJ.e eVar = this.l;
                if (eVar == null) {
                    P73.b("null horizontalArrangement when isVertical == false");
                    throw new KotlinNothingValueException();
                }
                fA = eVar.a();
            }
            int iB05 = interfaceC23450ww3.B0(fA);
            int iA = interfaceC17414mv3.a();
            int iK = this.f ? C17833ne1.k(j) - i2 : C17833ne1.l(j) - i3;
            if (!this.h || iK > 0) {
                i = iA;
                jF = C22045ua3.f((iB0 << 32) | (iB03 & 4294967295L));
            } else {
                boolean z3 = this.f;
                if (!z3) {
                    iB0 += iK;
                }
                if (z3) {
                    iB03 += iK;
                }
                i = iA;
                jF = C22045ua3.f((iB0 << 32) | (iB03 & 4294967295L));
            }
            int i7 = i;
            C1552b c1552b = new C1552b(interfaceC17414mv3, interfaceC23450ww3, iB05, this.e, this.f, this.h, i5, i6, jF);
            c cVar = new c(this.f, c4852Gv3A, i7, iB05, c1552b, c5788Kv3H);
            d dVar = new d(c5788Kv3H, cVar);
            g.a aVar = androidx.compose.runtime.snapshots.g.e;
            C6021Lv3 c6021Lv3 = this.e;
            androidx.compose.runtime.snapshots.g gVarD = aVar.d();
            UA2 ua2G = gVarD != null ? gVarD.g() : null;
            androidx.compose.runtime.snapshots.g gVarE = aVar.e(gVarD);
            try {
                int iK2 = c6021Lv3.K(interfaceC17414mv3, c6021Lv3.p());
                if (iK2 < i7 || i7 <= 0) {
                    iD = c5788Kv3H.d(iK2);
                    iQ = c6021Lv3.q();
                } else {
                    iQ = 0;
                    iD = c5788Kv3H.d(i7 - 1);
                }
                C19938rB7 c19938rB7 = C19938rB7.a;
                aVar.l(gVarD, gVarE, ua2G);
                C23441wv3 c23441wv3E = AbstractC22851vv3.e(i7, cVar, c1552b, iK, i5, i6, iB05, iD, iQ, (interfaceC23450ww3.s0() || !z) ? this.e.C() : this.e.B(), jI, this.f, this.k, this.l, this.h, interfaceC23450ww3, this.e.t(), length, AbstractC16833lw3.a(interfaceC17414mv3, this.e.x(), this.e.o()), z, interfaceC23450ww3.s0(), this.e.m(), this.m, this.e.y(), this.n, dVar, this.o, new a(interfaceC23450ww3, j, i3, i2));
                C6021Lv3.l(this.e, c23441wv3E, interfaceC23450ww3.s0(), false, 4, null);
                return c23441wv3E;
            } catch (Throwable th) {
                aVar.l(gVarD, gVarE, ua2G);
                throw th;
            }
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            return a((InterfaceC23450ww3) obj, ((C17833ne1) obj2).r());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x0117  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x011d  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0135  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x013c  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0158  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x015d  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x017a  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x0183  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x018d  */
    /* JADX WARN: Removed duplicated region for block: B:187:0x0348  */
    /* JADX WARN: Removed duplicated region for block: B:190:0x0358  */
    /* JADX WARN: Removed duplicated region for block: B:192:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00e5  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0100  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void a(androidx.compose.ui.e r32, ir.nasim.C6021Lv3 r33, ir.nasim.InterfaceC5086Hv3 r34, ir.nasim.TS4 r35, boolean r36, boolean r37, ir.nasim.InterfaceC7645Sp2 r38, boolean r39, ir.nasim.InterfaceC14124hO4 r40, ir.nasim.C24254yJ.m r41, ir.nasim.C24254yJ.e r42, ir.nasim.UA2 r43, ir.nasim.InterfaceC22053ub1 r44, int r45, int r46, int r47) {
        /*
            Method dump skipped, instructions count: 898
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC20978sv3.a(androidx.compose.ui.e, ir.nasim.Lv3, ir.nasim.Hv3, ir.nasim.TS4, boolean, boolean, ir.nasim.Sp2, boolean, ir.nasim.hO4, ir.nasim.yJ$m, ir.nasim.yJ$e, ir.nasim.UA2, ir.nasim.ub1, int, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x002d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static final ir.nasim.InterfaceC14603iB2 b(ir.nasim.SA2 r18, ir.nasim.C6021Lv3 r19, ir.nasim.InterfaceC5086Hv3 r20, ir.nasim.TS4 r21, boolean r22, boolean r23, ir.nasim.C24254yJ.e r24, ir.nasim.C24254yJ.m r25, ir.nasim.InterfaceC20315ro1 r26, ir.nasim.InterfaceC20014rK2 r27, ir.nasim.EN6 r28, ir.nasim.InterfaceC22053ub1 r29, int r30, int r31) {
        /*
            Method dump skipped, instructions count: 262
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC20978sv3.b(ir.nasim.SA2, ir.nasim.Lv3, ir.nasim.Hv3, ir.nasim.TS4, boolean, boolean, ir.nasim.yJ$e, ir.nasim.yJ$m, ir.nasim.ro1, ir.nasim.rK2, ir.nasim.EN6, ir.nasim.ub1, int, int):ir.nasim.iB2");
    }
}
