package ir.nasim;

import androidx.recyclerview.widget.RecyclerView;
import okhttp3.internal.http2.Http2Connection;

/* loaded from: classes.dex */
public abstract class ZX0 {
    private static final AbstractC6535Nx5 a = AbstractC11024cc1.f(a.e);
    private static final AbstractC6535Nx5 b = AbstractC11024cc1.f(b.e);

    static final class a extends AbstractC8614Ws3 implements SA2 {
        public static final a e = new a();

        a() {
            super(0);
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final XX0 invoke() {
            return ZX0.h(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, -1, 15, null);
        }
    }

    static final class b extends AbstractC8614Ws3 implements SA2 {
        public static final b e = new b();

        b() {
            super(0);
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke() {
            return Boolean.TRUE;
        }
    }

    public /* synthetic */ class c {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[YX0.values().length];
            try {
                iArr[YX0.Background.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[YX0.Error.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[YX0.ErrorContainer.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[YX0.InverseOnSurface.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[YX0.InversePrimary.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[YX0.InverseSurface.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[YX0.OnBackground.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[YX0.OnError.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr[YX0.OnErrorContainer.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr[YX0.OnPrimary.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                iArr[YX0.OnPrimaryContainer.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                iArr[YX0.OnSecondary.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                iArr[YX0.OnSecondaryContainer.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                iArr[YX0.OnSurface.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                iArr[YX0.OnSurfaceVariant.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                iArr[YX0.SurfaceTint.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                iArr[YX0.OnTertiary.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                iArr[YX0.OnTertiaryContainer.ordinal()] = 18;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                iArr[YX0.Outline.ordinal()] = 19;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                iArr[YX0.OutlineVariant.ordinal()] = 20;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                iArr[YX0.Primary.ordinal()] = 21;
            } catch (NoSuchFieldError unused21) {
            }
            try {
                iArr[YX0.PrimaryContainer.ordinal()] = 22;
            } catch (NoSuchFieldError unused22) {
            }
            try {
                iArr[YX0.Scrim.ordinal()] = 23;
            } catch (NoSuchFieldError unused23) {
            }
            try {
                iArr[YX0.Secondary.ordinal()] = 24;
            } catch (NoSuchFieldError unused24) {
            }
            try {
                iArr[YX0.SecondaryContainer.ordinal()] = 25;
            } catch (NoSuchFieldError unused25) {
            }
            try {
                iArr[YX0.Surface.ordinal()] = 26;
            } catch (NoSuchFieldError unused26) {
            }
            try {
                iArr[YX0.SurfaceVariant.ordinal()] = 27;
            } catch (NoSuchFieldError unused27) {
            }
            try {
                iArr[YX0.SurfaceBright.ordinal()] = 28;
            } catch (NoSuchFieldError unused28) {
            }
            try {
                iArr[YX0.SurfaceContainer.ordinal()] = 29;
            } catch (NoSuchFieldError unused29) {
            }
            try {
                iArr[YX0.SurfaceContainerHigh.ordinal()] = 30;
            } catch (NoSuchFieldError unused30) {
            }
            try {
                iArr[YX0.SurfaceContainerHighest.ordinal()] = 31;
            } catch (NoSuchFieldError unused31) {
            }
            try {
                iArr[YX0.SurfaceContainerLow.ordinal()] = 32;
            } catch (NoSuchFieldError unused32) {
            }
            try {
                iArr[YX0.SurfaceContainerLowest.ordinal()] = 33;
            } catch (NoSuchFieldError unused33) {
            }
            try {
                iArr[YX0.SurfaceDim.ordinal()] = 34;
            } catch (NoSuchFieldError unused34) {
            }
            try {
                iArr[YX0.Tertiary.ordinal()] = 35;
            } catch (NoSuchFieldError unused35) {
            }
            try {
                iArr[YX0.TertiaryContainer.ordinal()] = 36;
            } catch (NoSuchFieldError unused36) {
            }
            a = iArr;
        }
    }

    public static final long a(XX0 xx0, long j, float f, InterfaceC22053ub1 interfaceC22053ub1, int i) {
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.Q(-1610977682, i, -1, "androidx.compose.material3.applyTonalElevation (ColorScheme.kt:895)");
        }
        boolean zBooleanValue = ((Boolean) interfaceC22053ub1.H(b)).booleanValue();
        if (C24381yX0.q(j, xx0.H()) && zBooleanValue) {
            j = i(xx0, f);
        }
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.P();
        }
        return j;
    }

    public static final long b(XX0 xx0, long j) {
        return C24381yX0.q(j, xx0.C()) ? xx0.s() : C24381yX0.q(j, xx0.F()) ? xx0.u() : C24381yX0.q(j, xx0.R()) ? xx0.y() : C24381yX0.q(j, xx0.a()) ? xx0.p() : C24381yX0.q(j, xx0.k()) ? xx0.q() : C24381yX0.q(j, xx0.D()) ? xx0.t() : C24381yX0.q(j, xx0.G()) ? xx0.v() : C24381yX0.q(j, xx0.S()) ? xx0.z() : C24381yX0.q(j, xx0.l()) ? xx0.r() : C24381yX0.q(j, xx0.o()) ? xx0.m() : C24381yX0.q(j, xx0.H()) ? xx0.w() : C24381yX0.q(j, xx0.Q()) ? xx0.x() : C24381yX0.q(j, xx0.I()) ? xx0.w() : C24381yX0.q(j, xx0.J()) ? xx0.w() : C24381yX0.q(j, xx0.K()) ? xx0.w() : C24381yX0.q(j, xx0.L()) ? xx0.w() : C24381yX0.q(j, xx0.M()) ? xx0.w() : C24381yX0.q(j, xx0.N()) ? xx0.w() : C24381yX0.b.i();
    }

    public static final long c(long j, InterfaceC22053ub1 interfaceC22053ub1, int i) {
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.Q(509589638, i, -1, "androidx.compose.material3.contentColorFor (ColorScheme.kt:878)");
        }
        interfaceC22053ub1.W(-1680936624);
        long jB = b(C15386jV3.a.a(interfaceC22053ub1, 6), j);
        if (jB == 16) {
            jB = ((C24381yX0) interfaceC22053ub1.H(AbstractC21553tk1.a())).y();
        }
        interfaceC22053ub1.Q();
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.P();
        }
        return jB;
    }

    public static final long d(XX0 xx0, YX0 yx0) {
        switch (c.a[yx0.ordinal()]) {
            case 1:
                return xx0.a();
            case 2:
                return xx0.k();
            case 3:
                return xx0.l();
            case 4:
                return xx0.m();
            case 5:
                return xx0.n();
            case 6:
                return xx0.o();
            case 7:
                return xx0.p();
            case 8:
                return xx0.q();
            case 9:
                return xx0.r();
            case 10:
                return xx0.s();
            case 11:
                return xx0.t();
            case 12:
                return xx0.u();
            case 13:
                return xx0.v();
            case 14:
                return xx0.w();
            case 15:
                return xx0.x();
            case 16:
                return xx0.P();
            case 17:
                return xx0.y();
            case 18:
                return xx0.z();
            case 19:
                return xx0.A();
            case 20:
                return xx0.B();
            case 21:
                return xx0.C();
            case 22:
                return xx0.D();
            case 23:
                return xx0.E();
            case 24:
                return xx0.F();
            case 25:
                return xx0.G();
            case 26:
                return xx0.H();
            case 27:
                return xx0.Q();
            case 28:
                return xx0.I();
            case 29:
                return xx0.J();
            case 30:
                return xx0.K();
            case 31:
                return xx0.L();
            case 32:
                return xx0.M();
            case 33:
                return xx0.N();
            case 34:
                return xx0.O();
            case 35:
                return xx0.R();
            case 36:
                return xx0.S();
            default:
                return C24381yX0.b.i();
        }
    }

    public static final AbstractC6535Nx5 e() {
        return a;
    }

    public static final long f(YX0 yx0, InterfaceC22053ub1 interfaceC22053ub1, int i) {
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.Q(-810780884, i, -1, "androidx.compose.material3.<get-value> (ColorScheme.kt:1009)");
        }
        long jD = d(C15386jV3.a.a(interfaceC22053ub1, 6), yx0);
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.P();
        }
        return jD;
    }

    public static final XX0 g(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, long j20, long j21, long j22, long j23, long j24, long j25, long j26, long j27, long j28, long j29, long j30, long j31, long j32, long j33, long j34, long j35, long j36) {
        return new XX0(j, j2, j3, j4, j5, j6, j7, j8, j9, j10, j11, j12, j13, j14, j15, j16, j17, j18, j19, j20, j21, j22, j23, j24, j25, j26, j27, j28, j29, j30, j36, j31, j32, j33, j34, j35, null);
    }

    public static /* synthetic */ XX0 h(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, long j20, long j21, long j22, long j23, long j24, long j25, long j26, long j27, long j28, long j29, long j30, long j31, long j32, long j33, long j34, long j35, long j36, int i, int i2, Object obj) {
        long jT = (i & 1) != 0 ? EX0.a.t() : j;
        return g(jT, (i & 2) != 0 ? EX0.a.j() : j2, (i & 4) != 0 ? EX0.a.u() : j3, (i & 8) != 0 ? EX0.a.k() : j4, (i & 16) != 0 ? EX0.a.e() : j5, (i & 32) != 0 ? EX0.a.w() : j6, (i & 64) != 0 ? EX0.a.l() : j7, (i & 128) != 0 ? EX0.a.x() : j8, (i & 256) != 0 ? EX0.a.m() : j9, (i & 512) != 0 ? EX0.a.H() : j10, (i & 1024) != 0 ? EX0.a.p() : j11, (i & 2048) != 0 ? EX0.a.I() : j12, (i & 4096) != 0 ? EX0.a.q() : j13, (i & 8192) != 0 ? EX0.a.a() : j14, (i & 16384) != 0 ? EX0.a.g() : j15, (i & 32768) != 0 ? EX0.a.y() : j16, (i & 65536) != 0 ? EX0.a.n() : j17, (i & 131072) != 0 ? EX0.a.G() : j18, (i & 262144) != 0 ? EX0.a.o() : j19, (i & 524288) != 0 ? jT : j20, (i & 1048576) != 0 ? EX0.a.f() : j21, (i & 2097152) != 0 ? EX0.a.d() : j22, (i & 4194304) != 0 ? EX0.a.b() : j23, (i & 8388608) != 0 ? EX0.a.h() : j24, (i & Http2Connection.OKHTTP_CLIENT_WINDOW_SIZE) != 0 ? EX0.a.c() : j25, (i & 33554432) != 0 ? EX0.a.i() : j26, (i & 67108864) != 0 ? EX0.a.r() : j27, (i & 134217728) != 0 ? EX0.a.s() : j28, (i & 268435456) != 0 ? EX0.a.v() : j29, (i & 536870912) != 0 ? EX0.a.z() : j30, (i & 1073741824) != 0 ? EX0.a.A() : j31, (i & RecyclerView.UNDEFINED_DURATION) != 0 ? EX0.a.B() : j32, (i2 & 1) != 0 ? EX0.a.C() : j33, (i2 & 2) != 0 ? EX0.a.D() : j34, (i2 & 4) != 0 ? EX0.a.E() : j35, (i2 & 8) != 0 ? EX0.a.F() : j36);
    }

    public static final long i(XX0 xx0, float f) {
        if (C17784nZ1.s(f, C17784nZ1.q(0))) {
            return xx0.H();
        }
        return DX0.h(C24381yX0.o(xx0.P(), ((((float) Math.log(f + 1)) * 4.5f) + 2.0f) / 100.0f, 0.0f, 0.0f, 0.0f, 14, null), xx0.H());
    }
}
