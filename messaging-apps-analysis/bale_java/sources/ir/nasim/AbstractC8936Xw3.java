package ir.nasim;

import androidx.compose.runtime.snapshots.g;
import ir.nasim.C24254yJ;
import ir.nasim.InterfaceC12529em;
import java.util.List;
import kotlin.KotlinNothingValueException;

/* renamed from: ir.nasim.Xw3, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC8936Xw3 {

    /* renamed from: ir.nasim.Xw3$a */
    static final class a extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
        final /* synthetic */ androidx.compose.ui.e e;
        final /* synthetic */ C19206px3 f;
        final /* synthetic */ TS4 g;
        final /* synthetic */ boolean h;
        final /* synthetic */ boolean i;
        final /* synthetic */ InterfaceC7645Sp2 j;
        final /* synthetic */ boolean k;
        final /* synthetic */ InterfaceC14124hO4 l;
        final /* synthetic */ int m;
        final /* synthetic */ InterfaceC12529em.b n;
        final /* synthetic */ C24254yJ.m o;
        final /* synthetic */ InterfaceC12529em.c p;
        final /* synthetic */ C24254yJ.e q;
        final /* synthetic */ UA2 r;
        final /* synthetic */ int s;
        final /* synthetic */ int t;
        final /* synthetic */ int u;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(androidx.compose.ui.e eVar, C19206px3 c19206px3, TS4 ts4, boolean z, boolean z2, InterfaceC7645Sp2 interfaceC7645Sp2, boolean z3, InterfaceC14124hO4 interfaceC14124hO4, int i, InterfaceC12529em.b bVar, C24254yJ.m mVar, InterfaceC12529em.c cVar, C24254yJ.e eVar2, UA2 ua2, int i2, int i3, int i4) {
            super(2);
            this.e = eVar;
            this.f = c19206px3;
            this.g = ts4;
            this.h = z;
            this.i = z2;
            this.j = interfaceC7645Sp2;
            this.k = z3;
            this.l = interfaceC14124hO4;
            this.m = i;
            this.n = bVar;
            this.o = mVar;
            this.p = cVar;
            this.q = eVar2;
            this.r = ua2;
            this.s = i2;
            this.t = i3;
            this.u = i4;
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            AbstractC8936Xw3.a(this.e, this.f, this.g, this.h, this.i, this.j, this.k, this.l, this.m, this.n, this.o, this.p, this.q, this.r, interfaceC22053ub1, QJ5.a(this.s | 1), QJ5.a(this.t), this.u);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.Xw3$b */
    static final class b extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
        final /* synthetic */ C19206px3 e;
        final /* synthetic */ boolean f;
        final /* synthetic */ TS4 g;
        final /* synthetic */ boolean h;
        final /* synthetic */ SA2 i;
        final /* synthetic */ C24254yJ.m j;
        final /* synthetic */ C24254yJ.e k;
        final /* synthetic */ int l;
        final /* synthetic */ InterfaceC20315ro1 m;
        final /* synthetic */ InterfaceC20014rK2 n;
        final /* synthetic */ EN6 o;
        final /* synthetic */ InterfaceC12529em.b p;
        final /* synthetic */ InterfaceC12529em.c q;

        /* renamed from: ir.nasim.Xw3$b$a */
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

        /* renamed from: ir.nasim.Xw3$b$b, reason: collision with other inner class name */
        public static final class C0780b extends AbstractC12642ex3 {
            final /* synthetic */ boolean d;
            final /* synthetic */ InterfaceC23450ww3 e;
            final /* synthetic */ int f;
            final /* synthetic */ int g;
            final /* synthetic */ InterfaceC12529em.b h;
            final /* synthetic */ InterfaceC12529em.c i;
            final /* synthetic */ boolean j;
            final /* synthetic */ int k;
            final /* synthetic */ int l;
            final /* synthetic */ long m;
            final /* synthetic */ C19206px3 n;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C0780b(long j, boolean z, InterfaceC8182Uw3 interfaceC8182Uw3, InterfaceC23450ww3 interfaceC23450ww3, int i, int i2, InterfaceC12529em.b bVar, InterfaceC12529em.c cVar, boolean z2, int i3, int i4, long j2, C19206px3 c19206px3) {
                super(j, z, interfaceC8182Uw3, interfaceC23450ww3, null);
                this.d = z;
                this.e = interfaceC23450ww3;
                this.f = i;
                this.g = i2;
                this.h = bVar;
                this.i = cVar;
                this.j = z2;
                this.k = i3;
                this.l = i4;
                this.m = j2;
                this.n = c19206px3;
            }

            @Override // ir.nasim.AbstractC12642ex3
            public C12051dx3 b(int i, Object obj, Object obj2, List list, long j) {
                return new C12051dx3(i, list, this.d, this.h, this.i, this.e.getLayoutDirection(), this.j, this.k, this.l, i == this.f + (-1) ? 0 : this.g, this.m, obj, obj2, this.n.w(), j, null);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(C19206px3 c19206px3, boolean z, TS4 ts4, boolean z2, SA2 sa2, C24254yJ.m mVar, C24254yJ.e eVar, int i, InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20014rK2 interfaceC20014rK2, EN6 en6, InterfaceC12529em.b bVar, InterfaceC12529em.c cVar) {
            super(2);
            this.e = c19206px3;
            this.f = z;
            this.g = ts4;
            this.h = z2;
            this.i = sa2;
            this.j = mVar;
            this.k = eVar;
            this.l = i;
            this.m = interfaceC20315ro1;
            this.n = interfaceC20014rK2;
            this.o = en6;
            this.p = bVar;
            this.q = cVar;
        }

        public final C11408cx3 a(InterfaceC23450ww3 interfaceC23450ww3, long j) {
            float fA;
            long jF;
            LG4.a(this.e.y());
            boolean z = this.e.u() || interfaceC23450ww3.s0();
            AbstractC21313tS0.a(j, this.f ? EnumC24286yM4.a : EnumC24286yM4.b);
            int iB0 = this.f ? interfaceC23450ww3.B0(this.g.d(interfaceC23450ww3.getLayoutDirection())) : interfaceC23450ww3.B0(androidx.compose.foundation.layout.q.g(this.g, interfaceC23450ww3.getLayoutDirection()));
            int iB02 = this.f ? interfaceC23450ww3.B0(this.g.b(interfaceC23450ww3.getLayoutDirection())) : interfaceC23450ww3.B0(androidx.compose.foundation.layout.q.f(this.g, interfaceC23450ww3.getLayoutDirection()));
            int iB03 = interfaceC23450ww3.B0(this.g.c());
            int iB04 = interfaceC23450ww3.B0(this.g.a());
            int i = iB03 + iB04;
            int i2 = iB0 + iB02;
            boolean z2 = this.f;
            int i3 = z2 ? i : i2;
            int i4 = (!z2 || this.h) ? (z2 && this.h) ? iB04 : (z2 || this.h) ? iB02 : iB0 : iB03;
            int i5 = i3 - i4;
            long jI = AbstractC19606qe1.i(j, -i2, -i);
            InterfaceC8182Uw3 interfaceC8182Uw3 = (InterfaceC8182Uw3) this.i.invoke();
            interfaceC8182Uw3.g().i(C17833ne1.l(jI), C17833ne1.k(jI));
            if (this.f) {
                C24254yJ.m mVar = this.j;
                if (mVar == null) {
                    P73.b("null verticalArrangement when isVertical == true");
                    throw new KotlinNothingValueException();
                }
                fA = mVar.a();
            } else {
                C24254yJ.e eVar = this.k;
                if (eVar == null) {
                    P73.b("null horizontalAlignment when isVertical == false");
                    throw new KotlinNothingValueException();
                }
                fA = eVar.a();
            }
            int iB05 = interfaceC23450ww3.B0(fA);
            int iA = interfaceC8182Uw3.a();
            int iK = this.f ? C17833ne1.k(j) - i : C17833ne1.l(j) - i2;
            if (!this.h || iK > 0) {
                jF = C22045ua3.f((iB0 << 32) | (iB03 & 4294967295L));
            } else {
                boolean z3 = this.f;
                if (!z3) {
                    iB0 += iK;
                }
                if (z3) {
                    iB03 += iK;
                }
                jF = C22045ua3.f((iB0 << 32) | (iB03 & 4294967295L));
            }
            C0780b c0780b = new C0780b(jI, this.f, interfaceC8182Uw3, interfaceC23450ww3, iA, iB05, this.p, this.q, this.h, i4, i5, jF, this.e);
            g.a aVar = androidx.compose.runtime.snapshots.g.e;
            C19206px3 c19206px3 = this.e;
            androidx.compose.runtime.snapshots.g gVarD = aVar.d();
            UA2 ua2G = gVarD != null ? gVarD.g() : null;
            androidx.compose.runtime.snapshots.g gVarE = aVar.e(gVarD);
            try {
                int iN = c19206px3.N(interfaceC8182Uw3, c19206px3.s());
                int iT = c19206px3.t();
                C19938rB7 c19938rB7 = C19938rB7.a;
                aVar.l(gVarD, gVarE, ua2G);
                C11408cx3 c11408cx3E = AbstractC10645bx3.e(iA, c0780b, iK, i4, i5, iB05, iN, iT, (interfaceC23450ww3.s0() || !z) ? this.e.F() : this.e.E(), jI, this.f, this.j, this.k, this.h, interfaceC23450ww3, this.e.w(), this.l, AbstractC16833lw3.a(interfaceC8182Uw3, this.e.A(), this.e.q()), z, interfaceC23450ww3.s0(), this.e.o(), this.m, this.e.B(), this.n, this.o, new a(interfaceC23450ww3, j, i2, i));
                C19206px3.n(this.e, c11408cx3E, interfaceC23450ww3.s0(), false, 4, null);
                return c11408cx3E;
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

    /* JADX WARN: Removed duplicated region for block: B:108:0x0133  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0138  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0152  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0157  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x016d  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x0172  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x0186  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x0189  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x01a2  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x01ab  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x01b5  */
    /* JADX WARN: Removed duplicated region for block: B:195:0x034a  */
    /* JADX WARN: Removed duplicated region for block: B:198:0x035e  */
    /* JADX WARN: Removed duplicated region for block: B:200:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x00fe  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0117  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x011c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void a(androidx.compose.ui.e r31, ir.nasim.C19206px3 r32, ir.nasim.TS4 r33, boolean r34, boolean r35, ir.nasim.InterfaceC7645Sp2 r36, boolean r37, ir.nasim.InterfaceC14124hO4 r38, int r39, ir.nasim.InterfaceC12529em.b r40, ir.nasim.C24254yJ.m r41, ir.nasim.InterfaceC12529em.c r42, ir.nasim.C24254yJ.e r43, ir.nasim.UA2 r44, ir.nasim.InterfaceC22053ub1 r45, int r46, int r47, int r48) {
        /*
            Method dump skipped, instructions count: 904
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC8936Xw3.a(androidx.compose.ui.e, ir.nasim.px3, ir.nasim.TS4, boolean, boolean, ir.nasim.Sp2, boolean, ir.nasim.hO4, int, ir.nasim.em$b, ir.nasim.yJ$m, ir.nasim.em$c, ir.nasim.yJ$e, ir.nasim.UA2, ir.nasim.ub1, int, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0101  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static final ir.nasim.InterfaceC14603iB2 b(ir.nasim.SA2 r21, ir.nasim.C19206px3 r22, ir.nasim.TS4 r23, boolean r24, boolean r25, int r26, ir.nasim.InterfaceC12529em.b r27, ir.nasim.InterfaceC12529em.c r28, ir.nasim.C24254yJ.e r29, ir.nasim.C24254yJ.m r30, ir.nasim.InterfaceC20315ro1 r31, ir.nasim.InterfaceC20014rK2 r32, ir.nasim.EN6 r33, ir.nasim.InterfaceC22053ub1 r34, int r35, int r36) {
        /*
            Method dump skipped, instructions count: 325
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC8936Xw3.b(ir.nasim.SA2, ir.nasim.px3, ir.nasim.TS4, boolean, boolean, int, ir.nasim.em$b, ir.nasim.em$c, ir.nasim.yJ$e, ir.nasim.yJ$m, ir.nasim.ro1, ir.nasim.rK2, ir.nasim.EN6, ir.nasim.ub1, int, int):ir.nasim.iB2");
    }
}
