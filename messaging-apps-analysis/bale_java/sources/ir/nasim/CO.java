package ir.nasim;

/* loaded from: classes3.dex */
public final class CO {
    private final boolean a;
    private final boolean b;

    public CO(BO bo, boolean z, BO bo2, boolean z2) {
        this.a = z;
        this.b = z2;
    }

    public final boolean a() {
        return this.a;
    }

    public final BO b() {
        return null;
    }

    public final boolean c() {
        return this.b;
    }

    public final BO d() {
        return null;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CO)) {
            return false;
        }
        CO co = (CO) obj;
        co.getClass();
        return AbstractC13042fc3.d(null, null) && this.a == co.a && AbstractC13042fc3.d(null, null) && this.b == co.b;
    }

    public int hashCode() {
        return (Boolean.hashCode(this.a) * 961) + Boolean.hashCode(this.b);
    }

    public String toString() {
        return "AudioProcessorOptions(capturePostProcessor=" + ((Object) null) + ", capturePostBypass=" + this.a + ", renderPreProcessor=" + ((Object) null) + ", renderPreBypass=" + this.b + ')';
    }

    public /* synthetic */ CO(BO bo, boolean z, BO bo2, boolean z2, int i, ED1 ed1) {
        this((i & 1) != 0 ? null : bo, (i & 2) != 0 ? false : z, (i & 4) != 0 ? null : bo2, (i & 8) != 0 ? false : z2);
    }
}
