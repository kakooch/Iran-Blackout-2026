package ir.nasim;

import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import kotlin.NoWhenBranchMatchedException;

/* loaded from: classes5.dex */
public final class AN1 implements BN1 {

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;
        public static final /* synthetic */ int[] b;

        static {
            int[] iArr = new int[EnumC23130wP1.values().length];
            try {
                iArr[EnumC23130wP1.a.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[EnumC23130wP1.b.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[EnumC23130wP1.c.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            a = iArr;
            int[] iArr2 = new int[SS4.values().length];
            try {
                iArr2[SS4.a.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr2[SS4.b.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr2[SS4.c.ordinal()] = 3;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr2[SS4.d.ordinal()] = 4;
            } catch (NoSuchFieldError unused7) {
            }
            b = iArr2;
        }
    }

    @Override // ir.nasim.BN1
    public int a(EnumC23130wP1 enumC23130wP1) {
        AbstractC13042fc3.i(enumC23130wP1, "dialogState");
        int i = a.a[enumC23130wP1.ordinal()];
        if (i == 1) {
            return KB5.msg_check_1;
        }
        if (i == 2 || i == 3) {
            return KB5.msg_check_2;
        }
        throw new NoWhenBranchMatchedException();
    }

    @Override // ir.nasim.BN1
    public String b(int i) {
        String strValueOf = String.valueOf(i);
        return JF5.g() ? XY6.e(strValueOf) : strValueOf;
    }

    @Override // ir.nasim.BN1
    public int c() {
        return 20;
    }

    @Override // ir.nasim.BN1
    public Drawable d() {
        Drawable drawableD = AbstractC4310Eo7.d(C22078ud6.a(16.0f), C5495Jo7.a.T0());
        AbstractC13042fc3.h(drawableD, "createRoundRectDrawable(...)");
        return drawableD;
    }

    @Override // ir.nasim.BN1
    public Drawable e() {
        Drawable drawableD = AbstractC4310Eo7.d(C22078ud6.a(16.0f), C5495Jo7.a.U0());
        AbstractC13042fc3.h(drawableD, "createRoundRectDrawable(...)");
        return drawableD;
    }

    @Override // ir.nasim.BN1
    public int f() {
        return C5495Jo7.a.Y0();
    }

    @Override // ir.nasim.BN1
    public int g(SS4 ss4) {
        AbstractC13042fc3.i(ss4, "paddingType");
        int i = a.b[ss4.ordinal()];
        if (i == 1) {
            return 6;
        }
        if (i == 2) {
            return 0;
        }
        if (i == 3) {
            return 6;
        }
        if (i == 4) {
            return -1;
        }
        throw new NoWhenBranchMatchedException();
    }

    @Override // ir.nasim.BN1
    public int h() {
        return C5495Jo7.a.Y0();
    }

    @Override // ir.nasim.BN1
    public int i(EnumC23130wP1 enumC23130wP1) {
        AbstractC13042fc3.i(enumC23130wP1, "dialogState");
        int i = a.a[enumC23130wP1.ordinal()];
        if (i == 1) {
            return C5495Jo7.a.T0();
        }
        if (i == 2) {
            return C5495Jo7.a.T0();
        }
        if (i == 3) {
            return C5495Jo7.a.U0();
        }
        throw new NoWhenBranchMatchedException();
    }

    @Override // ir.nasim.BN1
    public Typeface j() {
        return C6011Lu2.k();
    }
}
