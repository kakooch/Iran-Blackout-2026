package ir.nasim;

/* loaded from: classes5.dex */
public enum W06 {
    PUBLIC,
    PRIVATE;

    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[W06.values().length];
            a = iArr;
            try {
                iArr[W06.PRIVATE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[W06.PUBLIC.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public BB j() {
        int i = a.a[ordinal()];
        return i != 1 ? i != 2 ? BB.UNSUPPORTED_VALUE : BB.PUBLIC : BB.PRIVATE;
    }
}
