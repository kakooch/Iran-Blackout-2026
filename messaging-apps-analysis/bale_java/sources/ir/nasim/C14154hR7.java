package ir.nasim;

/* renamed from: ir.nasim.hR7, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C14154hR7 {
    private final AbstractC8151Ut a;
    private final K22 b;
    private final int c;

    public /* synthetic */ C14154hR7(AbstractC8151Ut abstractC8151Ut, K22 k22, int i, ED1 ed1) {
        this(abstractC8151Ut, k22, i);
    }

    public final int a() {
        return this.c;
    }

    public final K22 b() {
        return this.b;
    }

    public final AbstractC8151Ut c() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C14154hR7)) {
            return false;
        }
        C14154hR7 c14154hR7 = (C14154hR7) obj;
        return AbstractC13042fc3.d(this.a, c14154hR7.a) && AbstractC13042fc3.d(this.b, c14154hR7.b) && OI.c(this.c, c14154hR7.c);
    }

    public int hashCode() {
        return (((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + OI.d(this.c);
    }

    public String toString() {
        return "VectorizedKeyframeSpecElementInfo(vectorValue=" + this.a + ", easing=" + this.b + ", arcMode=" + ((Object) OI.e(this.c)) + ')';
    }

    private C14154hR7(AbstractC8151Ut abstractC8151Ut, K22 k22, int i) {
        this.a = abstractC8151Ut;
        this.b = k22;
        this.c = i;
    }
}
