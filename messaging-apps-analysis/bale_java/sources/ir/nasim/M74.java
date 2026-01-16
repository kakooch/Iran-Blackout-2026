package ir.nasim;

/* loaded from: classes5.dex */
public final class M74 implements InterfaceC14123hO3 {
    private final long a;
    private final long b;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[EnumC23558x74.values().length];
            try {
                iArr[EnumC23558x74.SENT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[EnumC23558x74.PENDING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[EnumC23558x74.ERROR.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            a = iArr;
        }
    }

    public M74(long j, long j2) {
        this.a = j;
        this.b = j2;
    }

    @Override // ir.nasim.InterfaceC14123hO3
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public LA7 a(J44 j44) {
        AbstractC13042fc3.i(j44, "input");
        int i = a.a[j44.L().ordinal()];
        return i != 1 ? i != 2 ? i != 3 ? LA7.a : LA7.b : LA7.a : j44.W() <= this.a ? LA7.d : j44.W() <= this.b ? LA7.c : LA7.e;
    }
}
