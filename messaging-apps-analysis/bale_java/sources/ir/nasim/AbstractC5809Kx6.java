package ir.nasim;

import kotlin.NoWhenBranchMatchedException;

/* renamed from: ir.nasim.Kx6, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC5809Kx6 {
    private static final AbstractC6535Nx5 a = AbstractC11024cc1.f(a.e);

    /* renamed from: ir.nasim.Kx6$a */
    static final class a extends AbstractC8614Ws3 implements SA2 {
        public static final a e = new a();

        a() {
            super(0);
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final C5107Hx6 invoke() {
            return new C5107Hx6(null, null, null, null, null, 31, null);
        }
    }

    /* renamed from: ir.nasim.Kx6$b */
    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[EnumC21686tx6.values().length];
            try {
                iArr[EnumC21686tx6.CornerExtraLarge.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[EnumC21686tx6.CornerExtraLargeTop.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[EnumC21686tx6.CornerExtraSmall.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[EnumC21686tx6.CornerExtraSmallTop.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[EnumC21686tx6.CornerFull.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[EnumC21686tx6.CornerLarge.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[EnumC21686tx6.CornerLargeEnd.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[EnumC21686tx6.CornerLargeTop.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr[EnumC21686tx6.CornerMedium.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr[EnumC21686tx6.CornerNone.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                iArr[EnumC21686tx6.CornerSmall.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            a = iArr;
        }
    }

    public static final AbstractC8333Vn1 a(AbstractC8333Vn1 abstractC8333Vn1) {
        float f = (float) 0.0d;
        return AbstractC8333Vn1.d(abstractC8333Vn1, AbstractC10554bo1.c(C17784nZ1.q(f)), null, null, AbstractC10554bo1.c(C17784nZ1.q(f)), 6, null);
    }

    public static final InterfaceC10031ax6 b(C5107Hx6 c5107Hx6, EnumC21686tx6 enumC21686tx6) {
        switch (b.a[enumC21686tx6.ordinal()]) {
            case 1:
                return c5107Hx6.a();
            case 2:
                return e(c5107Hx6.a());
            case 3:
                return c5107Hx6.b();
            case 4:
                return e(c5107Hx6.b());
            case 5:
                return N46.g();
            case 6:
                return c5107Hx6.c();
            case 7:
                return a(c5107Hx6.c());
            case 8:
                return e(c5107Hx6.c());
            case 9:
                return c5107Hx6.d();
            case 10:
                return MK5.a();
            case 11:
                return c5107Hx6.e();
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    public static final AbstractC6535Nx5 c() {
        return a;
    }

    public static final InterfaceC10031ax6 d(EnumC21686tx6 enumC21686tx6, InterfaceC22053ub1 interfaceC22053ub1, int i) {
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.Q(1629172543, i, -1, "androidx.compose.material3.<get-value> (Shapes.kt:191)");
        }
        InterfaceC10031ax6 interfaceC10031ax6B = b(C15386jV3.a.b(interfaceC22053ub1, 6), enumC21686tx6);
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.P();
        }
        return interfaceC10031ax6B;
    }

    public static final AbstractC8333Vn1 e(AbstractC8333Vn1 abstractC8333Vn1) {
        float f = (float) 0.0d;
        return AbstractC8333Vn1.d(abstractC8333Vn1, null, null, AbstractC10554bo1.c(C17784nZ1.q(f)), AbstractC10554bo1.c(C17784nZ1.q(f)), 3, null);
    }
}
