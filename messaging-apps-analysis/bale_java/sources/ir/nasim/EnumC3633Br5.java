package ir.nasim;

import kotlin.NoWhenBranchMatchedException;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* renamed from: ir.nasim.Br5, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class EnumC3633Br5 {
    public static final a a;
    public static final EnumC3633Br5 b = new EnumC3633Br5("NONE", 0);
    public static final EnumC3633Br5 c = new EnumC3633Br5("SPAM", 1);
    public static final EnumC3633Br5 d = new EnumC3633Br5("UNSUPPORTED_VALUE", 2);
    private static final /* synthetic */ EnumC3633Br5[] e;
    private static final /* synthetic */ F92 f;

    /* renamed from: ir.nasim.Br5$a */
    public static final class a {

        /* renamed from: ir.nasim.Br5$a$a, reason: collision with other inner class name */
        public /* synthetic */ class C0300a {
            public static final /* synthetic */ int[] a;

            static {
                int[] iArr = new int[EnumC12184eB.values().length];
                try {
                    iArr[EnumC12184eB.SPAM.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[EnumC12184eB.UNSUPPORTED_VALUE.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[EnumC12184eB.UNKNOWN.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                try {
                    iArr[EnumC12184eB.NONE.ordinal()] = 4;
                } catch (NoSuchFieldError unused4) {
                }
                a = iArr;
            }
        }

        private a() {
        }

        public final EnumC3633Br5 a(EnumC12184eB enumC12184eB) {
            int i = enumC12184eB == null ? -1 : C0300a.a[enumC12184eB.ordinal()];
            if (i != -1) {
                if (i == 1) {
                    return EnumC3633Br5.c;
                }
                if (i == 2 || i == 3) {
                    return EnumC3633Br5.d;
                }
                if (i != 4) {
                    throw new NoWhenBranchMatchedException();
                }
            }
            return EnumC3633Br5.b;
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    static {
        EnumC3633Br5[] enumC3633Br5ArrA = a();
        e = enumC3633Br5ArrA;
        f = G92.a(enumC3633Br5ArrA);
        a = new a(null);
    }

    private EnumC3633Br5(String str, int i) {
    }

    private static final /* synthetic */ EnumC3633Br5[] a() {
        return new EnumC3633Br5[]{b, c, d};
    }

    public static EnumC3633Br5 valueOf(String str) {
        return (EnumC3633Br5) Enum.valueOf(EnumC3633Br5.class, str);
    }

    public static EnumC3633Br5[] values() {
        return (EnumC3633Br5[]) e.clone();
    }
}
