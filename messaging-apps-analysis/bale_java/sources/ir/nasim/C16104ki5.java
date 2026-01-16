package ir.nasim;

/* renamed from: ir.nasim.ki5, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C16104ki5 implements InterfaceC9904al1 {
    private final String a;
    private final a b;
    private final C17380ms c;
    private final InterfaceC4104Ds d;
    private final C17380ms e;
    private final C17380ms f;
    private final C17380ms g;
    private final C17380ms h;
    private final C17380ms i;
    private final boolean j;
    private final boolean k;

    /* renamed from: ir.nasim.ki5$a */
    public enum a {
        STAR(1),
        POLYGON(2);

        private final int a;

        a(int i) {
            this.a = i;
        }

        public static a j(int i) {
            for (a aVar : values()) {
                if (aVar.a == i) {
                    return aVar;
                }
            }
            return null;
        }
    }

    public C16104ki5(String str, a aVar, C17380ms c17380ms, InterfaceC4104Ds interfaceC4104Ds, C17380ms c17380ms2, C17380ms c17380ms3, C17380ms c17380ms4, C17380ms c17380ms5, C17380ms c17380ms6, boolean z, boolean z2) {
        this.a = str;
        this.b = aVar;
        this.c = c17380ms;
        this.d = interfaceC4104Ds;
        this.e = c17380ms2;
        this.f = c17380ms3;
        this.g = c17380ms4;
        this.h = c17380ms5;
        this.i = c17380ms6;
        this.j = z;
        this.k = z2;
    }

    @Override // ir.nasim.InterfaceC9904al1
    public InterfaceC14939ik1 a(com.airbnb.lottie.q qVar, C23677xK3 c23677xK3, AbstractC3236Aa0 abstractC3236Aa0) {
        return new C15513ji5(qVar, abstractC3236Aa0, this);
    }

    public C17380ms b() {
        return this.f;
    }

    public C17380ms c() {
        return this.h;
    }

    public String d() {
        return this.a;
    }

    public C17380ms e() {
        return this.g;
    }

    public C17380ms f() {
        return this.i;
    }

    public C17380ms g() {
        return this.c;
    }

    public InterfaceC4104Ds h() {
        return this.d;
    }

    public C17380ms i() {
        return this.e;
    }

    public a j() {
        return this.b;
    }

    public boolean k() {
        return this.j;
    }

    public boolean l() {
        return this.k;
    }
}
