package ir.nasim;

/* renamed from: ir.nasim.xZ6, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C23815xZ6 extends AbstractC18051o02 {
    public static final a e = new a(null);
    private static final int f = AbstractC24405yZ6.a.a();
    private static final int g = AZ6.a.b();
    private final float a;
    private final float b;
    private final int c;
    private final int d;

    /* renamed from: ir.nasim.xZ6$a */
    public static final class a {
        private a() {
        }

        public final int a() {
            return C23815xZ6.f;
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public /* synthetic */ C23815xZ6(float f2, float f3, int i, int i2, InterfaceC13909h15 interfaceC13909h15, ED1 ed1) {
        this(f2, f3, i, i2, interfaceC13909h15);
    }

    public final int b() {
        return this.c;
    }

    public final int c() {
        return this.d;
    }

    public final float d() {
        return this.b;
    }

    public final InterfaceC13909h15 e() {
        return null;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C23815xZ6)) {
            return false;
        }
        C23815xZ6 c23815xZ6 = (C23815xZ6) obj;
        if (this.a != c23815xZ6.a || this.b != c23815xZ6.b || !AbstractC24405yZ6.e(this.c, c23815xZ6.c) || !AZ6.e(this.d, c23815xZ6.d)) {
            return false;
        }
        c23815xZ6.getClass();
        return AbstractC13042fc3.d(null, null);
    }

    public final float f() {
        return this.a;
    }

    public int hashCode() {
        return ((((((Float.hashCode(this.a) * 31) + Float.hashCode(this.b)) * 31) + AbstractC24405yZ6.f(this.c)) * 31) + AZ6.f(this.d)) * 31;
    }

    public String toString() {
        return "Stroke(width=" + this.a + ", miter=" + this.b + ", cap=" + ((Object) AbstractC24405yZ6.g(this.c)) + ", join=" + ((Object) AZ6.g(this.d)) + ", pathEffect=" + ((Object) null) + ')';
    }

    public /* synthetic */ C23815xZ6(float f2, float f3, int i, int i2, InterfaceC13909h15 interfaceC13909h15, int i3, ED1 ed1) {
        this((i3 & 1) != 0 ? 0.0f : f2, (i3 & 2) != 0 ? 4.0f : f3, (i3 & 4) != 0 ? f : i, (i3 & 8) != 0 ? g : i2, (i3 & 16) != 0 ? null : interfaceC13909h15, null);
    }

    private C23815xZ6(float f2, float f3, int i, int i2, InterfaceC13909h15 interfaceC13909h15) {
        super(null);
        this.a = f2;
        this.b = f3;
        this.c = i;
        this.d = i2;
    }
}
