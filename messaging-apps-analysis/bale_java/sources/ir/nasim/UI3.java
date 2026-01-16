package ir.nasim;

import kotlin.NoWhenBranchMatchedException;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes3.dex */
public final class UI3 {
    public static final UI3 a = new UI3("VERBOSE", 0);
    public static final UI3 b = new UI3("DEBUG", 1);
    public static final UI3 c = new UI3("INFO", 2);
    public static final UI3 d = new UI3("WARN", 3);
    public static final UI3 e = new UI3("ERROR", 4);
    public static final UI3 f = new UI3("WTF", 5);
    public static final UI3 g = new UI3("OFF", 6);
    private static final /* synthetic */ UI3[] h;
    private static final /* synthetic */ F92 i;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[UI3.values().length];
            try {
                iArr[UI3.a.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[UI3.c.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[UI3.b.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[UI3.d.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[UI3.e.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[UI3.f.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[UI3.g.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            a = iArr;
        }
    }

    static {
        UI3[] ui3ArrA = a();
        h = ui3ArrA;
        i = G92.a(ui3ArrA);
    }

    private UI3(String str, int i2) {
    }

    private static final /* synthetic */ UI3[] a() {
        return new UI3[]{a, b, c, d, e, f, g};
    }

    public static UI3 valueOf(String str) {
        return (UI3) Enum.valueOf(UI3.class, str);
    }

    public static UI3[] values() {
        return (UI3[]) h.clone();
    }

    public final int j() {
        switch (a.a[ordinal()]) {
            case 1:
                return 2;
            case 2:
                return 4;
            case 3:
                return 3;
            case 4:
                return 5;
            case 5:
            case 6:
                return 6;
            case 7:
                return 0;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }
}
