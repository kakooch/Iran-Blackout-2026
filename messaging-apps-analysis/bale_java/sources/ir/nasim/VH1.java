package ir.nasim;

/* loaded from: classes.dex */
public final class VH1 {
    private int a;

    public VH1(int i) {
        this.a = i;
    }

    public final int a() {
        return this.a;
    }

    public final void b(int i) {
        this.a += i;
    }

    public final void c(int i) {
        this.a = i;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof VH1) && this.a == ((VH1) obj).a;
    }

    public int hashCode() {
        return Integer.hashCode(this.a);
    }

    public String toString() {
        return "DeltaCounter(count=" + this.a + ')';
    }

    public /* synthetic */ VH1(int i, int i2, ED1 ed1) {
        this((i2 & 1) != 0 ? 0 : i);
    }
}
