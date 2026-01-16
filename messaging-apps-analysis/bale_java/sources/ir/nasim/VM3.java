package ir.nasim;

/* loaded from: classes5.dex */
public final class VM3 {
    public static final a a = new a(null);
    private static VM3 b;

    public static final class a {
        private a() {
        }

        public final VM3 a() {
            VM3 vm3 = VM3.b;
            if (vm3 != null) {
                return vm3;
            }
            VM3 vm32 = new VM3(null);
            VM3.b = vm32;
            return vm32;
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public /* synthetic */ class b {
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

    private VM3() {
    }

    public static final VM3 d() {
        return a.a();
    }

    public UM3 c() {
        return b.a[SE.b.ordinal()] == 1 ? new TM3() : new TM3();
    }

    public /* synthetic */ VM3(ED1 ed1) {
        this();
    }
}
