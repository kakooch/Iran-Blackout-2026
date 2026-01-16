package ir.nasim;

import kotlin.NoWhenBranchMatchedException;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* renamed from: ir.nasim.Zs3, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class EnumC9389Zs3 {
    public static final EnumC9389Zs3 a = new EnumC9389Zs3("FARSI", 0);
    public static final EnumC9389Zs3 b = new EnumC9389Zs3("ENGLISH", 1);
    public static final EnumC9389Zs3 c = new EnumC9389Zs3("ARABIC", 2);
    public static final EnumC9389Zs3 d = new EnumC9389Zs3("TORKI", 3);
    private static final /* synthetic */ EnumC9389Zs3[] e;
    private static final /* synthetic */ F92 f;

    /* renamed from: ir.nasim.Zs3$a */
    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[EnumC9389Zs3.values().length];
            try {
                iArr[EnumC9389Zs3.a.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[EnumC9389Zs3.b.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[EnumC9389Zs3.d.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[EnumC9389Zs3.c.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            a = iArr;
        }
    }

    static {
        EnumC9389Zs3[] enumC9389Zs3ArrA = a();
        e = enumC9389Zs3ArrA;
        f = G92.a(enumC9389Zs3ArrA);
    }

    private EnumC9389Zs3(String str, int i) {
    }

    private static final /* synthetic */ EnumC9389Zs3[] a() {
        return new EnumC9389Zs3[]{a, b, c, d};
    }

    public static EnumC9389Zs3 valueOf(String str) {
        return (EnumC9389Zs3) Enum.valueOf(EnumC9389Zs3.class, str);
    }

    public static EnumC9389Zs3[] values() {
        return (EnumC9389Zs3[]) e.clone();
    }

    @Override // java.lang.Enum
    public String toString() {
        int i = a.a[ordinal()];
        if (i == 1) {
            return "fa";
        }
        if (i == 2) {
            return "en";
        }
        if (i == 3) {
            return "ks";
        }
        if (i == 4) {
            return "ar";
        }
        throw new NoWhenBranchMatchedException();
    }
}
