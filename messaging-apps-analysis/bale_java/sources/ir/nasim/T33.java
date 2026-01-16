package ir.nasim;

/* loaded from: classes2.dex */
public final class T33 {
    public static final a g = new a(null);
    private static final T33 h = new T33(false, 0, false, 0, 0, null, null, 127, null);
    private final boolean a;
    private final int b;
    private final boolean c;
    private final int d;
    private final int e;
    private final IH3 f;

    public static final class a {
        private a() {
        }

        public final T33 a() {
            return T33.h;
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public /* synthetic */ T33(boolean z, int i, boolean z2, int i2, int i3, AbstractC11853df5 abstractC11853df5, IH3 ih3, ED1 ed1) {
        this(z, i, z2, i2, i3, abstractC11853df5, ih3);
    }

    public final boolean b() {
        return this.c;
    }

    public final int c() {
        return this.b;
    }

    public final IH3 d() {
        return this.f;
    }

    public final int e() {
        return this.e;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof T33)) {
            return false;
        }
        T33 t33 = (T33) obj;
        if (this.a != t33.a || !C14383hp3.i(this.b, t33.b) || this.c != t33.c || !C22785vp3.n(this.d, t33.d) || !S33.m(this.e, t33.e)) {
            return false;
        }
        t33.getClass();
        return AbstractC13042fc3.d(null, null) && AbstractC13042fc3.d(this.f, t33.f);
    }

    public final int f() {
        return this.d;
    }

    public final AbstractC11853df5 g() {
        return null;
    }

    public final boolean h() {
        return this.a;
    }

    public int hashCode() {
        return (((((((((Boolean.hashCode(this.a) * 31) + C14383hp3.j(this.b)) * 31) + Boolean.hashCode(this.c)) * 31) + C22785vp3.o(this.d)) * 31) + S33.n(this.e)) * 961) + this.f.hashCode();
    }

    public String toString() {
        return "ImeOptions(singleLine=" + this.a + ", capitalization=" + ((Object) C14383hp3.k(this.b)) + ", autoCorrect=" + this.c + ", keyboardType=" + ((Object) C22785vp3.p(this.d)) + ", imeAction=" + ((Object) S33.o(this.e)) + ", platformImeOptions=" + ((Object) null) + ", hintLocales=" + this.f + ')';
    }

    private T33(boolean z, int i, boolean z2, int i2, int i3, AbstractC11853df5 abstractC11853df5, IH3 ih3) {
        this.a = z;
        this.b = i;
        this.c = z2;
        this.d = i2;
        this.e = i3;
        this.f = ih3;
    }

    public /* synthetic */ T33(boolean z, int i, boolean z2, int i2, int i3, AbstractC11853df5 abstractC11853df5, IH3 ih3, int i4, ED1 ed1) {
        this((i4 & 1) != 0 ? false : z, (i4 & 2) != 0 ? C14383hp3.b.b() : i, (i4 & 4) != 0 ? true : z2, (i4 & 8) != 0 ? C22785vp3.b.h() : i2, (i4 & 16) != 0 ? S33.b.a() : i3, (i4 & 32) != 0 ? null : abstractC11853df5, (i4 & 64) != 0 ? IH3.c.b() : ih3, null);
    }
}
