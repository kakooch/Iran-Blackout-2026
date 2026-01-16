package ir.nasim;

/* renamed from: ir.nasim.co6, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C11322co6 {
    public static final int d = 8;
    private final String a;
    private final InterfaceC14603iB2 b;
    private boolean c;

    /* renamed from: ir.nasim.co6$a */
    static final class a extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
        public static final a e = new a();

        a() {
            super(2);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public final Object invoke(Object obj, Object obj2) {
            return obj == null ? obj2 : obj;
        }
    }

    public C11322co6(String str, InterfaceC14603iB2 interfaceC14603iB2) {
        this.a = str;
        this.b = interfaceC14603iB2;
    }

    public final String a() {
        return this.a;
    }

    public final boolean b() {
        return this.c;
    }

    public final Object c(Object obj, Object obj2) {
        return this.b.invoke(obj, obj2);
    }

    public final void d(InterfaceC11943do6 interfaceC11943do6, InterfaceC5239Im3 interfaceC5239Im3, Object obj) {
        interfaceC11943do6.f(this, obj);
    }

    public String toString() {
        return "AccessibilityKey: " + this.a;
    }

    public /* synthetic */ C11322co6(String str, InterfaceC14603iB2 interfaceC14603iB2, int i, ED1 ed1) {
        this(str, (i & 2) != 0 ? a.e : interfaceC14603iB2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public C11322co6(String str, boolean z) {
        this(str, null, 2, 0 == true ? 1 : 0);
        this.c = z;
    }

    public C11322co6(String str, boolean z, InterfaceC14603iB2 interfaceC14603iB2) {
        this(str, interfaceC14603iB2);
        this.c = z;
    }
}
