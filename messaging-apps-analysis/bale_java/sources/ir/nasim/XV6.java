package ir.nasim;

import kotlin.NoWhenBranchMatchedException;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes7.dex */
public final class XV6 {
    public static final a b;
    public static final XV6 c = new XV6("UNRECOGNIZED", 0, 0);
    public static final XV6 d = new XV6("PHOTO", 1, 1);
    public static final XV6 e = new XV6("VIDEO", 2, 2);
    public static final XV6 f = new XV6("TEXT", 3, 3);
    public static final XV6 g = new XV6("AFKAR", 4, 4);
    private static final /* synthetic */ XV6[] h;
    private static final /* synthetic */ F92 i;
    private final int a;

    public static final class a {

        /* renamed from: ir.nasim.XV6$a$a, reason: collision with other inner class name */
        public /* synthetic */ class C0755a {
            public static final /* synthetic */ int[] a;

            static {
                int[] iArr = new int[EnumC14144hQ6.values().length];
                try {
                    iArr[EnumC14144hQ6.a.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[EnumC14144hQ6.b.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[EnumC14144hQ6.c.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                try {
                    iArr[EnumC14144hQ6.d.ordinal()] = 4;
                } catch (NoSuchFieldError unused4) {
                }
                a = iArr;
            }
        }

        private a() {
        }

        public final XV6 a(EnumC14144hQ6 enumC14144hQ6) {
            int i = enumC14144hQ6 == null ? -1 : C0755a.a[enumC14144hQ6.ordinal()];
            if (i == -1) {
                return XV6.c;
            }
            if (i == 1) {
                return XV6.d;
            }
            if (i == 2) {
                return XV6.e;
            }
            if (i == 3) {
                return XV6.g;
            }
            if (i == 4) {
                return XV6.c;
            }
            throw new NoWhenBranchMatchedException();
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    static {
        XV6[] xv6ArrA = a();
        h = xv6ArrA;
        i = G92.a(xv6ArrA);
        b = new a(null);
    }

    private XV6(String str, int i2, int i3) {
        this.a = i3;
    }

    private static final /* synthetic */ XV6[] a() {
        return new XV6[]{c, d, e, f, g};
    }

    public static XV6 valueOf(String str) {
        return (XV6) Enum.valueOf(XV6.class, str);
    }

    public static XV6[] values() {
        return (XV6[]) h.clone();
    }

    public final int j() {
        return this.a;
    }
}
