package ir.nasim;

/* renamed from: ir.nasim.mw1, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public enum EnumC17422mw1 {
    RIAL(1),
    SCORE(2),
    UNSUPPORTED_VALUE(3);

    private final int a;

    /* renamed from: ir.nasim.mw1$a */
    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[EnumC17422mw1.values().length];
            a = iArr;
            try {
                iArr[EnumC17422mw1.RIAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[EnumC17422mw1.SCORE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    EnumC17422mw1(int i) {
        this.a = i;
    }

    public static EnumC17422mw1 j(int i) {
        return i != 1 ? i != 2 ? UNSUPPORTED_VALUE : SCORE : RIAL;
    }

    public int p() {
        return this.a;
    }

    public N38 q() {
        int i = a.a[ordinal()];
        return i != 1 ? i != 2 ? N38.UNRECOGNIZED : N38.Currency_SCORE : N38.Currency_RIAL;
    }
}
