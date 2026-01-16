package ir.nasim;

/* renamed from: ir.nasim.aY0, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC9775aY0 {
    public static final a d = new a(null);
    private final String a;
    private final long b;
    private final int c;

    /* renamed from: ir.nasim.aY0$a */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public /* synthetic */ AbstractC9775aY0(String str, long j, int i, ED1 ed1) {
        this(str, j, i);
    }

    public final int a() {
        return FX0.f(this.b);
    }

    public final int b() {
        return this.c;
    }

    public abstract float c(int i);

    public abstract float d(int i);

    public final long e() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        AbstractC9775aY0 abstractC9775aY0 = (AbstractC9775aY0) obj;
        if (this.c == abstractC9775aY0.c && AbstractC13042fc3.d(this.a, abstractC9775aY0.a)) {
            return FX0.e(this.b, abstractC9775aY0.b);
        }
        return false;
    }

    public final String f() {
        return this.a;
    }

    public boolean g() {
        return false;
    }

    public abstract long h(float f, float f2, float f3);

    public int hashCode() {
        return (((this.a.hashCode() * 31) + FX0.g(this.b)) * 31) + this.c;
    }

    public abstract float i(float f, float f2, float f3);

    public abstract long j(float f, float f2, float f3, float f4, AbstractC9775aY0 abstractC9775aY0);

    public String toString() {
        return this.a + " (id=" + this.c + ", model=" + ((Object) FX0.h(this.b)) + ')';
    }

    private AbstractC9775aY0(String str, long j, int i) {
        this.a = str;
        this.b = j;
        this.c = i;
        if (str.length() == 0) {
            throw new IllegalArgumentException("The name of a color space cannot be null and must contain at least 1 character");
        }
        if (i < -1 || i > 63) {
            throw new IllegalArgumentException("The id must be between -1 and 63");
        }
    }
}
