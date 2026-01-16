package ir.nasim;

import androidx.compose.runtime.snapshots.g;
import ir.nasim.InterfaceC12529em;

/* renamed from: ir.nasim.sT4, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC20706sT4 {

    /* renamed from: ir.nasim.sT4$a */
    static final class a extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
        final /* synthetic */ GT4 e;
        final /* synthetic */ EnumC24286yM4 f;
        final /* synthetic */ TS4 g;
        final /* synthetic */ boolean h;
        final /* synthetic */ float i;
        final /* synthetic */ InterfaceC10944cT4 j;
        final /* synthetic */ SA2 k;
        final /* synthetic */ SA2 l;
        final /* synthetic */ InterfaceC12529em.c m;
        final /* synthetic */ InterfaceC12529em.b n;
        final /* synthetic */ int o;
        final /* synthetic */ FG6 p;
        final /* synthetic */ InterfaceC20315ro1 q;

        /* renamed from: ir.nasim.sT4$a$a, reason: collision with other inner class name */
        static final class C1542a extends AbstractC8614Ws3 implements InterfaceC15796kB2 {
            final /* synthetic */ InterfaceC23450ww3 e;
            final /* synthetic */ long f;
            final /* synthetic */ int g;
            final /* synthetic */ int h;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C1542a(InterfaceC23450ww3 interfaceC23450ww3, long j, int i, int i2) {
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

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(GT4 gt4, EnumC24286yM4 enumC24286yM4, TS4 ts4, boolean z, float f, InterfaceC10944cT4 interfaceC10944cT4, SA2 sa2, SA2 sa22, InterfaceC12529em.c cVar, InterfaceC12529em.b bVar, int i, FG6 fg6, InterfaceC20315ro1 interfaceC20315ro1) {
            super(2);
            this.e = gt4;
            this.f = enumC24286yM4;
            this.g = ts4;
            this.h = z;
            this.i = f;
            this.j = interfaceC10944cT4;
            this.k = sa2;
            this.l = sa22;
            this.m = cVar;
            this.n = bVar;
            this.o = i;
            this.p = fg6;
            this.q = interfaceC20315ro1;
        }

        public final C21326tT4 a(InterfaceC23450ww3 interfaceC23450ww3, long j) {
            EnumC24286yM4 enumC24286yM4;
            long jF;
            LG4.a(this.e.E());
            EnumC24286yM4 enumC24286yM42 = this.f;
            EnumC24286yM4 enumC24286yM43 = EnumC24286yM4.a;
            boolean z = enumC24286yM42 == enumC24286yM43;
            AbstractC21313tS0.a(j, z ? enumC24286yM43 : EnumC24286yM4.b);
            int iB0 = z ? interfaceC23450ww3.B0(this.g.d(interfaceC23450ww3.getLayoutDirection())) : interfaceC23450ww3.B0(androidx.compose.foundation.layout.q.g(this.g, interfaceC23450ww3.getLayoutDirection()));
            int iB02 = z ? interfaceC23450ww3.B0(this.g.b(interfaceC23450ww3.getLayoutDirection())) : interfaceC23450ww3.B0(androidx.compose.foundation.layout.q.f(this.g, interfaceC23450ww3.getLayoutDirection()));
            int iB03 = interfaceC23450ww3.B0(this.g.c());
            int iB04 = interfaceC23450ww3.B0(this.g.a());
            int i = iB03 + iB04;
            int i2 = iB0 + iB02;
            int i3 = z ? i : i2;
            int i4 = (!z || this.h) ? (z && this.h) ? iB04 : (z || this.h) ? iB02 : iB0 : iB03;
            int i5 = i3 - i4;
            long jI = AbstractC19606qe1.i(j, -i2, -i);
            this.e.g0(interfaceC23450ww3);
            int iB05 = interfaceC23450ww3.B0(this.i);
            int iK = z ? C17833ne1.k(j) - i : C17833ne1.l(j) - i2;
            if (!this.h || iK > 0) {
                enumC24286yM4 = enumC24286yM43;
                jF = C22045ua3.f((iB0 << 32) | (iB03 & 4294967295L));
            } else {
                if (!z) {
                    iB0 += iK;
                }
                if (z) {
                    iB03 += iK;
                }
                enumC24286yM4 = enumC24286yM43;
                jF = C22045ua3.f((iB03 & 4294967295L) | (iB0 << 32));
            }
            long j2 = jF;
            int iE = AbstractC23053wG5.e(this.j.a(interfaceC23450ww3, iK, iB05), 0);
            EnumC24286yM4 enumC24286yM44 = enumC24286yM4;
            this.e.h0(AbstractC19606qe1.b(0, this.f == enumC24286yM44 ? C17833ne1.l(jI) : iE, 0, this.f != enumC24286yM44 ? C17833ne1.k(jI) : iE, 5, null));
            C19506qT4 c19506qT4 = (C19506qT4) this.k.invoke();
            int i6 = iK + i4 + i5;
            g.a aVar = androidx.compose.runtime.snapshots.g.e;
            GT4 gt4 = this.e;
            FG6 fg6 = this.p;
            androidx.compose.runtime.snapshots.g gVarD = aVar.d();
            UA2 ua2G = gVarD != null ? gVarD.g() : null;
            androidx.compose.runtime.snapshots.g gVarE = aVar.e(gVarD);
            try {
                int iW = gt4.W(c19506qT4, gt4.v());
                int iD = AbstractC17142mT4.d(fg6, i6, iE, iB05, i4, i5, gt4.v(), gt4.w(), gt4.H());
                C19938rB7 c19938rB7 = C19938rB7.a;
                aVar.l(gVarD, gVarE, ua2G);
                C21326tT4 c21326tT4H = AbstractC20097rT4.h(interfaceC23450ww3, ((Number) this.l.invoke()).intValue(), c19506qT4, iK, i4, i5, iB05, iW, iD, jI, this.f, this.m, this.n, this.h, j2, iE, this.o, AbstractC16833lw3.a(c19506qT4, this.e.L(), this.e.u()), this.p, this.e.M(), this.q, new C1542a(interfaceC23450ww3, j, i2, i));
                GT4.p(this.e, c21326tT4H, interfaceC23450ww3.s0(), false, 4, null);
                return c21326tT4H;
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

    /* JADX WARN: Removed duplicated region for block: B:103:0x0131  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x002b  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0113  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final ir.nasim.InterfaceC14603iB2 a(ir.nasim.SA2 r21, ir.nasim.GT4 r22, ir.nasim.TS4 r23, boolean r24, ir.nasim.EnumC24286yM4 r25, int r26, float r27, ir.nasim.InterfaceC10944cT4 r28, ir.nasim.InterfaceC12529em.b r29, ir.nasim.InterfaceC12529em.c r30, ir.nasim.FG6 r31, ir.nasim.InterfaceC20315ro1 r32, ir.nasim.SA2 r33, ir.nasim.InterfaceC22053ub1 r34, int r35, int r36) {
        /*
            Method dump skipped, instructions count: 381
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC20706sT4.a(ir.nasim.SA2, ir.nasim.GT4, ir.nasim.TS4, boolean, ir.nasim.yM4, int, float, ir.nasim.cT4, ir.nasim.em$b, ir.nasim.em$c, ir.nasim.FG6, ir.nasim.ro1, ir.nasim.SA2, ir.nasim.ub1, int, int):ir.nasim.iB2");
    }
}
