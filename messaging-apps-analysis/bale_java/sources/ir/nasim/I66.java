package ir.nasim;

/* loaded from: classes.dex */
public final class I66 {
    private float a;
    private boolean b;
    private AbstractC5075Hu1 c;

    public I66(float f, boolean z, AbstractC5075Hu1 abstractC5075Hu1, AbstractC11969dr2 abstractC11969dr2) {
        this.a = f;
        this.b = z;
        this.c = abstractC5075Hu1;
    }

    public final AbstractC5075Hu1 a() {
        return this.c;
    }

    public final boolean b() {
        return this.b;
    }

    public final AbstractC11969dr2 c() {
        return null;
    }

    public final float d() {
        return this.a;
    }

    public final void e(AbstractC5075Hu1 abstractC5075Hu1) {
        this.c = abstractC5075Hu1;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof I66)) {
            return false;
        }
        I66 i66 = (I66) obj;
        return Float.compare(this.a, i66.a) == 0 && this.b == i66.b && AbstractC13042fc3.d(this.c, i66.c) && AbstractC13042fc3.d(null, null);
    }

    public final void f(boolean z) {
        this.b = z;
    }

    public final void g(float f) {
        this.a = f;
    }

    public int hashCode() {
        int iHashCode = ((Float.hashCode(this.a) * 31) + Boolean.hashCode(this.b)) * 31;
        AbstractC5075Hu1 abstractC5075Hu1 = this.c;
        return (iHashCode + (abstractC5075Hu1 == null ? 0 : abstractC5075Hu1.hashCode())) * 31;
    }

    public String toString() {
        return "RowColumnParentData(weight=" + this.a + ", fill=" + this.b + ", crossAxisAlignment=" + this.c + ", flowLayoutData=" + ((Object) null) + ')';
    }

    public /* synthetic */ I66(float f, boolean z, AbstractC5075Hu1 abstractC5075Hu1, AbstractC11969dr2 abstractC11969dr2, int i, ED1 ed1) {
        this((i & 1) != 0 ? 0.0f : f, (i & 2) != 0 ? true : z, (i & 4) != 0 ? null : abstractC5075Hu1, (i & 8) != 0 ? null : abstractC11969dr2);
    }
}
