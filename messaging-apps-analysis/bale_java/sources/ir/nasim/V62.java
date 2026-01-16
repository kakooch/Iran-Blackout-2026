package ir.nasim;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes6.dex */
public final class V62 {
    public static final a b;
    public static final V62 c = new V62("HEADER", 0, 1010);
    public static final V62 d = new V62("EMOJI", 1, 1020);
    public static final V62 e = new V62("RECENT_EMOJI", 2, 1030);
    private static final /* synthetic */ V62[] f;
    private static final /* synthetic */ F92 g;
    private final int a;

    public static final class a {
        private a() {
        }

        public final V62 a(int i) {
            V62 v62;
            V62[] v62ArrValues = V62.values();
            int length = v62ArrValues.length;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    v62 = null;
                    break;
                }
                v62 = v62ArrValues[i2];
                if (v62.getNumber() == i) {
                    break;
                }
                i2++;
            }
            return v62 == null ? V62.c : v62;
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    static {
        V62[] v62ArrA = a();
        f = v62ArrA;
        g = G92.a(v62ArrA);
        b = new a(null);
    }

    private V62(String str, int i, int i2) {
        this.a = i2;
    }

    private static final /* synthetic */ V62[] a() {
        return new V62[]{c, d, e};
    }

    public static V62 valueOf(String str) {
        return (V62) Enum.valueOf(V62.class, str);
    }

    public static V62[] values() {
        return (V62[]) f.clone();
    }

    public final int getNumber() {
        return this.a;
    }
}
