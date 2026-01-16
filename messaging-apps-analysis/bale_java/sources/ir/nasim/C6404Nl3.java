package ir.nasim;

/* renamed from: ir.nasim.Nl3, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C6404Nl3 extends AbstractC7310Re0 {
    public static final a h = new a(null);
    public static final C6404Nl3 i = new C6404Nl3(1, 4, 2);
    public static final C6404Nl3 j = new C6404Nl3(new int[0]);
    private final boolean g;

    /* renamed from: ir.nasim.Nl3$a */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public C6404Nl3(int[] iArr, boolean z) {
        AbstractC13042fc3.i(iArr, "versionArray");
        int[] iArr2 = new int[iArr.length];
        System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
        super(iArr2);
        this.g = z;
    }

    public boolean h() {
        boolean zF;
        if (a() == 1 && b() == 0) {
            return false;
        }
        if (this.g) {
            zF = f(i);
        } else {
            int iA = a();
            C6404Nl3 c6404Nl3 = i;
            zF = iA == c6404Nl3.a() && b() <= c6404Nl3.b() + 1;
        }
        return zF;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public C6404Nl3(int... iArr) {
        this(iArr, false);
        AbstractC13042fc3.i(iArr, "numbers");
    }
}
