package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import ir.nasim.C24381yX0;
import ir.nasim.InterfaceC16030kb1;
import ir.nasim.InterfaceC22053ub1;

/* renamed from: ir.nasim.dm7, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC11925dm7 {
    private static final float a = C17784nZ1.q(16);
    private static final float b = C17784nZ1.q(12);

    /* renamed from: ir.nasim.dm7$a */
    static final class a extends AbstractC8614Ws3 implements InterfaceC19342qB2 {
        final /* synthetic */ InterfaceC14603iB2 e;
        final /* synthetic */ InterfaceC14603iB2 f;
        final /* synthetic */ String g;
        final /* synthetic */ InterfaceC7614Sl7 h;
        final /* synthetic */ boolean i;
        final /* synthetic */ boolean j;
        final /* synthetic */ InterfaceC23241wb3 k;
        final /* synthetic */ InterfaceC14603iB2 l;
        final /* synthetic */ InterfaceC14603iB2 m;
        final /* synthetic */ InterfaceC10031ax6 n;
        final /* synthetic */ EnumC23355wm7 o;
        final /* synthetic */ InterfaceC14603iB2 p;
        final /* synthetic */ boolean q;
        final /* synthetic */ TS4 r;
        final /* synthetic */ boolean s;
        final /* synthetic */ InterfaceC14603iB2 t;

        /* renamed from: ir.nasim.dm7$a$a, reason: collision with other inner class name */
        static final class C1030a extends AbstractC8614Ws3 implements UA2 {
            final /* synthetic */ float e;
            final /* synthetic */ InterfaceC9102Ym4 f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C1030a(float f, InterfaceC9102Ym4 interfaceC9102Ym4) {
                super(1);
                this.e = f;
                this.f = interfaceC9102Ym4;
            }

            public final void a(long j) {
                float fI = OD6.i(j) * this.e;
                float fG = OD6.g(j) * this.e;
                if (OD6.i(((OD6) this.f.getValue()).m()) == fI && OD6.g(((OD6) this.f.getValue()).m()) == fG) {
                    return;
                }
                this.f.setValue(OD6.c(UD6.a(fI, fG)));
            }

            @Override // ir.nasim.UA2
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                a(((OD6) obj).m());
                return C19938rB7.a;
            }
        }

        /* renamed from: ir.nasim.dm7$a$b */
        public /* synthetic */ class b {
            public static final /* synthetic */ int[] a;

            static {
                int[] iArr = new int[EnumC23355wm7.values().length];
                try {
                    iArr[EnumC23355wm7.a.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[EnumC23355wm7.b.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                a = iArr;
            }
        }

        /* renamed from: ir.nasim.dm7$a$c */
        static final class c extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
            final /* synthetic */ float e;
            final /* synthetic */ long f;
            final /* synthetic */ InterfaceC14603iB2 g;
            final /* synthetic */ boolean h;
            final /* synthetic */ long i;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            c(float f, long j, InterfaceC14603iB2 interfaceC14603iB2, boolean z, long j2) {
                super(2);
                this.e = f;
                this.f = j;
                this.g = interfaceC14603iB2;
                this.h = z;
                this.i = j2;
            }

            public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
                if (!interfaceC22053ub1.o((i & 3) != 2, i & 1)) {
                    interfaceC22053ub1.L();
                    return;
                }
                if (AbstractC5138Ib1.I()) {
                    AbstractC5138Ib1.Q(-1865025495, i, -1, "androidx.compose.material.CommonDecorationBox.<anonymous>.<anonymous>.<anonymous> (TextFieldImpl.kt:131)");
                }
                C15977kV3 c15977kV3 = C15977kV3.a;
                C9348Zn7 c9348Zn7C = AbstractC10560bo7.c(c15977kV3.c(interfaceC22053ub1, 6).e(), c15977kV3.c(interfaceC22053ub1, 6).d(), this.e);
                AbstractC11925dm7.b(this.f, this.h ? c9348Zn7C.b((16744447 & 1) != 0 ? c9348Zn7C.a.g() : this.i, (16744447 & 2) != 0 ? c9348Zn7C.a.k() : 0L, (16744447 & 4) != 0 ? c9348Zn7C.a.n() : null, (16744447 & 8) != 0 ? c9348Zn7C.a.l() : null, (16744447 & 16) != 0 ? c9348Zn7C.a.m() : null, (16744447 & 32) != 0 ? c9348Zn7C.a.i() : null, (16744447 & 64) != 0 ? c9348Zn7C.a.j() : null, (16744447 & 128) != 0 ? c9348Zn7C.a.o() : 0L, (16744447 & 256) != 0 ? c9348Zn7C.a.e() : null, (16744447 & 512) != 0 ? c9348Zn7C.a.u() : null, (16744447 & 1024) != 0 ? c9348Zn7C.a.p() : null, (16744447 & 2048) != 0 ? c9348Zn7C.a.d() : 0L, (16744447 & 4096) != 0 ? c9348Zn7C.a.s() : null, (16744447 & 8192) != 0 ? c9348Zn7C.a.r() : null, (16744447 & 16384) != 0 ? c9348Zn7C.a.h() : null, (16744447 & 32768) != 0 ? c9348Zn7C.b.h() : 0, (16744447 & 65536) != 0 ? c9348Zn7C.b.i() : 0, (16744447 & 131072) != 0 ? c9348Zn7C.b.e() : 0L, (16744447 & 262144) != 0 ? c9348Zn7C.b.j() : null, (16744447 & 524288) != 0 ? c9348Zn7C.c : null, (16744447 & 1048576) != 0 ? c9348Zn7C.b.f() : null, (16744447 & 2097152) != 0 ? c9348Zn7C.b.d() : 0, (16744447 & 4194304) != 0 ? c9348Zn7C.b.c() : 0, (16744447 & 8388608) != 0 ? c9348Zn7C.b.k() : null) : c9348Zn7C, null, this.g, interfaceC22053ub1, 384, 0);
                if (AbstractC5138Ib1.I()) {
                    AbstractC5138Ib1.P();
                }
            }

            @Override // ir.nasim.InterfaceC14603iB2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
                return C19938rB7.a;
            }
        }

        /* renamed from: ir.nasim.dm7$a$d */
        static final class d extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
            final /* synthetic */ long e;
            final /* synthetic */ InterfaceC14603iB2 f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            d(long j, InterfaceC14603iB2 interfaceC14603iB2) {
                super(2);
                this.e = j;
                this.f = interfaceC14603iB2;
            }

            public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
                if (!interfaceC22053ub1.o((i & 3) != 2, i & 1)) {
                    interfaceC22053ub1.L();
                    return;
                }
                if (AbstractC5138Ib1.I()) {
                    AbstractC5138Ib1.Q(-1165144581, i, -1, "androidx.compose.material.CommonDecorationBox.<anonymous>.<anonymous>.<anonymous> (TextFieldImpl.kt:164)");
                }
                AbstractC11925dm7.b(this.e, null, null, this.f, interfaceC22053ub1, 0, 6);
                if (AbstractC5138Ib1.I()) {
                    AbstractC5138Ib1.P();
                }
            }

            @Override // ir.nasim.InterfaceC14603iB2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
                return C19938rB7.a;
            }
        }

        /* renamed from: ir.nasim.dm7$a$e */
        static final class e extends AbstractC8614Ws3 implements InterfaceC15796kB2 {
            final /* synthetic */ float e;
            final /* synthetic */ InterfaceC7614Sl7 f;
            final /* synthetic */ boolean g;
            final /* synthetic */ InterfaceC14603iB2 h;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            e(float f, InterfaceC7614Sl7 interfaceC7614Sl7, boolean z, InterfaceC14603iB2 interfaceC14603iB2) {
                super(3);
                this.e = f;
                this.f = interfaceC7614Sl7;
                this.g = z;
                this.h = interfaceC14603iB2;
            }

            public final void a(androidx.compose.ui.e eVar, InterfaceC22053ub1 interfaceC22053ub1, int i) {
                int i2;
                if ((i & 6) == 0) {
                    i2 = i | (interfaceC22053ub1.V(eVar) ? 4 : 2);
                } else {
                    i2 = i;
                }
                if (!interfaceC22053ub1.o((i2 & 19) != 18, 1 & i2)) {
                    interfaceC22053ub1.L();
                    return;
                }
                if (AbstractC5138Ib1.I()) {
                    AbstractC5138Ib1.Q(-413527723, i2, -1, "androidx.compose.material.CommonDecorationBox.<anonymous>.<anonymous> (TextFieldImpl.kt:151)");
                }
                androidx.compose.ui.e eVarA = AbstractC21571tm.a(eVar, this.e);
                InterfaceC7614Sl7 interfaceC7614Sl7 = this.f;
                boolean z = this.g;
                InterfaceC14603iB2 interfaceC14603iB2 = this.h;
                InterfaceC10970cW3 interfaceC10970cW3G = androidx.compose.foundation.layout.f.g(InterfaceC12529em.a.o(), false);
                int iA = AbstractC6797Pa1.a(interfaceC22053ub1, 0);
                InterfaceC11819dc1 interfaceC11819dc1Q = interfaceC22053ub1.q();
                androidx.compose.ui.e eVarE = androidx.compose.ui.c.e(interfaceC22053ub1, eVarA);
                InterfaceC16030kb1.a aVar = InterfaceC16030kb1.d0;
                SA2 sa2A = aVar.a();
                if (!(interfaceC22053ub1.l() instanceof InterfaceC15247jG)) {
                    AbstractC6797Pa1.c();
                }
                interfaceC22053ub1.G();
                if (interfaceC22053ub1.h()) {
                    interfaceC22053ub1.g(sa2A);
                } else {
                    interfaceC22053ub1.r();
                }
                InterfaceC22053ub1 interfaceC22053ub1A = DG7.a(interfaceC22053ub1);
                DG7.c(interfaceC22053ub1A, interfaceC10970cW3G, aVar.e());
                DG7.c(interfaceC22053ub1A, interfaceC11819dc1Q, aVar.g());
                InterfaceC14603iB2 interfaceC14603iB2B = aVar.b();
                if (interfaceC22053ub1A.h() || !AbstractC13042fc3.d(interfaceC22053ub1A.B(), Integer.valueOf(iA))) {
                    interfaceC22053ub1A.s(Integer.valueOf(iA));
                    interfaceC22053ub1A.v(Integer.valueOf(iA), interfaceC14603iB2B);
                }
                DG7.c(interfaceC22053ub1A, eVarE, aVar.f());
                androidx.compose.foundation.layout.h hVar = androidx.compose.foundation.layout.h.a;
                AbstractC11925dm7.b(((C24381yX0) interfaceC7614Sl7.f(z, interfaceC22053ub1, 0).getValue()).y(), C15977kV3.a.c(interfaceC22053ub1, 6).e(), null, interfaceC14603iB2, interfaceC22053ub1, 0, 4);
                interfaceC22053ub1.u();
                if (AbstractC5138Ib1.I()) {
                    AbstractC5138Ib1.P();
                }
            }

            @Override // ir.nasim.InterfaceC15796kB2
            public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
                a((androidx.compose.ui.e) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
                return C19938rB7.a;
            }
        }

        /* renamed from: ir.nasim.dm7$a$f */
        static final class f extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
            final /* synthetic */ long e;
            final /* synthetic */ InterfaceC14603iB2 f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            f(long j, InterfaceC14603iB2 interfaceC14603iB2) {
                super(2);
                this.e = j;
                this.f = interfaceC14603iB2;
            }

            public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
                if (!interfaceC22053ub1.o((i & 3) != 2, i & 1)) {
                    interfaceC22053ub1.L();
                    return;
                }
                if (AbstractC5138Ib1.I()) {
                    AbstractC5138Ib1.Q(1694126319, i, -1, "androidx.compose.material.CommonDecorationBox.<anonymous>.<anonymous>.<anonymous> (TextFieldImpl.kt:170)");
                }
                AbstractC11925dm7.b(this.e, null, null, this.f, interfaceC22053ub1, 0, 6);
                if (AbstractC5138Ib1.I()) {
                    AbstractC5138Ib1.P();
                }
            }

            @Override // ir.nasim.InterfaceC14603iB2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
                return C19938rB7.a;
            }
        }

        /* renamed from: ir.nasim.dm7$a$g */
        static final class g extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
            final /* synthetic */ InterfaceC9102Ym4 e;
            final /* synthetic */ TS4 f;
            final /* synthetic */ InterfaceC14603iB2 g;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            g(InterfaceC9102Ym4 interfaceC9102Ym4, TS4 ts4, InterfaceC14603iB2 interfaceC14603iB2) {
                super(2);
                this.e = interfaceC9102Ym4;
                this.f = ts4;
                this.g = interfaceC14603iB2;
            }

            public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
                if (!interfaceC22053ub1.o((i & 3) != 2, i & 1)) {
                    interfaceC22053ub1.L();
                    return;
                }
                if (AbstractC5138Ib1.I()) {
                    AbstractC5138Ib1.Q(-1212965554, i, -1, "androidx.compose.material.CommonDecorationBox.<anonymous>.<anonymous> (TextFieldImpl.kt:193)");
                }
                androidx.compose.ui.e eVarK = AbstractC14115hN4.k(androidx.compose.ui.layout.a.b(androidx.compose.ui.e.a, "border"), ((OD6) this.e.getValue()).m(), this.f);
                InterfaceC14603iB2 interfaceC14603iB2 = this.g;
                InterfaceC10970cW3 interfaceC10970cW3G = androidx.compose.foundation.layout.f.g(InterfaceC12529em.a.o(), true);
                int iA = AbstractC6797Pa1.a(interfaceC22053ub1, 0);
                InterfaceC11819dc1 interfaceC11819dc1Q = interfaceC22053ub1.q();
                androidx.compose.ui.e eVarE = androidx.compose.ui.c.e(interfaceC22053ub1, eVarK);
                InterfaceC16030kb1.a aVar = InterfaceC16030kb1.d0;
                SA2 sa2A = aVar.a();
                if (!(interfaceC22053ub1.l() instanceof InterfaceC15247jG)) {
                    AbstractC6797Pa1.c();
                }
                interfaceC22053ub1.G();
                if (interfaceC22053ub1.h()) {
                    interfaceC22053ub1.g(sa2A);
                } else {
                    interfaceC22053ub1.r();
                }
                InterfaceC22053ub1 interfaceC22053ub1A = DG7.a(interfaceC22053ub1);
                DG7.c(interfaceC22053ub1A, interfaceC10970cW3G, aVar.e());
                DG7.c(interfaceC22053ub1A, interfaceC11819dc1Q, aVar.g());
                InterfaceC14603iB2 interfaceC14603iB2B = aVar.b();
                if (interfaceC22053ub1A.h() || !AbstractC13042fc3.d(interfaceC22053ub1A.B(), Integer.valueOf(iA))) {
                    interfaceC22053ub1A.s(Integer.valueOf(iA));
                    interfaceC22053ub1A.v(Integer.valueOf(iA), interfaceC14603iB2B);
                }
                DG7.c(interfaceC22053ub1A, eVarE, aVar.f());
                androidx.compose.foundation.layout.h hVar = androidx.compose.foundation.layout.h.a;
                if (interfaceC14603iB2 == null) {
                    interfaceC22053ub1.W(720285106);
                } else {
                    interfaceC22053ub1.W(-392406993);
                    interfaceC14603iB2.invoke(interfaceC22053ub1, 0);
                }
                interfaceC22053ub1.Q();
                interfaceC22053ub1.u();
                if (AbstractC5138Ib1.I()) {
                    AbstractC5138Ib1.P();
                }
            }

            @Override // ir.nasim.InterfaceC14603iB2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
                return C19938rB7.a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(InterfaceC14603iB2 interfaceC14603iB2, InterfaceC14603iB2 interfaceC14603iB22, String str, InterfaceC7614Sl7 interfaceC7614Sl7, boolean z, boolean z2, InterfaceC23241wb3 interfaceC23241wb3, InterfaceC14603iB2 interfaceC14603iB23, InterfaceC14603iB2 interfaceC14603iB24, InterfaceC10031ax6 interfaceC10031ax6, EnumC23355wm7 enumC23355wm7, InterfaceC14603iB2 interfaceC14603iB25, boolean z3, TS4 ts4, boolean z4, InterfaceC14603iB2 interfaceC14603iB26) {
            super(6);
            this.e = interfaceC14603iB2;
            this.f = interfaceC14603iB22;
            this.g = str;
            this.h = interfaceC7614Sl7;
            this.i = z;
            this.j = z2;
            this.k = interfaceC23241wb3;
            this.l = interfaceC14603iB23;
            this.m = interfaceC14603iB24;
            this.n = interfaceC10031ax6;
            this.o = enumC23355wm7;
            this.p = interfaceC14603iB25;
            this.q = z3;
            this.r = ts4;
            this.s = z4;
            this.t = interfaceC14603iB26;
        }

        public final void a(float f2, long j, long j2, float f3, InterfaceC22053ub1 interfaceC22053ub1, int i) {
            int i2;
            int i3;
            boolean z;
            InterfaceC18060o11 interfaceC18060o11;
            InterfaceC18060o11 interfaceC18060o112;
            InterfaceC18060o11 interfaceC18060o113;
            InterfaceC18060o11 interfaceC18060o114;
            if ((i & 6) == 0) {
                i2 = (interfaceC22053ub1.c(f2) ? 4 : 2) | i;
            } else {
                i2 = i;
            }
            if ((i & 48) == 0) {
                i2 |= interfaceC22053ub1.f(j) ? 32 : 16;
            }
            if ((i & 384) == 0) {
                i2 |= interfaceC22053ub1.f(j2) ? 256 : 128;
            }
            if ((i & SetRpcStruct$ComposedRpc.GET_NASIM_FILE_PUBLIC_URL_FIELD_NUMBER) == 0) {
                i2 |= interfaceC22053ub1.c(f3) ? 2048 : 1024;
            }
            int i4 = i2;
            if (!interfaceC22053ub1.o((i4 & 9363) != 9362, i4 & 1)) {
                interfaceC22053ub1.L();
                return;
            }
            if (AbstractC5138Ib1.I()) {
                AbstractC5138Ib1.Q(225557475, i4, -1, "androidx.compose.material.CommonDecorationBox.<anonymous> (TextFieldImpl.kt:128)");
            }
            InterfaceC14603iB2 interfaceC14603iB2 = this.e;
            if (interfaceC14603iB2 == null) {
                interfaceC22053ub1.W(-1572254148);
                interfaceC22053ub1.Q();
                i3 = 54;
                z = true;
                interfaceC18060o11 = null;
            } else {
                interfaceC22053ub1.W(-1572254147);
                i3 = 54;
                z = true;
                InterfaceC18060o11 interfaceC18060o11E = AbstractC19242q11.e(-1865025495, true, new c(f2, j2, interfaceC14603iB2, this.s, j), interfaceC22053ub1, 54);
                interfaceC22053ub1.Q();
                interfaceC18060o11 = interfaceC18060o11E;
            }
            if (this.f == null || this.g.length() != 0 || f3 <= 0.0f) {
                interfaceC22053ub1.W(-1570844268);
                interfaceC22053ub1.Q();
                interfaceC18060o112 = null;
            } else {
                interfaceC22053ub1.W(-1571270300);
                InterfaceC18060o11 interfaceC18060o11E2 = AbstractC19242q11.e(-413527723, z, new e(f3, this.h, this.i, this.f), interfaceC22053ub1, i3);
                interfaceC22053ub1.Q();
                interfaceC18060o112 = interfaceC18060o11E2;
            }
            long jY = ((C24381yX0) this.h.h(this.i, this.j, this.k, interfaceC22053ub1, 0).getValue()).y();
            InterfaceC14603iB2 interfaceC14603iB22 = this.l;
            if (interfaceC14603iB22 == null) {
                interfaceC22053ub1.W(-1570655509);
                interfaceC22053ub1.Q();
                interfaceC18060o113 = null;
            } else {
                interfaceC22053ub1.W(-1570655508);
                InterfaceC18060o11 interfaceC18060o11E3 = AbstractC19242q11.e(-1165144581, z, new d(jY, interfaceC14603iB22), interfaceC22053ub1, i3);
                interfaceC22053ub1.Q();
                interfaceC18060o113 = interfaceC18060o11E3;
            }
            long jY2 = ((C24381yX0) this.h.c(this.i, this.j, this.k, interfaceC22053ub1, 0).getValue()).y();
            InterfaceC14603iB2 interfaceC14603iB23 = this.m;
            if (interfaceC14603iB23 == null) {
                interfaceC22053ub1.W(-1570361846);
                interfaceC22053ub1.Q();
                interfaceC18060o114 = null;
            } else {
                interfaceC22053ub1.W(-1570361845);
                InterfaceC18060o11 interfaceC18060o11E4 = AbstractC19242q11.e(1694126319, z, new f(jY2, interfaceC14603iB23), interfaceC22053ub1, i3);
                interfaceC22053ub1.Q();
                interfaceC18060o114 = interfaceC18060o11E4;
            }
            androidx.compose.ui.e eVarC = androidx.compose.foundation.b.c(androidx.compose.ui.e.a, ((C24381yX0) this.h.a(this.i, interfaceC22053ub1, 0).getValue()).y(), this.n);
            int i5 = b.a[this.o.ordinal()];
            if (i5 == z) {
                interfaceC22053ub1.W(-1570081481);
                AbstractC14965im7.b(eVarC, this.p, interfaceC18060o11, interfaceC18060o112, interfaceC18060o113, interfaceC18060o114, this.q, f2, this.r, interfaceC22053ub1, (i4 << 21) & 29360128);
                interfaceC22053ub1.Q();
            } else if (i5 != 2) {
                interfaceC22053ub1.W(-1568043975);
                interfaceC22053ub1.Q();
            } else {
                interfaceC22053ub1.W(-1569502122);
                Object objB = interfaceC22053ub1.B();
                InterfaceC22053ub1.a aVar = InterfaceC22053ub1.a;
                if (objB == aVar.a()) {
                    objB = AbstractC13472gH6.d(OD6.c(OD6.b.b()), null, 2, null);
                    interfaceC22053ub1.s(objB);
                }
                InterfaceC9102Ym4 interfaceC9102Ym4 = (InterfaceC9102Ym4) objB;
                InterfaceC18060o11 interfaceC18060o11E5 = AbstractC19242q11.e(-1212965554, z, new g(interfaceC9102Ym4, this.r, this.t), interfaceC22053ub1, i3);
                InterfaceC14603iB2 interfaceC14603iB24 = this.p;
                boolean z2 = this.q;
                boolean z3 = (i4 & 14) == 4;
                Object objB2 = interfaceC22053ub1.B();
                if (z3 || objB2 == aVar.a()) {
                    objB2 = new C1030a(f2, interfaceC9102Ym4);
                    interfaceC22053ub1.s(objB2);
                }
                AbstractC14115hN4.c(eVarC, interfaceC14603iB24, interfaceC18060o112, interfaceC18060o11, interfaceC18060o113, interfaceC18060o114, z2, f2, (UA2) objB2, interfaceC18060o11E5, this.r, interfaceC22053ub1, ((i4 << 21) & 29360128) | 805306368, 0);
                interfaceC22053ub1.Q();
            }
            if (AbstractC5138Ib1.I()) {
                AbstractC5138Ib1.P();
            }
        }

        @Override // ir.nasim.InterfaceC19342qB2
        public /* bridge */ /* synthetic */ Object j(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6) {
            a(((Number) obj).floatValue(), ((C24381yX0) obj2).y(), ((C24381yX0) obj3).y(), ((Number) obj4).floatValue(), (InterfaceC22053ub1) obj5, ((Number) obj6).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.dm7$b */
    static final class b extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
        final /* synthetic */ EnumC23355wm7 e;
        final /* synthetic */ String f;
        final /* synthetic */ InterfaceC14603iB2 g;
        final /* synthetic */ QY7 h;
        final /* synthetic */ InterfaceC14603iB2 i;
        final /* synthetic */ InterfaceC14603iB2 j;
        final /* synthetic */ InterfaceC14603iB2 k;
        final /* synthetic */ InterfaceC14603iB2 l;
        final /* synthetic */ boolean m;
        final /* synthetic */ boolean n;
        final /* synthetic */ boolean o;
        final /* synthetic */ InterfaceC23241wb3 p;
        final /* synthetic */ TS4 q;
        final /* synthetic */ InterfaceC10031ax6 r;
        final /* synthetic */ InterfaceC7614Sl7 s;
        final /* synthetic */ InterfaceC14603iB2 t;
        final /* synthetic */ int u;
        final /* synthetic */ int v;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(EnumC23355wm7 enumC23355wm7, String str, InterfaceC14603iB2 interfaceC14603iB2, QY7 qy7, InterfaceC14603iB2 interfaceC14603iB22, InterfaceC14603iB2 interfaceC14603iB23, InterfaceC14603iB2 interfaceC14603iB24, InterfaceC14603iB2 interfaceC14603iB25, boolean z, boolean z2, boolean z3, InterfaceC23241wb3 interfaceC23241wb3, TS4 ts4, InterfaceC10031ax6 interfaceC10031ax6, InterfaceC7614Sl7 interfaceC7614Sl7, InterfaceC14603iB2 interfaceC14603iB26, int i, int i2) {
            super(2);
            this.e = enumC23355wm7;
            this.f = str;
            this.g = interfaceC14603iB2;
            this.h = qy7;
            this.i = interfaceC14603iB22;
            this.j = interfaceC14603iB23;
            this.k = interfaceC14603iB24;
            this.l = interfaceC14603iB25;
            this.m = z;
            this.n = z2;
            this.o = z3;
            this.p = interfaceC23241wb3;
            this.q = ts4;
            this.r = interfaceC10031ax6;
            this.s = interfaceC7614Sl7;
            this.t = interfaceC14603iB26;
            this.u = i;
            this.v = i2;
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            AbstractC11925dm7.a(this.e, this.f, this.g, this.h, this.i, this.j, this.k, this.l, this.m, this.n, this.o, this.p, this.q, this.r, this.s, this.t, interfaceC22053ub1, QJ5.a(this.u | 1), QJ5.a(this.v));
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.dm7$c */
    static final class c extends AbstractC8614Ws3 implements InterfaceC15796kB2 {
        final /* synthetic */ InterfaceC7614Sl7 e;
        final /* synthetic */ boolean f;
        final /* synthetic */ boolean g;
        final /* synthetic */ InterfaceC23241wb3 h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(InterfaceC7614Sl7 interfaceC7614Sl7, boolean z, boolean z2, InterfaceC23241wb3 interfaceC23241wb3) {
            super(3);
            this.e = interfaceC7614Sl7;
            this.f = z;
            this.g = z2;
            this.h = interfaceC23241wb3;
        }

        public final long a(EnumC24167y93 enumC24167y93, InterfaceC22053ub1 interfaceC22053ub1, int i) {
            interfaceC22053ub1.W(-1272940975);
            if (AbstractC5138Ib1.I()) {
                AbstractC5138Ib1.Q(-1272940975, i, -1, "androidx.compose.material.CommonDecorationBox.<anonymous> (TextFieldImpl.kt:95)");
            }
            long jY = ((C24381yX0) this.e.d(this.f, enumC24167y93 == EnumC24167y93.b ? false : this.g, this.h, interfaceC22053ub1, 0).getValue()).y();
            if (AbstractC5138Ib1.I()) {
                AbstractC5138Ib1.P();
            }
            interfaceC22053ub1.Q();
            return jY;
        }

        @Override // ir.nasim.InterfaceC15796kB2
        public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
            return C24381yX0.k(a((EnumC24167y93) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue()));
        }
    }

    /* renamed from: ir.nasim.dm7$d */
    static final class d extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
        final /* synthetic */ long e;
        final /* synthetic */ C9348Zn7 f;
        final /* synthetic */ Float g;
        final /* synthetic */ InterfaceC14603iB2 h;
        final /* synthetic */ int i;
        final /* synthetic */ int j;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(long j, C9348Zn7 c9348Zn7, Float f, InterfaceC14603iB2 interfaceC14603iB2, int i, int i2) {
            super(2);
            this.e = j;
            this.f = c9348Zn7;
            this.g = f;
            this.h = interfaceC14603iB2;
            this.i = i;
            this.j = i2;
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            AbstractC11925dm7.b(this.e, this.f, this.g, this.h, interfaceC22053ub1, QJ5.a(this.i | 1), this.j);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.dm7$e */
    static final class e extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
        final /* synthetic */ long e;
        final /* synthetic */ Float f;
        final /* synthetic */ InterfaceC14603iB2 g;

        /* renamed from: ir.nasim.dm7$e$a */
        static final class a extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
            final /* synthetic */ Float e;
            final /* synthetic */ InterfaceC14603iB2 f;
            final /* synthetic */ long g;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(Float f, InterfaceC14603iB2 interfaceC14603iB2, long j) {
                super(2);
                this.e = f;
                this.f = interfaceC14603iB2;
                this.g = j;
            }

            public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
                if (!interfaceC22053ub1.o((i & 3) != 2, i & 1)) {
                    interfaceC22053ub1.L();
                    return;
                }
                if (AbstractC5138Ib1.I()) {
                    AbstractC5138Ib1.Q(-1132188434, i, -1, "androidx.compose.material.Decoration.<anonymous>.<anonymous> (TextFieldImpl.kt:240)");
                }
                if (this.e != null) {
                    interfaceC22053ub1.W(-1177895124);
                    AbstractC11024cc1.a(AbstractC16711lk1.a().d(this.e), this.f, interfaceC22053ub1, C7252Qx5.i);
                    interfaceC22053ub1.Q();
                } else {
                    interfaceC22053ub1.W(-1177696538);
                    AbstractC11024cc1.a(AbstractC16711lk1.a().d(Float.valueOf(C24381yX0.r(this.g))), this.f, interfaceC22053ub1, C7252Qx5.i);
                    interfaceC22053ub1.Q();
                }
                if (AbstractC5138Ib1.I()) {
                    AbstractC5138Ib1.P();
                }
            }

            @Override // ir.nasim.InterfaceC14603iB2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
                return C19938rB7.a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e(long j, Float f, InterfaceC14603iB2 interfaceC14603iB2) {
            super(2);
            this.e = j;
            this.f = f;
            this.g = interfaceC14603iB2;
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if (!interfaceC22053ub1.o((i & 3) != 2, i & 1)) {
                interfaceC22053ub1.L();
                return;
            }
            if (AbstractC5138Ib1.I()) {
                AbstractC5138Ib1.Q(494684590, i, -1, "androidx.compose.material.Decoration.<anonymous> (TextFieldImpl.kt:239)");
            }
            AbstractC11024cc1.a(AbstractC20866sk1.a().d(C24381yX0.k(this.e)), AbstractC19242q11.e(-1132188434, true, new a(this.f, this.g, this.e), interfaceC22053ub1, 54), interfaceC22053ub1, C7252Qx5.i | 48);
            if (AbstractC5138Ib1.I()) {
                AbstractC5138Ib1.P();
            }
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.dm7$f */
    static final class f extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ String e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        f(String str) {
            super(1);
            this.e = str;
        }

        public final void a(InterfaceC11943do6 interfaceC11943do6) {
            AbstractC9939ao6.n(interfaceC11943do6, this.e);
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((InterfaceC11943do6) obj);
            return C19938rB7.a;
        }
    }

    public static final void a(EnumC23355wm7 enumC23355wm7, String str, InterfaceC14603iB2 interfaceC14603iB2, QY7 qy7, InterfaceC14603iB2 interfaceC14603iB22, InterfaceC14603iB2 interfaceC14603iB23, InterfaceC14603iB2 interfaceC14603iB24, InterfaceC14603iB2 interfaceC14603iB25, boolean z, boolean z2, boolean z3, InterfaceC23241wb3 interfaceC23241wb3, TS4 ts4, InterfaceC10031ax6 interfaceC10031ax6, InterfaceC7614Sl7 interfaceC7614Sl7, InterfaceC14603iB2 interfaceC14603iB26, InterfaceC22053ub1 interfaceC22053ub1, int i, int i2) {
        int i3;
        int i4;
        InterfaceC22053ub1 interfaceC22053ub12;
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(341783750);
        if ((i & 6) == 0) {
            i3 = (interfaceC22053ub1J.V(enumC23355wm7) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= interfaceC22053ub1J.V(str) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i3 |= interfaceC22053ub1J.D(interfaceC14603iB2) ? 256 : 128;
        }
        if ((i & SetRpcStruct$ComposedRpc.GET_NASIM_FILE_PUBLIC_URL_FIELD_NUMBER) == 0) {
            i3 |= interfaceC22053ub1J.V(qy7) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i3 |= interfaceC22053ub1J.D(interfaceC14603iB22) ? 16384 : 8192;
        }
        if ((i & 196608) == 0) {
            i3 |= interfaceC22053ub1J.D(interfaceC14603iB23) ? 131072 : 65536;
        }
        if ((i & 1572864) == 0) {
            i3 |= interfaceC22053ub1J.D(interfaceC14603iB24) ? 1048576 : 524288;
        }
        if ((i & 12582912) == 0) {
            i3 |= interfaceC22053ub1J.D(interfaceC14603iB25) ? 8388608 : 4194304;
        }
        if ((i & 100663296) == 0) {
            i3 |= interfaceC22053ub1J.a(z) ? 67108864 : 33554432;
        }
        if ((i & 805306368) == 0) {
            i3 |= interfaceC22053ub1J.a(z2) ? 536870912 : 268435456;
        }
        if ((i2 & 6) == 0) {
            i4 = i2 | (interfaceC22053ub1J.a(z3) ? 4 : 2);
        } else {
            i4 = i2;
        }
        if ((i2 & 48) == 0) {
            i4 |= interfaceC22053ub1J.V(interfaceC23241wb3) ? 32 : 16;
        }
        if ((i2 & 384) == 0) {
            i4 |= interfaceC22053ub1J.V(ts4) ? 256 : 128;
        }
        if ((i2 & SetRpcStruct$ComposedRpc.GET_NASIM_FILE_PUBLIC_URL_FIELD_NUMBER) == 0) {
            i4 |= interfaceC22053ub1J.V(interfaceC10031ax6) ? 2048 : 1024;
        }
        if ((i2 & 24576) == 0) {
            i4 |= interfaceC22053ub1J.V(interfaceC7614Sl7) ? 16384 : 8192;
        }
        if ((196608 & i2) == 0) {
            i4 |= interfaceC22053ub1J.D(interfaceC14603iB26) ? 131072 : 65536;
        }
        int i5 = i4;
        if (interfaceC22053ub1J.o(((i3 & 306783379) == 306783378 && (74899 & i5) == 74898) ? false : true, i3 & 1)) {
            if (AbstractC5138Ib1.I()) {
                AbstractC5138Ib1.Q(341783750, i3, i5, "androidx.compose.material.CommonDecorationBox (TextFieldImpl.kt:78)");
            }
            boolean z4 = ((i3 & 7168) == 2048) | ((i3 & SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER) == 32);
            Object objB = interfaceC22053ub1J.B();
            if (z4 || objB == InterfaceC22053ub1.a.a()) {
                objB = qy7.a(new C13245fu(str, null, null, 6, null));
                interfaceC22053ub1J.s(objB);
            }
            String strK = ((C18600ov7) objB).b().k();
            EnumC24167y93 enumC24167y93 = ((Boolean) AbstractC24580yr2.a(interfaceC23241wb3, interfaceC22053ub1J, (i5 >> 3) & 14).getValue()).booleanValue() ? EnumC24167y93.a : strK.length() == 0 ? EnumC24167y93.b : EnumC24167y93.c;
            c cVar = new c(interfaceC7614Sl7, z2, z3, interfaceC23241wb3);
            C15977kV3 c15977kV3 = C15977kV3.a;
            C6061Lz7 c6061Lz7C = c15977kV3.c(interfaceC22053ub1J, 6);
            C9348Zn7 c9348Zn7E = c6061Lz7C.e();
            C9348Zn7 c9348Zn7D = c6061Lz7C.d();
            long jH = c9348Zn7E.h();
            C24381yX0.a aVar = C24381yX0.b;
            boolean z5 = (C24381yX0.q(jH, aVar.i()) && !C24381yX0.q(c9348Zn7D.h(), aVar.i())) || (!C24381yX0.q(c9348Zn7E.h(), aVar.i()) && C24381yX0.q(c9348Zn7D.h(), aVar.i()));
            C22759vm7 c22759vm7 = C22759vm7.a;
            interfaceC22053ub1J.W(1578866909);
            long jH2 = c15977kV3.c(interfaceC22053ub1J, 6).d().h();
            if (z5) {
                interfaceC22053ub1J.W(-1572812364);
                if (jH2 == 16) {
                    jH2 = ((C24381yX0) cVar.q(enumC24167y93, interfaceC22053ub1J, 0)).y();
                }
                interfaceC22053ub1J.Q();
            } else {
                interfaceC22053ub1J.W(780549965);
                interfaceC22053ub1J.Q();
            }
            long j = jH2;
            interfaceC22053ub1J.Q();
            interfaceC22053ub1J.W(1578874175);
            long jH3 = c15977kV3.c(interfaceC22053ub1J, 6).e().h();
            if (z5) {
                interfaceC22053ub1J.W(-1572585196);
                if (jH3 == 16) {
                    jH3 = ((C24381yX0) cVar.q(enumC24167y93, interfaceC22053ub1J, 0)).y();
                }
                interfaceC22053ub1J.Q();
            } else {
                interfaceC22053ub1J.W(780557293);
                interfaceC22053ub1J.Q();
            }
            long j2 = jH3;
            interfaceC22053ub1J.Q();
            interfaceC22053ub12 = interfaceC22053ub1J;
            c22759vm7.a(enumC24167y93, j, j2, cVar, interfaceC14603iB22 != null, AbstractC19242q11.e(225557475, true, new a(interfaceC14603iB22, interfaceC14603iB23, strK, interfaceC7614Sl7, z2, z3, interfaceC23241wb3, interfaceC14603iB24, interfaceC14603iB25, interfaceC10031ax6, enumC23355wm7, interfaceC14603iB2, z, ts4, z5, interfaceC14603iB26), interfaceC22053ub12, 54), interfaceC22053ub12, 1769472);
            if (AbstractC5138Ib1.I()) {
                AbstractC5138Ib1.P();
            }
        } else {
            interfaceC22053ub12 = interfaceC22053ub1J;
            interfaceC22053ub12.L();
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub12.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new b(enumC23355wm7, str, interfaceC14603iB2, qy7, interfaceC14603iB22, interfaceC14603iB23, interfaceC14603iB24, interfaceC14603iB25, z, z2, z3, interfaceC23241wb3, ts4, interfaceC10031ax6, interfaceC7614Sl7, interfaceC14603iB26, i, i2));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:73:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void b(long r14, ir.nasim.C9348Zn7 r16, java.lang.Float r17, ir.nasim.InterfaceC14603iB2 r18, ir.nasim.InterfaceC22053ub1 r19, int r20, int r21) {
        /*
            Method dump skipped, instructions count: 240
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC11925dm7.b(long, ir.nasim.Zn7, java.lang.Float, ir.nasim.iB2, ir.nasim.ub1, int, int):void");
    }

    public static final androidx.compose.ui.e c(androidx.compose.ui.e eVar, boolean z, String str) {
        return z ? AbstractC6919Pn6.d(eVar, false, new f(str), 1, null) : eVar;
    }

    public static final float d() {
        return b;
    }

    public static final Object e(InterfaceC9236Zb3 interfaceC9236Zb3) {
        Object objH = interfaceC9236Zb3.h();
        InterfaceC15631ju3 interfaceC15631ju3 = objH instanceof InterfaceC15631ju3 ? (InterfaceC15631ju3) objH : null;
        if (interfaceC15631ju3 != null) {
            return interfaceC15631ju3.Y0();
        }
        return null;
    }

    public static final float f() {
        return a;
    }

    public static final int g(AbstractC21430te5 abstractC21430te5) {
        if (abstractC21430te5 != null) {
            return abstractC21430te5.A0();
        }
        return 0;
    }

    public static final int h(AbstractC21430te5 abstractC21430te5) {
        if (abstractC21430te5 != null) {
            return abstractC21430te5.P0();
        }
        return 0;
    }
}
