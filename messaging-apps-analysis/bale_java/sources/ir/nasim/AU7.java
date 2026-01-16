package ir.nasim;

import kotlin.NoWhenBranchMatchedException;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes3.dex */
public final class AU7 {
    public static final a Companion;
    public static final AU7 a = new AU7("LOW", 0);
    public static final AU7 b = new AU7("MEDIUM", 1);
    public static final AU7 c = new AU7("HIGH", 2);
    private static final /* synthetic */ AU7[] d;
    private static final /* synthetic */ F92 e;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[AU7.values().length];
            try {
                iArr[AU7.a.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[AU7.b.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[AU7.c.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            a = iArr;
        }
    }

    static {
        AU7[] au7ArrA = a();
        d = au7ArrA;
        e = G92.a(au7ArrA);
        Companion = new a(null);
    }

    private AU7(String str, int i) {
    }

    private static final /* synthetic */ AU7[] a() {
        return new AU7[]{a, b, c};
    }

    public static AU7 valueOf(String str) {
        return (AU7) Enum.valueOf(AU7.class, str);
    }

    public static AU7[] values() {
        return (AU7[]) d.clone();
    }

    public final EnumC12833fF3 j() {
        int i = b.a[ordinal()];
        if (i == 1) {
            return EnumC12833fF3.LOW;
        }
        if (i == 2) {
            return EnumC12833fF3.MEDIUM;
        }
        if (i == 3) {
            return EnumC12833fF3.HIGH;
        }
        throw new NoWhenBranchMatchedException();
    }
}
