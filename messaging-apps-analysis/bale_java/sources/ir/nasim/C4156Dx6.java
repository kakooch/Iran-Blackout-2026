package ir.nasim;

/* renamed from: ir.nasim.Dx6, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C4156Dx6 implements InterfaceC9904al1 {
    private final String a;
    private final a b;
    private final C17380ms c;
    private final C17380ms d;
    private final C17380ms e;
    private final boolean f;

    /* renamed from: ir.nasim.Dx6$a */
    public enum a {
        SIMULTANEOUSLY,
        INDIVIDUALLY;

        public static a j(int i) {
            if (i == 1) {
                return SIMULTANEOUSLY;
            }
            if (i == 2) {
                return INDIVIDUALLY;
            }
            throw new IllegalArgumentException("Unknown trim path type " + i);
        }
    }

    public C4156Dx6(String str, a aVar, C17380ms c17380ms, C17380ms c17380ms2, C17380ms c17380ms3, boolean z) {
        this.a = str;
        this.b = aVar;
        this.c = c17380ms;
        this.d = c17380ms2;
        this.e = c17380ms3;
        this.f = z;
    }

    @Override // ir.nasim.InterfaceC9904al1
    public InterfaceC14939ik1 a(com.airbnb.lottie.q qVar, C23677xK3 c23677xK3, AbstractC3236Aa0 abstractC3236Aa0) {
        return new C16837lw7(abstractC3236Aa0, this);
    }

    public C17380ms b() {
        return this.d;
    }

    public String c() {
        return this.a;
    }

    public C17380ms d() {
        return this.e;
    }

    public C17380ms e() {
        return this.c;
    }

    public a f() {
        return this.b;
    }

    public boolean g() {
        return this.f;
    }

    public String toString() {
        return "Trim Path: {start: " + this.c + ", end: " + this.d + ", offset: " + this.e + "}";
    }
}
