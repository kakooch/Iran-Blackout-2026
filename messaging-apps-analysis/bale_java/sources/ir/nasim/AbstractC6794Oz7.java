package ir.nasim;

import kotlin.NoWhenBranchMatchedException;

/* renamed from: ir.nasim.Oz7, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC6794Oz7 {
    private static final AbstractC6535Nx5 a = AbstractC11024cc1.f(a.e);

    /* renamed from: ir.nasim.Oz7$a */
    static final class a extends AbstractC8614Ws3 implements SA2 {
        public static final a e = new a();

        a() {
            super(0);
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final C5828Kz7 invoke() {
            return new C5828Kz7(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 32767, null);
        }
    }

    /* renamed from: ir.nasim.Oz7$b */
    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[EnumC6295Mz7.values().length];
            try {
                iArr[EnumC6295Mz7.DisplayLarge.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[EnumC6295Mz7.DisplayMedium.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[EnumC6295Mz7.DisplaySmall.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[EnumC6295Mz7.HeadlineLarge.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[EnumC6295Mz7.HeadlineMedium.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[EnumC6295Mz7.HeadlineSmall.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[EnumC6295Mz7.TitleLarge.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[EnumC6295Mz7.TitleMedium.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr[EnumC6295Mz7.TitleSmall.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr[EnumC6295Mz7.BodyLarge.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                iArr[EnumC6295Mz7.BodyMedium.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                iArr[EnumC6295Mz7.BodySmall.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                iArr[EnumC6295Mz7.LabelLarge.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                iArr[EnumC6295Mz7.LabelMedium.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                iArr[EnumC6295Mz7.LabelSmall.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            a = iArr;
        }
    }

    private static final C9348Zn7 a(C5828Kz7 c5828Kz7, EnumC6295Mz7 enumC6295Mz7) {
        switch (b.a[enumC6295Mz7.ordinal()]) {
            case 1:
                return c5828Kz7.d();
            case 2:
                return c5828Kz7.e();
            case 3:
                return c5828Kz7.f();
            case 4:
                return c5828Kz7.g();
            case 5:
                return c5828Kz7.h();
            case 6:
                return c5828Kz7.i();
            case 7:
                return c5828Kz7.m();
            case 8:
                return c5828Kz7.n();
            case 9:
                return c5828Kz7.o();
            case 10:
                return c5828Kz7.a();
            case 11:
                return c5828Kz7.b();
            case 12:
                return c5828Kz7.c();
            case 13:
                return c5828Kz7.j();
            case 14:
                return c5828Kz7.k();
            case 15:
                return c5828Kz7.l();
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    public static final AbstractC6535Nx5 b() {
        return a;
    }

    public static final C9348Zn7 c(EnumC6295Mz7 enumC6295Mz7, InterfaceC22053ub1 interfaceC22053ub1, int i) {
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.Q(-1049072145, i, -1, "androidx.compose.material3.<get-value> (Typography.kt:209)");
        }
        C9348Zn7 c9348Zn7A = a(C15386jV3.a.c(interfaceC22053ub1, 6), enumC6295Mz7);
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.P();
        }
        return c9348Zn7A;
    }
}
