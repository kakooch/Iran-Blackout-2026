package ir.nasim;

/* renamed from: ir.nasim.v02, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C22300v02 implements InterfaceC3905Cv7 {
    private final int a;
    private final boolean b;
    private C22896w02 c;

    /* renamed from: ir.nasim.v02$a */
    public static class a {
        private final int a;
        private boolean b;

        public a() {
            this(300);
        }

        public C22300v02 a() {
            return new C22300v02(this.a, this.b);
        }

        public a(int i) {
            this.a = i;
        }
    }

    protected C22300v02(int i, boolean z) {
        this.a = i;
        this.b = z;
    }

    private InterfaceC22855vv7 b() {
        if (this.c == null) {
            this.c = new C22896w02(this.a, this.b);
        }
        return this.c;
    }

    @Override // ir.nasim.InterfaceC3905Cv7
    public InterfaceC22855vv7 a(EnumC21012sz1 enumC21012sz1, boolean z) {
        return enumC21012sz1 == EnumC21012sz1.MEMORY_CACHE ? SA4.b() : b();
    }
}
