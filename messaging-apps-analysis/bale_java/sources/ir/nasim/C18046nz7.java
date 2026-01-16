package ir.nasim;

/* renamed from: ir.nasim.nz7, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C18046nz7 {
    private final AbstractC9998au2 a;
    private final C4593Fu2 b;
    private final int c;
    private final int d;
    private final Object e;

    public /* synthetic */ C18046nz7(AbstractC9998au2 abstractC9998au2, C4593Fu2 c4593Fu2, int i, int i2, Object obj, ED1 ed1) {
        this(abstractC9998au2, c4593Fu2, i, i2, obj);
    }

    public static /* synthetic */ C18046nz7 b(C18046nz7 c18046nz7, AbstractC9998au2 abstractC9998au2, C4593Fu2 c4593Fu2, int i, int i2, Object obj, int i3, Object obj2) {
        if ((i3 & 1) != 0) {
            abstractC9998au2 = c18046nz7.a;
        }
        if ((i3 & 2) != 0) {
            c4593Fu2 = c18046nz7.b;
        }
        C4593Fu2 c4593Fu22 = c4593Fu2;
        if ((i3 & 4) != 0) {
            i = c18046nz7.c;
        }
        int i4 = i;
        if ((i3 & 8) != 0) {
            i2 = c18046nz7.d;
        }
        int i5 = i2;
        if ((i3 & 16) != 0) {
            obj = c18046nz7.e;
        }
        return c18046nz7.a(abstractC9998au2, c4593Fu22, i4, i5, obj);
    }

    public final C18046nz7 a(AbstractC9998au2 abstractC9998au2, C4593Fu2 c4593Fu2, int i, int i2, Object obj) {
        return new C18046nz7(abstractC9998au2, c4593Fu2, i, i2, obj, null);
    }

    public final AbstractC9998au2 c() {
        return this.a;
    }

    public final int d() {
        return this.c;
    }

    public final int e() {
        return this.d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C18046nz7)) {
            return false;
        }
        C18046nz7 c18046nz7 = (C18046nz7) obj;
        return AbstractC13042fc3.d(this.a, c18046nz7.a) && AbstractC13042fc3.d(this.b, c18046nz7.b) && C3418Au2.f(this.c, c18046nz7.c) && C3657Bu2.h(this.d, c18046nz7.d) && AbstractC13042fc3.d(this.e, c18046nz7.e);
    }

    public final C4593Fu2 f() {
        return this.b;
    }

    public int hashCode() {
        AbstractC9998au2 abstractC9998au2 = this.a;
        int iHashCode = (((((((abstractC9998au2 == null ? 0 : abstractC9998au2.hashCode()) * 31) + this.b.hashCode()) * 31) + C3418Au2.g(this.c)) * 31) + C3657Bu2.i(this.d)) * 31;
        Object obj = this.e;
        return iHashCode + (obj != null ? obj.hashCode() : 0);
    }

    public String toString() {
        return "TypefaceRequest(fontFamily=" + this.a + ", fontWeight=" + this.b + ", fontStyle=" + ((Object) C3418Au2.h(this.c)) + ", fontSynthesis=" + ((Object) C3657Bu2.l(this.d)) + ", resourceLoaderCacheKey=" + this.e + ')';
    }

    private C18046nz7(AbstractC9998au2 abstractC9998au2, C4593Fu2 c4593Fu2, int i, int i2, Object obj) {
        this.a = abstractC9998au2;
        this.b = c4593Fu2;
        this.c = i;
        this.d = i2;
        this.e = obj;
    }
}
