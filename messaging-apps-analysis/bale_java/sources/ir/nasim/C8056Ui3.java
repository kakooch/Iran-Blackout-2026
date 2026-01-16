package ir.nasim;

/* renamed from: ir.nasim.Ui3, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C8056Ui3 {
    public static final a e = new a(null);
    private static final C8056Ui3 f = new C8056Ui3(null, null, false, false, 8, null);
    private final EnumC14043hF4 a;
    private final EnumC11300cm4 b;
    private final boolean c;
    private final boolean d;

    /* renamed from: ir.nasim.Ui3$a */
    public static final class a {
        private a() {
        }

        public final C8056Ui3 a() {
            return C8056Ui3.f;
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public C8056Ui3(EnumC14043hF4 enumC14043hF4, EnumC11300cm4 enumC11300cm4, boolean z, boolean z2) {
        this.a = enumC14043hF4;
        this.b = enumC11300cm4;
        this.c = z;
        this.d = z2;
    }

    public final EnumC11300cm4 b() {
        return this.b;
    }

    public final EnumC14043hF4 c() {
        return this.a;
    }

    public final boolean d() {
        return this.c;
    }

    public final boolean e() {
        return this.d;
    }

    public /* synthetic */ C8056Ui3(EnumC14043hF4 enumC14043hF4, EnumC11300cm4 enumC11300cm4, boolean z, boolean z2, int i, ED1 ed1) {
        this(enumC14043hF4, enumC11300cm4, z, (i & 8) != 0 ? false : z2);
    }
}
