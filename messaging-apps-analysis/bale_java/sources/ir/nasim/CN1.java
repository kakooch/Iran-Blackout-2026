package ir.nasim;

/* loaded from: classes5.dex */
public final class CN1 {
    public static final CN1 a = new CN1();

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[RE.values().length];
            try {
                iArr[RE.a.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            a = iArr;
        }
    }

    private CN1() {
    }

    public AN1 a() {
        return a.a[SE.b.ordinal()] == 1 ? new AN1() : new AN1();
    }
}
