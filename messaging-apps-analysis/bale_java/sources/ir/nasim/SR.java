package ir.nasim;

import kotlin.NoWhenBranchMatchedException;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes5.dex */
public final class SR {
    public static final SR a = new SR("C2C", 0);
    public static final SR b = new SR("BOT_PROTECTED_MESSAGES", 1);
    public static final SR c = new SR("BOT_WALLET", 2);
    public static final SR d = new SR("BOT_INLINE_BUTTON", 3);
    private static final /* synthetic */ SR[] e;
    private static final /* synthetic */ F92 f;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[SR.values().length];
            try {
                iArr[SR.a.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[SR.b.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[SR.c.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[SR.d.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            a = iArr;
        }
    }

    static {
        SR[] srArrA = a();
        e = srArrA;
        f = G92.a(srArrA);
    }

    private SR(String str, int i) {
    }

    private static final /* synthetic */ SR[] a() {
        return new SR[]{a, b, c, d};
    }

    public static SR valueOf(String str) {
        return (SR) Enum.valueOf(SR.class, str);
    }

    public static SR[] values() {
        return (SR[]) e.clone();
    }

    public final EnumC14053hG5 j() {
        int i = a.a[ordinal()];
        if (i == 1) {
            return EnumC14053hG5.C2C;
        }
        if (i == 2) {
            return EnumC14053hG5.Bot;
        }
        if (i == 3) {
            return EnumC14053hG5.UNRECOGNIZED;
        }
        if (i == 4) {
            return EnumC14053hG5.Bot;
        }
        throw new NoWhenBranchMatchedException();
    }
}
